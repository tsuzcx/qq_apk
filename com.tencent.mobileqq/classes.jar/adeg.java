import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x67.submsgtype0x67.MsgBody;

public class adeg
  implements adci
{
  private static void a(adan paramadan, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("nearbyTroopPush", 2, "receive msgtype0x210.submsgtype0x67 group recmd push: " + paramadan.a(paramMsgType0x210));
    }
    submsgtype0x67.MsgBody localMsgBody = new submsgtype0x67.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      if (localMsgBody.rpt_msg_grpinfo.has())
      {
        paramMsgType0x210 = localMsgBody.rpt_msg_grpinfo.get();
        paramadan = (aoat)paramadan.a().a(3);
        if (paramadan != null) {
          paramadan.a(paramMsgType0x210);
        }
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramMsgType0x210)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("nearbyTroopPush", 2, "receive msgtype0x210.submsgtype0x67 mergeFrom exception: " + paramMsgType0x210.toString());
        }
      }
    }
  }
  
  public MessageRecord a(adan paramadan, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramadan, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adeg
 * JD-Core Version:    0.7.0.1
 */