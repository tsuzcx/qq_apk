package NS_MINI_REALTIMELOG;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class REALTIMELOG$StReportLogReq
  extends MessageMicro<StReportLogReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 50, 58, 66 }, new String[] { "extInfo", "traceid", "report_time", "jslib_version", "page", "filter_msgs", "logs", "appid" }, new Object[] { null, "", Long.valueOf(0L), "", "", "", null, "" }, StReportLogReq.class);
  public final PBStringField appid = PBField.initString("");
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBRepeatField<String> filter_msgs = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField jslib_version = PBField.initString("");
  public final PBRepeatMessageField<REALTIMELOG.StLogItem> logs = PBField.initRepeatMessage(REALTIMELOG.StLogItem.class);
  public final PBStringField page = PBField.initString("");
  public final PBInt64Field report_time = PBField.initInt64(0L);
  public final PBStringField traceid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_REALTIMELOG.REALTIMELOG.StReportLogReq
 * JD-Core Version:    0.7.0.1
 */