package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.timeline.c.a.a.a;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class l
  extends b
{
  AnimatorSet IVc;
  a.a LiM;
  private ValueAnimator Lif;
  
  public l(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(227936);
    try
    {
      this.activity = paramMMActivity;
      this.LiM = ((a.a)paramBaseViewHolder);
      this.Lif = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.Lif.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(195318);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 1.0F)
          {
            l.this.LiM.JJt.setScaleX(f);
            l.this.LiM.JJt.setScaleY(f);
            l.this.LiM.JJt.setAlpha(f);
          }
          AppMethodBeat.o(195318);
        }
      });
      this.Lif.setDuration(400L);
      this.Lif.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(267605);
          if (l.this.LiM.jTm)
          {
            Log.i("MicroMsg.SlideFullCardItemAdClickAnimation", "holder is busy");
            paramAnonymousAnimator = l.this;
            if (paramAnonymousAnimator.IVc != null) {
              paramAnonymousAnimator.IVc.end();
            }
            AppMethodBeat.o(267605);
            return;
          }
          l.this.LiM.jTm = true;
          AppMethodBeat.o(267605);
        }
      });
      this.IVc = new AnimatorSet();
      this.IVc.playTogether(new Animator[] { this.Lif });
      this.IVc.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(246308);
          Log.i("MicroMsg.SlideFullCardItemAdClickAnimation", "onAnimation end");
          l.this.LiM.JJt.setScaleX(1.0F);
          l.this.LiM.JJt.setScaleY(1.0F);
          l.this.LiM.JJt.setAlpha(1.0F);
          if (l.this.Lia != null) {
            l.this.Lia.onAnimationEnd();
          }
          l.this.LiM.jTm = false;
          AppMethodBeat.o(246308);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(246305);
          Log.i("MicroMsg.SlideFullCardItemAdClickAnimation", "onAnimation start");
          AppMethodBeat.o(246305);
        }
      });
      AppMethodBeat.o(227936);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      Log.e("MicroMsg.SlideFullCardItemAdClickAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(227936);
    }
  }
  
  public final void Rq(long paramLong)
  {
    AppMethodBeat.i(227937);
    if ((this.IVc != null) && (!this.IVc.isStarted()))
    {
      this.IVc.setStartDelay(paramLong);
      this.IVc.start();
    }
    AppMethodBeat.o(227937);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.l
 * JD-Core Version:    0.7.0.1
 */