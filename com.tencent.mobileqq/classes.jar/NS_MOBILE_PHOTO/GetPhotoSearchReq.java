package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class GetPhotoSearchReq
  extends JceStruct
{
  static Map<Integer, PhotoSearchBoxChosenItem> cache_items;
  static int cache_req_type = 0;
  static ArrayList<Integer> cache_types = new ArrayList();
  public String albumid = "";
  public String attach_info = "";
  public Map<Integer, PhotoSearchBoxChosenItem> items;
  public int req_type = 0;
  public ArrayList<Integer> types;
  public long uin;
  
  static
  {
    cache_types.add(Integer.valueOf(0));
    cache_items = new HashMap();
    PhotoSearchBoxChosenItem localPhotoSearchBoxChosenItem = new PhotoSearchBoxChosenItem();
    cache_items.put(Integer.valueOf(0), localPhotoSearchBoxChosenItem);
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
    if (this.albumid != null) {
      paramJceOutputStream.write(this.albumid, 1);
    }
    paramJceOutputStream.write(this.req_type, 2);
    if (this.types != null) {
      paramJceOutputStream.write(this.types, 3);
    }
    if (this.items != null) {
      paramJceOutputStream.write(this.items, 4);
    }
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.GetPhotoSearchReq
 * JD-Core Version:    0.7.0.1
 */