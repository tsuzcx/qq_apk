package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class LikeReq
  extends JceStruct
{
  static SourceInfo cache_stSource = new SourceInfo();
  public long fromUin = 0L;
  public SourceInfo stSource = null;
  public long toUin = 0L;
  
  public LikeReq() {}
  
  public LikeReq(long paramLong1, long paramLong2, SourceInfo paramSourceInfo)
  {
    this.fromUin = paramLong1;
    this.toUin = paramLong2;
    this.stSource = paramSourceInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.fromUin = paramJceInputStream.read(this.fromUin, 0, false);
    this.toUin = paramJceInputStream.read(this.toUin, 1, false);
    this.stSource = ((SourceInfo)paramJceInputStream.read(cache_stSource, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.fromUin, 0);
    paramJceOutputStream.write(this.toUin, 1);
    SourceInfo localSourceInfo = this.stSource;
    if (localSourceInfo != null) {
      paramJceOutputStream.write(localSourceInfo, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     VIP.LikeReq
 * JD-Core Version:    0.7.0.1
 */