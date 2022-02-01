package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class WeatherInfo_V2
  extends JceStruct
{
  static ArrayList<ForecastInfo> cache_vecForecastInfo;
  public long iCacheTime;
  public int iCityCode;
  public int iDayTime;
  public int iHour;
  public int iHumidity;
  public int iPM2p5;
  public int iRet;
  public int iTempCurr;
  public int iTempMax;
  public int iTempMin;
  public int iTimeUpdate;
  public int iWeather;
  public int iWind;
  public int iWindForce;
  public String strCityName = "";
  public String strDate = "";
  public String strDeviceName = "";
  public String strPressure = "";
  public String strSunriseTime = "";
  public String strSunsetTime = "";
  public String strUrl = "";
  public ArrayList<ForecastInfo> vecForecastInfo;
  
  public WeatherInfo_V2() {}
  
  public WeatherInfo_V2(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, String paramString3, String paramString4, String paramString5, int paramInt10, String paramString6, int paramInt11, int paramInt12, long paramLong, ArrayList<ForecastInfo> paramArrayList, String paramString7, int paramInt13)
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
    this.iDayTime = paramInt12;
    this.iCacheTime = paramLong;
    this.vecForecastInfo = paramArrayList;
    this.strUrl = paramString7;
    this.iTimeUpdate = paramInt13;
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
    this.iDayTime = paramJceInputStream.read(this.iDayTime, 17, false);
    this.iCacheTime = paramJceInputStream.read(this.iCacheTime, 18, false);
    if (cache_vecForecastInfo == null)
    {
      cache_vecForecastInfo = new ArrayList();
      ForecastInfo localForecastInfo = new ForecastInfo();
      cache_vecForecastInfo.add(localForecastInfo);
    }
    this.vecForecastInfo = ((ArrayList)paramJceInputStream.read(cache_vecForecastInfo, 19, false));
    this.strUrl = paramJceInputStream.readString(20, false);
    this.iTimeUpdate = paramJceInputStream.read(this.iTimeUpdate, 21, false);
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
    Object localObject = this.strSunriseTime;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 11);
    }
    localObject = this.strSunsetTime;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 12);
    }
    localObject = this.strPressure;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 13);
    }
    paramJceOutputStream.write(this.iWindForce, 14);
    localObject = this.strDeviceName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 15);
    }
    paramJceOutputStream.write(this.iPM2p5, 16);
    paramJceOutputStream.write(this.iDayTime, 17);
    paramJceOutputStream.write(this.iCacheTime, 18);
    localObject = this.vecForecastInfo;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 19);
    }
    localObject = this.strUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 20);
    }
    paramJceOutputStream.write(this.iTimeUpdate, 21);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     LBS_V2_PROTOCOL.WeatherInfo_V2
 * JD-Core Version:    0.7.0.1
 */