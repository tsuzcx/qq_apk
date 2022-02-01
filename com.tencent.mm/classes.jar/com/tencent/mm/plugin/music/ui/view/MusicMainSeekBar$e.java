package com.tencent.mm.plugin.music.ui.view;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
final class MusicMainSeekBar$e
  implements View.OnTouchListener
{
  public static final e FVx;
  
  static
  {
    AppMethodBeat.i(259460);
    FVx = new e();
    AppMethodBeat.o(259460);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(259457);
    p.j(paramMotionEvent, "event");
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      paramView.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(259457);
      return true;
      p.j(paramView, "v");
      paramView.getParent().requestDisallowInterceptTouchEvent(true);
      continue;
      p.j(paramView, "v");
      paramView.getParent().requestDisallowInterceptTouchEvent(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.view.MusicMainSeekBar.e
 * JD-Core Version:    0.7.0.1
 */