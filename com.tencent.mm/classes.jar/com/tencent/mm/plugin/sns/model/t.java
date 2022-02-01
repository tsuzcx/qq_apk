package com.tencent.mm.plugin.sns.model;

import android.util.SparseArray;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.g.a.vh;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.network.e;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.bb;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.dfw;
import com.tencent.mm.protocal.protobuf.dhk;
import com.tencent.mm.protocal.protobuf.dhu;
import com.tencent.mm.protocal.protobuf.dhv;
import com.tencent.mm.protocal.protobuf.dj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bk;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class t
  extends com.tencent.mm.ak.n
  implements com.tencent.mm.network.k
{
  public int ajO;
  public f callback;
  private com.tencent.mm.ak.b rr;
  final int sourceType;
  private long zxY;
  private long zyA;
  private String zyB;
  public int zya;
  public int zyb;
  
  public t()
  {
    AppMethodBeat.i(95619);
    this.zxY = 0L;
    this.zyA = 0L;
    this.zyB = "";
    this.zya = 0;
    this.zyb = 0;
    this.ajO = 0;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dhu();
    ((b.a)localObject).hQG = new dhv();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnspreloadingtimeline";
    ((b.a)localObject).funcId = 718;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    int i;
    if (az.isWifi(ak.getContext())) {
      i = 1;
    }
    for (;;)
    {
      this.sourceType = 2;
      dhu localdhu = (dhu)this.rr.hQD.hQJ;
      localdhu.HNc = i;
      localdhu.HNy = 0L;
      int j = ah.dXu().dYi();
      this.zxY = ah.dXE().f(0L, j, true);
      localdhu.HOJ = this.zxY;
      int k = d.a(this.zxY, 0L, "@__weixintimtline");
      localdhu.HOK = k;
      this.zyA = ah.dXE().f(0L, 1, true);
      ae.i("MicroMsg.NetSceneSnsPreTimeLine", "newerid " + this.zyA);
      localdhu.HOL = this.zyA;
      com.tencent.mm.plugin.sns.storage.n localn = ah.dXI().aBw("@__weixintimtline");
      if (localn == null)
      {
        localObject = "";
        label263:
        this.zyB = ((String)localObject);
        if (this.zyB == null) {
          this.zyB = "";
        }
        localdhu.HNx = this.zyB;
        if ((localn != null) && (localn.field_adsession != null)) {
          break label463;
        }
      }
      for (localdhu.HNa = new SKBuiltinBuffer_t().setBuffer(new byte[0]);; localdhu.HNa = new SKBuiltinBuffer_t().setBuffer(localn.field_adsession))
      {
        ae.i("MicroMsg.NetSceneSnsPreTimeLine", " This req nextCount: " + j + " min:" + this.zxY + " ReqTime:" + localdhu.HOK + " nettype: " + i);
        ae.d("MicroMsg.NetSceneSnsPreTimeLine", "minId: %s lastReqTime: %s", new Object[] { r.zV(this.zxY), Integer.valueOf(k) });
        AppMethodBeat.o(95619);
        return;
        if (az.is3G(ak.getContext()))
        {
          i = 3;
          break;
        }
        if (az.is4G(ak.getContext()))
        {
          i = 4;
          break;
        }
        if (!az.is2G(ak.getContext())) {
          break label505;
        }
        i = 2;
        break;
        localObject = localn.field_md5;
        break label263;
        label463:
        ae.d("MicroMsg.NetSceneSnsPreTimeLine", "request adsession %s", new Object[] { localn.field_adsession });
      }
      label505:
      i = 0;
    }
  }
  
  private static void a(bzh parambzh, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(95623);
    if (parambzh == null)
    {
      AppMethodBeat.o(95623);
      return;
    }
    Object localObject1 = r.d(parambzh);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localObject2 = ap.jv(ah.getAccSnsPath(), parambzh.Id);
      if ((!com.tencent.mm.vfs.o.fB((String)localObject2 + (String)localObject1)) && (!com.tencent.mm.vfs.o.fB((String)localObject2 + r.k(parambzh))) && (!com.tencent.mm.vfs.o.fB((String)localObject2 + r.l(parambzh)))) {
        break;
      }
      ae.i("MicroMsg.NetSceneSnsPreTimeLine", "dealwithMedia exist:%s", new Object[] { parambzh.Id });
      AppMethodBeat.o(95623);
      return;
    }
    ae.i("MicroMsg.NetSceneSnsPreTimeLine", "dealwithMedia ready to download:%s", new Object[] { parambzh.Id });
    localObject1 = new com.tencent.mm.plugin.sns.data.n(parambzh);
    ((com.tencent.mm.plugin.sns.data.n)localObject1).zui = i;
    ((com.tencent.mm.plugin.sns.data.n)localObject1).dyb = parambzh.Id;
    Object localObject2 = ah.dXz();
    i = j;
    if (parambzh.nJA == 6) {
      i = 5;
    }
    ((c)localObject2).a(parambzh, i, (com.tencent.mm.plugin.sns.data.n)localObject1, bk.Jgu);
    AppMethodBeat.o(95623);
  }
  
  private void a(dhv paramdhv, String paramString)
  {
    AppMethodBeat.i(95620);
    al.b("@__weixintimtline", this.sourceType, paramdhv.FUY, paramString);
    this.zxY = ((SnsObject)paramdhv.FUY.getLast()).Id;
    d.f("@__weixintimtline", ((SnsObject)paramdhv.FUY.getFirst()).Id, this.zxY, paramdhv.HOS);
    paramdhv = paramdhv.FUY.iterator();
    label672:
    label708:
    while (paramdhv.hasNext())
    {
      paramString = (SnsObject)paramdhv.next();
      if (paramString.NoChange == 0)
      {
        Object localObject1 = ah.dXE().AG(paramString.Id);
        if ((localObject1 != null) && (((p)localObject1).ebP() != null))
        {
          Object localObject2 = ((p)localObject1).ebP().HUG.Gtx;
          Object localObject3;
          Object localObject4;
          if ((((p)localObject1).Rt(32)) || (!bb.efV()))
          {
            localObject3 = ((List)localObject2).iterator();
            if (((Iterator)localObject3).hasNext())
            {
              localObject4 = (bzh)((Iterator)localObject3).next();
              if (((List)localObject2).size() <= 1) {}
              for (boolean bool = true;; bool = false)
              {
                a((bzh)localObject4, bool);
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
              if ((((p)localObject1).field_type != 15) || ((((p)localObject1).Rt(32)) && (!com.tencent.mm.plugin.sns.ad.timeline.a.a.j((p)localObject1)))) {
                break label708;
              }
              ah.dXC().z((p)localObject1);
              try
              {
                localObject1 = ((bzh)((p)localObject1).ebP().HUG.Gtx.get(0)).Url;
                g.yxI.f(14388, new Object[] { Long.valueOf(paramString.Id), Integer.valueOf(4), localObject1, Integer.valueOf(0) });
              }
              catch (Exception paramString) {}
            }
            break;
            label343:
            int k = ((List)localObject2).size();
            if (1 == k)
            {
              localObject2 = (bzh)((List)localObject2).get(0);
              ae.i("MicroMsg.NetSceneSnsPreTimeLine", "deal with single media, media type: %s.", new Object[] { Integer.valueOf(((bzh)localObject2).nJA) });
              a((bzh)localObject2, true);
            }
            else
            {
              localObject4 = new SparseArray();
              SparseArray localSparseArray = new SparseArray();
              int i = 0;
              if (i < k)
              {
                bzh localbzh = (bzh)((List)localObject2).get(i);
                if (6 == localbzh.nJA)
                {
                  ae.w("MicroMsg.NetSceneSnsPreTimeLine", "img batch download contains video, snsId: %s, mediaId: %s.", new Object[] { localObject3, localbzh.Id });
                  a(localbzh, false);
                }
                for (;;)
                {
                  i += 1;
                  break;
                  Object localObject5 = r.d(localbzh);
                  String str = ap.jv(ah.getAccSnsPath(), localbzh.Id);
                  if ((com.tencent.mm.vfs.o.fB(str + (String)localObject5)) || (com.tencent.mm.vfs.o.fB(str + r.k(localbzh))) || (com.tencent.mm.vfs.o.fB(str + r.l(localbzh)))) {
                    ae.i("MicroMsg.NetSceneSnsPreTimeLine", "mediaExist exist:%s.", new Object[] { localbzh.Id });
                  }
                  for (int j = 1;; j = 0)
                  {
                    if (j != 0) {
                      break label672;
                    }
                    localObject5 = new com.tencent.mm.plugin.sns.data.n(localbzh);
                    ((com.tencent.mm.plugin.sns.data.n)localObject5).zui = 0;
                    ((com.tencent.mm.plugin.sns.data.n)localObject5).dyb = localbzh.Id;
                    localSparseArray.put(i, localObject5);
                    ((SparseArray)localObject4).put(i, localbzh);
                    break;
                  }
                }
              }
              if (((SparseArray)localObject4).size() > 0)
              {
                ae.i("MicroMsg.NetSceneSnsPreTimeLine", "deal with batch img.");
                ah.dXz().a((String)localObject3, (SparseArray)localObject4, localSparseArray, bk.Jgu, k);
              }
            }
          }
        }
      }
    }
    ah.dXC().dYA();
    AppMethodBeat.o(95620);
  }
  
  public final int doScene(e parame, f paramf)
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
    ae.i("MicroMsg.NetSceneSnsPreTimeLine", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    dhv localdhv = (dhv)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    if ((paramq.getRespObj().getRetCode() != 207) && (paramq.getRespObj().getRetCode() != 0))
    {
      y.aAf("@__weixintimtline");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95621);
      return;
    }
    if (localdhv.HND != null)
    {
      ae.d("MicroMsg.NetSceneSnsPreTimeLine", "serverConfig  " + localdhv.HND.HOF + " " + localdhv.HND.HOE);
      paramInt1 = localdhv.HND.HOF;
      com.tencent.mm.plugin.sns.c.a.zsC = paramInt1;
      if (paramInt1 <= 0) {
        com.tencent.mm.plugin.sns.c.a.zsC = 2147483647;
      }
      com.tencent.mm.storage.al.IKg = localdhv.HND.HOE;
    }
    this.zya = localdhv.HNB;
    this.zyb = localdhv.HNC;
    ae.i("MicroMsg.NetSceneSnsPreTimeLine", "for same md5 count: " + localdhv.HNB + " , objCount:  " + localdhv.Hor + " cflag : " + localdhv.HNC);
    this.ajO = localdhv.Hor;
    String str = r.zW(0L);
    if (!localdhv.FUY.isEmpty())
    {
      paramArrayOfByte = new StringBuilder("respone size ").append(localdhv.FUY.size()).append(" Max ").append(((SnsObject)localdhv.FUY.getFirst()).Id).append(" ").append(r.zV(((SnsObject)localdhv.FUY.getFirst()).Id)).append("  respone min  ").append(((SnsObject)localdhv.FUY.getLast()).Id).append(" ").append(r.zV(((SnsObject)localdhv.FUY.getLast()).Id)).append(" adCount=");
      if (localdhv.HOU == null) {}
      for (paramInt1 = 0;; paramInt1 = localdhv.HOU.size())
      {
        ae.i("MicroMsg.NetSceneSnsPreTimeLine", paramInt1);
        com.tencent.mm.plugin.sns.ad.c.b.c(localdhv.HOY, localdhv.HOX, 1);
        this.ajO = localdhv.Hor;
        if (!this.zyB.equals(localdhv.HNx)) {
          break;
        }
        this.zxY = ah.dXE().f(0L, this.zya, true);
        ae.i("MicroMsg.NetSceneSnsPreTimeLine", "md5 is no change!! the new minid %s", new Object[] { Long.valueOf(this.zxY) });
        y.aAf("@__weixintimtline");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95621);
        return;
      }
    }
    paramArrayOfByte = new StringBuilder(" respone is Empty, adCount=");
    if (localdhv.HOU == null) {}
    for (paramInt1 = 0;; paramInt1 = localdhv.HOU.size())
    {
      ae.i("MicroMsg.NetSceneSnsPreTimeLine", paramInt1);
      break;
    }
    ah.dXI().g("@__weixintimtline", localdhv.HNx, z.a(localdhv.HNa));
    ae.i("MicroMsg.NetSceneSnsPreTimeLine", "fp resp list size " + localdhv.FUY.size() + " adsize : " + localdhv.HOT);
    paramInt1 = 0;
    long l2;
    for (;;)
    {
      if (paramInt1 >= localdhv.HOU.size()) {
        break label1255;
      }
      dj localdj = (dj)localdhv.HOU.get(paramInt1);
      Object localObject4 = new StringBuilder();
      if ((localdj != null) && (localdj.FOc != null)) {
        ((StringBuilder)localObject4).append(z.a(localdj.FOc));
      }
      Object localObject3 = new StringBuilder();
      paramArrayOfByte = new StringBuilder();
      if ((localdj != null) && (localdj.FOb != null))
      {
        ((StringBuilder)localObject3).append(z.a(localdj.FOb.HMZ));
        paramArrayOfByte.append(z.b(localdj.FOb.HMY.ObjectDesc));
      }
      ae.i("MicroMsg.NetSceneSnsPreTimeLine", "skXml " + ((StringBuilder)localObject4).toString());
      ae.i("MicroMsg.NetSceneSnsPreTimeLine", "adXml " + ((StringBuilder)localObject3).toString());
      ae.i("MicroMsg.NetSceneSnsPreTimeLine", "snsXml " + paramArrayOfByte.toString() + "\r\n");
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
        if (!bu.V(new String[] { localObject4, localObject3 }))
        {
          l1 = l3;
          if (localdj != null)
          {
            l1 = l3;
            paramArrayOfByte = (byte[])localObject3;
            l2 = l3;
            if (localdj.FOb != null)
            {
              l1 = l3;
              paramArrayOfByte = (byte[])localObject3;
              l2 = l3;
              if (localdj.FOb.HMY != null)
              {
                paramArrayOfByte = (byte[])localObject3;
                l2 = l3;
                l1 = bu.i(Long.valueOf(localdj.FOb.HMY.Id));
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
          ae.e("MicroMsg.NetSceneSnsPreTimeLine", "reportAdPullException: " + localThrowable.toString());
          localObject2 = paramArrayOfByte;
          long l1 = l2;
        }
      }
      paramArrayOfByte = localdj.FOb.HMY.Username;
      if (!bu.isNullOrNil(paramArrayOfByte))
      {
        bool = com.tencent.mm.plugin.sns.data.k.azh((String)localObject1);
        ae.i("MicroMsg.NetSceneSnsPreTimeLine", "checkUpdate contact:" + paramArrayOfByte + ", isUsePreferedInfo=" + bool + ", snsId=" + r.zW(l1));
        if (!bool)
        {
          au.a.hIG.aJ(paramArrayOfByte, "");
          h.MqF.r(new t.1(this, paramArrayOfByte), 10000L);
        }
      }
      com.tencent.mm.plugin.sns.ad.timeline.a.d.a(localdj);
      paramInt1 += 1;
    }
    label1255:
    a.a(localdhv.HOU, localdhv.FUY, false, -1);
    a.aS(localdhv.HOU);
    if (localdhv.HOT == 0)
    {
      ae.i("MicroMsg.NetSceneSnsPreTimeLine", "recv %d recommend", new Object[] { Integer.valueOf(localdhv.HOV) });
      a.e(localdhv.HOW, localdhv.FUY);
      a.aR(localdhv.HOW);
    }
    paramArrayOfByte = new LinkedList();
    Object localObject2 = localdhv.FUY.iterator();
    while (((Iterator)localObject2).hasNext()) {
      paramArrayOfByte.add(Long.valueOf(((SnsObject)((Iterator)localObject2).next()).Id));
    }
    localObject2 = new vh();
    ((vh)localObject2).dKC.dKD = paramArrayOfByte;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
    if (paramq.getRespObj().getRetCode() == 207)
    {
      if (localdhv.FUY.isEmpty()) {
        ah.dXE().ecF();
      }
      for (;;)
      {
        y.aAf("@__weixintimtline");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95621);
        return;
        ah.dXE().aBz(r.zW(((SnsObject)localdhv.FUY.getFirst()).Id));
        ah.dXE().aBy(r.zW(((SnsObject)localdhv.FUY.getLast()).Id));
        a(localdhv, str);
        a.aT(localdhv.FUY);
      }
    }
    if (localdhv.FUY.isEmpty()) {
      ah.dXE().ecF();
    }
    for (;;)
    {
      y.aAf("@__weixintimtline");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95621);
      return;
      a(localdhv, str);
      a.aT(localdhv.FUY);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.t
 * JD-Core Version:    0.7.0.1
 */