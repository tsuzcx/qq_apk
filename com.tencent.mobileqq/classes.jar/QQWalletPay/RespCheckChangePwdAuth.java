package QQWalletPay;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RespCheckChangePwdAuth
  extends JceStruct
{
  public int retCode = 0;
  public String retMsg = "";
  
  public RespCheckChangePwdAuth() {}
  
  public RespCheckChangePwdAuth(int paramInt, String paramString)
  {
    this.retCode = paramInt;
    this.retMsg = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.retCode = paramJceInputStream.read(this.retCode, 0, true);
    this.retMsg = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.retCode, 0);
    String str = this.retMsg;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QQWalletPay.RespCheckChangePwdAuth
 * JD-Core Version:    0.7.0.1
 */