package com.tencent.mm.ui;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bf.a;

final class SingleChatInfoUI$9
  implements bf.a
{
  SingleChatInfoUI$9(SingleChatInfoUI paramSingleChatInfoUI, ProgressDialog paramProgressDialog) {}
  
  public final boolean JS()
  {
    AppMethodBeat.i(29876);
    boolean bool = SingleChatInfoUI.access$400();
    AppMethodBeat.o(29876);
    return bool;
  }
  
  public final void JT()
  {
    AppMethodBeat.i(29877);
    if (this.efE != null) {
      this.efE.dismiss();
    }
    AppMethodBeat.o(29877);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.SingleChatInfoUI.9
 * JD-Core Version:    0.7.0.1
 */