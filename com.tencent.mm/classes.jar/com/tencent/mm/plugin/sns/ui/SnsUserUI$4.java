package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.statusbar.c.a;
import com.tencent.mm.ui.statusbar.d;

final class SnsUserUI$4
  implements c.a
{
  SnsUserUI$4(SnsUserUI paramSnsUserUI) {}
  
  public final void pB(int paramInt)
  {
    AppMethodBeat.i(39788);
    SnsUserUI.n(this.sce).setPadding(0, paramInt, 0, 0);
    d.a(this.sce.getWindow());
    AppMethodBeat.o(39788);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUserUI.4
 * JD-Core Version:    0.7.0.1
 */