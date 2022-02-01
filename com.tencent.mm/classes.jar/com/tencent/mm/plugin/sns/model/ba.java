package com.tencent.mm.plugin.sns.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.modelvideo.j.a;
import com.tencent.mm.modelvideo.p;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.egb;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.br;
import com.tencent.mm.vfs.y;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ba
  implements j.a
{
  IListener QwY;
  public volatile bh QyD;
  LinkedList<bh> QyE;
  public Map<String, bh> QyF;
  public LinkedList<SnsInfo> QyG;
  LinkedList<com.tencent.mm.modelvideo.j> QyH;
  int QyI;
  private int QyJ;
  IListener QyK;
  IListener QyL;
  public boolean oZR;
  public boolean oZS;
  
  public ba()
  {
    AppMethodBeat.i(95974);
    this.QyE = null;
    this.QyF = null;
    this.QyG = null;
    this.QyH = new LinkedList();
    this.QyI = 3;
    this.QyJ = 6;
    this.oZR = false;
    this.oZS = false;
    this.QyK = new SnsVideoService.9(this, f.hfK);
    this.QyL = new SnsVideoService.10(this, f.hfK);
    this.QwY = new SnsVideoService.11(this, f.hfK);
    this.QyD = null;
    this.QyE = new LinkedList();
    this.QyF = new ConcurrentHashMap();
    this.QyG = new LinkedList();
    this.QyK.alive();
    this.QyL.alive();
    this.QwY.alive();
    AppMethodBeat.o(95974);
  }
  
  public final boolean I(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(95976);
    if (paramSnsInfo == null)
    {
      Log.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_ADD null snsInfo . [fail in queue]");
      AppMethodBeat.o(95976);
      return false;
    }
    this.QyI = com.tencent.mm.plugin.sns.model.b.a.hhR();
    this.QyJ = com.tencent.mm.plugin.sns.model.b.a.hhQ();
    synchronized (this.QyG)
    {
      if ((this.QyG.size() >= this.QyJ) && (!paramSnsInfo.isAd()))
      {
        Log.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_ADD sns:[%s] full stack .[fail in queue], and the sns info is not ad.", new Object[] { paramSnsInfo.getLocalid() });
        AppMethodBeat.o(95976);
        return false;
      }
      this.QyG.add(paramSnsInfo);
      Log.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_ADD hash(%d) sns:[%s] add preload video  [success in queue]", new Object[] { Integer.valueOf(hashCode()), paramSnsInfo.getLocalid() });
      AppMethodBeat.o(95976);
      return true;
    }
  }
  
  public final void J(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(176274);
    if (paramSnsInfo == null)
    {
      Log.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_ADD null snsInfo . [fail in queue]");
      AppMethodBeat.o(176274);
      return;
    }
    synchronized (this.QyH)
    {
      Object localObject = this.QyH.iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.modelvideo.j localj = (com.tencent.mm.modelvideo.j)((Iterator)localObject).next();
        if (localj.hES.equals(paramSnsInfo.getLocalid()))
        {
          localj.oZg = System.currentTimeMillis();
          Collections.sort(this.QyH, new Comparator() {});
          Log.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_ADD sns:[%s] is downloading. [already in queue]", new Object[] { paramSnsInfo.getLocalid() });
          AppMethodBeat.o(176274);
          return;
        }
      }
      if (this.QyH.size() >= this.QyI)
      {
        localObject = (com.tencent.mm.modelvideo.j)this.QyH.poll();
        if (localObject != null)
        {
          ((com.tencent.mm.modelvideo.j)localObject).stop();
          Log.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_ADD sns:[%s] cancel preload.", new Object[] { paramSnsInfo.getLocalid() });
        }
      }
      if (I(paramSnsInfo)) {
        hhy();
      }
      AppMethodBeat.o(176274);
      return;
    }
  }
  
  public final void a(com.tencent.mm.modelvideo.j paramj, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95979);
    if (paramj == null)
    {
      Log.e("MicroMsg.SnsVideoService", "%d on preload finish but scene is null?", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(95979);
      return;
    }
    for (;;)
    {
      synchronized (this.QyH)
      {
        localObject1 = this.QyH.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label235;
        }
        if (paramj != (com.tencent.mm.modelvideo.j)((Iterator)localObject1).next()) {
          continue;
        }
        localObject1 = paramj;
        if (localObject1 == null)
        {
          Log.w("MicroMsg.SnsVideoService", "%d on preload finish, but scene callback not same object.", new Object[] { Integer.valueOf(hashCode()) });
          AppMethodBeat.o(95979);
          return;
        }
      }
      ??? = az.aYH(paramj.hES);
      if (??? != null)
      {
        ((z)???).osy = paramInt2;
        ab.f((z)???);
      }
      Log.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_DONE  preload video[%s] finish success[%b] range[%d, %d]  hash:[%d]", new Object[] { paramj.bNY(), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(hashCode()) });
      com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(95968);
          com.tencent.mm.plugin.sns.model.b.a.akU(1);
          v.bOj().hq(false);
          this.QyN.oZi = null;
          synchronized (ba.this.QyH)
          {
            ba.this.QyH.remove(this.QyN);
            ba.this.hhz();
            ba.this.hhy();
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
  
  final boolean a(bh parambh, boolean paramBoolean)
  {
    AppMethodBeat.i(95984);
    Object localObject1 = az.a(parambh.hES, parambh.ibT);
    if (!Util.isNullOrNil((String)localObject1))
    {
      Log.i("MicroMsg.SnsVideoService", "this sns:[%s] video[%s] already download finish, do nothing. [%s, %s]", new Object[] { parambh.hES, parambh.oYq, parambh.hES, localObject1 });
      AppMethodBeat.o(95984);
      return false;
    }
    boolean bool = y.bDX(az.aYG(parambh.ibT.Id));
    localObject1 = az.E(parambh.ibT);
    Object localObject2 = az.aYH(parambh.hES);
    if (localObject2 == null) {
      az.ha(parambh.hES, parambh.lxk);
    }
    for (;;)
    {
      Log.i("MicroMsg.SnsVideoService", "prepare stream download sns video %s mkDir %b", new Object[] { localObject1, Boolean.valueOf(bool) });
      localObject2 = new com.tencent.mm.plugin.sns.model.a.a(parambh.ibT.Id);
      ((com.tencent.mm.plugin.sns.model.a.a)localObject2).Qsr = parambh.ibT;
      br localbr = br.jbm();
      localbr.time = parambh.createTime;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject2).QzO = localbr;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject2).QzM = true;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject2).url = parambh.ibT.Url;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject2).QzL = false;
      com.tencent.mm.modelvideo.u.bOf();
      v.bOi();
      localObject1 = com.tencent.mm.modelcdntran.j.a(((com.tencent.mm.plugin.sns.model.a.a)localObject2).QzO, ((com.tencent.mm.plugin.sns.model.a.a)localObject2).url, (String)localObject1, az.PW(parambh.hES), parambh.lxi, parambh.ibT.isAd);
      if (localObject1 != null) {
        break;
      }
      AppMethodBeat.o(95984);
      return false;
      az.c((z)localObject2, parambh.lxk);
    }
    localObject2 = parambh.QzI;
    ((com.tencent.mm.g.h)localObject1).lxj = ((String)localObject2);
    ((com.tencent.mm.g.h)localObject1).hQQ = ((String)localObject2);
    try
    {
      localObject2 = m.lX(parambh.hES, parambh.ibT.Id + "_");
      localObject2 = ap.D(al.hgB().aZL((String)localObject2));
      if (localObject2 != null)
      {
        ((com.tencent.mm.g.h)localObject1).hQX = ((SnsObject)localObject2).Id;
        ((com.tencent.mm.g.h)localObject1).lxn = ((SnsObject)localObject2).PreDownloadInfo.ablw;
      }
    }
    catch (Exception localException)
    {
      label394:
      break label394;
    }
    this.QyD = parambh;
    this.QyD.oYq = ((com.tencent.mm.g.h)localObject1).field_mediaId;
    Log.i("MicroMsg.SnsVideoService", "start stream download sns video cdnMediaId %s delay %b", new Object[] { this.QyD.oYq, Boolean.valueOf(paramBoolean) });
    v.bOi().a((com.tencent.mm.g.h)localObject1, paramBoolean);
    AppMethodBeat.o(95984);
    return true;
  }
  
  public final boolean a(dmz paramdmz, int paramInt1, String paramString, boolean paramBoolean1, final boolean paramBoolean2, int paramInt2)
  {
    AppMethodBeat.i(95981);
    if (paramdmz.aazR == 2)
    {
      Log.w("MicroMsg.SnsVideoService", "add video task, but url is weixin, do nothing");
      AppMethodBeat.o(95981);
      return false;
    }
    boolean bool = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yWg, true);
    final bh localbh = this.QyD;
    if ((bool) && (localbh != null) && (!TextUtils.isEmpty(localbh.hES)) && (localbh.hES.equals(paramString)))
    {
      Log.e("MicroMsg.SnsVideoService", "[%s]task is downloading now.", new Object[] { paramString });
      AppMethodBeat.o(95981);
      return true;
    }
    localbh = new bh();
    localbh.oYq = az.de(paramInt1, paramdmz.Url);
    localbh.ibT = paramdmz;
    localbh.createTime = paramInt1;
    localbh.hES = paramString;
    if (paramBoolean1) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      localbh.lxi = paramInt1;
      localbh.lxk = paramInt2;
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(95970);
          for (;;)
          {
            try
            {
              localObject = m.lX(localbh.hES, localbh.ibT.Id + "_");
              localObject = al.hgB().aZL((String)localObject);
              bh localbh = localbh;
              if (localObject == null) {
                continue;
              }
              localObject = ((SnsInfo)localObject).getUserName();
              localbh.QzI = ((String)localObject);
            }
            catch (Exception localException)
            {
              Object localObject;
              Log.e("MicroMsg.SnsVideoService", localException.toString());
              continue;
              ba.this.QyE.offerLast(localbh);
              continue;
            }
            Log.i("MicroMsg.SnsVideoService", "offer [%b] video task[%s] to queue ", new Object[] { Boolean.valueOf(paramBoolean2), localbh });
            if (!paramBoolean2) {
              continue;
            }
            ba.this.QyE.offerFirst(localbh);
            ba.this.QyF.put(localbh.oYq, localbh);
            AppMethodBeat.o(95970);
            return;
            localObject = "";
          }
        }
      });
      if (paramBoolean2) {
        hhA();
      }
      AppMethodBeat.o(95981);
      return true;
    }
  }
  
  public final void eGB()
  {
    AppMethodBeat.i(95977);
    Log.d("MicroMsg.SnsVideoService", "%d stop preload %s", new Object[] { Integer.valueOf(hashCode()), Util.getStack() });
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95966);
        synchronized (ba.this.QyH)
        {
          if (ba.this.QyH.size() > 0) {
            ((com.tencent.mm.modelvideo.j)ba.this.QyH.poll()).stop();
          }
        }
        AppMethodBeat.o(95966);
      }
    });
    AppMethodBeat.o(95977);
  }
  
  final void hhA()
  {
    AppMethodBeat.i(95983);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        boolean bool2 = false;
        AppMethodBeat.i(95971);
        if (ba.this.QyE.isEmpty())
        {
          Log.i("MicroMsg.SnsVideoService", "download queue is null, do nothing");
          ba.b(ba.this);
          AppMethodBeat.o(95971);
          return;
        }
        bh localbh1 = (bh)ba.this.QyE.poll();
        if (localbh1 == null)
        {
          Log.w("MicroMsg.SnsVideoService", "try start download video task is null. queue size %d", new Object[] { Integer.valueOf(ba.this.QyE.size()) });
          ba.b(ba.this);
          AppMethodBeat.o(95971);
          return;
        }
        boolean bool1 = bool2;
        if (ba.this.QyD != null)
        {
          bool1 = bool2;
          if (localbh1.oYq.equals(ba.this.QyD.oYq)) {
            bool1 = true;
          }
        }
        Object localObject = ba.this;
        synchronized (((ba)localObject).QyH)
        {
          localObject = ((ba)localObject).QyH.iterator();
          if (((Iterator)localObject).hasNext())
          {
            com.tencent.mm.modelvideo.j localj = (com.tencent.mm.modelvideo.j)((Iterator)localObject).next();
            Log.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_PAUSE pause preload sns:[%s]", new Object[] { localj.hES });
            localj.stop();
          }
        }
        ba.this.a(localbh2, bool1);
        AppMethodBeat.o(95971);
      }
    });
    AppMethodBeat.o(95983);
  }
  
  final void hhy()
  {
    try
    {
      AppMethodBeat.i(95978);
      Log.i("MicroMsg.SnsVideoService", "SNS_PRELOAD_LOAD preload size:%d  queue size:%d", new Object[] { Integer.valueOf(this.QyH.size()), Integer.valueOf(this.QyG.size()) });
      com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
      {
        /* Error */
        public final void run()
        {
          // Byte code:
          //   0: ldc 24
          //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   5: aload_0
          //   6: getfield 17	com/tencent/mm/plugin/sns/model/ba$3:QyM	Lcom/tencent/mm/plugin/sns/model/ba;
          //   9: getfield 34	com/tencent/mm/plugin/sns/model/ba:QyD	Lcom/tencent/mm/plugin/sns/model/bh;
          //   12: ifnull +9 -> 21
          //   15: ldc 24
          //   17: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   20: return
          //   21: aload_0
          //   22: getfield 17	com/tencent/mm/plugin/sns/model/ba$3:QyM	Lcom/tencent/mm/plugin/sns/model/ba;
          //   25: getfield 41	com/tencent/mm/plugin/sns/model/ba:QyE	Ljava/util/LinkedList;
          //   28: invokevirtual 47	java/util/LinkedList:isEmpty	()Z
          //   31: ifne +9 -> 40
          //   34: ldc 24
          //   36: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   39: return
          //   40: aload_0
          //   41: getfield 17	com/tencent/mm/plugin/sns/model/ba$3:QyM	Lcom/tencent/mm/plugin/sns/model/ba;
          //   44: getfield 50	com/tencent/mm/plugin/sns/model/ba:QyH	Ljava/util/LinkedList;
          //   47: astore 6
          //   49: aload 6
          //   51: monitorenter
          //   52: aload_0
          //   53: getfield 17	com/tencent/mm/plugin/sns/model/ba$3:QyM	Lcom/tencent/mm/plugin/sns/model/ba;
          //   56: getfield 50	com/tencent/mm/plugin/sns/model/ba:QyH	Ljava/util/LinkedList;
          //   59: invokevirtual 54	java/util/LinkedList:size	()I
          //   62: aload_0
          //   63: getfield 17	com/tencent/mm/plugin/sns/model/ba$3:QyM	Lcom/tencent/mm/plugin/sns/model/ba;
          //   66: getfield 58	com/tencent/mm/plugin/sns/model/ba:QyI	I
          //   69: if_icmplt +19 -> 88
          //   72: ldc 60
          //   74: ldc 62
          //   76: invokestatic 67	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   79: aload 6
          //   81: monitorexit
          //   82: ldc 24
          //   84: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   87: return
          //   88: aload 6
          //   90: monitorexit
          //   91: aload_0
          //   92: getfield 17	com/tencent/mm/plugin/sns/model/ba$3:QyM	Lcom/tencent/mm/plugin/sns/model/ba;
          //   95: getfield 71	com/tencent/mm/plugin/sns/model/ba:oZR	Z
          //   98: ifne +19 -> 117
          //   101: aload_0
          //   102: getfield 17	com/tencent/mm/plugin/sns/model/ba$3:QyM	Lcom/tencent/mm/plugin/sns/model/ba;
          //   105: getfield 74	com/tencent/mm/plugin/sns/model/ba:oZS	Z
          //   108: ifeq +1777 -> 1885
          //   111: invokestatic 79	com/tencent/mm/plugin/sns/model/b/a:hhP	()Z
          //   114: ifne +1771 -> 1885
          //   117: ldc 60
          //   119: ldc 81
          //   121: iconst_2
          //   122: anewarray 4	java/lang/Object
          //   125: dup
          //   126: iconst_0
          //   127: aload_0
          //   128: getfield 17	com/tencent/mm/plugin/sns/model/ba$3:QyM	Lcom/tencent/mm/plugin/sns/model/ba;
          //   131: getfield 71	com/tencent/mm/plugin/sns/model/ba:oZR	Z
          //   134: invokestatic 87	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
          //   137: aastore
          //   138: dup
          //   139: iconst_1
          //   140: invokestatic 79	com/tencent/mm/plugin/sns/model/b/a:hhP	()Z
          //   143: invokestatic 87	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
          //   146: aastore
          //   147: invokestatic 90	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   150: iconst_1
          //   151: istore_2
          //   152: aconst_null
          //   153: astore 6
          //   155: aconst_null
          //   156: astore 8
          //   158: new 92	com/tencent/mm/pointers/PBool
          //   161: dup
          //   162: invokespecial 93	com/tencent/mm/pointers/PBool:<init>	()V
          //   165: astore 13
          //   167: new 95	com/tencent/mm/pointers/PInt
          //   170: dup
          //   171: invokespecial 96	com/tencent/mm/pointers/PInt:<init>	()V
          //   174: astore 11
          //   176: new 98	com/tencent/mm/pointers/PString
          //   179: dup
          //   180: invokespecial 99	com/tencent/mm/pointers/PString:<init>	()V
          //   183: astore 14
          //   185: aload_0
          //   186: getfield 17	com/tencent/mm/plugin/sns/model/ba$3:QyM	Lcom/tencent/mm/plugin/sns/model/ba;
          //   189: getfield 102	com/tencent/mm/plugin/sns/model/ba:QyG	Ljava/util/LinkedList;
          //   192: astore 12
          //   194: aload 12
          //   196: monitorenter
          //   197: aload_0
          //   198: getfield 17	com/tencent/mm/plugin/sns/model/ba$3:QyM	Lcom/tencent/mm/plugin/sns/model/ba;
          //   201: getfield 102	com/tencent/mm/plugin/sns/model/ba:QyG	Ljava/util/LinkedList;
          //   204: invokevirtual 106	java/util/LinkedList:iterator	()Ljava/util/Iterator;
          //   207: astore 15
          //   209: ldc 108
          //   211: astore 7
          //   213: aload 8
          //   215: astore 10
          //   217: aload 15
          //   219: invokeinterface 113 1 0
          //   224: ifeq +1303 -> 1527
          //   227: aload 15
          //   229: invokeinterface 117 1 0
          //   234: checkcast 119	com/tencent/mm/plugin/sns/storage/SnsInfo
          //   237: astore 9
          //   239: aload 9
          //   241: invokevirtual 123	com/tencent/mm/plugin/sns/storage/SnsInfo:getLocalid	()Ljava/lang/String;
          //   244: astore 7
          //   246: aload 9
          //   248: invokevirtual 126	com/tencent/mm/plugin/sns/storage/SnsInfo:isAd	()Z
          //   251: ifne +33 -> 284
          //   254: iload_2
          //   255: ifeq +29 -> 284
          //   258: aconst_null
          //   259: astore 6
          //   261: ldc 60
          //   263: ldc 128
          //   265: invokestatic 67	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   268: goto -55 -> 213
          //   271: astore 7
          //   273: aload 6
          //   275: monitorexit
          //   276: ldc 24
          //   278: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   281: aload 7
          //   283: athrow
          //   284: aload_0
          //   285: getfield 17	com/tencent/mm/plugin/sns/model/ba$3:QyM	Lcom/tencent/mm/plugin/sns/model/ba;
          //   288: getfield 74	com/tencent/mm/plugin/sns/model/ba:oZS	Z
          //   291: ifeq +285 -> 576
          //   294: aload_0
          //   295: getfield 17	com/tencent/mm/plugin/sns/model/ba$3:QyM	Lcom/tencent/mm/plugin/sns/model/ba;
          //   298: astore 6
          //   300: aload 9
          //   302: ifnonnull +102 -> 404
          //   305: aload 13
          //   307: iconst_1
          //   308: putfield 131	com/tencent/mm/pointers/PBool:value	Z
          //   311: iconst_0
          //   312: istore_1
          //   313: aload 13
          //   315: getfield 131	com/tencent/mm/pointers/PBool:value	Z
          //   318: ifeq +10 -> 328
          //   321: aload 15
          //   323: invokeinterface 134 1 0
          //   328: iload_1
          //   329: ifeq +1572 -> 1901
          //   332: aload_0
          //   333: getfield 17	com/tencent/mm/plugin/sns/model/ba$3:QyM	Lcom/tencent/mm/plugin/sns/model/ba;
          //   336: astore 17
          //   338: aload 14
          //   340: getfield 137	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
          //   343: astore 8
          //   345: aload 9
          //   347: ifnull +1543 -> 1890
          //   350: aload 9
          //   352: invokevirtual 141	com/tencent/mm/plugin/sns/storage/SnsInfo:getTimeLine	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
          //   355: getfield 147	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
          //   358: ifnull +1532 -> 1890
          //   361: aload 9
          //   363: invokevirtual 141	com/tencent/mm/plugin/sns/storage/SnsInfo:getTimeLine	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
          //   366: getfield 147	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
          //   369: getfield 152	com/tencent/mm/protocal/protobuf/agh:Zpr	Ljava/util/LinkedList;
          //   372: invokestatic 158	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/util/List;)Z
          //   375: ifeq +594 -> 969
          //   378: goto +1512 -> 1890
          //   381: aload 6
          //   383: ifnonnull +1524 -> 1907
          //   386: aload 15
          //   388: invokeinterface 134 1 0
          //   393: aload 6
          //   395: astore 8
          //   397: aload 9
          //   399: astore 6
          //   401: goto -188 -> 213
          //   404: aload 9
          //   406: invokevirtual 126	com/tencent/mm/plugin/sns/storage/SnsInfo:isAd	()Z
          //   409: ifne +156 -> 565
          //   412: invokestatic 164	com/tencent/mm/modelvideo/v:bOj	()Lcom/tencent/mm/modelvideo/p;
          //   415: iconst_0
          //   416: invokevirtual 170	com/tencent/mm/modelvideo/p:hr	(Z)Z
          //   419: ifeq +14 -> 433
          //   422: aload 13
          //   424: iconst_1
          //   425: putfield 131	com/tencent/mm/pointers/PBool:value	Z
          //   428: iconst_0
          //   429: istore_1
          //   430: goto -117 -> 313
          //   433: aload 9
          //   435: invokestatic 176	com/tencent/mm/plugin/sns/model/ap:D	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)Lcom/tencent/mm/protocal/protobuf/SnsObject;
          //   438: astore 10
          //   440: aload 10
          //   442: ifnull +11 -> 453
          //   445: aload 10
          //   447: getfield 182	com/tencent/mm/protocal/protobuf/SnsObject:PreDownloadInfo	Lcom/tencent/mm/protocal/protobuf/egb;
          //   450: ifnonnull +21 -> 471
          //   453: ldc 60
          //   455: ldc 184
          //   457: invokestatic 67	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   460: aload 13
          //   462: iconst_1
          //   463: putfield 131	com/tencent/mm/pointers/PBool:value	Z
          //   466: iconst_0
          //   467: istore_1
          //   468: goto -155 -> 313
          //   471: invokestatic 187	com/tencent/mm/plugin/sns/model/b/a:hhS	()I
          //   474: istore_1
          //   475: iload_1
          //   476: ifgt +36 -> 512
          //   479: ldc 60
          //   481: ldc 189
          //   483: iconst_1
          //   484: anewarray 4	java/lang/Object
          //   487: dup
          //   488: iconst_0
          //   489: aload 6
          //   491: invokevirtual 192	java/lang/Object:hashCode	()I
          //   494: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   497: aastore
          //   498: invokestatic 90	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   501: aload 13
          //   503: iconst_1
          //   504: putfield 131	com/tencent/mm/pointers/PBool:value	Z
          //   507: iconst_0
          //   508: istore_1
          //   509: goto -196 -> 313
          //   512: aload 14
          //   514: new 199	java/lang/StringBuilder
          //   517: dup
          //   518: invokespecial 200	java/lang/StringBuilder:<init>	()V
          //   521: aload 10
          //   523: getfield 204	com/tencent/mm/protocal/protobuf/SnsObject:Id	J
          //   526: invokevirtual 208	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
          //   529: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   532: putfield 137	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
          //   535: aload 11
          //   537: iload_1
          //   538: putfield 213	com/tencent/mm/pointers/PInt:value	I
          //   541: invokestatic 79	com/tencent/mm/plugin/sns/model/b/a:hhP	()Z
          //   544: ifne +21 -> 565
          //   547: ldc 60
          //   549: ldc 215
          //   551: invokestatic 67	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   554: aload 13
          //   556: iconst_1
          //   557: putfield 131	com/tencent/mm/pointers/PBool:value	Z
          //   560: iconst_0
          //   561: istore_1
          //   562: goto -249 -> 313
          //   565: aload 13
          //   567: iconst_0
          //   568: putfield 131	com/tencent/mm/pointers/PBool:value	Z
          //   571: iconst_1
          //   572: istore_1
          //   573: goto -260 -> 313
          //   576: aload_0
          //   577: getfield 17	com/tencent/mm/plugin/sns/model/ba$3:QyM	Lcom/tencent/mm/plugin/sns/model/ba;
          //   580: astore 6
          //   582: aload 9
          //   584: ifnonnull +14 -> 598
          //   587: aload 13
          //   589: iconst_1
          //   590: putfield 131	com/tencent/mm/pointers/PBool:value	Z
          //   593: iconst_0
          //   594: istore_1
          //   595: goto -282 -> 313
          //   598: aload 9
          //   600: invokevirtual 126	com/tencent/mm/plugin/sns/storage/SnsInfo:isAd	()Z
          //   603: ifeq +14 -> 617
          //   606: aload 13
          //   608: iconst_0
          //   609: putfield 131	com/tencent/mm/pointers/PBool:value	Z
          //   612: iconst_1
          //   613: istore_1
          //   614: goto -301 -> 313
          //   617: aload 9
          //   619: invokevirtual 218	com/tencent/mm/plugin/sns/storage/SnsInfo:getCreateTime	()I
          //   622: i2l
          //   623: invokestatic 222	com/tencent/mm/sdk/platformtools/Util:secondsToNow	(J)J
          //   626: ldc2_w 223
          //   629: lcmp
          //   630: iflt +14 -> 644
          //   633: aload 13
          //   635: iconst_1
          //   636: putfield 131	com/tencent/mm/pointers/PBool:value	Z
          //   639: iconst_0
          //   640: istore_1
          //   641: goto -328 -> 313
          //   644: invokestatic 164	com/tencent/mm/modelvideo/v:bOj	()Lcom/tencent/mm/modelvideo/p;
          //   647: iconst_0
          //   648: invokevirtual 170	com/tencent/mm/modelvideo/p:hr	(Z)Z
          //   651: ifeq +14 -> 665
          //   654: aload 13
          //   656: iconst_1
          //   657: putfield 131	com/tencent/mm/pointers/PBool:value	Z
          //   660: iconst_0
          //   661: istore_1
          //   662: goto -349 -> 313
          //   665: aload 9
          //   667: invokestatic 176	com/tencent/mm/plugin/sns/model/ap:D	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)Lcom/tencent/mm/protocal/protobuf/SnsObject;
          //   670: astore 10
          //   672: aload 10
          //   674: ifnull +11 -> 685
          //   677: aload 10
          //   679: getfield 182	com/tencent/mm/protocal/protobuf/SnsObject:PreDownloadInfo	Lcom/tencent/mm/protocal/protobuf/egb;
          //   682: ifnonnull +21 -> 703
          //   685: ldc 60
          //   687: ldc 184
          //   689: invokestatic 67	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   692: aload 13
          //   694: iconst_1
          //   695: putfield 131	com/tencent/mm/pointers/PBool:value	Z
          //   698: iconst_0
          //   699: istore_1
          //   700: goto -387 -> 313
          //   703: ldc 60
          //   705: ldc 226
          //   707: iconst_5
          //   708: anewarray 4	java/lang/Object
          //   711: dup
          //   712: iconst_0
          //   713: aload 6
          //   715: invokevirtual 192	java/lang/Object:hashCode	()I
          //   718: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   721: aastore
          //   722: dup
          //   723: iconst_1
          //   724: aload 9
          //   726: invokevirtual 123	com/tencent/mm/plugin/sns/storage/SnsInfo:getLocalid	()Ljava/lang/String;
          //   729: aastore
          //   730: dup
          //   731: iconst_2
          //   732: aload 10
          //   734: getfield 182	com/tencent/mm/protocal/protobuf/SnsObject:PreDownloadInfo	Lcom/tencent/mm/protocal/protobuf/egb;
          //   737: getfield 231	com/tencent/mm/protocal/protobuf/egb:ablw	I
          //   740: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   743: aastore
          //   744: dup
          //   745: iconst_3
          //   746: aload 10
          //   748: getfield 182	com/tencent/mm/protocal/protobuf/SnsObject:PreDownloadInfo	Lcom/tencent/mm/protocal/protobuf/egb;
          //   751: getfield 234	com/tencent/mm/protocal/protobuf/egb:ablx	I
          //   754: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   757: aastore
          //   758: dup
          //   759: iconst_4
          //   760: aload 10
          //   762: getfield 182	com/tencent/mm/protocal/protobuf/SnsObject:PreDownloadInfo	Lcom/tencent/mm/protocal/protobuf/egb;
          //   765: getfield 237	com/tencent/mm/protocal/protobuf/egb:ably	Ljava/lang/String;
          //   768: aastore
          //   769: invokestatic 90	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   772: aload 10
          //   774: getfield 182	com/tencent/mm/protocal/protobuf/SnsObject:PreDownloadInfo	Lcom/tencent/mm/protocal/protobuf/egb;
          //   777: getfield 231	com/tencent/mm/protocal/protobuf/egb:ablw	I
          //   780: ifgt +36 -> 816
          //   783: ldc 60
          //   785: ldc 189
          //   787: iconst_1
          //   788: anewarray 4	java/lang/Object
          //   791: dup
          //   792: iconst_0
          //   793: aload 6
          //   795: invokevirtual 192	java/lang/Object:hashCode	()I
          //   798: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   801: aastore
          //   802: invokestatic 90	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   805: aload 13
          //   807: iconst_1
          //   808: putfield 131	com/tencent/mm/pointers/PBool:value	Z
          //   811: iconst_0
          //   812: istore_1
          //   813: goto -500 -> 313
          //   816: aload 14
          //   818: new 199	java/lang/StringBuilder
          //   821: dup
          //   822: invokespecial 200	java/lang/StringBuilder:<init>	()V
          //   825: aload 10
          //   827: getfield 204	com/tencent/mm/protocal/protobuf/SnsObject:Id	J
          //   830: invokevirtual 208	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
          //   833: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   836: putfield 137	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
          //   839: aload 11
          //   841: aload 10
          //   843: getfield 182	com/tencent/mm/protocal/protobuf/SnsObject:PreDownloadInfo	Lcom/tencent/mm/protocal/protobuf/egb;
          //   846: getfield 231	com/tencent/mm/protocal/protobuf/egb:ablw	I
          //   849: putfield 213	com/tencent/mm/pointers/PInt:value	I
          //   852: aload 10
          //   854: getfield 182	com/tencent/mm/protocal/protobuf/SnsObject:PreDownloadInfo	Lcom/tencent/mm/protocal/protobuf/egb;
          //   857: getfield 237	com/tencent/mm/protocal/protobuf/egb:ably	Ljava/lang/String;
          //   860: invokestatic 243	com/tencent/mm/modelcontrol/b:NB	(Ljava/lang/String;)Z
          //   863: ifne +95 -> 958
          //   866: invokestatic 249	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
          //   869: invokestatic 255	com/tencent/mm/sdk/platformtools/NetStatusUtil:isWifi	(Landroid/content/Context;)Z
          //   872: ifeq +29 -> 901
          //   875: aload 10
          //   877: getfield 182	com/tencent/mm/protocal/protobuf/SnsObject:PreDownloadInfo	Lcom/tencent/mm/protocal/protobuf/egb;
          //   880: getfield 234	com/tencent/mm/protocal/protobuf/egb:ablx	I
          //   883: iconst_1
          //   884: iand
          //   885: istore_1
          //   886: iload_1
          //   887: ifle +71 -> 958
          //   890: aload 13
          //   892: iconst_0
          //   893: putfield 131	com/tencent/mm/pointers/PBool:value	Z
          //   896: iconst_1
          //   897: istore_1
          //   898: goto -585 -> 313
          //   901: invokestatic 249	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
          //   904: invokestatic 258	com/tencent/mm/sdk/platformtools/NetStatusUtil:is4G	(Landroid/content/Context;)Z
          //   907: ifeq +17 -> 924
          //   910: aload 10
          //   912: getfield 182	com/tencent/mm/protocal/protobuf/SnsObject:PreDownloadInfo	Lcom/tencent/mm/protocal/protobuf/egb;
          //   915: getfield 234	com/tencent/mm/protocal/protobuf/egb:ablx	I
          //   918: iconst_2
          //   919: iand
          //   920: istore_1
          //   921: goto -35 -> 886
          //   924: invokestatic 249	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
          //   927: invokestatic 261	com/tencent/mm/sdk/platformtools/NetStatusUtil:is3G	(Landroid/content/Context;)Z
          //   930: ifeq +17 -> 947
          //   933: aload 10
          //   935: getfield 182	com/tencent/mm/protocal/protobuf/SnsObject:PreDownloadInfo	Lcom/tencent/mm/protocal/protobuf/egb;
          //   938: getfield 234	com/tencent/mm/protocal/protobuf/egb:ablx	I
          //   941: iconst_4
          //   942: iand
          //   943: istore_1
          //   944: goto -58 -> 886
          //   947: aload 13
          //   949: iconst_0
          //   950: putfield 131	com/tencent/mm/pointers/PBool:value	Z
          //   953: iconst_0
          //   954: istore_1
          //   955: goto -642 -> 313
          //   958: aload 13
          //   960: iconst_0
          //   961: putfield 131	com/tencent/mm/pointers/PBool:value	Z
          //   964: iconst_0
          //   965: istore_1
          //   966: goto -653 -> 313
          //   969: aload 9
          //   971: invokevirtual 141	com/tencent/mm/plugin/sns/storage/SnsInfo:getTimeLine	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
          //   974: getfield 147	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
          //   977: getfield 152	com/tencent/mm/protocal/protobuf/agh:Zpr	Ljava/util/LinkedList;
          //   980: iconst_0
          //   981: invokevirtual 265	java/util/LinkedList:get	(I)Ljava/lang/Object;
          //   984: checkcast 267	com/tencent/mm/protocal/protobuf/dmz
          //   987: astore 10
          //   989: aload 9
          //   991: invokevirtual 123	com/tencent/mm/plugin/sns/storage/SnsInfo:getLocalid	()Ljava/lang/String;
          //   994: astore 6
          //   996: aload 6
          //   998: aload 10
          //   1000: invokestatic 273	com/tencent/mm/plugin/sns/model/az:a	(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/dmz;)Ljava/lang/String;
          //   1003: astore 16
          //   1005: aload 16
          //   1007: invokestatic 275	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
          //   1010: ifne +98 -> 1108
          //   1013: ldc 60
          //   1015: ldc_w 277
          //   1018: iconst_2
          //   1019: anewarray 4	java/lang/Object
          //   1022: dup
          //   1023: iconst_0
          //   1024: aload 9
          //   1026: invokevirtual 123	com/tencent/mm/plugin/sns/storage/SnsInfo:getLocalid	()Ljava/lang/String;
          //   1029: aastore
          //   1030: dup
          //   1031: iconst_1
          //   1032: aload 16
          //   1034: aastore
          //   1035: invokestatic 90	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   1038: aload 10
          //   1040: getfield 280	com/tencent/mm/protocal/protobuf/dmz:aaTE	Ljava/lang/String;
          //   1043: astore 6
          //   1045: aload 16
          //   1047: invokestatic 286	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
          //   1050: lstore_3
          //   1051: aload 17
          //   1053: getfield 74	com/tencent/mm/plugin/sns/model/ba:oZS	Z
          //   1056: ifeq +840 -> 1896
          //   1059: iconst_4
          //   1060: istore_1
          //   1061: invokestatic 164	com/tencent/mm/modelvideo/v:bOj	()Lcom/tencent/mm/modelvideo/p;
          //   1064: aload 6
          //   1066: iload_1
          //   1067: lload_3
          //   1068: aload 9
          //   1070: invokevirtual 289	com/tencent/mm/plugin/sns/storage/SnsInfo:getUserName	()Ljava/lang/String;
          //   1073: ldc 108
          //   1075: iconst_0
          //   1076: ldc 108
          //   1078: aload 10
          //   1080: getfield 292	com/tencent/mm/protocal/protobuf/dmz:Url	Ljava/lang/String;
          //   1083: aload 8
          //   1085: invokevirtual 295	com/tencent/mm/modelvideo/p:a	(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
          //   1088: getstatic 301	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
          //   1091: ldc2_w 302
          //   1094: ldc2_w 304
          //   1097: lconst_1
          //   1098: iconst_0
          //   1099: invokevirtual 309	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
          //   1102: aconst_null
          //   1103: astore 6
          //   1105: goto -724 -> 381
          //   1108: aload 10
          //   1110: getfield 311	com/tencent/mm/protocal/protobuf/dmz:Id	Ljava/lang/String;
          //   1113: invokestatic 315	com/tencent/mm/plugin/sns/model/az:aYG	(Ljava/lang/String;)Ljava/lang/String;
          //   1116: invokestatic 318	com/tencent/mm/vfs/y:bDX	(Ljava/lang/String;)Z
          //   1119: istore 5
          //   1121: aload 10
          //   1123: invokestatic 322	com/tencent/mm/plugin/sns/model/az:E	(Lcom/tencent/mm/protocal/protobuf/dmz;)Ljava/lang/String;
          //   1126: astore 17
          //   1128: aload 6
          //   1130: invokestatic 326	com/tencent/mm/plugin/sns/model/az:aYH	(Ljava/lang/String;)Lcom/tencent/mm/modelvideo/z;
          //   1133: astore 18
          //   1135: aload 9
          //   1137: invokevirtual 126	com/tencent/mm/plugin/sns/storage/SnsInfo:isAd	()Z
          //   1140: ifeq +140 -> 1280
          //   1143: bipush 100
          //   1145: istore_1
          //   1146: aload 11
          //   1148: iload_1
          //   1149: putfield 213	com/tencent/mm/pointers/PInt:value	I
          //   1152: ldc 60
          //   1154: ldc_w 328
          //   1157: iconst_3
          //   1158: anewarray 4	java/lang/Object
          //   1161: dup
          //   1162: iconst_0
          //   1163: aload 9
          //   1165: invokevirtual 123	com/tencent/mm/plugin/sns/storage/SnsInfo:getLocalid	()Ljava/lang/String;
          //   1168: aastore
          //   1169: dup
          //   1170: iconst_1
          //   1171: aload 10
          //   1173: getfield 332	com/tencent/mm/protocal/protobuf/dmz:aaTF	F
          //   1176: invokestatic 337	java/lang/Float:valueOf	(F)Ljava/lang/Float;
          //   1179: aastore
          //   1180: dup
          //   1181: iconst_2
          //   1182: aload 11
          //   1184: getfield 213	com/tencent/mm/pointers/PInt:value	I
          //   1187: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1190: aastore
          //   1191: invokestatic 90	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   1194: aload 18
          //   1196: ifnull +98 -> 1294
          //   1199: ldc 60
          //   1201: ldc_w 339
          //   1204: iconst_1
          //   1205: anewarray 4	java/lang/Object
          //   1208: dup
          //   1209: iconst_0
          //   1210: aload 18
          //   1212: invokevirtual 342	com/tencent/mm/modelvideo/z:toString	()Ljava/lang/String;
          //   1215: aastore
          //   1216: invokestatic 90	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   1219: aload 18
          //   1221: getfield 345	com/tencent/mm/modelvideo/z:osy	I
          //   1224: ifle +70 -> 1294
          //   1227: aload 18
          //   1229: getfield 348	com/tencent/mm/modelvideo/z:hQV	I
          //   1232: bipush 100
          //   1234: imul
          //   1235: aload 18
          //   1237: getfield 345	com/tencent/mm/modelvideo/z:osy	I
          //   1240: idiv
          //   1241: aload 11
          //   1243: getfield 213	com/tencent/mm/pointers/PInt:value	I
          //   1246: if_icmplt +48 -> 1294
          //   1249: ldc 60
          //   1251: ldc_w 350
          //   1254: iconst_2
          //   1255: anewarray 4	java/lang/Object
          //   1258: dup
          //   1259: iconst_0
          //   1260: aload 9
          //   1262: invokevirtual 123	com/tencent/mm/plugin/sns/storage/SnsInfo:getLocalid	()Ljava/lang/String;
          //   1265: aastore
          //   1266: dup
          //   1267: iconst_1
          //   1268: aload 16
          //   1270: aastore
          //   1271: invokestatic 90	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   1274: aconst_null
          //   1275: astore 6
          //   1277: goto -896 -> 381
          //   1280: aload 10
          //   1282: aload 11
          //   1284: getfield 213	com/tencent/mm/pointers/PInt:value	I
          //   1287: invokestatic 353	com/tencent/mm/plugin/sns/model/b/a:a	(Lcom/tencent/mm/protocal/protobuf/dmz;I)I
          //   1290: istore_1
          //   1291: goto -145 -> 1146
          //   1294: aload 18
          //   1296: ifnonnull +156 -> 1452
          //   1299: aload 6
          //   1301: bipush 30
          //   1303: invokestatic 357	com/tencent/mm/plugin/sns/model/az:ha	(Ljava/lang/String;I)Z
          //   1306: pop
          //   1307: ldc 60
          //   1309: ldc_w 359
          //   1312: iconst_3
          //   1313: anewarray 4	java/lang/Object
          //   1316: dup
          //   1317: iconst_0
          //   1318: aload 9
          //   1320: invokevirtual 123	com/tencent/mm/plugin/sns/storage/SnsInfo:getLocalid	()Ljava/lang/String;
          //   1323: aastore
          //   1324: dup
          //   1325: iconst_1
          //   1326: aload 17
          //   1328: aastore
          //   1329: dup
          //   1330: iconst_2
          //   1331: iload 5
          //   1333: invokestatic 87	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
          //   1336: aastore
          //   1337: invokestatic 90	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   1340: new 361	com/tencent/mm/plugin/sns/model/a/a
          //   1343: dup
          //   1344: aload 10
          //   1346: getfield 311	com/tencent/mm/protocal/protobuf/dmz:Id	Ljava/lang/String;
          //   1349: invokespecial 364	com/tencent/mm/plugin/sns/model/a/a:<init>	(Ljava/lang/String;)V
          //   1352: astore 16
          //   1354: aload 16
          //   1356: aload 10
          //   1358: putfield 368	com/tencent/mm/plugin/sns/model/a/a:Qsr	Lcom/tencent/mm/protocal/protobuf/dmz;
          //   1361: invokestatic 374	com/tencent/mm/storage/br:jbm	()Lcom/tencent/mm/storage/br;
          //   1364: astore 18
          //   1366: aload 18
          //   1368: aload 9
          //   1370: invokevirtual 218	com/tencent/mm/plugin/sns/storage/SnsInfo:getCreateTime	()I
          //   1373: putfield 377	com/tencent/mm/storage/br:time	I
          //   1376: aload 16
          //   1378: aload 18
          //   1380: putfield 381	com/tencent/mm/plugin/sns/model/a/a:QzO	Lcom/tencent/mm/storage/br;
          //   1383: aload 16
          //   1385: iconst_1
          //   1386: putfield 384	com/tencent/mm/plugin/sns/model/a/a:QzM	Z
          //   1389: aload 16
          //   1391: aload 10
          //   1393: getfield 292	com/tencent/mm/protocal/protobuf/dmz:Url	Ljava/lang/String;
          //   1396: putfield 387	com/tencent/mm/plugin/sns/model/a/a:url	Ljava/lang/String;
          //   1399: aload 16
          //   1401: iconst_0
          //   1402: putfield 390	com/tencent/mm/plugin/sns/model/a/a:QzL	Z
          //   1405: invokestatic 396	com/tencent/mm/modelvideo/u:bOf	()Lcom/tencent/mm/modelvideo/u;
          //   1408: pop
          //   1409: invokestatic 400	com/tencent/mm/modelvideo/v:bOi	()Lcom/tencent/mm/modelcdntran/j;
          //   1412: pop
          //   1413: aload 16
          //   1415: getfield 381	com/tencent/mm/plugin/sns/model/a/a:QzO	Lcom/tencent/mm/storage/br;
          //   1418: aload 16
          //   1420: getfield 387	com/tencent/mm/plugin/sns/model/a/a:url	Ljava/lang/String;
          //   1423: aload 17
          //   1425: aload 6
          //   1427: invokestatic 403	com/tencent/mm/plugin/sns/model/az:PW	(Ljava/lang/String;)Ljava/lang/String;
          //   1430: iconst_2
          //   1431: aload 10
          //   1433: getfield 405	com/tencent/mm/protocal/protobuf/dmz:isAd	Z
          //   1436: invokestatic 410	com/tencent/mm/modelcdntran/j:a	(Lcom/tencent/mm/storage/br;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)Lcom/tencent/mm/g/h;
          //   1439: astore 6
          //   1441: aload 6
          //   1443: ifnonnull +33 -> 1476
          //   1446: aconst_null
          //   1447: astore 6
          //   1449: goto -1068 -> 381
          //   1452: aload 18
          //   1454: bipush 30
          //   1456: invokestatic 414	com/tencent/mm/plugin/sns/model/az:c	(Lcom/tencent/mm/modelvideo/z;I)Z
          //   1459: pop
          //   1460: goto -153 -> 1307
          //   1463: astore 6
          //   1465: aload 12
          //   1467: monitorexit
          //   1468: ldc 24
          //   1470: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1473: aload 6
          //   1475: athrow
          //   1476: aload 6
          //   1478: aload 10
          //   1480: getfield 280	com/tencent/mm/protocal/protobuf/dmz:aaTE	Ljava/lang/String;
          //   1483: putfield 419	com/tencent/mm/g/h:heD	Ljava/lang/String;
          //   1486: aload 6
          //   1488: aload 11
          //   1490: getfield 213	com/tencent/mm/pointers/PInt:value	I
          //   1493: putfield 422	com/tencent/mm/g/h:field_preloadRatio	I
          //   1496: aload 6
          //   1498: aload 8
          //   1500: putfield 425	com/tencent/mm/g/h:hQX	Ljava/lang/String;
          //   1503: aload 9
          //   1505: invokevirtual 289	com/tencent/mm/plugin/sns/storage/SnsInfo:getUserName	()Ljava/lang/String;
          //   1508: astore 8
          //   1510: aload 6
          //   1512: aload 8
          //   1514: putfield 428	com/tencent/mm/g/h:lxj	Ljava/lang/String;
          //   1517: aload 6
          //   1519: aload 8
          //   1521: putfield 431	com/tencent/mm/g/h:hQQ	Ljava/lang/String;
          //   1524: goto -1143 -> 381
          //   1527: aload 12
          //   1529: monitorexit
          //   1530: aload 6
          //   1532: ifnonnull +17 -> 1549
          //   1535: ldc 60
          //   1537: ldc_w 433
          //   1540: invokestatic 67	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   1543: ldc 24
          //   1545: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1548: return
          //   1549: aload 10
          //   1551: ifnonnull +26 -> 1577
          //   1554: ldc 60
          //   1556: ldc_w 435
          //   1559: iconst_1
          //   1560: anewarray 4	java/lang/Object
          //   1563: dup
          //   1564: iconst_0
          //   1565: aload 7
          //   1567: aastore
          //   1568: invokestatic 90	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   1571: ldc 24
          //   1573: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1576: return
          //   1577: new 437	com/tencent/mm/modelvideo/j
          //   1580: dup
          //   1581: aload 10
          //   1583: aload 6
          //   1585: invokevirtual 123	com/tencent/mm/plugin/sns/storage/SnsInfo:getLocalid	()Ljava/lang/String;
          //   1588: invokespecial 440	com/tencent/mm/modelvideo/j:<init>	(Lcom/tencent/mm/g/h;Ljava/lang/String;)V
          //   1591: astore 7
          //   1593: aload 7
          //   1595: aload_0
          //   1596: getfield 17	com/tencent/mm/plugin/sns/model/ba$3:QyM	Lcom/tencent/mm/plugin/sns/model/ba;
          //   1599: getfield 74	com/tencent/mm/plugin/sns/model/ba:oZS	Z
          //   1602: putfield 443	com/tencent/mm/modelvideo/j:oZh	Z
          //   1605: aload 7
          //   1607: aload_0
          //   1608: getfield 17	com/tencent/mm/plugin/sns/model/ba$3:QyM	Lcom/tencent/mm/plugin/sns/model/ba;
          //   1611: invokevirtual 446	com/tencent/mm/modelvideo/j:a	(Lcom/tencent/mm/modelvideo/j$a;)I
          //   1614: ifge +179 -> 1793
          //   1617: ldc 60
          //   1619: ldc_w 448
          //   1622: iconst_1
          //   1623: anewarray 4	java/lang/Object
          //   1626: dup
          //   1627: iconst_0
          //   1628: aload_0
          //   1629: getfield 17	com/tencent/mm/plugin/sns/model/ba$3:QyM	Lcom/tencent/mm/plugin/sns/model/ba;
          //   1632: invokevirtual 192	java/lang/Object:hashCode	()I
          //   1635: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1638: aastore
          //   1639: invokestatic 451	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   1642: aload_0
          //   1643: getfield 17	com/tencent/mm/plugin/sns/model/ba$3:QyM	Lcom/tencent/mm/plugin/sns/model/ba;
          //   1646: getfield 102	com/tencent/mm/plugin/sns/model/ba:QyG	Ljava/util/LinkedList;
          //   1649: astore 7
          //   1651: aload 7
          //   1653: monitorenter
          //   1654: aload_0
          //   1655: getfield 17	com/tencent/mm/plugin/sns/model/ba$3:QyM	Lcom/tencent/mm/plugin/sns/model/ba;
          //   1658: getfield 102	com/tencent/mm/plugin/sns/model/ba:QyG	Ljava/util/LinkedList;
          //   1661: invokevirtual 106	java/util/LinkedList:iterator	()Ljava/util/Iterator;
          //   1664: astore 8
          //   1666: aload 8
          //   1668: invokeinterface 113 1 0
          //   1673: ifeq +203 -> 1876
          //   1676: aload 8
          //   1678: invokeinterface 117 1 0
          //   1683: checkcast 119	com/tencent/mm/plugin/sns/storage/SnsInfo
          //   1686: astore 9
          //   1688: aload 9
          //   1690: ifnull -24 -> 1666
          //   1693: aload 9
          //   1695: invokevirtual 123	com/tencent/mm/plugin/sns/storage/SnsInfo:getLocalid	()Ljava/lang/String;
          //   1698: aload 6
          //   1700: invokevirtual 123	com/tencent/mm/plugin/sns/storage/SnsInfo:getLocalid	()Ljava/lang/String;
          //   1703: invokestatic 455	com/tencent/mm/sdk/platformtools/Util:isEqual	(Ljava/lang/String;Ljava/lang/String;)Z
          //   1706: ifeq -40 -> 1666
          //   1709: ldc 60
          //   1711: ldc_w 457
          //   1714: iconst_2
          //   1715: anewarray 4	java/lang/Object
          //   1718: dup
          //   1719: iconst_0
          //   1720: aload 6
          //   1722: invokevirtual 123	com/tencent/mm/plugin/sns/storage/SnsInfo:getLocalid	()Ljava/lang/String;
          //   1725: aastore
          //   1726: dup
          //   1727: iconst_1
          //   1728: aload_0
          //   1729: getfield 17	com/tencent/mm/plugin/sns/model/ba$3:QyM	Lcom/tencent/mm/plugin/sns/model/ba;
          //   1732: invokevirtual 192	java/lang/Object:hashCode	()I
          //   1735: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1738: aastore
          //   1739: invokestatic 90	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   1742: aload 8
          //   1744: invokeinterface 134 1 0
          //   1749: goto -83 -> 1666
          //   1752: astore 6
          //   1754: aload 7
          //   1756: monitorexit
          //   1757: ldc 24
          //   1759: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1762: aload 6
          //   1764: athrow
          //   1765: astore 6
          //   1767: ldc 60
          //   1769: aload 6
          //   1771: ldc 108
          //   1773: iconst_0
          //   1774: anewarray 4	java/lang/Object
          //   1777: invokestatic 461	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
          //   1780: aload_0
          //   1781: getfield 17	com/tencent/mm/plugin/sns/model/ba$3:QyM	Lcom/tencent/mm/plugin/sns/model/ba;
          //   1784: invokevirtual 462	com/tencent/mm/plugin/sns/model/ba:hhy	()V
          //   1787: ldc 24
          //   1789: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1792: return
          //   1793: ldc 60
          //   1795: ldc_w 464
          //   1798: iconst_2
          //   1799: anewarray 4	java/lang/Object
          //   1802: dup
          //   1803: iconst_0
          //   1804: aload 7
          //   1806: getfield 467	com/tencent/mm/modelvideo/j:hES	Ljava/lang/String;
          //   1809: aastore
          //   1810: dup
          //   1811: iconst_1
          //   1812: aload 11
          //   1814: getfield 213	com/tencent/mm/pointers/PInt:value	I
          //   1817: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1820: aastore
          //   1821: invokestatic 90	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   1824: aload 7
          //   1826: invokestatic 473	java/lang/System:currentTimeMillis	()J
          //   1829: putfield 476	com/tencent/mm/modelvideo/j:oZg	J
          //   1832: aload_0
          //   1833: getfield 17	com/tencent/mm/plugin/sns/model/ba$3:QyM	Lcom/tencent/mm/plugin/sns/model/ba;
          //   1836: getfield 50	com/tencent/mm/plugin/sns/model/ba:QyH	Ljava/util/LinkedList;
          //   1839: astore 8
          //   1841: aload 8
          //   1843: monitorenter
          //   1844: aload_0
          //   1845: getfield 17	com/tencent/mm/plugin/sns/model/ba$3:QyM	Lcom/tencent/mm/plugin/sns/model/ba;
          //   1848: getfield 50	com/tencent/mm/plugin/sns/model/ba:QyH	Ljava/util/LinkedList;
          //   1851: iconst_0
          //   1852: aload 7
          //   1854: invokevirtual 480	java/util/LinkedList:add	(ILjava/lang/Object;)V
          //   1857: aload 8
          //   1859: monitorexit
          //   1860: goto -218 -> 1642
          //   1863: astore 6
          //   1865: aload 8
          //   1867: monitorexit
          //   1868: ldc 24
          //   1870: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1873: aload 6
          //   1875: athrow
          //   1876: aload 7
          //   1878: monitorexit
          //   1879: ldc 24
          //   1881: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1884: return
          //   1885: iconst_0
          //   1886: istore_2
          //   1887: goto -1735 -> 152
          //   1890: aconst_null
          //   1891: astore 6
          //   1893: goto -1512 -> 381
          //   1896: iconst_3
          //   1897: istore_1
          //   1898: goto -837 -> 1061
          //   1901: aconst_null
          //   1902: astore 6
          //   1904: goto -1691 -> 213
          //   1907: aload 6
          //   1909: astore 10
          //   1911: aload 9
          //   1913: astore 6
          //   1915: goto -388 -> 1527
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	1918	0	this	3
          //   312	1586	1	i	int
          //   151	1736	2	j	int
          //   1050	18	3	l	long
          //   1119	213	5	bool	boolean
          //   1463	258	6	localObject2	Object
          //   1752	11	6	localObject3	Object
          //   1765	5	6	localException	Exception
          //   1863	11	6	localObject4	Object
          //   1891	23	6	localObject5	Object
          //   211	34	7	str	String
          //   271	1295	7	localObject6	Object
          //   237	1675	9	localSnsInfo	SnsInfo
          //   215	1695	10	localObject9	Object
          //   174	1639	11	localPInt	com.tencent.mm.pointers.PInt
          //   165	794	13	localPBool	com.tencent.mm.pointers.PBool
          //   183	634	14	localPString	com.tencent.mm.pointers.PString
          //   207	180	15	localIterator	Iterator
          //   1003	416	16	localObject10	Object
          //   336	1088	17	localObject11	Object
          //   1133	320	18	localObject12	Object
          // Exception table:
          //   from	to	target	type
          //   52	82	271	finally
          //   197	209	1463	finally
          //   217	254	1463	finally
          //   261	268	1463	finally
          //   284	300	1463	finally
          //   305	311	1463	finally
          //   313	328	1463	finally
          //   332	345	1463	finally
          //   350	378	1463	finally
          //   386	393	1463	finally
          //   404	428	1463	finally
          //   433	440	1463	finally
          //   445	453	1463	finally
          //   453	466	1463	finally
          //   471	475	1463	finally
          //   479	507	1463	finally
          //   512	560	1463	finally
          //   565	571	1463	finally
          //   576	582	1463	finally
          //   587	593	1463	finally
          //   598	612	1463	finally
          //   617	639	1463	finally
          //   644	660	1463	finally
          //   665	672	1463	finally
          //   677	685	1463	finally
          //   685	698	1463	finally
          //   703	811	1463	finally
          //   816	886	1463	finally
          //   890	896	1463	finally
          //   901	921	1463	finally
          //   924	944	1463	finally
          //   947	953	1463	finally
          //   958	964	1463	finally
          //   969	1059	1463	finally
          //   1061	1102	1463	finally
          //   1108	1143	1463	finally
          //   1146	1194	1463	finally
          //   1199	1274	1463	finally
          //   1280	1291	1463	finally
          //   1299	1307	1463	finally
          //   1307	1441	1463	finally
          //   1452	1460	1463	finally
          //   1476	1524	1463	finally
          //   1527	1530	1463	finally
          //   1654	1666	1752	finally
          //   1666	1688	1752	finally
          //   1693	1749	1752	finally
          //   1876	1879	1752	finally
          //   1577	1642	1765	java/lang/Exception
          //   1642	1654	1765	java/lang/Exception
          //   1754	1765	1765	java/lang/Exception
          //   1793	1844	1765	java/lang/Exception
          //   1865	1876	1765	java/lang/Exception
          //   1879	1884	1765	java/lang/Exception
          //   1844	1860	1863	finally
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
  
  final boolean hhz()
  {
    AppMethodBeat.i(95980);
    long l1 = Util.currentTicks();
    int i = com.tencent.mm.plugin.sns.model.b.a.hhV();
    long l2 = Util.nowSecond() - i * 86400L;
    Log.i("MicroMsg.SnsVideoService", "%d start to delete expired file limit[%d] status[%d] expiredTime[%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(1), Integer.valueOf(130), Long.valueOf(l2) });
    List localList = v.bOh().e(130, 1, l2);
    if ((localList == null) || (localList.isEmpty()))
    {
      AppMethodBeat.o(95980);
      return false;
    }
    Iterator localIterator = localList.iterator();
    i = 0;
    z localz;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localz = (z)localIterator.next();
    } while (localz == null);
    label447:
    for (;;)
    {
      try
      {
        Object localObject = az.aYF(localz.getFileName());
        localObject = al.hgB().aZL((String)localObject);
        if ((localObject == null) || (((SnsInfo)localObject).getTimeLine().ContentObj == null) || (Util.isNullOrNil(((SnsInfo)localObject).getTimeLine().ContentObj.Zpr))) {
          break;
        }
        localObject = az.E((dmz)((SnsInfo)localObject).getTimeLine().ContentObj.Zpr.get(0));
        if (Util.isNullOrNil((String)localObject)) {
          break label447;
        }
        com.tencent.mm.vfs.u localu = new com.tencent.mm.vfs.u((String)localObject);
        if (!localu.jKS()) {
          break label447;
        }
        l2 = localu.length();
        Log.i("MicroMsg.SnsVideoService", "%s file[%d %d] lastmodifytime[%d] path[%s]", new Object[] { localz.getFileName(), Long.valueOf(l2), Integer.valueOf(localz.hQV), Long.valueOf(localz.pba), localObject });
        if ((l2 <= 0L) || (l2 > localz.hQV)) {
          break label447;
        }
        localu.diJ();
        i += 1;
      }
      catch (Exception localException1)
      {
        try
        {
          localz.hQV = 0;
          localz.eQp = 1;
          ab.f(localz);
        }
        catch (Exception localException2)
        {
          break label364;
        }
        localException1 = localException1;
      }
      label364:
      break;
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 145L, i, false);
      Log.i("MicroMsg.SnsVideoService", "%d delete expire file size %d delete count %d costTime[%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(localList.size()), Integer.valueOf(i), Long.valueOf(Util.ticksToNow(l1)) });
      AppMethodBeat.o(95980);
      return false;
    }
  }
  
  public final boolean p(final String paramString, final Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(95982);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(95982);
      return false;
    }
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95969);
        v.bOi().l(paramString, paramArrayOfObject);
        if ((ba.this.QyD != null) && (Util.isEqual(ba.this.QyD.oYq, paramString))) {
          ba.a(ba.this);
        }
        bh localbh = (bh)ba.this.QyF.get(paramString);
        ba.this.QyE.remove(localbh);
        AppMethodBeat.o(95969);
      }
    });
    AppMethodBeat.o(95982);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ba
 * JD-Core Version:    0.7.0.1
 */