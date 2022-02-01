package com.tencent.mm.plugin.performance.diagnostic.c;

import android.content.Context;
import android.os.Process;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.hook.pthread.PthreadHook;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.performance.diagnostic.c.d;
import com.tencent.mm.plugin.performance.diagnostic.e;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.q;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public class b
  extends com.tencent.mm.plugin.performance.diagnostic.c<PthreadHook, a>
  implements com.tencent.mm.plugin.performance.b.a.a
{
  private static final q GNq;
  private static final q GNr;
  private static final long GNs;
  private static final Set<String> GNt;
  private static String TAG;
  public final a GNu;
  
  static
  {
    AppMethodBeat.i(201527);
    TAG = "MicroMsg.PthreadHookLogic";
    if (BuildInfo.IS_FLAVOR_RED) {}
    for (long l = 300000L;; l = 1800000L)
    {
      GNs = l;
      GNt = new HashSet();
      String str2 = fnr();
      TAG += str2;
      String str1 = MMApplicationContext.getContext().getFilesDir().getAbsolutePath() + "/pthread_hook";
      str2 = str1 + "/" + str2 + Process.myPid() + "_pthread_hook.json";
      GNq = new q(str1);
      GNr = new q(str2);
      Log.i(TAG, "init dump file path = %s", new Object[] { str2 });
      AppMethodBeat.o(201527);
      return;
    }
  }
  
  public b()
  {
    AppMethodBeat.i(201495);
    this.GNu = new a(this);
    AppMethodBeat.o(201495);
  }
  
  public final void a(c.d paramd)
  {
    AppMethodBeat.i(201501);
    super.a(paramd);
    paramd = new ArrayList();
    IDKey localIDKey1 = new IDKey(1571, 12, 1);
    int i;
    if (MMApplicationContext.isMainProcess()) {
      i = 70;
    }
    for (;;)
    {
      IDKey localIDKey2 = new IDKey(1571, i, 1);
      paramd.add(localIDKey1);
      paramd.add(localIDKey2);
      com.tencent.mm.plugin.report.service.h.IzE.b(paramd, false);
      AppMethodBeat.o(201501);
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
  
  public void action(double paramDouble)
  {
    AppMethodBeat.i(201515);
    Object localObject = "<cmd><diagnostic><PthreadHook\n enable='1' process='" + fnz() + "' duration='24' hook='.*\\.so$' thread='.*'/></diagnostic></cmd>";
    localObject = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vRh, (String)localObject);
    com.tencent.mm.plugin.performance.a.a.GLp.aUm((String)localObject);
    localObject = new ArrayList();
    IDKey localIDKey1 = new IDKey(1571, 10, 1);
    int i;
    if (MMApplicationContext.isMainProcess()) {
      i = 50;
    }
    for (;;)
    {
      IDKey localIDKey2 = new IDKey(1571, i, 1);
      ((ArrayList)localObject).add(localIDKey1);
      ((ArrayList)localObject).add(localIDKey2);
      com.tencent.mm.plugin.report.service.h.IzE.b((ArrayList)localObject, false);
      AppMethodBeat.o(201515);
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
  
  public long cycleMinutes()
  {
    AppMethodBeat.i(201517);
    long l = TimeUnit.DAYS.toMinutes(1L);
    AppMethodBeat.o(201517);
    return l;
  }
  
  public final void fnn()
  {
    AppMethodBeat.i(201497);
    Log.i(TAG, "onRegistered: %s", new Object[] { "PthreadHook" });
    e.GMC.a("pthread", this);
    com.tencent.mm.plugin.performance.b.a.GNv.b(this);
    AppMethodBeat.o(201497);
  }
  
  public final String fnu()
  {
    AppMethodBeat.i(201513);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("hook=").append(this.GNu.fnM()).append(",thread=").append(this.GNu.fnW()).append("\t");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(201513);
    return localObject;
  }
  
  public final String fnv()
  {
    return "PthreadHook";
  }
  
  public final void hU(boolean paramBoolean)
  {
    AppMethodBeat.i(201512);
    Log.i(TAG, "memory dump begin");
    l1 = System.currentTimeMillis();
    try
    {
      localObject1 = GNq;
      if (!((q)localObject1).ifE()) {
        ((q)localObject1).ifK();
      }
      localObject1 = PthreadHook.cYv;
      localObject2 = GNr.bOF();
      if (((com.tencent.matrix.hook.a)localObject1).cXZ == com.tencent.matrix.hook.a.a.cYb) {
        ((PthreadHook)localObject1).dumpNative((String)localObject2);
      }
      Log.i(TAG, "dump path = %s", new Object[] { GNr.bOF() });
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
              if (!GNt.contains(localObject5)) {
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
              break label817;
            }
            com.tencent.mm.plugin.report.service.h.IzE.a(19816, new Object[] { Integer.valueOf(0), Long.valueOf(l1), Long.valueOf(l2), str1, str2, Integer.valueOf(k), localArrayList.toString().replace(",", ""), MMApplicationContext.getProcessName(), Integer.valueOf(Process.myPid()), BuildInfo.BUILD_TAG, BuildInfo.REV });
            GNt.addAll(localHashSet);
            Log.i(TAG, "reported %s", new Object[] { localHashSet });
            break label817;
          }
          if ((WeChatEnvironment.isMonkeyEnv()) || (WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG)) {
            com.tencent.mm.plugin.performance.c.T(localException1);
          }
          localException1.cFq();
        }
        catch (Exception localException2)
        {
          Log.printErrStackTrace(TAG, localException2, "report kv error", new Object[0]);
          localException1.cFq();
          continue;
        }
        finally
        {
          localException1.cFq();
          AppMethodBeat.o(201512);
        }
        Log.i(TAG, "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< dump file = %s, modified = %s", new Object[] { localException1.getName(), com.tencent.mm.plugin.performance.c.OZ(localException1.lastModified()) });
        AppMethodBeat.o(201512);
        return;
        i += 1;
      }
    }
    Log.i(TAG, "memory dump end, cost = %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    localObject1 = new q(GNr.bOF());
    Log.i(TAG, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> dump file = %s, modified = %s", new Object[] { ((q)localObject1).getName(), com.tencent.mm.plugin.performance.c.OZ(((q)localObject1).lastModified()) });
    localObject2 = com.tencent.mm.plugin.performance.c.aUl(((q)localObject1).bOF());
  }
  
  public String key()
  {
    return "PthreadHook";
  }
  
  public double rate()
  {
    AppMethodBeat.i(201516);
    double d = 1.0D / ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vRf, -1L);
    AppMethodBeat.o(201516);
    return d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.c.b
 * JD-Core Version:    0.7.0.1
 */