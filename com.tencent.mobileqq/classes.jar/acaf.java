import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.submsgtype0x139.Submsgtype0x139.MsgBody;

public class acaf
  implements abzb
{
  private static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    Submsgtype0x139.MsgBody localMsgBody = new Submsgtype0x139.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramArrayOfByte);
      l1 = localMsgBody.uint64_friend.get();
      l2 = localMsgBody.uint64_uin.get();
      i = localMsgBody.uint32_op_type.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, new Object[] { "onLinePush shortcut receive 0x210_0x139,pushType =", Integer.valueOf(i), " friendUin =", Long.valueOf(l1), " accountUin = ", Long.valueOf(l2) });
      }
      paramQQAppInterface = (apih)paramQQAppInterface.getBusinessHandler(186);
      if (i == 1)
      {
        paramQQAppInterface.a(l1);
        return;
      }
      if (i == 2)
      {
        paramQQAppInterface.a(l1, l2, true);
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      long l1;
      long l2;
      int i;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x139 " + paramQQAppInterface);
        return;
        if (i == 3) {
          paramQQAppInterface.a(l1, l2, false);
        }
      }
    }
  }
  
  public MessageRecord a(abxc paramabxc, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramabxc.a(), paramMsgType0x210.vProtobuf);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acaf
 * JD-Core Version:    0.7.0.1
 */