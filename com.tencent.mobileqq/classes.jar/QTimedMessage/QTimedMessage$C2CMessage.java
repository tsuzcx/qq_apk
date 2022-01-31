package QTimedMessage;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QTimedMessage$C2CMessage
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public QTimedMessage.User msg_from_user = new QTimedMessage.User();
  public QTimedMessage.Client msg_recv_client = new QTimedMessage.Client();
  public QTimedMessage.C2CMessage.RichText msg_rich_text = new QTimedMessage.C2CMessage.RichText();
  public QTimedMessage.User msg_to_user = new QTimedMessage.User();
  public final PBUInt32Field uint32_send_rich_text_standalone = PBField.initUInt32(0);
  public final PBUInt32Field uint32_send_text_standalone = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 56 }, new String[] { "msg_from_user", "msg_to_user", "msg_recv_client", "bytes_text", "msg_rich_text", "uint32_send_text_standalone", "uint32_send_rich_text_standalone" }, new Object[] { null, null, null, localByteStringMicro, null, Integer.valueOf(0), Integer.valueOf(0) }, C2CMessage.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QTimedMessage.QTimedMessage.C2CMessage
 * JD-Core Version:    0.7.0.1
 */