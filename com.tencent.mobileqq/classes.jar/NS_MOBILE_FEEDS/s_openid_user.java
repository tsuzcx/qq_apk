package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_openid_user
  extends JceStruct
{
  public String logo = "";
  public String nickname = "";
  public String openid = "";
  
  public s_openid_user() {}
  
  public s_openid_user(String paramString1, String paramString2, String paramString3)
  {
    this.openid = paramString1;
    this.nickname = paramString2;
    this.logo = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.openid = paramJceInputStream.readString(0, false);
    this.nickname = paramJceInputStream.readString(1, false);
    this.logo = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.openid;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.nickname;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.logo;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_openid_user
 * JD-Core Version:    0.7.0.1
 */