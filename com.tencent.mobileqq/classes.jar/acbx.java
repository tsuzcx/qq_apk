import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x96.submsgtype0x96.MsgBody;

public class acbx
  implements abzb
{
  private static void a(QQAppInterface paramQQAppInterface, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 4, "OnLinePushMessageProcessor receive 0x96 push message ");
    }
    submsgtype0x96.MsgBody localMsgBody = new submsgtype0x96.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      paramMsgType0x210 = new Intent("tencent.qqcomic.push.msg");
      if (localMsgBody.uint32_push_type.has()) {
        switch (localMsgBody.uint32_push_type.get())
        {
        case 0: 
          paramMsgType0x210.setAction("tencent.qqcomic.show.dialog");
          for (;;)
          {
            paramMsgType0x210.putExtra("msg", localMsgBody.string_push_msg.get());
            paramQQAppInterface.getApp().sendBroadcast(paramMsgType0x210);
            return;
            paramMsgType0x210.setAction("tencent.qqcomic.show.dialog");
          }
        }
      }
    }
    catch (Exception paramQQAppInterface)
    {
      while (QLog.isColorLevel())
      {
        QLog.d("Q.msg.BaseMessageProcessor", 4, "OnLinePushMessageProcessor mergeFrom 0x96 exception ");
        return;
        paramMsgType0x210.setAction("tencent.qqcomic.show.egg");
        continue;
        paramMsgType0x210.setAction("tencent.qqcomic.show.dialog");
      }
    }
  }
  
  public MessageRecord a(abxc paramabxc, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramabxc.a(), paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acbx
 * JD-Core Version:    0.7.0.1
 */