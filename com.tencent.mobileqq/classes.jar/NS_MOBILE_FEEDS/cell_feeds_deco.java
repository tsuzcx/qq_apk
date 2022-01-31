package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cell_feeds_deco
  extends JceStruct
{
  static byte[] cache_decoration = (byte[])new byte[1];
  public byte[] decoration;
  
  static
  {
    ((byte[])cache_decoration)[0] = 0;
  }
  
  public cell_feeds_deco() {}
  
  public cell_feeds_deco(byte[] paramArrayOfByte)
  {
    this.decoration = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.decoration = ((byte[])paramJceInputStream.read(cache_decoration, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.decoration != null) {
      paramJceOutputStream.write(this.decoration, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_feeds_deco
 * JD-Core Version:    0.7.0.1
 */