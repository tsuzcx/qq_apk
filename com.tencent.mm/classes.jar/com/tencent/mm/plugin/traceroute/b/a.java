package com.tencent.mm.plugin.traceroute.b;

import com.tencent.mm.a.e;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  public static String pIx;
  public static c pIy;
  private final String TAG = "MicroMsg.MMTraceRoute";
  private boolean pIA = false;
  f pIB = new f((byte)0);
  public Map<String, Set<Integer>> pIC = new HashMap();
  public a.e pID;
  public a.d pIE;
  public a.c pIF;
  public a.b pIG;
  private final int pIz = 64;
  String userName;
  
  public a(String paramString)
  {
    this.userName = paramString;
    pIx = h.getExternalStorageDirectory().getAbsolutePath() + "/tencent/traceroute_log_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString() + ".log";
  }
  
  final void a(String paramString1, String paramString2, Integer paramInteger)
  {
    if ((paramString1 != null) && (paramString2 != null)) {}
    for (;;)
    {
      try
      {
        int i = paramInteger.intValue();
        if (i < 0) {
          return;
        }
        if (!this.pIB.containsKey(paramString1))
        {
          ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
          localConcurrentHashMap.put(paramInteger, new StringBuilder(paramString2));
          this.pIB.put(paramString1, (ConcurrentHashMap)localConcurrentHashMap);
          continue;
        }
        if (!((ConcurrentHashMap)this.pIB.get(paramString1)).containsKey(paramInteger)) {
          break label127;
        }
      }
      finally {}
      ((StringBuilder)((ConcurrentHashMap)this.pIB.get(paramString1)).get(paramInteger)).append(paramString2);
      continue;
      label127:
      new ConcurrentHashMap().put(paramInteger, new StringBuilder(paramString2));
      ((ConcurrentHashMap)this.pIB.get(paramString1)).put(paramInteger, new StringBuilder(paramString2));
    }
  }
  
  public final void b(String[] paramArrayOfString, boolean paramBoolean)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      y.e("MicroMsg.MMTraceRoute", "no ip contains");
      return;
    }
    String str;
    int i;
    label49:
    Object localObject;
    String[] arrayOfString;
    if (paramBoolean)
    {
      str = "" + "long: ";
      int j = paramArrayOfString.length;
      i = 0;
      if (i >= j) {
        break label263;
      }
      localObject = paramArrayOfString[i];
      arrayOfString = ((String)localObject).split(":");
      if ((arrayOfString != null) && (arrayOfString.length == 3)) {
        break label135;
      }
      y.e("MicroMsg.MMTraceRoute", "err ip " + (String)localObject);
    }
    for (;;)
    {
      i += 1;
      break label49;
      str = "" + "short: ";
      break;
      label135:
      if (!this.pIC.containsKey(arrayOfString[0]))
      {
        localObject = new HashSet();
        ((Set)localObject).add(Integer.valueOf(bk.getInt(arrayOfString[1], 0)));
        this.pIC.put(arrayOfString[0], localObject);
        str = str + arrayOfString[0] + " ";
      }
      else
      {
        ((Set)this.pIC.get(arrayOfString[0])).add(Integer.valueOf(bk.getInt(arrayOfString[1], 0)));
      }
    }
    label263:
    paramArrayOfString = str + "\n";
    e.e(pIx, paramArrayOfString.getBytes());
  }
  
  final boolean bOK()
  {
    try
    {
      boolean bool = this.pIA;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void bOL()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 69	com/tencent/mm/plugin/traceroute/b/a:pIB	Lcom/tencent/mm/plugin/traceroute/b/a$f;
    //   6: ifnull +338 -> 344
    //   9: aload_0
    //   10: getfield 69	com/tencent/mm/plugin/traceroute/b/a:pIB	Lcom/tencent/mm/plugin/traceroute/b/a$f;
    //   13: astore 6
    //   15: new 87	java/io/File
    //   18: dup
    //   19: getstatic 120	com/tencent/mm/plugin/traceroute/b/a:pIx	Ljava/lang/String;
    //   22: invokespecial 220	java/io/File:<init>	(Ljava/lang/String;)V
    //   25: astore 4
    //   27: aload 4
    //   29: invokevirtual 223	java/io/File:exists	()Z
    //   32: istore_3
    //   33: iload_3
    //   34: ifne +45 -> 79
    //   37: aload 4
    //   39: invokevirtual 226	java/io/File:createNewFile	()Z
    //   42: pop
    //   43: getstatic 120	com/tencent/mm/plugin/traceroute/b/a:pIx	Ljava/lang/String;
    //   46: new 78	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   53: aload 6
    //   55: getfield 230	com/tencent/mm/plugin/traceroute/b/a$f:pII	Lcom/tencent/mm/plugin/traceroute/b/a;
    //   58: getfield 76	com/tencent/mm/plugin/traceroute/b/a:userName	Ljava/lang/String;
    //   61: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: ldc 205
    //   66: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokevirtual 209	java/lang/String:getBytes	()[B
    //   75: invokestatic 214	com/tencent/mm/a/e:e	(Ljava/lang/String;[B)I
    //   78: pop
    //   79: aload 6
    //   81: getfield 230	com/tencent/mm/plugin/traceroute/b/a$f:pII	Lcom/tencent/mm/plugin/traceroute/b/a;
    //   84: getfield 69	com/tencent/mm/plugin/traceroute/b/a:pIB	Lcom/tencent/mm/plugin/traceroute/b/a$f;
    //   87: invokevirtual 234	com/tencent/mm/plugin/traceroute/b/a$f:entrySet	()Ljava/util/Set;
    //   90: invokeinterface 238 1 0
    //   95: astore 7
    //   97: aload 7
    //   99: invokeinterface 243 1 0
    //   104: ifeq +357 -> 461
    //   107: aload 7
    //   109: invokeinterface 247 1 0
    //   114: checkcast 249	java/util/Map$Entry
    //   117: invokeinterface 252 1 0
    //   122: checkcast 112	java/lang/String
    //   125: astore 8
    //   127: aload 8
    //   129: invokestatic 256	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   132: ifne -35 -> 97
    //   135: aload 6
    //   137: getfield 230	com/tencent/mm/plugin/traceroute/b/a$f:pII	Lcom/tencent/mm/plugin/traceroute/b/a;
    //   140: getfield 69	com/tencent/mm/plugin/traceroute/b/a:pIB	Lcom/tencent/mm/plugin/traceroute/b/a$f;
    //   143: aload 8
    //   145: invokevirtual 139	com/tencent/mm/plugin/traceroute/b/a$f:containsKey	(Ljava/lang/Object;)Z
    //   148: ifeq -51 -> 97
    //   151: aload 6
    //   153: getfield 230	com/tencent/mm/plugin/traceroute/b/a$f:pII	Lcom/tencent/mm/plugin/traceroute/b/a;
    //   156: getfield 69	com/tencent/mm/plugin/traceroute/b/a:pIB	Lcom/tencent/mm/plugin/traceroute/b/a$f;
    //   159: aload 8
    //   161: invokevirtual 154	com/tencent/mm/plugin/traceroute/b/a$f:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   164: checkcast 145	java/util/Map
    //   167: astore 9
    //   169: aload 9
    //   171: ifnull -74 -> 97
    //   174: ldc 169
    //   176: astore 4
    //   178: aload 9
    //   180: invokeinterface 259 1 0
    //   185: iconst_1
    //   186: if_icmpne +161 -> 347
    //   189: aload 9
    //   191: iconst_1
    //   192: invokestatic 195	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   195: invokeinterface 203 2 0
    //   200: ifnull +147 -> 347
    //   203: new 78	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   210: ldc 169
    //   212: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload 9
    //   217: iconst_1
    //   218: invokestatic 195	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   221: invokeinterface 203 2 0
    //   226: checkcast 78	java/lang/StringBuilder
    //   229: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: astore 5
    //   240: aload 5
    //   242: invokevirtual 262	java/lang/String:length	()I
    //   245: ifle -148 -> 97
    //   248: ldc 58
    //   250: new 78	java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   257: aload 8
    //   259: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: aload 5
    //   264: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 264	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   273: getstatic 120	com/tencent/mm/plugin/traceroute/b/a:pIx	Ljava/lang/String;
    //   276: aload 5
    //   278: invokevirtual 209	java/lang/String:getBytes	()[B
    //   281: invokestatic 214	com/tencent/mm/a/e:e	(Ljava/lang/String;[B)I
    //   284: pop
    //   285: goto -188 -> 97
    //   288: astore 4
    //   290: aload_0
    //   291: monitorexit
    //   292: aload 4
    //   294: athrow
    //   295: astore 4
    //   297: ldc 58
    //   299: new 78	java/lang/StringBuilder
    //   302: dup
    //   303: ldc_w 266
    //   306: invokespecial 143	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   309: aload 4
    //   311: invokevirtual 269	java/io/IOException:getMessage	()Ljava/lang/String;
    //   314: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokestatic 167	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   323: ldc 58
    //   325: aload 4
    //   327: ldc 169
    //   329: iconst_0
    //   330: anewarray 4	java/lang/Object
    //   333: invokestatic 273	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   336: aload 6
    //   338: getfield 230	com/tencent/mm/plugin/traceroute/b/a$f:pII	Lcom/tencent/mm/plugin/traceroute/b/a;
    //   341: invokestatic 275	com/tencent/mm/plugin/traceroute/b/a:a	(Lcom/tencent/mm/plugin/traceroute/b/a;)V
    //   344: aload_0
    //   345: monitorexit
    //   346: return
    //   347: iconst_0
    //   348: istore_1
    //   349: iconst_0
    //   350: istore_2
    //   351: aload 4
    //   353: astore 5
    //   355: iload_1
    //   356: aload 9
    //   358: invokeinterface 259 1 0
    //   363: if_icmpge -123 -> 240
    //   366: aload 4
    //   368: astore 5
    //   370: iload_2
    //   371: ifne -131 -> 240
    //   374: aload 9
    //   376: iload_1
    //   377: invokestatic 195	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   380: invokeinterface 203 2 0
    //   385: ifnull +206 -> 591
    //   388: aload 9
    //   390: iload_1
    //   391: invokestatic 195	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   394: invokeinterface 203 2 0
    //   399: checkcast 78	java/lang/StringBuilder
    //   402: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: astore 10
    //   407: aload 10
    //   409: invokestatic 256	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   412: ifne +179 -> 591
    //   415: new 78	java/lang/StringBuilder
    //   418: dup
    //   419: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   422: aload 4
    //   424: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload 10
    //   429: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: astore 5
    //   437: aload 5
    //   439: astore 4
    //   441: aload 10
    //   443: ldc_w 277
    //   446: invokevirtual 281	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   449: ifeq +142 -> 591
    //   452: iconst_1
    //   453: istore_2
    //   454: aload 5
    //   456: astore 4
    //   458: goto +133 -> 591
    //   461: getstatic 120	com/tencent/mm/plugin/traceroute/b/a:pIx	Ljava/lang/String;
    //   464: iconst_0
    //   465: iconst_m1
    //   466: invokestatic 285	com/tencent/mm/a/e:c	(Ljava/lang/String;II)[B
    //   469: astore 5
    //   471: aload 5
    //   473: invokestatic 289	com/tencent/mm/sdk/platformtools/bk:bE	([B)Z
    //   476: ifeq +22 -> 498
    //   479: ldc 58
    //   481: ldc_w 291
    //   484: invokestatic 167	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   487: aload 6
    //   489: getfield 230	com/tencent/mm/plugin/traceroute/b/a$f:pII	Lcom/tencent/mm/plugin/traceroute/b/a;
    //   492: invokestatic 275	com/tencent/mm/plugin/traceroute/b/a:a	(Lcom/tencent/mm/plugin/traceroute/b/a;)V
    //   495: goto -151 -> 344
    //   498: aload 5
    //   500: arraylength
    //   501: istore_1
    //   502: ldc_w 293
    //   505: iconst_2
    //   506: anewarray 4	java/lang/Object
    //   509: dup
    //   510: iconst_0
    //   511: getstatic 298	com/tencent/mm/protocal/d:spa	I
    //   514: invokestatic 195	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   517: aastore
    //   518: dup
    //   519: iconst_1
    //   520: iload_1
    //   521: invokestatic 195	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   524: aastore
    //   525: invokestatic 301	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   528: invokevirtual 209	java/lang/String:getBytes	()[B
    //   531: invokestatic 307	com/tencent/mm/a/g:o	([B)Ljava/lang/String;
    //   534: invokevirtual 310	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   537: astore 4
    //   539: aload 5
    //   541: invokestatic 316	com/tencent/mm/a/q:l	([B)[B
    //   544: astore 5
    //   546: new 318	com/tencent/mm/pointers/PByteArray
    //   549: dup
    //   550: invokespecial 319	com/tencent/mm/pointers/PByteArray:<init>	()V
    //   553: astore 7
    //   555: aload 7
    //   557: aload 5
    //   559: aload 4
    //   561: invokevirtual 209	java/lang/String:getBytes	()[B
    //   564: invokestatic 324	com/tencent/mm/a/c:a	(Lcom/tencent/mm/pointers/PByteArray;[B[B)I
    //   567: pop
    //   568: new 326	com/tencent/mm/plugin/traceroute/b/a$f$1
    //   571: dup
    //   572: aload 6
    //   574: iload_1
    //   575: aload 4
    //   577: aload 7
    //   579: invokespecial 329	com/tencent/mm/plugin/traceroute/b/a$f$1:<init>	(Lcom/tencent/mm/plugin/traceroute/b/a$f;ILjava/lang/String;Lcom/tencent/mm/pointers/PByteArray;)V
    //   582: ldc_w 331
    //   585: invokestatic 337	com/tencent/mm/sdk/f/e:post	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   588: goto -244 -> 344
    //   591: iload_1
    //   592: iconst_1
    //   593: iadd
    //   594: istore_1
    //   595: goto -244 -> 351
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	598	0	this	a
    //   348	247	1	i	int
    //   350	104	2	j	int
    //   32	2	3	bool	boolean
    //   25	152	4	localObject1	Object
    //   288	5	4	localObject2	Object
    //   295	128	4	localIOException	java.io.IOException
    //   439	137	4	localObject3	Object
    //   238	320	5	localObject4	Object
    //   13	560	6	localf	f
    //   95	483	7	localObject5	Object
    //   125	133	8	str1	String
    //   167	222	9	localMap	Map
    //   405	37	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   2	33	288	finally
    //   37	79	288	finally
    //   79	97	288	finally
    //   97	169	288	finally
    //   178	240	288	finally
    //   240	285	288	finally
    //   297	344	288	finally
    //   355	366	288	finally
    //   374	437	288	finally
    //   441	452	288	finally
    //   461	495	288	finally
    //   498	588	288	finally
    //   37	79	295	java/io/IOException
  }
  
  final void jM(boolean paramBoolean)
  {
    try
    {
      this.pIA = paramBoolean;
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
    jM(true);
    if (pIy != null) {}
    try
    {
      pIy.shutdownNow();
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.MMTraceRoute", "failed to shutdown threadpool: " + localException.getMessage());
    }
  }
  
  private final class f
    extends ConcurrentHashMap<String, ConcurrentHashMap<Integer, StringBuilder>>
  {
    private f() {}
  }
  
  private final class g
    implements Runnable
  {
    private String pIN;
    private boolean pIO;
    private Integer pIP;
    private String serverIP;
    
    public g(String paramString1, String paramString2, boolean paramBoolean, Integer paramInteger)
    {
      this.pIN = paramString1;
      this.serverIP = paramString2;
      this.pIO = paramBoolean;
      this.pIP = paramInteger;
    }
    
    public final void run()
    {
      a locala = a.this;
      String str2 = this.pIN;
      String str3 = this.serverIP;
      Integer localInteger = this.pIP;
      int i = 1;
      if (i <= 3)
      {
        Object localObject = b.B(new String[] { "ping", "-c 1", "-t 64", str2 });
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
          if (!bk.bl(str1)) {
            break label160;
          }
          y.e("MicroMsg.MMTraceRoute", "runcommand err " + str2);
          locala.a(str3, "run command err ", localInteger);
        }
        label160:
        localObject = ((List)localObject).get(1).toString();
        if (b.PS(str1) > 0)
        {
          str1 = b.PR(str1);
          if (!bk.bl(str1)) {
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
          if (!bk.bl((String)localObject))
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
    }
  }
  
  private final class h
    implements Runnable
  {
    private String ip;
    private int pIQ;
    
    public h(String paramString, int paramInt)
    {
      this.ip = paramString;
      this.pIQ = paramInt;
    }
    
    public final void run()
    {
      int j = 1;
      y.i("MicroMsg.MMTraceRoute", "ttl= " + this.pIQ);
      a locala = a.this;
      String str1 = this.ip;
      int m = this.pIQ;
      Object localObject = b.B(new String[] { "ping", "-c 1", "-t " + String.valueOf(m), str1 });
      if (((List)localObject).size() != 2) {
        locala.a(str1, String.format("%d : can not get roupter ip\n", new Object[] { Integer.valueOf(m) }), Integer.valueOf(m + 1));
      }
      for (;;)
      {
        int i = 0;
        for (;;)
        {
          label135:
          if (i != 0) {}
          return;
          String str2 = (String)((List)localObject).get(0);
          if (str2.length() == 0)
          {
            y.e("MicroMsg.MMTraceRoute", "runcommand err");
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
            if (!bk.bl((String)localObject)) {
              break label358;
            }
            i = j;
            if (b.PS(str2) > 0) {
              break label135;
            }
            localObject = String.format("%d : can not get roupter ip\n", new Object[] { Integer.valueOf(m) });
            y.e("MicroMsg.MMTraceRoute", "can not get route ip and ttl" + str1);
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
          label358:
          if (str1.equals(localObject))
          {
            locala.a(str1, String.format("%d : FIN %s\n\n", new Object[] { Integer.valueOf(m), localObject }), Integer.valueOf(m + 1));
            i = j;
          }
          else
          {
            if (b.PS(str2) <= 0) {
              break label493;
            }
            locala.a(str1, String.format("%d : FIN %s\n\n ", new Object[] { Integer.valueOf(m), localObject }), Integer.valueOf(m + 1));
            i = j;
            if (a.pIy != null)
            {
              a.pIy.execute(new a.g(locala, (String)localObject, str1, true, Integer.valueOf(m + 1)));
              i = j;
            }
          }
        }
        label493:
        locala.a(str1, String.format("%d : %s", new Object[] { Integer.valueOf(m), localObject }), Integer.valueOf(m + 1));
        if (a.pIy != null) {
          a.pIy.execute(new a.g(locala, (String)localObject, str1, false, Integer.valueOf(m + 1)));
        }
      }
    }
  }
  
  private final class i
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
      Object localObject2 = b.B(new String[] { "ping", "-c 1", "-t 64", this.ip });
      if (((List)localObject2).size() != 2)
      {
        a.this.a(this.ip, "failed to ping: \n" + this.ip, Integer.valueOf(0));
        return;
      }
      Object localObject1 = (String)((List)localObject2).get(0);
      if (bk.bl((String)localObject1))
      {
        a.this.a(this.ip, "failed to ping: \n" + this.ip, Integer.valueOf(0));
        y.e("MicroMsg.MMTraceRoute", "runcommand err");
        return;
      }
      int i = b.PS((String)localObject1);
      if (i <= 0)
      {
        y.e("MicroMsg.MMTraceRoute", "failed to touch server:" + this.ip);
        a.this.a(this.ip, "failed to touch server: " + this.ip + "\n", Integer.valueOf(0));
        return;
      }
      localObject2 = ((List)localObject2).get(1).toString();
      localObject1 = b.PR((String)localObject1);
      if (!bk.bl((String)localObject1)) {
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
        while ((j < i) && (!a.this.bOK()))
        {
          localObject1 = new a.h(a.this, this.ip, j);
          if (a.pIy != null) {
            a.pIy.execute((Runnable)localObject1);
          }
          j += 1;
        }
        break;
        if (!bk.bl((String)localObject2)) {
          localObject1 = String.format("server: %s, TTL: %d, Time = %sms", new Object[] { this.ip, Integer.valueOf(i), localObject2 });
        } else {
          localObject1 = String.format("server: %s, TTL: %d, Time = %sms", new Object[] { this.ip, Integer.valueOf(i), "unknown" });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.b.a
 * JD-Core Version:    0.7.0.1
 */