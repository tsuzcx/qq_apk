package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class MMAppMgr$6
  implements DialogInterface.OnClickListener
{
  MMAppMgr$6(Context paramContext) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(33408);
    try
    {
      Object localObject = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
      paramDialogInterface = this.val$context;
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/MMAppMgr$14", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramDialogInterface, "com/tencent/mm/ui/MMAppMgr$14", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(33408);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      Log.printErrStackTrace("MicroMsg.MMAppMgr", paramDialogInterface, "showLbsTipsAlert", new Object[0]);
      AppMethodBeat.o(33408);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.MMAppMgr.6
 * JD-Core Version:    0.7.0.1
 */