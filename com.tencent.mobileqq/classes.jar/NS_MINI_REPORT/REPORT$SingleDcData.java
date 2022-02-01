package NS_MINI_REPORT;

import NS_COMM.COMM.Entry;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class REPORT$SingleDcData
  extends MessageMicro<SingleDcData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "type", "dcid", "report_data", "extinfo" }, new Object[] { "", Integer.valueOf(0), null, null }, SingleDcData.class);
  public final PBUInt32Field dcid = PBField.initUInt32(0);
  public final PBRepeatMessageField<COMM.Entry> extinfo = PBField.initRepeatMessage(COMM.Entry.class);
  public final PBRepeatMessageField<COMM.Entry> report_data = PBField.initRepeatMessage(COMM.Entry.class);
  public final PBStringField type = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_REPORT.REPORT.SingleDcData
 * JD-Core Version:    0.7.0.1
 */