package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class be
{
  Context mContext;
  int qZo = -1;
  LinearLayout rOA;
  LinearLayout rOB;
  private av rkX;
  FrameLayout rkt;
  SnsCommentShowAbLayout scN = null;
  
  public be(Context paramContext, av paramav, FrameLayout paramFrameLayout)
  {
    this.mContext = paramContext;
    this.rkX = paramav;
    this.rkt = paramFrameLayout;
  }
  
  public final boolean ctC()
  {
    AppMethodBeat.i(39884);
    if (this.scN != null)
    {
      this.rkt.removeView(this.scN);
      this.scN = null;
      AppMethodBeat.o(39884);
      return true;
    }
    AppMethodBeat.o(39884);
    return false;
  }
  
  final void dS(View paramView)
  {
    AppMethodBeat.i(39883);
    paramView.clearAnimation();
    paramView.startAnimation(this.rkX.rOz);
    this.rkX.rOz.setAnimationListener(new be.2(this, paramView));
    AppMethodBeat.o(39883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.be
 * JD-Core Version:    0.7.0.1
 */