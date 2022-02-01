package com.tencent.mm.plugin.textstatus.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.textstatus.proto.j;
import com.tencent.mm.plugin.textstatus.proto.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneDeleteSelfHistory;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "statusId", "", "scene", "", "(Ljava/lang/String;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getStatusId", "()Ljava/lang/String;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-textstatus_release"})
public final class a
  extends q
  implements m
{
  public static final a.a MCX;
  public final String MBU;
  private i callback;
  private final d lKU;
  
  static
  {
    AppMethodBeat.i(238386);
    MCX = new a.a((byte)0);
    AppMethodBeat.o(238386);
  }
  
  public a(String paramString, int paramInt)
  {
    AppMethodBeat.i(238382);
    this.MBU = paramString;
    paramString = new d.a();
    paramString.vD(getType());
    paramString.TW("/cgi-bin/micromsg-bin/textstatusdeleteselfhistory");
    paramString.c((com.tencent.mm.cd.a)new j());
    paramString.d((com.tencent.mm.cd.a)new k());
    paramString = paramString.bgN();
    p.j(paramString, "commReqRespBuilder.buildInstance()");
    this.lKU = paramString;
    paramString = this.lKU.bhX();
    if (paramString == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusDeleteSelfHistoryReq");
      AppMethodBeat.o(238382);
      throw paramString;
    }
    paramString = (j)paramString;
    paramString.MEN = this.MBU;
    paramString.scene = paramInt;
    Log.i("MicroMsg.TextStatus.NetSceneDeleteSelfHistory", "statusId:" + this.MBU);
    AppMethodBeat.o(238382);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(238376);
    p.k(paramg, "dispatcher");
    p.k(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.lKU, (m)this);
    AppMethodBeat.o(238376);
    return i;
  }
  
  public final int getType()
  {
    return 5967;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(238380);
    p.k(params, "rr");
    Log.i("MicroMsg.TextStatus.NetSceneDeleteSelfHistory", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    String str;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = com.tencent.mm.plugin.textstatus.b.f.MAm;
      params = com.tencent.mm.plugin.textstatus.b.f.gly();
      paramArrayOfByte = this.MBU;
      str = com.tencent.mm.plugin.auth.a.a.crN();
      p.j(str, "Account.username()");
      p.k(paramArrayOfByte, "statusId");
      p.k(str, "userName");
      if (params.db.delete(com.tencent.mm.plugin.textstatus.g.e.f.Alf, "StatusID = ?", new String[] { paramArrayOfByte }) <= 0) {
        break label215;
      }
    }
    label215:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0)
      {
        com.tencent.mm.plugin.textstatus.g.e.a locala = (com.tencent.mm.plugin.textstatus.g.e.a)params.gmf().get(str);
        if ((locala != null) && (p.h(locala.field_StatusID, paramArrayOfByte)))
        {
          params.gmf().remove(str);
          params.doNotify(str);
        }
      }
      params = this.callback;
      if (params == null) {
        break;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(238380);
      return;
    }
    AppMethodBeat.o(238380);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.a
 * JD-Core Version:    0.7.0.1
 */