package com.tencent.mm.plugin.performance.watchdogs;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class d$6
  implements Runnable
{
  d$6(d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(301018);
    Toast.makeText(MMApplicationContext.getContext(), "trigger memory hook\n(toast for debug/coolassist)", 0).show();
    AppMethodBeat.o(301018);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.watchdogs.d.6
 * JD-Core Version:    0.7.0.1
 */