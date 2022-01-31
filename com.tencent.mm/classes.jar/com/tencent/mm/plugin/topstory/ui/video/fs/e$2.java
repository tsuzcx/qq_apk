package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.f;
import com.tencent.mm.plugin.topstory.ui.video.o;

final class e$2
  implements View.OnClickListener
{
  e$2(e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(1878);
    if ((this.tkq.getFSItemUIComponent() != null) && (this.tkq.getFSItemUIComponent().cJb() != this.tkq.getFSVideoUIComponent().cJk()))
    {
      this.tkq.getFSVideoUIComponent().cJd().tjK = 2;
      this.tkq.getFSVideoUIComponent().Gz(e.q(this.tkq).cJb());
      this.tkq.getFSVideoUIComponent().cJd().g(e.r(this.tkq));
      ((com.tencent.mm.plugin.topstory.a.b)g.G(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.tkq.getFSVideoUIComponent().cJf(), e.s(this.tkq), e.t(this.tkq).cJb(), 2, "");
    }
    AppMethodBeat.o(1878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.e.2
 * JD-Core Version:    0.7.0.1
 */