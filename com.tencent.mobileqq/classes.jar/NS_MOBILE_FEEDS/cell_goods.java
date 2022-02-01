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
    String str = this.goods_desc;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.price;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.dis_price;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.btn_title;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    paramJceOutputStream.write(this.btn_color, 5);
    paramJceOutputStream.write(this.btn_actiontype, 6);
    str = this.btn_url;
    if (str != null) {
      paramJceOutputStream.write(str, 7);
    }
    str = this.upper_price_desc;
    if (str != null) {
      paramJceOutputStream.write(str, 8);
    }
    str = this.under_price_desc;
    if (str != null) {
      paramJceOutputStream.write(str, 9);
    }
    str = this.left_price_desc;
    if (str != null) {
      paramJceOutputStream.write(str, 10);
    }
    str = this.right_price_desc;
    if (str != null) {
      paramJceOutputStream.write(str, 11);
    }
    str = this.payremark;
    if (str != null) {
      paramJceOutputStream.write(str, 12);
    }
    str = this.payofferid;
    if (str != null) {
      paramJceOutputStream.write(str, 13);
    }
    paramJceOutputStream.write(this.iOpenMonth, 14);
    paramJceOutputStream.write(this.isCanChange, 15);
    str = this.popup_title;
    if (str != null) {
      paramJceOutputStream.write(str, 16);
    }
    str = this.popup_desc;
    if (str != null) {
      paramJceOutputStream.write(str, 17);
    }
    str = this.product_id;
    if (str != null) {
      paramJceOutputStream.write(str, 18);
    }
    paramJceOutputStream.write(this.iQuantity, 19);
    paramJceOutputStream.write(this.iProductType, 20);
    str = this.product_name;
    if (str != null) {
      paramJceOutputStream.write(str, 21);
    }
    paramJceOutputStream.write(this.isDepositGameCoin, 22);
    str = this.pf;
    if (str != null) {
      paramJceOutputStream.write(str, 23);
    }
    str = this.pfkey;
    if (str != null) {
      paramJceOutputStream.write(str, 24);
    }
    str = this.zoneid;
    if (str != null) {
      paramJceOutputStream.write(str, 25);
    }
    str = this.strItemId;
    if (str != null) {
      paramJceOutputStream.write(str, 26);
    }
    paramJceOutputStream.write(this.iBuyCount, 27);
    str = this.goods_name;
    if (str != null) {
      paramJceOutputStream.write(str, 28);
    }
    paramJceOutputStream.write(this.layout_type, 29);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_goods
 * JD-Core Version:    0.7.0.1
 */