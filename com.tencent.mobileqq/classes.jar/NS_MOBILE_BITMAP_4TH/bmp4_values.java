package NS_MOBILE_BITMAP_4TH;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class bmp4_values
  extends JceStruct
{
  static Map<String, Long> cache_map_kv = new HashMap();
  public Map<String, Long> map_kv;
  
  static
  {
    cache_map_kv.put("", Long.valueOf(0L));
  }
  
  public bmp4_values() {}
  
  public bmp4_values(Map<String, Long> paramMap)
  {
    this.map_kv = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.map_kv = ((Map)paramJceInputStream.read(cache_map_kv, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.map_kv != null) {
      paramJceOutputStream.write(this.map_kv, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_BITMAP_4TH.bmp4_values
 * JD-Core Version:    0.7.0.1
 */