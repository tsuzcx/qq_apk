import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.QLog;

public class alou
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int j = 0;
    int i = 0;
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity == null) {
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, paramIntent.getAction());
      }
    }
    for (;;)
    {
      return;
      if (paramIntent.getAction().equals("android.intent.action.SCREEN_OFF"))
      {
        if ((localBaseActivity.mStopFlag == 0) && (localBaseActivity.mCanLock) && (GesturePWDUtils.getGesturePWDState(localBaseActivity, localBaseActivity.getCurrentAccountUin()) == 2) && (GesturePWDUtils.getGesturePWDMode(localBaseActivity, localBaseActivity.getCurrentAccountUin()) == 21) && (!(localBaseActivity instanceof GesturePWDUnlockActivity)) && (!(localBaseActivity instanceof LoginActivity)) && (!GesturePWDUtils.getGestureLocking(localBaseActivity)))
        {
          BaseActivity.mAppForground = false;
          GesturePWDUtils.setAppForground(paramContext, BaseActivity.mAppForground);
          BaseActivity.isUnLockSuccess = false;
          if (BaseActivity.access$300() == null) {
            continue;
          }
          if (SettingCloneUtil.readValue(paramContext, null, paramContext.getString(2131695444), "qqsetting_screenshot_key", false)) {
            break label169;
          }
        }
        for (;;)
        {
          if (i == 0) {
            break label172;
          }
          localBaseActivity.turnOffShake();
          return;
          localBaseActivity.receiveScreenOff();
          break;
          label169:
          i = 1;
        }
      }
      else
      {
        label172:
        if ((paramIntent.getAction().equals("android.intent.action.SCREEN_ON")) && (BaseActivity.access$300() == null))
        {
          if (!SettingCloneUtil.readValue(paramContext, null, paramContext.getString(2131695444), "qqsetting_screenshot_key", false)) {}
          for (i = j; i != 0; i = 1)
          {
            localBaseActivity.turnOnShake();
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alou
 * JD-Core Version:    0.7.0.1
 */