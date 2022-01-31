package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.List;

final class e$5
  implements ViewTreeObserver.OnPreDrawListener
{
  e$5(e parame, DynamicGridView paramDynamicGridView, List paramList) {}
  
  public final boolean onPreDraw()
  {
    this.ppU.getViewTreeObserver().removeOnPreDrawListener(this);
    this.ppV.zb(this.ppX.size());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.e.5
 * JD-Core Version:    0.7.0.1
 */