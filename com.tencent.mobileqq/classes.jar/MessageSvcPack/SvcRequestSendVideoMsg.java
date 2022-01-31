package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcRequestSendVideoMsg
  extends JceStruct
{
  static byte[] cache_vMsg;
  public byte cVerifyType;
  public long lPeerUin;
  public long lUin;
  public long uClientIP;
  public int uDateTime;
  public byte[] vMsg;
  
  public SvcRequestSendVideoMsg() {}
  
  public SvcRequestSendVideoMsg(long paramLong1, long paramLong2, int paramInt, byte paramByte, byte[] paramArrayOfByte, long paramLong3)
  {
    this.lUin = paramLong1;
    this.lPeerUin = paramLong2;
    this.uDateTime = paramInt;
    this.cVerifyType = paramByte;
    this.vMsg = paramArrayOfByte;
    this.uClientIP = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.lPeerUin = paramJceInputStream.read(this.lPeerUin, 1, true);
    this.uDateTime = paramJceInputStream.read(this.uDateTime, 2, true);
    this.cVerifyType = paramJceInputStream.read(this.cVerifyType, 3, true);
    if (cache_vMsg == null)
    {
      cache_vMsg = (byte[])new byte[1];
      ((byte[])cache_vMsg)[0] = 0;
    }
    this.vMsg = ((byte[])paramJceInputStream.read(cache_vMsg, 4, true));
    this.uClientIP = paramJceInputStream.read(this.uClientIP, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.lPeerUin, 1);
    paramJceOutputStream.write(this.uDateTime, 2);
    paramJceOutputStream.write(this.cVerifyType, 3);
    paramJceOutputStream.write(this.vMsg, 4);
    paramJceOutputStream.write(this.uClientIP, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     MessageSvcPack.SvcRequestSendVideoMsg
 * JD-Core Version:    0.7.0.1
 */