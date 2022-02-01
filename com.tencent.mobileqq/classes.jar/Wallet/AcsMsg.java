package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class AcsMsg
  extends JceStruct
  implements Comparable<AcsMsg>
{
  public String applet_jump_url = "";
  public int banner_type = 0;
  public String banner_url = "";
  public String btn_text = "";
  public String busi_icon = "";
  public String busi_id = "";
  public String busi_logo = "";
  public String busi_name = "";
  public int calendar = 0;
  public String content = "";
  public String flag_text = "";
  public String jump_url = "";
  public int mn_appid = 0;
  public String mn_reserved = "";
  public String msg_id = "";
  public long notice_time = 0L;
  public long sub_time = 0L;
  public String title = "";
  public int type = 0;
  
  public AcsMsg() {}
  
  public AcsMsg(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, int paramInt1, String paramString5, String paramString6, String paramString7, String paramString8, long paramLong2, String paramString9, String paramString10, String paramString11, int paramInt2, int paramInt3, String paramString12, String paramString13, int paramInt4)
  {
    this.msg_id = paramString1;
    this.busi_id = paramString2;
    this.busi_name = paramString3;
    this.busi_icon = paramString4;
    this.sub_time = paramLong1;
    this.type = paramInt1;
    this.flag_text = paramString5;
    this.btn_text = paramString6;
    this.title = paramString7;
    this.content = paramString8;
    this.notice_time = paramLong2;
    this.banner_url = paramString9;
    this.jump_url = paramString10;
    this.applet_jump_url = paramString11;
    this.banner_type = paramInt2;
    this.mn_appid = paramInt3;
    this.mn_reserved = paramString12;
    this.busi_logo = paramString13;
    this.calendar = paramInt4;
  }
  
  public int compareTo(AcsMsg paramAcsMsg)
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = JceUtil.compareTo(this.notice_time, paramAcsMsg.notice_time);
    int i = 0;
    while (i < arrayOfInt.length)
    {
      if (arrayOfInt[i] != 0) {
        return arrayOfInt[i];
      }
      i += 1;
    }
    return 0;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.msg_id = paramJceInputStream.readString(0, false);
    this.busi_id = paramJceInputStream.readString(1, false);
    this.busi_name = paramJceInputStream.readString(2, false);
    this.busi_icon = paramJceInputStream.readString(3, false);
    this.sub_time = paramJceInputStream.read(this.sub_time, 4, false);
    this.type = paramJceInputStream.read(this.type, 5, false);
    this.flag_text = paramJceInputStream.readString(6, false);
    this.btn_text = paramJceInputStream.readString(7, false);
    this.title = paramJceInputStream.readString(8, false);
    this.content = paramJceInputStream.readString(9, false);
    this.notice_time = paramJceInputStream.read(this.notice_time, 10, false);
    this.banner_url = paramJceInputStream.readString(11, false);
    this.jump_url = paramJceInputStream.readString(12, false);
    this.applet_jump_url = paramJceInputStream.readString(13, false);
    this.banner_type = paramJceInputStream.read(this.banner_type, 14, false);
    this.mn_appid = paramJceInputStream.read(this.mn_appid, 15, false);
    this.mn_reserved = paramJceInputStream.readString(16, false);
    this.busi_logo = paramJceInputStream.readString(17, false);
    this.calendar = paramJceInputStream.read(this.calendar, 18, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.msg_id;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.busi_id;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.busi_name;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.busi_icon;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    paramJceOutputStream.write(this.sub_time, 4);
    paramJceOutputStream.write(this.type, 5);
    str = this.flag_text;
    if (str != null) {
      paramJceOutputStream.write(str, 6);
    }
    str = this.btn_text;
    if (str != null) {
      paramJceOutputStream.write(str, 7);
    }
    str = this.title;
    if (str != null) {
      paramJceOutputStream.write(str, 8);
    }
    str = this.content;
    if (str != null) {
      paramJceOutputStream.write(str, 9);
    }
    paramJceOutputStream.write(this.notice_time, 10);
    str = this.banner_url;
    if (str != null) {
      paramJceOutputStream.write(str, 11);
    }
    str = this.jump_url;
    if (str != null) {
      paramJceOutputStream.write(str, 12);
    }
    str = this.applet_jump_url;
    if (str != null) {
      paramJceOutputStream.write(str, 13);
    }
    paramJceOutputStream.write(this.banner_type, 14);
    paramJceOutputStream.write(this.mn_appid, 15);
    str = this.mn_reserved;
    if (str != null) {
      paramJceOutputStream.write(str, 16);
    }
    str = this.busi_logo;
    if (str != null) {
      paramJceOutputStream.write(str, 17);
    }
    paramJceOutputStream.write(this.calendar, 18);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.AcsMsg
 * JD-Core Version:    0.7.0.1
 */