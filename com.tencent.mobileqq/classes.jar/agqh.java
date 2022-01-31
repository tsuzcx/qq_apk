import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadConfig;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadResource;
import com.tencent.mobileqq.activity.qwallet.preload.ResourceInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class agqh
{
  public static int a(String paramString, int paramInt)
  {
    int i = 0;
    SharedPreferences localSharedPreferences = a(paramInt);
    paramInt = i;
    if (localSharedPreferences != null)
    {
      paramInt = i;
      if (!TextUtils.isEmpty(paramString)) {
        paramInt = localSharedPreferences.getInt("url_abnormal_retry_times" + paramString, 0);
      }
    }
    return paramInt;
  }
  
  public static long a(int paramInt)
  {
    long l = 0L;
    SharedPreferences localSharedPreferences = a(paramInt);
    if (localSharedPreferences != null) {
      l = localSharedPreferences.getLong("check_surplus_res_time", 0L);
    }
    return l;
  }
  
  public static long a(String paramString, int paramInt)
  {
    long l2 = 0L;
    SharedPreferences localSharedPreferences = a(paramInt);
    long l1 = l2;
    if (localSharedPreferences != null)
    {
      l1 = l2;
      if (!TextUtils.isEmpty(paramString)) {
        l1 = localSharedPreferences.getLong("url_abnormal_retry_last_time" + paramString, 0L);
      }
    }
    return l1;
  }
  
  public static long a(String paramString, long paramLong, int paramInt)
  {
    SharedPreferences localSharedPreferences = a(paramInt);
    long l = paramLong;
    if (localSharedPreferences != null)
    {
      l = paramLong;
      if (!TextUtils.isEmpty(paramString)) {
        l = localSharedPreferences.getLong("url_doneTime" + paramString, paramLong);
      }
    }
    return l;
  }
  
  private static SharedPreferences a(int paramInt)
  {
    if (BaseApplicationImpl.getApplication() != null)
    {
      if (paramInt == 1) {
        return BaseApplicationImpl.getApplication().getSharedPreferences("qwallet_res_utilinner", 4);
      }
      return BaseApplicationImpl.getApplication().getSharedPreferences("qwallet_res_util", 4);
    }
    return null;
  }
  
  public static ResourceInfo a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    ResourceInfo localResourceInfo = new ResourceInfo();
    localResourceInfo.url = paramString;
    String str = agpg.a(paramString, paramInt2);
    if (!TextUtils.isEmpty(str))
    {
      localResourceInfo.filePath = str;
      localResourceInfo.fileMd5 = b(paramString, str, paramInt2);
      localResourceInfo.doneTime = a(paramString, 0L, paramInt2);
      if ((paramBoolean) || (PreloadResource.isNeedAutoUnzip(paramString, paramInt1)))
      {
        paramString = PreloadResource.getFolderPathByMD5AndUrl(localResourceInfo.fileMd5, paramString, paramInt2);
        if (!PreloadResource.isFolderPathValid(paramString)) {
          break label99;
        }
        localResourceInfo.folderPath = paramString;
      }
    }
    label99:
    while (!PreloadResource.unzipAtomically(localResourceInfo.filePath, paramString)) {
      return localResourceInfo;
    }
    localResourceInfo.folderPath = paramString;
    return localResourceInfo;
  }
  
  public static String a(String paramString1, String paramString2, int paramInt)
  {
    SharedPreferences localSharedPreferences = a(paramInt);
    String str = paramString2;
    if (localSharedPreferences != null)
    {
      str = paramString2;
      if (!TextUtils.isEmpty(paramString1)) {
        str = localSharedPreferences.getString("url_md5" + paramString1, paramString2);
      }
    }
    return str;
  }
  
  public static List<agqi> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = a(paramInt);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).getAll().entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        String str = (String)localEntry.getKey();
        if (str.startsWith("url_last_use_time")) {
          localArrayList.add(new agqi(str.substring("url_last_use_time".length(), str.length()), ((Long)localEntry.getValue()).longValue(), paramInt));
        }
      }
    }
    return localArrayList;
  }
  
  public static void a(int paramInt, PreloadConfig paramPreloadConfig)
  {
    if (paramPreloadConfig == null) {}
    long l1;
    do
    {
      return;
      l1 = NetConnInfoCenter.getServerTimeMillis();
      if (l1 - a(paramInt) >= 86400000L) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ResUtil", 2, "removeSurplusRes already Check Today:" + paramInt);
    return;
    Object localObject = agpg.a(paramInt);
    long l2 = System.currentTimeMillis();
    long l3 = bace.b((String)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("ResUtil", 2, "resFolderPathSize:" + l3 + "|" + 209715200L + "|" + (System.currentTimeMillis() - l2));
    }
    if (l3 > 209715200L)
    {
      localObject = a(paramInt).iterator();
      while (((Iterator)localObject).hasNext())
      {
        agqi localagqi = (agqi)((Iterator)localObject).next();
        if ((localagqi != null) && (!TextUtils.isEmpty(localagqi.jdField_a_of_type_JavaLangString)) && (l1 - localagqi.jdField_a_of_type_Long > 2592000000L) && (!paramPreloadConfig.isUrlInConfig(localagqi.jdField_a_of_type_JavaLangString)))
        {
          ResourceInfo localResourceInfo = a(localagqi.jdField_a_of_type_JavaLangString, false, 0, localagqi.jdField_a_of_type_Int);
          if (localResourceInfo != null)
          {
            b(localagqi.jdField_a_of_type_JavaLangString, localagqi.jdField_a_of_type_Int);
            agwj.a(localResourceInfo.filePath);
            agwj.a(localResourceInfo.folderPath);
            agqg.a(localagqi.jdField_a_of_type_JavaLangString, 8, localagqi.jdField_a_of_type_Int);
          }
        }
      }
    }
    a(l1, paramInt);
  }
  
  public static void a(long paramLong, int paramInt)
  {
    SharedPreferences localSharedPreferences = a(paramInt);
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong("check_surplus_res_time", paramLong).apply();
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    int i = a(paramString, paramInt);
    SharedPreferences localSharedPreferences = a(paramInt);
    if ((localSharedPreferences != null) && (!TextUtils.isEmpty(paramString))) {
      localSharedPreferences.edit().putInt("url_abnormal_retry_times" + paramString, i + 1).putLong("url_abnormal_retry_last_time" + paramString, NetConnInfoCenter.getServerTimeMillis()).apply();
    }
  }
  
  public static void a(String paramString, int paramInt, long paramLong)
  {
    SharedPreferences localSharedPreferences = a(paramInt);
    if ((localSharedPreferences != null) && (!TextUtils.isEmpty(paramString))) {
      localSharedPreferences.edit().putLong("url_last_use_time" + paramString, paramLong).apply();
    }
  }
  
  public static void a(String paramString, long paramLong, int paramInt)
  {
    int i = 1;
    SharedPreferences localSharedPreferences = a(paramInt);
    if (localSharedPreferences != null)
    {
      paramInt = 1;
      if (TextUtils.isEmpty(paramString)) {
        break label73;
      }
    }
    for (;;)
    {
      if ((paramInt & i) != 0) {
        localSharedPreferences.edit().putLong("url_doneTime" + paramString, paramLong).apply();
      }
      return;
      paramInt = 0;
      break;
      label73:
      i = 0;
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    SharedPreferences localSharedPreferences = a(paramInt);
    if ((localSharedPreferences != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      localSharedPreferences.edit().putString("url_md5" + paramString1, paramString2).apply();
    }
  }
  
  public static void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    a(paramString1, paramString2, paramInt);
    a(paramString1, paramLong, paramInt);
    a(paramString1, paramInt, NetConnInfoCenter.getServerTimeMillis());
  }
  
  public static void a(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = a(0);
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("has_update_sdcard_path", paramBoolean).apply();
    }
  }
  
  public static boolean a()
  {
    boolean bool2 = false;
    SharedPreferences localSharedPreferences = a(0);
    boolean bool1 = bool2;
    if (localSharedPreferences != null)
    {
      bool1 = bool2;
      if (localSharedPreferences.getBoolean("has_update_sdcard_path", false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static String b(String paramString1, String paramString2, int paramInt)
  {
    String str2 = a(paramString1, "", paramInt);
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (!TextUtils.isEmpty(paramString2))
      {
        str1 = str2;
        if (new File(paramString2).exists())
        {
          str1 = MD5Coding.encodeFile2HexStr(paramString2);
          a(paramString1, str1, paramInt);
        }
      }
    }
    return str1;
  }
  
  public static void b(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = a(paramInt);
    if ((localSharedPreferences != null) && (!TextUtils.isEmpty(paramString)))
    {
      localSharedPreferences.edit().remove("url_doneTime" + paramString);
      localSharedPreferences.edit().remove("url_md5" + paramString);
      localSharedPreferences.edit().remove("url_last_use_time" + paramString);
      localSharedPreferences.edit().remove("url_abnormal_retry_times" + paramString).apply();
    }
  }
  
  public static void b(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = a(0);
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("has_check_old_folder", paramBoolean).apply();
    }
  }
  
  public static boolean b()
  {
    boolean bool2 = false;
    SharedPreferences localSharedPreferences = a(0);
    boolean bool1 = bool2;
    if (localSharedPreferences != null)
    {
      bool1 = bool2;
      if (localSharedPreferences.getBoolean("has_check_old_folder", false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agqh
 * JD-Core Version:    0.7.0.1
 */