package com.tencent.mm.ui.chatting.i;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.cm.a;
import com.tencent.mm.protocal.protobuf.acq;
import java.util.LinkedList;
import java.util.List;

final class e$4
  implements DialogInterface.OnClickListener
{
  e$4(e parame, cm paramcm, List paramList) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(32561);
    if ((this.zEZ.cpR.type == 14) && (this.zEZ.cpR.cpT.wVc.size() == 0))
    {
      AppMethodBeat.o(32561);
      return;
    }
    e.a(this.zPs, this.zEZ);
    e.fr(this.ieO);
    AppMethodBeat.o(32561);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.e.4
 * JD-Core Version:    0.7.0.1
 */