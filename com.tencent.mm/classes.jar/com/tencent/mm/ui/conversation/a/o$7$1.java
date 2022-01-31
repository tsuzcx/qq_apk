package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import java.lang.ref.WeakReference;

final class o$7$1
  implements DialogInterface.OnClickListener
{
  o$7$1(o.7 param7) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(34716);
    try
    {
      this.Anx.Anv.jIo.setVisibility(8);
      this.Anx.Anv.Anu = true;
      at.startSettingItent((Context)this.Anx.Anv.vUD.get(), this.Anx.bHS);
      AppMethodBeat.o(34716);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      ab.printErrStackTrace("MicroMsg.NetWarnView", paramDialogInterface, "", new Object[0]);
      AppMethodBeat.o(34716);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.o.7.1
 * JD-Core Version:    0.7.0.1
 */