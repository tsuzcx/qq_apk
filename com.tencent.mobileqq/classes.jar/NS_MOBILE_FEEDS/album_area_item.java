package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class album_area_item
  extends JceStruct
{
  static stPoi cache_poi_info = new stPoi();
  public String description = "";
  public long end_shoot_time = 0L;
  public long is_userconfirmed = 0L;
  public long photo_num = 0L;
  public stPoi poi_info = null;
  public long poi_photo_num = 0L;
  public String scenery_name = "";
  public long start_shoot_time = 0L;
  
  public album_area_item() {}
  
  public album_area_item(long paramLong1, long paramLong2, long paramLong3, long paramLong4, stPoi paramstPoi, String paramString1, String paramString2, long paramLong5)
  {
    this.photo_num = paramLong1;
    this.poi_photo_num = paramLong2;
    this.start_shoot_time = paramLong3;
    this.end_shoot_time = paramLong4;
    this.poi_info = paramstPoi;
    this.description = paramString1;
    this.scenery_name = paramString2;
    this.is_userconfirmed = paramLong5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.photo_num = paramJceInputStream.read(this.photo_num, 0, false);
    this.poi_photo_num = paramJceInputStream.read(this.poi_photo_num, 1, false);
    this.start_shoot_time = paramJceInputStream.read(this.start_shoot_time, 2, false);
    this.end_shoot_time = paramJceInputStream.read(this.end_shoot_time, 3, false);
    this.poi_info = ((stPoi)paramJceInputStream.read(cache_poi_info, 4, false));
    this.description = paramJceInputStream.readString(5, false);
    this.scenery_name = paramJceInputStream.readString(6, false);
    this.is_userconfirmed = paramJceInputStream.read(this.is_userconfirmed, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.photo_num, 0);
    paramJceOutputStream.write(this.poi_photo_num, 1);
    paramJceOutputStream.write(this.start_shoot_time, 2);
    paramJceOutputStream.write(this.end_shoot_time, 3);
    Object localObject = this.poi_info;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 4);
    }
    localObject = this.description;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.scenery_name;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    paramJceOutputStream.write(this.is_userconfirmed, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.album_area_item
 * JD-Core Version:    0.7.0.1
 */