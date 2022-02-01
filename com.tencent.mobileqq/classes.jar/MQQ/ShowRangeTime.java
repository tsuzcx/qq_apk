package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ShowRangeTime
  extends JceStruct
{
  public long beginTime = 0L;
  public long endTime = 0L;
  
  public ShowRangeTime() {}
  
  public ShowRangeTime(long paramLong1, long paramLong2)
  {
    this.beginTime = paramLong1;
    this.endTime = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.beginTime = paramJceInputStream.read(this.beginTime, 0, false);
    this.endTime = paramJceInputStream.read(this.endTime, 1, false);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShowRangeTime{beginTime=");
    localStringBuilder.append(this.beginTime);
    localStringBuilder.append(", endTime=");
    localStringBuilder.append(this.endTime);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.beginTime, 0);
    paramJceOutputStream.write(this.endTime, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MQQ.ShowRangeTime
 * JD-Core Version:    0.7.0.1
 */