package com.tencent.mm.ui.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class MMViewPager$j
  extends MMViewPager.a
{
  float[] nhN;
  
  public MMViewPager$j(MMViewPager paramMMViewPager)
  {
    super(paramMMViewPager);
    AppMethodBeat.i(106918);
    this.nhN = new float[9];
    AppMethodBeat.o(106918);
  }
  
  public final void play()
  {
    AppMethodBeat.i(106919);
    MMViewPager.c(this.znE).post(new MMViewPager.j.1(this));
    AppMethodBeat.o(106919);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMViewPager.j
 * JD-Core Version:    0.7.0.1
 */