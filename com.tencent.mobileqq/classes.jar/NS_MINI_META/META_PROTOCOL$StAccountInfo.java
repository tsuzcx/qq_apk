package NS_MINI_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class META_PROTOCOL$StAccountInfo
  extends MessageMicro<StAccountInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40 }, new String[] { "email", "passwordMd5", "activateTicket", "activateEmailTime", "activateState" }, new Object[] { "", "", "", Integer.valueOf(0), Integer.valueOf(0) }, StAccountInfo.class);
  public final PBUInt32Field activateEmailTime = PBField.initUInt32(0);
  public final PBUInt32Field activateState = PBField.initUInt32(0);
  public final PBStringField activateTicket = PBField.initString("");
  public final PBStringField email = PBField.initString("");
  public final PBStringField passwordMd5 = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_META.META_PROTOCOL.StAccountInfo
 * JD-Core Version:    0.7.0.1
 */