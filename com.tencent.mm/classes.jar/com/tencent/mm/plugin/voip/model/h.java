package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.br;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.x;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.don;
import com.tencent.mm.protocal.protobuf.doo;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.exm;
import com.tencent.mm.protocal.protobuf.exn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public final class h
  extends p
  implements m
{
  private static final Set<Long> UwQ;
  private static final List<Object> oMg;
  private com.tencent.mm.am.h callback;
  private long msgId;
  private final List<cc> oMh;
  private c rr;
  
  static
  {
    AppMethodBeat.i(114860);
    oMg = new ArrayList();
    UwQ = new HashSet();
    AppMethodBeat.o(114860);
  }
  
  public h()
  {
    AppMethodBeat.i(114854);
    this.oMh = new LinkedList();
    Log.d("MicroMsg.NetSceneSendMsg", "dktext :" + Util.getStack());
    Log.i("MicroMsg.NetSceneSendMsg", "empty msg sender created");
    AppMethodBeat.o(114854);
  }
  
  public h(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(114853);
    this.oMh = new LinkedList();
    Log.d("MicroMsg.NetSceneSendMsg", "dktext :" + Util.getStack());
    if (!Util.isNullOrNil(paramString1))
    {
      cc localcc = new cc();
      localcc.setStatus(1);
      localcc.BS(paramString1);
      localcc.setCreateTime(br.JN(paramString1));
      localcc.pI(1);
      localcc.setContent(paramString2);
      localcc.setType(paramInt);
      this.msgId = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().ba(localcc);
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
  
  private void bKQ()
  {
    AppMethodBeat.i(114858);
    int i = 0;
    while (i < this.oMh.size())
    {
      wE(i);
      i += 1;
    }
    AppMethodBeat.o(114858);
  }
  
  private void wE(int paramInt)
  {
    AppMethodBeat.i(114859);
    Object localObject = (cc)this.oMh.get(paramInt);
    ((cc)localObject).setStatus(5);
    ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(((fi)localObject).field_msgId, (cc)localObject);
    localObject = oMg.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Iterator)localObject).next();
    }
    AppMethodBeat.o(114859);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(114856);
    this.callback = paramh;
    paramh = new c.a();
    paramh.otE = new exm();
    paramh.otF = new exn();
    paramh.uri = "/cgi-bin/micromsg-bin/newsendmsg";
    paramh.funcId = 522;
    paramh.otG = 237;
    paramh.respCmdId = 1000000237;
    this.rr = paramh.bEF();
    paramh = (exm)c.b.b(this.rr.otB);
    List localList = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().gbm();
    if ((localList == null) || (localList.size() == 0))
    {
      Log.i("MicroMsg.NetSceneSendMsg", "no sending message");
      AppMethodBeat.o(114856);
      return -2;
    }
    this.oMh.clear();
    int i = 0;
    while (i < localList.size())
    {
      cc localcc = (cc)localList.get(i);
      if (localcc.field_isSend == 1)
      {
        don localdon = new don();
        localdon.YFF = new etl().btH(localcc.field_talker);
        localdon.CreateTime = ((int)(localcc.getCreateTime() / 1000L));
        localdon.vhJ = localcc.getType();
        localdon.nUB = localcc.field_content;
        localdon.aaVx = x.z(z.bAM(), localcc.getCreateTime()).hashCode();
        localdon.YFJ = bt.bCR();
        if (((v)com.tencent.mm.kernel.h.az(v.class)).ifAddTicketByActionFlag(localcc.field_talker)) {
          localdon.ZaR = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxH(localcc.field_talker);
        }
        paramh.vgO.add(localdon);
        paramh.vgN = paramh.vgO.size();
        this.oMh.add(localcc);
      }
      i += 1;
    }
    i = dispatch(paramg, this.rr, this);
    if (i < 0) {
      bKQ();
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
    params = (exn)c.c.b(this.rr.otC);
    if ((params != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((v)com.tencent.mm.kernel.h.az(v.class)).setEnSendMsgActionFlag(params.ZaS);
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      bKQ();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(114857);
      return;
    }
    params = params.vgO;
    if (this.oMh.size() == params.size())
    {
      paramInt1 = 0;
      while (paramInt1 < params.size())
      {
        paramArrayOfByte = (doo)params.get(paramInt1);
        if (paramArrayOfByte.Idd != 0)
        {
          Log.e("MicroMsg.NetSceneSendMsg", "send msg failed: item ret code=" + paramArrayOfByte.Idd);
          wE(paramInt1);
          this.callback.onSceneEnd(4, paramArrayOfByte.Idd, paramString, this);
          AppMethodBeat.o(114857);
          return;
        }
        long l = ((cc)this.oMh.get(paramInt1)).field_msgId;
        Log.i("MicroMsg.NetSceneSendMsg", "msg local id = " + l + ", SvrId = " + paramArrayOfByte.Njv + " sent successfully!");
        cc localcc = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(l);
        localcc.gX(paramArrayOfByte.Njv);
        localcc.setStatus(2);
        ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(l, localcc);
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
  
  public final p.b securityVerificationChecked(s params)
  {
    AppMethodBeat.i(114855);
    if (this.oMh.size() > 0)
    {
      params = p.b.ouh;
      AppMethodBeat.o(114855);
      return params;
    }
    params = p.b.oui;
    AppMethodBeat.o(114855);
    return params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.h
 * JD-Core Version:    0.7.0.1
 */