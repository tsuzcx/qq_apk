import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class acsz
  implements acpi
{
  private static void a(acnk paramacnk, MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.e("HotFriend_PushMessage", 2, "onLinePush receive 0x210_0xc7");
    }
    long l1 = paramMsgInfo.lFromUin;
    int i = paramMsgInfo.shMsgSeq;
    long l2 = paramMsgInfo.lMsgUid;
    int j = paramMsgInfo.shMsgType;
    int k = paramMsgInfo.uRealMsgTime;
    paramMsgInfo = new aooq(l1, i, l2, j, k, true);
    paramacnk.a(paramMsgType0x210.vProtobuf, paramMsgInfo);
    bcrx.a(paramacnk.a().getMsgHandler(), l1, i, l2, j);
  }
  
  public MessageRecord a(acnk paramacnk, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramacnk, paramMsgInfo, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acsz
 * JD-Core Version:    0.7.0.1
 */