import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.msf.service.protocol.pb.SubMsgType0x51.MsgBody;
import com.tencent.qphone.base.util.QLog;

public class adeb
  implements adci
{
  private static void a(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler, MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    byte[] arrayOfByte = null;
    if (QLog.isColorLevel()) {
      QLog.d("DevLock", 2, "recv msg0x210.Submsgtype0x51");
    }
    new SubMsgType0x51.MsgBody();
    try
    {
      SubMsgType0x51.MsgBody localMsgBody = new SubMsgType0x51.MsgBody();
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      if (localMsgBody.bytes_qrsig_url.has())
      {
        paramMsgType0x210 = new String(localMsgBody.bytes_qrsig_url.get().toByteArray(), "utf-8");
        if (localMsgBody.bytes_hint1.has())
        {
          str1 = new String(localMsgBody.bytes_hint1.get().toByteArray(), "utf-8");
          if (localMsgBody.bytes_hint2.has())
          {
            str2 = new String(localMsgBody.bytes_hint2.get().toByteArray(), "utf-8");
            if (localMsgBody.bytes_login_conf.has()) {
              arrayOfByte = localMsgBody.bytes_login_conf.get().toByteArray();
            }
            if (QLog.isColorLevel()) {
              QLog.d("DevLock", 2, "recv devlock quicklogin push qrcode=" + paramMsgType0x210 + " maintip=" + str1 + " smalltip" + str2);
            }
            asvf.a().a(paramQQAppInterface, paramMsgType0x210, str1, str2, arrayOfByte);
            bcrw.a(paramMessageHandler, paramMsgInfo.lFromUin, paramMsgInfo.shMsgSeq, paramMsgInfo.lMsgUid, paramMsgInfo.shMsgType);
            return;
          }
        }
      }
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        String str1;
        String str2;
        if (QLog.isColorLevel())
        {
          QLog.d("DevLock", 2, "failed to parse msg0x210.Submsgtype0x51");
          continue;
          str2 = null;
          continue;
          str1 = null;
          continue;
          paramMsgType0x210 = null;
        }
      }
    }
  }
  
  public MessageRecord a(adan paramadan, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramadan.a(), paramadan.a().a(), paramMsgInfo, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adeb
 * JD-Core Version:    0.7.0.1
 */