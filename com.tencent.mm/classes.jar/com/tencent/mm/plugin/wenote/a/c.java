package com.tencent.mm.plugin.wenote.a;

import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  implements p, com.tencent.mm.plugin.record.a.c
{
  /* Error */
  private static void a(com.tencent.mm.plugin.wenote.model.e parame)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: invokestatic 23	com/tencent/mm/plugin/wenote/model/c:chu	()Lcom/tencent/mm/plugin/wenote/model/c;
    //   5: getfield 27	com/tencent/mm/plugin/wenote/model/c:rFh	Lcom/tencent/mm/plugin/wenote/model/d;
    //   8: astore 6
    //   10: aload 6
    //   12: ifnonnull +4 -> 16
    //   15: return
    //   16: aload_0
    //   17: getfield 33	com/tencent/mm/plugin/wenote/model/e:field_status	I
    //   20: iconst_3
    //   21: if_icmpeq +11 -> 32
    //   24: aload_0
    //   25: getfield 33	com/tencent/mm/plugin/wenote/model/e:field_status	I
    //   28: iconst_2
    //   29: if_icmpne +160 -> 189
    //   32: iconst_1
    //   33: istore_1
    //   34: iload_1
    //   35: ifeq -20 -> 15
    //   38: aload_0
    //   39: getfield 37	com/tencent/mm/plugin/wenote/model/e:field_path	Ljava/lang/String;
    //   42: invokestatic 43	com/tencent/mm/a/e:bK	(Ljava/lang/String;)Z
    //   45: ifeq -30 -> 15
    //   48: aload 6
    //   50: getfield 49	com/tencent/mm/plugin/wenote/model/d:rFm	Ljava/util/HashMap;
    //   53: aload_0
    //   54: getfield 52	com/tencent/mm/plugin/wenote/model/e:field_dataId	Ljava/lang/String;
    //   57: invokevirtual 58	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   60: checkcast 60	java/lang/String
    //   63: astore 7
    //   65: aload 7
    //   67: invokestatic 65	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   70: ifne -55 -> 15
    //   73: ldc 67
    //   75: ldc 69
    //   77: iconst_1
    //   78: anewarray 4	java/lang/Object
    //   81: dup
    //   82: iconst_0
    //   83: aload 7
    //   85: aastore
    //   86: invokestatic 75	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   89: aload_0
    //   90: getfield 52	com/tencent/mm/plugin/wenote/model/e:field_dataId	Ljava/lang/String;
    //   93: ldc 77
    //   95: invokevirtual 80	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   98: ifeq +96 -> 194
    //   101: aload 6
    //   103: getfield 83	com/tencent/mm/plugin/wenote/model/d:rFn	Ljava/util/HashMap;
    //   106: aload 7
    //   108: invokevirtual 58	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   111: ifnull +83 -> 194
    //   114: aload 6
    //   116: getfield 83	com/tencent/mm/plugin/wenote/model/d:rFn	Ljava/util/HashMap;
    //   119: aload 7
    //   121: invokevirtual 58	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   124: checkcast 85	com/tencent/mm/plugin/wenote/model/a/o
    //   127: invokevirtual 89	com/tencent/mm/plugin/wenote/model/a/o:getType	()I
    //   130: iconst_2
    //   131: if_icmpne +23 -> 154
    //   134: aload 6
    //   136: getfield 83	com/tencent/mm/plugin/wenote/model/d:rFn	Ljava/util/HashMap;
    //   139: aload 7
    //   141: invokevirtual 58	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   144: checkcast 85	com/tencent/mm/plugin/wenote/model/a/o
    //   147: aload_0
    //   148: getfield 37	com/tencent/mm/plugin/wenote/model/e:field_path	Ljava/lang/String;
    //   151: putfield 92	com/tencent/mm/plugin/wenote/model/a/o:bTY	Ljava/lang/String;
    //   154: invokestatic 98	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:chX	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   157: aload 7
    //   159: aload 6
    //   161: getfield 83	com/tencent/mm/plugin/wenote/model/d:rFn	Ljava/util/HashMap;
    //   164: aload 7
    //   166: invokevirtual 58	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   169: checkcast 100	com/tencent/mm/plugin/wenote/model/a/c
    //   172: invokevirtual 103	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/wenote/model/a/c;)V
    //   175: aload 6
    //   177: getfield 49	com/tencent/mm/plugin/wenote/model/d:rFm	Ljava/util/HashMap;
    //   180: aload_0
    //   181: getfield 52	com/tencent/mm/plugin/wenote/model/e:field_dataId	Ljava/lang/String;
    //   184: invokevirtual 106	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   187: pop
    //   188: return
    //   189: iconst_0
    //   190: istore_1
    //   191: goto -157 -> 34
    //   194: aload 7
    //   196: ldc 108
    //   198: invokevirtual 112	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   201: ifne +614 -> 815
    //   204: aload 6
    //   206: getfield 49	com/tencent/mm/plugin/wenote/model/d:rFm	Ljava/util/HashMap;
    //   209: ldc 108
    //   211: invokevirtual 115	java/util/HashMap:containsValue	(Ljava/lang/Object;)Z
    //   214: ifne +319 -> 533
    //   217: new 117	com/tencent/mm/h/a/kv
    //   220: dup
    //   221: invokespecial 118	com/tencent/mm/h/a/kv:<init>	()V
    //   224: astore 5
    //   226: aload 5
    //   228: getfield 122	com/tencent/mm/h/a/kv:bTV	Lcom/tencent/mm/h/a/kv$a;
    //   231: aload 7
    //   233: putfield 127	com/tencent/mm/h/a/kv$a:bTN	Ljava/lang/String;
    //   236: aload 5
    //   238: getfield 122	com/tencent/mm/h/a/kv:bTV	Lcom/tencent/mm/h/a/kv$a;
    //   241: aload_0
    //   242: getfield 37	com/tencent/mm/plugin/wenote/model/e:field_path	Ljava/lang/String;
    //   245: putfield 128	com/tencent/mm/h/a/kv$a:bTY	Ljava/lang/String;
    //   248: aload 5
    //   250: getfield 122	com/tencent/mm/h/a/kv:bTV	Lcom/tencent/mm/h/a/kv$a;
    //   253: iconst_1
    //   254: putfield 131	com/tencent/mm/h/a/kv$a:type	I
    //   257: aload 5
    //   259: getfield 122	com/tencent/mm/h/a/kv:bTV	Lcom/tencent/mm/h/a/kv$a;
    //   262: aload 6
    //   264: getfield 83	com/tencent/mm/plugin/wenote/model/d:rFn	Ljava/util/HashMap;
    //   267: aload 7
    //   269: invokevirtual 58	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   272: checkcast 85	com/tencent/mm/plugin/wenote/model/a/o
    //   275: getfield 132	com/tencent/mm/plugin/wenote/model/a/o:type	I
    //   278: putfield 135	com/tencent/mm/h/a/kv$a:itemType	I
    //   281: aload 5
    //   283: getfield 122	com/tencent/mm/h/a/kv:bTV	Lcom/tencent/mm/h/a/kv$a;
    //   286: getfield 135	com/tencent/mm/h/a/kv$a:itemType	I
    //   289: iconst_4
    //   290: if_icmpeq +55 -> 345
    //   293: aload 6
    //   295: getfield 83	com/tencent/mm/plugin/wenote/model/d:rFn	Ljava/util/HashMap;
    //   298: aload 7
    //   300: invokevirtual 58	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   303: checkcast 85	com/tencent/mm/plugin/wenote/model/a/o
    //   306: astore 8
    //   308: aload 5
    //   310: getfield 122	com/tencent/mm/h/a/kv:bTV	Lcom/tencent/mm/h/a/kv$a;
    //   313: getfield 135	com/tencent/mm/h/a/kv$a:itemType	I
    //   316: iconst_2
    //   317: if_icmpeq +191 -> 508
    //   320: aload 8
    //   322: aload_0
    //   323: getfield 37	com/tencent/mm/plugin/wenote/model/e:field_path	Ljava/lang/String;
    //   326: putfield 92	com/tencent/mm/plugin/wenote/model/a/o:bTY	Ljava/lang/String;
    //   329: aload 8
    //   331: iconst_1
    //   332: putfield 139	com/tencent/mm/plugin/wenote/model/a/o:rGJ	Z
    //   335: invokestatic 98	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:chX	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   338: aload 7
    //   340: aload 8
    //   342: invokevirtual 103	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/wenote/model/a/c;)V
    //   345: iconst_5
    //   346: aload 5
    //   348: getfield 122	com/tencent/mm/h/a/kv:bTV	Lcom/tencent/mm/h/a/kv$a;
    //   351: getfield 135	com/tencent/mm/h/a/kv$a:itemType	I
    //   354: if_icmpeq -339 -> 15
    //   357: aload 5
    //   359: getfield 122	com/tencent/mm/h/a/kv:bTV	Lcom/tencent/mm/h/a/kv$a;
    //   362: getfield 135	com/tencent/mm/h/a/kv$a:itemType	I
    //   365: iconst_4
    //   366: if_icmpne +95 -> 461
    //   369: aload 6
    //   371: aload_0
    //   372: getfield 52	com/tencent/mm/plugin/wenote/model/e:field_dataId	Ljava/lang/String;
    //   375: invokevirtual 143	com/tencent/mm/plugin/wenote/model/d:Uq	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/xv;
    //   378: astore 8
    //   380: aload 8
    //   382: ifnonnull +142 -> 524
    //   385: ldc 67
    //   387: ldc 145
    //   389: invokestatic 149	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   392: iconst_0
    //   393: istore_1
    //   394: aload 5
    //   396: getfield 122	com/tencent/mm/h/a/kv:bTV	Lcom/tencent/mm/h/a/kv$a;
    //   399: iload_1
    //   400: putfield 152	com/tencent/mm/h/a/kv$a:bNN	I
    //   403: aload 6
    //   405: getfield 83	com/tencent/mm/plugin/wenote/model/d:rFn	Ljava/util/HashMap;
    //   408: aload 7
    //   410: invokevirtual 58	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   413: checkcast 85	com/tencent/mm/plugin/wenote/model/a/o
    //   416: aload_0
    //   417: getfield 37	com/tencent/mm/plugin/wenote/model/e:field_path	Ljava/lang/String;
    //   420: putfield 92	com/tencent/mm/plugin/wenote/model/a/o:bTY	Ljava/lang/String;
    //   423: aload 6
    //   425: getfield 83	com/tencent/mm/plugin/wenote/model/d:rFn	Ljava/util/HashMap;
    //   428: aload 7
    //   430: invokevirtual 58	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   433: checkcast 85	com/tencent/mm/plugin/wenote/model/a/o
    //   436: iconst_1
    //   437: putfield 139	com/tencent/mm/plugin/wenote/model/a/o:rGJ	Z
    //   440: invokestatic 98	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:chX	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   443: aload 7
    //   445: aload 6
    //   447: getfield 83	com/tencent/mm/plugin/wenote/model/d:rFn	Ljava/util/HashMap;
    //   450: aload 7
    //   452: invokevirtual 58	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   455: checkcast 100	com/tencent/mm/plugin/wenote/model/a/c
    //   458: invokevirtual 103	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/wenote/model/a/c;)V
    //   461: ldc 67
    //   463: ldc 154
    //   465: iconst_2
    //   466: anewarray 4	java/lang/Object
    //   469: dup
    //   470: iconst_0
    //   471: aload 5
    //   473: getfield 122	com/tencent/mm/h/a/kv:bTV	Lcom/tencent/mm/h/a/kv$a;
    //   476: getfield 127	com/tencent/mm/h/a/kv$a:bTN	Ljava/lang/String;
    //   479: aastore
    //   480: dup
    //   481: iconst_1
    //   482: aload 5
    //   484: getfield 122	com/tencent/mm/h/a/kv:bTV	Lcom/tencent/mm/h/a/kv$a;
    //   487: getfield 128	com/tencent/mm/h/a/kv$a:bTY	Ljava/lang/String;
    //   490: aastore
    //   491: invokestatic 157	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   494: aload 6
    //   496: getfield 49	com/tencent/mm/plugin/wenote/model/d:rFm	Ljava/util/HashMap;
    //   499: aload_0
    //   500: getfield 52	com/tencent/mm/plugin/wenote/model/e:field_dataId	Ljava/lang/String;
    //   503: invokevirtual 106	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   506: pop
    //   507: return
    //   508: aload_0
    //   509: getfield 37	com/tencent/mm/plugin/wenote/model/e:field_path	Ljava/lang/String;
    //   512: aload 8
    //   514: getfield 92	com/tencent/mm/plugin/wenote/model/a/o:bTY	Ljava/lang/String;
    //   517: invokestatic 163	com/tencent/mm/plugin/wenote/b/c:fI	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   520: pop
    //   521: goto -192 -> 329
    //   524: aload 8
    //   526: getfield 168	com/tencent/mm/protocal/c/xv:duration	I
    //   529: istore_1
    //   530: goto -136 -> 394
    //   533: aload 6
    //   535: getfield 172	com/tencent/mm/plugin/wenote/model/d:rFj	Lcom/tencent/mm/plugin/wenote/model/a/m;
    //   538: getfield 178	com/tencent/mm/plugin/wenote/model/a/m:bTZ	J
    //   541: ldc2_w 179
    //   544: lcmp
    //   545: ifne +186 -> 731
    //   548: aload 6
    //   550: getfield 183	com/tencent/mm/plugin/wenote/model/d:rFl	Ljava/util/HashMap;
    //   553: aload 6
    //   555: getfield 172	com/tencent/mm/plugin/wenote/model/d:rFj	Lcom/tencent/mm/plugin/wenote/model/a/m;
    //   558: getfield 186	com/tencent/mm/plugin/wenote/model/a/m:bIt	J
    //   561: invokestatic 192	java/lang/Long:toString	(J)Ljava/lang/String;
    //   564: invokevirtual 58	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   567: checkcast 194	com/tencent/mm/plugin/wenote/model/a/w
    //   570: astore 5
    //   572: aload 5
    //   574: ifnull -559 -> 15
    //   577: aload 5
    //   579: getfield 198	com/tencent/mm/plugin/wenote/model/a/w:rHa	Ljava/util/ArrayList;
    //   582: ifnull -567 -> 15
    //   585: aload 5
    //   587: getfield 198	com/tencent/mm/plugin/wenote/model/a/w:rHa	Ljava/util/ArrayList;
    //   590: invokevirtual 204	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   593: astore 8
    //   595: aload 8
    //   597: invokeinterface 210 1 0
    //   602: ifeq -108 -> 494
    //   605: aload 8
    //   607: invokeinterface 214 1 0
    //   612: checkcast 85	com/tencent/mm/plugin/wenote/model/a/o
    //   615: astore 5
    //   617: aload 5
    //   619: getfield 217	com/tencent/mm/plugin/wenote/model/a/o:rGI	Ljava/lang/String;
    //   622: aload 7
    //   624: invokevirtual 112	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   627: ifeq -32 -> 595
    //   630: aload 5
    //   632: iconst_1
    //   633: putfield 139	com/tencent/mm/plugin/wenote/model/a/o:rGJ	Z
    //   636: aload 5
    //   638: getfield 132	com/tencent/mm/plugin/wenote/model/a/o:type	I
    //   641: iconst_4
    //   642: if_icmpne +125 -> 767
    //   645: aload 5
    //   647: checkcast 219	com/tencent/mm/plugin/wenote/model/a/v
    //   650: astore 8
    //   652: aload 8
    //   654: getstatic 222	com/tencent/mm/plugin/wenote/model/d:rFv	Ljava/lang/String;
    //   657: putfield 225	com/tencent/mm/plugin/wenote/model/a/v:gum	Ljava/lang/String;
    //   660: aload 6
    //   662: aload_0
    //   663: getfield 52	com/tencent/mm/plugin/wenote/model/e:field_dataId	Ljava/lang/String;
    //   666: invokevirtual 143	com/tencent/mm/plugin/wenote/model/d:Uq	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/xv;
    //   669: astore 9
    //   671: aload 9
    //   673: ifnonnull +85 -> 758
    //   676: ldc 67
    //   678: ldc 145
    //   680: invokestatic 149	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   683: iload_2
    //   684: istore_1
    //   685: aload 8
    //   687: iload_1
    //   688: i2l
    //   689: invokestatic 231	com/tencent/mm/plugin/wenote/model/f:ck	(J)F
    //   692: f2i
    //   693: putfield 234	com/tencent/mm/plugin/wenote/model/a/v:length	I
    //   696: aload 8
    //   698: invokestatic 240	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   701: aload 8
    //   703: getfield 234	com/tencent/mm/plugin/wenote/model/a/v:length	I
    //   706: invokestatic 244	com/tencent/mm/plugin/wenote/model/f:B	(Landroid/content/Context;I)Ljava/lang/String;
    //   709: putfield 247	com/tencent/mm/plugin/wenote/model/a/v:rGX	Ljava/lang/String;
    //   712: aload 8
    //   714: iload_1
    //   715: putfield 248	com/tencent/mm/plugin/wenote/model/a/v:bNN	I
    //   718: invokestatic 98	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:chX	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   721: aload 7
    //   723: aload 5
    //   725: invokevirtual 103	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/wenote/model/a/c;)V
    //   728: goto -234 -> 494
    //   731: aload 6
    //   733: getfield 183	com/tencent/mm/plugin/wenote/model/d:rFl	Ljava/util/HashMap;
    //   736: aload 6
    //   738: getfield 172	com/tencent/mm/plugin/wenote/model/d:rFj	Lcom/tencent/mm/plugin/wenote/model/a/m;
    //   741: getfield 178	com/tencent/mm/plugin/wenote/model/a/m:bTZ	J
    //   744: invokestatic 192	java/lang/Long:toString	(J)Ljava/lang/String;
    //   747: invokevirtual 58	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   750: checkcast 194	com/tencent/mm/plugin/wenote/model/a/w
    //   753: astore 5
    //   755: goto -183 -> 572
    //   758: aload 9
    //   760: getfield 168	com/tencent/mm/protocal/c/xv:duration	I
    //   763: istore_1
    //   764: goto -79 -> 685
    //   767: aload 5
    //   769: invokevirtual 89	com/tencent/mm/plugin/wenote/model/a/o:getType	()I
    //   772: iconst_2
    //   773: if_icmpne +30 -> 803
    //   776: aload_0
    //   777: getfield 37	com/tencent/mm/plugin/wenote/model/e:field_path	Ljava/lang/String;
    //   780: aload 6
    //   782: getfield 83	com/tencent/mm/plugin/wenote/model/d:rFn	Ljava/util/HashMap;
    //   785: aload 7
    //   787: invokevirtual 58	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   790: checkcast 85	com/tencent/mm/plugin/wenote/model/a/o
    //   793: getfield 92	com/tencent/mm/plugin/wenote/model/a/o:bTY	Ljava/lang/String;
    //   796: invokestatic 163	com/tencent/mm/plugin/wenote/b/c:fI	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   799: pop
    //   800: goto -82 -> 718
    //   803: aload 5
    //   805: aload_0
    //   806: getfield 37	com/tencent/mm/plugin/wenote/model/e:field_path	Ljava/lang/String;
    //   809: putfield 92	com/tencent/mm/plugin/wenote/model/a/o:bTY	Ljava/lang/String;
    //   812: goto -94 -> 718
    //   815: ldc 67
    //   817: ldc 250
    //   819: invokestatic 252	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   822: aload 6
    //   824: getfield 172	com/tencent/mm/plugin/wenote/model/d:rFj	Lcom/tencent/mm/plugin/wenote/model/a/m;
    //   827: getfield 178	com/tencent/mm/plugin/wenote/model/a/m:bTZ	J
    //   830: ldc2_w 179
    //   833: lcmp
    //   834: ifne +191 -> 1025
    //   837: aload 6
    //   839: getfield 183	com/tencent/mm/plugin/wenote/model/d:rFl	Ljava/util/HashMap;
    //   842: aload 6
    //   844: getfield 172	com/tencent/mm/plugin/wenote/model/d:rFj	Lcom/tencent/mm/plugin/wenote/model/a/m;
    //   847: getfield 186	com/tencent/mm/plugin/wenote/model/a/m:bIt	J
    //   850: invokestatic 192	java/lang/Long:toString	(J)Ljava/lang/String;
    //   853: invokevirtual 58	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   856: checkcast 194	com/tencent/mm/plugin/wenote/model/a/w
    //   859: astore 5
    //   861: aload 5
    //   863: ifnull -848 -> 15
    //   866: aload 5
    //   868: aload_0
    //   869: getfield 37	com/tencent/mm/plugin/wenote/model/e:field_path	Ljava/lang/String;
    //   872: invokestatic 258	com/tencent/mm/vfs/e:bP	(Ljava/lang/String;)Ljava/lang/String;
    //   875: putfield 261	com/tencent/mm/plugin/wenote/model/a/w:rGZ	Ljava/lang/String;
    //   878: invokestatic 98	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:chX	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;
    //   881: astore 7
    //   883: aload 5
    //   885: getfield 261	com/tencent/mm/plugin/wenote/model/a/w:rGZ	Ljava/lang/String;
    //   888: astore 5
    //   890: aload 5
    //   892: invokestatic 65	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   895: ifne -401 -> 494
    //   898: aload 7
    //   900: getfield 264	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:hka	Ljava/util/ArrayList;
    //   903: ifnull -409 -> 494
    //   906: aload 5
    //   908: invokestatic 270	com/tencent/mm/plugin/wenote/b/b:UA	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   911: astore 8
    //   913: aload 8
    //   915: ifnull -421 -> 494
    //   918: aload 8
    //   920: invokevirtual 273	java/util/ArrayList:size	()I
    //   923: ifle -429 -> 494
    //   926: aload 7
    //   928: monitorenter
    //   929: ldc_w 275
    //   932: ldc_w 277
    //   935: iconst_1
    //   936: anewarray 4	java/lang/Object
    //   939: dup
    //   940: iconst_0
    //   941: aload 7
    //   943: getfield 280	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:rHB	Z
    //   946: invokestatic 286	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   949: aastore
    //   950: invokestatic 157	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   953: invokestatic 292	com/tencent/mm/model/au:DS	()Lcom/tencent/mm/sdk/platformtools/ai;
    //   956: astore 5
    //   958: new 294	com/tencent/mm/plugin/wenote/model/nativenote/manager/c$2
    //   961: dup
    //   962: aload 7
    //   964: aload 8
    //   966: invokespecial 297	com/tencent/mm/plugin/wenote/model/nativenote/manager/c$2:<init>	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/c;Ljava/util/ArrayList;)V
    //   969: astore 8
    //   971: aload 7
    //   973: getfield 280	com/tencent/mm/plugin/wenote/model/nativenote/manager/c:rHB	Z
    //   976: ifeq +76 -> 1052
    //   979: ldc2_w 298
    //   982: lstore_3
    //   983: aload 5
    //   985: aload 8
    //   987: lload_3
    //   988: invokevirtual 305	com/tencent/mm/sdk/platformtools/ai:k	(Ljava/lang/Runnable;J)I
    //   991: pop
    //   992: aload 7
    //   994: monitorexit
    //   995: goto -501 -> 494
    //   998: astore 5
    //   1000: aload 7
    //   1002: monitorexit
    //   1003: aload 5
    //   1005: athrow
    //   1006: astore 5
    //   1008: ldc 67
    //   1010: aload 5
    //   1012: ldc_w 307
    //   1015: iconst_0
    //   1016: anewarray 4	java/lang/Object
    //   1019: invokestatic 311	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1022: goto -528 -> 494
    //   1025: aload 6
    //   1027: getfield 183	com/tencent/mm/plugin/wenote/model/d:rFl	Ljava/util/HashMap;
    //   1030: aload 6
    //   1032: getfield 172	com/tencent/mm/plugin/wenote/model/d:rFj	Lcom/tencent/mm/plugin/wenote/model/a/m;
    //   1035: getfield 178	com/tencent/mm/plugin/wenote/model/a/m:bTZ	J
    //   1038: invokestatic 192	java/lang/Long:toString	(J)Ljava/lang/String;
    //   1041: invokevirtual 58	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1044: checkcast 194	com/tencent/mm/plugin/wenote/model/a/w
    //   1047: astore 5
    //   1049: goto -188 -> 861
    //   1052: ldc2_w 312
    //   1055: lstore_3
    //   1056: goto -73 -> 983
    //   1059: astore 5
    //   1061: ldc_w 275
    //   1064: ldc_w 315
    //   1067: iconst_1
    //   1068: anewarray 4	java/lang/Object
    //   1071: dup
    //   1072: iconst_0
    //   1073: aload 5
    //   1075: invokevirtual 318	java/lang/Exception:toString	()Ljava/lang/String;
    //   1078: aastore
    //   1079: invokestatic 320	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1082: goto -90 -> 992
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1085	0	parame	com.tencent.mm.plugin.wenote.model.e
    //   33	731	1	i	int
    //   1	683	2	j	int
    //   982	74	3	l	long
    //   224	760	5	localObject1	Object
    //   998	6	5	localObject2	Object
    //   1006	5	5	localException1	java.lang.Exception
    //   1047	1	5	localw	com.tencent.mm.plugin.wenote.model.a.w
    //   1059	15	5	localException2	java.lang.Exception
    //   8	1023	6	locald	d
    //   63	938	7	localObject3	Object
    //   306	680	8	localObject4	Object
    //   669	90	9	localxv	com.tencent.mm.protocal.c.xv
    // Exception table:
    //   from	to	target	type
    //   929	979	998	finally
    //   983	992	998	finally
    //   992	995	998	finally
    //   1000	1003	998	finally
    //   1061	1082	998	finally
    //   866	913	1006	java/lang/Exception
    //   918	929	1006	java/lang/Exception
    //   1003	1006	1006	java/lang/Exception
    //   929	979	1059	java/lang/Exception
    //   983	992	1059	java/lang/Exception
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.record.a.f paramf)
  {
    com.tencent.mm.plugin.wenote.model.e locale = new com.tencent.mm.plugin.wenote.model.e();
    locale.field_localId = paramf.field_localId;
    locale.field_dataId = paramf.field_dataId;
    locale.field_status = paramf.field_status;
    locale.field_offset = paramf.field_offset;
    locale.field_totalLen = paramf.field_totalLen;
    locale.field_path = paramf.field_path;
    a(locale);
  }
  
  public final void d(com.tencent.mm.plugin.fav.a.c paramc)
  {
    Object localObject = com.tencent.mm.plugin.wenote.model.f.fu(paramc.field_favLocalId);
    if (localObject == null)
    {
      localObject = com.tencent.mm.plugin.wenote.model.c.chu().rFh;
      if ((localObject == null) || (((d)localObject).rFj == null)) {
        return;
      }
      if (paramc.field_favLocalId != ((d)localObject).rFj.bTZ) {
        y.i("MicroMsg.Note.WNNoteFavCdnChangedListener", "info null and not match localId:%s, %s", new Object[] { Long.valueOf(paramc.field_favLocalId), Long.valueOf(((d)localObject).rFj.bTZ) });
      }
    }
    else if (((g)localObject).field_type != 18)
    {
      y.i("MicroMsg.Note.WNNoteFavCdnChangedListener", "Not Note CDN onCdnStatusChanged %d", new Object[] { Long.valueOf(paramc.field_favLocalId) });
      return;
    }
    if ((paramc.field_status == 3) && (com.tencent.mm.a.e.bK(paramc.field_path)) && (paramc.field_path.endsWith("..htm"))) {
      com.tencent.mm.plugin.wenote.model.f.y(paramc.field_favLocalId, paramc.field_path);
    }
    localObject = new com.tencent.mm.plugin.wenote.model.e();
    ((com.tencent.mm.plugin.wenote.model.e)localObject).field_favLocalId = paramc.field_favLocalId;
    ((com.tencent.mm.plugin.wenote.model.e)localObject).field_dataId = paramc.field_dataId;
    ((com.tencent.mm.plugin.wenote.model.e)localObject).field_status = paramc.field_status;
    ((com.tencent.mm.plugin.wenote.model.e)localObject).field_offset = paramc.field_offset;
    ((com.tencent.mm.plugin.wenote.model.e)localObject).field_totalLen = paramc.field_totalLen;
    ((com.tencent.mm.plugin.wenote.model.e)localObject).field_path = paramc.field_path;
    a((com.tencent.mm.plugin.wenote.model.e)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.a.c
 * JD-Core Version:    0.7.0.1
 */