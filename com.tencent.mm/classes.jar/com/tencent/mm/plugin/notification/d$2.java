package com.tencent.mm.plugin.notification;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.model.aq;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;

final class d$2
  implements Runnable
{
  d$2(d paramd, cm paramcm, aq paramaq, bi parambi) {}
  
  public final void run()
  {
    AppMethodBeat.i(125800);
    if (this.piI.nqW == 49)
    {
      j.b localb = j.b.mY(d.c(this.piI));
      if ((localb.fhV == 1) && (!bo.isNullOrNil(localb.fhW)) && (!bo.isNullOrNil(localb.fhX)))
      {
        this.piJ.a(39, localb.fhX, "", localb.fhW, null, null);
        AppMethodBeat.o(125800);
        return;
      }
      this.piJ.a(this.fkH);
      AppMethodBeat.o(125800);
      return;
    }
    this.piJ.a(this.fkH);
    AppMethodBeat.o(125800);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.d.2
 * JD-Core Version:    0.7.0.1
 */