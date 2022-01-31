package com.tencent.mm.ui.widget.listview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ak;

final class PullDownListView$4
  extends AnimatorListenerAdapter
{
  PullDownListView$4(PullDownListView paramPullDownListView, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(112729);
    ak.i("MicroMsg.PullDownListView", "onAnimationEnd start:%s, openLimitPx():%s, closeLimitPx():%s", new Object[] { Integer.valueOf(this.AIz), Integer.valueOf(PullDownListView.e(this.AIy)), Integer.valueOf(PullDownListView.f(this.AIy)) });
    PullDownListView.i(this.AIy);
    PullDownListView.a(this.AIy, false);
    PullDownListView.j(this.AIy);
    PullDownListView.k(this.AIy);
    if ((PullDownListView.g(this.AIy) != null) && (this.AIz > PullDownListView.e(this.AIy)) && (this.AIz < PullDownListView.f(this.AIy))) {
      if (PullDownListView.h(this.AIy))
      {
        PullDownListView.g(this.AIy).onPostClose();
        if (PullDownListView.l(this.AIy) != null) {
          AppMethodBeat.o(112729);
        }
      }
      else
      {
        PullDownListView.g(this.AIy).onPostOpen(this.kLR);
      }
    }
    AppMethodBeat.o(112729);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(112728);
    ak.i("MicroMsg.PullDownListView", "onAnimationStart start:%s, openLimitPx():%s, closeLimitPx():%s", new Object[] { Integer.valueOf(this.AIz), Integer.valueOf(PullDownListView.e(this.AIy)), Integer.valueOf(PullDownListView.f(this.AIy)) });
    PullDownListView.a(this.AIy, true);
    if (this.qFb == 0) {
      PullDownListView.b(this.AIy, true);
    }
    while ((PullDownListView.g(this.AIy) != null) && (this.AIz > PullDownListView.e(this.AIy)) && (this.AIz < PullDownListView.f(this.AIy))) {
      if (PullDownListView.h(this.AIy))
      {
        PullDownListView.g(this.AIy).cbZ();
        AppMethodBeat.o(112728);
        return;
        PullDownListView.b(this.AIy, false);
      }
      else
      {
        PullDownListView.g(this.AIy).cbY();
      }
    }
    AppMethodBeat.o(112728);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.PullDownListView.4
 * JD-Core Version:    0.7.0.1
 */