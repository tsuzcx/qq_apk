package ELABORATE_FEED_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class feed_report_info
  extends JceStruct
{
  static int cache_eLayerTtype = 0;
  static Map<Integer, String> cache_mapFeedCookie = new HashMap();
  static Map<Integer, String> cache_mapParentFeedCookie;
  static ArrayList<action_flow> cache_vecActionFlow;
  public int eLayerTtype = -1;
  public Map<Integer, String> mapFeedCookie = null;
  public Map<Integer, String> mapParentFeedCookie = null;
  public int uFeedIndex = 0;
  public long uLayerNumber = 0L;
  public ArrayList<action_flow> vecActionFlow = null;
  
  static
  {
    cache_mapFeedCookie.put(Integer.valueOf(0), "");
    cache_vecActionFlow = new ArrayList();
    action_flow localaction_flow = new action_flow();
    cache_vecActionFlow.add(localaction_flow);
    cache_mapParentFeedCookie = new HashMap();
    cache_mapParentFeedCookie.put(Integer.valueOf(0), "");
  }
  
  public feed_report_info() {}
  
  public feed_report_info(Map<Integer, String> paramMap1, int paramInt1, ArrayList<action_flow> paramArrayList, Map<Integer, String> paramMap2, long paramLong, int paramInt2)
  {
    this.mapFeedCookie = paramMap1;
    this.uFeedIndex = paramInt1;
    this.vecActionFlow = paramArrayList;
    this.mapParentFeedCookie = paramMap2;
    this.uLayerNumber = paramLong;
    this.eLayerTtype = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.mapFeedCookie = ((Map)paramJceInputStream.read(cache_mapFeedCookie, 0, false));
    this.uFeedIndex = paramJceInputStream.read(this.uFeedIndex, 1, false);
    this.vecActionFlow = ((ArrayList)paramJceInputStream.read(cache_vecActionFlow, 2, false));
    this.mapParentFeedCookie = ((Map)paramJceInputStream.read(cache_mapParentFeedCookie, 3, false));
    this.uLayerNumber = paramJceInputStream.read(this.uLayerNumber, 4, false);
    this.eLayerTtype = paramJceInputStream.read(this.eLayerTtype, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.mapFeedCookie != null) {
      paramJceOutputStream.write(this.mapFeedCookie, 0);
    }
    paramJceOutputStream.write(this.uFeedIndex, 1);
    if (this.vecActionFlow != null) {
      paramJceOutputStream.write(this.vecActionFlow, 2);
    }
    if (this.mapParentFeedCookie != null) {
      paramJceOutputStream.write(this.mapParentFeedCookie, 3);
    }
    paramJceOutputStream.write(this.uLayerNumber, 4);
    paramJceOutputStream.write(this.eLayerTtype, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ELABORATE_FEED_REPORT.feed_report_info
 * JD-Core Version:    0.7.0.1
 */