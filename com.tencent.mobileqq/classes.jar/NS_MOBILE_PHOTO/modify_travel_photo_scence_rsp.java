package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class modify_travel_photo_scence_rsp
  extends JceStruct
{
  static Map cache_photo_result;
  static Map cache_poi_result;
  static Map cache_time_range = new HashMap();
  public Map photo_result;
  public Map poi_result;
  public String poiid = "";
  public Map time_range;
  
  static
  {
    cache_time_range.put(Long.valueOf(0L), Long.valueOf(0L));
    cache_poi_result = new HashMap();
    cache_poi_result.put("", Integer.valueOf(0));
    cache_photo_result = new HashMap();
    cache_photo_result.put("", Integer.valueOf(0));
  }
  
  public modify_travel_photo_scence_rsp() {}
  
  public modify_travel_photo_scence_rsp(String paramString, Map paramMap1, Map paramMap2, Map paramMap3)
  {
    this.poiid = paramString;
    this.time_range = paramMap1;
    this.poi_result = paramMap2;
    this.photo_result = paramMap3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.poiid = paramJceInputStream.readString(0, true);
    this.time_range = ((Map)paramJceInputStream.read(cache_time_range, 1, false));
    this.poi_result = ((Map)paramJceInputStream.read(cache_poi_result, 2, false));
    this.photo_result = ((Map)paramJceInputStream.read(cache_photo_result, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.poiid, 0);
    if (this.time_range != null) {
      paramJceOutputStream.write(this.time_range, 1);
    }
    if (this.poi_result != null) {
      paramJceOutputStream.write(this.poi_result, 2);
    }
    if (this.photo_result != null) {
      paramJceOutputStream.write(this.photo_result, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_PHOTO.modify_travel_photo_scence_rsp
 * JD-Core Version:    0.7.0.1
 */