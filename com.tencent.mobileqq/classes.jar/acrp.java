import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class acrp
  implements acpi
{
  private static void a(acnk paramacnk, MsgInfo paramMsgInfo, long paramLong, MsgType0x210 paramMsgType0x210)
  {
    long l1 = paramMsgInfo.lFromUin;
    int i = paramMsgInfo.shMsgSeq;
    long l2 = paramMsgInfo.lMsgUid;
    int j = paramMsgInfo.shMsgType;
    int k = (int)paramMsgType0x210.uSubMsgType;
    if (((aohe)paramacnk.a().getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS)).a(paramMsgInfo.shMsgSeq)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "receive same message, seq = " + paramMsgInfo.shMsgSeq);
      }
    }
    for (;;)
    {
      bcrx.a(paramacnk.a().getMsgHandler(), l1, i, l2, j);
      return;
      if (bcte.a(paramacnk.a(), paramMsgType0x210.vProtobuf, l1, paramLong, i, j, k)) {
        paramacnk.a("handleActivateFriendsPush", true, 1, true, false);
      }
    }
  }
  
  public MessageRecord a(acnk paramacnk, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramacnk, paramMsgInfo, paramLong, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acrp
 * JD-Core Version:    0.7.0.1
 */