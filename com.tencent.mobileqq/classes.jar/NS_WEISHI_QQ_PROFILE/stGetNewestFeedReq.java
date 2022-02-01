package NS_WEISHI_QQ_PROFILE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class stGetNewestFeedReq
  extends JceStruct
{
  static Map<Long, stGetNewestFeedReqInner> cache_mapReq = new HashMap();
  public Map<Long, stGetNewestFeedReqInner> mapReq = null;
  
  static
  {
    stGetNewestFeedReqInner localstGetNewestFeedReqInner = new stGetNewestFeedReqInner();
    cache_mapReq.put(Long.valueOf(0L), localstGetNewestFeedReqInner);
  }
  
  public stGetNewestFeedReq() {}
  
  public stGetNewestFeedReq(Map<Long, stGetNewestFeedReqInner> paramMap)
  {
    this.mapReq = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.mapReq = ((Map)paramJceInputStream.read(cache_mapReq, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Map localMap = this.mapReq;
    if (localMap != null) {
      paramJceOutputStream.write(localMap, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_WEISHI_QQ_PROFILE.stGetNewestFeedReq
 * JD-Core Version:    0.7.0.1
 */