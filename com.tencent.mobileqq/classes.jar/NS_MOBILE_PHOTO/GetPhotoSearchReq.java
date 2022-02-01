package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class GetPhotoSearchReq
  extends JceStruct
{
  static Map<Integer, PhotoSearchBoxChosenItem> cache_items;
  static int cache_req_type;
  static ArrayList<Integer> cache_types = new ArrayList();
  public String albumid = "";
  public String attach_info = "";
  public Map<Integer, PhotoSearchBoxChosenItem> items = null;
  public int req_type = 0;
  public ArrayList<Integer> types = null;
  public long uin = 0L;
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    cache_types.add(localInteger);
    cache_items = new HashMap();
    PhotoSearchBoxChosenItem localPhotoSearchBoxChosenItem = new PhotoSearchBoxChosenItem();
    cache_items.put(localInteger, localPhotoSearchBoxChosenItem);
  }
  
  public GetPhotoSearchReq() {}
  
  public GetPhotoSearchReq(long paramLong, String paramString1, int paramInt, ArrayList<Integer> paramArrayList, Map<Integer, PhotoSearchBoxChosenItem> paramMap, String paramString2)
  {
    this.uin = paramLong;
    this.albumid = paramString1;
    this.req_type = paramInt;
    this.types = paramArrayList;
    this.items = paramMap;
    this.attach_info = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.albumid = paramJceInputStream.readString(1, false);
    this.req_type = paramJceInputStream.read(this.req_type, 2, false);
    this.types = ((ArrayList)paramJceInputStream.read(cache_types, 3, false));
    this.items = ((Map)paramJceInputStream.read(cache_items, 4, false));
    this.attach_info = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    Object localObject = this.albumid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    paramJceOutputStream.write(this.req_type, 2);
    localObject = this.types;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 3);
    }
    localObject = this.items;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 4);
    }
    localObject = this.attach_info;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.GetPhotoSearchReq
 * JD-Core Version:    0.7.0.1
 */