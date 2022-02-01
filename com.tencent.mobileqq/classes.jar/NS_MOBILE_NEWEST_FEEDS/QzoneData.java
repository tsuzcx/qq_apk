package NS_MOBILE_NEWEST_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QzoneData
  extends JceStruct
{
  static byte[] cache_vcByte = (byte[])new byte[1];
  public int iType = 0;
  public byte[] vcByte = null;
  
  static
  {
    ((byte[])cache_vcByte)[0] = 0;
  }
  
  public QzoneData() {}
  
  public QzoneData(int paramInt, byte[] paramArrayOfByte)
  {
    this.iType = paramInt;
    this.vcByte = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iType = paramJceInputStream.read(this.iType, 0, false);
    this.vcByte = ((byte[])paramJceInputStream.read(cache_vcByte, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iType, 0);
    if (this.vcByte != null) {
      paramJceOutputStream.write(this.vcByte, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_NEWEST_FEEDS.QzoneData
 * JD-Core Version:    0.7.0.1
 */