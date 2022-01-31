package com.tencent.mm.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class MMGestureGallery$h
  extends MMGestureGallery.a
{
  float[] nhN;
  
  public MMGestureGallery$h(MMGestureGallery paramMMGestureGallery)
  {
    super(paramMMGestureGallery);
    AppMethodBeat.i(107666);
    this.nhN = new float[9];
    AppMethodBeat.o(107666);
  }
  
  public final void play()
  {
    AppMethodBeat.i(107667);
    MMGestureGallery.c(this.AvP).post(new MMGestureGallery.h.1(this));
    AppMethodBeat.o(107667);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MMGestureGallery.h
 * JD-Core Version:    0.7.0.1
 */