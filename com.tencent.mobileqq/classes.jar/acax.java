import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x63.submsgtype0x63.MsgBody;

public class acax
  implements abzb
{
  private static void a(QQAppInterface paramQQAppInterface, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "Get crm voip push from handleC2COnlinePushMsg0x210Resp");
    }
    bcef.b(paramQQAppInterface, "CliOper", "", "", "VoipService.ivrPush", "VoipService.ivrPush", 0, 0, "", "", "", "");
    new submsgtype0x63.MsgBody();
    new lxk(BaseApplication.getContext()).a(new acay(paramMsgType0x210));
  }
  
  public MessageRecord a(abxc paramabxc, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramabxc.a(), paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acax
 * JD-Core Version:    0.7.0.1
 */