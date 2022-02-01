package com.tencent.mm.pluginsdk.ui.span;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h.c;

final class m$2
  implements h.c
{
  m$2(DialogInterface.OnDismissListener paramOnDismissListener, String paramString, Context paramContext) {}
  
  public final void lh(int paramInt)
  {
    AppMethodBeat.i(31922);
    if (this.FAd != null) {
      this.FAd.onDismiss(null);
    }
    String str = this.FAe.replace(" ", "").replace("#", "@");
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(31922);
      return;
      m.bU(this.val$context, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.m.2
 * JD-Core Version:    0.7.0.1
 */