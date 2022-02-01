package com.tencent.mm.plugin.textstatus.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.textstatus.g.o;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetTopicShowInfos;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "topicIDs", "Ljava/util/LinkedList;", "", "(Ljava/util/LinkedList;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetTopicShowInfosReq;", "getRequest", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetTopicShowInfosReq;", "response", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetTopicShowInfosResp;", "getResponse", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetTopicShowInfosResp;", "setResponse", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetTopicShowInfosResp;)V", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-textstatus_release"})
public final class h
  extends q
  implements m
{
  public static final a FZd;
  public final o FZb;
  private com.tencent.mm.plugin.textstatus.g.p FZc;
  private i callback;
  private final d iUB;
  
  static
  {
    AppMethodBeat.i(216200);
    FZd = new a((byte)0);
    AppMethodBeat.o(216200);
  }
  
  public h(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(216199);
    Object localObject = new d.a();
    ((d.a)localObject).sG(getType());
    ((d.a)localObject).MB("/cgi-bin/micromsg-bin/textstatusgettopicshowinfos");
    ((d.a)localObject).c((a)new o());
    ((d.a)localObject).d((a)new com.tencent.mm.plugin.textstatus.g.p());
    localObject = ((d.a)localObject).aXF();
    kotlin.g.b.p.g(localObject, "commReqRespBuilder.buildInstance()");
    this.iUB = ((d)localObject);
    localObject = this.iUB.aYJ();
    if (localObject == null)
    {
      paramLinkedList = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusGetTopicShowInfosReq");
      AppMethodBeat.o(216199);
      throw paramLinkedList;
    }
    this.FZb = ((o)localObject);
    this.FZb.GaL = paramLinkedList;
    AppMethodBeat.o(216199);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(216197);
    kotlin.g.b.p.h(paramg, "dispatcher");
    kotlin.g.b.p.h(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.iUB, (m)this);
    AppMethodBeat.o(216197);
    return i;
  }
  
  public final int getType()
  {
    return 6284;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(216198);
    kotlin.g.b.p.h(params, "rr");
    Log.i("MicroMsg.TxtStatus.NetSceneTextStatusGetTopicShowInfos", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = this.iUB.aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusGetTopicShowInfosResp");
      AppMethodBeat.o(216198);
      throw paramString;
    }
    this.FZc = ((com.tencent.mm.plugin.textstatus.g.p)params);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(216198);
      return;
    }
    AppMethodBeat.o(216198);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetTopicShowInfos$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.f.h
 * JD-Core Version:    0.7.0.1
 */