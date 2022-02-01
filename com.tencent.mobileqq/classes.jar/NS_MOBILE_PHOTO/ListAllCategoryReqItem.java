package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ListAllCategoryReqItem
  extends JceStruct
{
  static CategoryPoiMap cache_poi_map_req = new CategoryPoiMap();
  public String page_str = "";
  public CategoryPoiMap poi_map_req = null;
  
  public ListAllCategoryReqItem() {}
  
  public ListAllCategoryReqItem(String paramString, CategoryPoiMap paramCategoryPoiMap)
  {
    this.page_str = paramString;
    this.poi_map_req = paramCategoryPoiMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.page_str = paramJceInputStream.readString(0, false);
    this.poi_map_req = ((CategoryPoiMap)paramJceInputStream.read(cache_poi_map_req, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.page_str;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.poi_map_req;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.ListAllCategoryReqItem
 * JD-Core Version:    0.7.0.1
 */