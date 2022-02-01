package com.tencent.mm.plugin.music.e;

import android.content.Context;
import android.widget.Toast;
import com.tencent.luggage.j.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class e$1$1
  implements Runnable
{
  e$1$1(e.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(137352);
    Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(a.a.music_file_wrong), 0).show();
    AppMethodBeat.o(137352);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.e.1.1
 * JD-Core Version:    0.7.0.1
 */