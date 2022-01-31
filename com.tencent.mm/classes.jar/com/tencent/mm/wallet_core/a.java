package com.tencent.mm.wallet_core;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.Toast;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.s;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static Map<String, Class<?>> wAb = new HashMap();
  private static SparseArray<c> wAc = new SparseArray();
  
  public static void a(Activity paramActivity, Class<?> paramClass, Bundle paramBundle)
  {
    a(paramActivity, paramClass, paramBundle, null);
  }
  
  public static void a(Activity paramActivity, Class<?> paramClass, Bundle paramBundle, c.a parama)
  {
    y.i("MicroMsg.ProcessManager", "startProcess to1 context:%s proc name: %s bundle %s", new Object[] { paramActivity, paramClass.getSimpleName(), at(paramBundle) });
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {}
    try
    {
      localBundle = new Bundle();
      if (localBundle.getLong("key_SessionId", 0L) == 0L) {
        localBundle.putLong("key_SessionId", System.currentTimeMillis());
      }
      paramBundle = (c)paramClass.newInstance();
      paramBundle.au(localBundle);
      paramBundle.a(parama);
      paramBundle.a(paramActivity, localBundle);
      wAc.put(paramClass.hashCode(), paramBundle);
      return;
    }
    catch (Exception paramActivity)
    {
      y.printErrStackTrace("MicroMsg.ProcessManager", paramActivity, "", new Object[0]);
    }
  }
  
  public static void a(Activity paramActivity, String paramString, Bundle paramBundle, c.a parama)
  {
    try
    {
      y.i("MicroMsg.ProcessManager", "startProcess to2 context:%s proc name: %s bundle %s", new Object[] { paramActivity, paramString, at(paramBundle) });
      Class localClass = (Class)wAb.get(paramString);
      if (localClass == null)
      {
        paramString = String.format("start process=%s fail, process not register or plugin no import", new Object[] { paramString });
        y.e("MicroMsg.ProcessManager", paramString);
        s.makeText(paramActivity, paramString, 1).show();
        return;
      }
      a(paramActivity, localClass, paramBundle, parama);
      return;
    }
    catch (Exception paramActivity)
    {
      y.e("MicroMsg.ProcessManager", "plugin load failed : " + paramActivity.toString());
      y.printErrStackTrace("MicroMsg.ProcessManager", paramActivity, "", new Object[0]);
    }
  }
  
  public static void ag(Activity paramActivity)
  {
    c localc = aj(paramActivity);
    if (localc == null) {}
    for (String str = "";; str = localc.aTh())
    {
      y.i("MicroMsg.ProcessManager", "backProcess to1 context: %s procname %s", new Object[] { paramActivity, str });
      if (localc != null) {
        localc.b(paramActivity, 0);
      }
      return;
    }
  }
  
  public static boolean ah(Activity paramActivity)
  {
    return aj(paramActivity) != null;
  }
  
  public static Bundle ai(Activity paramActivity)
  {
    paramActivity = aj(paramActivity);
    if (paramActivity != null) {
      return paramActivity.kke;
    }
    return new Bundle();
  }
  
  public static c aj(Activity paramActivity)
  {
    if (paramActivity == null)
    {
      y.w("MicroMsg.ProcessManager", "hy: ac is null");
      return null;
    }
    if (paramActivity.getIntent() == null)
    {
      y.w("MicroMsg.ProcessManager", "hy: get intent is null");
      return null;
    }
    return (c)wAc.get(paramActivity.getIntent().getIntExtra("process_id", 0));
  }
  
  private static String at(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return "";
    }
    return paramBundle.toString();
  }
  
  public static void b(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    y.i("MicroMsg.ProcessManager", "endProcess with errCode : " + paramInt);
    if (paramActivity == null) {
      y.w("MicroMsg.ProcessManager", "hy: end context is null");
    }
    c localc = aj(paramActivity);
    String str2 = at(paramBundle);
    String str1;
    if (localc == null)
    {
      str1 = "";
      y.i("MicroMsg.ProcessManager", "endProcess to1 context: %s bundle: %s procName %s", new Object[] { paramActivity, str2, str1 });
      if (localc == null) {
        break label98;
      }
      localc.b(paramActivity, paramBundle);
    }
    label98:
    while (paramActivity.isFinishing())
    {
      return;
      str1 = localc.aTh();
      break;
    }
    paramActivity.finish();
  }
  
  public static void b(Activity paramActivity, String paramString, Bundle paramBundle)
  {
    a(paramActivity, paramString, paramBundle, null);
  }
  
  public static void i(String paramString, Class<?> paramClass)
  {
    if (wAb.containsKey(paramString)) {
      throw new IllegalArgumentException("register process fail, exist process=" + paramString);
    }
    wAb.put(paramString, paramClass);
  }
  
  public static void j(Activity paramActivity, Bundle paramBundle)
  {
    c localc = aj(paramActivity);
    String str2 = at(paramBundle);
    if (localc == null) {}
    for (String str1 = "";; str1 = localc.aTh())
    {
      y.i("MicroMsg.ProcessManager", "forwardProcess to1 context: %s bundle: %s procName %s", new Object[] { paramActivity, str2, str1 });
      if (localc != null) {
        localc.a(paramActivity, 0, paramBundle);
      }
      return;
    }
  }
  
  public static boolean k(Activity paramActivity, Bundle paramBundle)
  {
    paramActivity = aj(paramActivity);
    if (paramActivity != null)
    {
      paramActivity.au(paramBundle);
      return true;
    }
    return false;
  }
  
  public static void n(Activity paramActivity, int paramInt)
  {
    if (paramActivity == null) {
      y.w("MicroMsg.ProcessManager", "hy: back context is null");
    }
    c localc = aj(paramActivity);
    String str;
    if (localc == null)
    {
      str = "";
      y.i("MicroMsg.ProcessManager", "backProcess to1 context: %s errCode %s procname %s ", new Object[] { paramActivity, Integer.valueOf(paramInt), str });
      if (localc == null) {
        break label68;
      }
      localc.b(paramActivity, paramInt);
    }
    label68:
    while (paramActivity.isFinishing())
    {
      return;
      str = localc.aTh();
      break;
    }
    paramActivity.finish();
  }
  
  public static void remove(int paramInt)
  {
    wAc.remove(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.a
 * JD-Core Version:    0.7.0.1
 */