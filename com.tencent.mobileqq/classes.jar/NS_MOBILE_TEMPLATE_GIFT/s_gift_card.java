package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_gift_card
  extends JceStruct
{
  public String btn_link_1 = "";
  public String btn_link_2 = "";
  public String btn_pic_1 = "";
  public String btn_pic_2 = "";
  public String btn_pic_reply = "";
  public boolean btn_reply = true;
  public String card_url = "";
  public String pic_100 = "";
  public String pic_65 = "";
  public String pic_background = "";
  public String pic_baseurl = "";
  public String pic_big = "";
  public String word_desc = "";
  public String word_msg = "";
  public String word_name = "";
  
  public s_gift_card() {}
  
  public s_gift_card(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14)
  {
    this.pic_baseurl = paramString1;
    this.pic_background = paramString2;
    this.pic_65 = paramString3;
    this.pic_100 = paramString4;
    this.pic_big = paramString5;
    this.btn_reply = paramBoolean;
    this.btn_pic_reply = paramString6;
    this.btn_pic_1 = paramString7;
    this.btn_link_1 = paramString8;
    this.btn_pic_2 = paramString9;
    this.btn_link_2 = paramString10;
    this.word_name = paramString11;
    this.word_desc = paramString12;
    this.word_msg = paramString13;
    this.card_url = paramString14;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.pic_baseurl = paramJceInputStream.readString(0, false);
    this.pic_background = paramJceInputStream.readString(1, false);
    this.pic_65 = paramJceInputStream.readString(2, false);
    this.pic_100 = paramJceInputStream.readString(3, false);
    this.pic_big = paramJceInputStream.readString(4, false);
    this.btn_reply = paramJceInputStream.read(this.btn_reply, 5, false);
    this.btn_pic_reply = paramJceInputStream.readString(6, false);
    this.btn_pic_1 = paramJceInputStream.readString(7, false);
    this.btn_link_1 = paramJceInputStream.readString(8, false);
    this.btn_pic_2 = paramJceInputStream.readString(9, false);
    this.btn_link_2 = paramJceInputStream.readString(10, false);
    this.word_name = paramJceInputStream.readString(11, false);
    this.word_desc = paramJceInputStream.readString(12, false);
    this.word_msg = paramJceInputStream.readString(13, false);
    this.card_url = paramJceInputStream.readString(14, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.pic_baseurl;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.pic_background;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.pic_65;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.pic_100;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.pic_big;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    paramJceOutputStream.write(this.btn_reply, 5);
    str = this.btn_pic_reply;
    if (str != null) {
      paramJceOutputStream.write(str, 6);
    }
    str = this.btn_pic_1;
    if (str != null) {
      paramJceOutputStream.write(str, 7);
    }
    str = this.btn_link_1;
    if (str != null) {
      paramJceOutputStream.write(str, 8);
    }
    str = this.btn_pic_2;
    if (str != null) {
      paramJceOutputStream.write(str, 9);
    }
    str = this.btn_link_2;
    if (str != null) {
      paramJceOutputStream.write(str, 10);
    }
    str = this.word_name;
    if (str != null) {
      paramJceOutputStream.write(str, 11);
    }
    str = this.word_desc;
    if (str != null) {
      paramJceOutputStream.write(str, 12);
    }
    str = this.word_msg;
    if (str != null) {
      paramJceOutputStream.write(str, 13);
    }
    str = this.card_url;
    if (str != null) {
      paramJceOutputStream.write(str, 14);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_TEMPLATE_GIFT.s_gift_card
 * JD-Core Version:    0.7.0.1
 */