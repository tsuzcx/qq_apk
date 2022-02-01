package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetBroadCastHbIdiomReq
  extends JceStruct
{
  static ArrayList<String> cache_billnos = new ArrayList();
  public long appid = 0L;
  public ArrayList<String> billnos = null;
  public int fromType = 0;
  public int platform = 0;
  public String qqVersion = "";
  public String sKey = "";
  
  static
  {
    cache_billnos.add("");
  }
  
  public GetBroadCastHbIdiomReq() {}
  
  public GetBroadCastHbIdiomReq(ArrayList<String> paramArrayList, String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2)
  {
    this.billnos = paramArrayList;
    this.sKey = paramString1;
    this.appid = paramLong;
    this.fromType = paramInt1;
    this.platform = paramInt2;
    this.qqVersion = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.billnos = ((ArrayList)paramJceInputStream.read(cache_billnos, 0, false));
    this.sKey = paramJceInputStream.readString(1, false);
    this.appid = paramJceInputStream.read(this.appid, 2, false);
    this.fromType = paramJceInputStream.read(this.fromType, 3, false);
    this.platform = paramJceInputStream.read(this.platform, 4, false);
    this.qqVersion = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.billnos != null) {
      paramJceOutputStream.write(this.billnos, 0);
    }
    if (this.sKey != null) {
      paramJceOutputStream.write(this.sKey, 1);
    }
    paramJceOutputStream.write(this.appid, 2);
    paramJceOutputStream.write(this.fromType, 3);
    paramJceOutputStream.write(this.platform, 4);
    if (this.qqVersion != null) {
      paramJceOutputStream.write(this.qqVersion, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     Wallet.GetBroadCastHbIdiomReq
 * JD-Core Version:    0.7.0.1
 */