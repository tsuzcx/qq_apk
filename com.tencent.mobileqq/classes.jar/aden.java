import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class aden
  implements adci
{
  private static void a(adan paramadan, MsgInfo paramMsgInfo, long paramLong, MsgType0x210 paramMsgType0x210)
  {
    long l1 = paramMsgInfo.lFromUin;
    int i = paramMsgInfo.shMsgSeq;
    long l2 = paramMsgInfo.lMsgUid;
    int j = paramMsgInfo.shMsgType;
    int k = (int)paramMsgType0x210.uSubMsgType;
    if (((aold)paramadan.a().getManager(85)).a(paramMsgInfo.shMsgSeq)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "receive same message, seq = " + paramMsgInfo.shMsgSeq);
      }
    }
    for (;;)
    {
      bcrw.a(paramadan.a().a(), l1, i, l2, j);
      return;
      if (bctc.a(paramadan.a(), paramMsgType0x210.vProtobuf, l1, paramLong, i, j, k)) {
        paramadan.a("handleActivateFriendsPush", true, 1, true, false);
      }
    }
  }
  
  public MessageRecord a(adan paramadan, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramadan, paramMsgInfo, paramLong, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aden
 * JD-Core Version:    0.7.0.1
 */