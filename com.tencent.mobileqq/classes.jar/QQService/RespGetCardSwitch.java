package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RespGetCardSwitch
  extends JceStruct
{
  static RespHead cache_stHeader;
  public RespHead stHeader;
  public long uCloseNeighborVote;
  public long uCloseTimeGateVote;
  
  public RespGetCardSwitch() {}
  
  public RespGetCardSwitch(RespHead paramRespHead, long paramLong1, long paramLong2)
  {
    this.stHeader = paramRespHead;
    this.uCloseNeighborVote = paramLong1;
    this.uCloseTimeGateVote = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHead();
    }
    this.stHeader = ((RespHead)paramJceInputStream.read(cache_stHeader, 0, true));
    this.uCloseNeighborVote = paramJceInputStream.read(this.uCloseNeighborVote, 1, true);
    this.uCloseTimeGateVote = paramJceInputStream.read(this.uCloseTimeGateVote, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.uCloseNeighborVote, 1);
    paramJceOutputStream.write(this.uCloseTimeGateVote, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     QQService.RespGetCardSwitch
 * JD-Core Version:    0.7.0.1
 */