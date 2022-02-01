package com.tencent.mm.plugin.traceroute.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  public static String Ahp;
  public static c Ahq;
  private final int Ahr;
  private boolean Ahs;
  f Aht;
  public Map<String, Set<Integer>> Ahu;
  public e Ahv;
  public d Ahw;
  public c Ahx;
  public b Ahy;
  private final String TAG;
  String userName;
  
  public a(String paramString)
  {
    AppMethodBeat.i(29663);
    this.TAG = "MicroMsg.MMTraceRoute";
    this.Ahr = 64;
    this.Ahs = false;
    this.Aht = new f((byte)0);
    this.Ahu = new HashMap();
    this.userName = paramString;
    Ahp = g.getExternalStorageDirectory().getAbsolutePath() + "/tencent/traceroute_log_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date()).toString() + ".log";
    AppMethodBeat.o(29663);
  }
  
  final void a(String paramString1, String paramString2, Integer paramInteger)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(29666);
        if ((paramString1 == null) || (paramString2 == null) || (paramInteger.intValue() < 0))
        {
          AppMethodBeat.o(29666);
          return;
        }
        if (!this.Aht.containsKey(paramString1))
        {
          ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
          localConcurrentHashMap.put(paramInteger, new StringBuilder(paramString2));
          this.Aht.put(paramString1, (ConcurrentHashMap)localConcurrentHashMap);
          AppMethodBeat.o(29666);
          continue;
        }
        if (!((ConcurrentHashMap)this.Aht.get(paramString1)).containsKey(paramInteger)) {
          break label147;
        }
      }
      finally {}
      ((StringBuilder)((ConcurrentHashMap)this.Aht.get(paramString1)).get(paramInteger)).append(paramString2);
      AppMethodBeat.o(29666);
      continue;
      label147:
      new ConcurrentHashMap().put(paramInteger, new StringBuilder(paramString2));
      ((ConcurrentHashMap)this.Aht.get(paramString1)).put(paramInteger, new StringBuilder(paramString2));
      AppMethodBeat.o(29666);
    }
  }
  
  public final void d(String[] paramArrayOfString, boolean paramBoolean)
  {
    AppMethodBeat.i(29665);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      ac.e("MicroMsg.MMTraceRoute", "no ip contains");
      AppMethodBeat.o(29665);
      return;
    }
    int i;
    label61:
    Object localObject2;
    String[] arrayOfString;
    if (paramBoolean)
    {
      localObject1 = "" + "long: ";
      int j = paramArrayOfString.length;
      i = 0;
      if (i >= j) {
        break label268;
      }
      localObject2 = paramArrayOfString[i];
      arrayOfString = ((String)localObject2).split(":");
      if ((arrayOfString != null) && (arrayOfString.length == 3)) {
        break label140;
      }
      ac.e("MicroMsg.MMTraceRoute", "err ip ".concat(String.valueOf(localObject2)));
    }
    for (;;)
    {
      i += 1;
      break label61;
      localObject1 = "" + "short: ";
      break;
      label140:
      if (!this.Ahu.containsKey(arrayOfString[0]))
      {
        localObject2 = new HashSet();
        ((Set)localObject2).add(Integer.valueOf(bs.getInt(arrayOfString[1], 0)));
        this.Ahu.put(arrayOfString[0], localObject2);
        localObject1 = (String)localObject1 + arrayOfString[0] + " ";
      }
      else
      {
        ((Set)this.Ahu.get(arrayOfString[0])).add(Integer.valueOf(bs.getInt(arrayOfString[1], 0)));
      }
    }
    label268:
    Object localObject1 = (String)localObject1 + "\n";
    paramArrayOfString = Ahp;
    localObject1 = ((String)localObject1).getBytes();
    i.e(paramArrayOfString, (byte[])localObject1, localObject1.length);
    AppMethodBeat.o(29665);
  }
  
  final boolean eeJ()
  {
    try
    {
      boolean bool = this.Ahs;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void eeK()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 29667
    //   5: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 82	com/tencent/mm/plugin/traceroute/b/a:Aht	Lcom/tencent/mm/plugin/traceroute/b/a$f;
    //   12: ifnull +616 -> 628
    //   15: aload_0
    //   16: getfield 82	com/tencent/mm/plugin/traceroute/b/a:Aht	Lcom/tencent/mm/plugin/traceroute/b/a$f;
    //   19: astore 6
    //   21: new 235	com/tencent/mm/vfs/e
    //   24: dup
    //   25: getstatic 133	com/tencent/mm/plugin/traceroute/b/a:Ahp	Ljava/lang/String;
    //   28: invokespecial 236	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   31: astore 4
    //   33: aload 4
    //   35: invokevirtual 239	com/tencent/mm/vfs/e:exists	()Z
    //   38: istore_3
    //   39: iload_3
    //   40: ifne +56 -> 96
    //   43: aload 4
    //   45: invokevirtual 242	com/tencent/mm/vfs/e:createNewFile	()Z
    //   48: pop
    //   49: getstatic 133	com/tencent/mm/plugin/traceroute/b/a:Ahp	Ljava/lang/String;
    //   52: astore 4
    //   54: new 91	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   61: aload 6
    //   63: getfield 246	com/tencent/mm/plugin/traceroute/b/a$f:AhA	Lcom/tencent/mm/plugin/traceroute/b/a;
    //   66: getfield 89	com/tencent/mm/plugin/traceroute/b/a:userName	Ljava/lang/String;
    //   69: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc 219
    //   74: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokevirtual 223	java/lang/String:getBytes	()[B
    //   83: astore 5
    //   85: aload 4
    //   87: aload 5
    //   89: aload 5
    //   91: arraylength
    //   92: invokestatic 228	com/tencent/mm/vfs/i:e	(Ljava/lang/String;[BI)I
    //   95: pop
    //   96: aload 6
    //   98: getfield 246	com/tencent/mm/plugin/traceroute/b/a$f:AhA	Lcom/tencent/mm/plugin/traceroute/b/a;
    //   101: getfield 82	com/tencent/mm/plugin/traceroute/b/a:Aht	Lcom/tencent/mm/plugin/traceroute/b/a$f;
    //   104: invokevirtual 250	com/tencent/mm/plugin/traceroute/b/a$f:entrySet	()Ljava/util/Set;
    //   107: invokeinterface 254 1 0
    //   112: astore 7
    //   114: aload 7
    //   116: invokeinterface 259 1 0
    //   121: ifeq +374 -> 495
    //   124: aload 7
    //   126: invokeinterface 263 1 0
    //   131: checkcast 265	java/util/Map$Entry
    //   134: invokeinterface 268 1 0
    //   139: checkcast 125	java/lang/String
    //   142: astore 8
    //   144: aload 8
    //   146: invokestatic 272	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   149: ifne -35 -> 114
    //   152: aload 6
    //   154: getfield 246	com/tencent/mm/plugin/traceroute/b/a$f:AhA	Lcom/tencent/mm/plugin/traceroute/b/a;
    //   157: getfield 82	com/tencent/mm/plugin/traceroute/b/a:Aht	Lcom/tencent/mm/plugin/traceroute/b/a$f;
    //   160: aload 8
    //   162: invokevirtual 148	com/tencent/mm/plugin/traceroute/b/a$f:containsKey	(Ljava/lang/Object;)Z
    //   165: ifeq -51 -> 114
    //   168: aload 6
    //   170: getfield 246	com/tencent/mm/plugin/traceroute/b/a$f:AhA	Lcom/tencent/mm/plugin/traceroute/b/a;
    //   173: getfield 82	com/tencent/mm/plugin/traceroute/b/a:Aht	Lcom/tencent/mm/plugin/traceroute/b/a$f;
    //   176: aload 8
    //   178: invokevirtual 163	com/tencent/mm/plugin/traceroute/b/a$f:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   181: checkcast 154	java/util/Map
    //   184: astore 9
    //   186: aload 9
    //   188: ifnull -74 -> 114
    //   191: ldc 176
    //   193: astore 4
    //   195: aload 9
    //   197: invokeinterface 275 1 0
    //   202: iconst_1
    //   203: if_icmpne +178 -> 381
    //   206: aload 9
    //   208: iconst_1
    //   209: invokestatic 209	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   212: invokeinterface 217 2 0
    //   217: ifnull +164 -> 381
    //   220: new 91	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   227: ldc 176
    //   229: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: aload 9
    //   234: iconst_1
    //   235: invokestatic 209	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   238: invokeinterface 217 2 0
    //   243: checkcast 91	java/lang/StringBuilder
    //   246: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: astore 5
    //   257: aload 5
    //   259: invokevirtual 278	java/lang/String:length	()I
    //   262: ifle -148 -> 114
    //   265: ldc 71
    //   267: new 91	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   274: aload 8
    //   276: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: aload 5
    //   281: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: invokestatic 280	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   290: getstatic 133	com/tencent/mm/plugin/traceroute/b/a:Ahp	Ljava/lang/String;
    //   293: astore 4
    //   295: aload 5
    //   297: invokevirtual 223	java/lang/String:getBytes	()[B
    //   300: astore 5
    //   302: aload 4
    //   304: aload 5
    //   306: aload 5
    //   308: arraylength
    //   309: invokestatic 228	com/tencent/mm/vfs/i:e	(Ljava/lang/String;[BI)I
    //   312: pop
    //   313: goto -199 -> 114
    //   316: astore 4
    //   318: aload_0
    //   319: monitorexit
    //   320: aload 4
    //   322: athrow
    //   323: astore 4
    //   325: ldc 71
    //   327: new 91	java/lang/StringBuilder
    //   330: dup
    //   331: ldc_w 282
    //   334: invokespecial 152	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   337: aload 4
    //   339: invokevirtual 285	java/io/IOException:getMessage	()Ljava/lang/String;
    //   342: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 174	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   351: ldc 71
    //   353: aload 4
    //   355: ldc 176
    //   357: iconst_0
    //   358: anewarray 4	java/lang/Object
    //   361: invokestatic 289	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   364: aload 6
    //   366: getfield 246	com/tencent/mm/plugin/traceroute/b/a$f:AhA	Lcom/tencent/mm/plugin/traceroute/b/a;
    //   369: invokevirtual 292	com/tencent/mm/plugin/traceroute/b/a:eeL	()V
    //   372: sipush 29667
    //   375: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   378: aload_0
    //   379: monitorexit
    //   380: return
    //   381: iconst_0
    //   382: istore_1
    //   383: iconst_0
    //   384: istore_2
    //   385: aload 4
    //   387: astore 5
    //   389: iload_1
    //   390: aload 9
    //   392: invokeinterface 275 1 0
    //   397: if_icmpge -140 -> 257
    //   400: aload 4
    //   402: astore 5
    //   404: iload_2
    //   405: ifne -148 -> 257
    //   408: aload 9
    //   410: iload_1
    //   411: invokestatic 209	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   414: invokeinterface 217 2 0
    //   419: ifnull +218 -> 637
    //   422: aload 9
    //   424: iload_1
    //   425: invokestatic 209	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   428: invokeinterface 217 2 0
    //   433: checkcast 91	java/lang/StringBuilder
    //   436: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   439: astore 10
    //   441: aload 10
    //   443: invokestatic 272	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   446: ifne +191 -> 637
    //   449: new 91	java/lang/StringBuilder
    //   452: dup
    //   453: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   456: aload 4
    //   458: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: aload 10
    //   463: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: astore 5
    //   471: aload 5
    //   473: astore 4
    //   475: aload 10
    //   477: ldc_w 294
    //   480: invokevirtual 298	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   483: ifeq +154 -> 637
    //   486: iconst_1
    //   487: istore_2
    //   488: aload 5
    //   490: astore 4
    //   492: goto +145 -> 637
    //   495: getstatic 133	com/tencent/mm/plugin/traceroute/b/a:Ahp	Ljava/lang/String;
    //   498: iconst_0
    //   499: iconst_m1
    //   500: invokestatic 302	com/tencent/mm/vfs/i:aU	(Ljava/lang/String;II)[B
    //   503: astore 5
    //   505: aload 5
    //   507: invokestatic 306	com/tencent/mm/sdk/platformtools/bs:cv	([B)Z
    //   510: ifeq +28 -> 538
    //   513: ldc 71
    //   515: ldc_w 308
    //   518: invokestatic 174	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   521: aload 6
    //   523: getfield 246	com/tencent/mm/plugin/traceroute/b/a$f:AhA	Lcom/tencent/mm/plugin/traceroute/b/a;
    //   526: invokevirtual 292	com/tencent/mm/plugin/traceroute/b/a:eeL	()V
    //   529: sipush 29667
    //   532: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   535: goto -157 -> 378
    //   538: aload 5
    //   540: arraylength
    //   541: istore_1
    //   542: ldc_w 310
    //   545: iconst_2
    //   546: anewarray 4	java/lang/Object
    //   549: dup
    //   550: iconst_0
    //   551: getstatic 315	com/tencent/mm/protocal/d:DIc	I
    //   554: invokestatic 209	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   557: aastore
    //   558: dup
    //   559: iconst_1
    //   560: iload_1
    //   561: invokestatic 209	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   564: aastore
    //   565: invokestatic 318	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   568: invokevirtual 223	java/lang/String:getBytes	()[B
    //   571: invokestatic 324	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   574: invokevirtual 327	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   577: astore 4
    //   579: aload 5
    //   581: invokestatic 333	com/tencent/mm/b/s:compress	([B)[B
    //   584: astore 5
    //   586: new 335	com/tencent/mm/pointers/PByteArray
    //   589: dup
    //   590: invokespecial 336	com/tencent/mm/pointers/PByteArray:<init>	()V
    //   593: astore 7
    //   595: aload 7
    //   597: aload 5
    //   599: aload 4
    //   601: invokevirtual 223	java/lang/String:getBytes	()[B
    //   604: invokestatic 341	com/tencent/mm/b/c:a	(Lcom/tencent/mm/pointers/PByteArray;[B[B)I
    //   607: pop
    //   608: new 24	com/tencent/mm/plugin/traceroute/b/a$f$1
    //   611: dup
    //   612: aload 6
    //   614: iload_1
    //   615: aload 4
    //   617: aload 7
    //   619: invokespecial 344	com/tencent/mm/plugin/traceroute/b/a$f$1:<init>	(Lcom/tencent/mm/plugin/traceroute/b/a$f;ILjava/lang/String;Lcom/tencent/mm/pointers/PByteArray;)V
    //   622: ldc_w 346
    //   625: invokestatic 351	com/tencent/mm/sdk/g/b:c	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   628: sipush 29667
    //   631: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   634: goto -256 -> 378
    //   637: iload_1
    //   638: iconst_1
    //   639: iadd
    //   640: istore_1
    //   641: goto -256 -> 385
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	644	0	this	a
    //   382	259	1	i	int
    //   384	104	2	j	int
    //   38	2	3	bool	boolean
    //   31	272	4	localObject1	Object
    //   316	5	4	localObject2	Object
    //   323	134	4	localIOException	java.io.IOException
    //   473	143	4	localObject3	Object
    //   83	515	5	localObject4	Object
    //   19	594	6	localf	f
    //   112	506	7	localObject5	Object
    //   142	133	8	str1	String
    //   184	239	9	localMap	Map
    //   439	37	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   2	39	316	finally
    //   43	96	316	finally
    //   96	114	316	finally
    //   114	186	316	finally
    //   195	257	316	finally
    //   257	313	316	finally
    //   325	378	316	finally
    //   389	400	316	finally
    //   408	471	316	finally
    //   475	486	316	finally
    //   495	535	316	finally
    //   538	628	316	finally
    //   628	634	316	finally
    //   43	96	323	java/io/IOException
  }
  
  final void eeL()
  {
    AppMethodBeat.i(29668);
    if (this.Ahy != null) {
      this.Ahy.eeM();
    }
    AppMethodBeat.o(29668);
  }
  
  final void sg(boolean paramBoolean)
  {
    try
    {
      this.Ahs = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(29664);
    sg(true);
    if (Ahq != null) {
      try
      {
        Ahq.shutdownNow();
        AppMethodBeat.o(29664);
        return;
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.MMTraceRoute", "failed to shutdown threadpool: " + localException.getMessage());
      }
    }
    AppMethodBeat.o(29664);
  }
  
  final class a
    implements Runnable
  {
    private Set<Integer> Ahz;
    private String ip;
    
    public a(Set<Integer> paramSet)
    {
      this.ip = paramSet;
      Object localObject;
      this.Ahz = localObject;
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: sipush 29656
      //   3: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: ldc 45
      //   8: iconst_1
      //   9: anewarray 4	java/lang/Object
      //   12: dup
      //   13: iconst_0
      //   14: aload_0
      //   15: getfield 25	com/tencent/mm/plugin/traceroute/b/a$a:ip	Ljava/lang/String;
      //   18: aastore
      //   19: invokestatic 51	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   22: astore 6
      //   24: aload_0
      //   25: getfield 20	com/tencent/mm/plugin/traceroute/b/a$a:AhA	Lcom/tencent/mm/plugin/traceroute/b/a;
      //   28: aload_0
      //   29: getfield 25	com/tencent/mm/plugin/traceroute/b/a$a:ip	Ljava/lang/String;
      //   32: aload 6
      //   34: iconst_1
      //   35: invokestatic 57	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   38: invokevirtual 60	com/tencent/mm/plugin/traceroute/b/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V
      //   41: aload_0
      //   42: getfield 27	com/tencent/mm/plugin/traceroute/b/a$a:Ahz	Ljava/util/Set;
      //   45: invokeinterface 66 1 0
      //   50: astore 9
      //   52: aload 9
      //   54: invokeinterface 72 1 0
      //   59: ifeq +722 -> 781
      //   62: aload 9
      //   64: invokeinterface 76 1 0
      //   69: checkcast 53	java/lang/Integer
      //   72: astore 6
      //   74: aload_0
      //   75: getfield 20	com/tencent/mm/plugin/traceroute/b/a$a:AhA	Lcom/tencent/mm/plugin/traceroute/b/a;
      //   78: astore 10
      //   80: aload_0
      //   81: getfield 25	com/tencent/mm/plugin/traceroute/b/a$a:ip	Ljava/lang/String;
      //   84: astore 11
      //   86: aload 6
      //   88: invokevirtual 80	java/lang/Integer:intValue	()I
      //   91: istore_1
      //   92: new 82	java/net/Socket
      //   95: dup
      //   96: invokespecial 83	java/net/Socket:<init>	()V
      //   99: astore 7
      //   101: aload 7
      //   103: astore 6
      //   105: aload 7
      //   107: sipush 5000
      //   110: invokevirtual 86	java/net/Socket:setSoTimeout	(I)V
      //   113: aload 7
      //   115: astore 6
      //   117: invokestatic 92	com/tencent/mm/sdk/platformtools/bs:eWj	()J
      //   120: lstore_2
      //   121: aload 7
      //   123: astore 6
      //   125: aload 7
      //   127: new 94	java/net/InetSocketAddress
      //   130: dup
      //   131: aload 11
      //   133: iload_1
      //   134: invokespecial 97	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
      //   137: invokevirtual 101	java/net/Socket:connect	(Ljava/net/SocketAddress;)V
      //   140: aload 7
      //   142: astore 6
      //   144: invokestatic 92	com/tencent/mm/sdk/platformtools/bs:eWj	()J
      //   147: lstore 4
      //   149: aload 7
      //   151: astore 6
      //   153: ldc 103
      //   155: new 105	java/lang/StringBuilder
      //   158: dup
      //   159: ldc 107
      //   161: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   164: aload 11
      //   166: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   169: ldc 116
      //   171: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   174: iload_1
      //   175: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   178: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   181: invokestatic 128	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   184: aload 7
      //   186: astore 6
      //   188: aload 10
      //   190: aload 11
      //   192: ldc 130
      //   194: iconst_2
      //   195: anewarray 4	java/lang/Object
      //   198: dup
      //   199: iconst_0
      //   200: iload_1
      //   201: invokestatic 57	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   204: aastore
      //   205: dup
      //   206: iconst_1
      //   207: lload 4
      //   209: lload_2
      //   210: lsub
      //   211: invokestatic 135	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   214: aastore
      //   215: invokestatic 51	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   218: iconst_1
      //   219: invokestatic 57	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   222: invokevirtual 60	com/tencent/mm/plugin/traceroute/b/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V
      //   225: aload 7
      //   227: invokevirtual 138	java/net/Socket:close	()V
      //   230: goto -178 -> 52
      //   233: astore 6
      //   235: ldc 103
      //   237: new 105	java/lang/StringBuilder
      //   240: dup
      //   241: ldc 140
      //   243: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   246: aload 6
      //   248: invokevirtual 143	java/io/IOException:getMessage	()Ljava/lang/String;
      //   251: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   254: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   257: invokestatic 146	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   260: ldc 103
      //   262: aload 6
      //   264: ldc 148
      //   266: iconst_0
      //   267: anewarray 4	java/lang/Object
      //   270: invokestatic 152	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   273: goto -221 -> 52
      //   276: astore 8
      //   278: aconst_null
      //   279: astore 7
      //   281: aload 7
      //   283: astore 6
      //   285: aload 10
      //   287: aload 11
      //   289: ldc 154
      //   291: iconst_2
      //   292: anewarray 4	java/lang/Object
      //   295: dup
      //   296: iconst_0
      //   297: iload_1
      //   298: invokestatic 57	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   301: aastore
      //   302: dup
      //   303: iconst_1
      //   304: aload 8
      //   306: invokevirtual 155	java/net/UnknownHostException:toString	()Ljava/lang/String;
      //   309: aastore
      //   310: invokestatic 51	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   313: iconst_1
      //   314: invokestatic 57	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   317: invokevirtual 60	com/tencent/mm/plugin/traceroute/b/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V
      //   320: aload 7
      //   322: astore 6
      //   324: ldc 103
      //   326: new 105	java/lang/StringBuilder
      //   329: dup
      //   330: ldc 157
      //   332: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   335: aload 8
      //   337: invokevirtual 158	java/net/UnknownHostException:getMessage	()Ljava/lang/String;
      //   340: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   343: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   346: invokestatic 146	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   349: aload 7
      //   351: astore 6
      //   353: ldc 103
      //   355: aload 8
      //   357: ldc 148
      //   359: iconst_0
      //   360: anewarray 4	java/lang/Object
      //   363: invokestatic 152	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   366: aload 7
      //   368: ifnull -316 -> 52
      //   371: aload 7
      //   373: invokevirtual 138	java/net/Socket:close	()V
      //   376: goto -324 -> 52
      //   379: astore 6
      //   381: ldc 103
      //   383: new 105	java/lang/StringBuilder
      //   386: dup
      //   387: ldc 140
      //   389: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   392: aload 6
      //   394: invokevirtual 143	java/io/IOException:getMessage	()Ljava/lang/String;
      //   397: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   400: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   403: invokestatic 146	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   406: ldc 103
      //   408: aload 6
      //   410: ldc 148
      //   412: iconst_0
      //   413: anewarray 4	java/lang/Object
      //   416: invokestatic 152	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   419: goto -367 -> 52
      //   422: astore 8
      //   424: aconst_null
      //   425: astore 7
      //   427: aload 7
      //   429: astore 6
      //   431: aload 10
      //   433: aload 11
      //   435: ldc 160
      //   437: iconst_2
      //   438: anewarray 4	java/lang/Object
      //   441: dup
      //   442: iconst_0
      //   443: iload_1
      //   444: invokestatic 57	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   447: aastore
      //   448: dup
      //   449: iconst_1
      //   450: aload 8
      //   452: invokevirtual 161	java/io/IOException:toString	()Ljava/lang/String;
      //   455: aastore
      //   456: invokestatic 51	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   459: iconst_1
      //   460: invokestatic 57	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   463: invokevirtual 60	com/tencent/mm/plugin/traceroute/b/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V
      //   466: aload 7
      //   468: astore 6
      //   470: ldc 103
      //   472: new 105	java/lang/StringBuilder
      //   475: dup
      //   476: ldc 163
      //   478: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   481: aload 8
      //   483: invokevirtual 143	java/io/IOException:getMessage	()Ljava/lang/String;
      //   486: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   489: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   492: invokestatic 146	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   495: aload 7
      //   497: astore 6
      //   499: ldc 103
      //   501: aload 8
      //   503: ldc 148
      //   505: iconst_0
      //   506: anewarray 4	java/lang/Object
      //   509: invokestatic 152	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   512: aload 7
      //   514: ifnull -462 -> 52
      //   517: aload 7
      //   519: invokevirtual 138	java/net/Socket:close	()V
      //   522: goto -470 -> 52
      //   525: astore 6
      //   527: ldc 103
      //   529: new 105	java/lang/StringBuilder
      //   532: dup
      //   533: ldc 140
      //   535: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   538: aload 6
      //   540: invokevirtual 143	java/io/IOException:getMessage	()Ljava/lang/String;
      //   543: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   546: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   549: invokestatic 146	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   552: ldc 103
      //   554: aload 6
      //   556: ldc 148
      //   558: iconst_0
      //   559: anewarray 4	java/lang/Object
      //   562: invokestatic 152	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   565: goto -513 -> 52
      //   568: astore 8
      //   570: aconst_null
      //   571: astore 7
      //   573: aload 7
      //   575: astore 6
      //   577: aload 10
      //   579: aload 11
      //   581: ldc 165
      //   583: iconst_2
      //   584: anewarray 4	java/lang/Object
      //   587: dup
      //   588: iconst_0
      //   589: iload_1
      //   590: invokestatic 57	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   593: aastore
      //   594: dup
      //   595: iconst_1
      //   596: aload 8
      //   598: invokevirtual 166	java/lang/Exception:toString	()Ljava/lang/String;
      //   601: aastore
      //   602: invokestatic 51	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   605: iconst_1
      //   606: invokestatic 57	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   609: invokevirtual 60	com/tencent/mm/plugin/traceroute/b/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V
      //   612: aload 7
      //   614: astore 6
      //   616: ldc 103
      //   618: new 105	java/lang/StringBuilder
      //   621: dup
      //   622: ldc 163
      //   624: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   627: aload 8
      //   629: invokevirtual 166	java/lang/Exception:toString	()Ljava/lang/String;
      //   632: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   635: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   638: invokestatic 146	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   641: aload 7
      //   643: astore 6
      //   645: ldc 103
      //   647: aload 8
      //   649: ldc 148
      //   651: iconst_0
      //   652: anewarray 4	java/lang/Object
      //   655: invokestatic 152	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   658: aload 7
      //   660: ifnull -608 -> 52
      //   663: aload 7
      //   665: invokevirtual 138	java/net/Socket:close	()V
      //   668: goto -616 -> 52
      //   671: astore 6
      //   673: ldc 103
      //   675: new 105	java/lang/StringBuilder
      //   678: dup
      //   679: ldc 140
      //   681: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   684: aload 6
      //   686: invokevirtual 143	java/io/IOException:getMessage	()Ljava/lang/String;
      //   689: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   692: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   695: invokestatic 146	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   698: ldc 103
      //   700: aload 6
      //   702: ldc 148
      //   704: iconst_0
      //   705: anewarray 4	java/lang/Object
      //   708: invokestatic 152	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   711: goto -659 -> 52
      //   714: astore 7
      //   716: aconst_null
      //   717: astore 6
      //   719: aload 6
      //   721: ifnull +8 -> 729
      //   724: aload 6
      //   726: invokevirtual 138	java/net/Socket:close	()V
      //   729: sipush 29656
      //   732: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   735: aload 7
      //   737: athrow
      //   738: astore 6
      //   740: ldc 103
      //   742: new 105	java/lang/StringBuilder
      //   745: dup
      //   746: ldc 140
      //   748: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   751: aload 6
      //   753: invokevirtual 143	java/io/IOException:getMessage	()Ljava/lang/String;
      //   756: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   759: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   762: invokestatic 146	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   765: ldc 103
      //   767: aload 6
      //   769: ldc 148
      //   771: iconst_0
      //   772: anewarray 4	java/lang/Object
      //   775: invokestatic 152	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   778: goto -49 -> 729
      //   781: aload_0
      //   782: getfield 20	com/tencent/mm/plugin/traceroute/b/a$a:AhA	Lcom/tencent/mm/plugin/traceroute/b/a;
      //   785: aload_0
      //   786: getfield 25	com/tencent/mm/plugin/traceroute/b/a$a:ip	Ljava/lang/String;
      //   789: ldc 171
      //   791: iconst_1
      //   792: invokestatic 57	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   795: invokevirtual 60	com/tencent/mm/plugin/traceroute/b/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V
      //   798: sipush 29656
      //   801: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   804: return
      //   805: astore 7
      //   807: goto -88 -> 719
      //   810: astore 8
      //   812: goto -239 -> 573
      //   815: astore 8
      //   817: goto -390 -> 427
      //   820: astore 8
      //   822: goto -541 -> 281
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	825	0	this	a
      //   91	499	1	i	int
      //   120	90	2	l1	long
      //   147	61	4	l2	long
      //   22	165	6	localObject1	Object
      //   233	30	6	localIOException1	java.io.IOException
      //   283	69	6	localObject2	Object
      //   379	30	6	localIOException2	java.io.IOException
      //   429	69	6	localObject3	Object
      //   525	30	6	localIOException3	java.io.IOException
      //   575	69	6	localObject4	Object
      //   671	30	6	localIOException4	java.io.IOException
      //   717	8	6	localObject5	Object
      //   738	30	6	localIOException5	java.io.IOException
      //   99	565	7	localSocket	java.net.Socket
      //   714	22	7	localObject6	Object
      //   805	1	7	localObject7	Object
      //   276	80	8	localUnknownHostException1	java.net.UnknownHostException
      //   422	80	8	localIOException6	java.io.IOException
      //   568	80	8	localException1	Exception
      //   810	1	8	localException2	Exception
      //   815	1	8	localIOException7	java.io.IOException
      //   820	1	8	localUnknownHostException2	java.net.UnknownHostException
      //   50	13	9	localIterator	Iterator
      //   78	500	10	locala	a
      //   84	496	11	str	String
      // Exception table:
      //   from	to	target	type
      //   225	230	233	java/io/IOException
      //   92	101	276	java/net/UnknownHostException
      //   371	376	379	java/io/IOException
      //   92	101	422	java/io/IOException
      //   517	522	525	java/io/IOException
      //   92	101	568	java/lang/Exception
      //   663	668	671	java/io/IOException
      //   92	101	714	finally
      //   724	729	738	java/io/IOException
      //   105	113	805	finally
      //   117	121	805	finally
      //   125	140	805	finally
      //   144	149	805	finally
      //   153	184	805	finally
      //   188	225	805	finally
      //   285	320	805	finally
      //   324	349	805	finally
      //   353	366	805	finally
      //   431	466	805	finally
      //   470	495	805	finally
      //   499	512	805	finally
      //   577	612	805	finally
      //   616	641	805	finally
      //   645	658	805	finally
      //   105	113	810	java/lang/Exception
      //   117	121	810	java/lang/Exception
      //   125	140	810	java/lang/Exception
      //   144	149	810	java/lang/Exception
      //   153	184	810	java/lang/Exception
      //   188	225	810	java/lang/Exception
      //   105	113	815	java/io/IOException
      //   117	121	815	java/io/IOException
      //   125	140	815	java/io/IOException
      //   144	149	815	java/io/IOException
      //   153	184	815	java/io/IOException
      //   188	225	815	java/io/IOException
      //   105	113	820	java/net/UnknownHostException
      //   117	121	820	java/net/UnknownHostException
      //   125	140	820	java/net/UnknownHostException
      //   144	149	820	java/net/UnknownHostException
      //   153	184	820	java/net/UnknownHostException
      //   188	225	820	java/net/UnknownHostException
    }
  }
  
  public static abstract interface b
  {
    public abstract void eeM();
  }
  
  public static abstract interface c
  {
    public abstract void eeN();
  }
  
  public static abstract interface d
  {
    public abstract void aRA();
  }
  
  public static abstract interface e
  {
    public abstract void eeO();
  }
  
  final class f
    extends ConcurrentHashMap<String, ConcurrentHashMap<Integer, StringBuilder>>
  {
    private f() {}
  }
  
  final class g
    implements Runnable
  {
    private String AhF;
    private boolean AhG;
    private Integer AhH;
    private String serverIP;
    
    public g(String paramString1, String paramString2, boolean paramBoolean, Integer paramInteger)
    {
      this.AhF = paramString1;
      this.serverIP = paramString2;
      this.AhG = paramBoolean;
      this.AhH = paramInteger;
    }
    
    public final void run()
    {
      AppMethodBeat.i(29659);
      a locala = a.this;
      String str2 = this.AhF;
      String str3 = this.serverIP;
      Integer localInteger = this.AhH;
      int i = 1;
      if (i <= 3)
      {
        Object localObject = b.N(new String[] { "ping", "-c 1", "-t 64", str2 });
        if (((List)localObject).size() != 2) {
          if (i == 3) {
            locala.a(str3, " router no response\n", localInteger);
          }
        }
        String str1;
        for (;;)
        {
          i += 1;
          break;
          locala.a(str3, " router no response", localInteger);
          continue;
          str1 = (String)((List)localObject).get(0);
          if (!bs.isNullOrNil(str1)) {
            break label159;
          }
          ac.e("MicroMsg.MMTraceRoute", "runcommand err ".concat(String.valueOf(str2)));
          locala.a(str3, "run command err ", localInteger);
        }
        label159:
        localObject = ((List)localObject).get(1).toString();
        if (b.axX(str1) > 0)
        {
          str1 = b.axW(str1);
          if (!bs.isNullOrNil(str1)) {
            str1 = String.format(" %sms ", new Object[] { str1 });
          }
        }
        for (;;)
        {
          localObject = str1;
          if (i == 3) {
            localObject = str1 + "\n";
          }
          locala.a(str3, (String)localObject, localInteger);
          break;
          if (!bs.isNullOrNil((String)localObject))
          {
            str1 = String.format(" %sms ", new Object[] { localObject });
          }
          else
          {
            str1 = String.format("unable to get time", new Object[0]);
            continue;
            str1 = String.format(" router no response ", new Object[0]);
          }
        }
      }
      AppMethodBeat.o(29659);
    }
  }
  
  final class h
    implements Runnable
  {
    private int AhI;
    private String ip;
    
    public h(String paramString, int paramInt)
    {
      this.ip = paramString;
      this.AhI = paramInt;
    }
    
    public final void run()
    {
      int j = 1;
      AppMethodBeat.i(29660);
      ac.i("MicroMsg.MMTraceRoute", "ttl= " + this.AhI);
      a locala = a.this;
      String str1 = this.ip;
      int m = this.AhI;
      Object localObject = b.N(new String[] { "ping", "-c 1", "-t " + String.valueOf(m), str1 });
      if (((List)localObject).size() != 2) {
        locala.a(str1, String.format("%d : can not get roupter ip\n", new Object[] { Integer.valueOf(m) }), Integer.valueOf(m + 1));
      }
      for (;;)
      {
        int i = 0;
        for (;;)
        {
          label141:
          if (i == 0) {
            break label570;
          }
          AppMethodBeat.o(29660);
          return;
          String str2 = (String)((List)localObject).get(0);
          if (str2.length() == 0)
          {
            ac.e("MicroMsg.MMTraceRoute", "runcommand err");
            break;
          }
          int k = str2.indexOf("From ");
          i = k;
          if (k < 0)
          {
            k = str2.indexOf("from ");
            i = k;
            if (k < 0) {
              localObject = null;
            }
          }
          for (;;)
          {
            if (!bs.isNullOrNil((String)localObject)) {
              break label363;
            }
            i = j;
            if (b.axX(str2) > 0) {
              break label141;
            }
            localObject = String.format("%d : can not get roupter ip\n", new Object[] { Integer.valueOf(m) });
            ac.e("MicroMsg.MMTraceRoute", "can not get setData ip and ttl".concat(String.valueOf(str1)));
            locala.a(str1, (String)localObject, Integer.valueOf(m + 1));
            break;
            k = str2.indexOf(" ", i);
            if (k < 0)
            {
              k = str2.indexOf(":", i);
              i = k;
              if (k < 0) {
                localObject = null;
              }
            }
            else
            {
              i = k;
            }
            i += 1;
            k = str2.indexOf(" ", i);
            if (k < 0) {
              localObject = null;
            } else {
              localObject = str2.substring(i, k).replace(":", "");
            }
          }
          label363:
          if (str1.equals(localObject))
          {
            locala.a(str1, String.format("%d : FIN %s\n\n", new Object[] { Integer.valueOf(m), localObject }), Integer.valueOf(m + 1));
            i = j;
          }
          else
          {
            if (b.axX(str2) <= 0) {
              break label498;
            }
            locala.a(str1, String.format("%d : FIN %s\n\n ", new Object[] { Integer.valueOf(m), localObject }), Integer.valueOf(m + 1));
            i = j;
            if (a.Ahq != null)
            {
              a.Ahq.execute(new a.g(locala, (String)localObject, str1, true, Integer.valueOf(m + 1)));
              i = j;
            }
          }
        }
        label498:
        locala.a(str1, String.format("%d : %s", new Object[] { Integer.valueOf(m), localObject }), Integer.valueOf(m + 1));
        if (a.Ahq != null) {
          a.Ahq.execute(new a.g(locala, (String)localObject, str1, false, Integer.valueOf(m + 1)));
        }
      }
      label570:
      AppMethodBeat.o(29660);
    }
  }
  
  final class i
    implements Runnable
  {
    private String ip;
    
    public i(String paramString)
    {
      this.ip = paramString;
    }
    
    public final void run()
    {
      int k = 1;
      AppMethodBeat.i(29661);
      Object localObject2 = b.N(new String[] { "ping", "-c 1", "-t 64", this.ip });
      if (((List)localObject2).size() != 2)
      {
        a.this.a(this.ip, "failed to ping: \n" + this.ip, Integer.valueOf(0));
        AppMethodBeat.o(29661);
        return;
      }
      Object localObject1 = (String)((List)localObject2).get(0);
      if (bs.isNullOrNil((String)localObject1))
      {
        a.this.a(this.ip, "failed to ping: \n" + this.ip, Integer.valueOf(0));
        ac.e("MicroMsg.MMTraceRoute", "runcommand err");
        AppMethodBeat.o(29661);
        return;
      }
      int i = b.axX((String)localObject1);
      if (i <= 0)
      {
        ac.e("MicroMsg.MMTraceRoute", "failed to touch server:" + this.ip);
        a.this.a(this.ip, "failed to touch server: " + this.ip + "\n", Integer.valueOf(0));
        AppMethodBeat.o(29661);
        return;
      }
      localObject2 = ((List)localObject2).get(1).toString();
      localObject1 = b.axW((String)localObject1);
      if (!bs.isNullOrNil((String)localObject1)) {
        localObject1 = String.format("server: %s, TTL: %d, Time = %sms", new Object[] { this.ip, Integer.valueOf(i), localObject1 });
      }
      for (;;)
      {
        a.this.a(this.ip, (String)localObject1 + "\n", Integer.valueOf(0));
        int m = 64 - i + 5;
        i = m;
        int j = k;
        if (m < 0)
        {
          i = 64;
          j = k;
        }
        while ((j < i) && (!a.this.eeJ()))
        {
          localObject1 = new a.h(a.this, this.ip, j);
          if (a.Ahq != null) {
            a.Ahq.execute((Runnable)localObject1);
          }
          j += 1;
        }
        if (!bs.isNullOrNil((String)localObject2)) {
          localObject1 = String.format("server: %s, TTL: %d, Time = %sms", new Object[] { this.ip, Integer.valueOf(i), localObject2 });
        } else {
          localObject1 = String.format("server: %s, TTL: %d, Time = %sms", new Object[] { this.ip, Integer.valueOf(i), "unknown" });
        }
      }
      AppMethodBeat.o(29661);
    }
  }
  
  public final class j
    implements Runnable
  {
    private j() {}
    
    public final void run()
    {
      AppMethodBeat.i(29662);
      a.this.sg(false);
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      long l1 = bs.eWj();
      Object localObject1 = new java.sql.Date(l1);
      ac.i("MicroMsg.MMTraceRoute", "mmtraceroute start time " + localSimpleDateFormat.format((java.util.Date)localObject1));
      localObject1 = a.this.Ahu.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        a.i locali = new a.i(a.this, (String)((Map.Entry)localObject2).getKey());
        if (a.Ahq != null) {
          a.Ahq.execute(locali);
        }
        localObject2 = new a.a(a.this, (String)((Map.Entry)localObject2).getKey(), (Set)((Map.Entry)localObject2).getValue());
        if (a.Ahq != null) {
          a.Ahq.execute((Runnable)localObject2);
        }
      }
      try
      {
        do
        {
          Thread.sleep(500L);
          if ((a.this.eeJ()) || (a.Ahq.getActiveCount() <= 0)) {
            break;
          }
          ac.d("MicroMsg.MMTraceRoute", "task count: " + String.valueOf(a.Ahq.getActiveCount()));
          l2 = bs.eWj();
        } while (l2 - l1 < 120000L);
        ac.i("MicroMsg.MMTraceRoute", "traceroute timeout: " + (l2 - l1) / 1000L);
        a.this.sg(true);
        a.this.stop();
        if (a.this.Ahv != null) {
          a.this.Ahv.eeO();
        }
        AppMethodBeat.o(29662);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.e("MicroMsg.MMTraceRoute", "wait for command end err: " + localException.getMessage());
          ac.printErrStackTrace("MicroMsg.MMTraceRoute", localException, "", new Object[0]);
        }
        long l2 = bs.eWj();
        ac.i("MicroMsg.MMTraceRoute", "mmtraceroute end time " + localSimpleDateFormat.format(new java.util.Date(l2)));
        ac.i("MicroMsg.MMTraceRoute", "mmtraceroute total time " + (l2 - l1) / 1000L);
        if ((a.this.Ahw != null) && (!a.this.eeJ())) {
          a.this.Ahw.aRA();
        }
        AppMethodBeat.o(29662);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.b.a
 * JD-Core Version:    0.7.0.1
 */