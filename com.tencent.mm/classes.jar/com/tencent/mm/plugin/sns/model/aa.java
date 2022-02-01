package com.tencent.mm.plugin.sns.model;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q.b;
import com.tencent.mm.aq.f;
import com.tencent.mm.f.b.a.ac;
import com.tencent.mm.f.b.a.ae;
import com.tencent.mm.i.g.a;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.sns.k.e;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.protocal.protobuf.cvo;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.ejl;
import com.tencent.mm.protocal.protobuf.elg;
import com.tencent.mm.protocal.protobuf.elh;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;
import java.util.LinkedList;

public final class aa
  extends com.tencent.mm.an.q
  implements m
{
  private String JWk;
  private elg JWl;
  private String JWm;
  private boolean JWn;
  private boolean JWo;
  private boolean JWp;
  private boolean JWq;
  private int JWr;
  public i callback;
  private int fWh;
  private int jGU;
  private int lAW;
  private int lPH;
  public String lPn;
  private g.a lPx;
  private long mJB;
  private int offset;
  private String path;
  private com.tencent.mm.an.d rr;
  private long startTime;
  
  /* Error */
  public aa(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 43	com/tencent/mm/an/q:<init>	()V
    //   4: ldc 44
    //   6: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: sipush 8192
    //   13: putfield 52	com/tencent/mm/plugin/sns/model/aa:lPH	I
    //   16: aload_0
    //   17: iconst_0
    //   18: putfield 54	com/tencent/mm/plugin/sns/model/aa:offset	I
    //   21: aload_0
    //   22: ldc 56
    //   24: putfield 58	com/tencent/mm/plugin/sns/model/aa:path	Ljava/lang/String;
    //   27: aload_0
    //   28: ldc 56
    //   30: putfield 60	com/tencent/mm/plugin/sns/model/aa:JWk	Ljava/lang/String;
    //   33: aload_0
    //   34: iconst_0
    //   35: putfield 62	com/tencent/mm/plugin/sns/model/aa:fWh	I
    //   38: aload_0
    //   39: ldc 56
    //   41: putfield 64	com/tencent/mm/plugin/sns/model/aa:JWm	Ljava/lang/String;
    //   44: aload_0
    //   45: ldc 56
    //   47: putfield 66	com/tencent/mm/plugin/sns/model/aa:lPn	Ljava/lang/String;
    //   50: aload_0
    //   51: iconst_0
    //   52: putfield 68	com/tencent/mm/plugin/sns/model/aa:JWn	Z
    //   55: aload_0
    //   56: iconst_0
    //   57: putfield 70	com/tencent/mm/plugin/sns/model/aa:JWo	Z
    //   60: aload_0
    //   61: iconst_0
    //   62: putfield 72	com/tencent/mm/plugin/sns/model/aa:JWp	Z
    //   65: aload_0
    //   66: iconst_0
    //   67: putfield 74	com/tencent/mm/plugin/sns/model/aa:JWq	Z
    //   70: aload_0
    //   71: lconst_0
    //   72: putfield 76	com/tencent/mm/plugin/sns/model/aa:mJB	J
    //   75: aload_0
    //   76: lconst_0
    //   77: putfield 78	com/tencent/mm/plugin/sns/model/aa:startTime	J
    //   80: aload_0
    //   81: iconst_0
    //   82: putfield 80	com/tencent/mm/plugin/sns/model/aa:jGU	I
    //   85: aload_0
    //   86: iconst_0
    //   87: putfield 82	com/tencent/mm/plugin/sns/model/aa:JWr	I
    //   90: aload_0
    //   91: new 8	com/tencent/mm/plugin/sns/model/aa$1
    //   94: dup
    //   95: aload_0
    //   96: invokespecial 85	com/tencent/mm/plugin/sns/model/aa$1:<init>	(Lcom/tencent/mm/plugin/sns/model/aa;)V
    //   99: putfield 87	com/tencent/mm/plugin/sns/model/aa:lPx	Lcom/tencent/mm/i/g$a;
    //   102: aload_0
    //   103: invokestatic 93	java/lang/System:currentTimeMillis	()J
    //   106: putfield 76	com/tencent/mm/plugin/sns/model/aa:mJB	J
    //   109: aload_0
    //   110: iload_1
    //   111: putfield 62	com/tencent/mm/plugin/sns/model/aa:fWh	I
    //   114: aload_0
    //   115: aload_2
    //   116: putfield 64	com/tencent/mm/plugin/sns/model/aa:JWm	Ljava/lang/String;
    //   119: aload_0
    //   120: iload 4
    //   122: putfield 82	com/tencent/mm/plugin/sns/model/aa:JWr	I
    //   125: new 95	com/tencent/mm/an/d$a
    //   128: dup
    //   129: invokespecial 96	com/tencent/mm/an/d$a:<init>	()V
    //   132: astore_2
    //   133: aload_2
    //   134: new 98	com/tencent/mm/protocal/protobuf/elg
    //   137: dup
    //   138: invokespecial 99	com/tencent/mm/protocal/protobuf/elg:<init>	()V
    //   141: putfield 103	com/tencent/mm/an/d$a:lBU	Lcom/tencent/mm/cd/a;
    //   144: aload_2
    //   145: new 105	com/tencent/mm/protocal/protobuf/elh
    //   148: dup
    //   149: invokespecial 106	com/tencent/mm/protocal/protobuf/elh:<init>	()V
    //   152: putfield 109	com/tencent/mm/an/d$a:lBV	Lcom/tencent/mm/cd/a;
    //   155: aload_2
    //   156: ldc 111
    //   158: putfield 114	com/tencent/mm/an/d$a:uri	Ljava/lang/String;
    //   161: aload_2
    //   162: sipush 207
    //   165: putfield 117	com/tencent/mm/an/d$a:funcId	I
    //   168: aload_2
    //   169: bipush 95
    //   171: putfield 120	com/tencent/mm/an/d$a:lBW	I
    //   174: aload_2
    //   175: ldc 121
    //   177: putfield 124	com/tencent/mm/an/d$a:respCmdId	I
    //   180: aload_0
    //   181: aload_2
    //   182: invokevirtual 128	com/tencent/mm/an/d$a:bgN	()Lcom/tencent/mm/an/d;
    //   185: putfield 130	com/tencent/mm/plugin/sns/model/aa:rr	Lcom/tencent/mm/an/d;
    //   188: aload_0
    //   189: aload_0
    //   190: getfield 130	com/tencent/mm/plugin/sns/model/aa:rr	Lcom/tencent/mm/an/d;
    //   193: getfield 136	com/tencent/mm/an/d:lBR	Lcom/tencent/mm/an/d$b;
    //   196: invokestatic 142	com/tencent/mm/an/d$b:b	(Lcom/tencent/mm/an/d$b;)Lcom/tencent/mm/cd/a;
    //   199: checkcast 98	com/tencent/mm/protocal/protobuf/elg
    //   202: putfield 144	com/tencent/mm/plugin/sns/model/aa:JWl	Lcom/tencent/mm/protocal/protobuf/elg;
    //   205: invokestatic 150	com/tencent/mm/plugin/sns/model/aj:fOx	()Lcom/tencent/mm/plugin/sns/storage/r;
    //   208: iload_1
    //   209: i2l
    //   210: invokevirtual 156	com/tencent/mm/plugin/sns/storage/r:Re	(J)Lcom/tencent/mm/plugin/sns/storage/q;
    //   213: astore 7
    //   215: aload_0
    //   216: iload_3
    //   217: putfield 74	com/tencent/mm/plugin/sns/model/aa:JWq	Z
    //   220: ldc 158
    //   222: new 160	java/lang/StringBuilder
    //   225: dup
    //   226: ldc 162
    //   228: invokespecial 165	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   231: iload_1
    //   232: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   235: ldc 171
    //   237: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload 7
    //   242: getfield 177	com/tencent/mm/plugin/sns/storage/q:offset	I
    //   245: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   248: ldc 179
    //   250: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: aload 7
    //   255: getfield 182	com/tencent/mm/plugin/sns/storage/q:KzW	Ljava/lang/String;
    //   258: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: ldc 184
    //   263: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload 7
    //   268: getfield 187	com/tencent/mm/plugin/sns/storage/q:KzV	I
    //   271: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   274: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   280: iload_3
    //   281: ifne +18 -> 299
    //   284: aload_0
    //   285: getfield 144	com/tencent/mm/plugin/sns/model/aa:JWl	Lcom/tencent/mm/protocal/protobuf/elg;
    //   288: iconst_1
    //   289: putfield 199	com/tencent/mm/protocal/protobuf/elg:ExtFlag	I
    //   292: ldc 158
    //   294: ldc 201
    //   296: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   299: new 203	com/tencent/mm/protocal/protobuf/cvw
    //   302: dup
    //   303: invokespecial 204	com/tencent/mm/protocal/protobuf/cvw:<init>	()V
    //   306: aload 7
    //   308: getfield 208	com/tencent/mm/plugin/sns/storage/q:KAa	[B
    //   311: invokevirtual 212	com/tencent/mm/protocal/protobuf/cvw:parseFrom	([B)Lcom/tencent/mm/cd/a;
    //   314: checkcast 203	com/tencent/mm/protocal/protobuf/cvw
    //   317: astore 6
    //   319: aload_0
    //   320: aload 7
    //   322: getfield 182	com/tencent/mm/plugin/sns/storage/q:KzW	Ljava/lang/String;
    //   325: invokestatic 218	com/tencent/mm/plugin/sns/data/t:aZf	(Ljava/lang/String;)Ljava/lang/String;
    //   328: putfield 60	com/tencent/mm/plugin/sns/model/aa:JWk	Ljava/lang/String;
    //   331: aload_0
    //   332: new 160	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   339: invokestatic 222	com/tencent/mm/plugin/sns/model/aj:getAccSnsPath	()Ljava/lang/String;
    //   342: aload 7
    //   344: getfield 182	com/tencent/mm/plugin/sns/storage/q:KzW	Ljava/lang/String;
    //   347: invokestatic 228	com/tencent/mm/plugin/sns/model/aq:kD	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   350: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: aload_0
    //   354: getfield 60	com/tencent/mm/plugin/sns/model/aa:JWk	Ljava/lang/String;
    //   357: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: putfield 58	com/tencent/mm/plugin/sns/model/aa:path	Ljava/lang/String;
    //   366: aload_0
    //   367: aload_0
    //   368: getfield 58	com/tencent/mm/plugin/sns/model/aa:path	Ljava/lang/String;
    //   371: invokestatic 234	com/tencent/mm/vfs/u:bBQ	(Ljava/lang/String;)J
    //   374: l2i
    //   375: putfield 236	com/tencent/mm/plugin/sns/model/aa:lAW	I
    //   378: aload_0
    //   379: aload_0
    //   380: getfield 58	com/tencent/mm/plugin/sns/model/aa:path	Ljava/lang/String;
    //   383: invokestatic 240	com/tencent/mm/plugin/sns/data/t:aZq	(Ljava/lang/String;)Z
    //   386: putfield 68	com/tencent/mm/plugin/sns/model/aa:JWn	Z
    //   389: ldc 158
    //   391: new 160	java/lang/StringBuilder
    //   394: dup
    //   395: ldc 242
    //   397: invokespecial 165	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   400: aload_0
    //   401: getfield 236	com/tencent/mm/plugin/sns/model/aa:lAW	I
    //   404: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   407: ldc 244
    //   409: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: aload_0
    //   413: getfield 68	com/tencent/mm/plugin/sns/model/aa:JWn	Z
    //   416: invokevirtual 247	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   419: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   425: aload 6
    //   427: getfield 250	com/tencent/mm/protocal/protobuf/cvw:TEA	Ljava/lang/String;
    //   430: astore 5
    //   432: aload 5
    //   434: astore_2
    //   435: aload 5
    //   437: invokestatic 255	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   440: ifeq +56 -> 496
    //   443: new 160	java/lang/StringBuilder
    //   446: dup
    //   447: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   450: invokestatic 258	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   453: invokevirtual 261	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   456: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: invokevirtual 267	java/lang/String:getBytes	()[B
    //   462: invokestatic 273	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   465: astore_2
    //   466: aload 6
    //   468: aload_2
    //   469: putfield 250	com/tencent/mm/protocal/protobuf/cvw:TEA	Ljava/lang/String;
    //   472: aload 7
    //   474: aload 6
    //   476: invokevirtual 276	com/tencent/mm/protocal/protobuf/cvw:toByteArray	()[B
    //   479: putfield 208	com/tencent/mm/plugin/sns/storage/q:KAa	[B
    //   482: invokestatic 150	com/tencent/mm/plugin/sns/model/aj:fOx	()Lcom/tencent/mm/plugin/sns/storage/r;
    //   485: aload 7
    //   487: getfield 279	com/tencent/mm/plugin/sns/storage/q:localid	I
    //   490: aload 7
    //   492: invokevirtual 283	com/tencent/mm/plugin/sns/storage/r:a	(ILcom/tencent/mm/plugin/sns/storage/q;)I
    //   495: pop
    //   496: aload_0
    //   497: getfield 144	com/tencent/mm/plugin/sns/model/aa:JWl	Lcom/tencent/mm/protocal/protobuf/elg;
    //   500: aload_0
    //   501: getfield 236	com/tencent/mm/plugin/sns/model/aa:lAW	I
    //   504: putfield 286	com/tencent/mm/protocal/protobuf/elg:HmZ	I
    //   507: aload_0
    //   508: getfield 144	com/tencent/mm/plugin/sns/model/aa:JWl	Lcom/tencent/mm/protocal/protobuf/elg;
    //   511: aload 7
    //   513: getfield 177	com/tencent/mm/plugin/sns/storage/q:offset	I
    //   516: putfield 289	com/tencent/mm/protocal/protobuf/elg:Hna	I
    //   519: aload_0
    //   520: getfield 144	com/tencent/mm/plugin/sns/model/aa:JWl	Lcom/tencent/mm/protocal/protobuf/elg;
    //   523: aload_2
    //   524: putfield 292	com/tencent/mm/protocal/protobuf/elg:lps	Ljava/lang/String;
    //   527: aload_0
    //   528: aload_2
    //   529: putfield 66	com/tencent/mm/plugin/sns/model/aa:lPn	Ljava/lang/String;
    //   532: ldc 158
    //   534: new 160	java/lang/StringBuilder
    //   537: dup
    //   538: ldc_w 294
    //   541: invokespecial 165	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   544: aload 6
    //   546: getfield 297	com/tencent/mm/protocal/protobuf/cvw:TEa	I
    //   549: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   552: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   555: invokestatic 300	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   558: aload_0
    //   559: getfield 144	com/tencent/mm/plugin/sns/model/aa:JWl	Lcom/tencent/mm/protocal/protobuf/elg;
    //   562: aload 6
    //   564: getfield 297	com/tencent/mm/protocal/protobuf/cvw:TEa	I
    //   567: putfield 301	com/tencent/mm/protocal/protobuf/elg:TEa	I
    //   570: ldc 158
    //   572: new 160	java/lang/StringBuilder
    //   575: dup
    //   576: ldc_w 303
    //   579: invokespecial 165	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   582: aload 6
    //   584: getfield 306	com/tencent/mm/protocal/protobuf/cvw:TEb	I
    //   587: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   590: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   593: invokestatic 300	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   596: aload_0
    //   597: getfield 144	com/tencent/mm/plugin/sns/model/aa:JWl	Lcom/tencent/mm/protocal/protobuf/elg;
    //   600: new 160	java/lang/StringBuilder
    //   603: dup
    //   604: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   607: aload 6
    //   609: getfield 309	com/tencent/mm/protocal/protobuf/cvw:CMB	Ljava/lang/String;
    //   612: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   618: putfield 312	com/tencent/mm/protocal/protobuf/elg:RIC	Ljava/lang/String;
    //   621: aload_0
    //   622: getfield 144	com/tencent/mm/plugin/sns/model/aa:JWl	Lcom/tencent/mm/protocal/protobuf/elg;
    //   625: aload 6
    //   627: getfield 306	com/tencent/mm/protocal/protobuf/cvw:TEb	I
    //   630: putfield 313	com/tencent/mm/protocal/protobuf/elg:TEb	I
    //   633: ldc 158
    //   635: new 160	java/lang/StringBuilder
    //   638: dup
    //   639: ldc_w 315
    //   642: invokespecial 165	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   645: aload 7
    //   647: getfield 318	com/tencent/mm/plugin/sns/storage/q:type	I
    //   650: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   653: ldc_w 320
    //   656: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: aload 6
    //   661: getfield 323	com/tencent/mm/protocal/protobuf/cvw:md5	Ljava/lang/String;
    //   664: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: ldc_w 325
    //   670: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: aload 6
    //   675: getfield 328	com/tencent/mm/protocal/protobuf/cvw:appid	Ljava/lang/String;
    //   678: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: ldc_w 330
    //   684: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: aload 6
    //   689: getfield 333	com/tencent/mm/protocal/protobuf/cvw:aOl	I
    //   692: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   695: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   698: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   701: aload_0
    //   702: getfield 144	com/tencent/mm/plugin/sns/model/aa:JWl	Lcom/tencent/mm/protocal/protobuf/elg;
    //   705: aload 7
    //   707: getfield 318	com/tencent/mm/plugin/sns/storage/q:type	I
    //   710: putfield 336	com/tencent/mm/protocal/protobuf/elg:rWu	I
    //   713: new 338	com/tencent/mm/protocal/protobuf/evb
    //   716: dup
    //   717: invokespecial 339	com/tencent/mm/protocal/protobuf/evb:<init>	()V
    //   720: astore_2
    //   721: aload_2
    //   722: aload 6
    //   724: getfield 342	com/tencent/mm/protocal/protobuf/cvw:token	Ljava/lang/String;
    //   727: putfield 345	com/tencent/mm/protocal/protobuf/evb:UwO	Ljava/lang/String;
    //   730: aload_2
    //   731: aload 6
    //   733: getfield 348	com/tencent/mm/protocal/protobuf/cvw:TEk	Ljava/lang/String;
    //   736: putfield 351	com/tencent/mm/protocal/protobuf/evb:UwP	Ljava/lang/String;
    //   739: aload_0
    //   740: getfield 144	com/tencent/mm/plugin/sns/model/aa:JWl	Lcom/tencent/mm/protocal/protobuf/elg;
    //   743: aload_2
    //   744: putfield 355	com/tencent/mm/protocal/protobuf/elg:TUs	Lcom/tencent/mm/protocal/protobuf/evb;
    //   747: aload 6
    //   749: getfield 323	com/tencent/mm/protocal/protobuf/cvw:md5	Ljava/lang/String;
    //   752: invokestatic 255	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   755: ifne +15 -> 770
    //   758: aload_0
    //   759: getfield 144	com/tencent/mm/plugin/sns/model/aa:JWl	Lcom/tencent/mm/protocal/protobuf/elg;
    //   762: aload 6
    //   764: getfield 323	com/tencent/mm/protocal/protobuf/cvw:md5	Ljava/lang/String;
    //   767: putfield 358	com/tencent/mm/protocal/protobuf/elg:MD5	Ljava/lang/String;
    //   770: aload 6
    //   772: getfield 328	com/tencent/mm/protocal/protobuf/cvw:appid	Ljava/lang/String;
    //   775: invokestatic 255	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   778: ifne +15 -> 793
    //   781: aload_0
    //   782: getfield 144	com/tencent/mm/plugin/sns/model/aa:JWl	Lcom/tencent/mm/protocal/protobuf/elg;
    //   785: aload 6
    //   787: getfield 328	com/tencent/mm/protocal/protobuf/cvw:appid	Ljava/lang/String;
    //   790: putfield 361	com/tencent/mm/protocal/protobuf/elg:lVG	Ljava/lang/String;
    //   793: aload_0
    //   794: getfield 144	com/tencent/mm/plugin/sns/model/aa:JWl	Lcom/tencent/mm/protocal/protobuf/elg;
    //   797: aload 6
    //   799: getfield 333	com/tencent/mm/protocal/protobuf/cvw:aOl	I
    //   802: putfield 364	com/tencent/mm/protocal/protobuf/elg:Unt	I
    //   805: getstatic 369	com/tencent/mm/platformtools/ac:mFn	Z
    //   808: ifeq +11 -> 819
    //   811: aload_0
    //   812: getfield 144	com/tencent/mm/plugin/sns/model/aa:JWl	Lcom/tencent/mm/protocal/protobuf/elg;
    //   815: iconst_0
    //   816: putfield 336	com/tencent/mm/protocal/protobuf/elg:rWu	I
    //   819: aload_0
    //   820: getfield 78	com/tencent/mm/plugin/sns/model/aa:startTime	J
    //   823: lconst_0
    //   824: lcmp
    //   825: ifne +17 -> 842
    //   828: aload_0
    //   829: invokestatic 372	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   832: putfield 78	com/tencent/mm/plugin/sns/model/aa:startTime	J
    //   835: aload_0
    //   836: getstatic 377	com/tencent/mm/i/a:MediaType_FRIENDS	I
    //   839: putfield 80	com/tencent/mm/plugin/sns/model/aa:jGU	I
    //   842: aload_0
    //   843: getfield 144	com/tencent/mm/plugin/sns/model/aa:JWl	Lcom/tencent/mm/protocal/protobuf/elg;
    //   846: astore_2
    //   847: invokestatic 383	com/tencent/mm/aq/f:bkg	()Lcom/tencent/mm/aq/b;
    //   850: pop
    //   851: bipush 32
    //   853: invokestatic 389	com/tencent/mm/aq/b:vQ	(I)Z
    //   856: ifne +80 -> 936
    //   859: invokestatic 383	com/tencent/mm/aq/f:bkg	()Lcom/tencent/mm/aq/b;
    //   862: pop
    //   863: ldc 158
    //   865: ldc_w 391
    //   868: iconst_1
    //   869: anewarray 393	java/lang/Object
    //   872: dup
    //   873: iconst_0
    //   874: bipush 32
    //   876: invokestatic 389	com/tencent/mm/aq/b:vQ	(I)Z
    //   879: invokestatic 399	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   882: aastore
    //   883: invokestatic 403	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   886: iconst_0
    //   887: istore_1
    //   888: iload_1
    //   889: ifeq +95 -> 984
    //   892: aload_0
    //   893: iconst_1
    //   894: putfield 70	com/tencent/mm/plugin/sns/model/aa:JWo	Z
    //   897: ldc 44
    //   899: invokestatic 406	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   902: return
    //   903: astore_2
    //   904: ldc 158
    //   906: ldc_w 408
    //   909: invokestatic 411	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   912: ldc 44
    //   914: invokestatic 406	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   917: return
    //   918: astore 5
    //   920: ldc 158
    //   922: aload 5
    //   924: ldc 56
    //   926: iconst_0
    //   927: anewarray 393	java/lang/Object
    //   930: invokestatic 415	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   933: goto -437 -> 496
    //   936: getstatic 418	com/tencent/mm/platformtools/ac:mGe	I
    //   939: iconst_2
    //   940: if_icmpne +8 -> 948
    //   943: iconst_0
    //   944: istore_1
    //   945: goto -57 -> 888
    //   948: aload_0
    //   949: aload_2
    //   950: getfield 292	com/tencent/mm/protocal/protobuf/elg:lps	Ljava/lang/String;
    //   953: putfield 66	com/tencent/mm/plugin/sns/model/aa:lPn	Ljava/lang/String;
    //   956: aload_0
    //   957: getfield 66	com/tencent/mm/plugin/sns/model/aa:lPn	Ljava/lang/String;
    //   960: invokestatic 255	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   963: ifeq +16 -> 979
    //   966: ldc 158
    //   968: ldc_w 420
    //   971: invokestatic 422	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   974: iconst_0
    //   975: istore_1
    //   976: goto -88 -> 888
    //   979: iconst_1
    //   980: istore_1
    //   981: goto -93 -> 888
    //   984: aload_0
    //   985: invokespecial 426	com/tencent/mm/plugin/sns/model/aa:fOe	()Z
    //   988: ifne +7 -> 995
    //   991: aload_0
    //   992: invokespecial 429	com/tencent/mm/plugin/sns/model/aa:onError	()V
    //   995: ldc 44
    //   997: invokestatic 406	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   317	481	6	localcvw	cvw
    //   213	493	7	localq	com.tencent.mm.plugin.sns.storage.q
    // Exception table:
    //   from	to	target	type
    //   299	319	903	java/lang/Exception
    //   472	496	918	java/lang/Exception
  }
  
  private void afK(int paramInt)
  {
    AppMethodBeat.i(95676);
    com.tencent.mm.plugin.sns.storage.q localq = aj.fOx().Re(this.fWh);
    try
    {
      cvw localcvw = (cvw)new cvw().parseFrom(localq.KAa);
      localcvw.TAg = 1;
      localcvw.TEj = paramInt;
      localq.KAa = localcvw.toByteArray();
      label54:
      aj.fOH().afP(this.fWh);
      aj.fOx().a(this.fWh, localq);
      AppMethodBeat.o(95676);
      return;
    }
    catch (Exception localException)
    {
      break label54;
    }
  }
  
  private boolean fOe()
  {
    AppMethodBeat.i(95673);
    Object localObject = aj.fOx().Re(this.fWh);
    int j = ((com.tencent.mm.plugin.sns.storage.q)localObject).KzV - ((com.tencent.mm.plugin.sns.storage.q)localObject).offset;
    int i = j;
    if (j > this.lPH) {
      i = this.lPH;
    }
    this.offset = ((com.tencent.mm.plugin.sns.storage.q)localObject).offset;
    localObject = u.aY(this.path, this.offset, i);
    if ((localObject == null) || (localObject.length <= 0))
    {
      AppMethodBeat.o(95673);
      return false;
    }
    eae localeae = new eae();
    localeae.dc((byte[])localObject);
    this.JWl.RNM = localeae;
    this.JWl.Hna = this.offset;
    AppMethodBeat.o(95673);
    return true;
  }
  
  private void onError()
  {
    AppMethodBeat.i(95677);
    com.tencent.mm.plugin.sns.storage.q localq = aj.fOx().Re(this.fWh);
    localq.offset = 0;
    try
    {
      cvw localcvw = (cvw)new cvw().parseFrom(localq.KAa);
      localcvw.TEA = "";
      localq.KAa = localcvw.toByteArray();
      aj.fOx().a(this.fWh, localq);
      aj.fOH().afP(this.fWh);
      AppMethodBeat.o(95677);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.NetSceneMMSnsUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
      AppMethodBeat.o(95677);
    }
  }
  
  public final boolean a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(95675);
    com.tencent.mm.plugin.sns.storage.q localq = aj.fOx().Re(this.fWh);
    Log.i("MicroMsg.NetSceneMMSnsUpload", "upload ok " + paramString1 + "  " + paramString3 + "  " + paramInt1 + " thumbUrl: " + paramString2);
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
      long l = u.bBQ(this.path);
      e.c(paramString1, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, i, l);
      localq.KzZ = paramString3;
      try
      {
        paramString3 = (cvw)new cvw().parseFrom(localq.KAa);
        localObject = paramString3;
        if (paramString3 == null) {
          localObject = new cvw();
        }
        paramString3 = new cvo();
        paramString3.rWu = paramInt1;
        paramString3.Url = paramString1;
        ((cvw)localObject).TEx = paramString3;
        ((cvw)localObject).TAg = 0;
        ((cvw)localObject).md5 = paramString4;
        if (!Util.isNullOrNil(paramString2))
        {
          paramString1 = new cvo();
          paramString1.rWu = paramInt2;
          paramString1.Url = paramString2;
          ((cvw)localObject).TEz.add(paramString1);
        }
      }
      catch (Exception paramString3)
      {
        try
        {
          localq.KAa = ((cvw)localObject).toByteArray();
          localq.fSV();
          aj.fOx().a(this.fWh, localq);
          aj.fOH().afP(this.fWh);
          if (aj.fOE() != null) {
            aj.fOE().fNd();
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
            Log.printErrStackTrace("MicroMsg.NetSceneMMSnsUpload", paramString1, "", new Object[0]);
          }
        }
      }
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(95678);
    super.cancel();
    if ((this.JWo) && (!Util.isNullOrNil(this.lPn)))
    {
      Log.i("MicroMsg.NetSceneMMSnsUpload", "cancel by cdn " + this.lPn);
      f.bkg().Vy(this.lPn);
    }
    AppMethodBeat.o(95678);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    int i = 108;
    AppMethodBeat.i(95679);
    this.callback = parami;
    if (this.JWo)
    {
      this.lPn = this.JWl.lps;
      if (Util.isNullOrNil(this.lPn))
      {
        Log.w("MicroMsg.NetSceneMMSnsUpload", "cdntra genClientId failed not use cdn");
        AppMethodBeat.o(95679);
        return 0;
      }
      paramg = new com.tencent.mm.i.g();
      paramg.taskName = "task_NetSceneSnsUpload_1";
      paramg.iUG = this.lPx;
      paramg.field_mediaId = this.lPn;
      paramg.field_fullpath = this.path;
      paramg.field_thumbpath = "";
      paramg.field_fileType = com.tencent.mm.i.a.MediaType_FRIENDS;
      paramg.field_talker = "";
      paramg.field_priority = com.tencent.mm.i.a.iTU;
      paramg.field_needStorage = true;
      paramg.field_isStreamMedia = false;
      if (r.fSY())
      {
        if (this.JWq) {}
        for (i = 114;; i = 113)
        {
          paramg.field_appType = i;
          paramg.field_bzScene = 1;
          if (f.bkg().f(paramg)) {
            break;
          }
          Log.e("MicroMsg.NetSceneMMSnsUpload", "cdntra addSendTask failed. clientid:%s", new Object[] { this.lPn });
          this.lPn = "";
          break;
        }
      }
      if (r.fSZ())
      {
        if (this.JWq) {}
        for (;;)
        {
          paramg.field_appType = i;
          break;
          i = 107;
        }
      }
      if (r.fSX())
      {
        if (this.JWq) {}
        for (;;)
        {
          paramg.field_appType = i;
          break;
          i = 107;
        }
      }
      f.bkg();
      if (com.tencent.mm.aq.b.vQ(64))
      {
        if (this.JWq) {}
        for (i = 104;; i = 103)
        {
          paramg.field_appType = i;
          break;
        }
      }
      if (this.JWq) {}
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95674);
    Log.i("MicroMsg.NetSceneMMSnsUpload", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    params = (elh)d.c.b(((com.tencent.mm.an.d)params).lBS);
    if (paramInt2 == 4)
    {
      afK(paramInt3);
      if (this.JWr == 21) {
        com.tencent.mm.plugin.sns.lucky.a.b.rE(12);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95674);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      onError();
      if (this.JWr == 21) {
        com.tencent.mm.plugin.sns.lucky.a.b.rE(13);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95674);
      return;
    }
    paramArrayOfByte = aj.fOx().Re(this.fWh);
    if ((params.Hna < 0) || ((params.Hna > paramArrayOfByte.KzV) && (paramArrayOfByte.KzV > 0)))
    {
      onError();
      if (paramInt2 == 3) {
        com.tencent.mm.plugin.sns.lucky.a.b.rE(14);
      }
      AppMethodBeat.o(95674);
      return;
    }
    if (params.Hna < paramArrayOfByte.offset)
    {
      onError();
      if (paramInt2 == 3) {
        com.tencent.mm.plugin.sns.lucky.a.b.rE(14);
      }
      AppMethodBeat.o(95674);
      return;
    }
    Log.d("MicroMsg.NetSceneMMSnsUpload", " bufferUrl: " + params.Unu.Url + " bufferUrlType: " + params.Unu.rWu + "  id:" + params.Id + " thumb Count: " + params.TEy + "  type " + params.rWu + " startPos : " + params.Hna);
    paramArrayOfByte.offset = params.Hna;
    aj.fOx().a(this.fWh, paramArrayOfByte);
    if ((paramArrayOfByte.offset == paramArrayOfByte.KzV) && (paramArrayOfByte.KzV != 0))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label621;
      }
      Log.i("MicroMsg.NetSceneMMSnsUpload", "uploadsns done pass: " + (System.currentTimeMillis() - this.mJB));
      if ((params.TEz.size() == 0) || (params.TEz.size() <= 0)) {
        break label569;
      }
      a(params.Unu.Url, params.Unu.rWu, ((ejl)params.TEz.get(0)).Url, ((ejl)params.TEz.get(0)).rWu, params.Id, this.JWl.MD5);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95674);
      return;
      paramInt1 = 0;
      break;
      label569:
      a(params.Unu.Url, params.Unu.rWu, "", 0, params.Id, this.JWl.MD5);
    }
    label621:
    if ((fOe()) && (doScene(dispatcher(), this.callback) < 0)) {
      this.callback.onSceneEnd(3, -1, "doScene failed", this);
    }
    AppMethodBeat.o(95674);
  }
  
  public final int securityLimitCount()
  {
    if (this.JWn) {
      return 675;
    }
    return 100;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.lCx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.aa
 * JD-Core Version:    0.7.0.1
 */