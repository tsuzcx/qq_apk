package com.tencent.mm.plugin.sight.decode.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;

public final class b$4
  implements Runnable
{
  public b$4(b paramb, double paramDouble) {}
  
  public final void run()
  {
    AppMethodBeat.i(204059);
    Log.i("MicroMsg.SightPlayController", "SeekToFrame   %f  %s", new Object[] { Double.valueOf(this.Dnd), Util.getStack().toString() });
    b.a(this.Dnc, this.Dnd);
    AppMethodBeat.o(204059);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.a.b.4
 * JD-Core Version:    0.7.0.1
 */