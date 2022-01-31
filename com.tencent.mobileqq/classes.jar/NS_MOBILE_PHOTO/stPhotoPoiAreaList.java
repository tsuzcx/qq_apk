package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class stPhotoPoiAreaList
  extends JceStruct
  implements Cloneable
{
  static stPhotoPoiArea cache_album_poi;
  static ArrayList<stPhotoPoiArea> cache_poi_areas;
  public stPhotoPoiArea album_poi;
  public String end_description = "";
  public ArrayList<stPhotoPoiArea> poi_areas;
  public String start_description = "";
  public long start_shoot_time;
  
  public stPhotoPoiAreaList() {}
  
  public stPhotoPoiAreaList(stPhotoPoiArea paramstPhotoPoiArea, String paramString1, String paramString2, ArrayList<stPhotoPoiArea> paramArrayList, long paramLong)
  {
    this.album_poi = paramstPhotoPoiArea;
    this.start_description = paramString1;
    this.end_description = paramString2;
    this.poi_areas = paramArrayList;
    this.start_shoot_time = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_album_poi == null) {
      cache_album_poi = new stPhotoPoiArea();
    }
    this.album_poi = ((stPhotoPoiArea)paramJceInputStream.read(cache_album_poi, 0, true));
    this.start_description = paramJceInputStream.readString(1, true);
    this.end_description = paramJceInputStream.readString(2, true);
    if (cache_poi_areas == null)
    {
      cache_poi_areas = new ArrayList();
      stPhotoPoiArea localstPhotoPoiArea = new stPhotoPoiArea();
      cache_poi_areas.add(localstPhotoPoiArea);
    }
    this.poi_areas = ((ArrayList)paramJceInputStream.read(cache_poi_areas, 3, true));
    this.start_shoot_time = paramJceInputStream.read(this.start_shoot_time, 4, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.album_poi, 0);
    paramJceOutputStream.write(this.start_description, 1);
    paramJceOutputStream.write(this.end_description, 2);
    paramJceOutputStream.write(this.poi_areas, 3);
    paramJceOutputStream.write(this.start_shoot_time, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.stPhotoPoiAreaList
 * JD-Core Version:    0.7.0.1
 */