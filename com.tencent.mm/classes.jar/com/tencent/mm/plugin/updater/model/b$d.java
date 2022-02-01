package com.tencent.mm.plugin.updater.model;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.updater.a.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
final class b$d
  implements Runnable
{
  public static final d NjZ;
  
  static
  {
    AppMethodBeat.i(196058);
    NjZ = new d();
    AppMethodBeat.o(196058);
  }
  
  public final void run()
  {
    AppMethodBeat.i(196056);
    Toast.makeText(MMApplicationContext.getContext(), a.c.sdcard_full_title, 0).show();
    AppMethodBeat.o(196056);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.updater.model.b.d
 * JD-Core Version:    0.7.0.1
 */