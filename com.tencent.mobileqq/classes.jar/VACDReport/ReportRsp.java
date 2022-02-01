package VACDReport;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ReportRsp
  extends JceStruct
  implements Cloneable
{
  static ArrayList<ReportHeader> cache_headers;
  public ArrayList<ReportHeader> headers = null;
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_headers == null)
    {
      cache_headers = new ArrayList();
      ReportHeader localReportHeader = new ReportHeader();
      cache_headers.add(localReportHeader);
    }
    this.headers = ((ArrayList)paramJceInputStream.read(cache_headers, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.headers, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     VACDReport.ReportRsp
 * JD-Core Version:    0.7.0.1
 */