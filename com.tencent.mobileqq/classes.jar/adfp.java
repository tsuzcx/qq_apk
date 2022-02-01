import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0xb3.SubMsgType0xb3.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xb3.SubMsgType0xb3.PushAddFrdNotify;

public class adfp
  implements adci
{
  public static String a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    Object localObject = null;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0xb3 parse start");
    }
    SubMsgType0xb3.PushAddFrdNotify localPushAddFrdNotify;
    int i;
    int j;
    long l1;
    MessageHandler localMessageHandler;
    for (;;)
    {
      try
      {
        paramArrayOfByte = (SubMsgType0xb3.MsgBody)new SubMsgType0xb3.MsgBody().mergeFrom(paramArrayOfByte);
        if (paramArrayOfByte == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0xb3 | msgBody is null.");
          }
          return null;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0xb3 parse failed.", paramArrayOfByte);
        }
        paramArrayOfByte = null;
        continue;
        if (!paramArrayOfByte.msg_add_frd_notify.has())
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0xb3 | msg_add_frd_notify is null.");
          return null;
        }
        localPushAddFrdNotify = (SubMsgType0xb3.PushAddFrdNotify)paramArrayOfByte.msg_add_frd_notify.get();
        i = localPushAddFrdNotify.uint32_source_id.get();
        j = localPushAddFrdNotify.uint32_subsource_id.get();
        if (!localPushAddFrdNotify.uint64_req_uin.has()) {
          break;
        }
      }
      l1 = localPushAddFrdNotify.uint64_req_uin.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessorQ.nearby.follow", 2, "decodeC2CMsgPkgSubMsgType0xb3, sourceid:" + i + "|subSourceid:" + j + " |reqUin: " + l1);
      }
      if ((i != 3076) && (i != 3077) && (i != 2076) && (i != 2077) && (i != 10012) && (i != 10013))
      {
        boolean bool = brlp.a(i);
        localMessageHandler = (MessageHandler)paramQQAppInterface.a(0);
        if (!bool) {
          break label401;
        }
        if (!localPushAddFrdNotify.bytes_mobile.has()) {
          break label388;
        }
        paramQQAppInterface = localPushAddFrdNotify.bytes_mobile.get().toStringUtf8();
      }
    }
    for (;;)
    {
      label286:
      long l3 = localPushAddFrdNotify.uint64_fuin.get();
      if (localPushAddFrdNotify.uint64_fuin_bubble_id.has()) {}
      for (long l2 = localPushAddFrdNotify.uint64_fuin_bubble_id.get();; l2 = -1L)
      {
        paramArrayOfByte = localObject;
        if (localPushAddFrdNotify.bytes_wording.has()) {
          paramArrayOfByte = localPushAddFrdNotify.bytes_wording.get().toStringUtf8();
        }
        localMessageHandler.a(String.valueOf(l3), paramQQAppInterface, l2, paramArrayOfByte, localPushAddFrdNotify.fixed32_timestamp.get(), i, j, l1);
        return String.valueOf(localPushAddFrdNotify.uint64_fuin.get());
        l1 = 0L;
        break;
        label388:
        paramQQAppInterface = null;
        break label286;
      }
      label401:
      paramQQAppInterface = null;
    }
  }
  
  public MessageRecord a(adan paramadan, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramadan.a(), paramMsgType0x210.vProtobuf);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adfp
 * JD-Core Version:    0.7.0.1
 */