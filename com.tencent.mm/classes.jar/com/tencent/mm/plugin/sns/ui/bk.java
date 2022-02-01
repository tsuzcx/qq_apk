package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;

public final class bk
{
  public static void b(Context paramContext, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(99694);
    d.a locala = new d.a(paramContext);
    locala.afe(2131764065);
    locala.aXG(paramContext.getString(2131764066) + "\n\n" + paramContext.getString(2131764067));
    locala.afl(2131766205).c(paramOnClickListener);
    locala.a(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(99693);
        g.ajD();
        int i = bt.a((Integer)g.ajC().ajl().get(68385, null), 0);
        g.ajD();
        g.ajC().ajl().set(68385, Integer.valueOf(i + 1));
        AppMethodBeat.o(99693);
      }
    });
    locala.fMb().show();
    AppMethodBeat.o(99694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bk
 * JD-Core Version:    0.7.0.1
 */