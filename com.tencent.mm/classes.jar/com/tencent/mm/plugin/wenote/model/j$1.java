package com.tencent.mm.plugin.wenote.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

final class j$1
  implements Runnable
{
  j$1(j paramj) {}
  
  public final void run()
  {
    AppMethodBeat.i(26649);
    j.a(this.vwN);
    this.vwN.el(this.vwN.vvS.pZa);
    if (k.diU() != null) {
      k.diY();
    }
    AppMethodBeat.o(26649);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(26650);
    String str = super.toString() + "|dealWNoteInfo";
    AppMethodBeat.o(26650);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.j.1
 * JD-Core Version:    0.7.0.1
 */