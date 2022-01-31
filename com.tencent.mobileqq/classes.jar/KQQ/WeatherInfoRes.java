package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class WeatherInfoRes
  extends JceStruct
{
  static ThreeDayWeather cache_weatherInfo;
  public String city = "";
  public byte citytype;
  public String province = "";
  public byte result;
  public ThreeDayWeather weatherInfo;
  
  public WeatherInfoRes() {}
  
  public WeatherInfoRes(byte paramByte1, String paramString1, ThreeDayWeather paramThreeDayWeather, byte paramByte2, String paramString2)
  {
    this.result = paramByte1;
    this.city = paramString1;
    this.weatherInfo = paramThreeDayWeather;
    this.citytype = paramByte2;
    this.province = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.result = paramJceInputStream.read(this.result, 1, true);
    this.city = paramJceInputStream.readString(2, true);
    if (cache_weatherInfo == null) {
      cache_weatherInfo = new ThreeDayWeather();
    }
    this.weatherInfo = ((ThreeDayWeather)paramJceInputStream.read(cache_weatherInfo, 3, true));
    this.citytype = paramJceInputStream.read(this.citytype, 4, false);
    this.province = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.result, 1);
    paramJceOutputStream.write(this.city, 2);
    paramJceOutputStream.write(this.weatherInfo, 3);
    paramJceOutputStream.write(this.citytype, 4);
    if (this.province != null) {
      paramJceOutputStream.write(this.province, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     KQQ.WeatherInfoRes
 * JD-Core Version:    0.7.0.1
 */