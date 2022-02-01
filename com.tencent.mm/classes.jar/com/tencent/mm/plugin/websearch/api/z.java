package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eqy;
import com.tencent.mm.protocal.protobuf.eqz;
import com.tencent.mm.sdk.platformtools.Log;

public final class z
  extends p
  implements m
{
  private String WoA;
  private h callback;
  private c oDw;
  private int scene;
  
  public z(eqy parameqy)
  {
    AppMethodBeat.i(117627);
    c.a locala = new c.a();
    locala.funcId = 1523;
    locala.uri = "/cgi-bin/mmsearch-bin/recsearchreport";
    locala.otE = parameqy;
    locala.otF = new eqz();
    this.oDw = locala.bEF();
    this.scene = parameqy.IJG;
    this.WoA = parameqy.abuE;
    AppMethodBeat.o(117627);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(117629);
    Log.i("MicroMsg.FTS.NetSceneWebSearchReport", "doScene %d", new Object[] { Integer.valueOf(this.scene) });
    as.atf(5);
    as.W(this.scene, 4, this.WoA);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
    AppMethodBeat.o(117629);
    return i;
  }
  
  public final int getType()
  {
    return 1523;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117628);
    Log.i("MicroMsg.FTS.NetSceneWebSearchReport", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      as.atf(7);
      AppMethodBeat.o(117628);
      return;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    as.atf(6);
    as.a(this.scene, 5, paramInt2, paramInt3, this.WoA);
    AppMethodBeat.o(117628);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.z
 * JD-Core Version:    0.7.0.1
 */