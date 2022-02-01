import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msgsync.cmd0x100.Submsgtype0x8a.ReqBody;

public class acrz
  implements acpi
{
  private static void a(QQAppInterface paramQQAppInterface, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b onlinepush");
    }
    Submsgtype0x8a.ReqBody localReqBody = new Submsgtype0x8a.ReqBody();
    try
    {
      localReqBody.mergeFrom(paramMsgType0x210.vProtobuf);
      bctj.a(paramQQAppInterface, localReqBody, 0L, false);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b online msg, prase reqBody error");
    }
  }
  
  public MessageRecord a(acnk paramacnk, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramacnk.a(), paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acrz
 * JD-Core Version:    0.7.0.1
 */