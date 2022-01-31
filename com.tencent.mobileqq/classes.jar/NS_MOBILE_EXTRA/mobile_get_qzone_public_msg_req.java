package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class mobile_get_qzone_public_msg_req
  extends JceStruct
{
  static Map<String, String> cache_map_ext = new HashMap();
  public Map<String, String> map_ext;
  public long uin;
  
  static
  {
    cache_map_ext.put("", "");
  }
  
  public mobile_get_qzone_public_msg_req() {}
  
  public mobile_get_qzone_public_msg_req(long paramLong, Map<String, String> paramMap)
  {
    this.uin = paramLong;
    this.map_ext = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.map_ext = ((Map)paramJceInputStream.read(cache_map_ext, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.map_ext != null) {
      paramJceOutputStream.write(this.map_ext, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_EXTRA.mobile_get_qzone_public_msg_req
 * JD-Core Version:    0.7.0.1
 */