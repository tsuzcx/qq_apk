import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x104.submsgtype0x104.MsgBody;

public class adcn
  implements adci
{
  private static void a(QQAppInterface paramQQAppInterface, MsgType0x210 paramMsgType0x210)
  {
    submsgtype0x104.MsgBody localMsgBody = new submsgtype0x104.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      paramQQAppInterface.a().a().a(localMsgBody);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x104 wrong:" + paramQQAppInterface.toString());
    }
  }
  
  public MessageRecord a(adan paramadan, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramadan.a(), paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adcn
 * JD-Core Version:    0.7.0.1
 */