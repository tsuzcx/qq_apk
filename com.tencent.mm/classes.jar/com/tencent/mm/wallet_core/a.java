package com.tencent.mm.wallet_core;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  private static SparseArray<e> agRA;
  private static Map<String, Class<?>> agRz;
  
  static
  {
    AppMethodBeat.i(72640);
    agRz = new ConcurrentHashMap();
    agRA = new SparseArray();
    AppMethodBeat.o(72640);
  }
  
  public static void a(Activity paramActivity, Class<?> paramClass, Bundle paramBundle)
  {
    AppMethodBeat.i(72627);
    a(paramActivity, paramClass, paramBundle, null);
    AppMethodBeat.o(72627);
  }
  
  public static void a(Activity paramActivity, Class<?> paramClass, Bundle paramBundle, e.a parama)
  {
    AppMethodBeat.i(72628);
    Log.i("MicroMsg.ProcessManager", "startProcess to1 context:%s proc name: %s bundle %s", new Object[] { paramActivity, paramClass.getSimpleName(), cf(paramBundle) });
    try
    {
      if (((paramActivity instanceof WalletBaseUI)) && (parama != null)) {
        ((WalletBaseUI)paramActivity).keepProcessEnd(parama);
      }
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      if (localBundle.getLong("key_SessionId", 0L) == 0L) {
        localBundle.putLong("key_SessionId", System.currentTimeMillis());
      }
      paramBundle = (e)paramClass.newInstance();
      paramBundle.cg(localBundle);
      paramBundle.a(parama, paramActivity);
      paramBundle.a(paramActivity, localBundle);
      agRA.put(paramClass.hashCode(), paramBundle);
      AppMethodBeat.o(72628);
      return;
    }
    catch (Exception paramActivity)
    {
      Log.printErrStackTrace("MicroMsg.ProcessManager", paramActivity, "", new Object[0]);
      AppMethodBeat.o(72628);
    }
  }
  
  public static void a(Activity paramActivity, String paramString, Bundle paramBundle, e.a parama)
  {
    AppMethodBeat.i(72630);
    try
    {
      Log.i("MicroMsg.ProcessManager", "startProcess to2 context:%s proc name: %s bundle %s", new Object[] { paramActivity, paramString, cf(paramBundle) });
      Class localClass = (Class)agRz.get(paramString);
      if (localClass == null)
      {
        paramString = String.format("start process=%s fail, process not register or plugin no import", new Object[] { paramString });
        Log.e("MicroMsg.ProcessManager", paramString);
        aa.makeText(paramActivity, paramString, 1).show();
        AppMethodBeat.o(72630);
        return;
      }
      a(paramActivity, localClass, paramBundle, parama);
      AppMethodBeat.o(72630);
      return;
    }
    catch (Exception paramActivity)
    {
      Log.e("MicroMsg.ProcessManager", "plugin load failed : " + paramActivity.toString());
      Log.printErrStackTrace("MicroMsg.ProcessManager", paramActivity, "", new Object[0]);
      AppMethodBeat.o(72630);
    }
  }
  
  public static void b(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    AppMethodBeat.i(72634);
    Log.i("MicroMsg.ProcessManager", "endProcess with errCode : ".concat(String.valueOf(paramInt)));
    if (paramActivity == null) {
      Log.w("MicroMsg.ProcessManager", "hy: end context is null");
    }
    e locale = cm(paramActivity);
    String str2 = cf(paramBundle);
    if (locale == null) {}
    for (String str1 = "";; str1 = locale.fud())
    {
      Log.i("MicroMsg.ProcessManager", "endProcess to1 context: %s bundle: %s procName %s", new Object[] { paramActivity, str2, str1 });
      if (locale == null) {
        break;
      }
      locale.b(paramActivity, paramBundle);
      AppMethodBeat.o(72634);
      return;
    }
    if (!paramActivity.isFinishing()) {
      paramActivity.finish();
    }
    AppMethodBeat.o(72634);
  }
  
  public static void b(Activity paramActivity, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(72629);
    a(paramActivity, paramString, paramBundle, null);
    AppMethodBeat.o(72629);
  }
  
  public static List<e> bEC(String paramString)
  {
    AppMethodBeat.i(72639);
    ArrayList localArrayList = new ArrayList();
    int j = agRA.size();
    int i = 0;
    while (i < j)
    {
      e locale = (e)agRA.valueAt(i);
      if (paramString.equals(locale.fud())) {
        localArrayList.add(locale);
      }
      i += 1;
    }
    AppMethodBeat.o(72639);
    return localArrayList;
  }
  
  private static String cf(Bundle paramBundle)
  {
    AppMethodBeat.i(72625);
    if (paramBundle == null)
    {
      AppMethodBeat.o(72625);
      return "";
    }
    paramBundle = paramBundle.toString();
    AppMethodBeat.o(72625);
    return paramBundle;
  }
  
  public static void cj(Activity paramActivity)
  {
    AppMethodBeat.i(72632);
    e locale = cm(paramActivity);
    if (locale == null) {}
    for (String str = "";; str = locale.fud())
    {
      Log.i("MicroMsg.ProcessManager", "backProcess to1 context: %s procname %s", new Object[] { paramActivity, str });
      if (locale != null) {
        locale.i(paramActivity, 0);
      }
      AppMethodBeat.o(72632);
      return;
    }
  }
  
  public static boolean ck(Activity paramActivity)
  {
    AppMethodBeat.i(72635);
    if (cm(paramActivity) != null)
    {
      AppMethodBeat.o(72635);
      return true;
    }
    AppMethodBeat.o(72635);
    return false;
  }
  
  public static Bundle cl(Activity paramActivity)
  {
    AppMethodBeat.i(72636);
    paramActivity = cm(paramActivity);
    if (paramActivity != null)
    {
      paramActivity = paramActivity.hPH;
      AppMethodBeat.o(72636);
      return paramActivity;
    }
    paramActivity = new Bundle();
    AppMethodBeat.o(72636);
    return paramActivity;
  }
  
  public static e cm(Activity paramActivity)
  {
    AppMethodBeat.i(72638);
    if (paramActivity == null)
    {
      Log.w("MicroMsg.ProcessManager", "hy: ac is null");
      AppMethodBeat.o(72638);
      return null;
    }
    if (paramActivity.getIntent() == null)
    {
      Log.w("MicroMsg.ProcessManager", "hy: get intent is null");
      AppMethodBeat.o(72638);
      return null;
    }
    paramActivity = (e)agRA.get(paramActivity.getIntent().getIntExtra("process_id", 0));
    AppMethodBeat.o(72638);
    return paramActivity;
  }
  
  public static void k(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(72631);
    e locale = cm(paramActivity);
    String str2 = cf(paramBundle);
    if (locale == null) {}
    for (String str1 = "";; str1 = locale.fud())
    {
      Log.i("MicroMsg.ProcessManager", "forwardProcess to1 context: %s bundle: %s procName %s", new Object[] { paramActivity, str2, str1 });
      if (locale != null) {
        locale.a(paramActivity, 0, paramBundle);
      }
      AppMethodBeat.o(72631);
      return;
    }
  }
  
  public static boolean l(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(72637);
    paramActivity = cm(paramActivity);
    if (paramActivity != null)
    {
      paramActivity.cg(paramBundle);
      AppMethodBeat.o(72637);
      return true;
    }
    AppMethodBeat.o(72637);
    return false;
  }
  
  public static void n(String paramString, Class<?> paramClass)
  {
    AppMethodBeat.i(72624);
    if (agRz.containsKey(paramString))
    {
      paramString = new IllegalArgumentException("register process fail, exist process=".concat(String.valueOf(paramString)));
      AppMethodBeat.o(72624);
      throw paramString;
    }
    agRz.put(paramString, paramClass);
    AppMethodBeat.o(72624);
  }
  
  public static void remove(int paramInt)
  {
    AppMethodBeat.i(72626);
    agRA.remove(paramInt);
    AppMethodBeat.o(72626);
  }
  
  public static void v(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(72633);
    if (paramActivity == null) {
      Log.w("MicroMsg.ProcessManager", "hy: back context is null");
    }
    e locale = cm(paramActivity);
    if (locale == null) {}
    for (String str = "";; str = locale.fud())
    {
      Log.i("MicroMsg.ProcessManager", "backProcess to1 context: %s errCode %s procname %s ", new Object[] { paramActivity, Integer.valueOf(paramInt), str });
      if (locale == null) {
        break;
      }
      locale.i(paramActivity, paramInt);
      AppMethodBeat.o(72633);
      return;
    }
    if (!paramActivity.isFinishing()) {
      paramActivity.finish();
    }
    AppMethodBeat.o(72633);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.a
 * JD-Core Version:    0.7.0.1
 */