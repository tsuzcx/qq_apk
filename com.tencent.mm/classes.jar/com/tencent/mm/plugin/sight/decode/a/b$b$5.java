package com.tencent.mm.plugin.sight.decode.a;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class b$b$5
  implements Runnable
{
  b$b$5(b.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(70236);
    if (b.r(this.qTt.qTn) != null)
    {
      View localView = b.r(this.qTt.qTn).cmI();
      if (localView != null)
      {
        if ((b.D(this.qTt.qTn) == null) && (b.r(this.qTt.qTn).cmJ() != -1) && (b.l(this.qTt.qTn).get() != null)) {
          b.a(this.qTt.qTn, AnimationUtils.loadAnimation(((View)b.l(this.qTt.qTn).get()).getContext(), b.r(this.qTt.qTn).cmJ()));
        }
        if (b.D(this.qTt.qTn) != null) {
          localView.startAnimation(b.D(this.qTt.qTn));
        }
        localView.setVisibility(0);
      }
    }
    AppMethodBeat.o(70236);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.a.b.b.5
 * JD-Core Version:    0.7.0.1
 */