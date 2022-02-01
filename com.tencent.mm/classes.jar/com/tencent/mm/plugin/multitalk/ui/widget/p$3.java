package com.tencent.mm.plugin.multitalk.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.floatcard.VoipFloatCardPermissionDialog;
import com.tencent.mm.plugin.voip.floatcard.VoipFloatCardPermissionDialog.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class p$3
  implements Runnable
{
  p$3(p paramp) {}
  
  public final void run()
  {
    AppMethodBeat.i(285552);
    VoipFloatCardPermissionDialog.a locala = VoipFloatCardPermissionDialog.UvI;
    VoipFloatCardPermissionDialog.a.showDialog(MMApplicationContext.getContext());
    AppMethodBeat.o(285552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.p.3
 * JD-Core Version:    0.7.0.1
 */