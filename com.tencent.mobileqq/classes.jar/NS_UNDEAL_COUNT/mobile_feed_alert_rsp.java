package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class mobile_feed_alert_rsp
  extends JceStruct
{
  static int cache_jumpType;
  static Map cache_mapLastGetTime;
  static count_info cache_stActiveInfo;
  static single_count cache_stGameBarInfo;
  static single_count cache_stPersionalInfo;
  static single_count cache_stZebraAppInfo;
  public int iNextTimeout;
  public int jumpType;
  public Map mapLastGetTime;
  public count_info stActiveInfo;
  public single_count stGameBarInfo;
  public single_count stPersionalInfo;
  public single_count stZebraAppInfo;
  
  public mobile_feed_alert_rsp() {}
  
  public mobile_feed_alert_rsp(count_info paramcount_info, single_count paramsingle_count1, int paramInt1, single_count paramsingle_count2, single_count paramsingle_count3, Map paramMap, int paramInt2)
  {
    this.stActiveInfo = paramcount_info;
    this.stGameBarInfo = paramsingle_count1;
    this.iNextTimeout = paramInt1;
    this.stZebraAppInfo = paramsingle_count2;
    this.stPersionalInfo = paramsingle_count3;
    this.mapLastGetTime = paramMap;
    this.jumpType = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stActiveInfo == null) {
      cache_stActiveInfo = new count_info();
    }
    this.stActiveInfo = ((count_info)paramJceInputStream.read(cache_stActiveInfo, 0, false));
    if (cache_stGameBarInfo == null) {
      cache_stGameBarInfo = new single_count();
    }
    this.stGameBarInfo = ((single_count)paramJceInputStream.read(cache_stGameBarInfo, 1, false));
    this.iNextTimeout = paramJceInputStream.read(this.iNextTimeout, 2, false);
    if (cache_stZebraAppInfo == null) {
      cache_stZebraAppInfo = new single_count();
    }
    this.stZebraAppInfo = ((single_count)paramJceInputStream.read(cache_stZebraAppInfo, 3, false));
    if (cache_stPersionalInfo == null) {
      cache_stPersionalInfo = new single_count();
    }
    this.stPersionalInfo = ((single_count)paramJceInputStream.read(cache_stPersionalInfo, 4, false));
    if (cache_mapLastGetTime == null)
    {
      cache_mapLastGetTime = new HashMap();
      cache_mapLastGetTime.put(Long.valueOf(0L), Long.valueOf(0L));
    }
    this.mapLastGetTime = ((Map)paramJceInputStream.read(cache_mapLastGetTime, 5, false));
    this.jumpType = paramJceInputStream.read(this.jumpType, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stActiveInfo != null) {
      paramJceOutputStream.write(this.stActiveInfo, 0);
    }
    if (this.stGameBarInfo != null) {
      paramJceOutputStream.write(this.stGameBarInfo, 1);
    }
    paramJceOutputStream.write(this.iNextTimeout, 2);
    if (this.stZebraAppInfo != null) {
      paramJceOutputStream.write(this.stZebraAppInfo, 3);
    }
    if (this.stPersionalInfo != null) {
      paramJceOutputStream.write(this.stPersionalInfo, 4);
    }
    if (this.mapLastGetTime != null) {
      paramJceOutputStream.write(this.mapLastGetTime, 5);
    }
    paramJceOutputStream.write(this.jumpType, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_UNDEAL_COUNT.mobile_feed_alert_rsp
 * JD-Core Version:    0.7.0.1
 */