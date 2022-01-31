package com.tencent.mm.ui.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class MMViewPager$h
  extends MMViewPager.a
{
  float[] nhN;
  
  public MMViewPager$h(MMViewPager paramMMViewPager)
  {
    super(paramMMViewPager);
    AppMethodBeat.i(106912);
    this.nhN = new float[9];
    AppMethodBeat.o(106912);
  }
  
  public final void play()
  {
    AppMethodBeat.i(106913);
    MMViewPager.c(this.znE).post(new MMViewPager.h.1(this));
    AppMethodBeat.o(106913);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMViewPager.h
 * JD-Core Version:    0.7.0.1
 */