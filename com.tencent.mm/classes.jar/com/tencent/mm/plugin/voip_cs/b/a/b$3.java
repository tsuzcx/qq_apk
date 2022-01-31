package com.tencent.mm.plugin.voip_cs.b.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.ui.VoipBigIconButton;
import com.tencent.mm.plugin.voip_cs.b.c;
import com.tencent.mm.plugin.voip_cs.b.e;
import com.tencent.mm.plugin.voip_cs.c.a;
import com.tencent.mm.sdk.platformtools.ab;

final class b$3
  implements View.OnClickListener
{
  b$3(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(135320);
    ab.i("MicroMsg.voipcs.VoipCSViewManager", "switch camera");
    b.d(this.tLv).setEnabled(false);
    if (c.cQn().tKO > 1) {
      b.e(this.tLv);
    }
    b.d(this.tLv).setEnabled(true);
    if (b.f(this.tLv) != null) {
      b.f(this.tLv).cPy();
    }
    AppMethodBeat.o(135320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.a.b.3
 * JD-Core Version:    0.7.0.1
 */