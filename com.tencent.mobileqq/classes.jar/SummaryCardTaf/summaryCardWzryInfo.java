package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class summaryCardWzryInfo
  extends JceStruct
{
  public int honorId;
  public String strRecord = "";
  
  public summaryCardWzryInfo() {}
  
  public summaryCardWzryInfo(int paramInt, String paramString)
  {
    this.honorId = paramInt;
    this.strRecord = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.honorId = paramJceInputStream.read(this.honorId, 0, false);
    this.strRecord = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.honorId, 0);
    if (this.strRecord != null) {
      paramJceOutputStream.write(this.strRecord, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     SummaryCardTaf.summaryCardWzryInfo
 * JD-Core Version:    0.7.0.1
 */