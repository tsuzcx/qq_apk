package com.tencent.mm.plugin.textstatus.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.textstatus.proto.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneSportTextStatus;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "iconId", "", "source", "", "(Ljava/lang/String;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getIconId", "()Ljava/lang/String;", "request", "Lcom/tencent/mm/plugin/textstatus/proto/GetCheersSignatureForWerunReq;", "response", "Lcom/tencent/mm/plugin/textstatus/proto/GetCheersSignatureForWerunResp;", "getResponse", "()Lcom/tencent/mm/plugin/textstatus/proto/GetCheersSignatureForWerunResp;", "setResponse", "(Lcom/tencent/mm/plugin/textstatus/proto/GetCheersSignatureForWerunResp;)V", "getSource", "()I", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends p
  implements m
{
  public static final a TmD;
  private com.tencent.mm.plugin.textstatus.proto.c TmE;
  public d TmF;
  private h callback;
  private final String iconId;
  private final com.tencent.mm.am.c oDw;
  private final int source;
  
  static
  {
    AppMethodBeat.i(290545);
    TmD = new a((byte)0);
    AppMethodBeat.o(290545);
  }
  
  public c(String paramString, int paramInt)
  {
    AppMethodBeat.i(290527);
    this.iconId = paramString;
    this.source = paramInt;
    paramString = new com.tencent.mm.am.c.a();
    paramString.funcId = getType();
    paramString.uri = "/cgi-bin/mmbiz-bin/rank/getcheerssignatureforwerun";
    paramString.otE = ((a)new com.tencent.mm.plugin.textstatus.proto.c());
    paramString.otF = ((a)new d());
    paramString = paramString.bEF();
    kotlin.g.b.s.s(paramString, "commReqRespBuilder.buildInstance()");
    this.oDw = paramString;
    paramString = c.b.b(this.oDw.otB);
    if (paramString == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.GetCheersSignatureForWerunReq");
      AppMethodBeat.o(290527);
      throw paramString;
    }
    this.TmE = ((com.tencent.mm.plugin.textstatus.proto.c)paramString);
    this.TmE.ToD = this.iconId;
    this.TmE.source = this.source;
    Log.i("MicroMsg.TextStatus.NetSceneSportTextStatus", "iconId:" + this.iconId + " source:" + this.source);
    AppMethodBeat.o(290527);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(290555);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.oDw, (m)this);
    AppMethodBeat.o(290555);
    return i;
  }
  
  public final int getType()
  {
    return 4301;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(290576);
    Log.i("MicroMsg.TextStatus.NetSceneSportTextStatus", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = c.c.b(this.oDw.otC);
      if (params == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.GetCheersSignatureForWerunResp");
        AppMethodBeat.o(290576);
        throw paramString;
      }
      this.TmF = ((d)params);
    }
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(290576);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneSportTextStatus$Companion;", "", "()V", "TAG", "", "TEXT_STATUS_SPORT_SOURCE_PROFILE", "", "TEXT_STATUS_SPORT_SOURCE_RANK", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.c
 * JD-Core Version:    0.7.0.1
 */