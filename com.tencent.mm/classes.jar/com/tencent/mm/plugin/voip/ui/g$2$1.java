package com.tencent.mm.plugin.voip.ui;

import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class g$2$1
  implements am.a
{
  g$2$1(g.2 param2) {}
  
  public final boolean tC()
  {
    y.i("MicroMsg.VoipVoiceMiniManager", "click small view and time is up we remove it..");
    this.pZE.pZD.dismiss();
    if (g.a(this.pZE.pZD) != null) {
      g.a(this.pZE.pZD).stopTimer();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.g.2.1
 * JD-Core Version:    0.7.0.1
 */