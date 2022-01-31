package com.tencent.mm.plugin.sight.decode.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$k$3
  implements Runnable
{
  b$k$3(b.k paramk, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(70249);
    ab.v("MicroMsg.SightPlayController", "set background drawable null");
    this.guT.setBackgroundDrawable(null);
    AppMethodBeat.o(70249);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.a.b.k.3
 * JD-Core Version:    0.7.0.1
 */