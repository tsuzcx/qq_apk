package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cell_goods
  extends JceStruct
{
  public int btn_actiontype;
  public int btn_color;
  public String btn_title = "";
  public String btn_url = "";
  public String dis_price = "";
  public String goods_desc = "";
  public String goods_name = "";
  public int goods_type;
  public int iBuyCount;
  public int iOpenMonth;
  public int iProductType;
  public int iQuantity;
  public int isCanChange;
  public int isDepositGameCoin;
  public int layout_type;
  public String left_price_desc = "";
  public String payofferid = "";
  public String payremark = "";
  public String pf = "";
  public String pfkey = "";
  public String popup_desc = "";
  public String popup_title = "";
  public String price = "";
  public String product_id = "";
  public String product_name = "";
  public String right_price_desc = "";
  public String strItemId = "";
  public String under_price_desc = "";
  public String upper_price_desc = "";
  public String zoneid = "";
  
  public cell_goods() {}
  
  public cell_goods(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, int paramInt4, int paramInt5, String paramString12, String paramString13, String paramString14, int paramInt6, int paramInt7, String paramString15, int paramInt8, String paramString16, String paramString17, String paramString18, String paramString19, int paramInt9, String paramString20, int paramInt10)
  {
    this.goods_type = paramInt1;
    this.goods_desc = paramString1;
    this.price = paramString2;
    this.dis_price = paramString3;
    this.btn_title = paramString4;
    this.btn_color = paramInt2;
    this.btn_actiontype = paramInt3;
    this.btn_url = paramString5;
    this.upper_price_desc = paramString6;
    this.under_price_desc = paramString7;
    this.left_price_desc = paramString8;
    this.right_price_desc = paramString9;
    this.payremark = paramString10;
    this.payofferid = paramString11;
    this.iOpenMonth = paramInt4;
    this.isCanChange = paramInt5;
    this.popup_title = paramString12;
    this.popup_desc = paramString13;
    this.product_id = paramString14;
    this.iQuantity = paramInt6;
    this.iProductType = paramInt7;
    this.product_name = paramString15;
    this.isDepositGameCoin = paramInt8;
    this.pf = paramString16;
    this.pfkey = paramString17;
    this.zoneid = paramString18;
    this.strItemId = paramString19;
    this.iBuyCount = paramInt9;
    this.goods_name = paramString20;
    this.layout_type = paramInt10;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.goods_type = paramJceInputStream.read(this.goods_type, 0, false);
    this.goods_desc = paramJceInputStream.readString(1, false);
    this.price = paramJceInputStream.readString(2, false);
    this.dis_price = paramJceInputStream.readString(3, false);
    this.btn_title = paramJceInputStream.readString(4, false);
    this.btn_color = paramJceInputStream.read(this.btn_color, 5, false);
    this.btn_actiontype = paramJceInputStream.read(this.btn_actiontype, 6, false);
    this.btn_url = paramJceInputStream.readString(7, false);
    this.upper_price_desc = paramJceInputStream.readString(8, false);
    this.under_price_desc = paramJceInputStream.readString(9, false);
    this.left_price_desc = paramJceInputStream.readString(10, false);
    this.right_price_desc = paramJceInputStream.readString(11, false);
    this.payremark = paramJceInputStream.readString(12, false);
    this.payofferid = paramJceInputStream.readString(13, false);
    this.iOpenMonth = paramJceInputStream.read(this.iOpenMonth, 14, false);
    this.isCanChange = paramJceInputStream.read(this.isCanChange, 15, false);
    this.popup_title = paramJceInputStream.readString(16, false);
    this.popup_desc = paramJceInputStream.readString(17, false);
    this.product_id = paramJceInputStream.readString(18, false);
    this.iQuantity = paramJceInputStream.read(this.iQuantity, 19, false);
    this.iProductType = paramJceInputStream.read(this.iProductType, 20, false);
    this.product_name = paramJceInputStream.readString(21, false);
    this.isDepositGameCoin = paramJceInputStream.read(this.isDepositGameCoin, 22, false);
    this.pf = paramJceInputStream.readString(23, false);
    this.pfkey = paramJceInputStream.readString(24, false);
    this.zoneid = paramJceInputStream.readString(25, false);
    this.strItemId = paramJceInputStream.readString(26, false);
    this.iBuyCount = paramJceInputStream.read(this.iBuyCount, 27, false);
    this.goods_name = paramJceInputStream.readString(28, false);
    this.layout_type = paramJceInputStream.read(this.layout_type, 29, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.goods_type, 0);
    if (this.goods_desc != null) {
      paramJceOutputStream.write(this.goods_desc, 1);
    }
    if (this.price != null) {
      paramJceOutputStream.write(this.price, 2);
    }
    if (this.dis_price != null) {
      paramJceOutputStream.write(this.dis_price, 3);
    }
    if (this.btn_title != null) {
      paramJceOutputStream.write(this.btn_title, 4);
    }
    paramJceOutputStream.write(this.btn_color, 5);
    paramJceOutputStream.write(this.btn_actiontype, 6);
    if (this.btn_url != null) {
      paramJceOutputStream.write(this.btn_url, 7);
    }
    if (this.upper_price_desc != null) {
      paramJceOutputStream.write(this.upper_price_desc, 8);
    }
    if (this.under_price_desc != null) {
      paramJceOutputStream.write(this.under_price_desc, 9);
    }
    if (this.left_price_desc != null) {
      paramJceOutputStream.write(this.left_price_desc, 10);
    }
    if (this.right_price_desc != null) {
      paramJceOutputStream.write(this.right_price_desc, 11);
    }
    if (this.payremark != null) {
      paramJceOutputStream.write(this.payremark, 12);
    }
    if (this.payofferid != null) {
      paramJceOutputStream.write(this.payofferid, 13);
    }
    paramJceOutputStream.write(this.iOpenMonth, 14);
    paramJceOutputStream.write(this.isCanChange, 15);
    if (this.popup_title != null) {
      paramJceOutputStream.write(this.popup_title, 16);
    }
    if (this.popup_desc != null) {
      paramJceOutputStream.write(this.popup_desc, 17);
    }
    if (this.product_id != null) {
      paramJceOutputStream.write(this.product_id, 18);
    }
    paramJceOutputStream.write(this.iQuantity, 19);
    paramJceOutputStream.write(this.iProductType, 20);
    if (this.product_name != null) {
      paramJceOutputStream.write(this.product_name, 21);
    }
    paramJceOutputStream.write(this.isDepositGameCoin, 22);
    if (this.pf != null) {
      paramJceOutputStream.write(this.pf, 23);
    }
    if (this.pfkey != null) {
      paramJceOutputStream.write(this.pfkey, 24);
    }
    if (this.zoneid != null) {
      paramJceOutputStream.write(this.zoneid, 25);
    }
    if (this.strItemId != null) {
      paramJceOutputStream.write(this.strItemId, 26);
    }
    paramJceOutputStream.write(this.iBuyCount, 27);
    if (this.goods_name != null) {
      paramJceOutputStream.write(this.goods_name, 28);
    }
    paramJceOutputStream.write(this.layout_type, 29);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_goods
 * JD-Core Version:    0.7.0.1
 */