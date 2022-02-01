package NS_NEXTRADIO_QZONEBGMUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class BroadcastUrl
  extends JceStruct
{
  static Map<Byte, String> cache_mapBroadcastUrl = new HashMap();
  public Map<Byte, String> mapBroadcastUrl = null;
  
  static
  {
    cache_mapBroadcastUrl.put(Byte.valueOf((byte)0), "");
  }
  
  public BroadcastUrl() {}
  
  public BroadcastUrl(Map<Byte, String> paramMap)
  {
    this.mapBroadcastUrl = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.mapBroadcastUrl = ((Map)paramJceInputStream.read(cache_mapBroadcastUrl, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.mapBroadcastUrl != null) {
      paramJceOutputStream.write(this.mapBroadcastUrl, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_NEXTRADIO_QZONEBGMUSIC.BroadcastUrl
 * JD-Core Version:    0.7.0.1
 */