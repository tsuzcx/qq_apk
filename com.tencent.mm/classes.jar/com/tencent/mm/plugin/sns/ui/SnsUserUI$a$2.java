package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.base.n.d;

final class SnsUserUI$a$2
  implements n.d
{
  SnsUserUI$a$2(SnsUserUI.a parama) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    case 0: 
      h.nFQ.f(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
      SnsUserUI.o(this.pjC.pjB);
      return;
    }
    h.nFQ.f(13822, new Object[] { Integer.valueOf(2), Integer.valueOf(2) });
    SnsUserUI.p(this.pjC.pjB).yW(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUserUI.a.2
 * JD-Core Version:    0.7.0.1
 */