package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.b.a;

final class b$10
  implements DialogInterface.OnCancelListener
{
  b$10(b paramb, m paramm) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(153588);
    aw.Rc().b(536, this.pDl);
    paramDialogInterface = new dd();
    paramDialogInterface.cqA.opType = 2;
    paramDialogInterface.cqA.cqE = this.ckS;
    a.ymk.l(paramDialogInterface);
    AppMethodBeat.o(153588);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.10
 * JD-Core Version:    0.7.0.1
 */