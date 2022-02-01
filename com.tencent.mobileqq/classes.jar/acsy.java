import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class acsy
  implements acpi
{
  private static void a(QQAppInterface paramQQAppInterface, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("qqprotect.alert.push", 2, "get a push message for sec svc handler, 0xc6");
    }
    paramQQAppInterface = (aodi)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(paramMsgType0x210.uSubMsgType, paramMsgType0x210.vProtobuf);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("qqprotect.alert.push", 2, "failed to get sec svc handler, 0xc6");
  }
  
  public MessageRecord a(acnk paramacnk, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramacnk.a(), paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acsy
 * JD-Core Version:    0.7.0.1
 */