package NS_MOBILE_COMM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PicDecorateInfo
  extends JceStruct
{
  public int iType = -1;
  public String strPlayZipUrl = "";
  public String strReverseUrl = "";
  
  public PicDecorateInfo() {}
  
  public PicDecorateInfo(int paramInt, String paramString1, String paramString2)
  {
    this.iType = paramInt;
    this.strReverseUrl = paramString1;
    this.strPlayZipUrl = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iType = paramJceInputStream.read(this.iType, 0, false);
    this.strReverseUrl = paramJceInputStream.readString(1, false);
    this.strPlayZipUrl = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iType, 0);
    if (this.strReverseUrl != null) {
      paramJceOutputStream.write(this.strReverseUrl, 1);
    }
    if (this.strPlayZipUrl != null) {
      paramJceOutputStream.write(this.strPlayZipUrl, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     NS_MOBILE_COMM.PicDecorateInfo
 * JD-Core Version:    0.7.0.1
 */