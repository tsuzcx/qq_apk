package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AcsSubNoticeRsp
  extends JceStruct
{
  static AcsMsg cache_msg = new AcsMsg();
  public String err_str = "";
  public AcsMsg msg = null;
  public int ret_code = 0;
  
  public AcsSubNoticeRsp() {}
  
  public AcsSubNoticeRsp(int paramInt, String paramString, AcsMsg paramAcsMsg)
  {
    this.ret_code = paramInt;
    this.err_str = paramString;
    this.msg = paramAcsMsg;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret_code = paramJceInputStream.read(this.ret_code, 0, false);
    this.err_str = paramJceInputStream.readString(1, false);
    this.msg = ((AcsMsg)paramJceInputStream.read(cache_msg, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret_code, 0);
    Object localObject = this.err_str;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.msg;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.AcsSubNoticeRsp
 * JD-Core Version:    0.7.0.1
 */