package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class QzmallFeedDecoGetRsp
  extends JceStruct
{
  static Map<Long, byte[]> cache_mapRsp = new HashMap();
  public Map<Long, byte[]> mapRsp = null;
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    ((byte[])arrayOfByte)[0] = 0;
    cache_mapRsp.put(Long.valueOf(0L), arrayOfByte);
  }
  
  public QzmallFeedDecoGetRsp() {}
  
  public QzmallFeedDecoGetRsp(Map<Long, byte[]> paramMap)
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
 * Qualified Name:     NS_QMALL_COVER.QzmallFeedDecoGetRsp
 * JD-Core Version:    0.7.0.1
 */