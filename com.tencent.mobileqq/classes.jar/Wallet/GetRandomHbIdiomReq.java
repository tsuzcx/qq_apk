package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetRandomHbIdiomReq
  extends JceStruct
{
  static int cache_subchannel;
  public long appid = 0L;
  public int fromType = 0;
  public long makeUin = 0L;
  public int platform = 0;
  public String qqVersion = "";
  public String sKey = "";
  public int subchannel = 0;
  
  public GetRandomHbIdiomReq() {}
  
  public GetRandomHbIdiomReq(long paramLong1, String paramString1, long paramLong2, int paramInt1, int paramInt2, String paramString2, int paramInt3)
  {
    this.makeUin = paramLong1;
    this.sKey = paramString1;
    this.appid = paramLong2;
    this.fromType = paramInt1;
    this.platform = paramInt2;
    this.qqVersion = paramString2;
    this.subchannel = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.makeUin = paramJceInputStream.read(this.makeUin, 0, false);
    this.sKey = paramJceInputStream.readString(1, false);
    this.appid = paramJceInputStream.read(this.appid, 2, false);
    this.fromType = paramJceInputStream.read(this.fromType, 3, false);
    this.platform = paramJceInputStream.read(this.platform, 4, false);
    this.qqVersion = paramJceInputStream.readString(5, false);
    this.subchannel = paramJceInputStream.read(this.subchannel, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.makeUin, 0);
    String str = this.sKey;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    paramJceOutputStream.write(this.appid, 2);
    paramJceOutputStream.write(this.fromType, 3);
    paramJceOutputStream.write(this.platform, 4);
    str = this.qqVersion;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
    paramJceOutputStream.write(this.subchannel, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.GetRandomHbIdiomReq
 * JD-Core Version:    0.7.0.1
 */