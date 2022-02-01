import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import tencent.im.s2c.msgtype0x210.submsgtype0x116.submsgtype0x116.MsgBody;

public class adct
  implements adci
{
  private static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    Object localObject = new submsgtype0x116.MsgBody();
    try
    {
      ((submsgtype0x116.MsgBody)localObject).mergeFrom(paramArrayOfByte);
      long l1 = lcy.a(((submsgtype0x116.MsgBody)localObject).uint32_group_id.get());
      long l2 = lcy.a(((submsgtype0x116.MsgBody)localObject).uint32_room_id.get());
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SuMsgType0x116 qqMainThread;roomId=" + l2 + ";groupId=" + l1);
      }
      if (paramQQAppInterface != null)
      {
        localObject = new Intent("tencent.video.q2v.GvideoMemInviteUpdate");
        ((Intent)localObject).putExtra("uin", paramQQAppInterface.c());
        ((Intent)localObject).putExtra("groupId", l1);
        ((Intent)localObject).putExtra("roomId", l2);
        ((Intent)localObject).putExtra("pushData", paramArrayOfByte);
        ((Intent)localObject).setPackage(MobileQQ.getContext().getPackageName());
        paramQQAppInterface.getApp().sendBroadcast((Intent)localObject);
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
  }
  
  public MessageRecord a(adan paramadan, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramadan.a(), paramMsgType0x210.vProtobuf);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adct
 * JD-Core Version:    0.7.0.1
 */