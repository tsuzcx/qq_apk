package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.statusbar.b;

public final class c
  extends b
{
  public c(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void onStatusBarHeightChange(int paramInt)
  {
    AppMethodBeat.i(78193);
    if (paramInt == 0)
    {
      AppMethodBeat.o(78193);
      return;
    }
    super.onStatusBarHeightChange(paramInt);
    AppMethodBeat.o(78193);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.c
 * JD-Core Version:    0.7.0.1
 */