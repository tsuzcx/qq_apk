package com.tencent.mm.plugin.updater.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.hp.d.b;
import com.tencent.mm.protocal.protobuf.dhf;
import com.tencent.mm.protocal.protobuf.dhg;
import com.tencent.mm.protocal.protobuf.dhh;
import com.tencent.mm.protocal.protobuf.dhk;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/updater/model/NetSceneManualCheckWxUpdate;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "baseId", "", "patchId", "targets", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/PRCondition;", "source", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/LinkedList;I)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCallback", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "setCallback", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getRr", "()Lcom/tencent/mm/modelbase/CommReqResp;", "getSource", "()I", "tinkerSyncNode", "Lcom/tencent/mm/protocal/protobuf/PRRespNode;", "getTinkerSyncNode", "()Lcom/tencent/mm/protocal/protobuf/PRRespNode;", "setTinkerSyncNode", "(Lcom/tencent/mm/protocal/protobuf/PRRespNode;)V", "tinkerSyncResponse", "Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;", "getTinkerSyncResponse", "()Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;", "setTinkerSyncResponse", "(Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-updater_release"})
public final class c
  extends q
  implements m
{
  public b Nkc;
  private dhk Nkd;
  private final String TAG;
  private i callback;
  private final d rr;
  public final int source;
  
  public c(String paramString1, String paramString2, LinkedList<dhf> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(196104);
    this.source = paramInt;
    this.TAG = "MicroMsg.Updater.NetSceneManualCheckWxUpdate";
    dhg localdhg = new dhg();
    localdhg.TOo = paramString1;
    localdhg.GIL = paramString2;
    localdhg.TOp = paramLinkedList;
    localdhg.TOr = 1;
    paramLinkedList = new d.a();
    paramLinkedList.c((a)localdhg);
    paramLinkedList.d((a)new dhh());
    paramLinkedList.TW("/cgi-bin/micromsg-bin/prconfig");
    paramLinkedList.vD(3899);
    paramLinkedList.vF(0);
    paramLinkedList.vG(0);
    paramLinkedList = paramLinkedList.bgN();
    p.j(paramLinkedList, "builder.buildInstance()");
    this.rr = paramLinkedList;
    Log.i(this.TAG, "Create NetSceneManualCheckWxUpdate baseId:" + paramString1 + " patchId:" + paramString2);
    AppMethodBeat.o(196104);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(196091);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(196091);
    return i;
  }
  
  public final int getType()
  {
    return 3899;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(196097);
    Log.i(this.TAG, "errType:" + paramInt2 + ", errCode:" + paramInt3 + ", errMsg:" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
        AppMethodBeat.o(196097);
        throw paramString;
      }
      params = ((d)params).bhY();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.PRConfigResponse");
        AppMethodBeat.o(196097);
        throw paramString;
      }
      params = ((dhh)params).TOs;
      if (params != null)
      {
        this.Nkd = params;
        this.Nkc = new b(params);
      }
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(196097);
      return;
    }
    AppMethodBeat.o(196097);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.updater.model.c
 * JD-Core Version:    0.7.0.1
 */