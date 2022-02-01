import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x101.SubMsgType0x27.MsgBody;

public class acpk
  implements acpi
{
  private static void a(QQAppInterface paramQQAppInterface, MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    SubMsgType0x27.MsgBody localMsgBody = new SubMsgType0x27.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      ((awtm)paramQQAppInterface.getManager(QQManagerFactory.PUSH_NOTICE_MANAGER)).a(localMsgBody, paramMsgInfo.shMsgSeq, paramMsgInfo.lMsgUid);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramQQAppInterface)
    {
      QLog.e("Q.msg.BaseMessageProcessor", 1, paramQQAppInterface, new Object[0]);
    }
  }
  
  public MessageRecord a(acnk paramacnk, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramacnk.a(), paramMsgInfo, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acpk
 * JD-Core Version:    0.7.0.1
 */