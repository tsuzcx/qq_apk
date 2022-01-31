package com.tencent.mm.plugin.sns.model;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.j.a;
import com.tencent.mm.j.f.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.h.c;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.c.awa;
import com.tencent.mm.protocal.c.awg;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bta;
import com.tencent.mm.protocal.c.bur;
import com.tencent.mm.protocal.c.bus;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class z
  extends m
  implements k
{
  private com.tencent.mm.ah.b dmK;
  public com.tencent.mm.ah.f dmL;
  private int ebK;
  public String eoQ;
  int eoR;
  private f.a epa;
  private int epk;
  private int offset;
  private int onc;
  private String oqL;
  private bur oqM;
  private String oqN;
  private boolean oqO;
  private boolean oqP;
  private boolean oqQ;
  long oqR;
  int oqS;
  private String path;
  long startTime;
  
  /* Error */
  public z(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 40	com/tencent/mm/ah/m:<init>	()V
    //   4: aload_0
    //   5: sipush 8192
    //   8: putfield 42	com/tencent/mm/plugin/sns/model/z:epk	I
    //   11: aload_0
    //   12: iconst_0
    //   13: putfield 44	com/tencent/mm/plugin/sns/model/z:offset	I
    //   16: aload_0
    //   17: ldc 46
    //   19: putfield 48	com/tencent/mm/plugin/sns/model/z:path	Ljava/lang/String;
    //   22: aload_0
    //   23: ldc 46
    //   25: putfield 50	com/tencent/mm/plugin/sns/model/z:oqL	Ljava/lang/String;
    //   28: aload_0
    //   29: iconst_0
    //   30: putfield 52	com/tencent/mm/plugin/sns/model/z:onc	I
    //   33: aload_0
    //   34: ldc 46
    //   36: putfield 54	com/tencent/mm/plugin/sns/model/z:oqN	Ljava/lang/String;
    //   39: aload_0
    //   40: ldc 46
    //   42: putfield 56	com/tencent/mm/plugin/sns/model/z:eoQ	Ljava/lang/String;
    //   45: aload_0
    //   46: iconst_0
    //   47: putfield 58	com/tencent/mm/plugin/sns/model/z:oqO	Z
    //   50: aload_0
    //   51: iconst_0
    //   52: putfield 60	com/tencent/mm/plugin/sns/model/z:oqP	Z
    //   55: aload_0
    //   56: iconst_0
    //   57: putfield 62	com/tencent/mm/plugin/sns/model/z:oqQ	Z
    //   60: aload_0
    //   61: lconst_0
    //   62: putfield 64	com/tencent/mm/plugin/sns/model/z:oqR	J
    //   65: aload_0
    //   66: lconst_0
    //   67: putfield 66	com/tencent/mm/plugin/sns/model/z:startTime	J
    //   70: aload_0
    //   71: iconst_0
    //   72: putfield 68	com/tencent/mm/plugin/sns/model/z:eoR	I
    //   75: aload_0
    //   76: iconst_0
    //   77: putfield 70	com/tencent/mm/plugin/sns/model/z:oqS	I
    //   80: aload_0
    //   81: new 72	com/tencent/mm/plugin/sns/model/z$1
    //   84: dup
    //   85: aload_0
    //   86: invokespecial 75	com/tencent/mm/plugin/sns/model/z$1:<init>	(Lcom/tencent/mm/plugin/sns/model/z;)V
    //   89: putfield 77	com/tencent/mm/plugin/sns/model/z:epa	Lcom/tencent/mm/j/f$a;
    //   92: aload_0
    //   93: invokestatic 83	java/lang/System:currentTimeMillis	()J
    //   96: putfield 64	com/tencent/mm/plugin/sns/model/z:oqR	J
    //   99: aload_0
    //   100: iload_1
    //   101: putfield 52	com/tencent/mm/plugin/sns/model/z:onc	I
    //   104: aload_0
    //   105: aload_2
    //   106: putfield 54	com/tencent/mm/plugin/sns/model/z:oqN	Ljava/lang/String;
    //   109: aload_0
    //   110: iload 4
    //   112: putfield 70	com/tencent/mm/plugin/sns/model/z:oqS	I
    //   115: new 85	com/tencent/mm/ah/b$a
    //   118: dup
    //   119: invokespecial 86	com/tencent/mm/ah/b$a:<init>	()V
    //   122: astore_2
    //   123: aload_2
    //   124: new 88	com/tencent/mm/protocal/c/bur
    //   127: dup
    //   128: invokespecial 89	com/tencent/mm/protocal/c/bur:<init>	()V
    //   131: putfield 93	com/tencent/mm/ah/b$a:ecH	Lcom/tencent/mm/bv/a;
    //   134: aload_2
    //   135: new 95	com/tencent/mm/protocal/c/bus
    //   138: dup
    //   139: invokespecial 96	com/tencent/mm/protocal/c/bus:<init>	()V
    //   142: putfield 99	com/tencent/mm/ah/b$a:ecI	Lcom/tencent/mm/bv/a;
    //   145: aload_2
    //   146: ldc 101
    //   148: putfield 104	com/tencent/mm/ah/b$a:uri	Ljava/lang/String;
    //   151: aload_2
    //   152: sipush 207
    //   155: putfield 107	com/tencent/mm/ah/b$a:ecG	I
    //   158: aload_2
    //   159: bipush 95
    //   161: putfield 110	com/tencent/mm/ah/b$a:ecJ	I
    //   164: aload_2
    //   165: ldc 111
    //   167: putfield 114	com/tencent/mm/ah/b$a:ecK	I
    //   170: aload_0
    //   171: aload_2
    //   172: invokevirtual 118	com/tencent/mm/ah/b$a:Kt	()Lcom/tencent/mm/ah/b;
    //   175: putfield 120	com/tencent/mm/plugin/sns/model/z:dmK	Lcom/tencent/mm/ah/b;
    //   178: aload_0
    //   179: aload_0
    //   180: getfield 120	com/tencent/mm/plugin/sns/model/z:dmK	Lcom/tencent/mm/ah/b;
    //   183: getfield 126	com/tencent/mm/ah/b:ecE	Lcom/tencent/mm/ah/b$b;
    //   186: getfield 131	com/tencent/mm/ah/b$b:ecN	Lcom/tencent/mm/bv/a;
    //   189: checkcast 88	com/tencent/mm/protocal/c/bur
    //   192: putfield 133	com/tencent/mm/plugin/sns/model/z:oqM	Lcom/tencent/mm/protocal/c/bur;
    //   195: invokestatic 139	com/tencent/mm/plugin/sns/model/af:bDu	()Lcom/tencent/mm/plugin/sns/storage/s;
    //   198: iload_1
    //   199: i2l
    //   200: invokevirtual 145	com/tencent/mm/plugin/sns/storage/s:gu	(J)Lcom/tencent/mm/plugin/sns/storage/r;
    //   203: astore 7
    //   205: aload_0
    //   206: iload_3
    //   207: putfield 62	com/tencent/mm/plugin/sns/model/z:oqQ	Z
    //   210: ldc 147
    //   212: new 149	java/lang/StringBuilder
    //   215: dup
    //   216: ldc 151
    //   218: invokespecial 154	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   221: iload_1
    //   222: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   225: ldc 160
    //   227: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: aload 7
    //   232: getfield 166	com/tencent/mm/plugin/sns/storage/r:offset	I
    //   235: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   238: ldc 168
    //   240: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: aload 7
    //   245: getfield 171	com/tencent/mm/plugin/sns/storage/r:oLR	Ljava/lang/String;
    //   248: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: ldc 173
    //   253: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: aload 7
    //   258: getfield 176	com/tencent/mm/plugin/sns/storage/r:oLQ	I
    //   261: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   264: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokestatic 186	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   270: iload_3
    //   271: ifne +18 -> 289
    //   274: aload_0
    //   275: getfield 133	com/tencent/mm/plugin/sns/model/z:oqM	Lcom/tencent/mm/protocal/c/bur;
    //   278: iconst_1
    //   279: putfield 189	com/tencent/mm/protocal/c/bur:ttI	I
    //   282: ldc 147
    //   284: ldc 191
    //   286: invokestatic 186	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   289: new 193	com/tencent/mm/protocal/c/awg
    //   292: dup
    //   293: invokespecial 194	com/tencent/mm/protocal/c/awg:<init>	()V
    //   296: aload 7
    //   298: getfield 198	com/tencent/mm/plugin/sns/storage/r:oLV	[B
    //   301: invokevirtual 202	com/tencent/mm/protocal/c/awg:aH	([B)Lcom/tencent/mm/bv/a;
    //   304: checkcast 193	com/tencent/mm/protocal/c/awg
    //   307: astore 6
    //   309: aload_0
    //   310: aload 7
    //   312: getfield 171	com/tencent/mm/plugin/sns/storage/r:oLR	Ljava/lang/String;
    //   315: invokestatic 208	com/tencent/mm/plugin/sns/data/i:MV	(Ljava/lang/String;)Ljava/lang/String;
    //   318: putfield 50	com/tencent/mm/plugin/sns/model/z:oqL	Ljava/lang/String;
    //   321: aload_0
    //   322: new 149	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   329: invokestatic 212	com/tencent/mm/plugin/sns/model/af:getAccSnsPath	()Ljava/lang/String;
    //   332: aload 7
    //   334: getfield 171	com/tencent/mm/plugin/sns/storage/r:oLR	Ljava/lang/String;
    //   337: invokestatic 218	com/tencent/mm/plugin/sns/model/an:eJ	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   340: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: aload_0
    //   344: getfield 50	com/tencent/mm/plugin/sns/model/z:oqL	Ljava/lang/String;
    //   347: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   353: putfield 48	com/tencent/mm/plugin/sns/model/z:path	Ljava/lang/String;
    //   356: aload_0
    //   357: aload_0
    //   358: getfield 48	com/tencent/mm/plugin/sns/model/z:path	Ljava/lang/String;
    //   361: invokestatic 224	com/tencent/mm/vfs/e:aeQ	(Ljava/lang/String;)J
    //   364: l2i
    //   365: putfield 226	com/tencent/mm/plugin/sns/model/z:ebK	I
    //   368: aload_0
    //   369: aload_0
    //   370: getfield 48	com/tencent/mm/plugin/sns/model/z:path	Ljava/lang/String;
    //   373: invokestatic 230	com/tencent/mm/plugin/sns/data/i:Ne	(Ljava/lang/String;)Z
    //   376: putfield 58	com/tencent/mm/plugin/sns/model/z:oqO	Z
    //   379: ldc 147
    //   381: new 149	java/lang/StringBuilder
    //   384: dup
    //   385: ldc 232
    //   387: invokespecial 154	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   390: aload_0
    //   391: getfield 226	com/tencent/mm/plugin/sns/model/z:ebK	I
    //   394: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   397: ldc 234
    //   399: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: aload_0
    //   403: getfield 58	com/tencent/mm/plugin/sns/model/z:oqO	Z
    //   406: invokevirtual 237	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   409: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: invokestatic 186	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   415: aload 6
    //   417: getfield 240	com/tencent/mm/protocal/c/awg:tsM	Ljava/lang/String;
    //   420: astore 5
    //   422: aload 5
    //   424: astore_2
    //   425: aload 5
    //   427: invokestatic 245	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   430: ifeq +56 -> 486
    //   433: new 149	java/lang/StringBuilder
    //   436: dup
    //   437: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   440: invokestatic 248	com/tencent/mm/sdk/platformtools/bk:UZ	()J
    //   443: invokevirtual 251	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   446: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   449: invokevirtual 257	java/lang/String:getBytes	()[B
    //   452: invokestatic 263	com/tencent/mm/a/g:o	([B)Ljava/lang/String;
    //   455: astore_2
    //   456: aload 6
    //   458: aload_2
    //   459: putfield 240	com/tencent/mm/protocal/c/awg:tsM	Ljava/lang/String;
    //   462: aload 7
    //   464: aload 6
    //   466: invokevirtual 266	com/tencent/mm/protocal/c/awg:toByteArray	()[B
    //   469: putfield 198	com/tencent/mm/plugin/sns/storage/r:oLV	[B
    //   472: invokestatic 139	com/tencent/mm/plugin/sns/model/af:bDu	()Lcom/tencent/mm/plugin/sns/storage/s;
    //   475: aload 7
    //   477: getfield 269	com/tencent/mm/plugin/sns/storage/r:oLk	I
    //   480: aload 7
    //   482: invokevirtual 273	com/tencent/mm/plugin/sns/storage/s:a	(ILcom/tencent/mm/plugin/sns/storage/r;)I
    //   485: pop
    //   486: aload_0
    //   487: getfield 133	com/tencent/mm/plugin/sns/model/z:oqM	Lcom/tencent/mm/protocal/c/bur;
    //   490: aload_0
    //   491: getfield 226	com/tencent/mm/plugin/sns/model/z:ebK	I
    //   494: putfield 276	com/tencent/mm/protocal/c/bur:ndf	I
    //   497: aload_0
    //   498: getfield 133	com/tencent/mm/plugin/sns/model/z:oqM	Lcom/tencent/mm/protocal/c/bur;
    //   501: aload 7
    //   503: getfield 166	com/tencent/mm/plugin/sns/storage/r:offset	I
    //   506: putfield 279	com/tencent/mm/protocal/c/bur:ndg	I
    //   509: aload_0
    //   510: getfield 133	com/tencent/mm/plugin/sns/model/z:oqM	Lcom/tencent/mm/protocal/c/bur;
    //   513: aload_2
    //   514: putfield 282	com/tencent/mm/protocal/c/bur:nde	Ljava/lang/String;
    //   517: aload_0
    //   518: aload_2
    //   519: putfield 56	com/tencent/mm/plugin/sns/model/z:eoQ	Ljava/lang/String;
    //   522: ldc 147
    //   524: new 149	java/lang/StringBuilder
    //   527: dup
    //   528: ldc_w 284
    //   531: invokespecial 154	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   534: aload 6
    //   536: getfield 287	com/tencent/mm/protocal/c/awg:tsl	I
    //   539: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   542: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   545: invokestatic 290	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   548: aload_0
    //   549: getfield 133	com/tencent/mm/plugin/sns/model/z:oqM	Lcom/tencent/mm/protocal/c/bur;
    //   552: aload 6
    //   554: getfield 287	com/tencent/mm/protocal/c/awg:tsl	I
    //   557: putfield 291	com/tencent/mm/protocal/c/bur:tsl	I
    //   560: ldc 147
    //   562: new 149	java/lang/StringBuilder
    //   565: dup
    //   566: ldc_w 293
    //   569: invokespecial 154	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   572: aload 6
    //   574: getfield 296	com/tencent/mm/protocal/c/awg:tsm	I
    //   577: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   580: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   583: invokestatic 290	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   586: aload_0
    //   587: getfield 133	com/tencent/mm/plugin/sns/model/z:oqM	Lcom/tencent/mm/protocal/c/bur;
    //   590: new 149	java/lang/StringBuilder
    //   593: dup
    //   594: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   597: aload 6
    //   599: getfield 299	com/tencent/mm/protocal/c/awg:kRN	Ljava/lang/String;
    //   602: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   608: putfield 302	com/tencent/mm/protocal/c/bur:sxZ	Ljava/lang/String;
    //   611: aload_0
    //   612: getfield 133	com/tencent/mm/plugin/sns/model/z:oqM	Lcom/tencent/mm/protocal/c/bur;
    //   615: aload 6
    //   617: getfield 296	com/tencent/mm/protocal/c/awg:tsm	I
    //   620: putfield 303	com/tencent/mm/protocal/c/bur:tsm	I
    //   623: ldc 147
    //   625: new 149	java/lang/StringBuilder
    //   628: dup
    //   629: ldc_w 305
    //   632: invokespecial 154	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   635: aload 7
    //   637: getfield 308	com/tencent/mm/plugin/sns/storage/r:type	I
    //   640: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   643: ldc_w 310
    //   646: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: aload 6
    //   651: getfield 313	com/tencent/mm/protocal/c/awg:bIW	Ljava/lang/String;
    //   654: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: ldc_w 315
    //   660: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   663: aload 6
    //   665: getfield 318	com/tencent/mm/protocal/c/awg:bOL	Ljava/lang/String;
    //   668: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: ldc_w 320
    //   674: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: aload 6
    //   679: getfield 323	com/tencent/mm/protocal/c/awg:avS	I
    //   682: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   685: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   688: invokestatic 186	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   691: aload_0
    //   692: getfield 133	com/tencent/mm/plugin/sns/model/z:oqM	Lcom/tencent/mm/protocal/c/bur;
    //   695: aload 7
    //   697: getfield 308	com/tencent/mm/plugin/sns/storage/r:type	I
    //   700: putfield 326	com/tencent/mm/protocal/c/bur:hQR	I
    //   703: new 328	com/tencent/mm/protocal/c/bzd
    //   706: dup
    //   707: invokespecial 329	com/tencent/mm/protocal/c/bzd:<init>	()V
    //   710: astore_2
    //   711: aload_2
    //   712: aload 6
    //   714: getfield 332	com/tencent/mm/protocal/c/awg:token	Ljava/lang/String;
    //   717: putfield 335	com/tencent/mm/protocal/c/bzd:tPj	Ljava/lang/String;
    //   720: aload_2
    //   721: aload 6
    //   723: getfield 338	com/tencent/mm/protocal/c/awg:tsv	Ljava/lang/String;
    //   726: putfield 341	com/tencent/mm/protocal/c/bzd:tPk	Ljava/lang/String;
    //   729: aload_0
    //   730: getfield 133	com/tencent/mm/plugin/sns/model/z:oqM	Lcom/tencent/mm/protocal/c/bur;
    //   733: aload_2
    //   734: putfield 345	com/tencent/mm/protocal/c/bur:tzP	Lcom/tencent/mm/protocal/c/bzd;
    //   737: aload 6
    //   739: getfield 313	com/tencent/mm/protocal/c/awg:bIW	Ljava/lang/String;
    //   742: invokestatic 245	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   745: ifne +15 -> 760
    //   748: aload_0
    //   749: getfield 133	com/tencent/mm/plugin/sns/model/z:oqM	Lcom/tencent/mm/protocal/c/bur;
    //   752: aload 6
    //   754: getfield 313	com/tencent/mm/protocal/c/awg:bIW	Ljava/lang/String;
    //   757: putfield 348	com/tencent/mm/protocal/c/bur:sRE	Ljava/lang/String;
    //   760: aload 6
    //   762: getfield 318	com/tencent/mm/protocal/c/awg:bOL	Ljava/lang/String;
    //   765: invokestatic 245	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   768: ifne +15 -> 783
    //   771: aload_0
    //   772: getfield 133	com/tencent/mm/plugin/sns/model/z:oqM	Lcom/tencent/mm/protocal/c/bur;
    //   775: aload 6
    //   777: getfield 318	com/tencent/mm/protocal/c/awg:bOL	Ljava/lang/String;
    //   780: putfield 351	com/tencent/mm/protocal/c/bur:euK	Ljava/lang/String;
    //   783: aload_0
    //   784: getfield 133	com/tencent/mm/plugin/sns/model/z:oqM	Lcom/tencent/mm/protocal/c/bur;
    //   787: aload 6
    //   789: getfield 323	com/tencent/mm/protocal/c/awg:avS	I
    //   792: putfield 354	com/tencent/mm/protocal/c/bur:tLn	I
    //   795: getstatic 359	com/tencent/mm/platformtools/ae:eSs	Z
    //   798: ifeq +11 -> 809
    //   801: aload_0
    //   802: getfield 133	com/tencent/mm/plugin/sns/model/z:oqM	Lcom/tencent/mm/protocal/c/bur;
    //   805: iconst_0
    //   806: putfield 326	com/tencent/mm/protocal/c/bur:hQR	I
    //   809: aload_0
    //   810: getfield 66	com/tencent/mm/plugin/sns/model/z:startTime	J
    //   813: lconst_0
    //   814: lcmp
    //   815: ifne +17 -> 832
    //   818: aload_0
    //   819: invokestatic 362	com/tencent/mm/sdk/platformtools/bk:UY	()J
    //   822: putfield 66	com/tencent/mm/plugin/sns/model/z:startTime	J
    //   825: aload_0
    //   826: getstatic 367	com/tencent/mm/j/a:MediaType_FRIENDS	I
    //   829: putfield 68	com/tencent/mm/plugin/sns/model/z:eoR	I
    //   832: aload_0
    //   833: getfield 133	com/tencent/mm/plugin/sns/model/z:oqM	Lcom/tencent/mm/protocal/c/bur;
    //   836: astore_2
    //   837: invokestatic 373	com/tencent/mm/ak/f:Nd	()Lcom/tencent/mm/ak/b;
    //   840: pop
    //   841: bipush 32
    //   843: invokestatic 379	com/tencent/mm/ak/b:iq	(I)Z
    //   846: ifne +70 -> 916
    //   849: invokestatic 373	com/tencent/mm/ak/f:Nd	()Lcom/tencent/mm/ak/b;
    //   852: pop
    //   853: ldc 147
    //   855: ldc_w 381
    //   858: iconst_1
    //   859: anewarray 383	java/lang/Object
    //   862: dup
    //   863: iconst_0
    //   864: bipush 32
    //   866: invokestatic 379	com/tencent/mm/ak/b:iq	(I)Z
    //   869: invokestatic 389	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   872: aastore
    //   873: invokestatic 393	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   876: iconst_0
    //   877: istore_1
    //   878: iload_1
    //   879: ifeq +85 -> 964
    //   882: aload_0
    //   883: iconst_1
    //   884: putfield 60	com/tencent/mm/plugin/sns/model/z:oqP	Z
    //   887: return
    //   888: astore_2
    //   889: ldc 147
    //   891: ldc_w 395
    //   894: invokestatic 398	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   897: return
    //   898: astore 5
    //   900: ldc 147
    //   902: aload 5
    //   904: ldc 46
    //   906: iconst_0
    //   907: anewarray 383	java/lang/Object
    //   910: invokestatic 402	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   913: goto -427 -> 486
    //   916: getstatic 405	com/tencent/mm/platformtools/ae:eTh	I
    //   919: iconst_2
    //   920: if_icmpne +8 -> 928
    //   923: iconst_0
    //   924: istore_1
    //   925: goto -47 -> 878
    //   928: aload_0
    //   929: aload_2
    //   930: getfield 282	com/tencent/mm/protocal/c/bur:nde	Ljava/lang/String;
    //   933: putfield 56	com/tencent/mm/plugin/sns/model/z:eoQ	Ljava/lang/String;
    //   936: aload_0
    //   937: getfield 56	com/tencent/mm/plugin/sns/model/z:eoQ	Ljava/lang/String;
    //   940: invokestatic 245	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   943: ifeq +16 -> 959
    //   946: ldc 147
    //   948: ldc_w 407
    //   951: invokestatic 409	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   954: iconst_0
    //   955: istore_1
    //   956: goto -78 -> 878
    //   959: iconst_1
    //   960: istore_1
    //   961: goto -83 -> 878
    //   964: aload_0
    //   965: invokespecial 413	com/tencent/mm/plugin/sns/model/z:bDe	()Z
    //   968: ifne -81 -> 887
    //   971: aload_0
    //   972: invokespecial 416	com/tencent/mm/plugin/sns/model/z:onError	()V
    //   975: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	976	0	this	z
    //   0	976	1	paramInt1	int
    //   0	976	2	paramString	String
    //   0	976	3	paramBoolean	boolean
    //   0	976	4	paramInt2	int
    //   420	6	5	str	String
    //   898	5	5	localException	Exception
    //   307	481	6	localawg	awg
    //   203	493	7	localr	r
    // Exception table:
    //   from	to	target	type
    //   289	309	888	java/lang/Exception
    //   462	486	898	java/lang/Exception
  }
  
  private boolean bDe()
  {
    Object localObject = af.bDu().gu(this.onc);
    int j = ((r)localObject).oLQ - ((r)localObject).offset;
    int i = j;
    if (j > this.epk) {
      i = this.epk;
    }
    this.offset = ((r)localObject).offset;
    localObject = com.tencent.mm.vfs.e.c(this.path, this.offset, i);
    if ((localObject == null) || (localObject.length <= 0)) {
      return false;
    }
    bmk localbmk = new bmk();
    localbmk.bs((byte[])localObject);
    this.oqM.szp = localbmk;
    this.oqM.ndg = this.offset;
    return true;
  }
  
  private void onError()
  {
    r localr = af.bDu().gu(this.onc);
    localr.offset = 0;
    try
    {
      awg localawg = (awg)new awg().aH(localr.oLV);
      localawg.tsM = "";
      localr.oLV = localawg.toByteArray();
      af.bDu().a(this.onc, localr);
      af.bDE().xK(this.onc);
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.NetSceneMMSnsUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
    }
  }
  
  protected final int Ka()
  {
    if (this.oqO) {
      return 675;
    }
    return 100;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    int i = 108;
    this.dmL = paramf;
    if (this.oqP)
    {
      this.eoQ = this.oqM.nde;
      if (bk.bl(this.eoQ))
      {
        y.w("MicroMsg.NetSceneMMSnsUpload", "cdntra genClientId failed not use cdn");
        return 0;
      }
      parame = new com.tencent.mm.j.f();
      parame.dlP = this.epa;
      parame.field_mediaId = this.eoQ;
      parame.field_fullpath = this.path;
      parame.field_thumbpath = "";
      parame.field_fileType = a.MediaType_FRIENDS;
      parame.field_talker = "";
      parame.field_priority = a.dlk;
      parame.field_needStorage = true;
      parame.field_isStreamMedia = false;
      if (s.bHc())
      {
        if (this.oqQ) {}
        for (;;)
        {
          parame.field_appType = i;
          parame.field_bzScene = 1;
          if (com.tencent.mm.ak.f.Nd().c(parame)) {
            break;
          }
          y.e("MicroMsg.NetSceneMMSnsUpload", "cdntra addSendTask failed. clientid:%s", new Object[] { this.eoQ });
          this.eoQ = "";
          break;
          i = 107;
        }
      }
      if (s.bHb())
      {
        if (this.oqQ) {}
        for (;;)
        {
          parame.field_appType = i;
          break;
          i = 107;
        }
      }
      com.tencent.mm.ak.f.Nd();
      if (com.tencent.mm.ak.b.iq(64))
      {
        if (this.oqQ) {}
        for (i = 104;; i = 103)
        {
          parame.field_appType = i;
          break;
        }
      }
      if (this.oqQ) {}
      for (i = 101;; i = 100)
      {
        parame.field_appType = i;
        break;
      }
    }
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneMMSnsUpload", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramq = (bus)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    if (paramInt2 == 4)
    {
      xF(paramInt3);
      if (this.oqS == 21) {
        com.tencent.mm.plugin.sns.lucky.a.b.jdMethod_if(12);
      }
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    label533:
    do
    {
      do
      {
        do
        {
          return;
          if ((paramInt2 != 0) || (paramInt3 != 0))
          {
            onError();
            if (this.oqS == 21) {
              com.tencent.mm.plugin.sns.lucky.a.b.jdMethod_if(13);
            }
            this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
            return;
          }
          paramArrayOfByte = af.bDu().gu(this.onc);
          if ((paramq.ndg >= 0) && ((paramq.ndg <= paramArrayOfByte.oLQ) || (paramArrayOfByte.oLQ <= 0))) {
            break;
          }
          onError();
        } while (paramInt2 != 3);
        com.tencent.mm.plugin.sns.lucky.a.b.jdMethod_if(14);
        return;
        if (paramq.ndg >= paramArrayOfByte.offset) {
          break;
        }
        onError();
      } while (paramInt2 != 3);
      com.tencent.mm.plugin.sns.lucky.a.b.jdMethod_if(14);
      return;
      y.d("MicroMsg.NetSceneMMSnsUpload", " bufferUrl: " + paramq.tLo.kSC + " bufferUrlType: " + paramq.tLo.hQR + "  id:" + paramq.sGd + " thumb Count: " + paramq.tsJ + "  type " + paramq.hQR + " startPos : " + paramq.ndg);
      paramArrayOfByte.offset = paramq.ndg;
      af.bDu().a(this.onc, paramArrayOfByte);
      if ((paramArrayOfByte.offset == paramArrayOfByte.oLQ) && (paramArrayOfByte.oLQ != 0))
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          continue;
        }
        y.i("MicroMsg.NetSceneMMSnsUpload", "uploadsns done pass: " + (System.currentTimeMillis() - this.oqR));
        if ((paramq.tsK.size() == 0) || (paramq.tsK.size() <= 0)) {
          break label533;
        }
        a(paramq.tLo.kSC, paramq.tLo.hQR, ((bta)paramq.tsK.get(0)).kSC, ((bta)paramq.tsK.get(0)).hQR, paramq.sGd, this.oqM.sRE);
      }
      for (;;)
      {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
        paramInt1 = 0;
        break;
        a(paramq.tLo.kSC, paramq.tLo.hQR, "", 0, paramq.sGd, this.oqM.sRE);
      }
    } while ((!bDe()) || (a(this.edc, this.dmL) >= 0));
    this.dmL.onSceneEnd(3, -1, "doScene failed", this);
  }
  
  public final boolean a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    r localr = af.bDu().gu(this.onc);
    y.i("MicroMsg.NetSceneMMSnsUpload", "upload ok " + paramString1 + "  " + paramString3 + "  " + paramInt1 + " thumbUrl: " + paramString2);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    MMBitmapFactory.decodeFile(this.path, localOptions, null, 0, new int[0]);
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
      long l = com.tencent.mm.vfs.e.aeQ(this.path);
      c.a(paramString1, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, i, l);
      localr.oLU = paramString3;
      try
      {
        paramString3 = (awg)new awg().aH(localr.oLV);
        localObject = paramString3;
        if (paramString3 == null) {
          localObject = new awg();
        }
        paramString3 = new awa();
        paramString3.hQR = paramInt1;
        paramString3.kSC = paramString1;
        ((awg)localObject).tsI = paramString3;
        ((awg)localObject).tsL = 0;
        ((awg)localObject).bIW = paramString4;
        if (!bk.bl(paramString2))
        {
          paramString1 = new awa();
          paramString1.hQR = paramInt2;
          paramString1.kSC = paramString2;
          ((awg)localObject).tsK.add(paramString1);
        }
      }
      catch (Exception paramString3)
      {
        try
        {
          localr.oLV = ((awg)localObject).toByteArray();
          localr.bHa();
          af.bDu().a(this.onc, localr);
          af.bDE().xK(this.onc);
          if (af.bDB() != null) {
            af.bDB().bCp();
          }
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
            y.printErrStackTrace("MicroMsg.NetSceneMMSnsUpload", paramString1, "", new Object[0]);
          }
        }
      }
    }
  }
  
  protected final m.b b(q paramq)
  {
    return m.b.edr;
  }
  
  protected final void cancel()
  {
    super.cancel();
    if ((this.oqP) && (!bk.bl(this.eoQ)))
    {
      y.i("MicroMsg.NetSceneMMSnsUpload", "cancel by cdn " + this.eoQ);
      com.tencent.mm.ak.f.Nd().lL(this.eoQ);
    }
  }
  
  public final int getType()
  {
    return 207;
  }
  
  final void xF(int paramInt)
  {
    r localr = af.bDu().gu(this.onc);
    try
    {
      awg localawg = (awg)new awg().aH(localr.oLV);
      localawg.tsL = 1;
      localawg.tsu = paramInt;
      localr.oLV = localawg.toByteArray();
      label48:
      af.bDE().xK(this.onc);
      af.bDu().a(this.onc, localr);
      return;
    }
    catch (Exception localException)
    {
      break label48;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.z
 * JD-Core Version:    0.7.0.1
 */