package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bp
{
  LinearLayout AaI;
  LinearLayout AaJ;
  SnsCommentShowAbLayout Aqs = null;
  Context mContext;
  int yYM = -1;
  private bh zpI;
  FrameLayout zpe;
  
  public bp(Context paramContext, bh parambh, FrameLayout paramFrameLayout)
  {
    this.mContext = paramContext;
    this.zpI = parambh;
    this.zpe = paramFrameLayout;
  }
  
  public final boolean dZN()
  {
    AppMethodBeat.i(99749);
    if (this.Aqs != null)
    {
      this.zpe.removeView(this.Aqs);
      this.Aqs = null;
      AppMethodBeat.o(99749);
      return true;
    }
    AppMethodBeat.o(99749);
    return false;
  }
  
  final void fm(final View paramView)
  {
    AppMethodBeat.i(99748);
    paramView.clearAnimation();
    paramView.startAnimation(this.zpI.AaH);
    this.zpI.AaH.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(99747);
        if (paramView != null)
        {
          paramView.setVisibility(8);
          bp.this.dZN();
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
    View yXL = null;
    String zpy;
    
    public a(String paramString, View paramView)
    {
      this.zpy = paramString;
      this.yXL = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bp
 * JD-Core Version:    0.7.0.1
 */