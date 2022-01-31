package com.tencent.mm.plugin.sns.model;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.i.a;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bcp;
import com.tencent.mm.protocal.protobuf.bcv;
import com.tencent.mm.protocal.protobuf.cdp;
import com.tencent.mm.protocal.protobuf.cfh;
import com.tencent.mm.protocal.protobuf.cfi;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class z
  extends m
  implements k
{
  private int cIp;
  public com.tencent.mm.ai.f callback;
  private int fFI;
  public String fFo;
  int fFp;
  private g.a fFy;
  private int fsd;
  private int offset;
  private String path;
  private boolean rfA;
  private boolean rfB;
  long rfC;
  int rfD;
  private String rfw;
  private cfh rfx;
  private String rfy;
  private boolean rfz;
  private com.tencent.mm.ai.b rr;
  long startTime;
  
  /* Error */
  public z(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 40	com/tencent/mm/ai/m:<init>	()V
    //   4: ldc 41
    //   6: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: sipush 8192
    //   13: putfield 49	com/tencent/mm/plugin/sns/model/z:fFI	I
    //   16: aload_0
    //   17: iconst_0
    //   18: putfield 51	com/tencent/mm/plugin/sns/model/z:offset	I
    //   21: aload_0
    //   22: ldc 53
    //   24: putfield 55	com/tencent/mm/plugin/sns/model/z:path	Ljava/lang/String;
    //   27: aload_0
    //   28: ldc 53
    //   30: putfield 57	com/tencent/mm/plugin/sns/model/z:rfw	Ljava/lang/String;
    //   33: aload_0
    //   34: iconst_0
    //   35: putfield 59	com/tencent/mm/plugin/sns/model/z:cIp	I
    //   38: aload_0
    //   39: ldc 53
    //   41: putfield 61	com/tencent/mm/plugin/sns/model/z:rfy	Ljava/lang/String;
    //   44: aload_0
    //   45: ldc 53
    //   47: putfield 63	com/tencent/mm/plugin/sns/model/z:fFo	Ljava/lang/String;
    //   50: aload_0
    //   51: iconst_0
    //   52: putfield 65	com/tencent/mm/plugin/sns/model/z:rfz	Z
    //   55: aload_0
    //   56: iconst_0
    //   57: putfield 67	com/tencent/mm/plugin/sns/model/z:rfA	Z
    //   60: aload_0
    //   61: iconst_0
    //   62: putfield 69	com/tencent/mm/plugin/sns/model/z:rfB	Z
    //   65: aload_0
    //   66: lconst_0
    //   67: putfield 71	com/tencent/mm/plugin/sns/model/z:rfC	J
    //   70: aload_0
    //   71: lconst_0
    //   72: putfield 73	com/tencent/mm/plugin/sns/model/z:startTime	J
    //   75: aload_0
    //   76: iconst_0
    //   77: putfield 75	com/tencent/mm/plugin/sns/model/z:fFp	I
    //   80: aload_0
    //   81: iconst_0
    //   82: putfield 77	com/tencent/mm/plugin/sns/model/z:rfD	I
    //   85: aload_0
    //   86: new 79	com/tencent/mm/plugin/sns/model/z$1
    //   89: dup
    //   90: aload_0
    //   91: invokespecial 82	com/tencent/mm/plugin/sns/model/z$1:<init>	(Lcom/tencent/mm/plugin/sns/model/z;)V
    //   94: putfield 84	com/tencent/mm/plugin/sns/model/z:fFy	Lcom/tencent/mm/i/g$a;
    //   97: aload_0
    //   98: invokestatic 90	java/lang/System:currentTimeMillis	()J
    //   101: putfield 71	com/tencent/mm/plugin/sns/model/z:rfC	J
    //   104: aload_0
    //   105: iload_1
    //   106: putfield 59	com/tencent/mm/plugin/sns/model/z:cIp	I
    //   109: aload_0
    //   110: aload_2
    //   111: putfield 61	com/tencent/mm/plugin/sns/model/z:rfy	Ljava/lang/String;
    //   114: aload_0
    //   115: iload 4
    //   117: putfield 77	com/tencent/mm/plugin/sns/model/z:rfD	I
    //   120: new 92	com/tencent/mm/ai/b$a
    //   123: dup
    //   124: invokespecial 93	com/tencent/mm/ai/b$a:<init>	()V
    //   127: astore_2
    //   128: aload_2
    //   129: new 95	com/tencent/mm/protocal/protobuf/cfh
    //   132: dup
    //   133: invokespecial 96	com/tencent/mm/protocal/protobuf/cfh:<init>	()V
    //   136: putfield 100	com/tencent/mm/ai/b$a:fsX	Lcom/tencent/mm/bv/a;
    //   139: aload_2
    //   140: new 102	com/tencent/mm/protocal/protobuf/cfi
    //   143: dup
    //   144: invokespecial 103	com/tencent/mm/protocal/protobuf/cfi:<init>	()V
    //   147: putfield 106	com/tencent/mm/ai/b$a:fsY	Lcom/tencent/mm/bv/a;
    //   150: aload_2
    //   151: ldc 108
    //   153: putfield 111	com/tencent/mm/ai/b$a:uri	Ljava/lang/String;
    //   156: aload_2
    //   157: sipush 207
    //   160: putfield 114	com/tencent/mm/ai/b$a:funcId	I
    //   163: aload_2
    //   164: bipush 95
    //   166: putfield 117	com/tencent/mm/ai/b$a:reqCmdId	I
    //   169: aload_2
    //   170: ldc 118
    //   172: putfield 121	com/tencent/mm/ai/b$a:respCmdId	I
    //   175: aload_0
    //   176: aload_2
    //   177: invokevirtual 125	com/tencent/mm/ai/b$a:ado	()Lcom/tencent/mm/ai/b;
    //   180: putfield 127	com/tencent/mm/plugin/sns/model/z:rr	Lcom/tencent/mm/ai/b;
    //   183: aload_0
    //   184: aload_0
    //   185: getfield 127	com/tencent/mm/plugin/sns/model/z:rr	Lcom/tencent/mm/ai/b;
    //   188: getfield 133	com/tencent/mm/ai/b:fsV	Lcom/tencent/mm/ai/b$b;
    //   191: getfield 138	com/tencent/mm/ai/b$b:fta	Lcom/tencent/mm/bv/a;
    //   194: checkcast 95	com/tencent/mm/protocal/protobuf/cfh
    //   197: putfield 140	com/tencent/mm/plugin/sns/model/z:rfx	Lcom/tencent/mm/protocal/protobuf/cfh;
    //   200: invokestatic 146	com/tencent/mm/plugin/sns/model/ag:coU	()Lcom/tencent/mm/plugin/sns/storage/s;
    //   203: iload_1
    //   204: i2l
    //   205: invokevirtual 152	com/tencent/mm/plugin/sns/storage/s:ma	(J)Lcom/tencent/mm/plugin/sns/storage/r;
    //   208: astore 7
    //   210: aload_0
    //   211: iload_3
    //   212: putfield 69	com/tencent/mm/plugin/sns/model/z:rfB	Z
    //   215: ldc 154
    //   217: new 156	java/lang/StringBuilder
    //   220: dup
    //   221: ldc 158
    //   223: invokespecial 161	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   226: iload_1
    //   227: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   230: ldc 167
    //   232: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: aload 7
    //   237: getfield 173	com/tencent/mm/plugin/sns/storage/r:offset	I
    //   240: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   243: ldc 175
    //   245: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: aload 7
    //   250: getfield 178	com/tencent/mm/plugin/sns/storage/r:rDC	Ljava/lang/String;
    //   253: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: ldc 180
    //   258: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload 7
    //   263: getfield 183	com/tencent/mm/plugin/sns/storage/r:rDB	I
    //   266: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   269: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokestatic 192	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   275: iload_3
    //   276: ifne +18 -> 294
    //   279: aload_0
    //   280: getfield 140	com/tencent/mm/plugin/sns/model/z:rfx	Lcom/tencent/mm/protocal/protobuf/cfh;
    //   283: iconst_1
    //   284: putfield 195	com/tencent/mm/protocal/protobuf/cfh:ExtFlag	I
    //   287: ldc 154
    //   289: ldc 197
    //   291: invokestatic 192	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   294: new 199	com/tencent/mm/protocal/protobuf/bcv
    //   297: dup
    //   298: invokespecial 200	com/tencent/mm/protocal/protobuf/bcv:<init>	()V
    //   301: aload 7
    //   303: getfield 204	com/tencent/mm/plugin/sns/storage/r:rDG	[B
    //   306: invokevirtual 208	com/tencent/mm/protocal/protobuf/bcv:parseFrom	([B)Lcom/tencent/mm/bv/a;
    //   309: checkcast 199	com/tencent/mm/protocal/protobuf/bcv
    //   312: astore 6
    //   314: aload_0
    //   315: aload 7
    //   317: getfield 178	com/tencent/mm/plugin/sns/storage/r:rDC	Ljava/lang/String;
    //   320: invokestatic 214	com/tencent/mm/plugin/sns/data/i:ZB	(Ljava/lang/String;)Ljava/lang/String;
    //   323: putfield 57	com/tencent/mm/plugin/sns/model/z:rfw	Ljava/lang/String;
    //   326: aload_0
    //   327: new 156	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   334: invokestatic 218	com/tencent/mm/plugin/sns/model/ag:getAccSnsPath	()Ljava/lang/String;
    //   337: aload 7
    //   339: getfield 178	com/tencent/mm/plugin/sns/storage/r:rDC	Ljava/lang/String;
    //   342: invokestatic 224	com/tencent/mm/plugin/sns/model/ao:gl	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   345: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: aload_0
    //   349: getfield 57	com/tencent/mm/plugin/sns/model/z:rfw	Ljava/lang/String;
    //   352: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: putfield 55	com/tencent/mm/plugin/sns/model/z:path	Ljava/lang/String;
    //   361: aload_0
    //   362: aload_0
    //   363: getfield 55	com/tencent/mm/plugin/sns/model/z:path	Ljava/lang/String;
    //   366: invokestatic 230	com/tencent/mm/vfs/e:avI	(Ljava/lang/String;)J
    //   369: l2i
    //   370: putfield 232	com/tencent/mm/plugin/sns/model/z:fsd	I
    //   373: aload_0
    //   374: aload_0
    //   375: getfield 55	com/tencent/mm/plugin/sns/model/z:path	Ljava/lang/String;
    //   378: invokestatic 236	com/tencent/mm/plugin/sns/data/i:ZL	(Ljava/lang/String;)Z
    //   381: putfield 65	com/tencent/mm/plugin/sns/model/z:rfz	Z
    //   384: ldc 154
    //   386: new 156	java/lang/StringBuilder
    //   389: dup
    //   390: ldc 238
    //   392: invokespecial 161	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   395: aload_0
    //   396: getfield 232	com/tencent/mm/plugin/sns/model/z:fsd	I
    //   399: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   402: ldc 240
    //   404: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: aload_0
    //   408: getfield 65	com/tencent/mm/plugin/sns/model/z:rfz	Z
    //   411: invokevirtual 243	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   414: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: invokestatic 192	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   420: aload 6
    //   422: getfield 246	com/tencent/mm/protocal/protobuf/bcv:xsN	Ljava/lang/String;
    //   425: astore 5
    //   427: aload 5
    //   429: astore_2
    //   430: aload 5
    //   432: invokestatic 251	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   435: ifeq +56 -> 491
    //   438: new 156	java/lang/StringBuilder
    //   441: dup
    //   442: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   445: invokestatic 254	com/tencent/mm/sdk/platformtools/bo:yB	()J
    //   448: invokevirtual 257	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   451: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   454: invokevirtual 263	java/lang/String:getBytes	()[B
    //   457: invokestatic 269	com/tencent/mm/a/g:w	([B)Ljava/lang/String;
    //   460: astore_2
    //   461: aload 6
    //   463: aload_2
    //   464: putfield 246	com/tencent/mm/protocal/protobuf/bcv:xsN	Ljava/lang/String;
    //   467: aload 7
    //   469: aload 6
    //   471: invokevirtual 272	com/tencent/mm/protocal/protobuf/bcv:toByteArray	()[B
    //   474: putfield 204	com/tencent/mm/plugin/sns/storage/r:rDG	[B
    //   477: invokestatic 146	com/tencent/mm/plugin/sns/model/ag:coU	()Lcom/tencent/mm/plugin/sns/storage/s;
    //   480: aload 7
    //   482: getfield 275	com/tencent/mm/plugin/sns/storage/r:rCV	I
    //   485: aload 7
    //   487: invokevirtual 279	com/tencent/mm/plugin/sns/storage/s:a	(ILcom/tencent/mm/plugin/sns/storage/r;)I
    //   490: pop
    //   491: aload_0
    //   492: getfield 140	com/tencent/mm/plugin/sns/model/z:rfx	Lcom/tencent/mm/protocal/protobuf/cfh;
    //   495: aload_0
    //   496: getfield 232	com/tencent/mm/plugin/sns/model/z:fsd	I
    //   499: putfield 282	com/tencent/mm/protocal/protobuf/cfh:pIx	I
    //   502: aload_0
    //   503: getfield 140	com/tencent/mm/plugin/sns/model/z:rfx	Lcom/tencent/mm/protocal/protobuf/cfh;
    //   506: aload 7
    //   508: getfield 173	com/tencent/mm/plugin/sns/storage/r:offset	I
    //   511: putfield 285	com/tencent/mm/protocal/protobuf/cfh:pIy	I
    //   514: aload_0
    //   515: getfield 140	com/tencent/mm/plugin/sns/model/z:rfx	Lcom/tencent/mm/protocal/protobuf/cfh;
    //   518: aload_2
    //   519: putfield 288	com/tencent/mm/protocal/protobuf/cfh:pIw	Ljava/lang/String;
    //   522: aload_0
    //   523: aload_2
    //   524: putfield 63	com/tencent/mm/plugin/sns/model/z:fFo	Ljava/lang/String;
    //   527: ldc 154
    //   529: new 156	java/lang/StringBuilder
    //   532: dup
    //   533: ldc_w 290
    //   536: invokespecial 161	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   539: aload 6
    //   541: getfield 293	com/tencent/mm/protocal/protobuf/bcv:xso	I
    //   544: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   547: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   550: invokestatic 296	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   553: aload_0
    //   554: getfield 140	com/tencent/mm/plugin/sns/model/z:rfx	Lcom/tencent/mm/protocal/protobuf/cfh;
    //   557: aload 6
    //   559: getfield 293	com/tencent/mm/protocal/protobuf/bcv:xso	I
    //   562: putfield 297	com/tencent/mm/protocal/protobuf/cfh:xso	I
    //   565: ldc 154
    //   567: new 156	java/lang/StringBuilder
    //   570: dup
    //   571: ldc_w 299
    //   574: invokespecial 161	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   577: aload 6
    //   579: getfield 302	com/tencent/mm/protocal/protobuf/bcv:xsp	I
    //   582: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   585: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   588: invokestatic 296	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   591: aload_0
    //   592: getfield 140	com/tencent/mm/plugin/sns/model/z:rfx	Lcom/tencent/mm/protocal/protobuf/cfh;
    //   595: new 156	java/lang/StringBuilder
    //   598: dup
    //   599: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   602: aload 6
    //   604: getfield 305	com/tencent/mm/protocal/protobuf/bcv:Desc	Ljava/lang/String;
    //   607: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   613: putfield 308	com/tencent/mm/protocal/protobuf/cfh:woO	Ljava/lang/String;
    //   616: aload_0
    //   617: getfield 140	com/tencent/mm/plugin/sns/model/z:rfx	Lcom/tencent/mm/protocal/protobuf/cfh;
    //   620: aload 6
    //   622: getfield 302	com/tencent/mm/protocal/protobuf/bcv:xsp	I
    //   625: putfield 309	com/tencent/mm/protocal/protobuf/cfh:xsp	I
    //   628: ldc 154
    //   630: new 156	java/lang/StringBuilder
    //   633: dup
    //   634: ldc_w 311
    //   637: invokespecial 161	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   640: aload 7
    //   642: getfield 314	com/tencent/mm/plugin/sns/storage/r:type	I
    //   645: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   648: ldc_w 316
    //   651: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: aload 6
    //   656: getfield 319	com/tencent/mm/protocal/protobuf/bcv:cqq	Ljava/lang/String;
    //   659: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: ldc_w 321
    //   665: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: aload 6
    //   670: getfield 324	com/tencent/mm/protocal/protobuf/bcv:cwc	Ljava/lang/String;
    //   673: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: ldc_w 326
    //   679: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: aload 6
    //   684: getfield 329	com/tencent/mm/protocal/protobuf/bcv:ayi	I
    //   687: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   690: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   693: invokestatic 192	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   696: aload_0
    //   697: getfield 140	com/tencent/mm/plugin/sns/model/z:rfx	Lcom/tencent/mm/protocal/protobuf/cfh;
    //   700: aload 7
    //   702: getfield 314	com/tencent/mm/plugin/sns/storage/r:type	I
    //   705: putfield 332	com/tencent/mm/protocal/protobuf/cfh:jKs	I
    //   708: new 334	com/tencent/mm/protocal/protobuf/clw
    //   711: dup
    //   712: invokespecial 335	com/tencent/mm/protocal/protobuf/clw:<init>	()V
    //   715: astore_2
    //   716: aload_2
    //   717: aload 6
    //   719: getfield 338	com/tencent/mm/protocal/protobuf/bcv:token	Ljava/lang/String;
    //   722: putfield 341	com/tencent/mm/protocal/protobuf/clw:xVS	Ljava/lang/String;
    //   725: aload_2
    //   726: aload 6
    //   728: getfield 344	com/tencent/mm/protocal/protobuf/bcv:xsy	Ljava/lang/String;
    //   731: putfield 347	com/tencent/mm/protocal/protobuf/clw:xVT	Ljava/lang/String;
    //   734: aload_0
    //   735: getfield 140	com/tencent/mm/plugin/sns/model/z:rfx	Lcom/tencent/mm/protocal/protobuf/cfh;
    //   738: aload_2
    //   739: putfield 351	com/tencent/mm/protocal/protobuf/cfh:xBi	Lcom/tencent/mm/protocal/protobuf/clw;
    //   742: aload 6
    //   744: getfield 319	com/tencent/mm/protocal/protobuf/bcv:cqq	Ljava/lang/String;
    //   747: invokestatic 251	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   750: ifne +15 -> 765
    //   753: aload_0
    //   754: getfield 140	com/tencent/mm/plugin/sns/model/z:rfx	Lcom/tencent/mm/protocal/protobuf/cfh;
    //   757: aload 6
    //   759: getfield 319	com/tencent/mm/protocal/protobuf/bcv:cqq	Ljava/lang/String;
    //   762: putfield 354	com/tencent/mm/protocal/protobuf/cfh:wQr	Ljava/lang/String;
    //   765: aload 6
    //   767: getfield 324	com/tencent/mm/protocal/protobuf/bcv:cwc	Ljava/lang/String;
    //   770: invokestatic 251	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   773: ifne +15 -> 788
    //   776: aload_0
    //   777: getfield 140	com/tencent/mm/plugin/sns/model/z:rfx	Lcom/tencent/mm/protocal/protobuf/cfh;
    //   780: aload 6
    //   782: getfield 324	com/tencent/mm/protocal/protobuf/bcv:cwc	Ljava/lang/String;
    //   785: putfield 357	com/tencent/mm/protocal/protobuf/cfh:fKw	Ljava/lang/String;
    //   788: aload_0
    //   789: getfield 140	com/tencent/mm/plugin/sns/model/z:rfx	Lcom/tencent/mm/protocal/protobuf/cfh;
    //   792: aload 6
    //   794: getfield 329	com/tencent/mm/protocal/protobuf/bcv:ayi	I
    //   797: putfield 360	com/tencent/mm/protocal/protobuf/cfh:xPL	I
    //   800: getstatic 365	com/tencent/mm/platformtools/ae:gkn	Z
    //   803: ifeq +11 -> 814
    //   806: aload_0
    //   807: getfield 140	com/tencent/mm/plugin/sns/model/z:rfx	Lcom/tencent/mm/protocal/protobuf/cfh;
    //   810: iconst_0
    //   811: putfield 332	com/tencent/mm/protocal/protobuf/cfh:jKs	I
    //   814: aload_0
    //   815: getfield 73	com/tencent/mm/plugin/sns/model/z:startTime	J
    //   818: lconst_0
    //   819: lcmp
    //   820: ifne +17 -> 837
    //   823: aload_0
    //   824: invokestatic 368	com/tencent/mm/sdk/platformtools/bo:aoy	()J
    //   827: putfield 73	com/tencent/mm/plugin/sns/model/z:startTime	J
    //   830: aload_0
    //   831: getstatic 373	com/tencent/mm/i/a:MediaType_FRIENDS	I
    //   834: putfield 75	com/tencent/mm/plugin/sns/model/z:fFp	I
    //   837: aload_0
    //   838: getfield 140	com/tencent/mm/plugin/sns/model/z:rfx	Lcom/tencent/mm/protocal/protobuf/cfh;
    //   841: astore_2
    //   842: invokestatic 379	com/tencent/mm/al/f:afO	()Lcom/tencent/mm/al/b;
    //   845: pop
    //   846: bipush 32
    //   848: invokestatic 385	com/tencent/mm/al/b:lc	(I)Z
    //   851: ifne +80 -> 931
    //   854: invokestatic 379	com/tencent/mm/al/f:afO	()Lcom/tencent/mm/al/b;
    //   857: pop
    //   858: ldc 154
    //   860: ldc_w 387
    //   863: iconst_1
    //   864: anewarray 389	java/lang/Object
    //   867: dup
    //   868: iconst_0
    //   869: bipush 32
    //   871: invokestatic 385	com/tencent/mm/al/b:lc	(I)Z
    //   874: invokestatic 395	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   877: aastore
    //   878: invokestatic 398	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   881: iconst_0
    //   882: istore_1
    //   883: iload_1
    //   884: ifeq +95 -> 979
    //   887: aload_0
    //   888: iconst_1
    //   889: putfield 67	com/tencent/mm/plugin/sns/model/z:rfA	Z
    //   892: ldc 41
    //   894: invokestatic 401	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   897: return
    //   898: astore_2
    //   899: ldc 154
    //   901: ldc_w 403
    //   904: invokestatic 406	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   907: ldc 41
    //   909: invokestatic 401	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   912: return
    //   913: astore 5
    //   915: ldc 154
    //   917: aload 5
    //   919: ldc 53
    //   921: iconst_0
    //   922: anewarray 389	java/lang/Object
    //   925: invokestatic 410	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   928: goto -437 -> 491
    //   931: getstatic 413	com/tencent/mm/platformtools/ae:glc	I
    //   934: iconst_2
    //   935: if_icmpne +8 -> 943
    //   938: iconst_0
    //   939: istore_1
    //   940: goto -57 -> 883
    //   943: aload_0
    //   944: aload_2
    //   945: getfield 288	com/tencent/mm/protocal/protobuf/cfh:pIw	Ljava/lang/String;
    //   948: putfield 63	com/tencent/mm/plugin/sns/model/z:fFo	Ljava/lang/String;
    //   951: aload_0
    //   952: getfield 63	com/tencent/mm/plugin/sns/model/z:fFo	Ljava/lang/String;
    //   955: invokestatic 251	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   958: ifeq +16 -> 974
    //   961: ldc 154
    //   963: ldc_w 415
    //   966: invokestatic 417	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   969: iconst_0
    //   970: istore_1
    //   971: goto -88 -> 883
    //   974: iconst_1
    //   975: istore_1
    //   976: goto -93 -> 883
    //   979: aload_0
    //   980: invokespecial 421	com/tencent/mm/plugin/sns/model/z:coE	()Z
    //   983: ifne +7 -> 990
    //   986: aload_0
    //   987: invokespecial 424	com/tencent/mm/plugin/sns/model/z:onError	()V
    //   990: ldc 41
    //   992: invokestatic 401	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   995: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	996	0	this	z
    //   0	996	1	paramInt1	int
    //   0	996	2	paramString	String
    //   0	996	3	paramBoolean	boolean
    //   0	996	4	paramInt2	int
    //   425	6	5	str	String
    //   913	5	5	localException	Exception
    //   312	481	6	localbcv	bcv
    //   208	493	7	localr	r
    // Exception table:
    //   from	to	target	type
    //   294	314	898	java/lang/Exception
    //   467	491	913	java/lang/Exception
  }
  
  private boolean coE()
  {
    AppMethodBeat.i(36347);
    Object localObject = ag.coU().ma(this.cIp);
    int j = ((r)localObject).rDB - ((r)localObject).offset;
    int i = j;
    if (j > this.fFI) {
      i = this.fFI;
    }
    this.offset = ((r)localObject).offset;
    localObject = com.tencent.mm.vfs.e.i(this.path, this.offset, i);
    if ((localObject == null) || (localObject.length <= 0))
    {
      AppMethodBeat.o(36347);
      return false;
    }
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = new SKBuiltinBuffer_t();
    localSKBuiltinBuffer_t.setBuffer((byte[])localObject);
    this.rfx.wtq = localSKBuiltinBuffer_t;
    this.rfx.pIy = this.offset;
    AppMethodBeat.o(36347);
    return true;
  }
  
  private void onError()
  {
    AppMethodBeat.i(36351);
    r localr = ag.coU().ma(this.cIp);
    localr.offset = 0;
    try
    {
      bcv localbcv = (bcv)new bcv().parseFrom(localr.rDG);
      localbcv.xsN = "";
      localr.rDG = localbcv.toByteArray();
      ag.coU().a(this.cIp, localr);
      ag.cpe().DK(this.cIp);
      AppMethodBeat.o(36351);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.NetSceneMMSnsUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
      AppMethodBeat.o(36351);
    }
  }
  
  final void DF(int paramInt)
  {
    AppMethodBeat.i(36350);
    r localr = ag.coU().ma(this.cIp);
    try
    {
      bcv localbcv = (bcv)new bcv().parseFrom(localr.rDG);
      localbcv.nkT = 1;
      localbcv.xsx = paramInt;
      localr.rDG = localbcv.toByteArray();
      label54:
      ag.cpe().DK(this.cIp);
      ag.coU().a(this.cIp, localr);
      AppMethodBeat.o(36350);
      return;
    }
    catch (Exception localException)
    {
      break label54;
    }
  }
  
  public final boolean a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(36349);
    r localr = ag.coU().ma(this.cIp);
    ab.i("MicroMsg.NetSceneMMSnsUpload", "upload ok " + paramString1 + "  " + paramString3 + "  " + paramInt1 + " thumbUrl: " + paramString2);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    MMBitmapFactory.decodeFile(this.path, localOptions);
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
      long l = com.tencent.mm.vfs.e.avI(this.path);
      c.a(paramString1, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, i, l);
      localr.rDF = paramString3;
      try
      {
        paramString3 = (bcv)new bcv().parseFrom(localr.rDG);
        localObject = paramString3;
        if (paramString3 == null) {
          localObject = new bcv();
        }
        paramString3 = new bcp();
        paramString3.jKs = paramInt1;
        paramString3.Url = paramString1;
        ((bcv)localObject).xsK = paramString3;
        ((bcv)localObject).nkT = 0;
        ((bcv)localObject).cqq = paramString4;
        if (!bo.isNullOrNil(paramString2))
        {
          paramString1 = new bcp();
          paramString1.jKs = paramInt2;
          paramString1.Url = paramString2;
          ((bcv)localObject).xsM.add(paramString1);
        }
      }
      catch (Exception paramString3)
      {
        try
        {
          localr.rDG = ((bcv)localObject).toByteArray();
          localr.cte();
          ag.coU().a(this.cIp, localr);
          ag.cpe().DK(this.cIp);
          if (ag.cpb() != null) {
            ag.cpb().cnP();
          }
          AppMethodBeat.o(36349);
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
            ab.printErrStackTrace("MicroMsg.NetSceneMMSnsUpload", paramString1, "", new Object[0]);
          }
        }
      }
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(36352);
    super.cancel();
    if ((this.rfA) && (!bo.isNullOrNil(this.fFo)))
    {
      ab.i("MicroMsg.NetSceneMMSnsUpload", "cancel by cdn " + this.fFo);
      com.tencent.mm.al.f.afO().sI(this.fFo);
    }
    AppMethodBeat.o(36352);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    int i = 108;
    AppMethodBeat.i(36353);
    this.callback = paramf;
    if (this.rfA)
    {
      this.fFo = this.rfx.pIw;
      if (bo.isNullOrNil(this.fFo))
      {
        ab.w("MicroMsg.NetSceneMMSnsUpload", "cdntra genClientId failed not use cdn");
        AppMethodBeat.o(36353);
        return 0;
      }
      parame = new g();
      parame.edp = this.fFy;
      parame.field_mediaId = this.fFo;
      parame.field_fullpath = this.path;
      parame.field_thumbpath = "";
      parame.field_fileType = a.MediaType_FRIENDS;
      parame.field_talker = "";
      parame.field_priority = a.ecF;
      parame.field_needStorage = true;
      parame.field_isStreamMedia = false;
      if (s.ctg())
      {
        if (this.rfB) {}
        for (;;)
        {
          parame.field_appType = i;
          parame.field_bzScene = 1;
          if (com.tencent.mm.al.f.afO().e(parame)) {
            break;
          }
          ab.e("MicroMsg.NetSceneMMSnsUpload", "cdntra addSendTask failed. clientid:%s", new Object[] { this.fFo });
          this.fFo = "";
          break;
          i = 107;
        }
      }
      if (s.ctf())
      {
        if (this.rfB) {}
        for (;;)
        {
          parame.field_appType = i;
          break;
          i = 107;
        }
      }
      com.tencent.mm.al.f.afO();
      if (com.tencent.mm.al.b.lc(64))
      {
        if (this.rfB) {}
        for (i = 104;; i = 103)
        {
          parame.field_appType = i;
          break;
        }
      }
      if (this.rfB) {}
      for (i = 101;; i = 100)
      {
        parame.field_appType = i;
        break;
      }
    }
    i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(36353);
    return i;
  }
  
  public final int getType()
  {
    return 207;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(36348);
    ab.i("MicroMsg.NetSceneMMSnsUpload", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramq = (cfi)((com.tencent.mm.ai.b)paramq).fsW.fta;
    if (paramInt2 == 4)
    {
      DF(paramInt3);
      if (this.rfD == 21) {
        com.tencent.mm.plugin.sns.lucky.a.b.kS(12);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(36348);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      onError();
      if (this.rfD == 21) {
        com.tencent.mm.plugin.sns.lucky.a.b.kS(13);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(36348);
      return;
    }
    paramArrayOfByte = ag.coU().ma(this.cIp);
    if ((paramq.pIy < 0) || ((paramq.pIy > paramArrayOfByte.rDB) && (paramArrayOfByte.rDB > 0)))
    {
      onError();
      if (paramInt2 == 3) {
        com.tencent.mm.plugin.sns.lucky.a.b.kS(14);
      }
      AppMethodBeat.o(36348);
      return;
    }
    if (paramq.pIy < paramArrayOfByte.offset)
    {
      onError();
      if (paramInt2 == 3) {
        com.tencent.mm.plugin.sns.lucky.a.b.kS(14);
      }
      AppMethodBeat.o(36348);
      return;
    }
    ab.d("MicroMsg.NetSceneMMSnsUpload", " bufferUrl: " + paramq.xPM.Url + " bufferUrlType: " + paramq.xPM.jKs + "  id:" + paramq.Id + " thumb Count: " + paramq.xsL + "  type " + paramq.jKs + " startPos : " + paramq.pIy);
    paramArrayOfByte.offset = paramq.pIy;
    ag.coU().a(this.cIp, paramArrayOfByte);
    if ((paramArrayOfByte.offset == paramArrayOfByte.rDB) && (paramArrayOfByte.rDB != 0))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label621;
      }
      ab.i("MicroMsg.NetSceneMMSnsUpload", "uploadsns done pass: " + (System.currentTimeMillis() - this.rfC));
      if ((paramq.xsM.size() == 0) || (paramq.xsM.size() <= 0)) {
        break label569;
      }
      a(paramq.xPM.Url, paramq.xPM.jKs, ((cdp)paramq.xsM.get(0)).Url, ((cdp)paramq.xsM.get(0)).jKs, paramq.Id, this.rfx.wQr);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(36348);
      return;
      paramInt1 = 0;
      break;
      label569:
      a(paramq.xPM.Url, paramq.xPM.jKs, "", 0, paramq.Id, this.rfx.wQr);
    }
    label621:
    if ((coE()) && (doScene(dispatcher(), this.callback) < 0)) {
      this.callback.onSceneEnd(3, -1, "doScene failed", this);
    }
    AppMethodBeat.o(36348);
  }
  
  public final int securityLimitCount()
  {
    if (this.rfz) {
      return 675;
    }
    return 100;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.z
 * JD-Core Version:    0.7.0.1
 */