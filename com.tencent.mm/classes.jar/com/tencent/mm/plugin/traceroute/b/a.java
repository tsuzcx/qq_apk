package com.tencent.mm.plugin.traceroute.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  public static String tmL;
  public static c tmM;
  private final String TAG;
  private final int tmN;
  private boolean tmO;
  a.f tmP;
  public Map<String, Set<Integer>> tmQ;
  public a.e tmR;
  public a.d tmS;
  public a.c tmT;
  public a.b tmU;
  String userName;
  
  public a(String paramString)
  {
    AppMethodBeat.i(25979);
    this.TAG = "MicroMsg.MMTraceRoute";
    this.tmN = 64;
    this.tmO = false;
    this.tmP = new a.f(this, (byte)0);
    this.tmQ = new HashMap();
    this.userName = paramString;
    tmL = h.getExternalStorageDirectory().getAbsolutePath() + "/tencent/traceroute_log_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString() + ".log";
    AppMethodBeat.o(25979);
  }
  
  final void a(String paramString1, String paramString2, Integer paramInteger)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(25982);
        if ((paramString1 == null) || (paramString2 == null) || (paramInteger.intValue() < 0))
        {
          AppMethodBeat.o(25982);
          return;
        }
        if (!this.tmP.containsKey(paramString1))
        {
          ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
          localConcurrentHashMap.put(paramInteger, new StringBuilder(paramString2));
          this.tmP.put(paramString1, (ConcurrentHashMap)localConcurrentHashMap);
          AppMethodBeat.o(25982);
          continue;
        }
        if (!((ConcurrentHashMap)this.tmP.get(paramString1)).containsKey(paramInteger)) {
          break label147;
        }
      }
      finally {}
      ((StringBuilder)((ConcurrentHashMap)this.tmP.get(paramString1)).get(paramInteger)).append(paramString2);
      AppMethodBeat.o(25982);
      continue;
      label147:
      new ConcurrentHashMap().put(paramInteger, new StringBuilder(paramString2));
      ((ConcurrentHashMap)this.tmP.get(paramString1)).put(paramInteger, new StringBuilder(paramString2));
      AppMethodBeat.o(25982);
    }
  }
  
  public final void c(String[] paramArrayOfString, boolean paramBoolean)
  {
    AppMethodBeat.i(25981);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      ab.e("MicroMsg.MMTraceRoute", "no ip contains");
      AppMethodBeat.o(25981);
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
      ab.e("MicroMsg.MMTraceRoute", "err ip ".concat(String.valueOf(localObject)));
    }
    for (;;)
    {
      i += 1;
      break label61;
      str = "" + "short: ";
      break;
      label140:
      if (!this.tmQ.containsKey(arrayOfString[0]))
      {
        localObject = new HashSet();
        ((Set)localObject).add(Integer.valueOf(bo.getInt(arrayOfString[1], 0)));
        this.tmQ.put(arrayOfString[0], localObject);
        str = str + arrayOfString[0] + " ";
      }
      else
      {
        ((Set)this.tmQ.get(arrayOfString[0])).add(Integer.valueOf(bo.getInt(arrayOfString[1], 0)));
      }
    }
    label268:
    paramArrayOfString = str + "\n";
    e.e(tmL, paramArrayOfString.getBytes());
    AppMethodBeat.o(25981);
  }
  
  final boolean cKF()
  {
    try
    {
      boolean bool = this.tmO;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void cKG()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 25983
    //   5: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 72	com/tencent/mm/plugin/traceroute/b/a:tmP	Lcom/tencent/mm/plugin/traceroute/b/a$f;
    //   12: ifnull +594 -> 606
    //   15: aload_0
    //   16: getfield 72	com/tencent/mm/plugin/traceroute/b/a:tmP	Lcom/tencent/mm/plugin/traceroute/b/a$f;
    //   19: astore 6
    //   21: new 90	java/io/File
    //   24: dup
    //   25: getstatic 123	com/tencent/mm/plugin/traceroute/b/a:tmL	Ljava/lang/String;
    //   28: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;)V
    //   31: astore 4
    //   33: aload 4
    //   35: invokevirtual 230	java/io/File:exists	()Z
    //   38: istore_3
    //   39: iload_3
    //   40: ifne +45 -> 85
    //   43: aload 4
    //   45: invokevirtual 233	java/io/File:createNewFile	()Z
    //   48: pop
    //   49: getstatic 123	com/tencent/mm/plugin/traceroute/b/a:tmL	Ljava/lang/String;
    //   52: new 81	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   59: aload 6
    //   61: getfield 237	com/tencent/mm/plugin/traceroute/b/a$f:tmW	Lcom/tencent/mm/plugin/traceroute/b/a;
    //   64: getfield 79	com/tencent/mm/plugin/traceroute/b/a:userName	Ljava/lang/String;
    //   67: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: ldc 212
    //   72: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokevirtual 216	java/lang/String:getBytes	()[B
    //   81: invokestatic 221	com/tencent/mm/a/e:e	(Ljava/lang/String;[B)I
    //   84: pop
    //   85: aload 6
    //   87: getfield 237	com/tencent/mm/plugin/traceroute/b/a$f:tmW	Lcom/tencent/mm/plugin/traceroute/b/a;
    //   90: getfield 72	com/tencent/mm/plugin/traceroute/b/a:tmP	Lcom/tencent/mm/plugin/traceroute/b/a$f;
    //   93: invokevirtual 241	com/tencent/mm/plugin/traceroute/b/a$f:entrySet	()Ljava/util/Set;
    //   96: invokeinterface 245 1 0
    //   101: astore 7
    //   103: aload 7
    //   105: invokeinterface 250 1 0
    //   110: ifeq +363 -> 473
    //   113: aload 7
    //   115: invokeinterface 254 1 0
    //   120: checkcast 256	java/util/Map$Entry
    //   123: invokeinterface 259 1 0
    //   128: checkcast 115	java/lang/String
    //   131: astore 8
    //   133: aload 8
    //   135: invokestatic 263	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   138: ifne -35 -> 103
    //   141: aload 6
    //   143: getfield 237	com/tencent/mm/plugin/traceroute/b/a$f:tmW	Lcom/tencent/mm/plugin/traceroute/b/a;
    //   146: getfield 72	com/tencent/mm/plugin/traceroute/b/a:tmP	Lcom/tencent/mm/plugin/traceroute/b/a$f;
    //   149: aload 8
    //   151: invokevirtual 139	com/tencent/mm/plugin/traceroute/b/a$f:containsKey	(Ljava/lang/Object;)Z
    //   154: ifeq -51 -> 103
    //   157: aload 6
    //   159: getfield 237	com/tencent/mm/plugin/traceroute/b/a$f:tmW	Lcom/tencent/mm/plugin/traceroute/b/a;
    //   162: getfield 72	com/tencent/mm/plugin/traceroute/b/a:tmP	Lcom/tencent/mm/plugin/traceroute/b/a$f;
    //   165: aload 8
    //   167: invokevirtual 154	com/tencent/mm/plugin/traceroute/b/a$f:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   170: checkcast 145	java/util/Map
    //   173: astore 9
    //   175: aload 9
    //   177: ifnull -74 -> 103
    //   180: ldc 169
    //   182: astore 4
    //   184: aload 9
    //   186: invokeinterface 266 1 0
    //   191: iconst_1
    //   192: if_icmpne +167 -> 359
    //   195: aload 9
    //   197: iconst_1
    //   198: invokestatic 202	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   201: invokeinterface 210 2 0
    //   206: ifnull +153 -> 359
    //   209: new 81	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   216: ldc 169
    //   218: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: aload 9
    //   223: iconst_1
    //   224: invokestatic 202	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   227: invokeinterface 210 2 0
    //   232: checkcast 81	java/lang/StringBuilder
    //   235: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: astore 5
    //   246: aload 5
    //   248: invokevirtual 269	java/lang/String:length	()I
    //   251: ifle -148 -> 103
    //   254: ldc 61
    //   256: new 81	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   263: aload 8
    //   265: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload 5
    //   270: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokestatic 271	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   279: getstatic 123	com/tencent/mm/plugin/traceroute/b/a:tmL	Ljava/lang/String;
    //   282: aload 5
    //   284: invokevirtual 216	java/lang/String:getBytes	()[B
    //   287: invokestatic 221	com/tencent/mm/a/e:e	(Ljava/lang/String;[B)I
    //   290: pop
    //   291: goto -188 -> 103
    //   294: astore 4
    //   296: aload_0
    //   297: monitorexit
    //   298: aload 4
    //   300: athrow
    //   301: astore 4
    //   303: ldc 61
    //   305: new 81	java/lang/StringBuilder
    //   308: dup
    //   309: ldc_w 273
    //   312: invokespecial 143	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   315: aload 4
    //   317: invokevirtual 276	java/io/IOException:getMessage	()Ljava/lang/String;
    //   320: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: invokestatic 167	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   329: ldc 61
    //   331: aload 4
    //   333: ldc 169
    //   335: iconst_0
    //   336: anewarray 4	java/lang/Object
    //   339: invokestatic 280	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   342: aload 6
    //   344: getfield 237	com/tencent/mm/plugin/traceroute/b/a$f:tmW	Lcom/tencent/mm/plugin/traceroute/b/a;
    //   347: invokevirtual 283	com/tencent/mm/plugin/traceroute/b/a:cKH	()V
    //   350: sipush 25983
    //   353: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   370: invokeinterface 266 1 0
    //   375: if_icmpge -129 -> 246
    //   378: aload 4
    //   380: astore 5
    //   382: iload_2
    //   383: ifne -137 -> 246
    //   386: aload 9
    //   388: iload_1
    //   389: invokestatic 202	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   392: invokeinterface 210 2 0
    //   397: ifnull +218 -> 615
    //   400: aload 9
    //   402: iload_1
    //   403: invokestatic 202	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   406: invokeinterface 210 2 0
    //   411: checkcast 81	java/lang/StringBuilder
    //   414: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: astore 10
    //   419: aload 10
    //   421: invokestatic 263	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   424: ifne +191 -> 615
    //   427: new 81	java/lang/StringBuilder
    //   430: dup
    //   431: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   434: aload 4
    //   436: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: aload 10
    //   441: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: astore 5
    //   449: aload 5
    //   451: astore 4
    //   453: aload 10
    //   455: ldc_w 285
    //   458: invokevirtual 289	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   461: ifeq +154 -> 615
    //   464: iconst_1
    //   465: istore_2
    //   466: aload 5
    //   468: astore 4
    //   470: goto +145 -> 615
    //   473: getstatic 123	com/tencent/mm/plugin/traceroute/b/a:tmL	Ljava/lang/String;
    //   476: iconst_0
    //   477: iconst_m1
    //   478: invokestatic 292	com/tencent/mm/a/e:i	(Ljava/lang/String;II)[B
    //   481: astore 5
    //   483: aload 5
    //   485: invokestatic 296	com/tencent/mm/sdk/platformtools/bo:ce	([B)Z
    //   488: ifeq +28 -> 516
    //   491: ldc 61
    //   493: ldc_w 298
    //   496: invokestatic 167	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   499: aload 6
    //   501: getfield 237	com/tencent/mm/plugin/traceroute/b/a$f:tmW	Lcom/tencent/mm/plugin/traceroute/b/a;
    //   504: invokevirtual 283	com/tencent/mm/plugin/traceroute/b/a:cKH	()V
    //   507: sipush 25983
    //   510: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   513: goto -157 -> 356
    //   516: aload 5
    //   518: arraylength
    //   519: istore_1
    //   520: ldc_w 300
    //   523: iconst_2
    //   524: anewarray 4	java/lang/Object
    //   527: dup
    //   528: iconst_0
    //   529: getstatic 305	com/tencent/mm/protocal/d:whH	I
    //   532: invokestatic 202	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   535: aastore
    //   536: dup
    //   537: iconst_1
    //   538: iload_1
    //   539: invokestatic 202	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   542: aastore
    //   543: invokestatic 308	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   546: invokevirtual 216	java/lang/String:getBytes	()[B
    //   549: invokestatic 314	com/tencent/mm/a/g:w	([B)Ljava/lang/String;
    //   552: invokevirtual 317	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   555: astore 4
    //   557: aload 5
    //   559: invokestatic 323	com/tencent/mm/a/r:compress	([B)[B
    //   562: astore 5
    //   564: new 325	com/tencent/mm/pointers/PByteArray
    //   567: dup
    //   568: invokespecial 326	com/tencent/mm/pointers/PByteArray:<init>	()V
    //   571: astore 7
    //   573: aload 7
    //   575: aload 5
    //   577: aload 4
    //   579: invokevirtual 216	java/lang/String:getBytes	()[B
    //   582: invokestatic 331	com/tencent/mm/a/c:a	(Lcom/tencent/mm/pointers/PByteArray;[B[B)I
    //   585: pop
    //   586: new 333	com/tencent/mm/plugin/traceroute/b/a$f$1
    //   589: dup
    //   590: aload 6
    //   592: iload_1
    //   593: aload 4
    //   595: aload 7
    //   597: invokespecial 336	com/tencent/mm/plugin/traceroute/b/a$f$1:<init>	(Lcom/tencent/mm/plugin/traceroute/b/a$f;ILjava/lang/String;Lcom/tencent/mm/pointers/PByteArray;)V
    //   600: ldc_w 338
    //   603: invokestatic 344	com/tencent/mm/sdk/g/d:post	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   606: sipush 25983
    //   609: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   19	572	6	localf	a.f
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
  
  final void cKH()
  {
    AppMethodBeat.i(25984);
    if (this.tmU != null) {
      this.tmU.cKI();
    }
    AppMethodBeat.o(25984);
  }
  
  final void mD(boolean paramBoolean)
  {
    try
    {
      this.tmO = paramBoolean;
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
    AppMethodBeat.i(25980);
    mD(true);
    if (tmM != null) {
      try
      {
        tmM.shutdownNow();
        AppMethodBeat.o(25980);
        return;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.MMTraceRoute", "failed to shutdown threadpool: " + localException.getMessage());
      }
    }
    AppMethodBeat.o(25980);
  }
  
  final class g
    implements Runnable
  {
    private String serverIP;
    private String tnb;
    private boolean tnc;
    private Integer tnd;
    
    public g(String paramString1, String paramString2, boolean paramBoolean, Integer paramInteger)
    {
      this.tnb = paramString1;
      this.serverIP = paramString2;
      this.tnc = paramBoolean;
      this.tnd = paramInteger;
    }
    
    public final void run()
    {
      AppMethodBeat.i(25975);
      a locala = a.this;
      String str2 = this.tnb;
      String str3 = this.serverIP;
      Integer localInteger = this.tnd;
      int i = 1;
      if (i <= 3)
      {
        Object localObject = b.J(new String[] { "ping", "-c 1", "-t 64", str2 });
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
          if (!bo.isNullOrNil(str1)) {
            break label159;
          }
          ab.e("MicroMsg.MMTraceRoute", "runcommand err ".concat(String.valueOf(str2)));
          locala.a(str3, "run command err ", localInteger);
        }
        label159:
        localObject = ((List)localObject).get(1).toString();
        if (b.aev(str1) > 0)
        {
          str1 = b.aeu(str1);
          if (!bo.isNullOrNil(str1)) {
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
          if (!bo.isNullOrNil((String)localObject))
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
      AppMethodBeat.o(25975);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.b.a
 * JD-Core Version:    0.7.0.1
 */