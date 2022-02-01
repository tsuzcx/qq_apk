import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x119.SubMsgType0x119.MsgBody;

public class adcw
  implements adci
{
  private static void a(adan paramadan, MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x119, [S2C push for input status]");
    }
    try
    {
      SubMsgType0x119.MsgBody localMsgBody = new SubMsgType0x119.MsgBody();
      if (paramadan.a(paramMsgType0x210))
      {
        localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
        QLog.d("Q.msg.BaseMessageProcessor", 1, "troopFormLog receive c2c" + localMsgBody.toString());
        if (!becb.a(paramMsgInfo.shMsgSeq))
        {
          becb.a(paramadan.a(), localMsgBody);
          QLog.d("Q.msg.BaseMessageProcessor", 1, "troopFormLog isPushMessageDuplicated");
        }
      }
      return;
    }
    catch (Exception paramadan)
    {
      QLog.e("Q.msg.BaseMessageProcessor", 1, "[msg0x210.uSubMsgType == 0x115], errInfo->" + paramadan.getMessage());
    }
  }
  
  public MessageRecord a(adan paramadan, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramadan, paramMsgInfo, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adcw
 * JD-Core Version:    0.7.0.1
 */