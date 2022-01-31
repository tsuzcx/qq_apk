package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class AuthCodeReq
  extends JceStruct
{
  static ArrayList cache_apps = new ArrayList();
  public ArrayList apps;
  public String skey = "";
  public long uin;
  
  static
  {
    cache_apps.add(Long.valueOf(0L));
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.skey = paramJceInputStream.readString(1, false);
    this.apps = ((ArrayList)paramJceInputStream.read(cache_apps, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.skey != null) {
      paramJceOutputStream.write(this.skey, 1);
    }
    if (this.apps != null) {
      paramJceOutputStream.write(this.apps, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     Wallet.AuthCodeReq
 * JD-Core Version:    0.7.0.1
 */