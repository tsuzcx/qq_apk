package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class CKV_LikeListInfo
  extends JceStruct
{
  static Map<Long, CKV_LikeInfo> cache_mLikeList = new HashMap();
  public long iLstCheckTime = 0L;
  public Map<Long, CKV_LikeInfo> mLikeList = null;
  
  static
  {
    CKV_LikeInfo localCKV_LikeInfo = new CKV_LikeInfo();
    cache_mLikeList.put(Long.valueOf(0L), localCKV_LikeInfo);
  }
  
  public CKV_LikeListInfo() {}
  
  public CKV_LikeListInfo(Map<Long, CKV_LikeInfo> paramMap, long paramLong)
  {
    this.mLikeList = paramMap;
    this.iLstCheckTime = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.mLikeList = ((Map)paramJceInputStream.read(cache_mLikeList, 0, false));
    this.iLstCheckTime = paramJceInputStream.read(this.iLstCheckTime, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Map localMap = this.mLikeList;
    if (localMap != null) {
      paramJceOutputStream.write(localMap, 0);
    }
    paramJceOutputStream.write(this.iLstCheckTime, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     VIP.CKV_LikeListInfo
 * JD-Core Version:    0.7.0.1
 */