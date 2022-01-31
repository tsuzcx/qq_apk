package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CustomColor
  extends JceStruct
{
  public byte a;
  public byte b;
  public byte g;
  public byte r;
  
  public CustomColor() {}
  
  public CustomColor(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4)
  {
    this.a = paramByte1;
    this.r = paramByte2;
    this.g = paramByte3;
    this.b = paramByte4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, false);
    this.r = paramJceInputStream.read(this.r, 1, false);
    this.g = paramJceInputStream.read(this.g, 2, false);
    this.b = paramJceInputStream.read(this.b, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.r, 1);
    paramJceOutputStream.write(this.g, 2);
    paramJceOutputStream.write(this.b, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_CUSTOM.CustomColor
 * JD-Core Version:    0.7.0.1
 */