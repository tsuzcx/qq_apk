package com.tencent.mm.plugin.music.f;

import android.content.Context;
import android.widget.Toast;
import com.tencent.luggage.i.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class d$1$1
  implements Runnable
{
  d$1$1(d.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(137327);
    if (System.currentTimeMillis() - this.FTe.FTc > 10000L)
    {
      this.FTe.FTc = System.currentTimeMillis();
      Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(a.a.music_file_wrong), 0).show();
    }
    AppMethodBeat.o(137327);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.d.1.1
 * JD-Core Version:    0.7.0.1
 */