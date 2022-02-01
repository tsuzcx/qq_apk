import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x92.SubMsgType0x92.MsgBody;

public class acsc
  implements acpi
{
  private static void a(QQAppInterface paramQQAppInterface, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Qidian0x92Push", 2, "<---receive qidian0x92 push : forward to qidianHandler");
    }
    try
    {
      paramMsgType0x210 = (SubMsgType0x92.MsgBody)new SubMsgType0x92.MsgBody().mergeFrom(paramMsgType0x210.vProtobuf);
      ((bjyi)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).a(paramMsgType0x210);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.msg.BaseMessageProcessor", 2, "<---decode0x92push parse failed.", paramQQAppInterface);
    }
  }
  
  public MessageRecord a(acnk paramacnk, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramacnk.a(), paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acsc
 * JD-Core Version:    0.7.0.1
 */