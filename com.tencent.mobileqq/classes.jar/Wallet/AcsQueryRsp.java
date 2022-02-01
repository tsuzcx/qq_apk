package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AcsQueryRsp
  extends JceStruct
{
  public String err_str = "";
  public int ret_code = 0;
  public int subscribed = 0;
  
  public AcsQueryRsp() {}
  
  public AcsQueryRsp(int paramInt1, String paramString, int paramInt2)
  {
    this.ret_code = paramInt1;
    this.err_str = paramString;
    this.subscribed = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret_code = paramJceInputStream.read(this.ret_code, 0, false);
    this.err_str = paramJceInputStream.readString(1, false);
    this.subscribed = paramJceInputStream.read(this.subscribed, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret_code, 0);
    if (this.err_str != null) {
      paramJceOutputStream.write(this.err_str, 1);
    }
    paramJceOutputStream.write(this.subscribed, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     Wallet.AcsQueryRsp
 * JD-Core Version:    0.7.0.1
 */