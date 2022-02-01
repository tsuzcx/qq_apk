package com.tencent.mm.plugin.traceroute.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.vfs.u;
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
  public static String NdR;
  public static c NdS;
  private final int NdT;
  private boolean NdU;
  f NdV;
  public Map<String, Set<Integer>> NdW;
  public e NdX;
  public d NdY;
  public c NdZ;
  public b Nea;
  private final String TAG;
  String userName;
  
  public a(String paramString)
  {
    AppMethodBeat.i(29663);
    this.TAG = "MicroMsg.MMTraceRoute";
    this.NdT = 64;
    this.NdU = false;
    this.NdV = new f((byte)0);
    this.NdW = new HashMap();
    this.userName = paramString;
    NdR = g.avF().getAbsolutePath() + "/tencent/traceroute_log_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date()).toString() + ".log";
    AppMethodBeat.o(29663);
  }
  
  final void Al(boolean paramBoolean)
  {
    try
    {
      this.NdU = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final void c(String paramString1, String paramString2, Integer paramInteger)
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
        if (!this.NdV.containsKey(paramString1))
        {
          ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
          localConcurrentHashMap.put(paramInteger, new StringBuilder(paramString2));
          this.NdV.put(paramString1, (ConcurrentHashMap)localConcurrentHashMap);
          AppMethodBeat.o(29666);
          continue;
        }
        if (!((ConcurrentHashMap)this.NdV.get(paramString1)).containsKey(paramInteger)) {
          break label147;
        }
      }
      finally {}
      ((StringBuilder)((ConcurrentHashMap)this.NdV.get(paramString1)).get(paramInteger)).append(paramString2);
      AppMethodBeat.o(29666);
      continue;
      label147:
      new ConcurrentHashMap().put(paramInteger, new StringBuilder(paramString2));
      ((ConcurrentHashMap)this.NdV.get(paramString1)).put(paramInteger, new StringBuilder(paramString2));
      AppMethodBeat.o(29666);
    }
  }
  
  public final void c(String[] paramArrayOfString, boolean paramBoolean)
  {
    AppMethodBeat.i(29665);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      Log.e("MicroMsg.MMTraceRoute", "no ip contains");
      AppMethodBeat.o(29665);
      return;
    }
    String str;
    int i;
    label61:
    Object localObject;
    String[] arrayOfString;
    if (paramBoolean)
    {
      str = "" + "long: ";
      int j = paramArrayOfString.length;
      i = 0;
      if (i >= j) {
        break label268;
      }
      localObject = paramArrayOfString[i];
      arrayOfString = ((String)localObject).split(":");
      if ((arrayOfString != null) && (arrayOfString.length == 3)) {
        break label140;
      }
      Log.e("MicroMsg.MMTraceRoute", "err ip ".concat(String.valueOf(localObject)));
    }
    for (;;)
    {
      i += 1;
      break label61;
      str = "" + "short: ";
      break;
      label140:
      if (!this.NdW.containsKey(arrayOfString[0]))
      {
        localObject = new HashSet();
        ((Set)localObject).add(Integer.valueOf(Util.getInt(arrayOfString[1], 0)));
        this.NdW.put(arrayOfString[0], localObject);
        str = str + arrayOfString[0] + " ";
      }
      else
      {
        ((Set)this.NdW.get(arrayOfString[0])).add(Integer.valueOf(Util.getInt(arrayOfString[1], 0)));
      }
    }
    label268:
    paramArrayOfString = str + "\n";
    u.F(NdR, paramArrayOfString.getBytes());
    AppMethodBeat.o(29665);
  }
  
  final boolean gsb()
  {
    try
    {
      boolean bool = this.NdU;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void gsc()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 29667
    //   5: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 82	com/tencent/mm/plugin/traceroute/b/a:NdV	Lcom/tencent/mm/plugin/traceroute/b/a$f;
    //   12: ifnull +594 -> 606
    //   15: aload_0
    //   16: getfield 82	com/tencent/mm/plugin/traceroute/b/a:NdV	Lcom/tencent/mm/plugin/traceroute/b/a$f;
    //   19: astore 6
    //   21: new 238	com/tencent/mm/vfs/q
    //   24: dup
    //   25: getstatic 133	com/tencent/mm/plugin/traceroute/b/a:NdR	Ljava/lang/String;
    //   28: invokespecial 239	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   31: astore 4
    //   33: aload 4
    //   35: invokevirtual 242	com/tencent/mm/vfs/q:ifE	()Z
    //   38: istore_3
    //   39: iload_3
    //   40: ifne +45 -> 85
    //   43: aload 4
    //   45: invokevirtual 245	com/tencent/mm/vfs/q:ifM	()Z
    //   48: pop
    //   49: getstatic 133	com/tencent/mm/plugin/traceroute/b/a:NdR	Ljava/lang/String;
    //   52: new 91	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   59: aload 6
    //   61: getfield 249	com/tencent/mm/plugin/traceroute/b/a$f:Nec	Lcom/tencent/mm/plugin/traceroute/b/a;
    //   64: getfield 89	com/tencent/mm/plugin/traceroute/b/a:userName	Ljava/lang/String;
    //   67: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: ldc 221
    //   72: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokevirtual 225	java/lang/String:getBytes	()[B
    //   81: invokestatic 231	com/tencent/mm/vfs/u:F	(Ljava/lang/String;[B)I
    //   84: pop
    //   85: aload 6
    //   87: getfield 249	com/tencent/mm/plugin/traceroute/b/a$f:Nec	Lcom/tencent/mm/plugin/traceroute/b/a;
    //   90: getfield 82	com/tencent/mm/plugin/traceroute/b/a:NdV	Lcom/tencent/mm/plugin/traceroute/b/a$f;
    //   93: invokevirtual 253	com/tencent/mm/plugin/traceroute/b/a$f:entrySet	()Ljava/util/Set;
    //   96: invokeinterface 257 1 0
    //   101: astore 7
    //   103: aload 7
    //   105: invokeinterface 262 1 0
    //   110: ifeq +363 -> 473
    //   113: aload 7
    //   115: invokeinterface 266 1 0
    //   120: checkcast 268	java/util/Map$Entry
    //   123: invokeinterface 271 1 0
    //   128: checkcast 125	java/lang/String
    //   131: astore 8
    //   133: aload 8
    //   135: invokestatic 275	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   138: ifne -35 -> 103
    //   141: aload 6
    //   143: getfield 249	com/tencent/mm/plugin/traceroute/b/a$f:Nec	Lcom/tencent/mm/plugin/traceroute/b/a;
    //   146: getfield 82	com/tencent/mm/plugin/traceroute/b/a:NdV	Lcom/tencent/mm/plugin/traceroute/b/a$f;
    //   149: aload 8
    //   151: invokevirtual 150	com/tencent/mm/plugin/traceroute/b/a$f:containsKey	(Ljava/lang/Object;)Z
    //   154: ifeq -51 -> 103
    //   157: aload 6
    //   159: getfield 249	com/tencent/mm/plugin/traceroute/b/a$f:Nec	Lcom/tencent/mm/plugin/traceroute/b/a;
    //   162: getfield 82	com/tencent/mm/plugin/traceroute/b/a:NdV	Lcom/tencent/mm/plugin/traceroute/b/a$f;
    //   165: aload 8
    //   167: invokevirtual 165	com/tencent/mm/plugin/traceroute/b/a$f:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   170: checkcast 156	java/util/Map
    //   173: astore 9
    //   175: aload 9
    //   177: ifnull -74 -> 103
    //   180: ldc 178
    //   182: astore 4
    //   184: aload 9
    //   186: invokeinterface 278 1 0
    //   191: iconst_1
    //   192: if_icmpne +167 -> 359
    //   195: aload 9
    //   197: iconst_1
    //   198: invokestatic 211	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   201: invokeinterface 219 2 0
    //   206: ifnull +153 -> 359
    //   209: new 91	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   216: ldc 178
    //   218: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: aload 9
    //   223: iconst_1
    //   224: invokestatic 211	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   227: invokeinterface 219 2 0
    //   232: checkcast 91	java/lang/StringBuilder
    //   235: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: astore 5
    //   246: aload 5
    //   248: invokevirtual 281	java/lang/String:length	()I
    //   251: ifle -148 -> 103
    //   254: ldc 71
    //   256: new 91	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   263: aload 8
    //   265: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload 5
    //   270: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokestatic 283	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   279: getstatic 133	com/tencent/mm/plugin/traceroute/b/a:NdR	Ljava/lang/String;
    //   282: aload 5
    //   284: invokevirtual 225	java/lang/String:getBytes	()[B
    //   287: invokestatic 231	com/tencent/mm/vfs/u:F	(Ljava/lang/String;[B)I
    //   290: pop
    //   291: goto -188 -> 103
    //   294: astore 4
    //   296: aload_0
    //   297: monitorexit
    //   298: aload 4
    //   300: athrow
    //   301: astore 4
    //   303: ldc 71
    //   305: new 91	java/lang/StringBuilder
    //   308: dup
    //   309: ldc_w 285
    //   312: invokespecial 154	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   315: aload 4
    //   317: invokevirtual 288	java/io/IOException:getMessage	()Ljava/lang/String;
    //   320: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: invokestatic 176	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   329: ldc 71
    //   331: aload 4
    //   333: ldc 178
    //   335: iconst_0
    //   336: anewarray 4	java/lang/Object
    //   339: invokestatic 292	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   342: aload 6
    //   344: getfield 249	com/tencent/mm/plugin/traceroute/b/a$f:Nec	Lcom/tencent/mm/plugin/traceroute/b/a;
    //   347: invokevirtual 295	com/tencent/mm/plugin/traceroute/b/a:gsd	()V
    //   350: sipush 29667
    //   353: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   356: aload_0
    //   357: monitorexit
    //   358: return
    //   359: iconst_0
    //   360: istore_1
    //   361: iconst_0
    //   362: istore_2
    //   363: aload 4
    //   365: astore 5
    //   367: iload_1
    //   368: aload 9
    //   370: invokeinterface 278 1 0
    //   375: if_icmpge -129 -> 246
    //   378: aload 4
    //   380: astore 5
    //   382: iload_2
    //   383: ifne -137 -> 246
    //   386: aload 9
    //   388: iload_1
    //   389: invokestatic 211	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   392: invokeinterface 219 2 0
    //   397: ifnull +218 -> 615
    //   400: aload 9
    //   402: iload_1
    //   403: invokestatic 211	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   406: invokeinterface 219 2 0
    //   411: checkcast 91	java/lang/StringBuilder
    //   414: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: astore 10
    //   419: aload 10
    //   421: invokestatic 275	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   424: ifne +191 -> 615
    //   427: new 91	java/lang/StringBuilder
    //   430: dup
    //   431: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   434: aload 4
    //   436: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: aload 10
    //   441: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: astore 5
    //   449: aload 5
    //   451: astore 4
    //   453: aload 10
    //   455: ldc_w 297
    //   458: invokevirtual 301	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   461: ifeq +154 -> 615
    //   464: iconst_1
    //   465: istore_2
    //   466: aload 5
    //   468: astore 4
    //   470: goto +145 -> 615
    //   473: getstatic 133	com/tencent/mm/plugin/traceroute/b/a:NdR	Ljava/lang/String;
    //   476: iconst_0
    //   477: iconst_m1
    //   478: invokestatic 305	com/tencent/mm/vfs/u:aY	(Ljava/lang/String;II)[B
    //   481: astore 5
    //   483: aload 5
    //   485: invokestatic 308	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	([B)Z
    //   488: ifeq +28 -> 516
    //   491: ldc 71
    //   493: ldc_w 310
    //   496: invokestatic 176	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   499: aload 6
    //   501: getfield 249	com/tencent/mm/plugin/traceroute/b/a$f:Nec	Lcom/tencent/mm/plugin/traceroute/b/a;
    //   504: invokevirtual 295	com/tencent/mm/plugin/traceroute/b/a:gsd	()V
    //   507: sipush 29667
    //   510: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   513: goto -157 -> 356
    //   516: aload 5
    //   518: arraylength
    //   519: istore_1
    //   520: ldc_w 312
    //   523: iconst_2
    //   524: anewarray 4	java/lang/Object
    //   527: dup
    //   528: iconst_0
    //   529: getstatic 317	com/tencent/mm/protocal/d:RAD	I
    //   532: invokestatic 211	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   535: aastore
    //   536: dup
    //   537: iconst_1
    //   538: iload_1
    //   539: invokestatic 211	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   542: aastore
    //   543: invokestatic 320	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   546: invokevirtual 225	java/lang/String:getBytes	()[B
    //   549: invokestatic 326	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   552: invokevirtual 329	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   555: astore 4
    //   557: aload 5
    //   559: invokestatic 335	com/tencent/mm/b/s:compress	([B)[B
    //   562: astore 5
    //   564: new 337	com/tencent/mm/pointers/PByteArray
    //   567: dup
    //   568: invokespecial 338	com/tencent/mm/pointers/PByteArray:<init>	()V
    //   571: astore 7
    //   573: aload 7
    //   575: aload 5
    //   577: aload 4
    //   579: invokevirtual 225	java/lang/String:getBytes	()[B
    //   582: invokestatic 343	com/tencent/mm/b/c:a	(Lcom/tencent/mm/pointers/PByteArray;[B[B)I
    //   585: pop
    //   586: new 24	com/tencent/mm/plugin/traceroute/b/a$f$1
    //   589: dup
    //   590: aload 6
    //   592: iload_1
    //   593: aload 4
    //   595: aload 7
    //   597: invokespecial 346	com/tencent/mm/plugin/traceroute/b/a$f$1:<init>	(Lcom/tencent/mm/plugin/traceroute/b/a$f;ILjava/lang/String;Lcom/tencent/mm/pointers/PByteArray;)V
    //   600: ldc_w 348
    //   603: invokestatic 354	com/tencent/mm/sdk/thread/ThreadPool:post	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   606: sipush 29667
    //   609: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   612: goto -256 -> 356
    //   615: iload_1
    //   616: iconst_1
    //   617: iadd
    //   618: istore_1
    //   619: goto -256 -> 363
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	622	0	this	a
    //   360	259	1	i	int
    //   362	104	2	j	int
    //   38	2	3	bool	boolean
    //   31	152	4	localObject1	Object
    //   294	5	4	localObject2	Object
    //   301	134	4	localIOException	java.io.IOException
    //   451	143	4	localObject3	Object
    //   244	332	5	localObject4	Object
    //   19	572	6	localf	f
    //   101	495	7	localObject5	Object
    //   131	133	8	str1	String
    //   173	228	9	localMap	Map
    //   417	37	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   2	39	294	finally
    //   43	85	294	finally
    //   85	103	294	finally
    //   103	175	294	finally
    //   184	246	294	finally
    //   246	291	294	finally
    //   303	356	294	finally
    //   367	378	294	finally
    //   386	449	294	finally
    //   453	464	294	finally
    //   473	513	294	finally
    //   516	606	294	finally
    //   606	612	294	finally
    //   43	85	301	java/io/IOException
  }
  
  final void gsd()
  {
    AppMethodBeat.i(29668);
    if (this.Nea != null) {
      this.Nea.gse();
    }
    AppMethodBeat.o(29668);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(29664);
    Al(true);
    if (NdS != null) {
      try
      {
        NdS.shutdownNow();
        AppMethodBeat.o(29664);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.MMTraceRoute", "failed to shutdown threadpool: " + localException.getMessage());
      }
    }
    AppMethodBeat.o(29664);
  }
  
  final class a
    implements Runnable
  {
    private Set<Integer> Neb;
    private String ip;
    
    public a(Set<Integer> paramSet)
    {
      this.ip = paramSet;
      Object localObject;
      this.Neb = localObject;
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
      //   25: getfield 20	com/tencent/mm/plugin/traceroute/b/a$a:Nec	Lcom/tencent/mm/plugin/traceroute/b/a;
      //   28: aload_0
      //   29: getfield 25	com/tencent/mm/plugin/traceroute/b/a$a:ip	Ljava/lang/String;
      //   32: aload 6
      //   34: iconst_1
      //   35: invokestatic 57	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   38: invokevirtual 61	com/tencent/mm/plugin/traceroute/b/a:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V
      //   41: aload_0
      //   42: getfield 27	com/tencent/mm/plugin/traceroute/b/a$a:Neb	Ljava/util/Set;
      //   45: invokeinterface 67 1 0
      //   50: astore 9
      //   52: aload 9
      //   54: invokeinterface 73 1 0
      //   59: ifeq +722 -> 781
      //   62: aload 9
      //   64: invokeinterface 77 1 0
      //   69: checkcast 53	java/lang/Integer
      //   72: astore 6
      //   74: aload_0
      //   75: getfield 20	com/tencent/mm/plugin/traceroute/b/a$a:Nec	Lcom/tencent/mm/plugin/traceroute/b/a;
      //   78: astore 10
      //   80: aload_0
      //   81: getfield 25	com/tencent/mm/plugin/traceroute/b/a$a:ip	Ljava/lang/String;
      //   84: astore 11
      //   86: aload 6
      //   88: invokevirtual 81	java/lang/Integer:intValue	()I
      //   91: istore_1
      //   92: new 83	java/net/Socket
      //   95: dup
      //   96: invokespecial 84	java/net/Socket:<init>	()V
      //   99: astore 7
      //   101: aload 7
      //   103: astore 6
      //   105: aload 7
      //   107: sipush 5000
      //   110: invokevirtual 87	java/net/Socket:setSoTimeout	(I)V
      //   113: aload 7
      //   115: astore 6
      //   117: invokestatic 93	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
      //   120: lstore_2
      //   121: aload 7
      //   123: astore 6
      //   125: aload 7
      //   127: new 95	java/net/InetSocketAddress
      //   130: dup
      //   131: aload 11
      //   133: iload_1
      //   134: invokespecial 98	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
      //   137: invokevirtual 102	java/net/Socket:connect	(Ljava/net/SocketAddress;)V
      //   140: aload 7
      //   142: astore 6
      //   144: invokestatic 93	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
      //   147: lstore 4
      //   149: aload 7
      //   151: astore 6
      //   153: ldc 104
      //   155: new 106	java/lang/StringBuilder
      //   158: dup
      //   159: ldc 108
      //   161: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   164: aload 11
      //   166: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   169: ldc 117
      //   171: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   174: iload_1
      //   175: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   178: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   181: invokestatic 129	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   184: aload 7
      //   186: astore 6
      //   188: aload 10
      //   190: aload 11
      //   192: ldc 131
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
      //   211: invokestatic 136	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   214: aastore
      //   215: invokestatic 51	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   218: iconst_1
      //   219: invokestatic 57	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   222: invokevirtual 61	com/tencent/mm/plugin/traceroute/b/a:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V
      //   225: aload 7
      //   227: invokevirtual 139	java/net/Socket:close	()V
      //   230: goto -178 -> 52
      //   233: astore 6
      //   235: ldc 104
      //   237: new 106	java/lang/StringBuilder
      //   240: dup
      //   241: ldc 141
      //   243: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   246: aload 6
      //   248: invokevirtual 144	java/io/IOException:getMessage	()Ljava/lang/String;
      //   251: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   254: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   257: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   260: ldc 104
      //   262: aload 6
      //   264: ldc 149
      //   266: iconst_0
      //   267: anewarray 4	java/lang/Object
      //   270: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   273: goto -221 -> 52
      //   276: astore 8
      //   278: aconst_null
      //   279: astore 7
      //   281: aload 7
      //   283: astore 6
      //   285: aload 10
      //   287: aload 11
      //   289: ldc 155
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
      //   306: invokevirtual 156	java/net/UnknownHostException:toString	()Ljava/lang/String;
      //   309: aastore
      //   310: invokestatic 51	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   313: iconst_1
      //   314: invokestatic 57	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   317: invokevirtual 61	com/tencent/mm/plugin/traceroute/b/a:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V
      //   320: aload 7
      //   322: astore 6
      //   324: ldc 104
      //   326: new 106	java/lang/StringBuilder
      //   329: dup
      //   330: ldc 158
      //   332: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   335: aload 8
      //   337: invokevirtual 159	java/net/UnknownHostException:getMessage	()Ljava/lang/String;
      //   340: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   343: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   346: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   349: aload 7
      //   351: astore 6
      //   353: ldc 104
      //   355: aload 8
      //   357: ldc 149
      //   359: iconst_0
      //   360: anewarray 4	java/lang/Object
      //   363: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   366: aload 7
      //   368: ifnull -316 -> 52
      //   371: aload 7
      //   373: invokevirtual 139	java/net/Socket:close	()V
      //   376: goto -324 -> 52
      //   379: astore 6
      //   381: ldc 104
      //   383: new 106	java/lang/StringBuilder
      //   386: dup
      //   387: ldc 141
      //   389: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   392: aload 6
      //   394: invokevirtual 144	java/io/IOException:getMessage	()Ljava/lang/String;
      //   397: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   400: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   403: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   406: ldc 104
      //   408: aload 6
      //   410: ldc 149
      //   412: iconst_0
      //   413: anewarray 4	java/lang/Object
      //   416: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   419: goto -367 -> 52
      //   422: astore 8
      //   424: aconst_null
      //   425: astore 7
      //   427: aload 7
      //   429: astore 6
      //   431: aload 10
      //   433: aload 11
      //   435: ldc 161
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
      //   452: invokevirtual 162	java/io/IOException:toString	()Ljava/lang/String;
      //   455: aastore
      //   456: invokestatic 51	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   459: iconst_1
      //   460: invokestatic 57	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   463: invokevirtual 61	com/tencent/mm/plugin/traceroute/b/a:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V
      //   466: aload 7
      //   468: astore 6
      //   470: ldc 104
      //   472: new 106	java/lang/StringBuilder
      //   475: dup
      //   476: ldc 164
      //   478: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   481: aload 8
      //   483: invokevirtual 144	java/io/IOException:getMessage	()Ljava/lang/String;
      //   486: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   489: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   492: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   495: aload 7
      //   497: astore 6
      //   499: ldc 104
      //   501: aload 8
      //   503: ldc 149
      //   505: iconst_0
      //   506: anewarray 4	java/lang/Object
      //   509: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   512: aload 7
      //   514: ifnull -462 -> 52
      //   517: aload 7
      //   519: invokevirtual 139	java/net/Socket:close	()V
      //   522: goto -470 -> 52
      //   525: astore 6
      //   527: ldc 104
      //   529: new 106	java/lang/StringBuilder
      //   532: dup
      //   533: ldc 141
      //   535: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   538: aload 6
      //   540: invokevirtual 144	java/io/IOException:getMessage	()Ljava/lang/String;
      //   543: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   546: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   549: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   552: ldc 104
      //   554: aload 6
      //   556: ldc 149
      //   558: iconst_0
      //   559: anewarray 4	java/lang/Object
      //   562: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   565: goto -513 -> 52
      //   568: astore 8
      //   570: aconst_null
      //   571: astore 7
      //   573: aload 7
      //   575: astore 6
      //   577: aload 10
      //   579: aload 11
      //   581: ldc 166
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
      //   598: invokevirtual 167	java/lang/Exception:toString	()Ljava/lang/String;
      //   601: aastore
      //   602: invokestatic 51	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   605: iconst_1
      //   606: invokestatic 57	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   609: invokevirtual 61	com/tencent/mm/plugin/traceroute/b/a:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V
      //   612: aload 7
      //   614: astore 6
      //   616: ldc 104
      //   618: new 106	java/lang/StringBuilder
      //   621: dup
      //   622: ldc 164
      //   624: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   627: aload 8
      //   629: invokevirtual 167	java/lang/Exception:toString	()Ljava/lang/String;
      //   632: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   635: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   638: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   641: aload 7
      //   643: astore 6
      //   645: ldc 104
      //   647: aload 8
      //   649: ldc 149
      //   651: iconst_0
      //   652: anewarray 4	java/lang/Object
      //   655: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   658: aload 7
      //   660: ifnull -608 -> 52
      //   663: aload 7
      //   665: invokevirtual 139	java/net/Socket:close	()V
      //   668: goto -616 -> 52
      //   671: astore 6
      //   673: ldc 104
      //   675: new 106	java/lang/StringBuilder
      //   678: dup
      //   679: ldc 141
      //   681: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   684: aload 6
      //   686: invokevirtual 144	java/io/IOException:getMessage	()Ljava/lang/String;
      //   689: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   692: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   695: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   698: ldc 104
      //   700: aload 6
      //   702: ldc 149
      //   704: iconst_0
      //   705: anewarray 4	java/lang/Object
      //   708: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   711: goto -659 -> 52
      //   714: astore 7
      //   716: aconst_null
      //   717: astore 6
      //   719: aload 6
      //   721: ifnull +8 -> 729
      //   724: aload 6
      //   726: invokevirtual 139	java/net/Socket:close	()V
      //   729: sipush 29656
      //   732: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   735: aload 7
      //   737: athrow
      //   738: astore 6
      //   740: ldc 104
      //   742: new 106	java/lang/StringBuilder
      //   745: dup
      //   746: ldc 141
      //   748: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   751: aload 6
      //   753: invokevirtual 144	java/io/IOException:getMessage	()Ljava/lang/String;
      //   756: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   759: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   762: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   765: ldc 104
      //   767: aload 6
      //   769: ldc 149
      //   771: iconst_0
      //   772: anewarray 4	java/lang/Object
      //   775: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   778: goto -49 -> 729
      //   781: aload_0
      //   782: getfield 20	com/tencent/mm/plugin/traceroute/b/a$a:Nec	Lcom/tencent/mm/plugin/traceroute/b/a;
      //   785: aload_0
      //   786: getfield 25	com/tencent/mm/plugin/traceroute/b/a$a:ip	Ljava/lang/String;
      //   789: ldc 172
      //   791: iconst_1
      //   792: invokestatic 57	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   795: invokevirtual 61	com/tencent/mm/plugin/traceroute/b/a:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V
      //   798: sipush 29656
      //   801: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    public abstract void gse();
  }
  
  public static abstract interface c
  {
    public abstract void gsf();
  }
  
  public static abstract interface d
  {
    public abstract void onFinished();
  }
  
  public static abstract interface e
  {
    public abstract void gsg();
  }
  
  final class f
    extends ConcurrentHashMap<String, ConcurrentHashMap<Integer, StringBuilder>>
  {
    private final String Ned;
    
    private f()
    {
      AppMethodBeat.i(267402);
      this.Ned = ("https://" + WeChatHosts.domainString(R.l.host_weixin_qq_com));
      AppMethodBeat.o(267402);
    }
  }
  
  final class g
    implements Runnable
  {
    private String Nei;
    private boolean Nej;
    private Integer Nek;
    private String serverIP;
    
    public g(String paramString1, String paramString2, boolean paramBoolean, Integer paramInteger)
    {
      this.Nei = paramString1;
      this.serverIP = paramString2;
      this.Nej = paramBoolean;
      this.Nek = paramInteger;
    }
    
    public final void run()
    {
      AppMethodBeat.i(29659);
      a locala = a.this;
      String str2 = this.Nei;
      String str3 = this.serverIP;
      Integer localInteger = this.Nek;
      int i = 1;
      if (i <= 3)
      {
        Object localObject = b.T(new String[] { "ping", "-c 1", "-t 64", str2 });
        if (((List)localObject).size() != 2) {
          if (i == 3) {
            locala.c(str3, " router no response\n", localInteger);
          }
        }
        String str1;
        for (;;)
        {
          i += 1;
          break;
          locala.c(str3, " router no response", localInteger);
          continue;
          str1 = (String)((List)localObject).get(0);
          if (!Util.isNullOrNil(str1)) {
            break label159;
          }
          Log.e("MicroMsg.MMTraceRoute", "runcommand err ".concat(String.valueOf(str2)));
          locala.c(str3, "run command err ", localInteger);
        }
        label159:
        localObject = ((List)localObject).get(1).toString();
        if (b.bfj(str1) > 0)
        {
          str1 = b.bfi(str1);
          if (!Util.isNullOrNil(str1)) {
            str1 = String.format(" %sms ", new Object[] { str1 });
          }
        }
        for (;;)
        {
          localObject = str1;
          if (i == 3) {
            localObject = str1 + "\n";
          }
          locala.c(str3, (String)localObject, localInteger);
          break;
          if (!Util.isNullOrNil((String)localObject))
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
    private int Nel;
    private String ip;
    
    public h(String paramString, int paramInt)
    {
      this.ip = paramString;
      this.Nel = paramInt;
    }
    
    public final void run()
    {
      int j = 1;
      AppMethodBeat.i(29660);
      Log.i("MicroMsg.MMTraceRoute", "ttl= " + this.Nel);
      a locala = a.this;
      String str1 = this.ip;
      int m = this.Nel;
      Object localObject = b.T(new String[] { "ping", "-c 1", "-t " + String.valueOf(m), str1 });
      if (((List)localObject).size() != 2) {
        locala.c(str1, String.format("%d : can not get roupter ip\n", new Object[] { Integer.valueOf(m) }), Integer.valueOf(m + 1));
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
            Log.e("MicroMsg.MMTraceRoute", "runcommand err");
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
            if (!Util.isNullOrNil((String)localObject)) {
              break label363;
            }
            i = j;
            if (b.bfj(str2) > 0) {
              break label141;
            }
            localObject = String.format("%d : can not get roupter ip\n", new Object[] { Integer.valueOf(m) });
            Log.e("MicroMsg.MMTraceRoute", "can not get setData ip and ttl".concat(String.valueOf(str1)));
            locala.c(str1, (String)localObject, Integer.valueOf(m + 1));
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
            locala.c(str1, String.format("%d : FIN %s\n\n", new Object[] { Integer.valueOf(m), localObject }), Integer.valueOf(m + 1));
            i = j;
          }
          else
          {
            if (b.bfj(str2) <= 0) {
              break label498;
            }
            locala.c(str1, String.format("%d : FIN %s\n\n ", new Object[] { Integer.valueOf(m), localObject }), Integer.valueOf(m + 1));
            i = j;
            if (a.NdS != null)
            {
              a.NdS.execute(new a.g(locala, (String)localObject, str1, true, Integer.valueOf(m + 1)));
              i = j;
            }
          }
        }
        label498:
        locala.c(str1, String.format("%d : %s", new Object[] { Integer.valueOf(m), localObject }), Integer.valueOf(m + 1));
        if (a.NdS != null) {
          a.NdS.execute(new a.g(locala, (String)localObject, str1, false, Integer.valueOf(m + 1)));
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
      Object localObject2 = b.T(new String[] { "ping", "-c 1", "-t 64", this.ip });
      if (((List)localObject2).size() != 2)
      {
        a.this.c(this.ip, "failed to ping: \n" + this.ip, Integer.valueOf(0));
        AppMethodBeat.o(29661);
        return;
      }
      Object localObject1 = (String)((List)localObject2).get(0);
      if (Util.isNullOrNil((String)localObject1))
      {
        a.this.c(this.ip, "failed to ping: \n" + this.ip, Integer.valueOf(0));
        Log.e("MicroMsg.MMTraceRoute", "runcommand err");
        AppMethodBeat.o(29661);
        return;
      }
      int i = b.bfj((String)localObject1);
      if (i <= 0)
      {
        Log.e("MicroMsg.MMTraceRoute", "failed to touch server:" + this.ip);
        a.this.c(this.ip, "failed to touch server: " + this.ip + "\n", Integer.valueOf(0));
        AppMethodBeat.o(29661);
        return;
      }
      localObject2 = ((List)localObject2).get(1).toString();
      localObject1 = b.bfi((String)localObject1);
      if (!Util.isNullOrNil((String)localObject1)) {
        localObject1 = String.format("server: %s, TTL: %d, Time = %sms", new Object[] { this.ip, Integer.valueOf(i), localObject1 });
      }
      for (;;)
      {
        a.this.c(this.ip, (String)localObject1 + "\n", Integer.valueOf(0));
        int m = 64 - i + 5;
        i = m;
        int j = k;
        if (m < 0)
        {
          i = 64;
          j = k;
        }
        while ((j < i) && (!a.this.gsb()))
        {
          localObject1 = new a.h(a.this, this.ip, j);
          if (a.NdS != null) {
            a.NdS.execute((Runnable)localObject1);
          }
          j += 1;
        }
        if (!Util.isNullOrNil((String)localObject2)) {
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
      a.this.Al(false);
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      long l1 = Util.nowMilliSecond();
      Object localObject1 = new java.sql.Date(l1);
      Log.i("MicroMsg.MMTraceRoute", "mmtraceroute start time " + localSimpleDateFormat.format((java.util.Date)localObject1));
      localObject1 = a.this.NdW.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        a.i locali = new a.i(a.this, (String)((Map.Entry)localObject2).getKey());
        if (a.NdS != null) {
          a.NdS.execute(locali);
        }
        localObject2 = new a.a(a.this, (String)((Map.Entry)localObject2).getKey(), (Set)((Map.Entry)localObject2).getValue());
        if (a.NdS != null) {
          a.NdS.execute((Runnable)localObject2);
        }
      }
      try
      {
        do
        {
          Thread.sleep(500L);
          if ((a.this.gsb()) || (a.NdS.getActiveCount() <= 0)) {
            break;
          }
          Log.d("MicroMsg.MMTraceRoute", "task count: " + String.valueOf(a.NdS.getActiveCount()));
          l2 = Util.nowMilliSecond();
        } while (l2 - l1 < 120000L);
        Log.i("MicroMsg.MMTraceRoute", "traceroute timeout: " + (l2 - l1) / 1000L);
        a.this.Al(true);
        a.this.stop();
        if (a.this.NdX != null) {
          a.this.NdX.gsg();
        }
        AppMethodBeat.o(29662);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.MMTraceRoute", "wait for command end err: " + localException.getMessage());
          Log.printErrStackTrace("MicroMsg.MMTraceRoute", localException, "", new Object[0]);
        }
        long l2 = Util.nowMilliSecond();
        Log.i("MicroMsg.MMTraceRoute", "mmtraceroute end time " + localSimpleDateFormat.format(new java.util.Date(l2)));
        Log.i("MicroMsg.MMTraceRoute", "mmtraceroute total time " + (l2 - l1) / 1000L);
        if ((a.this.NdY != null) && (!a.this.gsb())) {
          a.this.NdY.onFinished();
        }
        AppMethodBeat.o(29662);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.b.a
 * JD-Core Version:    0.7.0.1
 */