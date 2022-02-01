import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

public class acdp
  implements abzb
{
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, int paramInt)
  {
    ((aula)paramQQAppInterface.getManager(268)).a(paramArrayOfByte, paramInt);
  }
  
  public MessageRecord a(abxc paramabxc, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramabxc.a(), paramMsgType0x210.vProtobuf, 1);
    bblf.a(paramabxc.a().getMsgHandler(), paramMsgInfo.lFromUin, paramMsgInfo.shMsgSeq, paramMsgInfo.lMsgUid, paramMsgInfo.shMsgType);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acdp
 * JD-Core Version:    0.7.0.1
 */