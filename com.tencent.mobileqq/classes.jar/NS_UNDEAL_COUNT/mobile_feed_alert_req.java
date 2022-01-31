package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class mobile_feed_alert_req
  extends JceStruct
{
  static Map cache_mapLastGetTime;
  static Map cache_mapTimeStamp;
  public Map mapLastGetTime;
  public Map mapTimeStamp;
  public String sTransParam = "";
  public long uMask;
  
  public mobile_feed_alert_req() {}
  
  public mobile_feed_alert_req(long paramLong, Map paramMap1, Map paramMap2, String paramString)
  {
    this.uMask = paramLong;
    this.mapTimeStamp = paramMap1;
    this.mapLastGetTime = paramMap2;
    this.sTransParam = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uMask = paramJceInputStream.read(this.uMask, 0, false);
    if (cache_mapTimeStamp == null)
    {
      cache_mapTimeStamp = new HashMap();
      cache_mapTimeStamp.put(Integer.valueOf(0), Long.valueOf(0L));
    }
    this.mapTimeStamp = ((Map)paramJceInputStream.read(cache_mapTimeStamp, 1, false));
    if (cache_mapLastGetTime == null)
    {
      cache_mapLastGetTime = new HashMap();
      cache_mapLastGetTime.put(Long.valueOf(0L), Long.valueOf(0L));
    }
    this.mapLastGetTime = ((Map)paramJceInputStream.read(cache_mapLastGetTime, 2, false));
    this.sTransParam = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uMask, 0);
    if (this.mapTimeStamp != null) {
      paramJceOutputStream.write(this.mapTimeStamp, 1);
    }
    if (this.mapLastGetTime != null) {
      paramJceOutputStream.write(this.mapLastGetTime, 2);
    }
    if (this.sTransParam != null) {
      paramJceOutputStream.write(this.sTransParam, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_UNDEAL_COUNT.mobile_feed_alert_req
 * JD-Core Version:    0.7.0.1
 */