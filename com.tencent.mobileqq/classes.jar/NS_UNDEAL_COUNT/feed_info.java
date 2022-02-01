package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class feed_info
  extends JceStruct
{
  public String strText = "";
  public long uFeedCTime = 0L;
  public long uOrgFeedTime = 0L;
  public long uOrgFeedUin = 0L;
  
  public feed_info() {}
  
  public feed_info(long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    this.uOrgFeedTime = paramLong1;
    this.uFeedCTime = paramLong2;
    this.uOrgFeedUin = paramLong3;
    this.strText = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uOrgFeedTime = paramJceInputStream.read(this.uOrgFeedTime, 0, false);
    this.uFeedCTime = paramJceInputStream.read(this.uFeedCTime, 1, false);
    this.uOrgFeedUin = paramJceInputStream.read(this.uOrgFeedUin, 2, false);
    this.strText = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uOrgFeedTime, 0);
    paramJceOutputStream.write(this.uFeedCTime, 1);
    paramJceOutputStream.write(this.uOrgFeedUin, 2);
    if (this.strText != null) {
      paramJceOutputStream.write(this.strText, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_UNDEAL_COUNT.feed_info
 * JD-Core Version:    0.7.0.1
 */