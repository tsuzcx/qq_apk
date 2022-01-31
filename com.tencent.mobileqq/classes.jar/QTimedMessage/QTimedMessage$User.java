package QTimedMessage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QTimedMessage$User
  extends MessageMicro
{
  public static final int GROUP_CODE = 1;
  public static final int GTALK_CODE = 2;
  public static final int QQ_UIN = 3;
  public static final int SYSTEM_UIN = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "enum_uin_type", "uint64_uin" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L) }, User.class);
  public final PBEnumField enum_uin_type = PBField.initEnum(1);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QTimedMessage.QTimedMessage.User
 * JD-Core Version:    0.7.0.1
 */