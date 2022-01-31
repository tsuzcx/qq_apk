package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.qqmail.b.t;
import com.tencent.mm.ui.base.h;

final class a$5
  implements DialogInterface.OnClickListener
{
  a$5(a parama, boolean paramBoolean, EditText paramEditText) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(68266);
    paramDialogInterface = new t(this.mvd, com.tencent.mm.a.g.w(this.pMD.getText().toString().trim().getBytes()));
    com.tencent.mm.kernel.g.RK().eHt.a(paramDialogInterface, 0);
    a locala = this.pMB;
    Context localContext = a.a(this.pMB);
    a.a(this.pMB).getString(2131298705);
    a.a(locala, h.b(localContext, a.a(this.pMB).getString(2131297112), true, new a.5.1(this, paramDialogInterface)));
    AppMethodBeat.o(68266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.a.5
 * JD-Core Version:    0.7.0.1
 */