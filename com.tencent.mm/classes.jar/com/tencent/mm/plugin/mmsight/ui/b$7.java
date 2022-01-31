package com.tencent.mm.plugin.mmsight.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.al;

final class b$7
  implements View.OnClickListener
{
  b$7(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(55152);
    if ((!b.k(this.oOV)) && (b.d(this.oOV) <= b.l(this.oOV).duration))
    {
      b.a(this.oOV, b.b(this.oOV, -1));
      b.m(this.oOV).bSm();
      b.a(this.oOV, b.m(this.oOV).oQL);
      b.n(this.oOV);
    }
    if (!b.o(this.oOV))
    {
      if (b.a(this.oOV) != null)
      {
        al.d(new b.7.1(this));
        AppMethodBeat.o(55152);
      }
    }
    else
    {
      b.p(this.oOV);
      if ((!b.k(this.oOV)) && (b.q(this.oOV)) && (b.a(this.oOV) != null)) {
        al.d(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(55151);
            b.a(b.7.this.oOV).bRD();
            AppMethodBeat.o(55151);
          }
        });
      }
    }
    AppMethodBeat.o(55152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.b.7
 * JD-Core Version:    0.7.0.1
 */