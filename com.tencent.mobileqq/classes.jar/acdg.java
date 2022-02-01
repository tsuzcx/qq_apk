import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0xe5.Submsgtype0xe5.MsgBody;

public class acdg
  implements abzb
{
  private static void a(QQAppInterface paramQQAppInterface, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Qidian0xe5Push", 2, "<---receive qidian0xe5 push : forward to qidianHandler");
    }
    try
    {
      paramMsgType0x210 = (Submsgtype0xe5.MsgBody)new Submsgtype0xe5.MsgBody().mergeFrom(paramMsgType0x210.vProtobuf);
      ((bing)paramQQAppInterface.getBusinessHandler(85)).a(paramMsgType0x210);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.msg.BaseMessageProcessor", 2, "<---decode0xe5push parse failed.", paramQQAppInterface);
    }
  }
  
  public MessageRecord a(abxc paramabxc, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramabxc.a(), paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acdg
 * JD-Core Version:    0.7.0.1
 */