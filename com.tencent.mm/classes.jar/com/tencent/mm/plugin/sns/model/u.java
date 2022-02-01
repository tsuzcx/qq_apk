package com.tencent.mm.plugin.sns.model;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.f.a.xm;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.sns.ad.timeline.b.b;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.data.p;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.bg;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.dq;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.ejd;
import com.tencent.mm.protocal.protobuf.ekt;
import com.tencent.mm.protocal.protobuf.eld;
import com.tencent.mm.protocal.protobuf.ele;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class u
  extends com.tencent.mm.an.q
  implements com.tencent.mm.network.m
{
  private long JVK;
  private String JVL;
  private long JVg;
  public int JVi;
  public int JVj;
  public int afI;
  public com.tencent.mm.an.i callback;
  private com.tencent.mm.an.d rr;
  final int sourceType;
  
  public u()
  {
    AppMethodBeat.i(95619);
    this.JVg = 0L;
    this.JVK = 0L;
    this.JVL = "";
    this.JVi = 0;
    this.JVj = 0;
    this.afI = 0;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new eld();
    ((d.a)localObject).lBV = new ele();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnspreloadingtimeline";
    ((d.a)localObject).funcId = 718;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    int i = t.avq();
    this.sourceType = 2;
    eld localeld = (eld)d.b.b(this.rr.lBR);
    localeld.Ulf = i;
    localeld.UlB = 0L;
    int j = aj.fOy().fPp();
    this.JVg = aj.fOI().g(0L, j, true);
    localeld.UmO = this.JVg;
    int k = d.a(this.JVg, 0L, "@__weixintimtline");
    localeld.UmP = k;
    this.JVK = aj.fOI().g(0L, 1, true);
    Log.i("MicroMsg.NetSceneSnsPreTimeLine", "newerid " + this.JVK);
    localeld.UmQ = this.JVK;
    l locall = aj.fOM().bbr("@__weixintimtline");
    if (locall == null)
    {
      localObject = "";
      this.JVL = ((String)localObject);
      if (this.JVL == null) {
        this.JVL = "";
      }
      localeld.UlA = this.JVL;
      if ((locall != null) && (locall.field_adsession != null)) {
        break label432;
      }
    }
    for (localeld.Uld = new eae().dc(new byte[0]);; localeld.Uld = new eae().dc(locall.field_adsession))
    {
      localeld.Una = new eae().dc(com.tencent.mm.plugin.sns.ad.d.e.fJS());
      Log.i("MicroMsg.NetSceneSnsPreTimeLine", "This req nextCount: " + j + " min:" + this.JVg + " ReqTime:" + localeld.UmP + " nettype: " + i);
      Log.d("MicroMsg.NetSceneSnsPreTimeLine", "minId: %s lastReqTime: %s", new Object[] { t.Qu(this.JVg), Integer.valueOf(k) });
      AppMethodBeat.o(95619);
      return;
      localObject = locall.field_md5;
      break;
      label432:
      Log.i("MicroMsg.NetSceneSnsPreTimeLine", "request adsession %s", new Object[] { locall.field_adsession });
    }
  }
  
  private void a(ele paramele, String paramString)
  {
    AppMethodBeat.i(95620);
    an.a("@__weixintimtline", this.sourceType, paramele.RPF, paramString);
    this.JVg = ((SnsObject)paramele.RPF.getLast()).Id;
    d.f("@__weixintimtline", ((SnsObject)paramele.RPF.getFirst()).Id, this.JVg, paramele.Unb);
    paramele = paramele.RPF.iterator();
    label667:
    label703:
    while (paramele.hasNext())
    {
      paramString = (SnsObject)paramele.next();
      if (paramString.NoChange == 0)
      {
        Object localObject1 = aj.fOI().Rd(paramString.Id);
        if ((localObject1 != null) && (((SnsInfo)localObject1).getTimeLine() != null))
        {
          Object localObject2 = ((SnsInfo)localObject1).getTimeLine().ContentObj.Sqr;
          Object localObject3;
          Object localObject4;
          if ((((SnsInfo)localObject1).isAd()) || (!bg.fWH()))
          {
            localObject3 = ((List)localObject2).iterator();
            if (((Iterator)localObject3).hasNext())
            {
              localObject4 = (cvt)((Iterator)localObject3).next();
              if (((List)localObject2).size() <= 1) {}
              for (boolean bool = true;; bool = false)
              {
                b((cvt)localObject4, bool);
                break;
              }
            }
          }
          else
          {
            localObject3 = ((SnsInfo)localObject1).getSnsId();
            if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
              break label338;
            }
          }
          for (;;)
          {
            for (;;)
            {
              if ((((SnsInfo)localObject1).getTypeFlag() != 15) || ((((SnsInfo)localObject1).isAd()) && (!b.n((SnsInfo)localObject1)))) {
                break label703;
              }
              aj.fOG().H((SnsInfo)localObject1);
              try
              {
                localObject1 = ((cvt)((SnsInfo)localObject1).getTimeLine().ContentObj.Sqr.get(0)).Url;
                com.tencent.mm.plugin.report.service.h.IzE.a(14388, new Object[] { Long.valueOf(paramString.Id), Integer.valueOf(4), localObject1, Integer.valueOf(0) });
              }
              catch (Exception paramString) {}
            }
            break;
            label338:
            int k = ((List)localObject2).size();
            if (1 == k)
            {
              localObject2 = (cvt)((List)localObject2).get(0);
              Log.i("MicroMsg.NetSceneSnsPreTimeLine", "deal with single media, media type: %s.", new Object[] { Integer.valueOf(((cvt)localObject2).rWu) });
              b((cvt)localObject2, true);
            }
            else
            {
              localObject4 = new SparseArray();
              SparseArray localSparseArray = new SparseArray();
              int i = 0;
              if (i < k)
              {
                cvt localcvt = (cvt)((List)localObject2).get(i);
                if (6 == localcvt.rWu)
                {
                  Log.w("MicroMsg.NetSceneSnsPreTimeLine", "img batch download contains video, snsId: %s, mediaId: %s.", new Object[] { localObject3, localcvt.Id });
                  b(localcvt, false);
                }
                for (;;)
                {
                  i += 1;
                  break;
                  Object localObject5 = t.d(localcvt);
                  String str = aq.kD(aj.getAccSnsPath(), localcvt.Id);
                  if ((com.tencent.mm.vfs.u.agG(str + (String)localObject5)) || (com.tencent.mm.vfs.u.agG(str + t.k(localcvt))) || (com.tencent.mm.vfs.u.agG(str + t.l(localcvt)))) {
                    Log.i("MicroMsg.NetSceneSnsPreTimeLine", "mediaExist exist:%s.", new Object[] { localcvt.Id });
                  }
                  for (int j = 1;; j = 0)
                  {
                    if (j != 0) {
                      break label667;
                    }
                    localObject5 = new p(localcvt);
                    ((p)localObject5).JRn = 0;
                    ((p)localObject5).fIY = localcvt.Id;
                    localSparseArray.put(i, localObject5);
                    ((SparseArray)localObject4).put(i, localcvt);
                    break;
                  }
                }
              }
              if (((SparseArray)localObject4).size() > 0)
              {
                Log.i("MicroMsg.NetSceneSnsPreTimeLine", "deal with batch img.");
                aj.fOD().a((String)localObject3, (SparseArray)localObject4, localSparseArray, bp.VGh, k);
              }
            }
          }
        }
      }
    }
    aj.fOG().fPG();
    AppMethodBeat.o(95620);
  }
  
  private static void b(cvt paramcvt, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(95623);
    if (paramcvt == null)
    {
      AppMethodBeat.o(95623);
      return;
    }
    Object localObject1 = t.d(paramcvt);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localObject2 = aq.kD(aj.getAccSnsPath(), paramcvt.Id);
      if ((!com.tencent.mm.vfs.u.agG((String)localObject2 + (String)localObject1)) && (!com.tencent.mm.vfs.u.agG((String)localObject2 + t.k(paramcvt))) && (!com.tencent.mm.vfs.u.agG((String)localObject2 + t.l(paramcvt)))) {
        break;
      }
      Log.i("MicroMsg.NetSceneSnsPreTimeLine", "dealwithMedia exist:%s", new Object[] { paramcvt.Id });
      AppMethodBeat.o(95623);
      return;
    }
    Log.i("MicroMsg.NetSceneSnsPreTimeLine", "dealwithMedia ready to download:%s", new Object[] { paramcvt.Id });
    localObject1 = new p(paramcvt);
    ((p)localObject1).JRn = i;
    ((p)localObject1).fIY = paramcvt.Id;
    Object localObject2 = aj.fOD();
    i = j;
    if (paramcvt.rWu == 6) {
      i = 5;
    }
    ((c)localObject2).a(paramcvt, i, (p)localObject1, bp.VGh);
    AppMethodBeat.o(95623);
  }
  
  public final int doScene(g paramg, com.tencent.mm.an.i parami)
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95621);
    Log.i("MicroMsg.NetSceneSnsPreTimeLine", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    ele localele = (ele)d.c.b(((com.tencent.mm.an.d)params).lBS);
    if ((params.getRespObj().getRetCode() != 207) && (params.getRespObj().getRetCode() != 0))
    {
      z.aZW("@__weixintimtline");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95621);
      return;
    }
    if (localele.UlF != null)
    {
      Log.d("MicroMsg.NetSceneSnsPreTimeLine", "serverConfig  " + localele.UlF.UmK + " " + localele.UlF.UmJ);
      paramInt1 = localele.UlF.UmK;
      com.tencent.mm.plugin.sns.c.a.JPj = paramInt1;
      if (paramInt1 <= 0) {
        com.tencent.mm.plugin.sns.c.a.JPj = 2147483647;
      }
      com.tencent.mm.storage.aq.Vga = localele.UlF.UmJ;
    }
    this.JVi = localele.UlE;
    this.JVj = localele.CqN;
    Log.i("MicroMsg.NetSceneSnsPreTimeLine", "for same md5 count: " + localele.UlE + " , objCount:  " + localele.TGK + " controlFlag : " + localele.CqN);
    this.afI = localele.TGK;
    String str = t.Qv(0L);
    if (!localele.RPF.isEmpty())
    {
      paramArrayOfByte = new StringBuilder("resp size ").append(localele.RPF.size()).append(", resp Max:").append(((SnsObject)localele.RPF.getFirst()).Id).append(" ").append(t.Qu(((SnsObject)localele.RPF.getFirst()).Id)).append(", resp Min:").append(((SnsObject)localele.RPF.getLast()).Id).append(" ").append(t.Qu(((SnsObject)localele.RPF.getLast()).Id)).append(", adListSize:");
      if (localele.Und == null) {}
      for (paramInt1 = 0;; paramInt1 = localele.Und.size())
      {
        Log.i("MicroMsg.NetSceneSnsPreTimeLine", paramInt1);
        com.tencent.mm.plugin.sns.ad.d.f.c(localele.Unh, localele.Ung, 1);
        this.afI = localele.TGK;
        if (!this.JVL.equals(localele.UlA)) {
          break;
        }
        this.JVg = aj.fOI().g(0L, this.JVi, true);
        Log.i("MicroMsg.NetSceneSnsPreTimeLine", "md5 is no change!! the new minid %s", new Object[] { Long.valueOf(this.JVg) });
        z.aZW("@__weixintimtline");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95621);
        return;
      }
    }
    paramArrayOfByte = new StringBuilder(" resp is Empty, adListSize:");
    if (localele.Und == null) {}
    for (paramInt1 = 0;; paramInt1 = localele.Und.size())
    {
      Log.i("MicroMsg.NetSceneSnsPreTimeLine", paramInt1);
      break;
    }
    aj.fOM().g("@__weixintimtline", localele.UlA, com.tencent.mm.platformtools.z.a(localele.Uld));
    Log.i("MicroMsg.NetSceneSnsPreTimeLine", "fp resp list size " + localele.RPF.size() + " adsize : " + localele.Unc);
    if ((localele != null) && (localele.Und != null) && (localele.Und.size() > 0)) {
      com.tencent.mm.plugin.sns.ad.d.e.fJT();
    }
    long l2;
    for (;;)
    {
      paramInt1 = 0;
      for (;;)
      {
        if (paramInt1 >= localele.Und.size()) {
          break label1295;
        }
        dq localdq = (dq)localele.Und.get(paramInt1);
        Object localObject4 = new StringBuilder();
        if ((localdq != null) && (localdq.RJa != null)) {
          ((StringBuilder)localObject4).append(com.tencent.mm.platformtools.z.a(localdq.RJa));
        }
        Object localObject3 = new StringBuilder();
        paramArrayOfByte = new StringBuilder();
        if ((localdq != null) && (localdq.RIZ != null))
        {
          ((StringBuilder)localObject3).append(com.tencent.mm.platformtools.z.a(localdq.RIZ.Ulc));
          paramArrayOfByte.append(com.tencent.mm.platformtools.z.b(localdq.RIZ.Ulb.ObjectDesc));
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
            if (localdq != null)
            {
              l1 = l3;
              paramArrayOfByte = (byte[])localObject3;
              l2 = l3;
              if (localdq.RIZ != null)
              {
                l1 = l3;
                paramArrayOfByte = (byte[])localObject3;
                l2 = l3;
                if (localdq.RIZ.Ulb != null)
                {
                  paramArrayOfByte = (byte[])localObject3;
                  l2 = l3;
                  l1 = Util.nullAsNil(Long.valueOf(localdq.RIZ.Ulb.Id));
                }
              }
            }
            paramArrayOfByte = (byte[])localObject3;
            l2 = l1;
            k.f(l1, (String)localObject4, (String)localObject3);
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
        paramArrayOfByte = localdq.RIZ.Ulb.Username;
        if (!Util.isNullOrNil(paramArrayOfByte))
        {
          bool = com.tencent.mm.plugin.sns.data.m.aYV((String)localObject1);
          Log.i("MicroMsg.NetSceneSnsPreTimeLine", "checkUpdate contact:" + paramArrayOfByte + ", isUsePreferedInfo=" + bool + ", snsId=" + t.Qv(l1));
          if (!bool)
          {
            az.a.ltq.aP(paramArrayOfByte, "");
            com.tencent.e.h.ZvG.o(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(95618);
                Log.i("MicroMsg.NetSceneSnsPreTimeLine", "checkUpdate avatar:" + paramArrayOfByte);
                com.tencent.mm.am.d.TA(paramArrayOfByte);
                com.tencent.mm.am.q.bhR().Rv(paramArrayOfByte);
                AppMethodBeat.o(95618);
              }
            }, 10000L);
          }
        }
        com.tencent.mm.plugin.sns.ad.timeline.b.f.a(localdq, 4);
        paramInt1 += 1;
      }
      Log.d("AdPassThroughInfoHelper", "NetSceneSnsPreTimeLine, resp AdvertiseList size is 0");
    }
    label1295:
    a.a(localele.Und, localele.RPF, false, -1);
    j.f(localele.Und, false);
    if (localele.Unc == 0)
    {
      Log.i("MicroMsg.NetSceneSnsPreTimeLine", "recv %d recommend", new Object[] { Integer.valueOf(localele.Une) });
      a.f(localele.Unf, localele.RPF);
      a.bI(localele.Unf);
    }
    paramArrayOfByte = new LinkedList();
    Object localObject2 = localele.RPF.iterator();
    while (((Iterator)localObject2).hasNext()) {
      paramArrayOfByte.add(Long.valueOf(((SnsObject)((Iterator)localObject2).next()).Id));
    }
    localObject2 = new xm();
    ((xm)localObject2).fWt.fWu = paramArrayOfByte;
    EventCenter.instance.publish((IEvent)localObject2);
    if (params.getRespObj().getRetCode() == 207)
    {
      if (localele.RPF.isEmpty()) {
        aj.fOI().fSK();
      }
      for (;;)
      {
        z.aZW("@__weixintimtline");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95621);
        return;
        aj.fOI().bbu(t.Qv(((SnsObject)localele.RPF.getFirst()).Id));
        aj.fOI().bbt(t.Qv(((SnsObject)localele.RPF.getLast()).Id));
        a(localele, str);
        j.bM(localele.RPF);
      }
    }
    if (localele.RPF.isEmpty()) {
      aj.fOI().fSK();
    }
    for (;;)
    {
      z.aZW("@__weixintimtline");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95621);
      return;
      a(localele, str);
      j.bM(localele.RPF);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.u
 * JD-Core Version:    0.7.0.1
 */