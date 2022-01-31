package OnlinePushPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CPicInfo
  extends JceStruct
{
  static byte[] cache_vHost;
  static byte[] cache_vPath;
  public byte[] vHost;
  public byte[] vPath;
  
  public CPicInfo() {}
  
  public CPicInfo(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.vPath = paramArrayOfByte1;
    this.vHost = paramArrayOfByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vPath == null)
    {
      cache_vPath = (byte[])new byte[1];
      ((byte[])cache_vPath)[0] = 0;
    }
    this.vPath = ((byte[])paramJceInputStream.read(cache_vPath, 0, true));
    if (cache_vHost == null)
    {
      cache_vHost = (byte[])new byte[1];
      ((byte[])cache_vHost)[0] = 0;
    }
    this.vHost = ((byte[])paramJceInputStream.read(cache_vHost, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vPath, 0);
    if (this.vHost != null) {
      paramJceOutputStream.write(this.vHost, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     OnlinePushPack.CPicInfo
 * JD-Core Version:    0.7.0.1
 */