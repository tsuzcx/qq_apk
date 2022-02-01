import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class acrj
  implements acpi
{
  private static void a(acnk paramacnk, MsgType0x210 paramMsgType0x210)
  {
    paramMsgType0x210 = ntj.a(paramacnk.a(), paramMsgType0x210.vProtobuf);
    if (paramMsgType0x210 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("storyRedDotDebug", 2, "receive push");
      }
      paramacnk.a(105, true, paramMsgType0x210);
    }
  }
  
  public MessageRecord a(acnk paramacnk, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramacnk, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acrj
 * JD-Core Version:    0.7.0.1
 */