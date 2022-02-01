import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class adgs
  implements adci
{
  private static void a(QQAppInterface paramQQAppInterface, MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.BaseMessageProcessor", 2, "handleC2COnlinePushMsg0x210Resp invoked. info: AIO story feed. msg0x210.uSubMsgType: " + paramMsgType0x210.uSubMsgType);
    }
    paramQQAppInterface = (wiz)paramQQAppInterface.getManager(253);
    long l = paramMsgInfo.lFromUin;
    paramQQAppInterface.a(paramQQAppInterface.a(paramMsgType0x210.vProtobuf, String.valueOf(l)));
  }
  
  public MessageRecord a(adan paramadan, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramadan.a(), paramMsgInfo, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adgs
 * JD-Core Version:    0.7.0.1
 */