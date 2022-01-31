package com.tencent.mm.plugin.trafficmonitor;

import android.os.Process;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static Map<Integer, Long> pJA;
  private static Map<Integer, Long> pJB;
  private static Map<Integer, Long> pJC;
  private static Map<Integer, Long> pJD;
  private static Map<Integer, Long> pJE;
  private static Map<Integer, Long> pJF;
  private static Map<Integer, Long> pJG;
  private static Map<Integer, Long> pJH;
  private static Map<Integer, Long> pJI;
  private static Map<Integer, Long> pJJ;
  private static Map<Integer, Long> pJK;
  private static Map<Integer, Long> pJL;
  private static Map<Integer, Long> pJM;
  private static Map<Integer, Long> pJN;
  private static Map<Integer, Long> pJO;
  private static Map<Integer, Long> pJP;
  private static final File pJQ;
  private static final File pJR;
  
  static
  {
    Object localObject2 = null;
    pJI = new HashMap();
    pJJ = new HashMap();
    pJK = new HashMap();
    pJL = new HashMap();
    pJM = new HashMap();
    pJN = new HashMap();
    pJO = new HashMap();
    pJP = new HashMap();
    pJA = new HashMap();
    pJB = new HashMap();
    pJC = new HashMap();
    pJD = new HashMap();
    pJE = new HashMap();
    pJF = new HashMap();
    pJG = new HashMap();
    pJH = new HashMap();
    Object localObject1 = new File("/proc/" + Process.myPid() + "/net/dev");
    if (((File)localObject1).isFile()) {}
    for (;;)
    {
      pJQ = (File)localObject1;
      File localFile = new File("/proc/net/xt_qtaguid/stats");
      localObject1 = localObject2;
      if (localFile.isFile()) {
        localObject1 = localFile;
      }
      pJR = (File)localObject1;
      return;
      localObject1 = null;
    }
  }
  
  public static void init(int paramInt)
  {
    pJI.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    pJJ.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    pJK.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    pJL.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    pJM.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    pJN.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    pJO.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    pJP.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    pJA.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    pJB.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    pJC.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    pJD.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    pJE.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    pJF.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    pJG.put(Integer.valueOf(paramInt), Long.valueOf(0L));
    pJH.put(Integer.valueOf(paramInt), Long.valueOf(0L));
  }
  
  public static void reset(int paramInt)
  {
    pJJ.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    pJI.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    pJL.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    pJK.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    pJB.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    pJA.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    pJD.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    pJC.put(Integer.valueOf(paramInt), Long.valueOf(-1L));
    update(paramInt);
  }
  
  /* Error */
  public static void update(int paramInt)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 6
    //   3: lconst_0
    //   4: lstore 4
    //   6: lconst_0
    //   7: lstore 8
    //   9: lconst_0
    //   10: lstore_2
    //   11: lconst_0
    //   12: lstore 14
    //   14: lconst_0
    //   15: lstore 12
    //   17: getstatic 99	com/tencent/mm/plugin/trafficmonitor/a:pJQ	Ljava/io/File;
    //   20: ifnull +732 -> 752
    //   23: new 133	java/util/Scanner
    //   26: dup
    //   27: getstatic 99	com/tencent/mm/plugin/trafficmonitor/a:pJQ	Ljava/io/File;
    //   30: invokespecial 136	java/util/Scanner:<init>	(Ljava/io/File;)V
    //   33: astore 16
    //   35: aload 16
    //   37: astore 17
    //   39: aload 16
    //   41: invokevirtual 139	java/util/Scanner:nextLine	()Ljava/lang/String;
    //   44: pop
    //   45: aload 16
    //   47: astore 17
    //   49: aload 16
    //   51: invokevirtual 139	java/util/Scanner:nextLine	()Ljava/lang/String;
    //   54: pop
    //   55: aload 16
    //   57: astore 17
    //   59: aload 16
    //   61: invokevirtual 142	java/util/Scanner:hasNext	()Z
    //   64: ifeq +171 -> 235
    //   67: aload 16
    //   69: astore 17
    //   71: aload 16
    //   73: invokevirtual 139	java/util/Scanner:nextLine	()Ljava/lang/String;
    //   76: ldc 144
    //   78: invokevirtual 150	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   81: astore 18
    //   83: aload 16
    //   85: astore 17
    //   87: aload 18
    //   89: iconst_0
    //   90: aaload
    //   91: invokevirtual 153	java/lang/String:length	()I
    //   94: ifne +1738 -> 1832
    //   97: iconst_1
    //   98: istore_1
    //   99: aload 16
    //   101: astore 17
    //   103: aload 18
    //   105: iload_1
    //   106: iconst_0
    //   107: iadd
    //   108: aaload
    //   109: ldc 155
    //   111: invokevirtual 159	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   114: ifne +1715 -> 1829
    //   117: aload 16
    //   119: astore 17
    //   121: aload 18
    //   123: iload_1
    //   124: iconst_0
    //   125: iadd
    //   126: aaload
    //   127: ldc 161
    //   129: invokevirtual 165	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   132: ifne +21 -> 153
    //   135: aload 16
    //   137: astore 17
    //   139: aload 18
    //   141: iload_1
    //   142: iconst_0
    //   143: iadd
    //   144: aaload
    //   145: ldc 167
    //   147: invokevirtual 165	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   150: ifeq +45 -> 195
    //   153: aload 16
    //   155: astore 17
    //   157: lload 6
    //   159: aload 18
    //   161: iload_1
    //   162: bipush 9
    //   164: iadd
    //   165: aaload
    //   166: lconst_0
    //   167: invokestatic 173	com/tencent/mm/sdk/platformtools/bk:getLong	(Ljava/lang/String;J)J
    //   170: ladd
    //   171: lstore 6
    //   173: aload 16
    //   175: astore 17
    //   177: lload 4
    //   179: aload 18
    //   181: iload_1
    //   182: iconst_1
    //   183: iadd
    //   184: aaload
    //   185: lconst_0
    //   186: invokestatic 173	com/tencent/mm/sdk/platformtools/bk:getLong	(Ljava/lang/String;J)J
    //   189: ladd
    //   190: lstore 4
    //   192: goto -137 -> 55
    //   195: aload 16
    //   197: astore 17
    //   199: lload 8
    //   201: aload 18
    //   203: iload_1
    //   204: bipush 9
    //   206: iadd
    //   207: aaload
    //   208: lconst_0
    //   209: invokestatic 173	com/tencent/mm/sdk/platformtools/bk:getLong	(Ljava/lang/String;J)J
    //   212: ladd
    //   213: lstore 8
    //   215: aload 16
    //   217: astore 17
    //   219: aload 18
    //   221: iload_1
    //   222: iconst_1
    //   223: iadd
    //   224: aaload
    //   225: lconst_0
    //   226: invokestatic 173	com/tencent/mm/sdk/platformtools/bk:getLong	(Ljava/lang/String;J)J
    //   229: lload_2
    //   230: ladd
    //   231: lstore_2
    //   232: goto +1605 -> 1837
    //   235: aload 16
    //   237: astore 17
    //   239: aload 16
    //   241: invokevirtual 176	java/util/Scanner:close	()V
    //   244: getstatic 50	com/tencent/mm/plugin/trafficmonitor/a:pJA	Ljava/util/Map;
    //   247: iload_0
    //   248: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   251: invokeinterface 180 2 0
    //   256: checkcast 114	java/lang/Long
    //   259: invokevirtual 184	java/lang/Long:longValue	()J
    //   262: lconst_0
    //   263: lcmp
    //   264: ifge +21 -> 285
    //   267: getstatic 50	com/tencent/mm/plugin/trafficmonitor/a:pJA	Ljava/util/Map;
    //   270: iload_0
    //   271: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   274: lload 6
    //   276: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   279: invokeinterface 123 3 0
    //   284: pop
    //   285: getstatic 52	com/tencent/mm/plugin/trafficmonitor/a:pJB	Ljava/util/Map;
    //   288: iload_0
    //   289: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   292: invokeinterface 180 2 0
    //   297: checkcast 114	java/lang/Long
    //   300: invokevirtual 184	java/lang/Long:longValue	()J
    //   303: lconst_0
    //   304: lcmp
    //   305: ifge +21 -> 326
    //   308: getstatic 52	com/tencent/mm/plugin/trafficmonitor/a:pJB	Ljava/util/Map;
    //   311: iload_0
    //   312: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   315: lload 4
    //   317: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   320: invokeinterface 123 3 0
    //   325: pop
    //   326: getstatic 54	com/tencent/mm/plugin/trafficmonitor/a:pJC	Ljava/util/Map;
    //   329: iload_0
    //   330: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   333: invokeinterface 180 2 0
    //   338: checkcast 114	java/lang/Long
    //   341: invokevirtual 184	java/lang/Long:longValue	()J
    //   344: lconst_0
    //   345: lcmp
    //   346: ifge +21 -> 367
    //   349: getstatic 54	com/tencent/mm/plugin/trafficmonitor/a:pJC	Ljava/util/Map;
    //   352: iload_0
    //   353: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   356: lload 8
    //   358: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   361: invokeinterface 123 3 0
    //   366: pop
    //   367: getstatic 56	com/tencent/mm/plugin/trafficmonitor/a:pJD	Ljava/util/Map;
    //   370: iload_0
    //   371: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   374: invokeinterface 180 2 0
    //   379: checkcast 114	java/lang/Long
    //   382: invokevirtual 184	java/lang/Long:longValue	()J
    //   385: lconst_0
    //   386: lcmp
    //   387: ifge +20 -> 407
    //   390: getstatic 56	com/tencent/mm/plugin/trafficmonitor/a:pJD	Ljava/util/Map;
    //   393: iload_0
    //   394: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   397: lload_2
    //   398: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   401: invokeinterface 123 3 0
    //   406: pop
    //   407: getstatic 58	com/tencent/mm/plugin/trafficmonitor/a:pJE	Ljava/util/Map;
    //   410: astore 16
    //   412: lload 6
    //   414: getstatic 50	com/tencent/mm/plugin/trafficmonitor/a:pJA	Ljava/util/Map;
    //   417: iload_0
    //   418: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   421: invokeinterface 180 2 0
    //   426: checkcast 114	java/lang/Long
    //   429: invokevirtual 184	java/lang/Long:longValue	()J
    //   432: lcmp
    //   433: iflt +1424 -> 1857
    //   436: lload 6
    //   438: getstatic 50	com/tencent/mm/plugin/trafficmonitor/a:pJA	Ljava/util/Map;
    //   441: iload_0
    //   442: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   445: invokeinterface 180 2 0
    //   450: checkcast 114	java/lang/Long
    //   453: invokevirtual 184	java/lang/Long:longValue	()J
    //   456: lsub
    //   457: lstore 10
    //   459: aload 16
    //   461: iload_0
    //   462: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   465: lload 10
    //   467: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   470: invokeinterface 123 3 0
    //   475: pop
    //   476: getstatic 60	com/tencent/mm/plugin/trafficmonitor/a:pJF	Ljava/util/Map;
    //   479: astore 16
    //   481: lload 4
    //   483: getstatic 52	com/tencent/mm/plugin/trafficmonitor/a:pJB	Ljava/util/Map;
    //   486: iload_0
    //   487: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   490: invokeinterface 180 2 0
    //   495: checkcast 114	java/lang/Long
    //   498: invokevirtual 184	java/lang/Long:longValue	()J
    //   501: lcmp
    //   502: iflt +1362 -> 1864
    //   505: lload 4
    //   507: getstatic 52	com/tencent/mm/plugin/trafficmonitor/a:pJB	Ljava/util/Map;
    //   510: iload_0
    //   511: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   514: invokeinterface 180 2 0
    //   519: checkcast 114	java/lang/Long
    //   522: invokevirtual 184	java/lang/Long:longValue	()J
    //   525: lsub
    //   526: lstore 10
    //   528: aload 16
    //   530: iload_0
    //   531: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   534: lload 10
    //   536: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   539: invokeinterface 123 3 0
    //   544: pop
    //   545: getstatic 62	com/tencent/mm/plugin/trafficmonitor/a:pJG	Ljava/util/Map;
    //   548: astore 16
    //   550: lload 8
    //   552: getstatic 54	com/tencent/mm/plugin/trafficmonitor/a:pJC	Ljava/util/Map;
    //   555: iload_0
    //   556: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   559: invokeinterface 180 2 0
    //   564: checkcast 114	java/lang/Long
    //   567: invokevirtual 184	java/lang/Long:longValue	()J
    //   570: lcmp
    //   571: iflt +1300 -> 1871
    //   574: lload 8
    //   576: getstatic 54	com/tencent/mm/plugin/trafficmonitor/a:pJC	Ljava/util/Map;
    //   579: iload_0
    //   580: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   583: invokeinterface 180 2 0
    //   588: checkcast 114	java/lang/Long
    //   591: invokevirtual 184	java/lang/Long:longValue	()J
    //   594: lsub
    //   595: lstore 10
    //   597: aload 16
    //   599: iload_0
    //   600: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   603: lload 10
    //   605: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   608: invokeinterface 123 3 0
    //   613: pop
    //   614: getstatic 64	com/tencent/mm/plugin/trafficmonitor/a:pJH	Ljava/util/Map;
    //   617: astore 16
    //   619: lload_2
    //   620: getstatic 56	com/tencent/mm/plugin/trafficmonitor/a:pJD	Ljava/util/Map;
    //   623: iload_0
    //   624: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   627: invokeinterface 180 2 0
    //   632: checkcast 114	java/lang/Long
    //   635: invokevirtual 184	java/lang/Long:longValue	()J
    //   638: lcmp
    //   639: iflt +1239 -> 1878
    //   642: lload_2
    //   643: getstatic 56	com/tencent/mm/plugin/trafficmonitor/a:pJD	Ljava/util/Map;
    //   646: iload_0
    //   647: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   650: invokeinterface 180 2 0
    //   655: checkcast 114	java/lang/Long
    //   658: invokevirtual 184	java/lang/Long:longValue	()J
    //   661: lsub
    //   662: lstore 10
    //   664: aload 16
    //   666: iload_0
    //   667: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   670: lload 10
    //   672: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   675: invokeinterface 123 3 0
    //   680: pop
    //   681: getstatic 50	com/tencent/mm/plugin/trafficmonitor/a:pJA	Ljava/util/Map;
    //   684: iload_0
    //   685: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   688: lload 6
    //   690: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   693: invokeinterface 123 3 0
    //   698: pop
    //   699: getstatic 52	com/tencent/mm/plugin/trafficmonitor/a:pJB	Ljava/util/Map;
    //   702: iload_0
    //   703: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   706: lload 4
    //   708: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   711: invokeinterface 123 3 0
    //   716: pop
    //   717: getstatic 54	com/tencent/mm/plugin/trafficmonitor/a:pJC	Ljava/util/Map;
    //   720: iload_0
    //   721: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   724: lload 8
    //   726: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   729: invokeinterface 123 3 0
    //   734: pop
    //   735: getstatic 56	com/tencent/mm/plugin/trafficmonitor/a:pJD	Ljava/util/Map;
    //   738: iload_0
    //   739: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   742: lload_2
    //   743: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   746: invokeinterface 123 3 0
    //   751: pop
    //   752: getstatic 103	com/tencent/mm/plugin/trafficmonitor/a:pJR	Ljava/io/File;
    //   755: ifnull +1068 -> 1823
    //   758: invokestatic 187	android/os/Process:myUid	()I
    //   761: istore_1
    //   762: new 133	java/util/Scanner
    //   765: dup
    //   766: getstatic 103	com/tencent/mm/plugin/trafficmonitor/a:pJR	Ljava/io/File;
    //   769: invokespecial 136	java/util/Scanner:<init>	(Ljava/io/File;)V
    //   772: astore 16
    //   774: aload 16
    //   776: astore 17
    //   778: aload 16
    //   780: invokevirtual 139	java/util/Scanner:nextLine	()Ljava/lang/String;
    //   783: pop
    //   784: lconst_0
    //   785: lstore_2
    //   786: lconst_0
    //   787: lstore 8
    //   789: lload 14
    //   791: lstore 4
    //   793: lload 12
    //   795: lstore 6
    //   797: aload 16
    //   799: astore 17
    //   801: aload 16
    //   803: invokevirtual 142	java/util/Scanner:hasNext	()Z
    //   806: ifeq +130 -> 936
    //   809: aload 16
    //   811: astore 17
    //   813: aload 16
    //   815: invokevirtual 139	java/util/Scanner:nextLine	()Ljava/lang/String;
    //   818: ldc 189
    //   820: invokevirtual 150	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   823: astore 18
    //   825: aload 16
    //   827: astore 17
    //   829: aload 18
    //   831: iconst_3
    //   832: aaload
    //   833: iconst_0
    //   834: invokestatic 193	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   837: iload_1
    //   838: if_icmpne -41 -> 797
    //   841: aload 18
    //   843: iconst_1
    //   844: aaload
    //   845: astore 19
    //   847: aload 16
    //   849: astore 17
    //   851: aload 18
    //   853: iconst_5
    //   854: aaload
    //   855: lconst_0
    //   856: invokestatic 173	com/tencent/mm/sdk/platformtools/bk:getLong	(Ljava/lang/String;J)J
    //   859: lstore 12
    //   861: aload 16
    //   863: astore 17
    //   865: aload 18
    //   867: bipush 7
    //   869: aaload
    //   870: lconst_0
    //   871: invokestatic 173	com/tencent/mm/sdk/platformtools/bk:getLong	(Ljava/lang/String;J)J
    //   874: lstore 10
    //   876: aload 16
    //   878: astore 17
    //   880: aload 19
    //   882: ldc 161
    //   884: invokevirtual 165	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   887: ifne +953 -> 1840
    //   890: aload 16
    //   892: astore 17
    //   894: aload 19
    //   896: ldc 167
    //   898: invokevirtual 165	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   901: ifeq +6 -> 907
    //   904: goto +936 -> 1840
    //   907: aload 16
    //   909: astore 17
    //   911: aload 19
    //   913: ldc 155
    //   915: invokevirtual 159	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   918: ifne +902 -> 1820
    //   921: lload_2
    //   922: lload 12
    //   924: ladd
    //   925: lstore_2
    //   926: lload 8
    //   928: lload 10
    //   930: ladd
    //   931: lstore 8
    //   933: goto +951 -> 1884
    //   936: aload 16
    //   938: astore 17
    //   940: getstatic 36	com/tencent/mm/plugin/trafficmonitor/a:pJJ	Ljava/util/Map;
    //   943: iload_0
    //   944: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   947: invokeinterface 180 2 0
    //   952: checkcast 114	java/lang/Long
    //   955: invokevirtual 184	java/lang/Long:longValue	()J
    //   958: lconst_0
    //   959: lcmp
    //   960: ifge +25 -> 985
    //   963: aload 16
    //   965: astore 17
    //   967: getstatic 36	com/tencent/mm/plugin/trafficmonitor/a:pJJ	Ljava/util/Map;
    //   970: iload_0
    //   971: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   974: lload 6
    //   976: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   979: invokeinterface 123 3 0
    //   984: pop
    //   985: aload 16
    //   987: astore 17
    //   989: getstatic 34	com/tencent/mm/plugin/trafficmonitor/a:pJI	Ljava/util/Map;
    //   992: iload_0
    //   993: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   996: invokeinterface 180 2 0
    //   1001: checkcast 114	java/lang/Long
    //   1004: invokevirtual 184	java/lang/Long:longValue	()J
    //   1007: lconst_0
    //   1008: lcmp
    //   1009: ifge +25 -> 1034
    //   1012: aload 16
    //   1014: astore 17
    //   1016: getstatic 34	com/tencent/mm/plugin/trafficmonitor/a:pJI	Ljava/util/Map;
    //   1019: iload_0
    //   1020: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1023: lload 4
    //   1025: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1028: invokeinterface 123 3 0
    //   1033: pop
    //   1034: aload 16
    //   1036: astore 17
    //   1038: getstatic 40	com/tencent/mm/plugin/trafficmonitor/a:pJL	Ljava/util/Map;
    //   1041: iload_0
    //   1042: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1045: invokeinterface 180 2 0
    //   1050: checkcast 114	java/lang/Long
    //   1053: invokevirtual 184	java/lang/Long:longValue	()J
    //   1056: lconst_0
    //   1057: lcmp
    //   1058: ifge +24 -> 1082
    //   1061: aload 16
    //   1063: astore 17
    //   1065: getstatic 40	com/tencent/mm/plugin/trafficmonitor/a:pJL	Ljava/util/Map;
    //   1068: iload_0
    //   1069: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1072: lload_2
    //   1073: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1076: invokeinterface 123 3 0
    //   1081: pop
    //   1082: aload 16
    //   1084: astore 17
    //   1086: getstatic 38	com/tencent/mm/plugin/trafficmonitor/a:pJK	Ljava/util/Map;
    //   1089: iload_0
    //   1090: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1093: invokeinterface 180 2 0
    //   1098: checkcast 114	java/lang/Long
    //   1101: invokevirtual 184	java/lang/Long:longValue	()J
    //   1104: lconst_0
    //   1105: lcmp
    //   1106: ifge +25 -> 1131
    //   1109: aload 16
    //   1111: astore 17
    //   1113: getstatic 38	com/tencent/mm/plugin/trafficmonitor/a:pJK	Ljava/util/Map;
    //   1116: iload_0
    //   1117: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1120: lload 8
    //   1122: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1125: invokeinterface 123 3 0
    //   1130: pop
    //   1131: aload 16
    //   1133: astore 17
    //   1135: getstatic 42	com/tencent/mm/plugin/trafficmonitor/a:pJM	Ljava/util/Map;
    //   1138: astore 18
    //   1140: aload 16
    //   1142: astore 17
    //   1144: lload 4
    //   1146: getstatic 34	com/tencent/mm/plugin/trafficmonitor/a:pJI	Ljava/util/Map;
    //   1149: iload_0
    //   1150: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1153: invokeinterface 180 2 0
    //   1158: checkcast 114	java/lang/Long
    //   1161: invokevirtual 184	java/lang/Long:longValue	()J
    //   1164: lcmp
    //   1165: iflt +402 -> 1567
    //   1168: aload 16
    //   1170: astore 17
    //   1172: lload 4
    //   1174: getstatic 34	com/tencent/mm/plugin/trafficmonitor/a:pJI	Ljava/util/Map;
    //   1177: iload_0
    //   1178: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1181: invokeinterface 180 2 0
    //   1186: checkcast 114	java/lang/Long
    //   1189: invokevirtual 184	java/lang/Long:longValue	()J
    //   1192: lsub
    //   1193: lstore 10
    //   1195: aload 16
    //   1197: astore 17
    //   1199: aload 18
    //   1201: iload_0
    //   1202: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1205: lload 10
    //   1207: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1210: invokeinterface 123 3 0
    //   1215: pop
    //   1216: aload 16
    //   1218: astore 17
    //   1220: getstatic 44	com/tencent/mm/plugin/trafficmonitor/a:pJN	Ljava/util/Map;
    //   1223: astore 18
    //   1225: aload 16
    //   1227: astore 17
    //   1229: lload 6
    //   1231: getstatic 36	com/tencent/mm/plugin/trafficmonitor/a:pJJ	Ljava/util/Map;
    //   1234: iload_0
    //   1235: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1238: invokeinterface 180 2 0
    //   1243: checkcast 114	java/lang/Long
    //   1246: invokevirtual 184	java/lang/Long:longValue	()J
    //   1249: lcmp
    //   1250: iflt +324 -> 1574
    //   1253: aload 16
    //   1255: astore 17
    //   1257: lload 6
    //   1259: getstatic 36	com/tencent/mm/plugin/trafficmonitor/a:pJJ	Ljava/util/Map;
    //   1262: iload_0
    //   1263: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1266: invokeinterface 180 2 0
    //   1271: checkcast 114	java/lang/Long
    //   1274: invokevirtual 184	java/lang/Long:longValue	()J
    //   1277: lsub
    //   1278: lstore 10
    //   1280: aload 16
    //   1282: astore 17
    //   1284: aload 18
    //   1286: iload_0
    //   1287: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1290: lload 10
    //   1292: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1295: invokeinterface 123 3 0
    //   1300: pop
    //   1301: aload 16
    //   1303: astore 17
    //   1305: getstatic 46	com/tencent/mm/plugin/trafficmonitor/a:pJO	Ljava/util/Map;
    //   1308: astore 18
    //   1310: aload 16
    //   1312: astore 17
    //   1314: lload 8
    //   1316: getstatic 38	com/tencent/mm/plugin/trafficmonitor/a:pJK	Ljava/util/Map;
    //   1319: iload_0
    //   1320: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1323: invokeinterface 180 2 0
    //   1328: checkcast 114	java/lang/Long
    //   1331: invokevirtual 184	java/lang/Long:longValue	()J
    //   1334: lcmp
    //   1335: iflt +246 -> 1581
    //   1338: aload 16
    //   1340: astore 17
    //   1342: lload 8
    //   1344: getstatic 38	com/tencent/mm/plugin/trafficmonitor/a:pJK	Ljava/util/Map;
    //   1347: iload_0
    //   1348: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1351: invokeinterface 180 2 0
    //   1356: checkcast 114	java/lang/Long
    //   1359: invokevirtual 184	java/lang/Long:longValue	()J
    //   1362: lsub
    //   1363: lstore 10
    //   1365: aload 16
    //   1367: astore 17
    //   1369: aload 18
    //   1371: iload_0
    //   1372: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1375: lload 10
    //   1377: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1380: invokeinterface 123 3 0
    //   1385: pop
    //   1386: aload 16
    //   1388: astore 17
    //   1390: getstatic 48	com/tencent/mm/plugin/trafficmonitor/a:pJP	Ljava/util/Map;
    //   1393: astore 18
    //   1395: aload 16
    //   1397: astore 17
    //   1399: lload_2
    //   1400: getstatic 40	com/tencent/mm/plugin/trafficmonitor/a:pJL	Ljava/util/Map;
    //   1403: iload_0
    //   1404: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1407: invokeinterface 180 2 0
    //   1412: checkcast 114	java/lang/Long
    //   1415: invokevirtual 184	java/lang/Long:longValue	()J
    //   1418: lcmp
    //   1419: iflt +169 -> 1588
    //   1422: aload 16
    //   1424: astore 17
    //   1426: lload_2
    //   1427: getstatic 40	com/tencent/mm/plugin/trafficmonitor/a:pJL	Ljava/util/Map;
    //   1430: iload_0
    //   1431: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1434: invokeinterface 180 2 0
    //   1439: checkcast 114	java/lang/Long
    //   1442: invokevirtual 184	java/lang/Long:longValue	()J
    //   1445: lsub
    //   1446: lstore 10
    //   1448: aload 16
    //   1450: astore 17
    //   1452: aload 18
    //   1454: iload_0
    //   1455: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1458: lload 10
    //   1460: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1463: invokeinterface 123 3 0
    //   1468: pop
    //   1469: aload 16
    //   1471: astore 17
    //   1473: getstatic 34	com/tencent/mm/plugin/trafficmonitor/a:pJI	Ljava/util/Map;
    //   1476: iload_0
    //   1477: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1480: lload 4
    //   1482: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1485: invokeinterface 123 3 0
    //   1490: pop
    //   1491: aload 16
    //   1493: astore 17
    //   1495: getstatic 36	com/tencent/mm/plugin/trafficmonitor/a:pJJ	Ljava/util/Map;
    //   1498: iload_0
    //   1499: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1502: lload 6
    //   1504: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1507: invokeinterface 123 3 0
    //   1512: pop
    //   1513: aload 16
    //   1515: astore 17
    //   1517: getstatic 38	com/tencent/mm/plugin/trafficmonitor/a:pJK	Ljava/util/Map;
    //   1520: iload_0
    //   1521: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1524: lload 8
    //   1526: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1529: invokeinterface 123 3 0
    //   1534: pop
    //   1535: aload 16
    //   1537: astore 17
    //   1539: getstatic 40	com/tencent/mm/plugin/trafficmonitor/a:pJL	Ljava/util/Map;
    //   1542: iload_0
    //   1543: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1546: lload_2
    //   1547: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1550: invokeinterface 123 3 0
    //   1555: pop
    //   1556: aload 16
    //   1558: ifnull +8 -> 1566
    //   1561: aload 16
    //   1563: invokevirtual 176	java/util/Scanner:close	()V
    //   1566: return
    //   1567: lload 4
    //   1569: lstore 10
    //   1571: goto -376 -> 1195
    //   1574: lload 6
    //   1576: lstore 10
    //   1578: goto -298 -> 1280
    //   1581: lload 8
    //   1583: lstore 10
    //   1585: goto -220 -> 1365
    //   1588: lload_2
    //   1589: lstore 10
    //   1591: goto -143 -> 1448
    //   1594: aconst_null
    //   1595: astore 16
    //   1597: astore 17
    //   1599: getstatic 42	com/tencent/mm/plugin/trafficmonitor/a:pJM	Ljava/util/Map;
    //   1602: iload_0
    //   1603: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1606: lconst_0
    //   1607: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1610: invokeinterface 123 3 0
    //   1615: pop
    //   1616: getstatic 44	com/tencent/mm/plugin/trafficmonitor/a:pJN	Ljava/util/Map;
    //   1619: iload_0
    //   1620: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1623: lconst_0
    //   1624: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1627: invokeinterface 123 3 0
    //   1632: pop
    //   1633: getstatic 46	com/tencent/mm/plugin/trafficmonitor/a:pJO	Ljava/util/Map;
    //   1636: iload_0
    //   1637: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1640: lconst_0
    //   1641: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1644: invokeinterface 123 3 0
    //   1649: pop
    //   1650: getstatic 48	com/tencent/mm/plugin/trafficmonitor/a:pJP	Ljava/util/Map;
    //   1653: iload_0
    //   1654: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1657: lconst_0
    //   1658: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1661: invokeinterface 123 3 0
    //   1666: pop
    //   1667: getstatic 34	com/tencent/mm/plugin/trafficmonitor/a:pJI	Ljava/util/Map;
    //   1670: iload_0
    //   1671: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1674: ldc2_w 125
    //   1677: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1680: invokeinterface 123 3 0
    //   1685: pop
    //   1686: getstatic 36	com/tencent/mm/plugin/trafficmonitor/a:pJJ	Ljava/util/Map;
    //   1689: iload_0
    //   1690: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1693: ldc2_w 125
    //   1696: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1699: invokeinterface 123 3 0
    //   1704: pop
    //   1705: getstatic 38	com/tencent/mm/plugin/trafficmonitor/a:pJK	Ljava/util/Map;
    //   1708: iload_0
    //   1709: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1712: ldc2_w 125
    //   1715: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1718: invokeinterface 123 3 0
    //   1723: pop
    //   1724: getstatic 40	com/tencent/mm/plugin/trafficmonitor/a:pJL	Ljava/util/Map;
    //   1727: iload_0
    //   1728: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1731: ldc2_w 125
    //   1734: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1737: invokeinterface 123 3 0
    //   1742: pop
    //   1743: aload 16
    //   1745: ifnull -179 -> 1566
    //   1748: aload 16
    //   1750: invokevirtual 176	java/util/Scanner:close	()V
    //   1753: return
    //   1754: astore 16
    //   1756: aconst_null
    //   1757: astore 17
    //   1759: aload 17
    //   1761: ifnull +8 -> 1769
    //   1764: aload 17
    //   1766: invokevirtual 176	java/util/Scanner:close	()V
    //   1769: aload 16
    //   1771: athrow
    //   1772: astore 16
    //   1774: goto -15 -> 1759
    //   1777: astore 16
    //   1779: aconst_null
    //   1780: astore 17
    //   1782: goto -23 -> 1759
    //   1785: astore 17
    //   1787: aload 16
    //   1789: astore 18
    //   1791: aload 17
    //   1793: astore 16
    //   1795: aload 18
    //   1797: astore 17
    //   1799: goto -40 -> 1759
    //   1802: astore 17
    //   1804: goto -205 -> 1599
    //   1807: astore 16
    //   1809: aconst_null
    //   1810: astore 16
    //   1812: goto -213 -> 1599
    //   1815: astore 17
    //   1817: goto -218 -> 1599
    //   1820: goto +64 -> 1884
    //   1823: aconst_null
    //   1824: astore 16
    //   1826: goto -270 -> 1556
    //   1829: goto +8 -> 1837
    //   1832: iconst_0
    //   1833: istore_1
    //   1834: goto -1735 -> 99
    //   1837: goto -1782 -> 55
    //   1840: lload 6
    //   1842: lload 12
    //   1844: ladd
    //   1845: lstore 6
    //   1847: lload 4
    //   1849: lload 10
    //   1851: ladd
    //   1852: lstore 4
    //   1854: goto -1057 -> 797
    //   1857: lload 6
    //   1859: lstore 10
    //   1861: goto -1402 -> 459
    //   1864: lload 4
    //   1866: lstore 10
    //   1868: goto -1340 -> 528
    //   1871: lload 8
    //   1873: lstore 10
    //   1875: goto -1278 -> 597
    //   1878: lload_2
    //   1879: lstore 10
    //   1881: goto -1217 -> 664
    //   1884: goto -1087 -> 797
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1887	0	paramInt	int
    //   98	1736	1	i	int
    //   10	1869	2	l1	long
    //   4	1861	4	l2	long
    //   1	1857	6	l3	long
    //   7	1865	8	l4	long
    //   457	1423	10	l5	long
    //   15	1828	12	l6	long
    //   12	778	14	l7	long
    //   33	1716	16	localObject1	Object
    //   1754	16	16	localObject2	Object
    //   1772	1	16	localObject3	Object
    //   1777	11	16	localObject4	Object
    //   1793	1	16	localObject5	Object
    //   1807	1	16	localException1	java.lang.Exception
    //   1810	15	16	localObject6	Object
    //   37	1501	17	localObject7	Object
    //   1597	1	17	localException2	java.lang.Exception
    //   1757	24	17	localObject8	Object
    //   1785	7	17	localObject9	Object
    //   1797	1	17	localObject10	Object
    //   1802	1	17	localException3	java.lang.Exception
    //   1815	1	17	localException4	java.lang.Exception
    //   81	1715	18	localObject11	Object
    //   845	67	19	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   17	35	1594	java/lang/Exception
    //   752	774	1594	java/lang/Exception
    //   17	35	1754	finally
    //   752	774	1754	finally
    //   39	45	1772	finally
    //   49	55	1772	finally
    //   59	67	1772	finally
    //   71	83	1772	finally
    //   87	97	1772	finally
    //   103	117	1772	finally
    //   121	135	1772	finally
    //   139	153	1772	finally
    //   157	173	1772	finally
    //   177	192	1772	finally
    //   199	215	1772	finally
    //   219	232	1772	finally
    //   239	244	1772	finally
    //   778	784	1772	finally
    //   801	809	1772	finally
    //   813	825	1772	finally
    //   829	841	1772	finally
    //   851	861	1772	finally
    //   865	876	1772	finally
    //   880	890	1772	finally
    //   894	904	1772	finally
    //   911	921	1772	finally
    //   940	963	1772	finally
    //   967	985	1772	finally
    //   989	1012	1772	finally
    //   1016	1034	1772	finally
    //   1038	1061	1772	finally
    //   1065	1082	1772	finally
    //   1086	1109	1772	finally
    //   1113	1131	1772	finally
    //   1135	1140	1772	finally
    //   1144	1168	1772	finally
    //   1172	1195	1772	finally
    //   1199	1216	1772	finally
    //   1220	1225	1772	finally
    //   1229	1253	1772	finally
    //   1257	1280	1772	finally
    //   1284	1301	1772	finally
    //   1305	1310	1772	finally
    //   1314	1338	1772	finally
    //   1342	1365	1772	finally
    //   1369	1386	1772	finally
    //   1390	1395	1772	finally
    //   1399	1422	1772	finally
    //   1426	1448	1772	finally
    //   1452	1469	1772	finally
    //   1473	1491	1772	finally
    //   1495	1513	1772	finally
    //   1517	1535	1772	finally
    //   1539	1556	1772	finally
    //   244	285	1777	finally
    //   285	326	1777	finally
    //   326	367	1777	finally
    //   367	407	1777	finally
    //   407	459	1777	finally
    //   459	528	1777	finally
    //   528	597	1777	finally
    //   597	664	1777	finally
    //   664	752	1777	finally
    //   1599	1743	1785	finally
    //   39	45	1802	java/lang/Exception
    //   49	55	1802	java/lang/Exception
    //   59	67	1802	java/lang/Exception
    //   71	83	1802	java/lang/Exception
    //   87	97	1802	java/lang/Exception
    //   103	117	1802	java/lang/Exception
    //   121	135	1802	java/lang/Exception
    //   139	153	1802	java/lang/Exception
    //   157	173	1802	java/lang/Exception
    //   177	192	1802	java/lang/Exception
    //   199	215	1802	java/lang/Exception
    //   219	232	1802	java/lang/Exception
    //   239	244	1802	java/lang/Exception
    //   244	285	1807	java/lang/Exception
    //   285	326	1807	java/lang/Exception
    //   326	367	1807	java/lang/Exception
    //   367	407	1807	java/lang/Exception
    //   407	459	1807	java/lang/Exception
    //   459	528	1807	java/lang/Exception
    //   528	597	1807	java/lang/Exception
    //   597	664	1807	java/lang/Exception
    //   664	752	1807	java/lang/Exception
    //   778	784	1815	java/lang/Exception
    //   801	809	1815	java/lang/Exception
    //   813	825	1815	java/lang/Exception
    //   829	841	1815	java/lang/Exception
    //   851	861	1815	java/lang/Exception
    //   865	876	1815	java/lang/Exception
    //   880	890	1815	java/lang/Exception
    //   894	904	1815	java/lang/Exception
    //   911	921	1815	java/lang/Exception
    //   940	963	1815	java/lang/Exception
    //   967	985	1815	java/lang/Exception
    //   989	1012	1815	java/lang/Exception
    //   1016	1034	1815	java/lang/Exception
    //   1038	1061	1815	java/lang/Exception
    //   1065	1082	1815	java/lang/Exception
    //   1086	1109	1815	java/lang/Exception
    //   1113	1131	1815	java/lang/Exception
    //   1135	1140	1815	java/lang/Exception
    //   1144	1168	1815	java/lang/Exception
    //   1172	1195	1815	java/lang/Exception
    //   1199	1216	1815	java/lang/Exception
    //   1220	1225	1815	java/lang/Exception
    //   1229	1253	1815	java/lang/Exception
    //   1257	1280	1815	java/lang/Exception
    //   1284	1301	1815	java/lang/Exception
    //   1305	1310	1815	java/lang/Exception
    //   1314	1338	1815	java/lang/Exception
    //   1342	1365	1815	java/lang/Exception
    //   1369	1386	1815	java/lang/Exception
    //   1390	1395	1815	java/lang/Exception
    //   1399	1422	1815	java/lang/Exception
    //   1426	1448	1815	java/lang/Exception
    //   1452	1469	1815	java/lang/Exception
    //   1473	1491	1815	java/lang/Exception
    //   1495	1513	1815	java/lang/Exception
    //   1517	1535	1815	java/lang/Exception
    //   1539	1556	1815	java/lang/Exception
  }
  
  public static long zH(int paramInt)
  {
    if (pJE == null) {
      return 0L;
    }
    if (pJE.get(Integer.valueOf(paramInt)) == null) {
      return 0L;
    }
    if (((Long)pJE.get(Integer.valueOf(paramInt))).longValue() > 0L) {
      return ((Long)pJE.get(Integer.valueOf(paramInt))).longValue();
    }
    return 0L;
  }
  
  public static long zI(int paramInt)
  {
    if (pJF == null) {
      return 0L;
    }
    if (pJF.get(Integer.valueOf(paramInt)) == null) {
      return 0L;
    }
    if (((Long)pJF.get(Integer.valueOf(paramInt))).longValue() > 0L) {
      return ((Long)pJF.get(Integer.valueOf(paramInt))).longValue();
    }
    return 0L;
  }
  
  public static long zJ(int paramInt)
  {
    if (pJO == null) {
      return 0L;
    }
    if (pJO.get(Integer.valueOf(paramInt)) == null) {
      return 0L;
    }
    if (((Long)pJO.get(Integer.valueOf(paramInt))).longValue() > 0L) {
      return ((Long)pJO.get(Integer.valueOf(paramInt))).longValue();
    }
    return 0L;
  }
  
  public static long zK(int paramInt)
  {
    if (pJP == null) {
      return 0L;
    }
    if (pJP.get(Integer.valueOf(paramInt)) == null) {
      return 0L;
    }
    if (((Long)pJP.get(Integer.valueOf(paramInt))).longValue() > 0L) {
      return ((Long)pJP.get(Integer.valueOf(paramInt))).longValue();
    }
    return 0L;
  }
  
  public static long zL(int paramInt)
  {
    if (pJM == null) {
      return 0L;
    }
    if (pJM.get(Integer.valueOf(paramInt)) == null) {
      return 0L;
    }
    if (((Long)pJM.get(Integer.valueOf(paramInt))).longValue() > 0L) {
      return ((Long)pJM.get(Integer.valueOf(paramInt))).longValue();
    }
    return 0L;
  }
  
  public static long zM(int paramInt)
  {
    if (pJN == null) {
      return 0L;
    }
    if (pJN.get(Integer.valueOf(paramInt)) == null) {
      return 0L;
    }
    if (((Long)pJN.get(Integer.valueOf(paramInt))).longValue() > 0L) {
      return ((Long)pJN.get(Integer.valueOf(paramInt))).longValue();
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.a
 * JD-Core Version:    0.7.0.1
 */