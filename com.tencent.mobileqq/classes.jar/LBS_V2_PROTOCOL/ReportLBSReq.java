package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReportLBSReq
  extends JceStruct
{
  static ReportLBSInfo cache_stReportInfo = new ReportLBSInfo();
  public ReportLBSInfo stReportInfo;
  
  public ReportLBSReq() {}
  
  public ReportLBSReq(ReportLBSInfo paramReportLBSInfo)
  {
    this.stReportInfo = paramReportLBSInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stReportInfo = ((ReportLBSInfo)paramJceInputStream.read(cache_stReportInfo, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stReportInfo != null) {
      paramJceOutputStream.write(this.stReportInfo, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     LBS_V2_PROTOCOL.ReportLBSReq
 * JD-Core Version:    0.7.0.1
 */