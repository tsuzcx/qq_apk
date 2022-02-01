package com.tencent.mm.plugin.newtips.a;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cim;
import com.tencent.mm.protocal.protobuf.cin;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;

public final class c
  extends n
  implements k
{
  private g callback;
  private String dpt;
  private b rr;
  
  public c(String paramString)
  {
    AppMethodBeat.i(184028);
    b.a locala = new b.a();
    locala.hvt = new cim();
    locala.hvu = new cin();
    locala.uri = "/cgi-bin/micromsg-bin/pushnewtips";
    locala.funcId = 597;
    this.rr = locala.aAz();
    ((cim)this.rr.hvr.hvw).FwB = paramString;
    this.dpt = paramString;
    AppMethodBeat.o(184028);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(184030);
    ac.d("MicroMsg.NewTips.NetScenePushNewTips", "doScene");
    this.callback = paramg;
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
      ac.e("MicroMsg.NewTips.NetScenePushNewTips", "errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(184029);
      return;
    }
    paramq = (cin)((b)paramq).hvs.hvw;
    paramArrayOfByte = this.dpt;
    boolean bool = paramq.FwC;
    ac.i("MicroMsg.NewTips.NewTipsHelper", "setLocalNewTipsState() uniqueId:%s isReject:%s", new Object[] { paramArrayOfByte, Boolean.valueOf(bool) });
    aw.aKT("new_tips").edit().putBoolean(paramArrayOfByte, bool).commit();
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    ac.i("MicroMsg.NewTips.NetScenePushNewTips", "onGYNetEnd() uniqueId:%s IsReject:%s", new Object[] { this.dpt, Boolean.valueOf(paramq.FwC) });
    AppMethodBeat.o(184029);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a.c
 * JD-Core Version:    0.7.0.1
 */