import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import tencent.im.apollo_push_msgInfo.STPushMsgElem;
import tencent.im.s2c.msgtype0x210.submsgtype0xe8.submsgtype0xe8.MsgBody;

public class actp
  implements acpi
{
  private static void a(QQAppInterface paramQQAppInterface, MsgType0x210 paramMsgType0x210)
  {
    QLog.d("ApolloPushManager", 1, "recv action push message 0x210_0xe8, [C2C.OnlinePush]");
    try
    {
      submsgtype0xe8.MsgBody localMsgBody = new submsgtype0xe8.MsgBody();
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      if (localMsgBody.msg_item.has())
      {
        paramMsgType0x210 = (apollo_push_msgInfo.STPushMsgElem)localMsgBody.msg_item.get();
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = (amnd)paramQQAppInterface.getManager(QQManagerFactory.APOLLO_PUSH_MANAGER);
          paramQQAppInterface.a(0, paramMsgType0x210);
          paramQQAppInterface.c(paramMsgType0x210);
          paramQQAppInterface.b(paramMsgType0x210);
          paramQQAppInterface.a(paramMsgType0x210);
        }
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      QLog.e("ApolloPushManager", 1, "[msg0x210.uSubMsgType == 0xe8], errInfo->" + paramQQAppInterface.getMessage());
    }
  }
  
  public MessageRecord a(acnk paramacnk, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramacnk.a(), paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     actp
 * JD-Core Version:    0.7.0.1
 */