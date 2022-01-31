package com.tencent.mm.ui.widget.textview;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$c
{
  int end;
  int start;
  
  a$c(a parama) {}
  
  public final String toString()
  {
    AppMethodBeat.i(113142);
    String str = "start: " + this.start + " end: " + this.end;
    AppMethodBeat.o(113142);
    return str;
  }
  
  final boolean ws(int paramInt)
  {
    return (paramInt >= this.start) && (paramInt < this.end);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.a.c
 * JD-Core Version:    0.7.0.1
 */