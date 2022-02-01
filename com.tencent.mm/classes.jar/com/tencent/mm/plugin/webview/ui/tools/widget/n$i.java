package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
final class n$i
  implements Runnable
{
  n$i(n paramn) {}
  
  public final void run()
  {
    AppMethodBeat.i(182679);
    n.g(this.JzC);
    Object localObject = this.JzC.getContext().getSystemService("input_method");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
      AppMethodBeat.o(182679);
      throw ((Throwable)localObject);
    }
    localObject = (InputMethodManager)localObject;
    if (localObject != null)
    {
      ((InputMethodManager)localObject).showSoftInput((View)n.b(this.JzC), 0);
      AppMethodBeat.o(182679);
      return;
    }
    AppMethodBeat.o(182679);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.n.i
 * JD-Core Version:    0.7.0.1
 */