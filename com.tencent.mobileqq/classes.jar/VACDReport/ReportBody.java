package VACDReport;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ReportBody
  extends JceStruct
  implements Cloneable
{
  static ArrayList cache_reportItems;
  public ArrayList reportItems;
  public String sKey = "";
  public long startTime;
  public long totalTime;
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sKey = paramJceInputStream.readString(0, false);
    this.startTime = paramJceInputStream.read(this.startTime, 1, false);
    this.totalTime = paramJceInputStream.read(this.totalTime, 2, false);
    if (cache_reportItems == null)
    {
      cache_reportItems = new ArrayList();
      ReportItem localReportItem = new ReportItem();
      cache_reportItems.add(localReportItem);
    }
    this.reportItems = ((ArrayList)paramJceInputStream.read(cache_reportItems, 3, false));
  }
  
  public String toString()
  {
    return 64 + this.sKey + "|" + this.startTime + "|" + this.totalTime;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.sKey != null) {
      paramJceOutputStream.write(this.sKey, 0);
    }
    paramJceOutputStream.write(this.startTime, 1);
    paramJceOutputStream.write(this.totalTime, 2);
    if (this.reportItems != null) {
      paramJceOutputStream.write(this.reportItems, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     VACDReport.ReportBody
 * JD-Core Version:    0.7.0.1
 */