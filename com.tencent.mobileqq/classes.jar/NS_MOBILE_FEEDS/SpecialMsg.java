package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SpecialMsg
  extends JceStruct
{
  static byte[] cache_msg = (byte[])new byte[1];
  public byte[] msg = null;
  public int type = 0;
  
  static
  {
    ((byte[])cache_msg)[0] = 0;
  }
  
  public SpecialMsg() {}
  
  public SpecialMsg(int paramInt, byte[] paramArrayOfByte)
  {
    this.type = paramInt;
    this.msg = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, false);
    this.msg = ((byte[])paramJceInputStream.read(cache_msg, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    byte[] arrayOfByte = this.msg;
    if (arrayOfByte != null) {
      paramJceOutputStream.write(arrayOfByte, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.SpecialMsg
 * JD-Core Version:    0.7.0.1
 */