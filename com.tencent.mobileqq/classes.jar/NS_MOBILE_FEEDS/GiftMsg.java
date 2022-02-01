package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GiftMsg
  extends JceStruct
{
  public String giftLogo = "";
  public String msg = "";
  public String nick = "";
  public String userId = "";
  
  public GiftMsg() {}
  
  public GiftMsg(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.userId = paramString1;
    this.nick = paramString2;
    this.msg = paramString3;
    this.giftLogo = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.userId = paramJceInputStream.readString(0, false);
    this.nick = paramJceInputStream.readString(1, false);
    this.msg = paramJceInputStream.readString(2, false);
    this.giftLogo = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.userId;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.nick;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.msg;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.giftLogo;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.GiftMsg
 * JD-Core Version:    0.7.0.1
 */