package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ForecastInfo
  extends JceStruct
{
  public int iDayWeather;
  public int iNightWeather;
  public int iTempMax;
  public int iTempMin;
  public int iTimestamp;
  public String strDayWeather = "";
  
  public ForecastInfo() {}
  
  public ForecastInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString)
  {
    this.iTimestamp = paramInt1;
    this.iDayWeather = paramInt2;
    this.iNightWeather = paramInt3;
    this.iTempMax = paramInt4;
    this.iTempMin = paramInt5;
    this.strDayWeather = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iTimestamp = paramJceInputStream.read(this.iTimestamp, 0, true);
    this.iDayWeather = paramJceInputStream.read(this.iDayWeather, 1, true);
    this.iNightWeather = paramJceInputStream.read(this.iNightWeather, 2, true);
    this.iTempMax = paramJceInputStream.read(this.iTempMax, 3, true);
    this.iTempMin = paramJceInputStream.read(this.iTempMin, 4, true);
    this.strDayWeather = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iTimestamp, 0);
    paramJceOutputStream.write(this.iDayWeather, 1);
    paramJceOutputStream.write(this.iNightWeather, 2);
    paramJceOutputStream.write(this.iTempMax, 3);
    paramJceOutputStream.write(this.iTempMin, 4);
    if (this.strDayWeather != null) {
      paramJceOutputStream.write(this.strDayWeather, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\acom2.jar
 * Qualified Name:     LBS_V2_PROTOCOL.ForecastInfo
 * JD-Core Version:    0.7.0.1
 */