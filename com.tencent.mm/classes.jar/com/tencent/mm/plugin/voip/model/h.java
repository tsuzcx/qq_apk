package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.s;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.protocal.protobuf.byy;
import com.tencent.mm.protocal.protobuf.byz;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.czv;
import com.tencent.mm.protocal.protobuf.czw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public final class h
  extends n
  implements k
{
  private static final Set<Long> BYw;
  private static final List<Object> ifa;
  private f callback;
  private final List<bu> ifb;
  private long msgId;
  private b rr;
  
  static
  {
    AppMethodBeat.i(114860);
    ifa = new ArrayList();
    BYw = new HashSet();
    AppMethodBeat.o(114860);
  }
  
  public h()
  {
    AppMethodBeat.i(114854);
    this.ifb = new LinkedList();
    ad.d("MicroMsg.NetSceneSendMsg", "dktext :" + bt.flS());
    ad.i("MicroMsg.NetSceneSendMsg", "empty msg sender created");
    AppMethodBeat.o(114854);
  }
  
  public h(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(114853);
    this.ifb = new LinkedList();
    ad.d("MicroMsg.NetSceneSendMsg", "dktext :" + bt.flS());
    if (!bt.isNullOrNil(paramString1))
    {
      bu localbu = new bu();
      localbu.setStatus(1);
      localbu.tN(paramString1);
      localbu.qA(bj.Bo(paramString1));
      localbu.kr(1);
      localbu.setContent(paramString2);
      localbu.setType(paramInt);
      this.msgId = ((l)g.ab(l.class)).dlK().as(localbu);
      if (this.msgId == -1L) {
        break label171;
      }
    }
    label171:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ad.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.msgId);
      AppMethodBeat.o(114853);
      return;
    }
  }
  
  private void aJp()
  {
    AppMethodBeat.i(114858);
    int i = 0;
    while (i < this.ifb.size())
    {
      pL(i);
      i += 1;
    }
    AppMethodBeat.o(114858);
  }
  
  private void pL(int paramInt)
  {
    AppMethodBeat.i(114859);
    Object localObject = (bu)this.ifb.get(paramInt);
    ((bu)localObject).setStatus(5);
    ((l)g.ab(l.class)).dlK().a(((ei)localObject).field_msgId, (bu)localObject);
    localObject = ifa.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Iterator)localObject).next();
    }
    AppMethodBeat.o(114859);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(114856);
    this.callback = paramf;
    paramf = new b.a();
    paramf.hNM = new czv();
    paramf.hNN = new czw();
    paramf.uri = "/cgi-bin/micromsg-bin/newsendmsg";
    paramf.funcId = 522;
    paramf.hNO = 237;
    paramf.respCmdId = 1000000237;
    this.rr = paramf.aDC();
    paramf = (czv)this.rr.hNK.hNQ;
    List localList = ((l)g.ab(l.class)).dlK().dlX();
    if (localList.size() == 0)
    {
      ad.i("MicroMsg.NetSceneSendMsg", "no sending message");
      AppMethodBeat.o(114856);
      return -2;
    }
    this.ifb.clear();
    int i = 0;
    while (i < localList.size())
    {
      bu localbu = (bu)localList.get(i);
      if (localbu.field_isSend == 1)
      {
        byy localbyy = new byy();
        localbyy.Fvj = new cwt().aPy(localbu.field_talker);
        localbyy.CreateTime = ((int)(localbu.field_createTime / 1000L));
        localbyy.nEf = localbu.getType();
        localbyy.hDa = localbu.field_content;
        localbyy.GUe = s.w(u.aAm(), localbu.field_createTime).hashCode();
        localbyy.Fvn = bl.aCi();
        if (((r)g.ad(r.class)).ifAddTicketByActionFlag(localbu.field_talker)) {
          localbyy.FOL = ((l)g.ab(l.class)).azp().aTu(localbu.field_talker);
        }
        paramf.nDj.add(localbyy);
        paramf.nDi = paramf.nDj.size();
        this.ifb.add(localbu);
      }
      i += 1;
    }
    i = dispatch(parame, this.rr, this);
    if (i < 0) {
      aJp();
    }
    AppMethodBeat.o(114856);
    return i;
  }
  
  public final int getType()
  {
    return 522;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114857);
    ad.i("MicroMsg.NetSceneSendMsg", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3);
    paramq = (czw)this.rr.hNL.hNQ;
    if ((paramq != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((r)g.ad(r.class)).setEnSendMsgActionFlag(paramq.FOM);
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      aJp();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(114857);
      return;
    }
    paramq = paramq.nDj;
    if (this.ifb.size() == paramq.size())
    {
      paramInt1 = 0;
      while (paramInt1 < paramq.size())
      {
        paramArrayOfByte = (byz)paramq.get(paramInt1);
        if (paramArrayOfByte.Ret != 0)
        {
          ad.e("MicroMsg.NetSceneSendMsg", "send msg failed: item ret code=" + paramArrayOfByte.Ret);
          pL(paramInt1);
          this.callback.onSceneEnd(4, paramArrayOfByte.Ret, paramString, this);
          AppMethodBeat.o(114857);
          return;
        }
        long l = ((bu)this.ifb.get(paramInt1)).field_msgId;
        ad.i("MicroMsg.NetSceneSendMsg", "msg local id = " + l + ", SvrId = " + paramArrayOfByte.xbt + " sent successfully!");
        bu localbu = ((l)g.ab(l.class)).dlK().xY(l);
        localbu.qz(paramArrayOfByte.xbt);
        localbu.setStatus(2);
        ((l)g.ab(l.class)).dlK().a(l, localbu);
        paramInt1 += 1;
      }
      ad.i("MicroMsg.NetSceneSendMsg", "total " + paramInt1 + " msgs sent successfully");
    }
    paramInt1 = doScene(dispatcher(), this.callback);
    if (paramInt1 == -2)
    {
      this.callback.onSceneEnd(0, 0, paramString, this);
      AppMethodBeat.o(114857);
      return;
    }
    if (paramInt1 < 0) {
      this.callback.onSceneEnd(3, -1, paramString, this);
    }
    AppMethodBeat.o(114857);
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(114855);
    if (this.ifb.size() > 0)
    {
      paramq = n.b.hOp;
      AppMethodBeat.o(114855);
      return paramq;
    }
    paramq = n.b.hOq;
    AppMethodBeat.o(114855);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.h
 * JD-Core Version:    0.7.0.1
 */