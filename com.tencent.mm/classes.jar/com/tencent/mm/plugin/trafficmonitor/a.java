package com.tencent.mm.plugin.trafficmonitor;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.e;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static Map<Integer, Long> AiA;
  private static Map<Integer, Long> AiB;
  private static Map<Integer, Long> AiC;
  private static Map<Integer, Long> AiD;
  private static Map<Integer, Long> AiE;
  private static Map<Integer, Long> AiF;
  private static Map<Integer, Long> AiG;
  private static Map<Integer, Long> AiH;
  private static final e AiI;
  private static final e AiJ;
  private static Map<Integer, Long> Ais;
  private static Map<Integer, Long> Ait;
  private static Map<Integer, Long> Aiu;
  private static Map<Integer, Long> Aiv;
  private static Map<Integer, Long> Aiw;
  private static Map<Integer, Long> Aix;
  private static Map<Integer, Long> Aiy;
  private static Map<Integer, Long> Aiz;
  
  static
  {
    Object localObject2 = null;
    AppMethodBeat.i(123887);
    AiA = new HashMap();
    AiB = new HashMap();
    AiC = new HashMap();
    AiD = new HashMap();
    AiE = new HashMap();
    AiF = new HashMap();
    AiG = new HashMap();
    AiH = new HashMap();
    Ais = new HashMap();
    Ait = new HashMap();
    Aiu = new HashMap();
    Aiv = new HashMap();
    Aiw = new HashMap();
    Aix = new HashMap();
    Aiy = new HashMap();
    Aiz = new HashMap();
    Object localObject1 = new e("/proc/" + Process.myPid() + "/net/dev");
    if (((e)localObject1).isFile()) {}
    for (;;)
    {
      AiI = (e)localObject1;
      e locale = new e("/proc/net/xt_qtaguid/stats");
      localObject1 = localObject2;
      if (locale.isFile()) {
        localObject1 = locale;
      }
      AiJ = (e)localObject1;
      AppMethodBeat.o(123887);
      return;
      localObject1 = null;
    }
  }
  
  public static long RA(int paramInt)
  {
    AppMethodBeat.i(123879);
    if (Aiw == null)
    {
      AppMethodBeat.o(123879);
      return 0L;
    }
    if (Aiw.get(Integer.valueOf(paramInt)) == null)
    {
      AppMethodBeat.o(123879);
      return 0L;
    }
    if (((Long)Aiw.get(Integer.valueOf(paramInt))).longValue() > 0L)
    {
      long l = ((Long)Aiw.get(Integer.valueOf(paramInt))).longValue();
      AppMethodBeat.o(123879);
      return l;
    }
    AppMethodBeat.o(123879);
    return 0L;
  }
  
  public static long RB(int paramInt)
  {
    AppMethodBeat.i(123880);
    if (Aix == null)
    {
      AppMethodBeat.o(123880);
      return 0L;
    }
    if (Aix.get(Integer.valueOf(paramInt)) == null)
    {
      AppMethodBeat.o(123880);
      return 0L;
    }
    if (((Long)Aix.get(Integer.valueOf(paramInt))).longValue() > 0L)
    {
      long l = ((Long)Aix.get(Integer.valueOf(paramInt))).longValue();
      AppMethodBeat.o(123880);
      return l;
    }
    AppMethodBeat.o(123880);
    return 0L;
  }
  
  public static long RC(int paramInt)
  {
    AppMethodBeat.i(123881);
    if (AiG == null)
    {
      AppMethodBeat.o(123881);
      return 0L;
    }
    if (AiG.get(Integer.valueOf(paramInt)) == null)
    {
      AppMethodBeat.o(123881);
      return 0L;
    }
    if (((Long)AiG.get(Integer.valueOf(paramInt))).longValue() > 0L)
    {
      long l = ((Long)AiG.get(Integer.valueOf(paramInt))).longValue();
      AppMethodBeat.o(123881);
      return l;
    }
    AppMethodBeat.o(123881);
    return 0L;
  }
  
  public static long RD(int paramInt)
  {
    AppMethodBeat.i(123882);
    if (AiH == null)
    {
      AppMethodBeat.o(123882);
      return 0L;
    }
    if (AiH.get(Integer.valueOf(paramInt)) == null)
    {
      AppMethodBeat.o(123882);
      return 0L;
    }
    if (((Long)AiH.get(Integer.valueOf(paramInt))).longValue() > 0L)
    {
      long l = ((Long)AiH.get(Integer.valueOf(paramInt))).longValue();
      AppMethodBeat.o(123882);
      return l;
    }
    AppMethodBeat.o(123882);
    return 0L;
  }
  
  public static long RE(int paramInt)
  {
    AppMethodBeat.i(123883);
    if (AiE == null)
    {
      AppMethodBeat.o(123883);
      return 0L;
    }
    if (AiE.get(Integer.valueOf(paramInt)) == null)
    {
      AppMethodBeat.o(123883);
      return 0L;
    }
    if (((Long)AiE.get(Integer.valueOf(paramInt))).longValue() > 0L)
    {
      long l = ((Long)AiE.get(Integer.valueOf(paramInt))).longValue();
      AppMethodBeat.o(123883);
      return l;
    }
    AppMethodBeat.o(123883);
    return 0L;
  }
  
  public static long RF(int paramInt)
  {
    AppMethodBeat.i(123884);
    if (AiF == null)
    {
      AppMethodBeat.o(123884);
      return 0L;
    }
    if (AiF.get(Integer.valueOf(paramInt)) == null)
    {
      AppMethodBeat.o(123884);
      return 0L;
    }
    if (((Long)AiF.get(Integer.valueOf(paramInt))).longValue() > 0L)
    {
      long l = ((Long)AiF.get(Integer.valueOf(paramInt))).longValue();
      AppMethodBeat.o(123884);
      return l;
    }
    AppMethodBeat.o(123884);
    return 0L;
  }
  
  public static void init(int paramInt)
  {
    AppMethodBeat.i(123878);
    AiA.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    AiB.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    AiC.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    AiD.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    AiE.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    AiF.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    AiG.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    AiH.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    Ais.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    Ait.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    Aiu.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    Aiv.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    Aiw.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    Aix.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    Aiy.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    Aiz.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    AppMethodBeat.o(123878);
  }
  
  public static void reset(int paramInt)
  {
    AppMethodBeat.i(123885);
    AiB.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    AiA.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    AiD.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    AiC.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    Ait.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    Ais.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    Aiv.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    Aiu.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    update(paramInt);
    AppMethodBeat.o(123885);
  }
  
  /* Error */
  public static void update(int paramInt)
  {
    // Byte code:
    //   0: ldc 164
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: lconst_0
    //   6: lstore 6
    //   8: lconst_0
    //   9: lstore 4
    //   11: lconst_0
    //   12: lstore 8
    //   14: lconst_0
    //   15: lstore_2
    //   16: lconst_0
    //   17: lstore 14
    //   19: lconst_0
    //   20: lstore 12
    //   22: aconst_null
    //   23: astore 16
    //   25: getstatic 106	com/tencent/mm/plugin/trafficmonitor/a:AiI	Lcom/tencent/mm/vfs/e;
    //   28: ifnull +1020 -> 1048
    //   31: new 166	java/io/BufferedReader
    //   34: dup
    //   35: new 168	com/tencent/mm/vfs/k
    //   38: dup
    //   39: getstatic 106	com/tencent/mm/plugin/trafficmonitor/a:AiI	Lcom/tencent/mm/vfs/e;
    //   42: invokespecial 171	com/tencent/mm/vfs/k:<init>	(Lcom/tencent/mm/vfs/e;)V
    //   45: invokespecial 174	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   48: astore 18
    //   50: aload 18
    //   52: astore 16
    //   54: aload 18
    //   56: astore 17
    //   58: aload 18
    //   60: invokevirtual 177	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   63: pop
    //   64: aload 18
    //   66: astore 16
    //   68: aload 18
    //   70: astore 17
    //   72: aload 18
    //   74: invokevirtual 177	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   77: pop
    //   78: aload 18
    //   80: astore 16
    //   82: aload 18
    //   84: astore 17
    //   86: aload 18
    //   88: invokevirtual 177	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   91: astore 19
    //   93: aload 19
    //   95: ifnull +204 -> 299
    //   98: aload 18
    //   100: astore 16
    //   102: aload 18
    //   104: astore 17
    //   106: aload 19
    //   108: ldc 179
    //   110: invokevirtual 185	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   113: astore 19
    //   115: aload 18
    //   117: astore 16
    //   119: aload 18
    //   121: astore 17
    //   123: aload 19
    //   125: iconst_0
    //   126: aaload
    //   127: invokevirtual 188	java/lang/String:length	()I
    //   130: ifne +2177 -> 2307
    //   133: iconst_1
    //   134: istore_1
    //   135: aload 18
    //   137: astore 16
    //   139: aload 18
    //   141: astore 17
    //   143: aload 19
    //   145: iload_1
    //   146: iconst_0
    //   147: iadd
    //   148: aaload
    //   149: ldc 190
    //   151: invokevirtual 194	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   154: ifne +2150 -> 2304
    //   157: aload 18
    //   159: astore 16
    //   161: aload 18
    //   163: astore 17
    //   165: aload 19
    //   167: iload_1
    //   168: iconst_0
    //   169: iadd
    //   170: aaload
    //   171: ldc 196
    //   173: invokevirtual 200	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   176: ifne +25 -> 201
    //   179: aload 18
    //   181: astore 16
    //   183: aload 18
    //   185: astore 17
    //   187: aload 19
    //   189: iload_1
    //   190: iconst_0
    //   191: iadd
    //   192: aaload
    //   193: ldc 202
    //   195: invokevirtual 200	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   198: ifeq +53 -> 251
    //   201: aload 18
    //   203: astore 16
    //   205: aload 18
    //   207: astore 17
    //   209: lload 6
    //   211: aload 19
    //   213: iload_1
    //   214: bipush 9
    //   216: iadd
    //   217: aaload
    //   218: lconst_0
    //   219: invokestatic 208	com/tencent/mm/sdk/platformtools/bs:getLong	(Ljava/lang/String;J)J
    //   222: ladd
    //   223: lstore 6
    //   225: aload 18
    //   227: astore 16
    //   229: aload 18
    //   231: astore 17
    //   233: lload 4
    //   235: aload 19
    //   237: iload_1
    //   238: iconst_1
    //   239: iadd
    //   240: aaload
    //   241: lconst_0
    //   242: invokestatic 208	com/tencent/mm/sdk/platformtools/bs:getLong	(Ljava/lang/String;J)J
    //   245: ladd
    //   246: lstore 4
    //   248: goto -170 -> 78
    //   251: aload 18
    //   253: astore 16
    //   255: aload 18
    //   257: astore 17
    //   259: lload 8
    //   261: aload 19
    //   263: iload_1
    //   264: bipush 9
    //   266: iadd
    //   267: aaload
    //   268: lconst_0
    //   269: invokestatic 208	com/tencent/mm/sdk/platformtools/bs:getLong	(Ljava/lang/String;J)J
    //   272: ladd
    //   273: lstore 8
    //   275: aload 18
    //   277: astore 16
    //   279: aload 18
    //   281: astore 17
    //   283: aload 19
    //   285: iload_1
    //   286: iconst_1
    //   287: iadd
    //   288: aaload
    //   289: lconst_0
    //   290: invokestatic 208	com/tencent/mm/sdk/platformtools/bs:getLong	(Ljava/lang/String;J)J
    //   293: lload_2
    //   294: ladd
    //   295: lstore_2
    //   296: goto +2016 -> 2312
    //   299: aload 18
    //   301: astore 16
    //   303: aload 18
    //   305: astore 17
    //   307: getstatic 57	com/tencent/mm/plugin/trafficmonitor/a:Ais	Ljava/util/Map;
    //   310: iload_0
    //   311: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   314: invokeinterface 129 2 0
    //   319: checkcast 131	java/lang/Long
    //   322: invokevirtual 135	java/lang/Long:longValue	()J
    //   325: lconst_0
    //   326: lcmp
    //   327: ifge +29 -> 356
    //   330: aload 18
    //   332: astore 16
    //   334: aload 18
    //   336: astore 17
    //   338: getstatic 57	com/tencent/mm/plugin/trafficmonitor/a:Ais	Ljava/util/Map;
    //   341: iload_0
    //   342: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   345: lload 6
    //   347: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   350: invokeinterface 154 3 0
    //   355: pop
    //   356: aload 18
    //   358: astore 16
    //   360: aload 18
    //   362: astore 17
    //   364: getstatic 59	com/tencent/mm/plugin/trafficmonitor/a:Ait	Ljava/util/Map;
    //   367: iload_0
    //   368: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   371: invokeinterface 129 2 0
    //   376: checkcast 131	java/lang/Long
    //   379: invokevirtual 135	java/lang/Long:longValue	()J
    //   382: lconst_0
    //   383: lcmp
    //   384: ifge +29 -> 413
    //   387: aload 18
    //   389: astore 16
    //   391: aload 18
    //   393: astore 17
    //   395: getstatic 59	com/tencent/mm/plugin/trafficmonitor/a:Ait	Ljava/util/Map;
    //   398: iload_0
    //   399: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   402: lload 4
    //   404: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   407: invokeinterface 154 3 0
    //   412: pop
    //   413: aload 18
    //   415: astore 16
    //   417: aload 18
    //   419: astore 17
    //   421: getstatic 61	com/tencent/mm/plugin/trafficmonitor/a:Aiu	Ljava/util/Map;
    //   424: iload_0
    //   425: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   428: invokeinterface 129 2 0
    //   433: checkcast 131	java/lang/Long
    //   436: invokevirtual 135	java/lang/Long:longValue	()J
    //   439: lconst_0
    //   440: lcmp
    //   441: ifge +29 -> 470
    //   444: aload 18
    //   446: astore 16
    //   448: aload 18
    //   450: astore 17
    //   452: getstatic 61	com/tencent/mm/plugin/trafficmonitor/a:Aiu	Ljava/util/Map;
    //   455: iload_0
    //   456: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   459: lload 8
    //   461: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   464: invokeinterface 154 3 0
    //   469: pop
    //   470: aload 18
    //   472: astore 16
    //   474: aload 18
    //   476: astore 17
    //   478: getstatic 63	com/tencent/mm/plugin/trafficmonitor/a:Aiv	Ljava/util/Map;
    //   481: iload_0
    //   482: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   485: invokeinterface 129 2 0
    //   490: checkcast 131	java/lang/Long
    //   493: invokevirtual 135	java/lang/Long:longValue	()J
    //   496: lconst_0
    //   497: lcmp
    //   498: ifge +28 -> 526
    //   501: aload 18
    //   503: astore 16
    //   505: aload 18
    //   507: astore 17
    //   509: getstatic 63	com/tencent/mm/plugin/trafficmonitor/a:Aiv	Ljava/util/Map;
    //   512: iload_0
    //   513: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   516: lload_2
    //   517: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   520: invokeinterface 154 3 0
    //   525: pop
    //   526: aload 18
    //   528: astore 16
    //   530: aload 18
    //   532: astore 17
    //   534: getstatic 65	com/tencent/mm/plugin/trafficmonitor/a:Aiw	Ljava/util/Map;
    //   537: astore 19
    //   539: aload 18
    //   541: astore 16
    //   543: aload 18
    //   545: astore 17
    //   547: lload 6
    //   549: getstatic 57	com/tencent/mm/plugin/trafficmonitor/a:Ais	Ljava/util/Map;
    //   552: iload_0
    //   553: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   556: invokeinterface 129 2 0
    //   561: checkcast 131	java/lang/Long
    //   564: invokevirtual 135	java/lang/Long:longValue	()J
    //   567: lcmp
    //   568: iflt +1764 -> 2332
    //   571: aload 18
    //   573: astore 16
    //   575: aload 18
    //   577: astore 17
    //   579: lload 6
    //   581: getstatic 57	com/tencent/mm/plugin/trafficmonitor/a:Ais	Ljava/util/Map;
    //   584: iload_0
    //   585: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   588: invokeinterface 129 2 0
    //   593: checkcast 131	java/lang/Long
    //   596: invokevirtual 135	java/lang/Long:longValue	()J
    //   599: lsub
    //   600: lstore 10
    //   602: aload 18
    //   604: astore 16
    //   606: aload 18
    //   608: astore 17
    //   610: aload 19
    //   612: iload_0
    //   613: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   616: lload 10
    //   618: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   621: invokeinterface 154 3 0
    //   626: pop
    //   627: aload 18
    //   629: astore 16
    //   631: aload 18
    //   633: astore 17
    //   635: getstatic 67	com/tencent/mm/plugin/trafficmonitor/a:Aix	Ljava/util/Map;
    //   638: astore 19
    //   640: aload 18
    //   642: astore 16
    //   644: aload 18
    //   646: astore 17
    //   648: lload 4
    //   650: getstatic 59	com/tencent/mm/plugin/trafficmonitor/a:Ait	Ljava/util/Map;
    //   653: iload_0
    //   654: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   657: invokeinterface 129 2 0
    //   662: checkcast 131	java/lang/Long
    //   665: invokevirtual 135	java/lang/Long:longValue	()J
    //   668: lcmp
    //   669: iflt +1670 -> 2339
    //   672: aload 18
    //   674: astore 16
    //   676: aload 18
    //   678: astore 17
    //   680: lload 4
    //   682: getstatic 59	com/tencent/mm/plugin/trafficmonitor/a:Ait	Ljava/util/Map;
    //   685: iload_0
    //   686: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   689: invokeinterface 129 2 0
    //   694: checkcast 131	java/lang/Long
    //   697: invokevirtual 135	java/lang/Long:longValue	()J
    //   700: lsub
    //   701: lstore 10
    //   703: aload 18
    //   705: astore 16
    //   707: aload 18
    //   709: astore 17
    //   711: aload 19
    //   713: iload_0
    //   714: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   717: lload 10
    //   719: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   722: invokeinterface 154 3 0
    //   727: pop
    //   728: aload 18
    //   730: astore 16
    //   732: aload 18
    //   734: astore 17
    //   736: getstatic 69	com/tencent/mm/plugin/trafficmonitor/a:Aiy	Ljava/util/Map;
    //   739: astore 19
    //   741: aload 18
    //   743: astore 16
    //   745: aload 18
    //   747: astore 17
    //   749: lload 8
    //   751: getstatic 61	com/tencent/mm/plugin/trafficmonitor/a:Aiu	Ljava/util/Map;
    //   754: iload_0
    //   755: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   758: invokeinterface 129 2 0
    //   763: checkcast 131	java/lang/Long
    //   766: invokevirtual 135	java/lang/Long:longValue	()J
    //   769: lcmp
    //   770: iflt +1576 -> 2346
    //   773: aload 18
    //   775: astore 16
    //   777: aload 18
    //   779: astore 17
    //   781: lload 8
    //   783: getstatic 61	com/tencent/mm/plugin/trafficmonitor/a:Aiu	Ljava/util/Map;
    //   786: iload_0
    //   787: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   790: invokeinterface 129 2 0
    //   795: checkcast 131	java/lang/Long
    //   798: invokevirtual 135	java/lang/Long:longValue	()J
    //   801: lsub
    //   802: lstore 10
    //   804: aload 18
    //   806: astore 16
    //   808: aload 18
    //   810: astore 17
    //   812: aload 19
    //   814: iload_0
    //   815: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   818: lload 10
    //   820: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   823: invokeinterface 154 3 0
    //   828: pop
    //   829: aload 18
    //   831: astore 16
    //   833: aload 18
    //   835: astore 17
    //   837: getstatic 71	com/tencent/mm/plugin/trafficmonitor/a:Aiz	Ljava/util/Map;
    //   840: astore 19
    //   842: aload 18
    //   844: astore 16
    //   846: aload 18
    //   848: astore 17
    //   850: lload_2
    //   851: getstatic 63	com/tencent/mm/plugin/trafficmonitor/a:Aiv	Ljava/util/Map;
    //   854: iload_0
    //   855: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   858: invokeinterface 129 2 0
    //   863: checkcast 131	java/lang/Long
    //   866: invokevirtual 135	java/lang/Long:longValue	()J
    //   869: lcmp
    //   870: iflt +1483 -> 2353
    //   873: aload 18
    //   875: astore 16
    //   877: aload 18
    //   879: astore 17
    //   881: lload_2
    //   882: getstatic 63	com/tencent/mm/plugin/trafficmonitor/a:Aiv	Ljava/util/Map;
    //   885: iload_0
    //   886: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   889: invokeinterface 129 2 0
    //   894: checkcast 131	java/lang/Long
    //   897: invokevirtual 135	java/lang/Long:longValue	()J
    //   900: lsub
    //   901: lstore 10
    //   903: aload 18
    //   905: astore 16
    //   907: aload 18
    //   909: astore 17
    //   911: aload 19
    //   913: iload_0
    //   914: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   917: lload 10
    //   919: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   922: invokeinterface 154 3 0
    //   927: pop
    //   928: aload 18
    //   930: astore 16
    //   932: aload 18
    //   934: astore 17
    //   936: getstatic 57	com/tencent/mm/plugin/trafficmonitor/a:Ais	Ljava/util/Map;
    //   939: iload_0
    //   940: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   943: lload 6
    //   945: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   948: invokeinterface 154 3 0
    //   953: pop
    //   954: aload 18
    //   956: astore 16
    //   958: aload 18
    //   960: astore 17
    //   962: getstatic 59	com/tencent/mm/plugin/trafficmonitor/a:Ait	Ljava/util/Map;
    //   965: iload_0
    //   966: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   969: lload 4
    //   971: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   974: invokeinterface 154 3 0
    //   979: pop
    //   980: aload 18
    //   982: astore 16
    //   984: aload 18
    //   986: astore 17
    //   988: getstatic 61	com/tencent/mm/plugin/trafficmonitor/a:Aiu	Ljava/util/Map;
    //   991: iload_0
    //   992: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   995: lload 8
    //   997: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1000: invokeinterface 154 3 0
    //   1005: pop
    //   1006: aload 18
    //   1008: astore 16
    //   1010: aload 18
    //   1012: astore 17
    //   1014: getstatic 63	com/tencent/mm/plugin/trafficmonitor/a:Aiv	Ljava/util/Map;
    //   1017: iload_0
    //   1018: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1021: lload_2
    //   1022: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1025: invokeinterface 154 3 0
    //   1030: pop
    //   1031: aload 18
    //   1033: astore 16
    //   1035: aload 18
    //   1037: astore 17
    //   1039: aload 18
    //   1041: invokestatic 212	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   1044: aload 18
    //   1046: astore 16
    //   1048: aload 16
    //   1050: astore 17
    //   1052: getstatic 110	com/tencent/mm/plugin/trafficmonitor/a:AiJ	Lcom/tencent/mm/vfs/e;
    //   1055: ifnull +974 -> 2029
    //   1058: invokestatic 215	android/os/Process:myUid	()I
    //   1061: istore_1
    //   1062: new 166	java/io/BufferedReader
    //   1065: dup
    //   1066: new 168	com/tencent/mm/vfs/k
    //   1069: dup
    //   1070: getstatic 110	com/tencent/mm/plugin/trafficmonitor/a:AiJ	Lcom/tencent/mm/vfs/e;
    //   1073: invokespecial 171	com/tencent/mm/vfs/k:<init>	(Lcom/tencent/mm/vfs/e;)V
    //   1076: invokespecial 174	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1079: astore 18
    //   1081: aload 18
    //   1083: astore 16
    //   1085: aload 18
    //   1087: astore 17
    //   1089: aload 18
    //   1091: invokevirtual 177	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1094: pop
    //   1095: lconst_0
    //   1096: lstore_2
    //   1097: lconst_0
    //   1098: lstore 8
    //   1100: lload 14
    //   1102: lstore 4
    //   1104: lload 12
    //   1106: lstore 6
    //   1108: aload 18
    //   1110: astore 16
    //   1112: aload 18
    //   1114: astore 17
    //   1116: aload 18
    //   1118: invokevirtual 177	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1121: astore 19
    //   1123: aload 19
    //   1125: ifnull +155 -> 1280
    //   1128: aload 18
    //   1130: astore 16
    //   1132: aload 18
    //   1134: astore 17
    //   1136: aload 19
    //   1138: ldc 217
    //   1140: invokevirtual 185	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1143: astore 19
    //   1145: aload 18
    //   1147: astore 16
    //   1149: aload 18
    //   1151: astore 17
    //   1153: aload 19
    //   1155: iconst_3
    //   1156: aaload
    //   1157: iconst_0
    //   1158: invokestatic 221	com/tencent/mm/sdk/platformtools/bs:getInt	(Ljava/lang/String;I)I
    //   1161: iload_1
    //   1162: if_icmpne -54 -> 1108
    //   1165: aload 19
    //   1167: iconst_1
    //   1168: aaload
    //   1169: astore 20
    //   1171: aload 18
    //   1173: astore 16
    //   1175: aload 18
    //   1177: astore 17
    //   1179: aload 19
    //   1181: iconst_5
    //   1182: aaload
    //   1183: lconst_0
    //   1184: invokestatic 208	com/tencent/mm/sdk/platformtools/bs:getLong	(Ljava/lang/String;J)J
    //   1187: lstore 12
    //   1189: aload 18
    //   1191: astore 16
    //   1193: aload 18
    //   1195: astore 17
    //   1197: aload 19
    //   1199: bipush 7
    //   1201: aaload
    //   1202: lconst_0
    //   1203: invokestatic 208	com/tencent/mm/sdk/platformtools/bs:getLong	(Ljava/lang/String;J)J
    //   1206: lstore 10
    //   1208: aload 18
    //   1210: astore 16
    //   1212: aload 18
    //   1214: astore 17
    //   1216: aload 20
    //   1218: ldc 196
    //   1220: invokevirtual 200	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1223: ifne +1092 -> 2315
    //   1226: aload 18
    //   1228: astore 16
    //   1230: aload 18
    //   1232: astore 17
    //   1234: aload 20
    //   1236: ldc 202
    //   1238: invokevirtual 200	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1241: ifeq +6 -> 1247
    //   1244: goto +1071 -> 2315
    //   1247: aload 18
    //   1249: astore 16
    //   1251: aload 18
    //   1253: astore 17
    //   1255: aload 20
    //   1257: ldc 190
    //   1259: invokevirtual 194	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1262: ifne +1039 -> 2301
    //   1265: lload_2
    //   1266: lload 12
    //   1268: ladd
    //   1269: lstore_2
    //   1270: lload 8
    //   1272: lload 10
    //   1274: ladd
    //   1275: lstore 8
    //   1277: goto +1082 -> 2359
    //   1280: aload 18
    //   1282: astore 16
    //   1284: aload 18
    //   1286: astore 17
    //   1288: getstatic 43	com/tencent/mm/plugin/trafficmonitor/a:AiB	Ljava/util/Map;
    //   1291: iload_0
    //   1292: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1295: invokeinterface 129 2 0
    //   1300: checkcast 131	java/lang/Long
    //   1303: invokevirtual 135	java/lang/Long:longValue	()J
    //   1306: lconst_0
    //   1307: lcmp
    //   1308: ifge +29 -> 1337
    //   1311: aload 18
    //   1313: astore 16
    //   1315: aload 18
    //   1317: astore 17
    //   1319: getstatic 43	com/tencent/mm/plugin/trafficmonitor/a:AiB	Ljava/util/Map;
    //   1322: iload_0
    //   1323: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1326: lload 6
    //   1328: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1331: invokeinterface 154 3 0
    //   1336: pop
    //   1337: aload 18
    //   1339: astore 16
    //   1341: aload 18
    //   1343: astore 17
    //   1345: getstatic 41	com/tencent/mm/plugin/trafficmonitor/a:AiA	Ljava/util/Map;
    //   1348: iload_0
    //   1349: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1352: invokeinterface 129 2 0
    //   1357: checkcast 131	java/lang/Long
    //   1360: invokevirtual 135	java/lang/Long:longValue	()J
    //   1363: lconst_0
    //   1364: lcmp
    //   1365: ifge +29 -> 1394
    //   1368: aload 18
    //   1370: astore 16
    //   1372: aload 18
    //   1374: astore 17
    //   1376: getstatic 41	com/tencent/mm/plugin/trafficmonitor/a:AiA	Ljava/util/Map;
    //   1379: iload_0
    //   1380: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1383: lload 4
    //   1385: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1388: invokeinterface 154 3 0
    //   1393: pop
    //   1394: aload 18
    //   1396: astore 16
    //   1398: aload 18
    //   1400: astore 17
    //   1402: getstatic 47	com/tencent/mm/plugin/trafficmonitor/a:AiD	Ljava/util/Map;
    //   1405: iload_0
    //   1406: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1409: invokeinterface 129 2 0
    //   1414: checkcast 131	java/lang/Long
    //   1417: invokevirtual 135	java/lang/Long:longValue	()J
    //   1420: lconst_0
    //   1421: lcmp
    //   1422: ifge +28 -> 1450
    //   1425: aload 18
    //   1427: astore 16
    //   1429: aload 18
    //   1431: astore 17
    //   1433: getstatic 47	com/tencent/mm/plugin/trafficmonitor/a:AiD	Ljava/util/Map;
    //   1436: iload_0
    //   1437: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1440: lload_2
    //   1441: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1444: invokeinterface 154 3 0
    //   1449: pop
    //   1450: aload 18
    //   1452: astore 16
    //   1454: aload 18
    //   1456: astore 17
    //   1458: getstatic 45	com/tencent/mm/plugin/trafficmonitor/a:AiC	Ljava/util/Map;
    //   1461: iload_0
    //   1462: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1465: invokeinterface 129 2 0
    //   1470: checkcast 131	java/lang/Long
    //   1473: invokevirtual 135	java/lang/Long:longValue	()J
    //   1476: lconst_0
    //   1477: lcmp
    //   1478: ifge +29 -> 1507
    //   1481: aload 18
    //   1483: astore 16
    //   1485: aload 18
    //   1487: astore 17
    //   1489: getstatic 45	com/tencent/mm/plugin/trafficmonitor/a:AiC	Ljava/util/Map;
    //   1492: iload_0
    //   1493: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1496: lload 8
    //   1498: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1501: invokeinterface 154 3 0
    //   1506: pop
    //   1507: aload 18
    //   1509: astore 16
    //   1511: aload 18
    //   1513: astore 17
    //   1515: getstatic 49	com/tencent/mm/plugin/trafficmonitor/a:AiE	Ljava/util/Map;
    //   1518: astore 19
    //   1520: aload 18
    //   1522: astore 16
    //   1524: aload 18
    //   1526: astore 17
    //   1528: lload 4
    //   1530: getstatic 41	com/tencent/mm/plugin/trafficmonitor/a:AiA	Ljava/util/Map;
    //   1533: iload_0
    //   1534: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1537: invokeinterface 129 2 0
    //   1542: checkcast 131	java/lang/Long
    //   1545: invokevirtual 135	java/lang/Long:longValue	()J
    //   1548: lcmp
    //   1549: iflt +491 -> 2040
    //   1552: aload 18
    //   1554: astore 16
    //   1556: aload 18
    //   1558: astore 17
    //   1560: lload 4
    //   1562: getstatic 41	com/tencent/mm/plugin/trafficmonitor/a:AiA	Ljava/util/Map;
    //   1565: iload_0
    //   1566: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1569: invokeinterface 129 2 0
    //   1574: checkcast 131	java/lang/Long
    //   1577: invokevirtual 135	java/lang/Long:longValue	()J
    //   1580: lsub
    //   1581: lstore 10
    //   1583: aload 18
    //   1585: astore 16
    //   1587: aload 18
    //   1589: astore 17
    //   1591: aload 19
    //   1593: iload_0
    //   1594: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1597: lload 10
    //   1599: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1602: invokeinterface 154 3 0
    //   1607: pop
    //   1608: aload 18
    //   1610: astore 16
    //   1612: aload 18
    //   1614: astore 17
    //   1616: getstatic 51	com/tencent/mm/plugin/trafficmonitor/a:AiF	Ljava/util/Map;
    //   1619: astore 19
    //   1621: aload 18
    //   1623: astore 16
    //   1625: aload 18
    //   1627: astore 17
    //   1629: lload 6
    //   1631: getstatic 43	com/tencent/mm/plugin/trafficmonitor/a:AiB	Ljava/util/Map;
    //   1634: iload_0
    //   1635: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1638: invokeinterface 129 2 0
    //   1643: checkcast 131	java/lang/Long
    //   1646: invokevirtual 135	java/lang/Long:longValue	()J
    //   1649: lcmp
    //   1650: iflt +397 -> 2047
    //   1653: aload 18
    //   1655: astore 16
    //   1657: aload 18
    //   1659: astore 17
    //   1661: lload 6
    //   1663: getstatic 43	com/tencent/mm/plugin/trafficmonitor/a:AiB	Ljava/util/Map;
    //   1666: iload_0
    //   1667: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1670: invokeinterface 129 2 0
    //   1675: checkcast 131	java/lang/Long
    //   1678: invokevirtual 135	java/lang/Long:longValue	()J
    //   1681: lsub
    //   1682: lstore 10
    //   1684: aload 18
    //   1686: astore 16
    //   1688: aload 18
    //   1690: astore 17
    //   1692: aload 19
    //   1694: iload_0
    //   1695: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1698: lload 10
    //   1700: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1703: invokeinterface 154 3 0
    //   1708: pop
    //   1709: aload 18
    //   1711: astore 16
    //   1713: aload 18
    //   1715: astore 17
    //   1717: getstatic 53	com/tencent/mm/plugin/trafficmonitor/a:AiG	Ljava/util/Map;
    //   1720: astore 19
    //   1722: aload 18
    //   1724: astore 16
    //   1726: aload 18
    //   1728: astore 17
    //   1730: lload 8
    //   1732: getstatic 45	com/tencent/mm/plugin/trafficmonitor/a:AiC	Ljava/util/Map;
    //   1735: iload_0
    //   1736: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1739: invokeinterface 129 2 0
    //   1744: checkcast 131	java/lang/Long
    //   1747: invokevirtual 135	java/lang/Long:longValue	()J
    //   1750: lcmp
    //   1751: iflt +303 -> 2054
    //   1754: aload 18
    //   1756: astore 16
    //   1758: aload 18
    //   1760: astore 17
    //   1762: lload 8
    //   1764: getstatic 45	com/tencent/mm/plugin/trafficmonitor/a:AiC	Ljava/util/Map;
    //   1767: iload_0
    //   1768: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1771: invokeinterface 129 2 0
    //   1776: checkcast 131	java/lang/Long
    //   1779: invokevirtual 135	java/lang/Long:longValue	()J
    //   1782: lsub
    //   1783: lstore 10
    //   1785: aload 18
    //   1787: astore 16
    //   1789: aload 18
    //   1791: astore 17
    //   1793: aload 19
    //   1795: iload_0
    //   1796: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1799: lload 10
    //   1801: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1804: invokeinterface 154 3 0
    //   1809: pop
    //   1810: aload 18
    //   1812: astore 16
    //   1814: aload 18
    //   1816: astore 17
    //   1818: getstatic 55	com/tencent/mm/plugin/trafficmonitor/a:AiH	Ljava/util/Map;
    //   1821: astore 19
    //   1823: aload 18
    //   1825: astore 16
    //   1827: aload 18
    //   1829: astore 17
    //   1831: lload_2
    //   1832: getstatic 47	com/tencent/mm/plugin/trafficmonitor/a:AiD	Ljava/util/Map;
    //   1835: iload_0
    //   1836: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1839: invokeinterface 129 2 0
    //   1844: checkcast 131	java/lang/Long
    //   1847: invokevirtual 135	java/lang/Long:longValue	()J
    //   1850: lcmp
    //   1851: iflt +210 -> 2061
    //   1854: aload 18
    //   1856: astore 16
    //   1858: aload 18
    //   1860: astore 17
    //   1862: lload_2
    //   1863: getstatic 47	com/tencent/mm/plugin/trafficmonitor/a:AiD	Ljava/util/Map;
    //   1866: iload_0
    //   1867: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1870: invokeinterface 129 2 0
    //   1875: checkcast 131	java/lang/Long
    //   1878: invokevirtual 135	java/lang/Long:longValue	()J
    //   1881: lsub
    //   1882: lstore 10
    //   1884: aload 18
    //   1886: astore 16
    //   1888: aload 18
    //   1890: astore 17
    //   1892: aload 19
    //   1894: iload_0
    //   1895: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1898: lload 10
    //   1900: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1903: invokeinterface 154 3 0
    //   1908: pop
    //   1909: aload 18
    //   1911: astore 16
    //   1913: aload 18
    //   1915: astore 17
    //   1917: getstatic 41	com/tencent/mm/plugin/trafficmonitor/a:AiA	Ljava/util/Map;
    //   1920: iload_0
    //   1921: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1924: lload 4
    //   1926: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1929: invokeinterface 154 3 0
    //   1934: pop
    //   1935: aload 18
    //   1937: astore 16
    //   1939: aload 18
    //   1941: astore 17
    //   1943: getstatic 43	com/tencent/mm/plugin/trafficmonitor/a:AiB	Ljava/util/Map;
    //   1946: iload_0
    //   1947: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1950: lload 6
    //   1952: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1955: invokeinterface 154 3 0
    //   1960: pop
    //   1961: aload 18
    //   1963: astore 16
    //   1965: aload 18
    //   1967: astore 17
    //   1969: getstatic 45	com/tencent/mm/plugin/trafficmonitor/a:AiC	Ljava/util/Map;
    //   1972: iload_0
    //   1973: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1976: lload 8
    //   1978: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1981: invokeinterface 154 3 0
    //   1986: pop
    //   1987: aload 18
    //   1989: astore 16
    //   1991: aload 18
    //   1993: astore 17
    //   1995: getstatic 47	com/tencent/mm/plugin/trafficmonitor/a:AiD	Ljava/util/Map;
    //   1998: iload_0
    //   1999: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2002: lload_2
    //   2003: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2006: invokeinterface 154 3 0
    //   2011: pop
    //   2012: aload 18
    //   2014: astore 16
    //   2016: aload 18
    //   2018: astore 17
    //   2020: aload 18
    //   2022: invokestatic 212	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   2025: aload 18
    //   2027: astore 17
    //   2029: aload 17
    //   2031: invokestatic 212	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   2034: ldc 164
    //   2036: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2039: return
    //   2040: lload 4
    //   2042: lstore 10
    //   2044: goto -461 -> 1583
    //   2047: lload 6
    //   2049: lstore 10
    //   2051: goto -367 -> 1684
    //   2054: lload 8
    //   2056: lstore 10
    //   2058: goto -273 -> 1785
    //   2061: lload_2
    //   2062: lstore 10
    //   2064: goto -180 -> 1884
    //   2067: astore 16
    //   2069: aconst_null
    //   2070: astore 17
    //   2072: aload 17
    //   2074: astore 16
    //   2076: getstatic 49	com/tencent/mm/plugin/trafficmonitor/a:AiE	Ljava/util/Map;
    //   2079: iload_0
    //   2080: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2083: lconst_0
    //   2084: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2087: invokeinterface 154 3 0
    //   2092: pop
    //   2093: aload 17
    //   2095: astore 16
    //   2097: getstatic 51	com/tencent/mm/plugin/trafficmonitor/a:AiF	Ljava/util/Map;
    //   2100: iload_0
    //   2101: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2104: lconst_0
    //   2105: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2108: invokeinterface 154 3 0
    //   2113: pop
    //   2114: aload 17
    //   2116: astore 16
    //   2118: getstatic 53	com/tencent/mm/plugin/trafficmonitor/a:AiG	Ljava/util/Map;
    //   2121: iload_0
    //   2122: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2125: lconst_0
    //   2126: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2129: invokeinterface 154 3 0
    //   2134: pop
    //   2135: aload 17
    //   2137: astore 16
    //   2139: getstatic 55	com/tencent/mm/plugin/trafficmonitor/a:AiH	Ljava/util/Map;
    //   2142: iload_0
    //   2143: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2146: lconst_0
    //   2147: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2150: invokeinterface 154 3 0
    //   2155: pop
    //   2156: aload 17
    //   2158: astore 16
    //   2160: getstatic 41	com/tencent/mm/plugin/trafficmonitor/a:AiA	Ljava/util/Map;
    //   2163: iload_0
    //   2164: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2167: ldc2_w 157
    //   2170: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2173: invokeinterface 154 3 0
    //   2178: pop
    //   2179: aload 17
    //   2181: astore 16
    //   2183: getstatic 43	com/tencent/mm/plugin/trafficmonitor/a:AiB	Ljava/util/Map;
    //   2186: iload_0
    //   2187: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2190: ldc2_w 157
    //   2193: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2196: invokeinterface 154 3 0
    //   2201: pop
    //   2202: aload 17
    //   2204: astore 16
    //   2206: getstatic 45	com/tencent/mm/plugin/trafficmonitor/a:AiC	Ljava/util/Map;
    //   2209: iload_0
    //   2210: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2213: ldc2_w 157
    //   2216: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2219: invokeinterface 154 3 0
    //   2224: pop
    //   2225: aload 17
    //   2227: astore 16
    //   2229: getstatic 47	com/tencent/mm/plugin/trafficmonitor/a:AiD	Ljava/util/Map;
    //   2232: iload_0
    //   2233: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2236: ldc2_w 157
    //   2239: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2242: invokeinterface 154 3 0
    //   2247: pop
    //   2248: aload 17
    //   2250: invokestatic 212	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   2253: ldc 164
    //   2255: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2258: return
    //   2259: astore 17
    //   2261: aconst_null
    //   2262: astore 16
    //   2264: aload 16
    //   2266: invokestatic 212	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   2269: ldc 164
    //   2271: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2274: aload 17
    //   2276: athrow
    //   2277: astore 17
    //   2279: goto -15 -> 2264
    //   2282: astore 17
    //   2284: goto -20 -> 2264
    //   2287: astore 16
    //   2289: goto -217 -> 2072
    //   2292: astore 17
    //   2294: aload 16
    //   2296: astore 17
    //   2298: goto -226 -> 2072
    //   2301: goto +58 -> 2359
    //   2304: goto +8 -> 2312
    //   2307: iconst_0
    //   2308: istore_1
    //   2309: goto -2174 -> 135
    //   2312: goto -2234 -> 78
    //   2315: lload 6
    //   2317: lload 12
    //   2319: ladd
    //   2320: lstore 6
    //   2322: lload 4
    //   2324: lload 10
    //   2326: ladd
    //   2327: lstore 4
    //   2329: goto -1221 -> 1108
    //   2332: lload 6
    //   2334: lstore 10
    //   2336: goto -1734 -> 602
    //   2339: lload 4
    //   2341: lstore 10
    //   2343: goto -1640 -> 703
    //   2346: lload 8
    //   2348: lstore 10
    //   2350: goto -1546 -> 804
    //   2353: lload_2
    //   2354: lstore 10
    //   2356: goto -1453 -> 903
    //   2359: goto -1251 -> 1108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2362	0	paramInt	int
    //   134	2175	1	i	int
    //   15	2339	2	l1	long
    //   9	2331	4	l2	long
    //   6	2327	6	l3	long
    //   12	2335	8	l4	long
    //   600	1755	10	l5	long
    //   20	2298	12	l6	long
    //   17	1084	14	l7	long
    //   23	1992	16	localObject1	Object
    //   2067	1	16	localException1	java.lang.Exception
    //   2074	191	16	localObject2	Object
    //   2287	8	16	localException2	java.lang.Exception
    //   56	2193	17	localObject3	Object
    //   2259	16	17	localObject4	Object
    //   2277	1	17	localObject5	Object
    //   2282	1	17	localObject6	Object
    //   2292	1	17	localException3	java.lang.Exception
    //   2296	1	17	localException4	java.lang.Exception
    //   48	1978	18	localBufferedReader	java.io.BufferedReader
    //   91	1802	19	localObject7	Object
    //   1169	87	20	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   25	50	2067	java/lang/Exception
    //   25	50	2259	finally
    //   58	64	2277	finally
    //   72	78	2277	finally
    //   86	93	2277	finally
    //   106	115	2277	finally
    //   123	133	2277	finally
    //   143	157	2277	finally
    //   165	179	2277	finally
    //   187	201	2277	finally
    //   209	225	2277	finally
    //   233	248	2277	finally
    //   259	275	2277	finally
    //   283	296	2277	finally
    //   307	330	2277	finally
    //   338	356	2277	finally
    //   364	387	2277	finally
    //   395	413	2277	finally
    //   421	444	2277	finally
    //   452	470	2277	finally
    //   478	501	2277	finally
    //   509	526	2277	finally
    //   534	539	2277	finally
    //   547	571	2277	finally
    //   579	602	2277	finally
    //   610	627	2277	finally
    //   635	640	2277	finally
    //   648	672	2277	finally
    //   680	703	2277	finally
    //   711	728	2277	finally
    //   736	741	2277	finally
    //   749	773	2277	finally
    //   781	804	2277	finally
    //   812	829	2277	finally
    //   837	842	2277	finally
    //   850	873	2277	finally
    //   881	903	2277	finally
    //   911	928	2277	finally
    //   936	954	2277	finally
    //   962	980	2277	finally
    //   988	1006	2277	finally
    //   1014	1031	2277	finally
    //   1039	1044	2277	finally
    //   1089	1095	2277	finally
    //   1116	1123	2277	finally
    //   1136	1145	2277	finally
    //   1153	1165	2277	finally
    //   1179	1189	2277	finally
    //   1197	1208	2277	finally
    //   1216	1226	2277	finally
    //   1234	1244	2277	finally
    //   1255	1265	2277	finally
    //   1288	1311	2277	finally
    //   1319	1337	2277	finally
    //   1345	1368	2277	finally
    //   1376	1394	2277	finally
    //   1402	1425	2277	finally
    //   1433	1450	2277	finally
    //   1458	1481	2277	finally
    //   1489	1507	2277	finally
    //   1515	1520	2277	finally
    //   1528	1552	2277	finally
    //   1560	1583	2277	finally
    //   1591	1608	2277	finally
    //   1616	1621	2277	finally
    //   1629	1653	2277	finally
    //   1661	1684	2277	finally
    //   1692	1709	2277	finally
    //   1717	1722	2277	finally
    //   1730	1754	2277	finally
    //   1762	1785	2277	finally
    //   1793	1810	2277	finally
    //   1818	1823	2277	finally
    //   1831	1854	2277	finally
    //   1862	1884	2277	finally
    //   1892	1909	2277	finally
    //   1917	1935	2277	finally
    //   1943	1961	2277	finally
    //   1969	1987	2277	finally
    //   1995	2012	2277	finally
    //   2020	2025	2277	finally
    //   2076	2093	2277	finally
    //   2097	2114	2277	finally
    //   2118	2135	2277	finally
    //   2139	2156	2277	finally
    //   2160	2179	2277	finally
    //   2183	2202	2277	finally
    //   2206	2225	2277	finally
    //   2229	2248	2277	finally
    //   1052	1081	2282	finally
    //   58	64	2287	java/lang/Exception
    //   72	78	2287	java/lang/Exception
    //   86	93	2287	java/lang/Exception
    //   106	115	2287	java/lang/Exception
    //   123	133	2287	java/lang/Exception
    //   143	157	2287	java/lang/Exception
    //   165	179	2287	java/lang/Exception
    //   187	201	2287	java/lang/Exception
    //   209	225	2287	java/lang/Exception
    //   233	248	2287	java/lang/Exception
    //   259	275	2287	java/lang/Exception
    //   283	296	2287	java/lang/Exception
    //   307	330	2287	java/lang/Exception
    //   338	356	2287	java/lang/Exception
    //   364	387	2287	java/lang/Exception
    //   395	413	2287	java/lang/Exception
    //   421	444	2287	java/lang/Exception
    //   452	470	2287	java/lang/Exception
    //   478	501	2287	java/lang/Exception
    //   509	526	2287	java/lang/Exception
    //   534	539	2287	java/lang/Exception
    //   547	571	2287	java/lang/Exception
    //   579	602	2287	java/lang/Exception
    //   610	627	2287	java/lang/Exception
    //   635	640	2287	java/lang/Exception
    //   648	672	2287	java/lang/Exception
    //   680	703	2287	java/lang/Exception
    //   711	728	2287	java/lang/Exception
    //   736	741	2287	java/lang/Exception
    //   749	773	2287	java/lang/Exception
    //   781	804	2287	java/lang/Exception
    //   812	829	2287	java/lang/Exception
    //   837	842	2287	java/lang/Exception
    //   850	873	2287	java/lang/Exception
    //   881	903	2287	java/lang/Exception
    //   911	928	2287	java/lang/Exception
    //   936	954	2287	java/lang/Exception
    //   962	980	2287	java/lang/Exception
    //   988	1006	2287	java/lang/Exception
    //   1014	1031	2287	java/lang/Exception
    //   1039	1044	2287	java/lang/Exception
    //   1089	1095	2287	java/lang/Exception
    //   1116	1123	2287	java/lang/Exception
    //   1136	1145	2287	java/lang/Exception
    //   1153	1165	2287	java/lang/Exception
    //   1179	1189	2287	java/lang/Exception
    //   1197	1208	2287	java/lang/Exception
    //   1216	1226	2287	java/lang/Exception
    //   1234	1244	2287	java/lang/Exception
    //   1255	1265	2287	java/lang/Exception
    //   1288	1311	2287	java/lang/Exception
    //   1319	1337	2287	java/lang/Exception
    //   1345	1368	2287	java/lang/Exception
    //   1376	1394	2287	java/lang/Exception
    //   1402	1425	2287	java/lang/Exception
    //   1433	1450	2287	java/lang/Exception
    //   1458	1481	2287	java/lang/Exception
    //   1489	1507	2287	java/lang/Exception
    //   1515	1520	2287	java/lang/Exception
    //   1528	1552	2287	java/lang/Exception
    //   1560	1583	2287	java/lang/Exception
    //   1591	1608	2287	java/lang/Exception
    //   1616	1621	2287	java/lang/Exception
    //   1629	1653	2287	java/lang/Exception
    //   1661	1684	2287	java/lang/Exception
    //   1692	1709	2287	java/lang/Exception
    //   1717	1722	2287	java/lang/Exception
    //   1730	1754	2287	java/lang/Exception
    //   1762	1785	2287	java/lang/Exception
    //   1793	1810	2287	java/lang/Exception
    //   1818	1823	2287	java/lang/Exception
    //   1831	1854	2287	java/lang/Exception
    //   1862	1884	2287	java/lang/Exception
    //   1892	1909	2287	java/lang/Exception
    //   1917	1935	2287	java/lang/Exception
    //   1943	1961	2287	java/lang/Exception
    //   1969	1987	2287	java/lang/Exception
    //   1995	2012	2287	java/lang/Exception
    //   2020	2025	2287	java/lang/Exception
    //   1052	1081	2292	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.a
 * JD-Core Version:    0.7.0.1
 */