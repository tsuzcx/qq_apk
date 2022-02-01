package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AcsAckMsgRsp
  extends JceStruct
{
  public String err_str = "";
  public int ret_code = 0;
  
  public AcsAckMsgRsp() {}
  
  public AcsAckMsgRsp(int paramInt, String paramString)
  {
    this.ret_code = paramInt;
    this.err_str = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret_code = paramJceInputStream.read(this.ret_code, 0, false);
    this.err_str = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret_code, 0);
    String str = this.err_str;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.AcsAckMsgRsp
 * JD-Core Version:    0.7.0.1
 */