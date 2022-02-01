import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

public class acai
  implements abzb
{
  public static void a(QQAppInterface paramQQAppInterface, MsgType0x210 paramMsgType0x210)
  {
    ((PublicAccountHandler)paramQQAppInterface.getBusinessHandler(11)).a(paramMsgType0x210.uSubMsgType, paramMsgType0x210.vProtobuf);
  }
  
  public MessageRecord a(abxc paramabxc, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramabxc.a(), paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acai
 * JD-Core Version:    0.7.0.1
 */