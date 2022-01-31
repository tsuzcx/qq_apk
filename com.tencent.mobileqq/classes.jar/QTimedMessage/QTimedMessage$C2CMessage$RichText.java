package QTimedMessage;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QTimedMessage$C2CMessage$RichText
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_template_1 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_gift_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_service_id = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "bytes_template_1", "uint32_service_id", "uint32_gift_id" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, RichText.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     QTimedMessage.QTimedMessage.C2CMessage.RichText
 * JD-Core Version:    0.7.0.1
 */