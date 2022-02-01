package NS_MOBILE_QQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class RES_ITEM_COVER
  extends JceStruct
{
  static Map<String, String> cache_extendinfo = new HashMap();
  public Map<String, String> extendinfo = null;
  public String strJumpQzone = "";
  
  static
  {
    cache_extendinfo.put("", "");
  }
  
  public RES_ITEM_COVER() {}
  
  public RES_ITEM_COVER(String paramString, Map<String, String> paramMap)
  {
    this.strJumpQzone = paramString;
    this.extendinfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strJumpQzone = paramJceInputStream.readString(0, false);
    this.extendinfo = ((Map)paramJceInputStream.read(cache_extendinfo, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.strJumpQzone;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.extendinfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_QQ.RES_ITEM_COVER
 * JD-Core Version:    0.7.0.1
 */