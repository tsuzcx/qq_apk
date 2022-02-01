package NS_QZONE_FESTIVAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FestivalGetReqItem
  extends JceStruct
{
  public long mdays = 0L;
  public long month = 0L;
  public long time = 0L;
  public long type = 0L;
  public long year = 0L;
  
  public FestivalGetReqItem() {}
  
  public FestivalGetReqItem(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    this.time = paramLong1;
    this.year = paramLong2;
    this.month = paramLong3;
    this.mdays = paramLong4;
    this.type = paramLong5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.time = paramJceInputStream.read(this.time, 0, false);
    this.year = paramJceInputStream.read(this.year, 1, false);
    this.month = paramJceInputStream.read(this.month, 2, false);
    this.mdays = paramJceInputStream.read(this.mdays, 3, false);
    this.type = paramJceInputStream.read(this.type, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.time, 0);
    paramJceOutputStream.write(this.year, 1);
    paramJceOutputStream.write(this.month, 2);
    paramJceOutputStream.write(this.mdays, 3);
    paramJceOutputStream.write(this.type, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QZONE_FESTIVAL.FestivalGetReqItem
 * JD-Core Version:    0.7.0.1
 */