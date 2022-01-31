package com.tencent.ttpic.factory;

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
    if (paramInt == ShakaFilterFactory.FILTER_TYPE.TRIPLE_FADE_TRANSFORM.value) {
      return new ShakaTripleFadeTransformFilter();
    }
    if (paramInt == ShakaFilterFactory.FILTER_TYPE.OFFSET_ALPHA_BLEND.value) {
      return new ShakaOffsetAlphaBlendFilter();
    }
    if (paramInt == ShakaFilterFactory.FILTER_TYPE.NINE_TILE.value) {
      return new ShakaNineTileFilter();
    }
    if (paramInt == ShakaFilterFactory.FILTER_TYPE.FLIP.value) {
      return new ShakaFlipFilter();
    }
    if (paramInt == ShakaFilterFactory.FILTER_TYPE.UP_DOWN.value) {
      return new ShakaUpDownFilter();
    }
    if (paramInt == ShakaFilterFactory.FILTER_TYPE.DISTORTION.value) {
      return new HorizontalSkewFilter();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.factory.ShakaFilterFactory
 * JD-Core Version:    0.7.0.1
 */