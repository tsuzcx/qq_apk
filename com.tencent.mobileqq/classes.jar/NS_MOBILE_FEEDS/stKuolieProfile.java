package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class stKuolieProfile
  extends JceStruct
{
  static Map<String, String> cache_extendinfo;
  static s_user cache_user = new s_user();
  public int CommOpmask2 = 0;
  public int CommOpmask3 = 0;
  public int FeedsCount = 0;
  public Map<String, String> extendinfo = null;
  public s_user user = null;
  
  static
  {
    cache_extendinfo = new HashMap();
    cache_extendinfo.put("", "");
  }
  
  public stKuolieProfile() {}
  
  public stKuolieProfile(s_user params_user, int paramInt1, int paramInt2, Map<String, String> paramMap, int paramInt3)
  {
    this.user = params_user;
    this.CommOpmask2 = paramInt1;
    this.FeedsCount = paramInt2;
    this.extendinfo = paramMap;
    this.CommOpmask3 = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.user = ((s_user)paramJceInputStream.read(cache_user, 0, false));
    this.CommOpmask2 = paramJceInputStream.read(this.CommOpmask2, 1, false);
    this.FeedsCount = paramJceInputStream.read(this.FeedsCount, 2, false);
    this.extendinfo = ((Map)paramJceInputStream.read(cache_extendinfo, 3, false));
    this.CommOpmask3 = paramJceInputStream.read(this.CommOpmask3, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.user;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    paramJceOutputStream.write(this.CommOpmask2, 1);
    paramJceOutputStream.write(this.FeedsCount, 2);
    localObject = this.extendinfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 3);
    }
    paramJceOutputStream.write(this.CommOpmask3, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.stKuolieProfile
 * JD-Core Version:    0.7.0.1
 */