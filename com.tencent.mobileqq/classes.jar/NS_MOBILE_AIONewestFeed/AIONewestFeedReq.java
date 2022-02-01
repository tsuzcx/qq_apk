package NS_MOBILE_AIONewestFeed;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class AIONewestFeedReq
  extends JceStruct
{
  static ArrayList<Long> cache_uHostUin = new ArrayList();
  public int src = 0;
  public ArrayList<Long> uHostUin = null;
  public long uLastTime = 0L;
  public long uOpUin = 0L;
  
  static
  {
    cache_uHostUin.add(Long.valueOf(0L));
  }
  
  public AIONewestFeedReq() {}
  
  public AIONewestFeedReq(long paramLong1, ArrayList<Long> paramArrayList, long paramLong2, int paramInt)
  {
    this.uOpUin = paramLong1;
    this.uHostUin = paramArrayList;
    this.uLastTime = paramLong2;
    this.src = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uOpUin = paramJceInputStream.read(this.uOpUin, 0, false);
    this.uHostUin = ((ArrayList)paramJceInputStream.read(cache_uHostUin, 1, false));
    this.uLastTime = paramJceInputStream.read(this.uLastTime, 2, false);
    this.src = paramJceInputStream.read(this.src, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uOpUin, 0);
    if (this.uHostUin != null) {
      paramJceOutputStream.write(this.uHostUin, 1);
    }
    paramJceOutputStream.write(this.uLastTime, 2);
    paramJceOutputStream.write(this.src, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_AIONewestFeed.AIONewestFeedReq
 * JD-Core Version:    0.7.0.1
 */