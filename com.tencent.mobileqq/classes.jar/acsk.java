import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0xa4.submsgtype0xa4.MsgBody;

public class acsk
  implements acpi
{
  private static void a(QQAppInterface paramQQAppInterface, MsgType0x210 paramMsgType0x210)
  {
    for (int i = 0;; i = 0) {
      for (;;)
      {
        try
        {
          Object localObject1 = ((ActivityManager)paramQQAppInterface.getApp().getSystemService("activity")).getRunningTasks(1);
          if ((localObject1 == null) || (((List)localObject1).size() < 1)) {
            break;
          }
          localObject1 = ((ActivityManager.RunningTaskInfo)((List)localObject1).get(0)).topActivity.getClassName();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0xa4 : curActivity: " + (String)localObject1);
          }
          boolean bool = "com.tencent.mobileqq.activity.QQBrowserActivity".equals(localObject1);
          i = bool;
          Intent localIntent;
          Object localObject3 = null;
        }
        catch (Exception localException1)
        {
          try
          {
            bool = ((PowerManager)paramQQAppInterface.getApp().getSystemService("power")).isScreenOn();
            if ((!bool) || ((paramQQAppInterface.isBackgroundPause) && (i == 0))) {
              localObject3 = new submsgtype0xa4.MsgBody();
            }
            try
            {
              ((submsgtype0xa4.MsgBody)localObject3).mergeFrom(paramMsgType0x210.vProtobuf);
              if (!((submsgtype0xa4.MsgBody)localObject3).bytes_title.has()) {
                break label509;
              }
              paramMsgType0x210 = ((submsgtype0xa4.MsgBody)localObject3).bytes_title.get().toStringUtf8();
              if (!((submsgtype0xa4.MsgBody)localObject3).bytes_brief.has()) {
                break label503;
              }
              localObject1 = ((submsgtype0xa4.MsgBody)localObject3).bytes_brief.get().toStringUtf8();
              if (!((submsgtype0xa4.MsgBody)localObject3).bytes_url.has()) {
                break label497;
              }
              localObject3 = ((submsgtype0xa4.MsgBody)localObject3).bytes_url.get().toStringUtf8();
              if ((!TextUtils.isEmpty(paramMsgType0x210)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3)))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0xa4 : title: " + paramMsgType0x210 + ", brief: " + (String)localObject1 + ", url:" + (String)localObject3);
                }
                localIntent = new Intent(paramQQAppInterface.getApp(), QQBrowserActivity.class);
                localIntent.putExtra("url", (String)localObject3);
                localIntent.putExtra("uintype", 3001);
                localObject3 = new ToServiceMsg("mobileqq.service", paramQQAppInterface.getCurrentAccountUin(), "CMD_SHOW_NOTIFIYCATION");
                ((ToServiceMsg)localObject3).extraData.putStringArray("cmds", new String[] { localObject1, paramMsgType0x210, localObject1 });
                ((ToServiceMsg)localObject3).extraData.putParcelable("intent", localIntent);
                ((ToServiceMsg)localObject3).extraData.putParcelable("bitmap", null);
                paramQQAppInterface.sendToService((ToServiceMsg)localObject3);
                bdla.b(null, "dc00898", "", "", "0X8006425", "0X8006425", 0, 0, "", "", "", "");
              }
              return;
            }
            catch (Exception paramQQAppInterface)
            {
              if (!QLog.isColorLevel()) {
                break label492;
              }
              QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0xa4 : fail to parse 0x210_0xa4.");
              paramQQAppInterface.printStackTrace();
              return;
            }
            localException1 = localException1;
            if (QLog.isColorLevel()) {
              QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0xa4 : fail to get curActivity.");
            }
            localException1.printStackTrace();
            continue;
          }
          catch (Exception localException2)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0xa4 : fail to get screen on.");
            }
            localException2.printStackTrace();
            bool = true;
            continue;
          }
        }
        label492:
        label497:
        continue;
        label503:
        Object localObject2 = null;
        continue;
        label509:
        paramMsgType0x210 = null;
      }
    }
  }
  
  public MessageRecord a(acnk paramacnk, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramacnk.a(), paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acsk
 * JD-Core Version:    0.7.0.1
 */