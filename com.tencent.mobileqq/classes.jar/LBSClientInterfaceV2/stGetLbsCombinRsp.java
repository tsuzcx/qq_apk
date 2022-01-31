package LBSClientInterfaceV2;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stGetLbsCombinRsp
  extends JceStruct
{
  static stGPS cache_stGps;
  static stGetPoiInfoRsp cache_stPoiInfo;
  static stGeoInfo cache_stPosition;
  static stWeatherInfo cache_stWeather;
  public stGPS stGps = null;
  public stGetPoiInfoRsp stPoiInfo = null;
  public stGeoInfo stPosition = null;
  public stWeatherInfo stWeather = null;
  
  public stGetLbsCombinRsp() {}
  
  public stGetLbsCombinRsp(stGPS paramstGPS, stGeoInfo paramstGeoInfo, stGetPoiInfoRsp paramstGetPoiInfoRsp, stWeatherInfo paramstWeatherInfo)
  {
    this.stGps = paramstGPS;
    this.stPosition = paramstGeoInfo;
    this.stPoiInfo = paramstGetPoiInfoRsp;
    this.stWeather = paramstWeatherInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stGps == null) {
      cache_stGps = new stGPS();
    }
    this.stGps = ((stGPS)paramJceInputStream.read(cache_stGps, 0, true));
    if (cache_stPosition == null) {
      cache_stPosition = new stGeoInfo();
    }
    this.stPosition = ((stGeoInfo)paramJceInputStream.read(cache_stPosition, 1, true));
    if (cache_stPoiInfo == null) {
      cache_stPoiInfo = new stGetPoiInfoRsp();
    }
    this.stPoiInfo = ((stGetPoiInfoRsp)paramJceInputStream.read(cache_stPoiInfo, 2, true));
    if (cache_stWeather == null) {
      cache_stWeather = new stWeatherInfo();
    }
    this.stWeather = ((stWeatherInfo)paramJceInputStream.read(cache_stWeather, 3, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stGps, 0);
    paramJceOutputStream.write(this.stPosition, 1);
    paramJceOutputStream.write(this.stPoiInfo, 2);
    paramJceOutputStream.write(this.stWeather, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     LBSClientInterfaceV2.stGetLbsCombinRsp
 * JD-Core Version:    0.7.0.1
 */