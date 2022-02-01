package com.tencent.mm.plugin.textstatus.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.cl;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.f.f.b;
import com.tencent.mm.plugin.textstatus.f.f.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusLike;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "topicId", "", "statusId", "userName", "action", "", "emotion", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getAction", "()I", "setAction", "(I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getEmotion", "request", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusLikeReq;", "response", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusLikeResp;", "getResponse", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusLikeResp;", "setResponse", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusLikeResp;)V", "getStatusId", "()Ljava/lang/String;", "setStatusId", "(Ljava/lang/String;)V", "getUserName", "setUserName", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-textstatus_release"})
public final class i
  extends q
  implements m
{
  public static final a FZh;
  private String FYf;
  private final com.tencent.mm.plugin.textstatus.g.s FZe;
  private com.tencent.mm.plugin.textstatus.g.t FZf;
  private final int FZg;
  private int action;
  private com.tencent.mm.ak.i callback;
  private final d iUB;
  private String userName;
  
  static
  {
    AppMethodBeat.i(216204);
    FZh = new a((byte)0);
    AppMethodBeat.o(216204);
  }
  
  public i(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216203);
    this.FYf = paramString2;
    this.userName = paramString3;
    this.action = paramInt1;
    this.FZg = paramInt2;
    paramString2 = new d.a();
    paramString2.sG(getType());
    paramString2.MB("/cgi-bin/micromsg-bin/textstatuslike");
    paramString2.c((com.tencent.mm.bw.a)new com.tencent.mm.plugin.textstatus.g.s());
    paramString2.d((com.tencent.mm.bw.a)new com.tencent.mm.plugin.textstatus.g.t());
    paramString2 = paramString2.aXF();
    p.g(paramString2, "commReqRespBuilder.buildInstance()");
    this.iUB = paramString2;
    paramString2 = this.iUB.aYJ();
    if (paramString2 == null)
    {
      paramString1 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusLikeReq");
      AppMethodBeat.o(216203);
      throw paramString1;
    }
    this.FZe = ((com.tencent.mm.plugin.textstatus.g.s)paramString2);
    this.FZe.GaI = paramString1;
    this.FZe.Gas = this.FYf;
    this.FZe.username = this.userName;
    this.FZe.GaR = this.action;
    this.FZe.type = this.FZg;
    Log.i("MicroMsg.TxtStatus.NetSceneTextStatusLike", "topicId:" + paramString1 + ", statusId:" + this.FYf + ", username:" + this.userName + ", action:" + this.action + ", type:" + this.FZg);
    AppMethodBeat.o(216203);
  }
  
  public final int doScene(g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(216201);
    p.h(paramg, "dispatcher");
    p.h(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.iUB, (m)this);
    AppMethodBeat.o(216201);
    return i;
  }
  
  public final int getType()
  {
    return 4099;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(216202);
    p.h(params, "rr");
    Log.i("MicroMsg.TxtStatus.NetSceneTextStatusLike", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.iUB.aYK();
      if (params == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusLikeResp");
        AppMethodBeat.o(216202);
        throw paramString;
      }
      this.FZf = ((com.tencent.mm.plugin.textstatus.g.t)params);
      params = f.FXJ;
      params = f.fvN();
      paramArrayOfByte = this.FYf;
      String str = com.tencent.mm.plugin.auth.a.a.ceA();
      p.g(str, "Account.username()");
      paramArrayOfByte = params.lc(paramArrayOfByte, str);
      if ((this.action != 1) || (paramArrayOfByte == null)) {
        break label202;
      }
      params = f.FXJ;
      f.fvN().b(paramArrayOfByte, new String[0]);
    }
    for (;;)
    {
      params = this.callback;
      if (params == null) {
        break;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(216202);
      return;
      label202:
      if (this.action != 1)
      {
        params = paramArrayOfByte;
        if (paramArrayOfByte == null) {
          params = new b();
        }
        params.field_HashUserName = com.tencent.mm.plugin.auth.a.a.ceA();
        params.field_TextStatusId = this.FYf;
        params.field_Type = this.FZg;
        params.field_Read = 1;
        params.field_CreateTime = cl.aWB();
        if ((int)params.systemRowid == -1)
        {
          paramArrayOfByte = f.FXJ;
          f.fvN().a(params);
        }
        else
        {
          paramArrayOfByte = f.FXJ;
          f.fvN().a(params, new String[0]);
        }
      }
    }
    AppMethodBeat.o(216202);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusLike$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.f.i
 * JD-Core Version:    0.7.0.1
 */