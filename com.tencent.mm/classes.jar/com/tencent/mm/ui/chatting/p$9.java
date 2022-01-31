package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.multitalk.model.a;
import com.tencent.mm.sdk.platformtools.ah;

final class p$9
  implements DialogInterface.OnClickListener
{
  p$9(p paramp) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(156135);
    if (!((a)g.E(a.class)).Ui(this.zyT.getTalkerUserName()))
    {
      Toast.makeText(ah.getContext(), ah.getContext().getString(2131301704), 0).show();
      AppMethodBeat.o(156135);
      return;
    }
    if (!((a)g.E(a.class)).Uo(this.zyT.getTalkerUserName())) {
      Toast.makeText(ah.getContext(), ah.getContext().getString(2131301669), 0).show();
    }
    AppMethodBeat.o(156135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.p.9
 * JD-Core Version:    0.7.0.1
 */