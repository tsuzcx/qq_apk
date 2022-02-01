package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class TimeStamp
  extends JceStruct
{
  public byte day = 0;
  public byte hour = 0;
  public byte month = 0;
  public int year = 0;
  
  public TimeStamp() {}
  
  public TimeStamp(int paramInt, byte paramByte1, byte paramByte2, byte paramByte3)
  {
    this.year = paramInt;
    this.month = paramByte1;
    this.day = paramByte2;
    this.hour = paramByte3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.year = paramJceInputStream.read(this.year, 1, true);
    this.month = paramJceInputStream.read(this.month, 2, true);
    this.day = paramJceInputStream.read(this.day, 3, true);
    this.hour = paramJceInputStream.read(this.hour, 4, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.year, 1);
    paramJceOutputStream.write(this.month, 2);
    paramJceOutputStream.write(this.day, 3);
    paramJceOutputStream.write(this.hour, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ConfigPush.TimeStamp
 * JD-Core Version:    0.7.0.1
 */