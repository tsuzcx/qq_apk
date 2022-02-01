import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.MsgBody;

public class acsn
  implements acpi
{
  private static void a(QQAppInterface paramQQAppInterface, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameParty", 2, "recv 0x210_0xaa push message");
    }
    SubMsgType0xaa.MsgBody localMsgBody = new SubMsgType0xaa.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      ((avhf)paramQQAppInterface.getManager(QQManagerFactory.GAME_PARTY_MANAGER)).a(localMsgBody, false);
      return;
    }
    catch (Exception paramMsgType0x210)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GameParty", 2, "recv 0x210_0xaa, prase msgBody error");
        }
      }
    }
  }
  
  public MessageRecord a(acnk paramacnk, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramacnk.a(), paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acsn
 * JD-Core Version:    0.7.0.1
 */