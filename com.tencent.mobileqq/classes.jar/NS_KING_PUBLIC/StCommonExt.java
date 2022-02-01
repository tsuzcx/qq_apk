package NS_KING_PUBLIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class StCommonExt
  extends JceStruct
{
  static Map<String, String> cache_mapInfo = new HashMap();
  public String attachInfo = "";
  public Map<String, String> mapInfo = null;
  
  static
  {
    cache_mapInfo.put("", "");
  }
  
  public StCommonExt() {}
  
  public StCommonExt(Map<String, String> paramMap, String paramString)
  {
    this.mapInfo = paramMap;
    this.attachInfo = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.mapInfo = ((Map)paramJceInputStream.read(cache_mapInfo, 0, false));
    this.attachInfo = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.mapInfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 0);
    }
    localObject = this.attachInfo;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_KING_PUBLIC.StCommonExt
 * JD-Core Version:    0.7.0.1
 */