package NS_MOBILE_QQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class RES_ITEM_COVER
  extends JceStruct
{
  static Map cache_extendinfo = new HashMap();
  public Map extendinfo;
  public String strJumpQzone = "";
  
  static
  {
    cache_extendinfo.put("", "");
  }
  
  public RES_ITEM_COVER() {}
  
  public RES_ITEM_COVER(String paramString, Map paramMap)
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
    if (this.strJumpQzone != null) {
      paramJceOutputStream.write(this.strJumpQzone, 0);
    }
    if (this.extendinfo != null) {
      paramJceOutputStream.write(this.extendinfo, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_QQ.RES_ITEM_COVER
 * JD-Core Version:    0.7.0.1
 */