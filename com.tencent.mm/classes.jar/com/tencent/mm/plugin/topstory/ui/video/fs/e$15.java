package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.a;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.r;

final class e$15
  implements View.OnClickListener
{
  e$15(e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(1900);
    this.tkq.cJH();
    this.tkq.tkg.aFn();
    this.tkq.getFSVideoUIComponent().cJd().tjK = 2;
    this.tkq.getFSVideoUIComponent().cJh().a(this.tkq.getFSVideoUIComponent(), e.n(this.tkq), e.o(this.tkq), e.p(this.tkq).cJb());
    this.tkq.cJB();
    AppMethodBeat.o(1900);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.e.15
 * JD-Core Version:    0.7.0.1
 */