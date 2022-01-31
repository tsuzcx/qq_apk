package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetPasswordReq
  extends JceStruct
{
  public String MQOS = "";
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.MQOS = paramJceInputStream.readString(0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.MQOS, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     Wallet.GetPasswordReq
 * JD-Core Version:    0.7.0.1
 */