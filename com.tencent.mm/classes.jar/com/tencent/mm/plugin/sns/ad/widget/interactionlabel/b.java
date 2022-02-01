package com.tencent.mm.plugin.sns.ad.widget.interactionlabel;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class b
{
  private View Qgo;
  AnimatorSet Qgq;
  boolean Qgr;
  
  public b(View paramView)
  {
    this.Qgo = paramView;
  }
  
  public final void cKI()
  {
    AppMethodBeat.i(310234);
    Object localObject;
    int i;
    int j;
    if (this.Qgq == null)
    {
      localObject = this.Qgo;
      i = ((View)localObject).getWidth();
      j = ((View)localObject).getHeight();
      if ((j != 0) && (i != 0)) {
        break label63;
      }
    }
    for (;;)
    {
      if (this.Qgq != null) {
        this.Qgq.start();
      }
      this.Qgr = false;
      AppMethodBeat.o(310234);
      return;
      label63:
      ((View)localObject).setPivotX(i);
      ((View)localObject).setPivotY(j - a.fromDPToPix(MMApplicationContext.getContext(), 2));
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localObject, "rotation", new float[] { 0.0F, -5.0F });
      localObjectAnimator1.setDuration(250L);
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(localObject, "rotation", new float[] { -5.0F, 5.0F });
      localObjectAnimator2.setDuration(250L);
      ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(localObject, "rotation", new float[] { 5.0F, -5.0F });
      localObjectAnimator3.setDuration(250L);
      ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(localObject, "rotation", new float[] { -5.0F, 5.0F });
      localObjectAnimator4.setDuration(250L);
      ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofFloat(localObject, "rotation", new float[] { 5.0F, -5.0F });
      localObjectAnimator5.setDuration(250L);
      ObjectAnimator localObjectAnimator6 = ObjectAnimator.ofFloat(localObject, "rotation", new float[] { -5.0F, 5.0F });
      localObjectAnimator6.setDuration(250L);
      ObjectAnimator localObjectAnimator7 = ObjectAnimator.ofFloat(localObject, "rotation", new float[] { 5.0F, 0.0F });
      localObjectAnimator7.setDuration(250L);
      localObject = ObjectAnimator.ofFloat(localObject, "rotation", new float[] { 0.0F, 0.0F });
      ((ObjectAnimator)localObject).setDuration(500L);
      this.Qgq = new AnimatorSet();
      this.Qgq.playSequentially(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, localObjectAnimator4, localObjectAnimator5, localObjectAnimator6, localObjectAnimator7, localObject });
      this.Qgq.addListener(new com.tencent.mm.plugin.sns.ad.widget.b()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(310221);
          new StringBuilder("onAnimationEnd, isStoped=").append(b.this.Qgr);
          if (!b.this.Qgr) {
            b.this.Qgq.start();
          }
          AppMethodBeat.o(310221);
        }
      });
    }
  }
  
  public final void dxz()
  {
    AppMethodBeat.i(310240);
    this.Qgr = true;
    if (this.Qgq != null) {
      this.Qgq.end();
    }
    AppMethodBeat.o(310240);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.interactionlabel.b
 * JD-Core Version:    0.7.0.1
 */