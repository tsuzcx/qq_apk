import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenPermissionDialogFragment;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class aluq
{
  private static Point jdField_a_of_type_AndroidGraphicsPoint = new Point(-1, -1);
  private static boolean jdField_a_of_type_Boolean;
  private static boolean b;
  
  public static Point a(QQAppInterface paramQQAppInterface)
  {
    if ((jdField_a_of_type_AndroidGraphicsPoint.x == -1) || (jdField_a_of_type_AndroidGraphicsPoint.y == -1))
    {
      paramQQAppInterface = baig.a(paramQQAppInterface.getApp(), paramQQAppInterface.c());
      int j = paramQQAppInterface.getInt("colornote_windows_x", -1);
      int k = paramQQAppInterface.getInt("colornote_windows_y", -1);
      int i;
      if (j != -1)
      {
        i = k;
        if (k != -1) {}
      }
      else
      {
        j = bajq.a() - bajq.a(25.0F);
        i = bajq.b() / 2 + bajq.a(25.0F);
      }
      jdField_a_of_type_AndroidGraphicsPoint.x = j;
      jdField_a_of_type_AndroidGraphicsPoint.y = i;
    }
    return jdField_a_of_type_AndroidGraphicsPoint;
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    jdField_a_of_type_AndroidGraphicsPoint.x = paramInt1;
    jdField_a_of_type_AndroidGraphicsPoint.y = paramInt2;
  }
  
  /* Error */
  public static void a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +30 -> 36
    //   9: ldc 74
    //   11: iconst_1
    //   12: new 76	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   19: ldc 80
    //   21: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: getstatic 86	aluq:jdField_a_of_type_Boolean	Z
    //   27: invokevirtual 89	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   30: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: new 98	android/content/Intent
    //   39: dup
    //   40: aload_0
    //   41: ldc 100
    //   43: invokespecial 103	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   46: astore_1
    //   47: iconst_0
    //   48: putstatic 86	aluq:jdField_a_of_type_Boolean	Z
    //   51: aload_0
    //   52: aload_1
    //   53: invokevirtual 109	android/content/Context:stopService	(Landroid/content/Intent;)Z
    //   56: pop
    //   57: ldc 2
    //   59: monitorexit
    //   60: return
    //   61: astore_0
    //   62: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   65: ifeq -8 -> 57
    //   68: ldc 74
    //   70: iconst_2
    //   71: new 76	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   78: ldc 111
    //   80: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_0
    //   84: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 117	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   93: goto -36 -> 57
    //   96: astore_0
    //   97: ldc 2
    //   99: monitorexit
    //   100: aload_0
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	paramContext	Context
    //   46	7	1	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   47	57	61	java/lang/Exception
    //   3	36	96	finally
    //   36	47	96	finally
    //   47	57	96	finally
    //   62	93	96	finally
  }
  
  public static void a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteSmallScreenUtil", 1, "sendUpdateSmallScreenStateBroadcast sHasServiceExit = " + jdField_a_of_type_Boolean + ", from = " + paramInt + ", shouldShow = " + paramBoolean);
    }
    Intent localIntent1 = new Intent("action_update_cn_smallscreen_state");
    localIntent1.setPackage(paramContext.getPackageName());
    localIntent1.putExtra("param_from", paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      paramContext.sendBroadcast(localIntent1);
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteSmallScreenUtil", 2, "sendUpdateSmallScreenStateBroadcast:" + paramBoolean);
      }
      return;
      localIntent1.putExtra("param_not_in_colornote_list", paramBoolean);
      continue;
      localIntent1.putExtra("param_shoule_show_smallscreen", paramBoolean);
      continue;
      Intent localIntent2;
      if (paramBoolean) {
        localIntent2 = new Intent(paramContext, ColorNoteSmallScreenService.class);
      }
      try
      {
        paramContext.startService(localIntent2);
        localIntent1.putExtra("param_is_app_foreground", paramBoolean);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ColorNoteSmallScreenUtil", 2, "actionOn e = " + localException);
          }
        }
      }
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    if (BaseApplicationImpl.getApplication().getRuntime().isLogin())
    {
      Intent localIntent = new Intent(paramContext, ColorNoteSmallScreenService.class);
      localIntent.putExtra("KEY_CMD_SHOW_LIST", 1);
      localIntent.putExtra("KEY_SHOW_LIST_LAND", paramBoolean);
      paramContext.startService(localIntent);
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("ColorNoteSmallScreenUtil", 1, "showColorNoteSmallScreen , idAdd = " + paramBoolean1 + ", sHasServiceExit = " + jdField_a_of_type_Boolean + ", force = " + paramBoolean2);
        }
        if ((!alui.a(paramContext)) && (paramBoolean1)) {
          b(paramContext);
        }
        if ((!jdField_a_of_type_Boolean) || (paramBoolean2))
        {
          jdField_a_of_type_Boolean = true;
          Intent localIntent = new Intent(paramContext, ColorNoteSmallScreenService.class);
          try
          {
            paramContext.startService(localIntent);
            return;
          }
          catch (Exception paramContext)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ColorNoteSmallScreenUtil", 2, "actionOn e = " + paramContext);
            }
            jdField_a_of_type_Boolean = false;
            continue;
          }
        }
        a(paramContext, 3, true);
      }
      finally {}
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (!paramBoolean)
    {
      bool = paramBoolean;
      if (b(BaseApplicationImpl.getContext())) {
        bool = true;
      }
    }
    if ((bool) && (b))
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if (((localAppRuntime instanceof QQAppInterface)) && (localAppRuntime.isLogin()) && (((QQAppInterface)localAppRuntime).a().a().a() > 0)) {
        a(((QQAppInterface)localAppRuntime).getApp(), false, true);
      }
    }
  }
  
  public static boolean a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ColorNoteSmallScreenUtil", 2, "isAfterSyncMsg() " + b);
    }
    return b;
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool2 = false;
    String str = paramContext.getPackageName();
    for (;;)
    {
      try
      {
        localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
        List localList = localActivityManager.getRunningTasks(1);
        localRunningAppProcessInfo = null;
        paramContext = localRunningAppProcessInfo;
        if (localList != null)
        {
          paramContext = localRunningAppProcessInfo;
          if (localList.size() > 0) {
            paramContext = ((ActivityManager.RunningTaskInfo)localList.get(0)).topActivity;
          }
        }
        if ((paramContext == null) || (!paramContext.getPackageName().startsWith(str))) {
          break label259;
        }
        if (!QLog.isDevelopLevel()) {
          break label264;
        }
        QLog.d("ColorNoteSmallScreenUtil", 2, "isAppOnForeground componentName = " + paramContext);
      }
      catch (Throwable paramContext)
      {
        ActivityManager localActivityManager;
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
        bool1 = bool2;
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.d("ColorNoteSmallScreenUtil", 2, "isAppOnForeground e = " + paramContext);
        return false;
      }
      if (bool1)
      {
        paramContext = localActivityManager.getRunningAppProcesses();
        if (paramContext != null)
        {
          paramContext = paramContext.iterator();
          if (paramContext.hasNext())
          {
            localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
            if ((localRunningAppProcessInfo.importance != 100) || (!localRunningAppProcessInfo.processName.startsWith(str))) {
              continue;
            }
            if (QLog.isDevelopLevel()) {
              QLog.d("ColorNoteSmallScreenUtil", 2, "isAppOnForeground appProcess.processName = " + localRunningAppProcessInfo.processName);
            }
            bool1 = true;
            return bool1;
          }
        }
        bool1 = false;
        continue;
      }
      continue;
      label259:
      boolean bool1 = false;
      continue;
      label264:
      bool1 = true;
    }
  }
  
  private static void b(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ColorNoteSmallScreenUtil", 2, "showPermissionDialog in");
    }
    paramContext = new Intent();
    paramContext.putExtra("public_fragment_window_feature", 1);
    abju.a(paramContext, PublicTransFragmentActivity.class, ColorNoteSmallScreenPermissionDialogFragment.class);
  }
  
  public static void b(boolean paramBoolean)
  {
    try
    {
      b = paramBoolean;
      if (QLog.isDevelopLevel()) {
        QLog.d("ColorNoteSmallScreenUtil", 2, "setAfterSyncMsg " + b);
      }
      Intent localIntent = new Intent("key_after_sync_msg");
      localIntent.putExtra("extra_after_sync_msg", b);
      BaseApplicationImpl.getContext().sendBroadcast(localIntent);
      return;
    }
    finally {}
  }
  
  private static boolean b(Context paramContext)
  {
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if (!((List)localObject).isEmpty())
    {
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity;
      if (QLog.isDevelopLevel()) {
        QLog.d("FSReceiver", 4, new Object[] { "currTopPkg:", ((ComponentName)localObject).getPackageName() });
      }
      if (((ComponentName)localObject).getPackageName().equals(paramContext.getPackageName())) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aluq
 * JD-Core Version:    0.7.0.1
 */