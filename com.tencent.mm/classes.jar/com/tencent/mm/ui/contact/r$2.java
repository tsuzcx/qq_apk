package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

final class r$2
  implements com.tencent.mm.plugin.fts.a.l
{
  r$2(r paramr) {}
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(105232);
    switch (paramj.bpE)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(105232);
      return;
      if ((r.a(this.AdP) != null) && (r.a(this.AdP).equals(r.a(this.AdP))))
      {
        r.a(this.AdP, paramj.mRX);
        r.a(this.AdP, paramj.mSW);
        if (paramj.mSW.size() > 0) {
          switch (((com.tencent.mm.plugin.fts.a.a.l)paramj.mSW.get(0)).type)
          {
          default: 
            ab.i("MicroMsg.MMSearchContactAdapter", "not support search");
          }
        }
        for (;;)
        {
          boolean bool = r.c(this.AdP);
          r.a(this.AdP, paramj.mPi.query, bool);
          AppMethodBeat.o(105232);
          return;
          r.c(this.AdP, paramj.mSW);
          continue;
          this.AdP.mVt = paramj.mSW;
          continue;
          r.d(this.AdP, paramj.mSW);
          continue;
          if (r.d(this.AdP) != null) {
            r.d(this.AdP).addAll(paramj.mSW);
          } else {
            r.c(this.AdP, paramj.mSW);
          }
        }
        if (!paramj.mPi.query.equals(this.AdP.query))
        {
          AppMethodBeat.o(105232);
          return;
        }
        r.c(this.AdP);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.r.2
 * JD-Core Version:    0.7.0.1
 */