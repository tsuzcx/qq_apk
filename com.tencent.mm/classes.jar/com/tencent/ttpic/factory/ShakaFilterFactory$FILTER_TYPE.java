package com.tencent.ttpic.factory;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ShakaFilterFactory$FILTER_TYPE
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(81922);
    TRIPLE_FADE_TRANSFORM = new FILTER_TYPE("TRIPLE_FADE_TRANSFORM", 0, 1);
    OFFSET_ALPHA_BLEND = new FILTER_TYPE("OFFSET_ALPHA_BLEND", 1, 2);
    NINE_TILE = new FILTER_TYPE("NINE_TILE", 2, 3);
    FLIP = new FILTER_TYPE("FLIP", 3, 4);
    UP_DOWN = new FILTER_TYPE("UP_DOWN", 4, 5);
    DISTORTION = new FILTER_TYPE("DISTORTION", 5, 6);
    $VALUES = new FILTER_TYPE[] { TRIPLE_FADE_TRANSFORM, OFFSET_ALPHA_BLEND, NINE_TILE, FLIP, UP_DOWN, DISTORTION };
    AppMethodBeat.o(81922);
  }
  
  private ShakaFilterFactory$FILTER_TYPE(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.factory.ShakaFilterFactory.FILTER_TYPE
 * JD-Core Version:    0.7.0.1
 */