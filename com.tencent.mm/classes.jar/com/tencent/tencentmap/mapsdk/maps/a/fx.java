package com.tencent.tencentmap.mapsdk.maps.a;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.BlockingQueue;

public class fx
  extends Thread
{
  private final BlockingQueue<gb<?>> a;
  private final fw b;
  private final ge c;
  private volatile boolean d = false;
  
  public fx(BlockingQueue<gb<?>> paramBlockingQueue, fw paramfw, ge paramge)
  {
    this.a = paramBlockingQueue;
    this.b = paramfw;
    this.c = paramge;
  }
  
  @TargetApi(14)
  private void a(gb<?> paramgb)
  {
    AppMethodBeat.i(147971);
    if (Build.VERSION.SDK_INT >= 14) {
      TrafficStats.setThreadStatsTag(paramgb.b());
    }
    AppMethodBeat.o(147971);
  }
  
  private void a(gb<?> paramgb, gi paramgi)
  {
    AppMethodBeat.i(147973);
    paramgi = paramgb.a(paramgi);
    this.c.a(paramgb, paramgi);
    AppMethodBeat.o(147973);
  }
  
  public void a()
  {
    AppMethodBeat.i(147970);
    this.d = true;
    interrupt();
    AppMethodBeat.o(147970);
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 83
    //   2: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: bipush 10
    //   7: invokestatic 88	android/os/Process:setThreadPriority	(I)V
    //   10: invokestatic 94	android/os/SystemClock:elapsedRealtime	()J
    //   13: lstore_1
    //   14: aload_0
    //   15: getfield 22	com/tencent/tencentmap/mapsdk/maps/a/fx:a	Ljava/util/concurrent/BlockingQueue;
    //   18: invokeinterface 100 1 0
    //   23: checkcast 48	com/tencent/tencentmap/mapsdk/maps/a/gb
    //   26: astore_3
    //   27: aload_3
    //   28: ldc 102
    //   30: invokevirtual 105	com/tencent/tencentmap/mapsdk/maps/a/gb:a	(Ljava/lang/String;)V
    //   33: aload_3
    //   34: invokevirtual 108	com/tencent/tencentmap/mapsdk/maps/a/gb:d	()Z
    //   37: ifeq +48 -> 85
    //   40: aload_3
    //   41: ldc 110
    //   43: invokevirtual 112	com/tencent/tencentmap/mapsdk/maps/a/gb:b	(Ljava/lang/String;)V
    //   46: goto -36 -> 10
    //   49: astore 4
    //   51: aload 4
    //   53: invokestatic 94	android/os/SystemClock:elapsedRealtime	()J
    //   56: lload_1
    //   57: lsub
    //   58: invokevirtual 115	com/tencent/tencentmap/mapsdk/maps/a/gi:a	(J)V
    //   61: aload_0
    //   62: aload_3
    //   63: aload 4
    //   65: invokespecial 116	com/tencent/tencentmap/mapsdk/maps/a/fx:a	(Lcom/tencent/tencentmap/mapsdk/maps/a/gb;Lcom/tencent/tencentmap/mapsdk/maps/a/gi;)V
    //   68: goto -58 -> 10
    //   71: astore_3
    //   72: aload_0
    //   73: getfield 20	com/tencent/tencentmap/mapsdk/maps/a/fx:d	Z
    //   76: ifeq -66 -> 10
    //   79: ldc 83
    //   81: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: return
    //   85: aload_0
    //   86: aload_3
    //   87: invokespecial 118	com/tencent/tencentmap/mapsdk/maps/a/fx:a	(Lcom/tencent/tencentmap/mapsdk/maps/a/gb;)V
    //   90: aload_0
    //   91: getfield 24	com/tencent/tencentmap/mapsdk/maps/a/fx:b	Lcom/tencent/tencentmap/mapsdk/maps/a/fw;
    //   94: aload_3
    //   95: invokeinterface 123 2 0
    //   100: astore 4
    //   102: aload_3
    //   103: ldc 125
    //   105: invokevirtual 105	com/tencent/tencentmap/mapsdk/maps/a/gb:a	(Ljava/lang/String;)V
    //   108: aload 4
    //   110: getfield 128	com/tencent/tencentmap/mapsdk/maps/a/fz:d	Z
    //   113: ifeq +76 -> 189
    //   116: aload_3
    //   117: invokevirtual 131	com/tencent/tencentmap/mapsdk/maps/a/gb:s	()Z
    //   120: ifeq +69 -> 189
    //   123: aload_3
    //   124: ldc 133
    //   126: invokevirtual 112	com/tencent/tencentmap/mapsdk/maps/a/gb:b	(Ljava/lang/String;)V
    //   129: goto -119 -> 10
    //   132: astore 4
    //   134: aload 4
    //   136: ldc 135
    //   138: iconst_1
    //   139: anewarray 137	java/lang/Object
    //   142: dup
    //   143: iconst_0
    //   144: aload 4
    //   146: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
    //   149: aastore
    //   150: invokestatic 146	com/tencent/tencentmap/mapsdk/maps/a/gj:a	(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   153: new 80	com/tencent/tencentmap/mapsdk/maps/a/gi
    //   156: dup
    //   157: aload 4
    //   159: invokespecial 149	com/tencent/tencentmap/mapsdk/maps/a/gi:<init>	(Ljava/lang/Throwable;)V
    //   162: astore 4
    //   164: aload 4
    //   166: invokestatic 94	android/os/SystemClock:elapsedRealtime	()J
    //   169: lload_1
    //   170: lsub
    //   171: invokevirtual 115	com/tencent/tencentmap/mapsdk/maps/a/gi:a	(J)V
    //   174: aload_0
    //   175: getfield 26	com/tencent/tencentmap/mapsdk/maps/a/fx:c	Lcom/tencent/tencentmap/mapsdk/maps/a/ge;
    //   178: aload_3
    //   179: aload 4
    //   181: invokeinterface 70 3 0
    //   186: goto -176 -> 10
    //   189: aload_3
    //   190: aload 4
    //   192: invokevirtual 152	com/tencent/tencentmap/mapsdk/maps/a/gb:a	(Lcom/tencent/tencentmap/mapsdk/maps/a/fz;)Lcom/tencent/tencentmap/mapsdk/maps/a/gd;
    //   195: astore 4
    //   197: aload_3
    //   198: ldc 154
    //   200: invokevirtual 105	com/tencent/tencentmap/mapsdk/maps/a/gb:a	(Ljava/lang/String;)V
    //   203: aload_3
    //   204: invokevirtual 157	com/tencent/tencentmap/mapsdk/maps/a/gb:r	()V
    //   207: aload_0
    //   208: getfield 26	com/tencent/tencentmap/mapsdk/maps/a/fx:c	Lcom/tencent/tencentmap/mapsdk/maps/a/ge;
    //   211: aload_3
    //   212: aload 4
    //   214: invokeinterface 160 3 0
    //   219: goto -209 -> 10
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	this	fx
    //   13	157	1	l	long
    //   26	37	3	localgb	gb
    //   71	141	3	localInterruptedException	java.lang.InterruptedException
    //   49	15	4	localgi	gi
    //   100	9	4	localfz	fz
    //   132	26	4	localException	java.lang.Exception
    //   162	51	4	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   27	46	49	com/tencent/tencentmap/mapsdk/maps/a/gi
    //   85	129	49	com/tencent/tencentmap/mapsdk/maps/a/gi
    //   189	219	49	com/tencent/tencentmap/mapsdk/maps/a/gi
    //   14	27	71	java/lang/InterruptedException
    //   27	46	132	java/lang/Exception
    //   85	129	132	java/lang/Exception
    //   189	219	132	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fx
 * JD-Core Version:    0.7.0.1
 */