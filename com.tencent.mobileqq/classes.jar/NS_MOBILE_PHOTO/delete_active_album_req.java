package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class delete_active_album_req
  extends JceStruct
{
  static Map cache_map_params = new HashMap();
  public Map map_params;
  public String mgz_id = "";
  public long uin;
  
  static
  {
    cache_map_params.put("", "");
  }
  
  public delete_active_album_req() {}
  
  public delete_active_album_req(long paramLong, String paramString, Map paramMap)
  {
    this.uin = paramLong;
    this.mgz_id = paramString;
    this.map_params = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.mgz_id = paramJceInputStream.readString(1, true);
    this.map_params = ((Map)paramJceInputStream.read(cache_map_params, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.mgz_id, 1);
    if (this.map_params != null) {
      paramJceOutputStream.write(this.map_params, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_PHOTO.delete_active_album_req
 * JD-Core Version:    0.7.0.1
 */