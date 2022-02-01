package com.tencent.mm.wlogcat.b;

import android.content.Context;
import com.tencent.mars.xlog.Xlog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.y;
import com.tencent.mm.xlog.app.XLogSetup;
import java.io.File;

public final class a
{
  private static a agWo;
  private Runnable agWp;
  
  static
  {
    AppMethodBeat.i(231309);
    agWo = new a();
    AppMethodBeat.o(231309);
  }
  
  private a()
  {
    AppMethodBeat.i(231300);
    this.agWp = new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 22
        //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 34	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
        //   8: new 36	java/lang/StringBuilder
        //   11: dup
        //   12: ldc 38
        //   14: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   17: invokestatic 47	android/os/Process:myPid	()I
        //   20: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   23: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   26: invokevirtual 59	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
        //   29: astore_2
        //   30: new 61	java/io/InputStreamReader
        //   33: dup
        //   34: aload_2
        //   35: invokevirtual 67	java/lang/Process:getInputStream	()Ljava/io/InputStream;
        //   38: invokespecial 70	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
        //   41: astore 4
        //   43: new 72	java/io/BufferedReader
        //   46: dup
        //   47: aload 4
        //   49: invokespecial 75	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
        //   52: astore_1
        //   53: aload_1
        //   54: astore 7
        //   56: aload 4
        //   58: astore 6
        //   60: aload_2
        //   61: astore 5
        //   63: getstatic 81	com/tencent/mm/xlog/app/XLogSetup:isLogcatOpen	Ljava/lang/Boolean;
        //   66: invokevirtual 87	java/lang/Boolean:booleanValue	()Z
        //   69: ifne +96 -> 165
        //   72: aload_1
        //   73: astore 7
        //   75: aload 4
        //   77: astore 6
        //   79: aload_2
        //   80: astore 5
        //   82: aload_1
        //   83: invokevirtual 90	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   86: astore_3
        //   87: aload_3
        //   88: ifnull +77 -> 165
        //   91: aload_1
        //   92: astore 7
        //   94: aload 4
        //   96: astore 6
        //   98: aload_2
        //   99: astore 5
        //   101: ldc 92
        //   103: aload_3
        //   104: invokestatic 97	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   107: goto -54 -> 53
        //   110: astore_3
        //   111: aload_1
        //   112: astore 7
        //   114: aload 4
        //   116: astore 6
        //   118: aload_2
        //   119: astore 5
        //   121: ldc 92
        //   123: aload_3
        //   124: ldc 99
        //   126: iconst_0
        //   127: anewarray 4	java/lang/Object
        //   130: invokestatic 103	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   133: aload_2
        //   134: ifnull +7 -> 141
        //   137: aload_2
        //   138: invokevirtual 106	java/lang/Process:destroy	()V
        //   141: aload 4
        //   143: ifnull +8 -> 151
        //   146: aload 4
        //   148: invokevirtual 109	java/io/InputStreamReader:close	()V
        //   151: aload_1
        //   152: ifnull +7 -> 159
        //   155: aload_1
        //   156: invokevirtual 110	java/io/BufferedReader:close	()V
        //   159: ldc 22
        //   161: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   164: return
        //   165: aload_1
        //   166: astore 7
        //   168: aload 4
        //   170: astore 6
        //   172: aload_2
        //   173: astore 5
        //   175: ldc 92
        //   177: ldc 115
        //   179: invokestatic 97	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   182: aload_2
        //   183: ifnull +7 -> 190
        //   186: aload_2
        //   187: invokevirtual 106	java/lang/Process:destroy	()V
        //   190: aload 4
        //   192: invokevirtual 109	java/io/InputStreamReader:close	()V
        //   195: aload_1
        //   196: invokevirtual 110	java/io/BufferedReader:close	()V
        //   199: ldc 22
        //   201: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   204: return
        //   205: astore_1
        //   206: ldc 22
        //   208: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   211: return
        //   212: astore_1
        //   213: ldc 22
        //   215: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   218: return
        //   219: astore_1
        //   220: aconst_null
        //   221: astore_3
        //   222: aconst_null
        //   223: astore 4
        //   225: aconst_null
        //   226: astore_2
        //   227: aload_2
        //   228: ifnull +7 -> 235
        //   231: aload_2
        //   232: invokevirtual 106	java/lang/Process:destroy	()V
        //   235: aload 4
        //   237: ifnull +8 -> 245
        //   240: aload 4
        //   242: invokevirtual 109	java/io/InputStreamReader:close	()V
        //   245: aload_3
        //   246: ifnull +7 -> 253
        //   249: aload_3
        //   250: invokevirtual 110	java/io/BufferedReader:close	()V
        //   253: ldc 22
        //   255: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   258: aload_1
        //   259: athrow
        //   260: astore_2
        //   261: goto -8 -> 253
        //   264: astore_1
        //   265: aconst_null
        //   266: astore_3
        //   267: aconst_null
        //   268: astore 4
        //   270: goto -43 -> 227
        //   273: astore_1
        //   274: aconst_null
        //   275: astore_3
        //   276: goto -49 -> 227
        //   279: astore_1
        //   280: aload 7
        //   282: astore_3
        //   283: aload 6
        //   285: astore 4
        //   287: aload 5
        //   289: astore_2
        //   290: goto -63 -> 227
        //   293: astore_3
        //   294: aconst_null
        //   295: astore_1
        //   296: aconst_null
        //   297: astore 4
        //   299: aconst_null
        //   300: astore_2
        //   301: goto -190 -> 111
        //   304: astore_3
        //   305: aconst_null
        //   306: astore_1
        //   307: aconst_null
        //   308: astore 4
        //   310: goto -199 -> 111
        //   313: astore_3
        //   314: aconst_null
        //   315: astore_1
        //   316: goto -205 -> 111
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	319	0	this	1
        //   52	144	1	localBufferedReader1	java.io.BufferedReader
        //   205	1	1	localException1	java.lang.Exception
        //   212	1	1	localException2	java.lang.Exception
        //   219	40	1	localObject1	Object
        //   264	1	1	localObject2	Object
        //   273	1	1	localObject3	Object
        //   279	1	1	localObject4	Object
        //   295	21	1	localObject5	Object
        //   29	203	2	localProcess1	java.lang.Process
        //   260	1	2	localException3	java.lang.Exception
        //   289	12	2	localObject6	Object
        //   86	18	3	str	String
        //   110	14	3	localException4	java.lang.Exception
        //   221	62	3	localBufferedReader2	java.io.BufferedReader
        //   293	1	3	localException5	java.lang.Exception
        //   304	1	3	localException6	java.lang.Exception
        //   313	1	3	localException7	java.lang.Exception
        //   41	268	4	localObject7	Object
        //   61	227	5	localProcess2	java.lang.Process
        //   58	226	6	localObject8	Object
        //   54	227	7	localBufferedReader3	java.io.BufferedReader
        // Exception table:
        //   from	to	target	type
        //   63	72	110	java/lang/Exception
        //   82	87	110	java/lang/Exception
        //   101	107	110	java/lang/Exception
        //   175	182	110	java/lang/Exception
        //   186	190	205	java/lang/Exception
        //   190	199	205	java/lang/Exception
        //   137	141	212	java/lang/Exception
        //   146	151	212	java/lang/Exception
        //   155	159	212	java/lang/Exception
        //   5	30	219	finally
        //   231	235	260	java/lang/Exception
        //   240	245	260	java/lang/Exception
        //   249	253	260	java/lang/Exception
        //   30	43	264	finally
        //   43	53	273	finally
        //   63	72	279	finally
        //   82	87	279	finally
        //   101	107	279	finally
        //   121	133	279	finally
        //   175	182	279	finally
        //   5	30	293	java/lang/Exception
        //   30	43	304	java/lang/Exception
        //   43	53	313	java/lang/Exception
      }
    };
    AppMethodBeat.o(231300);
  }
  
  public static a jPP()
  {
    return agWo;
  }
  
  public final void jPQ()
  {
    AppMethodBeat.i(231318);
    y.bEp(MMApplicationContext.getContext().getFilesDir().getAbsolutePath() + "/crashFlag.live");
    if (Log.getImpl().getClass() != Xlog.class)
    {
      Log.e("MicroMsg.CrashLogcatCatcher", "impl is not xlog!");
      AppMethodBeat.o(231318);
      return;
    }
    Log.i("MicroMsg.CrashLogcatCatcher", "Log.consoleLogOpen:" + XLogSetup.isLogcatOpen);
    if (XLogSetup.isLogcatOpen.booleanValue())
    {
      AppMethodBeat.o(231318);
      return;
    }
    int i = ((c)h.ax(c.class)).a(c.a.yGo, 0);
    Log.i("MicroMsg.CrashLogcatCatcher", "is need work :".concat(String.valueOf(i)));
    if (i == 0)
    {
      AppMethodBeat.o(231318);
      return;
    }
    this.agWp.run();
    AppMethodBeat.o(231318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.wlogcat.b.a
 * JD-Core Version:    0.7.0.1
 */