package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GeoInfoCell_V2
  extends JceStruct
{
  static GPS_V2 cache_stClientGps;
  static GeoInfo_V2 cache_stGeoInfo;
  static GPS_V2 cache_stGps;
  public int iRet;
  public GPS_V2 stClientGps;
  public GeoInfo_V2 stGeoInfo;
  public GPS_V2 stGps;
  
  public GeoInfoCell_V2() {}
  
  public GeoInfoCell_V2(GPS_V2 paramGPS_V21, GeoInfo_V2 paramGeoInfo_V2, int paramInt, GPS_V2 paramGPS_V22)
  {
    this.stGps = paramGPS_V21;
    this.stGeoInfo = paramGeoInfo_V2;
    this.iRet = paramInt;
    this.stClientGps = paramGPS_V22;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stGps == null) {
      cache_stGps = new GPS_V2();
    }
    this.stGps = ((GPS_V2)paramJceInputStream.read(cache_stGps, 0, false));
    if (cache_stGeoInfo == null) {
      cache_stGeoInfo = new GeoInfo_V2();
    }
    this.stGeoInfo = ((GeoInfo_V2)paramJceInputStream.read(cache_stGeoInfo, 1, false));
    this.iRet = paramJceInputStream.read(this.iRet, 2, false);
    if (cache_stClientGps == null) {
      cache_stClientGps = new GPS_V2();
    }
    this.stClientGps = ((GPS_V2)paramJceInputStream.read(cache_stClientGps, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stGps != null) {
      paramJceOutputStream.write(this.stGps, 0);
    }
    if (this.stGeoInfo != null) {
      paramJceOutputStream.write(this.stGeoInfo, 1);
    }
    paramJceOutputStream.write(this.iRet, 2);
    if (this.stClientGps != null) {
      paramJceOutputStream.write(this.stClientGps, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     LBS_V2_PROTOCOL.GeoInfoCell_V2
 * JD-Core Version:    0.7.0.1
 */