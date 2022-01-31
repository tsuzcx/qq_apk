package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class modify_travel_photo_scence
  extends JceStruct
{
  static int cache_opetype = 0;
  static stPhotoPoiArea cache_poi = new stPhotoPoiArea();
  public int opetype;
  public stPhotoPoiArea poi;
  public long poi_area_start_time;
  
  public modify_travel_photo_scence() {}
  
  public modify_travel_photo_scence(int paramInt, stPhotoPoiArea paramstPhotoPoiArea, long paramLong)
  {
    this.opetype = paramInt;
    this.poi = paramstPhotoPoiArea;
    this.poi_area_start_time = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.opetype = paramJceInputStream.read(this.opetype, 0, true);
    this.poi = ((stPhotoPoiArea)paramJceInputStream.read(cache_poi, 1, true));
    this.poi_area_start_time = paramJceInputStream.read(this.poi_area_start_time, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.opetype, 0);
    paramJceOutputStream.write(this.poi, 1);
    paramJceOutputStream.write(this.poi_area_start_time, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.modify_travel_photo_scence
 * JD-Core Version:    0.7.0.1
 */