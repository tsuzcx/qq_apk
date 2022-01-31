package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ImageIterm
  extends JceStruct
{
  static int cache_type;
  public long height;
  public int type = 0;
  public String url = "";
  public long width;
  
  public ImageIterm() {}
  
  public ImageIterm(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    this.url = paramString;
    this.width = paramLong1;
    this.height = paramLong2;
    this.type = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.url = paramJceInputStream.readString(0, true);
    this.width = paramJceInputStream.read(this.width, 1, true);
    this.height = paramJceInputStream.read(this.height, 2, true);
    this.type = paramJceInputStream.read(this.type, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.url, 0);
    paramJceOutputStream.write(this.width, 1);
    paramJceOutputStream.write(this.height, 2);
    paramJceOutputStream.write(this.type, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_OPERATION.ImageIterm
 * JD-Core Version:    0.7.0.1
 */