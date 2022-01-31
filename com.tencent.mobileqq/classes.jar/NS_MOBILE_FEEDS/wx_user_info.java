package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class wx_user_info
  extends JceStruct
{
  public String avatar_url = "";
  public String nickname = "";
  
  public wx_user_info() {}
  
  public wx_user_info(String paramString1, String paramString2)
  {
    this.nickname = paramString1;
    this.avatar_url = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nickname = paramJceInputStream.readString(0, false);
    this.avatar_url = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.nickname != null) {
      paramJceOutputStream.write(this.nickname, 0);
    }
    if (this.avatar_url != null) {
      paramJceOutputStream.write(this.avatar_url, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     NS_MOBILE_FEEDS.wx_user_info
 * JD-Core Version:    0.7.0.1
 */