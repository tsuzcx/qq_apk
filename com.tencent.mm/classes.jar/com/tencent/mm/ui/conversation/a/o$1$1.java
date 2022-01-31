package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

final class o$1$1
  implements Runnable
{
  o$1$1(o.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(34707);
    String str = com.tencent.mm.sdk.platformtools.o.ch((Context)this.Anw.Anv.vUD.get());
    ab.i("MicroMsg.NetWarnView", "curr top activity is: %s", new Object[] { str });
    int i;
    if (!str.endsWith("NetworkDiagnoseAllInOneUI"))
    {
      if (!this.Anw.Anv.Ano) {
        break label81;
      }
      i = 2;
    }
    for (;;)
    {
      o.a(this.Anw.Anv, i);
      AppMethodBeat.o(34707);
      return;
      label81:
      if (this.Anw.Anv.Anp) {
        i = 4;
      } else if (this.Anw.Anv.Anq) {
        i = 5;
      } else {
        i = 3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.o.1.1
 * JD-Core Version:    0.7.0.1
 */