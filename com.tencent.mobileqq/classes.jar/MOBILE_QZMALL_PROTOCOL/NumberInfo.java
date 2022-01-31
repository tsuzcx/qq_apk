package MOBILE_QZMALL_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class NumberInfo
  extends JceStruct
{
  static LocationInfo cache_stLocationInfo = new LocationInfo();
  public LocationInfo stLocationInfo;
  public String strFontColor = "";
  public String strNumber = "";
  public long uiFontSize;
  
  public NumberInfo() {}
  
  public NumberInfo(LocationInfo paramLocationInfo, String paramString1, long paramLong, String paramString2)
  {
    this.stLocationInfo = paramLocationInfo;
    this.strFontColor = paramString1;
    this.uiFontSize = paramLong;
    this.strNumber = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stLocationInfo = ((LocationInfo)paramJceInputStream.read(cache_stLocationInfo, 0, false));
    this.strFontColor = paramJceInputStream.readString(1, false);
    this.uiFontSize = paramJceInputStream.read(this.uiFontSize, 2, false);
    this.strNumber = paramJceInputStream.readString(3, false);
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
    if (this.strNumber != null) {
      paramJceOutputStream.write(this.strNumber, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\acom2.jar
 * Qualified Name:     MOBILE_QZMALL_PROTOCOL.NumberInfo
 * JD-Core Version:    0.7.0.1
 */