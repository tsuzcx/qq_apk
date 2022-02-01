package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
final class n$i
  implements Runnable
{
  n$i(n paramn) {}
  
  public final void run()
  {
    AppMethodBeat.i(182679);
    n.g(this.CNx);
    Object localObject = this.CNx.getContext().getSystemService("input_method");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
      AppMethodBeat.o(182679);
      throw ((Throwable)localObject);
    }
    localObject = (InputMethodManager)localObject;
    if (localObject != null)
    {
      ((InputMethodManager)localObject).showSoftInput((View)n.b(this.CNx), 0);
      AppMethodBeat.o(182679);
      return;
    }
    AppMethodBeat.o(182679);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.n.i
 * JD-Core Version:    0.7.0.1
 */