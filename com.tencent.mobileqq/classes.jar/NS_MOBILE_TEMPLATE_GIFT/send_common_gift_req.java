package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class send_common_gift_req
  extends JceStruct
{
  static s_send_gift_item cache_giftItem = new s_send_gift_item();
  static Map<String, String> cache_mapExt = new HashMap();
  public s_send_gift_item giftItem;
  public Map<String, String> mapExt;
  
  static
  {
    cache_mapExt.put("", "");
  }
  
  public send_common_gift_req() {}
  
  public send_common_gift_req(s_send_gift_item params_send_gift_item, Map<String, String> paramMap)
  {
    this.giftItem = params_send_gift_item;
    this.mapExt = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.giftItem = ((s_send_gift_item)paramJceInputStream.read(cache_giftItem, 0, true));
    this.mapExt = ((Map)paramJceInputStream.read(cache_mapExt, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.giftItem, 0);
    if (this.mapExt != null) {
      paramJceOutputStream.write(this.mapExt, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_TEMPLATE_GIFT.send_common_gift_req
 * JD-Core Version:    0.7.0.1
 */