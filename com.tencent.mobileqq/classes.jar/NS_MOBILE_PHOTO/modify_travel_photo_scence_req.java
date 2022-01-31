package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class modify_travel_photo_scence_req
  extends JceStruct
{
  static int cache_opetype = 0;
  static Map cache_picid_time_list;
  static stPhotoPoiArea cache_poi = new stPhotoPoiArea();
  static ArrayList cache_scence = new ArrayList();
  public String albumid = "";
  public int opetype;
  public Map picid_time_list;
  public stPhotoPoiArea poi;
  public long poi_area_start_time;
  public ArrayList scence;
  
  static
  {
    Object localObject = new modify_travel_photo_scence();
    cache_scence.add(localObject);
    cache_picid_time_list = new HashMap();
    localObject = new EditPhoto();
    cache_picid_time_list.put("", localObject);
  }
  
  public modify_travel_photo_scence_req() {}
  
  public modify_travel_photo_scence_req(String paramString, int paramInt, stPhotoPoiArea paramstPhotoPoiArea, long paramLong, ArrayList paramArrayList, Map paramMap)
  {
    this.albumid = paramString;
    this.opetype = paramInt;
    this.poi = paramstPhotoPoiArea;
    this.poi_area_start_time = paramLong;
    this.scence = paramArrayList;
    this.picid_time_list = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.albumid = paramJceInputStream.readString(0, true);
    this.opetype = paramJceInputStream.read(this.opetype, 1, true);
    this.poi = ((stPhotoPoiArea)paramJceInputStream.read(cache_poi, 2, true));
    this.poi_area_start_time = paramJceInputStream.read(this.poi_area_start_time, 3, false);
    this.scence = ((ArrayList)paramJceInputStream.read(cache_scence, 4, false));
    this.picid_time_list = ((Map)paramJceInputStream.read(cache_picid_time_list, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.albumid, 0);
    paramJceOutputStream.write(this.opetype, 1);
    paramJceOutputStream.write(this.poi, 2);
    paramJceOutputStream.write(this.poi_area_start_time, 3);
    if (this.scence != null) {
      paramJceOutputStream.write(this.scence, 4);
    }
    if (this.picid_time_list != null) {
      paramJceOutputStream.write(this.picid_time_list, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.modify_travel_photo_scence_req
 * JD-Core Version:    0.7.0.1
 */