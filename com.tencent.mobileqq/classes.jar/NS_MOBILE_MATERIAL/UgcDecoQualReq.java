package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class UgcDecoQualReq
  extends JceStruct
{
  static Map<Integer, Integer> cache_mapItemId = new HashMap();
  public Map<Integer, Integer> mapItemId = null;
  
  static
  {
    cache_mapItemId.put(Integer.valueOf(0), Integer.valueOf(0));
  }
  
  public UgcDecoQualReq() {}
  
  public UgcDecoQualReq(Map<Integer, Integer> paramMap)
  {
    this.mapItemId = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.mapItemId = ((Map)paramJceInputStream.read(cache_mapItemId, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.mapItemId != null) {
      paramJceOutputStream.write(this.mapItemId, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.UgcDecoQualReq
 * JD-Core Version:    0.7.0.1
 */