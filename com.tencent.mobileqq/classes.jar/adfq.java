import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.olympic.submsgtype0xb4.BodyType;
import tencent.im.oidb.olympic.submsgtype0xb4.MsgBody;
import tencent.im.oidb.olympic.torch_transfer.TorchbearerInfo;

public class adfq
  implements adci
{
  private static void a(QQAppInterface paramQQAppInterface, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("olympic.OnLinePush", 2, "receive push 0xb4");
    }
    submsgtype0xb4.MsgBody localMsgBody = new submsgtype0xb4.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      int i = localMsgBody.uint32_type.get();
      if (QLog.isColorLevel()) {
        QLog.d("olympic.OnLinePush", 2, new Object[] { "receive push 0xb4, type = ", Integer.valueOf(i) });
      }
      if (i == 1)
      {
        paramMsgType0x210 = localMsgBody.msg_body_type;
        if (paramMsgType0x210.msg_torchbearer.has())
        {
          paramQQAppInterface = (azct)paramQQAppInterface.a(94);
          if (paramQQAppInterface != null) {
            paramQQAppInterface.a((torch_transfer.TorchbearerInfo)paramMsgType0x210.msg_torchbearer.get());
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("olympic.OnLinePush", 2, "receive push 0xb4, bodyType.msg_torchbearer.has() == false");
          return;
        }
      }
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.d("olympic.OnLinePush", 2, "receive push 0xb4, parse msgBody err,", paramQQAppInterface);
      }
    }
  }
  
  public MessageRecord a(adan paramadan, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramadan.a(), paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adfq
 * JD-Core Version:    0.7.0.1
 */