package NS_COMM_VIP_GROWTH;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class IconInfo
  extends JceStruct
{
  public int iHigh = 0;
  public int iWidth = 0;
  public String strUrl = "";
  
  public IconInfo() {}
  
  public IconInfo(String paramString, int paramInt1, int paramInt2)
  {
    this.strUrl = paramString;
    this.iWidth = paramInt1;
    this.iHigh = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strUrl = paramJceInputStream.readString(0, false);
    this.iWidth = paramJceInputStream.read(this.iWidth, 1, false);
    this.iHigh = paramJceInputStream.read(this.iHigh, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.strUrl != null) {
      paramJceOutputStream.write(this.strUrl, 0);
    }
    paramJceOutputStream.write(this.iWidth, 1);
    paramJceOutputStream.write(this.iHigh, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_COMM_VIP_GROWTH.IconInfo
 * JD-Core Version:    0.7.0.1
 */