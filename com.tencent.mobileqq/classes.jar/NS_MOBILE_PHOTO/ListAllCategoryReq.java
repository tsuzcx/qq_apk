package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class ListAllCategoryReq
  extends JceStruct
{
  static Map<Integer, ListAllCategoryReqItem> cache_req_item_map = new HashMap();
  public long host;
  public Map<Integer, ListAllCategoryReqItem> req_item_map;
  
  static
  {
    ListAllCategoryReqItem localListAllCategoryReqItem = new ListAllCategoryReqItem();
    cache_req_item_map.put(Integer.valueOf(0), localListAllCategoryReqItem);
  }
  
  public ListAllCategoryReq() {}
  
  public ListAllCategoryReq(long paramLong, Map<Integer, ListAllCategoryReqItem> paramMap)
  {
    this.host = paramLong;
    this.req_item_map = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.host = paramJceInputStream.read(this.host, 0, false);
    this.req_item_map = ((Map)paramJceInputStream.read(cache_req_item_map, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.host, 0);
    if (this.req_item_map != null) {
      paramJceOutputStream.write(this.req_item_map, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.ListAllCategoryReq
 * JD-Core Version:    0.7.0.1
 */