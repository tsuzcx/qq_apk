package com.tencent.mm.ui.widget.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$3
  implements DialogInterface.OnDismissListener
{
  d$3(d paramd) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(112649);
    if (d.m(this.AHn) != null)
    {
      if (!d.m(this.AHn).isAlive()) {
        d.a(this.AHn, d.n(this.AHn).getViewTreeObserver());
      }
      d.m(this.AHn).removeGlobalOnLayoutListener(this.AHn);
      d.a(this.AHn, null);
    }
    d.o(this.AHn);
    AppMethodBeat.o(112649);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.b.d.3
 * JD-Core Version:    0.7.0.1
 */