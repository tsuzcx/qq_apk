package com.tencent.mm.ui.gridviewheaders;

import com.tencent.matrix.trace.core.AppMethodBeat;

class GridHeadersGridView$f
{
  private int zml;
  
  private GridHeadersGridView$f(GridHeadersGridView paramGridHeadersGridView) {}
  
  public final void dNn()
  {
    AppMethodBeat.i(107371);
    this.zml = GridHeadersGridView.b(this.Ape);
    AppMethodBeat.o(107371);
  }
  
  public final boolean dNo()
  {
    AppMethodBeat.i(107372);
    if ((this.Ape.hasWindowFocus()) && (GridHeadersGridView.c(this.Ape) == this.zml))
    {
      AppMethodBeat.o(107372);
      return true;
    }
    AppMethodBeat.o(107372);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.f
 * JD-Core Version:    0.7.0.1
 */