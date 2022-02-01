package ELABORATE_FEED_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class elaborate_feed_report_req
  extends JceStruct
{
  static ArrayList<session_report> cache_vecSessionReport = new ArrayList();
  public ArrayList<session_report> vecSessionReport = null;
  
  static
  {
    session_report localsession_report = new session_report();
    cache_vecSessionReport.add(localsession_report);
  }
  
  public elaborate_feed_report_req() {}
  
  public elaborate_feed_report_req(ArrayList<session_report> paramArrayList)
  {
    this.vecSessionReport = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vecSessionReport = ((ArrayList)paramJceInputStream.read(cache_vecSessionReport, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    ArrayList localArrayList = this.vecSessionReport;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ELABORATE_FEED_REPORT.elaborate_feed_report_req
 * JD-Core Version:    0.7.0.1
 */