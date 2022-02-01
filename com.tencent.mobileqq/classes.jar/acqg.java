import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;

public class acqg
  implements acpi
{
  private static void a(QQAppInterface paramQQAppInterface, MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    bekg localbekg = ((bejv)paramQQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER)).a(4);
    byte[] arrayOfByte;
    long l1;
    long l2;
    if (localbekg != null)
    {
      arrayOfByte = paramMsgType0x210.vProtobuf;
      l1 = paramMsgInfo.shMsgSeq;
      l2 = paramMsgInfo.uRealMsgTime;
      if (paramMsgType0x210.uSubMsgType != 295L) {
        break label70;
      }
    }
    label70:
    for (boolean bool = false;; bool = true)
    {
      localbekg.a(paramQQAppInterface, arrayOfByte, l1, l2, bool);
      return;
    }
  }
  
  public MessageRecord a(acnk paramacnk, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramacnk.a(), paramMsgInfo, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acqg
 * JD-Core Version:    0.7.0.1
 */