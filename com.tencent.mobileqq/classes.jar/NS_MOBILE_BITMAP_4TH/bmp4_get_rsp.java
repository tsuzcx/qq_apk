package NS_MOBILE_BITMAP_4TH;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class bmp4_get_rsp
  extends JceStruct
{
  static Map<Long, bmp4_values> cache_map_rsp = new HashMap();
  public String errmsg = "";
  public Map<Long, bmp4_values> map_rsp = null;
  public int retCode = 0;
  
  static
  {
    bmp4_values localbmp4_values = new bmp4_values();
    cache_map_rsp.put(Long.valueOf(0L), localbmp4_values);
  }
  
  public bmp4_get_rsp() {}
  
  public bmp4_get_rsp(int paramInt, String paramString, Map<Long, bmp4_values> paramMap)
  {
    this.retCode = paramInt;
    this.errmsg = paramString;
    this.map_rsp = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.retCode = paramJceInputStream.read(this.retCode, 0, false);
    this.errmsg = paramJceInputStream.readString(1, false);
    this.map_rsp = ((Map)paramJceInputStream.read(cache_map_rsp, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.retCode, 0);
    Object localObject = this.errmsg;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.map_rsp;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_BITMAP_4TH.bmp4_get_rsp
 * JD-Core Version:    0.7.0.1
 */