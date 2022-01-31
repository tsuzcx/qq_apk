package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.x.a.a;

final class SettingsUI$1
  implements a.a
{
  SettingsUI$1(SettingsUI paramSettingsUI) {}
  
  public final void b(ac.a parama)
  {
    AppMethodBeat.i(127560);
    if ((parama != null) && (parama == ac.a.yJH)) {
      SettingsUI.b(this.qKL);
    }
    AppMethodBeat.o(127560);
  }
  
  public final void s(int paramInt, String paramString)
  {
    AppMethodBeat.i(127559);
    if ((paramInt == 262145) || (paramInt == 262157) || (paramInt == 262158)) {
      SettingsUI.a(this.qKL);
    }
    AppMethodBeat.o(127559);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsUI.1
 * JD-Core Version:    0.7.0.1
 */