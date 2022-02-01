package KQQFS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class HttpDownloadReq
  extends JceStruct
{
  static byte[] cache_vEncryptUsrInfo;
  static byte[] cache_vFileKey;
  public short shPicScale = 0;
  public int uFromPos = 0;
  public int uLength = 0;
  public byte[] vEncryptUsrInfo = null;
  public byte[] vFileKey = null;
  
  public HttpDownloadReq() {}
  
  public HttpDownloadReq(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, short paramShort)
  {
    this.vEncryptUsrInfo = paramArrayOfByte1;
    this.vFileKey = paramArrayOfByte2;
    this.uFromPos = paramInt1;
    this.uLength = paramInt2;
    this.shPicScale = paramShort;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vEncryptUsrInfo == null)
    {
      cache_vEncryptUsrInfo = (byte[])new byte[1];
      ((byte[])cache_vEncryptUsrInfo)[0] = 0;
    }
    this.vEncryptUsrInfo = ((byte[])paramJceInputStream.read(cache_vEncryptUsrInfo, 0, true));
    if (cache_vFileKey == null)
    {
      cache_vFileKey = (byte[])new byte[1];
      ((byte[])cache_vFileKey)[0] = 0;
    }
    this.vFileKey = ((byte[])paramJceInputStream.read(cache_vFileKey, 1, true));
    this.uFromPos = paramJceInputStream.read(this.uFromPos, 2, true);
    this.uLength = paramJceInputStream.read(this.uLength, 3, true);
    this.shPicScale = paramJceInputStream.read(this.shPicScale, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vEncryptUsrInfo, 0);
    paramJceOutputStream.write(this.vFileKey, 1);
    paramJceOutputStream.write(this.uFromPos, 2);
    paramJceOutputStream.write(this.uLength, 3);
    paramJceOutputStream.write(this.shPicScale, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     KQQFS.HttpDownloadReq
 * JD-Core Version:    0.7.0.1
 */