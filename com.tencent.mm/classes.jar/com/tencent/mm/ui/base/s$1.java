package com.tencent.mm.ui.base;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ci.a;

final class s$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  s$1(s params) {}
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(190369);
    if (s.d(this.Wlh).getLineCount() > 1) {
      s.d(this.Wlh).setTextSize(0, a.aY(this.Wlh.getContext(), a.e.DescTextSize));
    }
    s.d(this.Wlh).getViewTreeObserver().removeOnGlobalLayoutListener(this);
    AppMethodBeat.o(190369);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.s.1
 * JD-Core Version:    0.7.0.1
 */