package com.tencent.mm.plugin.scanner.box;

import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onShow"})
final class i$c
  implements DialogInterface.OnShowListener
{
  i$c(i parami) {}
  
  public final void onShow(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(240255);
    Object localObject1 = i.c(this.CCN);
    if (localObject1 != null)
    {
      Log.v("MicroMsg.BaseBoxDialogView", "alvinluo showDialog");
      ((BaseBoxDialogView)localObject1).yPa = false;
      ((BaseBoxDialogView)localObject1).isAnimating = true;
      ((BaseBoxDialogView)localObject1).CBW = 0;
      float f1 = ((BaseBoxDialogView)localObject1).getMaxTranslationY();
      float f2 = ((BaseBoxDialogView)localObject1).CBx;
      Object localObject2 = ((BaseBoxDialogView)localObject1).CBj;
      if (localObject2 == null) {
        p.btv("dialogContainer");
      }
      ((View)localObject2).setTranslationY(f1);
      localObject2 = ((BaseBoxDialogView)localObject1).CBj;
      if (localObject2 == null) {
        p.btv("dialogContainer");
      }
      localObject2 = ((View)localObject2).animate();
      if (localObject2 != null)
      {
        localObject2 = ((ViewPropertyAnimator)localObject2).translationY(f2);
        if (localObject2 != null)
        {
          localObject2 = ((ViewPropertyAnimator)localObject2).setInterpolator((TimeInterpolator)((BaseBoxDialogView)localObject1).CBV);
          if (localObject2 != null)
          {
            localObject2 = ((ViewPropertyAnimator)localObject2).setUpdateListener((ValueAnimator.AnimatorUpdateListener)new BaseBoxDialogView.l((BaseBoxDialogView)localObject1));
            if (localObject2 != null)
            {
              localObject2 = ((ViewPropertyAnimator)localObject2).setListener((Animator.AnimatorListener)new BaseBoxDialogView.m((BaseBoxDialogView)localObject1, f1, f2));
              if (localObject2 != null)
              {
                localObject2 = ((ViewPropertyAnimator)localObject2).setDuration(300L);
                if (localObject2 != null) {
                  ((ViewPropertyAnimator)localObject2).start();
                }
              }
            }
          }
        }
      }
      localObject2 = ((BaseBoxDialogView)localObject1).animator;
      ((ValueAnimator)localObject2).setInterpolator((TimeInterpolator)new DecelerateInterpolator());
      ((ValueAnimator)localObject2).setDuration(300L);
      ((ValueAnimator)localObject2).setFloatValues(new float[] { ((BaseBoxDialogView)localObject1).CBT.CBY, ((BaseBoxDialogView)localObject1).CBT.CBZ });
      ((ValueAnimator)localObject2).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new BaseBoxDialogView.e((BaseBoxDialogView)localObject1));
      ((ValueAnimator)localObject2).addListener((Animator.AnimatorListener)new BaseBoxDialogView.f((BaseBoxDialogView)localObject1));
      ((ValueAnimator)localObject2).setStartDelay(50L);
      ((ValueAnimator)localObject2).start();
    }
    localObject1 = i.d(this.CCN);
    if (localObject1 != null)
    {
      ((j)localObject1).onShow(paramDialogInterface);
      AppMethodBeat.o(240255);
      return;
    }
    AppMethodBeat.o(240255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.i.c
 * JD-Core Version:    0.7.0.1
 */