package com.tencent.mm.plugin.textstatus.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.textstatus.proto.w;
import com.tencent.mm.plugin.textstatus.proto.x;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetTopicShowInfos;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "topicIDs", "Ljava/util/LinkedList;", "", "(Ljava/util/LinkedList;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetTopicShowInfosReq;", "getRequest", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetTopicShowInfosReq;", "response", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetTopicShowInfosResp;", "getResponse", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetTopicShowInfosResp;", "setResponse", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetTopicShowInfosResp;)V", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-textstatus_release"})
public final class j
  extends q
  implements m
{
  public static final a MDr;
  public final w MDp;
  private x MDq;
  private i callback;
  private final d lKU;
  
  static
  {
    AppMethodBeat.i(237126);
    MDr = new a((byte)0);
    AppMethodBeat.o(237126);
  }
  
  public j(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(237123);
    Object localObject = new d.a();
    ((d.a)localObject).vD(getType());
    ((d.a)localObject).TW("/cgi-bin/micromsg-bin/textstatusgettopicshowinfos");
    ((d.a)localObject).c((a)new w());
    ((d.a)localObject).d((a)new x());
    localObject = ((d.a)localObject).bgN();
    p.j(localObject, "commReqRespBuilder.buildInstance()");
    this.lKU = ((d)localObject);
    localObject = this.lKU.bhX();
    if (localObject == null)
    {
      paramLinkedList = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusGetTopicShowInfosReq");
      AppMethodBeat.o(237123);
      throw paramLinkedList;
    }
    this.MDp = ((w)localObject);
    this.MDp.MFw = paramLinkedList;
    AppMethodBeat.o(237123);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(237117);
    p.k(paramg, "dispatcher");
    p.k(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.lKU, (m)this);
    AppMethodBeat.o(237117);
    return i;
  }
  
  public final int getType()
  {
    return 6284;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(237121);
    p.k(params, "rr");
    Log.i("MicroMsg.TextStatus.NetSceneTextStatusGetTopicShowInfos", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = this.lKU.bhY();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusGetTopicShowInfosResp");
      AppMethodBeat.o(237121);
      throw paramString;
    }
    this.MDq = ((x)params);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(237121);
      return;
    }
    AppMethodBeat.o(237121);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetTopicShowInfos$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.j
 * JD-Core Version:    0.7.0.1
 */