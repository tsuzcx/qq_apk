package com.tencent.mm.plugin.sns.model;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.i.a;
import com.tencent.mm.i.g.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.k.d;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bpd;
import com.tencent.mm.protocal.protobuf.bpl;
import com.tencent.mm.protocal.protobuf.cul;
import com.tencent.mm.protocal.protobuf.cwe;
import com.tencent.mm.protocal.protobuf.cwf;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.LinkedList;

public final class y
  extends n
  implements k
{
  public com.tencent.mm.al.g callback;
  private int dzf;
  int fLB;
  private int gTY;
  long hZo;
  public String hhN;
  private g.a hhW;
  private int hig;
  private int offset;
  private String path;
  private com.tencent.mm.al.b rr;
  long startTime;
  private String wFW;
  private cwe wFX;
  private String wFY;
  private boolean wFZ;
  private boolean wGa;
  private boolean wGb;
  private boolean wGc;
  int wGd;
  
  /* Error */
  public y(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 41	com/tencent/mm/al/n:<init>	()V
    //   4: ldc 42
    //   6: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: sipush 8192
    //   13: putfield 50	com/tencent/mm/plugin/sns/model/y:hig	I
    //   16: aload_0
    //   17: iconst_0
    //   18: putfield 52	com/tencent/mm/plugin/sns/model/y:offset	I
    //   21: aload_0
    //   22: ldc 54
    //   24: putfield 56	com/tencent/mm/plugin/sns/model/y:path	Ljava/lang/String;
    //   27: aload_0
    //   28: ldc 54
    //   30: putfield 58	com/tencent/mm/plugin/sns/model/y:wFW	Ljava/lang/String;
    //   33: aload_0
    //   34: iconst_0
    //   35: putfield 60	com/tencent/mm/plugin/sns/model/y:dzf	I
    //   38: aload_0
    //   39: ldc 54
    //   41: putfield 62	com/tencent/mm/plugin/sns/model/y:wFY	Ljava/lang/String;
    //   44: aload_0
    //   45: ldc 54
    //   47: putfield 64	com/tencent/mm/plugin/sns/model/y:hhN	Ljava/lang/String;
    //   50: aload_0
    //   51: iconst_0
    //   52: putfield 66	com/tencent/mm/plugin/sns/model/y:wFZ	Z
    //   55: aload_0
    //   56: iconst_0
    //   57: putfield 68	com/tencent/mm/plugin/sns/model/y:wGa	Z
    //   60: aload_0
    //   61: iconst_0
    //   62: putfield 70	com/tencent/mm/plugin/sns/model/y:wGb	Z
    //   65: aload_0
    //   66: iconst_0
    //   67: putfield 72	com/tencent/mm/plugin/sns/model/y:wGc	Z
    //   70: aload_0
    //   71: lconst_0
    //   72: putfield 74	com/tencent/mm/plugin/sns/model/y:hZo	J
    //   75: aload_0
    //   76: lconst_0
    //   77: putfield 76	com/tencent/mm/plugin/sns/model/y:startTime	J
    //   80: aload_0
    //   81: iconst_0
    //   82: putfield 78	com/tencent/mm/plugin/sns/model/y:fLB	I
    //   85: aload_0
    //   86: iconst_0
    //   87: putfield 80	com/tencent/mm/plugin/sns/model/y:wGd	I
    //   90: aload_0
    //   91: new 82	com/tencent/mm/plugin/sns/model/y$1
    //   94: dup
    //   95: aload_0
    //   96: invokespecial 85	com/tencent/mm/plugin/sns/model/y$1:<init>	(Lcom/tencent/mm/plugin/sns/model/y;)V
    //   99: putfield 87	com/tencent/mm/plugin/sns/model/y:hhW	Lcom/tencent/mm/i/g$a;
    //   102: aload_0
    //   103: invokestatic 93	java/lang/System:currentTimeMillis	()J
    //   106: putfield 74	com/tencent/mm/plugin/sns/model/y:hZo	J
    //   109: aload_0
    //   110: iload_1
    //   111: putfield 60	com/tencent/mm/plugin/sns/model/y:dzf	I
    //   114: aload_0
    //   115: aload_2
    //   116: putfield 62	com/tencent/mm/plugin/sns/model/y:wFY	Ljava/lang/String;
    //   119: aload_0
    //   120: iload 4
    //   122: putfield 80	com/tencent/mm/plugin/sns/model/y:wGd	I
    //   125: new 95	com/tencent/mm/al/b$a
    //   128: dup
    //   129: invokespecial 96	com/tencent/mm/al/b$a:<init>	()V
    //   132: astore_2
    //   133: aload_2
    //   134: new 98	com/tencent/mm/protocal/protobuf/cwe
    //   137: dup
    //   138: invokespecial 99	com/tencent/mm/protocal/protobuf/cwe:<init>	()V
    //   141: putfield 103	com/tencent/mm/al/b$a:gUU	Lcom/tencent/mm/bx/a;
    //   144: aload_2
    //   145: new 105	com/tencent/mm/protocal/protobuf/cwf
    //   148: dup
    //   149: invokespecial 106	com/tencent/mm/protocal/protobuf/cwf:<init>	()V
    //   152: putfield 109	com/tencent/mm/al/b$a:gUV	Lcom/tencent/mm/bx/a;
    //   155: aload_2
    //   156: ldc 111
    //   158: putfield 114	com/tencent/mm/al/b$a:uri	Ljava/lang/String;
    //   161: aload_2
    //   162: sipush 207
    //   165: putfield 117	com/tencent/mm/al/b$a:funcId	I
    //   168: aload_2
    //   169: bipush 95
    //   171: putfield 120	com/tencent/mm/al/b$a:reqCmdId	I
    //   174: aload_2
    //   175: ldc 121
    //   177: putfield 124	com/tencent/mm/al/b$a:respCmdId	I
    //   180: aload_0
    //   181: aload_2
    //   182: invokevirtual 128	com/tencent/mm/al/b$a:atI	()Lcom/tencent/mm/al/b;
    //   185: putfield 130	com/tencent/mm/plugin/sns/model/y:rr	Lcom/tencent/mm/al/b;
    //   188: aload_0
    //   189: aload_0
    //   190: getfield 130	com/tencent/mm/plugin/sns/model/y:rr	Lcom/tencent/mm/al/b;
    //   193: getfield 136	com/tencent/mm/al/b:gUS	Lcom/tencent/mm/al/b$b;
    //   196: getfield 141	com/tencent/mm/al/b$b:gUX	Lcom/tencent/mm/bx/a;
    //   199: checkcast 98	com/tencent/mm/protocal/protobuf/cwe
    //   202: putfield 143	com/tencent/mm/plugin/sns/model/y:wFX	Lcom/tencent/mm/protocal/protobuf/cwe;
    //   205: invokestatic 149	com/tencent/mm/plugin/sns/model/af:dtj	()Lcom/tencent/mm/plugin/sns/storage/u;
    //   208: iload_1
    //   209: i2l
    //   210: invokevirtual 155	com/tencent/mm/plugin/sns/storage/u:ti	(J)Lcom/tencent/mm/plugin/sns/storage/t;
    //   213: astore 7
    //   215: aload_0
    //   216: iload_3
    //   217: putfield 72	com/tencent/mm/plugin/sns/model/y:wGc	Z
    //   220: ldc 157
    //   222: new 159	java/lang/StringBuilder
    //   225: dup
    //   226: ldc 161
    //   228: invokespecial 164	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   231: iload_1
    //   232: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   235: ldc 170
    //   237: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload 7
    //   242: getfield 176	com/tencent/mm/plugin/sns/storage/t:offset	I
    //   245: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   248: ldc 178
    //   250: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: aload 7
    //   255: getfield 181	com/tencent/mm/plugin/sns/storage/t:xjj	Ljava/lang/String;
    //   258: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: ldc 183
    //   263: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload 7
    //   268: getfield 186	com/tencent/mm/plugin/sns/storage/t:xji	I
    //   271: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   274: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokestatic 195	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   280: iload_3
    //   281: ifne +18 -> 299
    //   284: aload_0
    //   285: getfield 143	com/tencent/mm/plugin/sns/model/y:wFX	Lcom/tencent/mm/protocal/protobuf/cwe;
    //   288: iconst_1
    //   289: putfield 198	com/tencent/mm/protocal/protobuf/cwe:ExtFlag	I
    //   292: ldc 157
    //   294: ldc 200
    //   296: invokestatic 195	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   299: new 202	com/tencent/mm/protocal/protobuf/bpl
    //   302: dup
    //   303: invokespecial 203	com/tencent/mm/protocal/protobuf/bpl:<init>	()V
    //   306: aload 7
    //   308: getfield 207	com/tencent/mm/plugin/sns/storage/t:xjn	[B
    //   311: invokevirtual 211	com/tencent/mm/protocal/protobuf/bpl:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   314: checkcast 202	com/tencent/mm/protocal/protobuf/bpl
    //   317: astore 6
    //   319: aload_0
    //   320: aload 7
    //   322: getfield 181	com/tencent/mm/plugin/sns/storage/t:xjj	Ljava/lang/String;
    //   325: invokestatic 217	com/tencent/mm/plugin/sns/data/q:anE	(Ljava/lang/String;)Ljava/lang/String;
    //   328: putfield 58	com/tencent/mm/plugin/sns/model/y:wFW	Ljava/lang/String;
    //   331: aload_0
    //   332: new 159	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   339: invokestatic 221	com/tencent/mm/plugin/sns/model/af:getAccSnsPath	()Ljava/lang/String;
    //   342: aload 7
    //   344: getfield 181	com/tencent/mm/plugin/sns/storage/t:xjj	Ljava/lang/String;
    //   347: invokestatic 227	com/tencent/mm/plugin/sns/model/an:iF	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   350: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: aload_0
    //   354: getfield 58	com/tencent/mm/plugin/sns/model/y:wFW	Ljava/lang/String;
    //   357: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: putfield 56	com/tencent/mm/plugin/sns/model/y:path	Ljava/lang/String;
    //   366: aload_0
    //   367: aload_0
    //   368: getfield 56	com/tencent/mm/plugin/sns/model/y:path	Ljava/lang/String;
    //   371: invokestatic 233	com/tencent/mm/vfs/i:aMN	(Ljava/lang/String;)J
    //   374: l2i
    //   375: putfield 235	com/tencent/mm/plugin/sns/model/y:gTY	I
    //   378: aload_0
    //   379: aload_0
    //   380: getfield 56	com/tencent/mm/plugin/sns/model/y:path	Ljava/lang/String;
    //   383: invokestatic 239	com/tencent/mm/plugin/sns/data/q:anP	(Ljava/lang/String;)Z
    //   386: putfield 66	com/tencent/mm/plugin/sns/model/y:wFZ	Z
    //   389: ldc 157
    //   391: new 159	java/lang/StringBuilder
    //   394: dup
    //   395: ldc 241
    //   397: invokespecial 164	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   400: aload_0
    //   401: getfield 235	com/tencent/mm/plugin/sns/model/y:gTY	I
    //   404: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   407: ldc 243
    //   409: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: aload_0
    //   413: getfield 66	com/tencent/mm/plugin/sns/model/y:wFZ	Z
    //   416: invokevirtual 246	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   419: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokestatic 195	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   425: aload 6
    //   427: getfield 249	com/tencent/mm/protocal/protobuf/bpl:DNN	Ljava/lang/String;
    //   430: astore 5
    //   432: aload 5
    //   434: astore_2
    //   435: aload 5
    //   437: invokestatic 254	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   440: ifeq +56 -> 496
    //   443: new 159	java/lang/StringBuilder
    //   446: dup
    //   447: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   450: invokestatic 257	com/tencent/mm/sdk/platformtools/bt:GC	()J
    //   453: invokevirtual 260	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   456: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: invokevirtual 266	java/lang/String:getBytes	()[B
    //   462: invokestatic 272	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   465: astore_2
    //   466: aload 6
    //   468: aload_2
    //   469: putfield 249	com/tencent/mm/protocal/protobuf/bpl:DNN	Ljava/lang/String;
    //   472: aload 7
    //   474: aload 6
    //   476: invokevirtual 275	com/tencent/mm/protocal/protobuf/bpl:toByteArray	()[B
    //   479: putfield 207	com/tencent/mm/plugin/sns/storage/t:xjn	[B
    //   482: invokestatic 149	com/tencent/mm/plugin/sns/model/af:dtj	()Lcom/tencent/mm/plugin/sns/storage/u;
    //   485: aload 7
    //   487: getfield 278	com/tencent/mm/plugin/sns/storage/t:xiB	I
    //   490: aload 7
    //   492: invokevirtual 282	com/tencent/mm/plugin/sns/storage/u:a	(ILcom/tencent/mm/plugin/sns/storage/t;)I
    //   495: pop
    //   496: aload_0
    //   497: getfield 143	com/tencent/mm/plugin/sns/model/y:wFX	Lcom/tencent/mm/protocal/protobuf/cwe;
    //   500: aload_0
    //   501: getfield 235	com/tencent/mm/plugin/sns/model/y:gTY	I
    //   504: putfield 285	com/tencent/mm/protocal/protobuf/cwe:uKQ	I
    //   507: aload_0
    //   508: getfield 143	com/tencent/mm/plugin/sns/model/y:wFX	Lcom/tencent/mm/protocal/protobuf/cwe;
    //   511: aload 7
    //   513: getfield 176	com/tencent/mm/plugin/sns/storage/t:offset	I
    //   516: putfield 288	com/tencent/mm/protocal/protobuf/cwe:uKR	I
    //   519: aload_0
    //   520: getfield 143	com/tencent/mm/plugin/sns/model/y:wFX	Lcom/tencent/mm/protocal/protobuf/cwe;
    //   523: aload_2
    //   524: putfield 291	com/tencent/mm/protocal/protobuf/cwe:gKn	Ljava/lang/String;
    //   527: aload_0
    //   528: aload_2
    //   529: putfield 64	com/tencent/mm/plugin/sns/model/y:hhN	Ljava/lang/String;
    //   532: ldc 157
    //   534: new 159	java/lang/StringBuilder
    //   537: dup
    //   538: ldc_w 293
    //   541: invokespecial 164	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   544: aload 6
    //   546: getfield 296	com/tencent/mm/protocal/protobuf/bpl:DNn	I
    //   549: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   552: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   555: invokestatic 299	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   558: aload_0
    //   559: getfield 143	com/tencent/mm/plugin/sns/model/y:wFX	Lcom/tencent/mm/protocal/protobuf/cwe;
    //   562: aload 6
    //   564: getfield 296	com/tencent/mm/protocal/protobuf/bpl:DNn	I
    //   567: putfield 300	com/tencent/mm/protocal/protobuf/cwe:DNn	I
    //   570: ldc 157
    //   572: new 159	java/lang/StringBuilder
    //   575: dup
    //   576: ldc_w 302
    //   579: invokespecial 164	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   582: aload 6
    //   584: getfield 305	com/tencent/mm/protocal/protobuf/bpl:DNo	I
    //   587: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   590: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   593: invokestatic 299	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   596: aload_0
    //   597: getfield 143	com/tencent/mm/plugin/sns/model/y:wFX	Lcom/tencent/mm/protocal/protobuf/cwe;
    //   600: new 159	java/lang/StringBuilder
    //   603: dup
    //   604: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   607: aload 6
    //   609: getfield 308	com/tencent/mm/protocal/protobuf/bpl:Desc	Ljava/lang/String;
    //   612: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   618: putfield 311	com/tencent/mm/protocal/protobuf/cwe:Cxw	Ljava/lang/String;
    //   621: aload_0
    //   622: getfield 143	com/tencent/mm/plugin/sns/model/y:wFX	Lcom/tencent/mm/protocal/protobuf/cwe;
    //   625: aload 6
    //   627: getfield 305	com/tencent/mm/protocal/protobuf/bpl:DNo	I
    //   630: putfield 312	com/tencent/mm/protocal/protobuf/cwe:DNo	I
    //   633: ldc 157
    //   635: new 159	java/lang/StringBuilder
    //   638: dup
    //   639: ldc_w 314
    //   642: invokespecial 164	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   645: aload 7
    //   647: getfield 317	com/tencent/mm/plugin/sns/storage/t:type	I
    //   650: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   653: ldc_w 319
    //   656: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: aload 6
    //   661: getfield 322	com/tencent/mm/protocal/protobuf/bpl:md5	Ljava/lang/String;
    //   664: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: ldc_w 324
    //   670: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: aload 6
    //   675: getfield 327	com/tencent/mm/protocal/protobuf/bpl:dlB	Ljava/lang/String;
    //   678: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: ldc_w 329
    //   684: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: aload 6
    //   689: getfield 332	com/tencent/mm/protocal/protobuf/bpl:aTB	I
    //   692: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   695: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   698: invokestatic 195	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   701: aload_0
    //   702: getfield 143	com/tencent/mm/plugin/sns/model/y:wFX	Lcom/tencent/mm/protocal/protobuf/cwe;
    //   705: aload 7
    //   707: getfield 317	com/tencent/mm/plugin/sns/storage/t:type	I
    //   710: putfield 335	com/tencent/mm/protocal/protobuf/cwe:mBH	I
    //   713: new 337	com/tencent/mm/protocal/protobuf/dew
    //   716: dup
    //   717: invokespecial 338	com/tencent/mm/protocal/protobuf/dew:<init>	()V
    //   720: astore_2
    //   721: aload_2
    //   722: aload 6
    //   724: getfield 341	com/tencent/mm/protocal/protobuf/bpl:token	Ljava/lang/String;
    //   727: putfield 344	com/tencent/mm/protocal/protobuf/dew:Ewv	Ljava/lang/String;
    //   730: aload_2
    //   731: aload 6
    //   733: getfield 347	com/tencent/mm/protocal/protobuf/bpl:DNx	Ljava/lang/String;
    //   736: putfield 350	com/tencent/mm/protocal/protobuf/dew:Eww	Ljava/lang/String;
    //   739: aload_0
    //   740: getfield 143	com/tencent/mm/plugin/sns/model/y:wFX	Lcom/tencent/mm/protocal/protobuf/cwe;
    //   743: aload_2
    //   744: putfield 354	com/tencent/mm/protocal/protobuf/cwe:DXy	Lcom/tencent/mm/protocal/protobuf/dew;
    //   747: aload 6
    //   749: getfield 322	com/tencent/mm/protocal/protobuf/bpl:md5	Ljava/lang/String;
    //   752: invokestatic 254	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   755: ifne +15 -> 770
    //   758: aload_0
    //   759: getfield 143	com/tencent/mm/plugin/sns/model/y:wFX	Lcom/tencent/mm/protocal/protobuf/cwe;
    //   762: aload 6
    //   764: getfield 322	com/tencent/mm/protocal/protobuf/bpl:md5	Ljava/lang/String;
    //   767: putfield 357	com/tencent/mm/protocal/protobuf/cwe:MD5	Ljava/lang/String;
    //   770: aload 6
    //   772: getfield 327	com/tencent/mm/protocal/protobuf/bpl:dlB	Ljava/lang/String;
    //   775: invokestatic 254	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   778: ifne +15 -> 793
    //   781: aload_0
    //   782: getfield 143	com/tencent/mm/plugin/sns/model/y:wFX	Lcom/tencent/mm/protocal/protobuf/cwe;
    //   785: aload 6
    //   787: getfield 327	com/tencent/mm/protocal/protobuf/bpl:dlB	Ljava/lang/String;
    //   790: putfield 360	com/tencent/mm/protocal/protobuf/cwe:hnC	Ljava/lang/String;
    //   793: aload_0
    //   794: getfield 143	com/tencent/mm/plugin/sns/model/y:wFX	Lcom/tencent/mm/protocal/protobuf/cwe;
    //   797: aload 6
    //   799: getfield 332	com/tencent/mm/protocal/protobuf/bpl:aTB	I
    //   802: putfield 363	com/tencent/mm/protocal/protobuf/cwe:EnZ	I
    //   805: getstatic 368	com/tencent/mm/platformtools/ab:hVf	Z
    //   808: ifeq +11 -> 819
    //   811: aload_0
    //   812: getfield 143	com/tencent/mm/plugin/sns/model/y:wFX	Lcom/tencent/mm/protocal/protobuf/cwe;
    //   815: iconst_0
    //   816: putfield 335	com/tencent/mm/protocal/protobuf/cwe:mBH	I
    //   819: aload_0
    //   820: getfield 76	com/tencent/mm/plugin/sns/model/y:startTime	J
    //   823: lconst_0
    //   824: lcmp
    //   825: ifne +17 -> 842
    //   828: aload_0
    //   829: invokestatic 371	com/tencent/mm/sdk/platformtools/bt:eGO	()J
    //   832: putfield 76	com/tencent/mm/plugin/sns/model/y:startTime	J
    //   835: aload_0
    //   836: getstatic 376	com/tencent/mm/i/a:MediaType_FRIENDS	I
    //   839: putfield 78	com/tencent/mm/plugin/sns/model/y:fLB	I
    //   842: aload_0
    //   843: getfield 143	com/tencent/mm/plugin/sns/model/y:wFX	Lcom/tencent/mm/protocal/protobuf/cwe;
    //   846: astore_2
    //   847: invokestatic 382	com/tencent/mm/ao/f:awL	()Lcom/tencent/mm/ao/b;
    //   850: pop
    //   851: bipush 32
    //   853: invokestatic 388	com/tencent/mm/ao/b:nL	(I)Z
    //   856: ifne +80 -> 936
    //   859: invokestatic 382	com/tencent/mm/ao/f:awL	()Lcom/tencent/mm/ao/b;
    //   862: pop
    //   863: ldc 157
    //   865: ldc_w 390
    //   868: iconst_1
    //   869: anewarray 392	java/lang/Object
    //   872: dup
    //   873: iconst_0
    //   874: bipush 32
    //   876: invokestatic 388	com/tencent/mm/ao/b:nL	(I)Z
    //   879: invokestatic 398	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   882: aastore
    //   883: invokestatic 402	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   886: iconst_0
    //   887: istore_1
    //   888: iload_1
    //   889: ifeq +95 -> 984
    //   892: aload_0
    //   893: iconst_1
    //   894: putfield 68	com/tencent/mm/plugin/sns/model/y:wGa	Z
    //   897: ldc 42
    //   899: invokestatic 405	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   902: return
    //   903: astore_2
    //   904: ldc 157
    //   906: ldc_w 407
    //   909: invokestatic 410	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   912: ldc 42
    //   914: invokestatic 405	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   917: return
    //   918: astore 5
    //   920: ldc 157
    //   922: aload 5
    //   924: ldc 54
    //   926: iconst_0
    //   927: anewarray 392	java/lang/Object
    //   930: invokestatic 414	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   933: goto -437 -> 496
    //   936: getstatic 417	com/tencent/mm/platformtools/ab:hVU	I
    //   939: iconst_2
    //   940: if_icmpne +8 -> 948
    //   943: iconst_0
    //   944: istore_1
    //   945: goto -57 -> 888
    //   948: aload_0
    //   949: aload_2
    //   950: getfield 291	com/tencent/mm/protocal/protobuf/cwe:gKn	Ljava/lang/String;
    //   953: putfield 64	com/tencent/mm/plugin/sns/model/y:hhN	Ljava/lang/String;
    //   956: aload_0
    //   957: getfield 64	com/tencent/mm/plugin/sns/model/y:hhN	Ljava/lang/String;
    //   960: invokestatic 254	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   963: ifeq +16 -> 979
    //   966: ldc 157
    //   968: ldc_w 419
    //   971: invokestatic 421	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   974: iconst_0
    //   975: istore_1
    //   976: goto -88 -> 888
    //   979: iconst_1
    //   980: istore_1
    //   981: goto -93 -> 888
    //   984: aload_0
    //   985: invokespecial 425	com/tencent/mm/plugin/sns/model/y:dsT	()Z
    //   988: ifne +7 -> 995
    //   991: aload_0
    //   992: invokespecial 428	com/tencent/mm/plugin/sns/model/y:onError	()V
    //   995: ldc 42
    //   997: invokestatic 405	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1000: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1001	0	this	y
    //   0	1001	1	paramInt1	int
    //   0	1001	2	paramString	String
    //   0	1001	3	paramBoolean	boolean
    //   0	1001	4	paramInt2	int
    //   430	6	5	str	String
    //   918	5	5	localException	Exception
    //   317	481	6	localbpl	bpl
    //   213	493	7	localt	t
    // Exception table:
    //   from	to	target	type
    //   299	319	903	java/lang/Exception
    //   472	496	918	java/lang/Exception
  }
  
  private boolean dsT()
  {
    AppMethodBeat.i(95673);
    Object localObject = af.dtj().ti(this.dzf);
    int j = ((t)localObject).xji - ((t)localObject).offset;
    int i = j;
    if (j > this.hig) {
      i = this.hig;
    }
    this.offset = ((t)localObject).offset;
    localObject = i.aR(this.path, this.offset, i);
    if ((localObject == null) || (localObject.length <= 0))
    {
      AppMethodBeat.o(95673);
      return false;
    }
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = new SKBuiltinBuffer_t();
    localSKBuiltinBuffer_t.setBuffer((byte[])localObject);
    this.wFX.CCV = localSKBuiltinBuffer_t;
    this.wFX.uKR = this.offset;
    AppMethodBeat.o(95673);
    return true;
  }
  
  private void onError()
  {
    AppMethodBeat.i(95677);
    t localt = af.dtj().ti(this.dzf);
    localt.offset = 0;
    try
    {
      bpl localbpl = (bpl)new bpl().parseFrom(localt.xjn);
      localbpl.DNN = "";
      localt.xjn = localbpl.toByteArray();
      af.dtj().a(this.dzf, localt);
      af.dtt().Mk(this.dzf);
      AppMethodBeat.o(95677);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneMMSnsUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
      AppMethodBeat.o(95677);
    }
  }
  
  final void Mf(int paramInt)
  {
    AppMethodBeat.i(95676);
    t localt = af.dtj().ti(this.dzf);
    try
    {
      bpl localbpl = (bpl)new bpl().parseFrom(localt.xjn);
      localbpl.DJF = 1;
      localbpl.DNw = paramInt;
      localt.xjn = localbpl.toByteArray();
      label54:
      af.dtt().Mk(this.dzf);
      af.dtj().a(this.dzf, localt);
      AppMethodBeat.o(95676);
      return;
    }
    catch (Exception localException)
    {
      break label54;
    }
  }
  
  public final boolean a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(95675);
    t localt = af.dtj().ti(this.dzf);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneMMSnsUpload", "upload ok " + paramString1 + "  " + paramString3 + "  " + paramInt1 + " thumbUrl: " + paramString2);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    com.tencent.mm.sdk.platformtools.f.decodeFile(this.path, localOptions);
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
      long l = i.aMN(this.path);
      d.a(paramString1, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, i, l);
      localt.xjm = paramString3;
      try
      {
        paramString3 = (bpl)new bpl().parseFrom(localt.xjn);
        localObject = paramString3;
        if (paramString3 == null) {
          localObject = new bpl();
        }
        paramString3 = new bpd();
        paramString3.mBH = paramInt1;
        paramString3.Url = paramString1;
        ((bpl)localObject).DNK = paramString3;
        ((bpl)localObject).DJF = 0;
        ((bpl)localObject).md5 = paramString4;
        if (!bt.isNullOrNil(paramString2))
        {
          paramString1 = new bpd();
          paramString1.mBH = paramInt2;
          paramString1.Url = paramString2;
          ((bpl)localObject).DNM.add(paramString1);
        }
      }
      catch (Exception paramString3)
      {
        try
        {
          localt.xjn = ((bpl)localObject).toByteArray();
          localt.dyx();
          af.dtj().a(this.dzf, localt);
          af.dtt().Mk(this.dzf);
          if (af.dtq() != null) {
            af.dtq().drS();
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
            com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.NetSceneMMSnsUpload", paramString1, "", new Object[0]);
          }
        }
      }
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(95678);
    super.cancel();
    if ((this.wGa) && (!bt.isNullOrNil(this.hhN)))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneMMSnsUpload", "cancel by cdn " + this.hhN);
      com.tencent.mm.ao.f.awL().xK(this.hhN);
    }
    AppMethodBeat.o(95678);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    int i = 108;
    AppMethodBeat.i(95679);
    this.callback = paramg;
    if (this.wGa)
    {
      this.hhN = this.wFX.gKn;
      if (bt.isNullOrNil(this.hhN))
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.NetSceneMMSnsUpload", "cdntra genClientId failed not use cdn");
        AppMethodBeat.o(95679);
        return 0;
      }
      parame = new com.tencent.mm.i.g();
      parame.fnH = this.hhW;
      parame.field_mediaId = this.hhN;
      parame.field_fullpath = this.path;
      parame.field_thumbpath = "";
      parame.field_fileType = a.MediaType_FRIENDS;
      parame.field_talker = "";
      parame.field_priority = a.fmV;
      parame.field_needStorage = true;
      parame.field_isStreamMedia = false;
      if (u.dyz())
      {
        if (this.wGc) {}
        for (i = 114;; i = 113)
        {
          parame.field_appType = i;
          parame.field_bzScene = 1;
          if (com.tencent.mm.ao.f.awL().e(parame)) {
            break;
          }
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneMMSnsUpload", "cdntra addSendTask failed. clientid:%s", new Object[] { this.hhN });
          this.hhN = "";
          break;
        }
      }
      if (u.dyA())
      {
        if (this.wGc) {}
        for (;;)
        {
          parame.field_appType = i;
          break;
          i = 107;
        }
      }
      if (u.dyy())
      {
        if (this.wGc) {}
        for (;;)
        {
          parame.field_appType = i;
          break;
          i = 107;
        }
      }
      com.tencent.mm.ao.f.awL();
      if (com.tencent.mm.ao.b.nL(64))
      {
        if (this.wGc) {}
        for (i = 104;; i = 103)
        {
          parame.field_appType = i;
          break;
        }
      }
      if (this.wGc) {}
      for (i = 101;; i = 100)
      {
        parame.field_appType = i;
        break;
      }
    }
    i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(95679);
    return i;
  }
  
  public final int getType()
  {
    return 207;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95674);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneMMSnsUpload", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramq = (cwf)((com.tencent.mm.al.b)paramq).gUT.gUX;
    if (paramInt2 == 4)
    {
      Mf(paramInt3);
      if (this.wGd == 21) {
        com.tencent.mm.plugin.sns.lucky.a.b.lI(12);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95674);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      onError();
      if (this.wGd == 21) {
        com.tencent.mm.plugin.sns.lucky.a.b.lI(13);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95674);
      return;
    }
    paramArrayOfByte = af.dtj().ti(this.dzf);
    if ((paramq.uKR < 0) || ((paramq.uKR > paramArrayOfByte.xji) && (paramArrayOfByte.xji > 0)))
    {
      onError();
      if (paramInt2 == 3) {
        com.tencent.mm.plugin.sns.lucky.a.b.lI(14);
      }
      AppMethodBeat.o(95674);
      return;
    }
    if (paramq.uKR < paramArrayOfByte.offset)
    {
      onError();
      if (paramInt2 == 3) {
        com.tencent.mm.plugin.sns.lucky.a.b.lI(14);
      }
      AppMethodBeat.o(95674);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneMMSnsUpload", " bufferUrl: " + paramq.Eoa.Url + " bufferUrlType: " + paramq.Eoa.mBH + "  id:" + paramq.Id + " thumb Count: " + paramq.DNL + "  type " + paramq.mBH + " startPos : " + paramq.uKR);
    paramArrayOfByte.offset = paramq.uKR;
    af.dtj().a(this.dzf, paramArrayOfByte);
    if ((paramArrayOfByte.offset == paramArrayOfByte.xji) && (paramArrayOfByte.xji != 0))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label621;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneMMSnsUpload", "uploadsns done pass: " + (System.currentTimeMillis() - this.hZo));
      if ((paramq.DNM.size() == 0) || (paramq.DNM.size() <= 0)) {
        break label569;
      }
      a(paramq.Eoa.Url, paramq.Eoa.mBH, ((cul)paramq.DNM.get(0)).Url, ((cul)paramq.DNM.get(0)).mBH, paramq.Id, this.wFX.MD5);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95674);
      return;
      paramInt1 = 0;
      break;
      label569:
      a(paramq.Eoa.Url, paramq.Eoa.mBH, "", 0, paramq.Id, this.wFX.MD5);
    }
    label621:
    if ((dsT()) && (doScene(dispatcher(), this.callback) < 0)) {
      this.callback.onSceneEnd(3, -1, "doScene failed", this);
    }
    AppMethodBeat.o(95674);
  }
  
  public final int securityLimitCount()
  {
    if (this.wFZ) {
      return 675;
    }
    return 100;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.gVB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.y
 * JD-Core Version:    0.7.0.1
 */