package VACDReport;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class ReportBody
  extends JceStruct
  implements Cloneable
{
  static ArrayList<ReportItem> cache_reportItems;
  public ArrayList<ReportItem> reportItems = null;
  public String sKey = "";
  public long startTime = 0L;
  public long totalTime = 0L;
  
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
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append(this.sKey);
    localStringBuilder.append("|");
    localStringBuilder.append(this.startTime);
    localStringBuilder.append("|");
    localStringBuilder.append(this.totalTime);
    return localStringBuilder.toString();
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.sKey;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    paramJceOutputStream.write(this.startTime, 1);
    paramJceOutputStream.write(this.totalTime, 2);
    localObject = this.reportItems;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     VACDReport.ReportBody
 * JD-Core Version:    0.7.0.1
 */