package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bf.a;
import com.tencent.mm.pointers.PBool;

final class c$6
  implements bf.a
{
  c$6(PBool paramPBool, ProgressDialog paramProgressDialog) {}
  
  public final boolean JS()
  {
    return this.Ahi.value;
  }
  
  public final void JT()
  {
    AppMethodBeat.i(34160);
    if (this.efE != null) {
      this.efE.dismiss();
    }
    AppMethodBeat.o(34160);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.c.6
 * JD-Core Version:    0.7.0.1
 */