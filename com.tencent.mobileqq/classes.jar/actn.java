import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop.NearbyVideoProxyBroadcastReceiver;
import mqq.app.MobileQQ;

public class actn
  implements acpi
{
  private static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessorQ.nearby.video_chat", 2, "handleMsgType0x210SuMsgType0xe4");
    }
    if (paramQQAppInterface != null)
    {
      Intent localIntent = new Intent("tencent.video.q2v.nearbyVideoChatPush");
      localIntent.putExtra("uin", paramQQAppInterface.getCurrentUin());
      localIntent.putExtra("pushData", paramArrayOfByte);
      localIntent.setPackage(MobileQQ.getContext().getPackageName());
      NearbyVideoProxyBroadcastReceiver.a(paramQQAppInterface.getApp(), localIntent);
    }
  }
  
  public MessageRecord a(acnk paramacnk, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramacnk.a(), paramMsgType0x210.vProtobuf);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     actn
 * JD-Core Version:    0.7.0.1
 */