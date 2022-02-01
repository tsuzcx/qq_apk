package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ThreeDayWeather
  extends JceStruct
{
  static DayWeather cache_aftertom;
  static DayWeather cache_today;
  static DayWeather cache_tomorrow;
  public DayWeather aftertom = null;
  public String currtime = "";
  public int currtmpe = 0;
  public String day = "";
  public String festa = "";
  public DayWeather today = null;
  public DayWeather tomorrow = null;
  public String year = "";
  
  public ThreeDayWeather() {}
  
  public ThreeDayWeather(DayWeather paramDayWeather1, DayWeather paramDayWeather2, DayWeather paramDayWeather3, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.today = paramDayWeather1;
    this.tomorrow = paramDayWeather2;
    this.aftertom = paramDayWeather3;
    this.currtmpe = paramInt;
    this.year = paramString1;
    this.day = paramString2;
    this.festa = paramString3;
    this.currtime = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_today == null) {
      cache_today = new DayWeather();
    }
    this.today = ((DayWeather)paramJceInputStream.read(cache_today, 1, true));
    if (cache_tomorrow == null) {
      cache_tomorrow = new DayWeather();
    }
    this.tomorrow = ((DayWeather)paramJceInputStream.read(cache_tomorrow, 2, true));
    if (cache_aftertom == null) {
      cache_aftertom = new DayWeather();
    }
    this.aftertom = ((DayWeather)paramJceInputStream.read(cache_aftertom, 3, true));
    this.currtmpe = paramJceInputStream.read(this.currtmpe, 4, false);
    this.year = paramJceInputStream.readString(5, false);
    this.day = paramJceInputStream.readString(6, false);
    this.festa = paramJceInputStream.readString(7, false);
    this.currtime = paramJceInputStream.readString(8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.today, 1);
    paramJceOutputStream.write(this.tomorrow, 2);
    paramJceOutputStream.write(this.aftertom, 3);
    paramJceOutputStream.write(this.currtmpe, 4);
    String str = this.year;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
    str = this.day;
    if (str != null) {
      paramJceOutputStream.write(str, 6);
    }
    str = this.festa;
    if (str != null) {
      paramJceOutputStream.write(str, 7);
    }
    str = this.currtime;
    if (str != null) {
      paramJceOutputStream.write(str, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     KQQ.ThreeDayWeather
 * JD-Core Version:    0.7.0.1
 */