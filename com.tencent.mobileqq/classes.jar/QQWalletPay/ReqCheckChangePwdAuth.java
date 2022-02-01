package QQWalletPay;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqCheckChangePwdAuth
  extends JceStruct
{
  public String appId = "";
  public String offerId = "";
  public String packageName = "";
  public String resetWordMode = "";
  public String signatureMode = "";
  public String timeStamp = "";
  
  public ReqCheckChangePwdAuth() {}
  
  public ReqCheckChangePwdAuth(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.packageName = paramString1;
    this.signatureMode = paramString2;
    this.appId = paramString3;
    this.timeStamp = paramString4;
    this.resetWordMode = paramString5;
    this.offerId = paramString6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.packageName = paramJceInputStream.readString(0, true);
    this.signatureMode = paramJceInputStream.readString(1, true);
    this.appId = paramJceInputStream.readString(2, true);
    this.timeStamp = paramJceInputStream.readString(3, true);
    this.resetWordMode = paramJceInputStream.readString(4, true);
    this.offerId = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.packageName, 0);
    paramJceOutputStream.write(this.signatureMode, 1);
    paramJceOutputStream.write(this.appId, 2);
    paramJceOutputStream.write(this.timeStamp, 3);
    paramJceOutputStream.write(this.resetWordMode, 4);
    String str = this.offerId;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QQWalletPay.ReqCheckChangePwdAuth
 * JD-Core Version:    0.7.0.1
 */