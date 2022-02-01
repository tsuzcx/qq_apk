package com.tencent.mm.plugin.newtips.a;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cnm;
import com.tencent.mm.protocal.protobuf.cnn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;

public final class c
  extends n
  implements k
{
  private f callback;
  private String dBg;
  private b rr;
  
  public c(String paramString)
  {
    AppMethodBeat.i(184028);
    b.a locala = new b.a();
    locala.hNM = new cnm();
    locala.hNN = new cnn();
    locala.uri = "/cgi-bin/micromsg-bin/pushnewtips";
    locala.funcId = 597;
    this.rr = locala.aDC();
    ((cnm)this.rr.hNK.hNQ).HgH = paramString;
    this.dBg = paramString;
    AppMethodBeat.o(184028);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(184030);
    ad.d("MicroMsg.NewTips.NetScenePushNewTips", "doScene");
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
      ad.e("MicroMsg.NewTips.NetScenePushNewTips", "errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(184029);
      return;
    }
    paramq = (cnn)((b)paramq).hNL.hNQ;
    paramArrayOfByte = this.dBg;
    boolean bool = paramq.HgI;
    ad.i("MicroMsg.NewTips.NewTipsHelper", "setLocalNewTipsState() uniqueId:%s isReject:%s", new Object[] { paramArrayOfByte, Boolean.valueOf(bool) });
    ax.aQz("new_tips").edit().putBoolean(paramArrayOfByte, bool).commit();
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    ad.i("MicroMsg.NewTips.NetScenePushNewTips", "onGYNetEnd() uniqueId:%s IsReject:%s", new Object[] { this.dBg, Boolean.valueOf(paramq.HgI) });
    AppMethodBeat.o(184029);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a.c
 * JD-Core Version:    0.7.0.1
 */