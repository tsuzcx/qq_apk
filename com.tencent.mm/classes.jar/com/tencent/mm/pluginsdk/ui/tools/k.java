package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.ui.base.h;

public final class k
{
  public static boolean hm(Context paramContext)
  {
    AppMethodBeat.i(152416);
    if (!an.aFx("network_doctor_shown"))
    {
      AppMethodBeat.o(152416);
      return false;
    }
    h.a(paramContext, 2131761546, 2131755906, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(152415);
        paramAnonymousDialogInterface = this.val$context;
        Object localObject = new Intent("android.settings.WIRELESS_SETTINGS");
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/pluginsdk/ui/tools/NetworkErrAlert$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/pluginsdk/ui/tools/NetworkErrAlert$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(152415);
      }
    }, null);
    AppMethodBeat.o(152416);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.k
 * JD-Core Version:    0.7.0.1
 */