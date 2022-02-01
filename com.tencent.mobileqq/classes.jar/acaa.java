import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x128.submsgtype0x128.MsgBody;

public class acaa
  implements abzb
{
  private static void a(abxc paramabxc, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive submsgtype0x128,or 0x137" + paramMsgType0x210.uSubMsgType);
    }
    for (;;)
    {
      try
      {
        submsgtype0x128.MsgBody localMsgBody = new submsgtype0x128.MsgBody();
        if (paramabxc.a(paramMsgType0x210))
        {
          localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
          paramabxc = (arhg)paramabxc.a().getBusinessHandler(127);
          if (paramMsgType0x210.uSubMsgType == 296L)
          {
            bool = true;
            paramabxc.a(localMsgBody, bool);
            QLog.d("Q.msg.BaseMessageProcessorExtendFriendLimitChat", 2, "SubMsgType0x27.ChatMatchInfo");
          }
        }
        else
        {
          QLog.e("Q.msg.BaseMessageProcessor", 2, "submsgtype0x128 or 0x137 onLinePush vProto null   " + paramMsgType0x210.uSubMsgType);
          return;
        }
      }
      catch (Exception paramabxc)
      {
        QLog.e("Q.msg.BaseMessageProcessor", 1, "troopFormLog onLinePush receive submsgtype match chat0x128 decodeC2CMsgPkg_MsgType0x210 receive 0x128 push message, errInfo->" + paramabxc.getMessage());
        return;
      }
      boolean bool = false;
    }
  }
  
  public MessageRecord a(abxc paramabxc, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramabxc, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acaa
 * JD-Core Version:    0.7.0.1
 */