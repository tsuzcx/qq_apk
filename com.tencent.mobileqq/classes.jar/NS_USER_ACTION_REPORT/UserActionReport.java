package NS_USER_ACTION_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UserActionReport
  extends JceStruct
{
  static PageInfo cache_page_info = new PageInfo();
  static TraceInfo cache_trace_info = new TraceInfo();
  public PageInfo page_info = null;
  public long to_uin = 0L;
  public TraceInfo trace_info = null;
  
  public UserActionReport() {}
  
  public UserActionReport(TraceInfo paramTraceInfo, PageInfo paramPageInfo, long paramLong)
  {
    this.trace_info = paramTraceInfo;
    this.page_info = paramPageInfo;
    this.to_uin = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.trace_info = ((TraceInfo)paramJceInputStream.read(cache_trace_info, 0, true));
    this.page_info = ((PageInfo)paramJceInputStream.read(cache_page_info, 1, true));
    this.to_uin = paramJceInputStream.read(this.to_uin, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.trace_info, 0);
    paramJceOutputStream.write(this.page_info, 1);
    paramJceOutputStream.write(this.to_uin, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_USER_ACTION_REPORT.UserActionReport
 * JD-Core Version:    0.7.0.1
 */