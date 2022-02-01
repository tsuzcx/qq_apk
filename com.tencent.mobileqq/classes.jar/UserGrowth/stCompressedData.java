package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stCompressedData
  extends JceStruct
{
  static byte[] cache_compressed = (byte[])new byte[1];
  public byte[] compressed = null;
  
  static
  {
    ((byte[])cache_compressed)[0] = 0;
  }
  
  public stCompressedData() {}
  
  public stCompressedData(byte[] paramArrayOfByte)
  {
    this.compressed = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.compressed = ((byte[])paramJceInputStream.read(cache_compressed, 100, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.compressed != null) {
      paramJceOutputStream.write(this.compressed, 100);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stCompressedData
 * JD-Core Version:    0.7.0.1
 */