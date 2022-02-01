package NS_USER_ACTION_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class UserActionReportReq
  extends JceStruct
{
  static ArrayList<UserActionReport> cache_report_infos;
  static ArrayList<QQSchemaInfo> cache_schema_infos;
  static ArrayList<QQStayTimeInfo> cache_stay_time_infos;
  static UserCommReport cache_user_comm_report = new UserCommReport();
  public ArrayList<UserActionReport> report_infos = null;
  public ArrayList<QQSchemaInfo> schema_infos = null;
  public ArrayList<QQStayTimeInfo> stay_time_infos = null;
  public int type = 0;
  public UserCommReport user_comm_report = null;
  
  static
  {
    cache_report_infos = new ArrayList();
    Object localObject = new UserActionReport();
    cache_report_infos.add(localObject);
    cache_stay_time_infos = new ArrayList();
    localObject = new QQStayTimeInfo();
    cache_stay_time_infos.add(localObject);
    cache_schema_infos = new ArrayList();
    localObject = new QQSchemaInfo();
    cache_schema_infos.add(localObject);
  }
  
  public UserActionReportReq() {}
  
  public UserActionReportReq(int paramInt, UserCommReport paramUserCommReport, ArrayList<UserActionReport> paramArrayList, ArrayList<QQStayTimeInfo> paramArrayList1, ArrayList<QQSchemaInfo> paramArrayList2)
  {
    this.type = paramInt;
    this.user_comm_report = paramUserCommReport;
    this.report_infos = paramArrayList;
    this.stay_time_infos = paramArrayList1;
    this.schema_infos = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, false);
    this.user_comm_report = ((UserCommReport)paramJceInputStream.read(cache_user_comm_report, 1, true));
    this.report_infos = ((ArrayList)paramJceInputStream.read(cache_report_infos, 2, false));
    this.stay_time_infos = ((ArrayList)paramJceInputStream.read(cache_stay_time_infos, 3, false));
    this.schema_infos = ((ArrayList)paramJceInputStream.read(cache_schema_infos, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    paramJceOutputStream.write(this.user_comm_report, 1);
    if (this.report_infos != null) {
      paramJceOutputStream.write(this.report_infos, 2);
    }
    if (this.stay_time_infos != null) {
      paramJceOutputStream.write(this.stay_time_infos, 3);
    }
    if (this.schema_infos != null) {
      paramJceOutputStream.write(this.schema_infos, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_USER_ACTION_REPORT.UserActionReportReq
 * JD-Core Version:    0.7.0.1
 */