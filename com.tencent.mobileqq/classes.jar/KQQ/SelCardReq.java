package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SelCardReq
  extends JceStruct
{
  public long m_LastOthMsg = 0L;
  public long m_LastPic = 0L;
  
  public SelCardReq() {}
  
  public SelCardReq(long paramLong1, long paramLong2)
  {
    this.m_LastPic = paramLong1;
    this.m_LastOthMsg = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.m_LastPic = paramJceInputStream.read(this.m_LastPic, 0, true);
    this.m_LastOthMsg = paramJceInputStream.read(this.m_LastOthMsg, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.m_LastPic, 0);
    paramJceOutputStream.write(this.m_LastOthMsg, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     KQQ.SelCardReq
 * JD-Core Version:    0.7.0.1
 */