package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class feed_info
  extends JceStruct
{
  public long uFeedCTime;
  public long uOrgFeedTime;
  public long uOrgFeedUin;
  
  public feed_info() {}
  
  public feed_info(long paramLong1, long paramLong2, long paramLong3)
  {
    this.uOrgFeedTime = paramLong1;
    this.uFeedCTime = paramLong2;
    this.uOrgFeedUin = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uOrgFeedTime = paramJceInputStream.read(this.uOrgFeedTime, 0, false);
    this.uFeedCTime = paramJceInputStream.read(this.uFeedCTime, 1, false);
    this.uOrgFeedUin = paramJceInputStream.read(this.uOrgFeedUin, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uOrgFeedTime, 0);
    paramJceOutputStream.write(this.uFeedCTime, 1);
    paramJceOutputStream.write(this.uOrgFeedUin, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_UNDEAL_COUNT.feed_info
 * JD-Core Version:    0.7.0.1
 */