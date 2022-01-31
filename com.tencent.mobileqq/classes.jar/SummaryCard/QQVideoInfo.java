package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QQVideoInfo
  extends JceStruct
{
  public long uHollywoodLevel;
  public long uVipFlag;
  
  public QQVideoInfo() {}
  
  public QQVideoInfo(long paramLong1, long paramLong2)
  {
    this.uVipFlag = paramLong1;
    this.uHollywoodLevel = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uVipFlag = paramJceInputStream.read(this.uVipFlag, 0, false);
    this.uHollywoodLevel = paramJceInputStream.read(this.uHollywoodLevel, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uVipFlag, 0);
    paramJceOutputStream.write(this.uHollywoodLevel, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     SummaryCard.QQVideoInfo
 * JD-Core Version:    0.7.0.1
 */