package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class BannerStyleConf
  extends JceStruct
{
  public String strButtonText = "";
  public String strIconUrl = "";
  public String strText = "";
  
  public BannerStyleConf() {}
  
  public BannerStyleConf(String paramString1, String paramString2, String paramString3)
  {
    this.strIconUrl = paramString1;
    this.strText = paramString2;
    this.strButtonText = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strIconUrl = paramJceInputStream.readString(0, false);
    this.strText = paramJceInputStream.readString(1, false);
    this.strButtonText = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.strIconUrl != null) {
      paramJceOutputStream.write(this.strIconUrl, 0);
    }
    if (this.strText != null) {
      paramJceOutputStream.write(this.strText, 1);
    }
    if (this.strButtonText != null) {
      paramJceOutputStream.write(this.strButtonText, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QMALL_COVER.BannerStyleConf
 * JD-Core Version:    0.7.0.1
 */