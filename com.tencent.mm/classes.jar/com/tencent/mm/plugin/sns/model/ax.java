package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ny;
import com.tencent.mm.i.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.f;
import com.tencent.mm.modelvideo.f.a;
import com.tencent.mm.modelvideo.i;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.cmj;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bk;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class ax
  implements f.a
{
  public boolean ivS;
  public boolean ivT;
  c zCJ;
  c zCK;
  be zEe;
  LinkedList<be> zEf;
  Map<String, be> zEg;
  public LinkedList<p> zEh;
  LinkedList<f> zEi;
  int zEj;
  private int zEk;
  c zEl;
  
  public ax()
  {
    AppMethodBeat.i(95974);
    this.zEf = null;
    this.zEg = null;
    this.zEh = null;
    this.zEi = new LinkedList();
    this.zEj = 3;
    this.zEk = 6;
    this.ivS = false;
    this.ivT = false;
    this.zEl = new c() {};
    this.zCJ = new c() {};
    this.zCK = new c() {};
    this.zEe = null;
    this.zEf = new LinkedList();
    this.zEg = new HashMap();
    this.zEh = new LinkedList();
    com.tencent.mm.sdk.b.a.IvT.c(this.zEl);
    com.tencent.mm.sdk.b.a.IvT.c(this.zCJ);
    com.tencent.mm.sdk.b.a.IvT.c(this.zCK);
    AppMethodBeat.o(95974);
  }
  
  public final void A(p paramp)
  {
    AppMethodBeat.i(176274);
    if (paramp == null)
    {
      ae.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_ADD null snsInfo . [fail in queue]");
      AppMethodBeat.o(176274);
      return;
    }
    synchronized (this.zEi)
    {
      Object localObject = this.zEi.iterator();
      while (((Iterator)localObject).hasNext())
      {
        f localf = (f)((Iterator)localObject).next();
        if (localf.dqc.equals(paramp.eco()))
        {
          localf.ivx = System.currentTimeMillis();
          Collections.sort(this.zEi, new Comparator() {});
          ae.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_ADD sns:[%s] is downloading. [already in queue]", new Object[] { paramp.eco() });
          AppMethodBeat.o(176274);
          return;
        }
      }
      if (this.zEi.size() >= this.zEj)
      {
        localObject = (f)this.zEi.poll();
        if (localObject != null)
        {
          ((f)localObject).stop();
          ae.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_ADD sns:[%s] cancel preload.", new Object[] { paramp.eco() });
        }
      }
      if (z(paramp)) {
        dYA();
      }
      AppMethodBeat.o(176274);
      return;
    }
  }
  
  public final void a(f paramf, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95979);
    if (paramf == null)
    {
      ae.e("MicroMsg.SnsVideoService", "%d on preload finish but scene is null?", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(95979);
      return;
    }
    for (;;)
    {
      synchronized (this.zEi)
      {
        localObject1 = this.zEi.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label235;
        }
        if (paramf != (f)((Iterator)localObject1).next()) {
          continue;
        }
        localObject1 = paramf;
        if (localObject1 == null)
        {
          ae.w("MicroMsg.SnsVideoService", "%d on preload finish, but scene callback not same object.", new Object[] { Integer.valueOf(hashCode()) });
          AppMethodBeat.o(95979);
          return;
        }
      }
      ??? = aw.aAw(paramf.dqc);
      if (??? != null)
      {
        ((s)???).hPI = paramInt2;
        u.f((s)???);
      }
      ae.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_DONE  preload video[%s] finish success[%b] range[%d, %d]  hash:[%d]", new Object[] { paramf.aMY(), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(hashCode()) });
      g.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(95968);
          com.tencent.mm.plugin.sns.model.b.a.QR(1);
          com.tencent.mm.modelvideo.o.aNj().fa(false);
          this.zEn.ivz = null;
          synchronized (ax.this.zEi)
          {
            ax.this.zEi.remove(this.zEn);
            ax.this.dYB();
            ax.this.dYA();
            AppMethodBeat.o(95968);
            return;
          }
        }
      });
      AppMethodBeat.o(95979);
      return;
      label235:
      Object localObject1 = null;
    }
  }
  
  final boolean a(be parambe, boolean paramBoolean)
  {
    AppMethodBeat.i(95984);
    Object localObject1 = aw.a(parambe.dqc, parambe.dKe);
    if (!bu.isNullOrNil((String)localObject1))
    {
      ae.i("MicroMsg.SnsVideoService", "this sns:[%s] video[%s] already download finish, do nothing. [%s, %s]", new Object[] { parambe.dqc, parambe.iuG, parambe.dqc, localObject1 });
      AppMethodBeat.o(95984);
      return false;
    }
    boolean bool = com.tencent.mm.vfs.o.aZI(aw.aAv(parambe.dKe.Id));
    localObject1 = aw.D(parambe.dKe);
    Object localObject2 = aw.aAw(parambe.dqc);
    if (localObject2 == null) {
      aw.fg(parambe.dqc, parambe.fLK);
    }
    for (;;)
    {
      ae.i("MicroMsg.SnsVideoService", "prepare stream download sns video %s mkDir %b", new Object[] { localObject1, Boolean.valueOf(bool) });
      localObject2 = new com.tencent.mm.plugin.sns.model.a.a(parambe.dKe.Id);
      ((com.tencent.mm.plugin.sns.model.a.a)localObject2).zyh = parambe.dKe;
      bk localbk = bk.fvs();
      localbk.heF = parambe.icw;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject2).zFp = localbk;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject2).zFn = true;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject2).url = parambe.dKe.Url;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject2).zFm = false;
      n.aNf();
      com.tencent.mm.modelvideo.o.aNi();
      localObject1 = com.tencent.mm.an.e.a(((com.tencent.mm.plugin.sns.model.a.a)localObject2).zFp, ((com.tencent.mm.plugin.sns.model.a.a)localObject2).url, (String)localObject1, aw.HI(parambe.dqc), parambe.fLI);
      if (localObject1 != null) {
        break;
      }
      AppMethodBeat.o(95984);
      return false;
      aw.c((s)localObject2, parambe.fLK);
    }
    localObject2 = parambe.zFl;
    ((h)localObject1).fLJ = ((String)localObject2);
    ((h)localObject1).dzZ = ((String)localObject2);
    try
    {
      localObject2 = al.u(ah.dXE().aBr(parambe.dqc));
      if (localObject2 != null)
      {
        ((h)localObject1).dAg = ((SnsObject)localObject2).Id;
        ((h)localObject1).fLN = ((SnsObject)localObject2).PreDownloadInfo.Hyq;
      }
    }
    catch (Exception localException)
    {
      label354:
      break label354;
    }
    this.zEe = parambe;
    this.zEe.iuG = ((h)localObject1).field_mediaId;
    ae.i("MicroMsg.SnsVideoService", "start stream download sns video cdnMediaId %s delay %b", new Object[] { this.zEe.iuG, Boolean.valueOf(paramBoolean) });
    com.tencent.mm.modelvideo.o.aNi().a((h)localObject1, paramBoolean);
    AppMethodBeat.o(95984);
    return true;
  }
  
  public final boolean a(bzh parambzh, int paramInt1, String paramString, boolean paramBoolean1, final boolean paramBoolean2, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(95981);
    if (parambzh.GXH == 2)
    {
      ae.w("MicroMsg.SnsVideoService", "add video task, but url is weixin, do nothing");
      AppMethodBeat.o(95981);
      return false;
    }
    final be localbe = new be();
    localbe.iuG = aw.cb(paramInt1, parambzh.Url);
    localbe.dKe = parambzh;
    localbe.icw = paramInt1;
    localbe.dqc = paramString;
    paramInt1 = i;
    if (paramBoolean1) {
      paramInt1 = 1;
    }
    localbe.fLI = paramInt1;
    localbe.fLK = paramInt2;
    g.ajS();
    g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95970);
        Object localObject = ah.dXE().aBr(localbe.dqc);
        be localbe = localbe;
        if (localObject != null)
        {
          localObject = ((p)localObject).field_userName;
          localbe.zFl = ((String)localObject);
          ae.i("MicroMsg.SnsVideoService", "offer [%b] video task[%s] to queue ", new Object[] { Boolean.valueOf(paramBoolean2), localbe });
          if (!paramBoolean2) {
            break label124;
          }
          ax.this.zEf.offerFirst(localbe);
        }
        for (;;)
        {
          ax.this.zEg.put(localbe.iuG, localbe);
          AppMethodBeat.o(95970);
          return;
          localObject = "";
          break;
          label124:
          ax.this.zEf.offerLast(localbe);
        }
      }
    });
    if (paramBoolean2) {
      dYC();
    }
    AppMethodBeat.o(95981);
    return true;
  }
  
  final void dYA()
  {
    try
    {
      AppMethodBeat.i(95978);
      ae.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_LOAD preload size:%d  queue size:%d", new Object[] { Integer.valueOf(this.zEi.size()), Integer.valueOf(this.zEh.size()) });
      g.ajU().aw(new Runnable()
      {
        /* Error */
        public final void run()
        {
          // Byte code:
          //   0: ldc 24
          //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   5: aload_0
          //   6: getfield 17	com/tencent/mm/plugin/sns/model/ax$5:zEm	Lcom/tencent/mm/plugin/sns/model/ax;
          //   9: getfield 34	com/tencent/mm/plugin/sns/model/ax:zEe	Lcom/tencent/mm/plugin/sns/model/be;
          //   12: ifnull +9 -> 21
          //   15: ldc 24
          //   17: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   20: return
          //   21: aload_0
          //   22: getfield 17	com/tencent/mm/plugin/sns/model/ax$5:zEm	Lcom/tencent/mm/plugin/sns/model/ax;
          //   25: getfield 41	com/tencent/mm/plugin/sns/model/ax:zEf	Ljava/util/LinkedList;
          //   28: invokevirtual 47	java/util/LinkedList:isEmpty	()Z
          //   31: ifne +9 -> 40
          //   34: ldc 24
          //   36: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   39: return
          //   40: aload_0
          //   41: getfield 17	com/tencent/mm/plugin/sns/model/ax$5:zEm	Lcom/tencent/mm/plugin/sns/model/ax;
          //   44: getfield 50	com/tencent/mm/plugin/sns/model/ax:zEi	Ljava/util/LinkedList;
          //   47: astore 6
          //   49: aload 6
          //   51: monitorenter
          //   52: aload_0
          //   53: getfield 17	com/tencent/mm/plugin/sns/model/ax$5:zEm	Lcom/tencent/mm/plugin/sns/model/ax;
          //   56: getfield 50	com/tencent/mm/plugin/sns/model/ax:zEi	Ljava/util/LinkedList;
          //   59: invokevirtual 54	java/util/LinkedList:size	()I
          //   62: aload_0
          //   63: getfield 17	com/tencent/mm/plugin/sns/model/ax$5:zEm	Lcom/tencent/mm/plugin/sns/model/ax;
          //   66: getfield 58	com/tencent/mm/plugin/sns/model/ax:zEj	I
          //   69: if_icmplt +19 -> 88
          //   72: ldc 60
          //   74: ldc 62
          //   76: invokestatic 67	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   79: aload 6
          //   81: monitorexit
          //   82: ldc 24
          //   84: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   87: return
          //   88: aload 6
          //   90: monitorexit
          //   91: aload_0
          //   92: getfield 17	com/tencent/mm/plugin/sns/model/ax$5:zEm	Lcom/tencent/mm/plugin/sns/model/ax;
          //   95: getfield 71	com/tencent/mm/plugin/sns/model/ax:ivS	Z
          //   98: ifne +19 -> 117
          //   101: aload_0
          //   102: getfield 17	com/tencent/mm/plugin/sns/model/ax$5:zEm	Lcom/tencent/mm/plugin/sns/model/ax;
          //   105: getfield 74	com/tencent/mm/plugin/sns/model/ax:ivT	Z
          //   108: ifeq +1807 -> 1915
          //   111: invokestatic 79	com/tencent/mm/plugin/sns/model/b/a:dYQ	()Z
          //   114: ifne +1801 -> 1915
          //   117: ldc 60
          //   119: ldc 81
          //   121: iconst_2
          //   122: anewarray 4	java/lang/Object
          //   125: dup
          //   126: iconst_0
          //   127: aload_0
          //   128: getfield 17	com/tencent/mm/plugin/sns/model/ax$5:zEm	Lcom/tencent/mm/plugin/sns/model/ax;
          //   131: getfield 71	com/tencent/mm/plugin/sns/model/ax:ivS	Z
          //   134: invokestatic 87	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
          //   137: aastore
          //   138: dup
          //   139: iconst_1
          //   140: invokestatic 79	com/tencent/mm/plugin/sns/model/b/a:dYQ	()Z
          //   143: invokestatic 87	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
          //   146: aastore
          //   147: invokestatic 90	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   150: iconst_1
          //   151: istore_2
          //   152: aconst_null
          //   153: astore 7
          //   155: aconst_null
          //   156: astore 6
          //   158: new 92	com/tencent/mm/pointers/PBool
          //   161: dup
          //   162: invokespecial 93	com/tencent/mm/pointers/PBool:<init>	()V
          //   165: astore 12
          //   167: new 95	com/tencent/mm/pointers/PInt
          //   170: dup
          //   171: invokespecial 96	com/tencent/mm/pointers/PInt:<init>	()V
          //   174: astore 10
          //   176: new 98	com/tencent/mm/pointers/PString
          //   179: dup
          //   180: invokespecial 99	com/tencent/mm/pointers/PString:<init>	()V
          //   183: astore 13
          //   185: aload_0
          //   186: getfield 17	com/tencent/mm/plugin/sns/model/ax$5:zEm	Lcom/tencent/mm/plugin/sns/model/ax;
          //   189: getfield 102	com/tencent/mm/plugin/sns/model/ax:zEh	Ljava/util/LinkedList;
          //   192: astore 11
          //   194: aload 11
          //   196: monitorenter
          //   197: aload_0
          //   198: getfield 17	com/tencent/mm/plugin/sns/model/ax$5:zEm	Lcom/tencent/mm/plugin/sns/model/ax;
          //   201: getfield 102	com/tencent/mm/plugin/sns/model/ax:zEh	Ljava/util/LinkedList;
          //   204: invokevirtual 106	java/util/LinkedList:iterator	()Ljava/util/Iterator;
          //   207: astore 14
          //   209: ldc 108
          //   211: astore 8
          //   213: aload 14
          //   215: invokeinterface 113 1 0
          //   220: ifeq +1725 -> 1945
          //   223: aload 14
          //   225: invokeinterface 117 1 0
          //   230: checkcast 119	com/tencent/mm/plugin/sns/storage/p
          //   233: astore 8
          //   235: aload 8
          //   237: invokevirtual 123	com/tencent/mm/plugin/sns/storage/p:eco	()Ljava/lang/String;
          //   240: astore 7
          //   242: aload 8
          //   244: bipush 32
          //   246: invokevirtual 127	com/tencent/mm/plugin/sns/storage/p:Rt	(I)Z
          //   249: ifne +41 -> 290
          //   252: iload_2
          //   253: ifeq +37 -> 290
          //   256: aconst_null
          //   257: astore 9
          //   259: ldc 60
          //   261: ldc 129
          //   263: invokestatic 67	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   266: aload 7
          //   268: astore 8
          //   270: aload 9
          //   272: astore 7
          //   274: goto -61 -> 213
          //   277: astore 7
          //   279: aload 6
          //   281: monitorexit
          //   282: ldc 24
          //   284: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   287: aload 7
          //   289: athrow
          //   290: aload_0
          //   291: getfield 17	com/tencent/mm/plugin/sns/model/ax$5:zEm	Lcom/tencent/mm/plugin/sns/model/ax;
          //   294: getfield 74	com/tencent/mm/plugin/sns/model/ax:ivT	Z
          //   297: ifeq +291 -> 588
          //   300: aload_0
          //   301: getfield 17	com/tencent/mm/plugin/sns/model/ax$5:zEm	Lcom/tencent/mm/plugin/sns/model/ax;
          //   304: astore 9
          //   306: aload 8
          //   308: ifnonnull +106 -> 414
          //   311: aload 12
          //   313: iconst_1
          //   314: putfield 132	com/tencent/mm/pointers/PBool:value	Z
          //   317: iconst_0
          //   318: istore_1
          //   319: aload 12
          //   321: getfield 132	com/tencent/mm/pointers/PBool:value	Z
          //   324: ifeq +10 -> 334
          //   327: aload 14
          //   329: invokeinterface 135 1 0
          //   334: iload_1
          //   335: ifeq +1596 -> 1931
          //   338: aload_0
          //   339: getfield 17	com/tencent/mm/plugin/sns/model/ax$5:zEm	Lcom/tencent/mm/plugin/sns/model/ax;
          //   342: astore 17
          //   344: aload 13
          //   346: getfield 138	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
          //   349: astore 9
          //   351: aload 8
          //   353: ifnull +1567 -> 1920
          //   356: aload 8
          //   358: invokevirtual 142	com/tencent/mm/plugin/sns/storage/p:ebP	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
          //   361: getfield 148	com/tencent/mm/protocal/protobuf/TimeLineObject:HUG	Lcom/tencent/mm/protocal/protobuf/abo;
          //   364: ifnull +1556 -> 1920
          //   367: aload 8
          //   369: invokevirtual 142	com/tencent/mm/plugin/sns/storage/p:ebP	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
          //   372: getfield 148	com/tencent/mm/protocal/protobuf/TimeLineObject:HUG	Lcom/tencent/mm/protocal/protobuf/abo;
          //   375: getfield 153	com/tencent/mm/protocal/protobuf/abo:Gtx	Ljava/util/LinkedList;
          //   378: invokestatic 159	com/tencent/mm/sdk/platformtools/bu:ht	(Ljava/util/List;)Z
          //   381: ifeq +602 -> 983
          //   384: goto +1536 -> 1920
          //   387: aload 6
          //   389: ifnonnull +1507 -> 1896
          //   392: aload 14
          //   394: invokeinterface 135 1 0
          //   399: aload 7
          //   401: astore 9
          //   403: aload 8
          //   405: astore 7
          //   407: aload 9
          //   409: astore 8
          //   411: goto -198 -> 213
          //   414: aload 8
          //   416: bipush 32
          //   418: invokevirtual 127	com/tencent/mm/plugin/sns/storage/p:Rt	(I)Z
          //   421: ifne +156 -> 577
          //   424: invokestatic 165	com/tencent/mm/modelvideo/o:aNj	()Lcom/tencent/mm/modelvideo/i;
          //   427: iconst_0
          //   428: invokevirtual 171	com/tencent/mm/modelvideo/i:fb	(Z)Z
          //   431: ifeq +14 -> 445
          //   434: aload 12
          //   436: iconst_1
          //   437: putfield 132	com/tencent/mm/pointers/PBool:value	Z
          //   440: iconst_0
          //   441: istore_1
          //   442: goto -123 -> 319
          //   445: aload 8
          //   447: invokestatic 177	com/tencent/mm/plugin/sns/model/al:u	(Lcom/tencent/mm/plugin/sns/storage/p;)Lcom/tencent/mm/protocal/protobuf/SnsObject;
          //   450: astore 15
          //   452: aload 15
          //   454: ifnull +11 -> 465
          //   457: aload 15
          //   459: getfield 183	com/tencent/mm/protocal/protobuf/SnsObject:PreDownloadInfo	Lcom/tencent/mm/protocal/protobuf/cmj;
          //   462: ifnonnull +21 -> 483
          //   465: ldc 60
          //   467: ldc 185
          //   469: invokestatic 67	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   472: aload 12
          //   474: iconst_1
          //   475: putfield 132	com/tencent/mm/pointers/PBool:value	Z
          //   478: iconst_0
          //   479: istore_1
          //   480: goto -161 -> 319
          //   483: invokestatic 188	com/tencent/mm/plugin/sns/model/b/a:dYT	()I
          //   486: istore_1
          //   487: iload_1
          //   488: ifgt +36 -> 524
          //   491: ldc 60
          //   493: ldc 190
          //   495: iconst_1
          //   496: anewarray 4	java/lang/Object
          //   499: dup
          //   500: iconst_0
          //   501: aload 9
          //   503: invokevirtual 193	java/lang/Object:hashCode	()I
          //   506: invokestatic 198	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   509: aastore
          //   510: invokestatic 90	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   513: aload 12
          //   515: iconst_1
          //   516: putfield 132	com/tencent/mm/pointers/PBool:value	Z
          //   519: iconst_0
          //   520: istore_1
          //   521: goto -202 -> 319
          //   524: aload 13
          //   526: new 200	java/lang/StringBuilder
          //   529: dup
          //   530: invokespecial 201	java/lang/StringBuilder:<init>	()V
          //   533: aload 15
          //   535: getfield 205	com/tencent/mm/protocal/protobuf/SnsObject:Id	J
          //   538: invokevirtual 209	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
          //   541: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   544: putfield 138	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
          //   547: aload 10
          //   549: iload_1
          //   550: putfield 214	com/tencent/mm/pointers/PInt:value	I
          //   553: invokestatic 79	com/tencent/mm/plugin/sns/model/b/a:dYQ	()Z
          //   556: ifne +21 -> 577
          //   559: ldc 60
          //   561: ldc 216
          //   563: invokestatic 67	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   566: aload 12
          //   568: iconst_1
          //   569: putfield 132	com/tencent/mm/pointers/PBool:value	Z
          //   572: iconst_0
          //   573: istore_1
          //   574: goto -255 -> 319
          //   577: aload 12
          //   579: iconst_0
          //   580: putfield 132	com/tencent/mm/pointers/PBool:value	Z
          //   583: iconst_1
          //   584: istore_1
          //   585: goto -266 -> 319
          //   588: aload_0
          //   589: getfield 17	com/tencent/mm/plugin/sns/model/ax$5:zEm	Lcom/tencent/mm/plugin/sns/model/ax;
          //   592: astore 9
          //   594: aload 8
          //   596: ifnonnull +14 -> 610
          //   599: aload 12
          //   601: iconst_1
          //   602: putfield 132	com/tencent/mm/pointers/PBool:value	Z
          //   605: iconst_0
          //   606: istore_1
          //   607: goto -288 -> 319
          //   610: aload 8
          //   612: bipush 32
          //   614: invokevirtual 127	com/tencent/mm/plugin/sns/storage/p:Rt	(I)Z
          //   617: ifeq +14 -> 631
          //   620: aload 12
          //   622: iconst_0
          //   623: putfield 132	com/tencent/mm/pointers/PBool:value	Z
          //   626: iconst_1
          //   627: istore_1
          //   628: goto -309 -> 319
          //   631: aload 8
          //   633: getfield 219	com/tencent/mm/plugin/sns/storage/p:field_createTime	I
          //   636: i2l
          //   637: invokestatic 223	com/tencent/mm/sdk/platformtools/bu:rZ	(J)J
          //   640: ldc2_w 224
          //   643: lcmp
          //   644: iflt +14 -> 658
          //   647: aload 12
          //   649: iconst_1
          //   650: putfield 132	com/tencent/mm/pointers/PBool:value	Z
          //   653: iconst_0
          //   654: istore_1
          //   655: goto -336 -> 319
          //   658: invokestatic 165	com/tencent/mm/modelvideo/o:aNj	()Lcom/tencent/mm/modelvideo/i;
          //   661: iconst_0
          //   662: invokevirtual 171	com/tencent/mm/modelvideo/i:fb	(Z)Z
          //   665: ifeq +14 -> 679
          //   668: aload 12
          //   670: iconst_1
          //   671: putfield 132	com/tencent/mm/pointers/PBool:value	Z
          //   674: iconst_0
          //   675: istore_1
          //   676: goto -357 -> 319
          //   679: aload 8
          //   681: invokestatic 177	com/tencent/mm/plugin/sns/model/al:u	(Lcom/tencent/mm/plugin/sns/storage/p;)Lcom/tencent/mm/protocal/protobuf/SnsObject;
          //   684: astore 15
          //   686: aload 15
          //   688: ifnull +11 -> 699
          //   691: aload 15
          //   693: getfield 183	com/tencent/mm/protocal/protobuf/SnsObject:PreDownloadInfo	Lcom/tencent/mm/protocal/protobuf/cmj;
          //   696: ifnonnull +21 -> 717
          //   699: ldc 60
          //   701: ldc 185
          //   703: invokestatic 67	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   706: aload 12
          //   708: iconst_1
          //   709: putfield 132	com/tencent/mm/pointers/PBool:value	Z
          //   712: iconst_0
          //   713: istore_1
          //   714: goto -395 -> 319
          //   717: ldc 60
          //   719: ldc 227
          //   721: iconst_5
          //   722: anewarray 4	java/lang/Object
          //   725: dup
          //   726: iconst_0
          //   727: aload 9
          //   729: invokevirtual 193	java/lang/Object:hashCode	()I
          //   732: invokestatic 198	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   735: aastore
          //   736: dup
          //   737: iconst_1
          //   738: aload 8
          //   740: invokevirtual 123	com/tencent/mm/plugin/sns/storage/p:eco	()Ljava/lang/String;
          //   743: aastore
          //   744: dup
          //   745: iconst_2
          //   746: aload 15
          //   748: getfield 183	com/tencent/mm/protocal/protobuf/SnsObject:PreDownloadInfo	Lcom/tencent/mm/protocal/protobuf/cmj;
          //   751: getfield 232	com/tencent/mm/protocal/protobuf/cmj:Hyq	I
          //   754: invokestatic 198	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   757: aastore
          //   758: dup
          //   759: iconst_3
          //   760: aload 15
          //   762: getfield 183	com/tencent/mm/protocal/protobuf/SnsObject:PreDownloadInfo	Lcom/tencent/mm/protocal/protobuf/cmj;
          //   765: getfield 235	com/tencent/mm/protocal/protobuf/cmj:Hyr	I
          //   768: invokestatic 198	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   771: aastore
          //   772: dup
          //   773: iconst_4
          //   774: aload 15
          //   776: getfield 183	com/tencent/mm/protocal/protobuf/SnsObject:PreDownloadInfo	Lcom/tencent/mm/protocal/protobuf/cmj;
          //   779: getfield 238	com/tencent/mm/protocal/protobuf/cmj:Hys	Ljava/lang/String;
          //   782: aastore
          //   783: invokestatic 90	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   786: aload 15
          //   788: getfield 183	com/tencent/mm/protocal/protobuf/SnsObject:PreDownloadInfo	Lcom/tencent/mm/protocal/protobuf/cmj;
          //   791: getfield 232	com/tencent/mm/protocal/protobuf/cmj:Hyq	I
          //   794: ifgt +36 -> 830
          //   797: ldc 60
          //   799: ldc 190
          //   801: iconst_1
          //   802: anewarray 4	java/lang/Object
          //   805: dup
          //   806: iconst_0
          //   807: aload 9
          //   809: invokevirtual 193	java/lang/Object:hashCode	()I
          //   812: invokestatic 198	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   815: aastore
          //   816: invokestatic 90	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   819: aload 12
          //   821: iconst_1
          //   822: putfield 132	com/tencent/mm/pointers/PBool:value	Z
          //   825: iconst_0
          //   826: istore_1
          //   827: goto -508 -> 319
          //   830: aload 13
          //   832: new 200	java/lang/StringBuilder
          //   835: dup
          //   836: invokespecial 201	java/lang/StringBuilder:<init>	()V
          //   839: aload 15
          //   841: getfield 205	com/tencent/mm/protocal/protobuf/SnsObject:Id	J
          //   844: invokevirtual 209	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
          //   847: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   850: putfield 138	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
          //   853: aload 10
          //   855: aload 15
          //   857: getfield 183	com/tencent/mm/protocal/protobuf/SnsObject:PreDownloadInfo	Lcom/tencent/mm/protocal/protobuf/cmj;
          //   860: getfield 232	com/tencent/mm/protocal/protobuf/cmj:Hyq	I
          //   863: putfield 214	com/tencent/mm/pointers/PInt:value	I
          //   866: aload 15
          //   868: getfield 183	com/tencent/mm/protocal/protobuf/SnsObject:PreDownloadInfo	Lcom/tencent/mm/protocal/protobuf/cmj;
          //   871: getfield 238	com/tencent/mm/protocal/protobuf/cmj:Hys	Ljava/lang/String;
          //   874: invokestatic 244	com/tencent/mm/modelcontrol/b:Fv	(Ljava/lang/String;)Z
          //   877: ifne +95 -> 972
          //   880: invokestatic 250	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
          //   883: invokestatic 256	com/tencent/mm/sdk/platformtools/az:isWifi	(Landroid/content/Context;)Z
          //   886: ifeq +29 -> 915
          //   889: aload 15
          //   891: getfield 183	com/tencent/mm/protocal/protobuf/SnsObject:PreDownloadInfo	Lcom/tencent/mm/protocal/protobuf/cmj;
          //   894: getfield 235	com/tencent/mm/protocal/protobuf/cmj:Hyr	I
          //   897: iconst_1
          //   898: iand
          //   899: istore_1
          //   900: iload_1
          //   901: ifle +71 -> 972
          //   904: aload 12
          //   906: iconst_0
          //   907: putfield 132	com/tencent/mm/pointers/PBool:value	Z
          //   910: iconst_1
          //   911: istore_1
          //   912: goto -593 -> 319
          //   915: invokestatic 250	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
          //   918: invokestatic 259	com/tencent/mm/sdk/platformtools/az:is4G	(Landroid/content/Context;)Z
          //   921: ifeq +17 -> 938
          //   924: aload 15
          //   926: getfield 183	com/tencent/mm/protocal/protobuf/SnsObject:PreDownloadInfo	Lcom/tencent/mm/protocal/protobuf/cmj;
          //   929: getfield 235	com/tencent/mm/protocal/protobuf/cmj:Hyr	I
          //   932: iconst_2
          //   933: iand
          //   934: istore_1
          //   935: goto -35 -> 900
          //   938: invokestatic 250	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
          //   941: invokestatic 262	com/tencent/mm/sdk/platformtools/az:is3G	(Landroid/content/Context;)Z
          //   944: ifeq +17 -> 961
          //   947: aload 15
          //   949: getfield 183	com/tencent/mm/protocal/protobuf/SnsObject:PreDownloadInfo	Lcom/tencent/mm/protocal/protobuf/cmj;
          //   952: getfield 235	com/tencent/mm/protocal/protobuf/cmj:Hyr	I
          //   955: iconst_4
          //   956: iand
          //   957: istore_1
          //   958: goto -58 -> 900
          //   961: aload 12
          //   963: iconst_0
          //   964: putfield 132	com/tencent/mm/pointers/PBool:value	Z
          //   967: iconst_0
          //   968: istore_1
          //   969: goto -650 -> 319
          //   972: aload 12
          //   974: iconst_0
          //   975: putfield 132	com/tencent/mm/pointers/PBool:value	Z
          //   978: iconst_0
          //   979: istore_1
          //   980: goto -661 -> 319
          //   983: aload 8
          //   985: invokevirtual 142	com/tencent/mm/plugin/sns/storage/p:ebP	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
          //   988: getfield 148	com/tencent/mm/protocal/protobuf/TimeLineObject:HUG	Lcom/tencent/mm/protocal/protobuf/abo;
          //   991: getfield 153	com/tencent/mm/protocal/protobuf/abo:Gtx	Ljava/util/LinkedList;
          //   994: iconst_0
          //   995: invokevirtual 266	java/util/LinkedList:get	(I)Ljava/lang/Object;
          //   998: checkcast 268	com/tencent/mm/protocal/protobuf/bzh
          //   1001: astore 15
          //   1003: aload 8
          //   1005: invokevirtual 123	com/tencent/mm/plugin/sns/storage/p:eco	()Ljava/lang/String;
          //   1008: astore 6
          //   1010: aload 6
          //   1012: aload 15
          //   1014: invokestatic 274	com/tencent/mm/plugin/sns/model/aw:a	(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/bzh;)Ljava/lang/String;
          //   1017: astore 16
          //   1019: aload 16
          //   1021: invokestatic 277	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
          //   1024: ifne +98 -> 1122
          //   1027: ldc 60
          //   1029: ldc_w 279
          //   1032: iconst_2
          //   1033: anewarray 4	java/lang/Object
          //   1036: dup
          //   1037: iconst_0
          //   1038: aload 8
          //   1040: invokevirtual 123	com/tencent/mm/plugin/sns/storage/p:eco	()Ljava/lang/String;
          //   1043: aastore
          //   1044: dup
          //   1045: iconst_1
          //   1046: aload 16
          //   1048: aastore
          //   1049: invokestatic 90	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   1052: aload 15
          //   1054: getfield 282	com/tencent/mm/protocal/protobuf/bzh:HmE	Ljava/lang/String;
          //   1057: astore 6
          //   1059: aload 16
          //   1061: invokestatic 288	com/tencent/mm/vfs/o:aZR	(Ljava/lang/String;)J
          //   1064: lstore_3
          //   1065: aload 17
          //   1067: getfield 74	com/tencent/mm/plugin/sns/model/ax:ivT	Z
          //   1070: ifeq +856 -> 1926
          //   1073: iconst_4
          //   1074: istore_1
          //   1075: invokestatic 165	com/tencent/mm/modelvideo/o:aNj	()Lcom/tencent/mm/modelvideo/i;
          //   1078: aload 6
          //   1080: iload_1
          //   1081: lload_3
          //   1082: aload 8
          //   1084: getfield 291	com/tencent/mm/plugin/sns/storage/p:field_userName	Ljava/lang/String;
          //   1087: ldc 108
          //   1089: iconst_0
          //   1090: ldc 108
          //   1092: aload 15
          //   1094: getfield 294	com/tencent/mm/protocal/protobuf/bzh:Url	Ljava/lang/String;
          //   1097: aload 9
          //   1099: invokevirtual 297	com/tencent/mm/modelvideo/i:a	(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
          //   1102: getstatic 303	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
          //   1105: ldc2_w 304
          //   1108: ldc2_w 306
          //   1111: lconst_1
          //   1112: iconst_0
          //   1113: invokevirtual 311	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
          //   1116: aconst_null
          //   1117: astore 6
          //   1119: goto -732 -> 387
          //   1122: aload 15
          //   1124: getfield 313	com/tencent/mm/protocal/protobuf/bzh:Id	Ljava/lang/String;
          //   1127: invokestatic 317	com/tencent/mm/plugin/sns/model/aw:aAv	(Ljava/lang/String;)Ljava/lang/String;
          //   1130: invokestatic 320	com/tencent/mm/vfs/o:aZI	(Ljava/lang/String;)Z
          //   1133: istore 5
          //   1135: aload 15
          //   1137: invokestatic 324	com/tencent/mm/plugin/sns/model/aw:D	(Lcom/tencent/mm/protocal/protobuf/bzh;)Ljava/lang/String;
          //   1140: astore 17
          //   1142: aload 6
          //   1144: invokestatic 328	com/tencent/mm/plugin/sns/model/aw:aAw	(Ljava/lang/String;)Lcom/tencent/mm/modelvideo/s;
          //   1147: astore 18
          //   1149: aload 8
          //   1151: bipush 32
          //   1153: invokevirtual 127	com/tencent/mm/plugin/sns/storage/p:Rt	(I)Z
          //   1156: ifeq +140 -> 1296
          //   1159: bipush 100
          //   1161: istore_1
          //   1162: aload 10
          //   1164: iload_1
          //   1165: putfield 214	com/tencent/mm/pointers/PInt:value	I
          //   1168: ldc 60
          //   1170: ldc_w 330
          //   1173: iconst_3
          //   1174: anewarray 4	java/lang/Object
          //   1177: dup
          //   1178: iconst_0
          //   1179: aload 8
          //   1181: invokevirtual 123	com/tencent/mm/plugin/sns/storage/p:eco	()Ljava/lang/String;
          //   1184: aastore
          //   1185: dup
          //   1186: iconst_1
          //   1187: aload 15
          //   1189: getfield 334	com/tencent/mm/protocal/protobuf/bzh:HmF	F
          //   1192: invokestatic 339	java/lang/Float:valueOf	(F)Ljava/lang/Float;
          //   1195: aastore
          //   1196: dup
          //   1197: iconst_2
          //   1198: aload 10
          //   1200: getfield 214	com/tencent/mm/pointers/PInt:value	I
          //   1203: invokestatic 198	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1206: aastore
          //   1207: invokestatic 90	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   1210: aload 18
          //   1212: ifnull +98 -> 1310
          //   1215: ldc 60
          //   1217: ldc_w 341
          //   1220: iconst_1
          //   1221: anewarray 4	java/lang/Object
          //   1224: dup
          //   1225: iconst_0
          //   1226: aload 18
          //   1228: invokevirtual 344	com/tencent/mm/modelvideo/s:toString	()Ljava/lang/String;
          //   1231: aastore
          //   1232: invokestatic 90	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   1235: aload 18
          //   1237: getfield 347	com/tencent/mm/modelvideo/s:hPI	I
          //   1240: ifle +70 -> 1310
          //   1243: aload 18
          //   1245: getfield 350	com/tencent/mm/modelvideo/s:dAe	I
          //   1248: bipush 100
          //   1250: imul
          //   1251: aload 18
          //   1253: getfield 347	com/tencent/mm/modelvideo/s:hPI	I
          //   1256: idiv
          //   1257: aload 10
          //   1259: getfield 214	com/tencent/mm/pointers/PInt:value	I
          //   1262: if_icmplt +48 -> 1310
          //   1265: ldc 60
          //   1267: ldc_w 352
          //   1270: iconst_2
          //   1271: anewarray 4	java/lang/Object
          //   1274: dup
          //   1275: iconst_0
          //   1276: aload 8
          //   1278: invokevirtual 123	com/tencent/mm/plugin/sns/storage/p:eco	()Ljava/lang/String;
          //   1281: aastore
          //   1282: dup
          //   1283: iconst_1
          //   1284: aload 16
          //   1286: aastore
          //   1287: invokestatic 90	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   1290: aconst_null
          //   1291: astore 6
          //   1293: goto -906 -> 387
          //   1296: aload 15
          //   1298: aload 10
          //   1300: getfield 214	com/tencent/mm/pointers/PInt:value	I
          //   1303: invokestatic 355	com/tencent/mm/plugin/sns/model/b/a:a	(Lcom/tencent/mm/protocal/protobuf/bzh;I)I
          //   1306: istore_1
          //   1307: goto -145 -> 1162
          //   1310: aload 18
          //   1312: ifnonnull +151 -> 1463
          //   1315: aload 6
          //   1317: bipush 30
          //   1319: invokestatic 359	com/tencent/mm/plugin/sns/model/aw:fg	(Ljava/lang/String;I)Z
          //   1322: pop
          //   1323: ldc 60
          //   1325: ldc_w 361
          //   1328: iconst_3
          //   1329: anewarray 4	java/lang/Object
          //   1332: dup
          //   1333: iconst_0
          //   1334: aload 8
          //   1336: invokevirtual 123	com/tencent/mm/plugin/sns/storage/p:eco	()Ljava/lang/String;
          //   1339: aastore
          //   1340: dup
          //   1341: iconst_1
          //   1342: aload 17
          //   1344: aastore
          //   1345: dup
          //   1346: iconst_2
          //   1347: iload 5
          //   1349: invokestatic 87	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
          //   1352: aastore
          //   1353: invokestatic 90	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   1356: new 363	com/tencent/mm/plugin/sns/model/a/a
          //   1359: dup
          //   1360: aload 15
          //   1362: getfield 313	com/tencent/mm/protocal/protobuf/bzh:Id	Ljava/lang/String;
          //   1365: invokespecial 366	com/tencent/mm/plugin/sns/model/a/a:<init>	(Ljava/lang/String;)V
          //   1368: astore 16
          //   1370: aload 16
          //   1372: aload 15
          //   1374: putfield 370	com/tencent/mm/plugin/sns/model/a/a:zyh	Lcom/tencent/mm/protocal/protobuf/bzh;
          //   1377: invokestatic 376	com/tencent/mm/storage/bk:fvs	()Lcom/tencent/mm/storage/bk;
          //   1380: astore 18
          //   1382: aload 18
          //   1384: aload 8
          //   1386: getfield 219	com/tencent/mm/plugin/sns/storage/p:field_createTime	I
          //   1389: putfield 379	com/tencent/mm/storage/bk:heF	I
          //   1392: aload 16
          //   1394: aload 18
          //   1396: putfield 383	com/tencent/mm/plugin/sns/model/a/a:zFp	Lcom/tencent/mm/storage/bk;
          //   1399: aload 16
          //   1401: iconst_1
          //   1402: putfield 386	com/tencent/mm/plugin/sns/model/a/a:zFn	Z
          //   1405: aload 16
          //   1407: aload 15
          //   1409: getfield 294	com/tencent/mm/protocal/protobuf/bzh:Url	Ljava/lang/String;
          //   1412: putfield 389	com/tencent/mm/plugin/sns/model/a/a:url	Ljava/lang/String;
          //   1415: aload 16
          //   1417: iconst_0
          //   1418: putfield 392	com/tencent/mm/plugin/sns/model/a/a:zFm	Z
          //   1421: invokestatic 398	com/tencent/mm/modelvideo/n:aNf	()Lcom/tencent/mm/modelvideo/n;
          //   1424: pop
          //   1425: invokestatic 402	com/tencent/mm/modelvideo/o:aNi	()Lcom/tencent/mm/an/e;
          //   1428: pop
          //   1429: aload 16
          //   1431: getfield 383	com/tencent/mm/plugin/sns/model/a/a:zFp	Lcom/tencent/mm/storage/bk;
          //   1434: aload 16
          //   1436: getfield 389	com/tencent/mm/plugin/sns/model/a/a:url	Ljava/lang/String;
          //   1439: aload 17
          //   1441: aload 6
          //   1443: invokestatic 405	com/tencent/mm/plugin/sns/model/aw:HI	(Ljava/lang/String;)Ljava/lang/String;
          //   1446: iconst_2
          //   1447: invokestatic 410	com/tencent/mm/an/e:a	(Lcom/tencent/mm/storage/bk;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lcom/tencent/mm/i/h;
          //   1450: astore 6
          //   1452: aload 6
          //   1454: ifnonnull +33 -> 1487
          //   1457: aconst_null
          //   1458: astore 6
          //   1460: goto -1073 -> 387
          //   1463: aload 18
          //   1465: bipush 30
          //   1467: invokestatic 414	com/tencent/mm/plugin/sns/model/aw:c	(Lcom/tencent/mm/modelvideo/s;I)Z
          //   1470: pop
          //   1471: goto -148 -> 1323
          //   1474: astore 6
          //   1476: aload 11
          //   1478: monitorexit
          //   1479: ldc 24
          //   1481: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1484: aload 6
          //   1486: athrow
          //   1487: aload 6
          //   1489: aload 15
          //   1491: getfield 282	com/tencent/mm/protocal/protobuf/bzh:HmE	Ljava/lang/String;
          //   1494: putfield 419	com/tencent/mm/i/h:cTe	Ljava/lang/String;
          //   1497: aload 6
          //   1499: aload 10
          //   1501: getfield 214	com/tencent/mm/pointers/PInt:value	I
          //   1504: putfield 422	com/tencent/mm/i/h:field_preloadRatio	I
          //   1507: aload 6
          //   1509: aload 9
          //   1511: putfield 425	com/tencent/mm/i/h:dAg	Ljava/lang/String;
          //   1514: aload 8
          //   1516: getfield 291	com/tencent/mm/plugin/sns/storage/p:field_userName	Ljava/lang/String;
          //   1519: astore 9
          //   1521: aload 6
          //   1523: aload 9
          //   1525: putfield 428	com/tencent/mm/i/h:fLJ	Ljava/lang/String;
          //   1528: aload 6
          //   1530: aload 9
          //   1532: putfield 431	com/tencent/mm/i/h:dzZ	Ljava/lang/String;
          //   1535: goto -1148 -> 387
          //   1538: aload 11
          //   1540: monitorexit
          //   1541: aload 6
          //   1543: ifnonnull +17 -> 1560
          //   1546: ldc 60
          //   1548: ldc_w 433
          //   1551: invokestatic 67	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   1554: ldc 24
          //   1556: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1559: return
          //   1560: aload 7
          //   1562: ifnonnull +26 -> 1588
          //   1565: ldc 60
          //   1567: ldc_w 435
          //   1570: iconst_1
          //   1571: anewarray 4	java/lang/Object
          //   1574: dup
          //   1575: iconst_0
          //   1576: aload 8
          //   1578: aastore
          //   1579: invokestatic 90	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   1582: ldc 24
          //   1584: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1587: return
          //   1588: new 437	com/tencent/mm/modelvideo/f
          //   1591: dup
          //   1592: aload 7
          //   1594: aload 6
          //   1596: invokevirtual 123	com/tencent/mm/plugin/sns/storage/p:eco	()Ljava/lang/String;
          //   1599: invokespecial 440	com/tencent/mm/modelvideo/f:<init>	(Lcom/tencent/mm/i/h;Ljava/lang/String;)V
          //   1602: astore 7
          //   1604: aload 7
          //   1606: aload_0
          //   1607: getfield 17	com/tencent/mm/plugin/sns/model/ax$5:zEm	Lcom/tencent/mm/plugin/sns/model/ax;
          //   1610: getfield 74	com/tencent/mm/plugin/sns/model/ax:ivT	Z
          //   1613: putfield 443	com/tencent/mm/modelvideo/f:ivy	Z
          //   1616: aload 7
          //   1618: aload_0
          //   1619: getfield 17	com/tencent/mm/plugin/sns/model/ax$5:zEm	Lcom/tencent/mm/plugin/sns/model/ax;
          //   1622: invokevirtual 446	com/tencent/mm/modelvideo/f:a	(Lcom/tencent/mm/modelvideo/f$a;)I
          //   1625: ifge +179 -> 1804
          //   1628: ldc 60
          //   1630: ldc_w 448
          //   1633: iconst_1
          //   1634: anewarray 4	java/lang/Object
          //   1637: dup
          //   1638: iconst_0
          //   1639: aload_0
          //   1640: getfield 17	com/tencent/mm/plugin/sns/model/ax$5:zEm	Lcom/tencent/mm/plugin/sns/model/ax;
          //   1643: invokevirtual 193	java/lang/Object:hashCode	()I
          //   1646: invokestatic 198	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1649: aastore
          //   1650: invokestatic 451	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   1653: aload_0
          //   1654: getfield 17	com/tencent/mm/plugin/sns/model/ax$5:zEm	Lcom/tencent/mm/plugin/sns/model/ax;
          //   1657: getfield 102	com/tencent/mm/plugin/sns/model/ax:zEh	Ljava/util/LinkedList;
          //   1660: astore 7
          //   1662: aload 7
          //   1664: monitorenter
          //   1665: aload_0
          //   1666: getfield 17	com/tencent/mm/plugin/sns/model/ax$5:zEm	Lcom/tencent/mm/plugin/sns/model/ax;
          //   1669: getfield 102	com/tencent/mm/plugin/sns/model/ax:zEh	Ljava/util/LinkedList;
          //   1672: invokevirtual 106	java/util/LinkedList:iterator	()Ljava/util/Iterator;
          //   1675: astore 8
          //   1677: aload 8
          //   1679: invokeinterface 113 1 0
          //   1684: ifeq +203 -> 1887
          //   1687: aload 8
          //   1689: invokeinterface 117 1 0
          //   1694: checkcast 119	com/tencent/mm/plugin/sns/storage/p
          //   1697: astore 9
          //   1699: aload 9
          //   1701: ifnull -24 -> 1677
          //   1704: aload 9
          //   1706: invokevirtual 123	com/tencent/mm/plugin/sns/storage/p:eco	()Ljava/lang/String;
          //   1709: aload 6
          //   1711: invokevirtual 123	com/tencent/mm/plugin/sns/storage/p:eco	()Ljava/lang/String;
          //   1714: invokestatic 455	com/tencent/mm/sdk/platformtools/bu:lX	(Ljava/lang/String;Ljava/lang/String;)Z
          //   1717: ifeq -40 -> 1677
          //   1720: ldc 60
          //   1722: ldc_w 457
          //   1725: iconst_2
          //   1726: anewarray 4	java/lang/Object
          //   1729: dup
          //   1730: iconst_0
          //   1731: aload 6
          //   1733: invokevirtual 123	com/tencent/mm/plugin/sns/storage/p:eco	()Ljava/lang/String;
          //   1736: aastore
          //   1737: dup
          //   1738: iconst_1
          //   1739: aload_0
          //   1740: getfield 17	com/tencent/mm/plugin/sns/model/ax$5:zEm	Lcom/tencent/mm/plugin/sns/model/ax;
          //   1743: invokevirtual 193	java/lang/Object:hashCode	()I
          //   1746: invokestatic 198	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1749: aastore
          //   1750: invokestatic 90	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   1753: aload 8
          //   1755: invokeinterface 135 1 0
          //   1760: goto -83 -> 1677
          //   1763: astore 6
          //   1765: aload 7
          //   1767: monitorexit
          //   1768: ldc 24
          //   1770: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1773: aload 6
          //   1775: athrow
          //   1776: astore 6
          //   1778: ldc 60
          //   1780: aload 6
          //   1782: ldc 108
          //   1784: iconst_0
          //   1785: anewarray 4	java/lang/Object
          //   1788: invokestatic 461	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
          //   1791: aload_0
          //   1792: getfield 17	com/tencent/mm/plugin/sns/model/ax$5:zEm	Lcom/tencent/mm/plugin/sns/model/ax;
          //   1795: invokevirtual 462	com/tencent/mm/plugin/sns/model/ax:dYA	()V
          //   1798: ldc 24
          //   1800: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1803: return
          //   1804: ldc 60
          //   1806: ldc_w 464
          //   1809: iconst_2
          //   1810: anewarray 4	java/lang/Object
          //   1813: dup
          //   1814: iconst_0
          //   1815: aload 7
          //   1817: getfield 467	com/tencent/mm/modelvideo/f:dqc	Ljava/lang/String;
          //   1820: aastore
          //   1821: dup
          //   1822: iconst_1
          //   1823: aload 10
          //   1825: getfield 214	com/tencent/mm/pointers/PInt:value	I
          //   1828: invokestatic 198	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1831: aastore
          //   1832: invokestatic 90	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   1835: aload 7
          //   1837: invokestatic 473	java/lang/System:currentTimeMillis	()J
          //   1840: putfield 476	com/tencent/mm/modelvideo/f:ivx	J
          //   1843: aload_0
          //   1844: getfield 17	com/tencent/mm/plugin/sns/model/ax$5:zEm	Lcom/tencent/mm/plugin/sns/model/ax;
          //   1847: getfield 50	com/tencent/mm/plugin/sns/model/ax:zEi	Ljava/util/LinkedList;
          //   1850: astore 8
          //   1852: aload 8
          //   1854: monitorenter
          //   1855: aload_0
          //   1856: getfield 17	com/tencent/mm/plugin/sns/model/ax$5:zEm	Lcom/tencent/mm/plugin/sns/model/ax;
          //   1859: getfield 50	com/tencent/mm/plugin/sns/model/ax:zEi	Ljava/util/LinkedList;
          //   1862: iconst_0
          //   1863: aload 7
          //   1865: invokevirtual 480	java/util/LinkedList:add	(ILjava/lang/Object;)V
          //   1868: aload 8
          //   1870: monitorexit
          //   1871: goto -218 -> 1653
          //   1874: astore 6
          //   1876: aload 8
          //   1878: monitorexit
          //   1879: ldc 24
          //   1881: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1884: aload 6
          //   1886: athrow
          //   1887: aload 7
          //   1889: monitorexit
          //   1890: ldc 24
          //   1892: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1895: return
          //   1896: aload 8
          //   1898: astore 9
          //   1900: aload 7
          //   1902: astore 8
          //   1904: aload 6
          //   1906: astore 7
          //   1908: aload 9
          //   1910: astore 6
          //   1912: goto -374 -> 1538
          //   1915: iconst_0
          //   1916: istore_2
          //   1917: goto -1765 -> 152
          //   1920: aconst_null
          //   1921: astore 6
          //   1923: goto -1536 -> 387
          //   1926: iconst_3
          //   1927: istore_1
          //   1928: goto -853 -> 1075
          //   1931: aconst_null
          //   1932: astore 9
          //   1934: aload 7
          //   1936: astore 8
          //   1938: aload 9
          //   1940: astore 7
          //   1942: goto -1729 -> 213
          //   1945: aload 7
          //   1947: astore 9
          //   1949: aload 6
          //   1951: astore 7
          //   1953: aload 9
          //   1955: astore 6
          //   1957: goto -419 -> 1538
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	1960	0	this	5
          //   318	1610	1	i	int
          //   151	1766	2	j	int
          //   1064	18	3	l	long
          //   1133	215	5	bool	boolean
          //   1474	258	6	localObject2	Object
          //   1763	11	6	localObject3	Object
          //   1776	5	6	localException	Exception
          //   1874	31	6	localObject4	Object
          //   1910	46	6	localObject5	Object
          //   153	120	7	localObject6	Object
          //   277	123	7	localObject7	Object
          //   257	1697	9	localObject10	Object
          //   174	1650	10	localPInt	com.tencent.mm.pointers.PInt
          //   165	808	12	localPBool	com.tencent.mm.pointers.PBool
          //   183	648	13	localPString	com.tencent.mm.pointers.PString
          //   207	186	14	localIterator	Iterator
          //   450	1040	15	localObject11	Object
          //   1017	418	16	localObject12	Object
          //   342	1098	17	localObject13	Object
          //   1147	317	18	localObject14	Object
          // Exception table:
          //   from	to	target	type
          //   52	82	277	finally
          //   88	91	277	finally
          //   279	282	277	finally
          //   197	209	1474	finally
          //   213	252	1474	finally
          //   259	266	1474	finally
          //   290	306	1474	finally
          //   311	317	1474	finally
          //   319	334	1474	finally
          //   338	351	1474	finally
          //   356	384	1474	finally
          //   392	399	1474	finally
          //   414	440	1474	finally
          //   445	452	1474	finally
          //   457	465	1474	finally
          //   465	478	1474	finally
          //   483	487	1474	finally
          //   491	519	1474	finally
          //   524	572	1474	finally
          //   577	583	1474	finally
          //   588	594	1474	finally
          //   599	605	1474	finally
          //   610	626	1474	finally
          //   631	653	1474	finally
          //   658	674	1474	finally
          //   679	686	1474	finally
          //   691	699	1474	finally
          //   699	712	1474	finally
          //   717	825	1474	finally
          //   830	900	1474	finally
          //   904	910	1474	finally
          //   915	935	1474	finally
          //   938	958	1474	finally
          //   961	967	1474	finally
          //   972	978	1474	finally
          //   983	1073	1474	finally
          //   1075	1116	1474	finally
          //   1122	1159	1474	finally
          //   1162	1210	1474	finally
          //   1215	1290	1474	finally
          //   1296	1307	1474	finally
          //   1315	1323	1474	finally
          //   1323	1452	1474	finally
          //   1463	1471	1474	finally
          //   1476	1479	1474	finally
          //   1487	1535	1474	finally
          //   1538	1541	1474	finally
          //   1665	1677	1763	finally
          //   1677	1699	1763	finally
          //   1704	1760	1763	finally
          //   1765	1768	1763	finally
          //   1887	1890	1763	finally
          //   1588	1653	1776	java/lang/Exception
          //   1653	1665	1776	java/lang/Exception
          //   1768	1776	1776	java/lang/Exception
          //   1804	1855	1776	java/lang/Exception
          //   1879	1887	1776	java/lang/Exception
          //   1890	1895	1776	java/lang/Exception
          //   1855	1871	1874	finally
          //   1876	1879	1874	finally
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
  
  /* Error */
  final boolean dYB()
  {
    // Byte code:
    //   0: ldc_w 504
    //   3: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 507	com/tencent/mm/sdk/platformtools/bu:HQ	()J
    //   9: lstore_2
    //   10: invokestatic 512	com/tencent/mm/plugin/sns/model/b/a:dYW	()I
    //   13: istore_1
    //   14: invokestatic 515	com/tencent/mm/sdk/platformtools/bu:aRi	()J
    //   17: iload_1
    //   18: i2l
    //   19: ldc2_w 516
    //   22: lmul
    //   23: lsub
    //   24: lstore 4
    //   26: ldc 203
    //   28: ldc_w 519
    //   31: iconst_4
    //   32: anewarray 4	java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: aload_0
    //   38: invokevirtual 224	java/lang/Object:hashCode	()I
    //   41: invokestatic 230	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   44: aastore
    //   45: dup
    //   46: iconst_1
    //   47: iconst_1
    //   48: invokestatic 230	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   51: aastore
    //   52: dup
    //   53: iconst_2
    //   54: sipush 130
    //   57: invokestatic 230	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   60: aastore
    //   61: dup
    //   62: iconst_3
    //   63: lload 4
    //   65: invokestatic 524	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   68: aastore
    //   69: invokestatic 210	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: invokestatic 528	com/tencent/mm/modelvideo/o:aNh	()Lcom/tencent/mm/modelvideo/t;
    //   75: sipush 130
    //   78: lload 4
    //   80: invokevirtual 533	com/tencent/mm/modelvideo/t:A	(IJ)Ljava/util/List;
    //   83: astore 6
    //   85: aload 6
    //   87: invokeinterface 538 1 0
    //   92: ifeq +11 -> 103
    //   95: ldc_w 504
    //   98: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: iconst_0
    //   102: ireturn
    //   103: aload 6
    //   105: invokeinterface 539 1 0
    //   110: astore 7
    //   112: iconst_0
    //   113: istore_1
    //   114: aload 7
    //   116: invokeinterface 141 1 0
    //   121: ifeq +240 -> 361
    //   124: aload 7
    //   126: invokeinterface 145 1 0
    //   131: checkcast 299	com/tencent/mm/modelvideo/s
    //   134: astore 8
    //   136: aload 8
    //   138: ifnull -24 -> 114
    //   141: aload 8
    //   143: invokevirtual 542	com/tencent/mm/modelvideo/s:getFileName	()Ljava/lang/String;
    //   146: invokestatic 545	com/tencent/mm/plugin/sns/model/aw:aAu	(Ljava/lang/String;)Ljava/lang/String;
    //   149: astore 9
    //   151: invokestatic 153	com/tencent/mm/plugin/sns/model/ah:dXE	()Lcom/tencent/mm/plugin/sns/storage/q;
    //   154: aload 9
    //   156: invokevirtual 163	com/tencent/mm/plugin/sns/storage/q:aBr	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sns/storage/p;
    //   159: astore 9
    //   161: aload 9
    //   163: ifnull -49 -> 114
    //   166: aload 9
    //   168: invokevirtual 169	com/tencent/mm/plugin/sns/storage/p:ebP	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   171: getfield 175	com/tencent/mm/protocal/protobuf/TimeLineObject:HUG	Lcom/tencent/mm/protocal/protobuf/abo;
    //   174: ifnull -60 -> 114
    //   177: aload 9
    //   179: invokevirtual 169	com/tencent/mm/plugin/sns/storage/p:ebP	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   182: getfield 175	com/tencent/mm/protocal/protobuf/TimeLineObject:HUG	Lcom/tencent/mm/protocal/protobuf/abo;
    //   185: getfield 180	com/tencent/mm/protocal/protobuf/abo:Gtx	Ljava/util/LinkedList;
    //   188: invokestatic 549	com/tencent/mm/sdk/platformtools/bu:ht	(Ljava/util/List;)Z
    //   191: ifne -77 -> 114
    //   194: aload 9
    //   196: invokevirtual 169	com/tencent/mm/plugin/sns/storage/p:ebP	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   199: getfield 175	com/tencent/mm/protocal/protobuf/TimeLineObject:HUG	Lcom/tencent/mm/protocal/protobuf/abo;
    //   202: getfield 180	com/tencent/mm/protocal/protobuf/abo:Gtx	Ljava/util/LinkedList;
    //   205: iconst_0
    //   206: invokevirtual 184	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   209: checkcast 186	com/tencent/mm/protocal/protobuf/bzh
    //   212: invokestatic 353	com/tencent/mm/plugin/sns/model/aw:D	(Lcom/tencent/mm/protocal/protobuf/bzh;)Ljava/lang/String;
    //   215: astore 9
    //   217: aload 9
    //   219: invokestatic 201	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   222: ifne +219 -> 441
    //   225: new 551	com/tencent/mm/vfs/k
    //   228: dup
    //   229: aload 9
    //   231: invokespecial 552	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   234: astore 10
    //   236: aload 10
    //   238: invokevirtual 555	com/tencent/mm/vfs/k:exists	()Z
    //   241: ifeq +200 -> 441
    //   244: aload 10
    //   246: invokevirtual 558	com/tencent/mm/vfs/k:length	()J
    //   249: lstore 4
    //   251: ldc 203
    //   253: ldc_w 560
    //   256: iconst_5
    //   257: anewarray 4	java/lang/Object
    //   260: dup
    //   261: iconst_0
    //   262: aload 8
    //   264: invokevirtual 542	com/tencent/mm/modelvideo/s:getFileName	()Ljava/lang/String;
    //   267: aastore
    //   268: dup
    //   269: iconst_1
    //   270: lload 4
    //   272: invokestatic 524	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   275: aastore
    //   276: dup
    //   277: iconst_2
    //   278: aload 8
    //   280: getfield 563	com/tencent/mm/modelvideo/s:dAe	I
    //   283: invokestatic 230	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   286: aastore
    //   287: dup
    //   288: iconst_3
    //   289: aload 8
    //   291: getfield 566	com/tencent/mm/modelvideo/s:iwX	J
    //   294: invokestatic 524	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   297: aastore
    //   298: dup
    //   299: iconst_4
    //   300: aload 9
    //   302: aastore
    //   303: invokestatic 210	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   306: lload 4
    //   308: lconst_0
    //   309: lcmp
    //   310: ifle +131 -> 441
    //   313: lload 4
    //   315: aload 8
    //   317: getfield 563	com/tencent/mm/modelvideo/s:dAe	I
    //   320: i2l
    //   321: lcmp
    //   322: ifgt +119 -> 441
    //   325: aload 10
    //   327: invokevirtual 569	com/tencent/mm/vfs/k:delete	()Z
    //   330: pop
    //   331: iload_1
    //   332: iconst_1
    //   333: iadd
    //   334: istore_1
    //   335: aload 8
    //   337: iconst_0
    //   338: putfield 563	com/tencent/mm/modelvideo/s:dAe	I
    //   341: aload 8
    //   343: iconst_1
    //   344: putfield 572	com/tencent/mm/modelvideo/s:dEu	I
    //   347: aload 8
    //   349: invokestatic 308	com/tencent/mm/modelvideo/u:f	(Lcom/tencent/mm/modelvideo/s;)Z
    //   352: pop
    //   353: goto -239 -> 114
    //   356: astore 8
    //   358: goto -244 -> 114
    //   361: getstatic 578	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   364: ldc2_w 579
    //   367: ldc2_w 581
    //   370: iload_1
    //   371: i2l
    //   372: iconst_0
    //   373: invokevirtual 586	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
    //   376: ldc 203
    //   378: ldc_w 588
    //   381: iconst_4
    //   382: anewarray 4	java/lang/Object
    //   385: dup
    //   386: iconst_0
    //   387: aload_0
    //   388: invokevirtual 224	java/lang/Object:hashCode	()I
    //   391: invokestatic 230	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   394: aastore
    //   395: dup
    //   396: iconst_1
    //   397: aload 6
    //   399: invokeinterface 589 1 0
    //   404: invokestatic 230	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   407: aastore
    //   408: dup
    //   409: iconst_2
    //   410: iload_1
    //   411: invokestatic 230	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   414: aastore
    //   415: dup
    //   416: iconst_3
    //   417: lload_2
    //   418: invokestatic 593	com/tencent/mm/sdk/platformtools/bu:aO	(J)J
    //   421: invokestatic 524	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   424: aastore
    //   425: invokestatic 210	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   428: ldc_w 504
    //   431: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   434: iconst_0
    //   435: ireturn
    //   436: astore 8
    //   438: goto -80 -> 358
    //   441: goto -106 -> 335
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	444	0	this	ax
    //   13	398	1	i	int
    //   9	409	2	l1	long
    //   24	290	4	l2	long
    //   83	315	6	localList	java.util.List
    //   110	15	7	localIterator	Iterator
    //   134	214	8	locals	s
    //   356	1	8	localException1	Exception
    //   436	1	8	localException2	Exception
    //   149	152	9	localObject	Object
    //   234	92	10	localk	com.tencent.mm.vfs.k
    // Exception table:
    //   from	to	target	type
    //   141	161	356	java/lang/Exception
    //   166	306	356	java/lang/Exception
    //   313	331	356	java/lang/Exception
    //   335	353	436	java/lang/Exception
  }
  
  final void dYC()
  {
    AppMethodBeat.i(95983);
    g.ajS();
    g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        boolean bool2 = false;
        AppMethodBeat.i(95971);
        if (ax.this.zEf.isEmpty())
        {
          ae.i("MicroMsg.SnsVideoService", "download queue is null, do nothing");
          ax.b(ax.this);
          AppMethodBeat.o(95971);
          return;
        }
        be localbe1 = (be)ax.this.zEf.poll();
        if (localbe1 == null)
        {
          ae.w("MicroMsg.SnsVideoService", "try start download video task is null. queue size %d", new Object[] { Integer.valueOf(ax.this.zEf.size()) });
          ax.b(ax.this);
          AppMethodBeat.o(95971);
          return;
        }
        boolean bool1 = bool2;
        if (ax.this.zEe != null)
        {
          bool1 = bool2;
          if (localbe1.iuG.equals(ax.this.zEe.iuG)) {
            bool1 = true;
          }
        }
        Object localObject = ax.this;
        synchronized (((ax)localObject).zEi)
        {
          localObject = ((ax)localObject).zEi.iterator();
          if (((Iterator)localObject).hasNext())
          {
            f localf = (f)((Iterator)localObject).next();
            ae.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_PAUSE pause preload sns:[%s]", new Object[] { localf.dqc });
            localf.stop();
          }
        }
        ax.this.a(localbe2, bool1);
        AppMethodBeat.o(95971);
      }
    });
    AppMethodBeat.o(95983);
  }
  
  public final void dYz()
  {
    AppMethodBeat.i(95977);
    ae.d("MicroMsg.SnsVideoService", "%d stop preload %s", new Object[] { Integer.valueOf(hashCode()), bu.fpN() });
    g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95966);
        synchronized (ax.this.zEi)
        {
          if (ax.this.zEi.size() > 0) {
            ((f)ax.this.zEi.poll()).stop();
          }
        }
        AppMethodBeat.o(95966);
      }
    });
    AppMethodBeat.o(95977);
  }
  
  public final boolean s(final String paramString, final Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(95982);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(95982);
      return false;
    }
    g.ajS();
    g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95969);
        com.tencent.mm.modelvideo.o.aNi().m(paramString, paramArrayOfObject);
        if ((ax.this.zEe != null) && (bu.lX(ax.this.zEe.iuG, paramString))) {
          ax.a(ax.this);
        }
        be localbe = (be)ax.this.zEg.get(paramString);
        ax.this.zEf.remove(localbe);
        AppMethodBeat.o(95969);
      }
    });
    AppMethodBeat.o(95982);
    return true;
  }
  
  public final boolean z(p paramp)
  {
    AppMethodBeat.i(95976);
    if (paramp == null)
    {
      ae.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_ADD null snsInfo . [fail in queue]");
      AppMethodBeat.o(95976);
      return false;
    }
    this.zEj = com.tencent.mm.plugin.sns.model.b.a.dYS();
    this.zEk = com.tencent.mm.plugin.sns.model.b.a.dYR();
    synchronized (this.zEh)
    {
      if ((this.zEh.size() >= this.zEk) && (!paramp.Rt(32)))
      {
        ae.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_ADD sns:[%s] full stack .[fail in queue], and the sns info is not ad.", new Object[] { paramp.eco() });
        AppMethodBeat.o(95976);
        return false;
      }
      this.zEh.add(paramp);
      ae.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_ADD hash(%d) sns:[%s] add preload video  [success in queue]", new Object[] { Integer.valueOf(hashCode()), paramp.eco() });
      AppMethodBeat.o(95976);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ax
 * JD-Core Version:    0.7.0.1
 */