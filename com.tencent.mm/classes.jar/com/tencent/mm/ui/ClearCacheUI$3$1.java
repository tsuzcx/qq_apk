package com.tencent.mm.ui;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class ClearCacheUI$3$1
  implements Runnable
{
  ClearCacheUI$3$1(ClearCacheUI.3 param3) {}
  
  public final void run()
  {
    AppMethodBeat.i(32992);
    Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.l.gAp), 0).show();
    AppMethodBeat.o(32992);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.ClearCacheUI.3.1
 * JD-Core Version:    0.7.0.1
 */