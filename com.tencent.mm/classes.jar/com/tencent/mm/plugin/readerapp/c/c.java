package com.tencent.mm.plugin.readerapp.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.az;
import com.tencent.mm.storagebase.h;
import java.util.Iterator;
import java.util.List;

public final class c
  implements com.tencent.mm.ak.g
{
  private long BBW = 0L;
  
  public static boolean eHG()
  {
    AppMethodBeat.i(102663);
    if ((z.aUe() & 0x400) == 0)
    {
      AppMethodBeat.o(102663);
      return true;
    }
    AppMethodBeat.o(102663);
    return false;
  }
  
  public final int atA()
  {
    return 0;
  }
  
  public final int atz()
  {
    return 12399999;
  }
  
  /* Error */
  public final com.tencent.mm.ak.h.b b(com.tencent.mm.ak.h.a parama)
  {
    // Byte code:
    //   0: ldc 41
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: getfield 47	com/tencent/mm/ak/h$a:heO	Lcom/tencent/mm/protocal/protobuf/de;
    //   9: astore 19
    //   11: aload_1
    //   12: getfield 51	com/tencent/mm/ak/h$a:iMa	Ljava/lang/Object;
    //   15: ifnonnull +60 -> 75
    //   18: new 53	java/lang/StringBuilder
    //   21: dup
    //   22: ldc 55
    //   24: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   27: invokestatic 64	java/lang/System:currentTimeMillis	()J
    //   30: ldc2_w 65
    //   33: ldiv
    //   34: invokevirtual 70	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   37: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: astore_1
    //   41: ldc 76
    //   43: ldc 78
    //   45: iconst_1
    //   46: anewarray 4	java/lang/Object
    //   49: dup
    //   50: iconst_0
    //   51: aload_1
    //   52: aastore
    //   53: invokestatic 84	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   56: aload 19
    //   58: ifnonnull +31 -> 89
    //   61: ldc 76
    //   63: ldc 86
    //   65: invokestatic 90	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: ldc 41
    //   70: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: aconst_null
    //   74: areturn
    //   75: aload_1
    //   76: getfield 51	com/tencent/mm/ak/h$a:iMa	Ljava/lang/Object;
    //   79: checkcast 92	com/tencent/mm/ak/g$b
    //   82: getfield 96	com/tencent/mm/ak/g$b:iLU	Ljava/lang/String;
    //   85: astore_1
    //   86: goto -30 -> 56
    //   89: getstatic 102	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   92: sipush 13440
    //   95: iconst_1
    //   96: anewarray 4	java/lang/Object
    //   99: dup
    //   100: iconst_0
    //   101: iconst_1
    //   102: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   105: aastore
    //   106: invokevirtual 112	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   109: invokestatic 118	com/tencent/mm/plugin/readerapp/c/g:eHI	()Lcom/tencent/mm/model/bw;
    //   112: astore 14
    //   114: new 53	java/lang/StringBuilder
    //   117: dup
    //   118: ldc 120
    //   120: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   123: bipush 20
    //   125: invokestatic 126	com/tencent/mm/model/bw:se	(I)Ljava/lang/String;
    //   128: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: ldc 131
    //   133: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload_1
    //   137: invokestatic 137	com/tencent/mm/storagebase/h:Fl	(Ljava/lang/String;)Ljava/lang/String;
    //   140: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: astore 15
    //   148: ldc 139
    //   150: ldc 141
    //   152: iconst_1
    //   153: anewarray 4	java/lang/Object
    //   156: dup
    //   157: iconst_0
    //   158: aload 15
    //   160: aastore
    //   161: invokestatic 144	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   164: aload 14
    //   166: getfield 148	com/tencent/mm/model/bw:iFy	Lcom/tencent/mm/storagebase/h;
    //   169: bipush 20
    //   171: invokestatic 126	com/tencent/mm/model/bw:se	(I)Ljava/lang/String;
    //   174: aload 15
    //   176: invokevirtual 152	com/tencent/mm/storagebase/h:execSQL	(Ljava/lang/String;Ljava/lang/String;)Z
    //   179: ifeq +8 -> 187
    //   182: aload 14
    //   184: invokevirtual 155	com/tencent/mm/model/bw:doNotify	()V
    //   187: aload 19
    //   189: getfield 161	com/tencent/mm/protocal/protobuf/de:KHn	Lcom/tencent/mm/protocal/protobuf/dqi;
    //   192: invokestatic 166	com/tencent/mm/platformtools/z:a	(Lcom/tencent/mm/protocal/protobuf/dqi;)Ljava/lang/String;
    //   195: astore 14
    //   197: aload 19
    //   199: getfield 170	com/tencent/mm/protocal/protobuf/de:CreateTime	I
    //   202: i2l
    //   203: ldc2_w 65
    //   206: lmul
    //   207: lstore 11
    //   209: lload 11
    //   211: aload_0
    //   212: getfield 14	com/tencent/mm/plugin/readerapp/c/c:BBW	J
    //   215: lcmp
    //   216: ifgt +3063 -> 3279
    //   219: aload_0
    //   220: getfield 14	com/tencent/mm/plugin/readerapp/c/c:BBW	J
    //   223: lconst_1
    //   224: ladd
    //   225: lstore 11
    //   227: aload_0
    //   228: lload 11
    //   230: putfield 14	com/tencent/mm/plugin/readerapp/c/c:BBW	J
    //   233: ldc 76
    //   235: ldc 172
    //   237: iconst_2
    //   238: anewarray 4	java/lang/Object
    //   241: dup
    //   242: iconst_0
    //   243: aload 19
    //   245: getfield 170	com/tencent/mm/protocal/protobuf/de:CreateTime	I
    //   248: i2l
    //   249: ldc2_w 65
    //   252: lmul
    //   253: invokestatic 177	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   256: aastore
    //   257: dup
    //   258: iconst_1
    //   259: lload 11
    //   261: invokestatic 177	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   264: aastore
    //   265: invokestatic 179	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   303: aconst_null
    //   304: invokestatic 195	com/tencent/mm/sdk/platformtools/XmlParser:parseXml	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
    //   307: astore 21
    //   309: aload 21
    //   311: ifnonnull +10 -> 321
    //   314: ldc 41
    //   316: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   319: aconst_null
    //   320: areturn
    //   321: iload 4
    //   323: istore 5
    //   325: iload_2
    //   326: istore_3
    //   327: ldc 76
    //   329: ldc 197
    //   331: iconst_1
    //   332: anewarray 4	java/lang/Object
    //   335: dup
    //   336: iconst_0
    //   337: aload 14
    //   339: aastore
    //   340: invokestatic 144	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   343: iconst_0
    //   344: istore_2
    //   345: iconst_0
    //   346: istore_3
    //   347: iload_2
    //   348: ifgt +2475 -> 2823
    //   351: new 53	java/lang/StringBuilder
    //   354: dup
    //   355: ldc 199
    //   357: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   360: astore 15
    //   362: iload_2
    //   363: ifle +906 -> 1269
    //   366: iload_2
    //   367: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   370: astore 14
    //   372: aload 15
    //   374: aload 14
    //   376: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   379: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: astore 14
    //   384: aload 21
    //   386: new 53	java/lang/StringBuilder
    //   389: dup
    //   390: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   393: aload 14
    //   395: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: ldc 205
    //   400: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: invokeinterface 211 2 0
    //   411: checkcast 213	java/lang/String
    //   414: iconst_0
    //   415: invokestatic 219	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   418: istore 4
    //   420: aload 21
    //   422: new 53	java/lang/StringBuilder
    //   425: dup
    //   426: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   429: aload 14
    //   431: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: ldc 221
    //   436: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokeinterface 211 2 0
    //   447: checkcast 213	java/lang/String
    //   450: iconst_m1
    //   451: invokestatic 219	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   454: istore 8
    //   456: aload 21
    //   458: new 53	java/lang/StringBuilder
    //   461: dup
    //   462: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   465: aload 14
    //   467: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: ldc 223
    //   472: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   478: invokeinterface 211 2 0
    //   483: checkcast 213	java/lang/String
    //   486: astore 22
    //   488: iload 4
    //   490: ifne +787 -> 1277
    //   493: ldc 76
    //   495: new 53	java/lang/StringBuilder
    //   498: dup
    //   499: ldc 225
    //   501: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   504: aload 14
    //   506: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: ldc 227
    //   511: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   517: invokestatic 90	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   520: iload_3
    //   521: istore 4
    //   523: iload_2
    //   524: istore_3
    //   525: iload 4
    //   527: istore_2
    //   528: invokestatic 229	com/tencent/mm/plugin/readerapp/c/c:eHG	()Z
    //   531: istore 13
    //   533: ldc 76
    //   535: new 53	java/lang/StringBuilder
    //   538: dup
    //   539: ldc 231
    //   541: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   544: iload_2
    //   545: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   548: ldc 236
    //   550: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: iload 13
    //   555: invokevirtual 239	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   558: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   561: invokestatic 241	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   564: aload 18
    //   566: invokeinterface 247 1 0
    //   571: astore_1
    //   572: aload_1
    //   573: invokeinterface 252 1 0
    //   578: ifeq +2695 -> 3273
    //   581: aload_1
    //   582: invokeinterface 256 1 0
    //   587: checkcast 258	com/tencent/mm/model/bv
    //   590: astore 14
    //   592: aload 14
    //   594: invokevirtual 261	com/tencent/mm/model/bv:getTitle	()Ljava/lang/String;
    //   597: invokestatic 265	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   600: ifeq +2234 -> 2834
    //   603: ldc 76
    //   605: new 53	java/lang/StringBuilder
    //   608: dup
    //   609: ldc_w 267
    //   612: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   615: aload 14
    //   617: invokevirtual 270	com/tencent/mm/model/bv:aVZ	()Ljava/lang/String;
    //   620: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: ldc_w 272
    //   626: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: aload 14
    //   631: getfield 275	com/tencent/mm/model/bv:type	I
    //   634: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   637: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   640: invokestatic 90	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   643: iconst_0
    //   644: istore 4
    //   646: aload 18
    //   648: invokeinterface 278 1 0
    //   653: ifle +2590 -> 3243
    //   656: iload 4
    //   658: ifeq +2585 -> 3243
    //   661: iconst_0
    //   662: istore 5
    //   664: aconst_null
    //   665: astore_1
    //   666: iconst_0
    //   667: istore 4
    //   669: iload 4
    //   671: aload 18
    //   673: invokeinterface 278 1 0
    //   678: if_icmpge +2239 -> 2917
    //   681: invokestatic 118	com/tencent/mm/plugin/readerapp/c/g:eHI	()Lcom/tencent/mm/model/bw;
    //   684: astore 15
    //   686: aload 18
    //   688: iload 4
    //   690: invokeinterface 281 2 0
    //   695: checkcast 258	com/tencent/mm/model/bv
    //   698: astore 16
    //   700: aload 16
    //   702: ifnull +2209 -> 2911
    //   705: aload 16
    //   707: iconst_m1
    //   708: putfield 284	com/tencent/mm/model/bv:cSx	I
    //   711: new 286	android/content/ContentValues
    //   714: dup
    //   715: invokespecial 287	android/content/ContentValues:<init>	()V
    //   718: astore 17
    //   720: aload 16
    //   722: getfield 284	com/tencent/mm/model/bv:cSx	I
    //   725: iconst_1
    //   726: iand
    //   727: ifeq +16 -> 743
    //   730: aload 17
    //   732: ldc_w 289
    //   735: aload 16
    //   737: invokevirtual 270	com/tencent/mm/model/bv:aVZ	()Ljava/lang/String;
    //   740: invokevirtual 292	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   743: aload 16
    //   745: getfield 284	com/tencent/mm/model/bv:cSx	I
    //   748: iconst_2
    //   749: iand
    //   750: ifeq +19 -> 769
    //   753: aload 17
    //   755: ldc_w 294
    //   758: aload 16
    //   760: getfield 296	com/tencent/mm/model/bv:time	J
    //   763: invokestatic 177	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   766: invokevirtual 299	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   769: aload 16
    //   771: getfield 284	com/tencent/mm/model/bv:cSx	I
    //   774: iconst_4
    //   775: iand
    //   776: ifeq +19 -> 795
    //   779: aload 17
    //   781: ldc_w 300
    //   784: aload 16
    //   786: getfield 275	com/tencent/mm/model/bv:type	I
    //   789: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   792: invokevirtual 303	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   795: aload 16
    //   797: getfield 284	com/tencent/mm/model/bv:cSx	I
    //   800: bipush 8
    //   802: iand
    //   803: ifeq +16 -> 819
    //   806: aload 17
    //   808: ldc_w 305
    //   811: aload 16
    //   813: invokevirtual 308	com/tencent/mm/model/bv:getName	()Ljava/lang/String;
    //   816: invokevirtual 292	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   819: aload 16
    //   821: getfield 284	com/tencent/mm/model/bv:cSx	I
    //   824: bipush 16
    //   826: iand
    //   827: ifeq +16 -> 843
    //   830: aload 17
    //   832: ldc_w 310
    //   835: aload 16
    //   837: invokevirtual 261	com/tencent/mm/model/bv:getTitle	()Ljava/lang/String;
    //   840: invokevirtual 292	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   843: aload 16
    //   845: getfield 284	com/tencent/mm/model/bv:cSx	I
    //   848: bipush 32
    //   850: iand
    //   851: ifeq +16 -> 867
    //   854: aload 17
    //   856: ldc_w 312
    //   859: aload 16
    //   861: invokevirtual 315	com/tencent/mm/model/bv:getUrl	()Ljava/lang/String;
    //   864: invokevirtual 292	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   867: aload 16
    //   869: getfield 284	com/tencent/mm/model/bv:cSx	I
    //   872: bipush 64
    //   874: iand
    //   875: ifeq +16 -> 891
    //   878: aload 17
    //   880: ldc_w 317
    //   883: aload 16
    //   885: invokevirtual 320	com/tencent/mm/model/bv:aWa	()Ljava/lang/String;
    //   888: invokevirtual 292	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   891: aload 16
    //   893: getfield 284	com/tencent/mm/model/bv:cSx	I
    //   896: sipush 128
    //   899: iand
    //   900: ifeq +26 -> 926
    //   903: aload 16
    //   905: getfield 323	com/tencent/mm/model/bv:iFm	Ljava/lang/String;
    //   908: ifnonnull +1983 -> 2891
    //   911: ldc_w 325
    //   914: astore 14
    //   916: aload 17
    //   918: ldc_w 327
    //   921: aload 14
    //   923: invokevirtual 292	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   926: aload 16
    //   928: getfield 284	com/tencent/mm/model/bv:cSx	I
    //   931: sipush 256
    //   934: iand
    //   935: ifeq +19 -> 954
    //   938: aload 17
    //   940: ldc_w 329
    //   943: aload 16
    //   945: getfield 332	com/tencent/mm/model/bv:iFn	J
    //   948: invokestatic 177	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   951: invokevirtual 299	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   954: aload 16
    //   956: getfield 284	com/tencent/mm/model/bv:cSx	I
    //   959: sipush 512
    //   962: iand
    //   963: ifeq +16 -> 979
    //   966: aload 17
    //   968: ldc_w 334
    //   971: aload 16
    //   973: invokevirtual 337	com/tencent/mm/model/bv:aWb	()Ljava/lang/String;
    //   976: invokevirtual 292	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   979: aload 16
    //   981: getfield 284	com/tencent/mm/model/bv:cSx	I
    //   984: sipush 1024
    //   987: iand
    //   988: ifeq +16 -> 1004
    //   991: aload 17
    //   993: ldc_w 339
    //   996: aload 16
    //   998: invokevirtual 342	com/tencent/mm/model/bv:aWc	()Ljava/lang/String;
    //   1001: invokevirtual 292	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1004: aload 16
    //   1006: getfield 284	com/tencent/mm/model/bv:cSx	I
    //   1009: sipush 2048
    //   1012: iand
    //   1013: ifeq +19 -> 1032
    //   1016: aload 17
    //   1018: ldc_w 344
    //   1021: aload 16
    //   1023: getfield 347	com/tencent/mm/model/bv:iFq	I
    //   1026: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1029: invokevirtual 303	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1032: aload 16
    //   1034: getfield 284	com/tencent/mm/model/bv:cSx	I
    //   1037: sipush 4096
    //   1040: iand
    //   1041: ifeq +16 -> 1057
    //   1044: aload 17
    //   1046: ldc_w 349
    //   1049: aload 16
    //   1051: invokevirtual 352	com/tencent/mm/model/bv:aWd	()Ljava/lang/String;
    //   1054: invokevirtual 292	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1057: aload 16
    //   1059: getfield 284	com/tencent/mm/model/bv:cSx	I
    //   1062: sipush 8192
    //   1065: iand
    //   1066: ifeq +16 -> 1082
    //   1069: aload 17
    //   1071: ldc_w 354
    //   1074: aload 16
    //   1076: invokevirtual 357	com/tencent/mm/model/bv:getDigest	()Ljava/lang/String;
    //   1079: invokevirtual 292	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1082: aload 16
    //   1084: getfield 284	com/tencent/mm/model/bv:cSx	I
    //   1087: sipush 16384
    //   1090: iand
    //   1091: ifeq +19 -> 1110
    //   1094: aload 17
    //   1096: ldc_w 359
    //   1099: aload 16
    //   1101: getfield 362	com/tencent/mm/model/bv:iFr	I
    //   1104: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1107: invokevirtual 303	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1110: aload 16
    //   1112: getfield 284	com/tencent/mm/model/bv:cSx	I
    //   1115: ldc_w 363
    //   1118: iand
    //   1119: ifeq +19 -> 1138
    //   1122: aload 17
    //   1124: ldc_w 365
    //   1127: aload 16
    //   1129: getfield 368	com/tencent/mm/model/bv:iFs	J
    //   1132: invokestatic 177	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1135: invokevirtual 299	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   1138: aload 16
    //   1140: getfield 284	com/tencent/mm/model/bv:cSx	I
    //   1143: ldc_w 369
    //   1146: iand
    //   1147: ifeq +26 -> 1173
    //   1150: aload 16
    //   1152: getfield 372	com/tencent/mm/model/bv:iFt	Ljava/lang/String;
    //   1155: ifnonnull +1746 -> 2901
    //   1158: ldc_w 325
    //   1161: astore 14
    //   1163: aload 17
    //   1165: ldc_w 374
    //   1168: aload 14
    //   1170: invokevirtual 292	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1173: aload 16
    //   1175: getfield 284	com/tencent/mm/model/bv:cSx	I
    //   1178: ldc_w 375
    //   1181: iand
    //   1182: ifeq +16 -> 1198
    //   1185: aload 17
    //   1187: ldc_w 377
    //   1190: aload 16
    //   1192: invokevirtual 380	com/tencent/mm/model/bv:aWe	()Ljava/lang/String;
    //   1195: invokevirtual 292	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1198: aload 15
    //   1200: getfield 148	com/tencent/mm/model/bw:iFy	Lcom/tencent/mm/storagebase/h;
    //   1203: aload 16
    //   1205: getfield 275	com/tencent/mm/model/bv:type	I
    //   1208: invokestatic 126	com/tencent/mm/model/bw:se	(I)Ljava/lang/String;
    //   1211: ldc_w 289
    //   1214: aload 17
    //   1216: invokevirtual 384	com/tencent/mm/storagebase/h:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   1219: l2i
    //   1220: iconst_m1
    //   1221: if_icmpeq +1690 -> 2911
    //   1224: iconst_1
    //   1225: istore 6
    //   1227: iload 6
    //   1229: ifeq +2041 -> 3270
    //   1232: aload_1
    //   1233: ifnonnull +2034 -> 3267
    //   1236: aload 18
    //   1238: iload 4
    //   1240: invokeinterface 281 2 0
    //   1245: checkcast 258	com/tencent/mm/model/bv
    //   1248: astore_1
    //   1249: aload_1
    //   1250: iconst_1
    //   1251: putfield 347	com/tencent/mm/model/bv:iFq	I
    //   1254: iload 5
    //   1256: iconst_1
    //   1257: iadd
    //   1258: istore 5
    //   1260: iload 4
    //   1262: iconst_1
    //   1263: iadd
    //   1264: istore 4
    //   1266: goto -597 -> 669
    //   1269: ldc_w 325
    //   1272: astore 14
    //   1274: goto -902 -> 372
    //   1277: iload 4
    //   1279: bipush 20
    //   1281: if_icmpeq +54 -> 1335
    //   1284: iload 4
    //   1286: bipush 11
    //   1288: if_icmpeq +47 -> 1335
    //   1291: ldc 76
    //   1293: new 53	java/lang/StringBuilder
    //   1296: dup
    //   1297: ldc 225
    //   1299: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1302: aload 14
    //   1304: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1307: ldc_w 386
    //   1310: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1313: iload 4
    //   1315: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1318: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1321: invokestatic 90	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1324: iload_2
    //   1325: istore 4
    //   1327: iload_3
    //   1328: istore_2
    //   1329: iload 4
    //   1331: istore_3
    //   1332: goto -804 -> 528
    //   1335: iload 4
    //   1337: istore 5
    //   1339: iload_2
    //   1340: istore_3
    //   1341: aload 21
    //   1343: new 53	java/lang/StringBuilder
    //   1346: dup
    //   1347: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1350: aload 14
    //   1352: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1355: ldc_w 388
    //   1358: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1361: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1364: invokeinterface 211 2 0
    //   1369: checkcast 213	java/lang/String
    //   1372: astore 23
    //   1374: iload 4
    //   1376: istore 5
    //   1378: iload_2
    //   1379: istore_3
    //   1380: aload 23
    //   1382: invokestatic 265	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1385: ifeq +45 -> 1430
    //   1388: iload 4
    //   1390: istore 5
    //   1392: iload_2
    //   1393: istore_3
    //   1394: ldc 76
    //   1396: new 53	java/lang/StringBuilder
    //   1399: dup
    //   1400: ldc 225
    //   1402: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1405: aload 14
    //   1407: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1410: ldc_w 390
    //   1413: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1416: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1419: invokestatic 90	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1422: iload_2
    //   1423: istore_3
    //   1424: iload 4
    //   1426: istore_2
    //   1427: goto -899 -> 528
    //   1430: iload 4
    //   1432: istore 5
    //   1434: iload_2
    //   1435: istore_3
    //   1436: aload 21
    //   1438: new 53	java/lang/StringBuilder
    //   1441: dup
    //   1442: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1445: aload 14
    //   1447: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1450: ldc_w 392
    //   1453: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1456: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1459: invokeinterface 211 2 0
    //   1464: checkcast 213	java/lang/String
    //   1467: astore 24
    //   1469: iload 4
    //   1471: istore 5
    //   1473: iload_2
    //   1474: istore_3
    //   1475: aload 21
    //   1477: new 53	java/lang/StringBuilder
    //   1480: dup
    //   1481: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1484: aload 14
    //   1486: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1489: ldc_w 394
    //   1492: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1495: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1498: invokeinterface 211 2 0
    //   1503: checkcast 213	java/lang/String
    //   1506: astore 16
    //   1508: iload 4
    //   1510: istore 5
    //   1512: iload_2
    //   1513: istore_3
    //   1514: aload 21
    //   1516: new 53	java/lang/StringBuilder
    //   1519: dup
    //   1520: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1523: aload 14
    //   1525: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1528: ldc_w 396
    //   1531: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1534: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1537: invokeinterface 211 2 0
    //   1542: checkcast 213	java/lang/String
    //   1545: iconst_0
    //   1546: invokestatic 219	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   1549: istore 9
    //   1551: iload 9
    //   1553: ifne +45 -> 1598
    //   1556: iload 4
    //   1558: istore 5
    //   1560: iload_2
    //   1561: istore_3
    //   1562: ldc 76
    //   1564: new 53	java/lang/StringBuilder
    //   1567: dup
    //   1568: ldc 225
    //   1570: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1573: aload 14
    //   1575: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1578: ldc_w 398
    //   1581: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1584: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1587: invokestatic 90	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1590: iload_2
    //   1591: istore_3
    //   1592: iload 4
    //   1594: istore_2
    //   1595: goto -1067 -> 528
    //   1598: iload 9
    //   1600: iconst_1
    //   1601: if_icmple +106 -> 1707
    //   1604: iload 4
    //   1606: istore 5
    //   1608: iload_2
    //   1609: istore_3
    //   1610: new 53	java/lang/StringBuilder
    //   1613: dup
    //   1614: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1617: aload 14
    //   1619: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1622: astore 15
    //   1624: iload 4
    //   1626: bipush 20
    //   1628: if_icmpne +71 -> 1699
    //   1631: ldc_w 400
    //   1634: astore 14
    //   1636: iload 4
    //   1638: istore 5
    //   1640: iload_2
    //   1641: istore_3
    //   1642: aload 15
    //   1644: aload 14
    //   1646: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1649: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1652: astore 14
    //   1654: iconst_1
    //   1655: iload 8
    //   1657: if_icmpne +1625 -> 3282
    //   1660: iload 9
    //   1662: iconst_2
    //   1663: if_icmpge +1619 -> 3282
    //   1666: iload 4
    //   1668: istore 5
    //   1670: iload_2
    //   1671: istore_3
    //   1672: ldc 76
    //   1674: ldc_w 402
    //   1677: iconst_1
    //   1678: anewarray 4	java/lang/Object
    //   1681: dup
    //   1682: iconst_0
    //   1683: iload 9
    //   1685: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1688: aastore
    //   1689: invokestatic 179	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1692: ldc 41
    //   1694: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1697: aconst_null
    //   1698: areturn
    //   1699: ldc_w 404
    //   1702: astore 14
    //   1704: goto -68 -> 1636
    //   1707: iload 4
    //   1709: istore 5
    //   1711: iload_2
    //   1712: istore_3
    //   1713: new 53	java/lang/StringBuilder
    //   1716: dup
    //   1717: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1720: aload 14
    //   1722: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1725: ldc_w 404
    //   1728: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1731: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1734: astore 14
    //   1736: goto -82 -> 1654
    //   1739: iload 6
    //   1741: iload 9
    //   1743: if_icmpge +1070 -> 2813
    //   1746: iload 4
    //   1748: istore 5
    //   1750: iload_2
    //   1751: istore_3
    //   1752: new 53	java/lang/StringBuilder
    //   1755: dup
    //   1756: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1759: aload 14
    //   1761: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1764: astore 17
    //   1766: iload 6
    //   1768: ifle +1520 -> 3288
    //   1771: iload 4
    //   1773: istore 5
    //   1775: iload_2
    //   1776: istore_3
    //   1777: iload 6
    //   1779: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1782: astore 15
    //   1784: iload 4
    //   1786: istore 5
    //   1788: iload_2
    //   1789: istore_3
    //   1790: aload 17
    //   1792: aload 15
    //   1794: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1797: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1800: astore 26
    //   1802: iload 4
    //   1804: istore 5
    //   1806: iload_2
    //   1807: istore_3
    //   1808: new 258	com/tencent/mm/model/bv
    //   1811: dup
    //   1812: invokespecial 405	com/tencent/mm/model/bv:<init>	()V
    //   1815: astore 25
    //   1817: iload 4
    //   1819: istore 5
    //   1821: iload_2
    //   1822: istore_3
    //   1823: aload 25
    //   1825: aload 19
    //   1827: getfield 408	com/tencent/mm/protocal/protobuf/de:Brl	I
    //   1830: i2l
    //   1831: putfield 368	com/tencent/mm/model/bv:iFs	J
    //   1834: iload 4
    //   1836: istore 5
    //   1838: iload_2
    //   1839: istore_3
    //   1840: aload 25
    //   1842: aload 21
    //   1844: new 53	java/lang/StringBuilder
    //   1847: dup
    //   1848: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1851: aload 26
    //   1853: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1856: ldc_w 410
    //   1859: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1862: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1865: invokeinterface 211 2 0
    //   1870: checkcast 213	java/lang/String
    //   1873: putfield 412	com/tencent/mm/model/bv:title	Ljava/lang/String;
    //   1876: iload 6
    //   1878: ifne +822 -> 2700
    //   1881: iload 4
    //   1883: istore 5
    //   1885: iload_2
    //   1886: istore_3
    //   1887: aload 25
    //   1889: iconst_1
    //   1890: putfield 347	com/tencent/mm/model/bv:iFq	I
    //   1893: iload 4
    //   1895: istore 5
    //   1897: iload_2
    //   1898: istore_3
    //   1899: aload 25
    //   1901: aload 24
    //   1903: putfield 415	com/tencent/mm/model/bv:iAo	Ljava/lang/String;
    //   1906: iload 4
    //   1908: istore 5
    //   1910: iload_2
    //   1911: istore_3
    //   1912: aload 16
    //   1914: invokestatic 265	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1917: ifeq +1379 -> 3296
    //   1920: iload 4
    //   1922: istore 5
    //   1924: iload_2
    //   1925: istore_3
    //   1926: aload 21
    //   1928: new 53	java/lang/StringBuilder
    //   1931: dup
    //   1932: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1935: aload 26
    //   1937: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1940: ldc_w 417
    //   1943: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1946: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1949: invokeinterface 211 2 0
    //   1954: checkcast 213	java/lang/String
    //   1957: astore 15
    //   1959: iload 4
    //   1961: istore 5
    //   1963: iload_2
    //   1964: istore_3
    //   1965: aload 25
    //   1967: aload 15
    //   1969: putfield 420	com/tencent/mm/model/bv:iAq	Ljava/lang/String;
    //   1972: iload 4
    //   1974: istore 5
    //   1976: iload_2
    //   1977: istore_3
    //   1978: aload 21
    //   1980: new 53	java/lang/StringBuilder
    //   1983: dup
    //   1984: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1987: aload 26
    //   1989: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1992: ldc_w 422
    //   1995: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1998: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2001: invokeinterface 426 2 0
    //   2006: ifeq +801 -> 2807
    //   2009: iconst_1
    //   2010: istore 7
    //   2012: iload 4
    //   2014: istore 5
    //   2016: iload_2
    //   2017: istore_3
    //   2018: aload 25
    //   2020: iload 7
    //   2022: putfield 362	com/tencent/mm/model/bv:iFr	I
    //   2025: iload 4
    //   2027: istore 5
    //   2029: iload_2
    //   2030: istore_3
    //   2031: aload 25
    //   2033: aload 21
    //   2035: new 53	java/lang/StringBuilder
    //   2038: dup
    //   2039: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   2042: aload 26
    //   2044: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2047: ldc_w 428
    //   2050: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2053: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2056: invokeinterface 211 2 0
    //   2061: checkcast 213	java/lang/String
    //   2064: putfield 430	com/tencent/mm/model/bv:url	Ljava/lang/String;
    //   2067: iload 4
    //   2069: istore 5
    //   2071: iload_2
    //   2072: istore_3
    //   2073: aload 25
    //   2075: aload 21
    //   2077: new 53	java/lang/StringBuilder
    //   2080: dup
    //   2081: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   2084: aload 26
    //   2086: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2089: ldc_w 432
    //   2092: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2095: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2098: invokeinterface 211 2 0
    //   2103: checkcast 213	java/lang/String
    //   2106: putfield 435	com/tencent/mm/model/bv:iFl	Ljava/lang/String;
    //   2109: iload 4
    //   2111: istore 5
    //   2113: iload_2
    //   2114: istore_3
    //   2115: aload 25
    //   2117: aload 21
    //   2119: new 53	java/lang/StringBuilder
    //   2122: dup
    //   2123: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   2126: aload 26
    //   2128: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2131: ldc_w 437
    //   2134: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2137: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2140: invokeinterface 211 2 0
    //   2145: checkcast 213	java/lang/String
    //   2148: putfield 323	com/tencent/mm/model/bv:iFm	Ljava/lang/String;
    //   2151: iload 4
    //   2153: istore 5
    //   2155: iload_2
    //   2156: istore_3
    //   2157: aload 25
    //   2159: aload 21
    //   2161: new 53	java/lang/StringBuilder
    //   2164: dup
    //   2165: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   2168: aload 26
    //   2170: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2173: ldc_w 439
    //   2176: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2179: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2182: invokeinterface 211 2 0
    //   2187: checkcast 213	java/lang/String
    //   2190: lconst_0
    //   2191: invokestatic 443	com/tencent/mm/sdk/platformtools/Util:getLong	(Ljava/lang/String;J)J
    //   2194: putfield 332	com/tencent/mm/model/bv:iFn	J
    //   2197: iload 4
    //   2199: istore 5
    //   2201: iload_2
    //   2202: istore_3
    //   2203: aload 21
    //   2205: new 53	java/lang/StringBuilder
    //   2208: dup
    //   2209: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   2212: aload 26
    //   2214: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2217: ldc_w 445
    //   2220: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2223: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2226: invokeinterface 211 2 0
    //   2231: checkcast 213	java/lang/String
    //   2234: astore 17
    //   2236: aload 17
    //   2238: ifnull +24 -> 2262
    //   2241: aload 17
    //   2243: astore 15
    //   2245: iload 4
    //   2247: istore 5
    //   2249: iload_2
    //   2250: istore_3
    //   2251: ldc_w 325
    //   2254: aload 17
    //   2256: invokevirtual 448	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2259: ifeq +78 -> 2337
    //   2262: iload 4
    //   2264: istore 5
    //   2266: iload_2
    //   2267: istore_3
    //   2268: new 450	java/util/Date
    //   2271: dup
    //   2272: invokestatic 64	java/lang/System:currentTimeMillis	()J
    //   2275: iload 6
    //   2277: i2l
    //   2278: ladd
    //   2279: invokespecial 453	java/util/Date:<init>	(J)V
    //   2282: astore 15
    //   2284: iload 4
    //   2286: istore 5
    //   2288: iload_2
    //   2289: istore_3
    //   2290: new 53	java/lang/StringBuilder
    //   2293: dup
    //   2294: ldc_w 455
    //   2297: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2300: aload 20
    //   2302: aload 15
    //   2304: invokevirtual 459	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   2307: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2310: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2313: astore 15
    //   2315: iload 4
    //   2317: istore 5
    //   2319: iload_2
    //   2320: istore_3
    //   2321: ldc 76
    //   2323: ldc_w 461
    //   2326: aload 15
    //   2328: invokestatic 464	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   2331: invokevirtual 467	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2334: invokestatic 469	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2337: iload 4
    //   2339: istore 5
    //   2341: iload_2
    //   2342: istore_3
    //   2343: aload 25
    //   2345: aload 15
    //   2347: putfield 472	com/tencent/mm/model/bv:iFk	Ljava/lang/String;
    //   2350: iload 4
    //   2352: istore 5
    //   2354: iload_2
    //   2355: istore_3
    //   2356: aload 25
    //   2358: aload 21
    //   2360: new 53	java/lang/StringBuilder
    //   2363: dup
    //   2364: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   2367: aload 26
    //   2369: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2372: ldc_w 474
    //   2375: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2378: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2381: invokeinterface 211 2 0
    //   2386: checkcast 213	java/lang/String
    //   2389: putfield 477	com/tencent/mm/model/bv:iFo	Ljava/lang/String;
    //   2392: iload 4
    //   2394: istore 5
    //   2396: iload_2
    //   2397: istore_3
    //   2398: aload 25
    //   2400: aload 21
    //   2402: new 53	java/lang/StringBuilder
    //   2405: dup
    //   2406: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   2409: aload 26
    //   2411: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2414: ldc_w 479
    //   2417: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2420: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2423: invokeinterface 211 2 0
    //   2428: checkcast 213	java/lang/String
    //   2431: putfield 482	com/tencent/mm/model/bv:iFp	Ljava/lang/String;
    //   2434: iload 4
    //   2436: istore 5
    //   2438: iload_2
    //   2439: istore_3
    //   2440: aload 21
    //   2442: new 53	java/lang/StringBuilder
    //   2445: dup
    //   2446: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   2449: aload 26
    //   2451: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2454: ldc_w 484
    //   2457: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2460: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2463: invokeinterface 211 2 0
    //   2468: checkcast 213	java/lang/String
    //   2471: iconst_m1
    //   2472: invokestatic 219	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   2475: istore 7
    //   2477: iload 4
    //   2479: istore 5
    //   2481: iload_2
    //   2482: istore_3
    //   2483: aload 21
    //   2485: new 53	java/lang/StringBuilder
    //   2488: dup
    //   2489: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   2492: aload 26
    //   2494: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2497: ldc_w 486
    //   2500: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2503: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2506: invokeinterface 211 2 0
    //   2511: checkcast 213	java/lang/String
    //   2514: iconst_m1
    //   2515: invokestatic 219	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   2518: istore 10
    //   2520: new 488	org/json/JSONObject
    //   2523: dup
    //   2524: invokespecial 489	org/json/JSONObject:<init>	()V
    //   2527: astore 15
    //   2529: aload 15
    //   2531: ldc_w 491
    //   2534: iload 10
    //   2536: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2539: invokevirtual 495	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2542: pop
    //   2543: aload 15
    //   2545: ldc_w 497
    //   2548: iload 8
    //   2550: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2553: invokevirtual 495	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2556: pop
    //   2557: aload 15
    //   2559: ldc_w 499
    //   2562: aload 22
    //   2564: invokestatic 502	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   2567: invokevirtual 495	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2570: pop
    //   2571: aload 15
    //   2573: ldc_w 504
    //   2576: iload 7
    //   2578: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2581: invokevirtual 495	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2584: pop
    //   2585: aload 25
    //   2587: aload 15
    //   2589: invokevirtual 505	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2592: putfield 508	com/tencent/mm/model/bv:iFu	Ljava/lang/String;
    //   2595: iload 4
    //   2597: istore 5
    //   2599: iload_2
    //   2600: istore_3
    //   2601: ldc 76
    //   2603: ldc_w 510
    //   2606: iconst_1
    //   2607: anewarray 4	java/lang/Object
    //   2610: dup
    //   2611: iconst_0
    //   2612: aload 25
    //   2614: invokevirtual 380	com/tencent/mm/model/bv:aWe	()Ljava/lang/String;
    //   2617: aastore
    //   2618: invokestatic 144	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2621: iload 4
    //   2623: istore 5
    //   2625: iload_2
    //   2626: istore_3
    //   2627: aload 25
    //   2629: iload_2
    //   2630: i2l
    //   2631: lload 11
    //   2633: ladd
    //   2634: putfield 296	com/tencent/mm/model/bv:time	J
    //   2637: iload 4
    //   2639: istore 5
    //   2641: iload_2
    //   2642: istore_3
    //   2643: aload 25
    //   2645: iload 4
    //   2647: putfield 275	com/tencent/mm/model/bv:type	I
    //   2650: iload 4
    //   2652: istore 5
    //   2654: iload_2
    //   2655: istore_3
    //   2656: aload 25
    //   2658: aload 23
    //   2660: putfield 512	com/tencent/mm/model/bv:name	Ljava/lang/String;
    //   2663: iload 4
    //   2665: istore 5
    //   2667: iload_2
    //   2668: istore_3
    //   2669: aload 25
    //   2671: aload_1
    //   2672: putfield 372	com/tencent/mm/model/bv:iFt	Ljava/lang/String;
    //   2675: iload 4
    //   2677: istore 5
    //   2679: iload_2
    //   2680: istore_3
    //   2681: aload 18
    //   2683: aload 25
    //   2685: invokeinterface 515 2 0
    //   2690: pop
    //   2691: iload 6
    //   2693: iconst_1
    //   2694: iadd
    //   2695: istore 6
    //   2697: goto -958 -> 1739
    //   2700: iload 4
    //   2702: istore 5
    //   2704: iload_2
    //   2705: istore_3
    //   2706: aload 25
    //   2708: aload 21
    //   2710: new 53	java/lang/StringBuilder
    //   2713: dup
    //   2714: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   2717: aload 26
    //   2719: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2722: ldc_w 517
    //   2725: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2728: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2731: invokeinterface 211 2 0
    //   2736: checkcast 213	java/lang/String
    //   2739: putfield 415	com/tencent/mm/model/bv:iAo	Ljava/lang/String;
    //   2742: iload 4
    //   2744: istore 5
    //   2746: iload_2
    //   2747: istore_3
    //   2748: aload 25
    //   2750: aload 21
    //   2752: new 53	java/lang/StringBuilder
    //   2755: dup
    //   2756: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   2759: aload 26
    //   2761: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2764: ldc_w 417
    //   2767: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2770: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2773: invokeinterface 211 2 0
    //   2778: checkcast 213	java/lang/String
    //   2781: putfield 420	com/tencent/mm/model/bv:iAq	Ljava/lang/String;
    //   2784: goto -812 -> 1972
    //   2787: astore_1
    //   2788: iload 5
    //   2790: istore_2
    //   2791: ldc 76
    //   2793: aload_1
    //   2794: ldc_w 325
    //   2797: iconst_0
    //   2798: anewarray 4	java/lang/Object
    //   2801: invokestatic 521	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2804: goto -2276 -> 528
    //   2807: iconst_0
    //   2808: istore 7
    //   2810: goto -798 -> 2012
    //   2813: iload_2
    //   2814: iconst_1
    //   2815: iadd
    //   2816: istore_2
    //   2817: iload 4
    //   2819: istore_3
    //   2820: goto -2473 -> 347
    //   2823: iload_2
    //   2824: istore 4
    //   2826: iload_3
    //   2827: istore_2
    //   2828: iload 4
    //   2830: istore_3
    //   2831: goto -2303 -> 528
    //   2834: aload 14
    //   2836: invokevirtual 315	com/tencent/mm/model/bv:getUrl	()Ljava/lang/String;
    //   2839: invokestatic 265	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   2842: ifeq -2270 -> 572
    //   2845: ldc 76
    //   2847: new 53	java/lang/StringBuilder
    //   2850: dup
    //   2851: ldc_w 523
    //   2854: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2857: aload 14
    //   2859: invokevirtual 270	com/tencent/mm/model/bv:aVZ	()Ljava/lang/String;
    //   2862: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2865: ldc_w 272
    //   2868: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2871: aload 14
    //   2873: getfield 275	com/tencent/mm/model/bv:type	I
    //   2876: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2879: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2882: invokestatic 90	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2885: iconst_0
    //   2886: istore 4
    //   2888: goto -2242 -> 646
    //   2891: aload 16
    //   2893: getfield 323	com/tencent/mm/model/bv:iFm	Ljava/lang/String;
    //   2896: astore 14
    //   2898: goto -1982 -> 916
    //   2901: aload 16
    //   2903: getfield 372	com/tencent/mm/model/bv:iFt	Ljava/lang/String;
    //   2906: astore 14
    //   2908: goto -1745 -> 1163
    //   2911: iconst_0
    //   2912: istore 6
    //   2914: goto -1687 -> 1227
    //   2917: ldc 76
    //   2919: ldc_w 525
    //   2922: iconst_2
    //   2923: anewarray 4	java/lang/Object
    //   2926: dup
    //   2927: iconst_0
    //   2928: iload 5
    //   2930: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2933: aastore
    //   2934: dup
    //   2935: iconst_1
    //   2936: iload_3
    //   2937: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2940: aastore
    //   2941: invokestatic 179	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2944: iload 5
    //   2946: ifle +282 -> 3228
    //   2949: ldc_w 527
    //   2952: invokestatic 533	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   2955: checkcast 527	com/tencent/mm/plugin/messenger/foundation/a/l
    //   2958: invokeinterface 537 1 0
    //   2963: iload_2
    //   2964: invokestatic 540	com/tencent/mm/model/bv:sd	(I)Ljava/lang/String;
    //   2967: invokeinterface 546 2 0
    //   2972: astore 14
    //   2974: aload 14
    //   2976: ifnull +18 -> 2994
    //   2979: aload 14
    //   2981: getfield 551	com/tencent/mm/g/c/bb:field_username	Ljava/lang/String;
    //   2984: iload_2
    //   2985: invokestatic 540	com/tencent/mm/model/bv:sd	(I)Ljava/lang/String;
    //   2988: invokevirtual 448	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2991: ifne +172 -> 3163
    //   2994: new 553	com/tencent/mm/storage/az
    //   2997: dup
    //   2998: invokespecial 554	com/tencent/mm/storage/az:<init>	()V
    //   3001: astore 15
    //   3003: aload 15
    //   3005: iload_2
    //   3006: invokestatic 540	com/tencent/mm/model/bv:sd	(I)Ljava/lang/String;
    //   3009: invokevirtual 557	com/tencent/mm/storage/az:setUsername	(Ljava/lang/String;)V
    //   3012: aload_1
    //   3013: ifnonnull +132 -> 3145
    //   3016: ldc_w 325
    //   3019: astore 14
    //   3021: aload 15
    //   3023: aload 14
    //   3025: invokevirtual 560	com/tencent/mm/storage/az:setContent	(Ljava/lang/String;)V
    //   3028: aload_1
    //   3029: ifnonnull +125 -> 3154
    //   3032: invokestatic 563	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   3035: lstore 11
    //   3037: aload 15
    //   3039: lload 11
    //   3041: invokevirtual 566	com/tencent/mm/storage/az:yA	(J)V
    //   3044: aload 15
    //   3046: iconst_0
    //   3047: invokevirtual 569	com/tencent/mm/storage/az:nv	(I)V
    //   3050: aload 15
    //   3052: iload_3
    //   3053: invokevirtual 572	com/tencent/mm/storage/az:nt	(I)V
    //   3056: ldc_w 527
    //   3059: invokestatic 533	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   3062: checkcast 527	com/tencent/mm/plugin/messenger/foundation/a/l
    //   3065: invokeinterface 537 1 0
    //   3070: aload 15
    //   3072: invokeinterface 575 2 0
    //   3077: pop2
    //   3078: invokestatic 118	com/tencent/mm/plugin/readerapp/c/g:eHI	()Lcom/tencent/mm/model/bw;
    //   3081: invokevirtual 155	com/tencent/mm/model/bw:doNotify	()V
    //   3084: aload_1
    //   3085: invokevirtual 261	com/tencent/mm/model/bv:getTitle	()Ljava/lang/String;
    //   3088: astore_1
    //   3089: new 577	com/tencent/mm/storage/ca
    //   3092: dup
    //   3093: invokespecial 578	com/tencent/mm/storage/ca:<init>	()V
    //   3096: astore 14
    //   3098: aload 14
    //   3100: aload_1
    //   3101: invokevirtual 579	com/tencent/mm/storage/ca:setContent	(Ljava/lang/String;)V
    //   3104: aload 14
    //   3106: iload_2
    //   3107: invokestatic 540	com/tencent/mm/model/bv:sd	(I)Ljava/lang/String;
    //   3110: invokevirtual 582	com/tencent/mm/storage/ca:Cy	(Ljava/lang/String;)V
    //   3113: aload 14
    //   3115: iconst_1
    //   3116: invokevirtual 585	com/tencent/mm/storage/ca:setType	(I)V
    //   3119: aload 14
    //   3121: ldc2_w 586
    //   3124: invokevirtual 590	com/tencent/mm/storage/ca:setMsgId	(J)V
    //   3127: new 592	com/tencent/mm/ak/h$b
    //   3130: dup
    //   3131: aload 14
    //   3133: iconst_1
    //   3134: invokespecial 595	com/tencent/mm/ak/h$b:<init>	(Lcom/tencent/mm/storage/ca;Z)V
    //   3137: astore_1
    //   3138: ldc 41
    //   3140: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3143: aload_1
    //   3144: areturn
    //   3145: aload_1
    //   3146: invokevirtual 261	com/tencent/mm/model/bv:getTitle	()Ljava/lang/String;
    //   3149: astore 14
    //   3151: goto -130 -> 3021
    //   3154: aload_1
    //   3155: getfield 296	com/tencent/mm/model/bv:time	J
    //   3158: lstore 11
    //   3160: goto -123 -> 3037
    //   3163: aload 14
    //   3165: aload_1
    //   3166: invokevirtual 261	com/tencent/mm/model/bv:getTitle	()Ljava/lang/String;
    //   3169: invokevirtual 560	com/tencent/mm/storage/az:setContent	(Ljava/lang/String;)V
    //   3172: aload 14
    //   3174: aload_1
    //   3175: getfield 296	com/tencent/mm/model/bv:time	J
    //   3178: invokevirtual 566	com/tencent/mm/storage/az:yA	(J)V
    //   3181: aload 14
    //   3183: iconst_0
    //   3184: invokevirtual 569	com/tencent/mm/storage/az:nv	(I)V
    //   3187: aload 14
    //   3189: aload 14
    //   3191: getfield 598	com/tencent/mm/g/c/bb:field_unReadCount	I
    //   3194: iload_3
    //   3195: iadd
    //   3196: invokevirtual 572	com/tencent/mm/storage/az:nt	(I)V
    //   3199: ldc_w 527
    //   3202: invokestatic 533	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   3205: checkcast 527	com/tencent/mm/plugin/messenger/foundation/a/l
    //   3208: invokeinterface 537 1 0
    //   3213: aload 14
    //   3215: iload_2
    //   3216: invokestatic 540	com/tencent/mm/model/bv:sd	(I)Ljava/lang/String;
    //   3219: invokeinterface 601 3 0
    //   3224: pop
    //   3225: goto -147 -> 3078
    //   3228: ldc 76
    //   3230: ldc_w 603
    //   3233: invokestatic 90	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   3236: ldc 41
    //   3238: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3241: aconst_null
    //   3242: areturn
    //   3243: ldc 41
    //   3245: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3248: aconst_null
    //   3249: areturn
    //   3250: astore_1
    //   3251: iload_2
    //   3252: istore 4
    //   3254: iload_3
    //   3255: istore_2
    //   3256: iload 4
    //   3258: istore_3
    //   3259: goto -468 -> 2791
    //   3262: astore 15
    //   3264: goto -669 -> 2595
    //   3267: goto -2013 -> 1254
    //   3270: goto -2010 -> 1260
    //   3273: iconst_1
    //   3274: istore 4
    //   3276: goto -2630 -> 646
    //   3279: goto -3052 -> 227
    //   3282: iconst_0
    //   3283: istore 6
    //   3285: goto -1546 -> 1739
    //   3288: ldc_w 325
    //   3291: astore 15
    //   3293: goto -1509 -> 1784
    //   3296: aload 16
    //   3298: astore 15
    //   3300: goto -1341 -> 1959
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3303	0	this	c
    //   0	3303	1	parama	com.tencent.mm.ak.h.a
    //   280	2976	2	i	int
    //   298	2961	3	j	int
    //   291	2984	4	k	int
    //   295	2650	5	m	int
    //   1225	2059	6	n	int
    //   2010	799	7	i1	int
    //   454	2095	8	i2	int
    //   1549	195	9	i3	int
    //   2518	17	10	i4	int
    //   207	2952	11	l	long
    //   531	23	13	bool	boolean
    //   112	3102	14	localObject1	Object
    //   146	2925	15	localObject2	Object
    //   3262	1	15	localException	Exception
    //   3291	8	15	localObject3	Object
    //   698	2599	16	localObject4	Object
    //   718	1537	17	localObject5	Object
    //   288	2394	18	localArrayList	java.util.ArrayList
    //   9	1817	19	localde	com.tencent.mm.protocal.protobuf.de
    //   277	2024	20	localSimpleDateFormat	java.text.SimpleDateFormat
    //   307	2444	21	localMap	java.util.Map
    //   486	2077	22	str1	String
    //   1372	1287	23	str2	String
    //   1467	435	24	str3	String
    //   1815	934	25	localbv	bv
    //   1800	960	26	str4	String
    // Exception table:
    //   from	to	target	type
    //   299	309	2787	java/lang/Exception
    //   327	343	2787	java/lang/Exception
    //   1341	1374	2787	java/lang/Exception
    //   1380	1388	2787	java/lang/Exception
    //   1394	1422	2787	java/lang/Exception
    //   1436	1469	2787	java/lang/Exception
    //   1475	1508	2787	java/lang/Exception
    //   1514	1551	2787	java/lang/Exception
    //   1562	1590	2787	java/lang/Exception
    //   1610	1624	2787	java/lang/Exception
    //   1642	1654	2787	java/lang/Exception
    //   1672	1692	2787	java/lang/Exception
    //   1713	1736	2787	java/lang/Exception
    //   1752	1766	2787	java/lang/Exception
    //   1777	1784	2787	java/lang/Exception
    //   1790	1802	2787	java/lang/Exception
    //   1808	1817	2787	java/lang/Exception
    //   1823	1834	2787	java/lang/Exception
    //   1840	1876	2787	java/lang/Exception
    //   1887	1893	2787	java/lang/Exception
    //   1899	1906	2787	java/lang/Exception
    //   1912	1920	2787	java/lang/Exception
    //   1926	1959	2787	java/lang/Exception
    //   1965	1972	2787	java/lang/Exception
    //   1978	2009	2787	java/lang/Exception
    //   2018	2025	2787	java/lang/Exception
    //   2031	2067	2787	java/lang/Exception
    //   2073	2109	2787	java/lang/Exception
    //   2115	2151	2787	java/lang/Exception
    //   2157	2197	2787	java/lang/Exception
    //   2203	2236	2787	java/lang/Exception
    //   2251	2262	2787	java/lang/Exception
    //   2268	2284	2787	java/lang/Exception
    //   2290	2315	2787	java/lang/Exception
    //   2321	2337	2787	java/lang/Exception
    //   2343	2350	2787	java/lang/Exception
    //   2356	2392	2787	java/lang/Exception
    //   2398	2434	2787	java/lang/Exception
    //   2440	2477	2787	java/lang/Exception
    //   2483	2520	2787	java/lang/Exception
    //   2601	2621	2787	java/lang/Exception
    //   2627	2637	2787	java/lang/Exception
    //   2643	2650	2787	java/lang/Exception
    //   2656	2663	2787	java/lang/Exception
    //   2669	2675	2787	java/lang/Exception
    //   2681	2691	2787	java/lang/Exception
    //   2706	2742	2787	java/lang/Exception
    //   2748	2784	2787	java/lang/Exception
    //   351	362	3250	java/lang/Exception
    //   366	372	3250	java/lang/Exception
    //   372	488	3250	java/lang/Exception
    //   493	520	3250	java/lang/Exception
    //   1291	1324	3250	java/lang/Exception
    //   2520	2595	3262	java/lang/Exception
  }
  
  public final void b(h.c paramc)
  {
    AppMethodBeat.i(102664);
    Object localObject3 = (String)paramc.iMc;
    Log.i("MicroMsg.ReaderAppMsgExtension", "[onPreDelMessage] functionId:%s", new Object[] { localObject3 });
    label515:
    label518:
    for (;;)
    {
      try
      {
        localObject2 = g.eHI();
        localObject1 = ((com.tencent.mm.model.bw)localObject2).KE((String)localObject3);
        if ((localObject1 == null) || (((List)localObject1).size() == 0))
        {
          AppMethodBeat.o(102664);
          return;
        }
        paramc = (bv)((List)localObject1).get(0);
        Iterator localIterator = ((List)localObject1).iterator();
        if (localIterator.hasNext())
        {
          localObject1 = (bv)localIterator.next();
          if (((bv)localObject1).iFq != 1) {
            break label515;
          }
          paramc = (h.c)localObject1;
          break label518;
        }
        if (((com.tencent.mm.model.bw)localObject2).iFy.delete(com.tencent.mm.model.bw.se(20), "reserved3=?", new String[] { localObject3 }) >= 0) {
          ((com.tencent.mm.model.bw)localObject2).doNotify();
        }
        localObject1 = com.tencent.mm.model.bw.KD(com.tencent.mm.model.bw.se(20)) + " where istop = 1  group by time ORDER BY time DESC  limit 2";
        Log.i("MicroMsg.ReaderAppInfoStorage", "processConversationAfterDeleteInfo, sql is %s", new Object[] { localObject1 });
        localObject3 = ((com.tencent.mm.model.bw)localObject2).iFy.rawQuery((String)localObject1, null, 2);
        if (!((Cursor)localObject3).moveToFirst())
        {
          ((Cursor)localObject3).close();
          paramc = new az();
          paramc.setUsername(bv.sd(20));
          paramc.setContent("");
          paramc.yA(0L);
          paramc.nv(0);
          paramc.nt(0);
          ((l)com.tencent.mm.kernel.g.af(l.class)).aST().a(paramc, bv.sd(20));
          AppMethodBeat.o(102664);
          return;
        }
      }
      catch (Exception paramc)
      {
        Log.e("MicroMsg.ReaderAppMsgExtension", "[onPreDelMessage] Exception:%s", new Object[] { paramc });
        AppMethodBeat.o(102664);
        return;
      }
      Object localObject1 = ((l)com.tencent.mm.kernel.g.af(l.class)).aST().bjY(bv.sd(20));
      if (localObject1 == null)
      {
        Log.e("MicroMsg.ReaderAppInfoStorage", "[processConversationAfterDeleteInfo] originConv[%s] is null!", new Object[] { bv.sd(20) });
        AppMethodBeat.o(102664);
        return;
      }
      Object localObject2 = new bv();
      ((bv)localObject2).convertFrom((Cursor)localObject3);
      ((Cursor)localObject3).close();
      localObject3 = new az();
      ((az)localObject3).setUsername(bv.sd(20));
      ((az)localObject3).setContent(((bv)localObject2).getTitle());
      ((az)localObject3).yA(((bv)localObject2).time);
      ((az)localObject3).nv(0);
      if ((((bb)localObject1).field_unReadCount > 0) && (paramc != null) && (((bb)localObject1).field_content.equals(paramc.getTitle()))) {
        ((az)localObject3).nt(((bb)localObject1).field_unReadCount - 1);
      }
      for (;;)
      {
        ((l)com.tencent.mm.kernel.g.af(l.class)).aST().a((az)localObject3, bv.sd(20));
        AppMethodBeat.o(102664);
        return;
        ((az)localObject3).nt(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.c.c
 * JD-Core Version:    0.7.0.1
 */