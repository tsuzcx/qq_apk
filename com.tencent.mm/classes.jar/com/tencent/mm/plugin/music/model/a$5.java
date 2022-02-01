package com.tencent.mm.plugin.music.model;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class a$5
  implements Runnable
{
  a$5(a parama, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(220677);
    Toast.makeText(ak.getContext(), this.lBu, 0).show();
    AppMethodBeat.o(220677);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.5
 * JD-Core Version:    0.7.0.1
 */