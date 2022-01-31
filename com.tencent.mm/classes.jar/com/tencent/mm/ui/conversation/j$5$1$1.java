package com.tencent.mm.ui.conversation;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.protocal.protobuf.ckf;
import java.io.File;

final class j$5$1$1
  implements DialogInterface.OnClickListener
{
  j$5$1$1(j.5.1 param1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(34466);
    q.a(j.a(this.Ali.Alh.Alf), new File(this.Ali.Alh.Alg.xUk), null, false);
    h.qsU.idkeyStat(614L, 50L, 1L, false);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(34466);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.j.5.1.1
 * JD-Core Version:    0.7.0.1
 */