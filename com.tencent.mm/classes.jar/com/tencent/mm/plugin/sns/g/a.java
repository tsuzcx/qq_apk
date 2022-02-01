package com.tencent.mm.plugin.sns.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.up;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.b;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  implements b.b
{
  public c zek;
  
  public a()
  {
    AppMethodBeat.i(95172);
    this.zek = new c() {};
    com.tencent.mm.sdk.b.a.IbL.c(this.zek);
    ag.dTZ().a(this);
    AppMethodBeat.o(95172);
  }
  
  public final void ays(String paramString)
  {
    AppMethodBeat.i(95173);
    ad.i("MicroMsg.FTS.FTSSnsImageDownloadLogic", "onThumbFinish mediaId=%s", new Object[] { paramString });
    up localup = new up();
    localup.dIP.dkM = 2;
    localup.dIP.mediaId = paramString;
    String str = ao.jo(ag.getAccSnsPath(), paramString);
    localup.dIP.path = (str + q.axR(paramString));
    com.tencent.mm.sdk.b.a.IbL.l(localup);
    AppMethodBeat.o(95173);
  }
  
  public final void bM(String paramString, boolean paramBoolean) {}
  
  public final void bN(String paramString, boolean paramBoolean) {}
  
  public final void dTb() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.g.a
 * JD-Core Version:    0.7.0.1
 */