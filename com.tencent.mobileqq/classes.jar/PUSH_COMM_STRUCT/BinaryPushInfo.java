package PUSH_COMM_STRUCT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class BinaryPushInfo
  extends JceStruct
{
  static byte[] cache_pushBuffer = (byte[])new byte[1];
  public long compressType = 0L;
  public byte[] pushBuffer = null;
  public long pushType = 0L;
  
  static
  {
    ((byte[])cache_pushBuffer)[0] = 0;
  }
  
  public BinaryPushInfo() {}
  
  public BinaryPushInfo(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    this.pushType = paramLong1;
    this.compressType = paramLong2;
    this.pushBuffer = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.pushType = paramJceInputStream.read(this.pushType, 0, false);
    this.compressType = paramJceInputStream.read(this.compressType, 1, false);
    this.pushBuffer = ((byte[])paramJceInputStream.read(cache_pushBuffer, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.pushType, 0);
    paramJceOutputStream.write(this.compressType, 1);
    byte[] arrayOfByte = this.pushBuffer;
    if (arrayOfByte != null) {
      paramJceOutputStream.write(arrayOfByte, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     PUSH_COMM_STRUCT.BinaryPushInfo
 * JD-Core Version:    0.7.0.1
 */