import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import tencent.im.c2c.msgtype0x210.submsgtype0xeb.submsgtype0xeb.MsgBody;

public class actr
  implements acpi
{
  private static void a(acnk paramacnk, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0xeb");
    }
    try
    {
      submsgtype0xeb.MsgBody localMsgBody = new submsgtype0xeb.MsgBody();
      if (paramacnk.a(paramMsgType0x210)) {
        localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      }
      aohe.a(paramacnk.a(), localMsgBody);
      return;
    }
    catch (Exception paramacnk)
    {
      QLog.e("Q.msg.BaseMessageProcessor", 1, "[msg0x210.uSubMsgType == 0xeb], errInfo->" + paramacnk.getMessage());
    }
  }
  
  public MessageRecord a(acnk paramacnk, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramacnk, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     actr
 * JD-Core Version:    0.7.0.1
 */