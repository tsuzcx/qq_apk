package com.tencent.mm.ui.conversation;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.b.c;

final class j$8
  implements DialogInterface.OnClickListener
{
  j$8(j paramj) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(34476);
    g.RO().ac(new j.8.1(this));
    j.e(this.Alf).dismiss();
    h.a(j.a(this.Alf), 2131298911, 2131297087, false, new j.8.2(this));
    AppMethodBeat.o(34476);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.j.8
 * JD-Core Version:    0.7.0.1
 */