package MOBILE_QZMALL_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class VideoUrl
  extends JceStruct
{
  public String strContentUrl = "";
  public String strCoverUrl = "";
  
  public VideoUrl() {}
  
  public VideoUrl(String paramString1, String paramString2)
  {
    this.strContentUrl = paramString1;
    this.strCoverUrl = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strContentUrl = paramJceInputStream.readString(0, false);
    this.strCoverUrl = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.strContentUrl != null) {
      paramJceOutputStream.write(this.strContentUrl, 0);
    }
    if (this.strCoverUrl != null) {
      paramJceOutputStream.write(this.strCoverUrl, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\acom2.jar
 * Qualified Name:     MOBILE_QZMALL_PROTOCOL.VideoUrl
 * JD-Core Version:    0.7.0.1
 */