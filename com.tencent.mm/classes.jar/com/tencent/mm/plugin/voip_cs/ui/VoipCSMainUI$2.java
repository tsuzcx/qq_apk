package com.tencent.mm.plugin.voip_cs.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.compatible.b.g.a;
import com.tencent.mm.plugin.voip_cs.b.a.c;
import com.tencent.mm.sdk.platformtools.ab;

final class VoipCSMainUI$2
  implements g.a
{
  VoipCSMainUI$2(VoipCSMainUI paramVoipCSMainUI) {}
  
  public final void gy(int paramInt)
  {
    AppMethodBeat.i(135390);
    ab.d("MicroMsg.voipcs.VoipCSMainUI", "onBluetoothHeadsetStateChange status: %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(135390);
      return;
      g.KC().KE();
      AppMethodBeat.o(135390);
      return;
      g.KC().KF();
      VoipCSMainUI.c(this.tLK).mR(true);
      AppMethodBeat.o(135390);
      return;
      VoipCSMainUI.c(this.tLK).mR(false);
      AppMethodBeat.o(135390);
      return;
      g.KC().KF();
      VoipCSMainUI.c(this.tLK).mR(true);
      AppMethodBeat.o(135390);
      return;
      g.KC().KE();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.2
 * JD-Core Version:    0.7.0.1
 */