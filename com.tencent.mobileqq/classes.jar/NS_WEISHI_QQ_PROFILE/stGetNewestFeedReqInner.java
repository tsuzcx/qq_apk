package NS_WEISHI_QQ_PROFILE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class stGetNewestFeedReqInner
  extends JceStruct
{
  static Map<String, String> cache_mapExtern = new HashMap();
  public int cache_update_time = 0;
  public Map<String, String> mapExtern = null;
  public long uin = 0L;
  
  static
  {
    cache_mapExtern.put("", "");
  }
  
  public stGetNewestFeedReqInner() {}
  
  public stGetNewestFeedReqInner(long paramLong, int paramInt, Map<String, String> paramMap)
  {
    this.uin = paramLong;
    this.cache_update_time = paramInt;
    this.mapExtern = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.cache_update_time = paramJceInputStream.read(this.cache_update_time, 1, false);
    this.mapExtern = ((Map)paramJceInputStream.read(cache_mapExtern, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.cache_update_time, 1);
    if (this.mapExtern != null) {
      paramJceOutputStream.write(this.mapExtern, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_WEISHI_QQ_PROFILE.stGetNewestFeedReqInner
 * JD-Core Version:    0.7.0.1
 */