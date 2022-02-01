package com.tencent.mm.wallet_core;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  private static Map<String, Class<?>> RrV;
  private static SparseArray<d> RrW;
  
  static
  {
    AppMethodBeat.i(72640);
    RrV = new ConcurrentHashMap();
    RrW = new SparseArray();
    AppMethodBeat.o(72640);
  }
  
  public static void a(Activity paramActivity, Class<?> paramClass, Bundle paramBundle)
  {
    AppMethodBeat.i(72627);
    a(paramActivity, paramClass, paramBundle, null);
    AppMethodBeat.o(72627);
  }
  
  public static void a(Activity paramActivity, Class<?> paramClass, Bundle paramBundle, d.a parama)
  {
    AppMethodBeat.i(72628);
    Log.i("MicroMsg.ProcessManager", "startProcess to1 context:%s proc name: %s bundle %s", new Object[] { paramActivity, paramClass.getSimpleName(), bz(paramBundle) });
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
      paramBundle = (d)paramClass.newInstance();
      paramBundle.bA(localBundle);
      paramBundle.a(parama, paramActivity);
      paramBundle.a(paramActivity, localBundle);
      RrW.put(paramClass.hashCode(), paramBundle);
      AppMethodBeat.o(72628);
      return;
    }
    catch (Exception paramActivity)
    {
      Log.printErrStackTrace("MicroMsg.ProcessManager", paramActivity, "", new Object[0]);
      AppMethodBeat.o(72628);
    }
  }
  
  public static void a(Activity paramActivity, String paramString, Bundle paramBundle, d.a parama)
  {
    AppMethodBeat.i(72630);
    try
    {
      Log.i("MicroMsg.ProcessManager", "startProcess to2 context:%s proc name: %s bundle %s", new Object[] { paramActivity, paramString, bz(paramBundle) });
      Class localClass = (Class)RrV.get(paramString);
      if (localClass == null)
      {
        paramString = String.format("start process=%s fail, process not register or plugin no import", new Object[] { paramString });
        Log.e("MicroMsg.ProcessManager", paramString);
        u.makeText(paramActivity, paramString, 1).show();
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
  
  public static void b(Activity paramActivity, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(72629);
    a(paramActivity, paramString, paramBundle, null);
    AppMethodBeat.o(72629);
  }
  
  public static List<d> bpk(String paramString)
  {
    AppMethodBeat.i(72639);
    ArrayList localArrayList = new ArrayList();
    int j = RrW.size();
    int i = 0;
    while (i < j)
    {
      d locald = (d)RrW.valueAt(i);
      if (paramString.equals(locald.dKC())) {
        localArrayList.add(locald);
      }
      i += 1;
    }
    AppMethodBeat.o(72639);
    return localArrayList;
  }
  
  public static void bv(Activity paramActivity)
  {
    AppMethodBeat.i(72632);
    d locald = by(paramActivity);
    if (locald == null) {}
    for (String str = "";; str = locald.dKC())
    {
      Log.i("MicroMsg.ProcessManager", "backProcess to1 context: %s procname %s", new Object[] { paramActivity, str });
      if (locald != null) {
        locald.g(paramActivity, 0);
      }
      AppMethodBeat.o(72632);
      return;
    }
  }
  
  public static boolean bw(Activity paramActivity)
  {
    AppMethodBeat.i(72635);
    if (by(paramActivity) != null)
    {
      AppMethodBeat.o(72635);
      return true;
    }
    AppMethodBeat.o(72635);
    return false;
  }
  
  public static Bundle bx(Activity paramActivity)
  {
    AppMethodBeat.i(72636);
    paramActivity = by(paramActivity);
    if (paramActivity != null)
    {
      paramActivity = paramActivity.dQL;
      AppMethodBeat.o(72636);
      return paramActivity;
    }
    paramActivity = new Bundle();
    AppMethodBeat.o(72636);
    return paramActivity;
  }
  
  public static d by(Activity paramActivity)
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
    paramActivity = (d)RrW.get(paramActivity.getIntent().getIntExtra("process_id", 0));
    AppMethodBeat.o(72638);
    return paramActivity;
  }
  
  private static String bz(Bundle paramBundle)
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
  
  public static void c(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    AppMethodBeat.i(72634);
    Log.i("MicroMsg.ProcessManager", "endProcess with errCode : ".concat(String.valueOf(paramInt)));
    if (paramActivity == null) {
      Log.w("MicroMsg.ProcessManager", "hy: end context is null");
    }
    d locald = by(paramActivity);
    String str2 = bz(paramBundle);
    if (locald == null) {}
    for (String str1 = "";; str1 = locald.dKC())
    {
      Log.i("MicroMsg.ProcessManager", "endProcess to1 context: %s bundle: %s procName %s", new Object[] { paramActivity, str2, str1 });
      if (locald == null) {
        break;
      }
      locald.b(paramActivity, paramBundle);
      AppMethodBeat.o(72634);
      return;
    }
    if (!paramActivity.isFinishing()) {
      paramActivity.finish();
    }
    AppMethodBeat.o(72634);
  }
  
  public static void j(String paramString, Class<?> paramClass)
  {
    AppMethodBeat.i(72624);
    if (RrV.containsKey(paramString))
    {
      paramString = new IllegalArgumentException("register process fail, exist process=".concat(String.valueOf(paramString)));
      AppMethodBeat.o(72624);
      throw paramString;
    }
    RrV.put(paramString, paramClass);
    AppMethodBeat.o(72624);
  }
  
  public static void l(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(72631);
    d locald = by(paramActivity);
    String str2 = bz(paramBundle);
    if (locald == null) {}
    for (String str1 = "";; str1 = locald.dKC())
    {
      Log.i("MicroMsg.ProcessManager", "forwardProcess to1 context: %s bundle: %s procName %s", new Object[] { paramActivity, str2, str1 });
      if (locald != null) {
        locald.a(paramActivity, 0, paramBundle);
      }
      AppMethodBeat.o(72631);
      return;
    }
  }
  
  public static boolean m(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(72637);
    paramActivity = by(paramActivity);
    if (paramActivity != null)
    {
      paramActivity.bA(paramBundle);
      AppMethodBeat.o(72637);
      return true;
    }
    AppMethodBeat.o(72637);
    return false;
  }
  
  public static void remove(int paramInt)
  {
    AppMethodBeat.i(72626);
    RrW.remove(paramInt);
    AppMethodBeat.o(72626);
  }
  
  public static void s(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(72633);
    if (paramActivity == null) {
      Log.w("MicroMsg.ProcessManager", "hy: back context is null");
    }
    d locald = by(paramActivity);
    if (locald == null) {}
    for (String str = "";; str = locald.dKC())
    {
      Log.i("MicroMsg.ProcessManager", "backProcess to1 context: %s errCode %s procname %s ", new Object[] { paramActivity, Integer.valueOf(paramInt), str });
      if (locald == null) {
        break;
      }
      locald.g(paramActivity, paramInt);
      AppMethodBeat.o(72633);
      return;
    }
    if (!paramActivity.isFinishing()) {
      paramActivity.finish();
    }
    AppMethodBeat.o(72633);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.a
 * JD-Core Version:    0.7.0.1
 */