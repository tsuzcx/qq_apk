package LBSClientInterfaceV2;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class stWeatherInfo
  extends JceStruct
{
  static Map<String, AlarmInfo> cache_mapAlarminfo;
  static Map<Short, ForecastInfo> cache_mapForecastInfo;
  public int iCityCode = 0;
  public int iHour = 0;
  public int iHumidity = 0;
  public int iPM2p5 = 0;
  public int iRet = 0;
  public int iTempCurr = 0;
  public int iTempMax = 0;
  public int iTempMin = 0;
  public int iWeather = 0;
  public int iWind = 0;
  public int iWindForce = 0;
  public Map<String, AlarmInfo> mapAlarminfo = null;
  public Map<Short, ForecastInfo> mapForecastInfo = null;
  public String strCityName = "";
  public String strDate = "";
  public String strDeviceName = "";
  public String strPressure = "";
  public String strSunriseTime = "";
  public String strSunsetTime = "";
  
  public stWeatherInfo() {}
  
  public stWeatherInfo(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, String paramString3, String paramString4, String paramString5, int paramInt10, String paramString6, int paramInt11, Map<Short, ForecastInfo> paramMap, Map<String, AlarmInfo> paramMap1)
  {
    this.iRet = paramInt1;
    this.iCityCode = paramInt2;
    this.strCityName = paramString1;
    this.strDate = paramString2;
    this.iHour = paramInt3;
    this.iWeather = paramInt4;
    this.iWind = paramInt5;
    this.iTempCurr = paramInt6;
    this.iTempMax = paramInt7;
    this.iTempMin = paramInt8;
    this.iHumidity = paramInt9;
    this.strSunriseTime = paramString3;
    this.strSunsetTime = paramString4;
    this.strPressure = paramString5;
    this.iWindForce = paramInt10;
    this.strDeviceName = paramString6;
    this.iPM2p5 = paramInt11;
    this.mapForecastInfo = paramMap;
    this.mapAlarminfo = paramMap1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iRet = paramJceInputStream.read(this.iRet, 0, true);
    this.iCityCode = paramJceInputStream.read(this.iCityCode, 1, true);
    this.strCityName = paramJceInputStream.readString(2, true);
    this.strDate = paramJceInputStream.readString(3, true);
    this.iHour = paramJceInputStream.read(this.iHour, 4, true);
    this.iWeather = paramJceInputStream.read(this.iWeather, 5, true);
    this.iWind = paramJceInputStream.read(this.iWind, 6, true);
    this.iTempCurr = paramJceInputStream.read(this.iTempCurr, 7, true);
    this.iTempMax = paramJceInputStream.read(this.iTempMax, 8, true);
    this.iTempMin = paramJceInputStream.read(this.iTempMin, 9, true);
    this.iHumidity = paramJceInputStream.read(this.iHumidity, 10, true);
    this.strSunriseTime = paramJceInputStream.readString(11, false);
    this.strSunsetTime = paramJceInputStream.readString(12, false);
    this.strPressure = paramJceInputStream.readString(13, false);
    this.iWindForce = paramJceInputStream.read(this.iWindForce, 14, false);
    this.strDeviceName = paramJceInputStream.readString(15, false);
    this.iPM2p5 = paramJceInputStream.read(this.iPM2p5, 16, false);
    Object localObject;
    if (cache_mapForecastInfo == null)
    {
      cache_mapForecastInfo = new HashMap();
      localObject = new ForecastInfo();
      cache_mapForecastInfo.put(Short.valueOf((short)0), localObject);
    }
    this.mapForecastInfo = ((Map)paramJceInputStream.read(cache_mapForecastInfo, 17, false));
    if (cache_mapAlarminfo == null)
    {
      cache_mapAlarminfo = new HashMap();
      localObject = new AlarmInfo();
      cache_mapAlarminfo.put("", localObject);
    }
    this.mapAlarminfo = ((Map)paramJceInputStream.read(cache_mapAlarminfo, 18, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iRet, 0);
    paramJceOutputStream.write(this.iCityCode, 1);
    paramJceOutputStream.write(this.strCityName, 2);
    paramJceOutputStream.write(this.strDate, 3);
    paramJceOutputStream.write(this.iHour, 4);
    paramJceOutputStream.write(this.iWeather, 5);
    paramJceOutputStream.write(this.iWind, 6);
    paramJceOutputStream.write(this.iTempCurr, 7);
    paramJceOutputStream.write(this.iTempMax, 8);
    paramJceOutputStream.write(this.iTempMin, 9);
    paramJceOutputStream.write(this.iHumidity, 10);
    if (this.strSunriseTime != null) {
      paramJceOutputStream.write(this.strSunriseTime, 11);
    }
    if (this.strSunsetTime != null) {
      paramJceOutputStream.write(this.strSunsetTime, 12);
    }
    if (this.strPressure != null) {
      paramJceOutputStream.write(this.strPressure, 13);
    }
    paramJceOutputStream.write(this.iWindForce, 14);
    if (this.strDeviceName != null) {
      paramJceOutputStream.write(this.strDeviceName, 15);
    }
    paramJceOutputStream.write(this.iPM2p5, 16);
    if (this.mapForecastInfo != null) {
      paramJceOutputStream.write(this.mapForecastInfo, 17);
    }
    if (this.mapAlarminfo != null) {
      paramJceOutputStream.write(this.mapAlarminfo, 18);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     LBSClientInterfaceV2.stWeatherInfo
 * JD-Core Version:    0.7.0.1
 */