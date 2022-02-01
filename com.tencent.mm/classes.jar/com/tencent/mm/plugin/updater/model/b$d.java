package com.tencent.mm.plugin.updater.model;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
final class b$d
  implements Runnable
{
  public static final d GwG;
  
  static
  {
    AppMethodBeat.i(194738);
    GwG = new d();
    AppMethodBeat.o(194738);
  }
  
  public final void run()
  {
    AppMethodBeat.i(194737);
    Toast.makeText(MMApplicationContext.getContext(), 2131765032, 0).show();
    AppMethodBeat.o(194737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.updater.model.b.d
 * JD-Core Version:    0.7.0.1
 */