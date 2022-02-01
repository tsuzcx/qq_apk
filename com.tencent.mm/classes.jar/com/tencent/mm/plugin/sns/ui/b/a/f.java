package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.b.b.b.a;
import com.tencent.mm.plugin.sns.ui.c.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class f
  extends b
{
  private AnimatorSet Div;
  e RIr;
  private ValueAnimator RIs;
  
  public f(MMActivity paramMMActivity, com.tencent.mm.plugin.sns.ui.c.a.b paramb)
  {
    AppMethodBeat.i(309374);
    try
    {
      this.activity = paramMMActivity;
      this.RIr = ((e)paramb);
      this.RIs = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.RIs.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(309368);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 1.0F)
          {
            f.this.RIr.QaX.setScaleX(f);
            f.this.RIr.QaX.setScaleY(f);
            f.this.RIr.QaX.setAlpha(f);
          }
          AppMethodBeat.o(309368);
        }
      });
      this.RIs.setDuration(400L);
      this.Div = new AnimatorSet();
      this.Div.playTogether(new Animator[] { this.RIs });
      this.Div.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(309367);
          Log.i("MicroMsg.SlideFullCardItemAdClickAnimation", "onAnimation end");
          f.this.RIr.QaX.setScaleX(1.0F);
          f.this.RIr.QaX.setScaleY(1.0F);
          f.this.RIr.QaX.setAlpha(1.0F);
          if (f.this.RIn != null) {
            f.this.RIn.onAnimationEnd();
          }
          AppMethodBeat.o(309367);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(309364);
          Log.i("MicroMsg.SlideFullCardItemAdClickAnimation", "onAnimation start");
          AppMethodBeat.o(309364);
        }
      });
      AppMethodBeat.o(309374);
      return;
    }
    finally
    {
      Log.e("MicroMsg.SlideFullCardItemAdClickAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(309374);
    }
  }
  
  public final void vz(long paramLong)
  {
    AppMethodBeat.i(309376);
    if ((this.Div != null) && (!this.Div.isStarted()))
    {
      this.Div.setStartDelay(paramLong);
      this.Div.start();
    }
    AppMethodBeat.o(309376);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.f
 * JD-Core Version:    0.7.0.1
 */