package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AcsGetMsgRsp
  extends JceStruct
{
  public String busi_logo = "";
  public String busi_name = "";
  public String content = "";
  public String err_str = "";
  public long notice_time;
  public int ret_code;
  public String sub_content = "";
  public int type;
  
  public AcsGetMsgRsp() {}
  
  public AcsGetMsgRsp(int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2, String paramString3, String paramString4, String paramString5)
  {
    this.ret_code = paramInt1;
    this.err_str = paramString1;
    this.content = paramString2;
    this.notice_time = paramLong;
    this.type = paramInt2;
    this.busi_name = paramString3;
    this.busi_logo = paramString4;
    this.sub_content = paramString5;
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
  }
  
  public String toString()
  {
    return "AcsGetMsgRsp{ret_code=" + this.ret_code + ", err_str='" + this.err_str + '\'' + ", content='" + this.content + '\'' + ", notice_time=" + this.notice_time + ", type=" + this.type + ", busi_name='" + this.busi_name + '\'' + ", busi_logo='" + this.busi_logo + '\'' + ", sub_content='" + this.sub_content + '\'' + '}';
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret_code, 0);
    if (this.err_str != null) {
      paramJceOutputStream.write(this.err_str, 1);
    }
    if (this.content != null) {
      paramJceOutputStream.write(this.content, 2);
    }
    paramJceOutputStream.write(this.notice_time, 3);
    paramJceOutputStream.write(this.type, 4);
    if (this.busi_name != null) {
      paramJceOutputStream.write(this.busi_name, 5);
    }
    if (this.busi_logo != null) {
      paramJceOutputStream.write(this.busi_logo, 6);
    }
    if (this.sub_content != null) {
      paramJceOutputStream.write(this.sub_content, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     Wallet.AcsGetMsgRsp
 * JD-Core Version:    0.7.0.1
 */