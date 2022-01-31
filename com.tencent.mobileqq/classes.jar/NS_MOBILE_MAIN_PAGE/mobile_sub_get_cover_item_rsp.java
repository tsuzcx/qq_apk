package NS_MOBILE_MAIN_PAGE;

import NS_MOBILE_COMM.yellow_info;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_sub_get_cover_item_rsp
  extends JceStruct
{
  static CoverItem cache_item;
  static yellow_info cache_yellowInfo;
  public CoverItem item;
  public yellow_info yellowInfo;
  
  public mobile_sub_get_cover_item_rsp() {}
  
  public mobile_sub_get_cover_item_rsp(CoverItem paramCoverItem, yellow_info paramyellow_info)
  {
    this.item = paramCoverItem;
    this.yellowInfo = paramyellow_info;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_item == null) {
      cache_item = new CoverItem();
    }
    this.item = ((CoverItem)paramJceInputStream.read(cache_item, 0, false));
    if (cache_yellowInfo == null) {
      cache_yellowInfo = new yellow_info();
    }
    this.yellowInfo = ((yellow_info)paramJceInputStream.read(cache_yellowInfo, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.item != null) {
      paramJceOutputStream.write(this.item, 0);
    }
    if (this.yellowInfo != null) {
      paramJceOutputStream.write(this.yellowInfo, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_item_rsp
 * JD-Core Version:    0.7.0.1
 */