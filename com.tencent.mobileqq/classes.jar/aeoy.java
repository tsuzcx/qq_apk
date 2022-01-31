import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOOpenWebMonitor.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.qphone.base.util.BaseApplication;
import java.net.URLEncoder;
import java.util.HashMap;

public class aeoy
{
  private static int jdField_a_of_type_Int;
  private static ArrayMap<String, Long> jdField_a_of_type_AndroidSupportV4UtilArrayMap;
  private static String jdField_a_of_type_JavaLangString = "";
  private static HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private static int b = -1;
  
  public static void a()
  {
    if (Build.VERSION.SDK_INT > 10)
    {
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("web_process_preload_file", 4);
      int i = localSharedPreferences.getInt("aio_preload_qweb_cout", 0);
      localSharedPreferences.edit().putInt("aio_preload_qweb_cout", i + 1).commit();
    }
  }
  
  public static void a(Intent paramIntent)
  {
    int i = 1;
    jdField_a_of_type_Int += 1;
    if (paramIntent == null) {
      break label14;
    }
    label14:
    while (!paramIntent.getBooleanExtra("aio_open_web", false)) {
      return;
    }
    long l = paramIntent.getLongExtra("from_aio_time", -1L);
    label62:
    label89:
    int j;
    label105:
    String str;
    if ((jdField_a_of_type_JavaUtilHashMap == null) || (jdField_a_of_type_JavaUtilHashMap.size() > 25))
    {
      jdField_a_of_type_JavaUtilHashMap = new HashMap();
      if ((jdField_a_of_type_AndroidSupportV4UtilArrayMap != null) && (jdField_a_of_type_AndroidSupportV4UtilArrayMap.size() <= 25)) {
        break label437;
      }
      jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap();
      if ((jdField_a_of_type_Int != 1) || (WebProcessReceiver.jdField_a_of_type_Int != 1)) {
        break label446;
      }
      j = 1;
      b = 1;
      jdField_a_of_type_JavaUtilHashMap.put("from", paramIntent.getIntExtra("from_aio", 1) + "");
      jdField_a_of_type_JavaUtilHashMap.put("use_optimization", paramIntent.getIntExtra("from_aio_opt", 2) + "");
      HashMap localHashMap = jdField_a_of_type_JavaUtilHashMap;
      if (jdField_a_of_type_Int != 1) {
        break label451;
      }
      str = "1";
      label193:
      localHashMap.put("first_open", str);
      jdField_a_of_type_JavaUtilHashMap.put("network_type", ndd.a() + "");
      localHashMap = jdField_a_of_type_JavaUtilHashMap;
      if (WebProcessReceiver.jdField_a_of_type_Int != 1) {
        break label458;
      }
      str = "1";
      label249:
      localHashMap.put("has_pp", str);
      if (WebProcessReceiver.jdField_a_of_type_Int != 1) {
        break label465;
      }
    }
    for (;;)
    {
      jdField_a_of_type_JavaUtilHashMap.put("ps_state", i + "");
      b(paramIntent, "click_to_activity", SystemClock.uptimeMillis() - l + "");
      jdField_a_of_type_JavaUtilHashMap.put("open_finished", "2");
      jdField_a_of_type_AndroidSupportV4UtilArrayMap.put("web_finish", Long.valueOf(l));
      a(paramIntent, "click_to_activity", "activity_to_webview");
      paramIntent.removeExtra("from_aio");
      paramIntent.removeExtra("from_aio_time");
      paramIntent.removeExtra("from_aio_opt");
      if ((Build.VERSION.SDK_INT <= 10) || (j == 0)) {
        break;
      }
      paramIntent = BaseApplicationImpl.getApplication().getSharedPreferences("web_process_preload_file", 4);
      i = paramIntent.getInt("aio_hit_count", 0);
      paramIntent.edit().putInt("aio_hit_count", i + 1).commit();
      return;
      jdField_a_of_type_JavaUtilHashMap.clear();
      break label62;
      label437:
      jdField_a_of_type_AndroidSupportV4UtilArrayMap.clear();
      break label89;
      label446:
      j = 0;
      break label105;
      label451:
      str = "2";
      break label193;
      label458:
      str = "2";
      break label249;
      label465:
      if ((beiy.s) || (jdField_a_of_type_Int > 1)) {
        i = 2;
      } else {
        i = 3;
      }
    }
  }
  
