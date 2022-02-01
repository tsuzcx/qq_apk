package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class stGetMsgRedDotRsp
  extends JceStruct
{
  static Map<Integer, stMsgRedDotCount> cache_redDotCount = new HashMap();
  public Map<Integer, stMsgRedDotCount> redDotCount = null;
  
  static
  {
    stMsgRedDotCount localstMsgRedDotCount = new stMsgRedDotCount();
    cache_redDotCount.put(Integer.valueOf(0), localstMsgRedDotCount);
  }
  
  public stGetMsgRedDotRsp() {}
  
  public stGetMsgRedDotRsp(Map<Integer, stMsgRedDotCount> paramMap)
  {
    this.redDotCount = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.redDotCount = ((Map)paramJceInputStream.read(cache_redDotCount, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Map localMap = this.redDotCount;
    if (localMap != null) {
      paramJceOutputStream.write(localMap, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stGetMsgRedDotRsp
 * JD-Core Version:    0.7.0.1
 */