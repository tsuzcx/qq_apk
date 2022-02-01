package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.audio.mix.h.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.gic;
import com.tencent.mm.protocal.protobuf.gid;

public final class y
  extends p
  implements m
{
  private gic WnQ;
  public gid WnR;
  public w WnS;
  private h callback;
  private c oDw;
  
  public y(w paramw)
  {
    AppMethodBeat.i(315381);
    this.WnS = paramw;
    c.a locala = new c.a();
    locala.funcId = 4858;
    locala.uri = "/cgi-bin/mmsearch-bin/mmtagsearch";
    locala.otE = new gic();
    locala.otF = new gid();
    this.oDw = locala.bEF();
    this.WnQ = ((gic)c.b.b(this.oDw.otB));
    paramw.a(this.WnQ, 6);
    AppMethodBeat.o(315381);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(315387);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
    AppMethodBeat.o(315387);
    return i;
  }
  
  public final int getType()
  {
    return 4858;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(315393);
    b.i("MicroMsg.WebSearch.NetSceneTagSearch", "onGYNetEnd errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.WnR = ((gid)c.c.b(this.oDw.otC));
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(315393);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.y
 * JD-Core Version:    0.7.0.1
 */