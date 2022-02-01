package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AcsGetMsgRsp
  extends JceStruct
{
  public String busi_logo = "";
  public String busi_name = "";
  public int calendar = 0;
  public String content = "";
  public String err_str = "";
  public String jump_url = "";
  public long notice_time = 0L;
  public int ret_code = 0;
  public String sub_content = "";
  public String title = "";
  public int type = 0;
  
  public AcsGetMsgRsp() {}
  
  public AcsGetMsgRsp(int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2, String paramString3, String paramString4, String paramString5, int paramInt3, String paramString6, String paramString7)
  {
    this.ret_code = paramInt1;
    this.err_str = paramString1;
    this.content = paramString2;
    this.notice_time = paramLong;
    this.type = paramInt2;
    this.busi_name = paramString3;
    this.busi_logo = paramString4;
    this.sub_content = paramString5;
    this.calendar = paramInt3;
    this.jump_url = paramString6;
    this.title = paramString7;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret_code = paramJceInputStream.read(this.ret_code, 0, false);
    this.err_str = paramJceInputStream.readString(1, false);
    this.content = paramJceInputStream.readString(2, false);
    this.notice_time = paramJceInputStream.read(this.notice_time, 3, false);
    this.type = paramJceInputStream.read(this.type, 4, false);
    this.busi_name = paramJceInputStream.readString(5, false);
    this.busi_logo = paramJceInputStream.readString(6, false);
    this.sub_content = paramJceInputStream.readString(7, false);
    this.calendar = paramJceInputStream.read(this.calendar, 8, false);
    this.jump_url = paramJceInputStream.readString(9, false);
    this.title = paramJceInputStream.readString(10, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret_code, 0);
    String str = this.err_str;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.content;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    paramJceOutputStream.write(this.notice_time, 3);
    paramJceOutputStream.write(this.type, 4);
    str = this.busi_name;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
    str = this.busi_logo;
    if (str != null) {
      paramJceOutputStream.write(str, 6);
    }
    str = this.sub_content;
    if (str != null) {
      paramJceOutputStream.write(str, 7);
    }
    paramJceOutputStream.write(this.calendar, 8);
    str = this.jump_url;
    if (str != null) {
      paramJceOutputStream.write(str, 9);
    }
    str = this.title;
    if (str != null) {
      paramJceOutputStream.write(str, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.AcsGetMsgRsp
 * JD-Core Version:    0.7.0.1
 */