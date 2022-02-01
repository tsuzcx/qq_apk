package com.tencent.mm.plugin.sns.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
  implements c.b
{
  public com.tencent.mm.sdk.b.c zuZ;
  
  public a()
  {
    AppMethodBeat.i(95172);
    this.zuZ = new com.tencent.mm.sdk.b.c() {};
    com.tencent.mm.sdk.b.a.IvT.c(this.zuZ);
    ah.dXz().a(this);
    AppMethodBeat.o(95172);
  }
  
  public final void azJ(String paramString)
  {
    AppMethodBeat.i(95173);
    ae.i("MicroMsg.FTS.FTSSnsImageDownloadLogic", "onThumbFinish mediaId=%s", new Object[] { paramString });
    ut localut = new ut();
    localut.dKd.dlO = 2;
    localut.dKd.mediaId = paramString;
    String str = ap.jv(ah.getAccSnsPath(), paramString);
    localut.dKd.path = (str + r.azi(paramString));
    com.tencent.mm.sdk.b.a.IvT.l(localut);
    AppMethodBeat.o(95173);
  }
  
  public final void bQ(String paramString, boolean paramBoolean) {}
  
  public final void bR(String paramString, boolean paramBoolean) {}
  
  public final void dWB() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.g.a
 * JD-Core Version:    0.7.0.1
 */