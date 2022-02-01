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
import com.tencent.mm.protocal.protobuf.ghv;
import com.tencent.mm.protocal.protobuf.ghw;

public final class ab
  extends a
  implements m
{
  public w WnS;
  private ghv WoB;
  public ghw WoC;
  private h callback;
  private c oDw;
  
  public ab(w paramw)
  {
    AppMethodBeat.i(315344);
    this.WnS = paramw;
    biq(this.WnS.hOG);
    this.WoB = new ghv();
    this.WoB.type = 1;
    this.WoB.YQb = paramw.content;
    this.WoC = new ghw();
    b.i("MicroMsg.WebSearch.NetSceneWebSearchAiScanImageRetrieval", "create NetSceneWebSearchAiScanImageRetrieval scene:%s requestKey:%s", new Object[] { Integer.valueOf(paramw.scene), paramw.hAT });
    paramw = new c.a();
    paramw.funcId = 1532;
    paramw.uri = "/cgi-bin/mmbiz-bin/usrmsg/aiscan_image_retrieval";
    paramw.otE = this.WoB;
    paramw.otF = this.WoC;
    this.oDw = paramw.bEF();
    AppMethodBeat.o(315344);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(315353);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
    AppMethodBeat.o(315353);
    return i;
  }
  
  public final int getType()
  {
    return 1532;
  }
  
  public final String ipG()
  {
    return this.WoC.YQb;
  }
  
  public final int ipH()
  {
    return 0;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(315346);
    b.i("MicroMsg.WebSearch.NetSceneWebSearchAiScanImageRetrieval", "netId: %s errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) || (paramInt3 == 0)) {
      this.WoC = ((ghw)c.c.b(this.oDw.otC));
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(315346);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ab
 * JD-Core Version:    0.7.0.1
 */