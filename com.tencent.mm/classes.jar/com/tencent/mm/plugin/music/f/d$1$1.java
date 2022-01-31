package com.tencent.mm.plugin.music.f;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

final class d$1$1
  implements Runnable
{
  d$1$1(d.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(137577);
    if (System.currentTimeMillis() - this.paM.paK > 10000L)
    {
      this.paM.paK = System.currentTimeMillis();
      Toast.makeText(ah.getContext(), ah.getContext().getString(2131301726), 0).show();
    }
    AppMethodBeat.o(137577);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.d.1.1
 * JD-Core Version:    0.7.0.1
 */