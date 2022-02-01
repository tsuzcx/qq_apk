package com.tencent.mm.plugin.performance.diagnostic.b;

import android.content.Context;
import android.os.Debug;
import android.os.Process;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.performance.b.a.a;
import com.tencent.mm.plugin.performance.diagnostic.a.c;
import com.tencent.mm.plugin.performance.watchdogs.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.wxperf.jni.memory.MemoryHook;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.n.d;
import org.json.JSONArray;
import org.json.JSONObject;

public class b
  extends com.tencent.mm.plugin.performance.diagnostic.a<MemoryHook, a>
  implements a.a
{
  private static final o ATN;
  private static final o ATO;
  private static final o ATP;
  private static String TAG;
  public final a ATQ;
  private c.a ATR;
  
  static
  {
    AppMethodBeat.i(124967);
    TAG = "MicroMsg.MemoryHookLogic";
    String str3 = eBE();
    TAG += str3;
    String str1 = MMApplicationContext.getContext().getFilesDir().getAbsolutePath() + "/memory_hook";
    String str2 = str1 + "/" + str3 + Process.myPid() + "_memory_hook.log";
    str3 = str1 + "/" + str3 + Process.myPid() + "_memory_hook.json";
    ATN = new o(str1);
    ATO = new o(str2);
    ATP = new o(str3);
    Log.i(TAG, "init dump file path = %s", new Object[] { str2 });
    Log.i(TAG, "init json file path = %s", new Object[] { str3 });
    AppMethodBeat.o(124967);
  }
  
  public b()
  {
    AppMethodBeat.i(124959);
    this.ATQ = new a(this);
    AppMethodBeat.o(124959);
  }
  
  private void eCi()
  {
    AppMethodBeat.i(201065);
    Object localObject1 = com.tencent.mm.plugin.performance.c.a(aa.z(ATP.her()), d.UTF_8);
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      m((JSONObject)localObject1, "NativeHeap");
      m((JSONObject)localObject1, "mmap");
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace(TAG, localThrowable, "reportKV", new Object[0]);
      return;
    }
    finally
    {
      ATP.delete();
      AppMethodBeat.o(201065);
    }
  }
  
  private static void jo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(201063);
    Log.i(TAG, "memory dump begin");
    long l = System.currentTimeMillis();
    try
    {
      o localo = ATN;
      if (!localo.exists()) {
        localo.mkdirs();
      }
      MemoryHook.Sys.dump(paramString1, paramString2);
      Log.i(TAG, "dump path = %s, json path = %s", new Object[] { aa.z(ATO.her()), aa.z(ATP.her()) });
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        Log.printErrStackTrace(TAG, paramString1, "something wrong when dumping", new Object[0]);
      }
    }
    Log.i(TAG, "memory dump end, cost = %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(201063);
  }
  
  private void m(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(201064);
    JSONArray localJSONArray = paramJSONObject.getJSONArray(paramString);
    if (localJSONArray.length() <= 0)
    {
      Log.i(TAG, "report nothing");
      AppMethodBeat.o(201064);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i;
    if ("mmap".equalsIgnoreCase(paramString))
    {
      paramJSONObject = "1";
      localArrayList.add(paramJSONObject);
      localArrayList.add(MMApplicationContext.getProcessName());
      i = 0;
    }
    for (;;)
    {
      if (i >= localJSONArray.length()) {
        break label211;
      }
      paramJSONObject = localJSONArray.getJSONObject(i);
      paramString = paramJSONObject.getString("so").split("/");
      localArrayList.add(paramString[(paramString.length - 1)]);
      localArrayList.add(paramJSONObject.getString("size"));
      paramJSONObject = paramJSONObject.getJSONArray("top_stacks");
      int j = 0;
      for (;;)
      {
        if (j < paramJSONObject.length())
        {
          paramString = paramJSONObject.getJSONObject(j);
          localArrayList.add(paramString.getString("stack"));
          localArrayList.add(paramString.getString("size"));
          j += 1;
          continue;
          paramJSONObject = "0";
          break;
        }
      }
      i += 1;
    }
    label211:
    while (localArrayList.size() < 26) {
      localArrayList.add("");
    }
    localArrayList.add(String.valueOf(Debug.getNativeHeapAllocatedSize()));
    boolean bool;
    if (this.ATR != null)
    {
      if ((!this.ATR.cPB) && (this.ATR.AXr.isEmpty())) {
        break label399;
      }
      bool = true;
      if (!bool) {
        break label405;
      }
    }
    label399:
    label405:
    for (paramJSONObject = "1";; paramJSONObject = "2")
    {
      localArrayList.add(paramJSONObject);
      localArrayList.add(String.valueOf(this.ATR.AXD));
      Log.i(TAG, "dumpAndReport: isForeground=%s, bgDuration=%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(this.ATR.AXD) });
      paramJSONObject = h.CyF;
      h.r(21217, localArrayList);
      Log.d(TAG, "report: %s", new Object[] { Arrays.toString(localArrayList.toArray()) });
      AppMethodBeat.o(201064);
      return;
      bool = false;
      break;
    }
  }
  
  public final String Lb()
  {
    return "MemoryHook";
  }
  
  public final void a(a.c paramc)
  {
    AppMethodBeat.i(201060);
    Log.i(TAG, "onHookEnabled: source = %s", new Object[] { paramc.name() });
    paramc = new ArrayList();
    IDKey localIDKey1 = new IDKey(1571, 2, 1);
    int i;
    if (MMApplicationContext.isMainProcess()) {
      i = 40;
    }
    for (;;)
    {
      IDKey localIDKey2 = new IDKey(1571, i, 1);
      paramc.add(localIDKey1);
      paramc.add(localIDKey2);
      h.CyF.b(paramc, false);
      AppMethodBeat.o(201060);
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
  
  public final void a(c.a parama)
  {
    AppMethodBeat.i(201062);
    this.ATR = parama;
    hd(false);
    AppMethodBeat.o(201062);
  }
  
  public final void eBD()
  {
    AppMethodBeat.i(201059);
    Log.i(TAG, "onRegistered: %s", new Object[] { "MemoryHook" });
    com.tencent.mm.plugin.performance.diagnostic.c.ATi.a("memory", this);
    com.tencent.mm.plugin.performance.b.a.AUa.b(this);
    AppMethodBeat.o(201059);
  }
  
  public final String eBH()
  {
    AppMethodBeat.i(201066);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("hook=").append(this.ATQ.eBZ()).append(",stack=").append(this.ATQ.eCb()).append(",mmap=").append(this.ATQ.eCg()).append("\t");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(201066);
    return localObject;
  }
  
  public final String eBI()
  {
    return "MemoryHook";
  }
  
  public final void eCj()
  {
    AppMethodBeat.i(201067);
    Log.i(TAG, "dice action !");
    if (!BuildInfo.IS_ARM64)
    {
      Log.i(TAG, "not enable for 32-bit device");
      AppMethodBeat.o(201067);
      return;
    }
    Object localObject = eBM();
    localObject = "<cmd><diagnostic><MemoryHook enable='1' source='expt' process='" + (String)localObject + "' duration='24' hook='.*com\\.tencent\\.mm.*\\.so$' stack='1' min='0' max='0' force='1' enableExpt='0' sampling='1' mmap='0'/></diagnostic></cmd>";
    localObject = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.shi, (String)localObject);
    com.tencent.mm.plugin.performance.a.a.ASb.aJQ((String)localObject);
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
      h.CyF.b((ArrayList)localObject, false);
      AppMethodBeat.o(201067);
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
  
  public final double eCk()
  {
    AppMethodBeat.i(201068);
    double d = 1.0D / ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.shg, -1L);
    AppMethodBeat.o(201068);
    return d;
  }
  
  public final long eCl()
  {
    AppMethodBeat.i(201069);
    long l = TimeUnit.DAYS.toMinutes(1L);
    AppMethodBeat.o(201069);
    return l;
  }
  
  /* Error */
  public final void hd(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 578
    //   3: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_1
    //   7: ifeq +37 -> 44
    //   10: invokestatic 267	android/os/Debug:getNativeHeapAllocatedSize	()J
    //   13: ldc2_w 579
    //   16: lcmp
    //   17: ifle +16 -> 33
    //   20: aconst_null
    //   21: getstatic 91	com/tencent/mm/plugin/performance/diagnostic/b/b:ATP	Lcom/tencent/mm/vfs/o;
    //   24: invokevirtual 123	com/tencent/mm/vfs/o:her	()Landroid/net/Uri;
    //   27: invokestatic 129	com/tencent/mm/vfs/aa:z	(Landroid/net/Uri;)Ljava/lang/String;
    //   30: invokestatic 582	com/tencent/mm/plugin/performance/diagnostic/b/b:jo	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: aload_0
    //   34: invokespecial 584	com/tencent/mm/plugin/performance/diagnostic/b/b:eCi	()V
    //   37: ldc_w 578
    //   40: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: return
    //   44: getstatic 89	com/tencent/mm/plugin/performance/diagnostic/b/b:ATO	Lcom/tencent/mm/vfs/o;
    //   47: invokevirtual 123	com/tencent/mm/vfs/o:her	()Landroid/net/Uri;
    //   50: invokestatic 129	com/tencent/mm/vfs/aa:z	(Landroid/net/Uri;)Ljava/lang/String;
    //   53: getstatic 91	com/tencent/mm/plugin/performance/diagnostic/b/b:ATP	Lcom/tencent/mm/vfs/o;
    //   56: invokevirtual 123	com/tencent/mm/vfs/o:her	()Landroid/net/Uri;
    //   59: invokestatic 129	com/tencent/mm/vfs/aa:z	(Landroid/net/Uri;)Ljava/lang/String;
    //   62: invokestatic 582	com/tencent/mm/plugin/performance/diagnostic/b/b:jo	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: aload_0
    //   66: invokespecial 584	com/tencent/mm/plugin/performance/diagnostic/b/b:eCi	()V
    //   69: getstatic 30	com/tencent/mm/plugin/performance/diagnostic/b/b:TAG	Ljava/lang/String;
    //   72: astore 6
    //   74: getstatic 89	com/tencent/mm/plugin/performance/diagnostic/b/b:ATO	Lcom/tencent/mm/vfs/o;
    //   77: astore 5
    //   79: aload 6
    //   81: ldc_w 586
    //   84: iconst_2
    //   85: anewarray 95	java/lang/Object
    //   88: dup
    //   89: iconst_0
    //   90: aload 5
    //   92: invokevirtual 589	com/tencent/mm/vfs/o:getName	()Ljava/lang/String;
    //   95: aastore
    //   96: dup
    //   97: iconst_1
    //   98: aload 5
    //   100: invokevirtual 592	com/tencent/mm/vfs/o:lastModified	()J
    //   103: invokestatic 595	com/tencent/mm/plugin/performance/c:HF	(J)Ljava/lang/String;
    //   106: aastore
    //   107: invokestatic 100	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   110: aload 5
    //   112: invokevirtual 180	com/tencent/mm/vfs/o:exists	()Z
    //   115: ifeq +76 -> 191
    //   118: new 597	java/io/BufferedReader
    //   121: dup
    //   122: new 599	java/io/InputStreamReader
    //   125: dup
    //   126: aload 5
    //   128: invokestatic 605	com/tencent/mm/vfs/s:ao	(Lcom/tencent/mm/vfs/o;)Ljava/io/InputStream;
    //   131: invokespecial 608	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   134: invokespecial 611	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   137: astore_3
    //   138: aload_3
    //   139: astore_2
    //   140: aload_3
    //   141: invokevirtual 614	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   144: astore 4
    //   146: aload 4
    //   148: ifnull +81 -> 229
    //   151: aload_3
    //   152: astore_2
    //   153: aload 6
    //   155: aload 4
    //   157: invokestatic 171	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: goto -22 -> 138
    //   163: astore 4
    //   165: aload_3
    //   166: astore_2
    //   167: aload 6
    //   169: aload 4
    //   171: ldc_w 262
    //   174: iconst_0
    //   175: anewarray 95	java/lang/Object
    //   178: invokestatic 162	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   181: aload_3
    //   182: invokestatic 620	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   185: aload 5
    //   187: invokevirtual 156	com/tencent/mm/vfs/o:delete	()Z
    //   190: pop
    //   191: aload 6
    //   193: ldc_w 622
    //   196: iconst_2
    //   197: anewarray 95	java/lang/Object
    //   200: dup
    //   201: iconst_0
    //   202: aload 5
    //   204: invokevirtual 589	com/tencent/mm/vfs/o:getName	()Ljava/lang/String;
    //   207: aastore
    //   208: dup
    //   209: iconst_1
    //   210: aload 5
    //   212: invokevirtual 592	com/tencent/mm/vfs/o:lastModified	()J
    //   215: invokestatic 595	com/tencent/mm/plugin/performance/c:HF	(J)Ljava/lang/String;
    //   218: aastore
    //   219: invokestatic 100	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   222: ldc_w 578
    //   225: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   228: return
    //   229: aload_3
    //   230: astore_2
    //   231: invokestatic 627	com/tencent/mm/sdk/platformtools/WeChatEnvironment:isMonkeyEnv	()Z
    //   234: ifne +27 -> 261
    //   237: aload_3
    //   238: astore_2
    //   239: invokestatic 630	com/tencent/mm/sdk/platformtools/WeChatEnvironment:hasDebugger	()Z
    //   242: ifne +19 -> 261
    //   245: aload_3
    //   246: astore_2
    //   247: getstatic 633	com/tencent/mm/sdk/platformtools/BuildInfo:IS_FLAVOR_RED	Z
    //   250: ifne +11 -> 261
    //   253: aload_3
    //   254: astore_2
    //   255: getstatic 636	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   258: ifeq +10 -> 268
    //   261: aload_3
    //   262: astore_2
    //   263: aload 5
    //   265: invokestatic 640	com/tencent/mm/plugin/performance/c:T	(Lcom/tencent/mm/vfs/o;)V
    //   268: aload_3
    //   269: invokestatic 620	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   272: aload 5
    //   274: invokevirtual 156	com/tencent/mm/vfs/o:delete	()Z
    //   277: pop
    //   278: goto -87 -> 191
    //   281: astore_3
    //   282: aconst_null
    //   283: astore_2
    //   284: aload_2
    //   285: invokestatic 620	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   288: aload 5
    //   290: invokevirtual 156	com/tencent/mm/vfs/o:delete	()Z
    //   293: pop
    //   294: ldc_w 578
    //   297: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   300: aload_3
    //   301: athrow
    //   302: astore_3
    //   303: goto -19 -> 284
    //   306: astore 4
    //   308: aconst_null
    //   309: astore_3
    //   310: goto -145 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	313	0	this	b
    //   0	313	1	paramBoolean	boolean
    //   139	146	2	localBufferedReader1	java.io.BufferedReader
    //   137	132	3	localBufferedReader2	java.io.BufferedReader
    //   281	20	3	localObject1	Object
    //   302	1	3	localObject2	Object
    //   309	1	3	localObject3	Object
    //   144	12	4	str1	String
    //   163	7	4	localIOException1	java.io.IOException
    //   306	1	4	localIOException2	java.io.IOException
    //   77	212	5	localo	o
    //   72	120	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   140	146	163	java/io/IOException
    //   153	160	163	java/io/IOException
    //   231	237	163	java/io/IOException
    //   239	245	163	java/io/IOException
    //   247	253	163	java/io/IOException
    //   255	261	163	java/io/IOException
    //   263	268	163	java/io/IOException
    //   118	138	281	finally
    //   140	146	302	finally
    //   153	160	302	finally
    //   167	181	302	finally
    //   231	237	302	finally
    //   239	245	302	finally
    //   247	253	302	finally
    //   255	261	302	finally
    //   263	268	302	finally
    //   118	138	306	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.b.b
 * JD-Core Version:    0.7.0.1
 */