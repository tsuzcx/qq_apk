package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.k.b;
import com.tencent.mm.sdk.platformtools.ab;

final class SnsTagDetailUI$4
  implements k.b
{
  SnsTagDetailUI$4(SnsTagDetailUI paramSnsTagDetailUI) {}
  
  public final boolean iz(int paramInt)
  {
    AppMethodBeat.i(39346);
    if (!this.rWD.eeU.LY(paramInt)) {
      ab.d("MicroMsg.SnsTagDetailUI", "onItemLongClick ".concat(String.valueOf(paramInt)));
    }
    AppMethodBeat.o(39346);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTagDetailUI.4
 * JD-Core Version:    0.7.0.1
 */