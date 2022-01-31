package QzoneCombine;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ClientOnlineNotfiyReq
  extends JceStruct
{
  static byte[] cache_AttachInfo = (byte[])new byte[1];
  public byte[] AttachInfo;
  public long LastMsgTime;
  
  static
  {
    ((byte[])cache_AttachInfo)[0] = 0;
  }
  
  public ClientOnlineNotfiyReq() {}
  
  public ClientOnlineNotfiyReq(byte[] paramArrayOfByte, long paramLong)
  {
    this.AttachInfo = paramArrayOfByte;
    this.LastMsgTime = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.AttachInfo = ((byte[])paramJceInputStream.read(cache_AttachInfo, 0, false));
    this.LastMsgTime = paramJceInputStream.read(this.LastMsgTime, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.AttachInfo != null) {
      paramJceOutputStream.write(this.AttachInfo, 0);
    }
    paramJceOutputStream.write(this.LastMsgTime, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     QzoneCombine.ClientOnlineNotfiyReq
 * JD-Core Version:    0.7.0.1
 */