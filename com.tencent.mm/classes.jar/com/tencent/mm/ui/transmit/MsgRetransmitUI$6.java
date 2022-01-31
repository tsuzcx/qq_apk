package com.tencent.mm.ui.transmit;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.j.a;

final class MsgRetransmitUI$6
  implements j.a
{
  MsgRetransmitUI$6(MsgRetransmitUI paramMsgRetransmitUI) {}
  
  public final void dlh()
  {
    AppMethodBeat.i(35068);
    if (MsgRetransmitUI.f(this.Azx) != null)
    {
      MsgRetransmitUI.f(this.Azx).dismiss();
      MsgRetransmitUI.g(this.Azx);
    }
    this.Azx.finish();
    AppMethodBeat.o(35068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MsgRetransmitUI.6
 * JD-Core Version:    0.7.0.1
 */