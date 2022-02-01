package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.widget.twistad.TwistCoverView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap;
import com.tencent.mm.plugin.sns.ui.b.b.b.a;
import com.tencent.mm.plugin.sns.ui.c.a.a;
import com.tencent.mm.plugin.sns.ui.c.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class g
  extends b
{
  private AnimatorSet CPA;
  private boolean DsW;
  private ValueAnimator EUb;
  c EUm;
  
  public g(MMActivity paramMMActivity, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(203881);
    try
    {
      this.activity = paramMMActivity;
      this.EUm = ((c)parama);
      this.DsW = paramBoolean;
      paramMMActivity = this.EUm.ExX;
      int j = paramMMActivity.getHeight();
      int k = paramMMActivity.getWidth();
      parama = new int[2];
      paramMMActivity.getLocationInWindow(parama);
      int m = parama[0];
      int n = parama[1];
      parama = ObjectAnimator.ofFloat(paramMMActivity, "alpha", new float[] { 1.0F, 0.0F });
      parama.setDuration(400L);
      Object localObject = ap.ha(this.activity);
      int i1 = localObject[0];
      int i2 = localObject[1];
      int i = -90;
      if (this.DsW) {
        i = 90;
      }
      localObject = ObjectAnimator.ofFloat(paramMMActivity, "rotation", new float[] { 0.0F, i });
      ((ObjectAnimator)localObject).setDuration(400L);
      float f1 = 1.0F;
      if (j != 0) {
        f1 = i1 * 1.0F / j;
      }
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramMMActivity, "scaleX", new float[] { 1.0F, f1 });
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramMMActivity, "scaleY", new float[] { 1.0F, f1 });
      localObjectAnimator1.setDuration(400L);
      localObjectAnimator2.setDuration(400L);
      f1 = m;
      float f2 = k / 2.0F;
      float f3 = n;
      float f4 = j / 2.0F;
      float f5 = i1 / 2.0F;
      float f6 = i2 / 2.0F;
      ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(paramMMActivity, "translationX", new float[] { 0.0F, f5 - (f2 + f1) });
      paramMMActivity = ObjectAnimator.ofFloat(paramMMActivity, "translationY", new float[] { 0.0F, f6 - (f4 + f3) });
      localObjectAnimator3.setDuration(400L);
      paramMMActivity.setDuration(400L);
      this.EUb = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.EUb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(203878);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          g.this.EUm.wnX.setAlpha(f);
          g.this.EUm.EVh.setAlpha(f);
          AppMethodBeat.o(203878);
        }
      });
      this.EUb.setDuration(100L);
      this.CPA = new AnimatorSet();
      this.CPA.playTogether(new Animator[] { parama, localObject, localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, paramMMActivity, this.EUb });
      this.CPA.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(203880);
          Log.i("MicroMsg.FullCardAdDetailClickAnimation", "onAnimation end");
          paramAnonymousAnimator = g.this;
          Log.i("MicroMsg.FullCardAdDetailClickAnimation", "resetViewStatus");
          try
          {
            paramAnonymousAnimator.EUm.ExX.setScaleX(1.0F);
            paramAnonymousAnimator.EUm.ExX.setScaleY(1.0F);
            paramAnonymousAnimator.EUm.ExX.setAlpha(1.0F);
            paramAnonymousAnimator.EUm.ExX.setRotation(0.0F);
            paramAnonymousAnimator.EUm.ExX.setTranslationX(0.0F);
            paramAnonymousAnimator.EUm.ExX.setTranslationY(0.0F);
            paramAnonymousAnimator.EUm.wnX.setAlpha(1.0F);
            paramAnonymousAnimator.EUm.EVh.setAlpha(1.0F);
            paramAnonymousAnimator.EUm.EVy.setAlpha(1.0F);
            if (g.this.ETY != null) {
              g.this.ETY.onAnimationEnd();
            }
            AppMethodBeat.o(203880);
            return;
          }
          catch (Throwable paramAnonymousAnimator)
          {
            for (;;)
            {
              Log.e("MicroMsg.FullCardAdDetailClickAnimation", "resetViewStatus exp=" + paramAnonymousAnimator.toString());
            }
          }
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(203879);
          Log.i("MicroMsg.FullCardAdDetailClickAnimation", "onAnimation start");
          AppMethodBeat.o(203879);
        }
      });
      AppMethodBeat.o(203881);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      Log.e("MicroMsg.FullCardAdDetailClickAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(203881);
    }
  }
  
  public final void JW(long paramLong)
  {
    AppMethodBeat.i(203882);
    if ((this.CPA != null) && (!this.CPA.isStarted()))
    {
      this.CPA.setStartDelay(paramLong);
      this.CPA.start();
      if (this.EUm.EVy.getVisibility() == 0) {
        this.EUm.EVy.setAlpha(0.0F);
      }
    }
    AppMethodBeat.o(203882);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.g
 * JD-Core Version:    0.7.0.1
 */