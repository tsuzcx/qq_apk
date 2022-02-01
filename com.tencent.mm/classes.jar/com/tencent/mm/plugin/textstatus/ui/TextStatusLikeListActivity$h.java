package com.tencent.mm.plugin.textstatus.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
final class TextStatusLikeListActivity$h
  implements View.OnTouchListener
{
  TextStatusLikeListActivity$h(TextStatusLikeListActivity paramTextStatusLikeListActivity) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(234241);
    p.j(paramMotionEvent, "event");
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(234241);
      return false;
      this.MNC.hideVKB();
      TextStatusLikeListActivity.e(this.MNC)[0] = ((int)paramMotionEvent.getRawX());
      TextStatusLikeListActivity.e(this.MNC)[1] = ((int)paramMotionEvent.getRawY());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusLikeListActivity.h
 * JD-Core Version:    0.7.0.1
 */