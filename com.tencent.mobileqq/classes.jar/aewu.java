import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aewu
  implements Handler.Callback
{
  public static int a;
  public static long a;
  private static aewu jdField_a_of_type_Aewu;
  public static boolean a;
  private static boolean b;
  private Handler jdField_a_of_type_AndroidOsHandler = new bjng(Looper.getMainLooper(), this);
  
  static
  {
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_Long = -1L;
    jdField_a_of_type_Aewu = new aewu();
    a();
  }
  
  public static aewu a()
  {
    try
    {
      aewu localaewu = jdField_a_of_type_Aewu;
      return localaewu;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a()
  {
    boolean bool1 = true;
    for (;;)
    {
      Object localObject1;
      try
      {
        boolean bool2 = b;
        if (bool2) {
          return;
        }
      }
      finally {}
      try
      {
        localObject1 = DeviceProfileManager.b().a(DeviceProfileManager.DpcNames.aio_config.name(), "-1|1=0,2=0,3=0,4=0,5=1|1");
        if (QLog.isColorLevel()) {
          QLog.i("Q.aio.AIOPreLoadEngine", 2, "initAIOPreloadFlagByDpc thumbConfig:" + (String)localObject1);
        }
        localObject1 = ((String)localObject1).split("\\|");
        if (localObject1.length > 2)
        {
          if (!"1".equals(localObject1[2])) {
            break label137;
          }
          jdField_a_of_type_Boolean = bool1;
        }
      }
      catch (Exception localException)
      {
        label137:
        jdField_a_of_type_Boolean = false;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.aio.AIOPreLoadEngine", 2, "initAIOPreloadFlagByDpc error|" + jdField_a_of_type_Boolean);
        continue;
      }
      b = true;
      if (QLog.isColorLevel())
      {
        QLog.i("Q.aio.AIOPreLoadEngine", 2, "initAIOPreloadFlagByDpc|" + jdField_a_of_type_Boolean);
        continue;
        bool1 = false;
      }
    }
  }
  
  @TargetApi(17)
  private void a(Activity paramActivity)
  {
    SplashActivity localSplashActivity;
    label122:
    FragmentManager localFragmentManager;
    Fragment localFragment;
    if ((paramActivity != null) && ((paramActivity instanceof SplashActivity)))
    {
      if ((jdField_a_of_type_Int == 1) || (QQAppInterface.AIO_HAD_OPEN)) {
        if (QLog.isColorLevel()) {
          QLog.e("Q.aio.AIOPreLoadEngine", 2, "sPreloadedAIOType:" + jdField_a_of_type_Int + "|AIO_HAD_OPEN:" + QQAppInterface.AIO_HAD_OPEN);
        }
      }
      do
      {
        return;
        localSplashActivity = (SplashActivity)paramActivity;
        if ((localSplashActivity.app != null) && (localSplashActivity.app.isRunning()) && (localSplashActivity.app.isLogin())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("Q.aio.AIOPreLoadEngine", 2, "app is not valid");
      return;
      if (!QLog.isColorLevel())
      {
        localFragmentManager = localSplashActivity.getSupportFragmentManager();
        localFragment = localFragmentManager.findFragmentByTag(ChatFragment.class.getName());
        if (((Build.VERSION.SDK_INT <= 16) || (!paramActivity.isDestroyed())) && (!paramActivity.isFinishing())) {
          break label296;
        }
      }
    }
    label296:
    for (boolean bool = false;; bool = true)
    {
      if ((localFragment == null) && (bool))
      {
        jdField_a_of_type_Long = SystemClock.uptimeMillis();
        bfzg.a(null, "AIO_preLoad_Cost");
        try
        {
          paramActivity = localFragmentManager.beginTransaction();
          paramActivity.add(16908290, ChatFragment.a(), ChatFragment.class.getName());
          localSplashActivity.setIntent(new Intent());
          paramActivity.commitAllowingStateLoss();
          jdField_a_of_type_Int = 1;
          return;
        }
        catch (Exception paramActivity)
        {
          QLog.e("Q.aio.AIOPreLoadEngine", 1, "AIO preLoad:", paramActivity);
          return;
        }
        QLog.d("Q.aio.AIOPreLoadEngine", 2, "doRealPreLoadAIO");
        break label122;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.aio.AIOPreLoadEngine", 2, "AIO cannot peload:" + bool);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.aio.AIOPreLoadEngine", 2, "activity is not splashActivity");
      return;
    }
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    if (!jdField_a_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.AIOPreLoadEngine", 2, "startPreLoadAIO return");
      }
    }
    for (;;)
    {
      return;
      if (!QLog.isColorLevel()) {}
      while (paramBaseActivity != null)
      {
        Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
        localMessage.what = 1;
        localMessage.obj = paramBaseActivity;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
        return;
        QLog.i("Q.aio.AIOPreLoadEngine", 2, "startPreLoadAIO");
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (paramMessage.obj != null) {
        a((Activity)paramMessage.obj);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aewu
 * JD-Core Version:    0.7.0.1
 */