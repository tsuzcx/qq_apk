package NS_MINI_REPORT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class REPORT$StDcReportReq
  extends MessageMicro<StDcReportReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "dcdata" }, new Object[] { null }, StDcReportReq.class);
  public final PBRepeatMessageField<REPORT.SingleDcData> dcdata = PBField.initRepeatMessage(REPORT.SingleDcData.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_REPORT.REPORT.StDcReportReq
 * JD-Core Version:    0.7.0.1
 */