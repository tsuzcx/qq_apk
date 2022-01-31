package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

final class DynamicGridView$4
  implements TypeEvaluator<Rect>
{
  DynamicGridView$4(DynamicGridView paramDynamicGridView) {}
  
  private static int e(int paramInt1, int paramInt2, float paramFloat)
  {
    return (int)(paramInt1 + (paramInt2 - paramInt1) * paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.4
 * JD-Core Version:    0.7.0.1
 */