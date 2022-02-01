package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AuthCodeItem
  extends JceStruct
{
  public long appid = 0L;
  public String authCode = "";
  public long expireTime = 0L;
  public String urlDomain = "";
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appid = paramJceInputStream.read(this.appid, 0, false);
    this.expireTime = paramJceInputStream.read(this.expireTime, 1, false);
    this.urlDomain = paramJceInputStream.readString(2, false);
    this.authCode = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appid, 0);
    paramJceOutputStream.write(this.expireTime, 1);
    String str = this.urlDomain;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.authCode;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.AuthCodeItem
 * JD-Core Version:    0.7.0.1
 */