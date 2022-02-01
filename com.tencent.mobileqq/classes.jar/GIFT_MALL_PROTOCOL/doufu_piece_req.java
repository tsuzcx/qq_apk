package GIFT_MALL_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class doufu_piece_req
  extends JceStruct
{
  static Map<String, String> cache_mapExt = new HashMap();
  public Map<String, String> mapExt = null;
  public long uin = 0L;
  
  static
  {
    cache_mapExt.put("", "");
  }
  
  public doufu_piece_req() {}
  
  public doufu_piece_req(long paramLong, Map<String, String> paramMap)
  {
    this.uin = paramLong;
    this.mapExt = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.mapExt = ((Map)paramJceInputStream.read(cache_mapExt, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    Map localMap = this.mapExt;
    if (localMap != null) {
      paramJceOutputStream.write(localMap, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     GIFT_MALL_PROTOCOL.doufu_piece_req
 * JD-Core Version:    0.7.0.1
 */