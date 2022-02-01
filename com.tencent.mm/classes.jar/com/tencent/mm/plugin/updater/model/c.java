package com.tencent.mm.plugin.updater.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.protocal.protobuf.dzq;
import com.tencent.mm.protocal.protobuf.dzt;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/updater/model/NetSceneManualCheckWxUpdate;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "baseId", "", "patchId", "targets", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/PRCondition;", "source", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/LinkedList;I)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCallback", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "setCallback", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getRr", "()Lcom/tencent/mm/modelbase/CommReqResp;", "getSource", "()I", "tinkerSyncNode", "Lcom/tencent/mm/protocal/protobuf/PRRespNode;", "getTinkerSyncNode", "()Lcom/tencent/mm/protocal/protobuf/PRRespNode;", "setTinkerSyncNode", "(Lcom/tencent/mm/protocal/protobuf/PRRespNode;)V", "tinkerSyncResponse", "Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;", "getTinkerSyncResponse", "()Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;", "setTinkerSyncResponse", "(Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-updater_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends p
  implements m
{
  private final String TAG;
  public com.tencent.mm.plugin.hp.b.b TWL;
  private dzt TWM;
  private h callback;
  private final com.tencent.mm.am.c rr;
  public final int source;
  
  public c(String paramString1, String paramString2, LinkedList<dzo> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(265964);
    this.source = paramInt;
    this.TAG = "MicroMsg.Updater.NetSceneManualCheckWxUpdate";
    dzp localdzp = new dzp();
    localdzp.abeK = paramString1;
    localdzp.ycW = paramString2;
    localdzp.abeL = paramLinkedList;
    localdzp.abeN = 1;
    paramLinkedList = new c.a();
    paramLinkedList.otE = ((a)localdzp);
    paramLinkedList.otF = ((a)new dzq());
    paramLinkedList.uri = "/cgi-bin/micromsg-bin/prconfig";
    paramLinkedList.funcId = 3899;
    paramLinkedList.otG = 0;
    paramLinkedList.respCmdId = 0;
    paramLinkedList = paramLinkedList.bEF();
    kotlin.g.b.s.s(paramLinkedList, "builder.buildInstance()");
    this.rr = paramLinkedList;
    Log.i(this.TAG, "Create NetSceneManualCheckWxUpdate baseId:" + paramString1 + " patchId:" + paramString2);
    AppMethodBeat.o(265964);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(265988);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(265988);
    return i;
  }
  
  public final int getType()
  {
    return 3899;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(265996);
    Log.i(this.TAG, "errType:" + paramInt2 + ", errCode:" + paramInt3 + ", errMsg:" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      if (params == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
        AppMethodBeat.o(265996);
        throw paramString;
      }
      params = c.c.b(((com.tencent.mm.am.c)params).otC);
      if (params == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.PRConfigResponse");
        AppMethodBeat.o(265996);
        throw paramString;
      }
      params = ((dzq)params).abeO;
      if (params != null)
      {
        this.TWM = params;
        this.TWL = new com.tencent.mm.plugin.hp.b.b(params);
      }
    }
    com.tencent.mm.plugin.hp.model.b.a(this.TWL);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(265996);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.updater.model.c
 * JD-Core Version:    0.7.0.1
 */