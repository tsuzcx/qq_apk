package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QzmallCustomBanner
  extends JceStruct
{
  public int iBannerType;
  public String strBannerUrl = "";
  public String strJumpUrl = "";
  
  public QzmallCustomBanner() {}
  
  public QzmallCustomBanner(int paramInt, String paramString1, String paramString2)
  {
    this.iBannerType = paramInt;
    this.strBannerUrl = paramString1;
    this.strJumpUrl = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iBannerType = paramJceInputStream.read(this.iBannerType, 0, false);
    this.strBannerUrl = paramJceInputStream.readString(1, false);
    this.strJumpUrl = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iBannerType, 0);
    if (this.strBannerUrl != null) {
      paramJceOutputStream.write(this.strBannerUrl, 1);
    }
    if (this.strJumpUrl != null) {
      paramJceOutputStream.write(this.strJumpUrl, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_QMALL_COVER.QzmallCustomBanner
 * JD-Core Version:    0.7.0.1
 */