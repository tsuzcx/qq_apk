package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.faq;
import com.tencent.mm.protocal.protobuf.far;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class ab
  extends q
  implements m
{
  faq IEg;
  far IEh;
  private i callback;
  private d iUB;
  
  public ab(int paramInt)
  {
    AppMethodBeat.i(117635);
    this.IEg = new faq();
    d.a locala = new d.a();
    locala.funcId = 1948;
    locala.uri = "/cgi-bin/mmsearch-bin/websearchconfig";
    locala.iLN = new faq();
    locala.iLO = new far();
    this.iUB = locala.aXF();
    this.IEg = ((faq)this.iUB.iLK.iLR);
    this.IEg.MaY = ai.aft(0);
    this.IEg.rBI = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    this.IEg.pLm = ai.ait();
    this.IEg.MlQ = ai.clJ();
    this.IEg.MlR = ai.fYd();
    this.IEg.Scene = paramInt;
    this.IEg.KZg = 0L;
    AppMethodBeat.o(117635);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(117636);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
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
    this.IEh = ((far)this.iUB.iLL.iLR);
    if (this.IEh != null) {
      Log.v("MicroMsg.WebSearch.NetSceneWebSearchConfig", "return data\n%s", new Object[] { this.IEh.MaZ });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(117637);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ab
 * JD-Core Version:    0.7.0.1
 */