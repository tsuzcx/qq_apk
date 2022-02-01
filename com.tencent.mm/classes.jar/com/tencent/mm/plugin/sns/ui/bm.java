package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bm
{
  Context mContext;
  int xJx = -1;
  private be xZJ;
  FrameLayout xZf;
  LinearLayout yJo;
  LinearLayout yJp;
  SnsCommentShowAbLayout yYE = null;
  
  public bm(Context paramContext, be parambe, FrameLayout paramFrameLayout)
  {
    this.mContext = paramContext;
    this.xZJ = parambe;
    this.xZf = paramFrameLayout;
  }
  
  public final boolean dNy()
  {
    AppMethodBeat.i(99749);
    if (this.yYE != null)
    {
      this.xZf.removeView(this.yYE);
      this.yYE = null;
      AppMethodBeat.o(99749);
      return true;
    }
    AppMethodBeat.o(99749);
    return false;
  }
  
  final void eX(final View paramView)
  {
    AppMethodBeat.i(99748);
    paramView.clearAnimation();
    paramView.startAnimation(this.xZJ.yJn);
    this.xZJ.yJn.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(99747);
        if (paramView != null)
        {
          paramView.setVisibility(8);
          bm.this.dNy();
        }
        AppMethodBeat.o(99747);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    AppMethodBeat.o(99748);
  }
  
  final class a
  {
    View xIw = null;
    String xZz;
    
    public a(String paramString, View paramView)
    {
      this.xZz = paramString;
      this.xIw = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bm
 * JD-Core Version:    0.7.0.1
 */