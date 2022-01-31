package com.tencent.ttpic.factory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.filter.HorizontalSkewFilter;
import com.tencent.ttpic.filter.ShakaFilterBase;
import com.tencent.ttpic.filter.ShakaFlipFilter;
import com.tencent.ttpic.filter.ShakaNineTileFilter;
import com.tencent.ttpic.filter.ShakaOffsetAlphaBlendFilter;
import com.tencent.ttpic.filter.ShakaTripleFadeTransformFilter;
import com.tencent.ttpic.filter.ShakaUpDownFilter;

public class ShakaFilterFactory
{
  public static ShakaFilterBase create(int paramInt)
  {
    AppMethodBeat.i(81923);
    Object localObject;
    if (paramInt == ShakaFilterFactory.FILTER_TYPE.TRIPLE_FADE_TRANSFORM.value)
    {
      localObject = new ShakaTripleFadeTransformFilter();
      AppMethodBeat.o(81923);
      return localObject;
    }
    if (paramInt == ShakaFilterFactory.FILTER_TYPE.OFFSET_ALPHA_BLEND.value)
    {
      localObject = new ShakaOffsetAlphaBlendFilter();
      AppMethodBeat.o(81923);
      return localObject;
    }
    if (paramInt == ShakaFilterFactory.FILTER_TYPE.NINE_TILE.value)
    {
      localObject = new ShakaNineTileFilter();
      AppMethodBeat.o(81923);
      return localObject;
    }
    if (paramInt == ShakaFilterFactory.FILTER_TYPE.FLIP.value)
    {
      localObject = new ShakaFlipFilter();
      AppMethodBeat.o(81923);
      return localObject;
    }
    if (paramInt == ShakaFilterFactory.FILTER_TYPE.UP_DOWN.value)
    {
      localObject = new ShakaUpDownFilter();
      AppMethodBeat.o(81923);
      return localObject;
    }
    if (paramInt == ShakaFilterFactory.FILTER_TYPE.DISTORTION.value)
    {
      localObject = new HorizontalSkewFilter();
      AppMethodBeat.o(81923);
      return localObject;
    }
    AppMethodBeat.o(81923);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.factory.ShakaFilterFactory
 * JD-Core Version:    0.7.0.1
 */