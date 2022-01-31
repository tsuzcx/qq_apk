package com.tencent.mm.plugin.voip_cs.b.a;

import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI;
import com.tencent.mm.sdk.platformtools.y;

final class b$6
  implements Runnable
{
  b$6(b paramb) {}
  
  public final void run()
  {
    y.i("MicroMsg.voipcs.VoipCSViewManager", "dismiss button");
    if (b.j(this.qeI).isFinishing()) {
      return;
    }
    b.k(this.qeI).setVisibility(8);
    b.l(this.qeI).setVisibility(8);
    b.m(this.qeI).setVisibility(8);
    b.n(this.qeI);
    b.o(this.qeI);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.a.b.6
 * JD-Core Version:    0.7.0.1
 */