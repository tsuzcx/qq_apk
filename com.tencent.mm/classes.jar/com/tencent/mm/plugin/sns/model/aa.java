package com.tencent.mm.plugin.sns.model;

import android.graphics.BitmapFactory.Options;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.autogen.mmdata.rpt.ns;
import com.tencent.mm.g.a;
import com.tencent.mm.g.d;
import com.tencent.mm.g.g.a;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.sns.lucky.a.b;
import com.tencent.mm.plugin.sns.statistics.f;
import com.tencent.mm.plugin.sns.storage.z;
import com.tencent.mm.protocal.protobuf.dmu;
import com.tencent.mm.protocal.protobuf.dnc;
import com.tencent.mm.protocal.protobuf.fds;
import com.tencent.mm.protocal.protobuf.ffp;
import com.tencent.mm.protocal.protobuf.ffq;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.LinkedList;

public final class aa
  extends p
  implements m
{
  private static int Qtt = 0;
  private String Qtl;
  private ffp Qtm;
  private String Qtn;
  private boolean Qto;
  private boolean Qtp;
  private boolean Qtq;
  private boolean Qtr;
  private int Qts;
  public com.tencent.mm.am.h callback;
  int icg;
  private int mgx;
  public String oHX;
  private int oIq;
  private int offset;
  private long osG;
  private g.a osH;
  private int osy;
  private String path;
  private com.tencent.mm.am.c rr;
  private long startTime;
  
  /* Error */
  public aa(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 50	com/tencent/mm/am/p:<init>	()V
    //   4: ldc 51
    //   6: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: sipush 8192
    //   13: putfield 59	com/tencent/mm/plugin/sns/model/aa:oIq	I
    //   16: aload_0
    //   17: iconst_0
    //   18: putfield 61	com/tencent/mm/plugin/sns/model/aa:offset	I
    //   21: aload_0
    //   22: ldc 63
    //   24: putfield 65	com/tencent/mm/plugin/sns/model/aa:path	Ljava/lang/String;
    //   27: aload_0
    //   28: ldc 63
    //   30: putfield 67	com/tencent/mm/plugin/sns/model/aa:Qtl	Ljava/lang/String;
    //   33: aload_0
    //   34: iconst_0
    //   35: putfield 69	com/tencent/mm/plugin/sns/model/aa:icg	I
    //   38: aload_0
    //   39: ldc 63
    //   41: putfield 71	com/tencent/mm/plugin/sns/model/aa:Qtn	Ljava/lang/String;
    //   44: aload_0
    //   45: ldc 63
    //   47: putfield 73	com/tencent/mm/plugin/sns/model/aa:oHX	Ljava/lang/String;
    //   50: aload_0
    //   51: iconst_0
    //   52: putfield 75	com/tencent/mm/plugin/sns/model/aa:Qto	Z
    //   55: aload_0
    //   56: iconst_0
    //   57: putfield 77	com/tencent/mm/plugin/sns/model/aa:Qtp	Z
    //   60: aload_0
    //   61: iconst_0
    //   62: putfield 79	com/tencent/mm/plugin/sns/model/aa:Qtq	Z
    //   65: aload_0
    //   66: iconst_0
    //   67: putfield 81	com/tencent/mm/plugin/sns/model/aa:Qtr	Z
    //   70: aload_0
    //   71: lconst_0
    //   72: putfield 83	com/tencent/mm/plugin/sns/model/aa:osG	J
    //   75: aload_0
    //   76: lconst_0
    //   77: putfield 85	com/tencent/mm/plugin/sns/model/aa:startTime	J
    //   80: aload_0
    //   81: iconst_0
    //   82: putfield 87	com/tencent/mm/plugin/sns/model/aa:mgx	I
    //   85: aload_0
    //   86: iconst_0
    //   87: putfield 89	com/tencent/mm/plugin/sns/model/aa:Qts	I
    //   90: aload_0
    //   91: new 8	com/tencent/mm/plugin/sns/model/aa$1
    //   94: dup
    //   95: aload_0
    //   96: invokespecial 92	com/tencent/mm/plugin/sns/model/aa$1:<init>	(Lcom/tencent/mm/plugin/sns/model/aa;)V
    //   99: putfield 94	com/tencent/mm/plugin/sns/model/aa:osH	Lcom/tencent/mm/g/g$a;
    //   102: aload_0
    //   103: invokestatic 100	java/lang/System:currentTimeMillis	()J
    //   106: putfield 83	com/tencent/mm/plugin/sns/model/aa:osG	J
    //   109: aload_0
    //   110: iload_1
    //   111: putfield 69	com/tencent/mm/plugin/sns/model/aa:icg	I
    //   114: aload_0
    //   115: aload_2
    //   116: putfield 71	com/tencent/mm/plugin/sns/model/aa:Qtn	Ljava/lang/String;
    //   119: aload_0
    //   120: iload 4
    //   122: putfield 89	com/tencent/mm/plugin/sns/model/aa:Qts	I
    //   125: new 102	com/tencent/mm/am/c$a
    //   128: dup
    //   129: invokespecial 103	com/tencent/mm/am/c$a:<init>	()V
    //   132: astore_2
    //   133: aload_2
    //   134: new 105	com/tencent/mm/protocal/protobuf/ffp
    //   137: dup
    //   138: invokespecial 106	com/tencent/mm/protocal/protobuf/ffp:<init>	()V
    //   141: putfield 110	com/tencent/mm/am/c$a:otE	Lcom/tencent/mm/bx/a;
    //   144: aload_2
    //   145: new 112	com/tencent/mm/protocal/protobuf/ffq
    //   148: dup
    //   149: invokespecial 113	com/tencent/mm/protocal/protobuf/ffq:<init>	()V
    //   152: putfield 116	com/tencent/mm/am/c$a:otF	Lcom/tencent/mm/bx/a;
    //   155: aload_2
    //   156: ldc 118
    //   158: putfield 121	com/tencent/mm/am/c$a:uri	Ljava/lang/String;
    //   161: aload_2
    //   162: sipush 207
    //   165: putfield 124	com/tencent/mm/am/c$a:funcId	I
    //   168: aload_2
    //   169: bipush 95
    //   171: putfield 127	com/tencent/mm/am/c$a:otG	I
    //   174: aload_2
    //   175: ldc 128
    //   177: putfield 131	com/tencent/mm/am/c$a:respCmdId	I
    //   180: aload_0
    //   181: aload_2
    //   182: invokevirtual 135	com/tencent/mm/am/c$a:bEF	()Lcom/tencent/mm/am/c;
    //   185: putfield 137	com/tencent/mm/plugin/sns/model/aa:rr	Lcom/tencent/mm/am/c;
    //   188: aload_0
    //   189: aload_0
    //   190: getfield 137	com/tencent/mm/plugin/sns/model/aa:rr	Lcom/tencent/mm/am/c;
    //   193: getfield 143	com/tencent/mm/am/c:otB	Lcom/tencent/mm/am/c$b;
    //   196: invokestatic 149	com/tencent/mm/am/c$b:b	(Lcom/tencent/mm/am/c$b;)Lcom/tencent/mm/bx/a;
    //   199: checkcast 105	com/tencent/mm/protocal/protobuf/ffp
    //   202: putfield 151	com/tencent/mm/plugin/sns/model/aa:Qtm	Lcom/tencent/mm/protocal/protobuf/ffp;
    //   205: invokestatic 157	com/tencent/mm/plugin/sns/model/al:hgq	()Lcom/tencent/mm/plugin/sns/storage/aa;
    //   208: iload_1
    //   209: i2l
    //   210: invokevirtual 163	com/tencent/mm/plugin/sns/storage/aa:vk	(J)Lcom/tencent/mm/plugin/sns/storage/z;
    //   213: astore 7
    //   215: aload_0
    //   216: iload_3
    //   217: putfield 81	com/tencent/mm/plugin/sns/model/aa:Qtr	Z
    //   220: ldc 165
    //   222: new 167	java/lang/StringBuilder
    //   225: dup
    //   226: ldc 169
    //   228: invokespecial 172	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   231: iload_1
    //   232: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   235: ldc 178
    //   237: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload 7
    //   242: getfield 184	com/tencent/mm/plugin/sns/storage/z:offset	I
    //   245: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   248: ldc 186
    //   250: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: aload 7
    //   255: getfield 189	com/tencent/mm/plugin/sns/storage/z:Oxm	Ljava/lang/String;
    //   258: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: ldc 191
    //   263: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload 7
    //   268: getfield 194	com/tencent/mm/plugin/sns/storage/z:QZs	I
    //   271: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   274: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokestatic 203	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   280: iload_3
    //   281: ifne +18 -> 299
    //   284: aload_0
    //   285: getfield 151	com/tencent/mm/plugin/sns/model/aa:Qtm	Lcom/tencent/mm/protocal/protobuf/ffp;
    //   288: iconst_1
    //   289: putfield 206	com/tencent/mm/protocal/protobuf/ffp:ExtFlag	I
    //   292: ldc 165
    //   294: ldc 208
    //   296: invokestatic 203	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   299: new 210	com/tencent/mm/protocal/protobuf/dnc
    //   302: dup
    //   303: invokespecial 211	com/tencent/mm/protocal/protobuf/dnc:<init>	()V
    //   306: aload 7
    //   308: getfield 215	com/tencent/mm/plugin/sns/storage/z:QZv	[B
    //   311: invokevirtual 219	com/tencent/mm/protocal/protobuf/dnc:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   314: checkcast 210	com/tencent/mm/protocal/protobuf/dnc
    //   317: astore 6
    //   319: aload_0
    //   320: aload 7
    //   322: getfield 189	com/tencent/mm/plugin/sns/storage/z:Oxm	Ljava/lang/String;
    //   325: invokestatic 225	com/tencent/mm/plugin/sns/data/t:aXq	(Ljava/lang/String;)Ljava/lang/String;
    //   328: putfield 67	com/tencent/mm/plugin/sns/model/aa:Qtl	Ljava/lang/String;
    //   331: aload_0
    //   332: new 167	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   339: invokestatic 229	com/tencent/mm/plugin/sns/model/al:getAccSnsPath	()Ljava/lang/String;
    //   342: aload 7
    //   344: getfield 189	com/tencent/mm/plugin/sns/storage/z:Oxm	Ljava/lang/String;
    //   347: invokestatic 235	com/tencent/mm/plugin/sns/model/as:mg	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   350: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: aload_0
    //   354: getfield 67	com/tencent/mm/plugin/sns/model/aa:Qtl	Ljava/lang/String;
    //   357: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: putfield 65	com/tencent/mm/plugin/sns/model/aa:path	Ljava/lang/String;
    //   366: aload_0
    //   367: aload_0
    //   368: getfield 65	com/tencent/mm/plugin/sns/model/aa:path	Ljava/lang/String;
    //   371: invokestatic 241	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
    //   374: l2i
    //   375: putfield 243	com/tencent/mm/plugin/sns/model/aa:osy	I
    //   378: aload_0
    //   379: aload_0
    //   380: getfield 65	com/tencent/mm/plugin/sns/model/aa:path	Ljava/lang/String;
    //   383: invokestatic 247	com/tencent/mm/plugin/sns/data/t:aXB	(Ljava/lang/String;)Z
    //   386: putfield 75	com/tencent/mm/plugin/sns/model/aa:Qto	Z
    //   389: ldc 165
    //   391: new 167	java/lang/StringBuilder
    //   394: dup
    //   395: ldc 249
    //   397: invokespecial 172	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   400: aload_0
    //   401: getfield 243	com/tencent/mm/plugin/sns/model/aa:osy	I
    //   404: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   407: ldc 251
    //   409: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: aload_0
    //   413: getfield 75	com/tencent/mm/plugin/sns/model/aa:Qto	Z
    //   416: invokevirtual 254	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   419: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokestatic 203	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   425: aload 6
    //   427: getfield 257	com/tencent/mm/protocal/protobuf/dnc:aaUh	Ljava/lang/String;
    //   430: astore 5
    //   432: aload 5
    //   434: astore_2
    //   435: aload 5
    //   437: invokestatic 262	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   440: ifeq +56 -> 496
    //   443: new 167	java/lang/StringBuilder
    //   446: dup
    //   447: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   450: invokestatic 265	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   453: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   456: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: invokevirtual 274	java/lang/String:getBytes	()[B
    //   462: invokestatic 280	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   465: astore_2
    //   466: aload 6
    //   468: aload_2
    //   469: putfield 257	com/tencent/mm/protocal/protobuf/dnc:aaUh	Ljava/lang/String;
    //   472: aload 7
    //   474: aload 6
    //   476: invokevirtual 283	com/tencent/mm/protocal/protobuf/dnc:toByteArray	()[B
    //   479: putfield 215	com/tencent/mm/plugin/sns/storage/z:QZv	[B
    //   482: invokestatic 157	com/tencent/mm/plugin/sns/model/al:hgq	()Lcom/tencent/mm/plugin/sns/storage/aa;
    //   485: aload 7
    //   487: getfield 286	com/tencent/mm/plugin/sns/storage/z:localid	I
    //   490: aload 7
    //   492: invokevirtual 290	com/tencent/mm/plugin/sns/storage/aa:a	(ILcom/tencent/mm/plugin/sns/storage/z;)I
    //   495: pop
    //   496: aload_0
    //   497: getfield 151	com/tencent/mm/plugin/sns/model/aa:Qtm	Lcom/tencent/mm/protocal/protobuf/ffp;
    //   500: aload_0
    //   501: getfield 243	com/tencent/mm/plugin/sns/model/aa:osy	I
    //   504: putfield 293	com/tencent/mm/protocal/protobuf/ffp:NkN	I
    //   507: aload_0
    //   508: getfield 151	com/tencent/mm/plugin/sns/model/aa:Qtm	Lcom/tencent/mm/protocal/protobuf/ffp;
    //   511: aload 7
    //   513: getfield 184	com/tencent/mm/plugin/sns/storage/z:offset	I
    //   516: putfield 296	com/tencent/mm/protocal/protobuf/ffp:NkO	I
    //   519: aload_0
    //   520: getfield 151	com/tencent/mm/plugin/sns/model/aa:Qtm	Lcom/tencent/mm/protocal/protobuf/ffp;
    //   523: aload_2
    //   524: putfield 299	com/tencent/mm/protocal/protobuf/ffp:nUv	Ljava/lang/String;
    //   527: aload_0
    //   528: aload_2
    //   529: putfield 73	com/tencent/mm/plugin/sns/model/aa:oHX	Ljava/lang/String;
    //   532: ldc 165
    //   534: new 167	java/lang/StringBuilder
    //   537: dup
    //   538: ldc_w 301
    //   541: invokespecial 172	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   544: aload 6
    //   546: getfield 304	com/tencent/mm/protocal/protobuf/dnc:aaTG	I
    //   549: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   552: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   555: invokestatic 307	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   558: aload_0
    //   559: getfield 151	com/tencent/mm/plugin/sns/model/aa:Qtm	Lcom/tencent/mm/protocal/protobuf/ffp;
    //   562: aload 6
    //   564: getfield 304	com/tencent/mm/protocal/protobuf/dnc:aaTG	I
    //   567: putfield 308	com/tencent/mm/protocal/protobuf/ffp:aaTG	I
    //   570: ldc 165
    //   572: new 167	java/lang/StringBuilder
    //   575: dup
    //   576: ldc_w 310
    //   579: invokespecial 172	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   582: aload 6
    //   584: getfield 313	com/tencent/mm/protocal/protobuf/dnc:aaTH	I
    //   587: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   590: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   593: invokestatic 307	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   596: aload_0
    //   597: getfield 151	com/tencent/mm/plugin/sns/model/aa:Qtm	Lcom/tencent/mm/protocal/protobuf/ffp;
    //   600: new 167	java/lang/StringBuilder
    //   603: dup
    //   604: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   607: aload 6
    //   609: getfield 316	com/tencent/mm/protocal/protobuf/dnc:IGG	Ljava/lang/String;
    //   612: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   618: putfield 319	com/tencent/mm/protocal/protobuf/ffp:crB	Ljava/lang/String;
    //   621: aload_0
    //   622: getfield 151	com/tencent/mm/plugin/sns/model/aa:Qtm	Lcom/tencent/mm/protocal/protobuf/ffp;
    //   625: aload 6
    //   627: getfield 313	com/tencent/mm/protocal/protobuf/dnc:aaTH	I
    //   630: putfield 320	com/tencent/mm/protocal/protobuf/ffp:aaTH	I
    //   633: ldc 165
    //   635: new 167	java/lang/StringBuilder
    //   638: dup
    //   639: ldc_w 322
    //   642: invokespecial 172	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   645: aload 7
    //   647: getfield 325	com/tencent/mm/plugin/sns/storage/z:type	I
    //   650: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   653: ldc_w 327
    //   656: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: aload 6
    //   661: getfield 330	com/tencent/mm/protocal/protobuf/dnc:md5	Ljava/lang/String;
    //   664: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: ldc_w 332
    //   670: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: aload 6
    //   675: getfield 335	com/tencent/mm/protocal/protobuf/dnc:appid	Ljava/lang/String;
    //   678: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: ldc_w 337
    //   684: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: aload 6
    //   689: getfield 340	com/tencent/mm/protocal/protobuf/dnc:cIh	I
    //   692: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   695: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   698: invokestatic 203	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   701: aload_0
    //   702: getfield 151	com/tencent/mm/plugin/sns/model/aa:Qtm	Lcom/tencent/mm/protocal/protobuf/ffp;
    //   705: aload 7
    //   707: getfield 325	com/tencent/mm/plugin/sns/storage/z:type	I
    //   710: putfield 343	com/tencent/mm/protocal/protobuf/ffp:vhJ	I
    //   713: new 345	com/tencent/mm/protocal/protobuf/fqo
    //   716: dup
    //   717: invokespecial 346	com/tencent/mm/protocal/protobuf/fqo:<init>	()V
    //   720: astore_2
    //   721: aload_2
    //   722: aload 6
    //   724: getfield 349	com/tencent/mm/protocal/protobuf/dnc:token	Ljava/lang/String;
    //   727: putfield 352	com/tencent/mm/protocal/protobuf/fqo:abQw	Ljava/lang/String;
    //   730: aload_2
    //   731: aload 6
    //   733: getfield 355	com/tencent/mm/protocal/protobuf/dnc:aaTQ	Ljava/lang/String;
    //   736: putfield 358	com/tencent/mm/protocal/protobuf/fqo:abQx	Ljava/lang/String;
    //   739: aload_0
    //   740: getfield 151	com/tencent/mm/plugin/sns/model/aa:Qtm	Lcom/tencent/mm/protocal/protobuf/ffp;
    //   743: aload_2
    //   744: putfield 362	com/tencent/mm/protocal/protobuf/ffp:abld	Lcom/tencent/mm/protocal/protobuf/fqo;
    //   747: aload 6
    //   749: getfield 330	com/tencent/mm/protocal/protobuf/dnc:md5	Ljava/lang/String;
    //   752: invokestatic 262	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   755: ifne +15 -> 770
    //   758: aload_0
    //   759: getfield 151	com/tencent/mm/plugin/sns/model/aa:Qtm	Lcom/tencent/mm/protocal/protobuf/ffp;
    //   762: aload 6
    //   764: getfield 330	com/tencent/mm/protocal/protobuf/dnc:md5	Ljava/lang/String;
    //   767: putfield 365	com/tencent/mm/protocal/protobuf/ffp:MD5	Ljava/lang/String;
    //   770: aload 6
    //   772: getfield 335	com/tencent/mm/protocal/protobuf/dnc:appid	Ljava/lang/String;
    //   775: invokestatic 262	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   778: ifne +15 -> 793
    //   781: aload_0
    //   782: getfield 151	com/tencent/mm/plugin/sns/model/aa:Qtm	Lcom/tencent/mm/protocal/protobuf/ffp;
    //   785: aload 6
    //   787: getfield 335	com/tencent/mm/protocal/protobuf/dnc:appid	Ljava/lang/String;
    //   790: putfield 368	com/tencent/mm/protocal/protobuf/ffp:oOI	Ljava/lang/String;
    //   793: aload_0
    //   794: getfield 151	com/tencent/mm/plugin/sns/model/aa:Qtm	Lcom/tencent/mm/protocal/protobuf/ffp;
    //   797: aload 6
    //   799: getfield 340	com/tencent/mm/protocal/protobuf/dnc:cIh	I
    //   802: putfield 371	com/tencent/mm/protocal/protobuf/ffp:abFC	I
    //   805: getstatic 376	com/tencent/mm/platformtools/z:pBO	Z
    //   808: ifeq +11 -> 819
    //   811: aload_0
    //   812: getfield 151	com/tencent/mm/plugin/sns/model/aa:Qtm	Lcom/tencent/mm/protocal/protobuf/ffp;
    //   815: iconst_0
    //   816: putfield 343	com/tencent/mm/protocal/protobuf/ffp:vhJ	I
    //   819: aload_0
    //   820: getfield 85	com/tencent/mm/plugin/sns/model/aa:startTime	J
    //   823: lconst_0
    //   824: lcmp
    //   825: ifne +17 -> 842
    //   828: aload_0
    //   829: invokestatic 379	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   832: putfield 85	com/tencent/mm/plugin/sns/model/aa:startTime	J
    //   835: aload_0
    //   836: getstatic 384	com/tencent/mm/g/a:MediaType_FRIENDS	I
    //   839: putfield 87	com/tencent/mm/plugin/sns/model/aa:mgx	I
    //   842: aload_0
    //   843: getfield 151	com/tencent/mm/plugin/sns/model/aa:Qtm	Lcom/tencent/mm/protocal/protobuf/ffp;
    //   846: astore_2
    //   847: invokestatic 390	com/tencent/mm/modelcdntran/k:bHW	()Lcom/tencent/mm/modelcdntran/g;
    //   850: pop
    //   851: bipush 32
    //   853: invokestatic 396	com/tencent/mm/modelcdntran/g:vV	(I)Z
    //   856: ifne +80 -> 936
    //   859: invokestatic 390	com/tencent/mm/modelcdntran/k:bHW	()Lcom/tencent/mm/modelcdntran/g;
    //   862: pop
    //   863: ldc 165
    //   865: ldc_w 398
    //   868: iconst_1
    //   869: anewarray 400	java/lang/Object
    //   872: dup
    //   873: iconst_0
    //   874: bipush 32
    //   876: invokestatic 396	com/tencent/mm/modelcdntran/g:vV	(I)Z
    //   879: invokestatic 406	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   882: aastore
    //   883: invokestatic 410	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   886: iconst_0
    //   887: istore_1
    //   888: iload_1
    //   889: ifeq +95 -> 984
    //   892: aload_0
    //   893: iconst_1
    //   894: putfield 77	com/tencent/mm/plugin/sns/model/aa:Qtp	Z
    //   897: ldc 51
    //   899: invokestatic 413	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   902: return
    //   903: astore_2
    //   904: ldc 165
    //   906: ldc_w 415
    //   909: invokestatic 418	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   912: ldc 51
    //   914: invokestatic 413	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   917: return
    //   918: astore 5
    //   920: ldc 165
    //   922: aload 5
    //   924: ldc 63
    //   926: iconst_0
    //   927: anewarray 400	java/lang/Object
    //   930: invokestatic 422	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   933: goto -437 -> 496
    //   936: getstatic 425	com/tencent/mm/platformtools/z:pCE	I
    //   939: iconst_2
    //   940: if_icmpne +8 -> 948
    //   943: iconst_0
    //   944: istore_1
    //   945: goto -57 -> 888
    //   948: aload_0
    //   949: aload_2
    //   950: getfield 299	com/tencent/mm/protocal/protobuf/ffp:nUv	Ljava/lang/String;
    //   953: putfield 73	com/tencent/mm/plugin/sns/model/aa:oHX	Ljava/lang/String;
    //   956: aload_0
    //   957: getfield 73	com/tencent/mm/plugin/sns/model/aa:oHX	Ljava/lang/String;
    //   960: invokestatic 262	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   963: ifeq +16 -> 979
    //   966: ldc 165
    //   968: ldc_w 427
    //   971: invokestatic 429	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   974: iconst_0
    //   975: istore_1
    //   976: goto -88 -> 888
    //   979: iconst_1
    //   980: istore_1
    //   981: goto -93 -> 888
    //   984: aload_0
    //   985: invokespecial 433	com/tencent/mm/plugin/sns/model/aa:hfR	()Z
    //   988: ifne +7 -> 995
    //   991: aload_0
    //   992: invokespecial 436	com/tencent/mm/plugin/sns/model/aa:atR	()V
    //   995: ldc 51
    //   997: invokestatic 413	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1000: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1001	0	this	aa
    //   0	1001	1	paramInt1	int
    //   0	1001	2	paramString	String
    //   0	1001	3	paramBoolean	boolean
    //   0	1001	4	paramInt2	int
    //   430	6	5	str	String
    //   918	5	5	localException	Exception
    //   317	481	6	localdnc	dnc
    //   213	493	7	localz	z
    // Exception table:
    //   from	to	target	type
    //   299	319	903	java/lang/Exception
    //   472	496	918	java/lang/Exception
  }
  
  private void akz(int paramInt)
  {
    AppMethodBeat.i(95676);
    z localz = al.hgq().vk(this.icg);
    try
    {
      dnc localdnc = (dnc)new dnc().parseFrom(localz.QZv);
      localdnc.aaPu = 1;
      localdnc.aaTP = paramInt;
      localz.QZv = localdnc.toByteArray();
      label54:
      al.hgA().akE(this.icg);
      al.hgq().a(this.icg, localz);
      AppMethodBeat.o(95676);
      return;
    }
    catch (Exception localException)
    {
      break label54;
    }
  }
  
  private void atR()
  {
    AppMethodBeat.i(95677);
    z localz = al.hgq().vk(this.icg);
    localz.offset = 0;
    try
    {
      dnc localdnc = (dnc)new dnc().parseFrom(localz.QZv);
      localdnc.aaUh = "";
      localz.QZv = localdnc.toByteArray();
      al.hgq().a(this.icg, localz);
      al.hgA().akE(this.icg);
      AppMethodBeat.o(95677);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.NetSceneSnsUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
      AppMethodBeat.o(95677);
    }
  }
  
  private boolean hfR()
  {
    AppMethodBeat.i(95673);
    Object localObject = al.hgq().vk(this.icg);
    int j = ((z)localObject).QZs - ((z)localObject).offset;
    int i = j;
    if (j > this.oIq) {
      i = this.oIq;
    }
    this.offset = ((z)localObject).offset;
    localObject = y.bi(this.path, this.offset, i);
    if ((localObject == null) || (localObject.length <= 0))
    {
      AppMethodBeat.o(95673);
      return false;
    }
    gol localgol = new gol();
    localgol.df((byte[])localObject);
    this.Qtm.YLa = localgol;
    this.Qtm.NkO = this.offset;
    AppMethodBeat.o(95673);
    return true;
  }
  
  public final boolean a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(95675);
    z localz = al.hgq().vk(this.icg);
    Log.i("MicroMsg.NetSceneSnsUpload", "upload ok " + paramString1 + "  " + paramString3 + "  " + paramInt1 + " thumbUrl: " + paramString2);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapUtil.decodeFile(this.path, localOptions);
    Object localObject;
    if (localOptions.outMimeType != null) {
      localObject = localOptions.outMimeType.toLowerCase();
    }
    for (;;)
    {
      int i = -1;
      if ((((String)localObject).endsWith("jpg")) || (((String)localObject).endsWith("jpeg")))
      {
        int j = MMNativeJpeg.queryQuality(this.path);
        i = j;
        if (j == 0) {
          i = -1;
        }
      }
      long l = y.bEl(this.path);
      f.c(paramString1, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, i, l);
      localz.strId = paramString3;
      try
      {
        paramString3 = (dnc)new dnc().parseFrom(localz.QZv);
        localObject = paramString3;
        if (paramString3 == null) {
          localObject = new dnc();
        }
        paramString3 = new dmu();
        paramString3.vhJ = paramInt1;
        paramString3.Url = paramString1;
        ((dnc)localObject).aaUe = paramString3;
        ((dnc)localObject).aaPu = 0;
        ((dnc)localObject).md5 = paramString4;
        if (!Util.isNullOrNil(paramString2))
        {
          paramString1 = new dmu();
          paramString1.vhJ = paramInt2;
          paramString1.Url = paramString2;
          ((dnc)localObject).aaUg.add(paramString1);
        }
      }
      catch (Exception paramString3)
      {
        try
        {
          localz.QZv = ((dnc)localObject).toByteArray();
          localz.hlh();
          al.hgq().a(this.icg, localz);
          al.hgA().akE(this.icg);
          if (al.hgx() != null) {
            al.hgx().hej();
          }
          AppMethodBeat.o(95675);
          return true;
          localObject = "";
          continue;
          paramString3 = paramString3;
          paramString3 = null;
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.NetSceneSnsUpload", paramString1, "", new Object[0]);
          }
        }
      }
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(95678);
    super.cancel();
    if ((this.Qtp) && (!Util.isNullOrNil(this.oHX)))
    {
      Log.i("MicroMsg.NetSceneSnsUpload", "cancel by cdn " + this.oHX);
      k.bHW().Ny(this.oHX);
    }
    AppMethodBeat.o(95678);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    int i = 108;
    AppMethodBeat.i(95679);
    this.callback = paramh;
    if (this.Qtp)
    {
      this.oHX = this.Qtm.nUv;
      if (Util.isNullOrNil(this.oHX))
      {
        Log.w("MicroMsg.NetSceneSnsUpload", "cdntra genClientId failed not use cdn");
        AppMethodBeat.o(95679);
        return 0;
      }
      paramg = new com.tencent.mm.g.g();
      paramg.taskName = "task_NetSceneSnsUpload_1";
      paramg.lwL = this.osH;
      paramg.field_mediaId = this.oHX;
      paramg.field_fullpath = this.path;
      paramg.field_thumbpath = "";
      paramg.field_fileType = this.mgx;
      paramg.field_talker = "";
      paramg.field_priority = a.lvZ;
      paramg.field_needStorage = true;
      paramg.field_isStreamMedia = false;
      if (com.tencent.mm.plugin.sns.storage.aa.hlk())
      {
        if (this.Qtr) {}
        for (i = 114;; i = 113)
        {
          paramg.field_appType = i;
          paramg.field_bzScene = 1;
          if (k.bHW().g(paramg)) {
            break;
          }
          Log.e("MicroMsg.NetSceneSnsUpload", "cdntra addSendTask failed. clientid:%s", new Object[] { this.oHX });
          this.oHX = "";
          break;
        }
      }
      if (com.tencent.mm.plugin.sns.storage.aa.hll())
      {
        if (this.Qtr) {}
        for (;;)
        {
          paramg.field_appType = i;
          break;
          i = 107;
        }
      }
      if (com.tencent.mm.plugin.sns.storage.aa.hlj())
      {
        if (this.Qtr) {}
        for (;;)
        {
          paramg.field_appType = i;
          break;
          i = 107;
        }
      }
      k.bHW();
      if (com.tencent.mm.modelcdntran.g.vV(64))
      {
        if (this.Qtr) {}
        for (i = 104;; i = 103)
        {
          paramg.field_appType = i;
          break;
        }
      }
      if (this.Qtr) {}
      for (i = 101;; i = 100)
      {
        paramg.field_appType = i;
        break;
      }
    }
    i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(95679);
    return i;
  }
  
  public final int getType()
  {
    return 207;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95674);
    Log.i("MicroMsg.NetSceneSnsUpload", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    params = (ffq)c.c.b(((com.tencent.mm.am.c)params).otC);
    if (paramInt2 == 4)
    {
      akz(paramInt3);
      if (this.Qts == 21) {
        b.rG(12);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95674);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      atR();
      if (this.Qts == 21) {
        b.rG(13);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95674);
      return;
    }
    paramArrayOfByte = al.hgq().vk(this.icg);
    if ((params.NkO < 0) || ((params.NkO > paramArrayOfByte.QZs) && (paramArrayOfByte.QZs > 0)))
    {
      atR();
      if (paramInt2 == 3) {
        b.rG(14);
      }
      AppMethodBeat.o(95674);
      return;
    }
    if (params.NkO < paramArrayOfByte.offset)
    {
      atR();
      if (paramInt2 == 3) {
        b.rG(14);
      }
      AppMethodBeat.o(95674);
      return;
    }
    Log.d("MicroMsg.NetSceneSnsUpload", " bufferUrl: " + params.abFD.Url + " bufferUrlType: " + params.abFD.vhJ + "  id:" + params.Id + " thumb Count: " + params.aaUf + "  type " + params.vhJ + " startPos : " + params.NkO);
    paramArrayOfByte.offset = params.NkO;
    al.hgq().a(this.icg, paramArrayOfByte);
    if ((paramArrayOfByte.offset == paramArrayOfByte.QZs) && (paramArrayOfByte.QZs != 0))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label621;
      }
      Log.i("MicroMsg.NetSceneSnsUpload", "uploadsns done pass: " + (System.currentTimeMillis() - this.osG));
      if ((params.aaUg.size() == 0) || (params.aaUg.size() <= 0)) {
        break label569;
      }
      a(params.abFD.Url, params.abFD.vhJ, ((fds)params.aaUg.get(0)).Url, ((fds)params.aaUg.get(0)).vhJ, params.Id, this.Qtm.MD5);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95674);
      return;
      paramInt1 = 0;
      break;
      label569:
      a(params.abFD.Url, params.abFD.vhJ, "", 0, params.Id, this.Qtm.MD5);
    }
    label621:
    if ((hfR()) && (doScene(dispatcher(), this.callback) < 0)) {
      this.callback.onSceneEnd(3, -1, "doScene failed", this);
    }
    AppMethodBeat.o(95674);
  }
  
  public final int securityLimitCount()
  {
    if (this.Qto) {
      return 675;
    }
    return 100;
  }
  
  public final p.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return p.b.ouh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.aa
 * JD-Core Version:    0.7.0.1
 */