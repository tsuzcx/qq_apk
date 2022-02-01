package VideoSvrPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class VideoCallMsg
  extends JceStruct
  implements Cloneable
{
  static byte[] cache_errMsg;
  static byte[] cache_vMsg;
  public byte cVerifyType = 0;
  public byte[] errMsg = null;
  public long lPeerUin = 0L;
  public long lUin = 0L;
  public byte type = 0;
  public int uDateTime = 0;
  public int uSeqId = 0;
  public int uSessionId = 0;
  public byte[] vMsg = null;
  public byte ver = 0;
  
  public VideoCallMsg() {}
  
  public VideoCallMsg(byte paramByte1, byte paramByte2, long paramLong1, long paramLong2, int paramInt1, byte paramByte3, int paramInt2, int paramInt3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.ver = paramByte1;
    this.type = paramByte2;
    this.lUin = paramLong1;
    this.lPeerUin = paramLong2;
    this.uDateTime = paramInt1;
    this.cVerifyType = paramByte3;
    this.uSeqId = paramInt2;
    this.uSessionId = paramInt3;
    this.vMsg = paramArrayOfByte1;
    this.errMsg = paramArrayOfByte2;
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label7:
      break label7;
    }
    return null;
  }
  
  public int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ver = paramJceInputStream.read(this.ver, 0, true);
    this.type = paramJceInputStream.read(this.type, 1, true);
    this.lUin = paramJceInputStream.read(this.lUin, 2, true);
    this.lPeerUin = paramJceInputStream.read(this.lPeerUin, 3, true);
    this.uDateTime = paramJceInputStream.read(this.uDateTime, 4, true);
    this.cVerifyType = paramJceInputStream.read(this.cVerifyType, 5, true);
    this.uSeqId = paramJceInputStream.read(this.uSeqId, 6, true);
    this.uSessionId = paramJceInputStream.read(this.uSessionId, 7, true);
    if (cache_vMsg == null)
    {
      cache_vMsg = (byte[])new byte[1];
      ((byte[])cache_vMsg)[0] = 0;
    }
    cache_vMsg = (byte[])paramJceInputStream.read(cache_vMsg, 8, true);
    this.vMsg = cache_vMsg;
    if (cache_errMsg == null)
    {
      cache_errMsg = (byte[])new byte[1];
      ((byte[])cache_errMsg)[0] = 0;
    }
    cache_errMsg = (byte[])paramJceInputStream.read(cache_errMsg, 9, false);
    this.errMsg = cache_errMsg;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ver, 0);
    paramJceOutputStream.write(this.type, 1);
    paramJceOutputStream.write(this.lUin, 2);
    paramJceOutputStream.write(this.lPeerUin, 3);
    paramJceOutputStream.write(this.uDateTime, 4);
    paramJceOutputStream.write(this.cVerifyType, 5);
    paramJceOutputStream.write(this.uSeqId, 6);
    paramJceOutputStream.write(this.uSessionId, 7);
    paramJceOutputStream.write(this.vMsg, 8);
    byte[] arrayOfByte = this.errMsg;
    if (arrayOfByte != null) {
      paramJceOutputStream.write(arrayOfByte, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     VideoSvrPack.VideoCallMsg
 * JD-Core Version:    0.7.0.1
 */