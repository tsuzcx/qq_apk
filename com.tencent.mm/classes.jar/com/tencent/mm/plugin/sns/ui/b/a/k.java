package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.b.b.b.a;
import com.tencent.mm.plugin.sns.ui.c.a.b;
import com.tencent.mm.plugin.sns.ui.c.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class k
  extends a
{
  private AnimatorSet IVc;
  private ValueAnimator Lif;
  f Lio;
  
  public k(MMActivity paramMMActivity, b paramb)
  {
    AppMethodBeat.i(266574);
    try
    {
      this.activity = paramMMActivity;
      this.Lio = ((f)paramb);
      this.Lif = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.Lif.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(268494);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 0.0F)
          {
            k.this.Lio.JJt.setScaleX(f);
            k.this.Lio.JJt.setScaleY(f);
            k.this.Lio.JJt.setAlpha(f);
          }
          AppMethodBeat.o(268494);
        }
      });
      this.Lif.setDuration(400L);
      this.IVc = new AnimatorSet();
      this.IVc.playTogether(new Animator[] { this.Lif });
      this.IVc.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(253145);
          Log.i("MicroMsg.SlideFullCardItemAdBackAnimation", "onAnimation end");
          k.this.Lio.JJt.setScaleX(1.0F);
          k.this.Lio.JJt.setScaleY(1.0F);
          k.this.Lio.JJt.setAlpha(1.0F);
          if (k.this.Lia != null) {
            k.this.Lia.onAnimationEnd();
          }
          AppMethodBeat.o(253145);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(253142);
          Log.i("MicroMsg.SlideFullCardItemAdBackAnimation", "onAnimation start");
          AppMethodBeat.o(253142);
        }
      });
      AppMethodBeat.o(266574);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      Log.e("MicroMsg.SlideFullCardItemAdBackAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(266574);
    }
  }
  
  public final void Rq(long paramLong)
  {
    AppMethodBeat.i(266576);
    if ((this.IVc != null) && (!this.IVc.isStarted()))
    {
      this.IVc.setStartDelay(paramLong);
      this.IVc.start();
    }
    AppMethodBeat.o(266576);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.k
 * JD-Core Version:    0.7.0.1
 */