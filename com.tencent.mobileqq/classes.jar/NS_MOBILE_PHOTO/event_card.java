package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class event_card
  extends JceStruct
{
  static Map<String, String> cache_ext;
  static ArrayList<event_photo> cache_photos = new ArrayList();
  static int cache_type;
  public String cardid = "";
  public String desc = "";
  public Map<String, String> ext = null;
  public ArrayList<event_photo> photos = null;
  public int status = 0;
  public int type = 0;
  
  static
  {
    event_photo localevent_photo = new event_photo();
    cache_photos.add(localevent_photo);
    cache_type = 0;
    cache_ext = new HashMap();
    cache_ext.put("", "");
  }
  
  public event_card() {}
  
  public event_card(String paramString1, ArrayList<event_photo> paramArrayList, int paramInt1, int paramInt2, String paramString2, Map<String, String> paramMap)
  {
    this.cardid = paramString1;
    this.photos = paramArrayList;
    this.status = paramInt1;
    this.type = paramInt2;
    this.desc = paramString2;
    this.ext = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cardid = paramJceInputStream.readString(0, true);
    this.photos = ((ArrayList)paramJceInputStream.read(cache_photos, 1, true));
    this.status = paramJceInputStream.read(this.status, 2, true);
    this.type = paramJceInputStream.read(this.type, 3, false);
    this.desc = paramJceInputStream.readString(4, false);
    this.ext = ((Map)paramJceInputStream.read(cache_ext, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cardid, 0);
    paramJceOutputStream.write(this.photos, 1);
    paramJceOutputStream.write(this.status, 2);
    paramJceOutputStream.write(this.type, 3);
    Object localObject = this.desc;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.ext;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.event_card
 * JD-Core Version:    0.7.0.1
 */