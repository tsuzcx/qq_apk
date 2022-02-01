package com.tencent.tav.core.composition;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum VideoComposition$RenderLayoutMode
{
  static
  {
    AppMethodBeat.i(189716);
    aspectFit = new RenderLayoutMode("aspectFit", 0);
    aspectFill = new RenderLayoutMode("aspectFill", 1);
    $VALUES = new RenderLayoutMode[] { aspectFit, aspectFill };
    AppMethodBeat.o(189716);
  }
  
  private VideoComposition$RenderLayoutMode() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.core.composition.VideoComposition.RenderLayoutMode
 * JD-Core Version:    0.7.0.1
 */