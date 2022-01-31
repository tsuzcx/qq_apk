package OnlinePushPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class DelMsgInfo
  extends JceStruct
{
  static byte[] cache_vMsgCookies;
  public int clientIp;
  public long lFromUin;
  public long lSendTime;
  public short shMsgSeq;
  public int ssoIp;
  public int ssoSeq;
  public long uAppId;
  public long uMsgTime;
  public long uMsgType;
  public byte[] vMsgCookies;
  public short wCmd;
  
  public DelMsgInfo() {}
  
  public DelMsgInfo(long paramLong1, long paramLong2, short paramShort1, byte[] paramArrayOfByte, short paramShort2, long paramLong3, long paramLong4, long paramLong5, int paramInt1, int paramInt2, int paramInt3)
  {
    this.lFromUin = paramLong1;
    this.uMsgTime = paramLong2;
    this.shMsgSeq = paramShort1;
    this.vMsgCookies = paramArrayOfByte;
    this.wCmd = paramShort2;
    this.uMsgType = paramLong3;
    this.uAppId = paramLong4;
    this.lSendTime = paramLong5;
    this.ssoSeq = paramInt1;
    this.ssoIp = paramInt2;
    this.clientIp = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lFromUin = paramJceInputStream.read(this.lFromUin, 0, true);
    this.uMsgTime = paramJceInputStream.read(this.uMsgTime, 1, true);
    this.shMsgSeq = paramJceInputStream.read(this.shMsgSeq, 2, true);
    if (cache_vMsgCookies == null)
    {
      cache_vMsgCookies = (byte[])new byte[1];
      ((byte[])cache_vMsgCookies)[0] = 0;
    }
    this.vMsgCookies = ((byte[])paramJceInputStream.read(cache_vMsgCookies, 3, false));
    this.wCmd = paramJceInputStream.read(this.wCmd, 4, false);
    this.uMsgType = paramJceInputStream.read(this.uMsgType, 5, false);
    this.uAppId = paramJceInputStream.read(this.uAppId, 6, false);
    this.lSendTime = paramJceInputStream.read(this.lSendTime, 7, false);
    this.ssoSeq = paramJceInputStream.read(this.ssoSeq, 8, false);
    this.ssoIp = paramJceInputStream.read(this.ssoIp, 9, false);
    this.clientIp = paramJceInputStream.read(this.clientIp, 10, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lFromUin, 0);
    paramJceOutputStream.write(this.uMsgTime, 1);
    paramJceOutputStream.write(this.shMsgSeq, 2);
    if (this.vMsgCookies != null) {
      paramJceOutputStream.write(this.vMsgCookies, 3);
    }
    paramJceOutputStream.write(this.wCmd, 4);
    paramJceOutputStream.write(this.uMsgType, 5);
    paramJceOutputStream.write(this.uAppId, 6);
    paramJceOutputStream.write(this.lSendTime, 7);
    paramJceOutputStream.write(this.ssoSeq, 8);
    paramJceOutputStream.write(this.ssoIp, 9);
    paramJceOutputStream.write(this.clientIp, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     OnlinePushPack.DelMsgInfo
 * JD-Core Version:    0.7.0.1
 */