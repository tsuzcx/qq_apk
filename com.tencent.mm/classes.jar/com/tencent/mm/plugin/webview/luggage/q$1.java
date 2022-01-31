package com.tencent.mm.plugin.webview.luggage;

import android.app.Activity;
import android.content.Intent;
import com.tencent.luggage.g.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.modeltools.a;

final class q$1
  implements e.b
{
  q$1(q paramq, Activity paramActivity) {}
  
  public final boolean b(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(6224);
    boolean bool = a.d(this.gjR, paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(6224);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.q.1
 * JD-Core Version:    0.7.0.1
 */