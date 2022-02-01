package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcGetMsgInfo
  extends JceStruct
{
  static byte[] cache_vAppShareCookie;
  static byte[] cache_vMsg;
  static byte[] cache_vReserved;
  public byte cFlag = 0;
  public long lFromUin = 0L;
  public long lLastChangeTime = 1L;
  public long lMsgUid = 0L;
  public long lToUin = 0L;
  public short shMsgSeq = 0;
  public short shMsgType = 0;
  public String strMsg = "";
  public long uAppShareID = 0L;
  public int uMsgTime = 0;
  public int uRealMsgTime = 0;
  public byte[] vAppShareCookie = null;
  public byte[] vMsg = null;
  public byte[] vReserved = null;
  
  public SvcGetMsgInfo() {}
  
  public SvcGetMsgInfo(long paramLong1, int paramInt1, short paramShort1, short paramShort2, String paramString, int paramInt2, byte[] paramArrayOfByte1, long paramLong2, byte paramByte, byte[] paramArrayOfByte2, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte3)
  {
    this.lFromUin = paramLong1;
    this.uMsgTime = paramInt1;
    this.shMsgType = paramShort1;
    this.shMsgSeq = paramShort2;
    this.strMsg = paramString;
    this.uRealMsgTime = paramInt2;
    this.vMsg = paramArrayOfByte1;
    this.uAppShareID = paramLong2;
    this.cFlag = paramByte;
    this.vAppShareCookie = paramArrayOfByte2;
    this.lMsgUid = paramLong3;
    this.lToUin = paramLong4;
    this.lLastChangeTime = paramLong5;
    this.vReserved = paramArrayOfByte3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lFromUin = paramJceInputStream.read(this.lFromUin, 0, true);
    this.uMsgTime = paramJceInputStream.read(this.uMsgTime, 1, true);
    this.shMsgType = paramJceInputStream.read(this.shMsgType, 2, true);
    this.shMsgSeq = paramJceInputStream.read(this.shMsgSeq, 3, true);
    this.strMsg = paramJceInputStream.readString(4, true);
    this.uRealMsgTime = paramJceInputStream.read(this.uRealMsgTime, 5, false);
    if (cache_vMsg == null)
    {
      cache_vMsg = (byte[])new byte[1];
      ((byte[])cache_vMsg)[0] = 0;
    }
    this.vMsg = ((byte[])paramJceInputStream.read(cache_vMsg, 6, false));
    this.uAppShareID = paramJceInputStream.read(this.uAppShareID, 7, false);
    this.cFlag = paramJceInputStream.read(this.cFlag, 8, false);
    if (cache_vAppShareCookie == null)
    {
      cache_vAppShareCookie = (byte[])new byte[1];
      ((byte[])cache_vAppShareCookie)[0] = 0;
    }
    this.vAppShareCookie = ((byte[])paramJceInputStream.read(cache_vAppShareCookie, 9, false));
    this.lMsgUid = paramJceInputStream.read(this.lMsgUid, 10, false);
    this.lToUin = paramJceInputStream.read(this.lToUin, 11, false);
    this.lLastChangeTime = paramJceInputStream.read(this.lLastChangeTime, 12, false);
    if (cache_vReserved == null)
    {
      cache_vReserved = (byte[])new byte[1];
      ((byte[])cache_vReserved)[0] = 0;
    }
    this.vReserved = ((byte[])paramJceInputStream.read(cache_vReserved, 13, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lFromUin, 0);
    paramJceOutputStream.write(this.uMsgTime, 1);
    paramJceOutputStream.write(this.shMsgType, 2);
    paramJceOutputStream.write(this.shMsgSeq, 3);
    paramJceOutputStream.write(this.strMsg, 4);
    paramJceOutputStream.write(this.uRealMsgTime, 5);
    byte[] arrayOfByte = this.vMsg;
    if (arrayOfByte != null) {
      paramJceOutputStream.write(arrayOfByte, 6);
    }
    paramJceOutputStream.write(this.uAppShareID, 7);
    paramJceOutputStream.write(this.cFlag, 8);
    arrayOfByte = this.vAppShareCookie;
    if (arrayOfByte != null) {
      paramJceOutputStream.write(arrayOfByte, 9);
    }
    paramJceOutputStream.write(this.lMsgUid, 10);
    paramJceOutputStream.write(this.lToUin, 11);
    paramJceOutputStream.write(this.lLastChangeTime, 12);
    arrayOfByte = this.vReserved;
    if (arrayOfByte != null) {
      paramJceOutputStream.write(arrayOfByte, 13);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MessageSvcPack.SvcGetMsgInfo
 * JD-Core Version:    0.7.0.1
 */