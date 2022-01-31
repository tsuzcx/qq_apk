import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;

public class alhw
{
  public static void a(int paramInt, String paramString)
  {
    if (!alht.a()) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("featureId", paramInt);
    localBundle.putString("featureKey", paramString);
    localBundle.putLong("endTime", SystemClock.uptimeMillis());
    if (BaseApplicationImpl.sProcessId == 1)
    {
      alht.a().b(paramInt, paramString, localBundle);
      return;
    }
    a("action_end_trace", localBundle);
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2, int paramInt3, long paramLong1, int paramInt4, long paramLong2, Object... paramVarArgs)
  {
    if (!alht.a()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramVarArgs.length * 30);
    int i = 0;
    while (i < paramVarArgs.length)
    {
      localStringBuilder.append(paramVarArgs[i]);
      i += 1;
    }
    paramVarArgs = new Bundle();
    paramVarArgs.putInt("featureId", paramInt1);
    paramVarArgs.putString("featureKey", paramString);
    paramVarArgs.putInt("spanId", paramInt2);
    paramVarArgs.putInt("errCode", paramInt3);
    if (paramLong1 > 0L) {}
    for (long l = paramLong1;; l = System.currentTimeMillis())
    {
      paramVarArgs.putLong("timestamp", l);
      if ((paramInt3 == 0) || (paramInt3 == -100))
      {
        l = paramLong1;
        if (paramLong1 > 0L) {}
      }
      else
      {
        l = SystemClock.uptimeMillis();
      }
      paramVarArgs.putLong("serverTime", NetConnInfoCenter.getServerTimeMillis());
      paramVarArgs.putLong("startTime", l);
      paramVarArgs.putLong("endTime", l);
      paramVarArgs.putString("msg", localStringBuilder.toString());
      paramVarArgs.putInt("extKey", paramInt4);
      paramVarArgs.putLong("extValue", paramLong2);
      if (BaseApplicationImpl.sProcessId != 1) {
        break;
      }
      alht.a().c(paramInt1, paramString, paramVarArgs);
      return;
    }
    a("action_report_span", paramVarArgs);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2)
  {
    if (!alht.a()) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("featureId", paramInt);
    localBundle.putString("featureKey", paramString2);
    localBundle.putString("tuid", paramString1);
    localBundle.putLong("timestamp", System.currentTimeMillis());
    localBundle.putLong("serverTime", NetConnInfoCenter.getServerTimeMillis());
    localBundle.putLong("startTime", SystemClock.uptimeMillis());
    localBundle.putLong("endTime", SystemClock.uptimeMillis());
    if (BaseApplicationImpl.sProcessId == 1)
    {
      alht.a().a(paramInt, paramString2, localBundle);
      return;
    }
    a("action_begin_trace", localBundle);
  }
  
  public static void a(int paramInt, String paramString, int... paramVarArgs)
  {
    int i = 0;
    if (!alht.a()) {
      return;
    }
    int j = 0;
    int m = 0;
    int k = 0;
    while ((i < paramVarArgs.length) && (i < 3))
    {
      if (i == 0) {
        k = paramVarArgs[i];
      }
      if (i == 1) {
        m = paramVarArgs[i];
      }
      if (i == 2) {
        j = paramVarArgs[i];
      }
      i += 1;
    }
    paramVarArgs = new Bundle();
    paramVarArgs.putInt("featureId", paramInt);
    paramVarArgs.putString("tuid", paramString);
    paramVarArgs.putInt("extra1", k);
    paramVarArgs.putInt("extra2", m);
    paramVarArgs.putInt("extra3", j);
    if (BaseApplicationImpl.sProcessId == 1)
    {
      alht.a().a(paramInt, paramVarArgs);
      return;
    }
    a("action_update_trace", paramVarArgs);
  }
  
  public static void a(int paramInt, boolean paramBoolean)
  {
    if (!alht.a()) {
      return;
    }
    if (BaseApplicationImpl.sProcessId == 1)
    {
      alht.a().a(paramInt, paramBoolean);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("featureId", paramInt);
    localBundle.putBoolean("enable", paramBoolean);
    a("action_enable_trace", localBundle);
  }
  
  public static void a(alhq paramalhq)
  {
    if (!alht.a()) {
      return;
    }
    if (BaseApplicationImpl.sProcessId == 1)
    {
      alht.a().a(paramalhq);
      return;
    }
    throw new IllegalArgumentException("config should init in PROCESS_QQ");
  }
  
  private static void a(String paramString, Bundle paramBundle)
  {
    if (BaseApplicationImpl.sProcessId == 2)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("action", paramString);
      localBundle.putBundle("bundle", paramBundle);
      QIPCClientHelper.getInstance().callServer("cm_game_module", "action_cmshow_tracereport", localBundle, new alhx());
    }
    if (!aprh.a().a()) {
      return;
    }
    paramBundle.putString("action", paramString);
    paramString = apml.a("ipc_trace_report", "", 0, paramBundle);
    aprh.a().a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alhw
 * JD-Core Version:    0.7.0.1
 */