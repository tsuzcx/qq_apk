package NS_MOBILE_FEEDS_GAMES;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class st_Games_MarketData
  extends JceStruct
{
  public String strZipUrl = "";
  public long uBeginTime;
  public long uEndTime;
  
  public st_Games_MarketData() {}
  
  public st_Games_MarketData(long paramLong1, long paramLong2, String paramString)
  {
    this.uBeginTime = paramLong1;
    this.uEndTime = paramLong2;
    this.strZipUrl = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uBeginTime = paramJceInputStream.read(this.uBeginTime, 0, false);
    this.uEndTime = paramJceInputStream.read(this.uEndTime, 1, false);
    this.strZipUrl = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uBeginTime, 0);
    paramJceOutputStream.write(this.uEndTime, 1);
    if (this.strZipUrl != null) {
      paramJceOutputStream.write(this.strZipUrl, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS_GAMES.st_Games_MarketData
 * JD-Core Version:    0.7.0.1
 */