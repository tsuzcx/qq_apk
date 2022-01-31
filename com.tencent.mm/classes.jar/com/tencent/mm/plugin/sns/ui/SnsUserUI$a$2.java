package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.ui.base.n.d;

final class SnsUserUI$a$2
  implements n.d
{
  SnsUserUI$a$2(SnsUserUI.a parama) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(39809);
    long l = cb.abq();
    String str = i.ls(l);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(39809);
      return;
      h.qsU.e(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(2), str, Long.valueOf(l) });
      SnsUserUI.o(this.scf.sce);
      AppMethodBeat.o(39809);
      return;
      h.qsU.e(13822, new Object[] { Integer.valueOf(2), Integer.valueOf(2), str, Long.valueOf(l) });
      SnsUserUI.p(this.scf.sce).Fd(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUserUI.a.2
 * JD-Core Version:    0.7.0.1
 */