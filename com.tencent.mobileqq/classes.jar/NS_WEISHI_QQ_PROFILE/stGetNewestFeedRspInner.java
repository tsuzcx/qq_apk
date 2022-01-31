package NS_WEISHI_QQ_PROFILE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class stGetNewestFeedRspInner
  extends JceStruct
{
  static Map<String, String> cache_mapItemInfo;
  static stRspComm cache_rspComm = new stRspComm();
  public Map<String, String> mapItemInfo;
  public stRspComm rspComm;
  
  static
  {
    cache_mapItemInfo = new HashMap();
    cache_mapItemInfo.put("", "");
  }
  
  public stGetNewestFeedRspInner() {}
  
  public stGetNewestFeedRspInner(stRspComm paramstRspComm, Map<String, String> paramMap)
  {
    this.rspComm = paramstRspComm;
    this.mapItemInfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.rspComm = ((stRspComm)paramJceInputStream.read(cache_rspComm, 0, false));
    this.mapItemInfo = ((Map)paramJceInputStream.read(cache_mapItemInfo, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.rspComm != null) {
      paramJceOutputStream.write(this.rspComm, 0);
    }
    if (this.mapItemInfo != null) {
      paramJceOutputStream.write(this.mapItemInfo, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_WEISHI_QQ_PROFILE.stGetNewestFeedRspInner
 * JD-Core Version:    0.7.0.1
 */