package QTimedMessage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QTimedMessage$Client
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_PC", "uint32_Mobile" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, Client.class);
  public final PBUInt32Field uint32_Mobile = PBField.initUInt32(0);
  public final PBUInt32Field uint32_PC = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QTimedMessage.QTimedMessage.Client
 * JD-Core Version:    0.7.0.1
 */