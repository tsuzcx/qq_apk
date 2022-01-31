package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class AuthCodeRsp
  extends JceStruct
{
  static ArrayList<AuthCodeItem> cache_items = new ArrayList();
  public long iNextReqTime;
  public ArrayList<AuthCodeItem> items;
  
  static
  {
    AuthCodeItem localAuthCodeItem = new AuthCodeItem();
    cache_items.add(localAuthCodeItem);
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.items = ((ArrayList)paramJceInputStream.read(cache_items, 0, false));
    this.iNextReqTime = paramJceInputStream.read(this.iNextReqTime, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.items != null) {
      paramJceOutputStream.write(this.items, 0);
    }
    paramJceOutputStream.write(this.iNextReqTime, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     Wallet.AuthCodeRsp
 * JD-Core Version:    0.7.0.1
 */