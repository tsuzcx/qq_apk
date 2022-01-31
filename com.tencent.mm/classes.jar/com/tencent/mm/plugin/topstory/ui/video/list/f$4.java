package com.tencent.mm.plugin.topstory.ui.video.list;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.a;
import com.tencent.mm.plugin.topstory.ui.video.r;

final class f$4
  implements View.OnClickListener
{
  f$4(f paramf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(2038);
    this.tlr.cJH();
    f.g(this.tlr).aFn();
    this.tlr.getListVideoUIComponent().cJd().tjK = 2;
    this.tlr.getListVideoUIComponent().cJh().a(this.tlr.getListVideoUIComponent(), f.h(this.tlr), f.i(this.tlr), f.j(this.tlr).cJb());
    this.tlr.cJB();
    AppMethodBeat.o(2038);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.f.4
 * JD-Core Version:    0.7.0.1
 */