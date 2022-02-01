package com.tencent.mm.plugin.performance.diagnostic.b;

import android.content.Context;
import android.os.Debug;
import android.os.Process;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.hook.memory.MemoryHook;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.performance.b.a.a;
import com.tencent.mm.plugin.performance.diagnostic.c.d;
import com.tencent.mm.plugin.performance.diagnostic.e;
import com.tencent.mm.plugin.performance.watchdogs.c.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public class b
  extends com.tencent.mm.plugin.performance.diagnostic.c<MemoryHook, a>
  implements a.a
{
  private static final q GNi;
  private static final q GNj;
  private static final q GNk;
  private static String TAG;
  public final a GNl;
  private c.b GNm;
  
  static
  {
    AppMethodBeat.i(124967);
    TAG = "MicroMsg.MemoryHookLogic";
    String str3 = fnr();
    TAG += str3;
    String str1 = MMApplicationContext.getContext().getFilesDir().getAbsolutePath() + "/memory_hook";
    String str2 = str1 + "/" + str3 + Process.myPid() + "_memory_hook.log";
    str3 = str1 + "/" + str3 + Process.myPid() + "_memory_hook.json";
    GNi = new q(str1);
    GNj = new q(str2);
    GNk = new q(str3);
    Log.i(TAG, "init dump file path = %s", new Object[] { str2 });
    Log.i(TAG, "init json file path = %s", new Object[] { str3 });
    AppMethodBeat.o(124967);
  }
  
  public b()
  {
    AppMethodBeat.i(124959);
    this.GNl = new a(this);
    AppMethodBeat.o(124959);
  }
  
  private void fnV()
  {
    AppMethodBeat.i(200911);
    Object localObject1 = com.tencent.mm.plugin.performance.c.aUl(GNk.bOF());
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      n((JSONObject)localObject1, "NativeHeap");
      n((JSONObject)localObject1, "mmap");
      o((JSONObject)localObject1, "SoNativeSize");
      o((JSONObject)localObject1, "SoMmapSize");
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace(TAG, localThrowable, "reportKV", new Object[0]);
      return;
    }
    finally
    {
      GNk.cFq();
      AppMethodBeat.o(200911);
    }
  }
  
  private static void jz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(200891);
    Log.i(TAG, "memory dump begin");
    long l = System.currentTimeMillis();
    try
    {
      q localq = GNi;
      if (!localq.ifE()) {
        localq.ifK();
      }
      MemoryHook.cYl.dump(paramString1, paramString2);
      Log.i(TAG, "dump path = %s, json path = %s", new Object[] { GNj.bOF(), GNk.bOF() });
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        Log.printErrStackTrace(TAG, paramString1, "something wrong when dumping", new Object[0]);
      }
    }
    Log.i(TAG, "memory dump end, cost = %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(200891);
  }
  
  private void n(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(200896);
    ArrayList localArrayList;
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray(paramString);
        if (paramJSONObject.length() <= 0)
        {
          Log.i(TAG, "reportStacktraceJson: report nothing");
          AppMethodBeat.o(200896);
          return;
        }
        localArrayList = new ArrayList();
        int i;
        if ("mmap".equalsIgnoreCase(paramString))
        {
          localArrayList.add("1");
          localArrayList.add(MMApplicationContext.getProcessName());
          i = 0;
          if (i >= paramJSONObject.length()) {
            break;
          }
          paramString = paramJSONObject.getJSONObject(i);
          Object localObject = paramString.getString("so").split("/");
          localArrayList.add(localObject[(localObject.length - 1)]);
          localArrayList.add(paramString.getString("size"));
          paramString = paramString.getJSONArray("top_stacks");
          int j = 0;
          if (j < paramString.length())
          {
            localObject = paramString.getJSONObject(j);
            localArrayList.add(((JSONObject)localObject).getString("stack"));
            localArrayList.add(((JSONObject)localObject).getString("size"));
            j += 1;
            continue;
          }
        }
        else
        {
          if (!"NativeHeap".equalsIgnoreCase(paramString)) {
            continue;
          }
          localArrayList.add("0");
          continue;
        }
        i += 1;
      }
      catch (Throwable paramJSONObject)
      {
        Log.printErrStackTrace(TAG, paramJSONObject, "reportStacktraceJson", new Object[0]);
        AppMethodBeat.o(200896);
        return;
      }
    }
    while (localArrayList.size() < 26) {
      localArrayList.add("");
    }
    localArrayList.add(String.valueOf(Debug.getNativeHeapAllocatedSize()));
    if (this.GNm != null)
    {
      if (this.GNm.cQt) {
        break label499;
      }
      if (!this.GNm.GQW.isEmpty()) {
        break label499;
      }
    }
    for (;;)
    {
      localArrayList.add(paramJSONObject);
      localArrayList.add(String.valueOf(this.GNm.GRi));
      Log.i(TAG, "dumpAndReport: isForeground=%s, bgDuration=%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(this.GNm.GRi) });
      label381:
      localArrayList.add(String.valueOf(Process.myPid()));
      localArrayList.add(BuildInfo.BUILD_TAG);
      localArrayList.add(BuildInfo.REV);
      paramJSONObject = com.tencent.mm.plugin.report.service.h.IzE;
      com.tencent.mm.plugin.report.service.h.u(21217, localArrayList);
      Log.d(TAG, "report: %s", new Object[] { Arrays.toString(localArrayList.toArray()) });
      AppMethodBeat.o(200896);
      return;
      label499:
      for (boolean bool = false; !bool; bool = true)
      {
        paramJSONObject = "2";
        break;
        localArrayList.add("");
        localArrayList.add("");
        break label381;
      }
      paramJSONObject = "1";
    }
  }
  
  private static void o(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(200908);
    for (;;)
    {
      long l;
      int i;
      ArrayList localArrayList;
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray(paramString);
        if (paramJSONObject.length() <= 0) {
          Log.i(TAG, "reportSoSizeJson: report nothing");
        }
        l = Debug.getNativeHeapAllocatedSize();
        i = 0;
        if (i >= paramJSONObject.length()) {
          break;
        }
        localArrayList = new ArrayList();
        if ("SoNativeSize".equalsIgnoreCase(paramString))
        {
          localArrayList.add("4");
          localArrayList.add(MMApplicationContext.getProcessName());
          localObject = paramJSONObject.getJSONObject(i);
          String[] arrayOfString = ((JSONObject)localObject).getString("so").split("/");
          localArrayList.add(arrayOfString[(arrayOfString.length - 1)]);
          localObject = ((JSONObject)localObject).getString("size");
          localArrayList.add(localObject);
          if (Util.getInt((String)localObject, 0) < 1048576)
          {
            Log.i(TAG, "so size %s < 1M", new Object[] { localObject });
            AppMethodBeat.o(200908);
          }
        }
        else
        {
          if (!"SoMmapSize".equalsIgnoreCase(paramString)) {
            continue;
          }
          localArrayList.add("5");
          continue;
        }
        if (localArrayList.size() >= 26) {
          break label246;
        }
      }
      catch (Throwable paramJSONObject)
      {
        Log.printErrStackTrace(TAG, paramJSONObject, "reportSoSizeJson", new Object[0]);
        AppMethodBeat.o(200908);
        return;
      }
      for (;;)
      {
        localArrayList.add("");
      }
      label246:
      localArrayList.add(String.valueOf(l));
      localArrayList.add("");
      localArrayList.add("");
      localArrayList.add(String.valueOf(Process.myPid()));
      localArrayList.add(BuildInfo.BUILD_TAG);
      localArrayList.add(BuildInfo.REV);
      Object localObject = com.tencent.mm.plugin.report.service.h.IzE;
      com.tencent.mm.plugin.report.service.h.u(21217, localArrayList);
      Log.d(TAG, "report -> %s", new Object[] { Arrays.toString(localArrayList.toArray()) });
      i += 1;
    }
    AppMethodBeat.o(200908);
  }
  
  public final void a(c.d paramd)
  {
    AppMethodBeat.i(200882);
    Log.i(TAG, "onHookEnabled: source = %s", new Object[] { paramd.name() });
    super.a(paramd);
    paramd = new ArrayList();
    IDKey localIDKey1 = new IDKey(1571, 2, 1);
    int i;
    if (MMApplicationContext.isMainProcess()) {
      i = 40;
    }
    for (;;)
    {
      IDKey localIDKey2 = new IDKey(1571, i, 1);
      paramd.add(localIDKey1);
      paramd.add(localIDKey2);
      com.tencent.mm.plugin.report.service.h.IzE.b(paramd, false);
      AppMethodBeat.o(200882);
      return;
      if (MMApplicationContext.isAppBrandProcess()) {
        i = 41;
      } else if ((MMApplicationContext.isToolsMpProcess()) || (MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsIsolatedProcess())) {
        i = 42;
      } else {
        i = -1;
      }
    }
  }
  
  public void action(double paramDouble)
  {
    AppMethodBeat.i(200926);
    Log.i(TAG, "dice action !");
    Object localObject = fnz();
    localObject = "<cmd><diagnostic><MemoryHook enable='1' source='expt' process='" + (String)localObject + "' duration='24' hook='.*com\\.tencent\\.mm.*\\.so$' stack='1' min='0' max='0' force='1' enableExpt='0' sampling='1' mmap='0'/></diagnostic></cmd>";
    localObject = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vRg, (String)localObject);
    com.tencent.mm.plugin.performance.a.a.GLp.aUm((String)localObject);
    localObject = new ArrayList();
    IDKey localIDKey1 = new IDKey(1571, 0, 1);
    int i;
    if (MMApplicationContext.isMainProcess()) {
      i = 20;
    }
    for (;;)
    {
      IDKey localIDKey2 = new IDKey(1571, i, 1);
      ((ArrayList)localObject).add(localIDKey1);
      ((ArrayList)localObject).add(localIDKey2);
      com.tencent.mm.plugin.report.service.h.IzE.b((ArrayList)localObject, false);
      AppMethodBeat.o(200926);
      return;
      if (MMApplicationContext.isAppBrandProcess()) {
        i = 21;
      } else if ((MMApplicationContext.isToolsMpProcess()) || (MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsIsolatedProcess())) {
        i = 22;
      } else {
        i = -1;
      }
    }
  }
  
  public final void b(c.b paramb)
  {
    AppMethodBeat.i(200887);
    this.GNm = paramb;
    hU(false);
    AppMethodBeat.o(200887);
  }
  
  public long cycleMinutes()
  {
    AppMethodBeat.i(200931);
    long l = TimeUnit.DAYS.toMinutes(1L);
    AppMethodBeat.o(200931);
    return l;
  }
  
  public final void fnn()
  {
    AppMethodBeat.i(200878);
    Log.i(TAG, "onRegistered: %s", new Object[] { "MemoryHook" });
    e.GMC.a("memory", this);
    com.tencent.mm.plugin.performance.b.a.GNv.b(this);
    AppMethodBeat.o(200878);
  }
  
  public final String fnu()
  {
    AppMethodBeat.i(200915);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("hook=").append(this.GNl.fnM()).append(",stack=").append(this.GNl.fnO()).append(",mmap=").append(this.GNl.fnT()).append("\t");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(200915);
    return localObject;
  }
  
  public final String fnv()
  {
    return "MemoryHook";
  }
  
  public final void hU(boolean paramBoolean)
  {
    AppMethodBeat.i(200885);
    if (paramBoolean)
    {
      if (Debug.getNativeHeapAllocatedSize() > 524288000L) {
        jz(null, GNk.bOF());
      }
      fnV();
      AppMethodBeat.o(200885);
      return;
    }
    jz(GNj.bOF(), GNk.bOF());
    fnV();
    com.tencent.mm.plugin.performance.c.g(TAG, GNj);
    AppMethodBeat.o(200885);
  }
  
  public String key()
  {
    return "MemoryHook";
  }
  
  public double rate()
  {
    AppMethodBeat.i(200929);
    double d = 1.0D / ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vRe, -1L);
    AppMethodBeat.o(200929);
    return d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.b.b
 * JD-Core Version:    0.7.0.1
 */