package NS_USER_ACTION_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class UserActionReportRsp
  extends JceStruct
{
  static ArrayList<String> cache_trace_details = new ArrayList();
  public long report_interval = 0L;
  public int ret_code = 0;
  public String ret_msg = "";
  public ArrayList<String> trace_details = null;
  
  static
  {
    cache_trace_details.add("");
  }
  
  public UserActionReportRsp() {}
  
  public UserActionReportRsp(int paramInt, String paramString, ArrayList<String> paramArrayList, long paramLong)
  {
    this.ret_code = paramInt;
    this.ret_msg = paramString;
    this.trace_details = paramArrayList;
    this.report_interval = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret_code = paramJceInputStream.read(this.ret_code, 0, false);
    this.ret_msg = paramJceInputStream.readString(1, false);
    this.trace_details = ((ArrayList)paramJceInputStream.read(cache_trace_details, 2, false));
    this.report_interval = paramJceInputStream.read(this.report_interval, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret_code, 0);
    Object localObject = this.ret_msg;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.trace_details;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
    paramJceOutputStream.write(this.report_interval, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_USER_ACTION_REPORT.UserActionReportRsp
 * JD-Core Version:    0.7.0.1
 */