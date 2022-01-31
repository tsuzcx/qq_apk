package com.tencent.mm.ui.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class MMViewPager$i
  extends MMViewPager.a
{
  float[] nhN;
  
  public MMViewPager$i(MMViewPager paramMMViewPager)
  {
    super(paramMMViewPager);
    AppMethodBeat.i(106915);
    this.nhN = new float[9];
    AppMethodBeat.o(106915);
  }
  
  public final void play()
  {
    AppMethodBeat.i(106916);
    MMViewPager.c(this.znE).post(new MMViewPager.i.1(this));
    AppMethodBeat.o(106916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMViewPager.i
 * JD-Core Version:    0.7.0.1
 */