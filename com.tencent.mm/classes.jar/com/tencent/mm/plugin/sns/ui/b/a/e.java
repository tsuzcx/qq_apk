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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class e
  extends a
{
  private AnimatorSet Div;
  com.tencent.mm.plugin.sns.ui.c.a.e RIr;
  private ValueAnimator RIs;
  
  public e(MMActivity paramMMActivity, b paramb)
  {
    AppMethodBeat.i(309375);
    try
    {
      this.activity = paramMMActivity;
      this.RIr = ((com.tencent.mm.plugin.sns.ui.c.a.e)paramb);
      this.RIs = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.RIs.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(309370);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 0.0F)
          {
            e.this.RIr.QaX.setScaleX(f);
            e.this.RIr.QaX.setScaleY(f);
            e.this.RIr.QaX.setAlpha(f);
          }
          AppMethodBeat.o(309370);
        }
      });
      this.RIs.setDuration(400L);
      this.Div = new AnimatorSet();
      this.Div.playTogether(new Animator[] { this.RIs });
      this.Div.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(309372);
          Log.i("MicroMsg.SlideFullCardItemAdBackAnimation", "onAnimation end");
          e.this.RIr.QaX.setScaleX(1.0F);
          e.this.RIr.QaX.setScaleY(1.0F);
          e.this.RIr.QaX.setAlpha(1.0F);
          if (e.this.RIn != null) {
            e.this.RIn.onAnimationEnd();
          }
          AppMethodBeat.o(309372);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(309369);
          Log.i("MicroMsg.SlideFullCardItemAdBackAnimation", "onAnimation start");
          AppMethodBeat.o(309369);
        }
      });
      AppMethodBeat.o(309375);
      return;
    }
    finally
    {
      Log.e("MicroMsg.SlideFullCardItemAdBackAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(309375);
    }
  }
  
  public final void vz(long paramLong)
  {
    AppMethodBeat.i(309377);
    if ((this.Div != null) && (!this.Div.isStarted()))
    {
      this.Div.setStartDelay(paramLong);
      this.Div.start();
    }
    AppMethodBeat.o(309377);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.e
 * JD-Core Version:    0.7.0.1
 */