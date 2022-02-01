package mqq.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.util.AndroidOUIWrapperUtil;
import mqq.util.WeakReference;

@TargetApi(16)
public class AppActivity
  extends FragmentActivity
{
  public static Locale locale;
  public static int localeId;
  public static IActivityDispatchCallback sActivityDispatchCallback;
  private boolean mIsFinishingInOnCreate = false;
  private boolean mIsResultWaiting;
  protected boolean mIsResume = false;
  private boolean mIsSplashing = false;
  private boolean mIsStartSkipped = false;
  private Intent mNewIntent;
  private Bundle mOnCreateBundle = null;
  private Bundle mOnRestoreBundle;
  private SparseArray<List> mPermissionCallerMap = new SparseArray();
  private Bundle mPostCreateBundle = null;
  private AppRuntime mProRuntime;
  private int mRequestCode;
  private int mResultCode;
  private Intent mResultData;
  protected AppRuntime mRuntime = null;
  private int mWindowFocusState = -1;
  
  private boolean isActivityLocaleUpdated(Locale paramLocale)
  {
    Locale localLocale = locale;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localLocale != null)
    {
      if (paramLocale == null) {
        return false;
      }
      bool1 = localLocale.getLanguage().equals(paramLocale.getLanguage());
      boolean bool3 = locale.getCountry().equals(paramLocale.getCountry());
      if (bool1)
      {
        bool1 = bool2;
        if (bool3) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean isLocaleCN()
  {
    return localeId == 2052;
  }
  
  public static void setActivityDispatchCallback(IActivityDispatchCallback paramIActivityDispatchCallback)
  {
    sActivityDispatchCallback = paramIActivityDispatchCallback;
  }
  
  protected void beforeDoOnCreate()
  {
    MobileQQ.sMobileQQ.appActivities.add(new WeakReference(this));
    this.mOnCreateBundle = null;
    setAppRuntime(MobileQQ.sMobileQQ.waitAppRuntime(null));
    if (isActivityLocaleUpdated(getResources().getConfiguration().locale))
    {
      Resources localResources = getResources();
      Configuration localConfiguration = localResources.getConfiguration();
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      localDisplayMetrics.setTo(localResources.getDisplayMetrics());
      localConfiguration.locale = locale;
      localResources.updateConfiguration(localConfiguration, localResources.getDisplayMetrics());
      localResources.getDisplayMetrics().setTo(localDisplayMetrics);
    }
  }
  
  public boolean bindService(Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    ThirdAppReportHelper.reportThirdAppOpen(this, paramIntent, 2);
    return super.bindService(paramIntent, paramServiceConnection, paramInt);
  }
  
  public int checkSelfPermission(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return super.checkSelfPermission(paramString);
    }
    return 0;
  }
  
  @Deprecated
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (this.mIsSplashing) {
      return false;
    }
    return doDispatchKeyEvent(paramKeyEvent);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    IActivityDispatchCallback localIActivityDispatchCallback = sActivityDispatchCallback;
    if (localIActivityDispatchCallback != null) {
      localIActivityDispatchCallback.disaptchTouchEventCallback(this, paramMotionEvent);
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  protected void doOnBackPressed()
  {
    try
    {
      super.onBackPressed();
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "", localThrowable);
      }
    }
  }
  
  protected void doOnConfigurationChanged(Configuration paramConfiguration) {}
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    return true;
  }
  
  protected void doOnDestroy()
  {
    MobileQQ.sMobileQQ.appActivities.remove(new WeakReference(this));
  }
  
  protected boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void doOnNewIntent(Intent paramIntent) {}
  
  protected void doOnPause() {}
  
  protected void doOnPostCreate(Bundle paramBundle)
  {
    this.mPostCreateBundle = null;
  }
  
  protected void doOnPostResume() {}
  
  protected void doOnRestoreInstanceState(Bundle paramBundle) {}
  
  protected void doOnResume() {}
  
  protected void doOnSaveInstanceState(Bundle paramBundle) {}
  
  protected void doOnStart()
  {
    if (isActivityLocaleUpdated(getResources().getConfiguration().locale)) {
      recreate();
    }
  }
  
  protected void doOnStop() {}
  
  protected void doOnUserLeaveHint() {}
  
  protected void doOnWindowFocusChanged(boolean paramBoolean) {}
  
  public final AppRuntime getAppRuntime()
  {
    return this.mRuntime;
  }
  
  protected String getModuleId()
  {
    return null;
  }
  
  final AppRuntime getProRuntime()
  {
    return this.mProRuntime;
  }
  
  public Resources getResources()
  {
    if (isLocaleCN()) {
      return super.getResources();
    }
    return getApplicationContext().getResources();
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
  }
  
  public final boolean isResume()
  {
    return this.mIsResume;
  }
  
  protected void onAccountChanged() {}
  
  protected void onAccoutChangeFailed() {}
  
  @Deprecated
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (!this.mIsSplashing)
    {
      doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    this.mIsResultWaiting = true;
    this.mRequestCode = paramInt1;
    this.mResultCode = paramInt2;
    this.mResultData = paramIntent;
  }
  
  @Deprecated
  public void onBackPressed()
  {
    if (this.mIsSplashing) {
      return;
    }
    doOnBackPressed();
  }
  
  @Deprecated
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (!this.mIsSplashing) {
      doOnConfigurationChanged(paramConfiguration);
    }
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  @Deprecated
  protected void onCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    requestWindowFeature(localIntent);
    this.mIsSplashing = MobileQQ.sMobileQQ.onActivityCreate(this, localIntent);
    if (AndroidOUIWrapperUtil.isTranslucentOrFloating(this)) {
      AndroidOUIWrapperUtil.fixOrientation(this);
    }
    if (this.mIsSplashing)
    {
      this.mOnCreateBundle = paramBundle;
      if (paramBundle != null) {
        paramBundle.remove("android:support:fragments");
      }
      super.onCreate(paramBundle);
      return;
    }
    beforeDoOnCreate();
    super.onCreate(paramBundle);
    doOnCreate(paramBundle);
  }
  
  @Deprecated
  protected void onDestroy()
  {
    if ((!this.mIsSplashing) || (this.mIsFinishingInOnCreate)) {
      doOnDestroy();
    }
    super.onDestroy();
    this.mProRuntime = null;
  }
  
  @Deprecated
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.mIsSplashing) {
      return false;
    }
    return doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    finish();
  }
  
  @Deprecated
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (!this.mIsSplashing)
    {
      doOnNewIntent(paramIntent);
      return;
    }
    this.mNewIntent = paramIntent;
  }
  
  @Deprecated
  protected void onPause()
  {
    if (!this.mIsSplashing) {
      doOnPause();
    }
    this.mIsResume = false;
    super.onPause();
  }
  
  @Deprecated
  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    if (!this.mIsSplashing)
    {
      doOnPostCreate(paramBundle);
      return;
    }
    this.mPostCreateBundle = paramBundle;
  }
  
  @Deprecated
  protected void onPostResume()
  {
    super.onPostResume();
    if (!this.mIsSplashing) {
      doOnPostResume();
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if (paramArrayOfInt.length == 0) {
      return;
    }
    List localList = (List)this.mPermissionCallerMap.get(paramInt);
    if ((localList != null) && (localList.size() > 0))
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (localObject != null) {
          if ((localObject instanceof QQPermissionCallback))
          {
            localObject = (QQPermissionCallback)localObject;
            ArrayList localArrayList = new ArrayList();
            int i = 0;
            while (i < paramArrayOfInt.length)
            {
              if (paramArrayOfInt[i] != 0) {
                localArrayList.add(paramArrayOfString[i]);
              }
              i += 1;
            }
            if (localArrayList.size() > 0) {
              ((QQPermissionCallback)localObject).deny(paramInt, paramArrayOfString, paramArrayOfInt);
            } else {
              ((QQPermissionCallback)localObject).grant(paramInt, paramArrayOfString, paramArrayOfInt);
            }
          }
          else
          {
            QQPermissionHelper.requestResult(localObject, paramInt, paramArrayOfString, paramArrayOfInt);
          }
        }
      }
    }
    if (localList != null) {
      this.mPermissionCallerMap.remove(paramInt);
    }
  }
  
  @Deprecated
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    if (!this.mIsSplashing)
    {
      doOnRestoreInstanceState(paramBundle);
      return;
    }
    this.mOnRestoreBundle = paramBundle;
  }
  
  @Deprecated
  protected void onResume()
  {
    try
    {
      super.onResume();
    }
    catch (NullPointerException localNullPointerException)
    {
      QLog.d("AppActivity", 1, "super onResume", localNullPointerException);
    }
    catch (IllegalArgumentException localIllegalArgumentException1)
    {
      QLog.d("AppActivity", 1, "super onResume", localIllegalArgumentException1);
      try
      {
        Field localField = Activity.class.getDeclaredField("mCalled");
        localField.setAccessible(true);
        localField.set(this, Boolean.valueOf(true));
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
      catch (IllegalArgumentException localIllegalArgumentException2)
      {
        localIllegalArgumentException2.printStackTrace();
      }
      catch (SecurityException localSecurityException)
      {
        localSecurityException.printStackTrace();
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localNoSuchFieldException.printStackTrace();
      }
    }
    this.mIsResume = true;
    if (!this.mIsSplashing) {
      doOnResume();
    }
  }
  
  @Deprecated
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (!this.mIsSplashing) {
      doOnSaveInstanceState(paramBundle);
    }
  }
  
  @Deprecated
  protected void onStart()
  {
    super.onStart();
    if (!this.mIsSplashing)
    {
      doOnStart();
      return;
    }
    this.mIsStartSkipped = true;
  }
  
  @Deprecated
  protected void onStop()
  {
    if (!this.mIsSplashing) {
      doOnStop();
    } else {
      this.mIsStartSkipped = false;
    }
    super.onStop();
  }
  
  @Deprecated
  protected void onUserLeaveHint()
  {
    if (!this.mIsSplashing) {
      doOnUserLeaveHint();
    }
    super.onUserLeaveHint();
  }
  
  @Deprecated
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean preloadData(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    return false;
  }
  
  public void preloadUi() {}
  
  public void realOnCreate()
  {
    if (this.mIsSplashing)
    {
      boolean bool = false;
      this.mIsSplashing = false;
      beforeDoOnCreate();
      if ((doOnCreate(this.mOnCreateBundle)) && (!isFinishing()))
      {
        Foreground.updateRuntimeState(this.mProRuntime);
        if (this.mIsStartSkipped)
        {
          doOnStart();
          this.mIsStartSkipped = false;
          Object localObject = this.mOnRestoreBundle;
          if (localObject != null)
          {
            doOnRestoreInstanceState((Bundle)localObject);
            this.mOnRestoreBundle = null;
          }
          doOnPostCreate(this.mPostCreateBundle);
          if (this.mIsResultWaiting)
          {
            doOnActivityResult(this.mRequestCode, this.mResultCode, this.mResultData);
            this.mIsResultWaiting = false;
            this.mResultData = null;
          }
          localObject = this.mNewIntent;
          if (localObject != null)
          {
            doOnNewIntent((Intent)localObject);
            this.mNewIntent = null;
          }
          if (isResume())
          {
            doOnResume();
            doOnPostResume();
          }
          int i = this.mWindowFocusState;
          if (i == -1) {
            return;
          }
          if (i == 1) {
            bool = true;
          }
          doOnWindowFocusChanged(bool);
        }
      }
      else if (isFinishing())
      {
        this.mIsSplashing = true;
        this.mIsFinishingInOnCreate = true;
      }
    }
  }
  
  @TargetApi(24)
  public void requestPermissions(Object paramObject, int paramInt, String... paramVarArgs)
  {
    boolean bool = QLog.isColorLevel();
    int j = 1;
    if (bool) {
      QLog.d("qqBaseActivity", 2, new Object[] { "fight.requestPermissions-", paramVarArgs });
    }
    ArrayList localArrayList = new ArrayList();
    int k = paramVarArgs.length;
    int i = 0;
    Object localObject;
    while (i < k)
    {
      localObject = paramVarArgs[i];
      if ((Build.VERSION.SDK_INT >= 23) && (checkSelfPermission((String)localObject) != 0)) {
        localArrayList.add(localObject);
      }
      i += 1;
    }
    if (localArrayList.size() > 0)
    {
      localObject = (List)this.mPermissionCallerMap.get(paramInt);
      paramVarArgs = (String[])localObject;
      if (localObject == null) {
        paramVarArgs = new ArrayList();
      }
      k = paramVarArgs.size();
      i = 0;
      while (i < k)
      {
        localObject = paramVarArgs.get(i);
        if ((localObject != null) && (localObject == paramObject))
        {
          i = j;
          break label195;
        }
        i += 1;
      }
      i = 0;
      label195:
      if (i == 0)
      {
        paramVarArgs.add(paramObject);
        this.mPermissionCallerMap.put(paramInt, paramVarArgs);
      }
      requestPermissions((String[])localArrayList.toArray(new String[localArrayList.size()]), paramInt);
      return;
    }
    if ((paramObject instanceof QQPermissionCallback))
    {
      ((QQPermissionCallback)paramObject).grant(paramInt, paramVarArgs, null);
      return;
    }
    QQPermissionHelper.doExecuteSuccess(paramObject, paramInt);
  }
  
  protected void requestWindowFeature(Intent paramIntent) {}
  
  public void sendBroadcast(Intent paramIntent)
  {
    MobileQQ.restrictBroadcast(paramIntent);
    super.sendBroadcast(paramIntent);
    MobileQQ.sMobileQQ.onSendBroadcast(this, paramIntent);
  }
  
  public void sendBroadcast(Intent paramIntent, String paramString)
  {
    MobileQQ.restrictBroadcast(paramIntent);
    super.sendBroadcast(paramIntent, paramString);
    MobileQQ.sMobileQQ.onSendBroadcast(this, paramIntent);
  }
  
  public void sendOrderedBroadcast(Intent paramIntent, String paramString)
  {
    MobileQQ.restrictBroadcast(paramIntent);
    super.sendOrderedBroadcast(paramIntent, paramString);
    MobileQQ.sMobileQQ.onSendBroadcast(this, paramIntent);
  }
  
  public void sendOrderedBroadcast(Intent paramIntent, String paramString1, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString2, Bundle paramBundle)
  {
    MobileQQ.restrictBroadcast(paramIntent);
    super.sendOrderedBroadcast(paramIntent, paramString1, paramBroadcastReceiver, paramHandler, paramInt, paramString2, paramBundle);
    MobileQQ.sMobileQQ.onSendBroadcast(this, paramIntent);
  }
  
  void setAppRuntime(AppRuntime paramAppRuntime)
  {
    this.mProRuntime = paramAppRuntime;
    AppRuntime localAppRuntime = paramAppRuntime;
    if (paramAppRuntime != null)
    {
      String str = getModuleId();
      localAppRuntime = paramAppRuntime;
      if (!TextUtils.isEmpty(str)) {
        localAppRuntime = paramAppRuntime.getAppRuntime(str);
      }
    }
    this.mRuntime = localAppRuntime;
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    if (!AndroidOUIWrapperUtil.isTranslucentOrFloating(this)) {
      super.setRequestedOrientation(paramInt);
    }
  }
  
  public boolean showPreview()
  {
    return false;
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    paramIntent.putExtra("preAct", getClass().getSimpleName());
    paramIntent.putExtra("preAct_time", System.currentTimeMillis());
    paramIntent.putExtra("preAct_elapsedRealtime", SystemClock.elapsedRealtime());
    FileProvider7Helper.intentCompatForN(this, paramIntent);
    ThirdAppReportHelper.reportThirdAppOpen(this, paramIntent, 0);
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
  
  public ComponentName startService(Intent paramIntent)
  {
    ThirdAppReportHelper.reportThirdAppOpen(this, paramIntent, 1);
    return super.startService(paramIntent);
  }
  
  public void superFinish()
  {
    super.finish();
  }
  
  public void superSetRequestedOrientation(int paramInt)
  {
    super.setRequestedOrientation(paramInt);
  }
  
  public final void superStartActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      super.startActivityForResult(paramIntent, -1, paramBundle);
      return;
    }
    super.startActivityForResult(paramIntent, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqq.app.AppActivity
 * JD-Core Version:    0.7.0.1
 */