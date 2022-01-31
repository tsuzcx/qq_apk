package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class j$11
  implements Runnable
{
  j$11(j paramj, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(34480);
    if (j.h(this.Alf) != null) {
      j.h(this.Alf).setMessage(j.a(this.Alf).getString(2131296988) + this.gAL + "%");
    }
    AppMethodBeat.o(34480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.j.11
 * JD-Core Version:    0.7.0.1
 */