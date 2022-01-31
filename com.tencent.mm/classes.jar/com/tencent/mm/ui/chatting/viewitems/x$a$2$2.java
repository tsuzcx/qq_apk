package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelappbrand.s;

final class x$a$2$2
  implements DialogInterface.OnCancelListener
{
  x$a$2$2(x.a.2 param2, s params) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(33153);
    aw.Rc().a(this.zVp);
    AppMethodBeat.o(33153);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.x.a.2.2
 * JD-Core Version:    0.7.0.1
 */