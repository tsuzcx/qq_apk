package NS_MINI_REALTIMELOG;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class REALTIMELOG$StLogItem
  extends MessageMicro<StLogItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "log_time", "log_level", "msg" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "" }, StLogItem.class);
  public final PBInt32Field log_level = PBField.initInt32(0);
  public final PBInt64Field log_time = PBField.initInt64(0L);
  public final PBStringField msg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_REALTIMELOG.REALTIMELOG.StLogItem
 * JD-Core Version:    0.7.0.1
 */