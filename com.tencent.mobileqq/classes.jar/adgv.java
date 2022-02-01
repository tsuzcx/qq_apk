import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

public class adgv
  implements adci
{
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, int paramInt)
  {
    ((avya)paramQQAppInterface.getManager(268)).a(paramArrayOfByte, paramInt);
  }
  
  public MessageRecord a(adan paramadan, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramadan.a(), paramMsgType0x210.vProtobuf, 1);
    bcrw.a(paramadan.a().a(), paramMsgInfo.lFromUin, paramMsgInfo.shMsgSeq, paramMsgInfo.lMsgUid, paramMsgInfo.shMsgType);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adgv
 * JD-Core Version:    0.7.0.1
 */