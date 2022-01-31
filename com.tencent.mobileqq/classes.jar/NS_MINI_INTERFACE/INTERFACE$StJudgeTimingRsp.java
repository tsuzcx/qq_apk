package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StJudgeTimingRsp
  extends MessageMicro<StJudgeTimingRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 50 }, new String[] { "extInfo", "timingTraceId", "nextDuration", "loginInstructions", "loginTraceId", "timingInstructions" }, new Object[] { null, "", Integer.valueOf(0), null, "", null }, StJudgeTimingRsp.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBRepeatMessageField<INTERFACE.GuardInstruction> loginInstructions = PBField.initRepeatMessage(INTERFACE.GuardInstruction.class);
  public final PBStringField loginTraceId = PBField.initString("");
  public final PBInt32Field nextDuration = PBField.initInt32(0);
  public final PBRepeatMessageField<INTERFACE.GuardInstruction> timingInstructions = PBField.initRepeatMessage(INTERFACE.GuardInstruction.class);
  public final PBStringField timingTraceId = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StJudgeTimingRsp
 * JD-Core Version:    0.7.0.1
 */