package com.tencent.mm.plugin.sns.ui;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.tools.e;

final class SnsSightPlayerUI$3
  implements ViewTreeObserver.OnPreDrawListener
{
  SnsSightPlayerUI$3(SnsSightPlayerUI paramSnsSightPlayerUI) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(39249);
    this.rVT.qUt.getViewTreeObserver().removeOnPreDrawListener(this);
    this.rVT.kip.a(this.rVT.qUt, SnsSightPlayerUI.t(this.rVT), null);
    AppMethodBeat.o(39249);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.3
 * JD-Core Version:    0.7.0.1
 */