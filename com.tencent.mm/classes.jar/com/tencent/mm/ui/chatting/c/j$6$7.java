package com.tencent.mm.ui.chatting.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.cm.a;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.storage.bi;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class j$6$7
  implements DialogInterface.OnClickListener
{
  j$6$7(j.6 param6, List paramList, cm paramcm) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(31322);
    paramDialogInterface = this.zym.iterator();
    while (paramDialogInterface.hasNext())
    {
      bi localbi = (bi)paramDialogInterface.next();
      if ((!localbi.dxT()) && (!localbi.dxS()))
      {
        if ((this.zEZ.cpR.type == 14) && (this.zEZ.cpR.cpT.wVc.size() == 0))
        {
          this.zEY.zET.dHU();
          AppMethodBeat.o(31322);
          return;
        }
        j.6.a(this.zEY, this.zEZ);
        j.6.fh(j.c(this.zEY.zET));
        AppMethodBeat.o(31322);
        return;
      }
    }
    AppMethodBeat.o(31322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.j.6.7
 * JD-Core Version:    0.7.0.1
 */