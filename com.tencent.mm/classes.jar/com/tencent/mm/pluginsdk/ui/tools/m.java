package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.ui.base.k;

public final class m
{
  public static boolean lE(Context paramContext)
  {
    AppMethodBeat.i(152416);
    if (!MMEntryLock.lock("network_doctor_shown"))
    {
      AppMethodBeat.o(152416);
      return false;
    }
    k.a(paramContext, c.h.network_doctor, c.h.app_tip, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(152415);
        paramAnonymousDialogInterface = m.this;
        Object localObject = new Intent("android.settings.WIRELESS_SETTINGS");
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/pluginsdk/ui/tools/NetworkErrAlert$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/pluginsdk/ui/tools/NetworkErrAlert$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(152415);
      }
    }, null);
    AppMethodBeat.o(152416);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.m
 * JD-Core Version:    0.7.0.1
 */