package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UserFeed
  extends JceStruct
{
  static byte[] cache_vFeedInfo;
  public long uFlag;
  public byte[] vFeedInfo;
  
  public UserFeed() {}
  
  public UserFeed(long paramLong, byte[] paramArrayOfByte)
  {
    this.uFlag = paramLong;
    this.vFeedInfo = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uFlag = paramJceInputStream.read(this.uFlag, 0, false);
    if (cache_vFeedInfo == null)
    {
      cache_vFeedInfo = (byte[])new byte[1];
      ((byte[])cache_vFeedInfo)[0] = 0;
    }
    this.vFeedInfo = ((byte[])paramJceInputStream.read(cache_vFeedInfo, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uFlag, 0);
    if (this.vFeedInfo != null) {
      paramJceOutputStream.write(this.vFeedInfo, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     SummaryCard.UserFeed
 * JD-Core Version:    0.7.0.1
 */