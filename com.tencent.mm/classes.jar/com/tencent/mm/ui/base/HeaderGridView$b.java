package com.tencent.mm.ui.base;

import android.content.Context;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class HeaderGridView$b
  extends FrameLayout
{
  public HeaderGridView$b(HeaderGridView paramHeaderGridView, Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141651);
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.OOo.getMeasuredWidth() - this.OOo.getPaddingLeft() - this.OOo.getPaddingRight(), 1073741824), paramInt2);
    AppMethodBeat.o(141651);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.HeaderGridView.b
 * JD-Core Version:    0.7.0.1
 */