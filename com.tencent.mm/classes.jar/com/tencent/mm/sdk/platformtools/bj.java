package com.tencent.mm.sdk.platformtools;

import android.os.Process;
import java.io.File;

public final class bj
{
  private static final File pJQ;
  private static final File pJR;
  private static long uiB;
  private static long uiC;
  private static long uiD;
  private static long uiE;
  private static long uiF;
  private static long uiG;
  private static long uiH;
  private static long uiI;
  private static long uiJ;
  private static long uiK;
  private static long uiL;
  private static long uiM;
  private static long uiN;
  private static long uiO;
  private static long uiP;
  private static long uiQ;
  
  static
  {
    Object localObject2 = null;
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
  
  public static long crL()
  {
    long l = 0L;
    if (uiL > 0L) {
      l = uiL;
    }
    return l;
  }
  
  public static long crM()
  {
    long l = 0L;
    if (uiM > 0L) {
      l = uiM;
    }
    return l;
  }
  
  public static long crN()
  {
    long l = 0L;
    if (uiJ > 0L) {
      l = uiJ;
    }
    return l;
  }
  
  public static long crO()
  {
    long l = 0L;
    if (uiK > 0L) {
      l = uiK;
    }
    return l;
  }
  
  public static long crP()
  {
    long l = 0L;
    if (uiP > 0L) {
      l = uiP;
    }
    return l;
  }
  
  public static long crQ()
  {
    long l = 0L;
    if (uiQ > 0L) {
      l = uiQ;
    }
    return l;
  }
  
  public static long crR()
  {
    long l = 0L;
    if (uiN > 0L) {
      l = uiN;
    }
    return l;
  }
  
  public static long crS()
  {
    long l = 0L;
    if (uiO > 0L) {
      l = uiO;
    }
    return l;
  }
  
  public static void reset()
  {
    uiB = -1L;
    uiC = -1L;
    uiD = -1L;
    uiE = -1L;
    uiG = -1L;
    uiF = -1L;
    uiI = -1L;
    uiH = -1L;
    update();
  }
  
  /* Error */
  public static void update()
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_3
    //   2: lconst_0
    //   3: lstore_1
    //   4: lconst_0
    //   5: lstore 7
    //   7: lconst_0
    //   8: lstore 13
    //   10: lconst_0
    //   11: lstore 11
    //   13: getstatic 62	com/tencent/mm/sdk/platformtools/bj:pJQ	Ljava/io/File;
    //   16: ifnull +646 -> 662
    //   19: new 118	java/util/Scanner
    //   22: dup
    //   23: getstatic 62	com/tencent/mm/sdk/platformtools/bj:pJQ	Ljava/io/File;
    //   26: invokespecial 121	java/util/Scanner:<init>	(Ljava/io/File;)V
    //   29: astore 16
    //   31: aload 16
    //   33: astore 15
    //   35: aload 16
    //   37: invokevirtual 124	java/util/Scanner:nextLine	()Ljava/lang/String;
    //   40: pop
    //   41: aload 16
    //   43: astore 15
    //   45: aload 16
    //   47: invokevirtual 124	java/util/Scanner:nextLine	()Ljava/lang/String;
    //   50: pop
    //   51: lconst_0
    //   52: lstore 5
    //   54: aload 16
    //   56: astore 15
    //   58: aload 16
    //   60: invokevirtual 127	java/util/Scanner:hasNext	()Z
    //   63: ifeq +165 -> 228
    //   66: aload 16
    //   68: astore 15
    //   70: aload 16
    //   72: invokevirtual 124	java/util/Scanner:nextLine	()Ljava/lang/String;
    //   75: ldc 129
    //   77: invokevirtual 135	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   80: astore 17
    //   82: aload 16
    //   84: astore 15
    //   86: aload 17
    //   88: iconst_0
    //   89: aaload
    //   90: invokevirtual 138	java/lang/String:length	()I
    //   93: ifne +1221 -> 1314
    //   96: iconst_1
    //   97: istore_0
    //   98: aload 16
    //   100: astore 15
    //   102: aload 17
    //   104: iload_0
    //   105: iconst_0
    //   106: iadd
    //   107: aaload
    //   108: ldc 140
    //   110: invokevirtual 144	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   113: ifne -59 -> 54
    //   116: aload 16
    //   118: astore 15
    //   120: aload 17
    //   122: iload_0
    //   123: iconst_0
    //   124: iadd
    //   125: aaload
    //   126: ldc 146
    //   128: invokevirtual 150	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   131: ifne +21 -> 152
    //   134: aload 16
    //   136: astore 15
    //   138: aload 17
    //   140: iload_0
    //   141: iconst_0
    //   142: iadd
    //   143: aaload
    //   144: ldc 152
    //   146: invokevirtual 150	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   149: ifeq +39 -> 188
    //   152: aload 16
    //   154: astore 15
    //   156: lload_3
    //   157: aload 17
    //   159: iload_0
    //   160: bipush 9
    //   162: iadd
    //   163: aaload
    //   164: invokestatic 158	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   167: ladd
    //   168: lstore_3
    //   169: aload 16
    //   171: astore 15
    //   173: lload_1
    //   174: aload 17
    //   176: iload_0
    //   177: iconst_1
    //   178: iadd
    //   179: aaload
    //   180: invokestatic 158	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   183: ladd
    //   184: lstore_1
    //   185: goto -131 -> 54
    //   188: aload 16
    //   190: astore 15
    //   192: lload 7
    //   194: aload 17
    //   196: iload_0
    //   197: bipush 9
    //   199: iadd
    //   200: aaload
    //   201: invokestatic 158	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   204: ladd
    //   205: lstore 7
    //   207: aload 16
    //   209: astore 15
    //   211: lload 5
    //   213: aload 17
    //   215: iload_0
    //   216: iconst_1
    //   217: iadd
    //   218: aaload
    //   219: invokestatic 158	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   222: ladd
    //   223: lstore 5
    //   225: goto -171 -> 54
    //   228: aload 16
    //   230: astore 15
    //   232: aload 16
    //   234: invokevirtual 161	java/util/Scanner:close	()V
    //   237: aconst_null
    //   238: astore 16
    //   240: aload 16
    //   242: astore 15
    //   244: getstatic 97	com/tencent/mm/sdk/platformtools/bj:uiB	J
    //   247: lconst_0
    //   248: lcmp
    //   249: ifge +33 -> 282
    //   252: aload 16
    //   254: astore 15
    //   256: lload_3
    //   257: putstatic 97	com/tencent/mm/sdk/platformtools/bj:uiB	J
    //   260: aload 16
    //   262: astore 15
    //   264: ldc 163
    //   266: ldc 165
    //   268: iconst_1
    //   269: anewarray 4	java/lang/Object
    //   272: dup
    //   273: iconst_0
    //   274: lload_3
    //   275: invokestatic 169	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   278: aastore
    //   279: invokestatic 175	com/tencent/mm/sdk/platformtools/y:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   282: aload 16
    //   284: astore 15
    //   286: getstatic 99	com/tencent/mm/sdk/platformtools/bj:uiC	J
    //   289: lconst_0
    //   290: lcmp
    //   291: ifge +33 -> 324
    //   294: aload 16
    //   296: astore 15
    //   298: lload_1
    //   299: putstatic 99	com/tencent/mm/sdk/platformtools/bj:uiC	J
    //   302: aload 16
    //   304: astore 15
    //   306: ldc 163
    //   308: ldc 177
    //   310: iconst_1
    //   311: anewarray 4	java/lang/Object
    //   314: dup
    //   315: iconst_0
    //   316: lload_1
    //   317: invokestatic 169	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   320: aastore
    //   321: invokestatic 175	com/tencent/mm/sdk/platformtools/y:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   324: aload 16
    //   326: astore 15
    //   328: getstatic 101	com/tencent/mm/sdk/platformtools/bj:uiD	J
    //   331: lconst_0
    //   332: lcmp
    //   333: ifge +35 -> 368
    //   336: aload 16
    //   338: astore 15
    //   340: lload 7
    //   342: putstatic 101	com/tencent/mm/sdk/platformtools/bj:uiD	J
    //   345: aload 16
    //   347: astore 15
    //   349: ldc 163
    //   351: ldc 179
    //   353: iconst_1
    //   354: anewarray 4	java/lang/Object
    //   357: dup
    //   358: iconst_0
    //   359: lload 7
    //   361: invokestatic 169	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   364: aastore
    //   365: invokestatic 175	com/tencent/mm/sdk/platformtools/y:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   368: aload 16
    //   370: astore 15
    //   372: getstatic 103	com/tencent/mm/sdk/platformtools/bj:uiE	J
    //   375: lconst_0
    //   376: lcmp
    //   377: ifge +35 -> 412
    //   380: aload 16
    //   382: astore 15
    //   384: lload 5
    //   386: putstatic 103	com/tencent/mm/sdk/platformtools/bj:uiE	J
    //   389: aload 16
    //   391: astore 15
    //   393: ldc 163
    //   395: ldc 181
    //   397: iconst_1
    //   398: anewarray 4	java/lang/Object
    //   401: dup
    //   402: iconst_0
    //   403: lload 5
    //   405: invokestatic 169	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   408: aastore
    //   409: invokestatic 175	com/tencent/mm/sdk/platformtools/y:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   412: aload 16
    //   414: astore 15
    //   416: lload 5
    //   418: getstatic 103	com/tencent/mm/sdk/platformtools/bj:uiE	J
    //   421: lsub
    //   422: lconst_0
    //   423: lcmp
    //   424: ifge +30 -> 454
    //   427: aload 16
    //   429: astore 15
    //   431: ldc 163
    //   433: ldc 183
    //   435: iconst_1
    //   436: anewarray 4	java/lang/Object
    //   439: dup
    //   440: iconst_0
    //   441: lload 5
    //   443: getstatic 103	com/tencent/mm/sdk/platformtools/bj:uiE	J
    //   446: lsub
    //   447: invokestatic 169	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   450: aastore
    //   451: invokestatic 175	com/tencent/mm/sdk/platformtools/y:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   454: aload 16
    //   456: astore 15
    //   458: lload 7
    //   460: getstatic 101	com/tencent/mm/sdk/platformtools/bj:uiD	J
    //   463: lsub
    //   464: lconst_0
    //   465: lcmp
    //   466: ifge +30 -> 496
    //   469: aload 16
    //   471: astore 15
    //   473: ldc 163
    //   475: ldc 183
    //   477: iconst_1
    //   478: anewarray 4	java/lang/Object
    //   481: dup
    //   482: iconst_0
    //   483: lload 7
    //   485: getstatic 101	com/tencent/mm/sdk/platformtools/bj:uiD	J
    //   488: lsub
    //   489: invokestatic 169	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   492: aastore
    //   493: invokestatic 175	com/tencent/mm/sdk/platformtools/y:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   496: aload 16
    //   498: astore 15
    //   500: lload_3
    //   501: getstatic 97	com/tencent/mm/sdk/platformtools/bj:uiB	J
    //   504: lcmp
    //   505: iflt +827 -> 1332
    //   508: aload 16
    //   510: astore 15
    //   512: lload_3
    //   513: getstatic 97	com/tencent/mm/sdk/platformtools/bj:uiB	J
    //   516: lsub
    //   517: lstore 9
    //   519: aload 16
    //   521: astore 15
    //   523: lload 9
    //   525: putstatic 77	com/tencent/mm/sdk/platformtools/bj:uiJ	J
    //   528: aload 16
    //   530: astore 15
    //   532: lload_1
    //   533: getstatic 99	com/tencent/mm/sdk/platformtools/bj:uiC	J
    //   536: lcmp
    //   537: iflt +801 -> 1338
    //   540: aload 16
    //   542: astore 15
    //   544: lload_1
    //   545: getstatic 99	com/tencent/mm/sdk/platformtools/bj:uiC	J
    //   548: lsub
    //   549: lstore 9
    //   551: aload 16
    //   553: astore 15
    //   555: lload 9
    //   557: putstatic 80	com/tencent/mm/sdk/platformtools/bj:uiK	J
    //   560: aload 16
    //   562: astore 15
    //   564: lload 7
    //   566: getstatic 101	com/tencent/mm/sdk/platformtools/bj:uiD	J
    //   569: lcmp
    //   570: iflt +774 -> 1344
    //   573: aload 16
    //   575: astore 15
    //   577: lload 7
    //   579: getstatic 101	com/tencent/mm/sdk/platformtools/bj:uiD	J
    //   582: lsub
    //   583: lstore 9
    //   585: aload 16
    //   587: astore 15
    //   589: lload 9
    //   591: putstatic 71	com/tencent/mm/sdk/platformtools/bj:uiL	J
    //   594: aload 16
    //   596: astore 15
    //   598: lload 5
    //   600: getstatic 103	com/tencent/mm/sdk/platformtools/bj:uiE	J
    //   603: lcmp
    //   604: iflt +747 -> 1351
    //   607: aload 16
    //   609: astore 15
    //   611: lload 5
    //   613: getstatic 103	com/tencent/mm/sdk/platformtools/bj:uiE	J
    //   616: lsub
    //   617: lstore 9
    //   619: aload 16
    //   621: astore 15
    //   623: lload 9
    //   625: putstatic 74	com/tencent/mm/sdk/platformtools/bj:uiM	J
    //   628: aload 16
    //   630: astore 15
    //   632: lload_3
    //   633: putstatic 97	com/tencent/mm/sdk/platformtools/bj:uiB	J
    //   636: aload 16
    //   638: astore 15
    //   640: lload_1
    //   641: putstatic 99	com/tencent/mm/sdk/platformtools/bj:uiC	J
    //   644: aload 16
    //   646: astore 15
    //   648: lload 7
    //   650: putstatic 101	com/tencent/mm/sdk/platformtools/bj:uiD	J
    //   653: aload 16
    //   655: astore 15
    //   657: lload 5
    //   659: putstatic 103	com/tencent/mm/sdk/platformtools/bj:uiE	J
    //   662: getstatic 66	com/tencent/mm/sdk/platformtools/bj:pJR	Ljava/io/File;
    //   665: ifnull +643 -> 1308
    //   668: invokestatic 186	android/os/Process:myUid	()I
    //   671: istore_0
    //   672: new 118	java/util/Scanner
    //   675: dup
    //   676: getstatic 66	com/tencent/mm/sdk/platformtools/bj:pJR	Ljava/io/File;
    //   679: invokespecial 121	java/util/Scanner:<init>	(Ljava/io/File;)V
    //   682: astore 16
    //   684: aload 16
    //   686: astore 15
    //   688: aload 16
    //   690: invokevirtual 124	java/util/Scanner:nextLine	()Ljava/lang/String;
    //   693: pop
    //   694: lconst_0
    //   695: lstore 7
    //   697: lconst_0
    //   698: lstore 5
    //   700: lload 13
    //   702: lstore_1
    //   703: lload 11
    //   705: lstore_3
    //   706: aload 16
    //   708: astore 15
    //   710: aload 16
    //   712: invokevirtual 127	java/util/Scanner:hasNext	()Z
    //   715: ifeq +129 -> 844
    //   718: aload 16
    //   720: astore 15
    //   722: aload 16
    //   724: invokevirtual 124	java/util/Scanner:nextLine	()Ljava/lang/String;
    //   727: ldc 188
    //   729: invokevirtual 135	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   732: astore 17
    //   734: aload 16
    //   736: astore 15
    //   738: aload 17
    //   740: iconst_3
    //   741: aaload
    //   742: invokestatic 194	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   745: iload_0
    //   746: if_icmpne -40 -> 706
    //   749: aload 17
    //   751: iconst_1
    //   752: aaload
    //   753: astore 18
    //   755: aload 16
    //   757: astore 15
    //   759: aload 17
    //   761: iconst_5
    //   762: aaload
    //   763: invokestatic 158	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   766: lstore 11
    //   768: aload 16
    //   770: astore 15
    //   772: aload 17
    //   774: bipush 7
    //   776: aaload
    //   777: invokestatic 158	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   780: lstore 9
    //   782: aload 16
    //   784: astore 15
    //   786: aload 18
    //   788: ldc 146
    //   790: invokevirtual 150	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   793: ifne +526 -> 1319
    //   796: aload 16
    //   798: astore 15
    //   800: aload 18
    //   802: ldc 152
    //   804: invokevirtual 150	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   807: ifeq +6 -> 813
    //   810: goto +509 -> 1319
    //   813: aload 16
    //   815: astore 15
    //   817: aload 18
    //   819: ldc 140
    //   821: invokevirtual 144	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   824: ifne -118 -> 706
    //   827: lload 7
    //   829: lload 11
    //   831: ladd
    //   832: lstore 7
    //   834: lload 5
    //   836: lload 9
    //   838: ladd
    //   839: lstore 5
    //   841: goto -135 -> 706
    //   844: aload 16
    //   846: astore 15
    //   848: getstatic 105	com/tencent/mm/sdk/platformtools/bj:uiG	J
    //   851: lconst_0
    //   852: lcmp
    //   853: ifge +11 -> 864
    //   856: aload 16
    //   858: astore 15
    //   860: lload_3
    //   861: putstatic 105	com/tencent/mm/sdk/platformtools/bj:uiG	J
    //   864: aload 16
    //   866: astore 15
    //   868: getstatic 107	com/tencent/mm/sdk/platformtools/bj:uiF	J
    //   871: lconst_0
    //   872: lcmp
    //   873: ifge +11 -> 884
    //   876: aload 16
    //   878: astore 15
    //   880: lload_1
    //   881: putstatic 107	com/tencent/mm/sdk/platformtools/bj:uiF	J
    //   884: aload 16
    //   886: astore 15
    //   888: getstatic 109	com/tencent/mm/sdk/platformtools/bj:uiI	J
    //   891: lconst_0
    //   892: lcmp
    //   893: ifge +12 -> 905
    //   896: aload 16
    //   898: astore 15
    //   900: lload 7
    //   902: putstatic 109	com/tencent/mm/sdk/platformtools/bj:uiI	J
    //   905: aload 16
    //   907: astore 15
    //   909: getstatic 111	com/tencent/mm/sdk/platformtools/bj:uiH	J
    //   912: lconst_0
    //   913: lcmp
    //   914: ifge +12 -> 926
    //   917: aload 16
    //   919: astore 15
    //   921: lload 5
    //   923: putstatic 111	com/tencent/mm/sdk/platformtools/bj:uiH	J
    //   926: aload 16
    //   928: astore 15
    //   930: lload_1
    //   931: getstatic 107	com/tencent/mm/sdk/platformtools/bj:uiF	J
    //   934: lcmp
    //   935: iflt +254 -> 1189
    //   938: aload 16
    //   940: astore 15
    //   942: lload_1
    //   943: getstatic 107	com/tencent/mm/sdk/platformtools/bj:uiF	J
    //   946: lsub
    //   947: lstore 9
    //   949: aload 16
    //   951: astore 15
    //   953: lload 9
    //   955: putstatic 89	com/tencent/mm/sdk/platformtools/bj:uiN	J
    //   958: aload 16
    //   960: astore 15
    //   962: lload_3
    //   963: getstatic 105	com/tencent/mm/sdk/platformtools/bj:uiG	J
    //   966: lcmp
    //   967: iflt +228 -> 1195
    //   970: aload 16
    //   972: astore 15
    //   974: lload_3
    //   975: getstatic 105	com/tencent/mm/sdk/platformtools/bj:uiG	J
    //   978: lsub
    //   979: lstore 9
    //   981: aload 16
    //   983: astore 15
    //   985: lload 9
    //   987: putstatic 92	com/tencent/mm/sdk/platformtools/bj:uiO	J
    //   990: aload 16
    //   992: astore 15
    //   994: lload 5
    //   996: getstatic 111	com/tencent/mm/sdk/platformtools/bj:uiH	J
    //   999: lcmp
    //   1000: iflt +201 -> 1201
    //   1003: aload 16
    //   1005: astore 15
    //   1007: lload 5
    //   1009: getstatic 111	com/tencent/mm/sdk/platformtools/bj:uiH	J
    //   1012: lsub
    //   1013: lstore 9
    //   1015: aload 16
    //   1017: astore 15
    //   1019: lload 9
    //   1021: putstatic 83	com/tencent/mm/sdk/platformtools/bj:uiP	J
    //   1024: aload 16
    //   1026: astore 15
    //   1028: lload 7
    //   1030: getstatic 109	com/tencent/mm/sdk/platformtools/bj:uiI	J
    //   1033: lcmp
    //   1034: iflt +174 -> 1208
    //   1037: aload 16
    //   1039: astore 15
    //   1041: lload 7
    //   1043: getstatic 109	com/tencent/mm/sdk/platformtools/bj:uiI	J
    //   1046: lsub
    //   1047: lstore 9
    //   1049: aload 16
    //   1051: astore 15
    //   1053: lload 9
    //   1055: putstatic 86	com/tencent/mm/sdk/platformtools/bj:uiQ	J
    //   1058: aload 16
    //   1060: astore 15
    //   1062: lload_1
    //   1063: putstatic 107	com/tencent/mm/sdk/platformtools/bj:uiF	J
    //   1066: aload 16
    //   1068: astore 15
    //   1070: lload_3
    //   1071: putstatic 105	com/tencent/mm/sdk/platformtools/bj:uiG	J
    //   1074: aload 16
    //   1076: astore 15
    //   1078: lload 5
    //   1080: putstatic 111	com/tencent/mm/sdk/platformtools/bj:uiH	J
    //   1083: aload 16
    //   1085: astore 15
    //   1087: lload 7
    //   1089: putstatic 109	com/tencent/mm/sdk/platformtools/bj:uiI	J
    //   1092: aload 16
    //   1094: ifnull +8 -> 1102
    //   1097: aload 16
    //   1099: invokevirtual 161	java/util/Scanner:close	()V
    //   1102: ldc 163
    //   1104: ldc 196
    //   1106: bipush 8
    //   1108: anewarray 4	java/lang/Object
    //   1111: dup
    //   1112: iconst_0
    //   1113: getstatic 74	com/tencent/mm/sdk/platformtools/bj:uiM	J
    //   1116: invokestatic 169	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1119: aastore
    //   1120: dup
    //   1121: iconst_1
    //   1122: getstatic 71	com/tencent/mm/sdk/platformtools/bj:uiL	J
    //   1125: invokestatic 169	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1128: aastore
    //   1129: dup
    //   1130: iconst_2
    //   1131: getstatic 80	com/tencent/mm/sdk/platformtools/bj:uiK	J
    //   1134: invokestatic 169	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1137: aastore
    //   1138: dup
    //   1139: iconst_3
    //   1140: getstatic 77	com/tencent/mm/sdk/platformtools/bj:uiJ	J
    //   1143: invokestatic 169	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1146: aastore
    //   1147: dup
    //   1148: iconst_4
    //   1149: getstatic 86	com/tencent/mm/sdk/platformtools/bj:uiQ	J
    //   1152: invokestatic 169	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1155: aastore
    //   1156: dup
    //   1157: iconst_5
    //   1158: getstatic 83	com/tencent/mm/sdk/platformtools/bj:uiP	J
    //   1161: invokestatic 169	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1164: aastore
    //   1165: dup
    //   1166: bipush 6
    //   1168: getstatic 92	com/tencent/mm/sdk/platformtools/bj:uiO	J
    //   1171: invokestatic 169	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1174: aastore
    //   1175: dup
    //   1176: bipush 7
    //   1178: getstatic 89	com/tencent/mm/sdk/platformtools/bj:uiN	J
    //   1181: invokestatic 169	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1184: aastore
    //   1185: invokestatic 199	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1188: return
    //   1189: lload_1
    //   1190: lstore 9
    //   1192: goto -243 -> 949
    //   1195: lload_3
    //   1196: lstore 9
    //   1198: goto -217 -> 981
    //   1201: lload 5
    //   1203: lstore 9
    //   1205: goto -190 -> 1015
    //   1208: lload 7
    //   1210: lstore 9
    //   1212: goto -163 -> 1049
    //   1215: aconst_null
    //   1216: astore 15
    //   1218: astore 16
    //   1220: ldc 163
    //   1222: aload 16
    //   1224: ldc 201
    //   1226: iconst_0
    //   1227: anewarray 4	java/lang/Object
    //   1230: invokestatic 205	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1233: aload 15
    //   1235: ifnull -133 -> 1102
    //   1238: aload 15
    //   1240: invokevirtual 161	java/util/Scanner:close	()V
    //   1243: goto -141 -> 1102
    //   1246: astore 16
    //   1248: aconst_null
    //   1249: astore 15
    //   1251: aload 15
    //   1253: ifnull +8 -> 1261
    //   1256: aload 15
    //   1258: invokevirtual 161	java/util/Scanner:close	()V
    //   1261: aload 16
    //   1263: athrow
    //   1264: astore 16
    //   1266: goto -15 -> 1251
    //   1269: astore 16
    //   1271: goto -20 -> 1251
    //   1274: astore 17
    //   1276: aload 16
    //   1278: astore 15
    //   1280: aload 17
    //   1282: astore 16
    //   1284: goto -64 -> 1220
    //   1287: astore 16
    //   1289: aconst_null
    //   1290: astore 15
    //   1292: goto -72 -> 1220
    //   1295: astore 17
    //   1297: aload 16
    //   1299: astore 15
    //   1301: aload 17
    //   1303: astore 16
    //   1305: goto -85 -> 1220
    //   1308: aconst_null
    //   1309: astore 16
    //   1311: goto -219 -> 1092
    //   1314: iconst_0
    //   1315: istore_0
    //   1316: goto -1218 -> 98
    //   1319: lload_3
    //   1320: lload 11
    //   1322: ladd
    //   1323: lstore_3
    //   1324: lload_1
    //   1325: lload 9
    //   1327: ladd
    //   1328: lstore_1
    //   1329: goto -623 -> 706
    //   1332: lload_3
    //   1333: lstore 9
    //   1335: goto -816 -> 519
    //   1338: lload_1
    //   1339: lstore 9
    //   1341: goto -790 -> 551
    //   1344: lload 7
    //   1346: lstore 9
    //   1348: goto -763 -> 585
    //   1351: lload 5
    //   1353: lstore 9
    //   1355: goto -736 -> 619
    // Local variable table:
    //   start	length	slot	name	signature
    //   97	1219	0	i	int
    //   3	1336	1	l1	long
    //   1	1332	3	l2	long
    //   52	1300	5	l3	long
    //   5	1340	7	l4	long
    //   517	837	9	l5	long
    //   11	1310	11	l6	long
    //   8	693	13	l7	long
    //   33	1267	15	localObject1	Object
    //   29	1069	16	localScanner	java.util.Scanner
    //   1218	5	16	localException1	java.lang.Exception
    //   1246	16	16	localObject2	Object
    //   1264	1	16	localObject3	Object
    //   1269	8	16	localObject4	Object
    //   1282	1	16	localObject5	Object
    //   1287	11	16	localException2	java.lang.Exception
    //   1303	7	16	localObject6	Object
    //   80	693	17	arrayOfString	java.lang.String[]
    //   1274	7	17	localException3	java.lang.Exception
    //   1295	7	17	localException4	java.lang.Exception
    //   753	65	18	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   13	31	1215	java/lang/Exception
    //   662	684	1215	java/lang/Exception
    //   13	31	1246	finally
    //   662	684	1246	finally
    //   35	41	1264	finally
    //   45	51	1264	finally
    //   58	66	1264	finally
    //   70	82	1264	finally
    //   86	96	1264	finally
    //   102	116	1264	finally
    //   120	134	1264	finally
    //   138	152	1264	finally
    //   156	169	1264	finally
    //   173	185	1264	finally
    //   192	207	1264	finally
    //   211	225	1264	finally
    //   232	237	1264	finally
    //   244	252	1264	finally
    //   256	260	1264	finally
    //   264	282	1264	finally
    //   286	294	1264	finally
    //   298	302	1264	finally
    //   306	324	1264	finally
    //   328	336	1264	finally
    //   340	345	1264	finally
    //   349	368	1264	finally
    //   372	380	1264	finally
    //   384	389	1264	finally
    //   393	412	1264	finally
    //   416	427	1264	finally
    //   431	454	1264	finally
    //   458	469	1264	finally
    //   473	496	1264	finally
    //   500	508	1264	finally
    //   512	519	1264	finally
    //   523	528	1264	finally
    //   532	540	1264	finally
    //   544	551	1264	finally
    //   555	560	1264	finally
    //   564	573	1264	finally
    //   577	585	1264	finally
    //   589	594	1264	finally
    //   598	607	1264	finally
    //   611	619	1264	finally
    //   623	628	1264	finally
    //   632	636	1264	finally
    //   640	644	1264	finally
    //   648	653	1264	finally
    //   657	662	1264	finally
    //   688	694	1264	finally
    //   710	718	1264	finally
    //   722	734	1264	finally
    //   738	749	1264	finally
    //   759	768	1264	finally
    //   772	782	1264	finally
    //   786	796	1264	finally
    //   800	810	1264	finally
    //   817	827	1264	finally
    //   848	856	1264	finally
    //   860	864	1264	finally
    //   868	876	1264	finally
    //   880	884	1264	finally
    //   888	896	1264	finally
    //   900	905	1264	finally
    //   909	917	1264	finally
    //   921	926	1264	finally
    //   930	938	1264	finally
    //   942	949	1264	finally
    //   953	958	1264	finally
    //   962	970	1264	finally
    //   974	981	1264	finally
    //   985	990	1264	finally
    //   994	1003	1264	finally
    //   1007	1015	1264	finally
    //   1019	1024	1264	finally
    //   1028	1037	1264	finally
    //   1041	1049	1264	finally
    //   1053	1058	1264	finally
    //   1062	1066	1264	finally
    //   1070	1074	1264	finally
    //   1078	1083	1264	finally
    //   1087	1092	1264	finally
    //   1220	1233	1269	finally
    //   35	41	1274	java/lang/Exception
    //   45	51	1274	java/lang/Exception
    //   58	66	1274	java/lang/Exception
    //   70	82	1274	java/lang/Exception
    //   86	96	1274	java/lang/Exception
    //   102	116	1274	java/lang/Exception
    //   120	134	1274	java/lang/Exception
    //   138	152	1274	java/lang/Exception
    //   156	169	1274	java/lang/Exception
    //   173	185	1274	java/lang/Exception
    //   192	207	1274	java/lang/Exception
    //   211	225	1274	java/lang/Exception
    //   232	237	1274	java/lang/Exception
    //   244	252	1287	java/lang/Exception
    //   256	260	1287	java/lang/Exception
    //   264	282	1287	java/lang/Exception
    //   286	294	1287	java/lang/Exception
    //   298	302	1287	java/lang/Exception
    //   306	324	1287	java/lang/Exception
    //   328	336	1287	java/lang/Exception
    //   340	345	1287	java/lang/Exception
    //   349	368	1287	java/lang/Exception
    //   372	380	1287	java/lang/Exception
    //   384	389	1287	java/lang/Exception
    //   393	412	1287	java/lang/Exception
    //   416	427	1287	java/lang/Exception
    //   431	454	1287	java/lang/Exception
    //   458	469	1287	java/lang/Exception
    //   473	496	1287	java/lang/Exception
    //   500	508	1287	java/lang/Exception
    //   512	519	1287	java/lang/Exception
    //   523	528	1287	java/lang/Exception
    //   532	540	1287	java/lang/Exception
    //   544	551	1287	java/lang/Exception
    //   555	560	1287	java/lang/Exception
    //   564	573	1287	java/lang/Exception
    //   577	585	1287	java/lang/Exception
    //   589	594	1287	java/lang/Exception
    //   598	607	1287	java/lang/Exception
    //   611	619	1287	java/lang/Exception
    //   623	628	1287	java/lang/Exception
    //   632	636	1287	java/lang/Exception
    //   640	644	1287	java/lang/Exception
    //   648	653	1287	java/lang/Exception
    //   657	662	1287	java/lang/Exception
    //   688	694	1295	java/lang/Exception
    //   710	718	1295	java/lang/Exception
    //   722	734	1295	java/lang/Exception
    //   738	749	1295	java/lang/Exception
    //   759	768	1295	java/lang/Exception
    //   772	782	1295	java/lang/Exception
    //   786	796	1295	java/lang/Exception
    //   800	810	1295	java/lang/Exception
    //   817	827	1295	java/lang/Exception
    //   848	856	1295	java/lang/Exception
    //   860	864	1295	java/lang/Exception
    //   868	876	1295	java/lang/Exception
    //   880	884	1295	java/lang/Exception
    //   888	896	1295	java/lang/Exception
    //   900	905	1295	java/lang/Exception
    //   909	917	1295	java/lang/Exception
    //   921	926	1295	java/lang/Exception
    //   930	938	1295	java/lang/Exception
    //   942	949	1295	java/lang/Exception
    //   953	958	1295	java/lang/Exception
    //   962	970	1295	java/lang/Exception
    //   974	981	1295	java/lang/Exception
    //   985	990	1295	java/lang/Exception
    //   994	1003	1295	java/lang/Exception
    //   1007	1015	1295	java/lang/Exception
    //   1019	1024	1295	java/lang/Exception
    //   1028	1037	1295	java/lang/Exception
    //   1041	1049	1295	java/lang/Exception
    //   1053	1058	1295	java/lang/Exception
    //   1062	1066	1295	java/lang/Exception
    //   1070	1074	1295	java/lang/Exception
    //   1078	1083	1295	java/lang/Exception
    //   1087	1092	1295	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bj
 * JD-Core Version:    0.7.0.1
 */