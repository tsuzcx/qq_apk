package com.tencent.mm.plugin.readerapp.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e;
import com.tencent.mm.al.f.c;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.model.bo;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storagebase.h;
import java.util.Iterator;
import java.util.List;

public final class c
  implements e
{
  private long uVB = 0L;
  
  public static boolean dfx()
  {
    AppMethodBeat.i(102663);
    if ((u.aqM() & 0x400) == 0)
    {
      AppMethodBeat.o(102663);
      return true;
    }
    AppMethodBeat.o(102663);
    return false;
  }
  
  public final int aae()
  {
    return 12399999;
  }
  
  /* Error */
  public final com.tencent.mm.al.f.b b(com.tencent.mm.al.f.a parama)
  {
    // Byte code:
    //   0: ldc 40
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: getfield 46	com/tencent/mm/al/f$a:fTo	Lcom/tencent/mm/protocal/protobuf/cs;
    //   9: astore 19
    //   11: aload_1
    //   12: getfield 50	com/tencent/mm/al/f$a:gVl	Ljava/lang/Object;
    //   15: ifnonnull +60 -> 75
    //   18: new 52	java/lang/StringBuilder
    //   21: dup
    //   22: ldc 54
    //   24: invokespecial 57	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   27: invokestatic 63	java/lang/System:currentTimeMillis	()J
    //   30: ldc2_w 64
    //   33: ldiv
    //   34: invokevirtual 69	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   37: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: astore_1
    //   41: ldc 75
    //   43: ldc 77
    //   45: iconst_1
    //   46: anewarray 4	java/lang/Object
    //   49: dup
    //   50: iconst_0
    //   51: aload_1
    //   52: aastore
    //   53: invokestatic 83	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   56: aload 19
    //   58: ifnonnull +31 -> 89
    //   61: ldc 75
    //   63: ldc 85
    //   65: invokestatic 89	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: ldc 40
    //   70: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: aconst_null
    //   74: areturn
    //   75: aload_1
    //   76: getfield 50	com/tencent/mm/al/f$a:gVl	Ljava/lang/Object;
    //   79: checkcast 91	com/tencent/mm/al/e$b
    //   82: getfield 95	com/tencent/mm/al/e$b:gVf	Ljava/lang/String;
    //   85: astore_1
    //   86: goto -30 -> 56
    //   89: getstatic 101	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
    //   92: sipush 13440
    //   95: iconst_1
    //   96: anewarray 4	java/lang/Object
    //   99: dup
    //   100: iconst_0
    //   101: iconst_1
    //   102: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   105: aastore
    //   106: invokevirtual 111	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   109: invokestatic 117	com/tencent/mm/plugin/readerapp/c/g:dfz	()Lcom/tencent/mm/model/bp;
    //   112: astore 14
    //   114: new 52	java/lang/StringBuilder
    //   117: dup
    //   118: ldc 119
    //   120: invokespecial 57	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   123: bipush 20
    //   125: invokestatic 125	com/tencent/mm/model/bp:nm	(I)Ljava/lang/String;
    //   128: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: ldc 130
    //   133: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload_1
    //   137: invokestatic 136	com/tencent/mm/storagebase/h:qj	(Ljava/lang/String;)Ljava/lang/String;
    //   140: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: astore 15
    //   148: ldc 138
    //   150: ldc 140
    //   152: iconst_1
    //   153: anewarray 4	java/lang/Object
    //   156: dup
    //   157: iconst_0
    //   158: aload 15
    //   160: aastore
    //   161: invokestatic 143	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   164: aload 14
    //   166: getfield 147	com/tencent/mm/model/bp:gPa	Lcom/tencent/mm/storagebase/h;
    //   169: bipush 20
    //   171: invokestatic 125	com/tencent/mm/model/bp:nm	(I)Ljava/lang/String;
    //   174: aload 15
    //   176: invokevirtual 151	com/tencent/mm/storagebase/h:execSQL	(Ljava/lang/String;Ljava/lang/String;)Z
    //   179: ifeq +8 -> 187
    //   182: aload 14
    //   184: invokevirtual 154	com/tencent/mm/model/bp:doNotify	()V
    //   187: aload 19
    //   189: getfield 160	com/tencent/mm/protocal/protobuf/cs:Cxz	Lcom/tencent/mm/protocal/protobuf/cmf;
    //   192: invokestatic 166	com/tencent/mm/platformtools/z:a	(Lcom/tencent/mm/protocal/protobuf/cmf;)Ljava/lang/String;
    //   195: astore 14
    //   197: aload 19
    //   199: getfield 170	com/tencent/mm/protocal/protobuf/cs:CreateTime	I
    //   202: i2l
    //   203: ldc2_w 64
    //   206: lmul
    //   207: lstore 11
    //   209: lload 11
    //   211: aload_0
    //   212: getfield 14	com/tencent/mm/plugin/readerapp/c/c:uVB	J
    //   215: lcmp
    //   216: ifgt +3062 -> 3278
    //   219: aload_0
    //   220: getfield 14	com/tencent/mm/plugin/readerapp/c/c:uVB	J
    //   223: lconst_1
    //   224: ladd
    //   225: lstore 11
    //   227: aload_0
    //   228: lload 11
    //   230: putfield 14	com/tencent/mm/plugin/readerapp/c/c:uVB	J
    //   233: ldc 75
    //   235: ldc 172
    //   237: iconst_2
    //   238: anewarray 4	java/lang/Object
    //   241: dup
    //   242: iconst_0
    //   243: aload 19
    //   245: getfield 170	com/tencent/mm/protocal/protobuf/cs:CreateTime	I
    //   248: i2l
    //   249: ldc2_w 64
    //   252: lmul
    //   253: invokestatic 177	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   256: aastore
    //   257: dup
    //   258: iconst_1
    //   259: lload 11
    //   261: invokestatic 177	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   264: aastore
    //   265: invokestatic 179	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   268: new 181	java/text/SimpleDateFormat
    //   271: dup
    //   272: ldc 183
    //   274: invokespecial 184	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   277: astore 20
    //   279: iconst_0
    //   280: istore_2
    //   281: new 186	java/util/ArrayList
    //   284: dup
    //   285: invokespecial 187	java/util/ArrayList:<init>	()V
    //   288: astore 18
    //   290: iconst_0
    //   291: istore 4
    //   293: iload 4
    //   295: istore 5
    //   297: iload_2
    //   298: istore_3
    //   299: aload 14
    //   301: ldc 189
    //   303: invokestatic 195	com/tencent/mm/sdk/platformtools/bw:K	(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
    //   306: astore 21
    //   308: aload 21
    //   310: ifnonnull +10 -> 320
    //   313: ldc 40
    //   315: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   318: aconst_null
    //   319: areturn
    //   320: iload 4
    //   322: istore 5
    //   324: iload_2
    //   325: istore_3
    //   326: ldc 75
    //   328: ldc 197
    //   330: iconst_1
    //   331: anewarray 4	java/lang/Object
    //   334: dup
    //   335: iconst_0
    //   336: aload 14
    //   338: aastore
    //   339: invokestatic 143	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   342: iconst_0
    //   343: istore_2
    //   344: iconst_0
    //   345: istore_3
    //   346: iload_2
    //   347: ifgt +2475 -> 2822
    //   350: new 52	java/lang/StringBuilder
    //   353: dup
    //   354: ldc 199
    //   356: invokespecial 57	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   359: astore 15
    //   361: iload_2
    //   362: ifle +906 -> 1268
    //   365: iload_2
    //   366: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   369: astore 14
    //   371: aload 15
    //   373: aload 14
    //   375: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   378: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: astore 14
    //   383: aload 21
    //   385: new 52	java/lang/StringBuilder
    //   388: dup
    //   389: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   392: aload 14
    //   394: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: ldc 205
    //   399: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokeinterface 211 2 0
    //   410: checkcast 213	java/lang/String
    //   413: iconst_0
    //   414: invokestatic 219	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
    //   417: istore 4
    //   419: aload 21
    //   421: new 52	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   428: aload 14
    //   430: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: ldc 221
    //   435: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   441: invokeinterface 211 2 0
    //   446: checkcast 213	java/lang/String
    //   449: iconst_m1
    //   450: invokestatic 219	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
    //   453: istore 8
    //   455: aload 21
    //   457: new 52	java/lang/StringBuilder
    //   460: dup
    //   461: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   464: aload 14
    //   466: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: ldc 223
    //   471: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   477: invokeinterface 211 2 0
    //   482: checkcast 213	java/lang/String
    //   485: astore 22
    //   487: iload 4
    //   489: ifne +787 -> 1276
    //   492: ldc 75
    //   494: new 52	java/lang/StringBuilder
    //   497: dup
    //   498: ldc 225
    //   500: invokespecial 57	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   503: aload 14
    //   505: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: ldc 227
    //   510: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   516: invokestatic 89	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   519: iload_3
    //   520: istore 4
    //   522: iload_2
    //   523: istore_3
    //   524: iload 4
    //   526: istore_2
    //   527: invokestatic 229	com/tencent/mm/plugin/readerapp/c/c:dfx	()Z
    //   530: istore 13
    //   532: ldc 75
    //   534: new 52	java/lang/StringBuilder
    //   537: dup
    //   538: ldc 231
    //   540: invokespecial 57	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   543: iload_2
    //   544: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   547: ldc 236
    //   549: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: iload 13
    //   554: invokevirtual 239	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   557: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   560: invokestatic 241	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   563: aload 18
    //   565: invokeinterface 247 1 0
    //   570: astore_1
    //   571: aload_1
    //   572: invokeinterface 252 1 0
    //   577: ifeq +2695 -> 3272
    //   580: aload_1
    //   581: invokeinterface 256 1 0
    //   586: checkcast 258	com/tencent/mm/model/bo
    //   589: astore 14
    //   591: aload 14
    //   593: invokevirtual 261	com/tencent/mm/model/bo:getTitle	()Ljava/lang/String;
    //   596: invokestatic 265	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   599: ifeq +2234 -> 2833
    //   602: ldc 75
    //   604: new 52	java/lang/StringBuilder
    //   607: dup
    //   608: ldc_w 267
    //   611: invokespecial 57	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   614: aload 14
    //   616: invokevirtual 270	com/tencent/mm/model/bo:asq	()Ljava/lang/String;
    //   619: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: ldc_w 272
    //   625: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: aload 14
    //   630: getfield 275	com/tencent/mm/model/bo:type	I
    //   633: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   636: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   639: invokestatic 89	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   642: iconst_0
    //   643: istore 4
    //   645: aload 18
    //   647: invokeinterface 278 1 0
    //   652: ifle +2590 -> 3242
    //   655: iload 4
    //   657: ifeq +2585 -> 3242
    //   660: iconst_0
    //   661: istore 5
    //   663: aconst_null
    //   664: astore_1
    //   665: iconst_0
    //   666: istore 4
    //   668: iload 4
    //   670: aload 18
    //   672: invokeinterface 278 1 0
    //   677: if_icmpge +2239 -> 2916
    //   680: invokestatic 117	com/tencent/mm/plugin/readerapp/c/g:dfz	()Lcom/tencent/mm/model/bp;
    //   683: astore 15
    //   685: aload 18
    //   687: iload 4
    //   689: invokeinterface 281 2 0
    //   694: checkcast 258	com/tencent/mm/model/bo
    //   697: astore 16
    //   699: aload 16
    //   701: ifnull +2209 -> 2910
    //   704: aload 16
    //   706: iconst_m1
    //   707: putfield 284	com/tencent/mm/model/bo:dtM	I
    //   710: new 286	android/content/ContentValues
    //   713: dup
    //   714: invokespecial 287	android/content/ContentValues:<init>	()V
    //   717: astore 17
    //   719: aload 16
    //   721: getfield 284	com/tencent/mm/model/bo:dtM	I
    //   724: iconst_1
    //   725: iand
    //   726: ifeq +16 -> 742
    //   729: aload 17
    //   731: ldc_w 289
    //   734: aload 16
    //   736: invokevirtual 270	com/tencent/mm/model/bo:asq	()Ljava/lang/String;
    //   739: invokevirtual 292	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   742: aload 16
    //   744: getfield 284	com/tencent/mm/model/bo:dtM	I
    //   747: iconst_2
    //   748: iand
    //   749: ifeq +19 -> 768
    //   752: aload 17
    //   754: ldc_w 294
    //   757: aload 16
    //   759: getfield 296	com/tencent/mm/model/bo:time	J
    //   762: invokestatic 177	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   765: invokevirtual 299	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   768: aload 16
    //   770: getfield 284	com/tencent/mm/model/bo:dtM	I
    //   773: iconst_4
    //   774: iand
    //   775: ifeq +19 -> 794
    //   778: aload 17
    //   780: ldc_w 300
    //   783: aload 16
    //   785: getfield 275	com/tencent/mm/model/bo:type	I
    //   788: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   791: invokevirtual 303	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   794: aload 16
    //   796: getfield 284	com/tencent/mm/model/bo:dtM	I
    //   799: bipush 8
    //   801: iand
    //   802: ifeq +16 -> 818
    //   805: aload 17
    //   807: ldc_w 305
    //   810: aload 16
    //   812: invokevirtual 308	com/tencent/mm/model/bo:getName	()Ljava/lang/String;
    //   815: invokevirtual 292	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   818: aload 16
    //   820: getfield 284	com/tencent/mm/model/bo:dtM	I
    //   823: bipush 16
    //   825: iand
    //   826: ifeq +16 -> 842
    //   829: aload 17
    //   831: ldc_w 310
    //   834: aload 16
    //   836: invokevirtual 261	com/tencent/mm/model/bo:getTitle	()Ljava/lang/String;
    //   839: invokevirtual 292	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   842: aload 16
    //   844: getfield 284	com/tencent/mm/model/bo:dtM	I
    //   847: bipush 32
    //   849: iand
    //   850: ifeq +16 -> 866
    //   853: aload 17
    //   855: ldc_w 312
    //   858: aload 16
    //   860: invokevirtual 315	com/tencent/mm/model/bo:getUrl	()Ljava/lang/String;
    //   863: invokevirtual 292	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   866: aload 16
    //   868: getfield 284	com/tencent/mm/model/bo:dtM	I
    //   871: bipush 64
    //   873: iand
    //   874: ifeq +16 -> 890
    //   877: aload 17
    //   879: ldc_w 317
    //   882: aload 16
    //   884: invokevirtual 320	com/tencent/mm/model/bo:asr	()Ljava/lang/String;
    //   887: invokevirtual 292	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   890: aload 16
    //   892: getfield 284	com/tencent/mm/model/bo:dtM	I
    //   895: sipush 128
    //   898: iand
    //   899: ifeq +26 -> 925
    //   902: aload 16
    //   904: getfield 323	com/tencent/mm/model/bo:gOO	Ljava/lang/String;
    //   907: ifnonnull +1983 -> 2890
    //   910: ldc_w 325
    //   913: astore 14
    //   915: aload 17
    //   917: ldc_w 327
    //   920: aload 14
    //   922: invokevirtual 292	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   925: aload 16
    //   927: getfield 284	com/tencent/mm/model/bo:dtM	I
    //   930: sipush 256
    //   933: iand
    //   934: ifeq +19 -> 953
    //   937: aload 17
    //   939: ldc_w 329
    //   942: aload 16
    //   944: getfield 332	com/tencent/mm/model/bo:gOP	J
    //   947: invokestatic 177	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   950: invokevirtual 299	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   953: aload 16
    //   955: getfield 284	com/tencent/mm/model/bo:dtM	I
    //   958: sipush 512
    //   961: iand
    //   962: ifeq +16 -> 978
    //   965: aload 17
    //   967: ldc_w 334
    //   970: aload 16
    //   972: invokevirtual 337	com/tencent/mm/model/bo:ass	()Ljava/lang/String;
    //   975: invokevirtual 292	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   978: aload 16
    //   980: getfield 284	com/tencent/mm/model/bo:dtM	I
    //   983: sipush 1024
    //   986: iand
    //   987: ifeq +16 -> 1003
    //   990: aload 17
    //   992: ldc_w 339
    //   995: aload 16
    //   997: invokevirtual 342	com/tencent/mm/model/bo:ast	()Ljava/lang/String;
    //   1000: invokevirtual 292	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1003: aload 16
    //   1005: getfield 284	com/tencent/mm/model/bo:dtM	I
    //   1008: sipush 2048
    //   1011: iand
    //   1012: ifeq +19 -> 1031
    //   1015: aload 17
    //   1017: ldc_w 344
    //   1020: aload 16
    //   1022: getfield 347	com/tencent/mm/model/bo:gOS	I
    //   1025: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1028: invokevirtual 303	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1031: aload 16
    //   1033: getfield 284	com/tencent/mm/model/bo:dtM	I
    //   1036: sipush 4096
    //   1039: iand
    //   1040: ifeq +16 -> 1056
    //   1043: aload 17
    //   1045: ldc_w 349
    //   1048: aload 16
    //   1050: invokevirtual 352	com/tencent/mm/model/bo:asu	()Ljava/lang/String;
    //   1053: invokevirtual 292	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1056: aload 16
    //   1058: getfield 284	com/tencent/mm/model/bo:dtM	I
    //   1061: sipush 8192
    //   1064: iand
    //   1065: ifeq +16 -> 1081
    //   1068: aload 17
    //   1070: ldc_w 354
    //   1073: aload 16
    //   1075: invokevirtual 357	com/tencent/mm/model/bo:getDigest	()Ljava/lang/String;
    //   1078: invokevirtual 292	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1081: aload 16
    //   1083: getfield 284	com/tencent/mm/model/bo:dtM	I
    //   1086: sipush 16384
    //   1089: iand
    //   1090: ifeq +19 -> 1109
    //   1093: aload 17
    //   1095: ldc_w 359
    //   1098: aload 16
    //   1100: getfield 362	com/tencent/mm/model/bo:gOT	I
    //   1103: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1106: invokevirtual 303	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1109: aload 16
    //   1111: getfield 284	com/tencent/mm/model/bo:dtM	I
    //   1114: ldc_w 363
    //   1117: iand
    //   1118: ifeq +19 -> 1137
    //   1121: aload 17
    //   1123: ldc_w 365
    //   1126: aload 16
    //   1128: getfield 368	com/tencent/mm/model/bo:gOU	J
    //   1131: invokestatic 177	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1134: invokevirtual 299	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   1137: aload 16
    //   1139: getfield 284	com/tencent/mm/model/bo:dtM	I
    //   1142: ldc_w 369
    //   1145: iand
    //   1146: ifeq +26 -> 1172
    //   1149: aload 16
    //   1151: getfield 372	com/tencent/mm/model/bo:gOV	Ljava/lang/String;
    //   1154: ifnonnull +1746 -> 2900
    //   1157: ldc_w 325
    //   1160: astore 14
    //   1162: aload 17
    //   1164: ldc_w 374
    //   1167: aload 14
    //   1169: invokevirtual 292	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1172: aload 16
    //   1174: getfield 284	com/tencent/mm/model/bo:dtM	I
    //   1177: ldc_w 375
    //   1180: iand
    //   1181: ifeq +16 -> 1197
    //   1184: aload 17
    //   1186: ldc_w 377
    //   1189: aload 16
    //   1191: invokevirtual 380	com/tencent/mm/model/bo:asv	()Ljava/lang/String;
    //   1194: invokevirtual 292	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1197: aload 15
    //   1199: getfield 147	com/tencent/mm/model/bp:gPa	Lcom/tencent/mm/storagebase/h;
    //   1202: aload 16
    //   1204: getfield 275	com/tencent/mm/model/bo:type	I
    //   1207: invokestatic 125	com/tencent/mm/model/bp:nm	(I)Ljava/lang/String;
    //   1210: ldc_w 289
    //   1213: aload 17
    //   1215: invokevirtual 383	com/tencent/mm/storagebase/h:a	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   1218: l2i
    //   1219: iconst_m1
    //   1220: if_icmpeq +1690 -> 2910
    //   1223: iconst_1
    //   1224: istore 6
    //   1226: iload 6
    //   1228: ifeq +2041 -> 3269
    //   1231: aload_1
    //   1232: ifnonnull +2034 -> 3266
    //   1235: aload 18
    //   1237: iload 4
    //   1239: invokeinterface 281 2 0
    //   1244: checkcast 258	com/tencent/mm/model/bo
    //   1247: astore_1
    //   1248: aload_1
    //   1249: iconst_1
    //   1250: putfield 347	com/tencent/mm/model/bo:gOS	I
    //   1253: iload 5
    //   1255: iconst_1
    //   1256: iadd
    //   1257: istore 5
    //   1259: iload 4
    //   1261: iconst_1
    //   1262: iadd
    //   1263: istore 4
    //   1265: goto -597 -> 668
    //   1268: ldc_w 325
    //   1271: astore 14
    //   1273: goto -902 -> 371
    //   1276: iload 4
    //   1278: bipush 20
    //   1280: if_icmpeq +54 -> 1334
    //   1283: iload 4
    //   1285: bipush 11
    //   1287: if_icmpeq +47 -> 1334
    //   1290: ldc 75
    //   1292: new 52	java/lang/StringBuilder
    //   1295: dup
    //   1296: ldc 225
    //   1298: invokespecial 57	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1301: aload 14
    //   1303: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1306: ldc_w 385
    //   1309: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1312: iload 4
    //   1314: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1317: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1320: invokestatic 89	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1323: iload_2
    //   1324: istore 4
    //   1326: iload_3
    //   1327: istore_2
    //   1328: iload 4
    //   1330: istore_3
    //   1331: goto -804 -> 527
    //   1334: iload 4
    //   1336: istore 5
    //   1338: iload_2
    //   1339: istore_3
    //   1340: aload 21
    //   1342: new 52	java/lang/StringBuilder
    //   1345: dup
    //   1346: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1349: aload 14
    //   1351: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1354: ldc_w 387
    //   1357: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1360: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1363: invokeinterface 211 2 0
    //   1368: checkcast 213	java/lang/String
    //   1371: astore 23
    //   1373: iload 4
    //   1375: istore 5
    //   1377: iload_2
    //   1378: istore_3
    //   1379: aload 23
    //   1381: invokestatic 265	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   1384: ifeq +45 -> 1429
    //   1387: iload 4
    //   1389: istore 5
    //   1391: iload_2
    //   1392: istore_3
    //   1393: ldc 75
    //   1395: new 52	java/lang/StringBuilder
    //   1398: dup
    //   1399: ldc 225
    //   1401: invokespecial 57	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1404: aload 14
    //   1406: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1409: ldc_w 389
    //   1412: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1415: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1418: invokestatic 89	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1421: iload_2
    //   1422: istore_3
    //   1423: iload 4
    //   1425: istore_2
    //   1426: goto -899 -> 527
    //   1429: iload 4
    //   1431: istore 5
    //   1433: iload_2
    //   1434: istore_3
    //   1435: aload 21
    //   1437: new 52	java/lang/StringBuilder
    //   1440: dup
    //   1441: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1444: aload 14
    //   1446: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1449: ldc_w 391
    //   1452: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1455: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1458: invokeinterface 211 2 0
    //   1463: checkcast 213	java/lang/String
    //   1466: astore 24
    //   1468: iload 4
    //   1470: istore 5
    //   1472: iload_2
    //   1473: istore_3
    //   1474: aload 21
    //   1476: new 52	java/lang/StringBuilder
    //   1479: dup
    //   1480: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1483: aload 14
    //   1485: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1488: ldc_w 393
    //   1491: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1494: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1497: invokeinterface 211 2 0
    //   1502: checkcast 213	java/lang/String
    //   1505: astore 16
    //   1507: iload 4
    //   1509: istore 5
    //   1511: iload_2
    //   1512: istore_3
    //   1513: aload 21
    //   1515: new 52	java/lang/StringBuilder
    //   1518: dup
    //   1519: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1522: aload 14
    //   1524: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1527: ldc_w 395
    //   1530: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1533: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1536: invokeinterface 211 2 0
    //   1541: checkcast 213	java/lang/String
    //   1544: iconst_0
    //   1545: invokestatic 219	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
    //   1548: istore 9
    //   1550: iload 9
    //   1552: ifne +45 -> 1597
    //   1555: iload 4
    //   1557: istore 5
    //   1559: iload_2
    //   1560: istore_3
    //   1561: ldc 75
    //   1563: new 52	java/lang/StringBuilder
    //   1566: dup
    //   1567: ldc 225
    //   1569: invokespecial 57	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1572: aload 14
    //   1574: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1577: ldc_w 397
    //   1580: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1583: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1586: invokestatic 89	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1589: iload_2
    //   1590: istore_3
    //   1591: iload 4
    //   1593: istore_2
    //   1594: goto -1067 -> 527
    //   1597: iload 9
    //   1599: iconst_1
    //   1600: if_icmple +106 -> 1706
    //   1603: iload 4
    //   1605: istore 5
    //   1607: iload_2
    //   1608: istore_3
    //   1609: new 52	java/lang/StringBuilder
    //   1612: dup
    //   1613: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1616: aload 14
    //   1618: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1621: astore 15
    //   1623: iload 4
    //   1625: bipush 20
    //   1627: if_icmpne +71 -> 1698
    //   1630: ldc_w 399
    //   1633: astore 14
    //   1635: iload 4
    //   1637: istore 5
    //   1639: iload_2
    //   1640: istore_3
    //   1641: aload 15
    //   1643: aload 14
    //   1645: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1648: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1651: astore 14
    //   1653: iconst_1
    //   1654: iload 8
    //   1656: if_icmpne +1625 -> 3281
    //   1659: iload 9
    //   1661: iconst_2
    //   1662: if_icmpge +1619 -> 3281
    //   1665: iload 4
    //   1667: istore 5
    //   1669: iload_2
    //   1670: istore_3
    //   1671: ldc 75
    //   1673: ldc_w 401
    //   1676: iconst_1
    //   1677: anewarray 4	java/lang/Object
    //   1680: dup
    //   1681: iconst_0
    //   1682: iload 9
    //   1684: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1687: aastore
    //   1688: invokestatic 179	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1691: ldc 40
    //   1693: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1696: aconst_null
    //   1697: areturn
    //   1698: ldc_w 403
    //   1701: astore 14
    //   1703: goto -68 -> 1635
    //   1706: iload 4
    //   1708: istore 5
    //   1710: iload_2
    //   1711: istore_3
    //   1712: new 52	java/lang/StringBuilder
    //   1715: dup
    //   1716: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1719: aload 14
    //   1721: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1724: ldc_w 403
    //   1727: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1730: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1733: astore 14
    //   1735: goto -82 -> 1653
    //   1738: iload 6
    //   1740: iload 9
    //   1742: if_icmpge +1070 -> 2812
    //   1745: iload 4
    //   1747: istore 5
    //   1749: iload_2
    //   1750: istore_3
    //   1751: new 52	java/lang/StringBuilder
    //   1754: dup
    //   1755: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1758: aload 14
    //   1760: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1763: astore 17
    //   1765: iload 6
    //   1767: ifle +1520 -> 3287
    //   1770: iload 4
    //   1772: istore 5
    //   1774: iload_2
    //   1775: istore_3
    //   1776: iload 6
    //   1778: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1781: astore 15
    //   1783: iload 4
    //   1785: istore 5
    //   1787: iload_2
    //   1788: istore_3
    //   1789: aload 17
    //   1791: aload 15
    //   1793: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1796: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1799: astore 26
    //   1801: iload 4
    //   1803: istore 5
    //   1805: iload_2
    //   1806: istore_3
    //   1807: new 258	com/tencent/mm/model/bo
    //   1810: dup
    //   1811: invokespecial 404	com/tencent/mm/model/bo:<init>	()V
    //   1814: astore 25
    //   1816: iload 4
    //   1818: istore 5
    //   1820: iload_2
    //   1821: istore_3
    //   1822: aload 25
    //   1824: aload 19
    //   1826: getfield 407	com/tencent/mm/protocal/protobuf/cs:uKX	I
    //   1829: i2l
    //   1830: putfield 368	com/tencent/mm/model/bo:gOU	J
    //   1833: iload 4
    //   1835: istore 5
    //   1837: iload_2
    //   1838: istore_3
    //   1839: aload 25
    //   1841: aload 21
    //   1843: new 52	java/lang/StringBuilder
    //   1846: dup
    //   1847: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1850: aload 26
    //   1852: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1855: ldc_w 409
    //   1858: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1861: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1864: invokeinterface 211 2 0
    //   1869: checkcast 213	java/lang/String
    //   1872: putfield 411	com/tencent/mm/model/bo:title	Ljava/lang/String;
    //   1875: iload 6
    //   1877: ifne +822 -> 2699
    //   1880: iload 4
    //   1882: istore 5
    //   1884: iload_2
    //   1885: istore_3
    //   1886: aload 25
    //   1888: iconst_1
    //   1889: putfield 347	com/tencent/mm/model/bo:gOS	I
    //   1892: iload 4
    //   1894: istore 5
    //   1896: iload_2
    //   1897: istore_3
    //   1898: aload 25
    //   1900: aload 24
    //   1902: putfield 414	com/tencent/mm/model/bo:gKD	Ljava/lang/String;
    //   1905: iload 4
    //   1907: istore 5
    //   1909: iload_2
    //   1910: istore_3
    //   1911: aload 16
    //   1913: invokestatic 265	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   1916: ifeq +1379 -> 3295
    //   1919: iload 4
    //   1921: istore 5
    //   1923: iload_2
    //   1924: istore_3
    //   1925: aload 21
    //   1927: new 52	java/lang/StringBuilder
    //   1930: dup
    //   1931: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1934: aload 26
    //   1936: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1939: ldc_w 416
    //   1942: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1945: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1948: invokeinterface 211 2 0
    //   1953: checkcast 213	java/lang/String
    //   1956: astore 15
    //   1958: iload 4
    //   1960: istore 5
    //   1962: iload_2
    //   1963: istore_3
    //   1964: aload 25
    //   1966: aload 15
    //   1968: putfield 419	com/tencent/mm/model/bo:gKF	Ljava/lang/String;
    //   1971: iload 4
    //   1973: istore 5
    //   1975: iload_2
    //   1976: istore_3
    //   1977: aload 21
    //   1979: new 52	java/lang/StringBuilder
    //   1982: dup
    //   1983: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1986: aload 26
    //   1988: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1991: ldc_w 421
    //   1994: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1997: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2000: invokeinterface 425 2 0
    //   2005: ifeq +801 -> 2806
    //   2008: iconst_1
    //   2009: istore 7
    //   2011: iload 4
    //   2013: istore 5
    //   2015: iload_2
    //   2016: istore_3
    //   2017: aload 25
    //   2019: iload 7
    //   2021: putfield 362	com/tencent/mm/model/bo:gOT	I
    //   2024: iload 4
    //   2026: istore 5
    //   2028: iload_2
    //   2029: istore_3
    //   2030: aload 25
    //   2032: aload 21
    //   2034: new 52	java/lang/StringBuilder
    //   2037: dup
    //   2038: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   2041: aload 26
    //   2043: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2046: ldc_w 427
    //   2049: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2052: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2055: invokeinterface 211 2 0
    //   2060: checkcast 213	java/lang/String
    //   2063: putfield 429	com/tencent/mm/model/bo:url	Ljava/lang/String;
    //   2066: iload 4
    //   2068: istore 5
    //   2070: iload_2
    //   2071: istore_3
    //   2072: aload 25
    //   2074: aload 21
    //   2076: new 52	java/lang/StringBuilder
    //   2079: dup
    //   2080: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   2083: aload 26
    //   2085: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2088: ldc_w 431
    //   2091: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2094: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2097: invokeinterface 211 2 0
    //   2102: checkcast 213	java/lang/String
    //   2105: putfield 434	com/tencent/mm/model/bo:gON	Ljava/lang/String;
    //   2108: iload 4
    //   2110: istore 5
    //   2112: iload_2
    //   2113: istore_3
    //   2114: aload 25
    //   2116: aload 21
    //   2118: new 52	java/lang/StringBuilder
    //   2121: dup
    //   2122: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   2125: aload 26
    //   2127: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2130: ldc_w 436
    //   2133: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2136: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2139: invokeinterface 211 2 0
    //   2144: checkcast 213	java/lang/String
    //   2147: putfield 323	com/tencent/mm/model/bo:gOO	Ljava/lang/String;
    //   2150: iload 4
    //   2152: istore 5
    //   2154: iload_2
    //   2155: istore_3
    //   2156: aload 25
    //   2158: aload 21
    //   2160: new 52	java/lang/StringBuilder
    //   2163: dup
    //   2164: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   2167: aload 26
    //   2169: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2172: ldc_w 438
    //   2175: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2178: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2181: invokeinterface 211 2 0
    //   2186: checkcast 213	java/lang/String
    //   2189: lconst_0
    //   2190: invokestatic 442	com/tencent/mm/sdk/platformtools/bt:getLong	(Ljava/lang/String;J)J
    //   2193: putfield 332	com/tencent/mm/model/bo:gOP	J
    //   2196: iload 4
    //   2198: istore 5
    //   2200: iload_2
    //   2201: istore_3
    //   2202: aload 21
    //   2204: new 52	java/lang/StringBuilder
    //   2207: dup
    //   2208: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   2211: aload 26
    //   2213: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2216: ldc_w 444
    //   2219: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2222: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2225: invokeinterface 211 2 0
    //   2230: checkcast 213	java/lang/String
    //   2233: astore 17
    //   2235: aload 17
    //   2237: ifnull +24 -> 2261
    //   2240: aload 17
    //   2242: astore 15
    //   2244: iload 4
    //   2246: istore 5
    //   2248: iload_2
    //   2249: istore_3
    //   2250: ldc_w 325
    //   2253: aload 17
    //   2255: invokevirtual 447	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2258: ifeq +78 -> 2336
    //   2261: iload 4
    //   2263: istore 5
    //   2265: iload_2
    //   2266: istore_3
    //   2267: new 449	java/util/Date
    //   2270: dup
    //   2271: invokestatic 63	java/lang/System:currentTimeMillis	()J
    //   2274: iload 6
    //   2276: i2l
    //   2277: ladd
    //   2278: invokespecial 452	java/util/Date:<init>	(J)V
    //   2281: astore 15
    //   2283: iload 4
    //   2285: istore 5
    //   2287: iload_2
    //   2288: istore_3
    //   2289: new 52	java/lang/StringBuilder
    //   2292: dup
    //   2293: ldc_w 454
    //   2296: invokespecial 57	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2299: aload 20
    //   2301: aload 15
    //   2303: invokevirtual 458	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   2306: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2309: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2312: astore 15
    //   2314: iload 4
    //   2316: istore 5
    //   2318: iload_2
    //   2319: istore_3
    //   2320: ldc 75
    //   2322: ldc_w 460
    //   2325: aload 15
    //   2327: invokestatic 463	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   2330: invokevirtual 466	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2333: invokestatic 468	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2336: iload 4
    //   2338: istore 5
    //   2340: iload_2
    //   2341: istore_3
    //   2342: aload 25
    //   2344: aload 15
    //   2346: putfield 471	com/tencent/mm/model/bo:gOM	Ljava/lang/String;
    //   2349: iload 4
    //   2351: istore 5
    //   2353: iload_2
    //   2354: istore_3
    //   2355: aload 25
    //   2357: aload 21
    //   2359: new 52	java/lang/StringBuilder
    //   2362: dup
    //   2363: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   2366: aload 26
    //   2368: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2371: ldc_w 473
    //   2374: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2377: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2380: invokeinterface 211 2 0
    //   2385: checkcast 213	java/lang/String
    //   2388: putfield 476	com/tencent/mm/model/bo:gOQ	Ljava/lang/String;
    //   2391: iload 4
    //   2393: istore 5
    //   2395: iload_2
    //   2396: istore_3
    //   2397: aload 25
    //   2399: aload 21
    //   2401: new 52	java/lang/StringBuilder
    //   2404: dup
    //   2405: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   2408: aload 26
    //   2410: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2413: ldc_w 478
    //   2416: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2419: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2422: invokeinterface 211 2 0
    //   2427: checkcast 213	java/lang/String
    //   2430: putfield 481	com/tencent/mm/model/bo:gOR	Ljava/lang/String;
    //   2433: iload 4
    //   2435: istore 5
    //   2437: iload_2
    //   2438: istore_3
    //   2439: aload 21
    //   2441: new 52	java/lang/StringBuilder
    //   2444: dup
    //   2445: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   2448: aload 26
    //   2450: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2453: ldc_w 483
    //   2456: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2459: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2462: invokeinterface 211 2 0
    //   2467: checkcast 213	java/lang/String
    //   2470: iconst_m1
    //   2471: invokestatic 219	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
    //   2474: istore 7
    //   2476: iload 4
    //   2478: istore 5
    //   2480: iload_2
    //   2481: istore_3
    //   2482: aload 21
    //   2484: new 52	java/lang/StringBuilder
    //   2487: dup
    //   2488: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   2491: aload 26
    //   2493: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2496: ldc_w 485
    //   2499: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2502: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2505: invokeinterface 211 2 0
    //   2510: checkcast 213	java/lang/String
    //   2513: iconst_m1
    //   2514: invokestatic 219	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
    //   2517: istore 10
    //   2519: new 487	org/json/JSONObject
    //   2522: dup
    //   2523: invokespecial 488	org/json/JSONObject:<init>	()V
    //   2526: astore 15
    //   2528: aload 15
    //   2530: ldc_w 490
    //   2533: iload 10
    //   2535: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2538: invokevirtual 494	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2541: pop
    //   2542: aload 15
    //   2544: ldc_w 496
    //   2547: iload 8
    //   2549: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2552: invokevirtual 494	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2555: pop
    //   2556: aload 15
    //   2558: ldc_w 498
    //   2561: aload 22
    //   2563: invokestatic 501	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   2566: invokevirtual 494	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2569: pop
    //   2570: aload 15
    //   2572: ldc_w 503
    //   2575: iload 7
    //   2577: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2580: invokevirtual 494	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2583: pop
    //   2584: aload 25
    //   2586: aload 15
    //   2588: invokevirtual 504	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2591: putfield 507	com/tencent/mm/model/bo:gOW	Ljava/lang/String;
    //   2594: iload 4
    //   2596: istore 5
    //   2598: iload_2
    //   2599: istore_3
    //   2600: ldc 75
    //   2602: ldc_w 509
    //   2605: iconst_1
    //   2606: anewarray 4	java/lang/Object
    //   2609: dup
    //   2610: iconst_0
    //   2611: aload 25
    //   2613: invokevirtual 380	com/tencent/mm/model/bo:asv	()Ljava/lang/String;
    //   2616: aastore
    //   2617: invokestatic 143	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2620: iload 4
    //   2622: istore 5
    //   2624: iload_2
    //   2625: istore_3
    //   2626: aload 25
    //   2628: iload_2
    //   2629: i2l
    //   2630: lload 11
    //   2632: ladd
    //   2633: putfield 296	com/tencent/mm/model/bo:time	J
    //   2636: iload 4
    //   2638: istore 5
    //   2640: iload_2
    //   2641: istore_3
    //   2642: aload 25
    //   2644: iload 4
    //   2646: putfield 275	com/tencent/mm/model/bo:type	I
    //   2649: iload 4
    //   2651: istore 5
    //   2653: iload_2
    //   2654: istore_3
    //   2655: aload 25
    //   2657: aload 23
    //   2659: putfield 511	com/tencent/mm/model/bo:name	Ljava/lang/String;
    //   2662: iload 4
    //   2664: istore 5
    //   2666: iload_2
    //   2667: istore_3
    //   2668: aload 25
    //   2670: aload_1
    //   2671: putfield 372	com/tencent/mm/model/bo:gOV	Ljava/lang/String;
    //   2674: iload 4
    //   2676: istore 5
    //   2678: iload_2
    //   2679: istore_3
    //   2680: aload 18
    //   2682: aload 25
    //   2684: invokeinterface 514 2 0
    //   2689: pop
    //   2690: iload 6
    //   2692: iconst_1
    //   2693: iadd
    //   2694: istore 6
    //   2696: goto -958 -> 1738
    //   2699: iload 4
    //   2701: istore 5
    //   2703: iload_2
    //   2704: istore_3
    //   2705: aload 25
    //   2707: aload 21
    //   2709: new 52	java/lang/StringBuilder
    //   2712: dup
    //   2713: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   2716: aload 26
    //   2718: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2721: ldc_w 516
    //   2724: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2727: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2730: invokeinterface 211 2 0
    //   2735: checkcast 213	java/lang/String
    //   2738: putfield 414	com/tencent/mm/model/bo:gKD	Ljava/lang/String;
    //   2741: iload 4
    //   2743: istore 5
    //   2745: iload_2
    //   2746: istore_3
    //   2747: aload 25
    //   2749: aload 21
    //   2751: new 52	java/lang/StringBuilder
    //   2754: dup
    //   2755: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   2758: aload 26
    //   2760: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2763: ldc_w 416
    //   2766: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2769: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2772: invokeinterface 211 2 0
    //   2777: checkcast 213	java/lang/String
    //   2780: putfield 419	com/tencent/mm/model/bo:gKF	Ljava/lang/String;
    //   2783: goto -812 -> 1971
    //   2786: astore_1
    //   2787: iload 5
    //   2789: istore_2
    //   2790: ldc 75
    //   2792: aload_1
    //   2793: ldc_w 325
    //   2796: iconst_0
    //   2797: anewarray 4	java/lang/Object
    //   2800: invokestatic 520	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2803: goto -2276 -> 527
    //   2806: iconst_0
    //   2807: istore 7
    //   2809: goto -798 -> 2011
    //   2812: iload_2
    //   2813: iconst_1
    //   2814: iadd
    //   2815: istore_2
    //   2816: iload 4
    //   2818: istore_3
    //   2819: goto -2473 -> 346
    //   2822: iload_2
    //   2823: istore 4
    //   2825: iload_3
    //   2826: istore_2
    //   2827: iload 4
    //   2829: istore_3
    //   2830: goto -2303 -> 527
    //   2833: aload 14
    //   2835: invokevirtual 315	com/tencent/mm/model/bo:getUrl	()Ljava/lang/String;
    //   2838: invokestatic 265	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   2841: ifeq -2270 -> 571
    //   2844: ldc 75
    //   2846: new 52	java/lang/StringBuilder
    //   2849: dup
    //   2850: ldc_w 522
    //   2853: invokespecial 57	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2856: aload 14
    //   2858: invokevirtual 270	com/tencent/mm/model/bo:asq	()Ljava/lang/String;
    //   2861: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2864: ldc_w 272
    //   2867: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2870: aload 14
    //   2872: getfield 275	com/tencent/mm/model/bo:type	I
    //   2875: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2878: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2881: invokestatic 89	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2884: iconst_0
    //   2885: istore 4
    //   2887: goto -2242 -> 645
    //   2890: aload 16
    //   2892: getfield 323	com/tencent/mm/model/bo:gOO	Ljava/lang/String;
    //   2895: astore 14
    //   2897: goto -1982 -> 915
    //   2900: aload 16
    //   2902: getfield 372	com/tencent/mm/model/bo:gOV	Ljava/lang/String;
    //   2905: astore 14
    //   2907: goto -1745 -> 1162
    //   2910: iconst_0
    //   2911: istore 6
    //   2913: goto -1687 -> 1226
    //   2916: ldc 75
    //   2918: ldc_w 524
    //   2921: iconst_2
    //   2922: anewarray 4	java/lang/Object
    //   2925: dup
    //   2926: iconst_0
    //   2927: iload 5
    //   2929: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2932: aastore
    //   2933: dup
    //   2934: iconst_1
    //   2935: iload_3
    //   2936: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2939: aastore
    //   2940: invokestatic 179	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2943: iload 5
    //   2945: ifle +282 -> 3227
    //   2948: ldc_w 526
    //   2951: invokestatic 532	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   2954: checkcast 526	com/tencent/mm/plugin/messenger/foundation/a/k
    //   2957: invokeinterface 536 1 0
    //   2962: iload_2
    //   2963: invokestatic 539	com/tencent/mm/model/bo:nl	(I)Ljava/lang/String;
    //   2966: invokeinterface 545 2 0
    //   2971: astore 14
    //   2973: aload 14
    //   2975: ifnull +18 -> 2993
    //   2978: aload 14
    //   2980: getfield 550	com/tencent/mm/g/c/ay:field_username	Ljava/lang/String;
    //   2983: iload_2
    //   2984: invokestatic 539	com/tencent/mm/model/bo:nl	(I)Ljava/lang/String;
    //   2987: invokevirtual 447	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2990: ifne +172 -> 3162
    //   2993: new 552	com/tencent/mm/storage/am
    //   2996: dup
    //   2997: invokespecial 553	com/tencent/mm/storage/am:<init>	()V
    //   3000: astore 15
    //   3002: aload 15
    //   3004: iload_2
    //   3005: invokestatic 539	com/tencent/mm/model/bo:nl	(I)Ljava/lang/String;
    //   3008: invokevirtual 556	com/tencent/mm/storage/am:setUsername	(Ljava/lang/String;)V
    //   3011: aload_1
    //   3012: ifnonnull +132 -> 3144
    //   3015: ldc_w 325
    //   3018: astore 14
    //   3020: aload 15
    //   3022: aload 14
    //   3024: invokevirtual 559	com/tencent/mm/storage/am:setContent	(Ljava/lang/String;)V
    //   3027: aload_1
    //   3028: ifnonnull +125 -> 3153
    //   3031: invokestatic 562	com/tencent/mm/sdk/platformtools/bt:eGO	()J
    //   3034: lstore 11
    //   3036: aload 15
    //   3038: lload 11
    //   3040: invokevirtual 565	com/tencent/mm/storage/am:kS	(J)V
    //   3043: aload 15
    //   3045: iconst_0
    //   3046: invokevirtual 568	com/tencent/mm/storage/am:jV	(I)V
    //   3049: aload 15
    //   3051: iload_3
    //   3052: invokevirtual 571	com/tencent/mm/storage/am:jT	(I)V
    //   3055: ldc_w 526
    //   3058: invokestatic 532	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   3061: checkcast 526	com/tencent/mm/plugin/messenger/foundation/a/k
    //   3064: invokeinterface 536 1 0
    //   3069: aload 15
    //   3071: invokeinterface 574 2 0
    //   3076: pop2
    //   3077: invokestatic 117	com/tencent/mm/plugin/readerapp/c/g:dfz	()Lcom/tencent/mm/model/bp;
    //   3080: invokevirtual 154	com/tencent/mm/model/bp:doNotify	()V
    //   3083: aload_1
    //   3084: invokevirtual 261	com/tencent/mm/model/bo:getTitle	()Ljava/lang/String;
    //   3087: astore_1
    //   3088: new 576	com/tencent/mm/storage/bl
    //   3091: dup
    //   3092: invokespecial 577	com/tencent/mm/storage/bl:<init>	()V
    //   3095: astore 14
    //   3097: aload 14
    //   3099: aload_1
    //   3100: invokevirtual 578	com/tencent/mm/storage/bl:setContent	(Ljava/lang/String;)V
    //   3103: aload 14
    //   3105: iload_2
    //   3106: invokestatic 539	com/tencent/mm/model/bo:nl	(I)Ljava/lang/String;
    //   3109: invokevirtual 581	com/tencent/mm/storage/bl:nY	(Ljava/lang/String;)V
    //   3112: aload 14
    //   3114: iconst_1
    //   3115: invokevirtual 584	com/tencent/mm/storage/bl:setType	(I)V
    //   3118: aload 14
    //   3120: ldc2_w 585
    //   3123: invokevirtual 589	com/tencent/mm/storage/bl:setMsgId	(J)V
    //   3126: new 591	com/tencent/mm/al/f$b
    //   3129: dup
    //   3130: aload 14
    //   3132: iconst_1
    //   3133: invokespecial 594	com/tencent/mm/al/f$b:<init>	(Lcom/tencent/mm/storage/bl;Z)V
    //   3136: astore_1
    //   3137: ldc 40
    //   3139: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3142: aload_1
    //   3143: areturn
    //   3144: aload_1
    //   3145: invokevirtual 261	com/tencent/mm/model/bo:getTitle	()Ljava/lang/String;
    //   3148: astore 14
    //   3150: goto -130 -> 3020
    //   3153: aload_1
    //   3154: getfield 296	com/tencent/mm/model/bo:time	J
    //   3157: lstore 11
    //   3159: goto -123 -> 3036
    //   3162: aload 14
    //   3164: aload_1
    //   3165: invokevirtual 261	com/tencent/mm/model/bo:getTitle	()Ljava/lang/String;
    //   3168: invokevirtual 559	com/tencent/mm/storage/am:setContent	(Ljava/lang/String;)V
    //   3171: aload 14
    //   3173: aload_1
    //   3174: getfield 296	com/tencent/mm/model/bo:time	J
    //   3177: invokevirtual 565	com/tencent/mm/storage/am:kS	(J)V
    //   3180: aload 14
    //   3182: iconst_0
    //   3183: invokevirtual 568	com/tencent/mm/storage/am:jV	(I)V
    //   3186: aload 14
    //   3188: aload 14
    //   3190: getfield 597	com/tencent/mm/g/c/ay:field_unReadCount	I
    //   3193: iload_3
    //   3194: iadd
    //   3195: invokevirtual 571	com/tencent/mm/storage/am:jT	(I)V
    //   3198: ldc_w 526
    //   3201: invokestatic 532	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   3204: checkcast 526	com/tencent/mm/plugin/messenger/foundation/a/k
    //   3207: invokeinterface 536 1 0
    //   3212: aload 14
    //   3214: iload_2
    //   3215: invokestatic 539	com/tencent/mm/model/bo:nl	(I)Ljava/lang/String;
    //   3218: invokeinterface 600 3 0
    //   3223: pop
    //   3224: goto -147 -> 3077
    //   3227: ldc 75
    //   3229: ldc_w 602
    //   3232: invokestatic 89	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   3235: ldc 40
    //   3237: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3240: aconst_null
    //   3241: areturn
    //   3242: ldc 40
    //   3244: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3247: aconst_null
    //   3248: areturn
    //   3249: astore_1
    //   3250: iload_2
    //   3251: istore 4
    //   3253: iload_3
    //   3254: istore_2
    //   3255: iload 4
    //   3257: istore_3
    //   3258: goto -468 -> 2790
    //   3261: astore 15
    //   3263: goto -669 -> 2594
    //   3266: goto -2013 -> 1253
    //   3269: goto -2010 -> 1259
    //   3272: iconst_1
    //   3273: istore 4
    //   3275: goto -2630 -> 645
    //   3278: goto -3051 -> 227
    //   3281: iconst_0
    //   3282: istore 6
    //   3284: goto -1546 -> 1738
    //   3287: ldc_w 325
    //   3290: astore 15
    //   3292: goto -1509 -> 1783
    //   3295: aload 16
    //   3297: astore 15
    //   3299: goto -1341 -> 1958
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3302	0	this	c
    //   0	3302	1	parama	com.tencent.mm.al.f.a
    //   280	2975	2	i	int
    //   298	2960	3	j	int
    //   291	2983	4	k	int
    //   295	2649	5	m	int
    //   1224	2059	6	n	int
    //   2009	799	7	i1	int
    //   453	2095	8	i2	int
    //   1548	195	9	i3	int
    //   2517	17	10	i4	int
    //   207	2951	11	l	long
    //   530	23	13	bool	boolean
    //   112	3101	14	localObject1	Object
    //   146	2924	15	localObject2	Object
    //   3261	1	15	localException	Exception
    //   3290	8	15	localObject3	Object
    //   697	2599	16	localObject4	Object
    //   717	1537	17	localObject5	Object
    //   288	2393	18	localArrayList	java.util.ArrayList
    //   9	1816	19	localcs	com.tencent.mm.protocal.protobuf.cs
    //   277	2023	20	localSimpleDateFormat	java.text.SimpleDateFormat
    //   306	2444	21	localMap	java.util.Map
    //   485	2077	22	str1	String
    //   1371	1287	23	str2	String
    //   1466	435	24	str3	String
    //   1814	934	25	localbo	bo
    //   1799	960	26	str4	String
    // Exception table:
    //   from	to	target	type
    //   299	308	2786	java/lang/Exception
    //   326	342	2786	java/lang/Exception
    //   1340	1373	2786	java/lang/Exception
    //   1379	1387	2786	java/lang/Exception
    //   1393	1421	2786	java/lang/Exception
    //   1435	1468	2786	java/lang/Exception
    //   1474	1507	2786	java/lang/Exception
    //   1513	1550	2786	java/lang/Exception
    //   1561	1589	2786	java/lang/Exception
    //   1609	1623	2786	java/lang/Exception
    //   1641	1653	2786	java/lang/Exception
    //   1671	1691	2786	java/lang/Exception
    //   1712	1735	2786	java/lang/Exception
    //   1751	1765	2786	java/lang/Exception
    //   1776	1783	2786	java/lang/Exception
    //   1789	1801	2786	java/lang/Exception
    //   1807	1816	2786	java/lang/Exception
    //   1822	1833	2786	java/lang/Exception
    //   1839	1875	2786	java/lang/Exception
    //   1886	1892	2786	java/lang/Exception
    //   1898	1905	2786	java/lang/Exception
    //   1911	1919	2786	java/lang/Exception
    //   1925	1958	2786	java/lang/Exception
    //   1964	1971	2786	java/lang/Exception
    //   1977	2008	2786	java/lang/Exception
    //   2017	2024	2786	java/lang/Exception
    //   2030	2066	2786	java/lang/Exception
    //   2072	2108	2786	java/lang/Exception
    //   2114	2150	2786	java/lang/Exception
    //   2156	2196	2786	java/lang/Exception
    //   2202	2235	2786	java/lang/Exception
    //   2250	2261	2786	java/lang/Exception
    //   2267	2283	2786	java/lang/Exception
    //   2289	2314	2786	java/lang/Exception
    //   2320	2336	2786	java/lang/Exception
    //   2342	2349	2786	java/lang/Exception
    //   2355	2391	2786	java/lang/Exception
    //   2397	2433	2786	java/lang/Exception
    //   2439	2476	2786	java/lang/Exception
    //   2482	2519	2786	java/lang/Exception
    //   2600	2620	2786	java/lang/Exception
    //   2626	2636	2786	java/lang/Exception
    //   2642	2649	2786	java/lang/Exception
    //   2655	2662	2786	java/lang/Exception
    //   2668	2674	2786	java/lang/Exception
    //   2680	2690	2786	java/lang/Exception
    //   2705	2741	2786	java/lang/Exception
    //   2747	2783	2786	java/lang/Exception
    //   350	361	3249	java/lang/Exception
    //   365	371	3249	java/lang/Exception
    //   371	487	3249	java/lang/Exception
    //   492	519	3249	java/lang/Exception
    //   1290	1323	3249	java/lang/Exception
    //   2519	2594	3261	java/lang/Exception
  }
  
  public final void b(f.c paramc)
  {
    AppMethodBeat.i(102664);
    Object localObject3 = (String)paramc.gVn;
    ad.i("MicroMsg.ReaderAppMsgExtension", "[onPreDelMessage] functionId:%s", new Object[] { localObject3 });
    label515:
    label518:
    for (;;)
    {
      try
      {
        localObject2 = g.dfz();
        localObject1 = ((bp)localObject2).ur((String)localObject3);
        if ((localObject1 == null) || (((List)localObject1).size() == 0))
        {
          AppMethodBeat.o(102664);
          return;
        }
        paramc = (bo)((List)localObject1).get(0);
        Iterator localIterator = ((List)localObject1).iterator();
        if (localIterator.hasNext())
        {
          localObject1 = (bo)localIterator.next();
          if (((bo)localObject1).gOS != 1) {
            break label515;
          }
          paramc = (f.c)localObject1;
          break label518;
        }
        if (((bp)localObject2).gPa.delete(bp.nm(20), "reserved3=?", new String[] { localObject3 }) >= 0) {
          ((bp)localObject2).doNotify();
        }
        localObject1 = bp.uq(bp.nm(20)) + " where istop = 1  group by time ORDER BY time DESC  limit 2";
        ad.i("MicroMsg.ReaderAppInfoStorage", "processConversationAfterDeleteInfo, sql is %s", new Object[] { localObject1 });
        localObject3 = ((bp)localObject2).gPa.a((String)localObject1, null, 2);
        if (!((Cursor)localObject3).moveToFirst())
        {
          ((Cursor)localObject3).close();
          paramc = new am();
          paramc.setUsername(bo.nl(20));
          paramc.setContent("");
          paramc.kS(0L);
          paramc.jV(0);
          paramc.jT(0);
          ((k)com.tencent.mm.kernel.g.ab(k.class)).apR().a(paramc, bo.nl(20));
          AppMethodBeat.o(102664);
          return;
        }
      }
      catch (Exception paramc)
      {
        ad.e("MicroMsg.ReaderAppMsgExtension", "[onPreDelMessage] Exception:%s", new Object[] { paramc });
        AppMethodBeat.o(102664);
        return;
      }
      Object localObject1 = ((k)com.tencent.mm.kernel.g.ab(k.class)).apR().aIn(bo.nl(20));
      if (localObject1 == null)
      {
        ad.e("MicroMsg.ReaderAppInfoStorage", "[processConversationAfterDeleteInfo] originConv[%s] is null!", new Object[] { bo.nl(20) });
        AppMethodBeat.o(102664);
        return;
      }
      Object localObject2 = new bo();
      ((bo)localObject2).convertFrom((Cursor)localObject3);
      ((Cursor)localObject3).close();
      localObject3 = new am();
      ((am)localObject3).setUsername(bo.nl(20));
      ((am)localObject3).setContent(((bo)localObject2).getTitle());
      ((am)localObject3).kS(((bo)localObject2).time);
      ((am)localObject3).jV(0);
      if ((((ay)localObject1).field_unReadCount > 0) && (paramc != null) && (((ay)localObject1).field_content.equals(paramc.getTitle()))) {
        ((am)localObject3).jT(((ay)localObject1).field_unReadCount - 1);
      }
      for (;;)
      {
        ((k)com.tencent.mm.kernel.g.ab(k.class)).apR().a((am)localObject3, bo.nl(20));
        AppMethodBeat.o(102664);
        return;
        ((am)localObject3).jT(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.c.c
 * JD-Core Version:    0.7.0.1
 */