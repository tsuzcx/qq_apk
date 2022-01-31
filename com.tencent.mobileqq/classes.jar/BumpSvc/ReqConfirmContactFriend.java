package BumpSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqConfirmContactFriend
  extends JceStruct
{
  static byte[] cache_vSig;
  public byte bGroupId;
  public byte bType;
  public long lFromMobile;
  public long lToMID;
  public long lToMobile;
  public String strNickName = "";
  public String strReason = "";
  public byte[] vSig;
  
  public ReqConfirmContactFriend() {}
  
  public ReqConfirmContactFriend(byte paramByte1, long paramLong1, long paramLong2, long paramLong3, byte[] paramArrayOfByte, byte paramByte2, String paramString1, String paramString2)
  {
    this.bType = paramByte1;
    this.lToMID = paramLong1;
    this.lFromMobile = paramLong2;
    this.lToMobile = paramLong3;
    this.vSig = paramArrayOfByte;
    this.bGroupId = paramByte2;
    this.strReason = paramString1;
    this.strNickName = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bType = paramJceInputStream.read(this.bType, 0, true);
    this.lToMID = paramJceInputStream.read(this.lToMID, 1, false);
    this.lFromMobile = paramJceInputStream.read(this.lFromMobile, 2, false);
    this.lToMobile = paramJceInputStream.read(this.lToMobile, 3, false);
    if (cache_vSig == null)
    {
      cache_vSig = (byte[])new byte[1];
      ((byte[])cache_vSig)[0] = 0;
    }
    this.vSig = ((byte[])paramJceInputStream.read(cache_vSig, 4, true));
    this.bGroupId = paramJceInputStream.read(this.bGroupId, 5, false);
    this.strReason = paramJceInputStream.readString(6, false);
    this.strNickName = paramJceInputStream.readString(7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.bType, 0);
    paramJceOutputStream.write(this.lToMID, 1);
    paramJceOutputStream.write(this.lFromMobile, 2);
    paramJceOutputStream.write(this.lToMobile, 3);
    paramJceOutputStream.write(this.vSig, 4);
    paramJceOutputStream.write(this.bGroupId, 5);
    if (this.strReason != null) {
      paramJceOutputStream.write(this.strReason, 6);
    }
    if (this.strNickName != null) {
      paramJceOutputStream.write(this.strNickName, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\acom1.jar
 * Qualified Name:     BumpSvc.ReqConfirmContactFriend
 * JD-Core Version:    0.7.0.1
 */