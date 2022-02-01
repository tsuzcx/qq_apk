package com.tencent.mm.plugin.sns.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.b;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
  implements b.b
{
  public c xOq;
  
  public a()
  {
    AppMethodBeat.i(95172);
    this.xOq = new c() {};
    com.tencent.mm.sdk.b.a.GpY.c(this.xOq);
    af.dHM().a(this);
    AppMethodBeat.o(95172);
  }
  
  public final void atn(String paramString)
  {
    AppMethodBeat.i(95173);
    ac.i("MicroMsg.FTS.FTSSnsImageDownloadLogic", "onThumbFinish mediaId=%s", new Object[] { paramString });
    tw localtw = new tw();
    localtw.dwD.cZu = 2;
    localtw.dwD.mediaId = paramString;
    String str = an.jc(af.getAccSnsPath(), paramString);
    localtw.dwD.path = (str + q.asM(paramString));
    com.tencent.mm.sdk.b.a.GpY.l(localtw);
    AppMethodBeat.o(95173);
  }
  
  public final void bF(String paramString, boolean paramBoolean) {}
  
  public final void bG(String paramString, boolean paramBoolean) {}
  
  public final void dGO() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.g.a
 * JD-Core Version:    0.7.0.1
 */