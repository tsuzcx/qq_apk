package com.tencent.mm.plugin.updater.model;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
final class b$d
  implements Runnable
{
  public static final d BWc;
  
  static
  {
    AppMethodBeat.i(197776);
    BWc = new d();
    AppMethodBeat.o(197776);
  }
  
  public final void run()
  {
    AppMethodBeat.i(197775);
    Toast.makeText(ak.getContext(), 2131762896, 0).show();
    AppMethodBeat.o(197775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.updater.model.b.d
 * JD-Core Version:    0.7.0.1
 */