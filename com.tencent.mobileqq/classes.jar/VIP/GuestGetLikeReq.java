package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GuestGetLikeReq
  extends JceStruct
{
  public long fromUin = 0L;
  public long toUin = 0L;
  
  public GuestGetLikeReq() {}
  
  public GuestGetLikeReq(long paramLong1, long paramLong2)
  {
    this.fromUin = paramLong1;
    this.toUin = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.fromUin = paramJceInputStream.read(this.fromUin, 0, false);
    this.toUin = paramJceInputStream.read(this.toUin, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.fromUin, 0);
    paramJceOutputStream.write(this.toUin, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     VIP.GuestGetLikeReq
 * JD-Core Version:    0.7.0.1
 */