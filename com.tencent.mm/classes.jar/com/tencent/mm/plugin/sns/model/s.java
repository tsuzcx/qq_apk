package com.tencent.mm.plugin.sns.model;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.g.a.ua;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.bv;
import com.tencent.mm.protocal.protobuf.cud;
import com.tencent.mm.protocal.protobuf.cvr;
import com.tencent.mm.protocal.protobuf.cwb;
import com.tencent.mm.protocal.protobuf.cwc;
import com.tencent.mm.protocal.protobuf.dg;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.protocal.protobuf.zo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bc;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class s
  extends com.tencent.mm.al.n
  implements com.tencent.mm.network.k
{
  public int ahd;
  public com.tencent.mm.al.g callback;
  private com.tencent.mm.al.b rr;
  final int sourceType;
  private long wEU;
  public int wEW;
  public int wEX;
  private long wFx;
  private String wFy;
  
  public s()
  {
    AppMethodBeat.i(95619);
    this.wEU = 0L;
    this.wFx = 0L;
    this.wFy = "";
    this.wEW = 0;
    this.wEX = 0;
    this.ahd = 0;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cwb();
    ((b.a)localObject).gUV = new cwc();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnspreloadingtimeline";
    ((b.a)localObject).funcId = 718;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    int i;
    if (com.tencent.mm.sdk.platformtools.ay.isWifi(com.tencent.mm.sdk.platformtools.aj.getContext())) {
      i = 1;
    }
    for (;;)
    {
      this.sourceType = 2;
      cwb localcwb = (cwb)this.rr.gUS.gUX;
      localcwb.ElS = i;
      localcwb.Emo = 0L;
      int j = af.dtk().dtX();
      this.wEU = af.dtu().f(0L, j, true);
      localcwb.Enz = this.wEU;
      int k = c.a(this.wEU, 0L, "@__weixintimtline");
      localcwb.EnA = k;
      this.wFx = af.dtu().f(0L, 1, true);
      ad.i("MicroMsg.NetSceneSnsPreTimeLine", "newerid " + this.wFx);
      localcwb.EnB = this.wFx;
      com.tencent.mm.plugin.sns.storage.n localn = af.dty().apP("@__weixintimtline");
      if (localn == null)
      {
        localObject = "";
        label263:
        this.wFy = ((String)localObject);
        if (this.wFy == null) {
          this.wFy = "";
        }
        localcwb.Emn = this.wFy;
        if ((localn != null) && (localn.field_adsession != null)) {
          break label463;
        }
      }
      for (localcwb.ElQ = new SKBuiltinBuffer_t().setBuffer(new byte[0]);; localcwb.ElQ = new SKBuiltinBuffer_t().setBuffer(localn.field_adsession))
      {
        ad.i("MicroMsg.NetSceneSnsPreTimeLine", " This req nextCount: " + j + " min:" + this.wEU + " ReqTime:" + localcwb.EnA + " nettype: " + i);
        ad.d("MicroMsg.NetSceneSnsPreTimeLine", "minId: %s lastReqTime: %s", new Object[] { com.tencent.mm.plugin.sns.data.q.st(this.wEU), Integer.valueOf(k) });
        AppMethodBeat.o(95619);
        return;
        if (com.tencent.mm.sdk.platformtools.ay.is3G(com.tencent.mm.sdk.platformtools.aj.getContext()))
        {
          i = 3;
          break;
        }
        if (com.tencent.mm.sdk.platformtools.ay.is4G(com.tencent.mm.sdk.platformtools.aj.getContext()))
        {
          i = 4;
          break;
        }
        if (!com.tencent.mm.sdk.platformtools.ay.is2G(com.tencent.mm.sdk.platformtools.aj.getContext())) {
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
  
  private static void a(bpi parambpi, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(95623);
    if (parambpi == null)
    {
      AppMethodBeat.o(95623);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.sns.data.q.d(parambpi);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localObject2 = an.iF(af.getAccSnsPath(), parambpi.Id);
      if ((!com.tencent.mm.vfs.i.eK((String)localObject2 + (String)localObject1)) && (!com.tencent.mm.vfs.i.eK((String)localObject2 + com.tencent.mm.plugin.sns.data.q.k(parambpi))) && (!com.tencent.mm.vfs.i.eK((String)localObject2 + com.tencent.mm.plugin.sns.data.q.l(parambpi)))) {
        break;
      }
      ad.i("MicroMsg.NetSceneSnsPreTimeLine", "dealwithMedia exist:%s", new Object[] { parambpi.Id });
      AppMethodBeat.o(95623);
      return;
    }
    ad.i("MicroMsg.NetSceneSnsPreTimeLine", "dealwithMedia ready to download:%s", new Object[] { parambpi.Id });
    localObject1 = new m(parambpi);
    ((m)localObject1).wBd = i;
    ((m)localObject1).dnB = parambpi.Id;
    Object localObject2 = af.dtp();
    i = j;
    if (parambpi.mBH == 6) {
      i = 5;
    }
    ((b)localObject2).a(parambpi, i, (m)localObject1, bc.Fzx);
    AppMethodBeat.o(95623);
  }
  
  private void a(cwc paramcwc, String paramString)
  {
    AppMethodBeat.i(95620);
    aj.b("@__weixintimtline", this.sourceType, paramcwc.CEH, paramString);
    this.wEU = ((SnsObject)paramcwc.CEH.getLast()).Id;
    c.e("@__weixintimtline", ((SnsObject)paramcwc.CEH.getFirst()).Id, this.wEU, paramcwc.EnI);
    paramcwc = paramcwc.CEH.iterator();
    label664:
    label700:
    while (paramcwc.hasNext())
    {
      paramString = (SnsObject)paramcwc.next();
      if (paramString.NoChange == 0)
      {
        Object localObject1 = af.dtu().th(paramString.Id);
        if ((localObject1 != null) && (((p)localObject1).dxy() != null))
        {
          Object localObject2 = ((p)localObject1).dxy().Etm.DaC;
          Object localObject3;
          Object localObject4;
          if ((((p)localObject1).Nb(32)) || (!com.tencent.mm.plugin.sns.ui.ay.dBA()))
          {
            localObject3 = ((List)localObject2).iterator();
            if (((Iterator)localObject3).hasNext())
            {
              localObject4 = (bpi)((Iterator)localObject3).next();
              if (((List)localObject2).size() <= 1) {}
              for (boolean bool = true;; bool = false)
              {
                a((bpi)localObject4, bool);
                break;
              }
            }
          }
          else
          {
            localObject3 = ((p)localObject1).getSnsId();
            if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
              break label335;
            }
          }
          for (;;)
          {
            for (;;)
            {
              if ((((p)localObject1).field_type != 15) || (((p)localObject1).Nb(32))) {
                break label700;
              }
              af.dts().w((p)localObject1);
              try
              {
                localObject1 = ((bpi)((p)localObject1).dxy().Etm.DaC.get(0)).Url;
                com.tencent.mm.plugin.report.service.h.vKh.f(14388, new Object[] { Long.valueOf(paramString.Id), Integer.valueOf(4), localObject1, Integer.valueOf(0) });
              }
              catch (Exception paramString) {}
            }
            break;
            label335:
            int k = ((List)localObject2).size();
            if (1 == k)
            {
              localObject2 = (bpi)((List)localObject2).get(0);
              ad.i("MicroMsg.NetSceneSnsPreTimeLine", "deal with single media, media type: %s.", new Object[] { Integer.valueOf(((bpi)localObject2).mBH) });
              a((bpi)localObject2, true);
            }
            else
            {
              localObject4 = new SparseArray();
              SparseArray localSparseArray = new SparseArray();
              int i = 0;
              if (i < k)
              {
                bpi localbpi = (bpi)((List)localObject2).get(i);
                if (6 == localbpi.mBH)
                {
                  ad.w("MicroMsg.NetSceneSnsPreTimeLine", "img batch download contains video, snsId: %s, mediaId: %s.", new Object[] { localObject3, localbpi.Id });
                  a(localbpi, false);
                }
                for (;;)
                {
                  i += 1;
                  break;
                  Object localObject5 = com.tencent.mm.plugin.sns.data.q.d(localbpi);
                  String str = an.iF(af.getAccSnsPath(), localbpi.Id);
                  if ((com.tencent.mm.vfs.i.eK(str + (String)localObject5)) || (com.tencent.mm.vfs.i.eK(str + com.tencent.mm.plugin.sns.data.q.k(localbpi))) || (com.tencent.mm.vfs.i.eK(str + com.tencent.mm.plugin.sns.data.q.l(localbpi)))) {
                    ad.i("MicroMsg.NetSceneSnsPreTimeLine", "mediaExist exist:%s.", new Object[] { localbpi.Id });
                  }
                  for (int j = 1;; j = 0)
                  {
                    if (j != 0) {
                      break label664;
                    }
                    localObject5 = new m(localbpi);
                    ((m)localObject5).wBd = 0;
                    ((m)localObject5).dnB = localbpi.Id;
                    localSparseArray.put(i, localObject5);
                    ((SparseArray)localObject4).put(i, localbpi);
                    break;
                  }
                }
              }
              if (((SparseArray)localObject4).size() > 0)
              {
                ad.i("MicroMsg.NetSceneSnsPreTimeLine", "deal with batch img.");
                af.dtp().a((String)localObject3, (SparseArray)localObject4, localSparseArray, bc.Fzx, k);
              }
            }
          }
        }
      }
    }
    af.dts().dun();
    AppMethodBeat.o(95620);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(95622);
    this.callback = paramg;
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
    paramArrayOfByte = (cwc)((com.tencent.mm.al.b)paramq).gUT.gUX;
    if ((paramq.getRespObj().getRetCode() != 207) && (paramq.getRespObj().getRetCode() != 0))
    {
      x.aox("@__weixintimtline");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95621);
      return;
    }
    if (paramArrayOfByte.Emt != null)
    {
      ad.d("MicroMsg.NetSceneSnsPreTimeLine", "serverConfig  " + paramArrayOfByte.Emt.Env + " " + paramArrayOfByte.Emt.Enu);
      paramInt1 = paramArrayOfByte.Emt.Env;
      com.tencent.mm.plugin.sns.d.a.wzN = paramInt1;
      if (paramInt1 <= 0) {
        com.tencent.mm.plugin.sns.d.a.wzN = 2147483647;
      }
      com.tencent.mm.storage.ad.FfG = paramArrayOfByte.Emt.Enu;
    }
    this.wEW = paramArrayOfByte.Emr;
    this.wEX = paramArrayOfByte.Ems;
    ad.i("MicroMsg.NetSceneSnsPreTimeLine", "for same md5 count: " + paramArrayOfByte.Emr + " , objCount:  " + paramArrayOfByte.DOR + " cflag : " + paramArrayOfByte.Ems);
    this.ahd = paramArrayOfByte.DOR;
    String str = com.tencent.mm.plugin.sns.data.q.su(0L);
    label534:
    long l1;
    Object localObject2;
    if (!paramArrayOfByte.CEH.isEmpty())
    {
      localObject1 = new StringBuilder("respone size ").append(paramArrayOfByte.CEH.size()).append(" Max ").append(((SnsObject)paramArrayOfByte.CEH.getFirst()).Id).append(" ").append(com.tencent.mm.plugin.sns.data.q.st(((SnsObject)paramArrayOfByte.CEH.getFirst()).Id)).append("  respone min  ").append(((SnsObject)paramArrayOfByte.CEH.getLast()).Id).append(" ").append(com.tencent.mm.plugin.sns.data.q.st(((SnsObject)paramArrayOfByte.CEH.getLast()).Id)).append(" adCount=");
      if (paramArrayOfByte.EnK == null)
      {
        paramInt1 = 0;
        ad.i("MicroMsg.NetSceneSnsPreTimeLine", paramInt1);
        if (paramArrayOfByte.EnN <= 0) {
          break label780;
        }
        ad.i("MicroMsg.NetSceneSnsPreTimeLine", "%d ads to delete", new Object[] { Integer.valueOf(paramArrayOfByte.EnN) });
        if ((paramArrayOfByte.EnO == null) || (paramArrayOfByte.EnO.size() != paramArrayOfByte.EnN)) {
          break label780;
        }
        localObject1 = new LinkedList();
        paramInt1 = 0;
        if (paramInt1 >= paramArrayOfByte.EnN) {
          break label748;
        }
        l1 = ((zo)paramArrayOfByte.EnO.get(paramInt1)).Id;
        ad.i("MicroMsg.NetSceneSnsPreTimeLine", "delete ad %s", new Object[] { Long.valueOf(l1) });
        if (l1 != 0L)
        {
          localObject2 = af.dtx().sY(l1);
          if (localObject2 != null) {
            break label680;
          }
          ad.i("MicroMsg.NetSceneSnsPreTimeLine", "adSnsInfo is null!");
        }
      }
    }
    label680:
    Object localObject4;
    for (;;)
    {
      paramInt1 += 1;
      break label534;
      paramInt1 = paramArrayOfByte.EnK.size();
      break;
      localObject1 = new StringBuilder(" respone is Empty, adCount=");
      if (paramArrayOfByte.EnK == null) {}
      for (paramInt1 = 0;; paramInt1 = paramArrayOfByte.EnK.size())
      {
        ad.i("MicroMsg.NetSceneSnsPreTimeLine", paramInt1);
        break;
      }
      localObject4 = new bv();
      ((bv)localObject4).CwP = 13298;
      ((bv)localObject4).CwQ = new com.tencent.mm.bx.b(((com.tencent.mm.plugin.sns.storage.e)localObject2).dxu().dvK.getBytes());
      ((bv)localObject4).rOh = (System.currentTimeMillis() / 1000L);
      ((LinkedList)localObject1).add(localObject4);
      a.sv(l1);
    }
    label748:
    if (((LinkedList)localObject1).size() > 0)
    {
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a(new k((LinkedList)localObject1), 0);
    }
    label780:
    this.ahd = paramArrayOfByte.DOR;
    if (this.wFy.equals(paramArrayOfByte.Emn))
    {
      this.wEU = af.dtu().f(0L, this.wEW, true);
      ad.i("MicroMsg.NetSceneSnsPreTimeLine", "md5 is no change!! the new minid %s", new Object[] { Long.valueOf(this.wEU) });
      x.aox("@__weixintimtline");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95621);
      return;
    }
    af.dty().g("@__weixintimtline", paramArrayOfByte.Emn, z.a(paramArrayOfByte.ElQ));
    ad.i("MicroMsg.NetSceneSnsPreTimeLine", "fp resp list size " + paramArrayOfByte.CEH.size() + " adsize : " + paramArrayOfByte.EnJ);
    paramInt1 = 0;
    for (;;)
    {
      if (paramInt1 >= paramArrayOfByte.EnK.size()) {
        break label1374;
      }
      localObject1 = (dg)paramArrayOfByte.EnK.get(paramInt1);
      localObject4 = new StringBuilder();
      if ((localObject1 != null) && (((dg)localObject1).CxT != null)) {
        ((StringBuilder)localObject4).append(z.a(((dg)localObject1).CxT));
      }
      localObject2 = new StringBuilder();
      StringBuilder localStringBuilder = new StringBuilder();
      if ((localObject1 != null) && (((dg)localObject1).CxS != null))
      {
        ((StringBuilder)localObject2).append(z.a(((dg)localObject1).CxS.ElP));
        localStringBuilder.append(z.b(((dg)localObject1).CxS.ElO.ObjectDesc));
      }
      ad.i("MicroMsg.NetSceneSnsPreTimeLine", "skXml " + ((StringBuilder)localObject4).toString());
      ad.i("MicroMsg.NetSceneSnsPreTimeLine", "adXml " + ((StringBuilder)localObject2).toString());
      ad.i("MicroMsg.NetSceneSnsPreTimeLine", "snsXml " + localStringBuilder.toString() + "\r\n");
      com.tencent.mm.plugin.sns.waid.g.aqW(((StringBuilder)localObject4).toString());
      try
      {
        localObject4 = ((StringBuilder)localObject4).toString();
        localObject2 = ((StringBuilder)localObject2).toString();
        if (!bt.T(new String[] { localObject4, localObject2 }))
        {
          long l2 = 0L;
          l1 = l2;
          if (localObject1 != null)
          {
            l1 = l2;
            if (((dg)localObject1).CxS != null)
            {
              l1 = l2;
              if (((dg)localObject1).CxS.ElO != null) {
                l1 = bt.f(Long.valueOf(((dg)localObject1).CxS.ElO.Id));
              }
            }
          }
          com.tencent.mm.plugin.sns.data.h.c(l1, (String)localObject4, (String)localObject2);
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ad.e("MicroMsg.NetSceneSnsPreTimeLine", "reportAdPullException: " + localThrowable.toString());
        }
      }
      localObject2 = ((dg)localObject1).CxS.ElO.Username;
      if (!bt.isNullOrNil((String)localObject2))
      {
        ad.i("MicroMsg.NetSceneSnsPreTimeLine", "checkUpdate contact:".concat(String.valueOf(localObject2)));
        ar.a.gMW.aB((String)localObject2, "");
        com.tencent.e.h.Iye.q(new s.1(this, (String)localObject2), 10000L);
      }
      j.a((dg)localObject1);
      paramInt1 += 1;
    }
    label1374:
    a.y(paramArrayOfByte.EnK, paramArrayOfByte.CEH);
    a.aJ(paramArrayOfByte.EnK);
    if (paramArrayOfByte.EnJ == 0)
    {
      ad.i("MicroMsg.NetSceneSnsPreTimeLine", "recv %d recommend", new Object[] { Integer.valueOf(paramArrayOfByte.EnL) });
      a.e(paramArrayOfByte.EnM, paramArrayOfByte.CEH);
      a.aI(paramArrayOfByte.EnM);
    }
    Object localObject1 = new LinkedList();
    Object localObject3 = paramArrayOfByte.CEH.iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((LinkedList)localObject1).add(Long.valueOf(((SnsObject)((Iterator)localObject3).next()).Id));
    }
    localObject3 = new ua();
    ((ua)localObject3).dzq.dzr = ((LinkedList)localObject1);
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject3);
    if (paramq.getRespObj().getRetCode() == 207)
    {
      if (paramArrayOfByte.CEH.isEmpty()) {
        af.dtu().dyo();
      }
      for (;;)
      {
        x.aox("@__weixintimtline");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95621);
        return;
        af.dtu().apS(com.tencent.mm.plugin.sns.data.q.su(((SnsObject)paramArrayOfByte.CEH.getFirst()).Id));
        af.dtu().apR(com.tencent.mm.plugin.sns.data.q.su(((SnsObject)paramArrayOfByte.CEH.getLast()).Id));
        a(paramArrayOfByte, str);
        a.aK(paramArrayOfByte.CEH);
      }
    }
    if (paramArrayOfByte.CEH.isEmpty()) {
      af.dtu().dyo();
    }
    for (;;)
    {
      x.aox("@__weixintimtline");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95621);
      return;
      a(paramArrayOfByte, str);
      a.aK(paramArrayOfByte.CEH);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.s
 * JD-Core Version:    0.7.0.1
 */