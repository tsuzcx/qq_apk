package com.tencent.mm.plugin.shake.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qt;
import com.tencent.mm.g.a.qt.b;
import com.tencent.mm.sdk.platformtools.ab;

final class a$3
  implements Runnable
{
  a$3(a parama, qt paramqt) {}
  
  public final void run()
  {
    AppMethodBeat.i(24549);
    ab.i("MicroMsg.ShakeCardDialog", "doNetSceneAccept callback");
    a.a(this.qOr, this.qOs.cHm);
    if (a.g(this.qOr) != null)
    {
      a.a(this.qOr, 8);
      if (a.g(this.qOr) != null) {
        a.a(this.qOr, a.g(this.qOr).cHn);
      }
      if ((a.g(this.qOr) != null) && (a.g(this.qOr).csk))
      {
        a.a(this.qOr, a.a.qOv);
        a.h(this.qOr);
        a.i(this.qOr);
        a.j(this.qOr);
        if (a.a(this.qOr) != null)
        {
          a.a(this.qOr).clB();
          AppMethodBeat.o(24549);
        }
      }
      else
      {
        a.a(this.qOr, a.a.qOw);
        a.h(this.qOr);
        a.k(this.qOr);
        AppMethodBeat.o(24549);
      }
    }
    else
    {
      ab.i("MicroMsg.ShakeCardDialog", "doNetSceneAccept callback, mCardAcceptResult == null");
    }
    AppMethodBeat.o(24549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.b.a.3
 * JD-Core Version:    0.7.0.1
 */