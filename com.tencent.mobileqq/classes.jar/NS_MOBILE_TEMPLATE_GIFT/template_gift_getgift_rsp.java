package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class template_gift_getgift_rsp
  extends JceStruct
{
  static s_gift_item cache_common_gift;
  static template_gift_item cache_diy_gift;
  public s_gift_item common_gift;
  public template_gift_item diy_gift;
  public int is_diy;
  
  public template_gift_getgift_rsp() {}
  
  public template_gift_getgift_rsp(int paramInt, s_gift_item params_gift_item, template_gift_item paramtemplate_gift_item)
  {
    this.is_diy = paramInt;
    this.common_gift = params_gift_item;
    this.diy_gift = paramtemplate_gift_item;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.is_diy = paramJceInputStream.read(this.is_diy, 0, true);
    if (cache_common_gift == null) {
      cache_common_gift = new s_gift_item();
    }
    this.common_gift = ((s_gift_item)paramJceInputStream.read(cache_common_gift, 1, false));
    if (cache_diy_gift == null) {
      cache_diy_gift = new template_gift_item();
    }
    this.diy_gift = ((template_gift_item)paramJceInputStream.read(cache_diy_gift, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.is_diy, 0);
    Object localObject = this.common_gift;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    localObject = this.diy_gift;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_TEMPLATE_GIFT.template_gift_getgift_rsp
 * JD-Core Version:    0.7.0.1
 */