package com.tencent.mm.plugin.textstatus.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.model.cn;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.h.f.d;
import com.tencent.mm.plugin.textstatus.proto.ba;
import com.tencent.mm.plugin.textstatus.proto.bb;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusLike;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "topicId", "", "statusId", "userName", "action", "", "emotion", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getAction", "()I", "setAction", "(I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getEmotion", "request", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusLikeReq;", "response", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusLikeResp;", "getResponse", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusLikeResp;", "setResponse", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusLikeResp;)V", "getStatusId", "()Ljava/lang/String;", "setStatusId", "(Ljava/lang/String;)V", "getUserName", "setUserName", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends p
  implements com.tencent.mm.network.m
{
  public static final a TmV;
  private String Tly;
  private final int TmW;
  private final ba TmX;
  private bb TmY;
  private int action;
  private h callback;
  private final com.tencent.mm.am.c oDw;
  private String userName;
  
  static
  {
    AppMethodBeat.i(290516);
    TmV = new a((byte)0);
    AppMethodBeat.o(290516);
  }
  
  public m(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(290513);
    this.Tly = paramString2;
    this.userName = paramString3;
    this.action = paramInt1;
    this.TmW = paramInt2;
    paramString2 = new c.a();
    paramString2.funcId = getType();
    paramString2.uri = "/cgi-bin/micromsg-bin/textstatuslike";
    paramString2.otE = ((com.tencent.mm.bx.a)new ba());
    paramString2.otF = ((com.tencent.mm.bx.a)new bb());
    paramString2 = paramString2.bEF();
    kotlin.g.b.s.s(paramString2, "commReqRespBuilder.buildInstance()");
    this.oDw = paramString2;
    paramString2 = c.b.b(this.oDw.otB);
    if (paramString2 == null)
    {
      paramString1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusLikeReq");
      AppMethodBeat.o(290513);
      throw paramString1;
    }
    this.TmX = ((ba)paramString2);
    this.TmX.TpK = paramString1;
    this.TmX.ToK = this.Tly;
    this.TmX.username = this.userName;
    this.TmX.Tqd = this.action;
    this.TmX.type = this.TmW;
    Log.i("MicroMsg.TextStatus.NetSceneTextStatusLike", "topicId:" + paramString1 + ", statusId:" + this.Tly + ", username:" + this.userName + ", action:" + this.action + ", type:" + this.TmW);
    AppMethodBeat.o(290513);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(290526);
    kotlin.g.b.s.u(paramg, "dispatcher");
    kotlin.g.b.s.u(paramh, "callback");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.oDw, (com.tencent.mm.network.m)this);
    AppMethodBeat.o(290526);
    return i;
  }
  
  public final int getType()
  {
    return 4099;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(290546);
    kotlin.g.b.s.u(params, "rr");
    Log.i("MicroMsg.TextStatus.NetSceneTextStatusLike", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = c.c.b(this.oDw.otC);
      if (params == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusLikeResp");
        AppMethodBeat.o(290546);
        throw paramString;
      }
      this.TmY = ((bb)params);
      params = f.TjQ;
      params = f.hGI();
      paramArrayOfByte = this.Tly;
      String str = com.tencent.mm.plugin.auth.a.a.cUx();
      kotlin.g.b.s.s(str, "username()");
      paramArrayOfByte = params.ni(paramArrayOfByte, str);
      if ((this.action != 1) || (paramArrayOfByte == null)) {
        break label206;
      }
      params = f.TjQ;
      f.hGI().b(paramArrayOfByte, new String[0]);
    }
    for (;;)
    {
      params = this.callback;
      if (params != null) {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      }
      AppMethodBeat.o(290546);
      return;
      label206:
      if (this.action != 1)
      {
        params = paramArrayOfByte;
        if (paramArrayOfByte == null) {
          params = new com.tencent.mm.plugin.textstatus.h.f.c();
        }
        params.field_HashUserName = com.tencent.mm.plugin.auth.a.a.cUx();
        params.field_TextStatusId = this.Tly;
        params.field_Type = this.TmW;
        params.field_Read = 1;
        params.field_CreateTime = cn.getSyncServerTimeSecond();
        if ((int)params.systemRowid == -1)
        {
          paramArrayOfByte = f.TjQ;
          f.hGI().a(params);
        }
        else
        {
          paramArrayOfByte = f.TjQ;
          f.hGI().a(params, new String[0]);
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusLike$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.m
 * JD-Core Version:    0.7.0.1
 */