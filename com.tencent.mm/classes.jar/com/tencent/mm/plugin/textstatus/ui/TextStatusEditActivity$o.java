package com.tencent.mm.plugin.textstatus.ui;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$globalLayoutListenerMode1$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TextStatusEditActivity$o
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  TextStatusEditActivity$o(TextStatusEditActivity paramTextStatusEditActivity) {}
  
  private static final void p(TextStatusEditActivity paramTextStatusEditActivity)
  {
    AppMethodBeat.i(291166);
    s.u(paramTextStatusEditActivity, "this$0");
    paramTextStatusEditActivity.hIP().requestFocus();
    TextStatusEditActivity.k(paramTextStatusEditActivity);
    paramTextStatusEditActivity.hideVKB();
    AppMethodBeat.o(291166);
  }
  
  private static final void q(TextStatusEditActivity paramTextStatusEditActivity)
  {
    AppMethodBeat.i(291170);
    s.u(paramTextStatusEditActivity, "this$0");
    h.ahAA.o(new TextStatusEditActivity.o..ExternalSyntheticLambda1(paramTextStatusEditActivity), 200L);
    AppMethodBeat.o(291170);
  }
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(291189);
    this.Tzd.hIP().post(new TextStatusEditActivity.o..ExternalSyntheticLambda0(this.Tzd));
    this.Tzd.hIP().getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
    AppMethodBeat.o(291189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.o
 * JD-Core Version:    0.7.0.1
 */