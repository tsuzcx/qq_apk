package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetLbsCombinRsp_V2
  extends JceStruct
{
  static GeoInfo_V2 cache_stGeoInfo = new GeoInfo_V2();
  static GPS_V2 cache_stGps = new GPS_V2();
  static GetPoiInfoRsp_V2 cache_stPoiInfo = new GetPoiInfoRsp_V2();
  static WeatherInfo_V2 cache_stWeather = new WeatherInfo_V2();
  public int iMood = 0;
  public String request_id = "";
  public GeoInfo_V2 stGeoInfo = null;
  public GPS_V2 stGps = null;
  public GetPoiInfoRsp_V2 stPoiInfo = null;
  public WeatherInfo_V2 stWeather = null;
  
  public GetLbsCombinRsp_V2() {}
  
  public GetLbsCombinRsp_V2(GPS_V2 paramGPS_V2, GeoInfo_V2 paramGeoInfo_V2, GetPoiInfoRsp_V2 paramGetPoiInfoRsp_V2, WeatherInfo_V2 paramWeatherInfo_V2, int paramInt, String paramString)
  {
    this.stGps = paramGPS_V2;
    this.stGeoInfo = paramGeoInfo_V2;
    this.stPoiInfo = paramGetPoiInfoRsp_V2;
    this.stWeather = paramWeatherInfo_V2;
    this.iMood = paramInt;
    this.request_id = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stGps = ((GPS_V2)paramJceInputStream.read(cache_stGps, 0, true));
    this.stGeoInfo = ((GeoInfo_V2)paramJceInputStream.read(cache_stGeoInfo, 1, true));
    this.stPoiInfo = ((GetPoiInfoRsp_V2)paramJceInputStream.read(cache_stPoiInfo, 2, true));
    this.stWeather = ((WeatherInfo_V2)paramJceInputStream.read(cache_stWeather, 3, true));
    this.iMood = paramJceInputStream.read(this.iMood, 4, false);
    this.request_id = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stGps, 0);
    paramJceOutputStream.write(this.stGeoInfo, 1);
    paramJceOutputStream.write(this.stPoiInfo, 2);
    paramJceOutputStream.write(this.stWeather, 3);
    paramJceOutputStream.write(this.iMood, 4);
    String str = this.request_id;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     LBS_V2_PROTOCOL.GetLbsCombinRsp_V2
 * JD-Core Version:    0.7.0.1
 */