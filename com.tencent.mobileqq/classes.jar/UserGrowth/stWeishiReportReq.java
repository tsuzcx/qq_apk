package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class stWeishiReportReq
  extends JceStruct
{
  static ArrayList<stReportItem> cache_report_list = new ArrayList();
  public ArrayList<stReportItem> report_list = null;
  
  static
  {
    stReportItem localstReportItem = new stReportItem();
    cache_report_list.add(localstReportItem);
  }
  
  public stWeishiReportReq() {}
  
  public stWeishiReportReq(ArrayList<stReportItem> paramArrayList)
  {
    this.report_list = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.report_list = ((ArrayList)paramJceInputStream.read(cache_report_list, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    ArrayList localArrayList = this.report_list;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stWeishiReportReq
 * JD-Core Version:    0.7.0.1
 */