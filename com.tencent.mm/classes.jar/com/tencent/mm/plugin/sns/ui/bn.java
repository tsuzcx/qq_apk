package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;

public final class bn
{
  public static void g(Context paramContext, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(99694);
    d.a locala = new d.a(paramContext);
    locala.aoO(2131766305);
    locala.boo(paramContext.getString(2131766306) + "\n\n" + paramContext.getString(2131766307));
    locala.aoV(2131768713).c(paramOnClickListener);
    locala.a(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(99693);
        g.aAi();
        int i = Util.nullAs((Integer)g.aAh().azQ().get(68385, null), 0);
        g.aAi();
        g.aAh().azQ().set(68385, Integer.valueOf(i + 1));
        AppMethodBeat.o(99693);
      }
    });
    locala.hbn().show();
    AppMethodBeat.o(99694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bn
 * JD-Core Version:    0.7.0.1
 */