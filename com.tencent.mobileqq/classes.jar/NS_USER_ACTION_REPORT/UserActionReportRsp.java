package NS_USER_ACTION_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class UserActionReportRsp
  extends JceStruct
{
  static ArrayList<String> cache_trace_details = new ArrayList();
  public int ret_code;
  public String ret_msg = "";
  public ArrayList<String> trace_details;
  
  static
  {
    cache_trace_details.add("");
  }
  
  public UserActionReportRsp() {}
  
  public UserActionReportRsp(int paramInt, String paramString, ArrayList<String> paramArrayList)
  {
    this.ret_code = paramInt;
    this.ret_msg = paramString;
    this.trace_details = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret_code = paramJceInputStream.read(this.ret_code, 0, false);
    this.ret_msg = paramJceInputStream.readString(1, false);
    this.trace_details = ((ArrayList)paramJceInputStream.read(cache_trace_details, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret_code, 0);
    if (this.ret_msg != null) {
      paramJceOutputStream.write(this.ret_msg, 1);
    }
    if (this.trace_details != null) {
      paramJceOutputStream.write(this.trace_details, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_USER_ACTION_REPORT.UserActionReportRsp
 * JD-Core Version:    0.7.0.1
 */