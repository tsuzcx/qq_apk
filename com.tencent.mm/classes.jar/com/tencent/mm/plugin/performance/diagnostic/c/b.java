package com.tencent.mm.plugin.performance.diagnostic.c;

import android.content.Context;
import android.os.Process;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.performance.b.a.a;
import com.tencent.mm.plugin.performance.diagnostic.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.wxperf.jni.HookManager;
import com.tencent.wxperf.jni.pthread.PthreadHook;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.n.d;
import org.json.JSONArray;
import org.json.JSONObject;

public class b
  extends com.tencent.mm.plugin.performance.diagnostic.a<PthreadHook, a>
  implements a.a
{
  private static final o ATV;
  private static final o ATW;
  private static final long ATX;
  private static final Set<String> ATY;
  private static String TAG;
  public final a ATZ;
  
  static
  {
    AppMethodBeat.i(201087);
    TAG = "MicroMsg.PthreadHookLogic";
    if (BuildInfo.IS_FLAVOR_RED) {}
    for (long l = 300000L;; l = 1800000L)
    {
      ATX = l;
      ATY = new HashSet();
      String str2 = eBE();
      TAG += str2;
      String str1 = MMApplicationContext.getContext().getFilesDir().getAbsolutePath() + "/pthread_hook";
      str2 = str1 + "/" + str2 + Process.myPid() + "_pthread_hook.json";
      ATV = new o(str1);
      ATW = new o(str2);
      Log.i(TAG, "init dump file path = %s", new Object[] { str2 });
      AppMethodBeat.o(201087);
      return;
    }
  }
  
  public b()
  {
    AppMethodBeat.i(201078);
    this.ATZ = new a(this);
    AppMethodBeat.o(201078);
  }
  
  public final String Lb()
  {
    return "PthreadHook";
  }
  
  public final void a(a.c paramc)
  {
    AppMethodBeat.i(201080);
    h.CyF.n(1571L, 12L, 1L);
    paramc = new ArrayList();
    IDKey localIDKey1 = new IDKey(1376, 12, 1);
    int i;
    if (MMApplicationContext.isMainProcess()) {
      i = 70;
    }
    for (;;)
    {
      IDKey localIDKey2 = new IDKey(1376, i, 1);
      paramc.add(localIDKey1);
      paramc.add(localIDKey2);
      h.CyF.b(paramc, false);
      AppMethodBeat.o(201080);
      return;
      if (MMApplicationContext.isAppBrandProcess()) {
        i = 71;
      } else if ((MMApplicationContext.isToolsMpProcess()) || (MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsIsolatedProcess())) {
        i = 72;
      } else {
        i = -1;
      }
    }
  }
  
  public final void eBD()
  {
    AppMethodBeat.i(201079);
    Log.i(TAG, "onRegistered: %s", new Object[] { "PthreadHook" });
    com.tencent.mm.plugin.performance.diagnostic.c.ATi.a("pthread", this);
    com.tencent.mm.plugin.performance.b.a.AUa.b(this);
    AppMethodBeat.o(201079);
  }
  
  public final String eBH()
  {
    AppMethodBeat.i(201082);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("hook=").append(this.ATZ.eBZ()).append(",thread=").append(this.ATZ.eCm()).append("\t");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(201082);
    return localObject;
  }
  
  public final String eBI()
  {
    return "PthreadHook";
  }
  
  public final void eCj()
  {
    AppMethodBeat.i(201083);
    Object localObject = "<cmd><diagnostic><PthreadHook\n enable='1' process='" + eBM() + "' duration='24' hook='.*\\.so$' thread='.*'/></diagnostic></cmd>";
    localObject = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.shj, (String)localObject);
    com.tencent.mm.plugin.performance.a.a.ASb.aJQ((String)localObject);
    localObject = new ArrayList();
    IDKey localIDKey1 = new IDKey(1376, 10, 1);
    int i;
    if (MMApplicationContext.isMainProcess()) {
      i = 50;
    }
    for (;;)
    {
      IDKey localIDKey2 = new IDKey(1376, i, 1);
      ((ArrayList)localObject).add(localIDKey1);
      ((ArrayList)localObject).add(localIDKey2);
      h.CyF.b((ArrayList)localObject, false);
      AppMethodBeat.o(201083);
      return;
      if (MMApplicationContext.isAppBrandProcess()) {
        i = 51;
      } else if ((MMApplicationContext.isToolsMpProcess()) || (MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsIsolatedProcess())) {
        i = 52;
      } else {
        i = -1;
      }
    }
  }
  
  public final double eCk()
  {
    AppMethodBeat.i(201084);
    double d = 1.0D / ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.shh, -1L);
    AppMethodBeat.o(201084);
    return d;
  }
  
  public final long eCl()
  {
    AppMethodBeat.i(201085);
    long l = TimeUnit.DAYS.toMinutes(1L);
    AppMethodBeat.o(201085);
    return l;
  }
  
  public final void hd(boolean paramBoolean)
  {
    AppMethodBeat.i(201081);
    Log.i(TAG, "memory dump begin");
    l1 = System.currentTimeMillis();
    try
    {
      localObject1 = ATV;
      if (!((o)localObject1).exists()) {
        ((o)localObject1).mkdirs();
      }
      localObject1 = PthreadHook.SyB;
      localObject2 = aa.z(ATW.her());
      if (HookManager.Syn.Syo) {
        ((PthreadHook)localObject1).dumpNative((String)localObject2);
      }
      Log.i(TAG, "dump path = %s", new Object[] { aa.z(ATW.her()) });
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        int i;
        try
        {
          Object localObject1;
          Object localObject2 = new JSONObject((String)localObject2).getJSONArray("PthreadHook");
          l1 = System.currentTimeMillis();
          i = 0;
          if (i < ((JSONArray)localObject2).length())
          {
            Object localObject4 = ((JSONArray)localObject2).getJSONObject(i);
            long l2 = Util.getLong(((JSONObject)localObject4).getString("hash"), 0L);
            String str1 = ((JSONObject)localObject4).getString("native");
            String str2 = ((JSONObject)localObject4).getString("java");
            int k = Util.getInt(((JSONObject)localObject4).getString("count"), 0);
            localObject4 = ((JSONObject)localObject4).getJSONArray("threads");
            Log.i(TAG, "------------------------------- hash= %d -------------------------------", new Object[] { Long.valueOf(l2) });
            Log.i(TAG, "native\n\t%s", new Object[] { str1.replace(";", "\n\t") });
            Log.i(TAG, "java\n\t%s", new Object[] { str2.replace(";", "\n\t") });
            Log.i(TAG, "ThreadCount = %d", new Object[] { Integer.valueOf(k) });
            ArrayList localArrayList = new ArrayList();
            HashSet localHashSet = new HashSet();
            int j = 0;
            if (j < ((JSONArray)localObject4).length())
            {
              Object localObject5 = new StringBuilder();
              JSONObject localJSONObject = ((JSONArray)localObject4).getJSONObject(j);
              ((StringBuilder)localObject5).append("{").append(localJSONObject.getString("tid")).append("-").append(localJSONObject.getString("name")).append("}");
              localObject5 = ((StringBuilder)localObject5).toString();
              localArrayList.add(localObject5);
              if (!ATY.contains(localObject5)) {
                localHashSet.add(localObject5);
              }
              j += 1;
              continue;
              localException1 = localException1;
              Log.printErrStackTrace(TAG, localException1, "something wrong when dumping", new Object[0]);
              continue;
            }
            Log.i(TAG, "==> leaked threads : %s", new Object[] { localArrayList.toString().replace(",", "") });
            if (localHashSet.isEmpty()) {
              break label804;
            }
            h.CyF.a(19816, new Object[] { Integer.valueOf(0), Long.valueOf(l1), Long.valueOf(l2), str1, str2, Integer.valueOf(k), localArrayList.toString().replace(",", ""), MMApplicationContext.getProcessName() });
            ATY.addAll(localHashSet);
            Log.i(TAG, "reported %s", new Object[] { localHashSet });
            break label804;
          }
          if ((WeChatEnvironment.isMonkeyEnv()) || (WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG)) {
            com.tencent.mm.plugin.performance.c.T(localException1);
          }
          localException1.delete();
        }
        catch (Exception localException2)
        {
          Log.printErrStackTrace(TAG, localException2, "report kv error", new Object[0]);
          localException1.delete();
          continue;
        }
        finally
        {
          localException1.delete();
          AppMethodBeat.o(201081);
        }
        Log.i(TAG, "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< dump file = %s, modified = %s", new Object[] { localException1.getName(), com.tencent.mm.plugin.performance.c.HF(localException1.lastModified()) });
        AppMethodBeat.o(201081);
        return;
        i += 1;
      }
    }
    Log.i(TAG, "memory dump end, cost = %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    localObject1 = new o(aa.z(ATW.her()));
    Log.i(TAG, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> dump file = %s, modified = %s", new Object[] { ((o)localObject1).getName(), com.tencent.mm.plugin.performance.c.HF(((o)localObject1).lastModified()) });
    localObject2 = com.tencent.mm.plugin.performance.c.a(aa.z(((o)localObject1).her()), d.UTF_8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.c.b
 * JD-Core Version:    0.7.0.1
 */