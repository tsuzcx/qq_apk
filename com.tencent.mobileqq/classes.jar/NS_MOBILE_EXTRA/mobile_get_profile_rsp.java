package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_get_profile_rsp
  extends JceStruct
{
  static s_profile_for_get cache_profile;
  static s_user cache_user;
  public s_profile_for_get profile;
  public s_user user;
  
  public mobile_get_profile_rsp() {}
  
  public mobile_get_profile_rsp(s_user params_user, s_profile_for_get params_profile_for_get)
  {
    this.user = params_user;
    this.profile = params_profile_for_get;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_user == null) {
      cache_user = new s_user();
    }
    this.user = ((s_user)paramJceInputStream.read(cache_user, 0, false));
    if (cache_profile == null) {
      cache_profile = new s_profile_for_get();
    }
    this.profile = ((s_profile_for_get)paramJceInputStream.read(cache_profile, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.user;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.profile;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_EXTRA.mobile_get_profile_rsp
 * JD-Core Version:    0.7.0.1
 */