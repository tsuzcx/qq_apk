package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cyj;
import com.tencent.mm.protocal.protobuf.cyk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class u
  extends m
  implements k
{
  private f callback;
  private b fBd;
  cyj uIZ;
  cyk uJa;
  
  public u(int paramInt)
  {
    AppMethodBeat.i(124066);
    this.uIZ = new cyj();
    b.a locala = new b.a();
    locala.funcId = 1948;
    locala.uri = "/cgi-bin/mmsearch-bin/websearchconfig";
    locala.fsX = new cyj();
    locala.fsY = new cyk();
    this.fBd = locala.ado();
    this.uIZ = ((cyj)this.fBd.fsV.fta);
    this.uIZ.xqT = aa.Jf(0);
    this.uIZ.lGH = com.tencent.mm.sdk.platformtools.aa.gP(ah.getContext());
    this.uIZ.wuH = aa.bXn();
    this.uIZ.xqU = aa.acv();
    this.uIZ.Scene = paramInt;
    this.uIZ.wBW = 0L;
    AppMethodBeat.o(124066);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(124067);
    this.callback = paramf;
    int i = dispatch(parame, this.fBd, this);
    AppMethodBeat.o(124067);
    return i;
  }
  
  public final int getType()
  {
    return 1948;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124068);
    ab.i("MicroMsg.WebSearch.NetSceneWebSearchConfig", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(124068);
      return;
    }
    this.uJa = ((cyk)this.fBd.fsW.fta);
    if (this.uJa != null) {
      ab.v("MicroMsg.WebSearch.NetSceneWebSearchConfig", "return data\n%s", new Object[] { this.uJa.wAa });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(124068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.u
 * JD-Core Version:    0.7.0.1
 */