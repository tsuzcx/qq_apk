package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_single_count
  extends JceStruct
{
  public int iControl = 0;
  public long uCount = 0L;
  
  public s_single_count() {}
  
  public s_single_count(long paramLong, int paramInt)
  {
    this.uCount = paramLong;
    this.iControl = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uCount = paramJceInputStream.read(this.uCount, 0, false);
    this.iControl = paramJceInputStream.read(this.iControl, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uCount, 0);
    paramJceOutputStream.write(this.iControl, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_single_count
 * JD-Core Version:    0.7.0.1
 */