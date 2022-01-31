package WMDBClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class stGetPicUrlByKeysReq
  extends JceStruct
{
  static Map<String, String> cache_keys;
  public Map<String, String> keys = null;
  
  public stGetPicUrlByKeysReq() {}
  
  public stGetPicUrlByKeysReq(Map<String, String> paramMap)
  {
    this.keys = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_keys == null)
    {
      cache_keys = new HashMap();
      cache_keys.put("", "");
    }
    this.keys = ((Map)paramJceInputStream.read(cache_keys, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.keys, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     WMDBClientInterface.stGetPicUrlByKeysReq
 * JD-Core Version:    0.7.0.1
 */