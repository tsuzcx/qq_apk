package com.tencent.mm.ui.conversation;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.n;

final class j$10$1
  implements DialogInterface.OnCancelListener
{
  j$10$1(j.10 param10) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(34478);
    aw.Rc().a(j.g(this.Alk.Alf));
    if (n.raR != null) {
      n.raR.cnL();
    }
    AppMethodBeat.o(34478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.j.10.1
 * JD-Core Version:    0.7.0.1
 */