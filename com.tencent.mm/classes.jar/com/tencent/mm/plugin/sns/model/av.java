package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bb;
import com.tencent.mm.g.a.np;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.f;
import com.tencent.mm.modelvideo.f.a;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.cgq;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bf;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class av
  implements f.a
{
  public boolean hZD;
  public boolean hZE;
  c xVy;
  c xVz;
  bc xWQ;
  LinkedList<bc> xWR;
  Map<String, bc> xWS;
  public LinkedList<p> xWT;
  LinkedList<f> xWU;
  int xWV;
  private int xWW;
  c xWX;
  
  public av()
  {
    AppMethodBeat.i(95974);
    this.xWR = null;
    this.xWS = null;
    this.xWT = null;
    this.xWU = new LinkedList();
    this.xWV = 3;
    this.xWW = 6;
    this.hZD = false;
    this.hZE = false;
    this.xWX = new c() {};
    this.xVy = new c() {};
    this.xVz = new c() {};
    this.xWQ = null;
    this.xWR = new LinkedList();
    this.xWS = new HashMap();
    this.xWT = new LinkedList();
    com.tencent.mm.sdk.b.a.GpY.c(this.xWX);
    com.tencent.mm.sdk.b.a.GpY.c(this.xVy);
    com.tencent.mm.sdk.b.a.GpY.c(this.xVz);
    AppMethodBeat.o(95974);
  }
  
  public final void a(f paramf, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95979);
    if (paramf == null)
    {
      ac.e("MicroMsg.SnsVideoService", "%d on preload finish but scene is null?", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(95979);
      return;
    }
    for (;;)
    {
      synchronized (this.xWU)
      {
        localObject1 = this.xWU.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label228;
        }
        if (paramf != (f)((Iterator)localObject1).next()) {
          continue;
        }
        localObject1 = paramf;
        if (localObject1 == null)
        {
          ac.w("MicroMsg.SnsVideoService", "%d on preload finish, but scene callback not same object.", new Object[] { Integer.valueOf(hashCode()) });
          AppMethodBeat.o(95979);
          return;
        }
      }
      ??? = au.aua(paramf.ddB);
      if (??? != null)
      {
        ((s)???).hux = paramInt2;
        u.f((s)???);
      }
      ac.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_DONE  preload video[%s] finish success[%b] range[%d, %d]  hash:[%d]", new Object[] { paramf.aJq(), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(hashCode()) });
      g.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(95968);
          com.tencent.mm.plugin.sns.model.b.a.OC(1);
          o.aJA().eV(false);
          this.xWZ.hZj = null;
          synchronized (av.this.xWU)
          {
            av.this.xWU.remove(this.xWZ);
            av.this.dIO();
            av.this.dIN();
            AppMethodBeat.o(95968);
            return;
          }
        }
      });
      AppMethodBeat.o(95979);
      return;
      label228:
      Object localObject1 = null;
    }
  }
  
  final boolean a(bc parambc, boolean paramBoolean)
  {
    AppMethodBeat.i(95984);
    Object localObject1 = au.a(parambc.ddB, parambc.dwE);
    if (!bs.isNullOrNil((String)localObject1))
    {
      ac.i("MicroMsg.SnsVideoService", "this sns:[%s] video[%s] already download finish, do nothing. [%s, %s]", new Object[] { parambc.ddB, parambc.hYq, parambc.ddB, localObject1 });
      AppMethodBeat.o(95984);
      return false;
    }
    boolean bool = com.tencent.mm.vfs.i.aSh(au.atZ(parambc.dwE.Id));
    localObject1 = au.D(parambc.dwE);
    Object localObject2 = au.aua(parambc.ddB);
    if (localObject2 == null) {
      au.eF(parambc.ddB, parambc.fry);
    }
    for (;;)
    {
      ac.i("MicroMsg.SnsVideoService", "prepare stream download sns video %s mkDir %b", new Object[] { localObject1, Boolean.valueOf(bool) });
      localObject2 = new com.tencent.mm.plugin.sns.model.a.a(parambc.dwE.Id);
      ((com.tencent.mm.plugin.sns.model.a.a)localObject2).xRy = parambc.dwE;
      bf localbf = bf.fbp();
      localbf.gIh = parambc.hGU;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject2).xYb = localbf;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject2).xXZ = true;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject2).url = parambc.dwE.Url;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject2).xXY = false;
      n.aJw();
      o.aJz();
      localObject1 = com.tencent.mm.an.e.a(((com.tencent.mm.plugin.sns.model.a.a)localObject2).xYb, ((com.tencent.mm.plugin.sns.model.a.a)localObject2).url, (String)localObject1, au.DU(parambc.ddB), parambc.frw);
      if (localObject1 != null) {
        break;
      }
      AppMethodBeat.o(95984);
      return false;
      au.c((s)localObject2, parambc.fry);
    }
    localObject2 = parambc.xXX;
    ((com.tencent.mm.i.h)localObject1).frx = ((String)localObject2);
    ((com.tencent.mm.i.h)localObject1).dng = ((String)localObject2);
    try
    {
      localObject2 = aj.s(af.dHR().auT(parambc.ddB));
      if (localObject2 != null)
      {
        ((com.tencent.mm.i.h)localObject1).dnn = ((SnsObject)localObject2).Id;
        ((com.tencent.mm.i.h)localObject1).frB = ((SnsObject)localObject2).PreDownloadInfo.FuL;
      }
    }
    catch (Exception localException)
    {
      label354:
      break label354;
    }
    this.xWQ = parambc;
    this.xWQ.hYq = ((com.tencent.mm.i.h)localObject1).field_mediaId;
    ac.i("MicroMsg.SnsVideoService", "start stream download sns video cdnMediaId %s delay %b", new Object[] { this.xWQ.hYq, Boolean.valueOf(paramBoolean) });
    o.aJz().a((com.tencent.mm.i.h)localObject1, paramBoolean);
    AppMethodBeat.o(95984);
    return true;
  }
  
  public final boolean a(btz parambtz, int paramInt1, String paramString, boolean paramBoolean1, final boolean paramBoolean2, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(95981);
    if (parambtz.EUH == 2)
    {
      ac.w("MicroMsg.SnsVideoService", "add video task, but url is weixin, do nothing");
      AppMethodBeat.o(95981);
      return false;
    }
    final bc localbc = new bc();
    localbc.hYq = au.bU(paramInt1, parambtz.Url);
    localbc.dwE = parambtz;
    localbc.hGU = paramInt1;
    localbc.ddB = paramString;
    paramInt1 = i;
    if (paramBoolean1) {
      paramInt1 = 1;
    }
    localbc.frw = paramInt1;
    localbc.fry = paramInt2;
    g.agS();
    g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95970);
        Object localObject = af.dHR().auT(localbc.ddB);
        bc localbc = localbc;
        if (localObject != null)
        {
          localObject = ((p)localObject).field_userName;
          localbc.xXX = ((String)localObject);
          ac.i("MicroMsg.SnsVideoService", "offer [%b] video task[%s] to queue ", new Object[] { Boolean.valueOf(paramBoolean2), localbc });
          if (!paramBoolean2) {
            break label124;
          }
          av.this.xWR.offerFirst(localbc);
        }
        for (;;)
        {
          av.this.xWS.put(localbc.hYq, localbc);
          AppMethodBeat.o(95970);
          return;
          localObject = "";
          break;
          label124:
          av.this.xWR.offerLast(localbc);
        }
      }
    });
    if (paramBoolean2) {
      dIP();
    }
    AppMethodBeat.o(95981);
    return true;
  }
  
  public final void dIM()
  {
    AppMethodBeat.i(95977);
    ac.d("MicroMsg.SnsVideoService", "%d stop preload %s", new Object[] { Integer.valueOf(hashCode()), bs.eWi() });
    g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95966);
        synchronized (av.this.xWU)
        {
          if (av.this.xWU.size() > 0) {
            ((f)av.this.xWU.poll()).stop();
          }
        }
        AppMethodBeat.o(95966);
      }
    });
    AppMethodBeat.o(95977);
  }
  
  final void dIN()
  {
    try
    {
      AppMethodBeat.i(95978);
      ac.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_LOAD preload size:%d  queue size:%d", new Object[] { Integer.valueOf(this.xWU.size()), Integer.valueOf(this.xWT.size()) });
      g.agU().az(new Runnable()
      {
        /* Error */
        public final void run()
        {
          // Byte code:
          //   0: ldc 24
          //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   5: aload_0
          //   6: getfield 17	com/tencent/mm/plugin/sns/model/av$5:xWY	Lcom/tencent/mm/plugin/sns/model/av;
          //   9: getfield 34	com/tencent/mm/plugin/sns/model/av:xWQ	Lcom/tencent/mm/plugin/sns/model/bc;
          //   12: ifnull +9 -> 21
          //   15: ldc 24
          //   17: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   20: return
          //   21: aload_0
          //   22: getfield 17	com/tencent/mm/plugin/sns/model/av$5:xWY	Lcom/tencent/mm/plugin/sns/model/av;
          //   25: getfield 41	com/tencent/mm/plugin/sns/model/av:xWR	Ljava/util/LinkedList;
          //   28: invokevirtual 47	java/util/LinkedList:isEmpty	()Z
          //   31: ifne +9 -> 40
          //   34: ldc 24
          //   36: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   39: return
          //   40: aload_0
          //   41: getfield 17	com/tencent/mm/plugin/sns/model/av$5:xWY	Lcom/tencent/mm/plugin/sns/model/av;
          //   44: getfield 50	com/tencent/mm/plugin/sns/model/av:xWU	Ljava/util/LinkedList;
          //   47: astore 5
          //   49: aload 5
          //   51: monitorenter
          //   52: aload_0
          //   53: getfield 17	com/tencent/mm/plugin/sns/model/av$5:xWY	Lcom/tencent/mm/plugin/sns/model/av;
          //   56: getfield 50	com/tencent/mm/plugin/sns/model/av:xWU	Ljava/util/LinkedList;
          //   59: invokevirtual 54	java/util/LinkedList:size	()I
          //   62: aload_0
          //   63: getfield 17	com/tencent/mm/plugin/sns/model/av$5:xWY	Lcom/tencent/mm/plugin/sns/model/av;
          //   66: getfield 58	com/tencent/mm/plugin/sns/model/av:xWV	I
          //   69: if_icmplt +19 -> 88
          //   72: ldc 60
          //   74: ldc 62
          //   76: invokestatic 67	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   79: aload 5
          //   81: monitorexit
          //   82: ldc 24
          //   84: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   87: return
          //   88: aload 5
          //   90: monitorexit
          //   91: aload_0
          //   92: getfield 17	com/tencent/mm/plugin/sns/model/av$5:xWY	Lcom/tencent/mm/plugin/sns/model/av;
          //   95: getfield 71	com/tencent/mm/plugin/sns/model/av:hZD	Z
          //   98: ifne +19 -> 117
          //   101: aload_0
          //   102: getfield 17	com/tencent/mm/plugin/sns/model/av$5:xWY	Lcom/tencent/mm/plugin/sns/model/av;
          //   105: getfield 74	com/tencent/mm/plugin/sns/model/av:hZE	Z
          //   108: ifeq +61 -> 169
          //   111: invokestatic 79	com/tencent/mm/plugin/sns/model/b/a:dJc	()Z
          //   114: ifne +55 -> 169
          //   117: ldc 60
          //   119: ldc 81
          //   121: iconst_2
          //   122: anewarray 4	java/lang/Object
          //   125: dup
          //   126: iconst_0
          //   127: aload_0
          //   128: getfield 17	com/tencent/mm/plugin/sns/model/av$5:xWY	Lcom/tencent/mm/plugin/sns/model/av;
          //   131: getfield 71	com/tencent/mm/plugin/sns/model/av:hZD	Z
          //   134: invokestatic 87	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
          //   137: aastore
          //   138: dup
          //   139: iconst_1
          //   140: invokestatic 79	com/tencent/mm/plugin/sns/model/b/a:dJc	()Z
          //   143: invokestatic 87	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
          //   146: aastore
          //   147: invokestatic 90	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   150: ldc 24
          //   152: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   155: return
          //   156: astore 6
          //   158: aload 5
          //   160: monitorexit
          //   161: ldc 24
          //   163: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   166: aload 6
          //   168: athrow
          //   169: aconst_null
          //   170: astore 6
          //   172: aconst_null
          //   173: astore 5
          //   175: new 92	com/tencent/mm/pointers/PBool
          //   178: dup
          //   179: invokespecial 93	com/tencent/mm/pointers/PBool:<init>	()V
          //   182: astore 11
          //   184: new 95	com/tencent/mm/pointers/PInt
          //   187: dup
          //   188: invokespecial 96	com/tencent/mm/pointers/PInt:<init>	()V
          //   191: astore 9
          //   193: new 98	com/tencent/mm/pointers/PString
          //   196: dup
          //   197: invokespecial 99	com/tencent/mm/pointers/PString:<init>	()V
          //   200: astore 12
          //   202: aload_0
          //   203: getfield 17	com/tencent/mm/plugin/sns/model/av$5:xWY	Lcom/tencent/mm/plugin/sns/model/av;
          //   206: getfield 102	com/tencent/mm/plugin/sns/model/av:xWT	Ljava/util/LinkedList;
          //   209: astore 10
          //   211: aload 10
          //   213: monitorenter
          //   214: aload_0
          //   215: getfield 17	com/tencent/mm/plugin/sns/model/av$5:xWY	Lcom/tencent/mm/plugin/sns/model/av;
          //   218: getfield 102	com/tencent/mm/plugin/sns/model/av:xWT	Ljava/util/LinkedList;
          //   221: invokevirtual 106	java/util/LinkedList:iterator	()Ljava/util/Iterator;
          //   224: astore 13
          //   226: ldc 108
          //   228: astore 7
          //   230: aload 13
          //   232: invokeinterface 113 1 0
          //   237: ifeq +1623 -> 1860
          //   240: aload 13
          //   242: invokeinterface 117 1 0
          //   247: checkcast 119	com/tencent/mm/plugin/sns/storage/p
          //   250: astore 7
          //   252: aload 7
          //   254: invokevirtual 123	com/tencent/mm/plugin/sns/storage/p:dMu	()Ljava/lang/String;
          //   257: astore 6
          //   259: aload_0
          //   260: getfield 17	com/tencent/mm/plugin/sns/model/av$5:xWY	Lcom/tencent/mm/plugin/sns/model/av;
          //   263: getfield 74	com/tencent/mm/plugin/sns/model/av:hZE	Z
          //   266: ifeq +281 -> 547
          //   269: aload_0
          //   270: getfield 17	com/tencent/mm/plugin/sns/model/av$5:xWY	Lcom/tencent/mm/plugin/sns/model/av;
          //   273: astore 8
          //   275: aload 7
          //   277: ifnonnull +106 -> 383
          //   280: aload 11
          //   282: iconst_1
          //   283: putfield 126	com/tencent/mm/pointers/PBool:value	Z
          //   286: iconst_0
          //   287: istore_1
          //   288: aload 11
          //   290: getfield 126	com/tencent/mm/pointers/PBool:value	Z
          //   293: ifeq +10 -> 303
          //   296: aload 13
          //   298: invokeinterface 129 1 0
          //   303: iload_1
          //   304: ifeq +1542 -> 1846
          //   307: aload_0
          //   308: getfield 17	com/tencent/mm/plugin/sns/model/av$5:xWY	Lcom/tencent/mm/plugin/sns/model/av;
          //   311: astore 16
          //   313: aload 12
          //   315: getfield 132	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
          //   318: astore 8
          //   320: aload 7
          //   322: ifnull +1513 -> 1835
          //   325: aload 7
          //   327: invokevirtual 136	com/tencent/mm/plugin/sns/storage/p:dLV	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
          //   330: getfield 142	com/tencent/mm/protocal/protobuf/TimeLineObject:FQo	Lcom/tencent/mm/protocal/protobuf/zf;
          //   333: ifnull +1502 -> 1835
          //   336: aload 7
          //   338: invokevirtual 136	com/tencent/mm/plugin/sns/storage/p:dLV	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
          //   341: getfield 142	com/tencent/mm/protocal/protobuf/TimeLineObject:FQo	Lcom/tencent/mm/protocal/protobuf/zf;
          //   344: getfield 147	com/tencent/mm/protocal/protobuf/zf:Etz	Ljava/util/LinkedList;
          //   347: invokestatic 153	com/tencent/mm/sdk/platformtools/bs:gY	(Ljava/util/List;)Z
          //   350: ifeq +571 -> 921
          //   353: goto +1482 -> 1835
          //   356: aload 5
          //   358: ifnonnull +1458 -> 1816
          //   361: aload 13
          //   363: invokeinterface 129 1 0
          //   368: aload 6
          //   370: astore 8
          //   372: aload 7
          //   374: astore 6
          //   376: aload 8
          //   378: astore 7
          //   380: goto -150 -> 230
          //   383: invokestatic 159	com/tencent/mm/modelvideo/o:aJA	()Lcom/tencent/mm/modelvideo/i;
          //   386: iconst_0
          //   387: invokevirtual 165	com/tencent/mm/modelvideo/i:eW	(Z)Z
          //   390: ifeq +14 -> 404
          //   393: aload 11
          //   395: iconst_1
          //   396: putfield 126	com/tencent/mm/pointers/PBool:value	Z
          //   399: iconst_0
          //   400: istore_1
          //   401: goto -113 -> 288
          //   404: aload 7
          //   406: invokestatic 171	com/tencent/mm/plugin/sns/model/aj:s	(Lcom/tencent/mm/plugin/sns/storage/p;)Lcom/tencent/mm/protocal/protobuf/SnsObject;
          //   409: astore 14
          //   411: aload 14
          //   413: ifnull +11 -> 424
          //   416: aload 14
          //   418: getfield 177	com/tencent/mm/protocal/protobuf/SnsObject:PreDownloadInfo	Lcom/tencent/mm/protocal/protobuf/cgq;
          //   421: ifnonnull +21 -> 442
          //   424: ldc 60
          //   426: ldc 179
          //   428: invokestatic 67	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   431: aload 11
          //   433: iconst_1
          //   434: putfield 126	com/tencent/mm/pointers/PBool:value	Z
          //   437: iconst_0
          //   438: istore_1
          //   439: goto -151 -> 288
          //   442: invokestatic 182	com/tencent/mm/plugin/sns/model/b/a:dJf	()I
          //   445: istore_1
          //   446: iload_1
          //   447: ifgt +36 -> 483
          //   450: ldc 60
          //   452: ldc 184
          //   454: iconst_1
          //   455: anewarray 4	java/lang/Object
          //   458: dup
          //   459: iconst_0
          //   460: aload 8
          //   462: invokevirtual 187	java/lang/Object:hashCode	()I
          //   465: invokestatic 192	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   468: aastore
          //   469: invokestatic 90	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   472: aload 11
          //   474: iconst_1
          //   475: putfield 126	com/tencent/mm/pointers/PBool:value	Z
          //   478: iconst_0
          //   479: istore_1
          //   480: goto -192 -> 288
          //   483: aload 12
          //   485: new 194	java/lang/StringBuilder
          //   488: dup
          //   489: invokespecial 195	java/lang/StringBuilder:<init>	()V
          //   492: aload 14
          //   494: getfield 199	com/tencent/mm/protocal/protobuf/SnsObject:Id	J
          //   497: invokevirtual 203	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
          //   500: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   503: putfield 132	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
          //   506: aload 9
          //   508: iload_1
          //   509: putfield 208	com/tencent/mm/pointers/PInt:value	I
          //   512: invokestatic 79	com/tencent/mm/plugin/sns/model/b/a:dJc	()Z
          //   515: ifne +21 -> 536
          //   518: ldc 60
          //   520: ldc 210
          //   522: invokestatic 67	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   525: aload 11
          //   527: iconst_1
          //   528: putfield 126	com/tencent/mm/pointers/PBool:value	Z
          //   531: iconst_0
          //   532: istore_1
          //   533: goto -245 -> 288
          //   536: aload 11
          //   538: iconst_0
          //   539: putfield 126	com/tencent/mm/pointers/PBool:value	Z
          //   542: iconst_1
          //   543: istore_1
          //   544: goto -256 -> 288
          //   547: aload_0
          //   548: getfield 17	com/tencent/mm/plugin/sns/model/av$5:xWY	Lcom/tencent/mm/plugin/sns/model/av;
          //   551: astore 8
          //   553: aload 7
          //   555: ifnonnull +14 -> 569
          //   558: aload 11
          //   560: iconst_1
          //   561: putfield 126	com/tencent/mm/pointers/PBool:value	Z
          //   564: iconst_0
          //   565: istore_1
          //   566: goto -278 -> 288
          //   569: aload 7
          //   571: getfield 213	com/tencent/mm/plugin/sns/storage/p:field_createTime	I
          //   574: i2l
          //   575: invokestatic 217	com/tencent/mm/sdk/platformtools/bs:pN	(J)J
          //   578: ldc2_w 218
          //   581: lcmp
          //   582: iflt +14 -> 596
          //   585: aload 11
          //   587: iconst_1
          //   588: putfield 126	com/tencent/mm/pointers/PBool:value	Z
          //   591: iconst_0
          //   592: istore_1
          //   593: goto -305 -> 288
          //   596: invokestatic 159	com/tencent/mm/modelvideo/o:aJA	()Lcom/tencent/mm/modelvideo/i;
          //   599: iconst_0
          //   600: invokevirtual 165	com/tencent/mm/modelvideo/i:eW	(Z)Z
          //   603: ifeq +14 -> 617
          //   606: aload 11
          //   608: iconst_1
          //   609: putfield 126	com/tencent/mm/pointers/PBool:value	Z
          //   612: iconst_0
          //   613: istore_1
          //   614: goto -326 -> 288
          //   617: aload 7
          //   619: invokestatic 171	com/tencent/mm/plugin/sns/model/aj:s	(Lcom/tencent/mm/plugin/sns/storage/p;)Lcom/tencent/mm/protocal/protobuf/SnsObject;
          //   622: astore 14
          //   624: aload 14
          //   626: ifnull +11 -> 637
          //   629: aload 14
          //   631: getfield 177	com/tencent/mm/protocal/protobuf/SnsObject:PreDownloadInfo	Lcom/tencent/mm/protocal/protobuf/cgq;
          //   634: ifnonnull +21 -> 655
          //   637: ldc 60
          //   639: ldc 179
          //   641: invokestatic 67	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   644: aload 11
          //   646: iconst_1
          //   647: putfield 126	com/tencent/mm/pointers/PBool:value	Z
          //   650: iconst_0
          //   651: istore_1
          //   652: goto -364 -> 288
          //   655: ldc 60
          //   657: ldc 221
          //   659: iconst_5
          //   660: anewarray 4	java/lang/Object
          //   663: dup
          //   664: iconst_0
          //   665: aload 8
          //   667: invokevirtual 187	java/lang/Object:hashCode	()I
          //   670: invokestatic 192	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   673: aastore
          //   674: dup
          //   675: iconst_1
          //   676: aload 7
          //   678: invokevirtual 123	com/tencent/mm/plugin/sns/storage/p:dMu	()Ljava/lang/String;
          //   681: aastore
          //   682: dup
          //   683: iconst_2
          //   684: aload 14
          //   686: getfield 177	com/tencent/mm/protocal/protobuf/SnsObject:PreDownloadInfo	Lcom/tencent/mm/protocal/protobuf/cgq;
          //   689: getfield 226	com/tencent/mm/protocal/protobuf/cgq:FuL	I
          //   692: invokestatic 192	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   695: aastore
          //   696: dup
          //   697: iconst_3
          //   698: aload 14
          //   700: getfield 177	com/tencent/mm/protocal/protobuf/SnsObject:PreDownloadInfo	Lcom/tencent/mm/protocal/protobuf/cgq;
          //   703: getfield 229	com/tencent/mm/protocal/protobuf/cgq:FuM	I
          //   706: invokestatic 192	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   709: aastore
          //   710: dup
          //   711: iconst_4
          //   712: aload 14
          //   714: getfield 177	com/tencent/mm/protocal/protobuf/SnsObject:PreDownloadInfo	Lcom/tencent/mm/protocal/protobuf/cgq;
          //   717: getfield 232	com/tencent/mm/protocal/protobuf/cgq:FuN	Ljava/lang/String;
          //   720: aastore
          //   721: invokestatic 90	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   724: aload 14
          //   726: getfield 177	com/tencent/mm/protocal/protobuf/SnsObject:PreDownloadInfo	Lcom/tencent/mm/protocal/protobuf/cgq;
          //   729: getfield 226	com/tencent/mm/protocal/protobuf/cgq:FuL	I
          //   732: ifgt +36 -> 768
          //   735: ldc 60
          //   737: ldc 184
          //   739: iconst_1
          //   740: anewarray 4	java/lang/Object
          //   743: dup
          //   744: iconst_0
          //   745: aload 8
          //   747: invokevirtual 187	java/lang/Object:hashCode	()I
          //   750: invokestatic 192	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   753: aastore
          //   754: invokestatic 90	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   757: aload 11
          //   759: iconst_1
          //   760: putfield 126	com/tencent/mm/pointers/PBool:value	Z
          //   763: iconst_0
          //   764: istore_1
          //   765: goto -477 -> 288
          //   768: aload 12
          //   770: new 194	java/lang/StringBuilder
          //   773: dup
          //   774: invokespecial 195	java/lang/StringBuilder:<init>	()V
          //   777: aload 14
          //   779: getfield 199	com/tencent/mm/protocal/protobuf/SnsObject:Id	J
          //   782: invokevirtual 203	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
          //   785: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   788: putfield 132	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
          //   791: aload 9
          //   793: aload 14
          //   795: getfield 177	com/tencent/mm/protocal/protobuf/SnsObject:PreDownloadInfo	Lcom/tencent/mm/protocal/protobuf/cgq;
          //   798: getfield 226	com/tencent/mm/protocal/protobuf/cgq:FuL	I
          //   801: putfield 208	com/tencent/mm/pointers/PInt:value	I
          //   804: aload 14
          //   806: getfield 177	com/tencent/mm/protocal/protobuf/SnsObject:PreDownloadInfo	Lcom/tencent/mm/protocal/protobuf/cgq;
          //   809: getfield 232	com/tencent/mm/protocal/protobuf/cgq:FuN	Ljava/lang/String;
          //   812: invokestatic 238	com/tencent/mm/modelcontrol/b:BU	(Ljava/lang/String;)Z
          //   815: ifne +95 -> 910
          //   818: invokestatic 244	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
          //   821: invokestatic 250	com/tencent/mm/sdk/platformtools/ax:isWifi	(Landroid/content/Context;)Z
          //   824: ifeq +29 -> 853
          //   827: aload 14
          //   829: getfield 177	com/tencent/mm/protocal/protobuf/SnsObject:PreDownloadInfo	Lcom/tencent/mm/protocal/protobuf/cgq;
          //   832: getfield 229	com/tencent/mm/protocal/protobuf/cgq:FuM	I
          //   835: iconst_1
          //   836: iand
          //   837: istore_1
          //   838: iload_1
          //   839: ifle +71 -> 910
          //   842: aload 11
          //   844: iconst_0
          //   845: putfield 126	com/tencent/mm/pointers/PBool:value	Z
          //   848: iconst_1
          //   849: istore_1
          //   850: goto -562 -> 288
          //   853: invokestatic 244	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
          //   856: invokestatic 253	com/tencent/mm/sdk/platformtools/ax:is4G	(Landroid/content/Context;)Z
          //   859: ifeq +17 -> 876
          //   862: aload 14
          //   864: getfield 177	com/tencent/mm/protocal/protobuf/SnsObject:PreDownloadInfo	Lcom/tencent/mm/protocal/protobuf/cgq;
          //   867: getfield 229	com/tencent/mm/protocal/protobuf/cgq:FuM	I
          //   870: iconst_2
          //   871: iand
          //   872: istore_1
          //   873: goto -35 -> 838
          //   876: invokestatic 244	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
          //   879: invokestatic 256	com/tencent/mm/sdk/platformtools/ax:is3G	(Landroid/content/Context;)Z
          //   882: ifeq +17 -> 899
          //   885: aload 14
          //   887: getfield 177	com/tencent/mm/protocal/protobuf/SnsObject:PreDownloadInfo	Lcom/tencent/mm/protocal/protobuf/cgq;
          //   890: getfield 229	com/tencent/mm/protocal/protobuf/cgq:FuM	I
          //   893: iconst_4
          //   894: iand
          //   895: istore_1
          //   896: goto -58 -> 838
          //   899: aload 11
          //   901: iconst_0
          //   902: putfield 126	com/tencent/mm/pointers/PBool:value	Z
          //   905: iconst_0
          //   906: istore_1
          //   907: goto -619 -> 288
          //   910: aload 11
          //   912: iconst_0
          //   913: putfield 126	com/tencent/mm/pointers/PBool:value	Z
          //   916: iconst_0
          //   917: istore_1
          //   918: goto -630 -> 288
          //   921: aload 7
          //   923: invokevirtual 136	com/tencent/mm/plugin/sns/storage/p:dLV	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
          //   926: getfield 142	com/tencent/mm/protocal/protobuf/TimeLineObject:FQo	Lcom/tencent/mm/protocal/protobuf/zf;
          //   929: getfield 147	com/tencent/mm/protocal/protobuf/zf:Etz	Ljava/util/LinkedList;
          //   932: iconst_0
          //   933: invokevirtual 260	java/util/LinkedList:get	(I)Ljava/lang/Object;
          //   936: checkcast 262	com/tencent/mm/protocal/protobuf/btz
          //   939: astore 14
          //   941: aload 7
          //   943: invokevirtual 123	com/tencent/mm/plugin/sns/storage/p:dMu	()Ljava/lang/String;
          //   946: astore 5
          //   948: aload 5
          //   950: aload 14
          //   952: invokestatic 268	com/tencent/mm/plugin/sns/model/au:a	(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/btz;)Ljava/lang/String;
          //   955: astore 15
          //   957: aload 15
          //   959: invokestatic 271	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
          //   962: ifne +98 -> 1060
          //   965: ldc 60
          //   967: ldc_w 273
          //   970: iconst_2
          //   971: anewarray 4	java/lang/Object
          //   974: dup
          //   975: iconst_0
          //   976: aload 7
          //   978: invokevirtual 123	com/tencent/mm/plugin/sns/storage/p:dMu	()Ljava/lang/String;
          //   981: aastore
          //   982: dup
          //   983: iconst_1
          //   984: aload 15
          //   986: aastore
          //   987: invokestatic 90	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   990: aload 14
          //   992: getfield 276	com/tencent/mm/protocal/protobuf/btz:FjC	Ljava/lang/String;
          //   995: astore 5
          //   997: aload 15
          //   999: invokestatic 282	com/tencent/mm/vfs/i:aSp	(Ljava/lang/String;)J
          //   1002: lstore_2
          //   1003: aload 16
          //   1005: getfield 74	com/tencent/mm/plugin/sns/model/av:hZE	Z
          //   1008: ifeq +833 -> 1841
          //   1011: iconst_4
          //   1012: istore_1
          //   1013: invokestatic 159	com/tencent/mm/modelvideo/o:aJA	()Lcom/tencent/mm/modelvideo/i;
          //   1016: aload 5
          //   1018: iload_1
          //   1019: lload_2
          //   1020: aload 7
          //   1022: getfield 285	com/tencent/mm/plugin/sns/storage/p:field_userName	Ljava/lang/String;
          //   1025: ldc 108
          //   1027: iconst_0
          //   1028: ldc 108
          //   1030: aload 14
          //   1032: getfield 288	com/tencent/mm/protocal/protobuf/btz:Url	Ljava/lang/String;
          //   1035: aload 8
          //   1037: invokevirtual 291	com/tencent/mm/modelvideo/i:a	(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
          //   1040: getstatic 297	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
          //   1043: ldc2_w 298
          //   1046: ldc2_w 300
          //   1049: lconst_1
          //   1050: iconst_0
          //   1051: invokevirtual 305	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
          //   1054: aconst_null
          //   1055: astore 5
          //   1057: goto -701 -> 356
          //   1060: aload 14
          //   1062: getfield 307	com/tencent/mm/protocal/protobuf/btz:Id	Ljava/lang/String;
          //   1065: invokestatic 311	com/tencent/mm/plugin/sns/model/au:atZ	(Ljava/lang/String;)Ljava/lang/String;
          //   1068: invokestatic 314	com/tencent/mm/vfs/i:aSh	(Ljava/lang/String;)Z
          //   1071: istore 4
          //   1073: aload 14
          //   1075: invokestatic 318	com/tencent/mm/plugin/sns/model/au:D	(Lcom/tencent/mm/protocal/protobuf/btz;)Ljava/lang/String;
          //   1078: astore 16
          //   1080: aload 5
          //   1082: invokestatic 322	com/tencent/mm/plugin/sns/model/au:aua	(Ljava/lang/String;)Lcom/tencent/mm/modelvideo/s;
          //   1085: astore 17
          //   1087: aload 9
          //   1089: aload 14
          //   1091: aload 9
          //   1093: getfield 208	com/tencent/mm/pointers/PInt:value	I
          //   1096: invokestatic 325	com/tencent/mm/plugin/sns/model/b/a:a	(Lcom/tencent/mm/protocal/protobuf/btz;I)I
          //   1099: putfield 208	com/tencent/mm/pointers/PInt:value	I
          //   1102: ldc 60
          //   1104: ldc_w 327
          //   1107: iconst_3
          //   1108: anewarray 4	java/lang/Object
          //   1111: dup
          //   1112: iconst_0
          //   1113: aload 7
          //   1115: invokevirtual 123	com/tencent/mm/plugin/sns/storage/p:dMu	()Ljava/lang/String;
          //   1118: aastore
          //   1119: dup
          //   1120: iconst_1
          //   1121: aload 14
          //   1123: getfield 331	com/tencent/mm/protocal/protobuf/btz:FjD	F
          //   1126: invokestatic 336	java/lang/Float:valueOf	(F)Ljava/lang/Float;
          //   1129: aastore
          //   1130: dup
          //   1131: iconst_2
          //   1132: aload 9
          //   1134: getfield 208	com/tencent/mm/pointers/PInt:value	I
          //   1137: invokestatic 192	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1140: aastore
          //   1141: invokestatic 90	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   1144: aload 17
          //   1146: ifnull +84 -> 1230
          //   1149: ldc 60
          //   1151: ldc_w 338
          //   1154: iconst_1
          //   1155: anewarray 4	java/lang/Object
          //   1158: dup
          //   1159: iconst_0
          //   1160: aload 17
          //   1162: invokevirtual 341	com/tencent/mm/modelvideo/s:toString	()Ljava/lang/String;
          //   1165: aastore
          //   1166: invokestatic 90	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   1169: aload 17
          //   1171: getfield 344	com/tencent/mm/modelvideo/s:hux	I
          //   1174: ifle +56 -> 1230
          //   1177: aload 17
          //   1179: getfield 347	com/tencent/mm/modelvideo/s:dnl	I
          //   1182: bipush 100
          //   1184: imul
          //   1185: aload 17
          //   1187: getfield 344	com/tencent/mm/modelvideo/s:hux	I
          //   1190: idiv
          //   1191: aload 9
          //   1193: getfield 208	com/tencent/mm/pointers/PInt:value	I
          //   1196: if_icmplt +34 -> 1230
          //   1199: ldc 60
          //   1201: ldc_w 349
          //   1204: iconst_2
          //   1205: anewarray 4	java/lang/Object
          //   1208: dup
          //   1209: iconst_0
          //   1210: aload 7
          //   1212: invokevirtual 123	com/tencent/mm/plugin/sns/storage/p:dMu	()Ljava/lang/String;
          //   1215: aastore
          //   1216: dup
          //   1217: iconst_1
          //   1218: aload 15
          //   1220: aastore
          //   1221: invokestatic 90	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   1224: aconst_null
          //   1225: astore 5
          //   1227: goto -871 -> 356
          //   1230: aload 17
          //   1232: ifnonnull +151 -> 1383
          //   1235: aload 5
          //   1237: bipush 30
          //   1239: invokestatic 353	com/tencent/mm/plugin/sns/model/au:eF	(Ljava/lang/String;I)Z
          //   1242: pop
          //   1243: ldc 60
          //   1245: ldc_w 355
          //   1248: iconst_3
          //   1249: anewarray 4	java/lang/Object
          //   1252: dup
          //   1253: iconst_0
          //   1254: aload 7
          //   1256: invokevirtual 123	com/tencent/mm/plugin/sns/storage/p:dMu	()Ljava/lang/String;
          //   1259: aastore
          //   1260: dup
          //   1261: iconst_1
          //   1262: aload 16
          //   1264: aastore
          //   1265: dup
          //   1266: iconst_2
          //   1267: iload 4
          //   1269: invokestatic 87	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
          //   1272: aastore
          //   1273: invokestatic 90	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   1276: new 357	com/tencent/mm/plugin/sns/model/a/a
          //   1279: dup
          //   1280: aload 14
          //   1282: getfield 307	com/tencent/mm/protocal/protobuf/btz:Id	Ljava/lang/String;
          //   1285: invokespecial 360	com/tencent/mm/plugin/sns/model/a/a:<init>	(Ljava/lang/String;)V
          //   1288: astore 15
          //   1290: aload 15
          //   1292: aload 14
          //   1294: putfield 364	com/tencent/mm/plugin/sns/model/a/a:xRy	Lcom/tencent/mm/protocal/protobuf/btz;
          //   1297: invokestatic 370	com/tencent/mm/storage/bf:fbp	()Lcom/tencent/mm/storage/bf;
          //   1300: astore 17
          //   1302: aload 17
          //   1304: aload 7
          //   1306: getfield 213	com/tencent/mm/plugin/sns/storage/p:field_createTime	I
          //   1309: putfield 373	com/tencent/mm/storage/bf:gIh	I
          //   1312: aload 15
          //   1314: aload 17
          //   1316: putfield 377	com/tencent/mm/plugin/sns/model/a/a:xYb	Lcom/tencent/mm/storage/bf;
          //   1319: aload 15
          //   1321: iconst_1
          //   1322: putfield 380	com/tencent/mm/plugin/sns/model/a/a:xXZ	Z
          //   1325: aload 15
          //   1327: aload 14
          //   1329: getfield 288	com/tencent/mm/protocal/protobuf/btz:Url	Ljava/lang/String;
          //   1332: putfield 383	com/tencent/mm/plugin/sns/model/a/a:url	Ljava/lang/String;
          //   1335: aload 15
          //   1337: iconst_0
          //   1338: putfield 386	com/tencent/mm/plugin/sns/model/a/a:xXY	Z
          //   1341: invokestatic 392	com/tencent/mm/modelvideo/n:aJw	()Lcom/tencent/mm/modelvideo/n;
          //   1344: pop
          //   1345: invokestatic 396	com/tencent/mm/modelvideo/o:aJz	()Lcom/tencent/mm/an/e;
          //   1348: pop
          //   1349: aload 15
          //   1351: getfield 377	com/tencent/mm/plugin/sns/model/a/a:xYb	Lcom/tencent/mm/storage/bf;
          //   1354: aload 15
          //   1356: getfield 383	com/tencent/mm/plugin/sns/model/a/a:url	Ljava/lang/String;
          //   1359: aload 16
          //   1361: aload 5
          //   1363: invokestatic 399	com/tencent/mm/plugin/sns/model/au:DU	(Ljava/lang/String;)Ljava/lang/String;
          //   1366: iconst_2
          //   1367: invokestatic 404	com/tencent/mm/an/e:a	(Lcom/tencent/mm/storage/bf;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lcom/tencent/mm/i/h;
          //   1370: astore 5
          //   1372: aload 5
          //   1374: ifnonnull +33 -> 1407
          //   1377: aconst_null
          //   1378: astore 5
          //   1380: goto -1024 -> 356
          //   1383: aload 17
          //   1385: bipush 30
          //   1387: invokestatic 408	com/tencent/mm/plugin/sns/model/au:c	(Lcom/tencent/mm/modelvideo/s;I)Z
          //   1390: pop
          //   1391: goto -148 -> 1243
          //   1394: astore 5
          //   1396: aload 10
          //   1398: monitorexit
          //   1399: ldc 24
          //   1401: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1404: aload 5
          //   1406: athrow
          //   1407: aload 5
          //   1409: aload 14
          //   1411: getfield 276	com/tencent/mm/protocal/protobuf/btz:FjC	Ljava/lang/String;
          //   1414: putfield 413	com/tencent/mm/i/h:cHq	Ljava/lang/String;
          //   1417: aload 5
          //   1419: aload 9
          //   1421: getfield 208	com/tencent/mm/pointers/PInt:value	I
          //   1424: putfield 416	com/tencent/mm/i/h:field_preloadRatio	I
          //   1427: aload 5
          //   1429: aload 8
          //   1431: putfield 419	com/tencent/mm/i/h:dnn	Ljava/lang/String;
          //   1434: aload 7
          //   1436: getfield 285	com/tencent/mm/plugin/sns/storage/p:field_userName	Ljava/lang/String;
          //   1439: astore 8
          //   1441: aload 5
          //   1443: aload 8
          //   1445: putfield 422	com/tencent/mm/i/h:frx	Ljava/lang/String;
          //   1448: aload 5
          //   1450: aload 8
          //   1452: putfield 425	com/tencent/mm/i/h:dng	Ljava/lang/String;
          //   1455: goto -1099 -> 356
          //   1458: aload 10
          //   1460: monitorexit
          //   1461: aload 5
          //   1463: ifnonnull +17 -> 1480
          //   1466: ldc 60
          //   1468: ldc_w 427
          //   1471: invokestatic 67	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   1474: ldc 24
          //   1476: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1479: return
          //   1480: aload 6
          //   1482: ifnonnull +26 -> 1508
          //   1485: ldc 60
          //   1487: ldc_w 429
          //   1490: iconst_1
          //   1491: anewarray 4	java/lang/Object
          //   1494: dup
          //   1495: iconst_0
          //   1496: aload 7
          //   1498: aastore
          //   1499: invokestatic 90	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   1502: ldc 24
          //   1504: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1507: return
          //   1508: new 431	com/tencent/mm/modelvideo/f
          //   1511: dup
          //   1512: aload 6
          //   1514: aload 5
          //   1516: invokevirtual 123	com/tencent/mm/plugin/sns/storage/p:dMu	()Ljava/lang/String;
          //   1519: invokespecial 434	com/tencent/mm/modelvideo/f:<init>	(Lcom/tencent/mm/i/h;Ljava/lang/String;)V
          //   1522: astore 6
          //   1524: aload 6
          //   1526: aload_0
          //   1527: getfield 17	com/tencent/mm/plugin/sns/model/av$5:xWY	Lcom/tencent/mm/plugin/sns/model/av;
          //   1530: getfield 74	com/tencent/mm/plugin/sns/model/av:hZE	Z
          //   1533: putfield 437	com/tencent/mm/modelvideo/f:hZi	Z
          //   1536: aload 6
          //   1538: aload_0
          //   1539: getfield 17	com/tencent/mm/plugin/sns/model/av$5:xWY	Lcom/tencent/mm/plugin/sns/model/av;
          //   1542: invokevirtual 440	com/tencent/mm/modelvideo/f:a	(Lcom/tencent/mm/modelvideo/f$a;)I
          //   1545: ifge +179 -> 1724
          //   1548: ldc 60
          //   1550: ldc_w 442
          //   1553: iconst_1
          //   1554: anewarray 4	java/lang/Object
          //   1557: dup
          //   1558: iconst_0
          //   1559: aload_0
          //   1560: getfield 17	com/tencent/mm/plugin/sns/model/av$5:xWY	Lcom/tencent/mm/plugin/sns/model/av;
          //   1563: invokevirtual 187	java/lang/Object:hashCode	()I
          //   1566: invokestatic 192	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1569: aastore
          //   1570: invokestatic 445	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   1573: aload_0
          //   1574: getfield 17	com/tencent/mm/plugin/sns/model/av$5:xWY	Lcom/tencent/mm/plugin/sns/model/av;
          //   1577: getfield 102	com/tencent/mm/plugin/sns/model/av:xWT	Ljava/util/LinkedList;
          //   1580: astore 6
          //   1582: aload 6
          //   1584: monitorenter
          //   1585: aload_0
          //   1586: getfield 17	com/tencent/mm/plugin/sns/model/av$5:xWY	Lcom/tencent/mm/plugin/sns/model/av;
          //   1589: getfield 102	com/tencent/mm/plugin/sns/model/av:xWT	Ljava/util/LinkedList;
          //   1592: invokevirtual 106	java/util/LinkedList:iterator	()Ljava/util/Iterator;
          //   1595: astore 7
          //   1597: aload 7
          //   1599: invokeinterface 113 1 0
          //   1604: ifeq +203 -> 1807
          //   1607: aload 7
          //   1609: invokeinterface 117 1 0
          //   1614: checkcast 119	com/tencent/mm/plugin/sns/storage/p
          //   1617: astore 8
          //   1619: aload 8
          //   1621: ifnull -24 -> 1597
          //   1624: aload 8
          //   1626: invokevirtual 123	com/tencent/mm/plugin/sns/storage/p:dMu	()Ljava/lang/String;
          //   1629: aload 5
          //   1631: invokevirtual 123	com/tencent/mm/plugin/sns/storage/p:dMu	()Ljava/lang/String;
          //   1634: invokestatic 449	com/tencent/mm/sdk/platformtools/bs:lr	(Ljava/lang/String;Ljava/lang/String;)Z
          //   1637: ifeq -40 -> 1597
          //   1640: ldc 60
          //   1642: ldc_w 451
          //   1645: iconst_2
          //   1646: anewarray 4	java/lang/Object
          //   1649: dup
          //   1650: iconst_0
          //   1651: aload 5
          //   1653: invokevirtual 123	com/tencent/mm/plugin/sns/storage/p:dMu	()Ljava/lang/String;
          //   1656: aastore
          //   1657: dup
          //   1658: iconst_1
          //   1659: aload_0
          //   1660: getfield 17	com/tencent/mm/plugin/sns/model/av$5:xWY	Lcom/tencent/mm/plugin/sns/model/av;
          //   1663: invokevirtual 187	java/lang/Object:hashCode	()I
          //   1666: invokestatic 192	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1669: aastore
          //   1670: invokestatic 90	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   1673: aload 7
          //   1675: invokeinterface 129 1 0
          //   1680: goto -83 -> 1597
          //   1683: astore 5
          //   1685: aload 6
          //   1687: monitorexit
          //   1688: ldc 24
          //   1690: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1693: aload 5
          //   1695: athrow
          //   1696: astore 5
          //   1698: ldc 60
          //   1700: aload 5
          //   1702: ldc 108
          //   1704: iconst_0
          //   1705: anewarray 4	java/lang/Object
          //   1708: invokestatic 455	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
          //   1711: aload_0
          //   1712: getfield 17	com/tencent/mm/plugin/sns/model/av$5:xWY	Lcom/tencent/mm/plugin/sns/model/av;
          //   1715: invokevirtual 456	com/tencent/mm/plugin/sns/model/av:dIN	()V
          //   1718: ldc 24
          //   1720: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1723: return
          //   1724: ldc 60
          //   1726: ldc_w 458
          //   1729: iconst_2
          //   1730: anewarray 4	java/lang/Object
          //   1733: dup
          //   1734: iconst_0
          //   1735: aload 6
          //   1737: getfield 461	com/tencent/mm/modelvideo/f:ddB	Ljava/lang/String;
          //   1740: aastore
          //   1741: dup
          //   1742: iconst_1
          //   1743: aload 9
          //   1745: getfield 208	com/tencent/mm/pointers/PInt:value	I
          //   1748: invokestatic 192	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1751: aastore
          //   1752: invokestatic 90	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   1755: aload 6
          //   1757: invokestatic 467	java/lang/System:currentTimeMillis	()J
          //   1760: putfield 470	com/tencent/mm/modelvideo/f:hZh	J
          //   1763: aload_0
          //   1764: getfield 17	com/tencent/mm/plugin/sns/model/av$5:xWY	Lcom/tencent/mm/plugin/sns/model/av;
          //   1767: getfield 50	com/tencent/mm/plugin/sns/model/av:xWU	Ljava/util/LinkedList;
          //   1770: astore 7
          //   1772: aload 7
          //   1774: monitorenter
          //   1775: aload_0
          //   1776: getfield 17	com/tencent/mm/plugin/sns/model/av$5:xWY	Lcom/tencent/mm/plugin/sns/model/av;
          //   1779: getfield 50	com/tencent/mm/plugin/sns/model/av:xWU	Ljava/util/LinkedList;
          //   1782: iconst_0
          //   1783: aload 6
          //   1785: invokevirtual 474	java/util/LinkedList:add	(ILjava/lang/Object;)V
          //   1788: aload 7
          //   1790: monitorexit
          //   1791: goto -218 -> 1573
          //   1794: astore 5
          //   1796: aload 7
          //   1798: monitorexit
          //   1799: ldc 24
          //   1801: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1804: aload 5
          //   1806: athrow
          //   1807: aload 6
          //   1809: monitorexit
          //   1810: ldc 24
          //   1812: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1815: return
          //   1816: aload 7
          //   1818: astore 8
          //   1820: aload 6
          //   1822: astore 7
          //   1824: aload 5
          //   1826: astore 6
          //   1828: aload 8
          //   1830: astore 5
          //   1832: goto -374 -> 1458
          //   1835: aconst_null
          //   1836: astore 5
          //   1838: goto -1482 -> 356
          //   1841: iconst_3
          //   1842: istore_1
          //   1843: goto -830 -> 1013
          //   1846: aconst_null
          //   1847: astore 8
          //   1849: aload 6
          //   1851: astore 7
          //   1853: aload 8
          //   1855: astore 6
          //   1857: goto -1627 -> 230
          //   1860: aload 6
          //   1862: astore 8
          //   1864: aload 5
          //   1866: astore 6
          //   1868: aload 8
          //   1870: astore 5
          //   1872: goto -414 -> 1458
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	1875	0	this	5
          //   287	1556	1	i	int
          //   1002	18	2	l	long
          //   1071	197	4	bool	boolean
          //   1394	258	5	localObject2	Object
          //   1683	11	5	localObject3	Object
          //   1696	5	5	localException	Exception
          //   1794	31	5	localObject4	Object
          //   1830	41	5	localObject5	Object
          //   156	11	6	localObject6	Object
          //   273	1596	8	localObject9	Object
          //   191	1553	9	localPInt	com.tencent.mm.pointers.PInt
          //   182	729	11	localPBool	com.tencent.mm.pointers.PBool
          //   200	569	12	localPString	com.tencent.mm.pointers.PString
          //   224	138	13	localIterator	Iterator
          //   409	1001	14	localObject10	Object
          //   955	400	15	localObject11	Object
          //   311	1049	16	localObject12	Object
          //   1085	299	17	localObject13	Object
          // Exception table:
          //   from	to	target	type
          //   52	82	156	finally
          //   88	91	156	finally
          //   158	161	156	finally
          //   214	226	1394	finally
          //   230	275	1394	finally
          //   280	286	1394	finally
          //   288	303	1394	finally
          //   307	320	1394	finally
          //   325	353	1394	finally
          //   361	368	1394	finally
          //   383	399	1394	finally
          //   404	411	1394	finally
          //   416	424	1394	finally
          //   424	437	1394	finally
          //   442	446	1394	finally
          //   450	478	1394	finally
          //   483	531	1394	finally
          //   536	542	1394	finally
          //   547	553	1394	finally
          //   558	564	1394	finally
          //   569	591	1394	finally
          //   596	612	1394	finally
          //   617	624	1394	finally
          //   629	637	1394	finally
          //   637	650	1394	finally
          //   655	763	1394	finally
          //   768	838	1394	finally
          //   842	848	1394	finally
          //   853	873	1394	finally
          //   876	896	1394	finally
          //   899	905	1394	finally
          //   910	916	1394	finally
          //   921	1011	1394	finally
          //   1013	1054	1394	finally
          //   1060	1144	1394	finally
          //   1149	1224	1394	finally
          //   1235	1243	1394	finally
          //   1243	1372	1394	finally
          //   1383	1391	1394	finally
          //   1396	1399	1394	finally
          //   1407	1455	1394	finally
          //   1458	1461	1394	finally
          //   1585	1597	1683	finally
          //   1597	1619	1683	finally
          //   1624	1680	1683	finally
          //   1685	1688	1683	finally
          //   1807	1810	1683	finally
          //   1508	1573	1696	java/lang/Exception
          //   1573	1585	1696	java/lang/Exception
          //   1688	1696	1696	java/lang/Exception
          //   1724	1775	1696	java/lang/Exception
          //   1799	1807	1696	java/lang/Exception
          //   1810	1815	1696	java/lang/Exception
          //   1775	1791	1794	finally
          //   1796	1799	1794	finally
        }
      });
      AppMethodBeat.o(95978);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final boolean dIO()
  {
    AppMethodBeat.i(95980);
    long l1 = bs.Gn();
    int i = com.tencent.mm.plugin.sns.model.b.a.dJi();
    long l2 = bs.aNx() - i * 86400L;
    ac.i("MicroMsg.SnsVideoService", "%d start to delete expired file limit[%d] status[%d] expiredTime[%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(1), Integer.valueOf(130), Long.valueOf(l2) });
    List localList = o.aJy().z(130, l2);
    if ((localList == null) || (localList.isEmpty()))
    {
      AppMethodBeat.o(95980);
      return false;
    }
    Iterator localIterator = localList.iterator();
    i = 0;
    s locals;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      locals = (s)localIterator.next();
    } while (locals == null);
    label446:
    for (;;)
    {
      try
      {
        Object localObject = au.atY(locals.getFileName());
        localObject = af.dHR().auT((String)localObject);
        if ((localObject == null) || (((p)localObject).dLV().FQo == null) || (bs.gY(((p)localObject).dLV().FQo.Etz))) {
          break;
        }
        localObject = au.D((btz)((p)localObject).dLV().FQo.Etz.get(0));
        if (bs.isNullOrNil((String)localObject)) {
          break label446;
        }
        com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e((String)localObject);
        if (!locale.exists()) {
          break label446;
        }
        l2 = locale.length();
        ac.i("MicroMsg.SnsVideoService", "%s file[%d %d] lastmodifytime[%d] path[%s]", new Object[] { locals.getFileName(), Long.valueOf(l2), Integer.valueOf(locals.dnl), Long.valueOf(locals.iaH), localObject });
        if ((l2 <= 0L) || (l2 > locals.dnl)) {
          break label446;
        }
        locale.delete();
        i += 1;
      }
      catch (Exception localException1)
      {
        try
        {
          locals.dnl = 0;
          locals.drx = 1;
          u.f(locals);
        }
        catch (Exception localException2)
        {
          break label363;
        }
        localException1 = localException1;
      }
      label363:
      break;
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 145L, i, false);
      ac.i("MicroMsg.SnsVideoService", "%d delete expire file size %d delete count %d costTime[%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(localList.size()), Integer.valueOf(i), Long.valueOf(bs.aO(l1)) });
      AppMethodBeat.o(95980);
      return false;
    }
  }
  
  final void dIP()
  {
    AppMethodBeat.i(95983);
    g.agS();
    g.agU().az(new Runnable()
    {
      public final void run()
      {
        boolean bool2 = false;
        AppMethodBeat.i(95971);
        if (av.this.xWR.isEmpty())
        {
          ac.i("MicroMsg.SnsVideoService", "download queue is null, do nothing");
          av.b(av.this);
          AppMethodBeat.o(95971);
          return;
        }
        bc localbc1 = (bc)av.this.xWR.poll();
        if (localbc1 == null)
        {
          ac.w("MicroMsg.SnsVideoService", "try start download video task is null. queue size %d", new Object[] { Integer.valueOf(av.this.xWR.size()) });
          av.b(av.this);
          AppMethodBeat.o(95971);
          return;
        }
        boolean bool1 = bool2;
        if (av.this.xWQ != null)
        {
          bool1 = bool2;
          if (localbc1.hYq.equals(av.this.xWQ.hYq)) {
            bool1 = true;
          }
        }
        Object localObject = av.this;
        synchronized (((av)localObject).xWU)
        {
          localObject = ((av)localObject).xWU.iterator();
          if (((Iterator)localObject).hasNext())
          {
            f localf = (f)((Iterator)localObject).next();
            ac.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_PAUSE pause preload sns:[%s]", new Object[] { localf.ddB });
            localf.stop();
          }
        }
        av.this.a(localbc2, bool1);
        AppMethodBeat.o(95971);
      }
    });
    AppMethodBeat.o(95983);
  }
  
  public final boolean r(final String paramString, final Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(95982);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(95982);
      return false;
    }
    g.agS();
    g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95969);
        o.aJz().k(paramString, paramArrayOfObject);
        if ((av.this.xWQ != null) && (bs.lr(av.this.xWQ.hYq, paramString))) {
          av.a(av.this);
        }
        bc localbc = (bc)av.this.xWS.get(paramString);
        av.this.xWR.remove(localbc);
        AppMethodBeat.o(95969);
      }
    });
    AppMethodBeat.o(95982);
    return true;
  }
  
  public final boolean x(p paramp)
  {
    AppMethodBeat.i(95976);
    if (paramp == null)
    {
      ac.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_ADD null snsInfo . [fail in queue]");
      AppMethodBeat.o(95976);
      return false;
    }
    this.xWV = com.tencent.mm.plugin.sns.model.b.a.dJe();
    this.xWW = com.tencent.mm.plugin.sns.model.b.a.dJd();
    synchronized (this.xWT)
    {
      if (this.xWT.size() >= this.xWW)
      {
        ac.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_ADD sns:[%s] full stack .[fail in queue]", new Object[] { paramp.dMu() });
        AppMethodBeat.o(95976);
        return false;
      }
      this.xWT.add(paramp);
      ac.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_ADD hash(%d) sns:[%s] add preload video  [success in queue]", new Object[] { Integer.valueOf(hashCode()), paramp.dMu() });
      AppMethodBeat.o(95976);
      return true;
    }
  }
  
  public final void y(p paramp)
  {
    AppMethodBeat.i(176274);
    if (paramp == null)
    {
      ac.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_ADD null snsInfo . [fail in queue]");
      AppMethodBeat.o(176274);
      return;
    }
    synchronized (this.xWU)
    {
      Object localObject = this.xWU.iterator();
      while (((Iterator)localObject).hasNext())
      {
        f localf = (f)((Iterator)localObject).next();
        if (localf.ddB.equals(paramp.dMu()))
        {
          localf.hZh = System.currentTimeMillis();
          Collections.sort(this.xWU, new Comparator() {});
          ac.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_ADD sns:[%s] is downloading. [already in queue]", new Object[] { paramp.dMu() });
          AppMethodBeat.o(176274);
          return;
        }
      }
      if (this.xWU.size() >= this.xWV)
      {
        localObject = (f)this.xWU.poll();
        if (localObject != null)
        {
          ((f)localObject).stop();
          ac.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_ADD sns:[%s] cancel preload.", new Object[] { paramp.dMu() });
        }
      }
      if (x(paramp)) {
        dIN();
      }
      AppMethodBeat.o(176274);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.av
 * JD-Core Version:    0.7.0.1
 */