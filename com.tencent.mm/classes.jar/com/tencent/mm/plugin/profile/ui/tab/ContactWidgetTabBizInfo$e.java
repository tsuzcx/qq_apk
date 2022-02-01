package com.tencent.mm.plugin.profile.ui.tab;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import androidx.core.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
final class ContactWidgetTabBizInfo$e
  implements View.OnTouchListener
{
  ContactWidgetTabBizInfo$e(d paramd) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(283948);
    this.HgQ.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(283948);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.ContactWidgetTabBizInfo.e
 * JD-Core Version:    0.7.0.1
 */