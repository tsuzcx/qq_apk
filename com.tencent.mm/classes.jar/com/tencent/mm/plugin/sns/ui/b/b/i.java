package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.timeline.b.a.a.a;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class i
  extends b
{
  AnimatorSet Div;
  a.a RIO;
  private ValueAnimator RIs;
  
  public i(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(309332);
    try
    {
      this.activity = paramMMActivity;
      this.RIO = ((a.a)paramBaseViewHolder);
      this.RIs = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.RIs.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(309362);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 1.0F)
          {
            i.this.RIO.QaX.setScaleX(f);
            i.this.RIO.QaX.setScaleY(f);
            i.this.RIO.QaX.setAlpha(f);
          }
          AppMethodBeat.o(309362);
        }
      });
      this.RIs.setDuration(400L);
      this.RIs.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(309361);
          if (i.this.RIO.mtE)
          {
            Log.i("MicroMsg.SlideFullCardItemAdClickAnimation", "holder is busy");
            paramAnonymousAnimator = i.this;
            if (paramAnonymousAnimator.Div != null) {
              paramAnonymousAnimator.Div.end();
            }
            AppMethodBeat.o(309361);
            return;
          }
          i.this.RIO.mtE = true;
          AppMethodBeat.o(309361);
        }
      });
      this.Div = new AnimatorSet();
      this.Div.playTogether(new Animator[] { this.RIs });
      this.Div.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(309371);
          Log.i("MicroMsg.SlideFullCardItemAdClickAnimation", "onAnimation end");
          i.this.RIO.QaX.setScaleX(1.0F);
          i.this.RIO.QaX.setScaleY(1.0F);
          i.this.RIO.QaX.setAlpha(1.0F);
          if (i.this.RIn != null) {
            i.this.RIn.onAnimationEnd();
          }
          i.this.RIO.mtE = false;
          AppMethodBeat.o(309371);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(309365);
          Log.i("MicroMsg.SlideFullCardItemAdClickAnimation", "onAnimation start");
          AppMethodBeat.o(309365);
        }
      });
      AppMethodBeat.o(309332);
      return;
    }
    finally
    {
      Log.e("MicroMsg.SlideFullCardItemAdClickAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(309332);
    }
  }
  
  public final void vz(long paramLong)
  {
    AppMethodBeat.i(309335);
    if ((this.Div != null) && (!this.Div.isStarted()))
    {
      this.Div.setStartDelay(paramLong);
      this.Div.start();
    }
    AppMethodBeat.o(309335);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.i
 * JD-Core Version:    0.7.0.1
 */