package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class BatchRequest
  extends JceStruct
{
  static byte[] cache_buffer;
  static int cache_type;
  public byte[] buffer = null;
  public int seq = 0;
  public int type = 0;
  
  public BatchRequest() {}
  
  public BatchRequest(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    this.type = paramInt1;
    this.seq = paramInt2;
    this.buffer = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, false);
    this.seq = paramJceInputStream.read(this.seq, 1, false);
    if (cache_buffer == null)
    {
      cache_buffer = (byte[])new byte[1];
      ((byte[])cache_buffer)[0] = 0;
    }
    this.buffer = ((byte[])paramJceInputStream.read(cache_buffer, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    paramJceOutputStream.write(this.seq, 1);
    if (this.buffer != null) {
      paramJceOutputStream.write(this.buffer, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     KQQ.BatchRequest
 * JD-Core Version:    0.7.0.1
 */