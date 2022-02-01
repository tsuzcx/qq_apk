package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tn;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.b;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  implements b.b
{
  public c wBV;
  
  public a()
  {
    AppMethodBeat.i(95172);
    this.wBV = new c() {};
    com.tencent.mm.sdk.b.a.ESL.c(this.wBV);
    af.dtp().a(this);
    AppMethodBeat.o(95172);
  }
  
  public final void aob(String paramString)
  {
    AppMethodBeat.i(95173);
    ad.i("MicroMsg.FTS.FTSSnsImageDownloadLogic", "onThumbFinish mediaId=%s", new Object[] { paramString });
    tn localtn = new tn();
    localtn.dyR.dbV = 2;
    localtn.dyR.mediaId = paramString;
    String str = an.iF(af.getAccSnsPath(), paramString);
    localtn.dyR.path = (str + q.anA(paramString));
    com.tencent.mm.sdk.b.a.ESL.l(localtn);
    AppMethodBeat.o(95173);
  }
  
  public final void by(String paramString, boolean paramBoolean) {}
  
  public final void bz(String paramString, boolean paramBoolean) {}
  
  public final void dsp() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.a
 * JD-Core Version:    0.7.0.1
 */