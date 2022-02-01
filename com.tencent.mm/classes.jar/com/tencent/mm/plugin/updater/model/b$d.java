package com.tencent.mm.plugin.updater.model;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
final class b$d
  implements Runnable
{
  public static final d BEE;
  
  static
  {
    AppMethodBeat.i(214563);
    BEE = new d();
    AppMethodBeat.o(214563);
  }
  
  public final void run()
  {
    AppMethodBeat.i(214562);
    Toast.makeText(aj.getContext(), 2131762896, 0).show();
    AppMethodBeat.o(214562);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.updater.model.b.d
 * JD-Core Version:    0.7.0.1
 */