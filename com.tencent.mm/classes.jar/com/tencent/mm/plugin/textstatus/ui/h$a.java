package com.tencent.mm.plugin.textstatus.ui;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/ui/StatusCardView$attachStateListener$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h$a
  implements View.OnAttachStateChangeListener
{
  h$a(h paramh) {}
  
  public final void onViewAttachedToWindow(View paramView)
  {
    AppMethodBeat.i(291386);
    Log.d(this.TwV.TAG, s.X("onViewAttachedToWindow() called with: v = ", paramView));
    AppMethodBeat.o(291386);
  }
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    AppMethodBeat.i(291394);
    Log.d(this.TwV.TAG, s.X("onViewDetachedFromWindow() called with: v = ", paramView));
    this.TwV.TwT = true;
    AppMethodBeat.o(291394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.h.a
 * JD-Core Version:    0.7.0.1
 */