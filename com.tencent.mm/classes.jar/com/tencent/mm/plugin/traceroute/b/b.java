package com.tencent.mm.plugin.traceroute.b;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class b
{
  public static List<Object> N(String[] paramArrayOfString)
  {
    AppMethodBeat.i(29672);
    String str = " ";
    int i = 0;
    while (i < 4)
    {
      localObject = paramArrayOfString[i];
      str = str + (String)localObject + " ";
      i += 1;
    }
    ac.i("MicroMsg.MMTraceRoute", str);
    Object localObject = new ArrayList();
    paramArrayOfString = new a(paramArrayOfString, (List)localObject);
    paramArrayOfString = com.tencent.e.h.JZN.aS(paramArrayOfString);
    try
    {
      paramArrayOfString.get(5000L, TimeUnit.MILLISECONDS);
      ac.i("MicroMsg.MMTraceRoute", "watcher thread stopped".concat(String.valueOf(str)));
      label112:
      AppMethodBeat.o(29672);
      return localObject;
    }
    catch (TimeoutException paramArrayOfString)
    {
      break label112;
    }
    catch (ExecutionException paramArrayOfString)
    {
      break label112;
    }
    catch (InterruptedException paramArrayOfString)
    {
      break label112;
    }
  }
  
  public static String axW(String paramString)
  {
    AppMethodBeat.i(29670);
    ac.i("MicroMsg.MMTraceRoute", "output string: ".concat(String.valueOf(paramString)));
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(29670);
      return null;
    }
    int i = paramString.indexOf("time=");
    if (i < 0)
    {
      AppMethodBeat.o(29670);
      return null;
    }
    i += 5;
    int j = paramString.indexOf(" ", i);
    if (j < 0)
    {
      AppMethodBeat.o(29670);
      return null;
    }
    paramString = paramString.substring(i, j);
    AppMethodBeat.o(29670);
    return paramString;
  }
  
  public static int axX(String paramString)
  {
    AppMethodBeat.i(29671);
    int i = paramString.indexOf("ttl=");
    if (i < 0)
    {
      AppMethodBeat.o(29671);
      return -1;
    }
    i += 4;
    int j = paramString.indexOf(" ", i);
    if (j < 0)
    {
      AppMethodBeat.o(29671);
      return -1;
    }
    i = bs.getInt(paramString.substring(i, j), 0);
    AppMethodBeat.o(29671);
    return i;
  }
  
  static final class a
    implements com.tencent.e.i.h
  {
    private String[] AhJ;
    private List<Object> lnk;
    
    public a(String[] paramArrayOfString, List<Object> paramList)
    {
      this.AhJ = paramArrayOfString;
      this.lnk = paramList;
    }
    
    public final String getKey()
    {
      return "MMTraceRouteCMDExecutor_watcher";
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: sipush 29669
      //   3: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: new 45	java/lang/StringBuilder
      //   9: dup
      //   10: invokespecial 46	java/lang/StringBuilder:<init>	()V
      //   13: astore 16
      //   15: new 48	java/lang/ProcessBuilder
      //   18: dup
      //   19: aload_0
      //   20: getfield 21	com/tencent/mm/plugin/traceroute/b/b$a:AhJ	[Ljava/lang/String;
      //   23: invokespecial 51	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
      //   26: astore 11
      //   28: aload 11
      //   30: iconst_1
      //   31: invokevirtual 55	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
      //   34: pop
      //   35: invokestatic 61	com/tencent/mm/sdk/platformtools/bs:eWj	()J
      //   38: lstore 9
      //   40: invokestatic 61	com/tencent/mm/sdk/platformtools/bs:eWj	()J
      //   43: lstore_1
      //   44: aload 11
      //   46: invokevirtual 65	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
      //   49: astore 11
      //   51: lload_1
      //   52: lstore_3
      //   53: lload_1
      //   54: lstore 5
      //   56: lload_1
      //   57: lstore 7
      //   59: aload 11
      //   61: invokevirtual 71	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
      //   64: invokestatic 75	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
      //   67: lload_1
      //   68: lstore_3
      //   69: lload_1
      //   70: lstore 5
      //   72: lload_1
      //   73: lstore 7
      //   75: invokestatic 61	com/tencent/mm/sdk/platformtools/bs:eWj	()J
      //   78: lstore_1
      //   79: lload_1
      //   80: lstore_3
      //   81: lload_1
      //   82: lstore 5
      //   84: lload_1
      //   85: lstore 7
      //   87: new 77	java/io/BufferedReader
      //   90: dup
      //   91: new 79	java/io/InputStreamReader
      //   94: dup
      //   95: aload 11
      //   97: invokevirtual 83	java/lang/Process:getInputStream	()Ljava/io/InputStream;
      //   100: invokespecial 86	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
      //   103: sipush 8096
      //   106: invokespecial 89	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
      //   109: astore 14
      //   111: aload 14
      //   113: astore 13
      //   115: aload 11
      //   117: astore 12
      //   119: aload 14
      //   121: invokevirtual 92	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   124: astore 15
      //   126: aload 15
      //   128: ifnull +128 -> 256
      //   131: aload 14
      //   133: astore 13
      //   135: aload 11
      //   137: astore 12
      //   139: aload 16
      //   141: aload 15
      //   143: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   146: pop
      //   147: goto -36 -> 111
      //   150: astore 15
      //   152: aload 14
      //   154: astore 13
      //   156: aload 11
      //   158: astore 12
      //   160: ldc 98
      //   162: new 45	java/lang/StringBuilder
      //   165: dup
      //   166: ldc 100
      //   168: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   171: aload 15
      //   173: invokevirtual 106	java/io/IOException:getMessage	()Ljava/lang/String;
      //   176: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   179: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   182: invokestatic 115	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   185: aload 11
      //   187: aload 14
      //   189: invokestatic 118	com/tencent/mm/plugin/traceroute/b/b:a	(Ljava/lang/Process;Ljava/io/BufferedReader;)V
      //   192: aload_0
      //   193: getfield 23	com/tencent/mm/plugin/traceroute/b/b$a:lnk	Ljava/util/List;
      //   196: aload 16
      //   198: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   201: invokeinterface 124 2 0
      //   206: pop
      //   207: aload_0
      //   208: getfield 23	com/tencent/mm/plugin/traceroute/b/b$a:lnk	Ljava/util/List;
      //   211: lload_1
      //   212: lload 9
      //   214: lsub
      //   215: invokestatic 130	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   218: invokeinterface 124 2 0
      //   223: pop
      //   224: ldc 98
      //   226: new 45	java/lang/StringBuilder
      //   229: dup
      //   230: ldc 132
      //   232: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   235: aload 16
      //   237: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   240: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   243: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   246: invokestatic 134	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   249: sipush 29669
      //   252: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   255: return
      //   256: aload 14
      //   258: astore 13
      //   260: aload 11
      //   262: astore 12
      //   264: aload 11
      //   266: invokevirtual 141	java/lang/Process:waitFor	()I
      //   269: pop
      //   270: aload 11
      //   272: aload 14
      //   274: invokestatic 118	com/tencent/mm/plugin/traceroute/b/b:a	(Ljava/lang/Process;Ljava/io/BufferedReader;)V
      //   277: goto -85 -> 192
      //   280: astore 15
      //   282: aconst_null
      //   283: astore 14
      //   285: aconst_null
      //   286: astore 11
      //   288: aload 14
      //   290: astore 13
      //   292: aload 11
      //   294: astore 12
      //   296: ldc 98
      //   298: new 45	java/lang/StringBuilder
      //   301: dup
      //   302: ldc 143
      //   304: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   307: aload 15
      //   309: invokevirtual 144	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
      //   312: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   315: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   318: invokestatic 115	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   321: aload 11
      //   323: aload 14
      //   325: invokestatic 118	com/tencent/mm/plugin/traceroute/b/b:a	(Ljava/lang/Process;Ljava/io/BufferedReader;)V
      //   328: goto -136 -> 192
      //   331: astore 15
      //   333: aconst_null
      //   334: astore 14
      //   336: aconst_null
      //   337: astore 11
      //   339: aload 14
      //   341: astore 13
      //   343: aload 11
      //   345: astore 12
      //   347: ldc 98
      //   349: new 45	java/lang/StringBuilder
      //   352: dup
      //   353: ldc 146
      //   355: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   358: aload 15
      //   360: invokevirtual 147	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   363: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   366: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   369: invokestatic 115	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   372: aload 11
      //   374: aload 14
      //   376: invokestatic 118	com/tencent/mm/plugin/traceroute/b/b:a	(Ljava/lang/Process;Ljava/io/BufferedReader;)V
      //   379: goto -187 -> 192
      //   382: astore 14
      //   384: aconst_null
      //   385: astore 13
      //   387: aconst_null
      //   388: astore 11
      //   390: aload 11
      //   392: aload 13
      //   394: invokestatic 118	com/tencent/mm/plugin/traceroute/b/b:a	(Ljava/lang/Process;Ljava/io/BufferedReader;)V
      //   397: sipush 29669
      //   400: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   403: aload 14
      //   405: athrow
      //   406: astore 14
      //   408: aconst_null
      //   409: astore 13
      //   411: goto -21 -> 390
      //   414: astore 14
      //   416: aload 12
      //   418: astore 11
      //   420: goto -30 -> 390
      //   423: astore 15
      //   425: aconst_null
      //   426: astore 14
      //   428: lload_3
      //   429: lstore_1
      //   430: goto -91 -> 339
      //   433: astore 15
      //   435: goto -96 -> 339
      //   438: astore 15
      //   440: aconst_null
      //   441: astore 14
      //   443: lload 5
      //   445: lstore_1
      //   446: goto -158 -> 288
      //   449: astore 15
      //   451: goto -163 -> 288
      //   454: astore 15
      //   456: aconst_null
      //   457: astore 14
      //   459: aconst_null
      //   460: astore 11
      //   462: goto -310 -> 152
      //   465: astore 15
      //   467: aconst_null
      //   468: astore 14
      //   470: lload 7
      //   472: lstore_1
      //   473: goto -321 -> 152
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	476	0	this	a
      //   43	430	1	l1	long
      //   52	377	3	l2	long
      //   54	390	5	l3	long
      //   57	414	7	l4	long
      //   38	175	9	l5	long
      //   26	435	11	localObject1	Object
      //   117	300	12	localObject2	Object
      //   113	297	13	localBufferedReader1	java.io.BufferedReader
      //   109	266	14	localBufferedReader2	java.io.BufferedReader
      //   382	22	14	localObject3	Object
      //   406	1	14	localObject4	Object
      //   414	1	14	localObject5	Object
      //   426	43	14	localObject6	Object
      //   124	18	15	str	String
      //   150	22	15	localIOException1	java.io.IOException
      //   280	28	15	localInterruptedException1	InterruptedException
      //   331	28	15	localException1	java.lang.Exception
      //   423	1	15	localException2	java.lang.Exception
      //   433	1	15	localException3	java.lang.Exception
      //   438	1	15	localInterruptedException2	InterruptedException
      //   449	1	15	localInterruptedException3	InterruptedException
      //   454	1	15	localIOException2	java.io.IOException
      //   465	1	15	localIOException3	java.io.IOException
      //   13	223	16	localStringBuilder	java.lang.StringBuilder
      // Exception table:
      //   from	to	target	type
      //   119	126	150	java/io/IOException
      //   139	147	150	java/io/IOException
      //   264	270	150	java/io/IOException
      //   44	51	280	java/lang/InterruptedException
      //   44	51	331	java/lang/Exception
      //   44	51	382	finally
      //   59	67	406	finally
      //   75	79	406	finally
      //   87	111	406	finally
      //   119	126	414	finally
      //   139	147	414	finally
      //   160	185	414	finally
      //   264	270	414	finally
      //   296	321	414	finally
      //   347	372	414	finally
      //   59	67	423	java/lang/Exception
      //   75	79	423	java/lang/Exception
      //   87	111	423	java/lang/Exception
      //   119	126	433	java/lang/Exception
      //   139	147	433	java/lang/Exception
      //   264	270	433	java/lang/Exception
      //   59	67	438	java/lang/InterruptedException
      //   75	79	438	java/lang/InterruptedException
      //   87	111	438	java/lang/InterruptedException
      //   119	126	449	java/lang/InterruptedException
      //   139	147	449	java/lang/InterruptedException
      //   264	270	449	java/lang/InterruptedException
      //   44	51	454	java/io/IOException
      //   59	67	465	java/io/IOException
      //   75	79	465	java/io/IOException
      //   87	111	465	java/io/IOException
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.b.b
 * JD-Core Version:    0.7.0.1
 */