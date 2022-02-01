package com.tencent.mm.plugin.updater.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.chn;
import com.tencent.mm.protocal.protobuf.cho;
import com.tencent.mm.protocal.protobuf.chp;
import com.tencent.mm.protocal.protobuf.chs;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/updater/model/NetSceneManualCheckWxUpdate;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "baseId", "", "patchId", "targets", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/PRCondition;", "source", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/LinkedList;I)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCallback", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "setCallback", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getRr", "()Lcom/tencent/mm/modelbase/CommReqResp;", "getSource", "()I", "tinkerSyncNode", "Lcom/tencent/mm/protocal/protobuf/PRRespNode;", "getTinkerSyncNode", "()Lcom/tencent/mm/protocal/protobuf/PRRespNode;", "setTinkerSyncNode", "(Lcom/tencent/mm/protocal/protobuf/PRRespNode;)V", "tinkerSyncResponse", "Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;", "getTinkerSyncResponse", "()Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;", "setTinkerSyncResponse", "(Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-updater_release"})
public final class c
  extends n
  implements k
{
  public com.tencent.mm.plugin.hp.d.b BWe;
  private chs BWf;
  private final String TAG;
  private f callback;
  public final int doj;
  private final com.tencent.mm.ak.b rr;
  
  public c(String paramString1, String paramString2, LinkedList<chn> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(197792);
    this.doj = paramInt;
    this.TAG = "MicroMsg.Updater.NetSceneManualCheckWxUpdate";
    cho localcho = new cho();
    localcho.HtK = paramString1;
    localcho.wTE = paramString2;
    localcho.HtL = paramLinkedList;
    localcho.HtN = 1;
    paramLinkedList = new b.a();
    paramLinkedList.c((a)localcho);
    paramLinkedList.d((a)new chp());
    paramLinkedList.DN("/cgi-bin/micromsg-bin/prconfig");
    paramLinkedList.oS(3899);
    paramLinkedList.oU(0);
    paramLinkedList.oV(0);
    paramLinkedList = paramLinkedList.aDS();
    p.g(paramLinkedList, "builder.buildInstance()");
    this.rr = paramLinkedList;
    ae.i(this.TAG, "Create NetSceneManualCheckWxUpdate baseId:" + paramString1 + " patchId:" + paramString2);
    AppMethodBeat.o(197792);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(197790);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(197790);
    return i;
  }
  
  public final int getType()
  {
    return 3899;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(197791);
    ae.i(this.TAG, "errType:" + paramInt2 + ", errCode:" + paramInt3 + ", errMsg:" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      if (paramq == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
        AppMethodBeat.o(197791);
        throw paramString;
      }
      paramq = ((com.tencent.mm.ak.b)paramq).aEV();
      if (paramq == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.PRConfigResponse");
        AppMethodBeat.o(197791);
        throw paramString;
      }
      paramq = ((chp)paramq).HtO;
      if (paramq != null)
      {
        this.BWf = paramq;
        this.BWe = new com.tencent.mm.plugin.hp.d.b(paramq);
      }
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(197791);
      return;
    }
    AppMethodBeat.o(197791);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.updater.model.c
 * JD-Core Version:    0.7.0.1
 */