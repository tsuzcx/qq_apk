package NS_COMM;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class COMM$StCommonExt
  extends MessageMicro<StCommonExt>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "mapInfo", "attachInfo" }, new Object[] { null, "" }, StCommonExt.class);
  public final PBStringField attachInfo = PBField.initString("");
  public final PBRepeatMessageField<COMM.Entry> mapInfo = PBField.initRepeatMessage(COMM.Entry.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_COMM.COMM.StCommonExt
 * JD-Core Version:    0.7.0.1
 */