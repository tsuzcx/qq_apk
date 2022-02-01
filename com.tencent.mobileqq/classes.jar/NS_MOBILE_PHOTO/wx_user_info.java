package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class wx_user_info
  extends JceStruct
{
  public String avatar_url = "";
  public String nickname = "";
  public String openid = "";
  
  public wx_user_info() {}
  
  public wx_user_info(String paramString1, String paramString2, String paramString3)
  {
    this.nickname = paramString1;
    this.avatar_url = paramString2;
    this.openid = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nickname = paramJceInputStream.readString(0, false);
    this.avatar_url = paramJceInputStream.readString(1, false);
    this.openid = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.nickname;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.avatar_url;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.openid;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.wx_user_info
 * JD-Core Version:    0.7.0.1
 */