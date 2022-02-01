package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetPasswordRsp
  extends JceStruct
{
  public int checkInterval = 300;
  public String deviceId = "";
  public int passInterval = 0;
  public String password = "";
  public int passwordType = 0;
  public int ret = 0;
  
  public GetPasswordRsp() {}
  
  public GetPasswordRsp(int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    this.ret = paramInt1;
    this.password = paramString1;
    this.checkInterval = paramInt2;
    this.passInterval = paramInt3;
    this.passwordType = paramInt4;
    this.deviceId = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    this.password = paramJceInputStream.readString(1, true);
    this.checkInterval = paramJceInputStream.read(this.checkInterval, 2, false);
    this.passInterval = paramJceInputStream.read(this.passInterval, 3, false);
    this.passwordType = paramJceInputStream.read(this.passwordType, 4, false);
    this.deviceId = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    paramJceOutputStream.write(this.password, 1);
    paramJceOutputStream.write(this.checkInterval, 2);
    paramJceOutputStream.write(this.passInterval, 3);
    paramJceOutputStream.write(this.passwordType, 4);
    String str = this.deviceId;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.GetPasswordRsp
 * JD-Core Version:    0.7.0.1
 */