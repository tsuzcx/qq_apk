import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0xe9.SubMsgType0xe9.MsgBody;

public class actq
  implements acpi
{
  private static void a(QQAppInterface paramQQAppInterface, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor runhw", 2, "onLinePush Audio Trans 0x210_0xe9");
    }
    try
    {
      SubMsgType0xe9.MsgBody localMsgBody = new SubMsgType0xe9.MsgBody();
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      paramQQAppInterface.getGAudioHandler().a(localMsgBody);
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = localMsgBody.bytes_business.get().toByteArray();
        QLog.d("Q.msg.BaseMessageProcessor runhw", 2, "onLinePush 0x210_0xe9 =" + paramQQAppInterface.length);
        QLog.d("Q.msg.BaseMessageProcessor runhw", 2, "onLinePush 0x210_0xe9 businessBytes = " + paramQQAppInterface.length);
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      do
      {
        paramQQAppInterface.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.e("Q.msg.BaseMessageProcessor runhw", 2, "onLinePush 0x210_0xe9 push exception = " + paramQQAppInterface.getMessage());
    }
  }
  
  public MessageRecord a(acnk paramacnk, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramacnk.a(), paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     actq
 * JD-Core Version:    0.7.0.1
 */