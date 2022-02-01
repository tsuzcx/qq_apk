package com.tencent.mm.plugin.trafficmonitor;

import com.tencent.matrix.d.b;
import com.tencent.matrix.d.c;
import com.tencent.matrix.report.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.traffic.TrafficPlugin;
import com.tencent.matrix.traffic.a;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class d
{
  private static boolean Hjt = false;
  private static TrafficPlugin TRX;
  private static a fiG;
  
  /* Error */
  public static void a(android.app.Application paramApplication, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 34
    //   5: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 36
    //   10: new 38	java/lang/StringBuilder
    //   13: dup
    //   14: ldc 40
    //   16: invokespecial 44	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   19: getstatic 31	com/tencent/mm/plugin/trafficmonitor/d:Hjt	Z
    //   22: invokevirtual 48	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   25: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 57	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: getstatic 31	com/tencent/mm/plugin/trafficmonitor/d:Hjt	Z
    //   34: ifeq +12 -> 46
    //   37: ldc 34
    //   39: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: ldc 2
    //   44: monitorexit
    //   45: return
    //   46: iconst_1
    //   47: putstatic 31	com/tencent/mm/plugin/trafficmonitor/d:Hjt	Z
    //   50: new 59	com/tencent/matrix/traffic/a
    //   53: dup
    //   54: invokespecial 61	com/tencent/matrix/traffic/a:<init>	()V
    //   57: astore 5
    //   59: aload 5
    //   61: putstatic 63	com/tencent/mm/plugin/trafficmonitor/d:fiG	Lcom/tencent/matrix/traffic/a;
    //   64: aload 5
    //   66: iconst_1
    //   67: putfield 66	com/tencent/matrix/traffic/a:fiA	Z
    //   70: getstatic 63	com/tencent/mm/plugin/trafficmonitor/d:fiG	Lcom/tencent/matrix/traffic/a;
    //   73: iload_1
    //   74: putfield 69	com/tencent/matrix/traffic/a:fiB	Z
    //   77: getstatic 63	com/tencent/mm/plugin/trafficmonitor/d:fiG	Lcom/tencent/matrix/traffic/a;
    //   80: iload_2
    //   81: putfield 72	com/tencent/matrix/traffic/a:fiC	Z
    //   84: getstatic 63	com/tencent/mm/plugin/trafficmonitor/d:fiG	Lcom/tencent/matrix/traffic/a;
    //   87: iload_3
    //   88: putfield 75	com/tencent/matrix/traffic/a:fiD	Z
    //   91: getstatic 63	com/tencent/mm/plugin/trafficmonitor/d:fiG	Lcom/tencent/matrix/traffic/a;
    //   94: iload 4
    //   96: putfield 78	com/tencent/matrix/traffic/a:fiE	Z
    //   99: getstatic 63	com/tencent/mm/plugin/trafficmonitor/d:fiG	Lcom/tencent/matrix/traffic/a;
    //   102: ldc 80
    //   104: invokevirtual 83	com/tencent/matrix/traffic/a:ho	(Ljava/lang/String;)V
    //   107: getstatic 63	com/tencent/mm/plugin/trafficmonitor/d:fiG	Lcom/tencent/matrix/traffic/a;
    //   110: ldc 85
    //   112: invokevirtual 83	com/tencent/matrix/traffic/a:ho	(Ljava/lang/String;)V
    //   115: getstatic 63	com/tencent/mm/plugin/trafficmonitor/d:fiG	Lcom/tencent/matrix/traffic/a;
    //   118: ldc 87
    //   120: invokevirtual 83	com/tencent/matrix/traffic/a:ho	(Ljava/lang/String;)V
    //   123: getstatic 63	com/tencent/mm/plugin/trafficmonitor/d:fiG	Lcom/tencent/matrix/traffic/a;
    //   126: ldc 89
    //   128: invokevirtual 83	com/tencent/matrix/traffic/a:ho	(Ljava/lang/String;)V
    //   131: getstatic 63	com/tencent/mm/plugin/trafficmonitor/d:fiG	Lcom/tencent/matrix/traffic/a;
    //   134: ldc 91
    //   136: invokevirtual 83	com/tencent/matrix/traffic/a:ho	(Ljava/lang/String;)V
    //   139: new 93	com/tencent/matrix/traffic/TrafficPlugin
    //   142: dup
    //   143: getstatic 63	com/tencent/mm/plugin/trafficmonitor/d:fiG	Lcom/tencent/matrix/traffic/a;
    //   146: invokespecial 96	com/tencent/matrix/traffic/TrafficPlugin:<init>	(Lcom/tencent/matrix/traffic/a;)V
    //   149: astore 5
    //   151: aload 5
    //   153: putstatic 98	com/tencent/mm/plugin/trafficmonitor/d:TRX	Lcom/tencent/matrix/traffic/TrafficPlugin;
    //   156: aload 5
    //   158: aload_0
    //   159: new 6	com/tencent/mm/plugin/trafficmonitor/d$1
    //   162: dup
    //   163: invokespecial 99	com/tencent/mm/plugin/trafficmonitor/d$1:<init>	()V
    //   166: invokevirtual 103	com/tencent/matrix/traffic/TrafficPlugin:init	(Landroid/app/Application;Lcom/tencent/matrix/d/c;)V
    //   169: getstatic 98	com/tencent/mm/plugin/trafficmonitor/d:TRX	Lcom/tencent/matrix/traffic/TrafficPlugin;
    //   172: invokevirtual 106	com/tencent/matrix/traffic/TrafficPlugin:start	()V
    //   175: ldc 36
    //   177: ldc 108
    //   179: invokestatic 57	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: getstatic 114	com/tencent/threadpool/h:ahAA	Lcom/tencent/threadpool/i;
    //   185: getstatic 120	com/tencent/mm/plugin/trafficmonitor/d$$ExternalSyntheticLambda0:INSTANCE	Lcom/tencent/mm/plugin/trafficmonitor/d$$ExternalSyntheticLambda0;
    //   188: lconst_0
    //   189: ldc2_w 121
    //   192: invokeinterface 128 6 0
    //   197: pop
    //   198: ldc 34
    //   200: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   203: goto -161 -> 42
    //   206: astore_0
    //   207: ldc 2
    //   209: monitorexit
    //   210: aload_0
    //   211: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	paramApplication	android.app.Application
    //   0	212	1	paramBoolean1	boolean
    //   0	212	2	paramBoolean2	boolean
    //   0	212	3	paramBoolean3	boolean
    //   0	212	4	paramBoolean4	boolean
    //   57	100	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	42	206	finally
    //   46	203	206	finally
  }
  
  private static void apk(int paramInt)
  {
    AppMethodBeat.i(260739);
    Log.i("MatrixTrafficCollector", "dumpTraffic = ".concat(String.valueOf(paramInt)));
    Object localObject2 = TrafficPlugin.nz(paramInt);
    Object localObject1 = "";
    long l1 = 0L;
    Object localObject3 = ((HashMap)localObject2).entrySet().iterator();
    Object localObject4;
    long l2;
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = (Map.Entry)((Iterator)localObject3).next();
      localObject2 = (String)((Map.Entry)localObject4).getKey();
      l2 = Long.parseLong((String)((Map.Entry)localObject4).getValue());
      if (l2 <= l1) {
        break label330;
      }
      l1 = l2;
      localObject1 = localObject2;
    }
    label330:
    for (;;)
    {
      Log.i("MatrixTrafficCollector", "getTraffic, type = %d, threadName = %s, traffic = %d", new Object[] { Integer.valueOf(paramInt), localObject2, Long.valueOf(l2) });
      break;
      localObject2 = "";
      localObject4 = TrafficPlugin.aAh().entrySet().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject4).next();
        String str = (String)((Map.Entry)localObject3).getKey();
        localObject3 = (String)((Map.Entry)localObject3).getValue();
        if (str.equals(localObject1)) {
          localObject2 = localObject3;
        }
        Log.i("MatrixTrafficCollector", "getTraffic, type = %d, threadName = %s, traffic = %s", new Object[] { Integer.valueOf(paramInt), str, localObject3 });
      }
      Log.i("MatrixTrafficCollector", "evilThreadName = %s, traffic = %d, evilStackTrace = %s, type = %d", new Object[] { localObject1, Long.valueOf(l1), localObject2, Integer.valueOf(paramInt) });
      f.Ozc.b(24883, new Object[] { MMApplicationContext.getProcessName(), localObject1, Long.valueOf(l1), localObject2, Integer.valueOf(paramInt) });
      AppMethodBeat.o(260739);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.d
 * JD-Core Version:    0.7.0.1
 */