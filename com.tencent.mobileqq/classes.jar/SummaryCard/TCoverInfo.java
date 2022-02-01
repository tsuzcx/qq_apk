package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class TCoverInfo
  extends JceStruct
{
  static byte[] cache_vTagInfo = (byte[])new byte[1];
  public byte[] vTagInfo = null;
  
  static
  {
    ((byte[])cache_vTagInfo)[0] = 0;
  }
  
  public TCoverInfo() {}
  
  public TCoverInfo(byte[] paramArrayOfByte)
  {
    this.vTagInfo = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vTagInfo = ((byte[])paramJceInputStream.read(cache_vTagInfo, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    byte[] arrayOfByte = this.vTagInfo;
    if (arrayOfByte != null) {
      paramJceOutputStream.write(arrayOfByte, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SummaryCard.TCoverInfo
 * JD-Core Version:    0.7.0.1
 */