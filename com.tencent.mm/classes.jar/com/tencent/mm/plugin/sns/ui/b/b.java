package com.tencent.mm.plugin.sns.ui.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public ValueAnimator omf;
  private Context seL;
  public int seM;
  public int seN;
  public int seO;
  public int seP;
  public a seQ;
  View view;
  
  public b(Activity paramActivity, View paramView)
  {
    AppMethodBeat.i(40005);
    this.seL = paramActivity;
    this.view = paramView;
    this.omf = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.omf.addUpdateListener(new b.1(this));
    this.omf.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(40004);
        if (b.this.seQ != null) {
          b.this.seQ.onAnimationEnd();
        }
        b.this.view.setVisibility(8);
        AppMethodBeat.o(40004);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(40003);
        paramAnonymousAnimator = (FrameLayout.LayoutParams)b.this.view.getLayoutParams();
        paramAnonymousAnimator.leftMargin = b.this.seM;
        paramAnonymousAnimator.topMargin = b.this.seN;
        ViewGroup localViewGroup = (ViewGroup)b.this.view.getParent();
        paramAnonymousAnimator.rightMargin = (localViewGroup.getWidth() - b.this.seO - paramAnonymousAnimator.leftMargin);
        paramAnonymousAnimator.bottomMargin = (localViewGroup.getHeight() - b.this.seP - paramAnonymousAnimator.topMargin);
        b.this.view.setLayoutParams(paramAnonymousAnimator);
        b.this.view.setVisibility(0);
        if (b.this.seQ != null) {
          b.this.seQ.onAnimationStart();
        }
        AppMethodBeat.o(40003);
      }
    });
    this.omf.setDuration(400L);
    AppMethodBeat.o(40005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b
 * JD-Core Version:    0.7.0.1
 */