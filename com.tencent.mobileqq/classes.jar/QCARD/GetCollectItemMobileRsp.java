package QCARD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetCollectItemMobileRsp
  extends JceStruct
{
  static ArrayList<CouponMobileFolder> cache_folder_list;
  static CouponMobileItem cache_item = new CouponMobileItem();
  public ArrayList<CouponMobileFolder> folder_list;
  public CouponMobileItem item;
  public String next_card_uid = "";
  public int ret_code = -1;
  public long sequence;
  
  static
  {
    cache_folder_list = new ArrayList();
    CouponMobileFolder localCouponMobileFolder = new CouponMobileFolder();
    cache_folder_list.add(localCouponMobileFolder);
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret_code = paramJceInputStream.read(this.ret_code, 0, true);
    this.item = ((CouponMobileItem)paramJceInputStream.read(cache_item, 1, true));
    this.next_card_uid = paramJceInputStream.readString(2, true);
    this.sequence = paramJceInputStream.read(this.sequence, 3, true);
    this.folder_list = ((ArrayList)paramJceInputStream.read(cache_folder_list, 4, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret_code, 0);
    paramJceOutputStream.write(this.item, 1);
    paramJceOutputStream.write(this.next_card_uid, 2);
    paramJceOutputStream.write(this.sequence, 3);
    paramJceOutputStream.write(this.folder_list, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QCARD.GetCollectItemMobileRsp
 * JD-Core Version:    0.7.0.1
 */