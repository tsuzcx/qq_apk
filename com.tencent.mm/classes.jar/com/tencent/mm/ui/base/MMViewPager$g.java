package com.tencent.mm.ui.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class MMViewPager$g
  extends MMViewPager.a
{
  float[] nhN;
  
  public MMViewPager$g(MMViewPager paramMMViewPager)
  {
    super(paramMMViewPager);
    AppMethodBeat.i(106909);
    this.nhN = new float[9];
    AppMethodBeat.o(106909);
  }
  
  public final void play()
  {
    AppMethodBeat.i(106910);
    MMViewPager.c(this.znE).post(new MMViewPager.g.1(this));
    AppMethodBeat.o(106910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMViewPager.g
 * JD-Core Version:    0.7.0.1
 */