  public static void a(Intent paramIntent, int paramInt1, int paramInt2)
  {
    paramIntent.putExtra("aio_open_web", true);
    paramIntent.putExtra("from_aio_opt", paramInt2);
    paramIntent.putExtra("from_aio", paramInt1);
    paramIntent.putExtra("from_aio_time", SystemClock.uptimeMillis());
  }
  
  public static void a(Intent paramIntent, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      break label4;
    }
    label4:
    while (SystemClock.uptimeMillis() % 10L != 1L) {
      return;
    }
    int j = azuw.a(paramMessageRecord.istroop);
    if (aemu.a) {}
    for (int i = 1;; i = 2)
    {
      a(paramIntent, j, i);
      paramIntent = paramMessageRecord.frienduin;
      long l = paramMessageRecord.msgUid;
      i = paramMessageRecord.istroop;
      if (TextUtils.isEmpty(paramIntent)) {
        break;
      }
      ThreadManager.post(new AIOOpenWebMonitor.1(paramQQAppInterface, i, paramIntent, l), 2, null, false);
      return;
    }
  }
  
  public static void a(Intent paramIntent, String paramString)
  {
    if (paramIntent == null) {}
    while ((b != 1) || (!paramIntent.getBooleanExtra("aio_open_web", false)) || ((!paramString.startsWith("http:")) && (!paramString.startsWith("https:")))) {
      return;
    }
    a(paramIntent, "activity_to_webview", null);
    c(paramIntent, paramString);
    e(paramIntent, paramString);
    a(paramIntent, null, "wb_c");
  }
  
  public static void a(Intent paramIntent, String paramString1, String paramString2)
  {
    if (paramIntent == null) {}
    long l;
    do
    {
      do
      {
        return;
      } while ((b != 1) || (!paramIntent.getBooleanExtra("aio_open_web", false)));
      l = SystemClock.uptimeMillis();
      if (paramString1 != null)
      {
        paramIntent = (Long)jdField_a_of_type_AndroidSupportV4UtilArrayMap.remove(paramString1);
        if (paramIntent != null) {
          jdField_a_of_type_JavaUtilHashMap.put(paramString1, l - paramIntent.longValue() + "");
        }
      }
    } while (paramString2 == null);
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(paramString2, Long.valueOf(l));
  }
  
  public static void b(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      do
      {
        return;
      } while ((b != 1) || (!paramIntent.getBooleanExtra("aio_open_web", false)));
      a(paramIntent, "wb_c", null);
      a(paramIntent, "web_finish", null);
    } while (b != 1);
    b = 2;
    jdField_a_of_type_JavaUtilHashMap.put("open_finished", "1");
  }
  
  public static void b(Intent paramIntent, String paramString)
  {
    if (paramIntent == null) {}
    while ((b != 1) || (!paramIntent.getBooleanExtra("aio_open_web", false))) {
      return;
    }
    d(paramIntent, paramString);
    f(paramIntent, paramString);
  }
  
  public static void b(Intent paramIntent, String paramString1, String paramString2)
  {
    if (paramIntent == null) {}
    while ((b != 1) || (!paramIntent.getBooleanExtra("aio_open_web", false))) {
      return;
    }
    jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
  }
  
  public static void c(Intent paramIntent)
  {
    if (paramIntent == null) {}
    String str;
    do
    {
      do
      {
        return;
      } while ((!paramIntent.getBooleanExtra("aio_open_web", false)) || (jdField_a_of_type_JavaUtilHashMap == null));
      str = (String)jdField_a_of_type_JavaUtilHashMap.get("open_finished");
    } while ((str == null) || (!str.equals("2")));
    a(paramIntent, "web_finish", null);
  }
  
  private static void c(Intent paramIntent, String paramString)
  {
    if ((paramIntent == null) || (paramString == null)) {}
    while ((!paramString.contains(URLEncoder.encode("/cgi-bin/httpconn?htcmd=0x6ff0080"))) && (!paramString.contains("/cgi-bin/httpconn?htcmd=0x6ff0080"))) {
      return;
    }
    jdField_a_of_type_JavaLangString = paramString;
    a(paramIntent, null, "safe_check");
  }
  
  public static void d(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      do
      {
        return;
      } while (!paramIntent.getBooleanExtra("aio_open_web", false));
      paramIntent.removeExtra("aio_open_web");
    } while ((jdField_a_of_type_JavaUtilHashMap == null) || (TextUtils.isEmpty((CharSequence)jdField_a_of_type_JavaUtilHashMap.get("from"))));
    String str = (String)jdField_a_of_type_JavaUtilHashMap.get("safe_check");
    paramIntent = (String)jdField_a_of_type_JavaUtilHashMap.get("short_link");
    try
    {
      l1 = Long.parseLong(str);
    }
    catch (Exception localException)
    {
      try
      {
        for (;;)
        {
          l2 = Long.parseLong(paramIntent);
          if (l1 != 0L) {
            break;
          }
          jdField_a_of_type_JavaUtilHashMap.put("has_safecheck", "2");
          if (l2 != 0L) {
            break label250;
          }
          jdField_a_of_type_JavaUtilHashMap.put("has_short_link", "2");
          azri.a(BaseApplication.getContext()).a(null, "AIOWeb", false, 0L, 0L, jdField_a_of_type_JavaUtilHashMap, "", false);
          b = -1;
          if (Build.VERSION.SDK_INT > 10)
          {
            paramIntent = BaseApplicationImpl.getApplication().getSharedPreferences("web_process_preload_file", 4);
            l1 = paramIntent.getLong("aio_preload_qweb_last", 0L);
            l2 = System.currentTimeMillis();
            if (l1 != 0L) {
              break label265;
            }
            paramIntent.edit().putLong("aio_preload_qweb_last", l2).commit();
          }
          jdField_a_of_type_JavaUtilHashMap.clear();
          jdField_a_of_type_AndroidSupportV4UtilArrayMap.clear();
          return;
          localException = localException;
          l1 = 0L;
        }
      }
      catch (Exception paramIntent)
      {
        for (;;)
        {
          long l1;
          long l2 = 0L;
          continue;
          jdField_a_of_type_JavaUtilHashMap.put("has_safecheck", "1");
          continue;
          label250:
          jdField_a_of_type_JavaUtilHashMap.put("has_short_link", "1");
          continue;
          label265:
          if (l2 - l1 > 86400000L)
          {
            int i = paramIntent.getInt("aio_preload_qweb_cout", 0);
            int j = paramIntent.getInt("aio_hit_count", 0);
            HashMap localHashMap = new HashMap();
            localHashMap.put("hit_count", j + "");
            localHashMap.put("preload_count", i + "");
            azri.a(BaseApplication.getContext()).a(null, "AIOWebPreloadhit", false, 0L, 0L, localHashMap, "", false);
            paramIntent.edit().putInt("aio_preload_qweb_cout", 0).putLong("aio_preload_qweb_last", l2).putInt("aio_hit_count", 0).commit();
          }
        }
      }
    }
  }
  
  private static void d(Intent paramIntent, String paramString)
  {
    if ((paramIntent == null) || (paramString == null)) {
      return;
    }
    if ((jdField_a_of_type_JavaLangString != null) && (jdField_a_of_type_JavaLangString.contains(URLEncoder.encode(paramString)))) {
      a(paramIntent, "safe_check", null);
    }
    jdField_a_of_type_JavaLangString = "";
  }
  
  private static void e(Intent paramIntent, String paramString)
  {
    if (paramString == null) {}
    while (!aemu.c(paramString)) {
      return;
    }
    a(paramIntent, null, "short_link");
  }
  
  private static void f(Intent paramIntent, String paramString)
  {
    if (paramString == null) {}
    while ((!paramString.startsWith("http:")) && (!paramString.startsWith("https:"))) {
      return;
    }
    a(paramIntent, "short_link", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeoy
 * JD-Core Version:    0.7.0.1
 */