package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QiqiVideoInfo
  extends JceStruct
{
  public long uRoomid;
  
  public QiqiVideoInfo() {}
  
  public QiqiVideoInfo(long paramLong)
  {
    this.uRoomid = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uRoomid = paramJceInputStream.read(this.uRoomid, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uRoomid, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     SummaryCard.QiqiVideoInfo
 * JD-Core Version:    0.7.0.1
 */