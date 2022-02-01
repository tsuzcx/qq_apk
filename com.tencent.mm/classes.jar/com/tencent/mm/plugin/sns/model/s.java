package com.tencent.mm.plugin.sns.model;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.g.a.vd;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.bb;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.bx;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.dfc;
import com.tencent.mm.protocal.protobuf.dgq;
import com.tencent.mm.protocal.protobuf.dha;
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.protocal.protobuf.dj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bj;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class s
  extends com.tencent.mm.al.n
  implements com.tencent.mm.network.k
{
  public int ajO;
  public com.tencent.mm.al.f callback;
  private com.tencent.mm.al.b rr;
  final int sourceType;
  private long zhL;
  private String zhM;
  private long zhj;
  public int zhl;
  public int zhm;
  
  public s()
  {
    AppMethodBeat.i(95619);
    this.zhj = 0L;
    this.zhL = 0L;
    this.zhM = "";
    this.zhl = 0;
    this.zhm = 0;
    this.ajO = 0;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dha();
    ((b.a)localObject).hNN = new dhb();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnspreloadingtimeline";
    ((b.a)localObject).funcId = 718;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    int i;
    if (ay.isWifi(aj.getContext())) {
      i = 1;
    }
    for (;;)
    {
      this.sourceType = 2;
      dha localdha = (dha)this.rr.hNK.hNQ;
      localdha.Htz = i;
      localdha.HtV = 0L;
      int j = ag.dTU().dUI();
      this.zhj = ag.dUe().f(0L, j, true);
      localdha.Hvg = this.zhj;
      int k = c.a(this.zhj, 0L, "@__weixintimtline");
      localdha.Hvh = k;
      this.zhL = ag.dUe().f(0L, 1, true);
      ad.i("MicroMsg.NetSceneSnsPreTimeLine", "newerid " + this.zhL);
      localdha.Hvi = this.zhL;
      com.tencent.mm.plugin.sns.storage.n localn = ag.dUi().aAf("@__weixintimtline");
      if (localn == null)
      {
        localObject = "";
        label263:
        this.zhM = ((String)localObject);
        if (this.zhM == null) {
          this.zhM = "";
        }
        localdha.HtU = this.zhM;
        if ((localn != null) && (localn.field_adsession != null)) {
          break label463;
        }
      }
      for (localdha.Htx = new SKBuiltinBuffer_t().setBuffer(new byte[0]);; localdha.Htx = new SKBuiltinBuffer_t().setBuffer(localn.field_adsession))
      {
        ad.i("MicroMsg.NetSceneSnsPreTimeLine", " This req nextCount: " + j + " min:" + this.zhj + " ReqTime:" + localdha.Hvh + " nettype: " + i);
        ad.d("MicroMsg.NetSceneSnsPreTimeLine", "minId: %s lastReqTime: %s", new Object[] { com.tencent.mm.plugin.sns.data.q.zw(this.zhj), Integer.valueOf(k) });
        AppMethodBeat.o(95619);
        return;
        if (ay.is3G(aj.getContext()))
        {
          i = 3;
          break;
        }
        if (ay.is4G(aj.getContext()))
        {
          i = 4;
          break;
        }
        if (!ay.is2G(aj.getContext())) {
          break label505;
        }
        i = 2;
        break;
        localObject = localn.field_md5;
        break label263;
        label463:
        ad.d("MicroMsg.NetSceneSnsPreTimeLine", "request adsession %s", new Object[] { localn.field_adsession });
      }
      label505:
      i = 0;
    }
  }
  
  private static void a(byn parambyn, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(95623);
    if (parambyn == null)
    {
      AppMethodBeat.o(95623);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.sns.data.q.d(parambyn);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localObject2 = ao.jo(ag.getAccSnsPath(), parambyn.Id);
      if ((!com.tencent.mm.vfs.i.fv((String)localObject2 + (String)localObject1)) && (!com.tencent.mm.vfs.i.fv((String)localObject2 + com.tencent.mm.plugin.sns.data.q.k(parambyn))) && (!com.tencent.mm.vfs.i.fv((String)localObject2 + com.tencent.mm.plugin.sns.data.q.l(parambyn)))) {
        break;
      }
      ad.i("MicroMsg.NetSceneSnsPreTimeLine", "dealwithMedia exist:%s", new Object[] { parambyn.Id });
      AppMethodBeat.o(95623);
      return;
    }
    ad.i("MicroMsg.NetSceneSnsPreTimeLine", "dealwithMedia ready to download:%s", new Object[] { parambyn.Id });
    localObject1 = new m(parambyn);
    ((m)localObject1).zds = i;
    ((m)localObject1).dwW = parambyn.Id;
    Object localObject2 = ag.dTZ();
    i = j;
    if (parambyn.nEf == 6) {
      i = 5;
    }
    ((b)localObject2).a(parambyn, i, (m)localObject1, bj.ILN);
    AppMethodBeat.o(95623);
  }
  
  private void a(dhb paramdhb, String paramString)
  {
    AppMethodBeat.i(95620);
    ak.b("@__weixintimtline", this.sourceType, paramdhb.FCD, paramString);
    this.zhj = ((SnsObject)paramdhb.FCD.getLast()).Id;
    c.f("@__weixintimtline", ((SnsObject)paramdhb.FCD.getFirst()).Id, this.zhj, paramdhb.Hvp);
    paramdhb = paramdhb.FCD.iterator();
    label672:
    label708:
    while (paramdhb.hasNext())
    {
      paramString = (SnsObject)paramdhb.next();
      if (paramString.NoChange == 0)
      {
        Object localObject1 = ag.dUe().Ai(paramString.Id);
        if ((localObject1 != null) && (((p)localObject1).dYl() != null))
        {
          Object localObject2 = ((p)localObject1).dYl().HAT.GaQ;
          Object localObject3;
          Object localObject4;
          if ((((p)localObject1).QM(32)) || (!bb.eco()))
          {
            localObject3 = ((List)localObject2).iterator();
            if (((Iterator)localObject3).hasNext())
            {
              localObject4 = (byn)((Iterator)localObject3).next();
              if (((List)localObject2).size() <= 1) {}
              for (boolean bool = true;; bool = false)
              {
                a((byn)localObject4, bool);
                break;
              }
            }
          }
          else
          {
            localObject3 = ((p)localObject1).getSnsId();
            if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
              break label343;
            }
          }
          for (;;)
          {
            for (;;)
            {
              if ((((p)localObject1).field_type != 15) || ((((p)localObject1).QM(32)) && (!com.tencent.mm.plugin.sns.ad.timeline.a.a.i((p)localObject1)))) {
                break label708;
              }
              ag.dUc().z((p)localObject1);
              try
              {
                localObject1 = ((byn)((p)localObject1).dYl().HAT.GaQ.get(0)).Url;
                com.tencent.mm.plugin.report.service.g.yhR.f(14388, new Object[] { Long.valueOf(paramString.Id), Integer.valueOf(4), localObject1, Integer.valueOf(0) });
              }
              catch (Exception paramString) {}
            }
            break;
            label343:
            int k = ((List)localObject2).size();
            if (1 == k)
            {
              localObject2 = (byn)((List)localObject2).get(0);
              ad.i("MicroMsg.NetSceneSnsPreTimeLine", "deal with single media, media type: %s.", new Object[] { Integer.valueOf(((byn)localObject2).nEf) });
              a((byn)localObject2, true);
            }
            else
            {
              localObject4 = new SparseArray();
              SparseArray localSparseArray = new SparseArray();
              int i = 0;
              if (i < k)
              {
                byn localbyn = (byn)((List)localObject2).get(i);
                if (6 == localbyn.nEf)
                {
                  ad.w("MicroMsg.NetSceneSnsPreTimeLine", "img batch download contains video, snsId: %s, mediaId: %s.", new Object[] { localObject3, localbyn.Id });
                  a(localbyn, false);
                }
                for (;;)
                {
                  i += 1;
                  break;
                  Object localObject5 = com.tencent.mm.plugin.sns.data.q.d(localbyn);
                  String str = ao.jo(ag.getAccSnsPath(), localbyn.Id);
                  if ((com.tencent.mm.vfs.i.fv(str + (String)localObject5)) || (com.tencent.mm.vfs.i.fv(str + com.tencent.mm.plugin.sns.data.q.k(localbyn))) || (com.tencent.mm.vfs.i.fv(str + com.tencent.mm.plugin.sns.data.q.l(localbyn)))) {
                    ad.i("MicroMsg.NetSceneSnsPreTimeLine", "mediaExist exist:%s.", new Object[] { localbyn.Id });
                  }
                  for (int j = 1;; j = 0)
                  {
                    if (j != 0) {
                      break label672;
                    }
                    localObject5 = new m(localbyn);
                    ((m)localObject5).zds = 0;
                    ((m)localObject5).dwW = localbyn.Id;
                    localSparseArray.put(i, localObject5);
                    ((SparseArray)localObject4).put(i, localbyn);
                    break;
                  }
                }
              }
              if (((SparseArray)localObject4).size() > 0)
              {
                ad.i("MicroMsg.NetSceneSnsPreTimeLine", "deal with batch img.");
                ag.dTZ().a((String)localObject3, (SparseArray)localObject4, localSparseArray, bj.ILN, k);
              }
            }
          }
        }
      }
    }
    ag.dUc().dVa();
    AppMethodBeat.o(95620);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(95622);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(95622);
    return i;
  }
  
  public final int getType()
  {
    return 718;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95621);
    ad.i("MicroMsg.NetSceneSnsPreTimeLine", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    dhb localdhb = (dhb)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    if ((paramq.getRespObj().getRetCode() != 207) && (paramq.getRespObj().getRetCode() != 0))
    {
      x.ayO("@__weixintimtline");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95621);
      return;
    }
    if (localdhb.Hua != null)
    {
      ad.d("MicroMsg.NetSceneSnsPreTimeLine", "serverConfig  " + localdhb.Hua.Hvc + " " + localdhb.Hua.Hvb);
      paramInt1 = localdhb.Hua.Hvc;
      com.tencent.mm.plugin.sns.c.a.zbZ = paramInt1;
      if (paramInt1 <= 0) {
        com.tencent.mm.plugin.sns.c.a.zbZ = 2147483647;
      }
      com.tencent.mm.storage.ak.IpM = localdhb.Hua.Hvb;
    }
    this.zhl = localdhb.HtY;
    this.zhm = localdhb.HtZ;
    ad.i("MicroMsg.NetSceneSnsPreTimeLine", "for same md5 count: " + localdhb.HtY + " , objCount:  " + localdhb.GUQ + " cflag : " + localdhb.HtZ);
    this.ajO = localdhb.GUQ;
    String str = com.tencent.mm.plugin.sns.data.q.zx(0L);
    label534:
    long l1;
    Object localObject1;
    if (!localdhb.FCD.isEmpty())
    {
      paramArrayOfByte = new StringBuilder("respone size ").append(localdhb.FCD.size()).append(" Max ").append(((SnsObject)localdhb.FCD.getFirst()).Id).append(" ").append(com.tencent.mm.plugin.sns.data.q.zw(((SnsObject)localdhb.FCD.getFirst()).Id)).append("  respone min  ").append(((SnsObject)localdhb.FCD.getLast()).Id).append(" ").append(com.tencent.mm.plugin.sns.data.q.zw(((SnsObject)localdhb.FCD.getLast()).Id)).append(" adCount=");
      if (localdhb.Hvr == null)
      {
        paramInt1 = 0;
        ad.i("MicroMsg.NetSceneSnsPreTimeLine", paramInt1);
        if (localdhb.Hvu <= 0) {
          break label786;
        }
        ad.i("MicroMsg.NetSceneSnsPreTimeLine", "%d ads to delete", new Object[] { Integer.valueOf(localdhb.Hvu) });
        if ((localdhb.Hvv == null) || (localdhb.Hvv.size() != localdhb.Hvu)) {
          break label786;
        }
        paramArrayOfByte = new LinkedList();
        paramInt1 = 0;
        if (paramInt1 >= localdhb.Hvu) {
          break label754;
        }
        l1 = ((acn)localdhb.Hvv.get(paramInt1)).Id;
        ad.i("MicroMsg.NetSceneSnsPreTimeLine", "server delete ad, snsId=" + com.tencent.mm.plugin.sns.data.q.zw(l1));
        if (l1 != 0L)
        {
          localObject1 = ag.dUh().zZ(l1);
          if (localObject1 != null) {
            break label686;
          }
          ad.i("MicroMsg.NetSceneSnsPreTimeLine", "adSnsInfo is null!");
        }
      }
    }
    label686:
    Object localObject3;
    for (;;)
    {
      paramInt1 += 1;
      break label534;
      paramInt1 = localdhb.Hvr.size();
      break;
      paramArrayOfByte = new StringBuilder(" respone is Empty, adCount=");
      if (localdhb.Hvr == null) {}
      for (paramInt1 = 0;; paramInt1 = localdhb.Hvr.size())
      {
        ad.i("MicroMsg.NetSceneSnsPreTimeLine", paramInt1);
        break;
      }
      localObject3 = new bx();
      ((bx)localObject3).Fuv = 13298;
      ((bx)localObject3).Fuw = new com.tencent.mm.bx.b(((com.tencent.mm.plugin.sns.storage.e)localObject1).dRK().dFy.getBytes());
      ((bx)localObject3).tSD = (System.currentTimeMillis() / 1000L);
      paramArrayOfByte.add(localObject3);
      a.zy(l1);
    }
    label754:
    if (paramArrayOfByte.size() > 0)
    {
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().gAO.a(new k(paramArrayOfByte), 0);
    }
    label786:
    this.ajO = localdhb.GUQ;
    if (this.zhM.equals(localdhb.HtU))
    {
      this.zhj = ag.dUe().f(0L, this.zhl, true);
      ad.i("MicroMsg.NetSceneSnsPreTimeLine", "md5 is no change!! the new minid %s", new Object[] { Long.valueOf(this.zhj) });
      x.ayO("@__weixintimtline");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95621);
      return;
    }
    ag.dUi().g("@__weixintimtline", localdhb.HtU, z.a(localdhb.Htx));
    ad.i("MicroMsg.NetSceneSnsPreTimeLine", "fp resp list size " + localdhb.FCD.size() + " adsize : " + localdhb.Hvq);
    paramInt1 = 0;
    long l2;
    for (;;)
    {
      if (paramInt1 >= localdhb.Hvr.size()) {
        break label1496;
      }
      dj localdj = (dj)localdhb.Hvr.get(paramInt1);
      Object localObject4 = new StringBuilder();
      if ((localdj != null) && (localdj.FvE != null)) {
        ((StringBuilder)localObject4).append(z.a(localdj.FvE));
      }
      localObject3 = new StringBuilder();
      paramArrayOfByte = new StringBuilder();
      if ((localdj != null) && (localdj.FvD != null))
      {
        ((StringBuilder)localObject3).append(z.a(localdj.FvD.Htw));
        paramArrayOfByte.append(z.b(localdj.FvD.Htv.ObjectDesc));
      }
      ad.i("MicroMsg.NetSceneSnsPreTimeLine", "skXml " + ((StringBuilder)localObject4).toString());
      ad.i("MicroMsg.NetSceneSnsPreTimeLine", "adXml " + ((StringBuilder)localObject3).toString());
      ad.i("MicroMsg.NetSceneSnsPreTimeLine", "snsXml " + paramArrayOfByte.toString() + "\r\n");
      long l3 = 0L;
      localObject1 = "";
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
        if (!bt.V(new String[] { localObject4, localObject3 }))
        {
          l1 = l3;
          if (localdj != null)
          {
            l1 = l3;
            paramArrayOfByte = (byte[])localObject3;
            l2 = l3;
            if (localdj.FvD != null)
            {
              l1 = l3;
              paramArrayOfByte = (byte[])localObject3;
              l2 = l3;
              if (localdj.FvD.Htv != null)
              {
                paramArrayOfByte = (byte[])localObject3;
                l2 = l3;
                l1 = bt.g(Long.valueOf(localdj.FvD.Htv.Id));
              }
            }
          }
          paramArrayOfByte = (byte[])localObject3;
          l2 = l1;
          com.tencent.mm.plugin.sns.data.h.d(l1, (String)localObject4, (String)localObject3);
          localObject1 = localObject3;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          boolean bool;
          ad.e("MicroMsg.NetSceneSnsPreTimeLine", "reportAdPullException: " + localThrowable.toString());
          localObject2 = paramArrayOfByte;
          l1 = l2;
        }
      }
      paramArrayOfByte = localdj.FvD.Htv.Username;
      if (!bt.isNullOrNil(paramArrayOfByte))
      {
        bool = j.axQ((String)localObject1);
        ad.i("MicroMsg.NetSceneSnsPreTimeLine", "checkUpdate contact:" + paramArrayOfByte + ", isUsePreferedInfo=" + bool + ", snsId=" + com.tencent.mm.plugin.sns.data.q.zx(l1));
        if (!bool)
        {
          as.a.hFO.aI(paramArrayOfByte, "");
          com.tencent.e.h.LTJ.r(new s.1(this, paramArrayOfByte), 10000L);
        }
      }
      com.tencent.mm.plugin.sns.ad.timeline.a.b.a(localdj);
      paramInt1 += 1;
    }
    label1496:
    a.y(localdhb.Hvr, localdhb.FCD);
    a.aR(localdhb.Hvr);
    if (localdhb.Hvq == 0)
    {
      ad.i("MicroMsg.NetSceneSnsPreTimeLine", "recv %d recommend", new Object[] { Integer.valueOf(localdhb.Hvs) });
      a.e(localdhb.Hvt, localdhb.FCD);
      a.aQ(localdhb.Hvt);
    }
    paramArrayOfByte = new LinkedList();
    Object localObject2 = localdhb.FCD.iterator();
    while (((Iterator)localObject2).hasNext()) {
      paramArrayOfByte.add(Long.valueOf(((SnsObject)((Iterator)localObject2).next()).Id));
    }
    localObject2 = new vd();
    ((vd)localObject2).dJo.dJp = paramArrayOfByte;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
    if (paramq.getRespObj().getRetCode() == 207)
    {
      if (localdhb.FCD.isEmpty()) {
        ag.dUe().dZa();
      }
      for (;;)
      {
        x.ayO("@__weixintimtline");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95621);
        return;
        ag.dUe().aAi(com.tencent.mm.plugin.sns.data.q.zx(((SnsObject)localdhb.FCD.getFirst()).Id));
        ag.dUe().aAh(com.tencent.mm.plugin.sns.data.q.zx(((SnsObject)localdhb.FCD.getLast()).Id));
        a(localdhb, str);
        a.aS(localdhb.FCD);
      }
    }
    if (localdhb.FCD.isEmpty()) {
      ag.dUe().dZa();
    }
    for (;;)
    {
      x.ayO("@__weixintimtline");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95621);
      return;
      a(localdhb, str);
      a.aS(localdhb.FCD);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.s
 * JD-Core Version:    0.7.0.1
 */