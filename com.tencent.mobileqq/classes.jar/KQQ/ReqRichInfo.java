package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqRichInfo
  extends JceStruct
{
  public long dwTime;
  public long lUin;
  
  public ReqRichInfo() {}
  
  public ReqRichInfo(long paramLong1, long paramLong2)
  {
    this.lUin = paramLong1;
    this.dwTime = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 1, true);
    this.dwTime = paramJceInputStream.read(this.dwTime, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 1);
    paramJceOutputStream.write(this.dwTime, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     KQQ.ReqRichInfo
 * JD-Core Version:    0.7.0.1
 */