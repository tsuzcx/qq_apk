package com.tencent.mm.plugin.updater.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.hp.d.b;
import com.tencent.mm.protocal.protobuf.cxu;
import com.tencent.mm.protocal.protobuf.cxv;
import com.tencent.mm.protocal.protobuf.cxw;
import com.tencent.mm.protocal.protobuf.cxz;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/updater/model/NetSceneManualCheckWxUpdate;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "baseId", "", "patchId", "targets", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/PRCondition;", "source", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/LinkedList;I)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCallback", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "setCallback", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getRr", "()Lcom/tencent/mm/modelbase/CommReqResp;", "getSource", "()I", "tinkerSyncNode", "Lcom/tencent/mm/protocal/protobuf/PRRespNode;", "getTinkerSyncNode", "()Lcom/tencent/mm/protocal/protobuf/PRRespNode;", "setTinkerSyncNode", "(Lcom/tencent/mm/protocal/protobuf/PRRespNode;)V", "tinkerSyncResponse", "Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;", "getTinkerSyncResponse", "()Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;", "setTinkerSyncResponse", "(Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-updater_release"})
public final class c
  extends q
  implements m
{
  public b GwJ;
  private cxz GwK;
  private final String TAG;
  private i callback;
  private final d rr;
  public final int source;
  
  public c(String paramString1, String paramString2, LinkedList<cxu> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(194763);
    this.source = paramInt;
    this.TAG = "MicroMsg.Updater.NetSceneManualCheckWxUpdate";
    cxv localcxv = new cxv();
    localcxv.MCI = paramString1;
    localcxv.APx = paramString2;
    localcxv.MCJ = paramLinkedList;
    localcxv.MCL = 1;
    paramLinkedList = new d.a();
    paramLinkedList.c((a)localcxv);
    paramLinkedList.d((a)new cxw());
    paramLinkedList.MB("/cgi-bin/micromsg-bin/prconfig");
    paramLinkedList.sG(3899);
    paramLinkedList.sI(0);
    paramLinkedList.sJ(0);
    paramLinkedList = paramLinkedList.aXF();
    p.g(paramLinkedList, "builder.buildInstance()");
    this.rr = paramLinkedList;
    Log.i(this.TAG, "Create NetSceneManualCheckWxUpdate baseId:" + paramString1 + " patchId:" + paramString2);
    AppMethodBeat.o(194763);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(194761);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(194761);
    return i;
  }
  
  public final int getType()
  {
    return 3899;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(194762);
    Log.i(this.TAG, "errType:" + paramInt2 + ", errCode:" + paramInt3 + ", errMsg:" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
        AppMethodBeat.o(194762);
        throw paramString;
      }
      params = ((d)params).aYK();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.PRConfigResponse");
        AppMethodBeat.o(194762);
        throw paramString;
      }
      params = ((cxw)params).MCM;
      if (params != null)
      {
        this.GwK = params;
        this.GwJ = new b(params);
      }
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(194762);
      return;
    }
    AppMethodBeat.o(194762);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.updater.model.c
 * JD-Core Version:    0.7.0.1
 */