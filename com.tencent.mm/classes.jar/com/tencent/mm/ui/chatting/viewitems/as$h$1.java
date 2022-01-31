package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bh.d;
import com.tencent.mm.g.a.fa;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.sdk.b.a;

final class as$h$1
  implements DialogInterface.OnClickListener
{
  as$h$1(as.h paramh, az paramaz) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(33423);
    Object localObject = new tl();
    ((tl)localObject).cJT.cJW = true;
    a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = new fa();
    ((fa)localObject).csJ.username = d.fUP.alg();
    a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    as.h.a(this.zYn, this.zYm);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(33423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.as.h.1
 * JD-Core Version:    0.7.0.1
 */