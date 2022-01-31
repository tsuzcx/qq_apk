package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.ui.statusbar.b
{
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void pB(int paramInt)
  {
    AppMethodBeat.i(154599);
    if (paramInt == 0)
    {
      AppMethodBeat.o(154599);
      return;
    }
    super.pB(paramInt);
    AppMethodBeat.o(154599);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b
 * JD-Core Version:    0.7.0.1
 */