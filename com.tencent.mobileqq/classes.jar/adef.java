import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class adef
  implements adci
{
  private static void a(QQAppInterface paramQQAppInterface, MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.push", 2, "receive msg0x210submsg0x66");
    }
    akyb.a(paramQQAppInterface, paramMsgType0x210.vProtobuf, paramMsgInfo.lFromUin, paramMsgInfo.shMsgSeq, paramMsgInfo.lMsgUid, paramMsgInfo.shMsgType);
  }
  
  public MessageRecord a(adan paramadan, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramadan.a(), paramMsgInfo, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adef
 * JD-Core Version:    0.7.0.1
 */