import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0xa8.SubMsgType0xa8.MsgBody;

public class acce
  implements abzb
{
  private static void a(abxc paramabxc, MsgType0x210 paramMsgType0x210)
  {
    SubMsgType0xa8.MsgBody localMsgBody = new SubMsgType0xa8.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      paramabxc.a(localMsgBody);
      return;
    }
    catch (Exception paramabxc)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("PullActive", 2, "recv 0x210_0xa8, prase msgBody error");
    }
  }
  
  public MessageRecord a(abxc paramabxc, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramabxc, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acce
 * JD-Core Version:    0.7.0.1
 */