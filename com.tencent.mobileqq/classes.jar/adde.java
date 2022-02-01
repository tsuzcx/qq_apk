import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

public class adde
  implements adci
{
  private static void a(QQAppInterface paramQQAppInterface, MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    awpn.a(paramQQAppInterface, paramMsgType0x210.vProtobuf, paramMsgInfo.shMsgSeq, paramMsgInfo.uRealMsgTime, false);
  }
  
  public MessageRecord a(adan paramadan, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramadan.a(), paramMsgInfo, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adde
 * JD-Core Version:    0.7.0.1
 */