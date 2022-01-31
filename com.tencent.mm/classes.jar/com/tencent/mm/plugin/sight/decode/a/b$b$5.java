package com.tencent.mm.plugin.sight.decode.a;

import android.view.View;
import android.view.animation.AnimationUtils;
import java.lang.ref.WeakReference;

final class b$b$5
  implements Runnable
{
  b$b$5(b.b paramb) {}
  
  public final void run()
  {
    if (b.q(this.ofe.oeY) != null)
    {
      View localView = b.q(this.ofe.oeY).bBi();
      if (localView != null)
      {
        if ((b.C(this.ofe.oeY) == null) && (b.q(this.ofe.oeY).bBj() != -1) && (b.k(this.ofe.oeY).get() != null)) {
          b.a(this.ofe.oeY, AnimationUtils.loadAnimation(((View)b.k(this.ofe.oeY).get()).getContext(), b.q(this.ofe.oeY).bBj()));
        }
        if (b.C(this.ofe.oeY) != null) {
          localView.startAnimation(b.C(this.ofe.oeY));
        }
        localView.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.a.b.b.5
 * JD-Core Version:    0.7.0.1
 */