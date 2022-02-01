package com.tencent.mm.plugin.performance.c;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
  implements Runnable
{
  private static final a wJm;
  private static final Set<String> wJv;
  private boolean wJn;
  private boolean wJo;
  private boolean wJp;
  private boolean wJq;
  private int wJr;
  private int wJs;
  private Map<String, Map<String, Integer>> wJt;
  private Map<String, Integer> wJu;
  
  static
  {
    AppMethodBeat.i(211774);
    wJm = new a();
    HashSet localHashSet = new HashSet();
    wJv = localHashSet;
    localHashSet.add("anon_inode:sync_file");
    AppMethodBeat.o(211774);
  }
  
  private a()
  {
    AppMethodBeat.i(211769);
    this.wJt = new HashMap();
    this.wJu = new HashMap();
    AppMethodBeat.o(211769);
  }
  
  private int a(a parama)
  {
    AppMethodBeat.i(211771);
    parama = (Integer)this.wJu.get(parama.name());
    if (parama == null)
    {
      AppMethodBeat.o(211771);
      return 0;
    }
    int i = parama.intValue();
    AppMethodBeat.o(211771);
    return i;
  }
  
  private static boolean aut(String paramString)
  {
    AppMethodBeat.i(211773);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(211773);
      return true;
    }
    Iterator localIterator = wJv.iterator();
    while (localIterator.hasNext()) {
      if (paramString.matches((String)localIterator.next()))
      {
        AppMethodBeat.o(211773);
        return true;
      }
    }
    AppMethodBeat.o(211773);
    return false;
  }
  
  public static a dyX()
  {
    return wJm;
  }
  
  /* Error */
  private int dyY()
  {
    // Byte code:
    //   0: ldc 123
    //   2: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 129	java/lang/System:currentTimeMillis	()J
    //   8: lstore 6
    //   10: aload_0
    //   11: iconst_0
    //   12: putfield 131	com/tencent/mm/plugin/performance/c/a:wJr	I
    //   15: new 133	com/tencent/mm/vfs/e
    //   18: dup
    //   19: ldc 135
    //   21: iconst_1
    //   22: anewarray 4	java/lang/Object
    //   25: dup
    //   26: iconst_0
    //   27: invokestatic 140	android/os/Process:myPid	()I
    //   30: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   33: aastore
    //   34: invokestatic 148	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   37: invokespecial 151	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   40: astore 8
    //   42: aload 8
    //   44: invokevirtual 154	com/tencent/mm/vfs/e:exists	()Z
    //   47: ifne +46 -> 93
    //   50: getstatic 160	com/tencent/mm/plugin/report/e:ygI	Lcom/tencent/mm/plugin/report/e;
    //   53: ldc2_w 161
    //   56: ldc2_w 163
    //   59: lconst_1
    //   60: iconst_0
    //   61: invokevirtual 168	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   64: ldc 170
    //   66: ldc 172
    //   68: iconst_1
    //   69: anewarray 4	java/lang/Object
    //   72: dup
    //   73: iconst_0
    //   74: aload 8
    //   76: getfield 176	com/tencent/mm/vfs/e:mUri	Landroid/net/Uri;
    //   79: invokestatic 182	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   82: aastore
    //   83: invokestatic 188	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   86: ldc 123
    //   88: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: iconst_0
    //   92: ireturn
    //   93: aload_0
    //   94: getfield 69	com/tencent/mm/plugin/performance/c/a:wJt	Ljava/util/Map;
    //   97: invokeinterface 191 1 0
    //   102: aload_0
    //   103: getfield 71	com/tencent/mm/plugin/performance/c/a:wJu	Ljava/util/Map;
    //   106: invokeinterface 191 1 0
    //   111: aload 8
    //   113: invokevirtual 195	com/tencent/mm/vfs/e:fOM	()[Lcom/tencent/mm/vfs/e;
    //   116: astore 11
    //   118: aload 11
    //   120: ifnonnull +17 -> 137
    //   123: ldc 170
    //   125: ldc 197
    //   127: invokestatic 200	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: ldc 123
    //   132: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: iconst_0
    //   136: ireturn
    //   137: aload 11
    //   139: arraylength
    //   140: istore_3
    //   141: aload 11
    //   143: arraylength
    //   144: istore 4
    //   146: iconst_0
    //   147: istore_1
    //   148: iload_1
    //   149: iload 4
    //   151: if_icmpge +485 -> 636
    //   154: aload 11
    //   156: iload_1
    //   157: aaload
    //   158: invokevirtual 204	com/tencent/mm/vfs/e:fOK	()Landroid/net/Uri;
    //   161: invokestatic 182	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   164: astore 9
    //   166: new 206	java/io/File
    //   169: dup
    //   170: aload 9
    //   172: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   175: invokevirtual 210	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   178: astore 10
    //   180: aload 9
    //   182: aload 10
    //   184: invokevirtual 213	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   187: ifne +15 -> 202
    //   190: aload 10
    //   192: astore 8
    //   194: aload 10
    //   196: invokestatic 98	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   199: ifeq +457 -> 656
    //   202: aload 9
    //   204: invokestatic 219	com/tencent/wxperf/fd/FDDumpBridge:bar	(Ljava/lang/String;)Ljava/lang/String;
    //   207: astore 10
    //   209: aload 10
    //   211: astore 8
    //   213: aload 10
    //   215: invokestatic 98	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   218: ifeq +438 -> 656
    //   221: ldc 170
    //   223: ldc 221
    //   225: iconst_1
    //   226: anewarray 4	java/lang/Object
    //   229: dup
    //   230: iconst_0
    //   231: aload 9
    //   233: aastore
    //   234: invokestatic 188	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   237: getstatic 160	com/tencent/mm/plugin/report/e:ygI	Lcom/tencent/mm/plugin/report/e;
    //   240: ldc2_w 161
    //   243: ldc2_w 222
    //   246: lconst_1
    //   247: iconst_0
    //   248: invokevirtual 168	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   251: aload 9
    //   253: astore 8
    //   255: aload 8
    //   257: invokestatic 225	com/tencent/mm/plugin/performance/c/a:aut	(Ljava/lang/String;)Z
    //   260: ifeq +32 -> 292
    //   263: ldc 170
    //   265: ldc 227
    //   267: iconst_1
    //   268: anewarray 4	java/lang/Object
    //   271: dup
    //   272: iconst_0
    //   273: aload 8
    //   275: aastore
    //   276: invokestatic 229	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   279: aload_0
    //   280: aload_0
    //   281: getfield 131	com/tencent/mm/plugin/performance/c/a:wJr	I
    //   284: iconst_1
    //   285: iadd
    //   286: putfield 131	com/tencent/mm/plugin/performance/c/a:wJr	I
    //   289: goto +370 -> 659
    //   292: invokestatic 233	com/tencent/mm/plugin/performance/c/a$a:values	()[Lcom/tencent/mm/plugin/performance/c/a$a;
    //   295: astore 9
    //   297: aload 9
    //   299: arraylength
    //   300: istore 5
    //   302: iconst_0
    //   303: istore_2
    //   304: iload_2
    //   305: iload 5
    //   307: if_icmpge +352 -> 659
    //   310: aload 9
    //   312: iload_2
    //   313: aaload
    //   314: astore 10
    //   316: aload 8
    //   318: aload 10
    //   320: invokestatic 237	com/tencent/mm/plugin/performance/c/a$a:b	(Lcom/tencent/mm/plugin/performance/c/a$a;)Ljava/lang/String;
    //   323: invokevirtual 117	java/lang/String:matches	(Ljava/lang/String;)Z
    //   326: ifeq +303 -> 629
    //   329: aload_0
    //   330: getfield 69	com/tencent/mm/plugin/performance/c/a:wJt	Ljava/util/Map;
    //   333: aload 10
    //   335: invokevirtual 77	com/tencent/mm/plugin/performance/c/a$a:name	()Ljava/lang/String;
    //   338: invokeinterface 83 2 0
    //   343: checkcast 79	java/util/Map
    //   346: astore 9
    //   348: aload 9
    //   350: ifnonnull +303 -> 653
    //   353: new 66	java/util/HashMap
    //   356: dup
    //   357: invokespecial 67	java/util/HashMap:<init>	()V
    //   360: astore 9
    //   362: aload_0
    //   363: getfield 69	com/tencent/mm/plugin/performance/c/a:wJt	Ljava/util/Map;
    //   366: aload 10
    //   368: invokevirtual 77	com/tencent/mm/plugin/performance/c/a$a:name	()Ljava/lang/String;
    //   371: aload 9
    //   373: invokeinterface 241 3 0
    //   378: pop
    //   379: aload 9
    //   381: aload 8
    //   383: invokeinterface 83 2 0
    //   388: checkcast 85	java/lang/Integer
    //   391: astore 12
    //   393: aload 12
    //   395: ifnonnull +173 -> 568
    //   398: aload 9
    //   400: aload 8
    //   402: iconst_1
    //   403: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   406: invokeinterface 241 3 0
    //   411: pop
    //   412: aload_0
    //   413: getfield 71	com/tencent/mm/plugin/performance/c/a:wJu	Ljava/util/Map;
    //   416: aload 10
    //   418: invokevirtual 77	com/tencent/mm/plugin/performance/c/a$a:name	()Ljava/lang/String;
    //   421: invokeinterface 83 2 0
    //   426: checkcast 85	java/lang/Integer
    //   429: astore 8
    //   431: aload 8
    //   433: ifnonnull +168 -> 601
    //   436: aload_0
    //   437: getfield 71	com/tencent/mm/plugin/performance/c/a:wJu	Ljava/util/Map;
    //   440: aload 10
    //   442: invokevirtual 77	com/tencent/mm/plugin/performance/c/a$a:name	()Ljava/lang/String;
    //   445: iconst_1
    //   446: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   449: invokeinterface 241 3 0
    //   454: pop
    //   455: goto +204 -> 659
    //   458: astore 8
    //   460: iload_3
    //   461: istore_1
    //   462: getstatic 160	com/tencent/mm/plugin/report/e:ygI	Lcom/tencent/mm/plugin/report/e;
    //   465: ldc2_w 161
    //   468: ldc2_w 242
    //   471: lconst_1
    //   472: iconst_0
    //   473: invokevirtual 168	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   476: ldc 170
    //   478: aload 8
    //   480: ldc 245
    //   482: iconst_0
    //   483: anewarray 4	java/lang/Object
    //   486: invokestatic 249	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   489: iload_1
    //   490: aload_0
    //   491: getfield 131	com/tencent/mm/plugin/performance/c/a:wJr	I
    //   494: isub
    //   495: istore_1
    //   496: iload_1
    //   497: ifgt +24 -> 521
    //   500: ldc 170
    //   502: ldc 251
    //   504: invokestatic 200	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   507: getstatic 160	com/tencent/mm/plugin/report/e:ygI	Lcom/tencent/mm/plugin/report/e;
    //   510: ldc2_w 161
    //   513: ldc2_w 252
    //   516: lconst_1
    //   517: iconst_0
    //   518: invokevirtual 168	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   521: ldc 170
    //   523: ldc 255
    //   525: iconst_3
    //   526: anewarray 4	java/lang/Object
    //   529: dup
    //   530: iconst_0
    //   531: invokestatic 129	java/lang/System:currentTimeMillis	()J
    //   534: lload 6
    //   536: lsub
    //   537: invokestatic 260	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   540: aastore
    //   541: dup
    //   542: iconst_1
    //   543: iload_1
    //   544: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   547: aastore
    //   548: dup
    //   549: iconst_2
    //   550: aload_0
    //   551: getfield 131	com/tencent/mm/plugin/performance/c/a:wJr	I
    //   554: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   557: aastore
    //   558: invokestatic 229	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   561: ldc 123
    //   563: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   566: iload_1
    //   567: ireturn
    //   568: aload 9
    //   570: aload 8
    //   572: aload 12
    //   574: invokevirtual 89	java/lang/Integer:intValue	()I
    //   577: iconst_1
    //   578: iadd
    //   579: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   582: invokeinterface 241 3 0
    //   587: pop
    //   588: goto -176 -> 412
    //   591: astore 8
    //   593: ldc 123
    //   595: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   598: aload 8
    //   600: athrow
    //   601: aload_0
    //   602: getfield 71	com/tencent/mm/plugin/performance/c/a:wJu	Ljava/util/Map;
    //   605: aload 10
    //   607: invokevirtual 77	com/tencent/mm/plugin/performance/c/a$a:name	()Ljava/lang/String;
    //   610: aload 8
    //   612: invokevirtual 89	java/lang/Integer:intValue	()I
    //   615: iconst_1
    //   616: iadd
    //   617: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   620: invokeinterface 241 3 0
    //   625: pop
    //   626: goto +33 -> 659
    //   629: iload_2
    //   630: iconst_1
    //   631: iadd
    //   632: istore_2
    //   633: goto -329 -> 304
    //   636: iload_3
    //   637: aload_0
    //   638: getfield 131	com/tencent/mm/plugin/performance/c/a:wJr	I
    //   641: isub
    //   642: istore_1
    //   643: goto -147 -> 496
    //   646: astore 8
    //   648: iconst_0
    //   649: istore_1
    //   650: goto -188 -> 462
    //   653: goto -274 -> 379
    //   656: goto -401 -> 255
    //   659: iload_1
    //   660: iconst_1
    //   661: iadd
    //   662: istore_1
    //   663: goto -515 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	666	0	this	a
    //   147	516	1	i	int
    //   303	330	2	j	int
    //   140	502	3	k	int
    //   144	8	4	m	int
    //   300	8	5	n	int
    //   8	527	6	l	long
    //   40	392	8	localObject1	Object
    //   458	113	8	localException1	java.lang.Exception
    //   591	20	8	localObject2	Object
    //   646	1	8	localException2	java.lang.Exception
    //   164	405	9	localObject3	Object
    //   178	428	10	str	String
    //   116	39	11	arrayOfe	com.tencent.mm.vfs.e[]
    //   391	182	12	localInteger	Integer
    // Exception table:
    //   from	to	target	type
    //   141	146	458	java/lang/Exception
    //   154	190	458	java/lang/Exception
    //   194	202	458	java/lang/Exception
    //   202	209	458	java/lang/Exception
    //   213	251	458	java/lang/Exception
    //   255	289	458	java/lang/Exception
    //   292	302	458	java/lang/Exception
    //   316	348	458	java/lang/Exception
    //   353	379	458	java/lang/Exception
    //   379	393	458	java/lang/Exception
    //   398	412	458	java/lang/Exception
    //   412	431	458	java/lang/Exception
    //   436	455	458	java/lang/Exception
    //   568	588	458	java/lang/Exception
    //   601	626	458	java/lang/Exception
    //   111	118	591	finally
    //   123	130	591	finally
    //   137	141	591	finally
    //   141	146	591	finally
    //   154	190	591	finally
    //   194	202	591	finally
    //   202	209	591	finally
    //   213	251	591	finally
    //   255	289	591	finally
    //   292	302	591	finally
    //   316	348	591	finally
    //   353	379	591	finally
    //   379	393	591	finally
    //   398	412	591	finally
    //   412	431	591	finally
    //   436	455	591	finally
    //   462	489	591	finally
    //   568	588	591	finally
    //   601	626	591	finally
    //   111	118	646	java/lang/Exception
    //   123	130	646	java/lang/Exception
    //   137	141	646	java/lang/Exception
  }
  
  public final void run()
  {
    AppMethodBeat.i(211770);
    int i;
    if (aj.cmR()) {
      i = 100;
    }
    for (;;)
    {
      int k = dyY();
      if ((k <= 256) && (k - this.wJs > 32))
      {
        e.ygI.idkeyStat(1031L, i - 2, 1L, false);
        this.wJs = Math.max(k, this.wJs);
      }
      for (;;)
      {
        h.LTJ.r(this, 1800000L);
        AppMethodBeat.o(211770);
        return;
        if ((aj.fkI()) || (aj.fkJ()))
        {
          i = 120;
          break;
        }
        if (aj.isAppBrandProcess())
        {
          i = 140;
          break;
        }
        if (!aj.fkG()) {
          break label939;
        }
        i = 150;
        break;
        if ((256 < k) && (k <= 512) && (!this.wJn))
        {
          e.ygI.idkeyStat(1031L, i - 1, 1L, false);
          this.wJn = true;
        }
        else if ((512 < k) && (k <= 768) && (!this.wJo))
        {
          e.ygI.idkeyStat(1031L, i, 1L, false);
          this.wJo = true;
        }
        else if ((768 < k) && (k <= 896) && (!this.wJp))
        {
          e.ygI.idkeyStat(1031L, i + 1, 1L, false);
          this.wJp = true;
        }
        else if ((k > 896) && (!this.wJq))
        {
          e.ygI.idkeyStat(1031L, i + 2, 1L, false);
          ad.e("MicroMsg.FDWatchDog", ">>>>>>>>>>>> FD SOS: total count = %d", new Object[] { Integer.valueOf(k) });
          Object localObject2 = new ArrayList(this.wJu.entrySet());
          Collections.sort((List)localObject2, new Comparator() {});
          Object localObject1 = new StringBuilder();
          localObject2 = ((List)localObject2).iterator();
          i = 0;
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
            ad.e("MicroMsg.FDWatchDog", ">>>>>>>>>>>> FD SOS: type = %s, count = %s", new Object[] { ((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue() });
            localObject3 = (Map)this.wJt.get(((Map.Entry)localObject3).getKey());
            if (localObject3 != null)
            {
              localObject3 = new ArrayList(((Map)localObject3).entrySet());
              Collections.sort((List)localObject3, new Comparator() {});
              localObject3 = ((List)localObject3).iterator();
              int j = i;
              for (;;)
              {
                i = j;
                if (!((Iterator)localObject3).hasNext()) {
                  break;
                }
                Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
                ad.e("MicroMsg.FDWatchDog", "-> [%s] %s", new Object[] { localEntry.getValue(), localEntry.getKey() });
                if (j < 20) {
                  ((StringBuilder)localObject1).append("[").append(localEntry.getValue()).append("]").append((String)localEntry.getKey()).append(";");
                }
                j += 1;
              }
            }
          }
          localObject1 = ((StringBuilder)localObject1).toString();
          ad.e("MicroMsg.FDWatchDog", "top path is %s", new Object[] { localObject1 });
          e.ygI.f(17899, new Object[] { Integer.valueOf(k), Long.valueOf(System.currentTimeMillis()), aj.getProcessName(), Integer.valueOf(a(a.wJx)), Integer.valueOf(a(a.wJy)), Integer.valueOf(a(a.wJz)), Integer.valueOf(a(a.wJA)), Integer.valueOf(a(a.wJB)), Integer.valueOf(a(a.wJC)), Integer.valueOf(a(a.wJD)), Integer.valueOf(a(a.wJE)), Integer.valueOf(a(a.wJF)), Integer.valueOf(a(a.wJG)), Integer.valueOf(a(a.wJH)), Integer.valueOf(a(a.wJI)), Integer.valueOf(a(a.wJJ)), Integer.valueOf(a(a.wJK)), Integer.valueOf(a(a.wJL)), Integer.valueOf(a(a.wJM)), Integer.valueOf(a(a.wJN)), Integer.valueOf(a(a.wJO)), Integer.valueOf(a(a.wJP)), localObject1, Integer.valueOf(this.wJr) });
          this.wJq = true;
        }
      }
      label939:
      i = 0;
    }
  }
  
  @SuppressLint({"SdCardPath"})
  static enum a
  {
    private final String wJQ;
    
    static
    {
      AppMethodBeat.i(211768);
      wJx = new a("FD_TYPE_ANNON_INODE_EVENT", 0, "anon_inode:\\[event.*\\]");
      wJy = new a("FD_TYPE_ANNON_INODE_DMABUF", 1, "anon_inode:dmabuf");
      wJz = new a("FD_TYPE_SOCKET", 2, "socket:.*");
      wJA = new a("FD_TYPE_PATH_DATA_MM_FILES_MMKV", 3, "/data/data/com.tencent.mm/files/mmkv/.*");
      wJB = new a("FD_TYPE_PATH_DATA_MM_FILES_KVCOMM", 4, "/data/data/com.tencent.mm/files/kvcomm/.*");
      wJC = new a("FD_TYPE_PATH_DATA_MM_FILES_XLOG", 5, "/data/data/com.tencent.mm/files/xlog/.*");
      wJD = new a("FD_TYPE_PATH_DATA_MM_FILES_OTHERS", 6, "/data/data/com.tencent.mm/files/.*");
      wJE = new a("FD_TYPE_PATH_DATA_MM_MICRO_MSG", 7, "/data/data/com.tencent.mm/MicroMsg/.*");
      wJF = new a("FD_TYPE_PATH_DATA_MM_OTHERS", 8, "/data/data/com.tencent.mm/.*");
      wJG = new a("FD_TYPE_PATH_EXT_AC_VOICE", 9, ".*/tencent/MicroMsg/[0-9a-eA-E]+/voice2/.*");
      wJH = new a("FD_TYPE_PATH_EXT_AC_VIDEO", 10, ".*/tencent/MicroMsg/[0-9a-eA-E]+/video/.*");
      wJI = new a("FD_TYPE_PATH_EXT_AC_ATTACHMENT", 11, ".*/tencent/MicroMsg/[0-9a-eA-E]+/attachment/.*");
      wJJ = new a("FD_TYPE_PATH_EXT_AC_IMAGE", 12, ".*/tencent/MicroMsg/[0-9a-eA-E]+/image[2]?/.*");
      wJK = new a("FD_TYPE_PATH_EXT_AC_OTHERS", 13, ".*/tencent/MicroMsg/[0-9a-eA-E]+/.*");
      wJL = new a("FD_TYPE_PATH_EXT_OTHERS", 14, ".*/tencent/MicroMsg/.*");
      wJM = new a("FD_TYPE_PATH_SYSTEM_FRAMEWORK", 15, "/system/framework/.*");
      wJN = new a("FD_TYPE_PATH_DEV_ASHMEM", 16, "/dev/ashmem");
      wJO = new a("FD_TYPE_PATH_DEV_OTHERS", 17, "/dev/.*");
      wJP = new a("FD_TYPE_OTHERS", 18, ".*");
      wJR = new a[] { wJx, wJy, wJz, wJA, wJB, wJC, wJD, wJE, wJF, wJG, wJH, wJI, wJJ, wJK, wJL, wJM, wJN, wJO, wJP };
      AppMethodBeat.o(211768);
    }
    
    private a(String paramString)
    {
      this.wJQ = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.c.a
 * JD-Core Version:    0.7.0.1
 */