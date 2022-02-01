package com.tencent.mm.plugin.music.f;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;

final class d$1$1
  implements Runnable
{
  d$1$1(d.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(137327);
    if (System.currentTimeMillis() - this.vgM.vgK > 10000L)
    {
      this.vgM.vgK = System.currentTimeMillis();
      Toast.makeText(ai.getContext(), ai.getContext().getString(2131761469), 0).show();
    }
    AppMethodBeat.o(137327);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.d.1.1
 * JD-Core Version:    0.7.0.1
 */