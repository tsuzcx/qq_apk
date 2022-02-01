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
import java.util.ArrayList;
import java.util.Iterator;

public final class h
  extends a
{
  AnimatorSet Div;
  a.a RIO;
  private ValueAnimator RIs;
  
  public h(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(309333);
    try
    {
      this.activity = paramMMActivity;
      this.RIO = ((a.a)paramBaseViewHolder);
      this.RIs = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.RIs.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(309348);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 0.0F)
          {
            h.this.RIO.QaX.setScaleX(f);
            h.this.RIO.QaX.setScaleY(f);
            h.this.RIO.QaX.setAlpha(f);
          }
          AppMethodBeat.o(309348);
        }
      });
      this.RIs.setDuration(400L);
      this.RIs.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(309352);
          if (h.this.RIO.mtE)
          {
            Log.i("MicroMsg.SlideFullCardItemAdBackAnimation", "holder is busy");
            paramAnonymousAnimator = h.this.Div.getChildAnimations().iterator();
            while (paramAnonymousAnimator.hasNext()) {
              ((Animator)paramAnonymousAnimator.next()).cancel();
            }
            AppMethodBeat.o(309352);
            return;
          }
          h.this.RIO.mtE = true;
          AppMethodBeat.o(309352);
        }
      });
      this.Div = new AnimatorSet();
      this.Div.playTogether(new Animator[] { this.RIs });
      this.Div.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(309351);
          Log.i("MicroMsg.SlideFullCardItemAdBackAnimation", "onAnimation end");
          h.this.RIO.QaX.setScaleX(1.0F);
          h.this.RIO.QaX.setScaleY(1.0F);
          h.this.RIO.QaX.setAlpha(1.0F);
          h.this.RIO.mtE = false;
          AppMethodBeat.o(309351);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(309349);
          Log.i("MicroMsg.SlideFullCardItemAdBackAnimation", "onAnimation start");
          AppMethodBeat.o(309349);
        }
      });
      AppMethodBeat.o(309333);
      return;
    }
    finally
    {
      Log.e("MicroMsg.SlideFullCardItemAdBackAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(309333);
    }
  }
  
  public final void vz(long paramLong)
  {
    AppMethodBeat.i(309336);
    if ((this.Div != null) && (!this.Div.isStarted()))
    {
      this.Div.setStartDelay(paramLong);
      this.Div.start();
    }
    AppMethodBeat.o(309336);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.h
 * JD-Core Version:    0.7.0.1
 */