package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class HttpDownloadReq
  extends JceStruct
{
  static byte[] cache_vFileKey;
  static byte[] cache_vSignature;
  public long lAppID;
  public long lToMID;
  public short shPicScale;
  public byte[] vFileKey;
  public byte[] vSignature;
  
  public HttpDownloadReq() {}
  
  public HttpDownloadReq(long paramLong1, long paramLong2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, short paramShort)
  {
    this.lToMID = paramLong1;
    this.lAppID = paramLong2;
    this.vFileKey = paramArrayOfByte1;
    this.vSignature = paramArrayOfByte2;
    this.shPicScale = paramShort;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lToMID = paramJceInputStream.read(this.lToMID, 0, true);
    this.lAppID = paramJceInputStream.read(this.lAppID, 1, true);
    if (cache_vFileKey == null)
    {
      cache_vFileKey = (byte[])new byte[1];
      ((byte[])cache_vFileKey)[0] = 0;
    }
    this.vFileKey = ((byte[])paramJceInputStream.read(cache_vFileKey, 2, true));
    if (cache_vSignature == null)
    {
      cache_vSignature = (byte[])new byte[1];
      ((byte[])cache_vSignature)[0] = 0;
    }
    this.vSignature = ((byte[])paramJceInputStream.read(cache_vSignature, 3, true));
    this.shPicScale = paramJceInputStream.read(this.shPicScale, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lToMID, 0);
    paramJceOutputStream.write(this.lAppID, 1);
    paramJceOutputStream.write(this.vFileKey, 2);
    paramJceOutputStream.write(this.vSignature, 3);
    paramJceOutputStream.write(this.shPicScale, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     KQQ.HttpDownloadReq
 * JD-Core Version:    0.7.0.1
 */