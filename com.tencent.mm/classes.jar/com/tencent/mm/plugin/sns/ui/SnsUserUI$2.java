package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.an.a;
import com.tencent.mm.sdk.platformtools.ab;

final class SnsUserUI$2
  implements Runnable
{
  SnsUserUI$2(SnsUserUI paramSnsUserUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(39786);
    if (SnsUserUI.l(this.sce))
    {
      ab.w("MicroMsg.SnsUserUI", "too fast that it finish");
      AppMethodBeat.o(39786);
      return;
    }
    SnsUserUI.b(this.sce).a(SnsUserUI.m(this.sce).getType(), SnsUserUI.c(this.sce), this.sce);
    if ((SnsUserUI.m(this.sce).getType() == 1) && (SnsUserUI.m(this.sce).cwj())) {
      ag.coV().E(ag.cpm().rig, -1);
    }
    if (!SnsUserUI.m(this.sce).cwj())
    {
      an.a locala = SnsUserUI.b(this.sce);
      int i = SnsUserUI.m(this.sce).getType();
      String str = SnsUserUI.c(this.sce);
      SnsUserUI.d(this.sce);
      locala.a(i, str, SnsUserUI.f(this.sce), SnsUserUI.e(this.sce));
    }
    AppMethodBeat.o(39786);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUserUI.2
 * JD-Core Version:    0.7.0.1
 */