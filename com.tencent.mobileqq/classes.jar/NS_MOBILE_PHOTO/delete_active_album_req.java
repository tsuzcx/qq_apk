package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class delete_active_album_req
  extends JceStruct
{
  static Map<String, String> cache_map_params = new HashMap();
  public Map<String, String> map_params = null;
  public String mgz_id = "";
  public long uin = 0L;
  
  static
  {
    cache_map_params.put("", "");
  }
  
  public delete_active_album_req() {}
  
  public delete_active_album_req(long paramLong, String paramString, Map<String, String> paramMap)
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
    Map localMap = this.map_params;
    if (localMap != null) {
      paramJceOutputStream.write(localMap, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.delete_active_album_req
 * JD-Core Version:    0.7.0.1
 */