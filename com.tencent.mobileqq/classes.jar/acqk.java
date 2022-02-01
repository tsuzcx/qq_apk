import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.submsgtype0x136.Submsgtype0x136.MsgBody;

public class acqk
  implements acpi
{
  private static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x136");
    }
    Submsgtype0x136.MsgBody localMsgBody = new Submsgtype0x136.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramArrayOfByte);
      if (localMsgBody.uint32_msg_type.get() == 0) {
        ((aoep)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(String.valueOf(localMsgBody.uint64_group_id.get()), 1, 0, null, 0);
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x136 " + paramQQAppInterface);
    }
  }
  
  public MessageRecord a(acnk paramacnk, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramacnk.a(), paramMsgType0x210.vProtobuf);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acqk
 * JD-Core Version:    0.7.0.1
 */