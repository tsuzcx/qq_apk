package com.tencent.mm.plugin.product.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.fdf;
import com.tencent.mm.protocal.protobuf.fju;
import com.tencent.mm.protocal.protobuf.fjv;
import com.tencent.mm.sdk.platformtools.Log;

public final class j
  extends p
  implements m
{
  public String MQY;
  private h callback;
  private c rr;
  
  public j(fdf paramfdf)
  {
    AppMethodBeat.i(66903);
    c.a locala = new c.a();
    locala.otE = new fju();
    locala.otF = new fjv();
    locala.uri = "/cgi-bin/micromsg-bin/submitmallfreeorder";
    locala.funcId = 557;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    ((fju)c.b.b(this.rr.otB)).abKq = paramfdf;
    AppMethodBeat.o(66903);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(66905);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(66905);
    return i;
  }
  
  public final int getType()
  {
    return 557;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(66904);
    params = (fjv)c.c.b(((c)params).otC);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Log.d("MicroMsg.NetSceneMallSubmitMallFreeOrder", "resp.PrepareId " + params.abKr);
      this.MQY = params.abKr;
    }
    Log.d("MicroMsg.NetSceneMallSubmitMallFreeOrder", "errCode " + paramInt3 + ", errMsg " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(66904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.product.model.j
 * JD-Core Version:    0.7.0.1
 */