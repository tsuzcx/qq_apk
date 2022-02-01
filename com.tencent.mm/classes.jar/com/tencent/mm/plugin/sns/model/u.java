package com.tencent.mm.plugin.sns.model;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.wh;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.sns.ad.timeline.b.e;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.ds;
import com.tencent.mm.protocal.protobuf.dzd;
import com.tencent.mm.protocal.protobuf.eat;
import com.tencent.mm.protocal.protobuf.ebd;
import com.tencent.mm.protocal.protobuf.ebe;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class u
  extends q
  implements com.tencent.mm.network.m
{
  private long DIK;
  private String DIL;
  private long DIg;
  public int DIi;
  public int DIj;
  public int akb;
  public com.tencent.mm.ak.i callback;
  private com.tencent.mm.ak.d rr;
  final int sourceType;
  
  public u()
  {
    AppMethodBeat.i(95619);
    this.DIg = 0L;
    this.DIK = 0L;
    this.DIL = "";
    this.DIi = 0;
    this.DIj = 0;
    this.akb = 0;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ebd();
    ((d.a)localObject).iLO = new ebe();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnspreloadingtimeline";
    ((d.a)localObject).funcId = 718;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    int i;
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
      i = 1;
    }
    for (;;)
    {
      this.sourceType = 2;
      ebd localebd = (ebd)this.rr.iLK.iLR;
      localebd.MYL = i;
      localebd.MZh = 0L;
      int j = aj.faE().fbw();
      this.DIg = aj.faO().g(0L, j, true);
      localebd.Nau = this.DIg;
      int k = d.a(this.DIg, 0L, "@__weixintimtline");
      localebd.Nav = k;
      this.DIK = aj.faO().g(0L, 1, true);
      Log.i("MicroMsg.NetSceneSnsPreTimeLine", "newerid " + this.DIK);
      localebd.Naw = this.DIK;
      l locall = aj.faS().aQr("@__weixintimtline");
      if (locall == null)
      {
        localObject = "";
        label263:
        this.DIL = ((String)localObject);
        if (this.DIL == null) {
          this.DIL = "";
        }
        localebd.MZg = this.DIL;
        if ((locall != null) && (locall.field_adsession != null)) {
          break label463;
        }
      }
      for (localebd.MYJ = new SKBuiltinBuffer_t().setBuffer(new byte[0]);; localebd.MYJ = new SKBuiltinBuffer_t().setBuffer(locall.field_adsession))
      {
        Log.i("MicroMsg.NetSceneSnsPreTimeLine", " This req nextCount: " + j + " min:" + this.DIg + " ReqTime:" + localebd.Nav + " nettype: " + i);
        Log.d("MicroMsg.NetSceneSnsPreTimeLine", "minId: %s lastReqTime: %s", new Object[] { r.Jb(this.DIg), Integer.valueOf(k) });
        AppMethodBeat.o(95619);
        return;
        if (NetStatusUtil.is3G(MMApplicationContext.getContext()))
        {
          i = 3;
          break;
        }
        if (NetStatusUtil.is4G(MMApplicationContext.getContext()))
        {
          i = 4;
          break;
        }
        if (!NetStatusUtil.is2G(MMApplicationContext.getContext())) {
          break label506;
        }
        i = 2;
        break;
        localObject = locall.field_md5;
        break label263;
        label463:
        Log.d("MicroMsg.NetSceneSnsPreTimeLine", "request adsession %s", new Object[] { locall.field_adsession });
      }
      label506:
      i = 0;
    }
  }
  
  private void a(ebe paramebe, String paramString)
  {
    AppMethodBeat.i(95620);
    an.a("@__weixintimtline", this.sourceType, paramebe.KOH, paramString);
    this.DIg = ((SnsObject)paramebe.KOH.getLast()).Id;
    d.f("@__weixintimtline", ((SnsObject)paramebe.KOH.getFirst()).Id, this.DIg, paramebe.NaG);
    paramebe = paramebe.KOH.iterator();
    label668:
    label704:
    while (paramebe.hasNext())
    {
      paramString = (SnsObject)paramebe.next();
      if (paramString.NoChange == 0)
      {
        Object localObject1 = aj.faO().JJ(paramString.Id);
        if ((localObject1 != null) && (((SnsInfo)localObject1).getTimeLine() != null))
        {
          Object localObject2 = ((SnsInfo)localObject1).getTimeLine().ContentObj.LoV;
          Object localObject3;
          Object localObject4;
          if ((((SnsInfo)localObject1).isAd()) || (!be.fiv()))
          {
            localObject3 = ((List)localObject2).iterator();
            if (((Iterator)localObject3).hasNext())
            {
              localObject4 = (cnb)((Iterator)localObject3).next();
              if (((List)localObject2).size() <= 1) {}
              for (boolean bool = true;; bool = false)
              {
                b((cnb)localObject4, bool);
                break;
              }
            }
          }
          else
          {
            localObject3 = ((SnsInfo)localObject1).getSnsId();
            if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
              break label339;
            }
          }
          for (;;)
          {
            for (;;)
            {
              if ((((SnsInfo)localObject1).getTypeFlag() != 15) || ((((SnsInfo)localObject1).isAd()) && (!com.tencent.mm.plugin.sns.ad.timeline.b.a.n((SnsInfo)localObject1)))) {
                break label704;
              }
              aj.faM().G((SnsInfo)localObject1);
              try
              {
                localObject1 = ((cnb)((SnsInfo)localObject1).getTimeLine().ContentObj.LoV.get(0)).Url;
                com.tencent.mm.plugin.report.service.h.CyF.a(14388, new Object[] { Long.valueOf(paramString.Id), Integer.valueOf(4), localObject1, Integer.valueOf(0) });
              }
              catch (Exception paramString) {}
            }
            break;
            label339:
            int k = ((List)localObject2).size();
            if (1 == k)
            {
              localObject2 = (cnb)((List)localObject2).get(0);
              Log.i("MicroMsg.NetSceneSnsPreTimeLine", "deal with single media, media type: %s.", new Object[] { Integer.valueOf(((cnb)localObject2).oUv) });
              b((cnb)localObject2, true);
            }
            else
            {
              localObject4 = new SparseArray();
              SparseArray localSparseArray = new SparseArray();
              int i = 0;
              if (i < k)
              {
                cnb localcnb = (cnb)((List)localObject2).get(i);
                if (6 == localcnb.oUv)
                {
                  Log.w("MicroMsg.NetSceneSnsPreTimeLine", "img batch download contains video, snsId: %s, mediaId: %s.", new Object[] { localObject3, localcnb.Id });
                  b(localcnb, false);
                }
                for (;;)
                {
                  i += 1;
                  break;
                  Object localObject5 = r.e(localcnb);
                  String str = ar.ki(aj.getAccSnsPath(), localcnb.Id);
                  if ((com.tencent.mm.vfs.s.YS(str + (String)localObject5)) || (com.tencent.mm.vfs.s.YS(str + r.l(localcnb))) || (com.tencent.mm.vfs.s.YS(str + r.m(localcnb)))) {
                    Log.i("MicroMsg.NetSceneSnsPreTimeLine", "mediaExist exist:%s.", new Object[] { localcnb.Id });
                  }
                  for (int j = 1;; j = 0)
                  {
                    if (j != 0) {
                      break label668;
                    }
                    localObject5 = new com.tencent.mm.plugin.sns.data.n(localcnb);
                    ((com.tencent.mm.plugin.sns.data.n)localObject5).DEs = 0;
                    ((com.tencent.mm.plugin.sns.data.n)localObject5).dPI = localcnb.Id;
                    localSparseArray.put(i, localObject5);
                    ((SparseArray)localObject4).put(i, localcnb);
                    break;
                  }
                }
              }
              if (((SparseArray)localObject4).size() > 0)
              {
                Log.i("MicroMsg.NetSceneSnsPreTimeLine", "deal with batch img.");
                aj.faJ().a((String)localObject3, (SparseArray)localObject4, localSparseArray, bp.Oql, k);
              }
            }
          }
        }
      }
    }
    aj.faM().fbO();
    AppMethodBeat.o(95620);
  }
  
  private static void b(cnb paramcnb, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(95623);
    if (paramcnb == null)
    {
      AppMethodBeat.o(95623);
      return;
    }
    Object localObject1 = r.e(paramcnb);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localObject2 = ar.ki(aj.getAccSnsPath(), paramcnb.Id);
      if ((!com.tencent.mm.vfs.s.YS((String)localObject2 + (String)localObject1)) && (!com.tencent.mm.vfs.s.YS((String)localObject2 + r.l(paramcnb))) && (!com.tencent.mm.vfs.s.YS((String)localObject2 + r.m(paramcnb)))) {
        break;
      }
      Log.i("MicroMsg.NetSceneSnsPreTimeLine", "dealwithMedia exist:%s", new Object[] { paramcnb.Id });
      AppMethodBeat.o(95623);
      return;
    }
    Log.i("MicroMsg.NetSceneSnsPreTimeLine", "dealwithMedia ready to download:%s", new Object[] { paramcnb.Id });
    localObject1 = new com.tencent.mm.plugin.sns.data.n(paramcnb);
    ((com.tencent.mm.plugin.sns.data.n)localObject1).DEs = i;
    ((com.tencent.mm.plugin.sns.data.n)localObject1).dPI = paramcnb.Id;
    Object localObject2 = aj.faJ();
    i = j;
    if (paramcnb.oUv == 6) {
      i = 5;
    }
    ((c)localObject2).a(paramcnb, i, (com.tencent.mm.plugin.sns.data.n)localObject1, bp.Oql);
    AppMethodBeat.o(95623);
  }
  
  public final int doScene(g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(95622);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(95622);
    return i;
  }
  
  public final int getType()
  {
    return 718;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95621);
    Log.i("MicroMsg.NetSceneSnsPreTimeLine", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    ebe localebe = (ebe)((com.tencent.mm.ak.d)params).iLL.iLR;
    if ((params.getRespObj().getRetCode() != 207) && (params.getRespObj().getRetCode() != 0))
    {
      z.aPb("@__weixintimtline");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95621);
      return;
    }
    if (localebe.MZl != null)
    {
      Log.d("MicroMsg.NetSceneSnsPreTimeLine", "serverConfig  " + localebe.MZl.Naq + " " + localebe.MZl.Nap);
      paramInt1 = localebe.MZl.Naq;
      com.tencent.mm.plugin.sns.c.a.DCT = paramInt1;
      if (paramInt1 <= 0) {
        com.tencent.mm.plugin.sns.c.a.DCT = 2147483647;
      }
      com.tencent.mm.storage.aq.NSd = localebe.MZl.Nap;
    }
    this.DIi = localebe.MZk;
    this.DIj = localebe.xuw;
    Log.i("MicroMsg.NetSceneSnsPreTimeLine", "for same md5 count: " + localebe.MZk + " , objCount:  " + localebe.MvM + " cflag : " + localebe.xuw);
    this.akb = localebe.MvM;
    String str = r.Jc(0L);
    if (!localebe.KOH.isEmpty())
    {
      paramArrayOfByte = new StringBuilder("respone size ").append(localebe.KOH.size()).append(" Max ").append(((SnsObject)localebe.KOH.getFirst()).Id).append(" ").append(r.Jb(((SnsObject)localebe.KOH.getFirst()).Id)).append("  respone min  ").append(((SnsObject)localebe.KOH.getLast()).Id).append(" ").append(r.Jb(((SnsObject)localebe.KOH.getLast()).Id)).append(" adCount=");
      if (localebe.NaI == null) {}
      for (paramInt1 = 0;; paramInt1 = localebe.NaI.size())
      {
        Log.i("MicroMsg.NetSceneSnsPreTimeLine", paramInt1);
        com.tencent.mm.plugin.sns.ad.e.c.c(localebe.NaM, localebe.NaL, 1);
        this.akb = localebe.MvM;
        if (!this.DIL.equals(localebe.MZg)) {
          break;
        }
        this.DIg = aj.faO().g(0L, this.DIi, true);
        Log.i("MicroMsg.NetSceneSnsPreTimeLine", "md5 is no change!! the new minid %s", new Object[] { Long.valueOf(this.DIg) });
        z.aPb("@__weixintimtline");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95621);
        return;
      }
    }
    paramArrayOfByte = new StringBuilder(" respone is Empty, adCount=");
    if (localebe.NaI == null) {}
    for (paramInt1 = 0;; paramInt1 = localebe.NaI.size())
    {
      Log.i("MicroMsg.NetSceneSnsPreTimeLine", paramInt1);
      break;
    }
    aj.faS().g("@__weixintimtline", localebe.MZg, com.tencent.mm.platformtools.z.a(localebe.MYJ));
    Log.i("MicroMsg.NetSceneSnsPreTimeLine", "fp resp list size " + localebe.KOH.size() + " adsize : " + localebe.NaH);
    paramInt1 = 0;
    long l2;
    for (;;)
    {
      if (paramInt1 >= localebe.NaI.size()) {
        break label1255;
      }
      ds localds = (ds)localebe.NaI.get(paramInt1);
      Object localObject4 = new StringBuilder();
      if ((localds != null) && (localds.KHH != null)) {
        ((StringBuilder)localObject4).append(com.tencent.mm.platformtools.z.a(localds.KHH));
      }
      Object localObject3 = new StringBuilder();
      paramArrayOfByte = new StringBuilder();
      if ((localds != null) && (localds.KHG != null))
      {
        ((StringBuilder)localObject3).append(com.tencent.mm.platformtools.z.a(localds.KHG.MYI));
        paramArrayOfByte.append(com.tencent.mm.platformtools.z.b(localds.KHG.MYH.ObjectDesc));
      }
      Log.i("MicroMsg.NetSceneSnsPreTimeLine", "skXml " + ((StringBuilder)localObject4).toString());
      Log.i("MicroMsg.NetSceneSnsPreTimeLine", "adXml " + ((StringBuilder)localObject3).toString());
      Log.i("MicroMsg.NetSceneSnsPreTimeLine", "snsXml " + paramArrayOfByte.toString() + "\r\n");
      long l3 = 0L;
      Object localObject1 = "";
      paramArrayOfByte = (byte[])localObject1;
      l2 = l3;
      try
      {
        localObject4 = ((StringBuilder)localObject4).toString();
        paramArrayOfByte = (byte[])localObject1;
        l2 = l3;
        localObject3 = ((StringBuilder)localObject3).toString();
        localObject1 = localObject3;
        l1 = l3;
        paramArrayOfByte = (byte[])localObject3;
        l2 = l3;
        if (!Util.isNullOrNil(new String[] { localObject4, localObject3 }))
        {
          l1 = l3;
          if (localds != null)
          {
            l1 = l3;
            paramArrayOfByte = (byte[])localObject3;
            l2 = l3;
            if (localds.KHG != null)
            {
              l1 = l3;
              paramArrayOfByte = (byte[])localObject3;
              l2 = l3;
              if (localds.KHG.MYH != null)
              {
                paramArrayOfByte = (byte[])localObject3;
                l2 = l3;
                l1 = Util.nullAsNil(Long.valueOf(localds.KHG.MYH.Id));
              }
            }
          }
          paramArrayOfByte = (byte[])localObject3;
          l2 = l1;
          com.tencent.mm.plugin.sns.data.i.d(l1, (String)localObject4, (String)localObject3);
          localObject1 = localObject3;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          boolean bool;
          Log.e("MicroMsg.NetSceneSnsPreTimeLine", "reportAdPullException: " + localThrowable.toString());
          localObject2 = paramArrayOfByte;
          long l1 = l2;
        }
      }
      paramArrayOfByte = localds.KHG.MYH.Username;
      if (!Util.isNullOrNil(paramArrayOfByte))
      {
        bool = k.aOd((String)localObject1);
        Log.i("MicroMsg.NetSceneSnsPreTimeLine", "checkUpdate contact:" + paramArrayOfByte + ", isUsePreferedInfo=" + bool + ", snsId=" + r.Jc(l1));
        if (!bool)
        {
          ay.a.iDq.aL(paramArrayOfByte, "");
          com.tencent.f.h.RTc.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(95618);
              Log.i("MicroMsg.NetSceneSnsPreTimeLine", "checkUpdate avatar:" + paramArrayOfByte);
              com.tencent.mm.aj.c.Mf(paramArrayOfByte);
              p.aYD().Mh(paramArrayOfByte);
              AppMethodBeat.o(95618);
            }
          }, 10000L);
        }
      }
      e.a(localds);
      paramInt1 += 1;
    }
    label1255:
    a.a(localebe.NaI, localebe.KOH, false, -1);
    j.d(localebe.NaI, false);
    if (localebe.NaH == 0)
    {
      Log.i("MicroMsg.NetSceneSnsPreTimeLine", "recv %d recommend", new Object[] { Integer.valueOf(localebe.NaJ) });
      a.e(localebe.NaK, localebe.KOH);
      a.bo(localebe.NaK);
    }
    paramArrayOfByte = new LinkedList();
    Object localObject2 = localebe.KOH.iterator();
    while (((Iterator)localObject2).hasNext()) {
      paramArrayOfByte.add(Long.valueOf(((SnsObject)((Iterator)localObject2).next()).Id));
    }
    localObject2 = new wh();
    ((wh)localObject2).ecr.ecs = paramArrayOfByte;
    EventCenter.instance.publish((IEvent)localObject2);
    if (params.getRespObj().getRetCode() == 207)
    {
      if (localebe.KOH.isEmpty()) {
        aj.faO().feP();
      }
      for (;;)
      {
        z.aPb("@__weixintimtline");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95621);
        return;
        aj.faO().aQu(r.Jc(((SnsObject)localebe.KOH.getFirst()).Id));
        aj.faO().aQt(r.Jc(((SnsObject)localebe.KOH.getLast()).Id));
        a(localebe, str);
        j.br(localebe.KOH);
      }
    }
    if (localebe.KOH.isEmpty()) {
      aj.faO().feP();
    }
    for (;;)
    {
      z.aPb("@__weixintimtline");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95621);
      return;
      a(localebe, str);
      j.br(localebe.KOH);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.u
 * JD-Core Version:    0.7.0.1
 */