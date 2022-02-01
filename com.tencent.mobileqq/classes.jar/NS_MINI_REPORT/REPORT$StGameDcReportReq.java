package NS_MINI_REPORT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class REPORT$StGameDcReportReq
  extends MessageMicro<StGameDcReportReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "dcdata" }, new Object[] { null }, StGameDcReportReq.class);
  public final PBRepeatMessageField<REPORT.SingleDcData> dcdata = PBField.initRepeatMessage(REPORT.SingleDcData.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_REPORT.REPORT.StGameDcReportReq
 * JD-Core Version:    0.7.0.1
 */