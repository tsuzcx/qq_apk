package com.tencent.mm.plugin.readerapp.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.f;
import com.tencent.mm.am.f.b;
import com.tencent.mm.am.g.c;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bb;
import java.util.Iterator;
import java.util.List;

public final class b
  implements f
{
  private long NvG = 0L;
  
  public static boolean gFz()
  {
    AppMethodBeat.i(102663);
    if ((z.bAU() & 0x400) == 0)
    {
      AppMethodBeat.o(102663);
      return true;
    }
    AppMethodBeat.o(102663);
    return false;
  }
  
  public final void a(f.b paramb) {}
  
  public final int aTl()
  {
    return 12399999;
  }
  
  public final long aTm()
  {
    return 0L;
  }
  
  public final void aTn() {}
  
  /* Error */
  public final com.tencent.mm.am.g.b b(com.tencent.mm.am.g.a parama)
  {
    // Byte code:
    //   0: ldc 45
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: getfield 51	com/tencent/mm/am/g$a:mpN	Lcom/tencent/mm/protocal/protobuf/dl;
    //   9: astore 19
    //   11: aload_1
    //   12: getfield 55	com/tencent/mm/am/g$a:extra	Ljava/lang/Object;
    //   15: ifnonnull +60 -> 75
    //   18: new 57	java/lang/StringBuilder
    //   21: dup
    //   22: ldc 59
    //   24: invokespecial 62	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   27: invokestatic 67	java/lang/System:currentTimeMillis	()J
    //   30: ldc2_w 68
    //   33: ldiv
    //   34: invokevirtual 73	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   37: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: astore_1
    //   41: ldc 79
    //   43: ldc 81
    //   45: iconst_1
    //   46: anewarray 4	java/lang/Object
    //   49: dup
    //   50: iconst_0
    //   51: aload_1
    //   52: aastore
    //   53: invokestatic 87	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   56: aload 19
    //   58: ifnonnull +31 -> 89
    //   61: ldc 79
    //   63: ldc 89
    //   65: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: ldc 45
    //   70: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: aconst_null
    //   74: areturn
    //   75: aload_1
    //   76: getfield 55	com/tencent/mm/am/g$a:extra	Ljava/lang/Object;
    //   79: checkcast 95	com/tencent/mm/am/f$b
    //   82: getfield 99	com/tencent/mm/am/f$b:otL	Ljava/lang/String;
    //   85: astore_1
    //   86: goto -30 -> 56
    //   89: getstatic 105	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   92: sipush 13440
    //   95: iconst_1
    //   96: anewarray 4	java/lang/Object
    //   99: dup
    //   100: iconst_0
    //   101: iconst_1
    //   102: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   105: aastore
    //   106: invokevirtual 114	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   109: invokestatic 120	com/tencent/mm/plugin/readerapp/model/d:gFB	()Lcom/tencent/mm/model/by;
    //   112: astore 14
    //   114: new 57	java/lang/StringBuilder
    //   117: dup
    //   118: ldc 122
    //   120: invokespecial 62	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   123: bipush 20
    //   125: invokestatic 128	com/tencent/mm/model/by:vl	(I)Ljava/lang/String;
    //   128: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: ldc 133
    //   133: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload_1
    //   137: invokestatic 139	com/tencent/mm/storagebase/h:EQ	(Ljava/lang/String;)Ljava/lang/String;
    //   140: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: astore 15
    //   148: ldc 141
    //   150: ldc 143
    //   152: iconst_1
    //   153: anewarray 4	java/lang/Object
    //   156: dup
    //   157: iconst_0
    //   158: aload 15
    //   160: aastore
    //   161: invokestatic 146	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   164: aload 14
    //   166: getfield 150	com/tencent/mm/model/by:omV	Lcom/tencent/mm/storagebase/h;
    //   169: bipush 20
    //   171: invokestatic 128	com/tencent/mm/model/by:vl	(I)Ljava/lang/String;
    //   174: aload 15
    //   176: invokevirtual 154	com/tencent/mm/storagebase/h:execSQL	(Ljava/lang/String;Ljava/lang/String;)Z
    //   179: ifeq +8 -> 187
    //   182: aload 14
    //   184: invokevirtual 157	com/tencent/mm/model/by:doNotify	()V
    //   187: aload 19
    //   189: getfield 163	com/tencent/mm/protocal/protobuf/dl:YFG	Lcom/tencent/mm/protocal/protobuf/etl;
    //   192: invokestatic 168	com/tencent/mm/platformtools/w:a	(Lcom/tencent/mm/protocal/protobuf/etl;)Ljava/lang/String;
    //   195: astore 14
    //   197: aload 19
    //   199: getfield 172	com/tencent/mm/protocal/protobuf/dl:CreateTime	I
    //   202: i2l
    //   203: ldc2_w 68
    //   206: lmul
    //   207: lstore 11
    //   209: lload 11
    //   211: aload_0
    //   212: getfield 14	com/tencent/mm/plugin/readerapp/model/b:NvG	J
    //   215: lcmp
    //   216: ifgt +3102 -> 3318
    //   219: aload_0
    //   220: getfield 14	com/tencent/mm/plugin/readerapp/model/b:NvG	J
    //   223: lconst_1
    //   224: ladd
    //   225: lstore 11
    //   227: aload_0
    //   228: lload 11
    //   230: putfield 14	com/tencent/mm/plugin/readerapp/model/b:NvG	J
    //   233: ldc 79
    //   235: ldc 174
    //   237: iconst_2
    //   238: anewarray 4	java/lang/Object
    //   241: dup
    //   242: iconst_0
    //   243: aload 19
    //   245: getfield 172	com/tencent/mm/protocal/protobuf/dl:CreateTime	I
    //   248: i2l
    //   249: ldc2_w 68
    //   252: lmul
    //   253: invokestatic 179	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   256: aastore
    //   257: dup
    //   258: iconst_1
    //   259: lload 11
    //   261: invokestatic 179	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   264: aastore
    //   265: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   268: new 183	java/text/SimpleDateFormat
    //   271: dup
    //   272: ldc 185
    //   274: invokespecial 186	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   277: astore 20
    //   279: iconst_0
    //   280: istore_2
    //   281: new 188	java/util/ArrayList
    //   284: dup
    //   285: invokespecial 189	java/util/ArrayList:<init>	()V
    //   288: astore 18
    //   290: iconst_0
    //   291: istore 4
    //   293: iload 4
    //   295: istore 5
    //   297: iload_2
    //   298: istore_3
    //   299: aload 14
    //   301: ldc 191
    //   303: aconst_null
    //   304: invokestatic 197	com/tencent/mm/sdk/platformtools/XmlParser:parseXml	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
    //   307: astore 21
    //   309: aload 21
    //   311: ifnonnull +10 -> 321
    //   314: ldc 45
    //   316: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   319: aconst_null
    //   320: areturn
    //   321: iload 4
    //   323: istore 5
    //   325: iload_2
    //   326: istore_3
    //   327: ldc 79
    //   329: ldc 199
    //   331: iconst_1
    //   332: anewarray 4	java/lang/Object
    //   335: dup
    //   336: iconst_0
    //   337: aload 14
    //   339: aastore
    //   340: invokestatic 146	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   343: iconst_0
    //   344: istore_2
    //   345: iconst_0
    //   346: istore_3
    //   347: iload_2
    //   348: ifgt +2475 -> 2823
    //   351: new 57	java/lang/StringBuilder
    //   354: dup
    //   355: ldc 201
    //   357: invokespecial 62	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   360: astore 15
    //   362: iload_2
    //   363: ifle +906 -> 1269
    //   366: iload_2
    //   367: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   370: astore 14
    //   372: aload 15
    //   374: aload 14
    //   376: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   379: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: astore 14
    //   384: aload 21
    //   386: new 57	java/lang/StringBuilder
    //   389: dup
    //   390: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   393: aload 14
    //   395: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: ldc 207
    //   400: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: invokeinterface 213 2 0
    //   411: checkcast 215	java/lang/String
    //   414: iconst_0
    //   415: invokestatic 221	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   418: istore 4
    //   420: aload 21
    //   422: new 57	java/lang/StringBuilder
    //   425: dup
    //   426: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   429: aload 14
    //   431: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: ldc 223
    //   436: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokeinterface 213 2 0
    //   447: checkcast 215	java/lang/String
    //   450: iconst_m1
    //   451: invokestatic 221	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   454: istore 8
    //   456: aload 21
    //   458: new 57	java/lang/StringBuilder
    //   461: dup
    //   462: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   465: aload 14
    //   467: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: ldc 225
    //   472: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   478: invokeinterface 213 2 0
    //   483: checkcast 215	java/lang/String
    //   486: astore 22
    //   488: iload 4
    //   490: ifne +787 -> 1277
    //   493: ldc 79
    //   495: new 57	java/lang/StringBuilder
    //   498: dup
    //   499: ldc 227
    //   501: invokespecial 62	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   504: aload 14
    //   506: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: ldc 229
    //   511: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   517: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   520: iload_3
    //   521: istore 4
    //   523: iload_2
    //   524: istore_3
    //   525: iload 4
    //   527: istore_2
    //   528: invokestatic 231	com/tencent/mm/plugin/readerapp/model/b:gFz	()Z
    //   531: istore 13
    //   533: ldc 79
    //   535: new 57	java/lang/StringBuilder
    //   538: dup
    //   539: ldc 233
    //   541: invokespecial 62	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   544: iload_2
    //   545: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   548: ldc 238
    //   550: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: iload 13
    //   555: invokevirtual 241	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   558: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   561: invokestatic 243	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   564: aload 18
    //   566: invokeinterface 249 1 0
    //   571: astore_1
    //   572: aload_1
    //   573: invokeinterface 254 1 0
    //   578: ifeq +2734 -> 3312
    //   581: aload_1
    //   582: invokeinterface 258 1 0
    //   587: checkcast 260	com/tencent/mm/model/bx
    //   590: astore 14
    //   592: aload 14
    //   594: invokevirtual 263	com/tencent/mm/model/bx:getTitle	()Ljava/lang/String;
    //   597: invokestatic 267	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   600: ifeq +2234 -> 2834
    //   603: ldc 79
    //   605: new 57	java/lang/StringBuilder
    //   608: dup
    //   609: ldc_w 269
    //   612: invokespecial 62	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   615: aload 14
    //   617: invokevirtual 272	com/tencent/mm/model/bx:bCT	()Ljava/lang/String;
    //   620: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: ldc_w 274
    //   626: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: aload 14
    //   631: getfield 277	com/tencent/mm/model/bx:type	I
    //   634: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   637: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   640: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   643: iconst_0
    //   644: istore 4
    //   646: aload 18
    //   648: invokeinterface 280 1 0
    //   653: ifle +2629 -> 3282
    //   656: iload 4
    //   658: ifeq +2624 -> 3282
    //   661: iconst_0
    //   662: istore 5
    //   664: aconst_null
    //   665: astore_1
    //   666: iconst_0
    //   667: istore 4
    //   669: iload 4
    //   671: aload 18
    //   673: invokeinterface 280 1 0
    //   678: if_icmpge +2239 -> 2917
    //   681: invokestatic 120	com/tencent/mm/plugin/readerapp/model/d:gFB	()Lcom/tencent/mm/model/by;
    //   684: astore 15
    //   686: aload 18
    //   688: iload 4
    //   690: invokeinterface 283 2 0
    //   695: checkcast 260	com/tencent/mm/model/bx
    //   698: astore 16
    //   700: aload 16
    //   702: ifnull +2209 -> 2911
    //   705: aload 16
    //   707: iconst_m1
    //   708: putfield 286	com/tencent/mm/model/bx:eQp	I
    //   711: new 288	android/content/ContentValues
    //   714: dup
    //   715: invokespecial 289	android/content/ContentValues:<init>	()V
    //   718: astore 17
    //   720: aload 16
    //   722: getfield 286	com/tencent/mm/model/bx:eQp	I
    //   725: iconst_1
    //   726: iand
    //   727: ifeq +16 -> 743
    //   730: aload 17
    //   732: ldc_w 291
    //   735: aload 16
    //   737: invokevirtual 272	com/tencent/mm/model/bx:bCT	()Ljava/lang/String;
    //   740: invokevirtual 294	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   743: aload 16
    //   745: getfield 286	com/tencent/mm/model/bx:eQp	I
    //   748: iconst_2
    //   749: iand
    //   750: ifeq +19 -> 769
    //   753: aload 17
    //   755: ldc_w 296
    //   758: aload 16
    //   760: getfield 298	com/tencent/mm/model/bx:time	J
    //   763: invokestatic 179	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   766: invokevirtual 301	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   769: aload 16
    //   771: getfield 286	com/tencent/mm/model/bx:eQp	I
    //   774: iconst_4
    //   775: iand
    //   776: ifeq +19 -> 795
    //   779: aload 17
    //   781: ldc_w 302
    //   784: aload 16
    //   786: getfield 277	com/tencent/mm/model/bx:type	I
    //   789: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   792: invokevirtual 305	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   795: aload 16
    //   797: getfield 286	com/tencent/mm/model/bx:eQp	I
    //   800: bipush 8
    //   802: iand
    //   803: ifeq +16 -> 819
    //   806: aload 17
    //   808: ldc_w 307
    //   811: aload 16
    //   813: invokevirtual 310	com/tencent/mm/model/bx:getName	()Ljava/lang/String;
    //   816: invokevirtual 294	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   819: aload 16
    //   821: getfield 286	com/tencent/mm/model/bx:eQp	I
    //   824: bipush 16
    //   826: iand
    //   827: ifeq +16 -> 843
    //   830: aload 17
    //   832: ldc_w 312
    //   835: aload 16
    //   837: invokevirtual 263	com/tencent/mm/model/bx:getTitle	()Ljava/lang/String;
    //   840: invokevirtual 294	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   843: aload 16
    //   845: getfield 286	com/tencent/mm/model/bx:eQp	I
    //   848: bipush 32
    //   850: iand
    //   851: ifeq +16 -> 867
    //   854: aload 17
    //   856: ldc_w 314
    //   859: aload 16
    //   861: invokevirtual 317	com/tencent/mm/model/bx:getUrl	()Ljava/lang/String;
    //   864: invokevirtual 294	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   867: aload 16
    //   869: getfield 286	com/tencent/mm/model/bx:eQp	I
    //   872: bipush 64
    //   874: iand
    //   875: ifeq +16 -> 891
    //   878: aload 17
    //   880: ldc_w 319
    //   883: aload 16
    //   885: invokevirtual 322	com/tencent/mm/model/bx:bCU	()Ljava/lang/String;
    //   888: invokevirtual 294	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   891: aload 16
    //   893: getfield 286	com/tencent/mm/model/bx:eQp	I
    //   896: sipush 128
    //   899: iand
    //   900: ifeq +26 -> 926
    //   903: aload 16
    //   905: getfield 325	com/tencent/mm/model/bx:omL	Ljava/lang/String;
    //   908: ifnonnull +1983 -> 2891
    //   911: ldc_w 327
    //   914: astore 14
    //   916: aload 17
    //   918: ldc_w 329
    //   921: aload 14
    //   923: invokevirtual 294	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   926: aload 16
    //   928: getfield 286	com/tencent/mm/model/bx:eQp	I
    //   931: sipush 256
    //   934: iand
    //   935: ifeq +19 -> 954
    //   938: aload 17
    //   940: ldc_w 331
    //   943: aload 16
    //   945: getfield 334	com/tencent/mm/model/bx:omM	J
    //   948: invokestatic 179	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   951: invokevirtual 301	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   954: aload 16
    //   956: getfield 286	com/tencent/mm/model/bx:eQp	I
    //   959: sipush 512
    //   962: iand
    //   963: ifeq +16 -> 979
    //   966: aload 17
    //   968: ldc_w 336
    //   971: aload 16
    //   973: invokevirtual 339	com/tencent/mm/model/bx:bCV	()Ljava/lang/String;
    //   976: invokevirtual 294	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   979: aload 16
    //   981: getfield 286	com/tencent/mm/model/bx:eQp	I
    //   984: sipush 1024
    //   987: iand
    //   988: ifeq +16 -> 1004
    //   991: aload 17
    //   993: ldc_w 341
    //   996: aload 16
    //   998: invokevirtual 344	com/tencent/mm/model/bx:bCW	()Ljava/lang/String;
    //   1001: invokevirtual 294	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1004: aload 16
    //   1006: getfield 286	com/tencent/mm/model/bx:eQp	I
    //   1009: sipush 2048
    //   1012: iand
    //   1013: ifeq +19 -> 1032
    //   1016: aload 17
    //   1018: ldc_w 346
    //   1021: aload 16
    //   1023: getfield 349	com/tencent/mm/model/bx:omN	I
    //   1026: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1029: invokevirtual 305	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1032: aload 16
    //   1034: getfield 286	com/tencent/mm/model/bx:eQp	I
    //   1037: sipush 4096
    //   1040: iand
    //   1041: ifeq +16 -> 1057
    //   1044: aload 17
    //   1046: ldc_w 351
    //   1049: aload 16
    //   1051: invokevirtual 354	com/tencent/mm/model/bx:bCX	()Ljava/lang/String;
    //   1054: invokevirtual 294	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1057: aload 16
    //   1059: getfield 286	com/tencent/mm/model/bx:eQp	I
    //   1062: sipush 8192
    //   1065: iand
    //   1066: ifeq +16 -> 1082
    //   1069: aload 17
    //   1071: ldc_w 356
    //   1074: aload 16
    //   1076: invokevirtual 359	com/tencent/mm/model/bx:getDigest	()Ljava/lang/String;
    //   1079: invokevirtual 294	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1082: aload 16
    //   1084: getfield 286	com/tencent/mm/model/bx:eQp	I
    //   1087: sipush 16384
    //   1090: iand
    //   1091: ifeq +19 -> 1110
    //   1094: aload 17
    //   1096: ldc_w 361
    //   1099: aload 16
    //   1101: getfield 364	com/tencent/mm/model/bx:omO	I
    //   1104: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1107: invokevirtual 305	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1110: aload 16
    //   1112: getfield 286	com/tencent/mm/model/bx:eQp	I
    //   1115: ldc_w 365
    //   1118: iand
    //   1119: ifeq +19 -> 1138
    //   1122: aload 17
    //   1124: ldc_w 367
    //   1127: aload 16
    //   1129: getfield 370	com/tencent/mm/model/bx:omP	J
    //   1132: invokestatic 179	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1135: invokevirtual 301	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   1138: aload 16
    //   1140: getfield 286	com/tencent/mm/model/bx:eQp	I
    //   1143: ldc_w 371
    //   1146: iand
    //   1147: ifeq +26 -> 1173
    //   1150: aload 16
    //   1152: getfield 374	com/tencent/mm/model/bx:omQ	Ljava/lang/String;
    //   1155: ifnonnull +1746 -> 2901
    //   1158: ldc_w 327
    //   1161: astore 14
    //   1163: aload 17
    //   1165: ldc_w 376
    //   1168: aload 14
    //   1170: invokevirtual 294	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1173: aload 16
    //   1175: getfield 286	com/tencent/mm/model/bx:eQp	I
    //   1178: ldc_w 377
    //   1181: iand
    //   1182: ifeq +16 -> 1198
    //   1185: aload 17
    //   1187: ldc_w 379
    //   1190: aload 16
    //   1192: invokevirtual 382	com/tencent/mm/model/bx:bCY	()Ljava/lang/String;
    //   1195: invokevirtual 294	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1198: aload 15
    //   1200: getfield 150	com/tencent/mm/model/by:omV	Lcom/tencent/mm/storagebase/h;
    //   1203: aload 16
    //   1205: getfield 277	com/tencent/mm/model/bx:type	I
    //   1208: invokestatic 128	com/tencent/mm/model/by:vl	(I)Ljava/lang/String;
    //   1211: ldc_w 291
    //   1214: aload 17
    //   1216: invokevirtual 386	com/tencent/mm/storagebase/h:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   1219: l2i
    //   1220: iconst_m1
    //   1221: if_icmpeq +1690 -> 2911
    //   1224: iconst_1
    //   1225: istore 6
    //   1227: iload 6
    //   1229: ifeq +2080 -> 3309
    //   1232: aload_1
    //   1233: ifnonnull +2073 -> 3306
    //   1236: aload 18
    //   1238: iload 4
    //   1240: invokeinterface 283 2 0
    //   1245: checkcast 260	com/tencent/mm/model/bx
    //   1248: astore_1
    //   1249: aload_1
    //   1250: iconst_1
    //   1251: putfield 349	com/tencent/mm/model/bx:omN	I
    //   1254: iload 5
    //   1256: iconst_1
    //   1257: iadd
    //   1258: istore 5
    //   1260: iload 4
    //   1262: iconst_1
    //   1263: iadd
    //   1264: istore 4
    //   1266: goto -597 -> 669
    //   1269: ldc_w 327
    //   1272: astore 14
    //   1274: goto -902 -> 372
    //   1277: iload 4
    //   1279: bipush 20
    //   1281: if_icmpeq +54 -> 1335
    //   1284: iload 4
    //   1286: bipush 11
    //   1288: if_icmpeq +47 -> 1335
    //   1291: ldc 79
    //   1293: new 57	java/lang/StringBuilder
    //   1296: dup
    //   1297: ldc 227
    //   1299: invokespecial 62	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1302: aload 14
    //   1304: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1307: ldc_w 388
    //   1310: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1313: iload 4
    //   1315: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1318: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1321: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   1343: new 57	java/lang/StringBuilder
    //   1346: dup
    //   1347: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   1350: aload 14
    //   1352: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1355: ldc_w 390
    //   1358: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1361: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1364: invokeinterface 213 2 0
    //   1369: checkcast 215	java/lang/String
    //   1372: astore 23
    //   1374: iload 4
    //   1376: istore 5
    //   1378: iload_2
    //   1379: istore_3
    //   1380: aload 23
    //   1382: invokestatic 267	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1385: ifeq +45 -> 1430
    //   1388: iload 4
    //   1390: istore 5
    //   1392: iload_2
    //   1393: istore_3
    //   1394: ldc 79
    //   1396: new 57	java/lang/StringBuilder
    //   1399: dup
    //   1400: ldc 227
    //   1402: invokespecial 62	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1405: aload 14
    //   1407: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1410: ldc_w 392
    //   1413: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1416: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1419: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   1438: new 57	java/lang/StringBuilder
    //   1441: dup
    //   1442: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   1445: aload 14
    //   1447: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1450: ldc_w 394
    //   1453: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1456: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1459: invokeinterface 213 2 0
    //   1464: checkcast 215	java/lang/String
    //   1467: astore 24
    //   1469: iload 4
    //   1471: istore 5
    //   1473: iload_2
    //   1474: istore_3
    //   1475: aload 21
    //   1477: new 57	java/lang/StringBuilder
    //   1480: dup
    //   1481: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   1484: aload 14
    //   1486: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1489: ldc_w 396
    //   1492: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1495: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1498: invokeinterface 213 2 0
    //   1503: checkcast 215	java/lang/String
    //   1506: astore 16
    //   1508: iload 4
    //   1510: istore 5
    //   1512: iload_2
    //   1513: istore_3
    //   1514: aload 21
    //   1516: new 57	java/lang/StringBuilder
    //   1519: dup
    //   1520: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   1523: aload 14
    //   1525: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1528: ldc_w 398
    //   1531: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1534: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1537: invokeinterface 213 2 0
    //   1542: checkcast 215	java/lang/String
    //   1545: iconst_0
    //   1546: invokestatic 221	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   1549: istore 9
    //   1551: iload 9
    //   1553: ifne +45 -> 1598
    //   1556: iload 4
    //   1558: istore 5
    //   1560: iload_2
    //   1561: istore_3
    //   1562: ldc 79
    //   1564: new 57	java/lang/StringBuilder
    //   1567: dup
    //   1568: ldc 227
    //   1570: invokespecial 62	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1573: aload 14
    //   1575: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1578: ldc_w 400
    //   1581: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1584: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1587: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   1610: new 57	java/lang/StringBuilder
    //   1613: dup
    //   1614: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   1617: aload 14
    //   1619: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1622: astore 15
    //   1624: iload 4
    //   1626: bipush 20
    //   1628: if_icmpne +71 -> 1699
    //   1631: ldc_w 402
    //   1634: astore 14
    //   1636: iload 4
    //   1638: istore 5
    //   1640: iload_2
    //   1641: istore_3
    //   1642: aload 15
    //   1644: aload 14
    //   1646: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1649: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1652: astore 14
    //   1654: iconst_1
    //   1655: iload 8
    //   1657: if_icmpne +1664 -> 3321
    //   1660: iload 9
    //   1662: iconst_2
    //   1663: if_icmpge +1658 -> 3321
    //   1666: iload 4
    //   1668: istore 5
    //   1670: iload_2
    //   1671: istore_3
    //   1672: ldc 79
    //   1674: ldc_w 404
    //   1677: iconst_1
    //   1678: anewarray 4	java/lang/Object
    //   1681: dup
    //   1682: iconst_0
    //   1683: iload 9
    //   1685: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1688: aastore
    //   1689: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1692: ldc 45
    //   1694: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1697: aconst_null
    //   1698: areturn
    //   1699: ldc_w 406
    //   1702: astore 14
    //   1704: goto -68 -> 1636
    //   1707: iload 4
    //   1709: istore 5
    //   1711: iload_2
    //   1712: istore_3
    //   1713: new 57	java/lang/StringBuilder
    //   1716: dup
    //   1717: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   1720: aload 14
    //   1722: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1725: ldc_w 406
    //   1728: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1731: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1734: astore 14
    //   1736: goto -82 -> 1654
    //   1739: iload 6
    //   1741: iload 9
    //   1743: if_icmpge +1070 -> 2813
    //   1746: iload 4
    //   1748: istore 5
    //   1750: iload_2
    //   1751: istore_3
    //   1752: new 57	java/lang/StringBuilder
    //   1755: dup
    //   1756: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   1759: aload 14
    //   1761: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1764: astore 17
    //   1766: iload 6
    //   1768: ifle +1559 -> 3327
    //   1771: iload 4
    //   1773: istore 5
    //   1775: iload_2
    //   1776: istore_3
    //   1777: iload 6
    //   1779: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1782: astore 15
    //   1784: iload 4
    //   1786: istore 5
    //   1788: iload_2
    //   1789: istore_3
    //   1790: aload 17
    //   1792: aload 15
    //   1794: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1797: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1800: astore 26
    //   1802: iload 4
    //   1804: istore 5
    //   1806: iload_2
    //   1807: istore_3
    //   1808: new 260	com/tencent/mm/model/bx
    //   1811: dup
    //   1812: invokespecial 407	com/tencent/mm/model/bx:<init>	()V
    //   1815: astore 25
    //   1817: iload 4
    //   1819: istore 5
    //   1821: iload_2
    //   1822: istore_3
    //   1823: aload 25
    //   1825: aload 19
    //   1827: getfield 410	com/tencent/mm/protocal/protobuf/dl:Njs	I
    //   1830: i2l
    //   1831: putfield 370	com/tencent/mm/model/bx:omP	J
    //   1834: iload 4
    //   1836: istore 5
    //   1838: iload_2
    //   1839: istore_3
    //   1840: aload 25
    //   1842: aload 21
    //   1844: new 57	java/lang/StringBuilder
    //   1847: dup
    //   1848: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   1851: aload 26
    //   1853: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1856: ldc_w 412
    //   1859: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1862: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1865: invokeinterface 213 2 0
    //   1870: checkcast 215	java/lang/String
    //   1873: putfield 414	com/tencent/mm/model/bx:title	Ljava/lang/String;
    //   1876: iload 6
    //   1878: ifne +822 -> 2700
    //   1881: iload 4
    //   1883: istore 5
    //   1885: iload_2
    //   1886: istore_3
    //   1887: aload 25
    //   1889: iconst_1
    //   1890: putfield 349	com/tencent/mm/model/bx:omN	I
    //   1893: iload 4
    //   1895: istore 5
    //   1897: iload_2
    //   1898: istore_3
    //   1899: aload 25
    //   1901: aload 24
    //   1903: putfield 417	com/tencent/mm/model/bx:nUM	Ljava/lang/String;
    //   1906: iload 4
    //   1908: istore 5
    //   1910: iload_2
    //   1911: istore_3
    //   1912: aload 16
    //   1914: invokestatic 267	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1917: ifeq +1418 -> 3335
    //   1920: iload 4
    //   1922: istore 5
    //   1924: iload_2
    //   1925: istore_3
    //   1926: aload 21
    //   1928: new 57	java/lang/StringBuilder
    //   1931: dup
    //   1932: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   1935: aload 26
    //   1937: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1940: ldc_w 419
    //   1943: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1946: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1949: invokeinterface 213 2 0
    //   1954: checkcast 215	java/lang/String
    //   1957: astore 15
    //   1959: iload 4
    //   1961: istore 5
    //   1963: iload_2
    //   1964: istore_3
    //   1965: aload 25
    //   1967: aload 15
    //   1969: putfield 422	com/tencent/mm/model/bx:nUO	Ljava/lang/String;
    //   1972: iload 4
    //   1974: istore 5
    //   1976: iload_2
    //   1977: istore_3
    //   1978: aload 21
    //   1980: new 57	java/lang/StringBuilder
    //   1983: dup
    //   1984: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   1987: aload 26
    //   1989: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1992: ldc_w 424
    //   1995: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1998: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2001: invokeinterface 428 2 0
    //   2006: ifeq +801 -> 2807
    //   2009: iconst_1
    //   2010: istore 7
    //   2012: iload 4
    //   2014: istore 5
    //   2016: iload_2
    //   2017: istore_3
    //   2018: aload 25
    //   2020: iload 7
    //   2022: putfield 364	com/tencent/mm/model/bx:omO	I
    //   2025: iload 4
    //   2027: istore 5
    //   2029: iload_2
    //   2030: istore_3
    //   2031: aload 25
    //   2033: aload 21
    //   2035: new 57	java/lang/StringBuilder
    //   2038: dup
    //   2039: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   2042: aload 26
    //   2044: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2047: ldc_w 430
    //   2050: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2053: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2056: invokeinterface 213 2 0
    //   2061: checkcast 215	java/lang/String
    //   2064: putfield 432	com/tencent/mm/model/bx:url	Ljava/lang/String;
    //   2067: iload 4
    //   2069: istore 5
    //   2071: iload_2
    //   2072: istore_3
    //   2073: aload 25
    //   2075: aload 21
    //   2077: new 57	java/lang/StringBuilder
    //   2080: dup
    //   2081: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   2084: aload 26
    //   2086: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2089: ldc_w 434
    //   2092: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2095: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2098: invokeinterface 213 2 0
    //   2103: checkcast 215	java/lang/String
    //   2106: putfield 437	com/tencent/mm/model/bx:omK	Ljava/lang/String;
    //   2109: iload 4
    //   2111: istore 5
    //   2113: iload_2
    //   2114: istore_3
    //   2115: aload 25
    //   2117: aload 21
    //   2119: new 57	java/lang/StringBuilder
    //   2122: dup
    //   2123: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   2126: aload 26
    //   2128: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2131: ldc_w 439
    //   2134: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2137: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2140: invokeinterface 213 2 0
    //   2145: checkcast 215	java/lang/String
    //   2148: putfield 325	com/tencent/mm/model/bx:omL	Ljava/lang/String;
    //   2151: iload 4
    //   2153: istore 5
    //   2155: iload_2
    //   2156: istore_3
    //   2157: aload 25
    //   2159: aload 21
    //   2161: new 57	java/lang/StringBuilder
    //   2164: dup
    //   2165: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   2168: aload 26
    //   2170: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2173: ldc_w 441
    //   2176: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2179: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2182: invokeinterface 213 2 0
    //   2187: checkcast 215	java/lang/String
    //   2190: lconst_0
    //   2191: invokestatic 445	com/tencent/mm/sdk/platformtools/Util:getLong	(Ljava/lang/String;J)J
    //   2194: putfield 334	com/tencent/mm/model/bx:omM	J
    //   2197: iload 4
    //   2199: istore 5
    //   2201: iload_2
    //   2202: istore_3
    //   2203: aload 21
    //   2205: new 57	java/lang/StringBuilder
    //   2208: dup
    //   2209: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   2212: aload 26
    //   2214: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2217: ldc_w 447
    //   2220: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2223: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2226: invokeinterface 213 2 0
    //   2231: checkcast 215	java/lang/String
    //   2234: astore 17
    //   2236: aload 17
    //   2238: ifnull +24 -> 2262
    //   2241: aload 17
    //   2243: astore 15
    //   2245: iload 4
    //   2247: istore 5
    //   2249: iload_2
    //   2250: istore_3
    //   2251: ldc_w 327
    //   2254: aload 17
    //   2256: invokevirtual 450	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2259: ifeq +78 -> 2337
    //   2262: iload 4
    //   2264: istore 5
    //   2266: iload_2
    //   2267: istore_3
    //   2268: new 452	java/util/Date
    //   2271: dup
    //   2272: invokestatic 67	java/lang/System:currentTimeMillis	()J
    //   2275: iload 6
    //   2277: i2l
    //   2278: ladd
    //   2279: invokespecial 455	java/util/Date:<init>	(J)V
    //   2282: astore 15
    //   2284: iload 4
    //   2286: istore 5
    //   2288: iload_2
    //   2289: istore_3
    //   2290: new 57	java/lang/StringBuilder
    //   2293: dup
    //   2294: ldc_w 457
    //   2297: invokespecial 62	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2300: aload 20
    //   2302: aload 15
    //   2304: invokevirtual 461	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   2307: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2310: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2313: astore 15
    //   2315: iload 4
    //   2317: istore 5
    //   2319: iload_2
    //   2320: istore_3
    //   2321: ldc 79
    //   2323: ldc_w 463
    //   2326: aload 15
    //   2328: invokestatic 466	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   2331: invokevirtual 469	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2334: invokestatic 471	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2337: iload 4
    //   2339: istore 5
    //   2341: iload_2
    //   2342: istore_3
    //   2343: aload 25
    //   2345: aload 15
    //   2347: putfield 474	com/tencent/mm/model/bx:omJ	Ljava/lang/String;
    //   2350: iload 4
    //   2352: istore 5
    //   2354: iload_2
    //   2355: istore_3
    //   2356: aload 25
    //   2358: aload 21
    //   2360: new 57	java/lang/StringBuilder
    //   2363: dup
    //   2364: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   2367: aload 26
    //   2369: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2372: ldc_w 476
    //   2375: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2378: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2381: invokeinterface 213 2 0
    //   2386: checkcast 215	java/lang/String
    //   2389: putfield 479	com/tencent/mm/model/bx:sourceName	Ljava/lang/String;
    //   2392: iload 4
    //   2394: istore 5
    //   2396: iload_2
    //   2397: istore_3
    //   2398: aload 25
    //   2400: aload 21
    //   2402: new 57	java/lang/StringBuilder
    //   2405: dup
    //   2406: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   2409: aload 26
    //   2411: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2414: ldc_w 481
    //   2417: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2420: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2423: invokeinterface 213 2 0
    //   2428: checkcast 215	java/lang/String
    //   2431: putfield 484	com/tencent/mm/model/bx:sourceIcon	Ljava/lang/String;
    //   2434: iload 4
    //   2436: istore 5
    //   2438: iload_2
    //   2439: istore_3
    //   2440: aload 21
    //   2442: new 57	java/lang/StringBuilder
    //   2445: dup
    //   2446: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   2449: aload 26
    //   2451: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2454: ldc_w 486
    //   2457: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2460: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2463: invokeinterface 213 2 0
    //   2468: checkcast 215	java/lang/String
    //   2471: iconst_m1
    //   2472: invokestatic 221	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   2475: istore 7
    //   2477: iload 4
    //   2479: istore 5
    //   2481: iload_2
    //   2482: istore_3
    //   2483: aload 21
    //   2485: new 57	java/lang/StringBuilder
    //   2488: dup
    //   2489: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   2492: aload 26
    //   2494: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2497: ldc_w 488
    //   2500: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2503: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2506: invokeinterface 213 2 0
    //   2511: checkcast 215	java/lang/String
    //   2514: iconst_m1
    //   2515: invokestatic 221	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   2518: istore 10
    //   2520: new 490	org/json/JSONObject
    //   2523: dup
    //   2524: invokespecial 491	org/json/JSONObject:<init>	()V
    //   2527: astore 15
    //   2529: aload 15
    //   2531: ldc_w 493
    //   2534: iload 10
    //   2536: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2539: invokevirtual 497	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2542: pop
    //   2543: aload 15
    //   2545: ldc_w 499
    //   2548: iload 8
    //   2550: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2553: invokevirtual 497	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2556: pop
    //   2557: aload 15
    //   2559: ldc_w 501
    //   2562: aload 22
    //   2564: invokestatic 504	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   2567: invokevirtual 497	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2570: pop
    //   2571: aload 15
    //   2573: ldc_w 506
    //   2576: iload 7
    //   2578: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2581: invokevirtual 497	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2584: pop
    //   2585: aload 25
    //   2587: aload 15
    //   2589: invokevirtual 507	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2592: putfield 510	com/tencent/mm/model/bx:omR	Ljava/lang/String;
    //   2595: iload 4
    //   2597: istore 5
    //   2599: iload_2
    //   2600: istore_3
    //   2601: ldc 79
    //   2603: ldc_w 512
    //   2606: iconst_1
    //   2607: anewarray 4	java/lang/Object
    //   2610: dup
    //   2611: iconst_0
    //   2612: aload 25
    //   2614: invokevirtual 382	com/tencent/mm/model/bx:bCY	()Ljava/lang/String;
    //   2617: aastore
    //   2618: invokestatic 146	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2621: iload 4
    //   2623: istore 5
    //   2625: iload_2
    //   2626: istore_3
    //   2627: aload 25
    //   2629: iload_2
    //   2630: i2l
    //   2631: lload 11
    //   2633: ladd
    //   2634: putfield 298	com/tencent/mm/model/bx:time	J
    //   2637: iload 4
    //   2639: istore 5
    //   2641: iload_2
    //   2642: istore_3
    //   2643: aload 25
    //   2645: iload 4
    //   2647: putfield 277	com/tencent/mm/model/bx:type	I
    //   2650: iload 4
    //   2652: istore 5
    //   2654: iload_2
    //   2655: istore_3
    //   2656: aload 25
    //   2658: aload 23
    //   2660: putfield 514	com/tencent/mm/model/bx:name	Ljava/lang/String;
    //   2663: iload 4
    //   2665: istore 5
    //   2667: iload_2
    //   2668: istore_3
    //   2669: aload 25
    //   2671: aload_1
    //   2672: putfield 374	com/tencent/mm/model/bx:omQ	Ljava/lang/String;
    //   2675: iload 4
    //   2677: istore 5
    //   2679: iload_2
    //   2680: istore_3
    //   2681: aload 18
    //   2683: aload 25
    //   2685: invokeinterface 517 2 0
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
    //   2710: new 57	java/lang/StringBuilder
    //   2713: dup
    //   2714: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   2717: aload 26
    //   2719: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2722: ldc_w 519
    //   2725: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2728: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2731: invokeinterface 213 2 0
    //   2736: checkcast 215	java/lang/String
    //   2739: putfield 417	com/tencent/mm/model/bx:nUM	Ljava/lang/String;
    //   2742: iload 4
    //   2744: istore 5
    //   2746: iload_2
    //   2747: istore_3
    //   2748: aload 25
    //   2750: aload 21
    //   2752: new 57	java/lang/StringBuilder
    //   2755: dup
    //   2756: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   2759: aload 26
    //   2761: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2764: ldc_w 419
    //   2767: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2770: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2773: invokeinterface 213 2 0
    //   2778: checkcast 215	java/lang/String
    //   2781: putfield 422	com/tencent/mm/model/bx:nUO	Ljava/lang/String;
    //   2784: goto -812 -> 1972
    //   2787: astore_1
    //   2788: iload 5
    //   2790: istore_2
    //   2791: ldc 79
    //   2793: aload_1
    //   2794: ldc_w 327
    //   2797: iconst_0
    //   2798: anewarray 4	java/lang/Object
    //   2801: invokestatic 523	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   2836: invokevirtual 317	com/tencent/mm/model/bx:getUrl	()Ljava/lang/String;
    //   2839: invokestatic 267	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   2842: ifeq -2270 -> 572
    //   2845: ldc 79
    //   2847: new 57	java/lang/StringBuilder
    //   2850: dup
    //   2851: ldc_w 525
    //   2854: invokespecial 62	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2857: aload 14
    //   2859: invokevirtual 272	com/tencent/mm/model/bx:bCT	()Ljava/lang/String;
    //   2862: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2865: ldc_w 274
    //   2868: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2871: aload 14
    //   2873: getfield 277	com/tencent/mm/model/bx:type	I
    //   2876: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2879: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2882: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2885: iconst_0
    //   2886: istore 4
    //   2888: goto -2242 -> 646
    //   2891: aload 16
    //   2893: getfield 325	com/tencent/mm/model/bx:omL	Ljava/lang/String;
    //   2896: astore 14
    //   2898: goto -1982 -> 916
    //   2901: aload 16
    //   2903: getfield 374	com/tencent/mm/model/bx:omQ	Ljava/lang/String;
    //   2906: astore 14
    //   2908: goto -1745 -> 1163
    //   2911: iconst_0
    //   2912: istore 6
    //   2914: goto -1687 -> 1227
    //   2917: ldc 79
    //   2919: ldc_w 527
    //   2922: iconst_2
    //   2923: anewarray 4	java/lang/Object
    //   2926: dup
    //   2927: iconst_0
    //   2928: iload 5
    //   2930: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2933: aastore
    //   2934: dup
    //   2935: iconst_1
    //   2936: iload_3
    //   2937: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2940: aastore
    //   2941: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2944: iload 5
    //   2946: ifle +321 -> 3267
    //   2949: invokestatic 120	com/tencent/mm/plugin/readerapp/model/d:gFB	()Lcom/tencent/mm/model/by;
    //   2952: astore 14
    //   2954: getstatic 531	com/tencent/mm/model/by:omW	Z
    //   2957: ifne +31 -> 2988
    //   2960: iconst_1
    //   2961: putstatic 531	com/tencent/mm/model/by:omW	Z
    //   2964: getstatic 537	com/tencent/threadpool/h:ahAA	Lcom/tencent/threadpool/i;
    //   2967: new 539	com/tencent/mm/model/by$1
    //   2970: dup
    //   2971: aload 14
    //   2973: invokespecial 542	com/tencent/mm/model/by$1:<init>	(Lcom/tencent/mm/model/by;)V
    //   2976: ldc2_w 68
    //   2979: ldc_w 544
    //   2982: invokeinterface 549 5 0
    //   2987: pop
    //   2988: ldc_w 551
    //   2991: invokestatic 557	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   2994: checkcast 551	com/tencent/mm/plugin/messenger/foundation/a/n
    //   2997: invokeinterface 561 1 0
    //   3002: iload_2
    //   3003: invokestatic 564	com/tencent/mm/model/bx:vk	(I)Ljava/lang/String;
    //   3006: invokeinterface 570 2 0
    //   3011: astore 14
    //   3013: aload 14
    //   3015: ifnull +18 -> 3033
    //   3018: aload 14
    //   3020: getfield 575	com/tencent/mm/autogen/b/bd:field_username	Ljava/lang/String;
    //   3023: iload_2
    //   3024: invokestatic 564	com/tencent/mm/model/bx:vk	(I)Ljava/lang/String;
    //   3027: invokevirtual 450	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3030: ifne +172 -> 3202
    //   3033: new 577	com/tencent/mm/storage/bb
    //   3036: dup
    //   3037: invokespecial 578	com/tencent/mm/storage/bb:<init>	()V
    //   3040: astore 15
    //   3042: aload 15
    //   3044: iload_2
    //   3045: invokestatic 564	com/tencent/mm/model/bx:vk	(I)Ljava/lang/String;
    //   3048: invokevirtual 581	com/tencent/mm/storage/bb:setUsername	(Ljava/lang/String;)V
    //   3051: aload_1
    //   3052: ifnonnull +132 -> 3184
    //   3055: ldc_w 327
    //   3058: astore 14
    //   3060: aload 15
    //   3062: aload 14
    //   3064: invokevirtual 584	com/tencent/mm/storage/bb:setContent	(Ljava/lang/String;)V
    //   3067: aload_1
    //   3068: ifnonnull +125 -> 3193
    //   3071: invokestatic 587	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   3074: lstore 11
    //   3076: aload 15
    //   3078: lload 11
    //   3080: invokevirtual 590	com/tencent/mm/storage/bb:gR	(J)V
    //   3083: aload 15
    //   3085: iconst_0
    //   3086: invokevirtual 593	com/tencent/mm/storage/bb:pI	(I)V
    //   3089: aload 15
    //   3091: iload_3
    //   3092: invokevirtual 596	com/tencent/mm/storage/bb:pG	(I)V
    //   3095: ldc_w 551
    //   3098: invokestatic 557	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   3101: checkcast 551	com/tencent/mm/plugin/messenger/foundation/a/n
    //   3104: invokeinterface 561 1 0
    //   3109: aload 15
    //   3111: invokeinterface 600 2 0
    //   3116: pop2
    //   3117: invokestatic 120	com/tencent/mm/plugin/readerapp/model/d:gFB	()Lcom/tencent/mm/model/by;
    //   3120: invokevirtual 157	com/tencent/mm/model/by:doNotify	()V
    //   3123: aload_1
    //   3124: invokevirtual 263	com/tencent/mm/model/bx:getTitle	()Ljava/lang/String;
    //   3127: astore_1
    //   3128: new 602	com/tencent/mm/storage/cc
    //   3131: dup
    //   3132: invokespecial 603	com/tencent/mm/storage/cc:<init>	()V
    //   3135: astore 14
    //   3137: aload 14
    //   3139: aload_1
    //   3140: invokevirtual 604	com/tencent/mm/storage/cc:setContent	(Ljava/lang/String;)V
    //   3143: aload 14
    //   3145: iload_2
    //   3146: invokestatic 564	com/tencent/mm/model/bx:vk	(I)Ljava/lang/String;
    //   3149: invokevirtual 607	com/tencent/mm/storage/cc:BS	(Ljava/lang/String;)V
    //   3152: aload 14
    //   3154: iconst_1
    //   3155: invokevirtual 610	com/tencent/mm/storage/cc:setType	(I)V
    //   3158: aload 14
    //   3160: ldc2_w 611
    //   3163: invokevirtual 615	com/tencent/mm/storage/cc:setMsgId	(J)V
    //   3166: new 617	com/tencent/mm/am/g$b
    //   3169: dup
    //   3170: aload 14
    //   3172: iconst_1
    //   3173: invokespecial 620	com/tencent/mm/am/g$b:<init>	(Lcom/tencent/mm/storage/cc;Z)V
    //   3176: astore_1
    //   3177: ldc 45
    //   3179: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3182: aload_1
    //   3183: areturn
    //   3184: aload_1
    //   3185: invokevirtual 263	com/tencent/mm/model/bx:getTitle	()Ljava/lang/String;
    //   3188: astore 14
    //   3190: goto -130 -> 3060
    //   3193: aload_1
    //   3194: getfield 298	com/tencent/mm/model/bx:time	J
    //   3197: lstore 11
    //   3199: goto -123 -> 3076
    //   3202: aload 14
    //   3204: aload_1
    //   3205: invokevirtual 263	com/tencent/mm/model/bx:getTitle	()Ljava/lang/String;
    //   3208: invokevirtual 584	com/tencent/mm/storage/bb:setContent	(Ljava/lang/String;)V
    //   3211: aload 14
    //   3213: aload_1
    //   3214: getfield 298	com/tencent/mm/model/bx:time	J
    //   3217: invokevirtual 590	com/tencent/mm/storage/bb:gR	(J)V
    //   3220: aload 14
    //   3222: iconst_0
    //   3223: invokevirtual 593	com/tencent/mm/storage/bb:pI	(I)V
    //   3226: aload 14
    //   3228: aload 14
    //   3230: getfield 623	com/tencent/mm/autogen/b/bd:field_unReadCount	I
    //   3233: iload_3
    //   3234: iadd
    //   3235: invokevirtual 596	com/tencent/mm/storage/bb:pG	(I)V
    //   3238: ldc_w 551
    //   3241: invokestatic 557	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   3244: checkcast 551	com/tencent/mm/plugin/messenger/foundation/a/n
    //   3247: invokeinterface 561 1 0
    //   3252: aload 14
    //   3254: iload_2
    //   3255: invokestatic 564	com/tencent/mm/model/bx:vk	(I)Ljava/lang/String;
    //   3258: invokeinterface 627 3 0
    //   3263: pop
    //   3264: goto -147 -> 3117
    //   3267: ldc 79
    //   3269: ldc_w 629
    //   3272: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   3275: ldc 45
    //   3277: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3280: aconst_null
    //   3281: areturn
    //   3282: ldc 45
    //   3284: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3287: aconst_null
    //   3288: areturn
    //   3289: astore_1
    //   3290: iload_2
    //   3291: istore 4
    //   3293: iload_3
    //   3294: istore_2
    //   3295: iload 4
    //   3297: istore_3
    //   3298: goto -507 -> 2791
    //   3301: astore 15
    //   3303: goto -708 -> 2595
    //   3306: goto -2052 -> 1254
    //   3309: goto -2049 -> 1260
    //   3312: iconst_1
    //   3313: istore 4
    //   3315: goto -2669 -> 646
    //   3318: goto -3091 -> 227
    //   3321: iconst_0
    //   3322: istore 6
    //   3324: goto -1585 -> 1739
    //   3327: ldc_w 327
    //   3330: astore 15
    //   3332: goto -1548 -> 1784
    //   3335: aload 16
    //   3337: astore 15
    //   3339: goto -1380 -> 1959
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3342	0	this	b
    //   0	3342	1	parama	com.tencent.mm.am.g.a
    //   280	3015	2	i	int
    //   298	3000	3	j	int
    //   291	3023	4	k	int
    //   295	2650	5	m	int
    //   1225	2098	6	n	int
    //   2010	799	7	i1	int
    //   454	2095	8	i2	int
    //   1549	195	9	i3	int
    //   2518	17	10	i4	int
    //   207	2991	11	l	long
    //   531	23	13	bool	boolean
    //   112	3141	14	localObject1	Object
    //   146	2964	15	localObject2	Object
    //   3301	1	15	localException	Exception
    //   3330	8	15	localObject3	Object
    //   698	2638	16	localObject4	Object
    //   718	1537	17	localObject5	Object
    //   288	2394	18	localArrayList	java.util.ArrayList
    //   9	1817	19	localdl	com.tencent.mm.protocal.protobuf.dl
    //   277	2024	20	localSimpleDateFormat	java.text.SimpleDateFormat
    //   307	2444	21	localMap	java.util.Map
    //   486	2077	22	str1	String
    //   1372	1287	23	str2	String
    //   1467	435	24	str3	String
    //   1815	934	25	localbx	bx
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
    //   351	362	3289	java/lang/Exception
    //   366	372	3289	java/lang/Exception
    //   372	488	3289	java/lang/Exception
    //   493	520	3289	java/lang/Exception
    //   1291	1324	3289	java/lang/Exception
    //   2520	2595	3301	java/lang/Exception
  }
  
  public final void b(g.c paramc)
  {
    AppMethodBeat.i(102664);
    Object localObject3 = (String)paramc.otT;
    Log.i("MicroMsg.ReaderAppMsgExtension", "[onPreDelMessage] functionId:%s", new Object[] { localObject3 });
    label515:
    label518:
    for (;;)
    {
      try
      {
        localObject2 = d.gFB();
        localObject1 = ((com.tencent.mm.model.by)localObject2).JY((String)localObject3);
        if ((localObject1 == null) || (((List)localObject1).size() == 0))
        {
          AppMethodBeat.o(102664);
          return;
        }
        paramc = (bx)((List)localObject1).get(0);
        Iterator localIterator = ((List)localObject1).iterator();
        if (localIterator.hasNext())
        {
          localObject1 = (bx)localIterator.next();
          if (((bx)localObject1).omN != 1) {
            break label515;
          }
          paramc = (g.c)localObject1;
          break label518;
        }
        if (((com.tencent.mm.model.by)localObject2).omV.delete(com.tencent.mm.model.by.vl(20), "reserved3=?", new String[] { localObject3 }) >= 0) {
          ((com.tencent.mm.model.by)localObject2).doNotify();
        }
        localObject1 = com.tencent.mm.model.by.JX(com.tencent.mm.model.by.vl(20)) + " where istop = 1  group by time ORDER BY time DESC  limit 2";
        Log.i("MicroMsg.ReaderAppInfoStorage", "processConversationAfterDeleteInfo, sql is %s", new Object[] { localObject1 });
        localObject3 = ((com.tencent.mm.model.by)localObject2).omV.rawQuery((String)localObject1, null, 2);
        if (!((Cursor)localObject3).moveToFirst())
        {
          ((Cursor)localObject3).close();
          paramc = new bb();
          paramc.setUsername(bx.vk(20));
          paramc.setContent("");
          paramc.gR(0L);
          paramc.pI(0);
          paramc.pG(0);
          ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().c(paramc, bx.vk(20));
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
      Object localObject1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().bxM(bx.vk(20));
      if (localObject1 == null)
      {
        Log.e("MicroMsg.ReaderAppInfoStorage", "[processConversationAfterDeleteInfo] originConv[%s] is null!", new Object[] { bx.vk(20) });
        AppMethodBeat.o(102664);
        return;
      }
      Object localObject2 = new bx();
      ((bx)localObject2).convertFrom((Cursor)localObject3);
      ((Cursor)localObject3).close();
      localObject3 = new bb();
      ((bb)localObject3).setUsername(bx.vk(20));
      ((bb)localObject3).setContent(((bx)localObject2).getTitle());
      ((bb)localObject3).gR(((bx)localObject2).time);
      ((bb)localObject3).pI(0);
      if ((((bd)localObject1).field_unReadCount > 0) && (paramc != null) && (((bd)localObject1).field_content.equals(paramc.getTitle()))) {
        ((bb)localObject3).pG(((bd)localObject1).field_unReadCount - 1);
      }
      for (;;)
      {
        ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().c((bb)localObject3, bx.vk(20));
        AppMethodBeat.o(102664);
        return;
        ((bb)localObject3).pG(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.model.b
 * JD-Core Version:    0.7.0.1
 */