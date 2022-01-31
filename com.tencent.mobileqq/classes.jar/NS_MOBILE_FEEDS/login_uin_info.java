package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class login_uin_info
  extends JceStruct
{
  public String nickname = "";
  
  public login_uin_info() {}
  
  public login_uin_info(String paramString)
  {
    this.nickname = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nickname = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.nickname != null) {
      paramJceOutputStream.write(this.nickname, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.login_uin_info
 * JD-Core Version:    0.7.0.1
 */