package com.tencent.mm.plugin.sport.ui.a;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.a.b;

final class a$2
  implements DialogInterface.OnClickListener
{
  a$2(a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(25146);
    paramDialogInterface = f.rS(this.sqB.contact.field_username);
    ((com.tencent.mm.pluginsdk.h)g.E(com.tencent.mm.pluginsdk.h.class)).a(paramDialogInterface, (Activity)this.sqB.context, this.sqB.contact);
    this.sqB.bkc();
    ((b)g.E(b.class)).cyy();
    com.tencent.mm.plugin.sport.model.h.lL(false);
    AppMethodBeat.o(25146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.ui.a.a.2
 * JD-Core Version:    0.7.0.1
 */