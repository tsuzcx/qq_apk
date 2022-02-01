package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.flj;
import com.tencent.mm.protocal.protobuf.flk;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class ab
  extends q
  implements m
{
  flj Pyw;
  flk Pyx;
  private i callback;
  private d lKU;
  
  public ab(int paramInt)
  {
    AppMethodBeat.i(117635);
    this.Pyw = new flj();
    d.a locala = new d.a();
    locala.funcId = 1948;
    locala.uri = "/cgi-bin/mmsearch-bin/websearchconfig";
    locala.lBU = new flj();
    locala.lBV = new flk();
    this.lKU = locala.bgN();
    this.Pyw = ((flj)d.b.b(this.lKU.lBR));
    this.Pyw.Tkv = ai.anh(0);
    this.Pyw.vhq = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    this.Pyw.sSU = ai.anV();
    this.Pyw.TwK = ai.czn();
    this.Pyw.TwL = ai.gQO();
    this.Pyw.CPw = paramInt;
    this.Pyw.Sap = 0L;
    AppMethodBeat.o(117635);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(117636);
    this.callback = parami;
    int i = dispatch(paramg, this.lKU, this);
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
    this.Pyx = ((flk)d.c.b(this.lKU.lBS));
    if (this.Pyx != null) {
      Log.v("MicroMsg.WebSearch.NetSceneWebSearchConfig", "return data\n%s", new Object[] { this.Pyx.Tkw });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(117637);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ab
 * JD-Core Version:    0.7.0.1
 */