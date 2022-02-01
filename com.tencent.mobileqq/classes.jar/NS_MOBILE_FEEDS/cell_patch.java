package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cell_patch
  extends JceStruct
{
  public long uTestNum = 0L;
  
  public cell_patch() {}
  
  public cell_patch(long paramLong)
  {
    this.uTestNum = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uTestNum = paramJceInputStream.read(this.uTestNum, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uTestNum, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_patch
 * JD-Core Version:    0.7.0.1
 */