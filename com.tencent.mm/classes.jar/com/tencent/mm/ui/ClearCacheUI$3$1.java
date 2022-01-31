package com.tencent.mm.ui;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

final class ClearCacheUI$3$1
  implements Runnable
{
  ClearCacheUI$3$1(ClearCacheUI.3 param3) {}
  
  public final void run()
  {
    AppMethodBeat.i(29167);
    Toast.makeText(ah.getContext(), ah.getContext().getString(2131298410), 0).show();
    AppMethodBeat.o(29167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.ClearCacheUI.3.1
 * JD-Core Version:    0.7.0.1
 */