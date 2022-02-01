package NS_COMM_VIP_GROWTH;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class DouScoreInfo
  extends JceStruct
{
  public long uiDouScoreExpTime = 0L;
  public long uiDouTimes = 0L;
  
  public DouScoreInfo() {}
  
  public DouScoreInfo(long paramLong1, long paramLong2)
  {
    this.uiDouTimes = paramLong1;
    this.uiDouScoreExpTime = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uiDouTimes = paramJceInputStream.read(this.uiDouTimes, 0, false);
    this.uiDouScoreExpTime = paramJceInputStream.read(this.uiDouScoreExpTime, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uiDouTimes, 0);
    paramJceOutputStream.write(this.uiDouScoreExpTime, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_COMM_VIP_GROWTH.DouScoreInfo
 * JD-Core Version:    0.7.0.1
 */