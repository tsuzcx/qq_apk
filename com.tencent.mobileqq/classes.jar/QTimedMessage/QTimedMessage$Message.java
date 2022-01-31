package QTimedMessage;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QTimedMessage$Message
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_msg_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public QTimedMessage.User msg_author = new QTimedMessage.User();
  public QTimedMessage.Content msg_content = new QTimedMessage.Content();
  public QTimedMessage.Timer msg_timer = new QTimedMessage.Timer();
  public final PBUInt32Field uint32_main_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sub_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_appid = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_create_time = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 58, 66 }, new String[] { "uint64_appid", "bytes_msg_id", "msg_author", "uint32_main_type", "uint32_sub_type", "uint64_create_time", "msg_timer", "msg_content" }, new Object[] { Long.valueOf(0L), localByteStringMicro, null, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), null, null }, Message.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     QTimedMessage.QTimedMessage.Message
 * JD-Core Version:    0.7.0.1
 */