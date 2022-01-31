package com.tencent.mm.sdk.platformtools;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class bn
{
  private static long psI;
  private static long psJ;
  private static long psK;
  private static long psL;
  private static final File toe;
  private static final File tof;
  private static long yqE;
  private static long yqF;
  private static long yqG;
  private static long yqH;
  private static long yqI;
  private static long yqJ;
  private static long yqK;
  private static long yqL;
  private static long yqM;
  private static long yqN;
  private static long yqO;
  private static long yqP;
  
  static
  {
    Object localObject2 = null;
    AppMethodBeat.i(52288);
    Object localObject1 = new File("/proc/" + Process.myPid() + "/net/dev");
    if (((File)localObject1).isFile()) {}
    for (;;)
    {
      toe = (File)localObject1;
      File localFile = new File("/proc/net/xt_qtaguid/stats");
      localObject1 = localObject2;
      if (localFile.isFile()) {
        localObject1 = localFile;
      }
      tof = (File)localObject1;
      AppMethodBeat.o(52288);
      return;
      localObject1 = null;
    }
  }
  
  public static long dtL()
  {
    long l = 0L;
    if (yqO > 0L) {
      l = yqO;
    }
    return l;
  }
  
  public static long dtM()
  {
    long l = 0L;
    if (yqP > 0L) {
      l = yqP;
    }
    return l;
  }
  
  public static long dtN()
  {
    long l = 0L;
    if (yqM > 0L) {
      l = yqM;
    }
    return l;
  }
  
  public static long dtO()
  {
    long l = 0L;
    if (yqN > 0L) {
      l = yqN;
    }
    return l;
  }
  
  public static long dtP()
  {
    long l = 0L;
    if (psL > 0L) {
      l = psL;
    }
    return l;
  }
  
  /* Error */
  private static void dtQ()
  {
    // Byte code:
    //   0: ldc 97
    //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: lconst_0
    //   6: lstore_3
    //   7: lconst_0
    //   8: lstore_1
    //   9: lconst_0
    //   10: lstore 7
    //   12: lconst_0
    //   13: lstore 13
    //   15: lconst_0
    //   16: lstore 11
    //   18: getstatic 69	com/tencent/mm/sdk/platformtools/bn:toe	Ljava/io/File;
    //   21: ifnull +646 -> 667
    //   24: new 99	java/util/Scanner
    //   27: dup
    //   28: getstatic 69	com/tencent/mm/sdk/platformtools/bn:toe	Ljava/io/File;
    //   31: invokespecial 102	java/util/Scanner:<init>	(Ljava/io/File;)V
    //   34: astore 16
    //   36: aload 16
    //   38: astore 15
    //   40: aload 16
    //   42: invokevirtual 105	java/util/Scanner:nextLine	()Ljava/lang/String;
    //   45: pop
    //   46: aload 16
    //   48: astore 15
    //   50: aload 16
    //   52: invokevirtual 105	java/util/Scanner:nextLine	()Ljava/lang/String;
    //   55: pop
    //   56: lconst_0
    //   57: lstore 5
    //   59: aload 16
    //   61: astore 15
    //   63: aload 16
    //   65: invokevirtual 108	java/util/Scanner:hasNext	()Z
    //   68: ifeq +165 -> 233
    //   71: aload 16
    //   73: astore 15
    //   75: aload 16
    //   77: invokevirtual 105	java/util/Scanner:nextLine	()Ljava/lang/String;
    //   80: ldc 110
    //   82: invokevirtual 116	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   85: astore 17
    //   87: aload 16
    //   89: astore 15
    //   91: aload 17
    //   93: iconst_0
    //   94: aaload
    //   95: invokevirtual 119	java/lang/String:length	()I
    //   98: ifne +1231 -> 1329
    //   101: iconst_1
    //   102: istore_0
    //   103: aload 16
    //   105: astore 15
    //   107: aload 17
    //   109: iload_0
    //   110: iconst_0
    //   111: iadd
    //   112: aaload
    //   113: ldc 121
    //   115: invokevirtual 125	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   118: ifne -59 -> 59
    //   121: aload 16
    //   123: astore 15
    //   125: aload 17
    //   127: iload_0
    //   128: iconst_0
    //   129: iadd
    //   130: aaload
    //   131: ldc 127
    //   133: invokevirtual 131	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   136: ifne +21 -> 157
    //   139: aload 16
    //   141: astore 15
    //   143: aload 17
    //   145: iload_0
    //   146: iconst_0
    //   147: iadd
    //   148: aaload
    //   149: ldc 133
    //   151: invokevirtual 131	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   154: ifeq +39 -> 193
    //   157: aload 16
    //   159: astore 15
    //   161: lload_3
    //   162: aload 17
    //   164: iload_0
    //   165: bipush 9
    //   167: iadd
    //   168: aaload
    //   169: invokestatic 139	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   172: ladd
    //   173: lstore_3
    //   174: aload 16
    //   176: astore 15
    //   178: lload_1
    //   179: aload 17
    //   181: iload_0
    //   182: iconst_1
    //   183: iadd
    //   184: aaload
    //   185: invokestatic 139	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   188: ladd
    //   189: lstore_1
    //   190: goto -131 -> 59
    //   193: aload 16
    //   195: astore 15
    //   197: lload 7
    //   199: aload 17
    //   201: iload_0
    //   202: bipush 9
    //   204: iadd
    //   205: aaload
    //   206: invokestatic 139	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   209: ladd
    //   210: lstore 7
    //   212: aload 16
    //   214: astore 15
    //   216: lload 5
    //   218: aload 17
    //   220: iload_0
    //   221: iconst_1
    //   222: iadd
    //   223: aaload
    //   224: invokestatic 139	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   227: ladd
    //   228: lstore 5
    //   230: goto -171 -> 59
    //   233: aload 16
    //   235: astore 15
    //   237: aload 16
    //   239: invokevirtual 142	java/util/Scanner:close	()V
    //   242: aconst_null
    //   243: astore 16
    //   245: aload 16
    //   247: astore 15
    //   249: getstatic 144	com/tencent/mm/sdk/platformtools/bn:yqE	J
    //   252: lconst_0
    //   253: lcmp
    //   254: ifge +33 -> 287
    //   257: aload 16
    //   259: astore 15
    //   261: lload_3
    //   262: putstatic 144	com/tencent/mm/sdk/platformtools/bn:yqE	J
    //   265: aload 16
    //   267: astore 15
    //   269: ldc 146
    //   271: ldc 148
    //   273: iconst_1
    //   274: anewarray 4	java/lang/Object
    //   277: dup
    //   278: iconst_0
    //   279: lload_3
    //   280: invokestatic 152	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   283: aastore
    //   284: invokestatic 158	com/tencent/mm/sdk/platformtools/ab:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   287: aload 16
    //   289: astore 15
    //   291: getstatic 160	com/tencent/mm/sdk/platformtools/bn:yqF	J
    //   294: lconst_0
    //   295: lcmp
    //   296: ifge +33 -> 329
    //   299: aload 16
    //   301: astore 15
    //   303: lload_1
    //   304: putstatic 160	com/tencent/mm/sdk/platformtools/bn:yqF	J
    //   307: aload 16
    //   309: astore 15
    //   311: ldc 146
    //   313: ldc 162
    //   315: iconst_1
    //   316: anewarray 4	java/lang/Object
    //   319: dup
    //   320: iconst_0
    //   321: lload_1
    //   322: invokestatic 152	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   325: aastore
    //   326: invokestatic 158	com/tencent/mm/sdk/platformtools/ab:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   329: aload 16
    //   331: astore 15
    //   333: getstatic 164	com/tencent/mm/sdk/platformtools/bn:yqG	J
    //   336: lconst_0
    //   337: lcmp
    //   338: ifge +35 -> 373
    //   341: aload 16
    //   343: astore 15
    //   345: lload 7
    //   347: putstatic 164	com/tencent/mm/sdk/platformtools/bn:yqG	J
    //   350: aload 16
    //   352: astore 15
    //   354: ldc 146
    //   356: ldc 166
    //   358: iconst_1
    //   359: anewarray 4	java/lang/Object
    //   362: dup
    //   363: iconst_0
    //   364: lload 7
    //   366: invokestatic 152	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   369: aastore
    //   370: invokestatic 158	com/tencent/mm/sdk/platformtools/ab:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   373: aload 16
    //   375: astore 15
    //   377: getstatic 168	com/tencent/mm/sdk/platformtools/bn:yqH	J
    //   380: lconst_0
    //   381: lcmp
    //   382: ifge +35 -> 417
    //   385: aload 16
    //   387: astore 15
    //   389: lload 5
    //   391: putstatic 168	com/tencent/mm/sdk/platformtools/bn:yqH	J
    //   394: aload 16
    //   396: astore 15
    //   398: ldc 146
    //   400: ldc 170
    //   402: iconst_1
    //   403: anewarray 4	java/lang/Object
    //   406: dup
    //   407: iconst_0
    //   408: lload 5
    //   410: invokestatic 152	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   413: aastore
    //   414: invokestatic 158	com/tencent/mm/sdk/platformtools/ab:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   417: aload 16
    //   419: astore 15
    //   421: lload 5
    //   423: getstatic 168	com/tencent/mm/sdk/platformtools/bn:yqH	J
    //   426: lsub
    //   427: lconst_0
    //   428: lcmp
    //   429: ifge +30 -> 459
    //   432: aload 16
    //   434: astore 15
    //   436: ldc 146
    //   438: ldc 172
    //   440: iconst_1
    //   441: anewarray 4	java/lang/Object
    //   444: dup
    //   445: iconst_0
    //   446: lload 5
    //   448: getstatic 168	com/tencent/mm/sdk/platformtools/bn:yqH	J
    //   451: lsub
    //   452: invokestatic 152	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   455: aastore
    //   456: invokestatic 158	com/tencent/mm/sdk/platformtools/ab:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   459: aload 16
    //   461: astore 15
    //   463: lload 7
    //   465: getstatic 164	com/tencent/mm/sdk/platformtools/bn:yqG	J
    //   468: lsub
    //   469: lconst_0
    //   470: lcmp
    //   471: ifge +30 -> 501
    //   474: aload 16
    //   476: astore 15
    //   478: ldc 146
    //   480: ldc 172
    //   482: iconst_1
    //   483: anewarray 4	java/lang/Object
    //   486: dup
    //   487: iconst_0
    //   488: lload 7
    //   490: getstatic 164	com/tencent/mm/sdk/platformtools/bn:yqG	J
    //   493: lsub
    //   494: invokestatic 152	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   497: aastore
    //   498: invokestatic 158	com/tencent/mm/sdk/platformtools/ab:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   501: aload 16
    //   503: astore 15
    //   505: lload_3
    //   506: getstatic 144	com/tencent/mm/sdk/platformtools/bn:yqE	J
    //   509: lcmp
    //   510: iflt +837 -> 1347
    //   513: aload 16
    //   515: astore 15
    //   517: lload_3
    //   518: getstatic 144	com/tencent/mm/sdk/platformtools/bn:yqE	J
    //   521: lsub
    //   522: lstore 9
    //   524: aload 16
    //   526: astore 15
    //   528: lload 9
    //   530: putstatic 87	com/tencent/mm/sdk/platformtools/bn:yqM	J
    //   533: aload 16
    //   535: astore 15
    //   537: lload_1
    //   538: getstatic 160	com/tencent/mm/sdk/platformtools/bn:yqF	J
    //   541: lcmp
    //   542: iflt +811 -> 1353
    //   545: aload 16
    //   547: astore 15
    //   549: lload_1
    //   550: getstatic 160	com/tencent/mm/sdk/platformtools/bn:yqF	J
    //   553: lsub
    //   554: lstore 9
    //   556: aload 16
    //   558: astore 15
    //   560: lload 9
    //   562: putstatic 90	com/tencent/mm/sdk/platformtools/bn:yqN	J
    //   565: aload 16
    //   567: astore 15
    //   569: lload 7
    //   571: getstatic 164	com/tencent/mm/sdk/platformtools/bn:yqG	J
    //   574: lcmp
    //   575: iflt +784 -> 1359
    //   578: aload 16
    //   580: astore 15
    //   582: lload 7
    //   584: getstatic 164	com/tencent/mm/sdk/platformtools/bn:yqG	J
    //   587: lsub
    //   588: lstore 9
    //   590: aload 16
    //   592: astore 15
    //   594: lload 9
    //   596: putstatic 81	com/tencent/mm/sdk/platformtools/bn:yqO	J
    //   599: aload 16
    //   601: astore 15
    //   603: lload 5
    //   605: getstatic 168	com/tencent/mm/sdk/platformtools/bn:yqH	J
    //   608: lcmp
    //   609: iflt +757 -> 1366
    //   612: aload 16
    //   614: astore 15
    //   616: lload 5
    //   618: getstatic 168	com/tencent/mm/sdk/platformtools/bn:yqH	J
    //   621: lsub
    //   622: lstore 9
    //   624: aload 16
    //   626: astore 15
    //   628: lload 9
    //   630: putstatic 84	com/tencent/mm/sdk/platformtools/bn:yqP	J
    //   633: aload 16
    //   635: astore 15
    //   637: lload_3
    //   638: putstatic 144	com/tencent/mm/sdk/platformtools/bn:yqE	J
    //   641: aload 16
    //   643: astore 15
    //   645: lload_1
    //   646: putstatic 160	com/tencent/mm/sdk/platformtools/bn:yqF	J
    //   649: aload 16
    //   651: astore 15
    //   653: lload 7
    //   655: putstatic 164	com/tencent/mm/sdk/platformtools/bn:yqG	J
    //   658: aload 16
    //   660: astore 15
    //   662: lload 5
    //   664: putstatic 168	com/tencent/mm/sdk/platformtools/bn:yqH	J
    //   667: getstatic 73	com/tencent/mm/sdk/platformtools/bn:tof	Ljava/io/File;
    //   670: ifnull +653 -> 1323
    //   673: invokestatic 175	android/os/Process:myUid	()I
    //   676: istore_0
    //   677: new 99	java/util/Scanner
    //   680: dup
    //   681: getstatic 73	com/tencent/mm/sdk/platformtools/bn:tof	Ljava/io/File;
    //   684: invokespecial 102	java/util/Scanner:<init>	(Ljava/io/File;)V
    //   687: astore 16
    //   689: aload 16
    //   691: astore 15
    //   693: aload 16
    //   695: invokevirtual 105	java/util/Scanner:nextLine	()Ljava/lang/String;
    //   698: pop
    //   699: lconst_0
    //   700: lstore 7
    //   702: lconst_0
    //   703: lstore 5
    //   705: lload 13
    //   707: lstore_1
    //   708: lload 11
    //   710: lstore_3
    //   711: aload 16
    //   713: astore 15
    //   715: aload 16
    //   717: invokevirtual 108	java/util/Scanner:hasNext	()Z
    //   720: ifeq +129 -> 849
    //   723: aload 16
    //   725: astore 15
    //   727: aload 16
    //   729: invokevirtual 105	java/util/Scanner:nextLine	()Ljava/lang/String;
    //   732: ldc 177
    //   734: invokevirtual 116	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   737: astore 17
    //   739: aload 16
    //   741: astore 15
    //   743: aload 17
    //   745: iconst_3
    //   746: aaload
    //   747: invokestatic 183	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   750: iload_0
    //   751: if_icmpne -40 -> 711
    //   754: aload 17
    //   756: iconst_1
    //   757: aaload
    //   758: astore 18
    //   760: aload 16
    //   762: astore 15
    //   764: aload 17
    //   766: iconst_5
    //   767: aaload
    //   768: invokestatic 139	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   771: lstore 11
    //   773: aload 16
    //   775: astore 15
    //   777: aload 17
    //   779: bipush 7
    //   781: aaload
    //   782: invokestatic 139	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   785: lstore 9
    //   787: aload 16
    //   789: astore 15
    //   791: aload 18
    //   793: ldc 127
    //   795: invokevirtual 131	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   798: ifne +536 -> 1334
    //   801: aload 16
    //   803: astore 15
    //   805: aload 18
    //   807: ldc 133
    //   809: invokevirtual 131	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   812: ifeq +6 -> 818
    //   815: goto +519 -> 1334
    //   818: aload 16
    //   820: astore 15
    //   822: aload 18
    //   824: ldc 121
    //   826: invokevirtual 125	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   829: ifne -118 -> 711
    //   832: lload 7
    //   834: lload 11
    //   836: ladd
    //   837: lstore 7
    //   839: lload 5
    //   841: lload 9
    //   843: ladd
    //   844: lstore 5
    //   846: goto -135 -> 711
    //   849: aload 16
    //   851: astore 15
    //   853: getstatic 185	com/tencent/mm/sdk/platformtools/bn:yqJ	J
    //   856: lconst_0
    //   857: lcmp
    //   858: ifge +11 -> 869
    //   861: aload 16
    //   863: astore 15
    //   865: lload_3
    //   866: putstatic 185	com/tencent/mm/sdk/platformtools/bn:yqJ	J
    //   869: aload 16
    //   871: astore 15
    //   873: getstatic 187	com/tencent/mm/sdk/platformtools/bn:yqI	J
    //   876: lconst_0
    //   877: lcmp
    //   878: ifge +11 -> 889
    //   881: aload 16
    //   883: astore 15
    //   885: lload_1
    //   886: putstatic 187	com/tencent/mm/sdk/platformtools/bn:yqI	J
    //   889: aload 16
    //   891: astore 15
    //   893: getstatic 189	com/tencent/mm/sdk/platformtools/bn:yqL	J
    //   896: lconst_0
    //   897: lcmp
    //   898: ifge +12 -> 910
    //   901: aload 16
    //   903: astore 15
    //   905: lload 7
    //   907: putstatic 189	com/tencent/mm/sdk/platformtools/bn:yqL	J
    //   910: aload 16
    //   912: astore 15
    //   914: getstatic 191	com/tencent/mm/sdk/platformtools/bn:yqK	J
    //   917: lconst_0
    //   918: lcmp
    //   919: ifge +12 -> 931
    //   922: aload 16
    //   924: astore 15
    //   926: lload 5
    //   928: putstatic 191	com/tencent/mm/sdk/platformtools/bn:yqK	J
    //   931: aload 16
    //   933: astore 15
    //   935: lload_1
    //   936: getstatic 187	com/tencent/mm/sdk/platformtools/bn:yqI	J
    //   939: lcmp
    //   940: iflt +259 -> 1199
    //   943: aload 16
    //   945: astore 15
    //   947: lload_1
    //   948: getstatic 187	com/tencent/mm/sdk/platformtools/bn:yqI	J
    //   951: lsub
    //   952: lstore 9
    //   954: aload 16
    //   956: astore 15
    //   958: lload 9
    //   960: putstatic 193	com/tencent/mm/sdk/platformtools/bn:psI	J
    //   963: aload 16
    //   965: astore 15
    //   967: lload_3
    //   968: getstatic 185	com/tencent/mm/sdk/platformtools/bn:yqJ	J
    //   971: lcmp
    //   972: iflt +233 -> 1205
    //   975: aload 16
    //   977: astore 15
    //   979: lload_3
    //   980: getstatic 185	com/tencent/mm/sdk/platformtools/bn:yqJ	J
    //   983: lsub
    //   984: lstore 9
    //   986: aload 16
    //   988: astore 15
    //   990: lload 9
    //   992: putstatic 195	com/tencent/mm/sdk/platformtools/bn:psJ	J
    //   995: aload 16
    //   997: astore 15
    //   999: lload 5
    //   1001: getstatic 191	com/tencent/mm/sdk/platformtools/bn:yqK	J
    //   1004: lcmp
    //   1005: iflt +206 -> 1211
    //   1008: aload 16
    //   1010: astore 15
    //   1012: lload 5
    //   1014: getstatic 191	com/tencent/mm/sdk/platformtools/bn:yqK	J
    //   1017: lsub
    //   1018: lstore 9
    //   1020: aload 16
    //   1022: astore 15
    //   1024: lload 9
    //   1026: putstatic 197	com/tencent/mm/sdk/platformtools/bn:psK	J
    //   1029: aload 16
    //   1031: astore 15
    //   1033: lload 7
    //   1035: getstatic 189	com/tencent/mm/sdk/platformtools/bn:yqL	J
    //   1038: lcmp
    //   1039: iflt +179 -> 1218
    //   1042: aload 16
    //   1044: astore 15
    //   1046: lload 7
    //   1048: getstatic 189	com/tencent/mm/sdk/platformtools/bn:yqL	J
    //   1051: lsub
    //   1052: lstore 9
    //   1054: aload 16
    //   1056: astore 15
    //   1058: lload 9
    //   1060: putstatic 93	com/tencent/mm/sdk/platformtools/bn:psL	J
    //   1063: aload 16
    //   1065: astore 15
    //   1067: lload_1
    //   1068: putstatic 187	com/tencent/mm/sdk/platformtools/bn:yqI	J
    //   1071: aload 16
    //   1073: astore 15
    //   1075: lload_3
    //   1076: putstatic 185	com/tencent/mm/sdk/platformtools/bn:yqJ	J
    //   1079: aload 16
    //   1081: astore 15
    //   1083: lload 5
    //   1085: putstatic 191	com/tencent/mm/sdk/platformtools/bn:yqK	J
    //   1088: aload 16
    //   1090: astore 15
    //   1092: lload 7
    //   1094: putstatic 189	com/tencent/mm/sdk/platformtools/bn:yqL	J
    //   1097: aload 16
    //   1099: ifnull +8 -> 1107
    //   1102: aload 16
    //   1104: invokevirtual 142	java/util/Scanner:close	()V
    //   1107: ldc 146
    //   1109: ldc 199
    //   1111: bipush 8
    //   1113: anewarray 4	java/lang/Object
    //   1116: dup
    //   1117: iconst_0
    //   1118: getstatic 84	com/tencent/mm/sdk/platformtools/bn:yqP	J
    //   1121: invokestatic 152	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1124: aastore
    //   1125: dup
    //   1126: iconst_1
    //   1127: getstatic 81	com/tencent/mm/sdk/platformtools/bn:yqO	J
    //   1130: invokestatic 152	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1133: aastore
    //   1134: dup
    //   1135: iconst_2
    //   1136: getstatic 90	com/tencent/mm/sdk/platformtools/bn:yqN	J
    //   1139: invokestatic 152	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1142: aastore
    //   1143: dup
    //   1144: iconst_3
    //   1145: getstatic 87	com/tencent/mm/sdk/platformtools/bn:yqM	J
    //   1148: invokestatic 152	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1151: aastore
    //   1152: dup
    //   1153: iconst_4
    //   1154: getstatic 93	com/tencent/mm/sdk/platformtools/bn:psL	J
    //   1157: invokestatic 152	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1160: aastore
    //   1161: dup
    //   1162: iconst_5
    //   1163: getstatic 197	com/tencent/mm/sdk/platformtools/bn:psK	J
    //   1166: invokestatic 152	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1169: aastore
    //   1170: dup
    //   1171: bipush 6
    //   1173: getstatic 195	com/tencent/mm/sdk/platformtools/bn:psJ	J
    //   1176: invokestatic 152	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1179: aastore
    //   1180: dup
    //   1181: bipush 7
    //   1183: getstatic 193	com/tencent/mm/sdk/platformtools/bn:psI	J
    //   1186: invokestatic 152	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1189: aastore
    //   1190: invokestatic 201	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1193: ldc 97
    //   1195: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1198: return
    //   1199: lload_1
    //   1200: lstore 9
    //   1202: goto -248 -> 954
    //   1205: lload_3
    //   1206: lstore 9
    //   1208: goto -222 -> 986
    //   1211: lload 5
    //   1213: lstore 9
    //   1215: goto -195 -> 1020
    //   1218: lload 7
    //   1220: lstore 9
    //   1222: goto -168 -> 1054
    //   1225: aconst_null
    //   1226: astore 15
    //   1228: astore 16
    //   1230: ldc 146
    //   1232: aload 16
    //   1234: ldc 203
    //   1236: iconst_0
    //   1237: anewarray 4	java/lang/Object
    //   1240: invokestatic 207	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1243: aload 15
    //   1245: ifnull -138 -> 1107
    //   1248: aload 15
    //   1250: invokevirtual 142	java/util/Scanner:close	()V
    //   1253: goto -146 -> 1107
    //   1256: astore 16
    //   1258: aconst_null
    //   1259: astore 15
    //   1261: aload 15
    //   1263: ifnull +8 -> 1271
    //   1266: aload 15
    //   1268: invokevirtual 142	java/util/Scanner:close	()V
    //   1271: ldc 97
    //   1273: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1276: aload 16
    //   1278: athrow
    //   1279: astore 16
    //   1281: goto -20 -> 1261
    //   1284: astore 16
    //   1286: goto -25 -> 1261
    //   1289: astore 17
    //   1291: aload 16
    //   1293: astore 15
    //   1295: aload 17
    //   1297: astore 16
    //   1299: goto -69 -> 1230
    //   1302: astore 16
    //   1304: aconst_null
    //   1305: astore 15
    //   1307: goto -77 -> 1230
    //   1310: astore 17
    //   1312: aload 16
    //   1314: astore 15
    //   1316: aload 17
    //   1318: astore 16
    //   1320: goto -90 -> 1230
    //   1323: aconst_null
    //   1324: astore 16
    //   1326: goto -229 -> 1097
    //   1329: iconst_0
    //   1330: istore_0
    //   1331: goto -1228 -> 103
    //   1334: lload_3
    //   1335: lload 11
    //   1337: ladd
    //   1338: lstore_3
    //   1339: lload_1
    //   1340: lload 9
    //   1342: ladd
    //   1343: lstore_1
    //   1344: goto -633 -> 711
    //   1347: lload_3
    //   1348: lstore 9
    //   1350: goto -826 -> 524
    //   1353: lload_1
    //   1354: lstore 9
    //   1356: goto -800 -> 556
    //   1359: lload 7
    //   1361: lstore 9
    //   1363: goto -773 -> 590
    //   1366: lload 5
    //   1368: lstore 9
    //   1370: goto -746 -> 624
    // Local variable table:
    //   start	length	slot	name	signature
    //   102	1229	0	i	int
    //   8	1346	1	l1	long
    //   6	1342	3	l2	long
    //   57	1310	5	l3	long
    //   10	1350	7	l4	long
    //   522	847	9	l5	long
    //   16	1320	11	l6	long
    //   13	693	13	l7	long
    //   38	1277	15	localObject1	Object
    //   34	1069	16	localScanner	java.util.Scanner
    //   1228	5	16	localException1	java.lang.Exception
    //   1256	21	16	localObject2	Object
    //   1279	1	16	localObject3	Object
    //   1284	8	16	localObject4	Object
    //   1297	1	16	localObject5	Object
    //   1302	11	16	localException2	java.lang.Exception
    //   1318	7	16	localObject6	Object
    //   85	693	17	arrayOfString	java.lang.String[]
    //   1289	7	17	localException3	java.lang.Exception
    //   1310	7	17	localException4	java.lang.Exception
    //   758	65	18	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   18	36	1225	java/lang/Exception
    //   667	689	1225	java/lang/Exception
    //   18	36	1256	finally
    //   667	689	1256	finally
    //   40	46	1279	finally
    //   50	56	1279	finally
    //   63	71	1279	finally
    //   75	87	1279	finally
    //   91	101	1279	finally
    //   107	121	1279	finally
    //   125	139	1279	finally
    //   143	157	1279	finally
    //   161	174	1279	finally
    //   178	190	1279	finally
    //   197	212	1279	finally
    //   216	230	1279	finally
    //   237	242	1279	finally
    //   249	257	1279	finally
    //   261	265	1279	finally
    //   269	287	1279	finally
    //   291	299	1279	finally
    //   303	307	1279	finally
    //   311	329	1279	finally
    //   333	341	1279	finally
    //   345	350	1279	finally
    //   354	373	1279	finally
    //   377	385	1279	finally
    //   389	394	1279	finally
    //   398	417	1279	finally
    //   421	432	1279	finally
    //   436	459	1279	finally
    //   463	474	1279	finally
    //   478	501	1279	finally
    //   505	513	1279	finally
    //   517	524	1279	finally
    //   528	533	1279	finally
    //   537	545	1279	finally
    //   549	556	1279	finally
    //   560	565	1279	finally
    //   569	578	1279	finally
    //   582	590	1279	finally
    //   594	599	1279	finally
    //   603	612	1279	finally
    //   616	624	1279	finally
    //   628	633	1279	finally
    //   637	641	1279	finally
    //   645	649	1279	finally
    //   653	658	1279	finally
    //   662	667	1279	finally
    //   693	699	1279	finally
    //   715	723	1279	finally
    //   727	739	1279	finally
    //   743	754	1279	finally
    //   764	773	1279	finally
    //   777	787	1279	finally
    //   791	801	1279	finally
    //   805	815	1279	finally
    //   822	832	1279	finally
    //   853	861	1279	finally
    //   865	869	1279	finally
    //   873	881	1279	finally
    //   885	889	1279	finally
    //   893	901	1279	finally
    //   905	910	1279	finally
    //   914	922	1279	finally
    //   926	931	1279	finally
    //   935	943	1279	finally
    //   947	954	1279	finally
    //   958	963	1279	finally
    //   967	975	1279	finally
    //   979	986	1279	finally
    //   990	995	1279	finally
    //   999	1008	1279	finally
    //   1012	1020	1279	finally
    //   1024	1029	1279	finally
    //   1033	1042	1279	finally
    //   1046	1054	1279	finally
    //   1058	1063	1279	finally
    //   1067	1071	1279	finally
    //   1075	1079	1279	finally
    //   1083	1088	1279	finally
    //   1092	1097	1279	finally
    //   1230	1243	1284	finally
    //   40	46	1289	java/lang/Exception
    //   50	56	1289	java/lang/Exception
    //   63	71	1289	java/lang/Exception
    //   75	87	1289	java/lang/Exception
    //   91	101	1289	java/lang/Exception
    //   107	121	1289	java/lang/Exception
    //   125	139	1289	java/lang/Exception
    //   143	157	1289	java/lang/Exception
    //   161	174	1289	java/lang/Exception
    //   178	190	1289	java/lang/Exception
    //   197	212	1289	java/lang/Exception
    //   216	230	1289	java/lang/Exception
    //   237	242	1289	java/lang/Exception
    //   249	257	1302	java/lang/Exception
    //   261	265	1302	java/lang/Exception
    //   269	287	1302	java/lang/Exception
    //   291	299	1302	java/lang/Exception
    //   303	307	1302	java/lang/Exception
    //   311	329	1302	java/lang/Exception
    //   333	341	1302	java/lang/Exception
    //   345	350	1302	java/lang/Exception
    //   354	373	1302	java/lang/Exception
    //   377	385	1302	java/lang/Exception
    //   389	394	1302	java/lang/Exception
    //   398	417	1302	java/lang/Exception
    //   421	432	1302	java/lang/Exception
    //   436	459	1302	java/lang/Exception
    //   463	474	1302	java/lang/Exception
    //   478	501	1302	java/lang/Exception
    //   505	513	1302	java/lang/Exception
    //   517	524	1302	java/lang/Exception
    //   528	533	1302	java/lang/Exception
    //   537	545	1302	java/lang/Exception
    //   549	556	1302	java/lang/Exception
    //   560	565	1302	java/lang/Exception
    //   569	578	1302	java/lang/Exception
    //   582	590	1302	java/lang/Exception
    //   594	599	1302	java/lang/Exception
    //   603	612	1302	java/lang/Exception
    //   616	624	1302	java/lang/Exception
    //   628	633	1302	java/lang/Exception
    //   637	641	1302	java/lang/Exception
    //   645	649	1302	java/lang/Exception
    //   653	658	1302	java/lang/Exception
    //   662	667	1302	java/lang/Exception
    //   693	699	1310	java/lang/Exception
    //   715	723	1310	java/lang/Exception
    //   727	739	1310	java/lang/Exception
    //   743	754	1310	java/lang/Exception
    //   764	773	1310	java/lang/Exception
    //   777	787	1310	java/lang/Exception
    //   791	801	1310	java/lang/Exception
    //   805	815	1310	java/lang/Exception
    //   822	832	1310	java/lang/Exception
    //   853	861	1310	java/lang/Exception
    //   865	869	1310	java/lang/Exception
    //   873	881	1310	java/lang/Exception
    //   885	889	1310	java/lang/Exception
    //   893	901	1310	java/lang/Exception
    //   905	910	1310	java/lang/Exception
    //   914	922	1310	java/lang/Exception
    //   926	931	1310	java/lang/Exception
    //   935	943	1310	java/lang/Exception
    //   947	954	1310	java/lang/Exception
    //   958	963	1310	java/lang/Exception
    //   967	975	1310	java/lang/Exception
    //   979	986	1310	java/lang/Exception
    //   990	995	1310	java/lang/Exception
    //   999	1008	1310	java/lang/Exception
    //   1012	1020	1310	java/lang/Exception
    //   1024	1029	1310	java/lang/Exception
    //   1033	1042	1310	java/lang/Exception
    //   1046	1054	1310	java/lang/Exception
    //   1058	1063	1310	java/lang/Exception
    //   1067	1071	1310	java/lang/Exception
    //   1075	1079	1310	java/lang/Exception
    //   1083	1088	1310	java/lang/Exception
    //   1092	1097	1310	java/lang/Exception
  }
  
  public static long nQ(long paramLong)
  {
    long l = paramLong;
    if (psK > paramLong) {
      l = psK;
    }
    return l;
  }
  
  public static long nR(long paramLong)
  {
    long l = paramLong;
    if (psI > paramLong) {
      l = psI;
    }
    return l;
  }
  
  public static long nS(long paramLong)
  {
    long l = paramLong;
    if (psJ > paramLong) {
      l = psJ;
    }
    return l;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(156533);
    yqE = -1L;
    yqF = -1L;
    yqG = -1L;
    yqH = -1L;
    yqJ = -1L;
    yqI = -1L;
    yqL = -1L;
    yqK = -1L;
    dtQ();
    AppMethodBeat.o(156533);
  }
  
  public static void update()
  {
    AppMethodBeat.i(156811);
    dtQ();
    AppMethodBeat.o(156811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bn
 * JD-Core Version:    0.7.0.1
 */