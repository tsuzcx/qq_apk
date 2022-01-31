package com.tencent.mm.plugin.webview.luggage.ipc;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity.a;

final class b$1
  implements MMActivity.a
{
  b$1(a parama) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(6246);
    if (paramInt1 == 3456)
    {
      if ((paramIntent == null) || (this.uTb == null))
      {
        AppMethodBeat.o(6246);
        return;
      }
      paramIntent = paramIntent.getBundleExtra("input_data");
      this.uTb.o(paramIntent);
    }
    AppMethodBeat.o(6246);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.ipc.b.1
 * JD-Core Version:    0.7.0.1
 */