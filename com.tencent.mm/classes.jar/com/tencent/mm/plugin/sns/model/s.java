package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.nw;
import com.tencent.mm.g.a.rz;
import com.tencent.mm.g.a.sa;
import com.tencent.mm.g.a.sb;
import com.tencent.mm.g.a.wg;
import com.tencent.mm.g.a.wh;
import com.tencent.mm.g.a.wh.a;
import com.tencent.mm.modelvideo.n.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.bct;
import com.tencent.mm.protocal.protobuf.cep;
import com.tencent.mm.protocal.protobuf.cih;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class s
  extends m
  implements k
{
  int cIp;
  public f callback;
  int eDB;
  private com.tencent.mm.sdk.b.c eDE;
  private com.tencent.mm.sdk.b.c eDF;
  boolean eht;
  private TimeLineObject reM;
  private TimeLineObject reN;
  long reO;
  private int reP;
  private wg reQ;
  private wh reR;
  int reS;
  private HashMap<Integer, Integer> reT;
  String reU;
  HashMap<String, bcs> reV;
  HashMap<String, Integer> reW;
  String reX;
  private com.tencent.mm.ai.b rr;
  
  /* Error */
  public s(String paramString1, int paramInt1, int paramInt2, java.util.List<String> paramList, TimeLineObject paramTimeLineObject, int paramInt3, String paramString2, int paramInt4, LinkedList<Long> paramLinkedList, int paramInt5, bct parambct, boolean paramBoolean, LinkedList<com.tencent.mm.protocal.protobuf.bwc> paramLinkedList1, com.tencent.mm.protocal.protobuf.cen paramcen, com.tencent.mm.bv.b paramb, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 48	com/tencent/mm/ai/m:<init>	()V
    //   4: ldc 49
    //   6: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: lconst_0
    //   11: putfield 57	com/tencent/mm/plugin/sns/model/s:reO	J
    //   14: aload_0
    //   15: iconst_0
    //   16: putfield 59	com/tencent/mm/plugin/sns/model/s:eht	Z
    //   19: aload_0
    //   20: iconst_0
    //   21: putfield 61	com/tencent/mm/plugin/sns/model/s:reP	I
    //   24: aload_0
    //   25: new 63	java/util/HashMap
    //   28: dup
    //   29: invokespecial 64	java/util/HashMap:<init>	()V
    //   32: putfield 66	com/tencent/mm/plugin/sns/model/s:reT	Ljava/util/HashMap;
    //   35: aload_0
    //   36: iconst_0
    //   37: putfield 68	com/tencent/mm/plugin/sns/model/s:eDB	I
    //   40: aload_0
    //   41: ldc 70
    //   43: putfield 72	com/tencent/mm/plugin/sns/model/s:reU	Ljava/lang/String;
    //   46: aload_0
    //   47: new 63	java/util/HashMap
    //   50: dup
    //   51: invokespecial 64	java/util/HashMap:<init>	()V
    //   54: putfield 74	com/tencent/mm/plugin/sns/model/s:reV	Ljava/util/HashMap;
    //   57: aload_0
    //   58: new 63	java/util/HashMap
    //   61: dup
    //   62: invokespecial 64	java/util/HashMap:<init>	()V
    //   65: putfield 76	com/tencent/mm/plugin/sns/model/s:reW	Ljava/util/HashMap;
    //   68: aload_0
    //   69: ldc 70
    //   71: putfield 78	com/tencent/mm/plugin/sns/model/s:reX	Ljava/lang/String;
    //   74: aload_0
    //   75: new 80	com/tencent/mm/plugin/sns/model/s$2
    //   78: dup
    //   79: aload_0
    //   80: invokespecial 83	com/tencent/mm/plugin/sns/model/s$2:<init>	(Lcom/tencent/mm/plugin/sns/model/s;)V
    //   83: putfield 85	com/tencent/mm/plugin/sns/model/s:eDE	Lcom/tencent/mm/sdk/b/c;
    //   86: aload_0
    //   87: new 87	com/tencent/mm/plugin/sns/model/s$3
    //   90: dup
    //   91: aload_0
    //   92: invokespecial 88	com/tencent/mm/plugin/sns/model/s$3:<init>	(Lcom/tencent/mm/plugin/sns/model/s;)V
    //   95: putfield 90	com/tencent/mm/plugin/sns/model/s:eDF	Lcom/tencent/mm/sdk/b/c;
    //   98: aload_0
    //   99: aload 5
    //   101: putfield 92	com/tencent/mm/plugin/sns/model/s:reM	Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   104: aload_0
    //   105: iload 6
    //   107: putfield 94	com/tencent/mm/plugin/sns/model/s:cIp	I
    //   110: aload_0
    //   111: iload 10
    //   113: putfield 96	com/tencent/mm/plugin/sns/model/s:reS	I
    //   116: new 98	com/tencent/mm/ai/b$a
    //   119: dup
    //   120: invokespecial 99	com/tencent/mm/ai/b$a:<init>	()V
    //   123: astore 19
    //   125: aload 19
    //   127: new 101	com/tencent/mm/protocal/protobuf/ceo
    //   130: dup
    //   131: invokespecial 102	com/tencent/mm/protocal/protobuf/ceo:<init>	()V
    //   134: putfield 106	com/tencent/mm/ai/b$a:fsX	Lcom/tencent/mm/bv/a;
    //   137: aload 19
    //   139: new 108	com/tencent/mm/protocal/protobuf/cep
    //   142: dup
    //   143: invokespecial 109	com/tencent/mm/protocal/protobuf/cep:<init>	()V
    //   146: putfield 112	com/tencent/mm/ai/b$a:fsY	Lcom/tencent/mm/bv/a;
    //   149: aload 19
    //   151: ldc 114
    //   153: putfield 117	com/tencent/mm/ai/b$a:uri	Ljava/lang/String;
    //   156: aload 19
    //   158: sipush 209
    //   161: putfield 120	com/tencent/mm/ai/b$a:funcId	I
    //   164: aload 19
    //   166: bipush 97
    //   168: putfield 123	com/tencent/mm/ai/b$a:reqCmdId	I
    //   171: aload 19
    //   173: ldc 124
    //   175: putfield 127	com/tencent/mm/ai/b$a:respCmdId	I
    //   178: aload_0
    //   179: aload 19
    //   181: invokevirtual 131	com/tencent/mm/ai/b$a:ado	()Lcom/tencent/mm/ai/b;
    //   184: putfield 133	com/tencent/mm/plugin/sns/model/s:rr	Lcom/tencent/mm/ai/b;
    //   187: aload_0
    //   188: getfield 133	com/tencent/mm/plugin/sns/model/s:rr	Lcom/tencent/mm/ai/b;
    //   191: getfield 139	com/tencent/mm/ai/b:fsV	Lcom/tencent/mm/ai/b$b;
    //   194: getfield 144	com/tencent/mm/ai/b$b:fta	Lcom/tencent/mm/bv/a;
    //   197: checkcast 101	com/tencent/mm/protocal/protobuf/ceo
    //   200: astore 20
    //   202: aload 5
    //   204: getfield 150	com/tencent/mm/protocal/protobuf/TimeLineObject:rjv	Lcom/tencent/mm/protocal/protobuf/av;
    //   207: getfield 156	com/tencent/mm/protocal/protobuf/av:wmJ	Lcom/tencent/mm/protocal/protobuf/at;
    //   210: getfield 161	com/tencent/mm/protocal/protobuf/at:wmE	Ljava/lang/String;
    //   213: invokestatic 167	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   216: ifne +35 -> 251
    //   219: new 169	com/tencent/mm/protocal/protobuf/og
    //   222: dup
    //   223: invokespecial 170	com/tencent/mm/protocal/protobuf/og:<init>	()V
    //   226: astore 19
    //   228: aload 19
    //   230: aload 5
    //   232: getfield 150	com/tencent/mm/protocal/protobuf/TimeLineObject:rjv	Lcom/tencent/mm/protocal/protobuf/av;
    //   235: getfield 156	com/tencent/mm/protocal/protobuf/av:wmJ	Lcom/tencent/mm/protocal/protobuf/at;
    //   238: getfield 161	com/tencent/mm/protocal/protobuf/at:wmE	Ljava/lang/String;
    //   241: putfield 173	com/tencent/mm/protocal/protobuf/og:wDI	Ljava/lang/String;
    //   244: aload 20
    //   246: aload 19
    //   248: putfield 177	com/tencent/mm/protocal/protobuf/ceo:xOX	Lcom/tencent/mm/protocal/protobuf/og;
    //   251: invokestatic 183	com/tencent/mm/model/v:aae	()Lcom/tencent/mm/model/v;
    //   254: aload 11
    //   256: getfield 188	com/tencent/mm/protocal/protobuf/bct:cpW	Ljava/lang/String;
    //   259: invokevirtual 192	com/tencent/mm/model/v:oP	(Ljava/lang/String;)Lcom/tencent/mm/model/v$b;
    //   262: astore 19
    //   264: aload 19
    //   266: ifnull +441 -> 707
    //   269: aload_0
    //   270: new 194	com/tencent/mm/g/a/wg
    //   273: dup
    //   274: invokespecial 195	com/tencent/mm/g/a/wg:<init>	()V
    //   277: putfield 197	com/tencent/mm/plugin/sns/model/s:reQ	Lcom/tencent/mm/g/a/wg;
    //   280: aload_0
    //   281: getfield 197	com/tencent/mm/plugin/sns/model/s:reQ	Lcom/tencent/mm/g/a/wg;
    //   284: getfield 201	com/tencent/mm/g/a/wg:cNx	Lcom/tencent/mm/g/a/wg$a;
    //   287: aload 19
    //   289: ldc 203
    //   291: ldc 70
    //   293: invokevirtual 209	com/tencent/mm/model/v$b:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   296: putfield 214	com/tencent/mm/g/a/wg$a:cNy	Ljava/lang/String;
    //   299: aload_0
    //   300: getfield 197	com/tencent/mm/plugin/sns/model/s:reQ	Lcom/tencent/mm/g/a/wg;
    //   303: getfield 201	com/tencent/mm/g/a/wg:cNx	Lcom/tencent/mm/g/a/wg$a;
    //   306: aload 19
    //   308: ldc 216
    //   310: ldc 70
    //   312: invokevirtual 209	com/tencent/mm/model/v$b:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   315: putfield 218	com/tencent/mm/g/a/wg$a:url	Ljava/lang/String;
    //   318: aload_0
    //   319: getfield 197	com/tencent/mm/plugin/sns/model/s:reQ	Lcom/tencent/mm/g/a/wg;
    //   322: getfield 201	com/tencent/mm/g/a/wg:cNx	Lcom/tencent/mm/g/a/wg$a;
    //   325: aload 19
    //   327: ldc 220
    //   329: ldc 70
    //   331: invokevirtual 209	com/tencent/mm/model/v$b:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   334: putfield 223	com/tencent/mm/g/a/wg$a:cNA	Ljava/lang/String;
    //   337: aload_0
    //   338: getfield 197	com/tencent/mm/plugin/sns/model/s:reQ	Lcom/tencent/mm/g/a/wg;
    //   341: getfield 201	com/tencent/mm/g/a/wg:cNx	Lcom/tencent/mm/g/a/wg$a;
    //   344: aload 19
    //   346: ldc 225
    //   348: ldc 70
    //   350: invokevirtual 209	com/tencent/mm/model/v$b:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   353: putfield 228	com/tencent/mm/g/a/wg$a:cNB	Ljava/lang/String;
    //   356: aload_0
    //   357: getfield 197	com/tencent/mm/plugin/sns/model/s:reQ	Lcom/tencent/mm/g/a/wg;
    //   360: getfield 201	com/tencent/mm/g/a/wg:cNx	Lcom/tencent/mm/g/a/wg$a;
    //   363: aload 19
    //   365: ldc 230
    //   367: iconst_0
    //   368: invokevirtual 234	com/tencent/mm/model/v$b:getInt	(Ljava/lang/String;I)I
    //   371: putfield 237	com/tencent/mm/g/a/wg$a:cNC	I
    //   374: aload_0
    //   375: getfield 197	com/tencent/mm/plugin/sns/model/s:reQ	Lcom/tencent/mm/g/a/wg;
    //   378: getfield 201	com/tencent/mm/g/a/wg:cNx	Lcom/tencent/mm/g/a/wg$a;
    //   381: aload 19
    //   383: ldc 239
    //   385: iconst_0
    //   386: invokevirtual 234	com/tencent/mm/model/v$b:getInt	(Ljava/lang/String;I)I
    //   389: putfield 242	com/tencent/mm/g/a/wg$a:cNG	I
    //   392: aload_0
    //   393: getfield 197	com/tencent/mm/plugin/sns/model/s:reQ	Lcom/tencent/mm/g/a/wg;
    //   396: getfield 201	com/tencent/mm/g/a/wg:cNx	Lcom/tencent/mm/g/a/wg$a;
    //   399: aload 19
    //   401: ldc 244
    //   403: iconst_0
    //   404: invokevirtual 234	com/tencent/mm/model/v$b:getInt	(Ljava/lang/String;I)I
    //   407: putfield 247	com/tencent/mm/g/a/wg$a:cNH	I
    //   410: aload_0
    //   411: getfield 197	com/tencent/mm/plugin/sns/model/s:reQ	Lcom/tencent/mm/g/a/wg;
    //   414: getfield 201	com/tencent/mm/g/a/wg:cNx	Lcom/tencent/mm/g/a/wg$a;
    //   417: aload 19
    //   419: ldc 249
    //   421: aconst_null
    //   422: invokevirtual 209	com/tencent/mm/model/v$b:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   425: putfield 252	com/tencent/mm/g/a/wg$a:cNI	Ljava/lang/String;
    //   428: aload_0
    //   429: getfield 197	com/tencent/mm/plugin/sns/model/s:reQ	Lcom/tencent/mm/g/a/wg;
    //   432: getfield 201	com/tencent/mm/g/a/wg:cNx	Lcom/tencent/mm/g/a/wg$a;
    //   435: aload 19
    //   437: ldc 254
    //   439: aconst_null
    //   440: invokevirtual 209	com/tencent/mm/model/v$b:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   443: putfield 257	com/tencent/mm/g/a/wg$a:cNJ	Ljava/lang/String;
    //   446: aload_0
    //   447: getfield 197	com/tencent/mm/plugin/sns/model/s:reQ	Lcom/tencent/mm/g/a/wg;
    //   450: getfield 201	com/tencent/mm/g/a/wg:cNx	Lcom/tencent/mm/g/a/wg$a;
    //   453: aload 16
    //   455: putfield 260	com/tencent/mm/g/a/wg$a:cNK	Ljava/lang/String;
    //   458: aload 19
    //   460: ldc_w 262
    //   463: invokevirtual 266	com/tencent/mm/model/v$b:containsKey	(Ljava/lang/String;)Z
    //   466: ifeq +33 -> 499
    //   469: aload_0
    //   470: new 268	com/tencent/mm/g/a/wh
    //   473: dup
    //   474: invokespecial 269	com/tencent/mm/g/a/wh:<init>	()V
    //   477: putfield 271	com/tencent/mm/plugin/sns/model/s:reR	Lcom/tencent/mm/g/a/wh;
    //   480: aload_0
    //   481: getfield 271	com/tencent/mm/plugin/sns/model/s:reR	Lcom/tencent/mm/g/a/wh;
    //   484: getfield 275	com/tencent/mm/g/a/wh:cNM	Lcom/tencent/mm/g/a/wh$a;
    //   487: aload 19
    //   489: ldc_w 262
    //   492: iconst_m1
    //   493: invokevirtual 234	com/tencent/mm/model/v$b:getInt	(Ljava/lang/String;I)I
    //   496: putfield 280	com/tencent/mm/g/a/wh$a:cNN	I
    //   499: ldc 70
    //   501: astore 19
    //   503: aload 19
    //   505: astore 16
    //   507: aload 5
    //   509: getfield 283	com/tencent/mm/protocal/protobuf/TimeLineObject:rHA	Ljava/lang/String;
    //   512: ifnull +53 -> 565
    //   515: new 285	com/tencent/mm/protocal/protobuf/cgh
    //   518: dup
    //   519: invokespecial 286	com/tencent/mm/protocal/protobuf/cgh:<init>	()V
    //   522: astore 21
    //   524: aload 5
    //   526: getfield 283	com/tencent/mm/protocal/protobuf/TimeLineObject:rHA	Ljava/lang/String;
    //   529: iconst_0
    //   530: invokestatic 292	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   533: astore 16
    //   535: aload 21
    //   537: aload 16
    //   539: invokevirtual 296	com/tencent/mm/protocal/protobuf/cgh:parseFrom	([B)Lcom/tencent/mm/bv/a;
    //   542: pop
    //   543: aload 19
    //   545: astore 16
    //   547: aload 21
    //   549: getfield 300	com/tencent/mm/protocal/protobuf/cgh:xRa	Lcom/tencent/mm/protocal/protobuf/cgf;
    //   552: ifnull +13 -> 565
    //   555: aload 21
    //   557: getfield 300	com/tencent/mm/protocal/protobuf/cgh:xRa	Lcom/tencent/mm/protocal/protobuf/cgf;
    //   560: getfield 305	com/tencent/mm/protocal/protobuf/cgf:nmH	Ljava/lang/String;
    //   563: astore 16
    //   565: aload 16
    //   567: astore 19
    //   569: aload 16
    //   571: invokestatic 310	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   574: ifeq +25 -> 599
    //   577: aload 16
    //   579: astore 19
    //   581: aload 5
    //   583: getfield 314	com/tencent/mm/protocal/protobuf/TimeLineObject:xTR	Lcom/tencent/mm/protocal/protobuf/du;
    //   586: ifnull +13 -> 599
    //   589: aload 5
    //   591: getfield 314	com/tencent/mm/protocal/protobuf/TimeLineObject:xTR	Lcom/tencent/mm/protocal/protobuf/du;
    //   594: getfield 319	com/tencent/mm/protocal/protobuf/du:Id	Ljava/lang/String;
    //   597: astore 19
    //   599: aload 20
    //   601: getstatic 325	java/util/Locale:US	Ljava/util/Locale;
    //   604: ldc_w 327
    //   607: bipush 6
    //   609: anewarray 329	java/lang/Object
    //   612: dup
    //   613: iconst_0
    //   614: aload_0
    //   615: getfield 197	com/tencent/mm/plugin/sns/model/s:reQ	Lcom/tencent/mm/g/a/wg;
    //   618: getfield 201	com/tencent/mm/g/a/wg:cNx	Lcom/tencent/mm/g/a/wg$a;
    //   621: getfield 214	com/tencent/mm/g/a/wg$a:cNy	Ljava/lang/String;
    //   624: aastore
    //   625: dup
    //   626: iconst_1
    //   627: aload_0
    //   628: getfield 197	com/tencent/mm/plugin/sns/model/s:reQ	Lcom/tencent/mm/g/a/wg;
    //   631: getfield 201	com/tencent/mm/g/a/wg:cNx	Lcom/tencent/mm/g/a/wg$a;
    //   634: getfield 223	com/tencent/mm/g/a/wg$a:cNA	Ljava/lang/String;
    //   637: aastore
    //   638: dup
    //   639: iconst_2
    //   640: aload_0
    //   641: getfield 197	com/tencent/mm/plugin/sns/model/s:reQ	Lcom/tencent/mm/g/a/wg;
    //   644: getfield 201	com/tencent/mm/g/a/wg:cNx	Lcom/tencent/mm/g/a/wg$a;
    //   647: getfield 228	com/tencent/mm/g/a/wg$a:cNB	Ljava/lang/String;
    //   650: aastore
    //   651: dup
    //   652: iconst_3
    //   653: aload_0
    //   654: getfield 197	com/tencent/mm/plugin/sns/model/s:reQ	Lcom/tencent/mm/g/a/wg;
    //   657: getfield 201	com/tencent/mm/g/a/wg:cNx	Lcom/tencent/mm/g/a/wg$a;
    //   660: getfield 223	com/tencent/mm/g/a/wg$a:cNA	Ljava/lang/String;
    //   663: aload_0
    //   664: getfield 197	com/tencent/mm/plugin/sns/model/s:reQ	Lcom/tencent/mm/g/a/wg;
    //   667: getfield 201	com/tencent/mm/g/a/wg:cNx	Lcom/tencent/mm/g/a/wg$a;
    //   670: getfield 228	com/tencent/mm/g/a/wg$a:cNB	Ljava/lang/String;
    //   673: invokestatic 335	com/tencent/mm/model/u:ah	(Ljava/lang/String;Ljava/lang/String;)I
    //   676: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   679: aastore
    //   680: dup
    //   681: iconst_4
    //   682: aload_0
    //   683: getfield 197	com/tencent/mm/plugin/sns/model/s:reQ	Lcom/tencent/mm/g/a/wg;
    //   686: getfield 201	com/tencent/mm/g/a/wg:cNx	Lcom/tencent/mm/g/a/wg$a;
    //   689: getfield 247	com/tencent/mm/g/a/wg$a:cNH	I
    //   692: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   695: aastore
    //   696: dup
    //   697: iconst_5
    //   698: aload 19
    //   700: aastore
    //   701: invokestatic 347	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   704: putfield 350	com/tencent/mm/protocal/protobuf/ceo:xOW	Ljava/lang/String;
    //   707: new 352	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t
    //   710: dup
    //   711: invokespecial 353	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:<init>	()V
    //   714: astore 16
    //   716: aload 16
    //   718: aload_1
    //   719: invokevirtual 357	java/lang/String:getBytes	()[B
    //   722: invokevirtual 361	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:setBuffer	([B)Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   725: pop
    //   726: aload_1
    //   727: invokevirtual 365	java/lang/String:length	()I
    //   730: istore 17
    //   732: aload 16
    //   734: invokevirtual 368	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:getILen	()I
    //   737: istore 18
    //   739: aload 15
    //   741: ifnonnull +213 -> 954
    //   744: iconst_0
    //   745: istore 6
    //   747: ldc_w 370
    //   750: ldc_w 372
    //   753: iconst_3
    //   754: anewarray 329	java/lang/Object
    //   757: dup
    //   758: iconst_0
    //   759: iload 17
    //   761: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   764: aastore
    //   765: dup
    //   766: iconst_1
    //   767: iload 18
    //   769: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   772: aastore
    //   773: dup
    //   774: iconst_2
    //   775: iload 6
    //   777: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   780: aastore
    //   781: invokestatic 377	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   784: aload 20
    //   786: aload 16
    //   788: putfield 381	com/tencent/mm/protocal/protobuf/ceo:ObjectDesc	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   791: aload 20
    //   793: iload_2
    //   794: putfield 384	com/tencent/mm/protocal/protobuf/ceo:xOR	I
    //   797: aload 20
    //   799: iload_3
    //   800: putfield 387	com/tencent/mm/protocal/protobuf/ceo:xsp	I
    //   803: aload 20
    //   805: aload 7
    //   807: putfield 390	com/tencent/mm/protocal/protobuf/ceo:pIw	Ljava/lang/String;
    //   810: aload_0
    //   811: iload_2
    //   812: putfield 61	com/tencent/mm/plugin/sns/model/s:reP	I
    //   815: getstatic 395	com/tencent/mm/platformtools/ae:gkm	Z
    //   818: ifeq +24 -> 842
    //   821: aload 20
    //   823: new 352	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t
    //   826: dup
    //   827: invokespecial 353	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:<init>	()V
    //   830: putfield 381	com/tencent/mm/protocal/protobuf/ceo:ObjectDesc	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   833: ldc_w 370
    //   836: ldc_w 397
    //   839: invokestatic 401	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   842: new 403	java/util/LinkedList
    //   845: dup
    //   846: invokespecial 404	java/util/LinkedList:<init>	()V
    //   849: astore 16
    //   851: aload 4
    //   853: ifnull +128 -> 981
    //   856: aload 4
    //   858: invokeinterface 409 1 0
    //   863: ifle +118 -> 981
    //   866: aload 4
    //   868: invokeinterface 413 1 0
    //   873: astore 4
    //   875: ldc 70
    //   877: astore_1
    //   878: aload 4
    //   880: invokeinterface 419 1 0
    //   885: ifeq +80 -> 965
    //   888: aload 4
    //   890: invokeinterface 423 1 0
    //   895: checkcast 343	java/lang/String
    //   898: astore 19
    //   900: new 425	com/tencent/mm/protocal/protobuf/bwc
    //   903: dup
    //   904: invokespecial 426	com/tencent/mm/protocal/protobuf/bwc:<init>	()V
    //   907: astore 21
    //   909: aload 21
    //   911: aload 19
    //   913: invokevirtual 430	com/tencent/mm/protocal/protobuf/bwc:aoF	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/bwc;
    //   916: pop
    //   917: aload 16
    //   919: aload 21
    //   921: invokevirtual 434	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   924: pop
    //   925: new 436	java/lang/StringBuilder
    //   928: dup
    //   929: invokespecial 437	java/lang/StringBuilder:<init>	()V
    //   932: aload_1
    //   933: invokevirtual 441	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   936: ldc_w 443
    //   939: invokevirtual 441	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   942: aload 19
    //   944: invokevirtual 441	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   947: invokevirtual 447	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   950: astore_1
    //   951: goto -73 -> 878
    //   954: aload 15
    //   956: getfield 453	com/tencent/mm/bv/b:pW	[B
    //   959: arraylength
    //   960: istore 6
    //   962: goto -215 -> 747
    //   965: ldc_w 370
    //   968: ldc_w 455
    //   971: aload_1
    //   972: invokestatic 458	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   975: invokevirtual 462	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   978: invokestatic 465	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   981: aload 20
    //   983: aload 16
    //   985: putfield 469	com/tencent/mm/protocal/protobuf/ceo:WithUserList	Ljava/util/LinkedList;
    //   988: aload 20
    //   990: aload 16
    //   992: invokevirtual 470	java/util/LinkedList:size	()I
    //   995: putfield 473	com/tencent/mm/protocal/protobuf/ceo:WithUserListCount	I
    //   998: aload 20
    //   1000: iload 8
    //   1002: putfield 476	com/tencent/mm/protocal/protobuf/ceo:xOS	I
    //   1005: aload 20
    //   1007: getfield 350	com/tencent/mm/protocal/protobuf/ceo:xOW	Ljava/lang/String;
    //   1010: astore_1
    //   1011: aload 11
    //   1013: getfield 480	com/tencent/mm/protocal/protobuf/bct:xsG	Lcom/tencent/mm/protocal/protobuf/cdo;
    //   1016: ifnull +233 -> 1249
    //   1019: aload 11
    //   1021: getfield 480	com/tencent/mm/protocal/protobuf/bct:xsG	Lcom/tencent/mm/protocal/protobuf/cdo;
    //   1024: getfield 485	com/tencent/mm/protocal/protobuf/cdo:xOj	I
    //   1027: istore_2
    //   1028: ldc_w 370
    //   1031: ldc_w 487
    //   1034: iconst_4
    //   1035: anewarray 329	java/lang/Object
    //   1038: dup
    //   1039: iconst_0
    //   1040: iload 10
    //   1042: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1045: aastore
    //   1046: dup
    //   1047: iconst_1
    //   1048: aload 7
    //   1050: aastore
    //   1051: dup
    //   1052: iconst_2
    //   1053: aload_1
    //   1054: aastore
    //   1055: dup
    //   1056: iconst_3
    //   1057: iload_2
    //   1058: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1061: aastore
    //   1062: invokestatic 377	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1065: aload 13
    //   1067: ifnull +33 -> 1100
    //   1070: aload 13
    //   1072: invokevirtual 470	java/util/LinkedList:size	()I
    //   1075: ifle +25 -> 1100
    //   1078: iload 12
    //   1080: ifeq +174 -> 1254
    //   1083: aload 20
    //   1085: aload 13
    //   1087: putfield 490	com/tencent/mm/protocal/protobuf/ceo:BlackList	Ljava/util/LinkedList;
    //   1090: aload 20
    //   1092: aload 13
    //   1094: invokevirtual 470	java/util/LinkedList:size	()I
    //   1097: putfield 493	com/tencent/mm/protocal/protobuf/ceo:BlackListCount	I
    //   1100: ldc_w 370
    //   1103: ldc_w 495
    //   1106: iload 10
    //   1108: invokestatic 498	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1111: invokevirtual 462	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1114: invokestatic 465	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1117: aload 20
    //   1119: iload 10
    //   1121: putfield 501	com/tencent/mm/protocal/protobuf/ceo:xOT	I
    //   1124: new 503	com/tencent/mm/protocal/protobuf/clw
    //   1127: dup
    //   1128: invokespecial 504	com/tencent/mm/protocal/protobuf/clw:<init>	()V
    //   1131: astore_1
    //   1132: aload 11
    //   1134: getfield 507	com/tencent/mm/protocal/protobuf/bct:token	Ljava/lang/String;
    //   1137: invokestatic 310	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   1140: ifne +27 -> 1167
    //   1143: aload_1
    //   1144: aload 11
    //   1146: getfield 507	com/tencent/mm/protocal/protobuf/bct:token	Ljava/lang/String;
    //   1149: putfield 510	com/tencent/mm/protocal/protobuf/clw:xVS	Ljava/lang/String;
    //   1152: aload_1
    //   1153: aload 11
    //   1155: getfield 513	com/tencent/mm/protocal/protobuf/bct:xsy	Ljava/lang/String;
    //   1158: putfield 516	com/tencent/mm/protocal/protobuf/clw:xVT	Ljava/lang/String;
    //   1161: aload 20
    //   1163: aload_1
    //   1164: putfield 520	com/tencent/mm/protocal/protobuf/ceo:xBi	Lcom/tencent/mm/protocal/protobuf/clw;
    //   1167: aload 9
    //   1169: ifnull +149 -> 1318
    //   1172: aload 9
    //   1174: invokevirtual 522	java/util/LinkedList:isEmpty	()Z
    //   1177: ifne +141 -> 1318
    //   1180: aload 20
    //   1182: aload 9
    //   1184: invokevirtual 470	java/util/LinkedList:size	()I
    //   1187: putfield 525	com/tencent/mm/protocal/protobuf/ceo:GroupCount	I
    //   1190: aload 9
    //   1192: invokevirtual 526	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   1195: astore_1
    //   1196: aload_1
    //   1197: invokeinterface 419 1 0
    //   1202: ifeq +72 -> 1274
    //   1205: aload_1
    //   1206: invokeinterface 423 1 0
    //   1211: checkcast 528	java/lang/Long
    //   1214: astore 4
    //   1216: new 530	com/tencent/mm/protocal/protobuf/cdz
    //   1219: dup
    //   1220: invokespecial 531	com/tencent/mm/protocal/protobuf/cdz:<init>	()V
    //   1223: astore 7
    //   1225: aload 7
    //   1227: aload 4
    //   1229: invokevirtual 535	java/lang/Long:longValue	()J
    //   1232: putfield 538	com/tencent/mm/protocal/protobuf/cdz:xOC	J
    //   1235: aload 20
    //   1237: getfield 541	com/tencent/mm/protocal/protobuf/ceo:xsv	Ljava/util/LinkedList;
    //   1240: aload 7
    //   1242: invokevirtual 434	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   1245: pop
    //   1246: goto -50 -> 1196
    //   1249: iconst_0
    //   1250: istore_2
    //   1251: goto -223 -> 1028
    //   1254: aload 20
    //   1256: aload 13
    //   1258: putfield 544	com/tencent/mm/protocal/protobuf/ceo:GroupUser	Ljava/util/LinkedList;
    //   1261: aload 20
    //   1263: aload 13
    //   1265: invokevirtual 470	java/util/LinkedList:size	()I
    //   1268: putfield 547	com/tencent/mm/protocal/protobuf/ceo:GroupUserCount	I
    //   1271: goto -171 -> 1100
    //   1274: ldc_w 370
    //   1277: new 436	java/lang/StringBuilder
    //   1280: dup
    //   1281: ldc_w 549
    //   1284: invokespecial 552	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1287: aload 9
    //   1289: invokevirtual 470	java/util/LinkedList:size	()I
    //   1292: invokevirtual 555	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1295: ldc_w 557
    //   1298: invokevirtual 441	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1301: aload 20
    //   1303: getfield 541	com/tencent/mm/protocal/protobuf/ceo:xsv	Ljava/util/LinkedList;
    //   1306: invokevirtual 558	java/util/LinkedList:toString	()Ljava/lang/String;
    //   1309: invokevirtual 441	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1312: invokevirtual 447	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1315: invokestatic 465	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1318: aload 20
    //   1320: aload 14
    //   1322: putfield 562	com/tencent/mm/protocal/protobuf/ceo:xsA	Lcom/tencent/mm/protocal/protobuf/cen;
    //   1325: aload 11
    //   1327: getfield 565	com/tencent/mm/protocal/protobuf/bct:xsC	Ljava/lang/String;
    //   1330: invokestatic 310	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   1333: ifne +15 -> 1348
    //   1336: aload 20
    //   1338: new 567	com/tencent/mm/protocal/protobuf/ces
    //   1341: dup
    //   1342: invokespecial 568	com/tencent/mm/protocal/protobuf/ces:<init>	()V
    //   1345: putfield 572	com/tencent/mm/protocal/protobuf/ceo:SnsRedEnvelops	Lcom/tencent/mm/protocal/protobuf/ces;
    //   1348: aload 14
    //   1350: ifnull +40 -> 1390
    //   1353: ldc_w 370
    //   1356: ldc_w 574
    //   1359: iconst_3
    //   1360: anewarray 329	java/lang/Object
    //   1363: dup
    //   1364: iconst_0
    //   1365: aload 14
    //   1367: getfield 579	com/tencent/mm/protocal/protobuf/cen:wpV	Ljava/lang/String;
    //   1370: aastore
    //   1371: dup
    //   1372: iconst_1
    //   1373: aload 14
    //   1375: getfield 582	com/tencent/mm/protocal/protobuf/cen:wpW	Ljava/lang/String;
    //   1378: aastore
    //   1379: dup
    //   1380: iconst_2
    //   1381: aload 14
    //   1383: getfield 585	com/tencent/mm/protocal/protobuf/cen:wpX	Ljava/lang/String;
    //   1386: aastore
    //   1387: invokestatic 587	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1390: aload 15
    //   1392: ifnull +20 -> 1412
    //   1395: aload 20
    //   1397: new 352	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t
    //   1400: dup
    //   1401: invokespecial 353	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:<init>	()V
    //   1404: aload 15
    //   1406: invokevirtual 590	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:setBuffer	(Lcom/tencent/mm/bv/b;)Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   1409: putfield 593	com/tencent/mm/protocal/protobuf/ceo:xOV	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   1412: aload 20
    //   1414: aload 11
    //   1416: getfield 480	com/tencent/mm/protocal/protobuf/bct:xsG	Lcom/tencent/mm/protocal/protobuf/cdo;
    //   1419: putfield 596	com/tencent/mm/protocal/protobuf/ceo:xPa	Lcom/tencent/mm/protocal/protobuf/cdo;
    //   1422: invokestatic 602	com/tencent/mm/plugin/sns/model/ag:cpf	()Lcom/tencent/mm/plugin/sns/storage/o;
    //   1425: aload_0
    //   1426: getfield 94	com/tencent/mm/plugin/sns/model/s:cIp	I
    //   1429: invokevirtual 608	com/tencent/mm/plugin/sns/storage/o:Ez	(I)Lcom/tencent/mm/plugin/sns/storage/n;
    //   1432: astore_1
    //   1433: aload_1
    //   1434: ifnull +452 -> 1886
    //   1437: aload_1
    //   1438: getfield 613	com/tencent/mm/plugin/sns/storage/n:field_type	I
    //   1441: iconst_1
    //   1442: if_icmpeq +12 -> 1454
    //   1445: aload_1
    //   1446: getfield 613	com/tencent/mm/plugin/sns/storage/n:field_type	I
    //   1449: bipush 15
    //   1451: if_icmpne +435 -> 1886
    //   1454: aload 5
    //   1456: getfield 617	com/tencent/mm/protocal/protobuf/TimeLineObject:xTS	Lcom/tencent/mm/protocal/protobuf/vi;
    //   1459: ifnull +427 -> 1886
    //   1462: aload 5
    //   1464: getfield 617	com/tencent/mm/protocal/protobuf/TimeLineObject:xTS	Lcom/tencent/mm/protocal/protobuf/vi;
    //   1467: getfield 622	com/tencent/mm/protocal/protobuf/vi:wOa	Ljava/util/LinkedList;
    //   1470: ifnull +416 -> 1886
    //   1473: aload 5
    //   1475: getfield 617	com/tencent/mm/protocal/protobuf/TimeLineObject:xTS	Lcom/tencent/mm/protocal/protobuf/vi;
    //   1478: getfield 622	com/tencent/mm/protocal/protobuf/vi:wOa	Ljava/util/LinkedList;
    //   1481: invokevirtual 470	java/util/LinkedList:size	()I
    //   1484: ifle +402 -> 1886
    //   1487: aload 11
    //   1489: getfield 625	com/tencent/mm/protocal/protobuf/bct:xsq	Ljava/util/LinkedList;
    //   1492: ifnull +394 -> 1886
    //   1495: aload 11
    //   1497: getfield 625	com/tencent/mm/protocal/protobuf/bct:xsq	Ljava/util/LinkedList;
    //   1500: invokevirtual 470	java/util/LinkedList:size	()I
    //   1503: aload 5
    //   1505: getfield 617	com/tencent/mm/protocal/protobuf/TimeLineObject:xTS	Lcom/tencent/mm/protocal/protobuf/vi;
    //   1508: getfield 622	com/tencent/mm/protocal/protobuf/vi:wOa	Ljava/util/LinkedList;
    //   1511: invokevirtual 470	java/util/LinkedList:size	()I
    //   1514: if_icmpne +372 -> 1886
    //   1517: invokestatic 628	com/tencent/mm/plugin/sns/model/ag:getAccSnsPath	()Ljava/lang/String;
    //   1520: astore_1
    //   1521: aload 5
    //   1523: getfield 617	com/tencent/mm/protocal/protobuf/TimeLineObject:xTS	Lcom/tencent/mm/protocal/protobuf/vi;
    //   1526: getfield 622	com/tencent/mm/protocal/protobuf/vi:wOa	Ljava/util/LinkedList;
    //   1529: invokevirtual 526	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   1532: astore 4
    //   1534: iconst_0
    //   1535: istore_2
    //   1536: aload 4
    //   1538: invokeinterface 419 1 0
    //   1543: ifeq +306 -> 1849
    //   1546: aload 4
    //   1548: invokeinterface 423 1 0
    //   1553: checkcast 630	com/tencent/mm/protocal/protobuf/bcs
    //   1556: astore 9
    //   1558: aload 9
    //   1560: getfield 633	com/tencent/mm/protocal/protobuf/bcs:jKs	I
    //   1563: iconst_2
    //   1564: if_icmpeq +13 -> 1577
    //   1567: aload 9
    //   1569: getfield 633	com/tencent/mm/protocal/protobuf/bcs:jKs	I
    //   1572: bipush 6
    //   1574: if_icmpne +263 -> 1837
    //   1577: new 635	com/tencent/mm/protocal/protobuf/bcq
    //   1580: dup
    //   1581: invokespecial 636	com/tencent/mm/protocal/protobuf/bcq:<init>	()V
    //   1584: astore 5
    //   1586: aload 9
    //   1588: getfield 633	com/tencent/mm/protocal/protobuf/bcs:jKs	I
    //   1591: iconst_2
    //   1592: if_icmpne +252 -> 1844
    //   1595: iconst_2
    //   1596: istore_3
    //   1597: aload 5
    //   1599: iload_3
    //   1600: putfield 639	com/tencent/mm/protocal/protobuf/bcq:niE	I
    //   1603: aload 9
    //   1605: getfield 633	com/tencent/mm/protocal/protobuf/bcs:jKs	I
    //   1608: bipush 6
    //   1610: if_icmpne +70 -> 1680
    //   1613: aload_1
    //   1614: aload 9
    //   1616: getfield 640	com/tencent/mm/protocal/protobuf/bcs:Id	Ljava/lang/String;
    //   1619: invokestatic 645	com/tencent/mm/plugin/sns/model/ao:gl	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1622: astore 7
    //   1624: aload 9
    //   1626: invokestatic 651	com/tencent/mm/plugin/sns/data/i:p	(Lcom/tencent/mm/protocal/protobuf/bcs;)Ljava/lang/String;
    //   1629: astore 9
    //   1631: new 436	java/lang/StringBuilder
    //   1634: dup
    //   1635: invokespecial 437	java/lang/StringBuilder:<init>	()V
    //   1638: aload 7
    //   1640: invokevirtual 441	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1643: aload 9
    //   1645: invokevirtual 441	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1648: invokevirtual 447	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1651: invokestatic 657	com/tencent/mm/plugin/sight/base/d:Zo	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sight/base/a;
    //   1654: astore 7
    //   1656: aload 7
    //   1658: ifnull +22 -> 1680
    //   1661: aload 5
    //   1663: aload 7
    //   1665: getfield 662	com/tencent/mm/plugin/sight/base/a:eVA	I
    //   1668: i2d
    //   1669: ldc2_w 663
    //   1672: ddiv
    //   1673: invokestatic 670	java/lang/Math:round	(D)J
    //   1676: l2i
    //   1677: putfield 673	com/tencent/mm/protocal/protobuf/bcq:xrO	I
    //   1680: aload 11
    //   1682: getfield 625	com/tencent/mm/protocal/protobuf/bct:xsq	Ljava/util/LinkedList;
    //   1685: iload_2
    //   1686: invokevirtual 677	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   1689: checkcast 679	com/tencent/mm/protocal/protobuf/bam
    //   1692: astore 7
    //   1694: invokestatic 683	com/tencent/mm/plugin/sns/model/ag:coU	()Lcom/tencent/mm/plugin/sns/storage/s;
    //   1697: aload 7
    //   1699: getfield 686	com/tencent/mm/protocal/protobuf/bam:xpE	I
    //   1702: i2l
    //   1703: invokevirtual 692	com/tencent/mm/plugin/sns/storage/s:ma	(J)Lcom/tencent/mm/plugin/sns/storage/r;
    //   1706: astore 7
    //   1708: new 694	com/tencent/mm/protocal/protobuf/bcv
    //   1711: dup
    //   1712: invokespecial 695	com/tencent/mm/protocal/protobuf/bcv:<init>	()V
    //   1715: aload 7
    //   1717: getfield 700	com/tencent/mm/plugin/sns/storage/r:rDG	[B
    //   1720: invokevirtual 701	com/tencent/mm/protocal/protobuf/bcv:parseFrom	([B)Lcom/tencent/mm/bv/a;
    //   1723: checkcast 694	com/tencent/mm/protocal/protobuf/bcv
    //   1726: astore 9
    //   1728: aload 5
    //   1730: aload 9
    //   1732: getfield 704	com/tencent/mm/protocal/protobuf/bcv:xsR	I
    //   1735: putfield 707	com/tencent/mm/protocal/protobuf/bcq:niK	I
    //   1738: aload_0
    //   1739: getfield 66	com/tencent/mm/plugin/sns/model/s:reT	Ljava/util/HashMap;
    //   1742: aload 7
    //   1744: getfield 710	com/tencent/mm/plugin/sns/storage/r:rCV	I
    //   1747: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1750: aload 9
    //   1752: getfield 704	com/tencent/mm/protocal/protobuf/bcv:xsR	I
    //   1755: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1758: invokevirtual 714	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1761: pop
    //   1762: aload 5
    //   1764: aload 11
    //   1766: getfield 188	com/tencent/mm/protocal/protobuf/bct:cpW	Ljava/lang/String;
    //   1769: putfield 717	com/tencent/mm/protocal/protobuf/bcq:wqN	Ljava/lang/String;
    //   1772: ldc_w 370
    //   1775: ldc_w 719
    //   1778: iconst_4
    //   1779: anewarray 329	java/lang/Object
    //   1782: dup
    //   1783: iconst_0
    //   1784: aload 5
    //   1786: getfield 707	com/tencent/mm/protocal/protobuf/bcq:niK	I
    //   1789: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1792: aastore
    //   1793: dup
    //   1794: iconst_1
    //   1795: aload 5
    //   1797: getfield 673	com/tencent/mm/protocal/protobuf/bcq:xrO	I
    //   1800: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1803: aastore
    //   1804: dup
    //   1805: iconst_2
    //   1806: aload 5
    //   1808: getfield 639	com/tencent/mm/protocal/protobuf/bcq:niE	I
    //   1811: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1814: aastore
    //   1815: dup
    //   1816: iconst_3
    //   1817: aload 5
    //   1819: getfield 717	com/tencent/mm/protocal/protobuf/bcq:wqN	Ljava/lang/String;
    //   1822: aastore
    //   1823: invokestatic 377	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1826: aload 20
    //   1828: getfield 722	com/tencent/mm/protocal/protobuf/ceo:xOZ	Ljava/util/LinkedList;
    //   1831: aload 5
    //   1833: invokevirtual 434	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   1836: pop
    //   1837: iload_2
    //   1838: iconst_1
    //   1839: iadd
    //   1840: istore_2
    //   1841: goto -305 -> 1536
    //   1844: iconst_1
    //   1845: istore_3
    //   1846: goto -249 -> 1597
    //   1849: aload 20
    //   1851: aload 20
    //   1853: getfield 722	com/tencent/mm/protocal/protobuf/ceo:xOZ	Ljava/util/LinkedList;
    //   1856: invokevirtual 470	java/util/LinkedList:size	()I
    //   1859: putfield 725	com/tencent/mm/protocal/protobuf/ceo:xOY	I
    //   1862: ldc_w 370
    //   1865: ldc_w 727
    //   1868: iconst_1
    //   1869: anewarray 329	java/lang/Object
    //   1872: dup
    //   1873: iconst_0
    //   1874: aload 20
    //   1876: getfield 725	com/tencent/mm/protocal/protobuf/ceo:xOY	I
    //   1879: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1882: aastore
    //   1883: invokestatic 377	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1886: getstatic 733	com/tencent/mm/plugin/normsg/a/b:pgQ	Lcom/tencent/mm/plugin/normsg/a/b;
    //   1889: ldc_w 735
    //   1892: invokevirtual 738	com/tencent/mm/plugin/normsg/a/b:VY	(Ljava/lang/String;)Z
    //   1895: ifeq +12 -> 1907
    //   1898: getstatic 733	com/tencent/mm/plugin/normsg/a/b:pgQ	Lcom/tencent/mm/plugin/normsg/a/b;
    //   1901: ldc_w 735
    //   1904: invokevirtual 741	com/tencent/mm/plugin/normsg/a/b:VX	(Ljava/lang/String;)V
    //   1907: new 743	com/tencent/mm/protocal/protobuf/cuv
    //   1910: dup
    //   1911: invokespecial 744	com/tencent/mm/protocal/protobuf/cuv:<init>	()V
    //   1914: astore_1
    //   1915: aload_1
    //   1916: new 352	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t
    //   1919: dup
    //   1920: invokespecial 353	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:<init>	()V
    //   1923: getstatic 733	com/tencent/mm/plugin/normsg/a/b:pgQ	Lcom/tencent/mm/plugin/normsg/a/b;
    //   1926: ldc_w 735
    //   1929: invokevirtual 748	com/tencent/mm/plugin/normsg/a/b:VZ	(Ljava/lang/String;)[B
    //   1932: invokevirtual 361	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:setBuffer	([B)Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   1935: putfield 751	com/tencent/mm/protocal/protobuf/cuv:ydw	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   1938: aload_1
    //   1939: getfield 751	com/tencent/mm/protocal/protobuf/cuv:ydw	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   1942: ifnull +169 -> 2111
    //   1945: aload_1
    //   1946: getfield 751	com/tencent/mm/protocal/protobuf/cuv:ydw	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   1949: invokevirtual 368	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:getILen	()I
    //   1952: istore_2
    //   1953: ldc_w 370
    //   1956: ldc_w 753
    //   1959: iconst_1
    //   1960: anewarray 329	java/lang/Object
    //   1963: dup
    //   1964: iconst_0
    //   1965: iload_2
    //   1966: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1969: aastore
    //   1970: invokestatic 587	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1973: aload_1
    //   1974: new 352	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t
    //   1977: dup
    //   1978: invokespecial 353	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:<init>	()V
    //   1981: getstatic 733	com/tencent/mm/plugin/normsg/a/b:pgQ	Lcom/tencent/mm/plugin/normsg/a/b;
    //   1984: ldc_w 755
    //   1987: invokevirtual 758	com/tencent/mm/plugin/normsg/a/b:Wc	(Ljava/lang/String;)[B
    //   1990: invokevirtual 361	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:setBuffer	([B)Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   1993: putfield 761	com/tencent/mm/protocal/protobuf/cuv:ydx	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   1996: aload_1
    //   1997: getfield 761	com/tencent/mm/protocal/protobuf/cuv:ydx	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   2000: ifnull +116 -> 2116
    //   2003: aload_1
    //   2004: getfield 761	com/tencent/mm/protocal/protobuf/cuv:ydx	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   2007: invokevirtual 368	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:getILen	()I
    //   2010: istore_2
    //   2011: ldc_w 370
    //   2014: ldc_w 763
    //   2017: iconst_1
    //   2018: anewarray 329	java/lang/Object
    //   2021: dup
    //   2022: iconst_0
    //   2023: iload_2
    //   2024: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2027: aastore
    //   2028: invokestatic 587	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2031: aload_1
    //   2032: new 352	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t
    //   2035: dup
    //   2036: invokespecial 353	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:<init>	()V
    //   2039: getstatic 733	com/tencent/mm/plugin/normsg/a/b:pgQ	Lcom/tencent/mm/plugin/normsg/a/b;
    //   2042: invokevirtual 766	com/tencent/mm/plugin/normsg/a/b:bXq	()[B
    //   2045: invokevirtual 361	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:setBuffer	([B)Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   2048: putfield 769	com/tencent/mm/protocal/protobuf/cuv:ydy	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   2051: aload_1
    //   2052: getfield 769	com/tencent/mm/protocal/protobuf/cuv:ydy	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   2055: ifnull +66 -> 2121
    //   2058: aload_1
    //   2059: getfield 769	com/tencent/mm/protocal/protobuf/cuv:ydy	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   2062: invokevirtual 368	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:getILen	()I
    //   2065: istore_2
    //   2066: ldc_w 370
    //   2069: ldc_w 771
    //   2072: iconst_1
    //   2073: anewarray 329	java/lang/Object
    //   2076: dup
    //   2077: iconst_0
    //   2078: iload_2
    //   2079: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2082: aastore
    //   2083: invokestatic 587	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2086: aload 20
    //   2088: new 352	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t
    //   2091: dup
    //   2092: invokespecial 353	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:<init>	()V
    //   2095: aload_1
    //   2096: invokevirtual 774	com/tencent/mm/protocal/protobuf/cuv:toByteArray	()[B
    //   2099: invokevirtual 361	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:setBuffer	([B)Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   2102: putfield 777	com/tencent/mm/protocal/protobuf/ceo:wss	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   2105: ldc 49
    //   2107: invokestatic 780	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2110: return
    //   2111: iconst_m1
    //   2112: istore_2
    //   2113: goto -160 -> 1953
    //   2116: iconst_m1
    //   2117: istore_2
    //   2118: goto -107 -> 2011
    //   2121: iconst_m1
    //   2122: istore_2
    //   2123: goto -57 -> 2066
    //   2126: astore_1
    //   2127: ldc 49
    //   2129: invokestatic 780	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2132: return
    //   2133: astore 7
    //   2135: goto -373 -> 1762
    //   2138: astore 16
    //   2140: aload 19
    //   2142: astore 16
    //   2144: goto -1579 -> 565
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2147	0	this	s
    //   0	2147	1	paramString1	String
    //   0	2147	2	paramInt1	int
    //   0	2147	3	paramInt2	int
    //   0	2147	4	paramList	java.util.List<String>
    //   0	2147	5	paramTimeLineObject	TimeLineObject
    //   0	2147	6	paramInt3	int
    //   0	2147	7	paramString2	String
    //   0	2147	8	paramInt4	int
    //   0	2147	9	paramLinkedList	LinkedList<Long>
    //   0	2147	10	paramInt5	int
    //   0	2147	11	parambct	bct
    //   0	2147	12	paramBoolean	boolean
    //   0	2147	13	paramLinkedList1	LinkedList<com.tencent.mm.protocal.protobuf.bwc>
    //   0	2147	14	paramcen	com.tencent.mm.protocal.protobuf.cen
    //   0	2147	15	paramb	com.tencent.mm.bv.b
    //   0	2147	16	paramString3	String
    //   730	30	17	i	int
    //   737	31	18	j	int
    //   123	2018	19	localObject1	Object
    //   200	1887	20	localceo	com.tencent.mm.protocal.protobuf.ceo
    //   522	398	21	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   1907	1953	2126	java/lang/Throwable
    //   1953	2011	2126	java/lang/Throwable
    //   2011	2066	2126	java/lang/Throwable
    //   2066	2105	2126	java/lang/Throwable
    //   1708	1762	2133	java/lang/Exception
    //   535	543	2138	java/lang/Exception
    //   547	565	2138	java/lang/Exception
  }
  
  private static boolean a(TimeLineObject paramTimeLineObject1, TimeLineObject paramTimeLineObject2)
  {
    AppMethodBeat.i(36293);
    if ((paramTimeLineObject1 == null) || (paramTimeLineObject2 == null) || (paramTimeLineObject1.xTS == null) || (paramTimeLineObject2.xTS == null))
    {
      AppMethodBeat.o(36293);
      return false;
    }
    String str1 = ag.getAccSnsPath();
    int i = 0;
    while ((i < paramTimeLineObject1.xTS.wOa.size()) && (i < paramTimeLineObject2.xTS.wOa.size()))
    {
      Object localObject2 = (bcs)paramTimeLineObject1.xTS.wOa.get(i);
      Object localObject1 = (bcs)paramTimeLineObject2.xTS.wOa.get(i);
      String str2 = com.tencent.mm.plugin.sns.data.i.m((bcs)localObject2);
      String str3 = com.tencent.mm.plugin.sns.data.i.n((bcs)localObject2);
      String str4 = com.tencent.mm.plugin.sns.data.i.o((bcs)localObject2);
      String str5 = com.tencent.mm.plugin.sns.data.i.p((bcs)localObject2);
      String str6 = com.tencent.mm.plugin.sns.data.i.l((bcs)localObject1);
      String str7 = com.tencent.mm.plugin.sns.data.i.e((bcs)localObject1);
      String str8 = com.tencent.mm.plugin.sns.data.i.f((bcs)localObject1);
      String str9 = com.tencent.mm.plugin.sns.data.i.j((bcs)localObject1);
      ab.d("MicroMsg.NetSceneSnsPost", "updateMediaFileName " + str2 + "  - " + str6);
      localObject2 = ao.gl(str1, ((bcs)localObject2).Id);
      localObject1 = ao.gl(str1, ((bcs)localObject1).Id);
      com.tencent.mm.vfs.e.um((String)localObject1);
      com.tencent.mm.vfs.e.aT((String)localObject2 + str2, (String)localObject1 + str6);
      com.tencent.mm.vfs.e.aT((String)localObject2 + str3, (String)localObject1 + str7);
      com.tencent.mm.vfs.e.aT((String)localObject2 + str4, (String)localObject1 + str8);
      if (com.tencent.mm.vfs.e.cN((String)localObject2 + str5))
      {
        ab.i("MicroMsg.NetSceneSnsPost", "post done copy file %s", new Object[] { (String)localObject1 + str9 });
        com.tencent.mm.vfs.e.aT((String)localObject2 + str5, (String)localObject1 + str9);
      }
      i += 1;
    }
    AppMethodBeat.o(36293);
    return true;
  }
  
  private void aap(String paramString)
  {
    AppMethodBeat.i(36292);
    this.reX = paramString;
    paramString = com.tencent.mm.model.c.c.abU().me("100132");
    if (paramString.isValid()) {
      this.eDB = bo.getInt((String)paramString.dvN().get("needUploadData"), 1);
    }
    if ((this.reS != 12) && (this.eDB == 0))
    {
      AppMethodBeat.o(36292);
      return;
    }
    if ((this.reN != null) && (this.reN.xTS != null) && (this.reN.xTS.wOa != null) && (this.reN.xTS.wOa.size() > 0))
    {
      paramString = this.reN.xTS.wOa;
      a.ymk.c(this.eDE);
      a.ymk.c(this.eDF);
      paramString = paramString.iterator();
      int i = 0;
      while (paramString.hasNext())
      {
        Object localObject = (bcs)paramString.next();
        if (((bcs)localObject).jKs == 2)
        {
          String str = g.C((bcs)localObject);
          if (!bo.isNullOrNil(str))
          {
            this.reW.put(str, Integer.valueOf(i));
            this.reV.put(str, localObject);
            localObject = new nw();
            ((nw)localObject).cEv.filePath = str;
            a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
            i += 1;
          }
        }
      }
    }
    AppMethodBeat.o(36292);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(36290);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(36290);
    return i;
  }
  
  public final int getType()
  {
    return 209;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(36291);
    ab.i("MicroMsg.NetSceneSnsPost", "post netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    Object localObject1 = (cep)((com.tencent.mm.ai.b)paramq).fsW.fta;
    if (paramInt2 == 4) {
      paramq = ag.cpf().Ez(this.cIp);
    }
    try
    {
      paramArrayOfByte = (bct)new bct().parseFrom(paramq.field_postBuf);
      paramArrayOfByte.xsx = paramInt3;
      paramArrayOfByte.xsE = ((cep)localObject1).xsE;
      paramArrayOfByte.xsF = false;
      paramq.field_postBuf = paramArrayOfByte.toByteArray();
      label145:
      if (paramq != null)
      {
        paramq.csL();
        ag.cpf().b(this.cIp, paramq);
        ag.cpe().DI(this.cIp);
        ab.d("MicroMsg.NetSceneSnsPost", "onErrorServer, publish SnsPostFailEvent, snsInfoLocalId: " + paramq.csH());
        paramq = new rz();
        paramq.cIl.cIm = this.cIp;
        a.ymk.l(paramq);
      }
      if ((this.reM != null) && (this.reM.xTS != null) && (this.reM.xTS.wNZ == 21))
      {
        com.tencent.mm.plugin.sns.lucky.a.b.kS(8);
        switch (paramInt3)
        {
        default: 
          com.tencent.mm.plugin.sns.lucky.a.b.kS(20);
        }
      }
      for (;;)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(36291);
        return;
        com.tencent.mm.plugin.sns.lucky.a.b.kS(17);
        continue;
        com.tencent.mm.plugin.sns.lucky.a.b.kS(19);
        continue;
        com.tencent.mm.plugin.sns.lucky.a.b.kS(18);
      }
      if (paramInt3 != 0)
      {
        ag.cpe().DI(this.cIp);
        if ((this.reM != null) && (this.reM.xTS != null) && (this.reM.xTS.wNZ == 21))
        {
          com.tencent.mm.plugin.sns.lucky.a.b.kS(8);
          com.tencent.mm.plugin.sns.lucky.a.b.kS(16);
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(36291);
        return;
      }
      if ((((cep)localObject1).xNM == null) || (((cep)localObject1).xNM.ObjectDesc == null) || (((cep)localObject1).xNM.ObjectDesc.getBuffer() == null))
      {
        ab.e("MicroMsg.NetSceneSnsPost", "err respone buffer is null ignore");
        ag.cpe().DI(this.cIp);
        paramq = ag.cpf().Ez(this.cIp);
        if (paramq != null)
        {
          paramq.csK();
          ag.cpf().b(this.cIp, paramq);
          paramq = new sb();
          paramq.cIr.cIm = this.cIp;
          a.ymk.l(paramq);
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(36291);
        return;
      }
      Object localObject2 = new String(((cep)localObject1).xNM.ObjectDesc.getBuffer().toByteArray());
      if (this.reP == 0) {
        ab.d("MicroMsg.NetSceneSnsPost", "resp " + (String)localObject2 + "  ");
      }
      this.reN = com.tencent.mm.modelsns.e.uA((String)localObject2);
      Object localObject3;
      if (this.reN.xTX != null)
      {
        paramq = this.reN.Id;
        paramArrayOfByte = this.reN.xTX.fiV;
        localObject3 = this.reN.xTX.fiU;
        com.tencent.mm.modelsns.d locald = new com.tencent.mm.modelsns.d();
        locald.k("20CurrPublishId", paramq + ",");
        locald.k("20SourcePublishId", paramArrayOfByte + ",");
        locald.k("20SourceAdUxInfo", (String)localObject3 + ",");
        ab.i("MicroMsg.SnsVideoStatistic", "report snsad_shareReport: " + locald.Fg());
        com.tencent.mm.plugin.report.service.h.qsU.e(13004, new Object[] { locald });
      }
      paramArrayOfByte = ag.cpf().Ez(this.cIp);
      paramq = paramArrayOfByte;
      if (paramArrayOfByte == null)
      {
        ab.e("MicroMsg.NetSceneSnsPost", "the item has delete");
        paramq = new com.tencent.mm.plugin.sns.storage.n();
      }
      paramq.lp(((cep)localObject1).xNM.CreateTime);
      paramq.abt((String)localObject2);
      paramq.field_localFlag &= 0xFFFFFFEF;
      paramq.lV(((cep)localObject1).xNM.Id);
      paramq.lX(((cep)localObject1).xNM.Id);
      if ((((cep)localObject1).xNM.ExtFlag & 0x1) > 0) {
        paramq.csE();
      }
      this.reO = ((cep)localObject1).xNM.Id;
      if (this.reQ != null)
      {
        this.reQ.cNx.cNz = ("sns_" + com.tencent.mm.plugin.sns.data.i.lq(this.reO));
        a.ymk.l(this.reQ);
      }
      if ((this.reR != null) && (this.reR.cNM.cNN != -1)) {
        a.ymk.l(this.reR);
      }
      localObject1 = ((cep)localObject1).xNM;
      ((SnsObject)localObject1).ObjectDesc.setBuffer(new byte[0]);
      try
      {
        if ((((SnsObject)localObject1).CommentUserListCount == 0) && (((SnsObject)localObject1).LikeUserListCount == 0) && (((SnsObject)localObject1).WithUserListCount == 0) && (((SnsObject)localObject1).GroupCount == 0)) {
          ab.d("MicroMsg.NetSceneSnsPost", "no use! this buf");
        }
        for (;;)
        {
          paramq.csK();
          ag.cpf().b(this.cIp, paramq);
          ag.cpe().DI(this.cIp);
          if (((this.reM.xTS.wNZ == 1) && (this.reM.dqG == 0) && (this.reN.dqG == 1)) || ((this.reM.xTS.wNZ == 15) && (this.reM.xTZ == 0) && (this.reN.xTZ == 1) && (com.tencent.mm.plugin.sns.storage.i.lS(v.abO(paramq.getSnsId()))))) {
            new ak(Looper.getMainLooper()).post(new s.1(this));
          }
          paramArrayOfByte = com.tencent.mm.plugin.sns.i.g.roZ.ch(Integer.valueOf(this.cIp));
          if ((paramArrayOfByte != null) && (this.reN != null))
          {
            paramArrayOfByte.akb();
            paramArrayOfByte.akc();
            paramArrayOfByte.ux(this.reN.Id);
            paramArrayOfByte.lY(this.reN.xTS.wNZ);
            paramArrayOfByte.ake();
          }
          paramArrayOfByte = com.tencent.mm.plugin.sns.i.h.roZ.ch(Integer.valueOf(this.cIp));
          if ((paramArrayOfByte != null) && (this.reN != null))
          {
            paramArrayOfByte.akb();
            paramArrayOfByte.akc();
            paramArrayOfByte.ux(this.reN.Id);
            paramArrayOfByte.lY(this.reN.xTS.wNZ);
            paramArrayOfByte.ake();
          }
          paramArrayOfByte = new sb();
          paramArrayOfByte.cIr.cIm = this.cIp;
          a.ymk.l(paramArrayOfByte);
          if (paramq.field_type == 21)
          {
            com.tencent.mm.plugin.sns.lucky.a.b.kS(7);
            System.currentTimeMillis();
          }
          a(this.reM, this.reN);
          if (this.reN != null) {
            break;
          }
          paramArrayOfByte = "";
          aap(paramArrayOfByte);
          if (ag.cpb() != null) {
            ag.cpb().cnP();
          }
          try
          {
            if (paramq.field_type == 15)
            {
              localObject2 = (bcs)this.reN.xTS.wOa.get(0);
              if (localObject2 != null)
              {
                paramq = ao.gl(ag.getAccSnsPath(), ((bcs)localObject2).Id) + com.tencent.mm.plugin.sns.data.i.j((bcs)localObject2);
                paramArrayOfByte = com.tencent.mm.modelvideo.n.alC();
                localObject3 = ((bcs)localObject2).Url;
                l = ((SnsObject)localObject1).Id;
                if (!bo.isNullOrNil((String)localObject3))
                {
                  boolean bool = bo.isNullOrNil(paramq);
                  if (!bool) {
                    break label1707;
                  }
                }
              }
            }
          }
          catch (Exception paramq)
          {
            long l;
            label1583:
            break label1583;
          }
          l = ((SnsObject)localObject1).Id;
          paramq = new sa();
          paramq.cIn.cIo = l;
          paramq.cIn.cIp = this.cIp;
          paramq.cIn.cIq = this.reT;
          a.ymk.l(paramq);
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          AppMethodBeat.o(36291);
          return;
          paramq.bj(((SnsObject)localObject1).toByteArray());
        }
      }
      catch (IOException paramArrayOfByte)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.NetSceneSnsPost", paramArrayOfByte, "", new Object[0]);
          continue;
          paramArrayOfByte = this.reN.xTP;
          continue;
          label1707:
          localObject2 = ((String)localObject3).hashCode();
          ab.d("MicroMsg.SubCoreMediaRpt", "rpt sns video upload info snsKey[%s] url[%s] snsId[%d] path[%s]", new Object[] { localObject2, localObject3, Long.valueOf(l), paramq });
          localObject3 = (n.a)paramArrayOfByte.fWG.get(localObject2);
          if (localObject3 != null)
          {
            ((n.a)localObject3).fWV = String.valueOf(l);
            ((n.a)localObject3).fWU = paramq;
            paramArrayOfByte.a(((n.a)localObject3).fWk, (String)localObject2);
          }
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      break label145;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.s
 * JD-Core Version:    0.7.0.1
 */