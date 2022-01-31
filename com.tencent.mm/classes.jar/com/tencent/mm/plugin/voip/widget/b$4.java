package com.tencent.mm.plugin.voip.widget;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.ui.a;
import com.tencent.mm.plugin.voip.ui.e;
import com.tencent.mm.sdk.platformtools.ah;

final class b$4
  implements a
{
  b$4(b paramb) {}
  
  public final void a(Intent paramIntent, e parame)
  {
    AppMethodBeat.i(140267);
    if (paramIntent.getBooleanExtra("Voip_Is_Talking", false))
    {
      parame.aeI(this.tJE.cQe());
      AppMethodBeat.o(140267);
      return;
    }
    parame.aeI(ah.getContext().getString(2131304704));
    AppMethodBeat.o(140267);
  }
  
  public final boolean bIS()
  {
    AppMethodBeat.i(140266);
    if ((com.tencent.mm.plugin.voip.a.b.HS(b.d(this.tJE))) || (com.tencent.mm.plugin.voip.a.b.HQ(b.d(this.tJE))))
    {
      AppMethodBeat.o(140266);
      return true;
    }
    AppMethodBeat.o(140266);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.b.4
 * JD-Core Version:    0.7.0.1
 */