package NS_WEISHI_QQ_PROFILE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class stGetNewestFeedRsp
  extends JceStruct
{
  static Map<Long, stGetNewestFeedRspInner> cache_mapRsp = new HashMap();
  public Map<Long, stGetNewestFeedRspInner> mapRsp = null;
  
  static
  {
    stGetNewestFeedRspInner localstGetNewestFeedRspInner = new stGetNewestFeedRspInner();
    cache_mapRsp.put(Long.valueOf(0L), localstGetNewestFeedRspInner);
  }
  
  public stGetNewestFeedRsp() {}
  
  public stGetNewestFeedRsp(Map<Long, stGetNewestFeedRspInner> paramMap)
  {
    this.mapRsp = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.mapRsp = ((Map)paramJceInputStream.read(cache_mapRsp, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Map localMap = this.mapRsp;
    if (localMap != null) {
      paramJceOutputStream.write(localMap, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_WEISHI_QQ_PROFILE.stGetNewestFeedRsp
 * JD-Core Version:    0.7.0.1
 */