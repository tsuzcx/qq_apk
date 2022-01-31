package com.tencent.mm.plugin.voip_cs.b.a;

import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI;
import com.tencent.mm.sdk.platformtools.ab;

final class b$6
  implements Runnable
{
  b$6(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(135323);
    ab.i("MicroMsg.voipcs.VoipCSViewManager", "dismiss button");
    if (b.j(this.tLv).isFinishing())
    {
      AppMethodBeat.o(135323);
      return;
    }
    b.k(this.tLv).setVisibility(8);
    b.l(this.tLv).setVisibility(8);
    b.m(this.tLv).setVisibility(8);
    b.n(this.tLv);
    b.o(this.tLv);
    AppMethodBeat.o(135323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.a.b.6
 * JD-Core Version:    0.7.0.1
 */