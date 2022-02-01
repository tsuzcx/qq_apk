package com.tencent.mm.plugin.performance.diagnostic.c;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.hook.pthread.PthreadHook;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.performance.diagnostic.c.d;
import com.tencent.mm.plugin.performance.diagnostic.e;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
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
  implements com.tencent.mm.plugin.performance.dice.a.a
{
  private static final u MKI;
  private static final u MKJ;
  private static final long MKK;
  private static final Set<String> MKL;
  private static String TAG;
  public final a MKM;
  
  static
  {
    AppMethodBeat.i(300866);
    TAG = "MicroMsg.PthreadHookLogic";
    if (BuildInfo.IS_FLAVOR_RED) {}
    for (long l = 300000L;; l = 1800000L)
    {
      MKK = l;
      MKL = new HashSet();
      String str2 = gye();
      TAG += str2;
      String str1 = MMApplicationContext.getContext().getFilesDir().getAbsolutePath() + "/pthread_hook";
      str2 = str1 + "/" + str2 + Process.myPid() + "_pthread_hook.json";
      MKI = new u(str1);
      MKJ = new u(str2);
      Log.i(TAG, "init dump file path = %s", new Object[] { str2 });
      AppMethodBeat.o(300866);
      return;
    }
  }
  
  public b()
  {
    AppMethodBeat.i(300853);
    this.MKM = new a(this);
    AppMethodBeat.o(300853);
  }
  
  private static void Y(u paramu)
  {
    AppMethodBeat.i(300862);
    Log.i(TAG, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> dump file = %s, modified = %s", new Object[] { paramu.getName(), com.tencent.mm.plugin.performance.c.tc(paramu.lastModified()) });
    Object localObject1 = com.tencent.mm.plugin.performance.c.aRp(ah.v(paramu.jKT()));
    for (;;)
    {
      int i;
      int j;
      try
      {
        localObject1 = new JSONObject((String)localObject1).getJSONArray("PthreadHook_not_exited");
        long l1 = System.currentTimeMillis();
        i = 0;
        if (i < ((JSONArray)localObject1).length())
        {
          Object localObject3 = ((JSONArray)localObject1).getJSONObject(i);
          long l2 = Util.getLong(((JSONObject)localObject3).getString("hash"), 0L);
          String str1 = ((JSONObject)localObject3).getString("native");
          String str2 = ((JSONObject)localObject3).getString("java");
          int k = Util.getInt(((JSONObject)localObject3).getString("count"), 0);
          localObject3 = ((JSONObject)localObject3).getJSONArray("threads");
          Log.i(TAG, "------------------------------- hash= %d -------------------------------", new Object[] { Long.valueOf(l2) });
          Log.i(TAG, "native\n\t%s", new Object[] { str1.replace(";", "\n\t") });
          Log.i(TAG, "java\n\t%s", new Object[] { str2.replace(";", "\n\t") });
          Log.i(TAG, "ThreadCount = %d", new Object[] { Integer.valueOf(k) });
          ArrayList localArrayList = new ArrayList();
          HashSet localHashSet = new HashSet();
          j = 0;
          if (j < ((JSONArray)localObject3).length())
          {
            Object localObject4 = new StringBuilder();
            JSONObject localJSONObject = ((JSONArray)localObject3).getJSONObject(j);
            ((StringBuilder)localObject4).append("{").append(localJSONObject.getString("tid")).append("-").append(localJSONObject.getString("name")).append("}");
            localObject4 = ((StringBuilder)localObject4).toString();
            localArrayList.add(localObject4);
            if (MKL.contains(localObject4)) {
              break label636;
            }
            localHashSet.add(localObject4);
            break label636;
          }
          Log.i(TAG, "==> leaked threads : %s", new Object[] { localArrayList.toString().replace(",", "") });
          if (localHashSet.isEmpty()) {
            break label643;
          }
          com.tencent.mm.plugin.report.service.h.OAn.b(19816, new Object[] { Integer.valueOf(0), Long.valueOf(l1), Long.valueOf(l2), str1, str2, Integer.valueOf(k), localArrayList.toString().replace(",", ""), MMApplicationContext.getProcessName(), Integer.valueOf(Process.myPid()), BuildInfo.BUILD_TAG, BuildInfo.REV });
          MKL.addAll(localHashSet);
          Log.i(TAG, "reported %s", new Object[] { localHashSet });
          break label643;
        }
        if ((WeChatEnvironment.isMonkeyEnv()) || (WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG)) {
          com.tencent.mm.plugin.performance.c.V(paramu);
        }
        paramu.diJ();
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace(TAG, localException, "report kv error", new Object[0]);
        paramu.diJ();
        continue;
      }
      finally
      {
        paramu.diJ();
        AppMethodBeat.o(300862);
      }
      Log.i(TAG, "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< dump file = %s, modified = %s", new Object[] { paramu.getName(), com.tencent.mm.plugin.performance.c.tc(paramu.lastModified()) });
      AppMethodBeat.o(300862);
      return;
      label636:
      j += 1;
      continue;
      label643:
      i += 1;
    }
  }
  
  public final void a(c.d paramd)
  {
    AppMethodBeat.i(300874);
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
      com.tencent.mm.plugin.report.service.h.OAn.b(paramd, false);
      AppMethodBeat.o(300874);
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
    AppMethodBeat.i(300897);
    Object localObject = "<cmd><diagnostic><PthreadHook\n enable='1' process='" + gym() + "' duration='24' hook='.*\\.so$' thread='.*'/></diagnostic></cmd>";
    localObject = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zjQ, (String)localObject);
    com.tencent.mm.plugin.performance.a.a.MIk.aRq((String)localObject);
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
      com.tencent.mm.plugin.report.service.h.OAn.b((ArrayList)localObject, false);
      AppMethodBeat.o(300897);
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
    AppMethodBeat.i(300910);
    long l = TimeUnit.DAYS.toMinutes(1L);
    AppMethodBeat.o(300910);
    return l;
  }
  
  public final void gya()
  {
    AppMethodBeat.i(300869);
    Log.i(TAG, "onRegistered: %s", new Object[] { "PthreadHook" });
    e.MJy.a("pthread", this);
    com.tencent.mm.plugin.performance.dice.a.MKN.b(this);
    AppMethodBeat.o(300869);
  }
  
  public final String gyh()
  {
    AppMethodBeat.i(300888);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("hook=").append(this.MKM.gyI()).append(",thread=").append(this.MKM.gyS()).append("\t");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(300888);
    return localObject;
  }
  
  public final String gyi()
  {
    return "PthreadHook";
  }
  
  public final void iT(boolean paramBoolean)
  {
    AppMethodBeat.i(300880);
    Log.i(TAG, "memory dump begin");
    long l = System.currentTimeMillis();
    String str;
    try
    {
      Object localObject = MKI;
      if (!((u)localObject).jKS()) {
        ((u)localObject).jKY();
      }
      localObject = PthreadHook.eVl;
      str = ah.v(MKJ.jKT());
      if (TextUtils.isEmpty(str))
      {
        localObject = new IllegalArgumentException("path NOT valid: ".concat(String.valueOf(str)));
        AppMethodBeat.o(300880);
        throw ((Throwable)localObject);
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(TAG, localException, "something wrong when dumping", new Object[0]);
    }
    for (;;)
    {
      Log.i(TAG, "memory dump end, cost = %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      Y(new u(ah.v(MKJ.jKT())));
      AppMethodBeat.o(300880);
      return;
      if (localException.eUE == com.tencent.matrix.hook.a.a.eUG) {
        localException.dumpNative(str);
      }
      Log.i(TAG, "dump path = %s", new Object[] { ah.v(MKJ.jKT()) });
    }
  }
  
  public String key()
  {
    return "PthreadHook";
  }
  
  public double rate()
  {
    AppMethodBeat.i(300907);
    if (BuildInfo.ENABLE_MATRIX_PTHREAD_HOOK)
    {
      Log.i(TAG, "enable pthread hook by build config");
      AppMethodBeat.o(300907);
      return 1.0D;
    }
    double d = 1.0D / ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zjO, -1L);
    AppMethodBeat.o(300907);
    return d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.c.b
 * JD-Core Version:    0.7.0.1
 */