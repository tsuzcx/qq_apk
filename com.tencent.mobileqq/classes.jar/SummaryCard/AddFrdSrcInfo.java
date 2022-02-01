package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AddFrdSrcInfo
  extends JceStruct
{
  public String strSrcName = "";
  public long uSrcId = 0L;
  public long uSubSrcId = 0L;
  
  public AddFrdSrcInfo() {}
  
  public AddFrdSrcInfo(String paramString, long paramLong1, long paramLong2)
  {
    this.strSrcName = paramString;
    this.uSrcId = paramLong1;
    this.uSubSrcId = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strSrcName = paramJceInputStream.readString(0, false);
    this.uSrcId = paramJceInputStream.read(this.uSrcId, 1, false);
    this.uSubSrcId = paramJceInputStream.read(this.uSubSrcId, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.strSrcName;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    paramJceOutputStream.write(this.uSrcId, 1);
    paramJceOutputStream.write(this.uSubSrcId, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SummaryCard.AddFrdSrcInfo
 * JD-Core Version:    0.7.0.1
 */