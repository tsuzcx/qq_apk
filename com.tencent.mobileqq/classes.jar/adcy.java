import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x11b.submsgtype0x11b.MsgBody;

public class adcy
  implements adci
{
  private static void a(adan paramadan, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x11b");
    }
    try
    {
      submsgtype0x11b.MsgBody localMsgBody = new submsgtype0x11b.MsgBody();
      if (paramadan.a(paramMsgType0x210))
      {
        localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
        axga.a().a(localMsgBody);
      }
      return;
    }
    catch (Exception paramadan)
    {
      QLog.e("Q.msg.BaseMessageProcessor", 1, "[msg0x210.uSubMsgType == 0x11b], errInfo->" + paramadan.getMessage());
    }
  }
  
  public MessageRecord a(adan paramadan, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramadan, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adcy
 * JD-Core Version:    0.7.0.1
 */