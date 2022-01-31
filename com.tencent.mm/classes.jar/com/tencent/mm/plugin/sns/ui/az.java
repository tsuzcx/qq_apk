package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.mm.ui.widget.b.c.a;

public final class az
{
  public static void b(Context paramContext, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(39834);
    c.a locala = new c.a(paramContext);
    locala.Rb(2131304043);
    locala.avn(paramContext.getString(2131304044) + "\n\n" + paramContext.getString(2131304045));
    locala.Ri(2131305958).a(paramOnClickListener);
    locala.a(new az.1());
    locala.aLZ().show();
    AppMethodBeat.o(39834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.az
 * JD-Core Version:    0.7.0.1
 */