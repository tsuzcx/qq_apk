package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class BindUin
  extends JceStruct
{
  static byte[] cache_sKey;
  public int iStatus = 11;
  public long lUin;
  public byte[] sKey;
  
  public BindUin() {}
  
  public BindUin(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    this.lUin = paramLong;
    this.sKey = paramArrayOfByte;
    this.iStatus = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    if (cache_sKey == null)
    {
      cache_sKey = (byte[])new byte[1];
      ((byte[])cache_sKey)[0] = 0;
    }
    this.sKey = ((byte[])paramJceInputStream.read(cache_sKey, 1, true));
    this.iStatus = paramJceInputStream.read(this.iStatus, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.sKey, 1);
    paramJceOutputStream.write(this.iStatus, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     QQService.BindUin
 * JD-Core Version:    0.7.0.1
 */