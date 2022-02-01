package com.tencent.mm.plugin.textstatus.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.h.f.b;
import com.tencent.mm.plugin.textstatus.proto.y;
import com.tencent.mm.plugin.textstatus.proto.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneDeleteSelfHistory;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "statusId", "", "scene", "", "(Ljava/lang/String;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getStatusId", "()Ljava/lang/String;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends p
  implements m
{
  public static final a Tmy;
  public final String Tly;
  private h callback;
  private final c oDw;
  
  static
  {
    AppMethodBeat.i(290533);
    Tmy = new a((byte)0);
    AppMethodBeat.o(290533);
  }
  
  public a(String paramString, int paramInt)
  {
    AppMethodBeat.i(290525);
    this.Tly = paramString;
    paramString = new c.a();
    paramString.funcId = getType();
    paramString.uri = "/cgi-bin/micromsg-bin/textstatusdeleteselfhistory";
    paramString.otE = ((com.tencent.mm.bx.a)new y());
    paramString.otF = ((com.tencent.mm.bx.a)new z());
    paramString = paramString.bEF();
    kotlin.g.b.s.s(paramString, "commReqRespBuilder.buildInstance()");
    this.oDw = paramString;
    paramString = c.b.b(this.oDw.otB);
    if (paramString == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusDeleteSelfHistoryReq");
      AppMethodBeat.o(290525);
      throw paramString;
    }
    paramString = (y)paramString;
    paramString.ToK = this.Tly;
    paramString.scene = paramInt;
    Log.i("MicroMsg.TextStatus.NetSceneDeleteSelfHistory", kotlin.g.b.s.X("statusId:", this.Tly));
    AppMethodBeat.o(290525);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, h paramh)
  {
    AppMethodBeat.i(290550);
    kotlin.g.b.s.u(paramg, "dispatcher");
    kotlin.g.b.s.u(paramh, "callback");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.oDw, (m)this);
    AppMethodBeat.o(290550);
    return i;
  }
  
  public final int getType()
  {
    return 5967;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(290560);
    kotlin.g.b.s.u(params, "rr");
    Log.i("MicroMsg.TextStatus.NetSceneDeleteSelfHistory", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    String str;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = f.TjQ;
      params = f.hGH();
      paramArrayOfByte = this.Tly;
      str = com.tencent.mm.plugin.auth.a.a.cUx();
      kotlin.g.b.s.s(str, "username()");
      kotlin.g.b.s.u(paramArrayOfByte, "statusId");
      kotlin.g.b.s.u(str, "userName");
      if (params.db.delete(com.tencent.mm.plugin.textstatus.h.f.g.ptT, "StatusID = ?", new String[] { paramArrayOfByte }) <= 0) {
        break label215;
      }
    }
    label215:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0)
      {
        b localb = (b)params.hHO().get(str);
        if ((localb != null) && (kotlin.g.b.s.p(localb.field_StatusID, paramArrayOfByte)))
        {
          params.hHO().remove(str);
          params.doNotify(str);
        }
      }
      params = this.callback;
      if (params != null) {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      }
      AppMethodBeat.o(290560);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneDeleteSelfHistory$Companion;", "", "()V", "TAG", "", "TEXT_STATUS_DELETE_SELF_HISTORY_SCENE_DELETE", "", "TEXT_STATUS_DELETE_SELF_HISTORY_SCENE_HIDE", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.a
 * JD-Core Version:    0.7.0.1
 */