package com.tencent.mm.ui.gridviewheaders;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public final class c$b
  extends FrameLayout
{
  private int vWA;
  private int vWz;
  
  public c$b(c paramc, Context paramContext)
  {
    super(paramContext);
  }
  
  protected final FrameLayout.LayoutParams generateDefaultLayoutParams()
  {
    return new FrameLayout.LayoutParams(-1, -1);
  }
  
  public final int getHeaderId()
  {
    return this.vWz;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    View localView = (View)getTag();
    if (localView.getLayoutParams() == null) {
      localView.setLayoutParams(generateDefaultLayoutParams());
    }
    if ((localView.getVisibility() != 8) && (localView.getMeasuredHeight() == 0)) {
      localView.measure(View.MeasureSpec.makeMeasureSpec(this.vWA, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
    }
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), localView.getMeasuredHeight());
  }
  
  public final void setHeaderId(int paramInt)
  {
    this.vWz = paramInt;
  }
  
  public final void setHeaderWidth(int paramInt)
  {
    this.vWA = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.gridviewheaders.c.b
 * JD-Core Version:    0.7.0.1
 */