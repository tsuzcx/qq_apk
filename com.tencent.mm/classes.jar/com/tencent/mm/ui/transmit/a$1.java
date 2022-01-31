package com.tencent.mm.ui.transmit;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import java.util.ArrayList;
import java.util.List;

final class a$1
  implements com.tencent.mm.plugin.fts.a.l
{
  a$1(a parama) {}
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(35023);
    a.a locala = new a.a(this.AyM, (byte)0);
    locala.query = paramj.mPi.query;
    locala.mRX = paramj.mRX;
    locala.mSW = paramj.mSW;
    if ((locala.mSW == null) || (locala.mSW.size() == 0))
    {
      paramj = new com.tencent.mm.plugin.fts.a.a.l();
      paramj.mRV = "no_result​";
      locala.mSW = new ArrayList();
      locala.mSW.add(paramj);
    }
    a.a(this.AyM).add(locala);
    a.b(this.AyM);
    AppMethodBeat.o(35023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.a.1
 * JD-Core Version:    0.7.0.1
 */