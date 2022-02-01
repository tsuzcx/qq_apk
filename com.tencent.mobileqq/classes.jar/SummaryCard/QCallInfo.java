package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QCallInfo
  extends JceStruct
{
  static int cache_bStatus;
  public int bStatus = 0;
  public String strNick = "";
  public long uQCallId = 0L;
  
  public QCallInfo() {}
  
  public QCallInfo(int paramInt, String paramString, long paramLong)
  {
    this.bStatus = paramInt;
    this.strNick = paramString;
    this.uQCallId = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bStatus = paramJceInputStream.read(this.bStatus, 0, false);
    this.strNick = paramJceInputStream.readString(1, false);
    this.uQCallId = paramJceInputStream.read(this.uQCallId, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.bStatus, 0);
    if (this.strNick != null) {
      paramJceOutputStream.write(this.strNick, 1);
    }
    paramJceOutputStream.write(this.uQCallId, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SummaryCard.QCallInfo
 * JD-Core Version:    0.7.0.1
 */