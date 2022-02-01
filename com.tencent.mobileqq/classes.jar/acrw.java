import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x86.SubMsgType0x86.MsgBody;

public class acrw
  implements acpi
{
  private static void a(QQAppInterface paramQQAppInterface, MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 4, "OnLinePushMessageProcessor receive 0x86 push message, seq = " + paramMsgInfo.shMsgSeq + "submsgtype:" + paramMsgInfo.shMsgType);
    }
    paramMsgInfo = new SubMsgType0x86.MsgBody();
    for (;;)
    {
      try
      {
        paramMsgInfo.mergeFrom(paramMsgType0x210.vProtobuf);
        if (paramMsgInfo != null)
        {
          if (paramMsgInfo.uint32_notify_flag.get() != 1) {
            continue;
          }
          bool = true;
          if (bool == true)
          {
            paramMsgInfo = new String(paramMsgInfo.bytes_notify_wording.get().toByteArray(), "utf-8");
            bapk.a(paramQQAppInterface, bool, paramMsgInfo);
            paramQQAppInterface.getAVNotifyCenter().a(bool, paramMsgInfo);
          }
        }
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        boolean bool;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.msg.BaseMessageProcessor", 2, "parse 0x86 push msg error", paramQQAppInterface);
      }
      bool = false;
    }
  }
  
  public MessageRecord a(acnk paramacnk, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramacnk.a(), paramMsgInfo, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acrw
 * JD-Core Version:    0.7.0.1
 */