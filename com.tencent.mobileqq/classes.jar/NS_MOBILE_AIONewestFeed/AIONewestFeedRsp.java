package NS_MOBILE_AIONewestFeed;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class AIONewestFeedRsp
  extends JceStruct
{
  static Map<String, String> cache_mapEx;
  static ArrayList<NewestFeedInfo> cache_uFeedInfos = new ArrayList();
  public Map<String, String> mapEx;
  public ArrayList<NewestFeedInfo> uFeedInfos;
  public long uOpFlag;
  public long uOpuin;
  public long uTime;
  
  static
  {
    NewestFeedInfo localNewestFeedInfo = new NewestFeedInfo();
    cache_uFeedInfos.add(localNewestFeedInfo);
    cache_mapEx = new HashMap();
    cache_mapEx.put("", "");
  }
  
  public AIONewestFeedRsp() {}
  
  public AIONewestFeedRsp(long paramLong1, long paramLong2, ArrayList<NewestFeedInfo> paramArrayList, long paramLong3, Map<String, String> paramMap)
  {
    this.uOpuin = paramLong1;
    this.uTime = paramLong2;
    this.uFeedInfos = paramArrayList;
    this.uOpFlag = paramLong3;
    this.mapEx = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uOpuin = paramJceInputStream.read(this.uOpuin, 0, false);
    this.uTime = paramJceInputStream.read(this.uTime, 1, false);
    this.uFeedInfos = ((ArrayList)paramJceInputStream.read(cache_uFeedInfos, 2, false));
    this.uOpFlag = paramJceInputStream.read(this.uOpFlag, 3, false);
    this.mapEx = ((Map)paramJceInputStream.read(cache_mapEx, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uOpuin, 0);
    paramJceOutputStream.write(this.uTime, 1);
    if (this.uFeedInfos != null) {
      paramJceOutputStream.write(this.uFeedInfos, 2);
    }
    paramJceOutputStream.write(this.uOpFlag, 3);
    if (this.mapEx != null) {
      paramJceOutputStream.write(this.mapEx, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     NS_MOBILE_AIONewestFeed.AIONewestFeedRsp
 * JD-Core Version:    0.7.0.1
 */