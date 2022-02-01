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
  FrameLayout wMz;
  private be wNd;
  int wxW = -1;
  SnsCommentShowAbLayout xLP = null;
  LinearLayout xwy;
  LinearLayout xwz;
  
  public bm(Context paramContext, be parambe, FrameLayout paramFrameLayout)
  {
    this.mContext = paramContext;
    this.wNd = parambe;
    this.wMz = paramFrameLayout;
  }
  
  public final boolean dzb()
  {
    AppMethodBeat.i(99749);
    if (this.xLP != null)
    {
      this.wMz.removeView(this.xLP);
      this.xLP = null;
      AppMethodBeat.o(99749);
      return true;
    }
    AppMethodBeat.o(99749);
    return false;
  }
  
  final void eK(final View paramView)
  {
    AppMethodBeat.i(99748);
    paramView.clearAnimation();
    paramView.startAnimation(this.wNd.xwx);
    this.wNd.xwx.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(99747);
        if (paramView != null)
        {
          paramView.setVisibility(8);
          bm.this.dzb();
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
    String wMT;
    View wwV = null;
    
    public a(String paramString, View paramView)
    {
      this.wMT = paramString;
      this.wwV = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bm
 * JD-Core Version:    0.7.0.1
 */