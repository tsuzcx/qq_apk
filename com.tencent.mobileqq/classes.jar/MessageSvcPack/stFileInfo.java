package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stFileInfo
  extends JceStruct
{
  static byte[] cache_strIndex;
  static byte[] cache_strKey;
  static byte[] cache_strMd5;
  static byte[] cache_strName;
  static byte[] cache_strOriginFileMd5;
  public long lLen = 0L;
  public long lSessionId = 0L;
  public byte[] strIndex = null;
  public byte[] strKey = null;
  public byte[] strMd5 = null;
  public byte[] strName = null;
  public byte[] strOriginFileMd5 = null;
  public long uOriginFileType = 0L;
  public long uSvrIp = 0L;
  public long uSvrPort = 0L;
  
  public stFileInfo() {}
  
  public stFileInfo(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, long paramLong1, long paramLong2, byte[] paramArrayOfByte5, long paramLong3, long paramLong4, long paramLong5)
  {
    this.strName = paramArrayOfByte1;
    this.strIndex = paramArrayOfByte2;
    this.strMd5 = paramArrayOfByte3;
    this.strKey = paramArrayOfByte4;
    this.uSvrIp = paramLong1;
    this.uSvrPort = paramLong2;
    this.strOriginFileMd5 = paramArrayOfByte5;
    this.lLen = paramLong3;
    this.lSessionId = paramLong4;
    this.uOriginFileType = paramLong5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_strName == null)
    {
      cache_strName = (byte[])new byte[1];
      ((byte[])cache_strName)[0] = 0;
    }
    this.strName = ((byte[])paramJceInputStream.read(cache_strName, 0, true));
    if (cache_strIndex == null)
    {
      cache_strIndex = (byte[])new byte[1];
      ((byte[])cache_strIndex)[0] = 0;
    }
    this.strIndex = ((byte[])paramJceInputStream.read(cache_strIndex, 1, true));
    if (cache_strMd5 == null)
    {
      cache_strMd5 = (byte[])new byte[1];
      ((byte[])cache_strMd5)[0] = 0;
    }
    this.strMd5 = ((byte[])paramJceInputStream.read(cache_strMd5, 2, true));
    if (cache_strKey == null)
    {
      cache_strKey = (byte[])new byte[1];
      ((byte[])cache_strKey)[0] = 0;
    }
    this.strKey = ((byte[])paramJceInputStream.read(cache_strKey, 3, true));
    this.uSvrIp = paramJceInputStream.read(this.uSvrIp, 4, true);
    this.uSvrPort = paramJceInputStream.read(this.uSvrPort, 5, true);
    if (cache_strOriginFileMd5 == null)
    {
      cache_strOriginFileMd5 = (byte[])new byte[1];
      ((byte[])cache_strOriginFileMd5)[0] = 0;
    }
    this.strOriginFileMd5 = ((byte[])paramJceInputStream.read(cache_strOriginFileMd5, 6, false));
    this.lLen = paramJceInputStream.read(this.lLen, 7, false);
    this.lSessionId = paramJceInputStream.read(this.lSessionId, 8, false);
    this.uOriginFileType = paramJceInputStream.read(this.uOriginFileType, 9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strName, 0);
    paramJceOutputStream.write(this.strIndex, 1);
    paramJceOutputStream.write(this.strMd5, 2);
    paramJceOutputStream.write(this.strKey, 3);
    paramJceOutputStream.write(this.uSvrIp, 4);
    paramJceOutputStream.write(this.uSvrPort, 5);
    if (this.strOriginFileMd5 != null) {
      paramJceOutputStream.write(this.strOriginFileMd5, 6);
    }
    paramJceOutputStream.write(this.lLen, 7);
    paramJceOutputStream.write(this.lSessionId, 8);
    paramJceOutputStream.write(this.uOriginFileType, 9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     MessageSvcPack.stFileInfo
 * JD-Core Version:    0.7.0.1
 */