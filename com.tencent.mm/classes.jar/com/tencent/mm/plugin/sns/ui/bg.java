package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public final class bg
{
  Context mContext;
  LinearLayout oWc;
  LinearLayout oWd;
  int olg = -1;
  FrameLayout ovy;
  private au owd;
  SnsCommentShowAbLayout pkj = null;
  
  public bg(Context paramContext, au paramau, FrameLayout paramFrameLayout)
  {
    this.mContext = paramContext;
    this.owd = paramau;
    this.ovy = paramFrameLayout;
  }
  
  public final boolean bHw()
  {
    if (this.pkj != null)
    {
      this.ovy.removeView(this.pkj);
      this.pkj = null;
      return true;
    }
    return false;
  }
  
  final void db(View paramView)
  {
    paramView.clearAnimation();
    paramView.startAnimation(this.owd.oWb);
    this.owd.oWb.setAnimationListener(new bg.2(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bg
 * JD-Core Version:    0.7.0.1
 */