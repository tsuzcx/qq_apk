package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class mobile_ranking_feeds_req
  extends JceStruct
{
  static Map<String, String> cache_mapEx = new HashMap();
  static Map<Integer, byte[]> cache_stMapRanking;
  public int iOperaType = 1;
  public Map<String, String> mapEx;
  public Map<Integer, byte[]> stMapRanking;
  public long uin;
  
  static
  {
    cache_mapEx.put("", "");
    cache_stMapRanking = new HashMap();
    byte[] arrayOfByte = (byte[])new byte[1];
    ((byte[])arrayOfByte)[0] = 0;
    cache_stMapRanking.put(Integer.valueOf(0), arrayOfByte);
  }
  
  public mobile_ranking_feeds_req() {}
  
  public mobile_ranking_feeds_req(long paramLong, int paramInt, Map<String, String> paramMap, Map<Integer, byte[]> paramMap1)
  {
    this.uin = paramLong;
    this.iOperaType = paramInt;
    this.mapEx = paramMap;
    this.stMapRanking = paramMap1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.iOperaType = paramJceInputStream.read(this.iOperaType, 1, false);
    this.mapEx = ((Map)paramJceInputStream.read(cache_mapEx, 2, false));
    this.stMapRanking = ((Map)paramJceInputStream.read(cache_stMapRanking, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.iOperaType, 1);
    if (this.mapEx != null) {
      paramJceOutputStream.write(this.mapEx, 2);
    }
    if (this.stMapRanking != null) {
      paramJceOutputStream.write(this.stMapRanking, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.mobile_ranking_feeds_req
 * JD-Core Version:    0.7.0.1
 */