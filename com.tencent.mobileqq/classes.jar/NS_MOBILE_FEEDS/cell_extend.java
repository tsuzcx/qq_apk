package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class cell_extend
  extends JceStruct
{
  static Map<String, String> cache_mapEx = new HashMap();
  public Map<String, String> mapEx;
  
  static
  {
    cache_mapEx.put("", "");
  }
  
  public cell_extend() {}
  
  public cell_extend(Map<String, String> paramMap)
  {
    this.mapEx = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.mapEx = ((Map)paramJceInputStream.read(cache_mapEx, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.mapEx != null) {
      paramJceOutputStream.write(this.mapEx, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_extend
 * JD-Core Version:    0.7.0.1
 */