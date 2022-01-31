package NS_MOBILE_MAIN_PAGE;

import NS_MOBILE_TEMPLATE_GIFT.template_gift_getgift_rsp;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_gift_adv
  extends JceStruct
{
  static template_gift_getgift_rsp cache_adv_gift_info;
  static int cache_adv_type;
  public template_gift_getgift_rsp adv_gift_info;
  public int adv_section_id;
  public int adv_type;
  public String img_url = "";
  
  public s_gift_adv() {}
  
  public s_gift_adv(String paramString, int paramInt1, template_gift_getgift_rsp paramtemplate_gift_getgift_rsp, int paramInt2)
  {
    this.img_url = paramString;
    this.adv_type = paramInt1;
    this.adv_gift_info = paramtemplate_gift_getgift_rsp;
    this.adv_section_id = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.img_url = paramJceInputStream.readString(0, true);
    this.adv_type = paramJceInputStream.read(this.adv_type, 1, true);
    if (cache_adv_gift_info == null) {
      cache_adv_gift_info = new template_gift_getgift_rsp();
    }
    this.adv_gift_info = ((template_gift_getgift_rsp)paramJceInputStream.read(cache_adv_gift_info, 2, true));
    this.adv_section_id = paramJceInputStream.read(this.adv_section_id, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.img_url, 0);
    paramJceOutputStream.write(this.adv_type, 1);
    paramJceOutputStream.write(this.adv_gift_info, 2);
    paramJceOutputStream.write(this.adv_section_id, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.s_gift_adv
 * JD-Core Version:    0.7.0.1
 */