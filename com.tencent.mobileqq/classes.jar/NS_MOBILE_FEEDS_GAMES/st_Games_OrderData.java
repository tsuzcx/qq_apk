package NS_MOBILE_FEEDS_GAMES;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class st_Games_OrderData
  extends JceStruct
{
  public long uFrdRanking = 0L;
  public long uWinCount = 0L;
  
  public st_Games_OrderData() {}
  
  public st_Games_OrderData(long paramLong1, long paramLong2)
  {
    this.uWinCount = paramLong1;
    this.uFrdRanking = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uWinCount = paramJceInputStream.read(this.uWinCount, 0, false);
    this.uFrdRanking = paramJceInputStream.read(this.uFrdRanking, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uWinCount, 0);
    paramJceOutputStream.write(this.uFrdRanking, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS_GAMES.st_Games_OrderData
 * JD-Core Version:    0.7.0.1
 */