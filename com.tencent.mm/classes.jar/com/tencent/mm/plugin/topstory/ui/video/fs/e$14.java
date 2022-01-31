package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.f;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.o;

final class e$14
  implements View.OnClickListener
{
  e$14(e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(1899);
    this.tkq.getFSVideoUIComponent().cJd().tjK = 2;
    if ((this.tkq.getFSItemUIComponent() != null) && (this.tkq.getFSItemUIComponent().cJb() == this.tkq.getFSVideoUIComponent().cJk()))
    {
      paramView = this.tkq;
      if (!this.tkq.getFSVideoUIComponent().cJc().tjk) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.Q(bool, false);
        AppMethodBeat.o(1899);
        return;
      }
    }
    this.tkq.getFSVideoUIComponent().Gz(e.j(this.tkq).cJb());
    this.tkq.getFSVideoUIComponent().cJd().g(e.k(this.tkq));
    ((com.tencent.mm.plugin.topstory.a.b)g.G(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.tkq.getFSVideoUIComponent().cJf(), e.l(this.tkq), e.m(this.tkq).cJb(), 2, "");
    AppMethodBeat.o(1899);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.e.14
 * JD-Core Version:    0.7.0.1
 */