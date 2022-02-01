import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x119.SubMsgType0x119.MsgBody;

public class abzp
  implements abzb
{
  private static void a(abxc paramabxc, MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x119, [S2C push for input status]");
    }
    try
    {
      SubMsgType0x119.MsgBody localMsgBody = new SubMsgType0x119.MsgBody();
      if (paramabxc.a(paramMsgType0x210))
      {
        localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
        QLog.d("Q.msg.BaseMessageProcessor", 1, "troopFormLog receive c2c" + localMsgBody.toString());
        if (!bcvs.a(paramMsgInfo.shMsgSeq))
        {
          bcvs.a(paramabxc.a(), localMsgBody);
          QLog.d("Q.msg.BaseMessageProcessor", 1, "troopFormLog isPushMessageDuplicated");
        }
      }
      return;
    }
    catch (Exception paramabxc)
    {
      QLog.e("Q.msg.BaseMessageProcessor", 1, "[msg0x210.uSubMsgType == 0x115], errInfo->" + paramabxc.getMessage());
    }
  }
  
  public MessageRecord a(abxc paramabxc, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramabxc, paramMsgInfo, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abzp
 * JD-Core Version:    0.7.0.1
 */