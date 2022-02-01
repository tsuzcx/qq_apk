package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class HeartInfo
  extends JceStruct
{
  public int iHeartCount = 0;
  
  public HeartInfo() {}
  
  public HeartInfo(int paramInt)
  {
    this.iHeartCount = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iHeartCount = paramJceInputStream.read(this.iHeartCount, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iHeartCount, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SummaryCard.HeartInfo
 * JD-Core Version:    0.7.0.1
 */