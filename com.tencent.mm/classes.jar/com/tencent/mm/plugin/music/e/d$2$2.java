package com.tencent.mm.plugin.music.e;

import android.content.Context;
import android.widget.Toast;
import com.tencent.luggage.j.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class d$2$2
  implements Runnable
{
  d$2$2(d.2 param2) {}
  
  public final void run()
  {
    AppMethodBeat.i(137333);
    Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(a.a.music_url_wrong), 1).show();
    AppMethodBeat.o(137333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.d.2.2
 * JD-Core Version:    0.7.0.1
 */