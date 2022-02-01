package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RespJoinDiscuss
  extends JceStruct
{
  public long DiscussUin = 0L;
  
  public RespJoinDiscuss() {}
  
  public RespJoinDiscuss(long paramLong)
  {
    this.DiscussUin = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.DiscussUin = paramJceInputStream.read(this.DiscussUin, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.DiscussUin, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QQService.RespJoinDiscuss
 * JD-Core Version:    0.7.0.1
 */