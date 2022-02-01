package com.tencent.mm.plugin.multitalk.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.floatcard.VoipFloatCardPermissionDialog;
import com.tencent.mm.plugin.voip.floatcard.VoipFloatCardPermissionDialog.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class g$3
  implements Runnable
{
  g$3(g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(285404);
    VoipFloatCardPermissionDialog.a locala = VoipFloatCardPermissionDialog.UvI;
    VoipFloatCardPermissionDialog.a.showDialog(MMApplicationContext.getContext());
    AppMethodBeat.o(285404);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.g.3
 * JD-Core Version:    0.7.0.1
 */