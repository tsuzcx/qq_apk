package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class template_gift_get_send_status_rsp
  extends JceStruct
{
  static Map<String, String> cache_mapExt;
  static Map<Long, Integer> cache_map_birth_friend_list_state = new HashMap();
  public Map<String, String> mapExt = null;
  public Map<Long, Integer> map_birth_friend_list_state = null;
  public long uin = 0L;
  
  static
  {
    cache_map_birth_friend_list_state.put(Long.valueOf(0L), Integer.valueOf(0));
    cache_mapExt = new HashMap();
    cache_mapExt.put("", "");
  }
  
  public template_gift_get_send_status_rsp() {}
  
  public template_gift_get_send_status_rsp(long paramLong, Map<Long, Integer> paramMap, Map<String, String> paramMap1)
  {
    this.uin = paramLong;
    this.map_birth_friend_list_state = paramMap;
    this.mapExt = paramMap1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.map_birth_friend_list_state = ((Map)paramJceInputStream.read(cache_map_birth_friend_list_state, 1, false));
    this.mapExt = ((Map)paramJceInputStream.read(cache_mapExt, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    Map localMap = this.map_birth_friend_list_state;
    if (localMap != null) {
      paramJceOutputStream.write(localMap, 1);
    }
    localMap = this.mapExt;
    if (localMap != null) {
      paramJceOutputStream.write(localMap, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_TEMPLATE_GIFT.template_gift_get_send_status_rsp
 * JD-Core Version:    0.7.0.1
 */