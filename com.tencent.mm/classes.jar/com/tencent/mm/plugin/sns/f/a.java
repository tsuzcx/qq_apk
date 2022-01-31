package com.tencent.mm.plugin.sns.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rt;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.b;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
  implements b.b
{
  public c rbF;
  
  public a()
  {
    AppMethodBeat.i(35875);
    this.rbF = new a.1(this);
    com.tencent.mm.sdk.b.a.ymk.c(this.rbF);
    ag.cpa().a(this);
    AppMethodBeat.o(35875);
  }
  
  public final void ZU(String paramString)
  {
    AppMethodBeat.i(35876);
    ab.i("MicroMsg.FTS.FTSSnsImageDownloadLogic", "onThumbFinish mediaId=%s", new Object[] { paramString });
    rt localrt = new rt();
    localrt.cIb.coO = 2;
    localrt.cIb.cBO = paramString;
    String str = ao.gl(ag.getAccSnsPath(), paramString);
    localrt.cIb.path = (str + i.Zx(paramString));
    com.tencent.mm.sdk.b.a.ymk.l(localrt);
    AppMethodBeat.o(35876);
  }
  
  public final void bp(String paramString, boolean paramBoolean) {}
  
  public final void bq(String paramString, boolean paramBoolean) {}
  
  public final void cnV() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.f.a
 * JD-Core Version:    0.7.0.1
 */