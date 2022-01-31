package com.tencent.mm.ui.gridviewheaders;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c$b
  extends FrameLayout
{
  private int AoH;
  private int AoI;
  
  public c$b(c paramc, Context paramContext)
  {
    super(paramContext);
  }
  
  protected final FrameLayout.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(107332);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    AppMethodBeat.o(107332);
    return localLayoutParams;
  }
  
  public final int getHeaderId()
  {
    return this.AoH;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107331);
    View localView = (View)getTag();
    if (localView.getLayoutParams() == null) {
      localView.setLayoutParams(generateDefaultLayoutParams());
    }
    if ((localView.getVisibility() != 8) && (localView.getMeasuredHeight() == 0)) {
      localView.measure(View.MeasureSpec.makeMeasureSpec(this.AoI, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
    }
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), localView.getMeasuredHeight());
    AppMethodBeat.o(107331);
  }
  
  public final void setHeaderId(int paramInt)
  {
    this.AoH = paramInt;
  }
  
  public final void setHeaderWidth(int paramInt)
  {
    this.AoI = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.gridviewheaders.c.b
 * JD-Core Version:    0.7.0.1
 */