package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.view.View;
import android.view.animation.AnimationUtils;
import java.lang.ref.WeakReference;

final class a$b$5
  implements Runnable
{
  a$b$5(a.b paramb) {}
  
  public final void run()
  {
    if (a.q(this.oIC.oIA) != null)
    {
      View localView = a.q(this.oIC.oIA).bBi();
      if (localView != null)
      {
        if ((a.C(this.oIC.oIA) == null) && (a.q(this.oIC.oIA).bBj() != -1) && (a.k(this.oIC.oIA).get() != null)) {
          a.a(this.oIC.oIA, AnimationUtils.loadAnimation(((View)a.k(this.oIC.oIA).get()).getContext(), a.q(this.oIC.oIA).bBj()));
        }
        if (a.C(this.oIC.oIA) != null) {
          localView.startAnimation(a.C(this.oIC.oIA));
        }
        localView.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.b.5
 * JD-Core Version:    0.7.0.1
 */