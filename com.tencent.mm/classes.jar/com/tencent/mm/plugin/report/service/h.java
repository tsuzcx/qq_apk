package com.tencent.mm.plugin.report.service;

import android.content.Context;
import android.util.Pair;
import com.tencent.mars.Mars;
import com.tencent.mars.smc.IDKey;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.b.g;
import com.tencent.mm.f.a.qq;
import com.tencent.mm.plugin.report.a.c;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.protocal.protobuf.ai;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.JSONArray;

public enum h
  implements d
{
  private long IzF;
  private int IzG;
  public List<Pair<Long, Long>> IzH;
  private HashMap<String, Long> IzI;
  private int IzJ;
  private int IzK;
  private long IzL;
  private volatile boolean IzM;
  private int uin;
  
  static
  {
    AppMethodBeat.i(143908);
    IzE = new h("INSTANCE");
    IzN = new h[] { IzE };
    AppMethodBeat.o(143908);
  }
  
  private h()
  {
    AppMethodBeat.i(143875);
    this.IzF = 0L;
    this.IzH = new LinkedList();
    if (MMApplicationContext.isMMProcess())
    {
      com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143864);
          h.a(h.this);
          AppMethodBeat.o(143864);
        }
      });
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143865);
          h.b(h.this);
          AppMethodBeat.o(143865);
        }
      };
      EventCenter.instance.add(new IListener() {});
      com.tencent.mm.kernel.h.aGY().a(701, new i()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.q paramAnonymousq)
        {
          AppMethodBeat.i(143867);
          if (paramAnonymousInt1 != 0)
          {
            AppMethodBeat.o(143867);
            return;
          }
          com.tencent.mm.kernel.h.aHJ().postToWorkerDelayed(this.IzP, 5000L);
          AppMethodBeat.o(143867);
        }
      });
    }
    AppMethodBeat.o(143875);
  }
  
  public static Object a(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(143876);
    paramArrayOfInt = com.tencent.mm.plugin.report.f.a(paramInt1, paramArrayOfInt, paramInt2, paramInt3);
    AppMethodBeat.o(143876);
    return paramArrayOfInt;
  }
  
  private void a(String paramString, Callable<JSONArray> paramCallable)
  {
    AppMethodBeat.i(143903);
    long l = System.currentTimeMillis();
    if (!bo(paramString, l))
    {
      AppMethodBeat.o(143903);
      return;
    }
    ThreadPool.post(new h.7(this, paramCallable, paramString, l), "ReportManager_cLog");
    AppMethodBeat.o(143903);
  }
  
  private static void b(int paramInt1, int paramInt2, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(143879);
    KVReportDataInfo localKVReportDataInfo = new KVReportDataInfo();
    localKVReportDataInfo.fKh = paramInt1;
    localKVReportDataInfo.value = paramString;
    localKVReportDataInfo.fwf = paramInt2;
    localKVReportDataInfo.IyX = false;
    localKVReportDataInfo.Izq = paramBoolean1;
    localKVReportDataInfo.Izr = paramBoolean2;
    KVCommCrossProcessReceiver.a(localKVReportDataInfo);
    AppMethodBeat.o(143879);
  }
  
  private static void b(int paramInt, List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(143890);
    paramList = dt(paramList);
    if (MMApplicationContext.isMMProcess())
    {
      e.a(paramInt, paramList, paramBoolean, false, false);
      AppMethodBeat.o(143890);
      return;
    }
    c(paramInt, paramList, paramBoolean, false);
    AppMethodBeat.o(143890);
  }
  
  private boolean bo(String paramString, long paramLong)
  {
    AppMethodBeat.i(143905);
    if (WeChatEnvironment.hasDebugger())
    {
      Log.d("MicroMsg.cLog", "[%s] Sampling hit: (debug)", new Object[] { paramString });
      AppMethodBeat.o(143905);
      return true;
    }
    Long localLong;
    boolean bool;
    if (this.IzI != null)
    {
      localLong = (Long)this.IzI.get(paramString);
      if (localLong == null) {
        break label333;
      }
      localObject = g.V((paramString + this.uin + paramLong).getBytes());
      if ((localObject == null) || (localObject.length != 16)) {
        break label333;
      }
      paramLong = localObject[0] + localObject[4] + localObject[8] + localObject[12];
      long l1 = localObject[1] + localObject[5] + localObject[9] + localObject[13];
      long l2 = localObject[2] + localObject[6] + localObject[10] + localObject[14];
      int i = localObject[3];
      int j = localObject[7];
      int k = localObject[11];
      paramLong = paramLong & 0xFF | (l1 & 0xFF) << 8 | (l2 & 0xFF) << 16 | (localObject[15] + (i + j + k) & 0xFF) << 24;
      if (paramLong >= localLong.longValue()) {
        break label319;
      }
      bool = true;
      label261:
      if (!bool) {
        break label325;
      }
    }
    label319:
    label325:
    for (Object localObject = "hit";; localObject = "miss")
    {
      Log.d("MicroMsg.cLog", "[%s] Sampling %s: 0x%08x / 0x%08x", new Object[] { paramString, localObject, Long.valueOf(paramLong), localLong });
      AppMethodBeat.o(143905);
      return bool;
      localLong = null;
      break;
      bool = false;
      break label261;
    }
    label333:
    Log.d("MicroMsg.cLog", "[%s] Sampling hit: (default)", new Object[] { paramString });
    AppMethodBeat.o(143905);
    return true;
  }
  
  public static void c(int paramInt1, int paramInt2, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(194452);
    if (MMApplicationContext.isMMProcess())
    {
      if (c.IyE)
      {
        long l1 = paramInt1;
        long l2 = paramInt2;
        paramBoolean1 = c.IyF;
        e.a(l1, l2, paramString, paramBoolean1, paramBoolean1, paramBoolean2);
        AppMethodBeat.o(194452);
        return;
      }
      e.a(paramInt1, paramInt2, paramString, paramBoolean1, false, paramBoolean2);
      AppMethodBeat.o(194452);
      return;
    }
    b(paramInt1, paramInt2, paramString, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(194452);
  }
  
  private static void c(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(143880);
    KVReportDataInfo localKVReportDataInfo = new KVReportDataInfo();
    localKVReportDataInfo.fKh = paramInt;
    localKVReportDataInfo.value = paramString;
    localKVReportDataInfo.fwf = 0L;
    localKVReportDataInfo.IyX = false;
    localKVReportDataInfo.Izq = paramBoolean1;
    localKVReportDataInfo.Izr = paramBoolean2;
    KVCommCrossProcessReceiver.a(localKVReportDataInfo);
    AppMethodBeat.o(143880);
  }
  
  public static void d(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(143884);
    if (MMApplicationContext.isMMProcess())
    {
      if (c.IyE)
      {
        long l = paramInt;
        paramBoolean1 = c.IyF;
        e.a(l, paramString, paramBoolean1, paramBoolean1, paramBoolean2);
        AppMethodBeat.o(143884);
        return;
      }
      e.a(paramInt, paramString, paramBoolean1, false, paramBoolean2);
      AppMethodBeat.o(143884);
      return;
    }
    c(paramInt, paramString, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(143884);
  }
  
  private static String dt(List<String> paramList)
  {
    AppMethodBeat.i(143878);
    if ((paramList == null) || (paramList.isEmpty())) {
      Log.w("MicroMsg.ReportManagerKvCheck", "vals is null, use '' as value");
    }
    StringBuilder localStringBuilder;
    for (paramList = "";; paramList = localStringBuilder.toString())
    {
      AppMethodBeat.o(143878);
      return paramList;
      localStringBuilder = new StringBuilder();
      int j = paramList.size() - 1;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append((String)paramList.get(i)).append(',');
        i += 1;
      }
      localStringBuilder.append((String)paramList.get(j));
    }
  }
  
  public static void fBD()
  {
    AppMethodBeat.i(143899);
    if (MMApplicationContext.isMMProcess()) {
      Mars.onSingalCrash(0);
    }
    AppMethodBeat.o(143899);
  }
  
  private static void o(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(143881);
    StIDKeyDataInfo localStIDKeyDataInfo = new StIDKeyDataInfo();
    localStIDKeyDataInfo.rJY = paramLong1;
    localStIDKeyDataInfo.key = paramLong2;
    localStIDKeyDataInfo.value = paramLong3;
    localStIDKeyDataInfo.IyX = false;
    KVCommCrossProcessReceiver.a(localStIDKeyDataInfo);
    AppMethodBeat.o(143881);
  }
  
  public static String u(Object... paramVarArgs)
  {
    int i = 0;
    AppMethodBeat.i(143877);
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0))
    {
      Log.w("MicroMsg.ReportManagerKvCheck", "vals is null, use '' as value");
      paramVarArgs = "";
    }
    for (;;)
    {
      AppMethodBeat.o(143877);
      return paramVarArgs;
      if (paramVarArgs.length == 1)
      {
        paramVarArgs = String.valueOf(paramVarArgs[0]);
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        int j = paramVarArgs.length - 1;
        while (i < j)
        {
          localStringBuilder.append(String.valueOf(paramVarArgs[i]).replace(',', ' ')).append(',');
          i += 1;
        }
        localStringBuilder.append(String.valueOf(paramVarArgs[j]));
        paramVarArgs = localStringBuilder.toString();
      }
    }
  }
  
  public static void u(int paramInt, List<String> paramList)
  {
    AppMethodBeat.i(143889);
    if (c.IyE)
    {
      b(paramInt, paramList, c.IyF);
      AppMethodBeat.o(143889);
      return;
    }
    b(paramInt, paramList, false);
    AppMethodBeat.o(143889);
  }
  
  public final void B(String paramString, final List<String> paramList)
  {
    AppMethodBeat.i(143902);
    a(paramString, new Callable() {});
    AppMethodBeat.o(143902);
  }
  
  public final void F(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(293041);
    p(paramLong1, paramLong2, 1L);
    AppMethodBeat.o(293041);
  }
  
  public final void PJ(long paramLong)
  {
    AppMethodBeat.i(194455);
    synchronized (this.IzH)
    {
      this.IzH.add(new Pair(Long.valueOf(1570L), Long.valueOf(paramLong)));
      AppMethodBeat.o(194455);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean)
  {
    AppMethodBeat.i(143896);
    IDKey localIDKey1 = new IDKey();
    localIDKey1.SetID(paramInt1);
    localIDKey1.SetKey(paramInt3);
    localIDKey1.SetValue(paramInt5);
    IDKey localIDKey2 = new IDKey();
    localIDKey2.SetID(paramInt2);
    localIDKey2.SetKey(paramInt4);
    localIDKey2.SetValue(paramInt6);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localIDKey1);
    localArrayList.add(localIDKey2);
    b(localArrayList, paramBoolean);
    AppMethodBeat.o(143896);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(194451);
    if (MMApplicationContext.isMMProcess())
    {
      if (c.IyE)
      {
        long l1 = paramInt1;
        long l2 = paramInt2;
        paramBoolean1 = c.IyF;
        e.a(l1, l2, paramString, paramBoolean1, paramBoolean1, false);
        AppMethodBeat.o(194451);
        return;
      }
      e.a(paramInt1, paramInt2, paramString, paramBoolean1, false, false);
      AppMethodBeat.o(194451);
      return;
    }
    b(paramInt1, paramInt2, paramString, paramBoolean1, false);
    AppMethodBeat.o(194451);
  }
  
  public final void a(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    AppMethodBeat.i(194453);
    a(paramInt1, paramInt2, u(paramVarArgs), false, false);
    AppMethodBeat.o(194453);
  }
  
  public final void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Object... paramVarArgs)
  {
    AppMethodBeat.i(194449);
    d(paramInt, u(paramVarArgs), paramBoolean1, paramBoolean3);
    AppMethodBeat.o(194449);
  }
  
  public final void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, Object... paramVarArgs)
  {
    AppMethodBeat.i(143887);
    paramVarArgs = u(paramVarArgs);
    if (CrashReportFactory.hasDebuger()) {
      Log.v("MicroMsg.ReportManagerKvCheck", "kvTypedStat id:%d [%b,%b] val:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Boolean.FALSE, paramVarArgs });
    }
    if (MMApplicationContext.isMMProcess())
    {
      e.a(paramInt, paramVarArgs, paramBoolean1, false, false);
      AppMethodBeat.o(143887);
      return;
    }
    c(paramInt, paramVarArgs, paramBoolean1, false);
    AppMethodBeat.o(143887);
  }
  
  public final void a(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143886);
    if (c.IyE)
    {
      boolean bool = c.IyF;
      a(paramInt, bool, bool, paramVarArgs);
      AppMethodBeat.o(143886);
      return;
    }
    a(paramInt, false, false, paramVarArgs);
    AppMethodBeat.o(143886);
  }
  
  public final void aA(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(143898);
    IDKey localIDKey1 = new IDKey();
    localIDKey1.SetID(paramInt1);
    localIDKey1.SetKey(paramInt2);
    localIDKey1.SetValue(1L);
    IDKey localIDKey2 = new IDKey();
    localIDKey2.SetID(paramInt1);
    localIDKey2.SetKey(paramInt3);
    localIDKey2.SetValue(1L);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localIDKey1);
    localArrayList.add(localIDKey2);
    b(localArrayList, false);
    AppMethodBeat.o(143898);
  }
  
  public final void b(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(143883);
    if (MMApplicationContext.isMMProcess())
    {
      if (c.IyE)
      {
        long l = paramInt;
        paramBoolean1 = c.IyF;
        e.a(l, paramString, paramBoolean1, paramBoolean1, false);
        AppMethodBeat.o(143883);
        return;
      }
      e.a(paramInt, paramString, paramBoolean1, false, false);
      AppMethodBeat.o(143883);
      return;
    }
    c(paramInt, paramString, paramBoolean1, false);
    AppMethodBeat.o(143883);
  }
  
  public final void b(ArrayList<IDKey> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(143895);
    if (paramArrayList == null)
    {
      Log.e("MicroMsg.ReportManagerKvCheck", "report idkeyGroupStat lstIdKeyDataInfos == null return");
      AppMethodBeat.o(143895);
      return;
    }
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      IDKey localIDKey = (IDKey)localIterator.next();
      if (localIDKey == null)
      {
        Log.e("MicroMsg.ReportManagerKvCheck", "report idkeyGroupStat info == null return");
        AppMethodBeat.o(143895);
        return;
      }
      if ((localIDKey.GetID() < 0L) || (localIDKey.GetKey() < 0L) || (localIDKey.GetValue() <= 0L))
      {
        Log.e("MicroMsg.ReportManagerKvCheck", "report idkeyGroupStat ID %d, key %d, value %d <0", new Object[] { Long.valueOf(localIDKey.GetID()), Long.valueOf(localIDKey.GetKey()), Long.valueOf(localIDKey.GetValue()) });
        AppMethodBeat.o(143895);
        return;
      }
    }
    if (MMApplicationContext.isMMProcess())
    {
      e.f(paramArrayList, false);
      AppMethodBeat.o(143895);
      return;
    }
    KVCommCrossProcessReceiver.aU(paramArrayList);
    AppMethodBeat.o(143895);
  }
  
  public final void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(143897);
    IDKey localIDKey1 = new IDKey();
    localIDKey1.SetID(paramInt1);
    localIDKey1.SetKey(paramInt2);
    localIDKey1.SetValue(paramInt4);
    IDKey localIDKey2 = new IDKey();
    localIDKey2.SetID(paramInt1);
    localIDKey2.SetKey(paramInt3);
    localIDKey2.SetValue(1L);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localIDKey1);
    localArrayList.add(localIDKey2);
    b(localArrayList, false);
    AppMethodBeat.o(143897);
  }
  
  /* Error */
  public final boolean c(int paramInt, com.tencent.mm.cd.a parama)
  {
    // Byte code:
    //   0: ldc_w 632
    //   3: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: invokevirtual 636	java/lang/Object:getClass	()Ljava/lang/Class;
    //   10: ldc_w 638
    //   13: invokevirtual 644	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   16: aload_2
    //   17: ldc_w 645
    //   20: invokevirtual 651	java/lang/reflect/Field:setInt	(Ljava/lang/Object;I)V
    //   23: invokestatic 656	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   26: lstore_3
    //   27: lload_3
    //   28: ldc2_w 657
    //   31: ldiv
    //   32: aload_0
    //   33: getfield 72	com/tencent/mm/plugin/report/service/h:IzF	J
    //   36: lcmp
    //   37: ifeq +35 -> 72
    //   40: new 660	java/text/SimpleDateFormat
    //   43: dup
    //   44: ldc_w 662
    //   47: invokespecial 663	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   50: astore 8
    //   52: aload_0
    //   53: aload 8
    //   55: new 665	java/util/Date
    //   58: dup
    //   59: invokespecial 666	java/util/Date:<init>	()V
    //   62: invokevirtual 670	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   65: iconst_0
    //   66: invokestatic 674	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   69: putfield 676	com/tencent/mm/plugin/report/service/h:IzG	I
    //   72: aload_2
    //   73: invokevirtual 636	java/lang/Object:getClass	()Ljava/lang/Class;
    //   76: ldc_w 678
    //   79: invokevirtual 644	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   82: aload_2
    //   83: aload_0
    //   84: getfield 676	com/tencent/mm/plugin/report/service/h:IzG	I
    //   87: invokevirtual 651	java/lang/reflect/Field:setInt	(Ljava/lang/Object;I)V
    //   90: aload_0
    //   91: getfield 379	com/tencent/mm/plugin/report/service/h:uin	I
    //   94: i2l
    //   95: lstore 5
    //   97: aload_2
    //   98: invokevirtual 636	java/lang/Object:getClass	()Ljava/lang/Class;
    //   101: ldc_w 680
    //   104: invokevirtual 644	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   107: aload_2
    //   108: lload 5
    //   110: ldc2_w 212
    //   113: land
    //   114: invokevirtual 684	java/lang/reflect/Field:setLong	(Ljava/lang/Object;J)V
    //   117: aload_2
    //   118: invokevirtual 636	java/lang/Object:getClass	()Ljava/lang/Class;
    //   121: ldc_w 686
    //   124: invokevirtual 644	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   127: aload_2
    //   128: iconst_2
    //   129: invokevirtual 651	java/lang/reflect/Field:setInt	(Ljava/lang/Object;I)V
    //   132: aload_2
    //   133: invokevirtual 636	java/lang/Object:getClass	()Ljava/lang/Class;
    //   136: ldc_w 688
    //   139: invokevirtual 644	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   142: aload_2
    //   143: getstatic 693	com/tencent/mm/protocal/d:RAD	I
    //   146: invokevirtual 651	java/lang/reflect/Field:setInt	(Ljava/lang/Object;I)V
    //   149: aload_2
    //   150: invokevirtual 636	java/lang/Object:getClass	()Ljava/lang/Class;
    //   153: ldc_w 695
    //   156: invokevirtual 644	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   159: aload_2
    //   160: lload_3
    //   161: invokevirtual 684	java/lang/reflect/Field:setLong	(Ljava/lang/Object;J)V
    //   164: aload_2
    //   165: invokevirtual 700	com/tencent/mm/cd/a:toByteArray	()[B
    //   168: astore_2
    //   169: invokestatic 84	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMMProcess	()Z
    //   172: ifeq +119 -> 291
    //   175: getstatic 420	com/tencent/mm/plugin/report/a/c:IyE	Z
    //   178: ifeq +64 -> 242
    //   181: iload_1
    //   182: i2l
    //   183: lstore_3
    //   184: getstatic 423	com/tencent/mm/plugin/report/a/c:IyF	Z
    //   187: istore 7
    //   189: lload_3
    //   190: aload_2
    //   191: iload 7
    //   193: iload 7
    //   195: invokestatic 703	com/tencent/mm/plugin/report/service/e:a	(J[BZZ)V
    //   198: ldc_w 632
    //   201: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   204: iconst_1
    //   205: ireturn
    //   206: astore_2
    //   207: ldc_w 343
    //   210: ldc_w 705
    //   213: iconst_2
    //   214: anewarray 233	java/lang/Object
    //   217: dup
    //   218: iconst_0
    //   219: iload_1
    //   220: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   223: aastore
    //   224: dup
    //   225: iconst_1
    //   226: aload_2
    //   227: invokevirtual 706	java/lang/Exception:toString	()Ljava/lang/String;
    //   230: aastore
    //   231: invokestatic 619	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   234: ldc_w 632
    //   237: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   240: iconst_0
    //   241: ireturn
    //   242: iload_1
    //   243: i2l
    //   244: lstore_3
    //   245: lload_3
    //   246: aload_2
    //   247: iconst_0
    //   248: iconst_0
    //   249: invokestatic 703	com/tencent/mm/plugin/report/service/e:a	(J[BZZ)V
    //   252: goto -54 -> 198
    //   255: astore_2
    //   256: ldc_w 343
    //   259: ldc_w 708
    //   262: iconst_2
    //   263: anewarray 233	java/lang/Object
    //   266: dup
    //   267: iconst_0
    //   268: iload_1
    //   269: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   272: aastore
    //   273: dup
    //   274: iconst_1
    //   275: aload_2
    //   276: invokevirtual 709	java/io/IOException:toString	()Ljava/lang/String;
    //   279: aastore
    //   280: invokestatic 619	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   283: ldc_w 632
    //   286: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: iconst_0
    //   290: ireturn
    //   291: ldc_w 343
    //   294: ldc_w 711
    //   297: invokestatic 713	com/tencent/mm/sdk/platformtools/Log:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   300: goto -102 -> 198
    //   303: astore 8
    //   305: goto -233 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	308	0	this	h
    //   0	308	1	paramInt	int
    //   0	308	2	parama	com.tencent.mm.cd.a
    //   26	220	3	l1	long
    //   95	14	5	l2	long
    //   187	7	7	bool	boolean
    //   50	4	8	localSimpleDateFormat	java.text.SimpleDateFormat
    //   303	1	8	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   6	52	206	java/lang/Exception
    //   72	164	206	java/lang/Exception
    //   164	181	255	java/io/IOException
    //   184	198	255	java/io/IOException
    //   245	252	255	java/io/IOException
    //   291	300	255	java/io/IOException
    //   52	72	303	java/lang/Exception
  }
  
  public final void e(String paramString1, final String paramString2, final Map<String, Object> paramMap)
  {
    AppMethodBeat.i(143901);
    a(paramString1, new Callable() {});
    AppMethodBeat.o(143901);
  }
  
  public final void el(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143893);
    p(paramInt1, paramInt2, 1L);
    AppMethodBeat.o(143893);
  }
  
  public final void idkeyStat(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    AppMethodBeat.i(143894);
    if ((paramLong1 < 0L) || (paramLong2 < 0L) || (paramLong3 <= 0L))
    {
      Log.e("MicroMsg.ReportManagerKvCheck", "ID %d, key %d, value %d <0", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
      AppMethodBeat.o(143894);
      return;
    }
    if (MMApplicationContext.isMMProcess())
    {
      e.b(paramLong1, paramLong2, paramLong3, false);
      AppMethodBeat.o(143894);
      return;
    }
    o(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(143894);
  }
  
  public final void kg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(293042);
    e(paramString1, paramString2, null);
    AppMethodBeat.o(293042);
  }
  
  public final void kvStat(int paramInt, String paramString)
  {
    AppMethodBeat.i(143882);
    if (c.IyE)
    {
      boolean bool = c.IyF;
      b(paramInt, paramString, bool, bool);
      AppMethodBeat.o(143882);
      return;
    }
    b(paramInt, paramString, false, false);
    AppMethodBeat.o(143882);
  }
  
  public final void p(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(143892);
    idkeyStat(paramLong1, paramLong2, paramLong3, false);
    AppMethodBeat.o(143892);
  }
  
  public final void setUin(int paramInt)
  {
    AppMethodBeat.i(143904);
    this.uin = paramInt;
    SmcLogic.setUin(paramInt);
    AppMethodBeat.o(143904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.h
 * JD-Core Version:    0.7.0.1
 */