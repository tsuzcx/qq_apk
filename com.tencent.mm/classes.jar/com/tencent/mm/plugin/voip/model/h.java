package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.s;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.protobuf.bps;
import com.tencent.mm.protocal.protobuf.bpt;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.cpe;
import com.tencent.mm.protocal.protobuf.cpf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public final class h
  extends n
  implements com.tencent.mm.network.k
{
  private static final List<Object> hlD;
  private static final Set<Long> zgN;
  private com.tencent.mm.al.g callback;
  private final List<bl> hlE;
  private long msgId;
  private b rr;
  
  static
  {
    AppMethodBeat.i(114860);
    hlD = new ArrayList();
    zgN = new HashSet();
    AppMethodBeat.o(114860);
  }
  
  public h()
  {
    AppMethodBeat.i(114854);
    this.hlE = new LinkedList();
    ad.d("MicroMsg.NetSceneSendMsg", "dktext :" + bt.eGN());
    ad.i("MicroMsg.NetSceneSendMsg", "empty msg sender created");
    AppMethodBeat.o(114854);
  }
  
  public h(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(114853);
    this.hlE = new LinkedList();
    ad.d("MicroMsg.NetSceneSendMsg", "dktext :" + bt.eGN());
    if (!bt.isNullOrNil(paramString1))
    {
      bl localbl = new bl();
      localbl.setStatus(1);
      localbl.nY(paramString1);
      localbl.kY(bi.uj(paramString1));
      localbl.jV(1);
      localbl.setContent(paramString2);
      localbl.setType(paramInt);
      this.msgId = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().an(localbl);
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
  
  private void azp()
  {
    AppMethodBeat.i(114858);
    int i = 0;
    while (i < this.hlE.size())
    {
      ou(i);
      i += 1;
    }
    AppMethodBeat.o(114858);
  }
  
  private void ou(int paramInt)
  {
    AppMethodBeat.i(114859);
    Object localObject = (bl)this.hlE.get(paramInt);
    ((bl)localObject).setStatus(5);
    ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(((du)localObject).field_msgId, (bl)localObject);
    localObject = hlD.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Iterator)localObject).next();
    }
    AppMethodBeat.o(114859);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(114856);
    this.callback = paramg;
    paramg = new b.a();
    paramg.gUU = new cpe();
    paramg.gUV = new cpf();
    paramg.uri = "/cgi-bin/micromsg-bin/newsendmsg";
    paramg.funcId = 522;
    paramg.reqCmdId = 237;
    paramg.respCmdId = 1000000237;
    this.rr = paramg.atI();
    paramg = (cpe)this.rr.gUS.gUX;
    List localList = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().cOU();
    if (localList.size() == 0)
    {
      ad.i("MicroMsg.NetSceneSendMsg", "no sending message");
      AppMethodBeat.o(114856);
      return -2;
    }
    this.hlE.clear();
    int i = 0;
    while (i < localList.size())
    {
      bl localbl = (bl)localList.get(i);
      if (localbl.field_isSend == 1)
      {
        bps localbps = new bps();
        localbps.Cxy = new cmf().aEE(localbl.field_talker);
        localbps.CreateTime = ((int)(localbl.field_createTime / 1000L));
        localbps.mBH = localbl.getType();
        localbps.gKr = localbl.field_content;
        localbps.DOf = s.t(u.aqG(), localbl.field_createTime).hashCode();
        localbps.CxC = bk.asn();
        if (((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).ifAddTicketByActionFlag(localbl.field_talker)) {
          localbps.COT = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aIi(localbl.field_talker);
        }
        paramg.mAL.add(localbps);
        paramg.mAK = paramg.mAL.size();
        this.hlE.add(localbl);
      }
      i += 1;
    }
    i = dispatch(parame, this.rr, this);
    if (i < 0) {
      azp();
    }
    AppMethodBeat.o(114856);
    return i;
  }
  
  public final int getType()
  {
    return 522;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114857);
    ad.i("MicroMsg.NetSceneSendMsg", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3);
    paramq = (cpf)this.rr.gUT.gUX;
    if ((paramq != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).setEnSendMsgActionFlag(paramq.COU);
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      azp();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(114857);
      return;
    }
    paramq = paramq.mAL;
    if (this.hlE.size() == paramq.size())
    {
      paramInt1 = 0;
      while (paramInt1 < paramq.size())
      {
        paramArrayOfByte = (bpt)paramq.get(paramInt1);
        if (paramArrayOfByte.Ret != 0)
        {
          ad.e("MicroMsg.NetSceneSendMsg", "send msg failed: item ret code=" + paramArrayOfByte.Ret);
          ou(paramInt1);
          this.callback.onSceneEnd(4, paramArrayOfByte.Ret, paramString, this);
          AppMethodBeat.o(114857);
          return;
        }
        long l = ((bl)this.hlE.get(paramInt1)).field_msgId;
        ad.i("MicroMsg.NetSceneSendMsg", "msg local id = " + l + ", SvrId = " + paramArrayOfByte.uKZ + " sent successfully!");
        bl localbl = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(l);
        localbl.kX(paramArrayOfByte.uKZ);
        localbl.setStatus(2);
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(l, localbl);
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
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    AppMethodBeat.i(114855);
    if (this.hlE.size() > 0)
    {
      paramq = n.b.gVB;
      AppMethodBeat.o(114855);
      return paramq;
    }
    paramq = n.b.gVC;
    AppMethodBeat.o(114855);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.h
 * JD-Core Version:    0.7.0.1
 */