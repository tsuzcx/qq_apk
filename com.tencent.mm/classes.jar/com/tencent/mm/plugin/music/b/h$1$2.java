package com.tencent.mm.plugin.music.b;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.cache.c;
import com.tencent.mm.plugin.music.cache.e;
import com.tencent.mm.plugin.music.f.c.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

final class h$1$2
  implements Runnable
{
  h$1$2(h.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(137098);
    if (e.dvQ()) {}
    for (boolean bool = ((c)b.aQ(c.class)).dvJ();; bool = false)
    {
      if (bool) {
        Toast.makeText(ak.getContext(), ak.getContext().getString(2131761469), 0).show();
      }
      AppMethodBeat.o(137098);
      return;
      ae.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.h.1.2
 * JD-Core Version:    0.7.0.1
 */