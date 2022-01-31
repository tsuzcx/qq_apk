package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.f.a;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.plugin.websearch.api.a.a;

final class e$13
  implements View.OnClickListener
{
  e$13(e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(1898);
    if (e.h(this.tkq) == f.a.tij)
    {
      this.tkq.getFSVideoUIComponent().cJc().tjk = true;
      e.i(this.tkq).GB(2);
    }
    if (this.tkq.getFSVideoUIComponent().cJc().isConnected())
    {
      e.a(this.tkq, f.a.tii);
      if (this.tkq.getFSVideoUIComponent().cJh().tjS) {
        this.tkq.getFSVideoUIComponent().cJh().ctY();
      }
      for (;;)
      {
        a.kS(19);
        AppMethodBeat.o(1898);
        return;
        this.tkq.Q(true, false);
      }
    }
    a.kS(20);
    AppMethodBeat.o(1898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.e.13
 * JD-Core Version:    0.7.0.1
 */