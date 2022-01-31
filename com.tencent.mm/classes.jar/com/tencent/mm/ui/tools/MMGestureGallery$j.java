package com.tencent.mm.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class MMGestureGallery$j
  extends MMGestureGallery.a
{
  float[] nhN;
  
  public MMGestureGallery$j(MMGestureGallery paramMMGestureGallery)
  {
    super(paramMMGestureGallery);
    AppMethodBeat.i(107672);
    this.nhN = new float[9];
    AppMethodBeat.o(107672);
  }
  
  public final void play()
  {
    AppMethodBeat.i(107673);
    MMGestureGallery.c(this.AvP).post(new MMGestureGallery.j.1(this));
    AppMethodBeat.o(107673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MMGestureGallery.j
 * JD-Core Version:    0.7.0.1
 */