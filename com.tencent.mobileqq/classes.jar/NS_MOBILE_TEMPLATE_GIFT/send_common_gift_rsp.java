package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class send_common_gift_rsp
  extends JceStruct
{
  static ArrayList<send_gift_fail_item> cache_failList;
  public ArrayList<send_gift_fail_item> failList;
  public String giftUrl = "";
  
  public send_common_gift_rsp() {}
  
  public send_common_gift_rsp(ArrayList<send_gift_fail_item> paramArrayList, String paramString)
  {
    this.failList = paramArrayList;
    this.giftUrl = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_failList == null)
    {
      cache_failList = new ArrayList();
      send_gift_fail_item localsend_gift_fail_item = new send_gift_fail_item();
      cache_failList.add(localsend_gift_fail_item);
    }
    this.failList = ((ArrayList)paramJceInputStream.read(cache_failList, 0, false));
    this.giftUrl = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.failList;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 0);
    }
    localObject = this.giftUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_TEMPLATE_GIFT.send_common_gift_rsp
 * JD-Core Version:    0.7.0.1
 */