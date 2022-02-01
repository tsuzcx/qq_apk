package com.tencent.mm.plugin.websearch.api;

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
import com.tencent.mm.protocal.protobuf.ghy;
import com.tencent.mm.protocal.protobuf.ghz;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class ac
  extends p
  implements m
{
  ghy WoD;
  ghz WoE;
  private h callback;
  private c oDw;
  
  public ac(int paramInt)
  {
    AppMethodBeat.i(117635);
    this.WoD = new ghy();
    c.a locala = new c.a();
    locala.funcId = 1948;
    locala.uri = "/cgi-bin/mmsearch-bin/websearchconfig";
    locala.otE = new ghy();
    locala.otF = new ghz();
    this.oDw = locala.bEF();
    this.WoD = ((ghy)c.b.b(this.oDw.otB));
    this.WoD.aayc = aj.asY(0);
    this.WoD.yts = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    this.WoD.vYk = aj.gtA();
    this.WoD.aaLr = aj.dch();
    this.WoD.aaLs = aj.iqa();
    this.WoD.IJG = paramInt;
    this.WoD.YYo = 0L;
    AppMethodBeat.o(117635);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(117636);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
    AppMethodBeat.o(117636);
    return i;
  }
  
  public final int getType()
  {
    return 1948;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117637);
    Log.i("MicroMsg.WebSearch.NetSceneWebSearchConfig", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(117637);
      return;
    }
    this.WoE = ((ghz)c.c.b(this.oDw.otC));
    if (this.WoE != null) {
      Log.v("MicroMsg.WebSearch.NetSceneWebSearchConfig", "return data\n%s", new Object[] { this.WoE.aayd });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(117637);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ac
 * JD-Core Version:    0.7.0.1
 */