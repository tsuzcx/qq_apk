package com.tencent.mm.plugin.sns.ui;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.tools.e;

final class SnsOnlineVideoActivity$3
  implements ViewTreeObserver.OnPreDrawListener
{
  SnsOnlineVideoActivity$3(SnsOnlineVideoActivity paramSnsOnlineVideoActivity) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(39145);
    SnsOnlineVideoActivity.d(this.rUf).getViewTreeObserver().removeOnPreDrawListener(this);
    if (SnsOnlineVideoActivity.p(this.rUf) != null) {
      SnsOnlineVideoActivity.p(this.rUf).a(SnsOnlineVideoActivity.d(this.rUf), SnsOnlineVideoActivity.j(this.rUf), new SnsOnlineVideoActivity.3.1(this));
    }
    AppMethodBeat.o(39145);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.3
 * JD-Core Version:    0.7.0.1
 */