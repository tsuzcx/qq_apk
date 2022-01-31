package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.b.c.a;

final class SightUploadUI$5
  implements MenuItem.OnMenuItemClickListener
{
  SightUploadUI$5(SightUploadUI paramSightUploadUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(38590);
    if (this.rLy.isFinishing())
    {
      AppMethodBeat.o(38590);
      return false;
    }
    SightUploadUI.a(this.rLy, SightUploadUI.a(this.rLy).getText().toString());
    final int i = SightUploadUI.a(this.rLy).getPasterLen();
    paramMenuItem = c.d(SightUploadUI.a(this.rLy)).QS(b.MR());
    paramMenuItem.AyD = true;
    paramMenuItem.a(new c.a()
    {
      public final void JU() {}
      
      public final void kY(String paramAnonymousString)
      {
        AppMethodBeat.i(38588);
        paramAnonymousString = new PInt();
        SightUploadUI.j(SightUploadUI.5.this.rLy).a(SightUploadUI.c(SightUploadUI.5.this.rLy), 0, null, SightUploadUI.d(SightUploadUI.5.this.rLy), null, SightUploadUI.e(SightUploadUI.5.this.rLy).getLocation(), i, SightUploadUI.f(SightUploadUI.5.this.rLy), SightUploadUI.g(SightUploadUI.5.this.rLy), paramAnonymousString, "", SightUploadUI.h(SightUploadUI.5.this.rLy), SightUploadUI.i(SightUploadUI.5.this.rLy));
        com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.qsU;
        long l1 = SightUploadUI.k(SightUploadUI.5.this.rLy);
        long l2 = bo.aox();
        if (SightUploadUI.l(SightUploadUI.5.this.rLy))
        {
          i = 0;
          localh.e(13303, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(paramAnonymousString.value), i.cnT() });
          l1 = SightUploadUI.k(SightUploadUI.5.this.rLy);
          l2 = bo.aox();
          if (!SightUploadUI.l(SightUploadUI.5.this.rLy)) {
            break label283;
          }
        }
        label283:
        for (int i = 0;; i = 1)
        {
          ab.d("MicroMsg.SightUploadUI", "reprot timelinePostAction(13303), %d, %d, %d, %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(paramAnonymousString.value) });
          AppMethodBeat.o(38588);
          return;
          i = 1;
          break;
        }
      }
      
      public final void vn()
      {
        AppMethodBeat.i(38589);
        com.tencent.mm.ui.base.h.h(SightUploadUI.5.this.rLy, 2131304037, 2131304038);
        AppMethodBeat.o(38589);
      }
    });
    AppMethodBeat.o(38590);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SightUploadUI.5
 * JD-Core Version:    0.7.0.1
 */