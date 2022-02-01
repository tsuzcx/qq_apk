package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.ui.an;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.d.a;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;

public final class f
  extends b
{
  AnimatorSet xhG;
  private ValueAnimator zaW;
  private ValueAnimator zaX;
  d.a zbv;
  
  public f(MMActivity paramMMActivity, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(99975);
    try
    {
      this.activity = paramMMActivity;
      this.zbv = ((d.a)paramBaseViewHolder);
      this.zaW = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.zaW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99970);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 1.0F)
          {
            f.this.zbv.yGK.setScaleX(f);
            f.this.zbv.yGK.setScaleY(f);
            f.this.zbv.yGK.setAlpha(f);
          }
          AppMethodBeat.o(99970);
        }
      });
      this.zaW.setDuration(400L);
      this.zaW.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99971);
          if (f.this.zbv.fYC)
          {
            ac.i("MicroMsg.FullCardAdClickAnimation", "holder is busy");
            paramAnonymousAnimator = f.this;
            if (paramAnonymousAnimator.xhG != null) {
              paramAnonymousAnimator.xhG.end();
            }
            AppMethodBeat.o(99971);
            return;
          }
          f.this.zbv.fYC = true;
          AppMethodBeat.o(99971);
        }
      });
      this.zaX = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.zaX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99972);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          f.this.zbv.rXY.setAlpha(f);
          f.this.zbv.zbW.setAlpha(f);
          AppMethodBeat.o(99972);
        }
      });
      this.zaX.setDuration(100L);
      this.xhG = new AnimatorSet();
      this.xhG.playTogether(new Animator[] { this.zaW, this.zaX });
      this.xhG.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99974);
          ac.i("MicroMsg.FullCardAdClickAnimation", "onAnimation end");
          f.this.zbv.yGK.setScaleX(1.0F);
          f.this.zbv.yGK.setScaleY(1.0F);
          f.this.zbv.yGK.setAlpha(1.0F);
          f.this.zbv.rXY.setAlpha(1.0F);
          f.this.zbv.zbW.setAlpha(1.0F);
          if (f.this.zaU != null) {
            f.this.zaU.onAnimationEnd();
          }
          f.this.zbv.fYC = false;
          if (f.this.zbv.zbE.yFl)
          {
            if (f.this.zbv.zbE.yFe.getVisibility() == 0)
            {
              f.this.zbv.zbE.yFe.aw(0, false);
              ac.i("MicroMsg.FullCardAdClickAnimation", "seek newVideoView to 0");
              AppMethodBeat.o(99974);
            }
          }
          else if (f.this.zbv.zbE.yFd.getVisibility() == 0)
          {
            f.this.zbv.zbE.yFd.xDG.clear();
            ac.i("MicroMsg.FullCardAdClickAnimation", "seek sightView to 0");
          }
          AppMethodBeat.o(99974);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(99973);
          ac.i("MicroMsg.FullCardAdClickAnimation", "onAnimation start");
          AppMethodBeat.o(99973);
        }
      });
      AppMethodBeat.o(99975);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      ac.e("MicroMsg.FullCardAdClickAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99975);
    }
  }
  
  public final void xV(long paramLong)
  {
    AppMethodBeat.i(99976);
    if ((this.xhG != null) && (!this.xhG.isStarted()))
    {
      this.xhG.setStartDelay(paramLong);
      this.xhG.start();
    }
    AppMethodBeat.o(99976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.f
 * JD-Core Version:    0.7.0.1
 */