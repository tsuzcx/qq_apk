import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x115.SubMsgType0x115.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x115.SubMsgType0x115.NotifyItem;

public class acps
  implements acpi
{
  private static void a(acnk paramacnk, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x115, [S2C push for input status]");
    }
    try
    {
      SubMsgType0x115.MsgBody localMsgBody = new SubMsgType0x115.MsgBody();
      if (paramacnk.a(paramMsgType0x210))
      {
        localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
        long l1 = localMsgBody.uint64_from_uin.get();
        long l2 = localMsgBody.uint64_to_uin.get();
        paramMsgType0x210 = (SubMsgType0x115.NotifyItem)localMsgBody.msg_notify_item.get();
        int i = paramMsgType0x210.uint32_timeout_s.get();
        int j = paramMsgType0x210.uint32_event_type.get();
        int k = paramMsgType0x210.uint32_interval.get();
        long l3 = paramMsgType0x210.uint64_timestamp.get();
        paramMsgType0x210 = paramMsgType0x210.bytes_wording.get().toStringUtf8();
        paramacnk = paramacnk.a().getManager(QQManagerFactory.AIO_INPUT_STATUS_MANAGER);
        if ((paramacnk instanceof avrk)) {
          ((avrk)paramacnk).a(l1, l2, l3, k, i, j, paramMsgType0x210);
        }
      }
      return;
    }
    catch (Exception paramacnk)
    {
      QLog.e("Q.msg.BaseMessageProcessor", 1, "[msg0x210.uSubMsgType == 0x115], errInfo->" + paramacnk.getMessage());
    }
  }
  
  public MessageRecord a(acnk paramacnk, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramacnk, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acps
 * JD-Core Version:    0.7.0.1
 */