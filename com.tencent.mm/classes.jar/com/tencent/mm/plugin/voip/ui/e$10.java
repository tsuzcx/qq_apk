package com.tencent.mm.plugin.voip.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.floatcard.VoipFloatCardPermissionDialog;
import com.tencent.mm.plugin.voip.floatcard.VoipFloatCardPermissionDialog.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class e$10
  implements Runnable
{
  e$10(e parame) {}
  
  public final void run()
  {
    AppMethodBeat.i(292336);
    VoipFloatCardPermissionDialog.a locala = VoipFloatCardPermissionDialog.UvI;
    VoipFloatCardPermissionDialog.a.showDialog(MMApplicationContext.getContext());
    AppMethodBeat.o(292336);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.e.10
 * JD-Core Version:    0.7.0.1
 */