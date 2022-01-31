package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetPasswordRsp
  extends JceStruct
{
  public int checkInterval = 300;
  public int passInterval;
  public String password = "";
  public int ret;
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    this.password = paramJceInputStream.readString(1, true);
    this.checkInterval = paramJceInputStream.read(this.checkInterval, 2, true);
    this.passInterval = paramJceInputStream.read(this.passInterval, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    paramJceOutputStream.write(this.password, 1);
    paramJceOutputStream.write(this.checkInterval, 2);
    paramJceOutputStream.write(this.passInterval, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     Wallet.GetPasswordRsp
 * JD-Core Version:    0.7.0.1
 */