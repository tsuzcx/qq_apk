import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

public class addg
  implements adci
{
  private static void a(QQAppInterface paramQQAppInterface, MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    beki localbeki = ((bejx)paramQQAppInterface.getManager(339)).a(4);
    byte[] arrayOfByte;
    long l1;
    long l2;
    if (localbeki != null)
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
      localbeki.a(paramQQAppInterface, arrayOfByte, l1, l2, bool);
      return;
    }
  }
  
  public MessageRecord a(adan paramadan, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramadan.a(), paramMsgInfo, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     addg
 * JD-Core Version:    0.7.0.1
 */