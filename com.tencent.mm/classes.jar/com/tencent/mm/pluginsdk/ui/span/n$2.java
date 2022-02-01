package com.tencent.mm.pluginsdk.ui.span;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h.d;

final class n$2
  implements h.d
{
  n$2(DialogInterface.OnDismissListener paramOnDismissListener, String paramString, Context paramContext) {}
  
  public final void qy(int paramInt)
  {
    AppMethodBeat.i(31922);
    if (this.Rsq != null) {
      this.Rsq.onDismiss(null);
    }
    String str = this.Rsr.replace(" ", "").replace("#", "@");
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(31922);
      return;
      n.cA(this.val$context, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.n.2
 * JD-Core Version:    0.7.0.1
 */