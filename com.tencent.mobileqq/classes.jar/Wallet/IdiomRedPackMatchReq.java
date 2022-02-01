package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class IdiomRedPackMatchReq
  extends JceStruct
{
  static int cache_subchannel = 0;
  public long appid = 0L;
  public String billno = "";
  public int fromType = 0;
  public long grabUin = 0L;
  public String groupid = "";
  public String hbIdiom = "";
  public String inputIdiom = "";
  public long makeUin = 0L;
  public int platform = 0;
  public String qqVersion = "";
  public String sKey = "";
  public int subchannel = 0;
  
  public IdiomRedPackMatchReq() {}
  
  public IdiomRedPackMatchReq(long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, String paramString4, long paramLong3, int paramInt1, int paramInt2, String paramString5, String paramString6, int paramInt3)
  {
    this.grabUin = paramLong1;
    this.billno = paramString1;
    this.inputIdiom = paramString2;
    this.hbIdiom = paramString3;
    this.makeUin = paramLong2;
    this.sKey = paramString4;
    this.appid = paramLong3;
    this.fromType = paramInt1;
    this.platform = paramInt2;
    this.qqVersion = paramString5;
    this.groupid = paramString6;
    this.subchannel = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.grabUin = paramJceInputStream.read(this.grabUin, 0, false);
    this.billno = paramJceInputStream.readString(1, false);
    this.inputIdiom = paramJceInputStream.readString(2, false);
    this.hbIdiom = paramJceInputStream.readString(3, false);
    this.makeUin = paramJceInputStream.read(this.makeUin, 4, false);
    this.sKey = paramJceInputStream.readString(5, false);
    this.appid = paramJceInputStream.read(this.appid, 6, false);
    this.fromType = paramJceInputStream.read(this.fromType, 7, false);
    this.platform = paramJceInputStream.read(this.platform, 8, false);
    this.qqVersion = paramJceInputStream.readString(9, false);
    this.groupid = paramJceInputStream.readString(10, false);
    this.subchannel = paramJceInputStream.read(this.subchannel, 11, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.grabUin, 0);
    if (this.billno != null) {
      paramJceOutputStream.write(this.billno, 1);
    }
    if (this.inputIdiom != null) {
      paramJceOutputStream.write(this.inputIdiom, 2);
    }
    if (this.hbIdiom != null) {
      paramJceOutputStream.write(this.hbIdiom, 3);
    }
    paramJceOutputStream.write(this.makeUin, 4);
    if (this.sKey != null) {
      paramJceOutputStream.write(this.sKey, 5);
    }
    paramJceOutputStream.write(this.appid, 6);
    paramJceOutputStream.write(this.fromType, 7);
    paramJceOutputStream.write(this.platform, 8);
    if (this.qqVersion != null) {
      paramJceOutputStream.write(this.qqVersion, 9);
    }
    if (this.groupid != null) {
      paramJceOutputStream.write(this.groupid, 10);
    }
    paramJceOutputStream.write(this.subchannel, 11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     Wallet.IdiomRedPackMatchReq
 * JD-Core Version:    0.7.0.1
 */