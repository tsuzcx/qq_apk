package com.tencent.mm.plugin.topstory.ui.video.list;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.o;

final class f$3
  implements View.OnClickListener
{
  f$3(f paramf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(2037);
    this.tlr.getListVideoUIComponent().cJd().tjK = 2;
    if ((this.tlr.getListItemUIComponent() != null) && (this.tlr.getListItemUIComponent().cJb() == this.tlr.getListVideoUIComponent().cJk()))
    {
      paramView = this.tlr;
      if (!this.tlr.getListVideoUIComponent().cJc().tjk) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.Q(bool, false);
        AppMethodBeat.o(2037);
        return;
      }
    }
    this.tlr.getListVideoUIComponent().Gz(f.c(this.tlr).cJb());
    this.tlr.getListVideoUIComponent().cJd().g(f.d(this.tlr));
    ((com.tencent.mm.plugin.topstory.a.b)g.G(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.tlr.getListVideoUIComponent().cJf(), f.e(this.tlr), f.f(this.tlr).cJb(), 2, "");
    AppMethodBeat.o(2037);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.f.3
 * JD-Core Version:    0.7.0.1
 */