package com.tencent.mm.plugin.report.service;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class e$1
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(261694);
    Toast.makeText(MMApplicationContext.getContext(), "The IDKey has not applied yet, check your code or contact with astrozhou", 1);
    AppMethodBeat.o(261694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.e.1
 * JD-Core Version:    0.7.0.1
 */