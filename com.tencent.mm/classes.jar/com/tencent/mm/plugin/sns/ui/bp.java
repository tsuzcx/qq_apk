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
  SnsCommentShowAbLayout AHG = null;
  LinearLayout ArV;
  LinearLayout ArW;
  Context mContext;
  private bh zGX;
  FrameLayout zGt;
  int zpn = -1;
  
  public bp(Context paramContext, bh parambh, FrameLayout paramFrameLayout)
  {
    this.mContext = paramContext;
    this.zGX = parambh;
    this.zGt = paramFrameLayout;
  }
  
  public final boolean edt()
  {
    AppMethodBeat.i(99749);
    if (this.AHG != null)
    {
      this.zGt.removeView(this.AHG);
      this.AHG = null;
      AppMethodBeat.o(99749);
      return true;
    }
    AppMethodBeat.o(99749);
    return false;
  }
  
  final void fl(final View paramView)
  {
    AppMethodBeat.i(99748);
    paramView.clearAnimation();
    paramView.startAnimation(this.zGX.ArU);
    this.zGX.ArU.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(99747);
        if (paramView != null)
        {
          paramView.setVisibility(8);
          bp.this.edt();
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
    String zGN;
    View zom = null;
    
    public a(String paramString, View paramView)
    {
      this.zGN = paramString;
      this.zom = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bp
 * JD-Core Version:    0.7.0.1
 */