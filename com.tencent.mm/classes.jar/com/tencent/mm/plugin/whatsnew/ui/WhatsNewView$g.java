package com.tencent.mm.plugin.whatsnew.ui;

import android.support.v4.view.c;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
final class WhatsNewView$g
  implements View.OnTouchListener
{
  WhatsNewView$g(c paramc) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(230998);
    this.JPx.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(230998);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.whatsnew.ui.WhatsNewView.g
 * JD-Core Version:    0.7.0.1
 */