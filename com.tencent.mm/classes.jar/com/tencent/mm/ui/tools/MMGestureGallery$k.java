package com.tencent.mm.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class MMGestureGallery$k
  extends MMGestureGallery.a
{
  float[] nhN;
  
  public MMGestureGallery$k(MMGestureGallery paramMMGestureGallery)
  {
    super(paramMMGestureGallery);
    AppMethodBeat.i(107675);
    this.nhN = new float[9];
    AppMethodBeat.o(107675);
  }
  
  public final void play()
  {
    AppMethodBeat.i(107676);
    MMGestureGallery.c(this.AvP).post(new MMGestureGallery.k.1(this));
    AppMethodBeat.o(107676);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MMGestureGallery.k
 * JD-Core Version:    0.7.0.1
 */