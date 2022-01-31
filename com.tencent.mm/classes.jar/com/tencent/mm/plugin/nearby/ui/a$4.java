package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.nearby.a.c;
import com.tencent.mm.ui.base.h;

final class a$4
  implements DialogInterface.OnClickListener
{
  a$4(a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(55414);
    a.a(this.pcO, new c(2, 0.0F, 0.0F, 0, 0, "", ""));
    g.Rc().a(a.c(this.pcO), 0);
    paramDialogInterface = this.pcO;
    Context localContext = a.a(this.pcO);
    a.a(this.pcO).getString(2131297087);
    a.a(paramDialogInterface, h.b(localContext, a.a(this.pcO).getString(2131301752), true, new a.4.1(this)));
    AppMethodBeat.o(55414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.a.4
 * JD-Core Version:    0.7.0.1
 */