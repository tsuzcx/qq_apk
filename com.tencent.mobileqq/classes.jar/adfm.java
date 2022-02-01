import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0xab.SubMsgType0xab.MsgBody;

public class adfm
  implements adci
{
  private static void a(QQAppInterface paramQQAppInterface, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_reward.push", 2, "onLinePush receive 0x210_0xab");
    }
    try
    {
      SubMsgType0xab.MsgBody localMsgBody = new SubMsgType0xab.MsgBody();
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      ((aoip)paramQQAppInterface.a(20)).a(localMsgBody);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w(".troop.troop_reward.push", 2, "onLinePush 0x210_0xab push exception", paramQQAppInterface);
    }
  }
  
  public MessageRecord a(adan paramadan, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramadan.a(), paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adfm
 * JD-Core Version:    0.7.0.1
 */