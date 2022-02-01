package QTimedMessage;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class QTimedMessage$Content
  extends MessageMicro<Content>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_userdef = PBField.initBytes(ByteStringMicro.EMPTY);
  public QTimedMessage.C2CMessage msg_c2c_message = new QTimedMessage.C2CMessage();
  public QTimedMessage.GroupMessage msg_group_message = new QTimedMessage.GroupMessage();
  public QTimedMessage.PCTip msg_pc_tip = new QTimedMessage.PCTip();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "bytes_userdef", "msg_pc_tip", "msg_group_message", "msg_c2c_message" }, new Object[] { localByteStringMicro, null, null, null }, Content.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QTimedMessage.QTimedMessage.Content
 * JD-Core Version:    0.7.0.1
 */