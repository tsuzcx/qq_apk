package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.buo;
import com.tencent.mm.protocal.protobuf.bup;
import com.tencent.mm.sdk.platformtools.ab;

public final class w
  extends m
  implements k
{
  private f callback;
  public b fBd;
  private int scene;
  private String uJd;
  
  public w(buo parambuo)
  {
    AppMethodBeat.i(124072);
    b.a locala = new b.a();
    locala.funcId = 1134;
    locala.uri = "/cgi-bin/mmsearch-bin/searchreport";
    locala.fsX = parambuo;
    locala.fsY = new bup();
    this.fBd = locala.ado();
    this.scene = parambuo.Scene;
    this.uJd = parambuo.xHP;
    AppMethodBeat.o(124072);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(124074);
    ab.i("MicroMsg.FTS.NetSceneWebSearchReport", "doScene %d", new Object[] { Integer.valueOf(this.scene) });
    an.Jw(5);
    an.B(this.scene, 4, this.uJd);
    this.callback = paramf;
    int i = dispatch(parame, this.fBd, this);
    AppMethodBeat.o(124074);
    return i;
  }
  
  public final int getType()
  {
    return 1134;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124073);
    ab.i("MicroMsg.FTS.NetSceneWebSearchReport", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      an.Jw(7);
      AppMethodBeat.o(124073);
      return;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    an.Jw(6);
    an.a(this.scene, 5, paramInt2, paramInt3, this.uJd);
    AppMethodBeat.o(124073);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.w
 * JD-Core Version:    0.7.0.1
 */