package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bh.d;
import com.tencent.mm.g.a.fa;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.contact.VoipAddressUI;

final class ab$1
  implements DialogInterface.OnClickListener
{
  ab$1(ab paramab) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(29839);
    Object localObject = new tl();
    ((tl)localObject).cJT.cJW = true;
    a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = new fa();
    ((fa)localObject).csJ.username = d.fUP.alg();
    a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    VoipAddressUI.iq(ab.c(this.zeD));
    paramDialogInterface.dismiss();
    AppMethodBeat.o(29839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.ab.1
 * JD-Core Version:    0.7.0.1
 */