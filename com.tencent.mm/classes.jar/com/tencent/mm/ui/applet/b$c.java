package com.tencent.mm.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

final class b$c
{
  private LinkedList<String> lPK;
  private int maxSize;
  
  public b$c(b paramb)
  {
    AppMethodBeat.i(141584);
    this.lPK = null;
    this.maxSize = 40;
    this.lPK = new LinkedList();
    AppMethodBeat.o(141584);
  }
  
  final void add(String paramString)
  {
    AppMethodBeat.i(141585);
    if (this.lPK.contains(paramString))
    {
      AppMethodBeat.o(141585);
      return;
    }
    this.lPK.add(paramString);
    if (this.lPK.size() >= this.maxSize) {
      this.lPK.removeFirst();
    }
    AppMethodBeat.o(141585);
  }
  
  final boolean contains(String paramString)
  {
    AppMethodBeat.i(141586);
    boolean bool = this.lPK.contains(paramString);
    AppMethodBeat.o(141586);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.applet.b.c
 * JD-Core Version:    0.7.0.1
 */