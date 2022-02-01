package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StSwitchInfo
  extends MessageMicro<StSwitchInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "title", "key", "value", "desc" }, new Object[] { "", "", Integer.valueOf(0), "" }, StSwitchInfo.class);
  public final PBStringField desc = PBField.initString("");
  public final PBStringField key = PBField.initString("");
  public final PBStringField title = PBField.initString("");
  public final PBInt32Field value = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StSwitchInfo
 * JD-Core Version:    0.7.0.1
 */