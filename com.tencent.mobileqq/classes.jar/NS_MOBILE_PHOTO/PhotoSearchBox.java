package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class PhotoSearchBox
  extends JceStruct
{
  static Map<Integer, PhotoSearchBoxItem> cache_items;
  static int cache_status = 0;
  static ArrayList<Integer> cache_types = new ArrayList();
  public Map<Integer, PhotoSearchBoxItem> items = null;
  public int status = 1;
  public ArrayList<Integer> types = null;
  
  static
  {
    cache_types.add(Integer.valueOf(0));
    cache_items = new HashMap();
    PhotoSearchBoxItem localPhotoSearchBoxItem = new PhotoSearchBoxItem();
    cache_items.put(Integer.valueOf(0), localPhotoSearchBoxItem);
  }
  
  public PhotoSearchBox() {}
  
  public PhotoSearchBox(int paramInt, ArrayList<Integer> paramArrayList, Map<Integer, PhotoSearchBoxItem> paramMap)
  {
    this.status = paramInt;
    this.types = paramArrayList;
    this.items = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.status = paramJceInputStream.read(this.status, 0, false);
    this.types = ((ArrayList)paramJceInputStream.read(cache_types, 1, false));
    this.items = ((Map)paramJceInputStream.read(cache_items, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.status, 0);
    if (this.types != null) {
      paramJceOutputStream.write(this.types, 1);
    }
    if (this.items != null) {
      paramJceOutputStream.write(this.items, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.PhotoSearchBox
 * JD-Core Version:    0.7.0.1
 */