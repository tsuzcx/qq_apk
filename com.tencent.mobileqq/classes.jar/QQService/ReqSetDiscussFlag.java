package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqSetDiscussFlag
  extends JceStruct
{
  public long DiscussUin;
  public byte Flag;
  
  public ReqSetDiscussFlag() {}
  
  public ReqSetDiscussFlag(long paramLong, byte paramByte)
  {
    this.DiscussUin = paramLong;
    this.Flag = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.DiscussUin = paramJceInputStream.read(this.DiscussUin, 0, true);
    this.Flag = paramJceInputStream.read(this.Flag, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.DiscussUin, 0);
    paramJceOutputStream.write(this.Flag, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     QQService.ReqSetDiscussFlag
 * JD-Core Version:    0.7.0.1
 */