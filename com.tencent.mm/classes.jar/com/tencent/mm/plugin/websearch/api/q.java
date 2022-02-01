package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.audio.mix.h.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.crv;
import com.tencent.mm.protocal.protobuf.crw;

public final class q
  extends a
  implements m
{
  private w WnS;
  private crw WnT;
  private h callback;
  private c oDw;
  
  public q(w paramw)
  {
    AppMethodBeat.i(315360);
    this.WnS = paramw;
    biq(this.WnS.hOG);
    crv localcrv = new crv();
    localcrv.IJG = paramw.scene;
    localcrv.aayb = paramw.hAT;
    localcrv.aayc = aj.asY(0);
    b.i("MicroMsg.WebSearch.NetSceneGetSearchResult", "create NetSceneGetSearchResult scene:%s requestKey:%s", new Object[] { Integer.valueOf(paramw.scene), paramw.hAT });
    paramw = new c.a();
    paramw.funcId = 1003;
    paramw.uri = "/cgi-bin/mmsearch-bin/getsearchresult";
    paramw.otE = localcrv;
    paramw.otF = new crw();
    this.oDw = paramw.bEF();
    AppMethodBeat.o(315360);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(315365);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
    AppMethodBeat.o(315365);
    return i;
  }
  
  public final int getType()
  {
    return 1003;
  }
  
  public final String ipG()
  {
    if (this.WnT != null) {
      return this.WnT.aayd;
    }
    return null;
  }
  
  public final int ipH()
  {
    return 0;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(315375);
    b.i("MicroMsg.WebSearch.NetSceneGetSearchResult", "netId: %s errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.WnT = ((crw)c.c.b(this.oDw.otC));
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(315375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.q
 * JD-Core Version:    0.7.0.1
 */