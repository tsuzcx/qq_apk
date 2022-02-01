import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x78.submsgtype0x78.MsgBody;

public class acrq
  implements acpi
{
  private static void a(QQAppInterface paramQQAppInterface, MsgType0x210 paramMsgType0x210)
  {
    submsgtype0x78.MsgBody localMsgBody = new submsgtype0x78.MsgBody();
    int i;
    do
    {
      do
      {
        try
        {
          localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
          i = localMsgBody.uint32_type.get();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "MSG_TYPE_RED_PACKET type:" + i + ", serverVersion:" + localMsgBody.uint32_version.get());
          }
          if (i == 1004)
          {
            paramQQAppInterface = (PortalManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_PORTAL);
            if (paramQQAppInterface != null) {
              paramQQAppInterface.a(localMsgBody);
            }
            return;
          }
        }
        catch (Throwable paramQQAppInterface)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PortalManager", 2, "", paramQQAppInterface);
          }
          throw new RuntimeException(paramQQAppInterface);
        }
        if (i == 49)
        {
          arph.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), localMsgBody.uint32_version.get());
          return;
        }
        if (i == 46)
        {
          acma.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), localMsgBody.uint32_version.get(), "C2COnlinePush");
          return;
        }
        if (i == 1003)
        {
          ((OlympicManager)paramQQAppInterface.getManager(QQManagerFactory.OLYMPIC_MANAGER)).a(localMsgBody);
          return;
        }
        if (i != 222) {
          break;
        }
        i = paramQQAppInterface.getPreferences().getInt("public_account_ad_preload_task", 0);
        if (i != localMsgBody.uint32_version.get()) {
          arph.a(paramQQAppInterface, 222, paramQQAppInterface.getCurrentAccountUin());
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.msg.BaseMessageProcessor", 2, "handlePublicAccountAdPreloadTaskPush localVersion:" + i + ", serverVersion:" + localMsgBody.uint32_version.get());
      return;
    } while ((i != 283) || (paramQQAppInterface == null));
    try
    {
      QLog.d("Q.msg.BaseMessageProcessor", 1, "SAFE_MODE_COMMAND_CONFIG excute");
      arph.a(paramQQAppInterface, 283, paramQQAppInterface.getCurrentAccountUin());
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      QLog.e("Q.msg.BaseMessageProcessor", 1, "SAFE_MODE_COMMAND_CONFIG  Push throw an exception:", paramQQAppInterface);
    }
  }
  
  public MessageRecord a(acnk paramacnk, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramacnk.a(), paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acrq
 * JD-Core Version:    0.7.0.1
 */