package QMF_PROTOCAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QmfUpstream
  extends JceStruct
{
  static byte[] cache_BusiBuff;
  static byte[] cache_Extra;
  static QmfClientIpInfo cache_IpInfo;
  static QmfTokenInfo cache_Token;
  static RetryInfo cache_retryinfo;
  public int Appid;
  public byte[] BusiBuff;
  public String DeviceInfo = "";
  public byte[] Extra;
  public QmfClientIpInfo IpInfo;
  public String Qua = "";
  public int Seq;
  public String ServiceCmd = "";
  public QmfTokenInfo Token;
  public long Uin;
  public long flag;
  public RetryInfo retryinfo;
  public long sessionID;
  
  public QmfUpstream() {}
  
  public QmfUpstream(int paramInt1, int paramInt2, long paramLong1, String paramString1, String paramString2, String paramString3, QmfTokenInfo paramQmfTokenInfo, QmfClientIpInfo paramQmfClientIpInfo, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong2, long paramLong3, RetryInfo paramRetryInfo)
  {
    this.Seq = paramInt1;
    this.Appid = paramInt2;
    this.Uin = paramLong1;
    this.Qua = paramString1;
    this.ServiceCmd = paramString2;
    this.DeviceInfo = paramString3;
    this.Token = paramQmfTokenInfo;
    this.IpInfo = paramQmfClientIpInfo;
    this.BusiBuff = paramArrayOfByte1;
    this.Extra = paramArrayOfByte2;
    this.flag = paramLong2;
    this.sessionID = paramLong3;
    this.retryinfo = paramRetryInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Seq = paramJceInputStream.read(this.Seq, 0, true);
    this.Appid = paramJceInputStream.read(this.Appid, 1, true);
    this.Uin = paramJceInputStream.read(this.Uin, 2, true);
    this.Qua = paramJceInputStream.readString(3, true);
    this.ServiceCmd = paramJceInputStream.readString(4, true);
    this.DeviceInfo = paramJceInputStream.readString(5, true);
    if (cache_Token == null) {
      cache_Token = new QmfTokenInfo();
    }
    this.Token = ((QmfTokenInfo)paramJceInputStream.read(cache_Token, 6, true));
    if (cache_IpInfo == null) {
      cache_IpInfo = new QmfClientIpInfo();
    }
    this.IpInfo = ((QmfClientIpInfo)paramJceInputStream.read(cache_IpInfo, 7, true));
    if (cache_BusiBuff == null)
    {
      cache_BusiBuff = (byte[])new byte[1];
      ((byte[])cache_BusiBuff)[0] = 0;
    }
    this.BusiBuff = ((byte[])paramJceInputStream.read(cache_BusiBuff, 8, true));
    if (cache_Extra == null)
    {
      cache_Extra = (byte[])new byte[1];
      ((byte[])cache_Extra)[0] = 0;
    }
    this.Extra = ((byte[])paramJceInputStream.read(cache_Extra, 9, true));
    this.flag = paramJceInputStream.read(this.flag, 10, false);
    this.sessionID = paramJceInputStream.read(this.sessionID, 11, false);
    if (cache_retryinfo == null) {
      cache_retryinfo = new RetryInfo();
    }
    this.retryinfo = ((RetryInfo)paramJceInputStream.read(cache_retryinfo, 12, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Seq, 0);
    paramJceOutputStream.write(this.Appid, 1);
    paramJceOutputStream.write(this.Uin, 2);
    paramJceOutputStream.write(this.Qua, 3);
    paramJceOutputStream.write(this.ServiceCmd, 4);
    paramJceOutputStream.write(this.DeviceInfo, 5);
    paramJceOutputStream.write(this.Token, 6);
    paramJceOutputStream.write(this.IpInfo, 7);
    paramJceOutputStream.write(this.BusiBuff, 8);
    paramJceOutputStream.write(this.Extra, 9);
    paramJceOutputStream.write(this.flag, 10);
    paramJceOutputStream.write(this.sessionID, 11);
    if (this.retryinfo != null) {
      paramJceOutputStream.write(this.retryinfo, 12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     QMF_PROTOCAL.QmfUpstream
 * JD-Core Version:    0.7.0.1
 */