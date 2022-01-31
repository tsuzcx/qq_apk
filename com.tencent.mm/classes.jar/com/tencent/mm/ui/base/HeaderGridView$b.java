package com.tencent.mm.ui.base;

import android.content.Context;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public final class HeaderGridView$b
  extends FrameLayout
{
  public HeaderGridView$b(HeaderGridView paramHeaderGridView, Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.uTa.getMeasuredWidth() - this.uTa.getPaddingLeft() - this.uTa.getPaddingRight(), 1073741824), paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.HeaderGridView.b
 * JD-Core Version:    0.7.0.1
 */