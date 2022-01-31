package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.aw;
import com.tencent.mm.i.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.f;
import com.tencent.mm.modelvideo.f.a;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.bng;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class as
  implements f.a
{
  boolean fWq;
  boolean fWr;
  f fWu;
  az riB;
  LinkedList<az> riC;
  Map<String, az> riD;
  LinkedList<com.tencent.mm.plugin.sns.storage.n> riE;
  c riF;
  c rir;
  c ris;
  
  public as()
  {
    AppMethodBeat.i(36657);
    this.riC = null;
    this.riD = null;
    this.fWu = null;
    this.riE = null;
    this.fWq = false;
    this.fWr = false;
    this.riF = new as.9(this);
    this.rir = new as.10(this);
    this.ris = new c() {};
    this.riB = null;
    this.riC = new LinkedList();
    this.riD = new HashMap();
    this.riE = new LinkedList();
    com.tencent.mm.sdk.b.a.ymk.c(this.riF);
    com.tencent.mm.sdk.b.a.ymk.c(this.rir);
    com.tencent.mm.sdk.b.a.ymk.c(this.ris);
    AppMethodBeat.o(36657);
  }
  
  public final void a(f paramf, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(36660);
    if (paramf == null)
    {
      ab.e("MicroMsg.SnsVideoService", "%d on preload finish but scene is null?", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(36660);
      return;
    }
    if (this.fWu != paramf) {
      ab.w("MicroMsg.SnsVideoService", "%d on preload finish, but scene callback not same object.", new Object[] { Integer.valueOf(hashCode()) });
    }
    ab.i("MicroMsg.SnsVideoService", "%d preload video[%s] finish success[%b] range[%d, %d]", new Object[] { Integer.valueOf(hashCode()), paramf.alv(), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    g.RO().ac(new as.4(this, paramf));
    AppMethodBeat.o(36660);
  }
  
  final boolean a(az paramaz, boolean paramBoolean)
  {
    AppMethodBeat.i(36665);
    Object localObject1 = ar.a(paramaz.crk, paramaz.cIc);
    if (!bo.isNullOrNil((String)localObject1))
    {
      ab.i("MicroMsg.SnsVideoService", "this video[%s] already download finish, do nothing. [%s, %s]", new Object[] { paramaz.fVf, paramaz.crk, localObject1 });
      AppMethodBeat.o(36665);
      return false;
    }
    boolean bool = com.tencent.mm.vfs.e.um(ar.aaF(paramaz.cIc.Id));
    localObject1 = ar.D(paramaz.cIc);
    Object localObject2 = ar.aaG(paramaz.crk);
    if (localObject2 == null) {
      ar.dp(paramaz.crk, paramaz.edL);
    }
    for (;;)
    {
      ab.i("MicroMsg.SnsVideoService", "prepare stream download sns video %s mkDir %b", new Object[] { localObject1, Boolean.valueOf(bool) });
      localObject2 = new com.tencent.mm.plugin.sns.model.a.a(paramaz.cIc.Id);
      ((com.tencent.mm.plugin.sns.model.a.a)localObject2).reH = paramaz.cIc;
      com.tencent.mm.storage.az localaz = com.tencent.mm.storage.az.dxG();
      localaz.oLs = paramaz.fDT;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject2).rjD = localaz;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject2).rjB = true;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject2).url = paramaz.cIc.Url;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject2).rjA = false;
      com.tencent.mm.modelvideo.n.alC();
      com.tencent.mm.modelvideo.o.alF();
      localObject1 = com.tencent.mm.al.e.a(((com.tencent.mm.plugin.sns.model.a.a)localObject2).rjD, ((com.tencent.mm.plugin.sns.model.a.a)localObject2).url, (String)localObject1, ar.ve(paramaz.crk), paramaz.edJ);
      if (localObject1 != null) {
        break;
      }
      AppMethodBeat.o(36665);
      return false;
      ar.c((s)localObject2, paramaz.edL);
    }
    localObject2 = paramaz.rjz;
    ((h)localObject1).edK = ((String)localObject2);
    ((h)localObject1).czp = ((String)localObject2);
    try
    {
      localObject2 = ak.p(ag.cpf().abv(paramaz.crk));
      if (localObject2 != null)
      {
        ((h)localObject1).czw = ((SnsObject)localObject2).Id;
        ((h)localObject1).edO = ((SnsObject)localObject2).PreDownloadInfo.xBv;
      }
    }
    catch (Exception localException)
    {
      label342:
      break label342;
    }
    this.riB = paramaz;
    this.riB.fVf = ((h)localObject1).field_mediaId;
    ab.i("MicroMsg.SnsVideoService", "start stream download sns video cdnMediaId %s delay %b", new Object[] { this.riB.fVf, Boolean.valueOf(paramBoolean) });
    com.tencent.mm.modelvideo.o.alF().a((h)localObject1, paramBoolean);
    AppMethodBeat.o(36665);
    return true;
  }
  
  public final boolean a(bcs parambcs, int paramInt1, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(36662);
    if (parambcs.xrR == 2)
    {
      ab.w("MicroMsg.SnsVideoService", "add video task, but url is weixin, do nothing");
      AppMethodBeat.o(36662);
      return false;
    }
    az localaz = new az();
    localaz.fVf = ar.be(paramInt1, parambcs.Url);
    localaz.cIc = parambcs;
    localaz.fDT = paramInt1;
    localaz.crk = paramString;
    paramInt1 = i;
    if (paramBoolean1) {
      paramInt1 = 1;
    }
    localaz.edJ = paramInt1;
    localaz.edL = paramInt2;
    g.RM();
    g.RO().ac(new as.6(this, localaz, paramBoolean2));
    if (paramBoolean2) {
      cpL();
    }
    AppMethodBeat.o(36662);
    return true;
  }
  
  public final void cpI()
  {
    AppMethodBeat.i(36658);
    ab.d("MicroMsg.SnsVideoService", "%d stop preload %s", new Object[] { Integer.valueOf(hashCode()), bo.dtY() });
    g.RO().ac(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36644);
        if (as.this.fWu != null) {
          as.this.fWu.stop();
        }
        as.this.fWu = null;
        AppMethodBeat.o(36644);
      }
    });
    AppMethodBeat.o(36658);
  }
  
  final void cpJ()
  {
    AppMethodBeat.i(36659);
    g.RO().ac(new as.3(this));
    AppMethodBeat.o(36659);
  }
  
  /* Error */
  final boolean cpK()
  {
    // Byte code:
    //   0: ldc_w 391
    //   3: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 395	com/tencent/mm/sdk/platformtools/bo:yB	()J
    //   9: lstore_2
    //   10: ldc_w 397
    //   13: invokestatic 401	com/tencent/mm/kernel/g:E	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   16: checkcast 397	com/tencent/mm/plugin/zero/b/a
    //   19: invokeinterface 405 1 0
    //   24: ldc_w 407
    //   27: iconst_1
    //   28: invokevirtual 413	com/tencent/mm/m/e:getInt	(Ljava/lang/String;I)I
    //   31: istore_1
    //   32: invokestatic 416	com/tencent/mm/sdk/platformtools/bo:aox	()J
    //   35: iload_1
    //   36: i2l
    //   37: ldc2_w 417
    //   40: lmul
    //   41: lsub
    //   42: lstore 4
    //   44: ldc 114
    //   46: ldc_w 420
    //   49: iconst_4
    //   50: anewarray 4	java/lang/Object
    //   53: dup
    //   54: iconst_0
    //   55: aload_0
    //   56: invokevirtual 120	java/lang/Object:hashCode	()I
    //   59: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   62: aastore
    //   63: dup
    //   64: iconst_1
    //   65: iconst_1
    //   66: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   69: aastore
    //   70: dup
    //   71: iconst_2
    //   72: sipush 130
    //   75: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   78: aastore
    //   79: dup
    //   80: iconst_3
    //   81: lload 4
    //   83: invokestatic 425	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   86: aastore
    //   87: invokestatic 152	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   90: invokestatic 429	com/tencent/mm/modelvideo/o:alE	()Lcom/tencent/mm/modelvideo/t;
    //   93: sipush 130
    //   96: lload 4
    //   98: invokevirtual 435	com/tencent/mm/modelvideo/t:x	(IJ)Ljava/util/List;
    //   101: astore 6
    //   103: aload 6
    //   105: ifnull +13 -> 118
    //   108: aload 6
    //   110: invokeinterface 440 1 0
    //   115: ifeq +11 -> 126
    //   118: ldc_w 391
    //   121: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   124: iconst_0
    //   125: ireturn
    //   126: aload 6
    //   128: invokeinterface 444 1 0
    //   133: astore 7
    //   135: iconst_0
    //   136: istore_1
    //   137: aload 7
    //   139: invokeinterface 449 1 0
    //   144: ifeq +203 -> 347
    //   147: aload 7
    //   149: invokeinterface 453 1 0
    //   154: checkcast 455	com/tencent/mm/modelvideo/s
    //   157: astore 8
    //   159: aload 8
    //   161: ifnull -24 -> 137
    //   164: aload 8
    //   166: invokevirtual 458	com/tencent/mm/modelvideo/s:getFileName	()Ljava/lang/String;
    //   169: invokestatic 461	com/tencent/mm/plugin/sns/model/ar:aaE	(Ljava/lang/String;)Ljava/lang/String;
    //   172: astore 9
    //   174: invokestatic 298	com/tencent/mm/plugin/sns/model/ag:cpf	()Lcom/tencent/mm/plugin/sns/storage/o;
    //   177: aload 9
    //   179: invokevirtual 304	com/tencent/mm/plugin/sns/storage/o:abv	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sns/storage/n;
    //   182: invokevirtual 467	com/tencent/mm/plugin/sns/storage/n:csh	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   185: getfield 473	com/tencent/mm/protocal/protobuf/TimeLineObject:xTS	Lcom/tencent/mm/protocal/protobuf/vi;
    //   188: getfield 478	com/tencent/mm/protocal/protobuf/vi:wOa	Ljava/util/LinkedList;
    //   191: iconst_0
    //   192: invokevirtual 482	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   195: checkcast 189	com/tencent/mm/protocal/protobuf/bcs
    //   198: invokestatic 205	com/tencent/mm/plugin/sns/model/ar:D	(Lcom/tencent/mm/protocal/protobuf/bcs;)Ljava/lang/String;
    //   201: astore 9
    //   203: aload 9
    //   205: invokestatic 182	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   208: ifne +219 -> 427
    //   211: new 484	com/tencent/mm/vfs/b
    //   214: dup
    //   215: aload 9
    //   217: invokespecial 485	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   220: astore 10
    //   222: aload 10
    //   224: invokevirtual 488	com/tencent/mm/vfs/b:exists	()Z
    //   227: ifeq +200 -> 427
    //   230: aload 10
    //   232: invokevirtual 491	com/tencent/mm/vfs/b:length	()J
    //   235: lstore 4
    //   237: ldc 114
    //   239: ldc_w 493
    //   242: iconst_5
    //   243: anewarray 4	java/lang/Object
    //   246: dup
    //   247: iconst_0
    //   248: aload 8
    //   250: invokevirtual 458	com/tencent/mm/modelvideo/s:getFileName	()Ljava/lang/String;
    //   253: aastore
    //   254: dup
    //   255: iconst_1
    //   256: lload 4
    //   258: invokestatic 425	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   261: aastore
    //   262: dup
    //   263: iconst_2
    //   264: aload 8
    //   266: getfield 496	com/tencent/mm/modelvideo/s:czu	I
    //   269: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   272: aastore
    //   273: dup
    //   274: iconst_3
    //   275: aload 8
    //   277: getfield 499	com/tencent/mm/modelvideo/s:fXv	J
    //   280: invokestatic 425	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   283: aastore
    //   284: dup
    //   285: iconst_4
    //   286: aload 9
    //   288: aastore
    //   289: invokestatic 152	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   292: lload 4
    //   294: lconst_0
    //   295: lcmp
    //   296: ifle +131 -> 427
    //   299: lload 4
    //   301: aload 8
    //   303: getfield 496	com/tencent/mm/modelvideo/s:czu	I
    //   306: i2l
    //   307: lcmp
    //   308: ifgt +119 -> 427
    //   311: aload 10
    //   313: invokevirtual 502	com/tencent/mm/vfs/b:delete	()Z
    //   316: pop
    //   317: iload_1
    //   318: iconst_1
    //   319: iadd
    //   320: istore_1
    //   321: aload 8
    //   323: iconst_0
    //   324: putfield 496	com/tencent/mm/modelvideo/s:czu	I
    //   327: aload 8
    //   329: iconst_1
    //   330: putfield 505	com/tencent/mm/modelvideo/s:bsY	I
    //   333: aload 8
    //   335: invokestatic 511	com/tencent/mm/modelvideo/u:f	(Lcom/tencent/mm/modelvideo/s;)Z
    //   338: pop
    //   339: goto -202 -> 137
    //   342: astore 8
    //   344: goto -207 -> 137
    //   347: getstatic 517	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   350: ldc2_w 518
    //   353: ldc2_w 520
    //   356: iload_1
    //   357: i2l
    //   358: iconst_0
    //   359: invokevirtual 525	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   362: ldc 114
    //   364: ldc_w 527
    //   367: iconst_4
    //   368: anewarray 4	java/lang/Object
    //   371: dup
    //   372: iconst_0
    //   373: aload_0
    //   374: invokevirtual 120	java/lang/Object:hashCode	()I
    //   377: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   380: aastore
    //   381: dup
    //   382: iconst_1
    //   383: aload 6
    //   385: invokeinterface 530 1 0
    //   390: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   393: aastore
    //   394: dup
    //   395: iconst_2
    //   396: iload_1
    //   397: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   400: aastore
    //   401: dup
    //   402: iconst_3
    //   403: lload_2
    //   404: invokestatic 534	com/tencent/mm/sdk/platformtools/bo:av	(J)J
    //   407: invokestatic 425	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   410: aastore
    //   411: invokestatic 152	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   414: ldc_w 391
    //   417: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   420: iconst_0
    //   421: ireturn
    //   422: astore 8
    //   424: goto -80 -> 344
    //   427: goto -106 -> 321
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	430	0	this	as
    //   31	366	1	i	int
    //   9	395	2	l1	long
    //   42	258	4	l2	long
    //   101	283	6	localList	java.util.List
    //   133	15	7	localIterator	java.util.Iterator
    //   157	177	8	locals	s
    //   342	1	8	localException1	Exception
    //   422	1	8	localException2	Exception
    //   172	115	9	str	String
    //   220	92	10	localb	com.tencent.mm.vfs.b
    // Exception table:
    //   from	to	target	type
    //   164	292	342	java/lang/Exception
    //   299	317	342	java/lang/Exception
    //   321	339	422	java/lang/Exception
  }
  
  final void cpL()
  {
    AppMethodBeat.i(36664);
    g.RM();
    g.RO().ac(new as.7(this));
    AppMethodBeat.o(36664);
  }
  
  public final boolean o(String paramString, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(36663);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(36663);
      return false;
    }
    g.RM();
    g.RO().ac(new as.5(this, paramString, paramArrayOfObject));
    AppMethodBeat.o(36663);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.as
 * JD-Core Version:    0.7.0.1
 */