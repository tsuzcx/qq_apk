package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SetUserInfoReq
  extends JceStruct
{
  static byte[] cache_vecTLVValue;
  public long dwToUin;
  public byte[] vecTLVValue;
  public int wTLVCount;
  
  public SetUserInfoReq() {}
  
  public SetUserInfoReq(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    this.dwToUin = paramLong;
    this.wTLVCount = paramInt;
    this.vecTLVValue = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwToUin = paramJceInputStream.read(this.dwToUin, 0, true);
    this.wTLVCount = paramJceInputStream.read(this.wTLVCount, 1, true);
    if (cache_vecTLVValue == null)
    {
      cache_vecTLVValue = (byte[])new byte[1];
      ((byte[])cache_vecTLVValue)[0] = 0;
    }
    this.vecTLVValue = ((byte[])paramJceInputStream.read(cache_vecTLVValue, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwToUin, 0);
    paramJceOutputStream.write(this.wTLVCount, 1);
    paramJceOutputStream.write(this.vecTLVValue, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     KQQ.SetUserInfoReq
 * JD-Core Version:    0.7.0.1
 */