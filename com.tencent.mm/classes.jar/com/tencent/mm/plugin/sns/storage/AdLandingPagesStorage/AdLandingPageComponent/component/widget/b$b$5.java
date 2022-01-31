package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

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
    AppMethodBeat.i(37419);
    if (b.q(this.ryA.ryy) != null)
    {
      View localView = b.q(this.ryA.ryy).cmI();
      if (localView != null)
      {
        if ((b.C(this.ryA.ryy) == null) && (b.q(this.ryA.ryy).cmJ() != -1) && (b.k(this.ryA.ryy).get() != null)) {
          b.a(this.ryA.ryy, AnimationUtils.loadAnimation(((View)b.k(this.ryA.ryy).get()).getContext(), b.q(this.ryA.ryy).cmJ()));
        }
        if (b.C(this.ryA.ryy) != null) {
          localView.startAnimation(b.C(this.ryA.ryy));
        }
        localView.setVisibility(0);
      }
    }
    AppMethodBeat.o(37419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b.b.5
 * JD-Core Version:    0.7.0.1
 */