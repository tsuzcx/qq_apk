package com.tencent.mm.wexnet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/wexnet/XNetLibLoaderHelper;", "", "()V", "TAG", "", "markLoaded", "", "loadLib", "loadLibInner", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c agWk;
  private static boolean agWl;
  
  static
  {
    AppMethodBeat.i(231570);
    agWk = new c();
    AppMethodBeat.o(231570);
  }
  
  /* Error */
  private final boolean jPN()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: aload_0
    //   4: monitorenter
    //   5: ldc 47
    //   7: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: getstatic 49	com/tencent/mm/wexnet/c:agWl	Z
    //   13: ifeq +13 -> 26
    //   16: ldc 47
    //   18: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: iload 6
    //   25: ireturn
    //   26: getstatic 55	com/tencent/mm/wexnet/d:agWm	Lcom/tencent/mm/wexnet/d;
    //   29: astore 8
    //   31: invokestatic 58	com/tencent/mm/wexnet/d:jPO	()Z
    //   34: istore 7
    //   36: iload 7
    //   38: ifeq +176 -> 214
    //   41: getstatic 64	com/tencent/mm/wexnet/b:agWj	Lcom/tencent/mm/wexnet/b$a;
    //   44: astore 8
    //   46: new 66	com/tencent/mm/vfs/u
    //   49: dup
    //   50: invokestatic 72	com/tencent/mm/wexnet/b$a:jPJ	()Ljava/lang/String;
    //   53: invokespecial 75	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   56: invokevirtual 78	com/tencent/mm/vfs/u:jKV	()Z
    //   59: ifeq +15 -> 74
    //   62: getstatic 64	com/tencent/mm/wexnet/b:agWj	Lcom/tencent/mm/wexnet/b$a;
    //   65: astore 8
    //   67: invokestatic 72	com/tencent/mm/wexnet/b$a:jPJ	()Ljava/lang/String;
    //   70: invokestatic 84	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   73: pop
    //   74: getstatic 64	com/tencent/mm/wexnet/b:agWj	Lcom/tencent/mm/wexnet/b$a;
    //   77: astore 8
    //   79: new 66	com/tencent/mm/vfs/u
    //   82: dup
    //   83: invokestatic 72	com/tencent/mm/wexnet/b$a:jPJ	()Ljava/lang/String;
    //   86: invokespecial 75	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   89: invokevirtual 87	com/tencent/mm/vfs/u:jKS	()Z
    //   92: ifne +15 -> 107
    //   95: getstatic 64	com/tencent/mm/wexnet/b:agWj	Lcom/tencent/mm/wexnet/b$a;
    //   98: astore 8
    //   100: invokestatic 72	com/tencent/mm/wexnet/b$a:jPJ	()Ljava/lang/String;
    //   103: invokestatic 90	com/tencent/mm/vfs/y:bDX	(Ljava/lang/String;)Z
    //   106: pop
    //   107: getstatic 64	com/tencent/mm/wexnet/b:agWj	Lcom/tencent/mm/wexnet/b$a;
    //   110: astore 8
    //   112: invokestatic 93	com/tencent/mm/wexnet/b$a:jPI	()Ljava/lang/String;
    //   115: iconst_1
    //   116: invokestatic 97	com/tencent/mm/vfs/y:ew	(Ljava/lang/String;Z)Z
    //   119: pop
    //   120: getstatic 64	com/tencent/mm/wexnet/b:agWj	Lcom/tencent/mm/wexnet/b$a;
    //   123: astore 8
    //   125: invokestatic 72	com/tencent/mm/wexnet/b$a:jPJ	()Ljava/lang/String;
    //   128: invokestatic 101	com/tencent/mm/vfs/y:bEo	(Ljava/lang/String;)Ljava/lang/String;
    //   131: astore 8
    //   133: getstatic 64	com/tencent/mm/wexnet/b:agWj	Lcom/tencent/mm/wexnet/b$a;
    //   136: astore 9
    //   138: aload 8
    //   140: invokestatic 93	com/tencent/mm/wexnet/b$a:jPI	()Ljava/lang/String;
    //   143: invokestatic 105	com/tencent/mm/vfs/y:qo	(Ljava/lang/String;Ljava/lang/String;)Z
    //   146: pop
    //   147: new 107	java/lang/StringBuilder
    //   150: dup
    //   151: ldc 109
    //   153: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   156: iload 7
    //   158: invokevirtual 114	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   161: ldc 116
    //   163: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: astore 8
    //   168: getstatic 64	com/tencent/mm/wexnet/b:agWj	Lcom/tencent/mm/wexnet/b$a;
    //   171: astore 9
    //   173: aload 8
    //   175: invokestatic 72	com/tencent/mm/wexnet/b$a:jPJ	()Ljava/lang/String;
    //   178: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: ldc 121
    //   183: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: astore 8
    //   188: getstatic 64	com/tencent/mm/wexnet/b:agWj	Lcom/tencent/mm/wexnet/b$a;
    //   191: astore 9
    //   193: ldc 123
    //   195: aload 8
    //   197: invokestatic 93	com/tencent/mm/wexnet/b$a:jPI	()Ljava/lang/String;
    //   200: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: bipush 93
    //   205: invokevirtual 126	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   208: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokestatic 134	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   214: iload 7
    //   216: ifeq +148 -> 364
    //   219: getstatic 64	com/tencent/mm/wexnet/b:agWj	Lcom/tencent/mm/wexnet/b$a;
    //   222: astore 8
    //   224: invokestatic 93	com/tencent/mm/wexnet/b$a:jPI	()Ljava/lang/String;
    //   227: astore 8
    //   229: ldc 123
    //   231: new 107	java/lang/StringBuilder
    //   234: dup
    //   235: ldc 136
    //   237: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   240: aload 8
    //   242: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: bipush 93
    //   247: invokevirtual 126	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   250: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: invokestatic 134	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   256: new 66	com/tencent/mm/vfs/u
    //   259: dup
    //   260: aload 8
    //   262: invokespecial 75	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   265: invokevirtual 139	com/tencent/mm/vfs/u:isDirectory	()Z
    //   268: ifne +10 -> 278
    //   271: aload 8
    //   273: iconst_1
    //   274: invokestatic 97	com/tencent/mm/vfs/y:ew	(Ljava/lang/String;Z)Z
    //   277: pop
    //   278: aload 8
    //   280: invokestatic 142	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   283: ifne +9 -> 292
    //   286: aload 8
    //   288: invokestatic 90	com/tencent/mm/vfs/y:bDX	(Ljava/lang/String;)Z
    //   291: pop
    //   292: new 66	com/tencent/mm/vfs/u
    //   295: dup
    //   296: aload 8
    //   298: invokespecial 75	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   301: invokevirtual 146	com/tencent/mm/vfs/u:jKX	()[Lcom/tencent/mm/vfs/u;
    //   304: astore 10
    //   306: aload 10
    //   308: ifnull +512 -> 820
    //   311: aload 10
    //   313: arraylength
    //   314: ifne +501 -> 815
    //   317: iconst_1
    //   318: istore_1
    //   319: goto +487 -> 806
    //   322: iload_1
    //   323: ifne +54 -> 377
    //   326: ldc 123
    //   328: new 107	java/lang/StringBuilder
    //   331: dup
    //   332: ldc 148
    //   334: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   337: aload 8
    //   339: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: ldc 150
    //   344: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: invokestatic 134	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   353: ldc 47
    //   355: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   358: iconst_0
    //   359: istore 6
    //   361: goto -340 -> 21
    //   364: getstatic 64	com/tencent/mm/wexnet/b:agWj	Lcom/tencent/mm/wexnet/b$a;
    //   367: astore 8
    //   369: invokestatic 153	com/tencent/mm/wexnet/b$a:jPK	()Ljava/lang/String;
    //   372: astore 8
    //   374: goto -145 -> 229
    //   377: aload 10
    //   379: arraylength
    //   380: istore 4
    //   382: iconst_0
    //   383: istore_1
    //   384: iload_1
    //   385: iload 4
    //   387: if_icmpge +359 -> 746
    //   390: aload 10
    //   392: iload_1
    //   393: aaload
    //   394: astore 8
    //   396: aload 8
    //   398: invokevirtual 139	com/tencent/mm/vfs/u:isDirectory	()Z
    //   401: ifeq +446 -> 847
    //   404: aload 8
    //   406: invokevirtual 146	com/tencent/mm/vfs/u:jKX	()[Lcom/tencent/mm/vfs/u;
    //   409: astore 12
    //   411: aload 12
    //   413: ifnull +434 -> 847
    //   416: aload 12
    //   418: arraylength
    //   419: istore 5
    //   421: iconst_0
    //   422: istore_2
    //   423: iload_2
    //   424: iload 5
    //   426: if_icmpge +421 -> 847
    //   429: aload 12
    //   431: iload_2
    //   432: aaload
    //   433: astore 11
    //   435: aload 11
    //   437: invokevirtual 78	com/tencent/mm/vfs/u:jKV	()Z
    //   440: ifeq +400 -> 840
    //   443: aload 11
    //   445: getfield 157	com/tencent/mm/vfs/u:mUri	Landroid/net/Uri;
    //   448: invokestatic 163	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   451: invokestatic 166	com/tencent/mm/vfs/y:bub	(Ljava/lang/String;)Ljava/lang/String;
    //   454: astore 8
    //   456: new 107	java/lang/StringBuilder
    //   459: dup
    //   460: ldc 168
    //   462: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   465: astore 13
    //   467: aload 8
    //   469: ifnonnull +163 -> 632
    //   472: ldc 169
    //   474: astore 9
    //   476: ldc 123
    //   478: aload 13
    //   480: aload 9
    //   482: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: bipush 93
    //   487: invokevirtual 126	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   490: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: invokestatic 134	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   496: aload 8
    //   498: ifnull +141 -> 639
    //   501: getstatic 64	com/tencent/mm/wexnet/b:agWj	Lcom/tencent/mm/wexnet/b$a;
    //   504: astore 9
    //   506: aload 8
    //   508: invokestatic 172	com/tencent/mm/wexnet/b$a:jPL	()Ljava/lang/String;
    //   511: invokevirtual 178	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   514: iconst_1
    //   515: if_icmpne +124 -> 639
    //   518: iconst_1
    //   519: istore_3
    //   520: goto +305 -> 825
    //   523: getstatic 184	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   526: ldc2_w 185
    //   529: lconst_0
    //   530: lconst_1
    //   531: iconst_1
    //   532: invokevirtual 190	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   535: aload 11
    //   537: invokevirtual 194	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   540: invokestatic 163	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   543: invokestatic 199	java/lang/System:load	(Ljava/lang/String;)V
    //   546: new 107	java/lang/StringBuilder
    //   549: dup
    //   550: ldc 201
    //   552: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   555: aload 11
    //   557: invokevirtual 205	com/tencent/mm/vfs/u:jKU	()Lcom/tencent/mm/vfs/u;
    //   560: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   563: ldc 210
    //   565: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: astore 9
    //   570: aload 8
    //   572: ifnonnull +265 -> 837
    //   575: ldc 169
    //   577: astore 8
    //   579: ldc 123
    //   581: aload 9
    //   583: aload 8
    //   585: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: bipush 93
    //   590: invokevirtual 126	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   593: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   596: invokestatic 134	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   599: iconst_1
    //   600: putstatic 49	com/tencent/mm/wexnet/c:agWl	Z
    //   603: getstatic 184	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   606: ldc2_w 185
    //   609: ldc2_w 211
    //   612: lconst_1
    //   613: iconst_1
    //   614: invokevirtual 190	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   617: ldc 47
    //   619: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   622: goto -601 -> 21
    //   625: astore 8
    //   627: aload_0
    //   628: monitorexit
    //   629: aload 8
    //   631: athrow
    //   632: aload 8
    //   634: astore 9
    //   636: goto -160 -> 476
    //   639: iconst_0
    //   640: istore_3
    //   641: goto +184 -> 825
    //   644: astore 10
    //   646: new 107	java/lang/StringBuilder
    //   649: dup
    //   650: ldc 214
    //   652: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   655: aload 11
    //   657: invokevirtual 205	com/tencent/mm/vfs/u:jKU	()Lcom/tencent/mm/vfs/u;
    //   660: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   663: ldc 210
    //   665: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: astore 11
    //   670: aload 8
    //   672: astore 9
    //   674: aload 8
    //   676: ifnonnull +7 -> 683
    //   679: ldc 169
    //   681: astore 9
    //   683: ldc 123
    //   685: aload 11
    //   687: aload 9
    //   689: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: bipush 93
    //   694: invokevirtual 126	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   697: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   700: invokestatic 134	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   703: ldc 123
    //   705: aload 10
    //   707: ldc 169
    //   709: iconst_1
    //   710: anewarray 4	java/lang/Object
    //   713: dup
    //   714: iconst_0
    //   715: ldc 169
    //   717: aastore
    //   718: invokestatic 218	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   721: getstatic 184	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   724: ldc2_w 185
    //   727: ldc2_w 219
    //   730: lconst_1
    //   731: iconst_1
    //   732: invokevirtual 190	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   735: ldc 47
    //   737: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   740: iconst_0
    //   741: istore 6
    //   743: goto -722 -> 21
    //   746: getstatic 184	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   749: ldc2_w 185
    //   752: lconst_1
    //   753: lconst_1
    //   754: iconst_1
    //   755: invokevirtual 190	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   758: new 107	java/lang/StringBuilder
    //   761: dup
    //   762: ldc 222
    //   764: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   767: astore 8
    //   769: getstatic 64	com/tencent/mm/wexnet/b:agWj	Lcom/tencent/mm/wexnet/b$a;
    //   772: astore 9
    //   774: ldc 123
    //   776: aload 8
    //   778: invokestatic 172	com/tencent/mm/wexnet/b$a:jPL	()Ljava/lang/String;
    //   781: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   784: bipush 93
    //   786: invokevirtual 126	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   789: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   792: invokestatic 134	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   795: ldc 47
    //   797: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   800: iconst_0
    //   801: istore 6
    //   803: goto -782 -> 21
    //   806: iload_1
    //   807: ifne +13 -> 820
    //   810: iconst_1
    //   811: istore_1
    //   812: goto -490 -> 322
    //   815: iconst_0
    //   816: istore_1
    //   817: goto -11 -> 806
    //   820: iconst_0
    //   821: istore_1
    //   822: goto -500 -> 322
    //   825: iload_3
    //   826: ifne -303 -> 523
    //   829: iload 7
    //   831: ifeq +9 -> 840
    //   834: goto -311 -> 523
    //   837: goto -258 -> 579
    //   840: iload_2
    //   841: iconst_1
    //   842: iadd
    //   843: istore_2
    //   844: goto -421 -> 423
    //   847: iload_1
    //   848: iconst_1
    //   849: iadd
    //   850: istore_1
    //   851: goto -467 -> 384
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	854	0	this	c
    //   318	533	1	i	int
    //   422	422	2	j	int
    //   519	307	3	k	int
    //   380	8	4	m	int
    //   419	8	5	n	int
    //   1	801	6	bool1	boolean
    //   34	796	7	bool2	boolean
    //   29	555	8	localObject1	Object
    //   625	50	8	localObject2	Object
    //   767	10	8	localStringBuilder1	java.lang.StringBuilder
    //   136	637	9	localObject3	Object
    //   304	87	10	arrayOfu1	com.tencent.mm.vfs.u[]
    //   644	62	10	localThrowable	java.lang.Throwable
    //   433	253	11	localObject4	Object
    //   409	21	12	arrayOfu2	com.tencent.mm.vfs.u[]
    //   465	14	13	localStringBuilder2	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   5	21	625	finally
    //   26	36	625	finally
    //   41	74	625	finally
    //   74	107	625	finally
    //   107	214	625	finally
    //   219	229	625	finally
    //   229	278	625	finally
    //   278	292	625	finally
    //   292	306	625	finally
    //   311	317	625	finally
    //   326	358	625	finally
    //   364	374	625	finally
    //   377	382	625	finally
    //   396	411	625	finally
    //   416	421	625	finally
    //   435	467	625	finally
    //   476	496	625	finally
    //   501	518	625	finally
    //   523	535	625	finally
    //   546	570	625	finally
    //   579	622	625	finally
    //   646	670	625	finally
    //   683	740	625	finally
    //   746	800	625	finally
    //   535	546	644	finally
  }
  
  public final boolean jPM()
  {
    AppMethodBeat.i(231579);
    if (jPN())
    {
      AppMethodBeat.o(231579);
      return true;
    }
    Log.i("MicroMsg.XNET.XNetLibLoaderHelper", "loadLib fail, try check so resource update");
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, null, a.class, null);
    AppMethodBeat.o(231579);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.wexnet.c
 * JD-Core Version:    0.7.0.1
 */