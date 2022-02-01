package VACDReport;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReportItem
  extends JceStruct
  implements Cloneable, Comparable<ReportItem>
{
  public long costTime = 0L;
  public long createTime = 0L;
  public String failReason = "";
  public boolean isNormalEnd = false;
  public String params = "";
  public int result = 0;
  public long seqno = 0L;
  public String step = "";
  
  public int compareTo(ReportItem paramReportItem)
  {
    long l1 = this.createTime;
    long l2 = paramReportItem.createTime;
    if (l1 < l2) {
      return -1;
    }
    if (l1 == l2) {
      return 0;
    }
    return 1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.step = paramJceInputStream.readString(0, false);
    this.costTime = paramJceInputStream.read(this.costTime, 1, false);
    this.params = paramJceInputStream.readString(2, false);
    this.result = paramJceInputStream.read(this.result, 3, false);
    this.failReason = paramJceInputStream.readString(4, false);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.step);
    localStringBuilder.append("|");
    localStringBuilder.append(this.result);
    localStringBuilder.append("|");
    localStringBuilder.append(this.createTime);
    localStringBuilder.append("|");
    localStringBuilder.append(this.costTime);
    localStringBuilder.append("|");
    localStringBuilder.append(this.isNormalEnd);
    localStringBuilder.append("|");
    localStringBuilder.append(this.params);
    localStringBuilder.append("|");
    localStringBuilder.append(this.failReason);
    return localStringBuilder.toString();
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.step;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    paramJceOutputStream.write(this.costTime, 1);
    str = this.params;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    paramJceOutputStream.write(this.result, 3);
    str = this.failReason;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     VACDReport.ReportItem
 * JD-Core Version:    0.7.0.1
 */