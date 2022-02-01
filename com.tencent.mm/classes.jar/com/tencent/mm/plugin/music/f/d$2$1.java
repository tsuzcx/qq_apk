package com.tencent.mm.plugin.music.f;

import android.content.Context;
import android.widget.Toast;
import com.tencent.luggage.i.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class d$2$1
  implements Runnable
{
  d$2$1(d.2 param2, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(137332);
    Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(a.a.music_url_wrong), 0).show();
    d.a(this.FTf.FTd, this.FTf.FTd.FQe, this.fgX);
    AppMethodBeat.o(137332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.d.2.1
 * JD-Core Version:    0.7.0.1
 */