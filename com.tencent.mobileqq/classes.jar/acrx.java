import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x87.SubMsgType0x87.MsgBody;

public class acrx
  implements acpi
{
  private static void a(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler, MsgType0x210 paramMsgType0x210)
  {
    SubMsgType0x87.MsgBody localMsgBody = new SubMsgType0x87.MsgBody();
    for (;;)
    {
      try
      {
        localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
        if (localMsgBody.uint64_friend_msg_type_flag.has())
        {
          if (localMsgBody.uint64_friend_msg_type_flag.get() != 1L) {
            break label100;
          }
          i = 1;
          if (i != 0) {
            paramMessageHandler.a().a(2);
          }
        }
        if (localMsgBody.rpt_msg_msg_notify.has()) {
          aiyq.a(paramQQAppInterface, localMsgBody);
        }
        return;
      }
      catch (Throwable paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PortalManager", 2, "", paramQQAppInterface);
        }
        throw new RuntimeException(paramQQAppInterface);
      }
      label100:
      int i = 0;
    }
  }
  
  public MessageRecord a(acnk paramacnk, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramacnk.a(), paramacnk.a().getMsgHandler(), paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acrx
 * JD-Core Version:    0.7.0.1
 */