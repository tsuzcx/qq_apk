package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.s;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.protobuf.buj;
import com.tencent.mm.protocal.protobuf.buk;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.cul;
import com.tencent.mm.protocal.protobuf.cum;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
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
  private static final Set<Long> Azw;
  private static final List<Object> hMg;
  private com.tencent.mm.ak.g callback;
  private final List<bo> hMh;
  private long msgId;
  private b rr;
  
  static
  {
    AppMethodBeat.i(114860);
    hMg = new ArrayList();
    Azw = new HashSet();
    AppMethodBeat.o(114860);
  }
  
  public h()
  {
    AppMethodBeat.i(114854);
    this.hMh = new LinkedList();
    ac.d("MicroMsg.NetSceneSendMsg", "dktext :" + bs.eWi());
    ac.i("MicroMsg.NetSceneSendMsg", "empty msg sender created");
    AppMethodBeat.o(114854);
  }
  
  public h(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(114853);
    this.hMh = new LinkedList();
    ac.d("MicroMsg.NetSceneSendMsg", "dktext :" + bs.eWi());
    if (!bs.isNullOrNil(paramString1))
    {
      bo localbo = new bo();
      localbo.setStatus(1);
      localbo.re(paramString1);
      localbo.oA(bi.yp(paramString1));
      localbo.jT(1);
      localbo.setContent(paramString2);
      localbo.setType(paramInt);
      this.msgId = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().ap(localbo);
      if (this.msgId == -1L) {
        break label171;
      }
    }
    label171:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ac.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.msgId);
      AppMethodBeat.o(114853);
      return;
    }
  }
  
  private void aGg()
  {
    AppMethodBeat.i(114858);
    int i = 0;
    while (i < this.hMh.size())
    {
      pi(i);
      i += 1;
    }
    AppMethodBeat.o(114858);
  }
  
  private void pi(int paramInt)
  {
    AppMethodBeat.i(114859);
    Object localObject = (bo)this.hMh.get(paramInt);
    ((bo)localObject).setStatus(5);
    ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(((dy)localObject).field_msgId, (bo)localObject);
    localObject = hMg.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Iterator)localObject).next();
    }
    AppMethodBeat.o(114859);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(114856);
    this.callback = paramg;
    paramg = new b.a();
    paramg.hvt = new cul();
    paramg.hvu = new cum();
    paramg.uri = "/cgi-bin/micromsg-bin/newsendmsg";
    paramg.funcId = 522;
    paramg.reqCmdId = 237;
    paramg.respCmdId = 1000000237;
    this.rr = paramg.aAz();
    paramg = (cul)this.rr.hvr.hvw;
    List localList = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().dcD();
    if (localList.size() == 0)
    {
      ac.i("MicroMsg.NetSceneSendMsg", "no sending message");
      AppMethodBeat.o(114856);
      return -2;
    }
    this.hMh.clear();
    int i = 0;
    while (i < localList.size())
    {
      bo localbo = (bo)localList.get(i);
      if (localbo.field_isSend == 1)
      {
        buj localbuj = new buj();
        localbuj.DPU = new crm().aJV(localbo.field_talker);
        localbuj.CreateTime = ((int)(localbo.field_createTime / 1000L));
        localbuj.ndI = localbo.getType();
        localbuj.hkR = localbo.field_content;
        localbuj.Fkw = s.u(u.axw(), localbo.field_createTime).hashCode();
        localbuj.DPY = bk.aze();
        if (((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).ifAddTicketByActionFlag(localbo.field_talker)) {
          localbuj.EhE = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aND(localbo.field_talker);
        }
        paramg.ncM.add(localbuj);
        paramg.ncL = paramg.ncM.size();
        this.hMh.add(localbo);
      }
      i += 1;
    }
    i = dispatch(parame, this.rr, this);
    if (i < 0) {
      aGg();
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
    ac.i("MicroMsg.NetSceneSendMsg", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3);
    paramq = (cum)this.rr.hvs.hvw;
    if ((paramq != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).setEnSendMsgActionFlag(paramq.EhF);
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      aGg();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(114857);
      return;
    }
    paramq = paramq.ncM;
    if (this.hMh.size() == paramq.size())
    {
      paramInt1 = 0;
      while (paramInt1 < paramq.size())
      {
        paramArrayOfByte = (buk)paramq.get(paramInt1);
        if (paramArrayOfByte.Ret != 0)
        {
          ac.e("MicroMsg.NetSceneSendMsg", "send msg failed: item ret code=" + paramArrayOfByte.Ret);
          pi(paramInt1);
          this.callback.onSceneEnd(4, paramArrayOfByte.Ret, paramString, this);
          AppMethodBeat.o(114857);
          return;
        }
        long l = ((bo)this.hMh.get(paramInt1)).field_msgId;
        ac.i("MicroMsg.NetSceneSendMsg", "msg local id = " + l + ", SvrId = " + paramArrayOfByte.vTQ + " sent successfully!");
        bo localbo = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(l);
        localbo.oz(paramArrayOfByte.vTQ);
        localbo.setStatus(2);
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(l, localbo);
        paramInt1 += 1;
      }
      ac.i("MicroMsg.NetSceneSendMsg", "total " + paramInt1 + " msgs sent successfully");
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
    if (this.hMh.size() > 0)
    {
      paramq = n.b.hwa;
      AppMethodBeat.o(114855);
      return paramq;
    }
    paramq = n.b.hwb;
    AppMethodBeat.o(114855);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.h
 * JD-Core Version:    0.7.0.1
 */