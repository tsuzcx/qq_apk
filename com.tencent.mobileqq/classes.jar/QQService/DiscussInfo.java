package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class DiscussInfo
  extends JceStruct
{
  public long DiscussUin;
  public long InfoSeq;
  
  public DiscussInfo() {}
  
  public DiscussInfo(long paramLong1, long paramLong2)
  {
    this.DiscussUin = paramLong1;
    this.InfoSeq = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.DiscussUin = paramJceInputStream.read(this.DiscussUin, 0, true);
    this.InfoSeq = paramJceInputStream.read(this.InfoSeq, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.DiscussUin, 0);
    paramJceOutputStream.write(this.InfoSeq, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     QQService.DiscussInfo
 * JD-Core Version:    0.7.0.1
 */