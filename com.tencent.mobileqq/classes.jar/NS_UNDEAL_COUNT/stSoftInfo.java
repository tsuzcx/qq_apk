package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stSoftInfo
  extends JceStruct
{
  public long end_time;
  public long soft_type;
  public long start_time;
  
  public stSoftInfo() {}
  
  public stSoftInfo(long paramLong1, long paramLong2, long paramLong3)
  {
    this.soft_type = paramLong1;
    this.start_time = paramLong2;
    this.end_time = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.soft_type = paramJceInputStream.read(this.soft_type, 0, false);
    this.start_time = paramJceInputStream.read(this.start_time, 1, false);
    this.end_time = paramJceInputStream.read(this.end_time, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.soft_type, 0);
    paramJceOutputStream.write(this.start_time, 1);
    paramJceOutputStream.write(this.end_time, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_UNDEAL_COUNT.stSoftInfo
 * JD-Core Version:    0.7.0.1
 */