package com.tencent.mm.plugin.topstory.ui.home;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.sns.ui.SnsEditText;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;

final class TopStoryUploadUI$4
  implements MenuItem.OnMenuItemClickListener
{
  TopStoryUploadUI$4(TopStoryUploadUI paramTopStoryUploadUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(1683);
    if (this.thy.isFinishing())
    {
      AppMethodBeat.o(1683);
      return false;
    }
    if (System.currentTimeMillis() - TopStoryUploadUI.d(this.thy) < 500L)
    {
      AppMethodBeat.o(1683);
      return false;
    }
    com.tencent.mm.plugin.report.service.h.qsU.e(17080, new Object[] { Integer.valueOf(4), Integer.valueOf(2), TopStoryUploadUI.e(this.thy) });
    TopStoryUploadUI.a(this.thy, System.currentTimeMillis());
    paramMenuItem = TopStoryUploadUI.f(this.thy).getText().toString();
    if (paramMenuItem.length() > 200)
    {
      com.tencent.mm.ui.base.h.b(this.thy, this.thy.getString(2131304037), "", true);
      AppMethodBeat.o(1683);
      return true;
    }
    if (!TopStoryUploadUI.bDC())
    {
      com.tencent.mm.ui.base.h.b(this.thy, this.thy.getString(2131300044), "", true);
      e.qrI.idkeyStat(1032L, 1L, 1L, false);
      AppMethodBeat.o(1683);
      return true;
    }
    long l = System.currentTimeMillis();
    String str = TopStoryUploadUI.cIV();
    f localf = g.ca(TopStoryUploadUI.e(this.thy), true);
    this.thy.a(l, TopStoryUploadUI.g(this.thy), paramMenuItem, str, localf, TopStoryUploadUI.h(this.thy));
    AppMethodBeat.o(1683);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStoryUploadUI.4
 * JD-Core Version:    0.7.0.1
 */