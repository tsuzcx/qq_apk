package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PoiInfo_V2
  extends JceStruct
{
  static GPS_V2 cache_stGps;
  public int iDistance;
  public int iDistrictCode;
  public int iHotValue;
  public int iPoiNum;
  public int iPoiOrderType;
  public int iType;
  public GPS_V2 stGps;
  public String strAddress = "";
  public String strCity = "";
  public String strCountry = "";
  public String strDefaultName = "";
  public String strDianPingId = "";
  public String strDistrict = "";
  public String strName = "";
  public String strPhone = "";
  public String strPoiId = "";
  public String strProvince = "";
  public String strTypeName = "";
  
  public PoiInfo_V2() {}
  
  public PoiInfo_V2(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, GPS_V2 paramGPS_V2, int paramInt3, int paramInt4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt5, int paramInt6, String paramString9, String paramString10, String paramString11)
  {
    this.strPoiId = paramString1;
    this.strName = paramString2;
    this.iType = paramInt1;
    this.strTypeName = paramString3;
    this.strAddress = paramString4;
    this.iDistrictCode = paramInt2;
    this.stGps = paramGPS_V2;
    this.iDistance = paramInt3;
    this.iHotValue = paramInt4;
    this.strPhone = paramString5;
    this.strCountry = paramString6;
    this.strProvince = paramString7;
    this.strCity = paramString8;
    this.iPoiNum = paramInt5;
    this.iPoiOrderType = paramInt6;
    this.strDefaultName = paramString9;
    this.strDistrict = paramString10;
    this.strDianPingId = paramString11;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strPoiId = paramJceInputStream.readString(0, true);
    this.strName = paramJceInputStream.readString(1, true);
    this.iType = paramJceInputStream.read(this.iType, 2, true);
    this.strTypeName = paramJceInputStream.readString(3, true);
    this.strAddress = paramJceInputStream.readString(4, true);
    this.iDistrictCode = paramJceInputStream.read(this.iDistrictCode, 5, true);
    if (cache_stGps == null) {
      cache_stGps = new GPS_V2();
    }
    this.stGps = ((GPS_V2)paramJceInputStream.read(cache_stGps, 6, true));
    this.iDistance = paramJceInputStream.read(this.iDistance, 7, true);
    this.iHotValue = paramJceInputStream.read(this.iHotValue, 8, false);
    this.strPhone = paramJceInputStream.readString(9, false);
    this.strCountry = paramJceInputStream.readString(10, false);
    this.strProvince = paramJceInputStream.readString(11, false);
    this.strCity = paramJceInputStream.readString(12, false);
    this.iPoiNum = paramJceInputStream.read(this.iPoiNum, 13, false);
    this.iPoiOrderType = paramJceInputStream.read(this.iPoiOrderType, 14, false);
    this.strDefaultName = paramJceInputStream.readString(15, false);
    this.strDistrict = paramJceInputStream.readString(16, false);
    this.strDianPingId = paramJceInputStream.readString(17, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strPoiId, 0);
    paramJceOutputStream.write(this.strName, 1);
    paramJceOutputStream.write(this.iType, 2);
    paramJceOutputStream.write(this.strTypeName, 3);
    paramJceOutputStream.write(this.strAddress, 4);
    paramJceOutputStream.write(this.iDistrictCode, 5);
    paramJceOutputStream.write(this.stGps, 6);
    paramJceOutputStream.write(this.iDistance, 7);
    paramJceOutputStream.write(this.iHotValue, 8);
    String str = this.strPhone;
    if (str != null) {
      paramJceOutputStream.write(str, 9);
    }
    str = this.strCountry;
    if (str != null) {
      paramJceOutputStream.write(str, 10);
    }
    str = this.strProvince;
    if (str != null) {
      paramJceOutputStream.write(str, 11);
    }
    str = this.strCity;
    if (str != null) {
      paramJceOutputStream.write(str, 12);
    }
    paramJceOutputStream.write(this.iPoiNum, 13);
    paramJceOutputStream.write(this.iPoiOrderType, 14);
    str = this.strDefaultName;
    if (str != null) {
      paramJceOutputStream.write(str, 15);
    }
    str = this.strDistrict;
    if (str != null) {
      paramJceOutputStream.write(str, 16);
    }
    str = this.strDianPingId;
    if (str != null) {
      paramJceOutputStream.write(str, 17);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     LBS_V2_PROTOCOL.PoiInfo_V2
 * JD-Core Version:    0.7.0.1
 */