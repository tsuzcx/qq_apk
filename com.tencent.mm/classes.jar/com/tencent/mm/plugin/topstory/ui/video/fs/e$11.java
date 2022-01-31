package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.f;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.o;

final class e$11
  implements View.OnClickListener
{
  e$11(e parame) {}
  
  public final void onClick(View paramView)
  {
    this.pGX.getFSVideoUIComponent().bNt().pGp = 2;
    if ((this.pGX.getFSItemUIComponent() != null) && (this.pGX.getFSItemUIComponent().bNr() == this.pGX.getFSVideoUIComponent().bNB()))
    {
      paramView = this.pGX;
      if (!this.pGX.getFSVideoUIComponent().bNs().pFL) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.jI(bool);
        return;
      }
    }
    this.pGX.getFSVideoUIComponent().zw(e.h(this.pGX).bNr());
    this.pGX.getFSVideoUIComponent().bNt().c(e.i(this.pGX));
    ((com.tencent.mm.plugin.topstory.a.b)g.t(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.pGX.getFSVideoUIComponent().bNv(), e.j(this.pGX), e.k(this.pGX).bNr(), 2, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.e.11
 * JD-Core Version:    0.7.0.1
 */