package MOBILE_QZMALL_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ArrowInfo
  extends JceStruct
{
  static LocationInfo cache_stLocationInfo = new LocationInfo();
  public LocationInfo stLocationInfo = null;
  public String strUrl = "";
  
  public ArrowInfo() {}
  
  public ArrowInfo(LocationInfo paramLocationInfo, String paramString)
  {
    this.stLocationInfo = paramLocationInfo;
    this.strUrl = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stLocationInfo = ((LocationInfo)paramJceInputStream.read(cache_stLocationInfo, 0, false));
    this.strUrl = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.stLocationInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.strUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MOBILE_QZMALL_PROTOCOL.ArrowInfo
 * JD-Core Version:    0.7.0.1
 */