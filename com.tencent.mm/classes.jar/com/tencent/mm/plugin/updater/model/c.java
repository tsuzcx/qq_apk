package com.tencent.mm.plugin.updater.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cgt;
import com.tencent.mm.protocal.protobuf.cgu;
import com.tencent.mm.protocal.protobuf.cgv;
import com.tencent.mm.protocal.protobuf.cgy;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.v;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/updater/model/NetSceneManualCheckWxUpdate;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "baseId", "", "patchId", "targets", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/PRCondition;", "source", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/LinkedList;I)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCallback", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "setCallback", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getRr", "()Lcom/tencent/mm/modelbase/CommReqResp;", "getSource", "()I", "tinkerSyncNode", "Lcom/tencent/mm/protocal/protobuf/PRRespNode;", "getTinkerSyncNode", "()Lcom/tencent/mm/protocal/protobuf/PRRespNode;", "setTinkerSyncNode", "(Lcom/tencent/mm/protocal/protobuf/PRRespNode;)V", "tinkerSyncResponse", "Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;", "getTinkerSyncResponse", "()Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;", "setTinkerSyncResponse", "(Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-updater_release"})
public final class c
  extends n
  implements k
{
  public com.tencent.mm.plugin.hp.d.b BEG;
  private cgy BEH;
  private final String TAG;
  private f callback;
  public final int dnh;
  private final com.tencent.mm.al.b rr;
  
  public c(String paramString1, String paramString2, LinkedList<cgt> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(214579);
    this.dnh = paramInt;
    this.TAG = "MicroMsg.Updater.NetSceneManualCheckWxUpdate";
    cgu localcgu = new cgu();
    localcgu.Hak = paramString1;
    localcgu.wDT = paramString2;
    localcgu.Hal = paramLinkedList;
    localcgu.Han = 1;
    paramLinkedList = new b.a();
    paramLinkedList.c((a)localcgu);
    paramLinkedList.d((a)new cgv());
    paramLinkedList.Dl("/cgi-bin/micromsg-bin/prconfig");
    paramLinkedList.oP(3899);
    paramLinkedList.oR(0);
    paramLinkedList.oS(0);
    paramLinkedList = paramLinkedList.aDC();
    p.g(paramLinkedList, "builder.buildInstance()");
    this.rr = paramLinkedList;
    ad.i(this.TAG, "Create NetSceneManualCheckWxUpdate baseId:" + paramString1 + " patchId:" + paramString2);
    AppMethodBeat.o(214579);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(214577);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(214577);
    return i;
  }
  
  public final int getType()
  {
    return 3899;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(214578);
    ad.i(this.TAG, "errType:" + paramInt2 + ", errCode:" + paramInt3 + ", errMsg:" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      if (paramq == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
        AppMethodBeat.o(214578);
        throw paramString;
      }
      paramq = ((com.tencent.mm.al.b)paramq).aEF();
      if (paramq == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.PRConfigResponse");
        AppMethodBeat.o(214578);
        throw paramString;
      }
      paramq = ((cgv)paramq).Hao;
      if (paramq != null)
      {
        this.BEH = paramq;
        this.BEG = new com.tencent.mm.plugin.hp.d.b(paramq);
      }
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(214578);
      return;
    }
    AppMethodBeat.o(214578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.updater.model.c
 * JD-Core Version:    0.7.0.1
 */