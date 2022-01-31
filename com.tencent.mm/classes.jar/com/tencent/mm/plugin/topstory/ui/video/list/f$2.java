package com.tencent.mm.plugin.topstory.ui.video.list;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.f.a;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.plugin.websearch.api.a.a;

final class f$2
  implements View.OnClickListener
{
  f$2(f paramf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(2036);
    if (f.a(this.tlr) == f.a.tij)
    {
      this.tlr.getListVideoUIComponent().cJc().tjk = true;
      f.b(this.tlr).GB(2);
    }
    if (this.tlr.getListVideoUIComponent().cJc().isConnected())
    {
      f.a(this.tlr, f.a.tii);
      if (this.tlr.getListVideoUIComponent().cJh().tjS)
      {
        this.tlr.getListVideoUIComponent().cJh().ctY();
        this.tlr.cJB();
      }
      for (;;)
      {
        a.kS(19);
        AppMethodBeat.o(2036);
        return;
        this.tlr.Q(true, false);
      }
    }
    a.kS(20);
    AppMethodBeat.o(2036);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.f.2
 * JD-Core Version:    0.7.0.1
 */