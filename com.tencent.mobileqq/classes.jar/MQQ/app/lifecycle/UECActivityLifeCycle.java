package mqq.app.lifecycle;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QActivityLifecycleCallbacks;

@TargetApi(14)
public final class UECActivityLifeCycle
  implements Handler.Callback, QActivityLifecycleCallbacks
{
  private static final int DELAY_BROADCAST = 100;
  private static final int MSG_BACK = 0;
  private static final int MSG_FORE = 1;
  public static final String TAG = "MobileQQLife";
  private Context mContext;
  public int mCountActivity = 0;
  public int mCountResume = 0;
  private Handler mHandler;
  private String mProcessName;
  
  public UECActivityLifeCycle(Context paramContext, Looper paramLooper, String paramString)
  {
    this.mProcessName = paramString;
    this.mContext = paramContext;
    this.mHandler = new Handler(paramLooper, this);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    long l = paramMessage.arg1 << 32 | paramMessage.arg2 & 0xFFFFFFFF;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMessage.what);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.mProcessName);
      localStringBuilder.append(", ");
      localStringBuilder.append(l);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.mCountActivity);
      QLog.i("mqq", 2, localStringBuilder.toString());
    }
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1) {
        return true;
      }
      if (this.mCountActivity > 0) {
        MsfServiceSdk.get().onProcessViewableChanged(true, l);
      }
    }
    if (this.mCountActivity == 0) {
      MsfServiceSdk.get().onProcessViewableChanged(false, l);
    }
    return true;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity)
  {
    this.mCountResume -= 1;
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    this.mCountResume += 1;
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    this.mCountActivity += 1;
    int i = this.mCountActivity;
    if ((i == 1) || (i == 2))
    {
      long l = SystemClock.uptimeMillis();
      paramActivity = this.mHandler.obtainMessage(1, (int)(l >>> 32), (int)(l & 0xFFFFFFFF));
      this.mHandler.sendMessageDelayed(paramActivity, 100L);
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    int i = this.mCountActivity - 1;
    this.mCountActivity = i;
    if (i == 0)
    {
      long l = SystemClock.uptimeMillis();
      paramActivity = this.mHandler.obtainMessage(0, (int)(l >>> 32), (int)(l & 0xFFFFFFFF));
      this.mHandler.sendMessageDelayed(paramActivity, 100L);
    }
  }
  
  public void onProcessBackground() {}
  
  public void onProcessForeground() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.app.lifecycle.UECActivityLifeCycle
 * JD-Core Version:    0.7.0.1
 */