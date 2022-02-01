package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ButtonInfo
  extends JceStruct
{
  public String iconUrl = "";
  public String jumpUrl = "";
  public String words = "";
  
  public ButtonInfo() {}
  
  public ButtonInfo(String paramString1, String paramString2, String paramString3)
  {
    this.words = paramString1;
    this.iconUrl = paramString2;
    this.jumpUrl = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.words = paramJceInputStream.readString(0, false);
    this.iconUrl = paramJceInputStream.readString(1, false);
    this.jumpUrl = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.words != null) {
      paramJceOutputStream.write(this.words, 0);
    }
    if (this.iconUrl != null) {
      paramJceOutputStream.write(this.iconUrl, 1);
    }
    if (this.jumpUrl != null) {
      paramJceOutputStream.write(this.jumpUrl, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QZONE_MQMSG.ButtonInfo
 * JD-Core Version:    0.7.0.1
 */