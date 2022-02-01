package com.tencent.mm.plugin.subapp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.gf;
import com.tencent.mm.g.a.gf.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.plugin.subapp.ui.voicetranstext.c;
import com.tencent.mm.protocal.protobuf.eoe;
import com.tencent.mm.protocal.protobuf.esm;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cu;
import com.tencent.mm.storage.cv;
import java.util.HashMap;
import java.util.Map;

public final class a$a
  extends IListener<gf>
  implements i
{
  private com.tencent.mm.plugin.subapp.ui.voicetranstext.a FIA;
  private c FIB;
  private com.tencent.mm.plugin.subapp.ui.voicetranstext.b FIC;
  private r FID;
  private int FIE;
  private volatile boolean FIF;
  private boolean FIG;
  private MTimerHandler FIH;
  private gf FII;
  private int FIJ;
  private Map<String, String> FIK;
  private int FIL;
  private boolean FIM;
  private long FIN;
  private long FIO;
  private int dKi;
  private int dKj;
  private String dRL;
  private boolean hkH;
  private boolean lic;
  private String toUser;
  
  public a$a()
  {
    AppMethodBeat.i(28838);
    this.FIF = false;
    this.FIG = false;
    this.FIM = true;
    this.FIN = 0L;
    this.hkH = false;
    this.FIK = new HashMap();
    this.__eventId = gf.class.getName().hashCode();
    AppMethodBeat.o(28838);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(28840);
    switch (a.2.FIz[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(28840);
      return;
      Log.i("MicroMsg.SubCoreSubapp", "net check");
      if (this.FID.dTS > 0L) {
        Log.i("MicroMsg.SubCoreSubapp", "has msg svr id: %d", new Object[] { Long.valueOf(this.FID.dTS) });
      }
      for (this.FIA = new com.tencent.mm.plugin.subapp.ui.voicetranstext.a(this.FID.clientId, this.FID.iKP, this.FIE, this.FID.dTS, this.FID.fileName, this.FIL, this.dRL, this.toUser);; this.FIA = new com.tencent.mm.plugin.subapp.ui.voicetranstext.a(this.FID.clientId, this.FID.iKP, this.FID.fileName, this.FIL, this.dRL, this.toUser))
      {
        bg.azz().a(this.FIA, 0);
        bg.azz().a(this.FIA.getType(), this);
        this.FIO = System.currentTimeMillis();
        AppMethodBeat.o(28840);
        return;
        Log.i("MicroMsg.SubCoreSubapp", "not existex msg svr id: %d", new Object[] { Long.valueOf(this.FID.dTS) });
      }
      Log.i("MicroMsg.SubCoreSubapp", "net upload");
      if (this.FIA == null)
      {
        Log.w("MicroMsg.SubCoreSubapp", "request upload must after check!");
        AppMethodBeat.o(28840);
        return;
      }
      this.FIB = new c(this.FID.clientId, this.FIA.FNI, this.FIE, this.FID.fileName, this.FIL, this.dRL, this.toUser);
      bg.azz().a(this.FIB, 0);
      bg.azz().a(this.FIB.getType(), this);
      AppMethodBeat.o(28840);
      return;
      Log.i("MicroMsg.SubCoreSubapp", "net upload more");
      if (this.FIB == null)
      {
        Log.w("MicroMsg.SubCoreSubapp", "upload more need has upload netScene!");
        AppMethodBeat.o(28840);
        return;
      }
      this.FIB = new c(this.FIB);
      bg.azz().a(this.FIB, 0);
      bg.azz().a(this.FIB.getType(), this);
      AppMethodBeat.o(28840);
      return;
      if (this.FIF)
      {
        Log.i("MicroMsg.SubCoreSubapp", "pulling so pass");
        AppMethodBeat.o(28840);
        return;
      }
      Log.i("MicroMsg.SubCoreSubapp", "net get");
      if (this.FIA == null)
      {
        Log.w("MicroMsg.SubCoreSubapp", "request get must after check!");
        AppMethodBeat.o(28840);
        return;
      }
      this.FIF = true;
      this.FIC = new com.tencent.mm.plugin.subapp.ui.voicetranstext.b(this.FID.clientId);
      bg.azz().a(this.FIC, 0);
      bg.azz().a(this.FIC.getType(), this);
      AppMethodBeat.o(28840);
      return;
      this.FIG = true;
      AppMethodBeat.o(28840);
      return;
      bg.azz().a(this.FIA);
      bg.azz().a(this.FIB);
      bg.azz().a(this.FIC);
      this.hkH = true;
      a(null, a.FIY);
      AppMethodBeat.o(28840);
      return;
      this.hkH = true;
      a(null, parama);
      AppMethodBeat.o(28840);
      return;
      this.hkH = true;
      a(null, parama);
    }
  }
  
  private void a(String paramString, a parama)
  {
    AppMethodBeat.i(28842);
    Log.i("MicroMsg.SubCoreSubapp", "finishWithResult mstate:%s", new Object[] { parama });
    if (this.FIH != null) {
      this.FIH.stopTimer();
    }
    bg.azz().b(546, this);
    bg.azz().b(547, this);
    bg.azz().b(548, this);
    if (this.FII != null)
    {
      if (Util.isNullOrNil(paramString)) {
        break label290;
      }
      this.FIK.put(this.FII.dJV.fileName, paramString);
      if (((a.FIt == null) || (Util.isNullOrNil(a.FIt.field_content))) && (this.FII.dJV.from == 1)) {
        o.bic().a(aSJ(paramString));
      }
      this.FII.dJW.brW = true;
      this.FII.dJW.content = paramString;
      if (parama != a.FIY) {
        break label336;
      }
    }
    for (this.FII.dJW.state = 1;; this.FII.dJW.state = 2) {
      label290:
      label336:
      do
      {
        Log.d("MicroMsg.SubCoreSubapp", "finishWithResult result : %s", new Object[] { paramString });
        if (this.FII.dJV.dJZ != null) {
          this.FII.dJV.dJZ.run();
        }
        b(paramString, parama);
        this.FIA = null;
        this.FIB = null;
        this.FIC = null;
        this.FII = null;
        this.lic = false;
        this.FIG = false;
        this.FIF = false;
        this.FIJ = 20;
        a.FIt = null;
        fsL();
        AppMethodBeat.o(28842);
        return;
        if (parama != a.FIV) {
          break;
        }
        Log.i("MicroMsg.SubCoreSubapp", "finishWithResult State.FINISH id:%s", new Object[] { this.FII.dJV.dJX });
        this.FII.dJW.state = 2;
        break;
      } while ((parama != a.FJa) && (parama != a.FJb));
    }
  }
  
  /* Error */
  private boolean a(gf paramgf)
  {
    // Byte code:
    //   0: sipush 28839
    //   3: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: instanceof 74
    //   10: ifne +19 -> 29
    //   13: ldc 105
    //   15: ldc_w 359
    //   18: invokestatic 362	com/tencent/mm/sdk/platformtools/Log:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: sipush 28839
    //   24: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: iconst_0
    //   28: ireturn
    //   29: aload_1
    //   30: getfield 264	com/tencent/mm/g/a/gf:dJV	Lcom/tencent/mm/g/a/gf$a;
    //   33: getfield 365	com/tencent/mm/g/a/gf$a:dJY	I
    //   36: iconst_2
    //   37: if_icmpne +35 -> 72
    //   40: aload_0
    //   41: getstatic 233	com/tencent/mm/plugin/subapp/a$a$a:FIY	Lcom/tencent/mm/plugin/subapp/a$a$a;
    //   44: invokespecial 240	com/tencent/mm/plugin/subapp/a$a:a	(Lcom/tencent/mm/plugin/subapp/a$a$a;)V
    //   47: aload_0
    //   48: getfield 72	com/tencent/mm/plugin/subapp/a$a:FIK	Ljava/util/Map;
    //   51: invokeinterface 368 1 0
    //   56: ldc 105
    //   58: ldc_w 370
    //   61: invokestatic 112	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: sipush 28839
    //   67: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: iconst_1
    //   71: ireturn
    //   72: aload_1
    //   73: getfield 264	com/tencent/mm/g/a/gf:dJV	Lcom/tencent/mm/g/a/gf$a;
    //   76: getfield 365	com/tencent/mm/g/a/gf$a:dJY	I
    //   79: iconst_1
    //   80: if_icmpne +26 -> 106
    //   83: aload_0
    //   84: getstatic 233	com/tencent/mm/plugin/subapp/a$a$a:FIY	Lcom/tencent/mm/plugin/subapp/a$a$a;
    //   87: invokespecial 240	com/tencent/mm/plugin/subapp/a$a:a	(Lcom/tencent/mm/plugin/subapp/a$a$a;)V
    //   90: ldc 105
    //   92: ldc_w 372
    //   95: invokestatic 112	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: sipush 28839
    //   101: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: iconst_1
    //   105: ireturn
    //   106: aload_1
    //   107: getfield 264	com/tencent/mm/g/a/gf:dJV	Lcom/tencent/mm/g/a/gf$a;
    //   110: getfield 365	com/tencent/mm/g/a/gf$a:dJY	I
    //   113: iconst_3
    //   114: if_icmpne +26 -> 140
    //   117: aload_0
    //   118: getstatic 375	com/tencent/mm/plugin/subapp/a$a$a:FIZ	Lcom/tencent/mm/plugin/subapp/a$a$a;
    //   121: invokespecial 240	com/tencent/mm/plugin/subapp/a$a:a	(Lcom/tencent/mm/plugin/subapp/a$a$a;)V
    //   124: ldc 105
    //   126: ldc_w 377
    //   129: invokestatic 112	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: sipush 28839
    //   135: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: iconst_1
    //   139: ireturn
    //   140: aload_1
    //   141: getfield 264	com/tencent/mm/g/a/gf:dJV	Lcom/tencent/mm/g/a/gf$a;
    //   144: getfield 365	com/tencent/mm/g/a/gf$a:dJY	I
    //   147: ifeq +39 -> 186
    //   150: ldc 105
    //   152: ldc_w 379
    //   155: iconst_1
    //   156: anewarray 123	java/lang/Object
    //   159: dup
    //   160: iconst_0
    //   161: aload_0
    //   162: getfield 254	com/tencent/mm/plugin/subapp/a$a:FII	Lcom/tencent/mm/g/a/gf;
    //   165: getfield 264	com/tencent/mm/g/a/gf:dJV	Lcom/tencent/mm/g/a/gf$a;
    //   168: getfield 365	com/tencent/mm/g/a/gf$a:dJY	I
    //   171: invokestatic 384	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   174: aastore
    //   175: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   178: sipush 28839
    //   181: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   184: iconst_0
    //   185: ireturn
    //   186: aload_0
    //   187: getfield 333	com/tencent/mm/plugin/subapp/a$a:lic	Z
    //   190: ifeq +19 -> 209
    //   193: ldc 105
    //   195: ldc_w 386
    //   198: invokestatic 193	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: sipush 28839
    //   204: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   207: iconst_0
    //   208: ireturn
    //   209: invokestatic 390	com/tencent/mm/modelvoice/o:bib	()Lcom/tencent/mm/modelvoice/w;
    //   212: ifnonnull +35 -> 247
    //   215: ldc 105
    //   217: new 392	java/lang/StringBuilder
    //   220: dup
    //   221: ldc_w 394
    //   224: invokespecial 395	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   227: invokestatic 399	com/tencent/mm/sdk/platformtools/Util:getStack	()Lcom/tencent/mm/sdk/platformtools/MMStack;
    //   230: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 406	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 409	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: sipush 28839
    //   242: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   245: iconst_0
    //   246: ireturn
    //   247: aload_0
    //   248: aload_1
    //   249: putfield 254	com/tencent/mm/plugin/subapp/a$a:FII	Lcom/tencent/mm/g/a/gf;
    //   252: aload_0
    //   253: getfield 254	com/tencent/mm/plugin/subapp/a$a:FII	Lcom/tencent/mm/g/a/gf;
    //   256: getfield 264	com/tencent/mm/g/a/gf:dJV	Lcom/tencent/mm/g/a/gf$a;
    //   259: getfield 346	com/tencent/mm/g/a/gf$a:dJX	Ljava/lang/String;
    //   262: astore_3
    //   263: aload_0
    //   264: getfield 254	com/tencent/mm/plugin/subapp/a$a:FII	Lcom/tencent/mm/g/a/gf;
    //   267: getfield 264	com/tencent/mm/g/a/gf:dJV	Lcom/tencent/mm/g/a/gf$a;
    //   270: getfield 267	com/tencent/mm/g/a/gf$a:fileName	Ljava/lang/String;
    //   273: astore 4
    //   275: aload_3
    //   276: invokestatic 260	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   279: ifne +11 -> 290
    //   282: aload 4
    //   284: invokestatic 260	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   287: ifeq +39 -> 326
    //   290: ldc 105
    //   292: ldc_w 411
    //   295: iconst_2
    //   296: anewarray 123	java/lang/Object
    //   299: dup
    //   300: iconst_0
    //   301: aload_3
    //   302: aastore
    //   303: dup
    //   304: iconst_1
    //   305: aload 4
    //   307: aastore
    //   308: invokestatic 413	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   311: aload_0
    //   312: getstatic 349	com/tencent/mm/plugin/subapp/a$a$a:FJa	Lcom/tencent/mm/plugin/subapp/a$a$a;
    //   315: invokespecial 240	com/tencent/mm/plugin/subapp/a$a:a	(Lcom/tencent/mm/plugin/subapp/a$a$a;)V
    //   318: sipush 28839
    //   321: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   324: iconst_0
    //   325: ireturn
    //   326: aload_0
    //   327: invokespecial 338	com/tencent/mm/plugin/subapp/a$a:fsL	()V
    //   330: aload_0
    //   331: getfield 72	com/tencent/mm/plugin/subapp/a$a:FIK	Ljava/util/Map;
    //   334: aload 4
    //   336: invokeinterface 417 2 0
    //   341: checkcast 82	java/lang/String
    //   344: astore 5
    //   346: aload 5
    //   348: invokestatic 260	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   351: ifne +41 -> 392
    //   354: ldc 105
    //   356: ldc_w 419
    //   359: iconst_2
    //   360: anewarray 123	java/lang/Object
    //   363: dup
    //   364: iconst_0
    //   365: aload_3
    //   366: aastore
    //   367: dup
    //   368: iconst_1
    //   369: aload 4
    //   371: aastore
    //   372: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   375: aload_0
    //   376: aload 5
    //   378: getstatic 341	com/tencent/mm/plugin/subapp/a$a$a:FIV	Lcom/tencent/mm/plugin/subapp/a$a$a;
    //   381: invokespecial 236	com/tencent/mm/plugin/subapp/a$a:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/subapp/a$a$a;)V
    //   384: sipush 28839
    //   387: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   390: iconst_1
    //   391: ireturn
    //   392: invokestatic 291	com/tencent/mm/modelvoice/o:bic	()Lcom/tencent/mm/storage/cv;
    //   395: aload 4
    //   397: invokevirtual 422	com/tencent/mm/storage/cv:bkZ	(Ljava/lang/String;)Lcom/tencent/mm/storage/cu;
    //   400: astore 5
    //   402: aload 5
    //   404: putstatic 277	com/tencent/mm/plugin/subapp/a:FIt	Lcom/tencent/mm/storage/cu;
    //   407: aload 5
    //   409: ifnull +57 -> 466
    //   412: getstatic 277	com/tencent/mm/plugin/subapp/a:FIt	Lcom/tencent/mm/storage/cu;
    //   415: getfield 282	com/tencent/mm/storage/cu:field_content	Ljava/lang/String;
    //   418: invokestatic 260	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   421: ifne +45 -> 466
    //   424: ldc 105
    //   426: ldc_w 424
    //   429: iconst_2
    //   430: anewarray 123	java/lang/Object
    //   433: dup
    //   434: iconst_0
    //   435: aload_3
    //   436: aastore
    //   437: dup
    //   438: iconst_1
    //   439: aload 4
    //   441: aastore
    //   442: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   445: aload_0
    //   446: getstatic 277	com/tencent/mm/plugin/subapp/a:FIt	Lcom/tencent/mm/storage/cu;
    //   449: getfield 282	com/tencent/mm/storage/cu:field_content	Ljava/lang/String;
    //   452: getstatic 341	com/tencent/mm/plugin/subapp/a$a$a:FIV	Lcom/tencent/mm/plugin/subapp/a$a$a;
    //   455: invokespecial 236	com/tencent/mm/plugin/subapp/a$a:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/subapp/a$a$a;)V
    //   458: sipush 28839
    //   461: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   464: iconst_1
    //   465: ireturn
    //   466: ldc 105
    //   468: ldc_w 426
    //   471: iconst_1
    //   472: anewarray 123	java/lang/Object
    //   475: dup
    //   476: iconst_0
    //   477: aload_1
    //   478: getfield 264	com/tencent/mm/g/a/gf:dJV	Lcom/tencent/mm/g/a/gf$a;
    //   481: getfield 429	com/tencent/mm/g/a/gf$a:scene	I
    //   484: invokestatic 384	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   487: aastore
    //   488: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   491: aload_0
    //   492: invokestatic 390	com/tencent/mm/modelvoice/o:bib	()Lcom/tencent/mm/modelvoice/w;
    //   495: aload 4
    //   497: invokevirtual 435	com/tencent/mm/modelvoice/w:Rr	(Ljava/lang/String;)Lcom/tencent/mm/modelvoice/r;
    //   500: putfield 114	com/tencent/mm/plugin/subapp/a$a:FID	Lcom/tencent/mm/modelvoice/r;
    //   503: aload_0
    //   504: getfield 114	com/tencent/mm/plugin/subapp/a$a:FID	Lcom/tencent/mm/modelvoice/r;
    //   507: ifnonnull +142 -> 649
    //   510: ldc 105
    //   512: ldc_w 437
    //   515: iconst_2
    //   516: anewarray 123	java/lang/Object
    //   519: dup
    //   520: iconst_0
    //   521: aload_3
    //   522: aastore
    //   523: dup
    //   524: iconst_1
    //   525: aload 4
    //   527: aastore
    //   528: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   531: aload_0
    //   532: new 116	com/tencent/mm/modelvoice/r
    //   535: dup
    //   536: invokespecial 438	com/tencent/mm/modelvoice/r:<init>	()V
    //   539: putfield 114	com/tencent/mm/plugin/subapp/a$a:FID	Lcom/tencent/mm/modelvoice/r;
    //   542: aload_0
    //   543: getfield 114	com/tencent/mm/plugin/subapp/a$a:FID	Lcom/tencent/mm/modelvoice/r;
    //   546: aload 4
    //   548: putfield 145	com/tencent/mm/modelvoice/r:fileName	Ljava/lang/String;
    //   551: aload_0
    //   552: getfield 114	com/tencent/mm/plugin/subapp/a$a:FID	Lcom/tencent/mm/modelvoice/r;
    //   555: invokestatic 179	java/lang/System:currentTimeMillis	()J
    //   558: ldc2_w 439
    //   561: ldiv
    //   562: putfield 443	com/tencent/mm/modelvoice/r:createTime	J
    //   565: aload_0
    //   566: getfield 114	com/tencent/mm/plugin/subapp/a$a:FID	Lcom/tencent/mm/modelvoice/r;
    //   569: aload 4
    //   571: putfield 137	com/tencent/mm/modelvoice/r:clientId	Ljava/lang/String;
    //   574: aload_0
    //   575: getfield 114	com/tencent/mm/plugin/subapp/a$a:FID	Lcom/tencent/mm/modelvoice/r;
    //   578: invokestatic 179	java/lang/System:currentTimeMillis	()J
    //   581: ldc2_w 439
    //   584: ldiv
    //   585: putfield 446	com/tencent/mm/modelvoice/r:jsm	J
    //   588: aload_0
    //   589: getfield 114	com/tencent/mm/plugin/subapp/a$a:FID	Lcom/tencent/mm/modelvoice/r;
    //   592: iconst_1
    //   593: putfield 449	com/tencent/mm/modelvoice/r:status	I
    //   596: aload_1
    //   597: getfield 264	com/tencent/mm/g/a/gf:dJV	Lcom/tencent/mm/g/a/gf$a;
    //   600: getfield 429	com/tencent/mm/g/a/gf$a:scene	I
    //   603: bipush 8
    //   605: if_icmpne +196 -> 801
    //   608: aload_0
    //   609: getfield 114	com/tencent/mm/plugin/subapp/a$a:FID	Lcom/tencent/mm/modelvoice/r;
    //   612: iconst_m1
    //   613: putfield 452	com/tencent/mm/modelvoice/r:jso	I
    //   616: aload 4
    //   618: invokestatic 458	com/tencent/mm/modelvoice/q:Qy	(Ljava/lang/String;)I
    //   621: istore_2
    //   622: ldc 105
    //   624: ldc_w 460
    //   627: iconst_1
    //   628: anewarray 123	java/lang/Object
    //   631: dup
    //   632: iconst_0
    //   633: iload_2
    //   634: invokestatic 384	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   637: aastore
    //   638: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   641: aload_0
    //   642: getfield 114	com/tencent/mm/plugin/subapp/a$a:FID	Lcom/tencent/mm/modelvoice/r;
    //   645: iload_2
    //   646: putfield 140	com/tencent/mm/modelvoice/r:iKP	I
    //   649: aload_0
    //   650: getfield 114	com/tencent/mm/plugin/subapp/a$a:FID	Lcom/tencent/mm/modelvoice/r;
    //   653: getfield 452	com/tencent/mm/modelvoice/r:jso	I
    //   656: ifge +191 -> 847
    //   659: ldc 105
    //   661: ldc_w 462
    //   664: invokestatic 112	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   667: aload_0
    //   668: aload_0
    //   669: getfield 254	com/tencent/mm/plugin/subapp/a$a:FII	Lcom/tencent/mm/g/a/gf;
    //   672: getfield 264	com/tencent/mm/g/a/gf:dJV	Lcom/tencent/mm/g/a/gf$a;
    //   675: getfield 429	com/tencent/mm/g/a/gf$a:scene	I
    //   678: putfield 147	com/tencent/mm/plugin/subapp/a$a:FIL	I
    //   681: ldc 105
    //   683: ldc_w 464
    //   686: iconst_3
    //   687: anewarray 123	java/lang/Object
    //   690: dup
    //   691: iconst_0
    //   692: aload_0
    //   693: getfield 149	com/tencent/mm/plugin/subapp/a$a:dRL	Ljava/lang/String;
    //   696: aastore
    //   697: dup
    //   698: iconst_1
    //   699: aload_0
    //   700: getfield 151	com/tencent/mm/plugin/subapp/a$a:toUser	Ljava/lang/String;
    //   703: aastore
    //   704: dup
    //   705: iconst_2
    //   706: aload_0
    //   707: getfield 147	com/tencent/mm/plugin/subapp/a$a:FIL	I
    //   710: invokestatic 384	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   713: aastore
    //   714: invokestatic 320	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   717: aconst_null
    //   718: astore_3
    //   719: aconst_null
    //   720: astore_1
    //   721: aload_0
    //   722: getfield 114	com/tencent/mm/plugin/subapp/a$a:FID	Lcom/tencent/mm/modelvoice/r;
    //   725: getfield 145	com/tencent/mm/modelvoice/r:fileName	Ljava/lang/String;
    //   728: invokestatic 470	com/tencent/mm/modelvoice/s:Rf	(Ljava/lang/String;)Lcom/tencent/mm/modelvoice/b;
    //   731: astore 4
    //   733: aload 4
    //   735: ifnull +335 -> 1070
    //   738: aload 4
    //   740: astore_1
    //   741: aload 4
    //   743: astore_3
    //   744: aload 4
    //   746: invokeinterface 475 1 0
    //   751: istore_2
    //   752: aload 4
    //   754: astore_1
    //   755: aload 4
    //   757: astore_3
    //   758: aload_0
    //   759: iload_2
    //   760: putfield 142	com/tencent/mm/plugin/subapp/a$a:FIE	I
    //   763: aload 4
    //   765: ifnull +10 -> 775
    //   768: aload 4
    //   770: invokeinterface 478 1 0
    //   775: aload_0
    //   776: iconst_1
    //   777: putfield 333	com/tencent/mm/plugin/subapp/a$a:lic	Z
    //   780: aload_0
    //   781: bipush 20
    //   783: putfield 335	com/tencent/mm/plugin/subapp/a$a:FIJ	I
    //   786: aload_0
    //   787: getstatic 481	com/tencent/mm/plugin/subapp/a$a$a:FIR	Lcom/tencent/mm/plugin/subapp/a$a$a;
    //   790: invokespecial 240	com/tencent/mm/plugin/subapp/a$a:a	(Lcom/tencent/mm/plugin/subapp/a$a$a;)V
    //   793: sipush 28839
    //   796: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   799: iconst_1
    //   800: ireturn
    //   801: aload_0
    //   802: getfield 114	com/tencent/mm/plugin/subapp/a$a:FID	Lcom/tencent/mm/modelvoice/r;
    //   805: aload_3
    //   806: invokestatic 484	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   809: invokevirtual 487	java/lang/Integer:intValue	()I
    //   812: putfield 452	com/tencent/mm/modelvoice/r:jso	I
    //   815: goto -199 -> 616
    //   818: astore_1
    //   819: ldc 105
    //   821: aload_1
    //   822: ldc_w 489
    //   825: iconst_0
    //   826: anewarray 123	java/lang/Object
    //   829: invokestatic 493	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   832: aload_0
    //   833: getstatic 349	com/tencent/mm/plugin/subapp/a$a$a:FJa	Lcom/tencent/mm/plugin/subapp/a$a$a;
    //   836: invokespecial 240	com/tencent/mm/plugin/subapp/a$a:a	(Lcom/tencent/mm/plugin/subapp/a$a$a;)V
    //   839: sipush 28839
    //   842: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   845: iconst_1
    //   846: ireturn
    //   847: ldc_w 495
    //   850: invokestatic 501	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   853: checkcast 495	com/tencent/mm/plugin/messenger/foundation/a/l
    //   856: invokeinterface 505 1 0
    //   861: aload_0
    //   862: getfield 114	com/tencent/mm/plugin/subapp/a$a:FID	Lcom/tencent/mm/modelvoice/r;
    //   865: getfield 452	com/tencent/mm/modelvoice/r:jso	I
    //   868: i2l
    //   869: invokeinterface 511 3 0
    //   874: astore_1
    //   875: aload_1
    //   876: getfield 516	com/tencent/mm/g/c/eo:field_isSend	I
    //   879: iconst_1
    //   880: if_icmpne +93 -> 973
    //   883: aload_0
    //   884: invokestatic 521	com/tencent/mm/model/z:aTY	()Ljava/lang/String;
    //   887: putfield 149	com/tencent/mm/plugin/subapp/a$a:dRL	Ljava/lang/String;
    //   890: aload_0
    //   891: getfield 254	com/tencent/mm/plugin/subapp/a$a:FII	Lcom/tencent/mm/g/a/gf;
    //   894: getfield 264	com/tencent/mm/g/a/gf:dJV	Lcom/tencent/mm/g/a/gf$a;
    //   897: getfield 429	com/tencent/mm/g/a/gf$a:scene	I
    //   900: iconst_4
    //   901: if_icmpeq +17 -> 918
    //   904: aload_0
    //   905: getfield 254	com/tencent/mm/plugin/subapp/a$a:FII	Lcom/tencent/mm/g/a/gf;
    //   908: getfield 264	com/tencent/mm/g/a/gf:dJV	Lcom/tencent/mm/g/a/gf$a;
    //   911: getfield 429	com/tencent/mm/g/a/gf$a:scene	I
    //   914: iconst_5
    //   915: if_icmpne +47 -> 962
    //   918: ldc_w 523
    //   921: invokestatic 501	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   924: checkcast 523	com/tencent/mm/api/k
    //   927: aload_1
    //   928: getfield 526	com/tencent/mm/g/c/eo:field_bizChatId	J
    //   931: invokeinterface 530 3 0
    //   936: astore_1
    //   937: aload_1
    //   938: ifnull +14 -> 952
    //   941: aload_0
    //   942: aload_1
    //   943: getfield 535	com/tencent/mm/al/a/c:field_bizChatServId	Ljava/lang/String;
    //   946: putfield 151	com/tencent/mm/plugin/subapp/a$a:toUser	Ljava/lang/String;
    //   949: goto -282 -> 667
    //   952: aload_0
    //   953: ldc_w 537
    //   956: putfield 151	com/tencent/mm/plugin/subapp/a$a:toUser	Ljava/lang/String;
    //   959: goto -292 -> 667
    //   962: aload_0
    //   963: aload_1
    //   964: getfield 540	com/tencent/mm/g/c/eo:field_talker	Ljava/lang/String;
    //   967: putfield 151	com/tencent/mm/plugin/subapp/a$a:toUser	Ljava/lang/String;
    //   970: goto -303 -> 667
    //   973: aload_1
    //   974: getfield 516	com/tencent/mm/g/c/eo:field_isSend	I
    //   977: ifne -310 -> 667
    //   980: aload_0
    //   981: invokestatic 521	com/tencent/mm/model/z:aTY	()Ljava/lang/String;
    //   984: putfield 151	com/tencent/mm/plugin/subapp/a$a:toUser	Ljava/lang/String;
    //   987: aload_0
    //   988: getfield 254	com/tencent/mm/plugin/subapp/a$a:FII	Lcom/tencent/mm/g/a/gf;
    //   991: getfield 264	com/tencent/mm/g/a/gf:dJV	Lcom/tencent/mm/g/a/gf$a;
    //   994: getfield 429	com/tencent/mm/g/a/gf$a:scene	I
    //   997: iconst_4
    //   998: if_icmpeq +17 -> 1015
    //   1001: aload_0
    //   1002: getfield 254	com/tencent/mm/plugin/subapp/a$a:FII	Lcom/tencent/mm/g/a/gf;
    //   1005: getfield 264	com/tencent/mm/g/a/gf:dJV	Lcom/tencent/mm/g/a/gf$a;
    //   1008: getfield 429	com/tencent/mm/g/a/gf$a:scene	I
    //   1011: iconst_5
    //   1012: if_icmpne +47 -> 1059
    //   1015: ldc_w 523
    //   1018: invokestatic 501	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1021: checkcast 523	com/tencent/mm/api/k
    //   1024: aload_1
    //   1025: getfield 526	com/tencent/mm/g/c/eo:field_bizChatId	J
    //   1028: invokeinterface 530 3 0
    //   1033: astore_1
    //   1034: aload_1
    //   1035: ifnull +14 -> 1049
    //   1038: aload_0
    //   1039: aload_1
    //   1040: getfield 535	com/tencent/mm/al/a/c:field_bizChatServId	Ljava/lang/String;
    //   1043: putfield 149	com/tencent/mm/plugin/subapp/a$a:dRL	Ljava/lang/String;
    //   1046: goto -379 -> 667
    //   1049: aload_0
    //   1050: ldc_w 537
    //   1053: putfield 149	com/tencent/mm/plugin/subapp/a$a:dRL	Ljava/lang/String;
    //   1056: goto -389 -> 667
    //   1059: aload_0
    //   1060: aload_1
    //   1061: getfield 540	com/tencent/mm/g/c/eo:field_talker	Ljava/lang/String;
    //   1064: putfield 149	com/tencent/mm/plugin/subapp/a$a:dRL	Ljava/lang/String;
    //   1067: goto -400 -> 667
    //   1070: iconst_m1
    //   1071: istore_2
    //   1072: goto -320 -> 752
    //   1075: astore 4
    //   1077: aload_1
    //   1078: astore_3
    //   1079: ldc 105
    //   1081: aload 4
    //   1083: ldc_w 542
    //   1086: iconst_1
    //   1087: anewarray 123	java/lang/Object
    //   1090: dup
    //   1091: iconst_0
    //   1092: aload_0
    //   1093: getfield 114	com/tencent/mm/plugin/subapp/a$a:FID	Lcom/tencent/mm/modelvoice/r;
    //   1096: getfield 145	com/tencent/mm/modelvoice/r:fileName	Ljava/lang/String;
    //   1099: aastore
    //   1100: invokestatic 493	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1103: aload_1
    //   1104: astore_3
    //   1105: aload_0
    //   1106: iconst_m1
    //   1107: putfield 142	com/tencent/mm/plugin/subapp/a$a:FIE	I
    //   1110: aload_1
    //   1111: ifnull -336 -> 775
    //   1114: aload_1
    //   1115: invokeinterface 478 1 0
    //   1120: goto -345 -> 775
    //   1123: astore_1
    //   1124: goto -349 -> 775
    //   1127: astore_1
    //   1128: aload_3
    //   1129: ifnull +9 -> 1138
    //   1132: aload_3
    //   1133: invokeinterface 478 1 0
    //   1138: sipush 28839
    //   1141: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1144: aload_1
    //   1145: athrow
    //   1146: astore_1
    //   1147: goto -372 -> 775
    //   1150: astore_3
    //   1151: goto -13 -> 1138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1154	0	this	a
    //   0	1154	1	paramgf	gf
    //   621	451	2	i	int
    //   262	871	3	localObject1	Object
    //   1150	1	3	localThrowable1	java.lang.Throwable
    //   273	496	4	localObject2	Object
    //   1075	7	4	localThrowable2	java.lang.Throwable
    //   344	64	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   503	616	818	java/lang/Exception
    //   616	649	818	java/lang/Exception
    //   801	815	818	java/lang/Exception
    //   721	733	1075	java/lang/Throwable
    //   744	752	1075	java/lang/Throwable
    //   758	763	1075	java/lang/Throwable
    //   1114	1120	1123	java/lang/Throwable
    //   721	733	1127	finally
    //   744	752	1127	finally
    //   758	763	1127	finally
    //   1079	1103	1127	finally
    //   1105	1110	1127	finally
    //   768	775	1146	java/lang/Throwable
    //   1132	1138	1150	java/lang/Throwable
  }
  
  private cu aSJ(String paramString)
  {
    AppMethodBeat.i(28844);
    Log.i("MicroMsg.SubCoreSubapp", "createVoiceTT localId(%s) , fileName(%s).", new Object[] { this.FII.dJV.dJX, this.FII.dJV.fileName });
    cu localcu = new cu();
    localcu.field_msgId = Long.valueOf(this.FII.dJV.dJX).longValue();
    localcu.bkY(this.FII.dJV.fileName);
    localcu.field_content = paramString;
    AppMethodBeat.o(28844);
    return localcu;
  }
  
  private void b(String paramString, a parama)
  {
    AppMethodBeat.i(28843);
    if (!this.hkH)
    {
      AppMethodBeat.o(28843);
      return;
    }
    if (this.FID == null)
    {
      AppMethodBeat.o(28843);
      return;
    }
    int i;
    int j;
    if (paramString != null)
    {
      i = paramString.length();
      if (parama != a.FIV) {
        break label173;
      }
      if (Util.isNullOrNil(paramString)) {
        break label155;
      }
      j = 1;
    }
    for (;;)
    {
      Log.i("MicroMsg.SubCoreSubapp", "alvinluo transformTextResult voiceId: %s, wordCount: %d, waitTime: %d, animationTime: %d, transformResult: %d", new Object[] { this.FID.clientId, Integer.valueOf(i), Integer.valueOf(this.dKi), Integer.valueOf(this.dKj), Integer.valueOf(j) });
      if (j != 0) {
        com.tencent.mm.plugin.subapp.e.b.d(this.FID.clientId, i, this.dKi, this.dKj, j);
      }
      AppMethodBeat.o(28843);
      return;
      i = 0;
      break;
      label155:
      this.dKi = 0;
      this.dKj = 0;
      i = 0;
      j = 3;
      continue;
      label173:
      this.dKi = 0;
      this.dKj = 0;
      if (parama == a.FIY)
      {
        j = 5;
        i = 0;
      }
      else if (parama == a.FJb)
      {
        i = 0;
        j = 3;
      }
      else if (parama == a.FJa)
      {
        j = 4;
        i = 0;
      }
      else if (parama == a.FJc)
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
  
  private void fsL()
  {
    this.FIM = true;
    this.FIN = 0L;
    this.FIO = 0L;
    this.dKi = 0;
    this.dKj = 0;
    this.hkH = false;
  }
  
  private void fsM()
  {
    AppMethodBeat.i(28841);
    if (this.FIM)
    {
      this.FIM = false;
      this.FIN = System.currentTimeMillis();
      this.dKi = ((int)(this.FIN - this.FIO));
    }
    AppMethodBeat.o(28841);
  }
  
  public final void onSceneEnd(final int paramInt1, int paramInt2, String paramString, q paramq)
  {
    paramString = null;
    Object localObject = null;
    AppMethodBeat.i(28845);
    Log.i("MicroMsg.SubCoreSubapp", "onSceneEnd errType(%d) , errCode(%d).", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0)) {}
    switch (paramq.getType())
    {
    default: 
      AppMethodBeat.o(28845);
      return;
    case 546: 
      if (this.FIA.mState == com.tencent.mm.plugin.subapp.ui.voicetranstext.a.FNG)
      {
        Log.i("MicroMsg.SubCoreSubapp", "check result: done");
        a(a.FIV);
        fsM();
        this.dKj = 0;
        this.hkH = true;
        paramString = localObject;
        if (this.FIA.ftu()) {
          paramString = this.FIA.FNH.NpE;
        }
        a(paramString, a.FIV);
        AppMethodBeat.o(28845);
        return;
      }
      if (this.FIA.mState == com.tencent.mm.plugin.subapp.ui.voicetranstext.a.FNF)
      {
        if (this.FIA.FNH != null) {
          Util.isNullOrNil(this.FIA.FNH.NpE);
        }
        Log.i("MicroMsg.SubCoreSubapp", "check result: processing");
        a(a.FIU);
        AppMethodBeat.o(28845);
        return;
      }
      if (this.FIA.mState == com.tencent.mm.plugin.subapp.ui.voicetranstext.a.FNE)
      {
        Log.i("MicroMsg.SubCoreSubapp", "check result: not exist");
        a(a.FIS);
        AppMethodBeat.o(28845);
        return;
      }
      if (this.FIA.FNJ != null)
      {
        AppMethodBeat.o(28845);
        return;
      }
      break;
    case 547: 
      if (this.FIB.ftw())
      {
        Log.i("MicroMsg.SubCoreSubapp", "succeed upload");
        a(a.FIU);
        AppMethodBeat.o(28845);
        return;
      }
      Log.d("MicroMsg.SubCoreSubapp", "start upload more: start:%d, len:%d", new Object[] { Integer.valueOf(this.FIB.FNI.BsG), Integer.valueOf(this.FIB.FNI.BsH) });
      a(a.FIT);
      AppMethodBeat.o(28845);
      return;
    case 548: 
      paramInt1 = this.FIC.FNL;
      Log.i("MicroMsg.SubCoreSubapp", "get mIntervalSec:%ds", new Object[] { Integer.valueOf(paramInt1) });
      this.FIF = false;
      fsM();
      if ((!this.FIC.isComplete()) && (this.FIC.ftu()))
      {
        Log.i("MicroMsg.SubCoreSubapp", "refreshResult result");
        paramq = this.FIC.FNH.NpE;
        if (this.FII != null)
        {
          this.FII.dJW.brW = false;
          this.FII.dJW.content = paramq;
          Log.i("MicroMsg.SubCoreSubapp", "refreshResult result is null ? : %s", new Object[] { Boolean.valueOf(Util.isNullOrNil(paramq)) });
          if (this.FII.dJV.dJZ != null) {
            this.FII.dJV.dJZ.run();
          }
        }
      }
      while (this.FIC.isComplete())
      {
        Log.i("MicroMsg.SubCoreSubapp", "succeed get");
        if (this.FIC.ftu()) {
          paramString = this.FIC.FNH.NpE;
        }
        a(a.FIV);
        this.dKj = ((int)(System.currentTimeMillis() - this.FIN));
        this.hkH = true;
        a(paramString, a.FIV);
        AppMethodBeat.o(28845);
        return;
        if (!this.FIC.ftu()) {
          Log.d("MicroMsg.SubCoreSubapp", "result not valid");
        }
      }
      Log.i("MicroMsg.SubCoreSubapp", "do get again after:%ds", new Object[] { Integer.valueOf(paramInt1) });
      if (!this.FIG)
      {
        paramInt2 = this.FIJ - 1;
        this.FIJ = paramInt2;
        if (paramInt2 < 0)
        {
          Log.e("MicroMsg.SubCoreSubapp", "Has try to translate delay for %d times.", new Object[] { Integer.valueOf(20) });
          a(a.FJb);
          AppMethodBeat.o(28845);
          return;
        }
        if (this.FIH == null) {
          this.FIH = new MTimerHandler(new MTimerHandler.CallBack()
          {
            public final boolean onTimerExpired()
            {
              AppMethodBeat.i(28834);
              if (a.a.a(a.a.this))
              {
                AppMethodBeat.o(28834);
                return false;
              }
              Log.d("MicroMsg.SubCoreSubapp", "timmer get, delay:%d", new Object[] { Integer.valueOf(paramInt1) });
              a.a.a(a.a.this, a.a.a.FIU);
              AppMethodBeat.o(28834);
              return false;
            }
          }, false);
        }
        this.FIH.startTimer(paramInt1 * 1000);
      }
      AppMethodBeat.o(28845);
      return;
      if (paramInt1 == 2)
      {
        a(a.FJc);
        AppMethodBeat.o(28845);
        return;
      }
      a(a.FJb);
    }
    AppMethodBeat.o(28845);
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(28837);
      FIR = new a("CHECK", 0);
      FIS = new a("UPLOAD", 1);
      FIT = new a("UPLOAD_MORE", 2);
      FIU = new a("GET", 3);
      FIV = new a("FINISH", 4);
      FIW = new a("ERROR", 5);
      FIY = new a("CANCEL", 6);
      FIZ = new a("CANCEL_BY_USER", 7);
      FJa = new a("LOCAL_ERROR", 8);
      FJb = new a("SERVER_ERROR", 9);
      FJc = new a("NETWORK_OVERTIME", 10);
      FJd = new a[] { FIR, FIS, FIT, FIU, FIV, FIW, FIY, FIZ, FJa, FJb, FJc };
      AppMethodBeat.o(28837);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.a.a
 * JD-Core Version:    0.7.0.1
 */