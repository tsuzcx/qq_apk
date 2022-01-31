package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StJudgeTimingReq
  extends MessageMicro<StJudgeTimingReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 56, 64, 72, 82, 90 }, new String[] { "extInfo", "appid", "factType", "duration", "reportTime", "afterCertify", "appType", "scene", "totalTime", "launchId", "via" }, new Object[] { null, "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "" }, StJudgeTimingReq.class);
  public final PBInt32Field afterCertify = PBField.initInt32(0);
  public final PBInt32Field appType = PBField.initInt32(0);
  public final PBStringField appid = PBField.initString("");
  public final PBInt32Field duration = PBField.initInt32(0);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBInt32Field factType = PBField.initInt32(0);
  public final PBStringField launchId = PBField.initString("");
  public final PBInt64Field reportTime = PBField.initInt64(0L);
  public final PBInt32Field scene = PBField.initInt32(0);
  public final PBInt32Field totalTime = PBField.initInt32(0);
  public final PBStringField via = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StJudgeTimingReq
 * JD-Core Version:    0.7.0.1
 */