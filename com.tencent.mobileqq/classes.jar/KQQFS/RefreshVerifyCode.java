package KQQFS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RefreshVerifyCode
  extends JceStruct
{
  static byte[] cache_vEncryptUsrInfo;
  public byte bType;
  public byte[] vEncryptUsrInfo;
  
  public RefreshVerifyCode() {}
  
  public RefreshVerifyCode(byte[] paramArrayOfByte, byte paramByte)
  {
    this.vEncryptUsrInfo = paramArrayOfByte;
    this.bType = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vEncryptUsrInfo == null)
    {
      cache_vEncryptUsrInfo = (byte[])new byte[1];
      ((byte[])cache_vEncryptUsrInfo)[0] = 0;
    }
    this.vEncryptUsrInfo = ((byte[])paramJceInputStream.read(cache_vEncryptUsrInfo, 0, true));
    this.bType = paramJceInputStream.read(this.bType, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vEncryptUsrInfo, 0);
    paramJceOutputStream.write(this.bType, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     KQQFS.RefreshVerifyCode
 * JD-Core Version:    0.7.0.1
 */