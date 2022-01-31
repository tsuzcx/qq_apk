package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.e;
import com.tencent.mm.model.bf.a;
import com.tencent.mm.pointers.PBool;

final class c$11$1
  implements bf.a
{
  c$11$1(c.11 param11) {}
  
  public final boolean JS()
  {
    AppMethodBeat.i(34164);
    if ((this.Ahn.Ahi.value) || (this.Ahn.efE == null) || (!this.Ahn.efE.isShowing()))
    {
      AppMethodBeat.o(34164);
      return true;
    }
    AppMethodBeat.o(34164);
    return false;
  }
  
  public final void JT()
  {
    AppMethodBeat.i(34165);
    e.H(this.Ahn.yWh, false);
    if (this.Ahn.efE != null) {
      this.Ahn.efE.dismiss();
    }
    AppMethodBeat.o(34165);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.c.11.1
 * JD-Core Version:    0.7.0.1
 */