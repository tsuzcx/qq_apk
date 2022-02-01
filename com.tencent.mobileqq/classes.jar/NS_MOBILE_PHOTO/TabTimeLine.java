package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class TabTimeLine
  extends JceStruct
{
  public long begin_time = 0L;
  public long end_time = 0L;
  public long month = 0L;
  public long year = 0L;
  
  public TabTimeLine() {}
  
  public TabTimeLine(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.year = paramLong1;
    this.month = paramLong2;
    this.begin_time = paramLong3;
    this.end_time = paramLong4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.year = paramJceInputStream.read(this.year, 0, false);
    this.month = paramJceInputStream.read(this.month, 1, false);
    this.begin_time = paramJceInputStream.read(this.begin_time, 2, false);
    this.end_time = paramJceInputStream.read(this.end_time, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.year, 0);
    paramJceOutputStream.write(this.month, 1);
    paramJceOutputStream.write(this.begin_time, 2);
    paramJceOutputStream.write(this.end_time, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.TabTimeLine
 * JD-Core Version:    0.7.0.1
 */