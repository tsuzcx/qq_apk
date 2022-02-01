package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class AuthCodeReq
  extends JceStruct
{
  static ArrayList<Long> cache_apps = new ArrayList();
  public ArrayList<Long> apps = null;
  public String skey = "";
  public long uin = 0L;
  
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
    Object localObject = this.skey;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.apps;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.AuthCodeReq
 * JD-Core Version:    0.7.0.1
 */