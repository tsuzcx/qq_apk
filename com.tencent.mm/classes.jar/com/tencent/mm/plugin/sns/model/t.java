package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.sg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.bp;
import com.tencent.mm.protocal.protobuf.cdh;
import com.tencent.mm.protocal.protobuf.ceu;
import com.tencent.mm.protocal.protobuf.cfe;
import com.tencent.mm.protocal.protobuf.cff;
import com.tencent.mm.protocal.protobuf.cy;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.protocal.protobuf.wj;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class t
  extends com.tencent.mm.ai.m
  implements k
{
  public int ZY;
  public com.tencent.mm.ai.f callback;
  final int cpG;
  public int reA;
  public int reB;
  private long reZ;
  private long rey;
  private String rfa;
  private com.tencent.mm.ai.b rr;
  
  public t()
  {
    AppMethodBeat.i(36295);
    this.rey = 0L;
    this.reZ = 0L;
    this.rfa = "";
    this.reA = 0;
    this.reB = 0;
    this.ZY = 0;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cfe();
    ((b.a)localObject).fsY = new cff();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnspreloadingtimeline";
    ((b.a)localObject).funcId = 718;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    int i;
    if (at.isWifi(ah.getContext())) {
      i = 1;
    }
    for (;;)
    {
      this.cpG = 2;
      cfe localcfe = (cfe)this.rr.fsV.fta;
      localcfe.xNQ = i;
      localcfe.xOl = 0L;
      int j = ag.coV().cpD();
      this.rey = ag.cpf().g(0L, j, true);
      localcfe.xPt = this.rey;
      int k = c.a(this.rey, 0L, "@__weixintimtline");
      localcfe.xPu = k;
      this.reZ = ag.cpf().g(0L, 1, true);
      ab.i("MicroMsg.NetSceneSnsPreTimeLine", "newerid " + this.reZ);
      localcfe.xPv = this.reZ;
      com.tencent.mm.plugin.sns.storage.l locall = ag.cpj().abz("@__weixintimtline");
      if (locall == null)
      {
        localObject = "";
        label263:
        this.rfa = ((String)localObject);
        if (this.rfa == null) {
          this.rfa = "";
        }
        localcfe.xOk = this.rfa;
        if ((locall != null) && (locall.field_adsession != null)) {
          break label463;
        }
      }
      for (localcfe.xNO = new SKBuiltinBuffer_t().setBuffer(new byte[0]);; localcfe.xNO = new SKBuiltinBuffer_t().setBuffer(locall.field_adsession))
      {
        ab.i("MicroMsg.NetSceneSnsPreTimeLine", " This req nextCount: " + j + " min:" + this.rey + " ReqTime:" + localcfe.xPu + " nettype: " + i);
        ab.d("MicroMsg.NetSceneSnsPreTimeLine", "minId: %s lastReqTime: %s", new Object[] { i.lq(this.rey), Integer.valueOf(k) });
        AppMethodBeat.o(36295);
        return;
        if (at.is3G(ah.getContext()))
        {
          i = 3;
          break;
        }
        if (at.is4G(ah.getContext()))
        {
          i = 4;
          break;
        }
        if (!at.is2G(ah.getContext())) {
          break label505;
        }
        i = 2;
        break;
        localObject = locall.field_md5;
        break label263;
        label463:
        ab.d("MicroMsg.NetSceneSnsPreTimeLine", "request adsession %s", new Object[] { locall.field_adsession });
      }
      label505:
      i = 0;
    }
  }
  
  private void a(cff paramcff, String paramString)
  {
    AppMethodBeat.i(36296);
    ak.b("@__weixintimtline", this.cpG, paramcff.wuP, paramString);
    this.rey = ((SnsObject)paramcff.wuP.getLast()).Id;
    c.f("@__weixintimtline", ((SnsObject)paramcff.wuP.getFirst()).Id, this.rey, paramcff.xPz);
    paramcff = paramcff.wuP.iterator();
    while (paramcff.hasNext())
    {
      paramString = (SnsObject)paramcff.next();
      if (paramString.NoChange == 0)
      {
        Object localObject1 = ag.cpf().lZ(paramString.Id);
        if ((localObject1 != null) && (((n)localObject1).csh() != null))
        {
          ??? = ((n)localObject1).csh().xTS.wOa;
          Object localObject2 = ???.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            bcs localbcs = (bcs)((Iterator)localObject2).next();
            if (???.size() <= 1)
            {
              i = 1;
              label179:
              if (localbcs == null) {
                break label320;
              }
              localObject3 = i.e(localbcs);
              if (i == 0) {
                break label322;
              }
            }
            label320:
            label322:
            for (int i = 1;; i = 0)
            {
              localObject4 = ao.gl(ag.getAccSnsPath(), localbcs.Id);
              if ((!com.tencent.mm.vfs.e.cN((String)localObject4 + (String)localObject3)) && (!com.tencent.mm.vfs.e.cN((String)localObject4 + i.l(localbcs))) && (!com.tencent.mm.vfs.e.cN((String)localObject4 + i.m(localbcs)))) {
                break label327;
              }
              ab.i("MicroMsg.NetSceneSnsPreTimeLine", "dealwithMedia exist:%s", new Object[] { localbcs.Id });
              break;
              i = 0;
              break label179;
              break;
            }
            label327:
            ab.i("MicroMsg.NetSceneSnsPreTimeLine", "dealwithMedia ready to download:%s", new Object[] { localbcs.Id });
            Object localObject3 = new com.tencent.mm.plugin.sns.data.e(localbcs);
            ((com.tencent.mm.plugin.sns.data.e)localObject3).rbj = i;
            ((com.tencent.mm.plugin.sns.data.e)localObject3).ohe = localbcs.Id;
            Object localObject4 = ag.cpa();
            if (localbcs.jKs == 6) {}
            for (i = 5;; i = 1)
            {
              ((b)localObject4).a(localbcs, i, (com.tencent.mm.plugin.sns.data.e)localObject3, az.yNM);
              break;
            }
          }
          if (((n)localObject1).field_type == 15)
          {
            localObject2 = ag.cpd();
            if (localObject1 != null) {
              ab.i("MicroMsg.SnsVideoService", "%d add preload video[%s]", new Object[] { Integer.valueOf(localObject2.hashCode()), ((n)localObject1).csH() });
            }
            synchronized (((as)localObject2).riE)
            {
              ((as)localObject2).riE.addFirst(localObject1);
              try
              {
                localObject1 = ((bcs)((n)localObject1).csh().xTS.wOa.get(0)).Url;
                h.qsU.e(14388, new Object[] { Long.valueOf(paramString.Id), Integer.valueOf(4), localObject1, Integer.valueOf(0) });
              }
              catch (Exception paramString) {}
            }
          }
        }
      }
    }
    ag.cpd().cpJ();
    AppMethodBeat.o(36296);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(36298);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(36298);
    return i;
  }
  
  public final int getType()
  {
    return 718;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(36297);
    ab.i("MicroMsg.NetSceneSnsPreTimeLine", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramArrayOfByte = (cff)((com.tencent.mm.ai.b)paramq).fsW.fta;
    if ((paramq.getRespObj().getRetCode() != 207) && (paramq.getRespObj().getRetCode() != 0))
    {
      y.aao("@__weixintimtline");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(36297);
      return;
    }
    if (paramArrayOfByte.xOq != null)
    {
      ab.d("MicroMsg.NetSceneSnsPreTimeLine", "serverConfig  " + paramArrayOfByte.xOq.xPp + " " + paramArrayOfByte.xOq.xPo);
      paramInt1 = paramArrayOfByte.xOq.xPp;
      com.tencent.mm.plugin.sns.c.a.raX = paramInt1;
      if (paramInt1 <= 0) {
        com.tencent.mm.plugin.sns.c.a.raX = 2147483647;
      }
      com.tencent.mm.storage.ab.yxn = paramArrayOfByte.xOq.xPo;
    }
    this.reA = paramArrayOfByte.xOo;
    this.reB = paramArrayOfByte.xOp;
    ab.i("MicroMsg.NetSceneSnsPreTimeLine", "for same md5 count: " + paramArrayOfByte.xOo + " , objCount:  " + paramArrayOfByte.xtO + " cflag : " + paramArrayOfByte.xOp);
    this.ZY = paramArrayOfByte.xtO;
    String str1 = i.lr(0L);
    label534:
    long l;
    if (!paramArrayOfByte.wuP.isEmpty())
    {
      localObject1 = new StringBuilder("respone size ").append(paramArrayOfByte.wuP.size()).append(" Max ").append(((SnsObject)paramArrayOfByte.wuP.getFirst()).Id).append(" ").append(i.lq(((SnsObject)paramArrayOfByte.wuP.getFirst()).Id)).append("  respone min  ").append(((SnsObject)paramArrayOfByte.wuP.getLast()).Id).append(" ").append(i.lq(((SnsObject)paramArrayOfByte.wuP.getLast()).Id)).append(" adCount=");
      if (paramArrayOfByte.xPB == null)
      {
        paramInt1 = 0;
        ab.i("MicroMsg.NetSceneSnsPreTimeLine", paramInt1);
        if (paramArrayOfByte.xPE <= 0) {
          break label780;
        }
        ab.i("MicroMsg.NetSceneSnsPreTimeLine", "%d ads to delete", new Object[] { Integer.valueOf(paramArrayOfByte.xPE) });
        if ((paramArrayOfByte.xPF == null) || (paramArrayOfByte.xPF.size() != paramArrayOfByte.xPE)) {
          break label780;
        }
        localObject1 = new LinkedList();
        paramInt1 = 0;
        if (paramInt1 >= paramArrayOfByte.xPE) {
          break label748;
        }
        l = ((wj)paramArrayOfByte.xPF.get(paramInt1)).Id;
        ab.i("MicroMsg.NetSceneSnsPreTimeLine", "delete ad %s", new Object[] { Long.valueOf(l) });
        if (l != 0L)
        {
          localObject2 = ag.cpi().lQ(l);
          if (localObject2 != null) {
            break label680;
          }
          ab.i("MicroMsg.NetSceneSnsPreTimeLine", "adSnsInfo is null!");
        }
      }
    }
    label680:
    Object localObject3;
    for (;;)
    {
      paramInt1 += 1;
      break label534;
      paramInt1 = paramArrayOfByte.xPB.size();
      break;
      localObject1 = new StringBuilder(" respone is Empty, adCount=");
      if (paramArrayOfByte.xPB == null) {}
      for (paramInt1 = 0;; paramInt1 = paramArrayOfByte.xPB.size())
      {
        ab.i("MicroMsg.NetSceneSnsPreTimeLine", paramInt1);
        break;
      }
      localObject3 = new bp();
      ((bp)localObject3).wog = 13298;
      ((bp)localObject3).woh = new com.tencent.mm.bv.b(((com.tencent.mm.plugin.sns.storage.e)localObject2).csd().cFe.getBytes());
      ((bp)localObject3).woi = (System.currentTimeMillis() / 1000L);
      ((LinkedList)localObject1).add(localObject3);
      a.lt(l);
    }
    label748:
    if (((LinkedList)localObject1).size() > 0)
    {
      g.RM();
      g.RK().eHt.a(new l((LinkedList)localObject1), 0);
    }
    label780:
    this.ZY = paramArrayOfByte.xtO;
    if (this.rfa.equals(paramArrayOfByte.xOk))
    {
      this.rey = ag.cpf().g(0L, this.reA, true);
      ab.i("MicroMsg.NetSceneSnsPreTimeLine", "md5 is no change!! the new minid %s", new Object[] { Long.valueOf(this.rey) });
      y.aao("@__weixintimtline");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(36297);
      return;
    }
    ag.cpj().h("@__weixintimtline", paramArrayOfByte.xOk, aa.a(paramArrayOfByte.xNO));
    ab.i("MicroMsg.NetSceneSnsPreTimeLine", "fp resp list size " + paramArrayOfByte.wuP.size() + " adsize : " + paramArrayOfByte.xPA);
    paramInt1 = 0;
    while (paramInt1 < paramArrayOfByte.xPB.size())
    {
      localObject1 = (cy)paramArrayOfByte.xPB.get(paramInt1);
      localObject2 = aa.a(((cy)localObject1).wpm);
      localObject3 = aa.a(((cy)localObject1).wpl.xNN);
      String str2 = aa.b(((cy)localObject1).wpl.xNM.ObjectDesc);
      ab.i("MicroMsg.NetSceneSnsPreTimeLine", "skXml ".concat(String.valueOf(localObject2)));
      ab.i("MicroMsg.NetSceneSnsPreTimeLine", "adXml ".concat(String.valueOf(localObject3)));
      ab.i("MicroMsg.NetSceneSnsPreTimeLine", "snsXml " + str2 + "\r\n");
      localObject1 = ((cy)localObject1).wpl.xNM.Username;
      if (!bo.isNullOrNil((String)localObject1))
      {
        ab.i("MicroMsg.NetSceneSnsPreTimeLine", "checkUpdate contact:".concat(String.valueOf(localObject1)));
        ao.a.flI.am((String)localObject1, "");
        d.ysm.r(new t.1(this, (String)localObject1), 10000L);
      }
      paramInt1 += 1;
    }
    a.l(paramArrayOfByte.xPB, paramArrayOfByte.wuP);
    a.as(paramArrayOfByte.xPB);
    if (paramArrayOfByte.xPA == 0)
    {
      ab.i("MicroMsg.NetSceneSnsPreTimeLine", "recv %d recommend", new Object[] { Integer.valueOf(paramArrayOfByte.xPC) });
      a.e(paramArrayOfByte.xPD, paramArrayOfByte.wuP);
      a.ar(paramArrayOfByte.xPD);
    }
    Object localObject1 = new LinkedList();
    Object localObject2 = paramArrayOfByte.wuP.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).add(Long.valueOf(((SnsObject)((Iterator)localObject2).next()).Id));
    }
    localObject2 = new sg();
    ((sg)localObject2).cIA.cIB = ((LinkedList)localObject1);
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject2);
    if (paramq.getRespObj().getRetCode() == 207)
    {
      if (paramArrayOfByte.wuP.isEmpty()) {
        ag.cpf().csX();
      }
      for (;;)
      {
        y.aao("@__weixintimtline");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(36297);
        return;
        ag.cpf().abB(i.lr(((SnsObject)paramArrayOfByte.wuP.getFirst()).Id));
        ag.cpf().abA(i.lr(((SnsObject)paramArrayOfByte.wuP.getLast()).Id));
        a(paramArrayOfByte, str1);
        a.at(paramArrayOfByte.wuP);
      }
    }
    if (paramArrayOfByte.wuP.isEmpty()) {
      ag.cpf().csX();
    }
    for (;;)
    {
      y.aao("@__weixintimtline");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(36297);
      return;
      a(paramArrayOfByte, str1);
      a.at(paramArrayOfByte.wuP);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.t
 * JD-Core Version:    0.7.0.1
 */