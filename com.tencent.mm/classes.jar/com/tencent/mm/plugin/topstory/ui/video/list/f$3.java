package com.tencent.mm.plugin.topstory.ui.video.list;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.o;

final class f$3
  implements View.OnClickListener
{
  f$3(f paramf) {}
  
  public final void onClick(View paramView)
  {
    this.pHJ.getListVideoUIComponent().bNt().pGp = 2;
    if ((this.pHJ.getListItemUIComponent() != null) && (this.pHJ.getListItemUIComponent().bNr() == this.pHJ.getListVideoUIComponent().bNB()))
    {
      paramView = this.pHJ;
      if (!this.pHJ.getListVideoUIComponent().bNs().pFL) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.jI(bool);
        return;
      }
    }
    this.pHJ.getListVideoUIComponent().zw(f.b(this.pHJ).bNr());
    this.pHJ.getListVideoUIComponent().bNt().c(f.c(this.pHJ));
    ((com.tencent.mm.plugin.topstory.a.b)g.t(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.pHJ.getListVideoUIComponent().bNv(), f.d(this.pHJ), f.e(this.pHJ).bNr(), 2, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.f.3
 * JD-Core Version:    0.7.0.1
 */