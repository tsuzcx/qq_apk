package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.f;
import com.tencent.mm.plugin.topstory.ui.video.o;

final class e$13
  implements View.OnClickListener
{
  e$13(e parame) {}
  
  public final void onClick(View paramView)
  {
    if ((this.pGX.getFSItemUIComponent() != null) && (this.pGX.getFSItemUIComponent().bNr() != this.pGX.getFSVideoUIComponent().bNB()))
    {
      this.pGX.getFSVideoUIComponent().bNt().pGp = 2;
      this.pGX.getFSVideoUIComponent().zw(e.p(this.pGX).bNr());
      this.pGX.getFSVideoUIComponent().bNt().c(e.q(this.pGX));
      ((com.tencent.mm.plugin.topstory.a.b)g.t(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.pGX.getFSVideoUIComponent().bNv(), e.r(this.pGX), e.s(this.pGX).bNr(), 2, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.e.13
 * JD-Core Version:    0.7.0.1
 */