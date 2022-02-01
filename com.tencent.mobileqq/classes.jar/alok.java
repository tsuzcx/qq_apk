import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.recent.parcelUtils.ParcelHelper;
import com.tencent.mobileqq.activity.recent.parcelUtils.ParcelHelper.FieldChangedException;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.BaseRecentUser;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

public class alok
{
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
  private static AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
  
  public static int a()
  {
    return jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  @Nullable
  public static RecentBaseData a(QQAppInterface paramQQAppInterface, Context paramContext, @NonNull RecentUser paramRecentUser)
  {
    try
    {
      paramQQAppInterface = almc.a(paramRecentUser, paramQQAppInterface, paramContext, false);
      if (paramRecentUser.parceledRecentBaseData == null) {
        return null;
      }
      boolean bool = ParcelHelper.a(paramQQAppInterface, paramRecentUser.parceledRecentBaseData);
      if (QLog.isColorLevel())
      {
        QLog.e("RecentParcelUtil", 1, new Object[] { "bytesToObject status=", Boolean.valueOf(bool), " user=", paramRecentUser.uin });
        paramQQAppInterface.printDataItem();
        if (((paramQQAppInterface instanceof RecentUserBaseData)) && (((RecentUserBaseData)paramQQAppInterface).getRecentUser() != null)) {
          QLog.d("RecentParcelUtil", 1, new Object[] { "RecentUser info=[showUpTime=", Long.valueOf(((RecentUserBaseData)paramQQAppInterface).getRecentUser().showUpTime), " opTime=", Long.valueOf(((RecentUserBaseData)paramQQAppInterface).getRecentUser().opTime) });
        }
      }
      if (!bool) {
        return null;
      }
    }
    catch (ParcelHelper.FieldChangedException paramQQAppInterface)
    {
      QLog.e("RecentParcelUtil", 1, "FieldChangedException ", paramQQAppInterface);
      return null;
    }
    catch (Throwable paramQQAppInterface)
    {
      QLog.e("RecentParcelUtil", 1, "getRecentUserData fail, 请对应的开发检查是否使用了不该使用的字段", paramQQAppInterface);
      a(paramContext, false, paramQQAppInterface);
      paramQQAppInterface = null;
    }
    return paramQQAppInterface;
  }
  
  public static String a(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("BootOptimize", 0);
    String str = paramContext.getString("8.4.5_has_crash_when_parcel_because", "");
    paramContext.edit().putString("8.4.5_has_crash_when_parcel_because", "").apply();
    return str;
  }
  
  public static void a()
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  static void a(int paramInt1, int paramInt2)
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt1);
    jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt2);
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    a(paramContext, paramBoolean, null);
  }
  
  public static void a(Context paramContext, boolean paramBoolean, @Nullable Throwable paramThrowable)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("BootOptimize", 0).edit();
      if (paramBoolean) {
        paramContext.putLong("_last_crash_time", System.currentTimeMillis());
      }
      for (;;)
      {
        paramContext.apply();
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        return;
        paramContext.putBoolean("8.4.5_has_crash_when_parcel", true);
        if (paramThrowable != null)
        {
          while (paramThrowable.getCause() != null) {
            paramThrowable = paramThrowable.getCause();
          }
          StringWriter localStringWriter = new StringWriter();
          paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
          paramContext.putString("8.4.5_has_crash_when_parcel_because", localStringWriter.getBuffer().toString());
        }
      }
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static void a(QQAppInterface paramQQAppInterface, @NonNull List<Object> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    label170:
    do
    {
      return;
      int j = Math.min(paramInt, paramList.size());
      int i = 0;
      if (i < paramList.size())
      {
        Object localObject = paramList.get(i);
        int k;
        if ((localObject instanceof RecentBaseData))
        {
          localObject = (RecentBaseData)localObject;
          if (j <= 0) {
            continue;
          }
          k = j - 1;
          localObject = (RecentUser)((RecentUserBaseData)localObject).mUser;
          paramQQAppInterface.a().a().a((RecentUser)localObject, true);
          j = k;
          if (QLog.isColorLevel()) {
            if (localObject != null) {
              break label170;
            }
          }
        }
        for (localObject = "";; localObject = ((RecentUser)localObject).uin)
        {
          QLog.d("RecentParcelUtil", 2, new Object[] { "saveRecentUserData, ", localObject, " forceUpdateParcelData=true" });
          j = k;
          i += 1;
          break;
          new Object[2][0] = "saveRecentUserData, ignore data class=";
          throw new NullPointerException();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("RecentParcelUtil", 2, new Object[] { "saveRecentUserData, size=", Integer.valueOf(paramInt), " lastData.size()=", Integer.valueOf(paramList.size()) });
  }
  
  public static void a(@NonNull QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface.getApp().getSharedPreferences("BootOptimize", 0).edit().putBoolean("_useParcelForBoot", paramBoolean).apply();
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public static boolean a(Context paramContext)
  {
    return paramContext.getSharedPreferences("BootOptimize", 0).getBoolean("8.4.5_has_crash_when_parcel", false);
  }
  
  public static boolean a(@NonNull QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(b(paramQQAppInterface));
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
    return jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public static int b()
  {
    return jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public static boolean b(Context paramContext)
  {
    if (paramContext == null) {}
    long l;
    do
    {
      return true;
      l = paramContext.getSharedPreferences("BootOptimize", 0).getLong("_last_crash_time", 0L);
    } while (System.currentTimeMillis() - l > 1800000L);
    return false;
  }
  
  private static boolean b(@NonNull QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences("BootOptimize", 0);
    boolean bool2 = paramQQAppInterface.getBoolean("_useParcelForBoot", true);
    boolean bool3 = paramQQAppInterface.getBoolean("8.4.5_has_crash_when_parcel", false);
    long l = paramQQAppInterface.getLong("_last_crash_time", 0L);
    if (System.currentTimeMillis() - l < 1800000L) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BootOptimize", 2, new Object[] { "getUseBootOptimize=[isDebugVersion=", Boolean.valueOf(false), ", use_parcel:", Boolean.valueOf(bool2), ", has_crash=", Boolean.valueOf(bool3), ", appVersion=", "8.4.5", ", lastCrashTime=", Long.valueOf(l), " recentCrash=", Boolean.valueOf(bool1), "]" });
      }
      if ((!bool2) || (bool3) || (bool1)) {
        break;
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alok
 * JD-Core Version:    0.7.0.1
 */