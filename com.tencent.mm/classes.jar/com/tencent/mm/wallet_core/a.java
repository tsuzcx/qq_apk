package com.tencent.mm.wallet_core;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a
{
  private static SparseArray<c> AVA;
  private static Map<String, Class<?>> AVz;
  
  static
  {
    AppMethodBeat.i(49005);
    AVz = new HashMap();
    AVA = new SparseArray();
    AppMethodBeat.o(49005);
  }
  
  public static void a(Activity paramActivity, Class<?> paramClass, Bundle paramBundle)
  {
    AppMethodBeat.i(48992);
    a(paramActivity, paramClass, paramBundle, null);
    AppMethodBeat.o(48992);
  }
  
  public static void a(Activity paramActivity, Class<?> paramClass, Bundle paramBundle, c.a parama)
  {
    AppMethodBeat.i(48993);
    ab.i("MicroMsg.ProcessManager", "startProcess to1 context:%s proc name: %s bundle %s", new Object[] { paramActivity, paramClass.getSimpleName(), aL(paramBundle) });
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {}
    try
    {
      localBundle = new Bundle();
      if (localBundle.getLong("key_SessionId", 0L) == 0L) {
        localBundle.putLong("key_SessionId", System.currentTimeMillis());
      }
      paramBundle = (c)paramClass.newInstance();
      paramBundle.aM(localBundle);
      paramBundle.a(parama, paramActivity);
      paramBundle.a(paramActivity, localBundle);
      AVA.put(paramClass.hashCode(), paramBundle);
      AppMethodBeat.o(48993);
      return;
    }
    catch (Exception paramActivity)
    {
      ab.printErrStackTrace("MicroMsg.ProcessManager", paramActivity, "", new Object[0]);
      AppMethodBeat.o(48993);
    }
  }
  
  public static void a(Activity paramActivity, String paramString, Bundle paramBundle, c.a parama)
  {
    AppMethodBeat.i(48995);
    try
    {
      ab.i("MicroMsg.ProcessManager", "startProcess to2 context:%s proc name: %s bundle %s", new Object[] { paramActivity, paramString, aL(paramBundle) });
      Class localClass = (Class)AVz.get(paramString);
      if (localClass == null)
      {
        paramString = String.format("start process=%s fail, process not register or plugin no import", new Object[] { paramString });
        ab.e("MicroMsg.ProcessManager", paramString);
        t.makeText(paramActivity, paramString, 1).show();
        AppMethodBeat.o(48995);
        return;
      }
      a(paramActivity, localClass, paramBundle, parama);
      AppMethodBeat.o(48995);
      return;
    }
    catch (Exception paramActivity)
    {
      ab.e("MicroMsg.ProcessManager", "plugin load failed : " + paramActivity.toString());
      ab.printErrStackTrace("MicroMsg.ProcessManager", paramActivity, "", new Object[0]);
      AppMethodBeat.o(48995);
    }
  }
  
  public static void aJ(Activity paramActivity)
  {
    AppMethodBeat.i(48997);
    c localc = aM(paramActivity);
    if (localc == null) {}
    for (String str = "";; str = localc.bzC())
    {
      ab.i("MicroMsg.ProcessManager", "backProcess to1 context: %s procname %s", new Object[] { paramActivity, str });
      if (localc != null) {
        localc.e(paramActivity, 0);
      }
      AppMethodBeat.o(48997);
      return;
    }
  }
  
  public static boolean aK(Activity paramActivity)
  {
    AppMethodBeat.i(49000);
    if (aM(paramActivity) != null)
    {
      AppMethodBeat.o(49000);
      return true;
    }
    AppMethodBeat.o(49000);
    return false;
  }
  
  public static Bundle aL(Activity paramActivity)
  {
    AppMethodBeat.i(49001);
    paramActivity = aM(paramActivity);
    if (paramActivity != null)
    {
      paramActivity = paramActivity.mEJ;
      AppMethodBeat.o(49001);
      return paramActivity;
    }
    paramActivity = new Bundle();
    AppMethodBeat.o(49001);
    return paramActivity;
  }
  
  private static String aL(Bundle paramBundle)
  {
    AppMethodBeat.i(48990);
    if (paramBundle == null)
    {
      AppMethodBeat.o(48990);
      return "";
    }
    paramBundle = paramBundle.toString();
    AppMethodBeat.o(48990);
    return paramBundle;
  }
  
  public static c aM(Activity paramActivity)
  {
    AppMethodBeat.i(49003);
    if (paramActivity == null)
    {
      ab.w("MicroMsg.ProcessManager", "hy: ac is null");
      AppMethodBeat.o(49003);
      return null;
    }
    if (paramActivity.getIntent() == null)
    {
      ab.w("MicroMsg.ProcessManager", "hy: get intent is null");
      AppMethodBeat.o(49003);
      return null;
    }
    paramActivity = (c)AVA.get(paramActivity.getIntent().getIntExtra("process_id", 0));
    AppMethodBeat.o(49003);
    return paramActivity;
  }
  
  public static List<c> avV(String paramString)
  {
    AppMethodBeat.i(49004);
    ArrayList localArrayList = new ArrayList();
    int j = AVA.size();
    int i = 0;
    while (i < j)
    {
      c localc = (c)AVA.valueAt(i);
      if (paramString.equals(localc.bzC())) {
        localArrayList.add(localc);
      }
      i += 1;
    }
    AppMethodBeat.o(49004);
    return localArrayList;
  }
  
  public static void b(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    AppMethodBeat.i(48999);
    ab.i("MicroMsg.ProcessManager", "endProcess with errCode : ".concat(String.valueOf(paramInt)));
    if (paramActivity == null) {
      ab.w("MicroMsg.ProcessManager", "hy: end context is null");
    }
    c localc = aM(paramActivity);
    String str2 = aL(paramBundle);
    if (localc == null) {}
    for (String str1 = "";; str1 = localc.bzC())
    {
      ab.i("MicroMsg.ProcessManager", "endProcess to1 context: %s bundle: %s procName %s", new Object[] { paramActivity, str2, str1 });
      if (localc == null) {
        break;
      }
      localc.b(paramActivity, paramBundle);
      AppMethodBeat.o(48999);
      return;
    }
    if (!paramActivity.isFinishing()) {
      paramActivity.finish();
    }
    AppMethodBeat.o(48999);
  }
  
  public static void b(Activity paramActivity, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(48994);
    a(paramActivity, paramString, paramBundle, null);
    AppMethodBeat.o(48994);
  }
  
  public static void h(String paramString, Class<?> paramClass)
  {
    AppMethodBeat.i(48989);
    if (AVz.containsKey(paramString))
    {
      paramString = new IllegalArgumentException("register process fail, exist process=".concat(String.valueOf(paramString)));
      AppMethodBeat.o(48989);
      throw paramString;
    }
    AVz.put(paramString, paramClass);
    AppMethodBeat.o(48989);
  }
  
  public static void j(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(48996);
    c localc = aM(paramActivity);
    String str2 = aL(paramBundle);
    if (localc == null) {}
    for (String str1 = "";; str1 = localc.bzC())
    {
      ab.i("MicroMsg.ProcessManager", "forwardProcess to1 context: %s bundle: %s procName %s", new Object[] { paramActivity, str2, str1 });
      if (localc != null) {
        localc.a(paramActivity, 0, paramBundle);
      }
      AppMethodBeat.o(48996);
      return;
    }
  }
  
  public static boolean k(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(49002);
    paramActivity = aM(paramActivity);
    if (paramActivity != null)
    {
      paramActivity.aM(paramBundle);
      AppMethodBeat.o(49002);
      return true;
    }
    AppMethodBeat.o(49002);
    return false;
  }
  
  public static void q(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(48998);
    if (paramActivity == null) {
      ab.w("MicroMsg.ProcessManager", "hy: back context is null");
    }
    c localc = aM(paramActivity);
    if (localc == null) {}
    for (String str = "";; str = localc.bzC())
    {
      ab.i("MicroMsg.ProcessManager", "backProcess to1 context: %s errCode %s procname %s ", new Object[] { paramActivity, Integer.valueOf(paramInt), str });
      if (localc == null) {
        break;
      }
      localc.e(paramActivity, paramInt);
      AppMethodBeat.o(48998);
      return;
    }
    if (!paramActivity.isFinishing()) {
      paramActivity.finish();
    }
    AppMethodBeat.o(48998);
  }
  
  public static void remove(int paramInt)
  {
    AppMethodBeat.i(48991);
    AVA.remove(paramInt);
    AppMethodBeat.o(48991);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.a
 * JD-Core Version:    0.7.0.1
 */