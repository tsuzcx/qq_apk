package com.tencent.mm.plugin.voip_cs.b.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.voip.ui.VoipBigIconButton;
import com.tencent.mm.plugin.voip_cs.b.c;
import com.tencent.mm.plugin.voip_cs.b.e;
import com.tencent.mm.plugin.voip_cs.c.a;
import com.tencent.mm.sdk.platformtools.y;

final class b$3
  implements View.OnClickListener
{
  b$3(b paramb) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.voipcs.VoipCSViewManager", "switch camera");
    b.d(this.qeI).setEnabled(false);
    if (c.bSP().qeb > 1) {
      b.e(this.qeI);
    }
    b.d(this.qeI).setEnabled(true);
    if (b.f(this.qeI) != null) {
      b.f(this.qeI).bSq();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.a.b.3
 * JD-Core Version:    0.7.0.1
 */