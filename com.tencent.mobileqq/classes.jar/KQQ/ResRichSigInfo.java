package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ResRichSigInfo
  extends JceStruct
{
  static byte[] cache_vbSigInfo;
  public byte cStatus = -1;
  public long dwTime;
  public long lUin;
  public byte[] vbSigInfo;
  
  public ResRichSigInfo() {}
  
  public ResRichSigInfo(byte paramByte, long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    this.cStatus = paramByte;
    this.lUin = paramLong1;
    this.dwTime = paramLong2;
    this.vbSigInfo = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cStatus = paramJceInputStream.read(this.cStatus, 1, true);
    this.lUin = paramJceInputStream.read(this.lUin, 2, true);
    this.dwTime = paramJceInputStream.read(this.dwTime, 3, false);
    if (cache_vbSigInfo == null)
    {
      cache_vbSigInfo = (byte[])new byte[1];
      ((byte[])cache_vbSigInfo)[0] = 0;
    }
    this.vbSigInfo = ((byte[])paramJceInputStream.read(cache_vbSigInfo, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cStatus, 1);
    paramJceOutputStream.write(this.lUin, 2);
    paramJceOutputStream.write(this.dwTime, 3);
    if (this.vbSigInfo != null) {
      paramJceOutputStream.write(this.vbSigInfo, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     KQQ.ResRichSigInfo
 * JD-Core Version:    0.7.0.1
 */