package com.tencent.mm.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

final class b$c
{
  private LinkedList<String> elu;
  private int maxSize;
  
  public b$c(b paramb)
  {
    AppMethodBeat.i(106224);
    this.elu = null;
    this.maxSize = 40;
    this.elu = new LinkedList();
    AppMethodBeat.o(106224);
  }
  
  final boolean contains(String paramString)
  {
    AppMethodBeat.i(106226);
    boolean bool = this.elu.contains(paramString);
    AppMethodBeat.o(106226);
    return bool;
  }
  
  final void xB(String paramString)
  {
    AppMethodBeat.i(106225);
    if (this.elu.contains(paramString))
    {
      AppMethodBeat.o(106225);
      return;
    }
    this.elu.add(paramString);
    if (this.elu.size() >= this.maxSize) {
      this.elu.removeFirst();
    }
    AppMethodBeat.o(106225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.applet.b.c
 * JD-Core Version:    0.7.0.1
 */