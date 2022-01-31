package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AcsGetMsgRsp
  extends JceStruct
{
  public String content = "";
  public String err_str = "";
  public long notice_time;
  public int ret_code;
  
  public AcsGetMsgRsp() {}
  
  public AcsGetMsgRsp(int paramInt, String paramString1, String paramString2, long paramLong)
  {
    this.ret_code = paramInt;
    this.err_str = paramString1;
    this.content = paramString2;
    this.notice_time = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret_code = paramJceInputStream.read(this.ret_code, 0, false);
    this.err_str = paramJceInputStream.readString(1, false);
    this.content = paramJceInputStream.readString(2, false);
    this.notice_time = paramJceInputStream.read(this.notice_time, 3, false);
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     Wallet.AcsGetMsgRsp
 * JD-Core Version:    0.7.0.1
 */