package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqHead
  extends JceStruct
{
  public int iVersion = 1;
  
  public ReqHead() {}
  
  public ReqHead(int paramInt)
  {
    this.iVersion = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iVersion = paramJceInputStream.read(this.iVersion, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iVersion, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     SummaryCard.ReqHead
 * JD-Core Version:    0.7.0.1
 */