import android.os.Looper;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.javahook.DetectContactDelete;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public final class adlv
  implements HookMethodCallback
{
  public void afterHookedMethod(MethodHookParam paramMethodHookParam)
  {
    long l = Thread.currentThread().getId();
    HashMap localHashMap;
    if (DetectContactDelete.a().containsKey(Long.valueOf(l)))
    {
      l = SystemClock.uptimeMillis() - ((Long)DetectContactDelete.a().remove(Long.valueOf(l))).longValue();
      localHashMap = new HashMap(10);
      if (Looper.myLooper() != Looper.getMainLooper()) {
        break label139;
      }
    }
    label139:
    for (paramMethodHookParam = "1";; paramMethodHookParam = "0")
    {
      localHashMap.put("param_IsMainThread", paramMethodHookParam);
      localHashMap.put("param_OptType", "connection");
      localHashMap.put("param_bustag", "Friends");
      localHashMap.put("param_OptTotalCost", String.valueOf(l));
      localHashMap.put("param_WalSwitch", String.valueOf(SQLiteOpenHelper.a));
      StatisticCollector.a(BaseApplicationImpl.getContext()).a(null, "actFriendSqliteOpt", true, l, 0L, localHashMap, null, false);
      return;
    }
  }
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam)
  {
    long l = Thread.currentThread().getId();
    if (DetectContactDelete.a().containsKey(Long.valueOf(l))) {
      DetectContactDelete.a().put(Long.valueOf(l), Long.valueOf(SystemClock.uptimeMillis()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adlv
 * JD-Core Version:    0.7.0.1
 */