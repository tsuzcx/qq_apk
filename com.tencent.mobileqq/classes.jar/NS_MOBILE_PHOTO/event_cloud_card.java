package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class event_cloud_card
  extends JceStruct
{
  static Map<String, String> cache_ext;
  static ArrayList<event_cloud_photo> cache_photos = new ArrayList();
  static int cache_type;
  public String desc = "";
  public Map<String, String> ext;
  public ArrayList<event_cloud_photo> photos;
  public int type;
  
  static
  {
    event_cloud_photo localevent_cloud_photo = new event_cloud_photo();
    cache_photos.add(localevent_cloud_photo);
    cache_type = 0;
    cache_ext = new HashMap();
    cache_ext.put("", "");
  }
  
  public event_cloud_card() {}
  
  public event_cloud_card(ArrayList<event_cloud_photo> paramArrayList, int paramInt, String paramString, Map<String, String> paramMap)
  {
    this.photos = paramArrayList;
    this.type = paramInt;
    this.desc = paramString;
    this.ext = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.photos = ((ArrayList)paramJceInputStream.read(cache_photos, 0, true));
    this.type = paramJceInputStream.read(this.type, 1, false);
    this.desc = paramJceInputStream.readString(2, false);
    this.ext = ((Map)paramJceInputStream.read(cache_ext, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.photos, 0);
    paramJceOutputStream.write(this.type, 1);
    if (this.desc != null) {
      paramJceOutputStream.write(this.desc, 2);
    }
    if (this.ext != null) {
      paramJceOutputStream.write(this.ext, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.event_cloud_card
 * JD-Core Version:    0.7.0.1
 */