package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.fwr;
import com.tencent.mm.protocal.protobuf.fws;
import com.tencent.mm.protocal.protobuf.fwu;
import com.tencent.mm.protocal.protobuf.fwv;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class v
  extends p
  implements m
{
  public List<String> XRr;
  public String XRs;
  public List<String> XRt;
  private h callback;
  public int hId;
  public String pTA;
  private final c rr;
  
  public v(int paramInt, List<String> paramList, List<Integer> paramList1, String paramString1, String paramString2, Map<String, Integer> paramMap, String paramString3)
  {
    this(paramInt, paramList, paramList1, null, paramString1, paramString2, paramMap, paramString3, "");
  }
  
  public v(int paramInt, List<String> paramList1, List<Integer> paramList, List<String> paramList2, String paramString1, String paramString2, Map<String, Integer> paramMap, String paramString3, String paramString4)
  {
    this(paramInt, paramList1, paramList, paramList2, paramString1, paramString2, paramMap, paramString3, paramString4, null);
    AppMethodBeat.i(151639);
    AppMethodBeat.o(151639);
  }
  
  /* Error */
  public v(int paramInt, List<String> paramList1, List<Integer> paramList, List<String> paramList2, String paramString1, String paramString2, Map<String, Integer> paramMap, String paramString3, String paramString4, String paramString5)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 46	com/tencent/mm/am/p:<init>	()V
    //   4: ldc 47
    //   6: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: aconst_null
    //   11: putfield 49	com/tencent/mm/pluginsdk/model/v:XRr	Ljava/util/List;
    //   14: aload_0
    //   15: iconst_0
    //   16: putfield 51	com/tencent/mm/pluginsdk/model/v:hId	I
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield 53	com/tencent/mm/pluginsdk/model/v:XRt	Ljava/util/List;
    //   24: iload_1
    //   25: iconst_3
    //   26: if_icmpeq +250 -> 276
    //   29: iconst_1
    //   30: istore 12
    //   32: ldc 55
    //   34: iload 12
    //   36: invokestatic 61	junit/framework/Assert:assertTrue	(Ljava/lang/String;Z)V
    //   39: aload_0
    //   40: iload_1
    //   41: putfield 51	com/tencent/mm/pluginsdk/model/v:hId	I
    //   44: aload_0
    //   45: aload_2
    //   46: putfield 49	com/tencent/mm/pluginsdk/model/v:XRr	Ljava/util/List;
    //   49: aload 4
    //   51: ifnull +17 -> 68
    //   54: aload 4
    //   56: astore 13
    //   58: aload 4
    //   60: invokeinterface 67 1 0
    //   65: ifne +12 -> 77
    //   68: new 69	java/util/LinkedList
    //   71: dup
    //   72: invokespecial 70	java/util/LinkedList:<init>	()V
    //   75: astore 13
    //   77: new 72	com/tencent/mm/am/c$a
    //   80: dup
    //   81: invokespecial 73	com/tencent/mm/am/c$a:<init>	()V
    //   84: astore 4
    //   86: aload 4
    //   88: new 75	com/tencent/mm/protocal/protobuf/fwu
    //   91: dup
    //   92: invokespecial 76	com/tencent/mm/protocal/protobuf/fwu:<init>	()V
    //   95: putfield 80	com/tencent/mm/am/c$a:otE	Lcom/tencent/mm/bx/a;
    //   98: aload 4
    //   100: new 82	com/tencent/mm/protocal/protobuf/fwv
    //   103: dup
    //   104: invokespecial 83	com/tencent/mm/protocal/protobuf/fwv:<init>	()V
    //   107: putfield 86	com/tencent/mm/am/c$a:otF	Lcom/tencent/mm/bx/a;
    //   110: aload 4
    //   112: ldc 88
    //   114: putfield 91	com/tencent/mm/am/c$a:uri	Ljava/lang/String;
    //   117: aload 4
    //   119: sipush 137
    //   122: putfield 94	com/tencent/mm/am/c$a:funcId	I
    //   125: aload 4
    //   127: bipush 44
    //   129: putfield 97	com/tencent/mm/am/c$a:otG	I
    //   132: aload 4
    //   134: ldc 98
    //   136: putfield 101	com/tencent/mm/am/c$a:respCmdId	I
    //   139: aload_0
    //   140: aload 4
    //   142: invokevirtual 105	com/tencent/mm/am/c$a:bEF	()Lcom/tencent/mm/am/c;
    //   145: putfield 107	com/tencent/mm/pluginsdk/model/v:rr	Lcom/tencent/mm/am/c;
    //   148: aload 13
    //   150: ifnull +65 -> 215
    //   153: aload 13
    //   155: invokeinterface 67 1 0
    //   160: ifle +55 -> 215
    //   163: aload 13
    //   165: invokeinterface 67 1 0
    //   170: aload_2
    //   171: invokeinterface 67 1 0
    //   176: if_icmpeq +106 -> 282
    //   179: ldc 109
    //   181: ldc 111
    //   183: iconst_2
    //   184: anewarray 113	java/lang/Object
    //   187: dup
    //   188: iconst_0
    //   189: aload 13
    //   191: invokeinterface 67 1 0
    //   196: invokestatic 119	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   199: aastore
    //   200: dup
    //   201: iconst_1
    //   202: aload_2
    //   203: invokeinterface 67 1 0
    //   208: invokestatic 119	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   211: aastore
    //   212: invokestatic 125	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   215: iload_1
    //   216: iconst_2
    //   217: if_icmpne +123 -> 340
    //   220: iconst_0
    //   221: istore 11
    //   223: iload 11
    //   225: aload_2
    //   226: invokeinterface 67 1 0
    //   231: if_icmpge +109 -> 340
    //   234: aload 13
    //   236: invokestatic 131	com/tencent/mm/plugin/c/a:caJ	()Lcom/tencent/mm/plugin/c/a;
    //   239: invokevirtual 135	com/tencent/mm/plugin/c/a:bAc	()Lcom/tencent/mm/storage/g;
    //   242: aload_2
    //   243: iload 11
    //   245: invokeinterface 139 2 0
    //   250: checkcast 141	java/lang/String
    //   253: invokevirtual 147	com/tencent/mm/storage/g:bvd	(Ljava/lang/String;)Ljava/lang/String;
    //   256: ldc 23
    //   258: invokestatic 153	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   261: invokeinterface 157 2 0
    //   266: pop
    //   267: iload 11
    //   269: iconst_1
    //   270: iadd
    //   271: istore 11
    //   273: goto -50 -> 223
    //   276: iconst_0
    //   277: istore 12
    //   279: goto -247 -> 32
    //   282: iconst_0
    //   283: istore 11
    //   285: iload 11
    //   287: aload 13
    //   289: invokeinterface 67 1 0
    //   294: if_icmpge -79 -> 215
    //   297: invokestatic 131	com/tencent/mm/plugin/c/a:caJ	()Lcom/tencent/mm/plugin/c/a;
    //   300: invokevirtual 135	com/tencent/mm/plugin/c/a:bAc	()Lcom/tencent/mm/storage/g;
    //   303: aload_2
    //   304: iload 11
    //   306: invokeinterface 139 2 0
    //   311: checkcast 141	java/lang/String
    //   314: ldc 158
    //   316: aload 13
    //   318: iload 11
    //   320: invokeinterface 139 2 0
    //   325: checkcast 141	java/lang/String
    //   328: invokevirtual 162	com/tencent/mm/storage/g:V	(Ljava/lang/String;ILjava/lang/String;)V
    //   331: iload 11
    //   333: iconst_1
    //   334: iadd
    //   335: istore 11
    //   337: goto -52 -> 285
    //   340: aload_0
    //   341: getfield 107	com/tencent/mm/pluginsdk/model/v:rr	Lcom/tencent/mm/am/c;
    //   344: getfield 168	com/tencent/mm/am/c:otB	Lcom/tencent/mm/am/c$b;
    //   347: invokestatic 174	com/tencent/mm/am/c$b:b	(Lcom/tencent/mm/am/c$b;)Lcom/tencent/mm/bx/a;
    //   350: checkcast 75	com/tencent/mm/protocal/protobuf/fwu
    //   353: astore 14
    //   355: aload 14
    //   357: iload_1
    //   358: putfield 177	com/tencent/mm/protocal/protobuf/fwu:YKH	I
    //   361: aload 14
    //   363: aload 5
    //   365: putfield 180	com/tencent/mm/protocal/protobuf/fwu:aayW	Ljava/lang/String;
    //   368: aload_0
    //   369: aload 5
    //   371: putfield 182	com/tencent/mm/pluginsdk/model/v:XRs	Ljava/lang/String;
    //   374: aload 10
    //   376: invokestatic 186	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   379: ifne +10 -> 389
    //   382: aload 14
    //   384: aload 10
    //   386: putfield 189	com/tencent/mm/protocal/protobuf/fwu:abUG	Ljava/lang/String;
    //   389: new 69	java/util/LinkedList
    //   392: dup
    //   393: invokespecial 70	java/util/LinkedList:<init>	()V
    //   396: astore 5
    //   398: iconst_0
    //   399: istore_1
    //   400: iload_1
    //   401: aload_2
    //   402: invokeinterface 67 1 0
    //   407: if_icmpge +278 -> 685
    //   410: new 191	com/tencent/mm/protocal/protobuf/fwr
    //   413: dup
    //   414: invokespecial 192	com/tencent/mm/protocal/protobuf/fwr:<init>	()V
    //   417: astore 10
    //   419: aload 10
    //   421: aload_2
    //   422: iload_1
    //   423: invokeinterface 139 2 0
    //   428: checkcast 141	java/lang/String
    //   431: putfield 195	com/tencent/mm/protocal/protobuf/fwr:OzQ	Ljava/lang/String;
    //   434: aload 6
    //   436: ifnonnull +242 -> 678
    //   439: ldc 23
    //   441: astore 4
    //   443: aload 10
    //   445: aload 4
    //   447: putfield 198	com/tencent/mm/protocal/protobuf/fwr:abUp	Ljava/lang/String;
    //   450: invokestatic 131	com/tencent/mm/plugin/c/a:caJ	()Lcom/tencent/mm/plugin/c/a;
    //   453: invokevirtual 135	com/tencent/mm/plugin/c/a:bAc	()Lcom/tencent/mm/storage/g;
    //   456: astore 4
    //   458: aload 10
    //   460: getfield 195	com/tencent/mm/protocal/protobuf/fwr:OzQ	Ljava/lang/String;
    //   463: astore 15
    //   465: aload_3
    //   466: iload_1
    //   467: invokeinterface 139 2 0
    //   472: checkcast 115	java/lang/Integer
    //   475: invokevirtual 201	java/lang/Integer:intValue	()I
    //   478: pop
    //   479: aload 10
    //   481: aload 4
    //   483: aload 15
    //   485: invokevirtual 147	com/tencent/mm/storage/g:bvd	(Ljava/lang/String;)Ljava/lang/String;
    //   488: ldc 23
    //   490: invokestatic 153	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   493: putfield 204	com/tencent/mm/protocal/protobuf/fwr:aant	Ljava/lang/String;
    //   496: aload 10
    //   498: getfield 204	com/tencent/mm/protocal/protobuf/fwr:aant	Ljava/lang/String;
    //   501: invokestatic 210	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   504: ifeq +35 -> 539
    //   507: aload 13
    //   509: ifnull +30 -> 539
    //   512: aload 13
    //   514: invokeinterface 67 1 0
    //   519: iload_1
    //   520: if_icmple +19 -> 539
    //   523: aload 10
    //   525: aload 13
    //   527: iload_1
    //   528: invokeinterface 139 2 0
    //   533: checkcast 141	java/lang/String
    //   536: putfield 204	com/tencent/mm/protocal/protobuf/fwr:aant	Ljava/lang/String;
    //   539: aload 10
    //   541: aload 8
    //   543: putfield 213	com/tencent/mm/protocal/protobuf/fwr:abwa	Ljava/lang/String;
    //   546: aload 7
    //   548: ifnull +41 -> 589
    //   551: aload 7
    //   553: aload 10
    //   555: getfield 195	com/tencent/mm/protocal/protobuf/fwr:OzQ	Ljava/lang/String;
    //   558: invokeinterface 218 2 0
    //   563: ifeq +26 -> 589
    //   566: aload 10
    //   568: aload 7
    //   570: aload 10
    //   572: getfield 195	com/tencent/mm/protocal/protobuf/fwr:OzQ	Ljava/lang/String;
    //   575: invokeinterface 221 2 0
    //   580: checkcast 115	java/lang/Integer
    //   583: invokevirtual 201	java/lang/Integer:intValue	()I
    //   586: putfield 224	com/tencent/mm/protocal/protobuf/fwr:abUq	I
    //   589: aload 10
    //   591: aload 9
    //   593: putfield 227	com/tencent/mm/protocal/protobuf/fwr:abUu	Ljava/lang/String;
    //   596: ldc 109
    //   598: ldc 229
    //   600: bipush 7
    //   602: anewarray 113	java/lang/Object
    //   605: dup
    //   606: iconst_0
    //   607: aload_0
    //   608: getfield 51	com/tencent/mm/pluginsdk/model/v:hId	I
    //   611: invokestatic 119	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   614: aastore
    //   615: dup
    //   616: iconst_1
    //   617: iload_1
    //   618: invokestatic 119	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   621: aastore
    //   622: dup
    //   623: iconst_2
    //   624: aload 10
    //   626: getfield 195	com/tencent/mm/protocal/protobuf/fwr:OzQ	Ljava/lang/String;
    //   629: aastore
    //   630: dup
    //   631: iconst_3
    //   632: aload 10
    //   634: getfield 204	com/tencent/mm/protocal/protobuf/fwr:aant	Ljava/lang/String;
    //   637: aastore
    //   638: dup
    //   639: iconst_4
    //   640: aload 8
    //   642: aastore
    //   643: dup
    //   644: iconst_5
    //   645: aload 9
    //   647: aastore
    //   648: dup
    //   649: bipush 6
    //   651: aload 10
    //   653: getfield 224	com/tencent/mm/protocal/protobuf/fwr:abUq	I
    //   656: invokestatic 119	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   659: aastore
    //   660: invokestatic 231	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   663: aload 5
    //   665: aload 10
    //   667: invokevirtual 232	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   670: pop
    //   671: iload_1
    //   672: iconst_1
    //   673: iadd
    //   674: istore_1
    //   675: goto -275 -> 400
    //   678: aload 6
    //   680: astore 4
    //   682: goto -239 -> 443
    //   685: aload 14
    //   687: aload 5
    //   689: putfield 236	com/tencent/mm/protocal/protobuf/fwu:abUA	Ljava/util/LinkedList;
    //   692: aload 14
    //   694: aload 5
    //   696: invokevirtual 237	java/util/LinkedList:size	()I
    //   699: putfield 240	com/tencent/mm/protocal/protobuf/fwu:abUz	I
    //   702: new 69	java/util/LinkedList
    //   705: dup
    //   706: invokespecial 70	java/util/LinkedList:<init>	()V
    //   709: astore_2
    //   710: aload_2
    //   711: aload_3
    //   712: invokevirtual 244	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
    //   715: pop
    //   716: aload 14
    //   718: aload_2
    //   719: putfield 247	com/tencent/mm/protocal/protobuf/fwu:abUC	Ljava/util/LinkedList;
    //   722: aload 14
    //   724: aload_2
    //   725: invokevirtual 237	java/util/LinkedList:size	()I
    //   728: putfield 250	com/tencent/mm/protocal/protobuf/fwu:abUB	I
    //   731: getstatic 256	com/tencent/mm/plugin/normsg/a/d:MtP	Lcom/tencent/mm/plugin/normsg/a/d;
    //   734: ldc_w 258
    //   737: invokevirtual 261	com/tencent/mm/plugin/normsg/a/d:aQk	(Ljava/lang/String;)Z
    //   740: ifeq +12 -> 752
    //   743: getstatic 256	com/tencent/mm/plugin/normsg/a/d:MtP	Lcom/tencent/mm/plugin/normsg/a/d;
    //   746: ldc_w 258
    //   749: invokevirtual 265	com/tencent/mm/plugin/normsg/a/d:aQj	(Ljava/lang/String;)V
    //   752: new 267	com/tencent/mm/protocal/protobuf/gdd
    //   755: dup
    //   756: invokespecial 268	com/tencent/mm/protocal/protobuf/gdd:<init>	()V
    //   759: astore_2
    //   760: aload_2
    //   761: new 270	com/tencent/mm/protocal/protobuf/gol
    //   764: dup
    //   765: invokespecial 271	com/tencent/mm/protocal/protobuf/gol:<init>	()V
    //   768: getstatic 256	com/tencent/mm/plugin/normsg/a/d:MtP	Lcom/tencent/mm/plugin/normsg/a/d;
    //   771: ldc_w 258
    //   774: invokevirtual 275	com/tencent/mm/plugin/normsg/a/d:aQl	(Ljava/lang/String;)[B
    //   777: invokevirtual 279	com/tencent/mm/protocal/protobuf/gol:df	([B)Lcom/tencent/mm/protocal/protobuf/gol;
    //   780: putfield 283	com/tencent/mm/protocal/protobuf/gdd:acaV	Lcom/tencent/mm/protocal/protobuf/gol;
    //   783: aload_2
    //   784: getfield 283	com/tencent/mm/protocal/protobuf/gdd:acaV	Lcom/tencent/mm/protocal/protobuf/gol;
    //   787: ifnull +271 -> 1058
    //   790: aload_2
    //   791: getfield 283	com/tencent/mm/protocal/protobuf/gdd:acaV	Lcom/tencent/mm/protocal/protobuf/gol;
    //   794: getfield 286	com/tencent/mm/protocal/protobuf/gol:abwJ	I
    //   797: istore_1
    //   798: ldc 109
    //   800: ldc_w 288
    //   803: iconst_1
    //   804: anewarray 113	java/lang/Object
    //   807: dup
    //   808: iconst_0
    //   809: iload_1
    //   810: invokestatic 119	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   813: aastore
    //   814: invokestatic 291	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   817: aload_2
    //   818: new 270	com/tencent/mm/protocal/protobuf/gol
    //   821: dup
    //   822: invokespecial 271	com/tencent/mm/protocal/protobuf/gol:<init>	()V
    //   825: getstatic 256	com/tencent/mm/plugin/normsg/a/d:MtP	Lcom/tencent/mm/plugin/normsg/a/d;
    //   828: ldc_w 293
    //   831: invokevirtual 296	com/tencent/mm/plugin/normsg/a/d:aQo	(Ljava/lang/String;)[B
    //   834: invokevirtual 279	com/tencent/mm/protocal/protobuf/gol:df	([B)Lcom/tencent/mm/protocal/protobuf/gol;
    //   837: putfield 299	com/tencent/mm/protocal/protobuf/gdd:acaW	Lcom/tencent/mm/protocal/protobuf/gol;
    //   840: aload_2
    //   841: getfield 299	com/tencent/mm/protocal/protobuf/gdd:acaW	Lcom/tencent/mm/protocal/protobuf/gol;
    //   844: ifnull +219 -> 1063
    //   847: aload_2
    //   848: getfield 299	com/tencent/mm/protocal/protobuf/gdd:acaW	Lcom/tencent/mm/protocal/protobuf/gol;
    //   851: getfield 286	com/tencent/mm/protocal/protobuf/gol:abwJ	I
    //   854: istore_1
    //   855: ldc 109
    //   857: ldc_w 301
    //   860: iconst_1
    //   861: anewarray 113	java/lang/Object
    //   864: dup
    //   865: iconst_0
    //   866: iload_1
    //   867: invokestatic 119	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   870: aastore
    //   871: invokestatic 291	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   874: aload_2
    //   875: new 270	com/tencent/mm/protocal/protobuf/gol
    //   878: dup
    //   879: invokespecial 271	com/tencent/mm/protocal/protobuf/gol:<init>	()V
    //   882: getstatic 256	com/tencent/mm/plugin/normsg/a/d:MtP	Lcom/tencent/mm/plugin/normsg/a/d;
    //   885: invokevirtual 305	com/tencent/mm/plugin/normsg/a/d:gtE	()[B
    //   888: invokevirtual 279	com/tencent/mm/protocal/protobuf/gol:df	([B)Lcom/tencent/mm/protocal/protobuf/gol;
    //   891: putfield 308	com/tencent/mm/protocal/protobuf/gdd:acaX	Lcom/tencent/mm/protocal/protobuf/gol;
    //   894: aload_2
    //   895: getfield 308	com/tencent/mm/protocal/protobuf/gdd:acaX	Lcom/tencent/mm/protocal/protobuf/gol;
    //   898: ifnull +170 -> 1068
    //   901: aload_2
    //   902: getfield 308	com/tencent/mm/protocal/protobuf/gdd:acaX	Lcom/tencent/mm/protocal/protobuf/gol;
    //   905: getfield 286	com/tencent/mm/protocal/protobuf/gol:abwJ	I
    //   908: istore_1
    //   909: ldc 109
    //   911: ldc_w 310
    //   914: iconst_1
    //   915: anewarray 113	java/lang/Object
    //   918: dup
    //   919: iconst_0
    //   920: iload_1
    //   921: invokestatic 119	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   924: aastore
    //   925: invokestatic 291	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   928: getstatic 256	com/tencent/mm/plugin/normsg/a/d:MtP	Lcom/tencent/mm/plugin/normsg/a/d;
    //   931: ldc_w 293
    //   934: invokevirtual 313	com/tencent/mm/plugin/normsg/a/d:aQp	(Ljava/lang/String;)Ljava/lang/String;
    //   937: astore_3
    //   938: aload_3
    //   939: ifnull +21 -> 960
    //   942: aload_2
    //   943: new 270	com/tencent/mm/protocal/protobuf/gol
    //   946: dup
    //   947: invokespecial 271	com/tencent/mm/protocal/protobuf/gol:<init>	()V
    //   950: aload_3
    //   951: invokevirtual 316	java/lang/String:getBytes	()[B
    //   954: invokevirtual 279	com/tencent/mm/protocal/protobuf/gol:df	([B)Lcom/tencent/mm/protocal/protobuf/gol;
    //   957: putfield 319	com/tencent/mm/protocal/protobuf/gdd:acbc	Lcom/tencent/mm/protocal/protobuf/gol;
    //   960: aload 14
    //   962: new 270	com/tencent/mm/protocal/protobuf/gol
    //   965: dup
    //   966: invokespecial 271	com/tencent/mm/protocal/protobuf/gol:<init>	()V
    //   969: aload_2
    //   970: invokevirtual 322	com/tencent/mm/protocal/protobuf/gdd:toByteArray	()[B
    //   973: invokevirtual 279	com/tencent/mm/protocal/protobuf/gol:df	([B)Lcom/tencent/mm/protocal/protobuf/gol;
    //   976: putfield 325	com/tencent/mm/protocal/protobuf/fwu:YKb	Lcom/tencent/mm/protocal/protobuf/gol;
    //   979: ldc 109
    //   981: ldc_w 327
    //   984: bipush 6
    //   986: anewarray 113	java/lang/Object
    //   989: dup
    //   990: iconst_0
    //   991: aload_0
    //   992: getfield 51	com/tencent/mm/pluginsdk/model/v:hId	I
    //   995: invokestatic 119	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   998: aastore
    //   999: dup
    //   1000: iconst_1
    //   1001: aload 14
    //   1003: getfield 236	com/tencent/mm/protocal/protobuf/fwu:abUA	Ljava/util/LinkedList;
    //   1006: invokevirtual 237	java/util/LinkedList:size	()I
    //   1009: invokestatic 119	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1012: aastore
    //   1013: dup
    //   1014: iconst_2
    //   1015: aload 14
    //   1017: getfield 247	com/tencent/mm/protocal/protobuf/fwu:abUC	Ljava/util/LinkedList;
    //   1020: invokevirtual 237	java/util/LinkedList:size	()I
    //   1023: invokestatic 119	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1026: aastore
    //   1027: dup
    //   1028: iconst_3
    //   1029: aload 13
    //   1031: ldc_w 329
    //   1034: invokestatic 333	com/tencent/mm/sdk/platformtools/Util:listToString	(Ljava/util/List;Ljava/lang/String;)Ljava/lang/String;
    //   1037: aastore
    //   1038: dup
    //   1039: iconst_4
    //   1040: aload 8
    //   1042: aastore
    //   1043: dup
    //   1044: iconst_5
    //   1045: invokestatic 337	com/tencent/mm/sdk/platformtools/Util:getStack	()Lcom/tencent/mm/sdk/platformtools/MMStack;
    //   1048: aastore
    //   1049: invokestatic 231	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1052: ldc 47
    //   1054: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1057: return
    //   1058: iconst_m1
    //   1059: istore_1
    //   1060: goto -262 -> 798
    //   1063: iconst_m1
    //   1064: istore_1
    //   1065: goto -210 -> 855
    //   1068: iconst_m1
    //   1069: istore_1
    //   1070: goto -161 -> 909
    //   1073: astore_2
    //   1074: goto -95 -> 979
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1077	0	this	v
    //   0	1077	1	paramInt	int
    //   0	1077	2	paramList1	List<String>
    //   0	1077	3	paramList	List<Integer>
    //   0	1077	4	paramList2	List<String>
    //   0	1077	5	paramString1	String
    //   0	1077	6	paramString2	String
    //   0	1077	7	paramMap	Map<String, Integer>
    //   0	1077	8	paramString3	String
    //   0	1077	9	paramString4	String
    //   0	1077	10	paramString5	String
    //   221	115	11	i	int
    //   30	248	12	bool	boolean
    //   56	974	13	localObject	Object
    //   353	663	14	localfwu	fwu
    //   463	21	15	str	String
    // Exception table:
    //   from	to	target	type
    //   960	979	1073	finally
  }
  
  public v(String paramString1, String paramString2, int paramInt)
  {
    this(paramString1, paramString2, paramInt, null, 0);
  }
  
  /* Error */
  public v(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 46	com/tencent/mm/am/p:<init>	()V
    //   4: ldc_w 343
    //   7: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: aconst_null
    //   12: putfield 49	com/tencent/mm/pluginsdk/model/v:XRr	Ljava/util/List;
    //   15: aload_0
    //   16: iconst_0
    //   17: putfield 51	com/tencent/mm/pluginsdk/model/v:hId	I
    //   20: aload_0
    //   21: aconst_null
    //   22: putfield 53	com/tencent/mm/pluginsdk/model/v:XRt	Ljava/util/List;
    //   25: ldc_w 345
    //   28: iconst_1
    //   29: invokestatic 61	junit/framework/Assert:assertTrue	(Ljava/lang/String;Z)V
    //   32: aload_0
    //   33: new 69	java/util/LinkedList
    //   36: dup
    //   37: invokespecial 70	java/util/LinkedList:<init>	()V
    //   40: putfield 49	com/tencent/mm/pluginsdk/model/v:XRr	Ljava/util/List;
    //   43: aload_0
    //   44: getfield 49	com/tencent/mm/pluginsdk/model/v:XRr	Ljava/util/List;
    //   47: aload_1
    //   48: invokeinterface 157 2 0
    //   53: pop
    //   54: aload_0
    //   55: iconst_3
    //   56: putfield 51	com/tencent/mm/pluginsdk/model/v:hId	I
    //   59: new 72	com/tencent/mm/am/c$a
    //   62: dup
    //   63: invokespecial 73	com/tencent/mm/am/c$a:<init>	()V
    //   66: astore 6
    //   68: aload 6
    //   70: new 75	com/tencent/mm/protocal/protobuf/fwu
    //   73: dup
    //   74: invokespecial 76	com/tencent/mm/protocal/protobuf/fwu:<init>	()V
    //   77: putfield 80	com/tencent/mm/am/c$a:otE	Lcom/tencent/mm/bx/a;
    //   80: aload 6
    //   82: new 82	com/tencent/mm/protocal/protobuf/fwv
    //   85: dup
    //   86: invokespecial 83	com/tencent/mm/protocal/protobuf/fwv:<init>	()V
    //   89: putfield 86	com/tencent/mm/am/c$a:otF	Lcom/tencent/mm/bx/a;
    //   92: aload 6
    //   94: ldc 88
    //   96: putfield 91	com/tencent/mm/am/c$a:uri	Ljava/lang/String;
    //   99: aload 6
    //   101: sipush 137
    //   104: putfield 94	com/tencent/mm/am/c$a:funcId	I
    //   107: aload 6
    //   109: bipush 44
    //   111: putfield 97	com/tencent/mm/am/c$a:otG	I
    //   114: aload 6
    //   116: ldc 98
    //   118: putfield 101	com/tencent/mm/am/c$a:respCmdId	I
    //   121: aload_0
    //   122: aload 6
    //   124: invokevirtual 105	com/tencent/mm/am/c$a:bEF	()Lcom/tencent/mm/am/c;
    //   127: putfield 107	com/tencent/mm/pluginsdk/model/v:rr	Lcom/tencent/mm/am/c;
    //   130: aload_0
    //   131: getfield 107	com/tencent/mm/pluginsdk/model/v:rr	Lcom/tencent/mm/am/c;
    //   134: getfield 168	com/tencent/mm/am/c:otB	Lcom/tencent/mm/am/c$b;
    //   137: invokestatic 174	com/tencent/mm/am/c$b:b	(Lcom/tencent/mm/am/c$b;)Lcom/tencent/mm/bx/a;
    //   140: checkcast 75	com/tencent/mm/protocal/protobuf/fwu
    //   143: astore 6
    //   145: aload 6
    //   147: iconst_3
    //   148: putfield 177	com/tencent/mm/protocal/protobuf/fwu:YKH	I
    //   151: aload 6
    //   153: ldc 23
    //   155: putfield 180	com/tencent/mm/protocal/protobuf/fwu:aayW	Ljava/lang/String;
    //   158: new 69	java/util/LinkedList
    //   161: dup
    //   162: invokespecial 70	java/util/LinkedList:<init>	()V
    //   165: astore 8
    //   167: new 191	com/tencent/mm/protocal/protobuf/fwr
    //   170: dup
    //   171: invokespecial 192	com/tencent/mm/protocal/protobuf/fwr:<init>	()V
    //   174: astore 7
    //   176: aload 7
    //   178: aload_1
    //   179: putfield 195	com/tencent/mm/protocal/protobuf/fwr:OzQ	Ljava/lang/String;
    //   182: aload 7
    //   184: aload_2
    //   185: putfield 198	com/tencent/mm/protocal/protobuf/fwr:abUp	Ljava/lang/String;
    //   188: aload 7
    //   190: invokestatic 131	com/tencent/mm/plugin/c/a:caJ	()Lcom/tencent/mm/plugin/c/a;
    //   193: invokevirtual 135	com/tencent/mm/plugin/c/a:bAc	()Lcom/tencent/mm/storage/g;
    //   196: aload_1
    //   197: invokevirtual 147	com/tencent/mm/storage/g:bvd	(Ljava/lang/String;)Ljava/lang/String;
    //   200: putfield 204	com/tencent/mm/protocal/protobuf/fwr:aant	Ljava/lang/String;
    //   203: aload 7
    //   205: aload 4
    //   207: putfield 213	com/tencent/mm/protocal/protobuf/fwr:abwa	Ljava/lang/String;
    //   210: iload 5
    //   212: ifle +10 -> 222
    //   215: aload 7
    //   217: iload 5
    //   219: putfield 224	com/tencent/mm/protocal/protobuf/fwr:abUq	I
    //   222: aload 8
    //   224: aload 7
    //   226: invokevirtual 232	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   229: pop
    //   230: aload 6
    //   232: aload 8
    //   234: putfield 236	com/tencent/mm/protocal/protobuf/fwu:abUA	Ljava/util/LinkedList;
    //   237: aload 6
    //   239: aload 8
    //   241: invokevirtual 237	java/util/LinkedList:size	()I
    //   244: putfield 240	com/tencent/mm/protocal/protobuf/fwu:abUz	I
    //   247: new 69	java/util/LinkedList
    //   250: dup
    //   251: invokespecial 70	java/util/LinkedList:<init>	()V
    //   254: astore_1
    //   255: aload_1
    //   256: iload_3
    //   257: invokestatic 119	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   260: invokevirtual 232	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   263: pop
    //   264: aload 6
    //   266: aload_1
    //   267: putfield 247	com/tencent/mm/protocal/protobuf/fwu:abUC	Ljava/util/LinkedList;
    //   270: aload 6
    //   272: aload_1
    //   273: invokevirtual 237	java/util/LinkedList:size	()I
    //   276: putfield 250	com/tencent/mm/protocal/protobuf/fwu:abUB	I
    //   279: getstatic 256	com/tencent/mm/plugin/normsg/a/d:MtP	Lcom/tencent/mm/plugin/normsg/a/d;
    //   282: ldc_w 258
    //   285: invokevirtual 261	com/tencent/mm/plugin/normsg/a/d:aQk	(Ljava/lang/String;)Z
    //   288: ifeq +12 -> 300
    //   291: getstatic 256	com/tencent/mm/plugin/normsg/a/d:MtP	Lcom/tencent/mm/plugin/normsg/a/d;
    //   294: ldc_w 258
    //   297: invokevirtual 265	com/tencent/mm/plugin/normsg/a/d:aQj	(Ljava/lang/String;)V
    //   300: new 267	com/tencent/mm/protocal/protobuf/gdd
    //   303: dup
    //   304: invokespecial 268	com/tencent/mm/protocal/protobuf/gdd:<init>	()V
    //   307: astore_1
    //   308: aload_1
    //   309: new 270	com/tencent/mm/protocal/protobuf/gol
    //   312: dup
    //   313: invokespecial 271	com/tencent/mm/protocal/protobuf/gol:<init>	()V
    //   316: getstatic 256	com/tencent/mm/plugin/normsg/a/d:MtP	Lcom/tencent/mm/plugin/normsg/a/d;
    //   319: ldc_w 258
    //   322: invokevirtual 275	com/tencent/mm/plugin/normsg/a/d:aQl	(Ljava/lang/String;)[B
    //   325: invokevirtual 279	com/tencent/mm/protocal/protobuf/gol:df	([B)Lcom/tencent/mm/protocal/protobuf/gol;
    //   328: putfield 283	com/tencent/mm/protocal/protobuf/gdd:acaV	Lcom/tencent/mm/protocal/protobuf/gol;
    //   331: aload_1
    //   332: getfield 283	com/tencent/mm/protocal/protobuf/gdd:acaV	Lcom/tencent/mm/protocal/protobuf/gol;
    //   335: ifnull +262 -> 597
    //   338: aload_1
    //   339: getfield 283	com/tencent/mm/protocal/protobuf/gdd:acaV	Lcom/tencent/mm/protocal/protobuf/gol;
    //   342: getfield 286	com/tencent/mm/protocal/protobuf/gol:abwJ	I
    //   345: istore_3
    //   346: ldc 109
    //   348: ldc_w 288
    //   351: iconst_1
    //   352: anewarray 113	java/lang/Object
    //   355: dup
    //   356: iconst_0
    //   357: iload_3
    //   358: invokestatic 119	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   361: aastore
    //   362: invokestatic 291	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   365: aload_1
    //   366: new 270	com/tencent/mm/protocal/protobuf/gol
    //   369: dup
    //   370: invokespecial 271	com/tencent/mm/protocal/protobuf/gol:<init>	()V
    //   373: getstatic 256	com/tencent/mm/plugin/normsg/a/d:MtP	Lcom/tencent/mm/plugin/normsg/a/d;
    //   376: ldc_w 293
    //   379: invokevirtual 296	com/tencent/mm/plugin/normsg/a/d:aQo	(Ljava/lang/String;)[B
    //   382: invokevirtual 279	com/tencent/mm/protocal/protobuf/gol:df	([B)Lcom/tencent/mm/protocal/protobuf/gol;
    //   385: putfield 299	com/tencent/mm/protocal/protobuf/gdd:acaW	Lcom/tencent/mm/protocal/protobuf/gol;
    //   388: aload_1
    //   389: getfield 299	com/tencent/mm/protocal/protobuf/gdd:acaW	Lcom/tencent/mm/protocal/protobuf/gol;
    //   392: ifnull +210 -> 602
    //   395: aload_1
    //   396: getfield 299	com/tencent/mm/protocal/protobuf/gdd:acaW	Lcom/tencent/mm/protocal/protobuf/gol;
    //   399: getfield 286	com/tencent/mm/protocal/protobuf/gol:abwJ	I
    //   402: istore_3
    //   403: ldc 109
    //   405: ldc_w 301
    //   408: iconst_1
    //   409: anewarray 113	java/lang/Object
    //   412: dup
    //   413: iconst_0
    //   414: iload_3
    //   415: invokestatic 119	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   418: aastore
    //   419: invokestatic 291	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   422: aload_1
    //   423: new 270	com/tencent/mm/protocal/protobuf/gol
    //   426: dup
    //   427: invokespecial 271	com/tencent/mm/protocal/protobuf/gol:<init>	()V
    //   430: getstatic 256	com/tencent/mm/plugin/normsg/a/d:MtP	Lcom/tencent/mm/plugin/normsg/a/d;
    //   433: invokevirtual 305	com/tencent/mm/plugin/normsg/a/d:gtE	()[B
    //   436: invokevirtual 279	com/tencent/mm/protocal/protobuf/gol:df	([B)Lcom/tencent/mm/protocal/protobuf/gol;
    //   439: putfield 308	com/tencent/mm/protocal/protobuf/gdd:acaX	Lcom/tencent/mm/protocal/protobuf/gol;
    //   442: aload_1
    //   443: getfield 308	com/tencent/mm/protocal/protobuf/gdd:acaX	Lcom/tencent/mm/protocal/protobuf/gol;
    //   446: ifnull +161 -> 607
    //   449: aload_1
    //   450: getfield 308	com/tencent/mm/protocal/protobuf/gdd:acaX	Lcom/tencent/mm/protocal/protobuf/gol;
    //   453: getfield 286	com/tencent/mm/protocal/protobuf/gol:abwJ	I
    //   456: istore_3
    //   457: ldc 109
    //   459: ldc_w 310
    //   462: iconst_1
    //   463: anewarray 113	java/lang/Object
    //   466: dup
    //   467: iconst_0
    //   468: iload_3
    //   469: invokestatic 119	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   472: aastore
    //   473: invokestatic 291	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   476: getstatic 256	com/tencent/mm/plugin/normsg/a/d:MtP	Lcom/tencent/mm/plugin/normsg/a/d;
    //   479: ldc_w 293
    //   482: invokevirtual 313	com/tencent/mm/plugin/normsg/a/d:aQp	(Ljava/lang/String;)Ljava/lang/String;
    //   485: astore 4
    //   487: aload 4
    //   489: ifnull +22 -> 511
    //   492: aload_1
    //   493: new 270	com/tencent/mm/protocal/protobuf/gol
    //   496: dup
    //   497: invokespecial 271	com/tencent/mm/protocal/protobuf/gol:<init>	()V
    //   500: aload 4
    //   502: invokevirtual 316	java/lang/String:getBytes	()[B
    //   505: invokevirtual 279	com/tencent/mm/protocal/protobuf/gol:df	([B)Lcom/tencent/mm/protocal/protobuf/gol;
    //   508: putfield 319	com/tencent/mm/protocal/protobuf/gdd:acbc	Lcom/tencent/mm/protocal/protobuf/gol;
    //   511: aload 6
    //   513: new 270	com/tencent/mm/protocal/protobuf/gol
    //   516: dup
    //   517: invokespecial 271	com/tencent/mm/protocal/protobuf/gol:<init>	()V
    //   520: aload_1
    //   521: invokevirtual 322	com/tencent/mm/protocal/protobuf/gdd:toByteArray	()[B
    //   524: invokevirtual 279	com/tencent/mm/protocal/protobuf/gol:df	([B)Lcom/tencent/mm/protocal/protobuf/gol;
    //   527: putfield 325	com/tencent/mm/protocal/protobuf/fwu:YKb	Lcom/tencent/mm/protocal/protobuf/gol;
    //   530: ldc 109
    //   532: ldc_w 347
    //   535: iconst_5
    //   536: anewarray 113	java/lang/Object
    //   539: dup
    //   540: iconst_0
    //   541: aload 6
    //   543: getfield 236	com/tencent/mm/protocal/protobuf/fwu:abUA	Ljava/util/LinkedList;
    //   546: invokevirtual 237	java/util/LinkedList:size	()I
    //   549: invokestatic 119	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   552: aastore
    //   553: dup
    //   554: iconst_1
    //   555: aload 6
    //   557: getfield 247	com/tencent/mm/protocal/protobuf/fwu:abUC	Ljava/util/LinkedList;
    //   560: invokevirtual 237	java/util/LinkedList:size	()I
    //   563: invokestatic 119	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   566: aastore
    //   567: dup
    //   568: iconst_2
    //   569: aload_2
    //   570: aastore
    //   571: dup
    //   572: iconst_3
    //   573: aload 7
    //   575: getfield 204	com/tencent/mm/protocal/protobuf/fwr:aant	Ljava/lang/String;
    //   578: aastore
    //   579: dup
    //   580: iconst_4
    //   581: iload 5
    //   583: invokestatic 119	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   586: aastore
    //   587: invokestatic 231	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   590: ldc_w 343
    //   593: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   596: return
    //   597: iconst_m1
    //   598: istore_3
    //   599: goto -253 -> 346
    //   602: iconst_m1
    //   603: istore_3
    //   604: goto -201 -> 403
    //   607: iconst_m1
    //   608: istore_3
    //   609: goto -152 -> 457
    //   612: astore_1
    //   613: goto -83 -> 530
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	616	0	this	v
    //   0	616	1	paramString1	String
    //   0	616	2	paramString2	String
    //   0	616	3	paramInt1	int
    //   0	616	4	paramString3	String
    //   0	616	5	paramInt2	int
    //   66	490	6	localObject	Object
    //   174	400	7	localfwr	fwr
    //   165	75	8	localLinkedList	LinkedList
    // Exception table:
    //   from	to	target	type
    //   511	530	612	finally
  }
  
  public v(List<String> paramList, List<Integer> paramList1, String paramString1, String paramString2)
  {
    this(1, paramList, paramList1, null, paramString1, paramString2, null, null, "");
  }
  
  public final void Jv(boolean paramBoolean)
  {
    AppMethodBeat.i(244793);
    fwu localfwu = (fwu)c.b.b(this.rr.otB);
    if (paramBoolean)
    {
      localfwu.abUF = 1;
      AppMethodBeat.o(244793);
      return;
    }
    localfwu.abUF = 0;
    AppMethodBeat.o(244793);
  }
  
  public final void OW(String paramString)
  {
    AppMethodBeat.i(151641);
    Iterator localIterator = ((fwu)c.b.b(this.rr.otB)).abUA.iterator();
    while (localIterator.hasNext()) {
      ((fwr)localIterator.next()).aamF = paramString;
    }
    AppMethodBeat.o(151641);
  }
  
  public final void a(fws paramfws)
  {
    AppMethodBeat.i(151643);
    if (paramfws == null)
    {
      AppMethodBeat.o(151643);
      return;
    }
    Log.d("MicroMsg.NetSceneVerifyUser.dkverify", "setBizReportInfo SubScene:%d, MpScene:%d, SceneNote:%s", new Object[] { Integer.valueOf(paramfws.YIc), Integer.valueOf(paramfws.abUy), paramfws.Zsa });
    Iterator localIterator = ((fwu)c.b.b(this.rr.otB)).abUA.iterator();
    while (localIterator.hasNext())
    {
      fwr localfwr = (fwr)localIterator.next();
      try
      {
        localfwr.abUx = new gol().df(paramfws.toByteArray());
      }
      catch (IOException localIOException)
      {
        Log.e("MicroMsg.NetSceneVerifyUser.dkverify", "setBizReportInfo %s", new Object[] { localIOException.getMessage() });
      }
    }
    AppMethodBeat.o(151643);
  }
  
  public int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(151644);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(151644);
    return i;
  }
  
  public int getType()
  {
    return 30;
  }
  
  public final String iIc()
  {
    AppMethodBeat.i(244797);
    if ((this.rr != null) && (this.rr.otC != null))
    {
      String str = ((fwv)c.c.b(this.rr.otC)).UserName;
      AppMethodBeat.o(244797);
      return str;
    }
    AppMethodBeat.o(244797);
    return "";
  }
  
  public final fwv iId()
  {
    AppMethodBeat.i(244811);
    fwv localfwv = (fwv)c.c.b(this.rr.otC);
    AppMethodBeat.o(244811);
    return localfwv;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151645);
    updateDispatchId(paramInt1);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.NetSceneVerifyUser.dkverify", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151645);
  }
  
  public final void pg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151640);
    Iterator localIterator = ((fwu)c.b.b(this.rr.otB)).abUA.iterator();
    while (localIterator.hasNext())
    {
      fwr localfwr = (fwr)localIterator.next();
      localfwr.abUr = paramString1;
      localfwr.abUs = paramString2;
    }
    AppMethodBeat.o(151640);
  }
  
  public final void setSubScene(int paramInt)
  {
    AppMethodBeat.i(151642);
    Iterator localIterator = ((fwu)c.b.b(this.rr.otB)).abUA.iterator();
    while (localIterator.hasNext()) {
      ((fwr)localIterator.next()).YIc = paramInt;
    }
    AppMethodBeat.o(151642);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.v
 * JD-Core Version:    0.7.0.1
 */