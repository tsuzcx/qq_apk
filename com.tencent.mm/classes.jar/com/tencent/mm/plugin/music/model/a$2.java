package com.tencent.mm.plugin.music.model;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class a$2
  implements Runnable
{
  a$2(a parama, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(271166);
    Toast.makeText(MMApplicationContext.getContext(), this.sOC, 0).show();
    AppMethodBeat.o(271166);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.2
 * JD-Core Version:    0.7.0.1
 */