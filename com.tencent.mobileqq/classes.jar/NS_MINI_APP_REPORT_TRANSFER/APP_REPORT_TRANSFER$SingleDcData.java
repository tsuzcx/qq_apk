package NS_MINI_APP_REPORT_TRANSFER;

import NS_COMM.COMM.Entry;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class APP_REPORT_TRANSFER$SingleDcData
  extends MessageMicro<SingleDcData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "dcid", "report_data", "extinfo" }, new Object[] { Integer.valueOf(0), null, null }, SingleDcData.class);
  public final PBUInt32Field dcid = PBField.initUInt32(0);
  public final PBRepeatMessageField<COMM.Entry> extinfo = PBField.initRepeatMessage(COMM.Entry.class);
  public final PBRepeatMessageField<COMM.Entry> report_data = PBField.initRepeatMessage(COMM.Entry.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.SingleDcData
 * JD-Core Version:    0.7.0.1
 */