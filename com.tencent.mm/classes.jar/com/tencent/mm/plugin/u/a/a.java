package com.tencent.mm.plugin.u.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.model.n;
import com.tencent.mm.plugin.scanner.util.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.qbar.QbarNative;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public final class a
{
  Set<Integer> cEw;
  private Object ceY;
  private boolean hJk;
  boolean mCancelled;
  private QbarNative pPi;
  a.a pPj;
  long pPk;
  
  public a()
  {
    AppMethodBeat.i(80742);
    this.pPi = new QbarNative();
    this.ceY = new Object();
    this.hJk = false;
    this.pPj = null;
    this.pPk = 0L;
    this.mCancelled = false;
    AppMethodBeat.o(80742);
  }
  
  private d O(Bitmap paramBitmap)
  {
    AppMethodBeat.i(80745);
    paramBitmap = new g(paramBitmap);
    if ((paramBitmap.cjr() == null) || (paramBitmap.width <= 0) || (paramBitmap.height <= 0))
    {
      AppMethodBeat.o(80745);
      return null;
    }
    paramBitmap = a(paramBitmap, this.cEw);
    AppMethodBeat.o(80745);
    return paramBitmap;
  }
  
  /* Error */
  private d a(f.a parama, Set<Integer> paramSet)
  {
    // Byte code:
    //   0: ldc 82
    //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 84	com/tencent/mm/plugin/u/a/d
    //   8: dup
    //   9: invokespecial 85	com/tencent/mm/plugin/u/a/d:<init>	()V
    //   12: astore 11
    //   14: aload_0
    //   15: getfield 40	com/tencent/mm/plugin/u/a/a:ceY	Ljava/lang/Object;
    //   18: astore 10
    //   20: aload 10
    //   22: monitorenter
    //   23: aload_2
    //   24: ifnull +34 -> 58
    //   27: aload_2
    //   28: invokeinterface 91 1 0
    //   33: ifne +25 -> 58
    //   36: aload_0
    //   37: aload_2
    //   38: invokespecial 95	com/tencent/mm/plugin/u/a/a:h	(Ljava/util/Set;)Z
    //   41: ifne +17 -> 58
    //   44: aload_0
    //   45: invokespecial 98	com/tencent/mm/plugin/u/a/a:pJ	()V
    //   48: aload 10
    //   50: monitorexit
    //   51: ldc 82
    //   53: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: aconst_null
    //   57: areturn
    //   58: aload_0
    //   59: getfield 42	com/tencent/mm/plugin/u/a/a:hJk	Z
    //   62: ifne +81 -> 143
    //   65: new 100	java/util/HashSet
    //   68: dup
    //   69: invokespecial 101	java/util/HashSet:<init>	()V
    //   72: astore_2
    //   73: aload_2
    //   74: iconst_2
    //   75: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   78: invokeinterface 111 2 0
    //   83: pop
    //   84: aload_2
    //   85: iconst_1
    //   86: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   89: invokeinterface 111 2 0
    //   94: pop
    //   95: aload_2
    //   96: iconst_4
    //   97: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   100: invokeinterface 111 2 0
    //   105: pop
    //   106: aload_2
    //   107: iconst_3
    //   108: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   111: invokeinterface 111 2 0
    //   116: pop
    //   117: aload_0
    //   118: aload_2
    //   119: invokespecial 95	com/tencent/mm/plugin/u/a/a:h	(Ljava/util/Set;)Z
    //   122: istore 5
    //   124: iload 5
    //   126: ifne +26 -> 152
    //   129: aload_0
    //   130: invokespecial 98	com/tencent/mm/plugin/u/a/a:pJ	()V
    //   133: aload 10
    //   135: monitorexit
    //   136: ldc 82
    //   138: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aconst_null
    //   142: areturn
    //   143: aload_0
    //   144: getfield 42	com/tencent/mm/plugin/u/a/a:hJk	Z
    //   147: istore 5
    //   149: goto -25 -> 124
    //   152: ldc 113
    //   154: ldc 115
    //   156: iconst_1
    //   157: anewarray 4	java/lang/Object
    //   160: dup
    //   161: iconst_0
    //   162: getstatic 121	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   165: aastore
    //   166: invokestatic 127	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   169: aload_1
    //   170: invokevirtual 128	f/a:cjr	()[B
    //   173: ifnull +45 -> 218
    //   176: ldc 113
    //   178: ldc 130
    //   180: iconst_3
    //   181: anewarray 4	java/lang/Object
    //   184: dup
    //   185: iconst_0
    //   186: aload_1
    //   187: invokevirtual 128	f/a:cjr	()[B
    //   190: arraylength
    //   191: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   194: aastore
    //   195: dup
    //   196: iconst_1
    //   197: aload_1
    //   198: getfield 70	f/a:width	I
    //   201: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   204: aastore
    //   205: dup
    //   206: iconst_2
    //   207: aload_1
    //   208: getfield 73	f/a:height	I
    //   211: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   214: aastore
    //   215: invokestatic 132	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   218: invokestatic 138	java/lang/System:currentTimeMillis	()J
    //   221: lstore 6
    //   223: aload_1
    //   224: invokevirtual 128	f/a:cjr	()[B
    //   227: ifnull +152 -> 379
    //   230: aload_1
    //   231: getfield 70	f/a:width	I
    //   234: aload_1
    //   235: getfield 73	f/a:height	I
    //   238: imul
    //   239: aload_1
    //   240: invokevirtual 128	f/a:cjr	()[B
    //   243: arraylength
    //   244: if_icmpne +135 -> 379
    //   247: getstatic 144	com/tencent/mm/plugin/scanner/model/n:qux	Lcom/tencent/mm/plugin/scanner/model/n;
    //   250: aload_1
    //   251: getfield 70	f/a:width	I
    //   254: aload_1
    //   255: getfield 73	f/a:height	I
    //   258: invokevirtual 148	com/tencent/mm/plugin/scanner/model/n:fn	(II)V
    //   261: aload_0
    //   262: getfield 38	com/tencent/mm/plugin/u/a/a:pPi	Lcom/tencent/qbar/QbarNative;
    //   265: aload_1
    //   266: invokevirtual 128	f/a:cjr	()[B
    //   269: aload_1
    //   270: getfield 70	f/a:width	I
    //   273: aload_1
    //   274: getfield 73	f/a:height	I
    //   277: invokevirtual 152	com/tencent/qbar/QbarNative:A	([BII)I
    //   280: istore_3
    //   281: invokestatic 138	java/lang/System:currentTimeMillis	()J
    //   284: lstore 8
    //   286: ldc 113
    //   288: ldc 154
    //   290: iconst_2
    //   291: anewarray 4	java/lang/Object
    //   294: dup
    //   295: iconst_0
    //   296: iload_3
    //   297: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   300: aastore
    //   301: dup
    //   302: iconst_1
    //   303: lload 8
    //   305: lload 6
    //   307: lsub
    //   308: invokestatic 159	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   311: aastore
    //   312: invokestatic 127	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   315: getstatic 144	com/tencent/mm/plugin/scanner/model/n:qux	Lcom/tencent/mm/plugin/scanner/model/n;
    //   318: lload 8
    //   320: lload 6
    //   322: lsub
    //   323: invokevirtual 163	com/tencent/mm/plugin/scanner/model/n:lc	(J)V
    //   326: getstatic 144	com/tencent/mm/plugin/scanner/model/n:qux	Lcom/tencent/mm/plugin/scanner/model/n;
    //   329: invokevirtual 166	com/tencent/mm/plugin/scanner/model/n:cih	()V
    //   332: iload_3
    //   333: ifeq +51 -> 384
    //   336: new 168	java/util/ArrayList
    //   339: dup
    //   340: invokespecial 169	java/util/ArrayList:<init>	()V
    //   343: astore_1
    //   344: new 168	java/util/ArrayList
    //   347: dup
    //   348: invokespecial 169	java/util/ArrayList:<init>	()V
    //   351: astore_2
    //   352: aload_0
    //   353: getfield 38	com/tencent/mm/plugin/u/a/a:pPi	Lcom/tencent/qbar/QbarNative;
    //   356: aload_1
    //   357: aload_2
    //   358: invokevirtual 173	com/tencent/qbar/QbarNative:x	(Ljava/util/List;Ljava/util/List;)I
    //   361: pop
    //   362: getstatic 144	com/tencent/mm/plugin/scanner/model/n:qux	Lcom/tencent/mm/plugin/scanner/model/n;
    //   365: aload_1
    //   366: putfield 177	com/tencent/mm/plugin/scanner/model/n:quO	Ljava/util/List;
    //   369: aload 10
    //   371: monitorexit
    //   372: ldc 82
    //   374: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   377: aconst_null
    //   378: areturn
    //   379: iconst_m1
    //   380: istore_3
    //   381: goto -100 -> 281
    //   384: invokestatic 183	com/tencent/mm/model/v:aae	()Lcom/tencent/mm/model/v;
    //   387: ldc 185
    //   389: invokevirtual 189	com/tencent/mm/model/v:oP	(Ljava/lang/String;)Lcom/tencent/mm/model/v$b;
    //   392: astore_1
    //   393: aload_1
    //   394: ifnull +75 -> 469
    //   397: aload_1
    //   398: ldc 191
    //   400: iconst_0
    //   401: invokevirtual 197	com/tencent/mm/model/v$b:getInt	(Ljava/lang/String;I)I
    //   404: istore_3
    //   405: aload_1
    //   406: ldc 199
    //   408: iconst_0
    //   409: invokevirtual 197	com/tencent/mm/model/v$b:getInt	(Ljava/lang/String;I)I
    //   412: istore 4
    //   414: aload_0
    //   415: getfield 38	com/tencent/mm/plugin/u/a/a:pPi	Lcom/tencent/qbar/QbarNative;
    //   418: astore_1
    //   419: aload_1
    //   420: iload_3
    //   421: iload 4
    //   423: invokestatic 205	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   426: invokestatic 211	com/tencent/mm/cb/a:gw	(Landroid/content/Context;)I
    //   429: invokestatic 205	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   432: invokestatic 214	com/tencent/mm/cb/a:gx	(Landroid/content/Context;)I
    //   435: aload_1
    //   436: getfield 217	com/tencent/qbar/QbarNative:BhG	I
    //   439: invokevirtual 221	com/tencent/qbar/QbarNative:SetCenterCoordinate	(IIIII)I
    //   442: pop
    //   443: ldc 113
    //   445: ldc 223
    //   447: iconst_2
    //   448: anewarray 4	java/lang/Object
    //   451: dup
    //   452: iconst_0
    //   453: iload_3
    //   454: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   457: aastore
    //   458: dup
    //   459: iconst_1
    //   460: iload 4
    //   462: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   465: aastore
    //   466: invokestatic 132	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   469: getstatic 144	com/tencent/mm/plugin/scanner/model/n:qux	Lcom/tencent/mm/plugin/scanner/model/n;
    //   472: invokevirtual 226	com/tencent/mm/plugin/scanner/model/n:cig	()V
    //   475: getstatic 144	com/tencent/mm/plugin/scanner/model/n:qux	Lcom/tencent/mm/plugin/scanner/model/n;
    //   478: lload 8
    //   480: lload 6
    //   482: lsub
    //   483: invokevirtual 229	com/tencent/mm/plugin/scanner/model/n:ld	(J)V
    //   486: new 231	java/util/LinkedList
    //   489: dup
    //   490: invokespecial 232	java/util/LinkedList:<init>	()V
    //   493: astore 12
    //   495: new 231	java/util/LinkedList
    //   498: dup
    //   499: invokespecial 232	java/util/LinkedList:<init>	()V
    //   502: astore 13
    //   504: aload_0
    //   505: getfield 38	com/tencent/mm/plugin/u/a/a:pPi	Lcom/tencent/qbar/QbarNative;
    //   508: aload 12
    //   510: aload 13
    //   512: invokevirtual 235	com/tencent/qbar/QbarNative:w	(Ljava/util/List;Ljava/util/List;)I
    //   515: pop
    //   516: aload 12
    //   518: invokeinterface 241 1 0
    //   523: istore_3
    //   524: iload_3
    //   525: ifne +13 -> 538
    //   528: aload 10
    //   530: monitorexit
    //   531: ldc 82
    //   533: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   536: aconst_null
    //   537: areturn
    //   538: ldc 113
    //   540: ldc 243
    //   542: iconst_1
    //   543: anewarray 4	java/lang/Object
    //   546: dup
    //   547: iconst_0
    //   548: aload 12
    //   550: invokeinterface 241 1 0
    //   555: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   558: aastore
    //   559: invokestatic 132	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   562: aload 12
    //   564: iconst_0
    //   565: invokeinterface 247 2 0
    //   570: checkcast 249	com/tencent/qbar/QbarNative$QBarResult
    //   573: astore 14
    //   575: aconst_null
    //   576: astore_2
    //   577: aload 13
    //   579: invokestatic 255	com/tencent/mm/sdk/platformtools/bo:es	(Ljava/util/List;)Z
    //   582: ifne +15 -> 597
    //   585: aload 13
    //   587: iconst_0
    //   588: invokeinterface 247 2 0
    //   593: checkcast 257	com/tencent/qbar/QbarNative$QBarReportMsg
    //   596: astore_2
    //   597: ldc_w 259
    //   600: astore_1
    //   601: aload 14
    //   603: ifnull +127 -> 730
    //   606: aload 14
    //   608: getfield 263	com/tencent/qbar/QbarNative$QBarResult:data	Ljava/lang/String;
    //   611: invokestatic 267	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   614: ifne +35 -> 649
    //   617: aload 14
    //   619: getfield 270	com/tencent/qbar/QbarNative$QBarResult:typeName	Ljava/lang/String;
    //   622: astore_1
    //   623: aload_1
    //   624: ldc_w 272
    //   627: invokevirtual 277	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   630: ifne +13 -> 643
    //   633: aload_1
    //   634: ldc_w 279
    //   637: invokevirtual 277	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   640: ifeq +101 -> 741
    //   643: aload 14
    //   645: getfield 263	com/tencent/qbar/QbarNative$QBarResult:data	Ljava/lang/String;
    //   648: astore_1
    //   649: aload 11
    //   651: aload_1
    //   652: putfield 282	com/tencent/mm/plugin/u/a/d:result	Ljava/lang/String;
    //   655: aload 11
    //   657: aload 14
    //   659: getfield 286	com/tencent/qbar/QbarNative$QBarResult:rawData	[B
    //   662: putfield 287	com/tencent/mm/plugin/u/a/d:rawData	[B
    //   665: aload 11
    //   667: aload 14
    //   669: getfield 270	com/tencent/qbar/QbarNative$QBarResult:typeName	Ljava/lang/String;
    //   672: invokestatic 293	com/tencent/mm/plugin/scanner/util/t:YP	(Ljava/lang/String;)I
    //   675: putfield 296	com/tencent/mm/plugin/u/a/d:cpE	I
    //   678: aload_2
    //   679: ifnull +94 -> 773
    //   682: aload_2
    //   683: getfield 299	com/tencent/qbar/QbarNative$QBarReportMsg:qrcodeVersion	I
    //   686: istore_3
    //   687: aload 11
    //   689: iload_3
    //   690: putfield 302	com/tencent/mm/plugin/u/a/d:cpF	I
    //   693: aload 11
    //   695: aload 14
    //   697: getfield 270	com/tencent/qbar/QbarNative$QBarResult:typeName	Ljava/lang/String;
    //   700: putfield 305	com/tencent/mm/plugin/u/a/d:pPC	Ljava/lang/String;
    //   703: getstatic 144	com/tencent/mm/plugin/scanner/model/n:qux	Lcom/tencent/mm/plugin/scanner/model/n;
    //   706: aload 14
    //   708: getfield 270	com/tencent/qbar/QbarNative$QBarResult:typeName	Ljava/lang/String;
    //   711: aload_1
    //   712: aload 14
    //   714: getfield 308	com/tencent/qbar/QbarNative$QBarResult:charset	Ljava/lang/String;
    //   717: aload_2
    //   718: aload 12
    //   720: invokeinterface 241 1 0
    //   725: aload 13
    //   727: invokevirtual 311	com/tencent/mm/plugin/scanner/model/n:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/qbar/QbarNative$QBarReportMsg;ILjava/util/List;)V
    //   730: aload 10
    //   732: monitorexit
    //   733: ldc 82
    //   735: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   738: aload 11
    //   740: areturn
    //   741: new 313	java/lang/StringBuilder
    //   744: dup
    //   745: invokespecial 314	java/lang/StringBuilder:<init>	()V
    //   748: aload_1
    //   749: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   752: ldc_w 320
    //   755: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: aload 14
    //   760: getfield 263	com/tencent/qbar/QbarNative$QBarResult:data	Ljava/lang/String;
    //   763: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   766: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   769: astore_1
    //   770: goto -121 -> 649
    //   773: iconst_0
    //   774: istore_3
    //   775: goto -88 -> 687
    //   778: astore_1
    //   779: ldc 113
    //   781: new 313	java/lang/StringBuilder
    //   784: dup
    //   785: ldc_w 326
    //   788: invokespecial 329	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   791: aload_1
    //   792: invokevirtual 332	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   795: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   801: invokestatic 336	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   804: ldc 113
    //   806: aload_1
    //   807: ldc_w 259
    //   810: iconst_0
    //   811: anewarray 4	java/lang/Object
    //   814: invokestatic 340	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   817: aload 10
    //   819: monitorexit
    //   820: ldc 82
    //   822: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   825: aload 11
    //   827: areturn
    //   828: astore_1
    //   829: aload 10
    //   831: monitorexit
    //   832: ldc 82
    //   834: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   837: aload_1
    //   838: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	839	0	this	a
    //   0	839	1	parama	f.a
    //   0	839	2	paramSet	Set<Integer>
    //   280	495	3	i	int
    //   412	49	4	j	int
    //   122	26	5	bool	boolean
    //   221	260	6	l1	long
    //   284	195	8	l2	long
    //   18	812	10	localObject	Object
    //   12	814	11	locald	d
    //   493	226	12	localLinkedList1	java.util.LinkedList
    //   502	224	13	localLinkedList2	java.util.LinkedList
    //   573	186	14	localQBarResult	com.tencent.qbar.QbarNative.QBarResult
    // Exception table:
    //   from	to	target	type
    //   27	48	778	java/lang/Exception
    //   58	124	778	java/lang/Exception
    //   129	133	778	java/lang/Exception
    //   143	149	778	java/lang/Exception
    //   152	218	778	java/lang/Exception
    //   218	281	778	java/lang/Exception
    //   281	332	778	java/lang/Exception
    //   336	369	778	java/lang/Exception
    //   384	393	778	java/lang/Exception
    //   397	469	778	java/lang/Exception
    //   469	524	778	java/lang/Exception
    //   538	575	778	java/lang/Exception
    //   577	597	778	java/lang/Exception
    //   606	643	778	java/lang/Exception
    //   643	649	778	java/lang/Exception
    //   649	678	778	java/lang/Exception
    //   682	687	778	java/lang/Exception
    //   687	730	778	java/lang/Exception
    //   741	770	778	java/lang/Exception
    //   27	48	828	finally
    //   48	51	828	finally
    //   58	124	828	finally
    //   129	133	828	finally
    //   133	136	828	finally
    //   143	149	828	finally
    //   152	218	828	finally
    //   218	281	828	finally
    //   281	332	828	finally
    //   336	369	828	finally
    //   369	372	828	finally
    //   384	393	828	finally
    //   397	469	828	finally
    //   469	524	828	finally
    //   528	531	828	finally
    //   538	575	828	finally
    //   577	597	828	finally
    //   606	643	828	finally
    //   643	649	828	finally
    //   649	678	828	finally
    //   682	687	828	finally
    //   687	730	828	finally
    //   730	733	828	finally
    //   741	770	828	finally
    //   779	820	828	finally
    //   829	832	828	finally
  }
  
  private int g(Set<Integer> arg1)
  {
    AppMethodBeat.i(80746);
    if ((??? != null) && (!???.isEmpty()))
    {
      int[] arrayOfInt = new int[???.size()];
      ??? = ???.iterator();
      int i = 0;
      while (???.hasNext())
      {
        Integer localInteger = (Integer)???.next();
        if (localInteger != null)
        {
          arrayOfInt[i] = localInteger.intValue();
          i += 1;
        }
      }
      ab.i("MicroMsg.scanner.DecodeFile", "QBarNative.SetReaders, readers:%s", new Object[] { Arrays.toString(arrayOfInt) });
      synchronized (this.ceY)
      {
        i = this.pPi.i(arrayOfInt, arrayOfInt.length);
        AppMethodBeat.o(80746);
        return i;
      }
    }
    AppMethodBeat.o(80746);
    return 0;
  }
  
  private boolean h(Set<Integer> paramSet)
  {
    AppMethodBeat.i(80747);
    if ((!this.hJk) && (paramSet != null) && (!paramSet.isEmpty()))
    {
      int i = this.pPi.a(1, "ANY", "UTF-8", com.tencent.qbar.a.iQ(ah.getContext()));
      n.qux.quN = paramSet.contains(Integer.valueOf(3));
      int j = g(paramSet);
      ab.i("MicroMsg.scanner.DecodeFile", "QbarNative.Init = [%s], SetReaders = [%s], version = [%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), QbarNative.getVersion() });
      if ((i == 0) && (j == 0)) {
        this.hJk = true;
      }
    }
    else
    {
      boolean bool = this.hJk;
      AppMethodBeat.o(80747);
      return bool;
    }
    ab.e("MicroMsg.scanner.DecodeFile", "QbarNative failed, releaseDecoder 1");
    AppMethodBeat.o(80747);
    return false;
  }
  
  private void pJ()
  {
    AppMethodBeat.i(80748);
    ab.d("MicroMsg.scanner.DecodeFile", "releaseDecoder() start, hasInitQBar = %s", new Object[] { Boolean.valueOf(this.hJk) });
    synchronized (this.ceY)
    {
      if (this.hJk)
      {
        int i = this.pPi.release();
        this.pPi = null;
        this.hJk = false;
        ab.d("MicroMsg.scanner.DecodeFile", "QbarNative.Release() = [%s]", new Object[] { Integer.valueOf(i) });
      }
      com.tencent.mm.plugin.scanner.util.d.cjp();
      AppMethodBeat.o(80748);
      return;
    }
  }
  
  public final d N(Bitmap paramBitmap)
  {
    AppMethodBeat.i(80744);
    long l = SystemClock.elapsedRealtime();
    paramBitmap = O(paramBitmap);
    n.qux.cii();
    ab.d("MicroMsg.scanner.DecodeFile", "decode once time(ms):".concat(String.valueOf(SystemClock.elapsedRealtime() - l)));
    pJ();
    AppMethodBeat.o(80744);
    return paramBitmap;
  }
  
  public final d XE(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(80743);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      ab.e("MicroMsg.scanner.DecodeFile", "in decodeFile, file == null");
      AppMethodBeat.o(80743);
      return null;
    }
    BitmapFactory.Options localOptions = com.tencent.mm.sdk.platformtools.d.aoT(paramString);
    if (localOptions != null)
    {
      localOptions.inJustDecodeBounds = false;
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      if (localOptions.outWidth * localOptions.outHeight * 8 * 4L > 268435456L)
      {
        ab.i("MicroMsg.scanner.DecodeFile", "initial width %d, initial height %d", new Object[] { Integer.valueOf(localOptions.outWidth), Integer.valueOf(localOptions.outHeight) });
        localOptions.inSampleSize = 4;
      }
    }
    if (!this.mCancelled)
    {
      localObject1 = localObject2;
      try
      {
        paramString = com.tencent.mm.sdk.platformtools.d.decodeFile(paramString, localOptions);
        if (paramString == null)
        {
          localObject1 = localObject2;
          ab.e("MicroMsg.scanner.DecodeFile", "decode bitmap is null!");
          AppMethodBeat.o(80743);
          return null;
        }
        localObject1 = localObject2;
        paramString = N(paramString);
        if (paramString == null) {}
        for (boolean bool = true;; bool = false)
        {
          localObject1 = paramString;
          ab.d("MicroMsg.scanner.DecodeFile", "decode result==null:%b", new Object[] { Boolean.valueOf(bool) });
          localObject1 = paramString;
          if (paramString == null) {
            break;
          }
          localObject1 = paramString;
          bool = bo.isNullOrNil(paramString.result);
          localObject1 = paramString;
          if (bool) {
            break;
          }
          AppMethodBeat.o(80743);
          return paramString;
        }
        AppMethodBeat.o(80743);
      }
      catch (OutOfMemoryError paramString)
      {
        ab.e("MicroMsg.scanner.DecodeFile", "OutOfMemoryError, e: %s", new Object[] { paramString.getMessage() });
      }
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.u.a.a
 * JD-Core Version:    0.7.0.1
 */