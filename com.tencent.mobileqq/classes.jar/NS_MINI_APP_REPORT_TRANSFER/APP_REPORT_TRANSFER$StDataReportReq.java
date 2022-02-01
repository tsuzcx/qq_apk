package NS_MINI_APP_REPORT_TRANSFER;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class APP_REPORT_TRANSFER$StDataReportReq
  extends MessageMicro<StDataReportReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "dcdata" }, new Object[] { null }, StDataReportReq.class);
  public final PBRepeatMessageField<APP_REPORT_TRANSFER.SingleDcData> dcdata = PBField.initRepeatMessage(APP_REPORT_TRANSFER.SingleDcData.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.StDataReportReq
 * JD-Core Version:    0.7.0.1
 */