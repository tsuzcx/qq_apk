package com.tencent.mm.plugin.sns.model;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.g.a.uk;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.aan;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.bx;
import com.tencent.mm.protocal.protobuf.czp;
import com.tencent.mm.protocal.protobuf.dbd;
import com.tencent.mm.protocal.protobuf.dbn;
import com.tencent.mm.protocal.protobuf.dbo;
import com.tencent.mm.protocal.protobuf.di;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bf;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class s
  extends com.tencent.mm.ak.n
  implements com.tencent.mm.network.k
{
  public int ahX;
  public com.tencent.mm.ak.g callback;
  private com.tencent.mm.ak.b rr;
  final int sourceType;
  private long xRR;
  private String xRS;
  private long xRp;
  public int xRr;
  public int xRs;
  
  public s()
  {
    AppMethodBeat.i(95619);
    this.xRp = 0L;
    this.xRR = 0L;
    this.xRS = "";
    this.xRr = 0;
    this.xRs = 0;
    this.ahX = 0;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dbn();
    ((b.a)localObject).hvu = new dbo();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnspreloadingtimeline";
    ((b.a)localObject).funcId = 718;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    int i;
    if (ax.isWifi(ai.getContext())) {
      i = 1;
    }
    for (;;)
    {
      this.sourceType = 2;
      dbn localdbn = (dbn)this.rr.hvr.hvw;
      localdbn.FIR = i;
      localdbn.FJn = 0L;
      int j = af.dHH().dIv();
      this.xRp = af.dHR().f(0L, j, true);
      localdbn.FKy = this.xRp;
      int k = c.a(this.xRp, 0L, "@__weixintimtline");
      localdbn.FKz = k;
      this.xRR = af.dHR().f(0L, 1, true);
      ac.i("MicroMsg.NetSceneSnsPreTimeLine", "newerid " + this.xRR);
      localdbn.FKA = this.xRR;
      com.tencent.mm.plugin.sns.storage.n localn = af.dHV().auY("@__weixintimtline");
      if (localn == null)
      {
        localObject = "";
        label263:
        this.xRS = ((String)localObject);
        if (this.xRS == null) {
          this.xRS = "";
        }
        localdbn.FJm = this.xRS;
        if ((localn != null) && (localn.field_adsession != null)) {
          break label463;
        }
      }
      for (localdbn.FIP = new SKBuiltinBuffer_t().setBuffer(new byte[0]);; localdbn.FIP = new SKBuiltinBuffer_t().setBuffer(localn.field_adsession))
      {
        ac.i("MicroMsg.NetSceneSnsPreTimeLine", " This req nextCount: " + j + " min:" + this.xRp + " ReqTime:" + localdbn.FKz + " nettype: " + i);
        ac.d("MicroMsg.NetSceneSnsPreTimeLine", "minId: %s lastReqTime: %s", new Object[] { com.tencent.mm.plugin.sns.data.q.wW(this.xRp), Integer.valueOf(k) });
        AppMethodBeat.o(95619);
        return;
        if (ax.is3G(ai.getContext()))
        {
          i = 3;
          break;
        }
        if (ax.is4G(ai.getContext()))
        {
          i = 4;
          break;
        }
        if (!ax.is2G(ai.getContext())) {
          break label505;
        }
        i = 2;
        break;
        localObject = localn.field_md5;
        break label263;
        label463:
        ac.d("MicroMsg.NetSceneSnsPreTimeLine", "request adsession %s", new Object[] { localn.field_adsession });
      }
      label505:
      i = 0;
    }
  }
  
  private static void a(btz parambtz, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(95623);
    if (parambtz == null)
    {
      AppMethodBeat.o(95623);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.sns.data.q.d(parambtz);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localObject2 = an.jc(af.getAccSnsPath(), parambtz.Id);
      if ((!com.tencent.mm.vfs.i.eA((String)localObject2 + (String)localObject1)) && (!com.tencent.mm.vfs.i.eA((String)localObject2 + com.tencent.mm.plugin.sns.data.q.k(parambtz))) && (!com.tencent.mm.vfs.i.eA((String)localObject2 + com.tencent.mm.plugin.sns.data.q.l(parambtz)))) {
        break;
      }
      ac.i("MicroMsg.NetSceneSnsPreTimeLine", "dealwithMedia exist:%s", new Object[] { parambtz.Id });
      AppMethodBeat.o(95623);
      return;
    }
    ac.i("MicroMsg.NetSceneSnsPreTimeLine", "dealwithMedia ready to download:%s", new Object[] { parambtz.Id });
    localObject1 = new m(parambtz);
    ((m)localObject1).xNy = i;
    ((m)localObject1).dlj = parambtz.Id;
    Object localObject2 = af.dHM();
    i = j;
    if (parambtz.ndI == 6) {
      i = 5;
    }
    ((b)localObject2).a(parambtz, i, (m)localObject1, bf.GYz);
    AppMethodBeat.o(95623);
  }
  
  private void a(dbo paramdbo, String paramString)
  {
    AppMethodBeat.i(95620);
    aj.b("@__weixintimtline", this.sourceType, paramdbo.DXh, paramString);
    this.xRp = ((SnsObject)paramdbo.DXh.getLast()).Id;
    c.f("@__weixintimtline", ((SnsObject)paramdbo.DXh.getFirst()).Id, this.xRp, paramdbo.FKH);
    paramdbo = paramdbo.DXh.iterator();
    label664:
    label700:
    while (paramdbo.hasNext())
    {
      paramString = (SnsObject)paramdbo.next();
      if (paramString.NoChange == 0)
      {
        Object localObject1 = af.dHR().xK(paramString.Id);
        if ((localObject1 != null) && (((p)localObject1).dLV() != null))
        {
          Object localObject2 = ((p)localObject1).dLV().FQo.Etz;
          Object localObject3;
          Object localObject4;
          if ((((p)localObject1).Pe(32)) || (!ay.dPX()))
          {
            localObject3 = ((List)localObject2).iterator();
            if (((Iterator)localObject3).hasNext())
            {
              localObject4 = (btz)((Iterator)localObject3).next();
              if (((List)localObject2).size() <= 1) {}
              for (boolean bool = true;; bool = false)
              {
                a((btz)localObject4, bool);
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
              if ((((p)localObject1).field_type != 15) || (((p)localObject1).Pe(32))) {
                break label700;
              }
              af.dHP().x((p)localObject1);
              try
              {
                localObject1 = ((btz)((p)localObject1).dLV().FQo.Etz.get(0)).Url;
                com.tencent.mm.plugin.report.service.h.wUl.f(14388, new Object[] { Long.valueOf(paramString.Id), Integer.valueOf(4), localObject1, Integer.valueOf(0) });
              }
              catch (Exception paramString) {}
            }
            break;
            label335:
            int k = ((List)localObject2).size();
            if (1 == k)
            {
              localObject2 = (btz)((List)localObject2).get(0);
              ac.i("MicroMsg.NetSceneSnsPreTimeLine", "deal with single media, media type: %s.", new Object[] { Integer.valueOf(((btz)localObject2).ndI) });
              a((btz)localObject2, true);
            }
            else
            {
              localObject4 = new SparseArray();
              SparseArray localSparseArray = new SparseArray();
              int i = 0;
              if (i < k)
              {
                btz localbtz = (btz)((List)localObject2).get(i);
                if (6 == localbtz.ndI)
                {
                  ac.w("MicroMsg.NetSceneSnsPreTimeLine", "img batch download contains video, snsId: %s, mediaId: %s.", new Object[] { localObject3, localbtz.Id });
                  a(localbtz, false);
                }
                for (;;)
                {
                  i += 1;
                  break;
                  Object localObject5 = com.tencent.mm.plugin.sns.data.q.d(localbtz);
                  String str = an.jc(af.getAccSnsPath(), localbtz.Id);
                  if ((com.tencent.mm.vfs.i.eA(str + (String)localObject5)) || (com.tencent.mm.vfs.i.eA(str + com.tencent.mm.plugin.sns.data.q.k(localbtz))) || (com.tencent.mm.vfs.i.eA(str + com.tencent.mm.plugin.sns.data.q.l(localbtz)))) {
                    ac.i("MicroMsg.NetSceneSnsPreTimeLine", "mediaExist exist:%s.", new Object[] { localbtz.Id });
                  }
                  for (int j = 1;; j = 0)
                  {
                    if (j != 0) {
                      break label664;
                    }
                    localObject5 = new m(localbtz);
                    ((m)localObject5).xNy = 0;
                    ((m)localObject5).dlj = localbtz.Id;
                    localSparseArray.put(i, localObject5);
                    ((SparseArray)localObject4).put(i, localbtz);
                    break;
                  }
                }
              }
              if (((SparseArray)localObject4).size() > 0)
              {
                ac.i("MicroMsg.NetSceneSnsPreTimeLine", "deal with batch img.");
                af.dHM().a((String)localObject3, (SparseArray)localObject4, localSparseArray, bf.GYz, k);
              }
            }
          }
        }
      }
    }
    af.dHP().dIN();
    AppMethodBeat.o(95620);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
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
    ac.i("MicroMsg.NetSceneSnsPreTimeLine", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramArrayOfByte = (dbo)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    if ((paramq.getRespObj().getRetCode() != 207) && (paramq.getRespObj().getRetCode() != 0))
    {
      x.atJ("@__weixintimtline");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95621);
      return;
    }
    if (paramArrayOfByte.FJs != null)
    {
      ac.d("MicroMsg.NetSceneSnsPreTimeLine", "serverConfig  " + paramArrayOfByte.FJs.FKu + " " + paramArrayOfByte.FJs.FKt);
      paramInt1 = paramArrayOfByte.FJs.FKu;
      com.tencent.mm.plugin.sns.c.a.xMh = paramInt1;
      if (paramInt1 <= 0) {
        com.tencent.mm.plugin.sns.c.a.xMh = 2147483647;
      }
      com.tencent.mm.storage.ag.GDt = paramArrayOfByte.FJs.FKt;
    }
    this.xRr = paramArrayOfByte.FJq;
    this.xRs = paramArrayOfByte.FJr;
    ac.i("MicroMsg.NetSceneSnsPreTimeLine", "for same md5 count: " + paramArrayOfByte.FJq + " , objCount:  " + paramArrayOfByte.Fli + " cflag : " + paramArrayOfByte.FJr);
    this.ahX = paramArrayOfByte.Fli;
    String str = com.tencent.mm.plugin.sns.data.q.wX(0L);
    label534:
    long l1;
    Object localObject2;
    if (!paramArrayOfByte.DXh.isEmpty())
    {
      localObject1 = new StringBuilder("respone size ").append(paramArrayOfByte.DXh.size()).append(" Max ").append(((SnsObject)paramArrayOfByte.DXh.getFirst()).Id).append(" ").append(com.tencent.mm.plugin.sns.data.q.wW(((SnsObject)paramArrayOfByte.DXh.getFirst()).Id)).append("  respone min  ").append(((SnsObject)paramArrayOfByte.DXh.getLast()).Id).append(" ").append(com.tencent.mm.plugin.sns.data.q.wW(((SnsObject)paramArrayOfByte.DXh.getLast()).Id)).append(" adCount=");
      if (paramArrayOfByte.FKJ == null)
      {
        paramInt1 = 0;
        ac.i("MicroMsg.NetSceneSnsPreTimeLine", paramInt1);
        if (paramArrayOfByte.FKM <= 0) {
          break label780;
        }
        ac.i("MicroMsg.NetSceneSnsPreTimeLine", "%d ads to delete", new Object[] { Integer.valueOf(paramArrayOfByte.FKM) });
        if ((paramArrayOfByte.FKN == null) || (paramArrayOfByte.FKN.size() != paramArrayOfByte.FKM)) {
          break label780;
        }
        localObject1 = new LinkedList();
        paramInt1 = 0;
        if (paramInt1 >= paramArrayOfByte.FKM) {
          break label748;
        }
        l1 = ((aan)paramArrayOfByte.FKN.get(paramInt1)).Id;
        ac.i("MicroMsg.NetSceneSnsPreTimeLine", "delete ad %s", new Object[] { Long.valueOf(l1) });
        if (l1 != 0L)
        {
          localObject2 = af.dHU().xB(l1);
          if (localObject2 != null) {
            break label680;
          }
          ac.i("MicroMsg.NetSceneSnsPreTimeLine", "adSnsInfo is null!");
        }
      }
    }
    label680:
    Object localObject4;
    for (;;)
    {
      paramInt1 += 1;
      break label534;
      paramInt1 = paramArrayOfByte.FKJ.size();
      break;
      localObject1 = new StringBuilder(" respone is Empty, adCount=");
      if (paramArrayOfByte.FKJ == null) {}
      for (paramInt1 = 0;; paramInt1 = paramArrayOfByte.FKJ.size())
      {
        ac.i("MicroMsg.NetSceneSnsPreTimeLine", paramInt1);
        break;
      }
      localObject4 = new bx();
      ((bx)localObject4).DPl = 13298;
      ((bx)localObject4).DPm = new com.tencent.mm.bw.b(((com.tencent.mm.plugin.sns.storage.e)localObject2).dFQ().dtx.getBytes());
      ((bx)localObject4).sVY = (System.currentTimeMillis() / 1000L);
      ((LinkedList)localObject1).add(localObject4);
      a.wY(l1);
    }
    label748:
    if (((LinkedList)localObject1).size() > 0)
    {
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(new k((LinkedList)localObject1), 0);
    }
    label780:
    this.ahX = paramArrayOfByte.Fli;
    if (this.xRS.equals(paramArrayOfByte.FJm))
    {
      this.xRp = af.dHR().f(0L, this.xRr, true);
      ac.i("MicroMsg.NetSceneSnsPreTimeLine", "md5 is no change!! the new minid %s", new Object[] { Long.valueOf(this.xRp) });
      x.atJ("@__weixintimtline");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95621);
      return;
    }
    af.dHV().g("@__weixintimtline", paramArrayOfByte.FJm, z.a(paramArrayOfByte.FIP));
    ac.i("MicroMsg.NetSceneSnsPreTimeLine", "fp resp list size " + paramArrayOfByte.DXh.size() + " adsize : " + paramArrayOfByte.FKI);
    paramInt1 = 0;
    for (;;)
    {
      if (paramInt1 >= paramArrayOfByte.FKJ.size()) {
        break label1374;
      }
      localObject1 = (di)paramArrayOfByte.FKJ.get(paramInt1);
      localObject4 = new StringBuilder();
      if ((localObject1 != null) && (((di)localObject1).DQp != null)) {
        ((StringBuilder)localObject4).append(z.a(((di)localObject1).DQp));
      }
      localObject2 = new StringBuilder();
      StringBuilder localStringBuilder = new StringBuilder();
      if ((localObject1 != null) && (((di)localObject1).DQo != null))
      {
        ((StringBuilder)localObject2).append(z.a(((di)localObject1).DQo.FIO));
        localStringBuilder.append(z.b(((di)localObject1).DQo.FIN.ObjectDesc));
      }
      ac.i("MicroMsg.NetSceneSnsPreTimeLine", "skXml " + ((StringBuilder)localObject4).toString());
      ac.i("MicroMsg.NetSceneSnsPreTimeLine", "adXml " + ((StringBuilder)localObject2).toString());
      ac.i("MicroMsg.NetSceneSnsPreTimeLine", "snsXml " + localStringBuilder.toString() + "\r\n");
      com.tencent.mm.plugin.sns.waid.g.awf(((StringBuilder)localObject4).toString());
      try
      {
        localObject4 = ((StringBuilder)localObject4).toString();
        localObject2 = ((StringBuilder)localObject2).toString();
        if (!bs.T(new String[] { localObject4, localObject2 }))
        {
          long l2 = 0L;
          l1 = l2;
          if (localObject1 != null)
          {
            l1 = l2;
            if (((di)localObject1).DQo != null)
            {
              l1 = l2;
              if (((di)localObject1).DQo.FIN != null) {
                l1 = bs.g(Long.valueOf(((di)localObject1).DQo.FIN.Id));
              }
            }
          }
          com.tencent.mm.plugin.sns.data.h.d(l1, (String)localObject4, (String)localObject2);
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ac.e("MicroMsg.NetSceneSnsPreTimeLine", "reportAdPullException: " + localThrowable.toString());
        }
      }
      localObject2 = ((di)localObject1).DQo.FIN.Username;
      if (!bs.isNullOrNil((String)localObject2))
      {
        ac.i("MicroMsg.NetSceneSnsPreTimeLine", "checkUpdate contact:".concat(String.valueOf(localObject2)));
        ar.a.hnw.aJ((String)localObject2, "");
        com.tencent.e.h.JZN.q(new s.1(this, (String)localObject2), 10000L);
      }
      com.tencent.mm.plugin.sns.ad.timeline.a.a.a((di)localObject1);
      paramInt1 += 1;
    }
    label1374:
    a.x(paramArrayOfByte.FKJ, paramArrayOfByte.DXh);
    a.aQ(paramArrayOfByte.FKJ);
    if (paramArrayOfByte.FKI == 0)
    {
      ac.i("MicroMsg.NetSceneSnsPreTimeLine", "recv %d recommend", new Object[] { Integer.valueOf(paramArrayOfByte.FKK) });
      a.e(paramArrayOfByte.FKL, paramArrayOfByte.DXh);
      a.aP(paramArrayOfByte.FKL);
    }
    Object localObject1 = new LinkedList();
    Object localObject3 = paramArrayOfByte.DXh.iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((LinkedList)localObject1).add(Long.valueOf(((SnsObject)((Iterator)localObject3).next()).Id));
    }
    localObject3 = new uk();
    ((uk)localObject3).dxc.dxd = ((LinkedList)localObject1);
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject3);
    if (paramq.getRespObj().getRetCode() == 207)
    {
      if (paramArrayOfByte.DXh.isEmpty()) {
        af.dHR().dML();
      }
      for (;;)
      {
        x.atJ("@__weixintimtline");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95621);
        return;
        af.dHR().avb(com.tencent.mm.plugin.sns.data.q.wX(((SnsObject)paramArrayOfByte.DXh.getFirst()).Id));
        af.dHR().ava(com.tencent.mm.plugin.sns.data.q.wX(((SnsObject)paramArrayOfByte.DXh.getLast()).Id));
        a(paramArrayOfByte, str);
        a.aR(paramArrayOfByte.DXh);
      }
    }
    if (paramArrayOfByte.DXh.isEmpty()) {
      af.dHR().dML();
    }
    for (;;)
    {
      x.atJ("@__weixintimtline");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95621);
      return;
      a(paramArrayOfByte, str);
      a.aR(paramArrayOfByte.DXh);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.s
 * JD-Core Version:    0.7.0.1
 */