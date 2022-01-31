import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class ajos
{
  private static HashMap<String, Long> a = new HashMap();
  private static HashMap<String, Long> b = new HashMap();
  
  public static void a()
  {
    a.clear();
    b.clear();
  }
  
  public static void a(String paramString)
  {
    if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(paramString))) {
      a.put(paramString, Long.valueOf(SystemClock.uptimeMillis()));
    }
  }
  
  public static void b(String paramString)
  {
    if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(paramString)) && (a.containsKey(paramString)))
    {
      Long localLong = (Long)a.get(paramString);
      if (localLong != null)
      {
        long l1 = localLong.longValue();
        long l2 = SystemClock.uptimeMillis();
        b.put(paramString, Long.valueOf(l2));
        QLog.d("TraceReport_CmShowStatUtil", 1, new Object[] { "eventName=", paramString, ", cost=", Long.valueOf(l2 - l1) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajos
 * JD-Core Version:    0.7.0.1
 */