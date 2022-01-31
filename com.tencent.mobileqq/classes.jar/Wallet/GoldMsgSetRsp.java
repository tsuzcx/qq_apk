package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GoldMsgSetRsp
  extends JceStruct
{
  public String errMsg = "";
  public int status;
  
  public GoldMsgSetRsp() {}
  
  public GoldMsgSetRsp(int paramInt, String paramString)
  {
    this.status = paramInt;
    this.errMsg = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.status = paramJceInputStream.read(this.status, 0, false);
    this.errMsg = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.status, 0);
    if (this.errMsg != null) {
      paramJceOutputStream.write(this.errMsg, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     Wallet.GoldMsgSetRsp
 * JD-Core Version:    0.7.0.1
 */