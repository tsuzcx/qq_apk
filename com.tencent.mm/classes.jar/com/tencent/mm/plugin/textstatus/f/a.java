package com.tencent.mm.plugin.textstatus.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.textstatus.g.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneDeleteSelfHistory;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "statusId", "", "scene", "", "(Ljava/lang/String;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getStatusId", "()Ljava/lang/String;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-textstatus_release"})
public final class a
  extends q
  implements m
{
  public static final a.a FYN;
  public final String FYf;
  private i callback;
  private final com.tencent.mm.ak.d iUB;
  
  static
  {
    AppMethodBeat.i(216174);
    FYN = new a.a((byte)0);
    AppMethodBeat.o(216174);
  }
  
  public a(String paramString, int paramInt)
  {
    AppMethodBeat.i(216173);
    this.FYf = paramString;
    paramString = new d.a();
    paramString.sG(getType());
    paramString.MB("/cgi-bin/micromsg-bin/textstatusdeleteselfhistory");
    paramString.c((com.tencent.mm.bw.a)new e());
    paramString.d((com.tencent.mm.bw.a)new com.tencent.mm.plugin.textstatus.g.f());
    paramString = paramString.aXF();
    p.g(paramString, "commReqRespBuilder.buildInstance()");
    this.iUB = paramString;
    paramString = this.iUB.aYJ();
    if (paramString == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusDeleteSelfHistoryReq");
      AppMethodBeat.o(216173);
      throw paramString;
    }
    paramString = (e)paramString;
    paramString.Gas = this.FYf;
    paramString.scene = paramInt;
    Log.i("MicroMsg.TxtStatus.NetSceneDeleteSelfHistory", "statusId:" + this.FYf);
    AppMethodBeat.o(216173);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(216171);
    p.h(paramg, "dispatcher");
    p.h(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.iUB, (m)this);
    AppMethodBeat.o(216171);
    return i;
  }
  
  public final int getType()
  {
    return 5967;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(216172);
    p.h(params, "rr");
    Log.i("MicroMsg.TxtStatus.NetSceneDeleteSelfHistory", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    String str;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = com.tencent.mm.plugin.textstatus.b.f.FXJ;
      params = com.tencent.mm.plugin.textstatus.b.f.fvM();
      paramArrayOfByte = this.FYf;
      str = com.tencent.mm.plugin.auth.a.a.ceA();
      p.g(str, "Account.username()");
      p.h(paramArrayOfByte, "statusId");
      p.h(str, "userName");
      if (params.db.delete(com.tencent.mm.plugin.textstatus.f.f.d.TABLE, "StatusID = ?", new String[] { paramArrayOfByte }) <= 0) {
        break label215;
      }
    }
    label215:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0)
      {
        com.tencent.mm.plugin.textstatus.f.f.a locala = (com.tencent.mm.plugin.textstatus.f.f.a)params.gWL().get(str);
        if ((locala != null) && (p.j(locala.field_StatusID, paramArrayOfByte)))
        {
          params.gWL().remove(str);
          params.doNotify(str);
        }
      }
      params = this.callback;
      if (params == null) {
        break;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(216172);
      return;
    }
    AppMethodBeat.o(216172);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.f.a
 * JD-Core Version:    0.7.0.1
 */