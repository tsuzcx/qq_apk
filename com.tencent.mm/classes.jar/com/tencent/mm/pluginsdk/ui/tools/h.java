package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;

public final class h
{
  public static boolean fY(Context paramContext)
  {
    AppMethodBeat.i(79947);
    if (!aj.apk("network_doctor_shown"))
    {
      AppMethodBeat.o(79947);
      return false;
    }
    com.tencent.mm.ui.base.h.a(paramContext, 2131301799, 2131297087, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(79946);
        this.val$context.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
        AppMethodBeat.o(79946);
      }
    }, null);
    AppMethodBeat.o(79947);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.h
 * JD-Core Version:    0.7.0.1
 */