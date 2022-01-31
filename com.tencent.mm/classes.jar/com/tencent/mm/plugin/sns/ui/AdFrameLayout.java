package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMFrameLayout;

public class AdFrameLayout
  extends MMFrameLayout
{
  public AdFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void addView(View paramView)
  {
    AppMethodBeat.i(38046);
    super.addView(paramView);
    AppMethodBeat.o(38046);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(38052);
    super.draw(paramCanvas);
    AppMethodBeat.o(38052);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(38049);
    super.onDetachedFromWindow();
    AppMethodBeat.o(38049);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(38050);
    System.currentTimeMillis();
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(38050);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(38051);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(38051);
  }
  
  public void removeView(View paramView)
  {
    AppMethodBeat.i(38047);
    super.removeView(paramView);
    AppMethodBeat.o(38047);
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(38048);
    super.requestLayout();
    AppMethodBeat.o(38048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.AdFrameLayout
 * JD-Core Version:    0.7.0.1
 */