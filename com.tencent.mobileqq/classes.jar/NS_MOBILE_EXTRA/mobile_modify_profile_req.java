package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_modify_profile_req
  extends JceStruct
{
  static s_profile_for_set cache_profile;
  public s_profile_for_set profile;
  public long uin;
  
  public mobile_modify_profile_req() {}
  
  public mobile_modify_profile_req(long paramLong, s_profile_for_set params_profile_for_set)
  {
    this.uin = paramLong;
    this.profile = params_profile_for_set;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    if (cache_profile == null) {
      cache_profile = new s_profile_for_set();
    }
    this.profile = ((s_profile_for_set)paramJceInputStream.read(cache_profile, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    s_profile_for_set locals_profile_for_set = this.profile;
    if (locals_profile_for_set != null) {
      paramJceOutputStream.write(locals_profile_for_set, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_EXTRA.mobile_modify_profile_req
 * JD-Core Version:    0.7.0.1
 */