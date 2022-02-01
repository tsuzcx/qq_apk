package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bib;
import com.tencent.mm.protocal.protobuf.bic;

public final class p
  extends a
  implements k
{
  private bic DAV;
  private f callback;
  private com.tencent.mm.al.b hWL;
  
  public p(s params)
  {
    AppMethodBeat.i(217634);
    bib localbib = new bib();
    localbib.Scene = params.scene;
    localbib.GCZ = params.dlu;
    localbib.GDa = ad.We(0);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.WebSearch.NetSceneGetSearchResult", "create NetSceneGetSearchResult scene:%s requestKey:%s", new Object[] { Integer.valueOf(params.scene), params.dlu });
    params = new b.a();
    params.funcId = 1003;
    params.uri = "/cgi-bin/mmsearch-bin/getsearchresult";
    params.hNM = localbib;
    params.hNN = new bic();
    this.hWL = params.aDC();
    AppMethodBeat.o(217634);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(217635);
    this.callback = paramf;
    int i = dispatch(parame, this.hWL, this);
    AppMethodBeat.o(217635);
    return i;
  }
  
  public final String eLN()
  {
    if (this.DAV != null) {
      return this.DAV.GDb;
    }
    return null;
  }
  
  public final int eLO()
  {
    return 0;
  }
  
  public final int getType()
  {
    return 1003;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(217636);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.WebSearch.NetSceneGetSearchResult", "netId: %s errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.DAV = ((bic)this.hWL.hNL.hNQ);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(217636);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.p
 * JD-Core Version:    0.7.0.1
 */