package com.tencent.mm.view;

import com.tencent.matrix.trace.core.AppMethodBeat;

class SmileySubGrid$d
{
  private int zml;
  
  private SmileySubGrid$d(SmileySubGrid paramSmileySubGrid) {}
  
  public final void dNn()
  {
    AppMethodBeat.i(62958);
    this.zml = SmileySubGrid.a(this.ARL);
    AppMethodBeat.o(62958);
  }
  
  public final boolean dNo()
  {
    AppMethodBeat.i(62959);
    if ((this.ARL.hasWindowFocus()) && (SmileySubGrid.b(this.ARL) == this.zml))
    {
      AppMethodBeat.o(62959);
      return true;
    }
    AppMethodBeat.o(62959);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.SmileySubGrid.d
 * JD-Core Version:    0.7.0.1
 */