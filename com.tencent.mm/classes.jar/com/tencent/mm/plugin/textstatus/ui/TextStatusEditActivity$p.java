package com.tencent.mm.plugin.textstatus.ui;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$globalLayoutListenerMode2$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TextStatusEditActivity$p
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  TextStatusEditActivity$p(TextStatusEditActivity paramTextStatusEditActivity) {}
  
  private static final void p(TextStatusEditActivity paramTextStatusEditActivity)
  {
    AppMethodBeat.i(291122);
    s.u(paramTextStatusEditActivity, "this$0");
    Object localObject = paramTextStatusEditActivity.getContext().getSystemService("input_method");
    if (localObject == null)
    {
      paramTextStatusEditActivity = new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
      AppMethodBeat.o(291122);
      throw paramTextStatusEditActivity;
    }
    ((InputMethodManager)localObject).showSoftInput((View)paramTextStatusEditActivity.hIP(), 0);
    AppMethodBeat.o(291122);
  }
  
  private static final void q(TextStatusEditActivity paramTextStatusEditActivity)
  {
    AppMethodBeat.i(291130);
    s.u(paramTextStatusEditActivity, "this$0");
    paramTextStatusEditActivity.hIP().requestFocus();
    h.ahAA.o(new TextStatusEditActivity.p..ExternalSyntheticLambda1(paramTextStatusEditActivity), 200L);
    AppMethodBeat.o(291130);
  }
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(291146);
    this.Tzd.hIP().post(new TextStatusEditActivity.p..ExternalSyntheticLambda0(this.Tzd));
    this.Tzd.hIP().getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
    AppMethodBeat.o(291146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.p
 * JD-Core Version:    0.7.0.1
 */