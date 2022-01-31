package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$GuardInstruction
  extends MessageMicro<GuardInstruction>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 57, 66 }, new String[] { "type", "title", "msg", "url", "modal", "data", "ratio", "ruleName" }, new Object[] { Integer.valueOf(0), "", "", "", Integer.valueOf(0), "", Double.valueOf(0.0D), "" }, GuardInstruction.class);
  public final PBStringField data = PBField.initString("");
  public final PBInt32Field modal = PBField.initInt32(0);
  public final PBStringField msg = PBField.initString("");
  public final PBDoubleField ratio = PBField.initDouble(0.0D);
  public final PBStringField ruleName = PBField.initString("");
  public final PBStringField title = PBField.initString("");
  public final PBInt32Field type = PBField.initInt32(0);
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.GuardInstruction
 * JD-Core Version:    0.7.0.1
 */