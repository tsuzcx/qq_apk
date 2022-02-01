package com.tencent.mm.plugin.scanner.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ak.a.d;
import com.tencent.mm.plugin.ak.a.g;
import com.tencent.mm.plugin.scanner.b.a.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

final class ScanCardRectView$6
  implements c.b
{
  private LinkedList<Integer> PkE;
  private Integer PkF;
  Integer PkG;
  private Integer PkH;
  
  ScanCardRectView$6(ScanCardRectView paramScanCardRectView)
  {
    AppMethodBeat.i(314058);
    this.PkE = new LinkedList();
    this.PkF = Integer.valueOf(0);
    this.PkG = Integer.valueOf(0);
    this.PkH = Integer.valueOf(0);
    AppMethodBeat.o(314058);
  }
  
  public final void a(long paramLong, Bundle paramBundle)
  {
    AppMethodBeat.i(177502);
    if (paramLong == ScanCardRectView.a(this.PkB))
    {
      Log.i("MicroMsg.ScanCardRectView", "license decode success %s", new Object[] { Long.valueOf(ScanCardRectView.a(this.PkB)) });
      ScanCardRectView.b(this.PkB);
      if (ScanCardRectView.c(this.PkB) != null) {
        ScanCardRectView.c(this.PkB).aU(paramBundle);
      }
    }
    AppMethodBeat.o(177502);
  }
  
  public final void b(long paramLong, final Bundle paramBundle)
  {
    AppMethodBeat.i(177503);
    if ((paramLong == ScanCardRectView.a(this.PkB)) && (paramBundle.containsKey("param_card_edge")))
    {
      paramBundle = paramBundle.getBooleanArray("param_card_edge");
      ScanCardRectView.d(this.PkB).setHighLightEdges(paramBundle);
      if ((ScanCardRectView.e(this.PkB) != 9) && (ScanCardRectView.e(this.PkB) != 11))
      {
        AppMethodBeat.o(177503);
        return;
      }
      if (!ScanCardRectView.gUs())
      {
        AppMethodBeat.o(177503);
        return;
      }
      this.PkH = Integer.valueOf(this.PkH.intValue() + 1);
      if ((paramBundle[0] == 0) || (paramBundle[1] == 0) || (paramBundle[2] == 0) || (paramBundle[3] == 0))
      {
        this.PkF = Integer.valueOf(this.PkF.intValue() + 1);
        this.PkE.add(Integer.valueOf(1));
      }
      for (;;)
      {
        if ((this.PkE.size() > 60) && (((Integer)this.PkE.pollFirst()).intValue() == 1)) {
          this.PkF = Integer.valueOf(this.PkF.intValue() - 1);
        }
        if (this.PkH.intValue() < 0) {
          this.PkH = Integer.valueOf(0);
        }
        if (this.PkH.intValue() >= 70) {
          break;
        }
        AppMethodBeat.o(177503);
        return;
        this.PkE.add(Integer.valueOf(0));
      }
      final View localView;
      if (this.PkF.intValue() >= 53)
      {
        paramBundle = (TextView)ScanCardRectView.f(this.PkB).findViewById(a.d.bottom_tip_view);
        localView = ScanCardRectView.f(this.PkB).findViewById(a.d.bottom_tip_icon);
        paramBundle.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(314072);
            if (ScanCardRectView.6.this.PkG.intValue() == 1)
            {
              AppMethodBeat.o(314072);
              return;
            }
            ScanCardRectView.6.this.PkG = Integer.valueOf(1);
            ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.PkI, "alpha", new float[] { 1.0F, 0.0F });
            ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.PkI, "alpha", new float[] { 0.0F, 1.0F });
            AnimatorSet localAnimatorSet = new AnimatorSet();
            localAnimatorSet.setDuration(333L);
            localAnimatorSet.playSequentially(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
            localObjectAnimator2.addListener(new Animator.AnimatorListener()
            {
              public final void onAnimationCancel(Animator paramAnonymous2Animator) {}
              
              public final void onAnimationEnd(Animator paramAnonymous2Animator) {}
              
              public final void onAnimationRepeat(Animator paramAnonymous2Animator) {}
              
              public final void onAnimationStart(Animator paramAnonymous2Animator)
              {
                AppMethodBeat.i(314059);
                ScanCardRectView.6.1.this.PkJ.setText(ScanCardRectView.6.this.PkB.getContext().getResources().getString(a.g.scan_id_card_align_tips));
                ScanCardRectView.6.1.this.PkK.setVisibility(0);
                AppMethodBeat.o(314059);
              }
            });
            localAnimatorSet.start();
            AppMethodBeat.o(314072);
          }
        });
        AppMethodBeat.o(177503);
        return;
      }
      if (this.PkF.intValue() >= 40)
      {
        if (this.PkG.intValue() == 2)
        {
          AppMethodBeat.o(177503);
          return;
        }
        this.PkG = Integer.valueOf(2);
        paramBundle = (TextView)ScanCardRectView.f(this.PkB).findViewById(a.d.bottom_tip_view);
        localView = ScanCardRectView.f(this.PkB).findViewById(a.d.bottom_tip_icon);
        paramBundle.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(314069);
            ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.PkI, "alpha", new float[] { 1.0F, 0.0F });
            ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.PkI, "alpha", new float[] { 0.0F, 1.0F });
            AnimatorSet localAnimatorSet = new AnimatorSet();
            localAnimatorSet.setDuration(333L);
            localAnimatorSet.playSequentially(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
            localObjectAnimator2.addListener(new Animator.AnimatorListener()
            {
              public final void onAnimationCancel(Animator paramAnonymous2Animator) {}
              
              public final void onAnimationEnd(Animator paramAnonymous2Animator) {}
              
              public final void onAnimationRepeat(Animator paramAnonymous2Animator) {}
              
              public final void onAnimationStart(Animator paramAnonymous2Animator)
              {
                AppMethodBeat.i(314016);
                ScanCardRectView.6.2.this.PkJ.setText(ScanCardRectView.6.this.PkB.getContext().getResources().getString(a.g.scan_id_card_region_tips));
                ScanCardRectView.6.2.this.PkK.setVisibility(0);
                AppMethodBeat.o(314016);
              }
            });
            localAnimatorSet.start();
            AppMethodBeat.o(314069);
          }
        });
      }
    }
    AppMethodBeat.o(177503);
  }
  
  public final void bc(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(177501);
    if (paramLong1 == ScanCardRectView.a(this.PkB)) {
      this.PkB.ua(paramLong2);
    }
    AppMethodBeat.o(177501);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.ScanCardRectView.6
 * JD-Core Version:    0.7.0.1
 */