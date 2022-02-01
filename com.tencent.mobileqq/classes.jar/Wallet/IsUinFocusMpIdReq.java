package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class IsUinFocusMpIdReq
  extends JceStruct
{
  public String appid = "";
  public String uin = "";
  
  public IsUinFocusMpIdReq() {}
  
  public IsUinFocusMpIdReq(String paramString1, String paramString2)
  {
    this.uin = paramString1;
    this.appid = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.readString(0, false);
    this.appid = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.uin;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.appid;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.IsUinFocusMpIdReq
 * JD-Core Version:    0.7.0.1
 */