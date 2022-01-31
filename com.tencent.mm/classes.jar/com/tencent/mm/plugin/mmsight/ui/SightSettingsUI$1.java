package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class SightSettingsUI$1
  implements Runnable
{
  SightSettingsUI$1(SightSettingsUI paramSightSettingsUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(55279);
    ab.i("MicroMsg.SightSettingsUI", "has connect");
    SightSettingsUI.a(this.oQB);
    AppMethodBeat.o(55279);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightSettingsUI.1
 * JD-Core Version:    0.7.0.1
 */