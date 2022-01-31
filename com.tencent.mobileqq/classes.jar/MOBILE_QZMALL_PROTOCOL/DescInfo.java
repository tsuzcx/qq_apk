package MOBILE_QZMALL_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class DescInfo
  extends JceStruct
{
  static LocationInfo cache_stLocationInfo = new LocationInfo();
  public LocationInfo stLocationInfo;
  public String strDesc = "";
  public String strFontColor = "";
  public long uiFontSize;
  
  public DescInfo() {}
  
  public DescInfo(LocationInfo paramLocationInfo, String paramString1, long paramLong, String paramString2)
  {
    this.stLocationInfo = paramLocationInfo;
    this.strFontColor = paramString1;
    this.uiFontSize = paramLong;
    this.strDesc = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stLocationInfo = ((LocationInfo)paramJceInputStream.read(cache_stLocationInfo, 0, false));
    this.strFontColor = paramJceInputStream.readString(1, false);
    this.uiFontSize = paramJceInputStream.read(this.uiFontSize, 2, false);
    this.strDesc = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stLocationInfo != null) {
      paramJceOutputStream.write(this.stLocationInfo, 0);
    }
    if (this.strFontColor != null) {
      paramJceOutputStream.write(this.strFontColor, 1);
    }
    paramJceOutputStream.write(this.uiFontSize, 2);
    if (this.strDesc != null) {
      paramJceOutputStream.write(this.strDesc, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     MOBILE_QZMALL_PROTOCOL.DescInfo
 * JD-Core Version:    0.7.0.1
 */