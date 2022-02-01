package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class TTimInfo
  extends JceStruct
{
  public int iIsOnline = 0;
  
  public TTimInfo() {}
  
  public TTimInfo(int paramInt)
  {
    this.iIsOnline = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iIsOnline = paramJceInputStream.read(this.iIsOnline, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iIsOnline, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SummaryCard.TTimInfo
 * JD-Core Version:    0.7.0.1
 */