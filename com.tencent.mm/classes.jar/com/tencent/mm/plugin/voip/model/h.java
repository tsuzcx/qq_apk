package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.model.x;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cot;
import com.tencent.mm.protocal.protobuf.cou;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.dtt;
import com.tencent.mm.protocal.protobuf.dtu;
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
  private static final Set<Long> GTU;
  private static final List<Object> jcO;
  private com.tencent.mm.ak.i callback;
  private final List<ca> jcP;
  private long msgId;
  private d rr;
  
  static
  {
    AppMethodBeat.i(114860);
    jcO = new ArrayList();
    GTU = new HashSet();
    AppMethodBeat.o(114860);
  }
  
  public h()
  {
    AppMethodBeat.i(114854);
    this.jcP = new LinkedList();
    Log.d("MicroMsg.NetSceneSendMsg", "dktext :" + Util.getStack());
    Log.i("MicroMsg.NetSceneSendMsg", "empty msg sender created");
    AppMethodBeat.o(114854);
  }
  
  public h(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(114853);
    this.jcP = new LinkedList();
    Log.d("MicroMsg.NetSceneSendMsg", "dktext :" + Util.getStack());
    if (!Util.isNullOrNil(paramString1))
    {
      ca localca = new ca();
      localca.setStatus(1);
      localca.Cy(paramString1);
      localca.setCreateTime(bp.Kw(paramString1));
      localca.nv(1);
      localca.setContent(paramString2);
      localca.setType(paramInt);
      this.msgId = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().aC(localca);
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
  
  private void bdK()
  {
    AppMethodBeat.i(114858);
    int i = 0;
    while (i < this.jcP.size())
    {
      tC(i);
      i += 1;
    }
    AppMethodBeat.o(114858);
  }
  
  private void tC(int paramInt)
  {
    AppMethodBeat.i(114859);
    Object localObject = (ca)this.jcP.get(paramInt);
    ((ca)localObject).setStatus(5);
    ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a(((eo)localObject).field_msgId, (ca)localObject);
    localObject = jcO.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Iterator)localObject).next();
    }
    AppMethodBeat.o(114859);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(114856);
    this.callback = parami;
    parami = new d.a();
    parami.iLN = new dtt();
    parami.iLO = new dtu();
    parami.uri = "/cgi-bin/micromsg-bin/newsendmsg";
    parami.funcId = 522;
    parami.iLP = 237;
    parami.respCmdId = 1000000237;
    this.rr = parami.aXF();
    parami = (dtt)this.rr.iLK.iLR;
    List localList = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().eiL();
    if ((localList == null) || (localList.size() == 0))
    {
      Log.i("MicroMsg.NetSceneSendMsg", "no sending message");
      AppMethodBeat.o(114856);
      return -2;
    }
    this.jcP.clear();
    int i = 0;
    while (i < localList.size())
    {
      ca localca = (ca)localList.get(i);
      if (localca.field_isSend == 1)
      {
        cot localcot = new cot();
        localcot.KHm = new dqi().bhy(localca.field_talker);
        localcot.CreateTime = ((int)(localca.field_createTime / 1000L));
        localcot.oUv = localca.getType();
        localcot.iAc = localca.field_content;
        localcot.MuU = x.x(z.aTY(), localca.field_createTime).hashCode();
        localcot.KHq = br.aVW();
        if (((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).ifAddTicketByActionFlag(localca.field_talker)) {
          localcot.LbN = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().bjT(localca.field_talker);
        }
        parami.oTA.add(localcot);
        parami.oTz = parami.oTA.size();
        this.jcP.add(localca);
      }
      i += 1;
    }
    i = dispatch(paramg, this.rr, this);
    if (i < 0) {
      bdK();
    }
    AppMethodBeat.o(114856);
    return i;
  }
  
  public final int getType()
  {
    return 522;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114857);
    Log.i("MicroMsg.NetSceneSendMsg", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3);
    params = (dtu)this.rr.iLL.iLR;
    if ((params != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).setEnSendMsgActionFlag(params.LbO);
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      bdK();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(114857);
      return;
    }
    params = params.oTA;
    if (this.jcP.size() == params.size())
    {
      paramInt1 = 0;
      while (paramInt1 < params.size())
      {
        paramArrayOfByte = (cou)params.get(paramInt1);
        if (paramArrayOfByte.Ret != 0)
        {
          Log.e("MicroMsg.NetSceneSendMsg", "send msg failed: item ret code=" + paramArrayOfByte.Ret);
          tC(paramInt1);
          this.callback.onSceneEnd(4, paramArrayOfByte.Ret, paramString, this);
          AppMethodBeat.o(114857);
          return;
        }
        long l = ((ca)this.jcP.get(paramInt1)).field_msgId;
        Log.i("MicroMsg.NetSceneSendMsg", "msg local id = " + l + ", SvrId = " + paramArrayOfByte.Brn + " sent successfully!");
        ca localca = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(l);
        localca.yF(paramArrayOfByte.Brn);
        localca.setStatus(2);
        ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a(l, localca);
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
  
  public final q.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(114855);
    if (this.jcP.size() > 0)
    {
      params = q.b.iMq;
      AppMethodBeat.o(114855);
      return params;
    }
    params = q.b.iMr;
    AppMethodBeat.o(114855);
    return params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.h
 * JD-Core Version:    0.7.0.1
 */