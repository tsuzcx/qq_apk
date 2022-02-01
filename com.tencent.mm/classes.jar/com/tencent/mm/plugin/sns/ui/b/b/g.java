package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.timeline.b.b.a.a;
import com.tencent.mm.plugin.sns.ad.timeline.b.b.a.b;
import com.tencent.mm.plugin.sns.ad.widget.twistad.TwistCoverView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ar;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class g
  extends b
{
  private AnimatorSet Div;
  private boolean POw;
  private a.b RIM;
  
  public g(MMActivity paramMMActivity, final a.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(309340);
    try
    {
      Log.d("MicroMsg.FullCardAnim.simple_twist", "new FullCardAdSimpleTwistClickAnimationNew, source=" + paramb.Qcx.source + ", hash=" + hashCode());
      this.POw = paramBoolean;
      this.activity = paramMMActivity;
      this.RIM = paramb;
      Object localObject1 = paramb.Cxb;
      int j = ((View)localObject1).getHeight();
      int k = ((View)localObject1).getWidth();
      paramMMActivity = new int[2];
      ((View)localObject1).getLocationInWindow(paramMMActivity);
      int m = paramMMActivity[0];
      int n = paramMMActivity[1];
      paramMMActivity = ObjectAnimator.ofFloat(localObject1, "alpha", new float[] { 1.0F, 0.0F });
      paramMMActivity.setDuration(400L);
      Object localObject2 = ar.jR(this.activity);
      int i1 = localObject2[0];
      int i2 = localObject2[1];
      int i = -90;
      if (this.POw) {
        i = 90;
      }
      localObject2 = ObjectAnimator.ofFloat(localObject1, "rotation", new float[] { 0.0F, i });
      ((ObjectAnimator)localObject2).setDuration(400L);
      float f1 = 1.0F;
      if (j != 0) {
        f1 = i1 * 1.0F / j;
      }
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localObject1, "scaleX", new float[] { 1.0F, f1 });
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(localObject1, "scaleY", new float[] { 1.0F, f1 });
      localObjectAnimator1.setDuration(400L);
      localObjectAnimator2.setDuration(400L);
      f1 = m;
      float f2 = k / 2.0F;
      float f3 = n;
      float f4 = j / 2.0F;
      float f5 = i1 / 2.0F;
      float f6 = i2 / 2.0F;
      ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(localObject1, "translationX", new float[] { 0.0F, f5 - (f2 + f1) });
      localObject1 = ObjectAnimator.ofFloat(localObject1, "translationY", new float[] { 0.0F, f6 - (f4 + f3) });
      localObjectAnimator3.setDuration(400L);
      ((ObjectAnimator)localObject1).setDuration(400L);
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(309354);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          paramb.GBf.setAlpha(f);
          paramb.QbY.setAlpha(f);
          AppMethodBeat.o(309354);
        }
      });
      localValueAnimator.setDuration(100L);
      this.Div = new AnimatorSet();
      this.Div.playTogether(new Animator[] { paramMMActivity, localObject2, localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, localObject1, localValueAnimator });
      this.Div.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(309359);
          g.this.hqR();
          if (g.this.RIn != null) {
            g.this.RIn.onAnimationEnd();
          }
          paramb.Qcx.mtE = false;
          AppMethodBeat.o(309359);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      });
      AppMethodBeat.o(309340);
      return;
    }
    finally
    {
      Log.e("MicroMsg.FullCardAnim.simple_twist", "init exp=" + paramMMActivity.toString());
      hqR();
      AppMethodBeat.o(309340);
    }
  }
  
  protected final void hqR()
  {
    AppMethodBeat.i(309344);
    Log.i("MicroMsg.FullCardAnim.simple_twist", "resetViewStatus");
    try
    {
      this.RIM.Cxb.setScaleX(1.0F);
      this.RIM.Cxb.setScaleY(1.0F);
      this.RIM.Cxb.setAlpha(1.0F);
      this.RIM.Cxb.setRotation(0.0F);
      this.RIM.Cxb.setTranslationX(0.0F);
      this.RIM.Cxb.setTranslationY(0.0F);
      this.RIM.GBf.setAlpha(1.0F);
      this.RIM.QbY.setAlpha(1.0F);
      if ((this.RIM.Qcx.QbX instanceof com.tencent.mm.plugin.sns.ui.item.a.a.g))
      {
        TwistCoverView localTwistCoverView = ((com.tencent.mm.plugin.sns.ui.item.a.a.g)this.RIM.Qcx.QbX).ROg;
        if (localTwistCoverView != null) {
          localTwistCoverView.setAlpha(1.0F);
        }
      }
      AppMethodBeat.o(309344);
      return;
    }
    finally
    {
      Log.e("MicroMsg.FullCardAnim.simple_twist", "resetViewStatus exp=" + localObject.toString());
      AppMethodBeat.o(309344);
    }
  }
  
  public final void vz(long paramLong)
  {
    AppMethodBeat.i(309347);
    Log.d("MicroMsg.FullCardAnim.simple_twist", "startAnimation, hash=" + hashCode());
    if ((this.Div != null) && (!this.Div.isStarted()))
    {
      this.Div.setStartDelay(paramLong);
      this.Div.start();
      if ((this.RIM.Qcx.QbX instanceof com.tencent.mm.plugin.sns.ui.item.a.a.g))
      {
        TwistCoverView localTwistCoverView = ((com.tencent.mm.plugin.sns.ui.item.a.a.g)this.RIM.Qcx.QbX).ROg;
        if ((localTwistCoverView != null) && (localTwistCoverView.getVisibility() == 0)) {
          localTwistCoverView.setAlpha(0.0F);
        }
      }
    }
    AppMethodBeat.o(309347);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.g
 * JD-Core Version:    0.7.0.1
 */