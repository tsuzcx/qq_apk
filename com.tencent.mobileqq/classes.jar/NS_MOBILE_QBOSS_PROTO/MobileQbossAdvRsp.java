package NS_MOBILE_QBOSS_PROTO;

import BOSSStrategyCenter.tAdvDesc;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class MobileQbossAdvRsp
  extends JceStruct
{
  static Map<Integer, ArrayList<tAdvDesc>> cache_mapAdv = new HashMap();
  static Map<Integer, Long> cache_map_next_query_ts;
  public int iRet = 0;
  public Map<Integer, ArrayList<tAdvDesc>> mapAdv = null;
  public Map<Integer, Long> map_next_query_ts = null;
  public String sMsg = "";
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new tAdvDesc());
    cache_mapAdv.put(localInteger, localArrayList);
    cache_map_next_query_ts = new HashMap();
    cache_map_next_query_ts.put(localInteger, Long.valueOf(0L));
  }
  
  public MobileQbossAdvRsp() {}
  
  public MobileQbossAdvRsp(int paramInt, String paramString, Map<Integer, ArrayList<tAdvDesc>> paramMap, Map<Integer, Long> paramMap1)
  {
    this.iRet = paramInt;
    this.sMsg = paramString;
    this.mapAdv = paramMap;
    this.map_next_query_ts = paramMap1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iRet = paramJceInputStream.read(this.iRet, 0, true);
    this.sMsg = paramJceInputStream.readString(1, true);
    this.mapAdv = ((Map)paramJceInputStream.read(cache_mapAdv, 2, true));
    this.map_next_query_ts = ((Map)paramJceInputStream.read(cache_map_next_query_ts, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iRet, 0);
    paramJceOutputStream.write(this.sMsg, 1);
    paramJceOutputStream.write(this.mapAdv, 2);
    Map localMap = this.map_next_query_ts;
    if (localMap != null) {
      paramJceOutputStream.write(localMap, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_QBOSS_PROTO.MobileQbossAdvRsp
 * JD-Core Version:    0.7.0.1
 */