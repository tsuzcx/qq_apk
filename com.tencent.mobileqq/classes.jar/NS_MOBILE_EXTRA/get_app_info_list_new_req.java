package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class get_app_info_list_new_req
  extends JceStruct
{
  static Map<Integer, Integer> cache_current_serial_map;
  public int current_list_serial;
  public Map<Integer, Integer> current_serial_map;
  
  public get_app_info_list_new_req() {}
  
  public get_app_info_list_new_req(Map<Integer, Integer> paramMap, int paramInt)
  {
    this.current_serial_map = paramMap;
    this.current_list_serial = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_current_serial_map == null)
    {
      cache_current_serial_map = new HashMap();
      cache_current_serial_map.put(Integer.valueOf(0), Integer.valueOf(0));
    }
    this.current_serial_map = ((Map)paramJceInputStream.read(cache_current_serial_map, 0, false));
    this.current_list_serial = paramJceInputStream.read(this.current_list_serial, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.current_serial_map != null) {
      paramJceOutputStream.write(this.current_serial_map, 0);
    }
    paramJceOutputStream.write(this.current_list_serial, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_EXTRA.get_app_info_list_new_req
 * JD-Core Version:    0.7.0.1
 */