package com.tencent.mm.plugin.textstatus.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.model.cm;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.g.e.b;
import com.tencent.mm.plugin.textstatus.g.e.c;
import com.tencent.mm.plugin.textstatus.proto.ai;
import com.tencent.mm.plugin.textstatus.proto.aj;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusLike;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "topicId", "", "statusId", "userName", "action", "", "emotion", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getAction", "()I", "setAction", "(I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getEmotion", "request", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusLikeReq;", "response", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusLikeResp;", "getResponse", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusLikeResp;", "setResponse", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusLikeResp;)V", "getStatusId", "()Ljava/lang/String;", "setStatusId", "(Ljava/lang/String;)V", "getUserName", "setUserName", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-textstatus_release"})
public final class l
  extends q
  implements m
{
  public static final l.a MDw;
  private String MBU;
  private final ai MDt;
  private aj MDu;
  private final int MDv;
  private int action;
  private i callback;
  private final d lKU;
  private String userName;
  
  static
  {
    AppMethodBeat.i(237724);
    MDw = new l.a((byte)0);
    AppMethodBeat.o(237724);
  }
  
  public l(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(237722);
    this.MBU = paramString2;
    this.userName = paramString3;
    this.action = paramInt1;
    this.MDv = paramInt2;
    paramString2 = new d.a();
    paramString2.vD(getType());
    paramString2.TW("/cgi-bin/micromsg-bin/textstatuslike");
    paramString2.c((com.tencent.mm.cd.a)new ai());
    paramString2.d((com.tencent.mm.cd.a)new aj());
    paramString2 = paramString2.bgN();
    p.j(paramString2, "commReqRespBuilder.buildInstance()");
    this.lKU = paramString2;
    paramString2 = this.lKU.bhX();
    if (paramString2 == null)
    {
      paramString1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusLikeReq");
      AppMethodBeat.o(237722);
      throw paramString1;
    }
    this.MDt = ((ai)paramString2);
    this.MDt.MFz = paramString1;
    this.MDt.MEN = this.MBU;
    this.MDt.username = this.userName;
    this.MDt.MFK = this.action;
    this.MDt.type = this.MDv;
    Log.i("MicroMsg.TextStatus.NetSceneTextStatusLike", "topicId:" + paramString1 + ", statusId:" + this.MBU + ", username:" + this.userName + ", action:" + this.action + ", type:" + this.MDv);
    AppMethodBeat.o(237722);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(237711);
    p.k(paramg, "dispatcher");
    p.k(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.lKU, (m)this);
    AppMethodBeat.o(237711);
    return i;
  }
  
  public final int getType()
  {
    return 4099;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(237718);
    p.k(params, "rr");
    Log.i("MicroMsg.TextStatus.NetSceneTextStatusLike", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.lKU.bhY();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusLikeResp");
        AppMethodBeat.o(237718);
        throw paramString;
      }
      this.MDu = ((aj)params);
      params = f.MAm;
      params = f.glz();
      paramArrayOfByte = this.MBU;
      String str = com.tencent.mm.plugin.auth.a.a.crN();
      p.j(str, "Account.username()");
      paramArrayOfByte = params.lz(paramArrayOfByte, str);
      if ((this.action != 1) || (paramArrayOfByte == null)) {
        break label202;
      }
      params = f.MAm;
      f.glz().b(paramArrayOfByte, new String[0]);
    }
    for (;;)
    {
      params = this.callback;
      if (params == null) {
        break;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(237718);
      return;
      label202:
      if (this.action != 1)
      {
        params = paramArrayOfByte;
        if (paramArrayOfByte == null) {
          params = new b();
        }
        params.field_HashUserName = com.tencent.mm.plugin.auth.a.a.crN();
        params.field_TextStatusId = this.MBU;
        params.field_Type = this.MDv;
        params.field_Read = 1;
        params.field_CreateTime = cm.bfF();
        if ((int)params.systemRowid == -1)
        {
          paramArrayOfByte = f.MAm;
          f.glz().a(params);
        }
        else
        {
          paramArrayOfByte = f.MAm;
          f.glz().a(params, new String[0]);
        }
      }
    }
    AppMethodBeat.o(237718);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.l
 * JD-Core Version:    0.7.0.1
 */