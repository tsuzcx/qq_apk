import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class alms
{
  public static void a(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("sp_d_stable", 0);
    if (!localSharedPreferences.contains("key_mnt"))
    {
      localObject = localSharedPreferences.edit();
      if (Math.random() >= 0.001F) {
        break label101;
      }
    }
    long l3;
    long l2;
    label101:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((SharedPreferences.Editor)localObject).putBoolean("key_mnt", bool1).commit();
      if (localSharedPreferences.getBoolean("key_mnt", false))
      {
        l3 = localSharedPreferences.getLong("k_last_stable_ts_785", 0L);
        l2 = System.currentTimeMillis();
        if (l2 - l3 >= 86400000L) {
          break;
        }
      }
      return;
    }
    Object localObject = paramContext.getSharedPreferences(paramContext.getPackageName() + "_preferences", 0);
    long l4 = ((SharedPreferences)localObject).getLong("k_last_stable_ts_785", 0L);
    File localFile = new File(paramContext.getFilesDir(), "file_stable");
    if (localFile.exists()) {
      localFile.delete();
    }
    localSharedPreferences.edit().remove("k_last_stable_ts");
    ((SharedPreferences)localObject).edit().remove("k_last_stable_ts");
    localFile = new File(paramContext.getFilesDir(), "file_stable_785");
    String str = bdcs.a(localFile);
    long l1;
    int i;
    if (!TextUtils.isEmpty(str))
    {
      l1 = Long.parseLong(str);
      if ((l4 > 0L) || (l3 > 0L) || (l1 > 0L))
      {
        if ((l3 < l1) || ((l3 - l1) % 86400000L != 0L)) {
          break label832;
        }
        if ((l4 < l3) || ((l4 - l3) % 86400000L != 0L)) {
          break label827;
        }
        i = 0;
        label310:
        QLog.d("DeviceStability", 1, new Object[] { "check sp file.", Long.valueOf(l4), ", ", Long.valueOf(l3), ", ", Long.valueOf(l1) });
        HashMap localHashMap = new HashMap(4);
        localHashMap.put("fileCode", String.valueOf(i));
        if (i != 0)
        {
          localHashMap.put("big_sp_time", String.valueOf(l4));
          localHashMap.put("sm_sp_time", String.valueOf(l3));
          localHashMap.put("file_time", str);
        }
        azmz.a(paramContext).a("", "actSpFileStable", true, i, 0L, localHashMap, "");
        if (i == 0)
        {
          boolean bool3 = ((SharedPreferences)localObject).getBoolean("k_last_stable_sw", false);
          boolean bool2 = localSharedPreferences.getBoolean("k_last_stable_sw", false);
          if (l4 / 24L / 60L / 60L / 1000L % 2L != 0L) {
            break label837;
          }
          bool1 = true;
          label498:
          int j = i;
          if (bool3 != bool1) {
            j = i | 0x1;
          }
          if (l3 / 24L / 60L / 60L / 1000L % 2L != 0L) {
            break label842;
          }
          bool1 = true;
          label539:
          i = j;
          if (bool2 != bool1) {
            i = j | 0x2;
          }
          localHashMap = new HashMap(4);
          localHashMap.put("fileCode", String.valueOf(i));
          if (i != 0)
          {
            localHashMap.put("big_sp_time", String.valueOf(l4));
            localHashMap.put("sm_sp_time", String.valueOf(l3));
            localHashMap.put("file_time", str);
          }
          azmz.a(paramContext).a("", "actSpContentStable", true, i, 0L, localHashMap, "");
        }
      }
      l1 = 86400000L * (l2 / 86400000L);
      if (l2 / 86400000L % 2L != 0L) {
        break label847;
      }
    }
    label827:
    label832:
    label837:
    label842:
    label847:
    for (bool1 = true;; bool1 = false)
    {
      QLog.d("DeviceStability", 1, "write now = " + l2);
      ((SharedPreferences)localObject).edit().putLong("k_last_stable_ts_785", l1).putBoolean("k_last_stable_sw", bool1).commit();
      QLog.d("DeviceStability", 1, "write switch = " + bool1);
      localSharedPreferences.edit().putLong("k_last_stable_ts_785", l1).putBoolean("k_last_stable_sw", bool1).commit();
      QLog.d("DeviceStability", 1, "write sp end");
      bool1 = bdcs.a(localFile.getAbsolutePath(), String.valueOf(l1), false);
      QLog.d("DeviceStability", 1, "write content end " + bool1);
      return;
      l1 = 0L;
      break;
      i = 1;
      break label310;
      i = 2;
      break label310;
      bool1 = false;
      break label498;
      bool1 = false;
      break label539;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alms
 * JD-Core Version:    0.7.0.1
 */