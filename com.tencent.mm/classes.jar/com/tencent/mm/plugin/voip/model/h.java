package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.x;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.cxi;
import com.tencent.mm.protocal.protobuf.cxj;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.edv;
import com.tencent.mm.protocal.protobuf.edw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public final class h
  extends q
  implements m
{
  private static final Set<Long> NKg;
  private static final List<Object> lTn;
  private com.tencent.mm.an.i callback;
  private final List<ca> lTo;
  private long msgId;
  private d rr;
  
  static
  {
    AppMethodBeat.i(114860);
    lTn = new ArrayList();
    NKg = new HashSet();
    AppMethodBeat.o(114860);
  }
  
  public h()
  {
    AppMethodBeat.i(114854);
    this.lTo = new LinkedList();
    Log.d("MicroMsg.NetSceneSendMsg", "dktext :" + Util.getStack());
    Log.i("MicroMsg.NetSceneSendMsg", "empty msg sender created");
    AppMethodBeat.o(114854);
  }
  
  public h(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(114853);
    this.lTo = new LinkedList();
    Log.d("MicroMsg.NetSceneSendMsg", "dktext :" + Util.getStack());
    if (!Util.isNullOrNil(paramString1))
    {
      ca localca = new ca();
      localca.setStatus(1);
      localca.Jm(paramString1);
      localca.setCreateTime(bq.RP(paramString1));
      localca.pJ(1);
      localca.setContent(paramString2);
      localca.setType(paramInt);
      this.msgId = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aM(localca);
      if (this.msgId == -1L) {
        break label171;
      }
    }
    label171:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      Log.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.msgId);
      AppMethodBeat.o(114853);
      return;
    }
  }
  
  private void bnf()
  {
    AppMethodBeat.i(114858);
    int i = 0;
    while (i < this.lTo.size())
    {
      wC(i);
      i += 1;
    }
    AppMethodBeat.o(114858);
  }
  
  private void wC(int paramInt)
  {
    AppMethodBeat.i(114859);
    Object localObject = (ca)this.lTo.get(paramInt);
    ((ca)localObject).setStatus(5);
    ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(((et)localObject).field_msgId, (ca)localObject);
    localObject = lTn.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Iterator)localObject).next();
    }
    AppMethodBeat.o(114859);
  }
  
  public final int doScene(g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(114856);
    this.callback = parami;
    parami = new d.a();
    parami.lBU = new edv();
    parami.lBV = new edw();
    parami.uri = "/cgi-bin/micromsg-bin/newsendmsg";
    parami.funcId = 522;
    parami.lBW = 237;
    parami.respCmdId = 1000000237;
    this.rr = parami.bgN();
    parami = (edv)d.b.b(this.rr.lBR);
    List localList = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().eSr();
    if ((localList == null) || (localList.size() == 0))
    {
      Log.i("MicroMsg.NetSceneSendMsg", "no sending message");
      AppMethodBeat.o(114856);
      return -2;
    }
    this.lTo.clear();
    int i = 0;
    while (i < localList.size())
    {
      ca localca = (ca)localList.get(i);
      if (localca.field_isSend == 1)
      {
        cxi localcxi = new cxi();
        localcxi.RIE = new eaf().btQ(localca.field_talker);
        localcxi.CreateTime = ((int)(localca.field_createTime / 1000L));
        localcxi.rWu = localca.getType();
        localcxi.lpy = localca.field_content;
        localcxi.TFR = x.u(z.bcZ(), localca.field_createTime).hashCode();
        localcxi.RII = bs.beZ();
        if (((v)com.tencent.mm.kernel.h.ag(v.class)).ifAddTicketByActionFlag(localca.field_talker)) {
          localcxi.ScZ = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().bws(localca.field_talker);
        }
        parami.rVy.add(localcxi);
        parami.rVx = parami.rVy.size();
        this.lTo.add(localca);
      }
      i += 1;
    }
    i = dispatch(paramg, this.rr, this);
    if (i < 0) {
      bnf();
    }
    AppMethodBeat.o(114856);
    return i;
  }
  
  public final int getType()
  {
    return 522;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114857);
    Log.i("MicroMsg.NetSceneSendMsg", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3);
    params = (edw)d.c.b(this.rr.lBS);
    if ((params != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((v)com.tencent.mm.kernel.h.ag(v.class)).setEnSendMsgActionFlag(params.Sda);
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      bnf();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(114857);
      return;
    }
    params = params.rVy;
    if (this.lTo.size() == params.size())
    {
      paramInt1 = 0;
      while (paramInt1 < params.size())
      {
        paramArrayOfByte = (cxj)params.get(paramInt1);
        if (paramArrayOfByte.CqV != 0)
        {
          Log.e("MicroMsg.NetSceneSendMsg", "send msg failed: item ret code=" + paramArrayOfByte.CqV);
          wC(paramInt1);
          this.callback.onSceneEnd(4, paramArrayOfByte.CqV, paramString, this);
          AppMethodBeat.o(114857);
          return;
        }
        long l = ((ca)this.lTo.get(paramInt1)).field_msgId;
        Log.i("MicroMsg.NetSceneSendMsg", "msg local id = " + l + ", SvrId = " + paramArrayOfByte.HlH + " sent successfully!");
        ca localca = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(l);
        localca.EG(paramArrayOfByte.HlH);
        localca.setStatus(2);
        ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(l, localca);
        paramInt1 += 1;
      }
      Log.i("MicroMsg.NetSceneSendMsg", "total " + paramInt1 + " msgs sent successfully");
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
  
  public final q.b securityVerificationChecked(s params)
  {
    AppMethodBeat.i(114855);
    if (this.lTo.size() > 0)
    {
      params = q.b.lCx;
      AppMethodBeat.o(114855);
      return params;
    }
    params = q.b.lCy;
    AppMethodBeat.o(114855);
    return params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.h
 * JD-Core Version:    0.7.0.1
 */