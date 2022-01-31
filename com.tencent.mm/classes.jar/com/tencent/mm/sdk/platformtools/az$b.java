package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Vector;

final class az$b
  extends Thread
{
  private int vas;
  
  private az$b(az paramaz)
  {
    super(paramaz.name);
    AppMethodBeat.i(52233);
    this.vas = 60;
    setPriority(paramaz.priority);
    paramaz.ypE.add(this);
    AppMethodBeat.o(52233);
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc 59
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 31	com/tencent/mm/sdk/platformtools/az$b:vas	I
    //   9: ifle +157 -> 166
    //   12: aload_0
    //   13: getfield 15	com/tencent/mm/sdk/platformtools/az$b:ypG	Lcom/tencent/mm/sdk/platformtools/az;
    //   16: getfield 63	com/tencent/mm/sdk/platformtools/az:lock	Ljava/lang/Object;
    //   19: astore_1
    //   20: aload_1
    //   21: monitorenter
    //   22: aload_0
    //   23: getfield 15	com/tencent/mm/sdk/platformtools/az$b:ypG	Lcom/tencent/mm/sdk/platformtools/az;
    //   26: getfield 67	com/tencent/mm/sdk/platformtools/az:cCv	Z
    //   29: ifeq +13 -> 42
    //   32: aload_0
    //   33: getfield 15	com/tencent/mm/sdk/platformtools/az$b:ypG	Lcom/tencent/mm/sdk/platformtools/az;
    //   36: getfield 63	com/tencent/mm/sdk/platformtools/az:lock	Ljava/lang/Object;
    //   39: invokevirtual 72	java/lang/Object:wait	()V
    //   42: aload_1
    //   43: monitorexit
    //   44: aload_0
    //   45: getfield 15	com/tencent/mm/sdk/platformtools/az$b:ypG	Lcom/tencent/mm/sdk/platformtools/az;
    //   48: getfield 76	com/tencent/mm/sdk/platformtools/az:ypC	Ljava/util/concurrent/LinkedBlockingQueue;
    //   51: ldc2_w 77
    //   54: getstatic 84	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   57: invokevirtual 90	java/util/concurrent/LinkedBlockingQueue:poll	(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
    //   60: checkcast 92	com/tencent/mm/sdk/platformtools/az$a
    //   63: astore_1
    //   64: aload_1
    //   65: ifnonnull +60 -> 125
    //   68: aload_0
    //   69: aload_0
    //   70: getfield 31	com/tencent/mm/sdk/platformtools/az$b:vas	I
    //   73: iconst_1
    //   74: isub
    //   75: putfield 31	com/tencent/mm/sdk/platformtools/az$b:vas	I
    //   78: goto -73 -> 5
    //   81: astore_2
    //   82: ldc 94
    //   84: aload_2
    //   85: ldc 96
    //   87: iconst_0
    //   88: anewarray 69	java/lang/Object
    //   91: invokestatic 102	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   94: goto -52 -> 42
    //   97: astore_2
    //   98: aload_1
    //   99: monitorexit
    //   100: ldc 59
    //   102: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aload_2
    //   106: athrow
    //   107: astore_1
    //   108: ldc 94
    //   110: aload_1
    //   111: ldc 96
    //   113: iconst_0
    //   114: anewarray 69	java/lang/Object
    //   117: invokestatic 102	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   120: aconst_null
    //   121: astore_1
    //   122: goto -58 -> 64
    //   125: aload_0
    //   126: bipush 60
    //   128: putfield 31	com/tencent/mm/sdk/platformtools/az$b:vas	I
    //   131: aload_1
    //   132: invokeinterface 106 1 0
    //   137: ifeq -132 -> 5
    //   140: aload_0
    //   141: getfield 15	com/tencent/mm/sdk/platformtools/az$b:ypG	Lcom/tencent/mm/sdk/platformtools/az;
    //   144: getfield 110	com/tencent/mm/sdk/platformtools/az:ypF	Lcom/tencent/mm/sdk/platformtools/ak;
    //   147: aload_0
    //   148: getfield 15	com/tencent/mm/sdk/platformtools/az$b:ypG	Lcom/tencent/mm/sdk/platformtools/az;
    //   151: getfield 110	com/tencent/mm/sdk/platformtools/az:ypF	Lcom/tencent/mm/sdk/platformtools/ak;
    //   154: iconst_0
    //   155: aload_1
    //   156: invokevirtual 116	com/tencent/mm/sdk/platformtools/ak:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   159: invokevirtual 120	com/tencent/mm/sdk/platformtools/ak:sendMessage	(Landroid/os/Message;)Z
    //   162: pop
    //   163: goto -158 -> 5
    //   166: aload_0
    //   167: getfield 15	com/tencent/mm/sdk/platformtools/az$b:ypG	Lcom/tencent/mm/sdk/platformtools/az;
    //   170: getfield 41	com/tencent/mm/sdk/platformtools/az:ypE	Ljava/util/Vector;
    //   173: aload_0
    //   174: invokevirtual 123	java/util/Vector:remove	(Ljava/lang/Object;)Z
    //   177: pop
    //   178: ldc 94
    //   180: new 125	java/lang/StringBuilder
    //   183: dup
    //   184: ldc 127
    //   186: invokespecial 128	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   189: aload_0
    //   190: getfield 15	com/tencent/mm/sdk/platformtools/az$b:ypG	Lcom/tencent/mm/sdk/platformtools/az;
    //   193: getfield 76	com/tencent/mm/sdk/platformtools/az:ypC	Ljava/util/concurrent/LinkedBlockingQueue;
    //   196: invokevirtual 132	java/util/concurrent/LinkedBlockingQueue:size	()I
    //   199: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   202: ldc 138
    //   204: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload_0
    //   208: getfield 15	com/tencent/mm/sdk/platformtools/az$b:ypG	Lcom/tencent/mm/sdk/platformtools/az;
    //   211: getfield 41	com/tencent/mm/sdk/platformtools/az:ypE	Ljava/util/Vector;
    //   214: invokevirtual 142	java/util/Vector:size	()I
    //   217: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   220: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 150	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: ldc 59
    //   228: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   231: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	this	b
    //   19	80	1	localObject1	java.lang.Object
    //   107	4	1	localException1	java.lang.Exception
    //   121	35	1	localObject2	java.lang.Object
    //   81	4	2	localException2	java.lang.Exception
    //   97	9	2	localObject3	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   22	42	81	java/lang/Exception
    //   22	42	97	finally
    //   42	44	97	finally
    //   82	94	97	finally
    //   98	100	97	finally
    //   44	64	107	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.az.b
 * JD-Core Version:    0.7.0.1
 */