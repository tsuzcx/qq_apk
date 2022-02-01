package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.b.b.b.a;
import com.tencent.mm.plugin.sns.ui.c.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class l
  extends b
{
  private AnimatorSet IVc;
  private ValueAnimator Lif;
  f Lio;
  
  public l(MMActivity paramMMActivity, com.tencent.mm.plugin.sns.ui.c.a.b paramb)
  {
    AppMethodBeat.i(196879);
    try
    {
      this.activity = paramMMActivity;
      this.Lio = ((f)paramb);
      this.Lif = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.Lif.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(258914);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 1.0F)
          {
            l.this.Lio.JJt.setScaleX(f);
            l.this.Lio.JJt.setScaleY(f);
            l.this.Lio.JJt.setAlpha(f);
          }
          AppMethodBeat.o(258914);
        }
      });
      this.Lif.setDuration(400L);
      this.IVc = new AnimatorSet();
      this.IVc.playTogether(new Animator[] { this.Lif });
      this.IVc.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(247765);
          Log.i("MicroMsg.SlideFullCardItemAdClickAnimation", "onAnimation end");
          l.this.Lio.JJt.setScaleX(1.0F);
          l.this.Lio.JJt.setScaleY(1.0F);
          l.this.Lio.JJt.setAlpha(1.0F);
          if (l.this.Lia != null) {
            l.this.Lia.onAnimationEnd();
          }
          AppMethodBeat.o(247765);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(247763);
          Log.i("MicroMsg.SlideFullCardItemAdClickAnimation", "onAnimation start");
          AppMethodBeat.o(247763);
        }
      });
      AppMethodBeat.o(196879);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      Log.e("MicroMsg.SlideFullCardItemAdClickAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(196879);
    }
  }
  
  public final void Rq(long paramLong)
  {
    AppMethodBeat.i(196880);
    if ((this.IVc != null) && (!this.IVc.isStarted()))
    {
      this.IVc.setStartDelay(paramLong);
      this.IVc.start();
    }
    AppMethodBeat.o(196880);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.l
 * JD-Core Version:    0.7.0.1
 */