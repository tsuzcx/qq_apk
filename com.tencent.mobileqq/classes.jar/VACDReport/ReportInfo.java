package VACDReport;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReportInfo
  extends JceStruct
  implements Cloneable
{
  static ReportBody cache_body;
  static ReportHeader cache_header;
  public ReportBody body = null;
  public ReportHeader header = null;
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_header == null) {
      cache_header = new ReportHeader();
    }
    this.header = ((ReportHeader)paramJceInputStream.read(cache_header, 0, true));
    if (cache_body == null) {
      cache_body = new ReportBody();
    }
    this.body = ((ReportBody)paramJceInputStream.read(cache_body, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.header, 0);
    ReportBody localReportBody = this.body;
    if (localReportBody != null) {
      paramJceOutputStream.write(localReportBody, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     VACDReport.ReportInfo
 * JD-Core Version:    0.7.0.1
 */