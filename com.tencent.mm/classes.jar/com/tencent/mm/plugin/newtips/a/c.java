package com.tencent.mm.plugin.newtips.a;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cog;
import com.tencent.mm.protocal.protobuf.coh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;

public final class c
  extends n
  implements k
{
  private f callback;
  private String dCl;
  private b rr;
  
  public c(String paramString)
  {
    AppMethodBeat.i(184028);
    b.a locala = new b.a();
    locala.hQF = new cog();
    locala.hQG = new coh();
    locala.uri = "/cgi-bin/micromsg-bin/pushnewtips";
    locala.funcId = 597;
    this.rr = locala.aDS();
    ((cog)this.rr.hQD.hQJ).HAh = paramString;
    this.dCl = paramString;
    AppMethodBeat.o(184028);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(184030);
    ae.d("MicroMsg.NewTips.NetScenePushNewTips", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(184030);
    return i;
  }
  
  public final int getType()
  {
    return 597;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(184029);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ae.e("MicroMsg.NewTips.NetScenePushNewTips", "errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(184029);
      return;
    }
    paramq = (coh)((b)paramq).hQE.hQJ;
    paramArrayOfByte = this.dCl;
    boolean bool = paramq.HAi;
    ae.i("MicroMsg.NewTips.NewTipsHelper", "setLocalNewTipsState() uniqueId:%s isReject:%s", new Object[] { paramArrayOfByte, Boolean.valueOf(bool) });
    ay.aRW("new_tips").edit().putBoolean(paramArrayOfByte, bool).commit();
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    ae.i("MicroMsg.NewTips.NetScenePushNewTips", "onGYNetEnd() uniqueId:%s IsReject:%s", new Object[] { this.dCl, Boolean.valueOf(paramq.HAi) });
    AppMethodBeat.o(184029);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a.c
 * JD-Core Version:    0.7.0.1
 */