package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;

public final class br
{
  public static void h(Context paramContext, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(99694);
    e.a locala = new e.a(paramContext);
    locala.aEK(b.j.sns_welcome_tip);
    locala.bDw(paramContext.getString(b.j.sns_welcome_titlea) + "\n\n" + paramContext.getString(b.j.sns_welcome_titlec));
    locala.aER(b.j.welcome_i_know).c(paramOnClickListener);
    locala.c(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(99693);
        h.baF();
        int i = Util.nullAs((Integer)h.baE().ban().d(68385, null), 0);
        h.baF();
        h.baE().ban().B(68385, Integer.valueOf(i + 1));
        AppMethodBeat.o(99693);
      }
    });
    locala.jHH().show();
    AppMethodBeat.o(99694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.br
 * JD-Core Version:    0.7.0.1
 */