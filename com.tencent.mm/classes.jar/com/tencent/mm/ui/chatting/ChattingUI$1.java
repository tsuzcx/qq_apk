package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ng;
import com.tencent.mm.g.a.rb;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.base.h;

final class ChattingUI$1
  implements Runnable
{
  ChattingUI$1(ChattingUI paramChattingUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(34692);
    h.d(this.HPt, this.HPt.getString(2131761704), "", this.HPt.getString(2131761705), this.HPt.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(34690);
        paramAnonymousDialogInterface = new rb();
        a.GpY.l(paramAnonymousDialogInterface);
        AppMethodBeat.o(34690);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(34691);
        paramAnonymousDialogInterface = new ng();
        a.GpY.l(paramAnonymousDialogInterface);
        AppMethodBeat.o(34691);
      }
    });
    AppMethodBeat.o(34692);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingUI.1
 * JD-Core Version:    0.7.0.1
 */