package com.tencent.mm.plugin.performance.diagnostic.b;

import android.content.Context;
import android.os.Debug;
import android.os.Process;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.hook.memory.MemoryHook;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.performance.diagnostic.c.d;
import com.tencent.mm.plugin.performance.diagnostic.e;
import com.tencent.mm.plugin.performance.dice.a.a;
import com.tencent.mm.plugin.performance.watchdogs.d.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
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
  private static final u MKA;
  private static final u MKB;
  private static final u MKC;
  private static String TAG;
  public final a MKD;
  private d.b MKE;
  
  static
  {
    AppMethodBeat.i(124967);
    TAG = "MicroMsg.MemoryHookLogic";
    String str3 = gye();
    TAG += str3;
    String str1 = MMApplicationContext.getContext().getFilesDir().getAbsolutePath() + "/memory_hook";
    String str2 = str1 + "/" + str3 + Process.myPid() + "_memory_hook.log";
    str3 = str1 + "/" + str3 + Process.myPid() + "_memory_hook.json";
    MKA = new u(str1);
    MKB = new u(str2);
    MKC = new u(str3);
    Log.i(TAG, "init dump file path = %s", new Object[] { str2 });
    Log.i(TAG, "init json file path = %s", new Object[] { str3 });
    AppMethodBeat.o(124967);
  }
  
  public b()
  {
    AppMethodBeat.i(124959);
    this.MKD = new a(this);
    AppMethodBeat.o(124959);
  }
  
  private void gyR()
  {
    AppMethodBeat.i(300896);
    Object localObject1 = com.tencent.mm.plugin.performance.c.aRp(ah.v(MKC.jKT()));
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      o((JSONObject)localObject1, "NativeHeap");
      o((JSONObject)localObject1, "mmap");
      p((JSONObject)localObject1, "SoNativeSize");
      p((JSONObject)localObject1, "SoMmapSize");
      MKC.diJ();
      AppMethodBeat.o(300896);
      return;
    }
    finally
    {
      try
      {
        Log.printErrStackTrace(TAG, localThrowable, "reportKV", new Object[0]);
        return;
      }
      finally
      {
        MKC.diJ();
        AppMethodBeat.o(300896);
      }
    }
  }
  
  private static void kT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(300870);
    Log.i(TAG, "memory dump begin");
    long l = System.currentTimeMillis();
    try
    {
      u localu = MKA;
      if (!localu.jKS()) {
        localu.jKY();
      }
      MemoryHook.eVb.dump(paramString1, paramString2);
      Log.i(TAG, "dump path = %s, json path = %s", new Object[] { ah.v(MKB.jKT()), ah.v(MKC.jKT()) });
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        Log.printErrStackTrace(TAG, paramString1, "something wrong when dumping", new Object[0]);
      }
    }
    Log.i(TAG, "memory dump end, cost = %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(300870);
  }
  
  private void o(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(300881);
    ArrayList localArrayList;
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray(paramString);
        if (paramJSONObject.length() <= 0)
        {
          Log.i(TAG, "reportStacktraceJson: report nothing");
          AppMethodBeat.o(300881);
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
      finally
      {
        Log.printErrStackTrace(TAG, paramJSONObject, "reportStacktraceJson", new Object[0]);
        AppMethodBeat.o(300881);
        return;
      }
    }
    while (localArrayList.size() < 26) {
      localArrayList.add("");
    }
    localArrayList.add(String.valueOf(Debug.getNativeHeapAllocatedSize()));
    if (this.MKE != null)
    {
      if (this.MKE.eLx) {
        break label500;
      }
      if (!this.MKE.MOu.isEmpty()) {
        break label500;
      }
    }
    for (;;)
    {
      localArrayList.add(paramJSONObject);
      localArrayList.add(String.valueOf(this.MKE.MOH));
      Log.i(TAG, "dumpAndReport: isForeground=%s, bgDuration=%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(this.MKE.MOH) });
      label382:
      localArrayList.add(String.valueOf(Process.myPid()));
      localArrayList.add(BuildInfo.BUILD_TAG);
      localArrayList.add(BuildInfo.REV);
      paramJSONObject = com.tencent.mm.plugin.report.service.h.OAn;
      com.tencent.mm.plugin.report.service.h.P(21217, localArrayList);
      Log.d(TAG, "report: %s", new Object[] { Arrays.toString(localArrayList.toArray()) });
      AppMethodBeat.o(300881);
      return;
      label500:
      for (boolean bool = false; !bool; bool = true)
      {
        paramJSONObject = "2";
        break;
        localArrayList.add("");
        localArrayList.add("");
        break label382;
      }
      paramJSONObject = "1";
    }
  }
  
  private static void p(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(300890);
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
            AppMethodBeat.o(300890);
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
      finally
      {
        Log.printErrStackTrace(TAG, paramJSONObject, "reportSoSizeJson", new Object[0]);
        AppMethodBeat.o(300890);
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
      Object localObject = com.tencent.mm.plugin.report.service.h.OAn;
      com.tencent.mm.plugin.report.service.h.P(21217, localArrayList);
      Log.d(TAG, "report -> %s", new Object[] { Arrays.toString(localArrayList.toArray()) });
      i += 1;
    }
    AppMethodBeat.o(300890);
  }
  
  public final void a(c.d paramd)
  {
    AppMethodBeat.i(300912);
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
      com.tencent.mm.plugin.report.service.h.OAn.b(paramd, false);
      AppMethodBeat.o(300912);
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
    AppMethodBeat.i(300930);
    Log.i(TAG, "dice action !");
    Object localObject = gym();
    localObject = "<cmd><diagnostic><MemoryHook enable='1' source='expt' process='" + (String)localObject + "' duration='24' hook='.*com\\.tencent\\.mm.*\\.so$;.*libhwui\\.so$;.*libstagefright_foundation\\.so$;.*libstagefright\\.so$' stack='1' min='0' max='0' force='1' enableExpt='0' sampling='1' mmap='0'/></diagnostic></cmd>";
    localObject = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zjP, (String)localObject);
    com.tencent.mm.plugin.performance.a.a.MIk.aRq((String)localObject);
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
      com.tencent.mm.plugin.report.service.h.OAn.b((ArrayList)localObject, false);
      AppMethodBeat.o(300930);
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
  
  public final void b(d.b paramb)
  {
    AppMethodBeat.i(300921);
    this.MKE = paramb;
    iT(false);
    AppMethodBeat.o(300921);
  }
  
  public long cycleMinutes()
  {
    AppMethodBeat.i(300940);
    long l = TimeUnit.DAYS.toMinutes(1L);
    AppMethodBeat.o(300940);
    return l;
  }
  
  public final void gya()
  {
    AppMethodBeat.i(300908);
    Log.i(TAG, "onRegistered: %s", new Object[] { "MemoryHook" });
    e.MJy.a("memory", this);
    com.tencent.mm.plugin.performance.dice.a.MKN.b(this);
    AppMethodBeat.o(300908);
  }
  
  public final String gyh()
  {
    AppMethodBeat.i(300926);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("hook=").append(this.MKD.gyI()).append(",stack=").append(this.MKD.gyK()).append(",mmap=").append(this.MKD.gyP()).append("\t");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(300926);
    return localObject;
  }
  
  public final String gyi()
  {
    return "MemoryHook";
  }
  
  public final void iT(boolean paramBoolean)
  {
    AppMethodBeat.i(300918);
    if (paramBoolean)
    {
      if (Debug.getNativeHeapAllocatedSize() > 524288000L) {
        kT(null, ah.v(MKC.jKT()));
      }
      gyR();
      AppMethodBeat.o(300918);
      return;
    }
    kT(ah.v(MKB.jKT()), ah.v(MKC.jKT()));
    gyR();
    com.tencent.mm.plugin.performance.c.g(TAG, MKB);
    AppMethodBeat.o(300918);
  }
  
  public String key()
  {
    return "MemoryHook";
  }
  
  public double rate()
  {
    AppMethodBeat.i(300936);
    if (BuildInfo.ENABLE_MATRIX_MEMORY_HOOK)
    {
      Log.i(TAG, "enable memory hook by build config");
      AppMethodBeat.o(300936);
      return 1.0D;
    }
    double d = 1.0D / ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zjN, -1L);
    AppMethodBeat.o(300936);
    return d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.b.b
 * JD-Core Version:    0.7.0.1
 */