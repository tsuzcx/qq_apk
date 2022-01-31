package QTimedMessage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class QTimedMessage$GroupMessage
  extends MessageMicro<GroupMessage>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_from_user", "msg_to_user" }, new Object[] { null, null }, GroupMessage.class);
  public QTimedMessage.User msg_from_user = new QTimedMessage.User();
  public QTimedMessage.User msg_to_user = new QTimedMessage.User();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QTimedMessage.QTimedMessage.GroupMessage
 * JD-Core Version:    0.7.0.1
 */