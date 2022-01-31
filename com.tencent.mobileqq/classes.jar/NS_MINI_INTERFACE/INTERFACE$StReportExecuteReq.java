package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StReportExecuteReq
  extends MessageMicro<StReportExecuteReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42 }, new String[] { "extInfo", "appid", "instrTraceId", "execTime", "ruleName" }, new Object[] { null, "", "", Integer.valueOf(0), "" }, StReportExecuteReq.class);
  public final PBStringField appid = PBField.initString("");
  public final PBInt32Field execTime = PBField.initInt32(0);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField instrTraceId = PBField.initString("");
  public final PBStringField ruleName = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StReportExecuteReq
 * JD-Core Version:    0.7.0.1
 */