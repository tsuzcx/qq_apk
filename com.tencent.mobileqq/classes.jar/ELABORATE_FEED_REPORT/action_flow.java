package ELABORATE_FEED_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class action_flow
  extends JceStruct
{
  static Map<Integer, String> cache_mapExtend = new HashMap();
  public long lTime = 0L;
  public Map<Integer, String> mapExtend = null;
  public int uActionHierarchy = 0;
  public long uDurationTime = 0L;
  public int uPageType = 0;
  
  static
  {
    cache_mapExtend.put(Integer.valueOf(0), "");
  }
  
  public action_flow() {}
  
  public action_flow(int paramInt1, long paramLong1, int paramInt2, Map<Integer, String> paramMap, long paramLong2)
  {
    this.uActionHierarchy = paramInt1;
    this.lTime = paramLong1;
    this.uPageType = paramInt2;
    this.mapExtend = paramMap;
    this.uDurationTime = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uActionHierarchy = paramJceInputStream.read(this.uActionHierarchy, 0, false);
    this.lTime = paramJceInputStream.read(this.lTime, 1, false);
    this.uPageType = paramJceInputStream.read(this.uPageType, 2, false);
    this.mapExtend = ((Map)paramJceInputStream.read(cache_mapExtend, 3, false));
    this.uDurationTime = paramJceInputStream.read(this.uDurationTime, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uActionHierarchy, 0);
    paramJceOutputStream.write(this.lTime, 1);
    paramJceOutputStream.write(this.uPageType, 2);
    if (this.mapExtend != null) {
      paramJceOutputStream.write(this.mapExtend, 3);
    }
    paramJceOutputStream.write(this.uDurationTime, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ELABORATE_FEED_REPORT.action_flow
 * JD-Core Version:    0.7.0.1
 */