package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;

public final class bh
{
  public static void b(Context paramContext, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(99694);
    d.a locala = new d.a(paramContext);
    locala.aau(2131764065);
    locala.aMg(paramContext.getString(2131764066) + "\n\n" + paramContext.getString(2131764067));
    locala.aaB(2131766205).b(paramOnClickListener);
    locala.a(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(99693);
        g.afC();
        int i = bt.a((Integer)g.afB().afk().get(68385, null), 0);
        g.afC();
        g.afB().afk().set(68385, Integer.valueOf(i + 1));
        AppMethodBeat.o(99693);
      }
    });
    locala.fft().show();
    AppMethodBeat.o(99694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bh
 * JD-Core Version:    0.7.0.1
 */