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
  public Map<String, String> mapInfo;
  
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
    if (this.mapInfo != null) {
      paramJceOutputStream.write(this.mapInfo, 0);
    }
    if (this.attachInfo != null) {
      paramJceOutputStream.write(this.attachInfo, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_KING_PUBLIC.StCommonExt
 * JD-Core Version:    0.7.0.1
 */