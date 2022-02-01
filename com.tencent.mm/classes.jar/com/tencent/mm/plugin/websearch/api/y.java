package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.protocal.protobuf.dod;
import com.tencent.mm.sdk.platformtools.Log;

public final class y
  extends q
  implements m
{
  private String IEd;
  private i callback;
  private d iUB;
  private int scene;
  
  public y(doc paramdoc)
  {
    AppMethodBeat.i(117627);
    d.a locala = new d.a();
    locala.funcId = 1523;
    locala.uri = "/cgi-bin/mmsearch-bin/recsearchreport";
    locala.iLN = paramdoc;
    locala.iLO = new dod();
    this.iUB = locala.aXF();
    this.scene = paramdoc.Scene;
    this.IEd = paramdoc.MRe;
    AppMethodBeat.o(117627);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(117629);
    Log.i("MicroMsg.FTS.NetSceneWebSearchReport", "doScene %d", new Object[] { Integer.valueOf(this.scene) });
    ar.afB(5);
    ar.O(this.scene, 4, this.IEd);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
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
      ar.afB(7);
      AppMethodBeat.o(117628);
      return;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    ar.afB(6);
    ar.a(this.scene, 5, paramInt2, paramInt3, this.IEd);
    AppMethodBeat.o(117628);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.y
 * JD-Core Version:    0.7.0.1
 */