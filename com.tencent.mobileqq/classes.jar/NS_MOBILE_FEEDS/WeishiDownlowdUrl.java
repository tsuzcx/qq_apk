package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class WeishiDownlowdUrl
  extends JceStruct
{
  public String AndUrl = "";
  public String IOSUrl = "";
  
  public WeishiDownlowdUrl() {}
  
  public WeishiDownlowdUrl(String paramString1, String paramString2)
  {
    this.IOSUrl = paramString1;
    this.AndUrl = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.IOSUrl = paramJceInputStream.readString(0, false);
    this.AndUrl = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.IOSUrl != null) {
      paramJceOutputStream.write(this.IOSUrl, 0);
    }
    if (this.AndUrl != null) {
      paramJceOutputStream.write(this.AndUrl, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.WeishiDownlowdUrl
 * JD-Core Version:    0.7.0.1
 */