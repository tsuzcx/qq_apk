package com.tencent.mm.plugin.subapp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.fy;
import com.tencent.mm.g.a.fy.a;
import com.tencent.mm.model.az;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.protocal.protobuf.dns;
import com.tencent.mm.protocal.protobuf.dqu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.cg;
import com.tencent.mm.storage.ch;
import java.util.HashMap;
import java.util.Map;

public final class a$a
  extends com.tencent.mm.sdk.b.c<fy>
  implements g
{
  private int dgw;
  private int dgx;
  private String dng;
  private boolean gbD;
  private boolean jGP;
  private String toUser;
  private com.tencent.mm.plugin.subapp.ui.voicetranstext.a zOR;
  private com.tencent.mm.plugin.subapp.ui.voicetranstext.c zOS;
  private com.tencent.mm.plugin.subapp.ui.voicetranstext.b zOT;
  private r zOU;
  private int zOV;
  private volatile boolean zOW;
  boolean zOX;
  private au zOY;
  private fy zOZ;
  private int zPa;
  private Map<String, String> zPb;
  private int zPc;
  private boolean zPd;
  private long zPe;
  private long zPf;
  
  public a$a()
  {
    AppMethodBeat.i(28838);
    this.zOW = false;
    this.zOX = false;
    this.zPd = true;
    this.zPe = 0L;
    this.gbD = false;
    this.zPb = new HashMap();
    this.__eventId = fy.class.getName().hashCode();
    AppMethodBeat.o(28838);
  }
  
  private void a(String paramString, a parama)
  {
    AppMethodBeat.i(28842);
    ac.i("MicroMsg.SubCoreSubapp", "finishWithResult mstate:%s", new Object[] { parama });
    if (this.zOY != null) {
      this.zOY.stopTimer();
    }
    az.agi().b(546, this);
    az.agi().b(547, this);
    az.agi().b(548, this);
    if (this.zOZ != null)
    {
      if (bs.isNullOrNil(paramString)) {
        break label289;
      }
      this.zPb.put(this.zOZ.dgj.fileName, paramString);
      if (((a.zOK == null) || (bs.isNullOrNil(a.zOK.field_content))) && (this.zOZ.dgj.from == 1)) {
        o.aKq().a(axr(paramString));
      }
      this.zOZ.dgk.bhH = true;
      this.zOZ.dgk.content = paramString;
      if (parama != a.zPo) {
        break label334;
      }
    }
    for (this.zOZ.dgk.state = 1;; this.zOZ.dgk.state = 2) {
      label289:
      label334:
      do
      {
        ac.d("MicroMsg.SubCoreSubapp", "finishWithResult result : %s", new Object[] { paramString });
        if (this.zOZ.dgj.dgn != null) {
          this.zOZ.dgj.dgn.run();
        }
        b(paramString, parama);
        this.zOR = null;
        this.zOS = null;
        this.zOT = null;
        this.zOZ = null;
        this.jGP = false;
        this.zOX = false;
        this.zOW = false;
        this.zPa = 20;
        a.zOK = null;
        eao();
        AppMethodBeat.o(28842);
        return;
        if (parama != a.zPm) {
          break;
        }
        ac.i("MicroMsg.SubCoreSubapp", "finishWithResult State.FINISH id:%s", new Object[] { this.zOZ.dgj.dgl });
        this.zOZ.dgk.state = 2;
        break;
      } while ((parama != a.zPq) && (parama != a.zPr));
    }
  }
  
  /* Error */
  private boolean a(fy paramfy)
  {
    // Byte code:
    //   0: sipush 28839
    //   3: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: instanceof 74
    //   10: ifne +18 -> 28
    //   13: ldc 96
    //   15: ldc 243
    //   17: invokestatic 247	com/tencent/mm/sdk/platformtools/ac:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: sipush 28839
    //   23: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: iconst_0
    //   27: ireturn
    //   28: aload_1
    //   29: getfield 136	com/tencent/mm/g/a/fy:dgj	Lcom/tencent/mm/g/a/fy$a;
    //   32: getfield 250	com/tencent/mm/g/a/fy$a:dgm	I
    //   35: iconst_2
    //   36: if_icmpne +35 -> 71
    //   39: aload_0
    //   40: getstatic 190	com/tencent/mm/plugin/subapp/a$a$a:zPo	Lcom/tencent/mm/plugin/subapp/a$a$a;
    //   43: invokevirtual 253	com/tencent/mm/plugin/subapp/a$a:a	(Lcom/tencent/mm/plugin/subapp/a$a$a;)V
    //   46: aload_0
    //   47: getfield 72	com/tencent/mm/plugin/subapp/a$a:zPb	Ljava/util/Map;
    //   50: invokeinterface 256 1 0
    //   55: ldc 96
    //   57: ldc_w 258
    //   60: invokestatic 260	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: sipush 28839
    //   66: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: iconst_1
    //   70: ireturn
    //   71: aload_1
    //   72: getfield 136	com/tencent/mm/g/a/fy:dgj	Lcom/tencent/mm/g/a/fy$a;
    //   75: getfield 250	com/tencent/mm/g/a/fy$a:dgm	I
    //   78: iconst_1
    //   79: if_icmpne +26 -> 105
    //   82: aload_0
    //   83: getstatic 190	com/tencent/mm/plugin/subapp/a$a$a:zPo	Lcom/tencent/mm/plugin/subapp/a$a$a;
    //   86: invokevirtual 253	com/tencent/mm/plugin/subapp/a$a:a	(Lcom/tencent/mm/plugin/subapp/a$a$a;)V
    //   89: ldc 96
    //   91: ldc_w 262
    //   94: invokestatic 260	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: sipush 28839
    //   100: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: iconst_1
    //   104: ireturn
    //   105: aload_1
    //   106: getfield 136	com/tencent/mm/g/a/fy:dgj	Lcom/tencent/mm/g/a/fy$a;
    //   109: getfield 250	com/tencent/mm/g/a/fy$a:dgm	I
    //   112: iconst_3
    //   113: if_icmpne +26 -> 139
    //   116: aload_0
    //   117: getstatic 265	com/tencent/mm/plugin/subapp/a$a$a:zPp	Lcom/tencent/mm/plugin/subapp/a$a$a;
    //   120: invokevirtual 253	com/tencent/mm/plugin/subapp/a$a:a	(Lcom/tencent/mm/plugin/subapp/a$a$a;)V
    //   123: ldc 96
    //   125: ldc_w 267
    //   128: invokestatic 260	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: sipush 28839
    //   134: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: iconst_1
    //   138: ireturn
    //   139: aload_1
    //   140: getfield 136	com/tencent/mm/g/a/fy:dgj	Lcom/tencent/mm/g/a/fy$a;
    //   143: getfield 250	com/tencent/mm/g/a/fy$a:dgm	I
    //   146: ifeq +39 -> 185
    //   149: ldc 96
    //   151: ldc_w 269
    //   154: iconst_1
    //   155: anewarray 100	java/lang/Object
    //   158: dup
    //   159: iconst_0
    //   160: aload_0
    //   161: getfield 126	com/tencent/mm/plugin/subapp/a$a:zOZ	Lcom/tencent/mm/g/a/fy;
    //   164: getfield 136	com/tencent/mm/g/a/fy:dgj	Lcom/tencent/mm/g/a/fy$a;
    //   167: getfield 250	com/tencent/mm/g/a/fy$a:dgm	I
    //   170: invokestatic 275	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   173: aastore
    //   174: invokestatic 105	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   177: sipush 28839
    //   180: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: iconst_0
    //   184: ireturn
    //   185: aload_0
    //   186: getfield 217	com/tencent/mm/plugin/subapp/a$a:jGP	Z
    //   189: ifeq +19 -> 208
    //   192: ldc 96
    //   194: ldc_w 277
    //   197: invokestatic 280	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: sipush 28839
    //   203: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   206: iconst_0
    //   207: ireturn
    //   208: invokestatic 284	com/tencent/mm/modelvoice/o:aKp	()Lcom/tencent/mm/modelvoice/w;
    //   211: ifnonnull +35 -> 246
    //   214: ldc 96
    //   216: new 286	java/lang/StringBuilder
    //   219: dup
    //   220: ldc_w 288
    //   223: invokespecial 291	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   226: invokestatic 295	com/tencent/mm/sdk/platformtools/bs:eWi	()Lcom/tencent/mm/sdk/platformtools/as;
    //   229: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   232: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokestatic 305	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   238: sipush 28839
    //   241: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   244: iconst_0
    //   245: ireturn
    //   246: aload_0
    //   247: aload_1
    //   248: putfield 126	com/tencent/mm/plugin/subapp/a$a:zOZ	Lcom/tencent/mm/g/a/fy;
    //   251: aload_0
    //   252: getfield 126	com/tencent/mm/plugin/subapp/a$a:zOZ	Lcom/tencent/mm/g/a/fy;
    //   255: getfield 136	com/tencent/mm/g/a/fy:dgj	Lcom/tencent/mm/g/a/fy$a;
    //   258: getfield 230	com/tencent/mm/g/a/fy$a:dgl	Ljava/lang/String;
    //   261: astore_3
    //   262: aload_0
    //   263: getfield 126	com/tencent/mm/plugin/subapp/a$a:zOZ	Lcom/tencent/mm/g/a/fy;
    //   266: getfield 136	com/tencent/mm/g/a/fy:dgj	Lcom/tencent/mm/g/a/fy$a;
    //   269: getfield 141	com/tencent/mm/g/a/fy$a:fileName	Ljava/lang/String;
    //   272: astore 4
    //   274: aload_3
    //   275: invokestatic 132	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   278: ifne +11 -> 289
    //   281: aload 4
    //   283: invokestatic 132	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   286: ifeq +39 -> 325
    //   289: ldc 96
    //   291: ldc_w 307
    //   294: iconst_2
    //   295: anewarray 100	java/lang/Object
    //   298: dup
    //   299: iconst_0
    //   300: aload_3
    //   301: aastore
    //   302: dup
    //   303: iconst_1
    //   304: aload 4
    //   306: aastore
    //   307: invokestatic 309	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   310: aload_0
    //   311: getstatic 233	com/tencent/mm/plugin/subapp/a$a$a:zPq	Lcom/tencent/mm/plugin/subapp/a$a$a;
    //   314: invokevirtual 253	com/tencent/mm/plugin/subapp/a$a:a	(Lcom/tencent/mm/plugin/subapp/a$a$a;)V
    //   317: sipush 28839
    //   320: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   323: iconst_0
    //   324: ireturn
    //   325: aload_0
    //   326: invokespecial 222	com/tencent/mm/plugin/subapp/a$a:eao	()V
    //   329: aload_0
    //   330: getfield 72	com/tencent/mm/plugin/subapp/a$a:zPb	Ljava/util/Map;
    //   333: aload 4
    //   335: invokeinterface 313 2 0
    //   340: checkcast 82	java/lang/String
    //   343: astore 5
    //   345: aload 5
    //   347: invokestatic 132	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   350: ifne +41 -> 391
    //   353: ldc 96
    //   355: ldc_w 315
    //   358: iconst_2
    //   359: anewarray 100	java/lang/Object
    //   362: dup
    //   363: iconst_0
    //   364: aload_3
    //   365: aastore
    //   366: dup
    //   367: iconst_1
    //   368: aload 4
    //   370: aastore
    //   371: invokestatic 105	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   374: aload_0
    //   375: aload 5
    //   377: getstatic 225	com/tencent/mm/plugin/subapp/a$a$a:zPm	Lcom/tencent/mm/plugin/subapp/a$a$a;
    //   380: invokespecial 317	com/tencent/mm/plugin/subapp/a$a:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/subapp/a$a$a;)V
    //   383: sipush 28839
    //   386: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   389: iconst_1
    //   390: ireturn
    //   391: invokestatic 165	com/tencent/mm/modelvoice/o:aKq	()Lcom/tencent/mm/storage/ch;
    //   394: aload 4
    //   396: invokevirtual 320	com/tencent/mm/storage/ch:aOJ	(Ljava/lang/String;)Lcom/tencent/mm/storage/cg;
    //   399: astore 5
    //   401: aload 5
    //   403: putstatic 151	com/tencent/mm/plugin/subapp/a:zOK	Lcom/tencent/mm/storage/cg;
    //   406: aload 5
    //   408: ifnull +57 -> 465
    //   411: getstatic 151	com/tencent/mm/plugin/subapp/a:zOK	Lcom/tencent/mm/storage/cg;
    //   414: getfield 156	com/tencent/mm/storage/cg:field_content	Ljava/lang/String;
    //   417: invokestatic 132	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   420: ifne +45 -> 465
    //   423: ldc 96
    //   425: ldc_w 322
    //   428: iconst_2
    //   429: anewarray 100	java/lang/Object
    //   432: dup
    //   433: iconst_0
    //   434: aload_3
    //   435: aastore
    //   436: dup
    //   437: iconst_1
    //   438: aload 4
    //   440: aastore
    //   441: invokestatic 105	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   444: aload_0
    //   445: getstatic 151	com/tencent/mm/plugin/subapp/a:zOK	Lcom/tencent/mm/storage/cg;
    //   448: getfield 156	com/tencent/mm/storage/cg:field_content	Ljava/lang/String;
    //   451: getstatic 225	com/tencent/mm/plugin/subapp/a$a$a:zPm	Lcom/tencent/mm/plugin/subapp/a$a$a;
    //   454: invokespecial 317	com/tencent/mm/plugin/subapp/a$a:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/subapp/a$a$a;)V
    //   457: sipush 28839
    //   460: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   463: iconst_1
    //   464: ireturn
    //   465: ldc 96
    //   467: ldc_w 324
    //   470: iconst_1
    //   471: anewarray 100	java/lang/Object
    //   474: dup
    //   475: iconst_0
    //   476: aload_1
    //   477: getfield 136	com/tencent/mm/g/a/fy:dgj	Lcom/tencent/mm/g/a/fy$a;
    //   480: getfield 327	com/tencent/mm/g/a/fy$a:scene	I
    //   483: invokestatic 275	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   486: aastore
    //   487: invokestatic 105	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   490: aload_0
    //   491: invokestatic 284	com/tencent/mm/modelvoice/o:aKp	()Lcom/tencent/mm/modelvoice/w;
    //   494: aload 4
    //   496: invokevirtual 333	com/tencent/mm/modelvoice/w:EO	(Ljava/lang/String;)Lcom/tencent/mm/modelvoice/r;
    //   499: putfield 335	com/tencent/mm/plugin/subapp/a$a:zOU	Lcom/tencent/mm/modelvoice/r;
    //   502: aload_0
    //   503: getfield 335	com/tencent/mm/plugin/subapp/a$a:zOU	Lcom/tencent/mm/modelvoice/r;
    //   506: ifnonnull +142 -> 648
    //   509: ldc 96
    //   511: ldc_w 337
    //   514: iconst_2
    //   515: anewarray 100	java/lang/Object
    //   518: dup
    //   519: iconst_0
    //   520: aload_3
    //   521: aastore
    //   522: dup
    //   523: iconst_1
    //   524: aload 4
    //   526: aastore
    //   527: invokestatic 105	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   530: aload_0
    //   531: new 339	com/tencent/mm/modelvoice/r
    //   534: dup
    //   535: invokespecial 340	com/tencent/mm/modelvoice/r:<init>	()V
    //   538: putfield 335	com/tencent/mm/plugin/subapp/a$a:zOU	Lcom/tencent/mm/modelvoice/r;
    //   541: aload_0
    //   542: getfield 335	com/tencent/mm/plugin/subapp/a$a:zOU	Lcom/tencent/mm/modelvoice/r;
    //   545: aload 4
    //   547: putfield 341	com/tencent/mm/modelvoice/r:fileName	Ljava/lang/String;
    //   550: aload_0
    //   551: getfield 335	com/tencent/mm/plugin/subapp/a$a:zOU	Lcom/tencent/mm/modelvoice/r;
    //   554: invokestatic 347	java/lang/System:currentTimeMillis	()J
    //   557: ldc2_w 348
    //   560: ldiv
    //   561: putfield 352	com/tencent/mm/modelvoice/r:createTime	J
    //   564: aload_0
    //   565: getfield 335	com/tencent/mm/plugin/subapp/a$a:zOU	Lcom/tencent/mm/modelvoice/r;
    //   568: aload 4
    //   570: putfield 355	com/tencent/mm/modelvoice/r:clientId	Ljava/lang/String;
    //   573: aload_0
    //   574: getfield 335	com/tencent/mm/plugin/subapp/a$a:zOU	Lcom/tencent/mm/modelvoice/r;
    //   577: invokestatic 347	java/lang/System:currentTimeMillis	()J
    //   580: ldc2_w 348
    //   583: ldiv
    //   584: putfield 358	com/tencent/mm/modelvoice/r:iaH	J
    //   587: aload_0
    //   588: getfield 335	com/tencent/mm/plugin/subapp/a$a:zOU	Lcom/tencent/mm/modelvoice/r;
    //   591: iconst_1
    //   592: putfield 361	com/tencent/mm/modelvoice/r:status	I
    //   595: aload_1
    //   596: getfield 136	com/tencent/mm/g/a/fy:dgj	Lcom/tencent/mm/g/a/fy$a;
    //   599: getfield 327	com/tencent/mm/g/a/fy$a:scene	I
    //   602: bipush 8
    //   604: if_icmpne +196 -> 800
    //   607: aload_0
    //   608: getfield 335	com/tencent/mm/plugin/subapp/a$a:zOU	Lcom/tencent/mm/modelvoice/r;
    //   611: iconst_m1
    //   612: putfield 364	com/tencent/mm/modelvoice/r:iaJ	I
    //   615: aload 4
    //   617: invokestatic 370	com/tencent/mm/modelvoice/q:DX	(Ljava/lang/String;)I
    //   620: istore_2
    //   621: ldc 96
    //   623: ldc_w 372
    //   626: iconst_1
    //   627: anewarray 100	java/lang/Object
    //   630: dup
    //   631: iconst_0
    //   632: iload_2
    //   633: invokestatic 275	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   636: aastore
    //   637: invokestatic 105	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   640: aload_0
    //   641: getfield 335	com/tencent/mm/plugin/subapp/a$a:zOU	Lcom/tencent/mm/modelvoice/r;
    //   644: iload_2
    //   645: putfield 375	com/tencent/mm/modelvoice/r:hux	I
    //   648: aload_0
    //   649: getfield 335	com/tencent/mm/plugin/subapp/a$a:zOU	Lcom/tencent/mm/modelvoice/r;
    //   652: getfield 364	com/tencent/mm/modelvoice/r:iaJ	I
    //   655: ifge +191 -> 846
    //   658: ldc 96
    //   660: ldc_w 377
    //   663: invokestatic 260	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   666: aload_0
    //   667: aload_0
    //   668: getfield 126	com/tencent/mm/plugin/subapp/a$a:zOZ	Lcom/tencent/mm/g/a/fy;
    //   671: getfield 136	com/tencent/mm/g/a/fy:dgj	Lcom/tencent/mm/g/a/fy$a;
    //   674: getfield 327	com/tencent/mm/g/a/fy$a:scene	I
    //   677: putfield 379	com/tencent/mm/plugin/subapp/a$a:zPc	I
    //   680: ldc 96
    //   682: ldc_w 381
    //   685: iconst_3
    //   686: anewarray 100	java/lang/Object
    //   689: dup
    //   690: iconst_0
    //   691: aload_0
    //   692: getfield 383	com/tencent/mm/plugin/subapp/a$a:dng	Ljava/lang/String;
    //   695: aastore
    //   696: dup
    //   697: iconst_1
    //   698: aload_0
    //   699: getfield 385	com/tencent/mm/plugin/subapp/a$a:toUser	Ljava/lang/String;
    //   702: aastore
    //   703: dup
    //   704: iconst_2
    //   705: aload_0
    //   706: getfield 379	com/tencent/mm/plugin/subapp/a$a:zPc	I
    //   709: invokestatic 275	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   712: aastore
    //   713: invokestatic 198	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   716: aconst_null
    //   717: astore_3
    //   718: aconst_null
    //   719: astore_1
    //   720: aload_0
    //   721: getfield 335	com/tencent/mm/plugin/subapp/a$a:zOU	Lcom/tencent/mm/modelvoice/r;
    //   724: getfield 341	com/tencent/mm/modelvoice/r:fileName	Ljava/lang/String;
    //   727: invokestatic 391	com/tencent/mm/modelvoice/s:EC	(Ljava/lang/String;)Lcom/tencent/mm/modelvoice/b;
    //   730: astore 4
    //   732: aload 4
    //   734: ifnull +335 -> 1069
    //   737: aload 4
    //   739: astore_1
    //   740: aload 4
    //   742: astore_3
    //   743: aload 4
    //   745: invokeinterface 396 1 0
    //   750: istore_2
    //   751: aload 4
    //   753: astore_1
    //   754: aload 4
    //   756: astore_3
    //   757: aload_0
    //   758: iload_2
    //   759: putfield 398	com/tencent/mm/plugin/subapp/a$a:zOV	I
    //   762: aload 4
    //   764: ifnull +10 -> 774
    //   767: aload 4
    //   769: invokeinterface 401 1 0
    //   774: aload_0
    //   775: iconst_1
    //   776: putfield 217	com/tencent/mm/plugin/subapp/a$a:jGP	Z
    //   779: aload_0
    //   780: bipush 20
    //   782: putfield 219	com/tencent/mm/plugin/subapp/a$a:zPa	I
    //   785: aload_0
    //   786: getstatic 404	com/tencent/mm/plugin/subapp/a$a$a:zPi	Lcom/tencent/mm/plugin/subapp/a$a$a;
    //   789: invokevirtual 253	com/tencent/mm/plugin/subapp/a$a:a	(Lcom/tencent/mm/plugin/subapp/a$a$a;)V
    //   792: sipush 28839
    //   795: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   798: iconst_1
    //   799: ireturn
    //   800: aload_0
    //   801: getfield 335	com/tencent/mm/plugin/subapp/a$a:zOU	Lcom/tencent/mm/modelvoice/r;
    //   804: aload_3
    //   805: invokestatic 407	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   808: invokevirtual 410	java/lang/Integer:intValue	()I
    //   811: putfield 364	com/tencent/mm/modelvoice/r:iaJ	I
    //   814: goto -199 -> 615
    //   817: astore_1
    //   818: ldc 96
    //   820: aload_1
    //   821: ldc_w 412
    //   824: iconst_0
    //   825: anewarray 100	java/lang/Object
    //   828: invokestatic 416	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   831: aload_0
    //   832: getstatic 233	com/tencent/mm/plugin/subapp/a$a$a:zPq	Lcom/tencent/mm/plugin/subapp/a$a$a;
    //   835: invokevirtual 253	com/tencent/mm/plugin/subapp/a$a:a	(Lcom/tencent/mm/plugin/subapp/a$a$a;)V
    //   838: sipush 28839
    //   841: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   844: iconst_1
    //   845: ireturn
    //   846: ldc_w 418
    //   849: invokestatic 424	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   852: checkcast 418	com/tencent/mm/plugin/messenger/foundation/a/k
    //   855: invokeinterface 428 1 0
    //   860: aload_0
    //   861: getfield 335	com/tencent/mm/plugin/subapp/a$a:zOU	Lcom/tencent/mm/modelvoice/r;
    //   864: getfield 364	com/tencent/mm/modelvoice/r:iaJ	I
    //   867: i2l
    //   868: invokeinterface 434 3 0
    //   873: astore_1
    //   874: aload_1
    //   875: getfield 439	com/tencent/mm/g/c/dy:field_isSend	I
    //   878: iconst_1
    //   879: if_icmpne +93 -> 972
    //   882: aload_0
    //   883: invokestatic 444	com/tencent/mm/model/u:axw	()Ljava/lang/String;
    //   886: putfield 383	com/tencent/mm/plugin/subapp/a$a:dng	Ljava/lang/String;
    //   889: aload_0
    //   890: getfield 126	com/tencent/mm/plugin/subapp/a$a:zOZ	Lcom/tencent/mm/g/a/fy;
    //   893: getfield 136	com/tencent/mm/g/a/fy:dgj	Lcom/tencent/mm/g/a/fy$a;
    //   896: getfield 327	com/tencent/mm/g/a/fy$a:scene	I
    //   899: iconst_4
    //   900: if_icmpeq +17 -> 917
    //   903: aload_0
    //   904: getfield 126	com/tencent/mm/plugin/subapp/a$a:zOZ	Lcom/tencent/mm/g/a/fy;
    //   907: getfield 136	com/tencent/mm/g/a/fy:dgj	Lcom/tencent/mm/g/a/fy$a;
    //   910: getfield 327	com/tencent/mm/g/a/fy$a:scene	I
    //   913: iconst_5
    //   914: if_icmpne +47 -> 961
    //   917: ldc_w 446
    //   920: invokestatic 424	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   923: checkcast 446	com/tencent/mm/api/j
    //   926: aload_1
    //   927: getfield 449	com/tencent/mm/g/c/dy:field_bizChatId	J
    //   930: invokeinterface 453 3 0
    //   935: astore_1
    //   936: aload_1
    //   937: ifnull +14 -> 951
    //   940: aload_0
    //   941: aload_1
    //   942: getfield 458	com/tencent/mm/al/a/c:field_bizChatServId	Ljava/lang/String;
    //   945: putfield 385	com/tencent/mm/plugin/subapp/a$a:toUser	Ljava/lang/String;
    //   948: goto -282 -> 666
    //   951: aload_0
    //   952: ldc_w 460
    //   955: putfield 385	com/tencent/mm/plugin/subapp/a$a:toUser	Ljava/lang/String;
    //   958: goto -292 -> 666
    //   961: aload_0
    //   962: aload_1
    //   963: getfield 463	com/tencent/mm/g/c/dy:field_talker	Ljava/lang/String;
    //   966: putfield 385	com/tencent/mm/plugin/subapp/a$a:toUser	Ljava/lang/String;
    //   969: goto -303 -> 666
    //   972: aload_1
    //   973: getfield 439	com/tencent/mm/g/c/dy:field_isSend	I
    //   976: ifne -310 -> 666
    //   979: aload_0
    //   980: invokestatic 444	com/tencent/mm/model/u:axw	()Ljava/lang/String;
    //   983: putfield 385	com/tencent/mm/plugin/subapp/a$a:toUser	Ljava/lang/String;
    //   986: aload_0
    //   987: getfield 126	com/tencent/mm/plugin/subapp/a$a:zOZ	Lcom/tencent/mm/g/a/fy;
    //   990: getfield 136	com/tencent/mm/g/a/fy:dgj	Lcom/tencent/mm/g/a/fy$a;
    //   993: getfield 327	com/tencent/mm/g/a/fy$a:scene	I
    //   996: iconst_4
    //   997: if_icmpeq +17 -> 1014
    //   1000: aload_0
    //   1001: getfield 126	com/tencent/mm/plugin/subapp/a$a:zOZ	Lcom/tencent/mm/g/a/fy;
    //   1004: getfield 136	com/tencent/mm/g/a/fy:dgj	Lcom/tencent/mm/g/a/fy$a;
    //   1007: getfield 327	com/tencent/mm/g/a/fy$a:scene	I
    //   1010: iconst_5
    //   1011: if_icmpne +47 -> 1058
    //   1014: ldc_w 446
    //   1017: invokestatic 424	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1020: checkcast 446	com/tencent/mm/api/j
    //   1023: aload_1
    //   1024: getfield 449	com/tencent/mm/g/c/dy:field_bizChatId	J
    //   1027: invokeinterface 453 3 0
    //   1032: astore_1
    //   1033: aload_1
    //   1034: ifnull +14 -> 1048
    //   1037: aload_0
    //   1038: aload_1
    //   1039: getfield 458	com/tencent/mm/al/a/c:field_bizChatServId	Ljava/lang/String;
    //   1042: putfield 383	com/tencent/mm/plugin/subapp/a$a:dng	Ljava/lang/String;
    //   1045: goto -379 -> 666
    //   1048: aload_0
    //   1049: ldc_w 460
    //   1052: putfield 383	com/tencent/mm/plugin/subapp/a$a:dng	Ljava/lang/String;
    //   1055: goto -389 -> 666
    //   1058: aload_0
    //   1059: aload_1
    //   1060: getfield 463	com/tencent/mm/g/c/dy:field_talker	Ljava/lang/String;
    //   1063: putfield 383	com/tencent/mm/plugin/subapp/a$a:dng	Ljava/lang/String;
    //   1066: goto -400 -> 666
    //   1069: iconst_m1
    //   1070: istore_2
    //   1071: goto -320 -> 751
    //   1074: astore 4
    //   1076: aload_1
    //   1077: astore_3
    //   1078: ldc 96
    //   1080: aload 4
    //   1082: ldc_w 465
    //   1085: iconst_1
    //   1086: anewarray 100	java/lang/Object
    //   1089: dup
    //   1090: iconst_0
    //   1091: aload_0
    //   1092: getfield 335	com/tencent/mm/plugin/subapp/a$a:zOU	Lcom/tencent/mm/modelvoice/r;
    //   1095: getfield 341	com/tencent/mm/modelvoice/r:fileName	Ljava/lang/String;
    //   1098: aastore
    //   1099: invokestatic 416	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1102: aload_1
    //   1103: astore_3
    //   1104: aload_0
    //   1105: iconst_m1
    //   1106: putfield 398	com/tencent/mm/plugin/subapp/a$a:zOV	I
    //   1109: aload_1
    //   1110: ifnull -336 -> 774
    //   1113: aload_1
    //   1114: invokeinterface 401 1 0
    //   1119: goto -345 -> 774
    //   1122: astore_1
    //   1123: goto -349 -> 774
    //   1126: astore_1
    //   1127: aload_3
    //   1128: ifnull +9 -> 1137
    //   1131: aload_3
    //   1132: invokeinterface 401 1 0
    //   1137: sipush 28839
    //   1140: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1143: aload_1
    //   1144: athrow
    //   1145: astore_1
    //   1146: goto -372 -> 774
    //   1149: astore_3
    //   1150: goto -13 -> 1137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1153	0	this	a
    //   0	1153	1	paramfy	fy
    //   620	451	2	i	int
    //   261	871	3	localObject1	Object
    //   1149	1	3	localThrowable1	java.lang.Throwable
    //   272	496	4	localObject2	Object
    //   1074	7	4	localThrowable2	java.lang.Throwable
    //   343	64	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   502	615	817	java/lang/Exception
    //   615	648	817	java/lang/Exception
    //   800	814	817	java/lang/Exception
    //   720	732	1074	java/lang/Throwable
    //   743	751	1074	java/lang/Throwable
    //   757	762	1074	java/lang/Throwable
    //   1113	1119	1122	java/lang/Throwable
    //   720	732	1126	finally
    //   743	751	1126	finally
    //   757	762	1126	finally
    //   1078	1102	1126	finally
    //   1104	1109	1126	finally
    //   767	774	1145	java/lang/Throwable
    //   1131	1137	1149	java/lang/Throwable
  }
  
  private cg axr(String paramString)
  {
    AppMethodBeat.i(28844);
    ac.i("MicroMsg.SubCoreSubapp", "createVoiceTT localId(%s) , fileName(%s).", new Object[] { this.zOZ.dgj.dgl, this.zOZ.dgj.fileName });
    cg localcg = new cg();
    localcg.field_msgId = Long.valueOf(this.zOZ.dgj.dgl).longValue();
    localcg.aOI(this.zOZ.dgj.fileName);
    localcg.field_content = paramString;
    AppMethodBeat.o(28844);
    return localcg;
  }
  
  private void b(String paramString, a parama)
  {
    AppMethodBeat.i(28843);
    if (!this.gbD)
    {
      AppMethodBeat.o(28843);
      return;
    }
    if (this.zOU == null)
    {
      AppMethodBeat.o(28843);
      return;
    }
    int i;
    int j;
    if (paramString != null)
    {
      i = paramString.length();
      if (parama != a.zPm) {
        break label173;
      }
      if (bs.isNullOrNil(paramString)) {
        break label155;
      }
      j = 1;
    }
    for (;;)
    {
      ac.i("MicroMsg.SubCoreSubapp", "alvinluo transformTextResult voiceId: %s, wordCount: %d, waitTime: %d, animationTime: %d, transformResult: %d", new Object[] { this.zOU.clientId, Integer.valueOf(i), Integer.valueOf(this.dgw), Integer.valueOf(this.dgx), Integer.valueOf(j) });
      if (j != 0) {
        com.tencent.mm.plugin.subapp.e.b.c(this.zOU.clientId, i, this.dgw, this.dgx, j);
      }
      AppMethodBeat.o(28843);
      return;
      i = 0;
      break;
      label155:
      this.dgw = 0;
      this.dgx = 0;
      i = 0;
      j = 3;
      continue;
      label173:
      this.dgw = 0;
      this.dgx = 0;
      if (parama == a.zPo)
      {
        j = 5;
        i = 0;
      }
      else if (parama == a.zPr)
      {
        i = 0;
        j = 3;
      }
      else if (parama == a.zPq)
      {
        j = 4;
        i = 0;
      }
      else if (parama == a.zPs)
      {
        i = 0;
        j = 2;
      }
      else
      {
        i = 0;
        j = 0;
      }
    }
  }
  
  private void eao()
  {
    this.zPd = true;
    this.zPe = 0L;
    this.zPf = 0L;
    this.dgw = 0;
    this.dgx = 0;
    this.gbD = false;
  }
  
  private void eap()
  {
    AppMethodBeat.i(28841);
    if (this.zPd)
    {
      this.zPd = false;
      this.zPe = System.currentTimeMillis();
      this.dgw = ((int)(this.zPe - this.zPf));
    }
    AppMethodBeat.o(28841);
  }
  
  final void a(a parama)
  {
    AppMethodBeat.i(28840);
    switch (a.2.zOQ[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(28840);
      return;
      ac.i("MicroMsg.SubCoreSubapp", "net check");
      if (this.zOU.dpl > 0L) {
        ac.i("MicroMsg.SubCoreSubapp", "has msg svr id: %d", new Object[] { Long.valueOf(this.zOU.dpl) });
      }
      for (this.zOR = new com.tencent.mm.plugin.subapp.ui.voicetranstext.a(this.zOU.clientId, this.zOU.hux, this.zOV, this.zOU.dpl, this.zOU.fileName, this.zPc, this.dng, this.toUser);; this.zOR = new com.tencent.mm.plugin.subapp.ui.voicetranstext.a(this.zOU.clientId, this.zOU.hux, this.zOU.fileName, this.zPc, this.dng, this.toUser))
      {
        az.agi().a(this.zOR, 0);
        az.agi().a(this.zOR.getType(), this);
        this.zPf = System.currentTimeMillis();
        AppMethodBeat.o(28840);
        return;
        ac.i("MicroMsg.SubCoreSubapp", "not existex msg svr id: %d", new Object[] { Long.valueOf(this.zOU.dpl) });
      }
      ac.i("MicroMsg.SubCoreSubapp", "net upload");
      if (this.zOR == null)
      {
        ac.w("MicroMsg.SubCoreSubapp", "request upload must after check!");
        AppMethodBeat.o(28840);
        return;
      }
      this.zOS = new com.tencent.mm.plugin.subapp.ui.voicetranstext.c(this.zOU.clientId, this.zOR.zTT, this.zOV, this.zOU.fileName, this.zPc, this.dng, this.toUser);
      az.agi().a(this.zOS, 0);
      az.agi().a(this.zOS.getType(), this);
      AppMethodBeat.o(28840);
      return;
      ac.i("MicroMsg.SubCoreSubapp", "net upload more");
      if (this.zOS == null)
      {
        ac.w("MicroMsg.SubCoreSubapp", "upload more need has upload netScene!");
        AppMethodBeat.o(28840);
        return;
      }
      this.zOS = new com.tencent.mm.plugin.subapp.ui.voicetranstext.c(this.zOS);
      az.agi().a(this.zOS, 0);
      az.agi().a(this.zOS.getType(), this);
      AppMethodBeat.o(28840);
      return;
      if (this.zOW)
      {
        ac.i("MicroMsg.SubCoreSubapp", "pulling so pass");
        AppMethodBeat.o(28840);
        return;
      }
      ac.i("MicroMsg.SubCoreSubapp", "net get");
      if (this.zOR == null)
      {
        ac.w("MicroMsg.SubCoreSubapp", "request get must after check!");
        AppMethodBeat.o(28840);
        return;
      }
      this.zOW = true;
      this.zOT = new com.tencent.mm.plugin.subapp.ui.voicetranstext.b(this.zOU.clientId);
      az.agi().a(this.zOT, 0);
      az.agi().a(this.zOT.getType(), this);
      AppMethodBeat.o(28840);
      return;
      this.zOX = true;
      AppMethodBeat.o(28840);
      return;
      az.agi().a(this.zOR);
      az.agi().a(this.zOS);
      az.agi().a(this.zOT);
      this.gbD = true;
      a(null, a.zPo);
      AppMethodBeat.o(28840);
      return;
      this.gbD = true;
      a(null, parama);
      AppMethodBeat.o(28840);
      return;
      this.gbD = true;
      a(null, parama);
    }
  }
  
  public final void onSceneEnd(final int paramInt1, int paramInt2, String paramString, n paramn)
  {
    paramString = null;
    Object localObject = null;
    AppMethodBeat.i(28845);
    ac.i("MicroMsg.SubCoreSubapp", "onSceneEnd errType(%d) , errCode(%d).", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0)) {}
    switch (paramn.getType())
    {
    default: 
      AppMethodBeat.o(28845);
      return;
    case 546: 
      if (this.zOR.mState == com.tencent.mm.plugin.subapp.ui.voicetranstext.a.zTR)
      {
        ac.i("MicroMsg.SubCoreSubapp", "check result: done");
        a(a.zPm);
        eap();
        this.dgx = 0;
        this.gbD = true;
        paramString = localObject;
        if (this.zOR.eaX()) {
          paramString = this.zOR.zTS.FYc;
        }
        a(paramString, a.zPm);
        AppMethodBeat.o(28845);
        return;
      }
      if (this.zOR.mState == com.tencent.mm.plugin.subapp.ui.voicetranstext.a.zTQ)
      {
        if (this.zOR.zTS != null) {
          bs.isNullOrNil(this.zOR.zTS.FYc);
        }
        ac.i("MicroMsg.SubCoreSubapp", "check result: processing");
        a(a.zPl);
        AppMethodBeat.o(28845);
        return;
      }
      if (this.zOR.mState == com.tencent.mm.plugin.subapp.ui.voicetranstext.a.zTP)
      {
        ac.i("MicroMsg.SubCoreSubapp", "check result: not exist");
        a(a.zPj);
        AppMethodBeat.o(28845);
        return;
      }
      if (this.zOR.zTU != null)
      {
        AppMethodBeat.o(28845);
        return;
      }
      break;
    case 547: 
      if (this.zOS.eaZ())
      {
        ac.i("MicroMsg.SubCoreSubapp", "succeed upload");
        a(a.zPl);
        AppMethodBeat.o(28845);
        return;
      }
      ac.d("MicroMsg.SubCoreSubapp", "start upload more: start:%d, len:%d", new Object[] { Integer.valueOf(this.zOS.zTT.vTI), Integer.valueOf(this.zOS.zTT.vTJ) });
      a(a.zPk);
      AppMethodBeat.o(28845);
      return;
    case 548: 
      paramInt1 = this.zOT.zTW;
      ac.i("MicroMsg.SubCoreSubapp", "get mIntervalSec:%ds", new Object[] { Integer.valueOf(paramInt1) });
      this.zOW = false;
      eap();
      if ((!this.zOT.isComplete()) && (this.zOT.eaX()))
      {
        ac.i("MicroMsg.SubCoreSubapp", "refreshResult result");
        paramn = this.zOT.zTS.FYc;
        if (this.zOZ != null)
        {
          this.zOZ.dgk.bhH = false;
          this.zOZ.dgk.content = paramn;
          ac.i("MicroMsg.SubCoreSubapp", "refreshResult result is null ? : %s", new Object[] { Boolean.valueOf(bs.isNullOrNil(paramn)) });
          if (this.zOZ.dgj.dgn != null) {
            this.zOZ.dgj.dgn.run();
          }
        }
      }
      while (this.zOT.isComplete())
      {
        ac.i("MicroMsg.SubCoreSubapp", "succeed get");
        if (this.zOT.eaX()) {
          paramString = this.zOT.zTS.FYc;
        }
        a(a.zPm);
        this.dgx = ((int)(System.currentTimeMillis() - this.zPe));
        this.gbD = true;
        a(paramString, a.zPm);
        AppMethodBeat.o(28845);
        return;
        if (!this.zOT.eaX()) {
          ac.d("MicroMsg.SubCoreSubapp", "result not valid");
        }
      }
      ac.i("MicroMsg.SubCoreSubapp", "do get again after:%ds", new Object[] { Integer.valueOf(paramInt1) });
      if (!this.zOX)
      {
        paramInt2 = this.zPa - 1;
        this.zPa = paramInt2;
        if (paramInt2 < 0)
        {
          ac.e("MicroMsg.SubCoreSubapp", "Has try to translate delay for %d times.", new Object[] { Integer.valueOf(20) });
          a(a.zPr);
          AppMethodBeat.o(28845);
          return;
        }
        if (this.zOY == null) {
          this.zOY = new au(new au.a()
          {
            public final boolean onTimerExpired()
            {
              AppMethodBeat.i(28834);
              if (a.a.this.zOX)
              {
                AppMethodBeat.o(28834);
                return false;
              }
              ac.d("MicroMsg.SubCoreSubapp", "timmer get, delay:%d", new Object[] { Integer.valueOf(paramInt1) });
              a.a.this.a(a.a.a.zPl);
              AppMethodBeat.o(28834);
              return false;
            }
          }, false);
        }
        paramString = this.zOY;
        long l = paramInt1 * 1000;
        paramString.au(l, l);
      }
      AppMethodBeat.o(28845);
      return;
      if (paramInt1 == 2)
      {
        a(a.zPs);
        AppMethodBeat.o(28845);
        return;
      }
      a(a.zPr);
    }
    AppMethodBeat.o(28845);
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(28837);
      zPi = new a("CHECK", 0);
      zPj = new a("UPLOAD", 1);
      zPk = new a("UPLOAD_MORE", 2);
      zPl = new a("GET", 3);
      zPm = new a("FINISH", 4);
      zPn = new a("ERROR", 5);
      zPo = new a("CANCEL", 6);
      zPp = new a("CANCEL_BY_USER", 7);
      zPq = new a("LOCAL_ERROR", 8);
      zPr = new a("SERVER_ERROR", 9);
      zPs = new a("NETWORK_OVERTIME", 10);
      zPt = new a[] { zPi, zPj, zPk, zPl, zPm, zPn, zPo, zPp, zPq, zPr, zPs };
      AppMethodBeat.o(28837);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.a.a
 * JD-Core Version:    0.7.0.1
 */