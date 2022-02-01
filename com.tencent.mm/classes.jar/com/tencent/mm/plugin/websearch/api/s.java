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
import com.tencent.mm.protocal.protobuf.gic;
import com.tencent.mm.protocal.protobuf.gid;
import com.tencent.mm.ui.aw;

public final class s
  extends p
  implements m
{
  private gic WnQ;
  public gid WnR;
  public w WnS;
  private h callback;
  private c oDw;
  
  public s(w paramw)
  {
    AppMethodBeat.i(315355);
    this.WnS = paramw;
    paramw = new c.a();
    paramw.funcId = 719;
    paramw.uri = "/cgi-bin/micromsg-bin/mmwebsearch";
    paramw.otE = new gic();
    paramw.otF = new gid();
    this.oDw = paramw.bEF();
    this.WnQ = ((gic)c.b.b(this.oDw.otB));
    this.WnQ.aakp = this.WnS.hAB;
    this.WnQ.abuB = this.WnS.Wob;
    this.WnQ.YYo = this.WnS.businessType;
    this.WnQ.aaLr = aj.dch();
    this.WnQ.YYs = this.WnS.offset;
    this.WnQ.acet = aj.asY(0);
    this.WnQ.abyc = this.WnS.Woc;
    this.WnQ.IJG = this.WnS.scene;
    this.WnQ.YYr = this.WnS.xVe;
    this.WnQ.abuF = this.WnS.hVr;
    this.WnQ.aceu = this.WnS.Wod;
    this.WnQ.acew = this.WnS.Wof;
    this.WnQ.acev = this.WnS.Woe;
    this.WnQ.acex = this.WnS.Wog;
    this.WnQ.accs = this.WnS.Wol;
    this.WnQ.Wok = this.WnS.Wok;
    this.WnQ.acey = this.WnS.Wom;
    this.WnQ.yts = this.WnS.language;
    this.WnQ.acee = this.WnS.sessionId;
    paramw = this.WnQ;
    if (aw.isDarkMode()) {}
    for (int i = 1;; i = 0)
    {
      paramw.abgz = i;
      this.WnQ.aaLs = aj.iqa();
      AppMethodBeat.o(315355);
      return;
    }
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(315362);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
    AppMethodBeat.o(315362);
    return i;
  }
  
  public final int getType()
  {
    return 719;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(315369);
    b.i("MicroMsg.WebSearch.NetSceneMMWebSearch", "onGYNetEnd errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.WnR = ((gid)c.c.b(this.oDw.otC));
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(315369);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.s
 * JD-Core Version:    0.7.0.1
 */