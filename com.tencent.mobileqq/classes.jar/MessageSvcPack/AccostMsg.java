package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AccostMsg
  extends JceStruct
{
  static int cache_eAccostType;
  static byte[] cache_strMsg;
  public int eAccostType = 0;
  public int iAccostType = 0;
  public int iMsgTime = 0;
  public long lFromMID = 0L;
  public long lToMID = 0L;
  public short shMsgType = 0;
  public byte[] strMsg = null;
  public long uMsgID = 0L;
  
  public AccostMsg() {}
  
  public AccostMsg(short paramShort, long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3)
  {
    this.shMsgType = paramShort;
    this.uMsgID = paramLong1;
    this.lFromMID = paramLong2;
    this.lToMID = paramLong3;
    this.iMsgTime = paramInt1;
    this.eAccostType = paramInt2;
    this.strMsg = paramArrayOfByte;
    this.iAccostType = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shMsgType = paramJceInputStream.read(this.shMsgType, 0, true);
    this.uMsgID = paramJceInputStream.read(this.uMsgID, 1, true);
    this.lFromMID = paramJceInputStream.read(this.lFromMID, 2, true);
    this.lToMID = paramJceInputStream.read(this.lToMID, 3, true);
    this.iMsgTime = paramJceInputStream.read(this.iMsgTime, 4, true);
    this.eAccostType = paramJceInputStream.read(this.eAccostType, 5, true);
    if (cache_strMsg == null)
    {
      cache_strMsg = (byte[])new byte[1];
      ((byte[])cache_strMsg)[0] = 0;
    }
    this.strMsg = ((byte[])paramJceInputStream.read(cache_strMsg, 6, true));
    this.iAccostType = paramJceInputStream.read(this.iAccostType, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shMsgType, 0);
    paramJceOutputStream.write(this.uMsgID, 1);
    paramJceOutputStream.write(this.lFromMID, 2);
    paramJceOutputStream.write(this.lToMID, 3);
    paramJceOutputStream.write(this.iMsgTime, 4);
    paramJceOutputStream.write(this.eAccostType, 5);
    paramJceOutputStream.write(this.strMsg, 6);
    paramJceOutputStream.write(this.iAccostType, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MessageSvcPack.AccostMsg
 * JD-Core Version:    0.7.0.1
 */