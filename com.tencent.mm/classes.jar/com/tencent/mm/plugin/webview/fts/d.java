package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.websearch.api.a;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.plugin.websearch.api.s;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.protocal.c.btg;
import com.tencent.mm.protocal.c.ccd;
import com.tencent.mm.protocal.c.ckx;
import com.tencent.mm.protocal.c.cky;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class d
  extends a
  implements k
{
  private s dZR;
  private f dmL;
  private b esv;
  private int qTw;
  private cky qZu;
  private ckx qZv;
  private int scene;
  
  /* Error */
  public d(s params)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: aload_0
    //   4: invokespecial 28	com/tencent/mm/plugin/websearch/api/a:<init>	()V
    //   7: aload_0
    //   8: aload_1
    //   9: putfield 30	com/tencent/mm/plugin/webview/fts/d:dZR	Lcom/tencent/mm/plugin/websearch/api/s;
    //   12: aload_0
    //   13: aload_1
    //   14: getfield 36	com/tencent/mm/plugin/websearch/api/s:bGm	Ljava/lang/String;
    //   17: putfield 39	com/tencent/mm/plugin/webview/fts/d:qTu	Ljava/lang/String;
    //   20: aload_0
    //   21: aload_1
    //   22: getfield 42	com/tencent/mm/plugin/websearch/api/s:lJQ	Ljava/lang/String;
    //   25: putfield 45	com/tencent/mm/plugin/webview/fts/d:bVq	Ljava/lang/String;
    //   28: aload_0
    //   29: aload_1
    //   30: getfield 48	com/tencent/mm/plugin/websearch/api/s:offset	I
    //   33: putfield 51	com/tencent/mm/plugin/webview/fts/d:El	I
    //   36: aload_0
    //   37: aload_1
    //   38: getfield 53	com/tencent/mm/plugin/websearch/api/s:scene	I
    //   41: putfield 56	com/tencent/mm/plugin/webview/fts/d:fzn	I
    //   44: aload_0
    //   45: aload_1
    //   46: getfield 59	com/tencent/mm/plugin/websearch/api/s:bVm	I
    //   49: putfield 62	com/tencent/mm/plugin/webview/fts/d:qTt	I
    //   52: aload_0
    //   53: aload_1
    //   54: getfield 64	com/tencent/mm/plugin/websearch/api/s:qTw	I
    //   57: putfield 65	com/tencent/mm/plugin/webview/fts/d:qTw	I
    //   60: aload_0
    //   61: aload_1
    //   62: putfield 30	com/tencent/mm/plugin/webview/fts/d:dZR	Lcom/tencent/mm/plugin/websearch/api/s;
    //   65: aload_0
    //   66: aload_1
    //   67: getfield 69	com/tencent/mm/plugin/websearch/api/s:qTN	Landroid/os/Bundle;
    //   70: putfield 72	com/tencent/mm/plugin/webview/fts/d:qTv	Landroid/os/Bundle;
    //   73: aload_1
    //   74: getfield 36	com/tencent/mm/plugin/websearch/api/s:bGm	Ljava/lang/String;
    //   77: invokestatic 78	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   80: ifne +1065 -> 1145
    //   83: ldc 80
    //   85: ldc 82
    //   87: iconst_1
    //   88: anewarray 84	java/lang/Object
    //   91: dup
    //   92: iconst_0
    //   93: aload_1
    //   94: getfield 36	com/tencent/mm/plugin/websearch/api/s:bGm	Ljava/lang/String;
    //   97: aastore
    //   98: invokestatic 90	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   101: aload_0
    //   102: aload_1
    //   103: getfield 53	com/tencent/mm/plugin/websearch/api/s:scene	I
    //   106: putfield 91	com/tencent/mm/plugin/webview/fts/d:scene	I
    //   109: new 93	com/tencent/mm/ah/b$a
    //   112: dup
    //   113: invokespecial 94	com/tencent/mm/ah/b$a:<init>	()V
    //   116: astore 8
    //   118: aload_1
    //   119: getfield 53	com/tencent/mm/plugin/websearch/api/s:scene	I
    //   122: sipush 201
    //   125: if_icmpeq +11 -> 136
    //   128: aload_1
    //   129: getfield 97	com/tencent/mm/plugin/websearch/api/s:qTI	I
    //   132: iconst_1
    //   133: if_icmpne +938 -> 1071
    //   136: iconst_1
    //   137: istore 4
    //   139: iload 4
    //   141: ifeq +936 -> 1077
    //   144: invokestatic 103	com/tencent/mm/plugin/appbrand/u/r:aqs	()Z
    //   147: ifeq +930 -> 1077
    //   150: aload 8
    //   152: sipush 2676
    //   155: putfield 106	com/tencent/mm/ah/b$a:ecG	I
    //   158: aload 8
    //   160: ldc 108
    //   162: putfield 111	com/tencent/mm/ah/b$a:uri	Ljava/lang/String;
    //   165: aload 8
    //   167: new 113	com/tencent/mm/protocal/c/ckx
    //   170: dup
    //   171: invokespecial 114	com/tencent/mm/protocal/c/ckx:<init>	()V
    //   174: putfield 118	com/tencent/mm/ah/b$a:ecH	Lcom/tencent/mm/bv/a;
    //   177: aload 8
    //   179: new 120	com/tencent/mm/protocal/c/cky
    //   182: dup
    //   183: invokespecial 121	com/tencent/mm/protocal/c/cky:<init>	()V
    //   186: putfield 124	com/tencent/mm/ah/b$a:ecI	Lcom/tencent/mm/bv/a;
    //   189: aload_0
    //   190: aload 8
    //   192: invokevirtual 128	com/tencent/mm/ah/b$a:Kt	()Lcom/tencent/mm/ah/b;
    //   195: putfield 130	com/tencent/mm/plugin/webview/fts/d:esv	Lcom/tencent/mm/ah/b;
    //   198: aload_0
    //   199: aload_0
    //   200: getfield 130	com/tencent/mm/plugin/webview/fts/d:esv	Lcom/tencent/mm/ah/b;
    //   203: getfield 136	com/tencent/mm/ah/b:ecE	Lcom/tencent/mm/ah/b$b;
    //   206: getfield 141	com/tencent/mm/ah/b$b:ecN	Lcom/tencent/mm/bv/a;
    //   209: checkcast 113	com/tencent/mm/protocal/c/ckx
    //   212: putfield 143	com/tencent/mm/plugin/webview/fts/d:qZv	Lcom/tencent/mm/protocal/c/ckx;
    //   215: aload_0
    //   216: getfield 143	com/tencent/mm/plugin/webview/fts/d:qZv	Lcom/tencent/mm/protocal/c/ckx;
    //   219: aload_1
    //   220: getfield 36	com/tencent/mm/plugin/websearch/api/s:bGm	Ljava/lang/String;
    //   223: putfield 146	com/tencent/mm/protocal/c/ckx:sYZ	Ljava/lang/String;
    //   226: aload_0
    //   227: getfield 143	com/tencent/mm/plugin/webview/fts/d:qZv	Lcom/tencent/mm/protocal/c/ckx;
    //   230: aload_1
    //   231: getfield 64	com/tencent/mm/plugin/websearch/api/s:qTw	I
    //   234: putfield 149	com/tencent/mm/protocal/c/ckx:tEN	I
    //   237: aload_0
    //   238: getfield 143	com/tencent/mm/plugin/webview/fts/d:qZv	Lcom/tencent/mm/protocal/c/ckx;
    //   241: aload_1
    //   242: getfield 152	com/tencent/mm/plugin/websearch/api/s:businessType	I
    //   245: i2l
    //   246: putfield 156	com/tencent/mm/protocal/c/ckx:sFC	J
    //   249: aload_0
    //   250: getfield 143	com/tencent/mm/plugin/webview/fts/d:qZv	Lcom/tencent/mm/protocal/c/ckx;
    //   253: invokestatic 162	com/tencent/mm/plugin/websearch/api/aa:Jx	()Lcom/tencent/mm/protocal/c/atp;
    //   256: putfield 166	com/tencent/mm/protocal/c/ckx:tqT	Lcom/tencent/mm/protocal/c/atp;
    //   259: aload_0
    //   260: getfield 143	com/tencent/mm/plugin/webview/fts/d:qZv	Lcom/tencent/mm/protocal/c/ckx;
    //   263: aload_1
    //   264: getfield 48	com/tencent/mm/plugin/websearch/api/s:offset	I
    //   267: putfield 169	com/tencent/mm/protocal/c/ckx:sDT	I
    //   270: aload_0
    //   271: getfield 143	com/tencent/mm/plugin/webview/fts/d:qZv	Lcom/tencent/mm/protocal/c/ckx;
    //   274: iconst_0
    //   275: invokestatic 173	com/tencent/mm/plugin/websearch/api/aa:Bs	(I)I
    //   278: putfield 176	com/tencent/mm/protocal/c/ckx:tpI	I
    //   281: aload_0
    //   282: getfield 143	com/tencent/mm/plugin/webview/fts/d:qZv	Lcom/tencent/mm/protocal/c/ckx;
    //   285: aload_1
    //   286: getfield 180	com/tencent/mm/plugin/websearch/api/s:qTx	Ljava/util/LinkedList;
    //   289: putfield 183	com/tencent/mm/protocal/c/ckx:tGy	Ljava/util/LinkedList;
    //   292: aload_0
    //   293: getfield 143	com/tencent/mm/plugin/webview/fts/d:qZv	Lcom/tencent/mm/protocal/c/ckx;
    //   296: aload_1
    //   297: getfield 53	com/tencent/mm/plugin/websearch/api/s:scene	I
    //   300: putfield 186	com/tencent/mm/protocal/c/ckx:pyo	I
    //   303: aload_0
    //   304: getfield 143	com/tencent/mm/plugin/webview/fts/d:qZv	Lcom/tencent/mm/protocal/c/ckx;
    //   307: aload_1
    //   308: getfield 189	com/tencent/mm/plugin/websearch/api/s:jfE	Ljava/lang/String;
    //   311: putfield 192	com/tencent/mm/protocal/c/ckx:sFF	Ljava/lang/String;
    //   314: aload_0
    //   315: getfield 143	com/tencent/mm/plugin/webview/fts/d:qZv	Lcom/tencent/mm/protocal/c/ckx;
    //   318: aload_1
    //   319: getfield 195	com/tencent/mm/plugin/websearch/api/s:bVt	I
    //   322: putfield 198	com/tencent/mm/protocal/c/ckx:tXU	I
    //   325: aload_0
    //   326: getfield 143	com/tencent/mm/plugin/webview/fts/d:qZv	Lcom/tencent/mm/protocal/c/ckx;
    //   329: aload_1
    //   330: getfield 201	com/tencent/mm/plugin/websearch/api/s:qTy	Ljava/lang/String;
    //   333: putfield 204	com/tencent/mm/protocal/c/ckx:tYf	Ljava/lang/String;
    //   336: aload_0
    //   337: getfield 143	com/tencent/mm/plugin/webview/fts/d:qZv	Lcom/tencent/mm/protocal/c/ckx;
    //   340: aload_1
    //   341: getfield 207	com/tencent/mm/plugin/websearch/api/s:qTA	I
    //   344: putfield 210	com/tencent/mm/protocal/c/ckx:tYh	I
    //   347: aload_0
    //   348: getfield 143	com/tencent/mm/plugin/webview/fts/d:qZv	Lcom/tencent/mm/protocal/c/ckx;
    //   351: aload_1
    //   352: getfield 213	com/tencent/mm/plugin/websearch/api/s:qTz	Ljava/lang/String;
    //   355: putfield 216	com/tencent/mm/protocal/c/ckx:tYg	Ljava/lang/String;
    //   358: aload_0
    //   359: getfield 143	com/tencent/mm/plugin/webview/fts/d:qZv	Lcom/tencent/mm/protocal/c/ckx;
    //   362: aload_1
    //   363: getfield 219	com/tencent/mm/plugin/websearch/api/s:qTB	Ljava/util/LinkedList;
    //   366: putfield 222	com/tencent/mm/protocal/c/ckx:tYi	Ljava/util/LinkedList;
    //   369: aload_0
    //   370: getfield 143	com/tencent/mm/plugin/webview/fts/d:qZv	Lcom/tencent/mm/protocal/c/ckx;
    //   373: aload_1
    //   374: getfield 225	com/tencent/mm/plugin/websearch/api/s:qTG	Ljava/util/LinkedList;
    //   377: putfield 228	com/tencent/mm/protocal/c/ckx:tXV	Ljava/util/LinkedList;
    //   380: aload_0
    //   381: getfield 143	com/tencent/mm/plugin/webview/fts/d:qZv	Lcom/tencent/mm/protocal/c/ckx;
    //   384: aload_1
    //   385: getfield 232	com/tencent/mm/plugin/websearch/api/s:qTF	Lcom/tencent/mm/protocal/c/bww;
    //   388: putfield 233	com/tencent/mm/protocal/c/ckx:qTF	Lcom/tencent/mm/protocal/c/bww;
    //   391: aload_0
    //   392: getfield 143	com/tencent/mm/plugin/webview/fts/d:qZv	Lcom/tencent/mm/protocal/c/ckx;
    //   395: aload_1
    //   396: getfield 236	com/tencent/mm/plugin/websearch/api/s:qTH	Ljava/util/LinkedList;
    //   399: putfield 239	com/tencent/mm/protocal/c/ckx:tYj	Ljava/util/LinkedList;
    //   402: aload_0
    //   403: getfield 143	com/tencent/mm/plugin/webview/fts/d:qZv	Lcom/tencent/mm/protocal/c/ckx;
    //   406: aload_1
    //   407: getfield 242	com/tencent/mm/plugin/websearch/api/s:auI	Ljava/lang/String;
    //   410: putfield 245	com/tencent/mm/protocal/c/ckx:jxi	Ljava/lang/String;
    //   413: aload_0
    //   414: getfield 143	com/tencent/mm/plugin/webview/fts/d:qZv	Lcom/tencent/mm/protocal/c/ckx;
    //   417: aload_1
    //   418: getfield 248	com/tencent/mm/plugin/websearch/api/s:bIB	Ljava/lang/String;
    //   421: putfield 251	com/tencent/mm/protocal/c/ckx:tpM	Ljava/lang/String;
    //   424: aload_1
    //   425: getfield 255	com/tencent/mm/plugin/websearch/api/s:qTK	Lcom/tencent/mm/protocal/c/ckt;
    //   428: ifnonnull +14 -> 442
    //   431: aload_1
    //   432: new 257	com/tencent/mm/protocal/c/ckt
    //   435: dup
    //   436: invokespecial 258	com/tencent/mm/protocal/c/ckt:<init>	()V
    //   439: putfield 255	com/tencent/mm/plugin/websearch/api/s:qTK	Lcom/tencent/mm/protocal/c/ckt;
    //   442: aload_1
    //   443: getfield 255	com/tencent/mm/plugin/websearch/api/s:qTK	Lcom/tencent/mm/protocal/c/ckt;
    //   446: getfield 262	com/tencent/mm/protocal/c/ckt:tYb	Lcom/tencent/mm/protocal/c/jr;
    //   449: ifnonnull +17 -> 466
    //   452: aload_1
    //   453: getfield 255	com/tencent/mm/plugin/websearch/api/s:qTK	Lcom/tencent/mm/protocal/c/ckt;
    //   456: new 264	com/tencent/mm/protocal/c/jr
    //   459: dup
    //   460: invokespecial 265	com/tencent/mm/protocal/c/jr:<init>	()V
    //   463: putfield 262	com/tencent/mm/protocal/c/ckt:tYb	Lcom/tencent/mm/protocal/c/jr;
    //   466: aload_0
    //   467: getfield 143	com/tencent/mm/plugin/webview/fts/d:qZv	Lcom/tencent/mm/protocal/c/ckx;
    //   470: getfield 166	com/tencent/mm/protocal/c/ckx:tqT	Lcom/tencent/mm/protocal/c/atp;
    //   473: ifnull +629 -> 1102
    //   476: aload_1
    //   477: getfield 255	com/tencent/mm/plugin/websearch/api/s:qTK	Lcom/tencent/mm/protocal/c/ckt;
    //   480: getfield 262	com/tencent/mm/protocal/c/ckt:tYb	Lcom/tencent/mm/protocal/c/jr;
    //   483: astore 8
    //   485: invokestatic 271	com/tencent/mm/modelgeo/c:Ob	()Lcom/tencent/mm/modelgeo/c;
    //   488: invokevirtual 274	com/tencent/mm/modelgeo/c:Oe	()Z
    //   491: ifeq +605 -> 1096
    //   494: iconst_0
    //   495: istore 4
    //   497: aload 8
    //   499: iload 4
    //   501: putfield 277	com/tencent/mm/protocal/c/jr:sEx	I
    //   504: aload_0
    //   505: getfield 143	com/tencent/mm/plugin/webview/fts/d:qZv	Lcom/tencent/mm/protocal/c/ckx;
    //   508: getfield 166	com/tencent/mm/protocal/c/ckx:tqT	Lcom/tencent/mm/protocal/c/atp;
    //   511: getfield 283	com/tencent/mm/protocal/c/atp:sGJ	F
    //   514: fstore_3
    //   515: aload_0
    //   516: getfield 143	com/tencent/mm/plugin/webview/fts/d:qZv	Lcom/tencent/mm/protocal/c/ckx;
    //   519: getfield 166	com/tencent/mm/protocal/c/ckx:tqT	Lcom/tencent/mm/protocal/c/atp;
    //   522: getfield 286	com/tencent/mm/protocal/c/atp:sGK	F
    //   525: fstore_2
    //   526: ldc 80
    //   528: ldc_w 288
    //   531: iconst_3
    //   532: anewarray 84	java/lang/Object
    //   535: dup
    //   536: iconst_0
    //   537: fload_3
    //   538: invokestatic 294	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   541: aastore
    //   542: dup
    //   543: iconst_1
    //   544: fload_2
    //   545: invokestatic 294	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   548: aastore
    //   549: dup
    //   550: iconst_2
    //   551: aload_1
    //   552: getfield 255	com/tencent/mm/plugin/websearch/api/s:qTK	Lcom/tencent/mm/protocal/c/ckt;
    //   555: getfield 262	com/tencent/mm/protocal/c/ckt:tYb	Lcom/tencent/mm/protocal/c/jr;
    //   558: getfield 277	com/tencent/mm/protocal/c/jr:sEx	I
    //   561: invokestatic 299	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   564: aastore
    //   565: invokestatic 90	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   568: aload_1
    //   569: getfield 302	com/tencent/mm/plugin/websearch/api/s:qTL	Ljava/lang/String;
    //   572: invokestatic 308	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   575: ifne +148 -> 723
    //   578: aload_1
    //   579: getfield 302	com/tencent/mm/plugin/websearch/api/s:qTL	Ljava/lang/String;
    //   582: invokestatic 314	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   585: astore 8
    //   587: new 316	org/json/JSONObject
    //   590: dup
    //   591: aload 8
    //   593: invokespecial 319	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   596: astore 8
    //   598: new 321	com/tencent/mm/protocal/c/bey
    //   601: dup
    //   602: invokespecial 322	com/tencent/mm/protocal/c/bey:<init>	()V
    //   605: astore 9
    //   607: aload 9
    //   609: aload 8
    //   611: ldc_w 324
    //   614: invokevirtual 327	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   617: putfield 330	com/tencent/mm/protocal/c/bey:ffj	Ljava/lang/String;
    //   620: aload 9
    //   622: aload 8
    //   624: ldc_w 332
    //   627: invokevirtual 327	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   630: putfield 335	com/tencent/mm/protocal/c/bey:ffq	Ljava/lang/String;
    //   633: aload 9
    //   635: aload 8
    //   637: ldc_w 337
    //   640: invokevirtual 341	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   643: d2f
    //   644: putfield 342	com/tencent/mm/protocal/c/bey:sGK	F
    //   647: aload 9
    //   649: aload 8
    //   651: ldc_w 344
    //   654: invokevirtual 341	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   657: d2f
    //   658: putfield 345	com/tencent/mm/protocal/c/bey:sGJ	F
    //   661: aload 9
    //   663: aload 8
    //   665: ldc_w 347
    //   668: invokevirtual 327	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   671: putfield 350	com/tencent/mm/protocal/c/bey:tzJ	Ljava/lang/String;
    //   674: aload 9
    //   676: aload 8
    //   678: ldc_w 352
    //   681: invokevirtual 327	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   684: putfield 355	com/tencent/mm/protocal/c/bey:tlI	Ljava/lang/String;
    //   687: aload 9
    //   689: aload 8
    //   691: ldc_w 357
    //   694: invokevirtual 327	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   697: invokestatic 361	com/tencent/mm/plugin/websearch/api/aa:Ng	(Ljava/lang/String;)J
    //   700: putfield 364	com/tencent/mm/protocal/c/bey:tzL	J
    //   703: aload 9
    //   705: getfield 350	com/tencent/mm/protocal/c/bey:tzJ	Ljava/lang/String;
    //   708: invokestatic 308	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   711: ifne +12 -> 723
    //   714: aload_0
    //   715: getfield 143	com/tencent/mm/plugin/webview/fts/d:qZv	Lcom/tencent/mm/protocal/c/ckx;
    //   718: aload 9
    //   720: putfield 368	com/tencent/mm/protocal/c/ckx:tYm	Lcom/tencent/mm/protocal/c/bey;
    //   723: aload_1
    //   724: getfield 255	com/tencent/mm/plugin/websearch/api/s:qTK	Lcom/tencent/mm/protocal/c/ckt;
    //   727: ifnull +96 -> 823
    //   730: aload_1
    //   731: getfield 255	com/tencent/mm/plugin/websearch/api/s:qTK	Lcom/tencent/mm/protocal/c/ckt;
    //   734: ldc_w 370
    //   737: invokestatic 376	com/tencent/mm/kernel/g:r	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   740: checkcast 370	com/tencent/mm/plugin/appbrand/r/a
    //   743: invokeinterface 380 1 0
    //   748: putfield 383	com/tencent/mm/protocal/c/ckt:tYc	I
    //   751: aload_0
    //   752: getfield 143	com/tencent/mm/plugin/webview/fts/d:qZv	Lcom/tencent/mm/protocal/c/ckx;
    //   755: new 385	com/tencent/mm/bv/b
    //   758: dup
    //   759: aload_1
    //   760: getfield 255	com/tencent/mm/plugin/websearch/api/s:qTK	Lcom/tencent/mm/protocal/c/ckt;
    //   763: invokevirtual 389	com/tencent/mm/protocal/c/ckt:toByteArray	()[B
    //   766: invokespecial 392	com/tencent/mm/bv/b:<init>	([B)V
    //   769: putfield 396	com/tencent/mm/protocal/c/ckx:tpN	Lcom/tencent/mm/bv/b;
    //   772: ldc 80
    //   774: ldc_w 398
    //   777: iconst_3
    //   778: anewarray 84	java/lang/Object
    //   781: dup
    //   782: iconst_0
    //   783: aload_1
    //   784: getfield 255	com/tencent/mm/plugin/websearch/api/s:qTK	Lcom/tencent/mm/protocal/c/ckt;
    //   787: getfield 401	com/tencent/mm/protocal/c/ckt:tYa	J
    //   790: invokestatic 406	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   793: aastore
    //   794: dup
    //   795: iconst_1
    //   796: aload_1
    //   797: getfield 255	com/tencent/mm/plugin/websearch/api/s:qTK	Lcom/tencent/mm/protocal/c/ckt;
    //   800: getfield 262	com/tencent/mm/protocal/c/ckt:tYb	Lcom/tencent/mm/protocal/c/jr;
    //   803: getfield 409	com/tencent/mm/protocal/c/jr:bOL	Ljava/lang/String;
    //   806: aastore
    //   807: dup
    //   808: iconst_2
    //   809: aload_1
    //   810: getfield 255	com/tencent/mm/plugin/websearch/api/s:qTK	Lcom/tencent/mm/protocal/c/ckt;
    //   813: getfield 262	com/tencent/mm/protocal/c/ckt:tYb	Lcom/tencent/mm/protocal/c/jr;
    //   816: getfield 412	com/tencent/mm/protocal/c/jr:iQN	Ljava/lang/String;
    //   819: aastore
    //   820: invokestatic 415	com/tencent/mm/sdk/platformtools/y:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   823: aload_1
    //   824: getfield 419	com/tencent/mm/plugin/websearch/api/s:qTJ	Lcom/tencent/mm/protocal/c/cmx;
    //   827: ifnull +24 -> 851
    //   830: aload_0
    //   831: getfield 143	com/tencent/mm/plugin/webview/fts/d:qZv	Lcom/tencent/mm/protocal/c/ckx;
    //   834: new 385	com/tencent/mm/bv/b
    //   837: dup
    //   838: aload_1
    //   839: getfield 419	com/tencent/mm/plugin/websearch/api/s:qTJ	Lcom/tencent/mm/protocal/c/cmx;
    //   842: invokevirtual 422	com/tencent/mm/protocal/c/cmx:toByteArray	()[B
    //   845: invokespecial 392	com/tencent/mm/bv/b:<init>	([B)V
    //   848: putfield 425	com/tencent/mm/protocal/c/ckx:tpO	Lcom/tencent/mm/bv/b;
    //   851: aload_0
    //   852: getfield 143	com/tencent/mm/plugin/webview/fts/d:qZv	Lcom/tencent/mm/protocal/c/ckx;
    //   855: getfield 166	com/tencent/mm/protocal/c/ckx:tqT	Lcom/tencent/mm/protocal/c/atp;
    //   858: ifnull +281 -> 1139
    //   861: iconst_1
    //   862: istore 6
    //   864: ldc 80
    //   866: ldc_w 427
    //   869: bipush 7
    //   871: anewarray 84	java/lang/Object
    //   874: dup
    //   875: iconst_0
    //   876: iload 6
    //   878: invokestatic 432	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   881: aastore
    //   882: dup
    //   883: iconst_1
    //   884: aload_1
    //   885: getfield 180	com/tencent/mm/plugin/websearch/api/s:qTx	Ljava/util/LinkedList;
    //   888: invokevirtual 437	java/util/LinkedList:size	()I
    //   891: invokestatic 299	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   894: aastore
    //   895: dup
    //   896: iconst_2
    //   897: aload_1
    //   898: getfield 53	com/tencent/mm/plugin/websearch/api/s:scene	I
    //   901: invokestatic 299	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   904: aastore
    //   905: dup
    //   906: iconst_3
    //   907: aload_1
    //   908: getfield 152	com/tencent/mm/plugin/websearch/api/s:businessType	I
    //   911: invokestatic 299	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   914: aastore
    //   915: dup
    //   916: iconst_4
    //   917: aload_0
    //   918: getfield 65	com/tencent/mm/plugin/webview/fts/d:qTw	I
    //   921: invokestatic 299	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   924: aastore
    //   925: dup
    //   926: iconst_5
    //   927: aload_1
    //   928: getfield 195	com/tencent/mm/plugin/websearch/api/s:bVt	I
    //   931: invokestatic 299	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   934: aastore
    //   935: dup
    //   936: bipush 6
    //   938: aload_1
    //   939: getfield 59	com/tencent/mm/plugin/websearch/api/s:bVm	I
    //   942: invokestatic 299	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   945: aastore
    //   946: invokestatic 90	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   949: aload_0
    //   950: getfield 143	com/tencent/mm/plugin/webview/fts/d:qZv	Lcom/tencent/mm/protocal/c/ckx;
    //   953: getfield 166	com/tencent/mm/protocal/c/ckx:tqT	Lcom/tencent/mm/protocal/c/atp;
    //   956: ifnull +39 -> 995
    //   959: sipush 2005
    //   962: aload_0
    //   963: getfield 143	com/tencent/mm/plugin/webview/fts/d:qZv	Lcom/tencent/mm/protocal/c/ckx;
    //   966: getfield 166	com/tencent/mm/protocal/c/ckx:tqT	Lcom/tencent/mm/protocal/c/atp;
    //   969: getfield 283	com/tencent/mm/protocal/c/atp:sGJ	F
    //   972: aload_0
    //   973: getfield 143	com/tencent/mm/plugin/webview/fts/d:qZv	Lcom/tencent/mm/protocal/c/ckx;
    //   976: getfield 166	com/tencent/mm/protocal/c/ckx:tqT	Lcom/tencent/mm/protocal/c/atp;
    //   979: getfield 286	com/tencent/mm/protocal/c/atp:sGK	F
    //   982: aload_0
    //   983: getfield 143	com/tencent/mm/plugin/webview/fts/d:qZv	Lcom/tencent/mm/protocal/c/ckx;
    //   986: getfield 166	com/tencent/mm/protocal/c/ckx:tqT	Lcom/tencent/mm/protocal/c/atp;
    //   989: getfield 440	com/tencent/mm/protocal/c/atp:sUn	I
    //   992: invokestatic 446	com/tencent/mm/modelstat/o:a	(IFFI)V
    //   995: aload_1
    //   996: getfield 53	com/tencent/mm/plugin/websearch/api/s:scene	I
    //   999: istore 4
    //   1001: aload_1
    //   1002: getfield 248	com/tencent/mm/plugin/websearch/api/s:bIB	Ljava/lang/String;
    //   1005: astore 8
    //   1007: aload_1
    //   1008: getfield 449	com/tencent/mm/plugin/websearch/api/s:bVp	Ljava/lang/String;
    //   1011: astore 9
    //   1013: aload_1
    //   1014: getfield 189	com/tencent/mm/plugin/websearch/api/s:jfE	Ljava/lang/String;
    //   1017: astore 10
    //   1019: aload_1
    //   1020: getfield 48	com/tencent/mm/plugin/websearch/api/s:offset	I
    //   1023: istore 5
    //   1025: iload 7
    //   1027: istore 6
    //   1029: aload_1
    //   1030: getfield 64	com/tencent/mm/plugin/websearch/api/s:qTw	I
    //   1033: iconst_1
    //   1034: if_icmpne +6 -> 1040
    //   1037: iconst_1
    //   1038: istore 6
    //   1040: iload 4
    //   1042: aload 8
    //   1044: aload 9
    //   1046: aload 10
    //   1048: iload 5
    //   1050: iload 6
    //   1052: aload_1
    //   1053: getfield 42	com/tencent/mm/plugin/websearch/api/s:lJQ	Ljava/lang/String;
    //   1056: aload_1
    //   1057: getfield 36	com/tencent/mm/plugin/websearch/api/s:bGm	Ljava/lang/String;
    //   1060: aload_1
    //   1061: getfield 152	com/tencent/mm/plugin/websearch/api/s:businessType	I
    //   1064: ldc_w 451
    //   1067: invokestatic 456	com/tencent/mm/plugin/websearch/api/z:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   1070: return
    //   1071: iconst_0
    //   1072: istore 4
    //   1074: goto -935 -> 139
    //   1077: aload 8
    //   1079: sipush 719
    //   1082: putfield 106	com/tencent/mm/ah/b$a:ecG	I
    //   1085: aload 8
    //   1087: ldc_w 458
    //   1090: putfield 111	com/tencent/mm/ah/b$a:uri	Ljava/lang/String;
    //   1093: goto -928 -> 165
    //   1096: iconst_1
    //   1097: istore 4
    //   1099: goto -602 -> 497
    //   1102: aload_1
    //   1103: getfield 255	com/tencent/mm/plugin/websearch/api/s:qTK	Lcom/tencent/mm/protocal/c/ckt;
    //   1106: getfield 262	com/tencent/mm/protocal/c/ckt:tYb	Lcom/tencent/mm/protocal/c/jr;
    //   1109: iconst_1
    //   1110: putfield 277	com/tencent/mm/protocal/c/jr:sEx	I
    //   1113: fconst_0
    //   1114: fstore_2
    //   1115: fconst_0
    //   1116: fstore_3
    //   1117: goto -591 -> 526
    //   1120: astore 8
    //   1122: ldc 80
    //   1124: aload 8
    //   1126: ldc_w 451
    //   1129: iconst_0
    //   1130: anewarray 84	java/lang/Object
    //   1133: invokestatic 462	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1136: goto -413 -> 723
    //   1139: iconst_0
    //   1140: istore 6
    //   1142: goto -278 -> 864
    //   1145: ldc 80
    //   1147: ldc_w 464
    //   1150: invokestatic 468	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1153: return
    //   1154: astore 8
    //   1156: goto -305 -> 851
    //   1159: astore 8
    //   1161: goto -338 -> 823
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1164	0	this	d
    //   0	1164	1	params	s
    //   525	590	2	f1	float
    //   514	603	3	f2	float
    //   137	961	4	i	int
    //   1023	26	5	j	int
    //   862	279	6	bool1	boolean
    //   1	1025	7	bool2	boolean
    //   116	970	8	localObject1	Object
    //   1120	5	8	localJSONException	org.json.JSONException
    //   1154	1	8	localException1	java.lang.Exception
    //   1159	1	8	localException2	java.lang.Exception
    //   605	440	9	localObject2	Object
    //   1017	30	10	str	String
    // Exception table:
    //   from	to	target	type
    //   587	723	1120	org/json/JSONException
    //   830	851	1154	java/lang/Exception
    //   730	823	1159	java/lang/Exception
  }
  
  public final String Jv()
  {
    if (this.qZu != null) {
      return this.qZu.sEb;
    }
    return "";
  }
  
  public final int Jw()
  {
    if (this.qZu != null) {
      return this.qZu.tpP;
    }
    return 0;
  }
  
  public final int a(e parame, f paramf)
  {
    ao.eB(this.scene, 2);
    this.dmL = paramf;
    return a(parame, this.esv, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.FTS.NetSceneWebSearch", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    boolean bool1;
    int i;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      bool1 = true;
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        break label188;
      }
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      paramInt1 = this.dZR.scene;
      paramString = this.dZR.bIB;
      paramq = this.dZR.bVp;
      paramArrayOfByte = this.dZR.jfE;
      i = this.dZR.offset;
      if (this.dZR.qTw != 1) {
        break label182;
      }
    }
    label182:
    for (boolean bool2 = true;; bool2 = false)
    {
      z.a(paramInt1, paramString, paramq, paramArrayOfByte, i, bool2, this.dZR.lJQ, bool1, this.dZR.bGm, this.dZR.businessType);
      ao.Z(this.scene, paramInt2, paramInt3);
      return;
      bool1 = false;
      break;
    }
    label188:
    this.qZu = ((cky)this.esv.ecF.ecN);
    String str;
    if (this.qZu != null)
    {
      paramInt1 = this.dZR.scene;
      paramq = this.dZR.bIB;
      paramArrayOfByte = this.dZR.bVp;
      str = this.dZR.jfE;
      i = this.dZR.offset;
      if (this.dZR.qTw != 1) {
        break label353;
      }
    }
    label353:
    for (bool2 = true;; bool2 = false)
    {
      z.a(paramInt1, paramq, paramArrayOfByte, str, i, bool2, this.dZR.lJQ, bool1, this.dZR.bGm, this.dZR.businessType);
      y.v("MicroMsg.FTS.NetSceneWebSearch", "return data\n%s", new Object[] { this.qZu.sEb });
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      ao.Z(this.scene, paramInt2, paramInt3);
      return;
    }
  }
  
  public final void ar(LinkedList<ccd> paramLinkedList)
  {
    this.qZv.tGy = paramLinkedList;
    btg localbtg = new btg();
    localbtg.tJP = paramLinkedList.size();
    this.qZv.tYk = localbtg;
  }
  
  public final int getType()
  {
    return 719;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.d
 * JD-Core Version:    0.7.0.1
 */