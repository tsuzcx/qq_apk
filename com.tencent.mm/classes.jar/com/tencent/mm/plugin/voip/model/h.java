package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.t;
import com.tencent.mm.model.v;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.bzs;
import com.tencent.mm.protocal.protobuf.bzt;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.dap;
import com.tencent.mm.protocal.protobuf.daq;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
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
  private static final Set<Long> CpX;
  private static final List<Object> ihT;
  private f callback;
  private final List<bv> ihU;
  private long msgId;
  private b rr;
  
  static
  {
    AppMethodBeat.i(114860);
    ihT = new ArrayList();
    CpX = new HashSet();
    AppMethodBeat.o(114860);
  }
  
  public h()
  {
    AppMethodBeat.i(114854);
    this.ihU = new LinkedList();
    ae.d("MicroMsg.NetSceneSendMsg", "dktext :" + bu.fpN());
    ae.i("MicroMsg.NetSceneSendMsg", "empty msg sender created");
    AppMethodBeat.o(114854);
  }
  
  public h(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(114853);
    this.ihU = new LinkedList();
    ae.d("MicroMsg.NetSceneSendMsg", "dktext :" + bu.fpN());
    if (!bu.isNullOrNil(paramString1))
    {
      bv localbv = new bv();
      localbv.setStatus(1);
      localbv.ui(paramString1);
      localbv.qN(bl.BQ(paramString1));
      localbv.kt(1);
      localbv.setContent(paramString2);
      localbv.setType(paramInt);
      this.msgId = ((l)g.ab(l.class)).doJ().ar(localbv);
      if (this.msgId == -1L) {
        break label171;
      }
    }
    label171:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ae.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.msgId);
      AppMethodBeat.o(114853);
      return;
    }
  }
  
  private void aJI()
  {
    AppMethodBeat.i(114858);
    int i = 0;
    while (i < this.ihU.size())
    {
      pO(i);
      i += 1;
    }
    AppMethodBeat.o(114858);
  }
  
  private void pO(int paramInt)
  {
    AppMethodBeat.i(114859);
    Object localObject = (bv)this.ihU.get(paramInt);
    ((bv)localObject).setStatus(5);
    ((l)g.ab(l.class)).doJ().a(((ei)localObject).field_msgId, (bv)localObject);
    localObject = ihT.iterator();
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
    paramf.hQF = new dap();
    paramf.hQG = new daq();
    paramf.uri = "/cgi-bin/micromsg-bin/newsendmsg";
    paramf.funcId = 522;
    paramf.hQH = 237;
    paramf.respCmdId = 1000000237;
    this.rr = paramf.aDS();
    paramf = (dap)this.rr.hQD.hQJ;
    List localList = ((l)g.ab(l.class)).doJ().doW();
    if ((localList == null) || (localList.size() == 0))
    {
      ae.i("MicroMsg.NetSceneSendMsg", "no sending message");
      AppMethodBeat.o(114856);
      return -2;
    }
    this.ihU.clear();
    int i = 0;
    while (i < localList.size())
    {
      bv localbv = (bv)localList.get(i);
      if (localbv.field_isSend == 1)
      {
        bzs localbzs = new bzs();
        localbzs.FNH = new cxn().aQV(localbv.field_talker);
        localbzs.CreateTime = ((int)(localbv.field_createTime / 1000L));
        localbzs.nJA = localbv.getType();
        localbzs.hFS = localbv.field_content;
        localbzs.HnF = t.w(v.aAC(), localbv.field_createTime).hashCode();
        localbzs.FNL = bn.aCy();
        if (((s)g.ad(s.class)).ifAddTicketByActionFlag(localbv.field_talker)) {
          localbzs.Ghk = ((l)g.ab(l.class)).azF().aUV(localbv.field_talker);
        }
        paramf.nIE.add(localbzs);
        paramf.nID = paramf.nIE.size();
        this.ihU.add(localbv);
      }
      i += 1;
    }
    i = dispatch(parame, this.rr, this);
    if (i < 0) {
      aJI();
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
    ae.i("MicroMsg.NetSceneSendMsg", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3);
    paramq = (daq)this.rr.hQE.hQJ;
    if ((paramq != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((s)g.ad(s.class)).setEnSendMsgActionFlag(paramq.Ghl);
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      aJI();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(114857);
      return;
    }
    paramq = paramq.nIE;
    if (this.ihU.size() == paramq.size())
    {
      paramInt1 = 0;
      while (paramInt1 < paramq.size())
      {
        paramArrayOfByte = (bzt)paramq.get(paramInt1);
        if (paramArrayOfByte.Ret != 0)
        {
          ae.e("MicroMsg.NetSceneSendMsg", "send msg failed: item ret code=" + paramArrayOfByte.Ret);
          pO(paramInt1);
          this.callback.onSceneEnd(4, paramArrayOfByte.Ret, paramString, this);
          AppMethodBeat.o(114857);
          return;
        }
        long l = ((bv)this.ihU.get(paramInt1)).field_msgId;
        ae.i("MicroMsg.NetSceneSendMsg", "msg local id = " + l + ", SvrId = " + paramArrayOfByte.xrk + " sent successfully!");
        bv localbv = ((l)g.ab(l.class)).doJ().ys(l);
        localbv.qM(paramArrayOfByte.xrk);
        localbv.setStatus(2);
        ((l)g.ab(l.class)).doJ().a(l, localbv);
        paramInt1 += 1;
      }
      ae.i("MicroMsg.NetSceneSendMsg", "total " + paramInt1 + " msgs sent successfully");
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
    if (this.ihU.size() > 0)
    {
      paramq = n.b.hRi;
      AppMethodBeat.o(114855);
      return paramq;
    }
    paramq = n.b.hRj;
    AppMethodBeat.o(114855);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.h
 * JD-Core Version:    0.7.0.1
 */