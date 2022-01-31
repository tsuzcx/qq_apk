package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h.d;

final class SightSettingsUI$b$1
  implements h.d
{
  SightSettingsUI$b$1(SightSettingsUI.b paramb) {}
  
  public final void ca(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(55285);
    try
    {
      paramInt1 = this.oQI.oQG[paramInt1];
      SightSettingsUI.b(this.oQI.oQB).set(this.oQI.oQH, Integer.valueOf(paramInt1));
      SightSettingsUI.c(this.oQI.oQB).notifyDataSetChanged();
      AppMethodBeat.o(55285);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.SightSettingsUI", localException, "", new Object[0]);
      AppMethodBeat.o(55285);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightSettingsUI.b.1
 * JD-Core Version:    0.7.0.1
 */