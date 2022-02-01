package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dxu;
import com.tencent.mm.protocal.protobuf.dxv;
import com.tencent.mm.sdk.platformtools.Log;

public final class ad
  extends q
  implements m
{
  private String Pyt;
  private i callback;
  public d lKU;
  private int scene;
  
  public ad(dxu paramdxu)
  {
    AppMethodBeat.i(117641);
    d.a locala = new d.a();
    locala.funcId = 1134;
    locala.uri = "/cgi-bin/mmsearch-bin/searchreport";
    locala.lBU = paramdxu;
    locala.lBV = new dxv();
    this.lKU = locala.bgN();
    this.scene = paramdxu.CPw;
    this.Pyt = paramdxu.Udk;
    AppMethodBeat.o(117641);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(117643);
    Log.i("MicroMsg.FTS.NetSceneWebSearchReport", "doScene %d", new Object[] { Integer.valueOf(this.scene) });
    ar.anp(5);
    ar.N(this.scene, 4, this.Pyt);
    this.callback = parami;
    int i = dispatch(paramg, this.lKU, this);
    AppMethodBeat.o(117643);
    return i;
  }
  
  public final int getType()
  {
    return 1134;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117642);
    Log.i("MicroMsg.FTS.NetSceneWebSearchReport", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      ar.anp(7);
      AppMethodBeat.o(117642);
      return;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    ar.anp(6);
    ar.a(this.scene, 5, paramInt2, paramInt3, this.Pyt);
    AppMethodBeat.o(117642);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ad
 * JD-Core Version:    0.7.0.1
 */