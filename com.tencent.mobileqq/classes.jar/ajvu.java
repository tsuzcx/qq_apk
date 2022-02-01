import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

public class ajvu
{
  public static int a(String paramString1, String paramString2, int paramInt)
  {
    SharedPreferences localSharedPreferences = a("qwallet_setting");
    int i = paramInt;
    if (localSharedPreferences != null) {
      i = localSharedPreferences.getInt(paramString2 + paramString1, paramInt);
    }
    return i;
  }
  
  public static long a(String paramString1, String paramString2, long paramLong)
  {
    SharedPreferences localSharedPreferences = a("qwallet_setting");
    long l = paramLong;
    if (localSharedPreferences != null) {
      l = localSharedPreferences.getLong(paramString2 + paramString1, paramLong);
    }
    return l;
  }
  
  private static SharedPreferences a(String paramString)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      return localBaseApplicationImpl.getSharedPreferences(paramString, 4);
    }
    return null;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    SharedPreferences localSharedPreferences = a("qwallet_setting");
    String str = paramString3;
    if (localSharedPreferences != null) {
      str = localSharedPreferences.getString(paramString2 + paramString1, paramString3);
    }
    return str;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = a("qwallet_setting");
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().remove(paramString2 + paramString1).apply();
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    SharedPreferences localSharedPreferences = a("qwallet_setting");
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putInt(paramString2 + paramString1, paramInt).commit();
    }
  }
  
  public static void a(String paramString1, String paramString2, long paramLong)
  {
    SharedPreferences localSharedPreferences = a("qwallet_setting");
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong(paramString2 + paramString1, paramLong).commit();
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    SharedPreferences localSharedPreferences = a("qwallet_setting");
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putString(paramString2 + paramString1, paramString3).apply();
    }
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = a("qwallet_setting");
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean(paramString2 + paramString1, paramBoolean).commit();
    }
  }
  
  public static boolean a(String paramString)
  {
    SharedPreferences localSharedPreferences = a("qwallet_setting");
    if (localSharedPreferences != null)
    {
      long l1 = localSharedPreferences.getLong("F2FRedpack_EntryColorBeginTime" + paramString, 0L);
      long l2 = localSharedPreferences.getLong("F2FRedpack_EntryColorEndTime" + paramString, 0L);
      long l3 = NetConnInfoCenter.getServerTimeMillis();
      if ((l3 > l1) && (l3 < l2)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = a("qwallet_setting");
    boolean bool = paramBoolean;
    if (localSharedPreferences != null) {
      bool = localSharedPreferences.getBoolean(paramString2 + paramString1, paramBoolean);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajvu
 * JD-Core Version:    0.7.0.1
 */