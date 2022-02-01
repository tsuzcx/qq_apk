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
import java.util.ArrayList;
import java.util.Iterator;

public final class k
  extends a
{
  AnimatorSet IVc;
  a.a LiM;
  private ValueAnimator Lif;
  
  public k(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(193757);
    try
    {
      this.activity = paramMMActivity;
      this.LiM = ((a.a)paramBaseViewHolder);
      this.Lif = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.Lif.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(219112);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 0.0F)
          {
            k.this.LiM.JJt.setScaleX(f);
            k.this.LiM.JJt.setScaleY(f);
            k.this.LiM.JJt.setAlpha(f);
          }
          AppMethodBeat.o(219112);
        }
      });
      this.Lif.setDuration(400L);
      this.Lif.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(196224);
          if (k.this.LiM.jTm)
          {
            Log.i("MicroMsg.SlideFullCardItemAdBackAnimation", "holder is busy");
            paramAnonymousAnimator = k.this.IVc.getChildAnimations().iterator();
            while (paramAnonymousAnimator.hasNext()) {
              ((Animator)paramAnonymousAnimator.next()).cancel();
            }
            AppMethodBeat.o(196224);
            return;
          }
          k.this.LiM.jTm = true;
          AppMethodBeat.o(196224);
        }
      });
      this.IVc = new AnimatorSet();
      this.IVc.playTogether(new Animator[] { this.Lif });
      this.IVc.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(208994);
          Log.i("MicroMsg.SlideFullCardItemAdBackAnimation", "onAnimation end");
          k.this.LiM.JJt.setScaleX(1.0F);
          k.this.LiM.JJt.setScaleY(1.0F);
          k.this.LiM.JJt.setAlpha(1.0F);
          k.this.LiM.jTm = false;
          AppMethodBeat.o(208994);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(208992);
          Log.i("MicroMsg.SlideFullCardItemAdBackAnimation", "onAnimation start");
          AppMethodBeat.o(208992);
        }
      });
      AppMethodBeat.o(193757);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      Log.e("MicroMsg.SlideFullCardItemAdBackAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(193757);
    }
  }
  
  public final void Rq(long paramLong)
  {
    AppMethodBeat.i(193760);
    if ((this.IVc != null) && (!this.IVc.isStarted()))
    {
      this.IVc.setStartDelay(paramLong);
      this.IVc.start();
    }
    AppMethodBeat.o(193760);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.k
 * JD-Core Version:    0.7.0.1
 */