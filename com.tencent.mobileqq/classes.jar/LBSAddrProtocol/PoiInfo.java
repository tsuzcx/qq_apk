package LBSAddrProtocol;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PoiInfo
  extends JceStruct
{
  public int iDistance;
  public int iDistrictCode;
  public int iHotValue;
  public int iLat;
  public int iLon;
  public int iType;
  public long lId;
  public String strAddress = "";
  public String strName = "";
  public String strPhone = "";
  public String strTypeName = "";
  
  public PoiInfo() {}
  
  public PoiInfo(long paramLong, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString4)
  {
    this.lId = paramLong;
    this.strName = paramString1;
    this.iType = paramInt1;
    this.strTypeName = paramString2;
    this.strAddress = paramString3;
    this.iDistrictCode = paramInt2;
    this.iLat = paramInt3;
    this.iLon = paramInt4;
    this.iDistance = paramInt5;
    this.iHotValue = paramInt6;
    this.strPhone = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lId = paramJceInputStream.read(this.lId, 0, true);
    this.strName = paramJceInputStream.readString(1, true);
    this.iType = paramJceInputStream.read(this.iType, 2, true);
    this.strTypeName = paramJceInputStream.readString(3, true);
    this.strAddress = paramJceInputStream.readString(4, true);
    this.iDistrictCode = paramJceInputStream.read(this.iDistrictCode, 5, true);
    this.iLat = paramJceInputStream.read(this.iLat, 6, true);
    this.iLon = paramJceInputStream.read(this.iLon, 7, true);
    this.iDistance = paramJceInputStream.read(this.iDistance, 8, true);
    this.iHotValue = paramJceInputStream.read(this.iHotValue, 9, false);
    this.strPhone = paramJceInputStream.readString(10, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lId, 0);
    paramJceOutputStream.write(this.strName, 1);
    paramJceOutputStream.write(this.iType, 2);
    paramJceOutputStream.write(this.strTypeName, 3);
    paramJceOutputStream.write(this.strAddress, 4);
    paramJceOutputStream.write(this.iDistrictCode, 5);
    paramJceOutputStream.write(this.iLat, 6);
    paramJceOutputStream.write(this.iLon, 7);
    paramJceOutputStream.write(this.iDistance, 8);
    paramJceOutputStream.write(this.iHotValue, 9);
    if (this.strPhone != null) {
      paramJceOutputStream.write(this.strPhone, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     LBSAddrProtocol.PoiInfo
 * JD-Core Version:    0.7.0.1
 */