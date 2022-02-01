package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.ui.an;
import com.tencent.mm.plugin.sns.ui.b.b.b.a;
import com.tencent.mm.plugin.sns.ui.c.a.a;
import com.tencent.mm.plugin.sns.ui.c.a.c;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;

public final class f
  extends b
{
  private AnimatorSet xhG;
  private ValueAnimator zaW;
  private ValueAnimator zaX;
  c zbi;
  
  public f(MMActivity paramMMActivity, a parama)
  {
    AppMethodBeat.i(99922);
    try
    {
      this.activity = paramMMActivity;
      this.zbi = ((c)parama);
      this.zaW = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.zaW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(99918);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f != 1.0F)
          {
            f.this.zbi.yGK.setScaleX(f);
            f.this.zbi.yGK.setScaleY(f);
            f.this.zbi.yGK.setAlpha(f);
          }
          AppMethodBeat.o(99918);
        }
      });
      this.zaW.setDuration(400L);
      this.zaW.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      });
      this.zaX = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.zaX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(179331);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          f.this.zbi.rXY.setAlpha(f);
          f.this.zbi.zbW.setAlpha(f);
          AppMethodBeat.o(179331);
        }
      });
      this.zaX.setDuration(100L);
      this.xhG = new AnimatorSet();
      this.xhG.playTogether(new Animator[] { this.zaW, this.zaX });
      this.xhG.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(179333);
          ac.i("MicroMsg.FullCardAdDetailClickAnimation", "onAnimation end");
          f.this.zbi.yGK.setScaleX(1.0F);
          f.this.zbi.yGK.setScaleY(1.0F);
          f.this.zbi.yGK.setAlpha(1.0F);
          f.this.zbi.rXY.setAlpha(1.0F);
          f.this.zbi.zbW.setAlpha(1.0F);
          if (f.this.zaU != null) {
            f.this.zaU.onAnimationEnd();
          }
          if (f.this.zbi.zbE.yFl)
          {
            if (f.this.zbi.zbE.yFe.getVisibility() == 0)
            {
              f.this.zbi.zbE.yFe.aw(0, false);
              ac.i("MicroMsg.FullCardAdDetailClickAnimation", "seek newVideoView to 0");
              AppMethodBeat.o(179333);
            }
          }
          else if (f.this.zbi.zbE.yFd.getVisibility() == 0)
          {
            f.this.zbi.zbE.yFd.xDG.clear();
            ac.i("MicroMsg.FullCardAdDetailClickAnimation", "seek sightView to 0");
          }
          AppMethodBeat.o(179333);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(179332);
          ac.i("MicroMsg.FullCardAdDetailClickAnimation", "onAnimation start");
          AppMethodBeat.o(179332);
        }
      });
      AppMethodBeat.o(99922);
      return;
    }
    catch (Throwable paramMMActivity)
    {
      ac.e("MicroMsg.FullCardAdDetailClickAnimation", "init exp=" + paramMMActivity.toString());
      AppMethodBeat.o(99922);
    }
  }
  
  public final void xV(long paramLong)
  {
    AppMethodBeat.i(99923);
    if ((this.xhG != null) && (!this.xhG.isStarted()))
    {
      this.xhG.setStartDelay(paramLong);
      this.xhG.start();
    }
    AppMethodBeat.o(99923);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.a.f
 * JD-Core Version:    0.7.0.1
 */