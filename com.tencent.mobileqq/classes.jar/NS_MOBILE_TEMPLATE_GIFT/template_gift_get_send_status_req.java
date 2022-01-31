package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class template_gift_get_send_status_req
  extends JceStruct
{
  static ArrayList cache_birth_friend_list = new ArrayList();
  static Map cache_mapExt;
  public ArrayList birth_friend_list;
  public Map mapExt;
  public long uin;
  
  static
  {
    cache_birth_friend_list.add(Long.valueOf(0L));
    cache_mapExt = new HashMap();
    cache_mapExt.put("", "");
  }
  
  public template_gift_get_send_status_req() {}
  
  public template_gift_get_send_status_req(long paramLong, ArrayList paramArrayList, Map paramMap)
  {
    this.uin = paramLong;
    this.birth_friend_list = paramArrayList;
    this.mapExt = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.birth_friend_list = ((ArrayList)paramJceInputStream.read(cache_birth_friend_list, 1, false));
    this.mapExt = ((Map)paramJceInputStream.read(cache_mapExt, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.birth_friend_list != null) {
      paramJceOutputStream.write(this.birth_friend_list, 1);
    }
    if (this.mapExt != null) {
      paramJceOutputStream.write(this.mapExt, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_TEMPLATE_GIFT.template_gift_get_send_status_req
 * JD-Core Version:    0.7.0.1
 */