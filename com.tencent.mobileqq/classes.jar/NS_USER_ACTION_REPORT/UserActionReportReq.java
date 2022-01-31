package NS_USER_ACTION_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class UserActionReportReq
  extends JceStruct
{
  static ArrayList<UserActionReport> cache_report_infos;
  static UserCommReport cache_user_comm_report = new UserCommReport();
  public ArrayList<UserActionReport> report_infos;
  public int type;
  public UserCommReport user_comm_report;
  
  static
  {
    cache_report_infos = new ArrayList();
    UserActionReport localUserActionReport = new UserActionReport();
    cache_report_infos.add(localUserActionReport);
  }
  
  public UserActionReportReq() {}
  
  public UserActionReportReq(int paramInt, UserCommReport paramUserCommReport, ArrayList<UserActionReport> paramArrayList)
  {
    this.type = paramInt;
    this.user_comm_report = paramUserCommReport;
    this.report_infos = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, false);
    this.user_comm_report = ((UserCommReport)paramJceInputStream.read(cache_user_comm_report, 1, true));
    this.report_infos = ((ArrayList)paramJceInputStream.read(cache_report_infos, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    paramJceOutputStream.write(this.user_comm_report, 1);
    if (this.report_infos != null) {
      paramJceOutputStream.write(this.report_infos, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_USER_ACTION_REPORT.UserActionReportReq
 * JD-Core Version:    0.7.0.1
 */