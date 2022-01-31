package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.l;

final class r$1
  implements l
{
  r$1(r paramr) {}
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(105231);
    switch (paramj.bpE)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(105231);
      return;
      if ((r.a(this.AdP) == null) || (!r.a(this.AdP).equals(r.a(this.AdP))))
      {
        AppMethodBeat.o(105231);
        return;
      }
      r.b(this.AdP);
      r.a(this.AdP, paramj.mRX);
      r.a(this.AdP, paramj.mSW);
      r.b(this.AdP, paramj.mSW);
      d.bT(paramj.mSW);
      boolean bool = r.c(this.AdP);
      r.a(this.AdP, paramj.mPi.query, bool);
      AppMethodBeat.o(105231);
      return;
      if (!paramj.mPi.query.equals(this.AdP.query))
      {
        AppMethodBeat.o(105231);
        return;
      }
      r.c(this.AdP);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.r.1
 * JD-Core Version:    0.7.0.1
 */