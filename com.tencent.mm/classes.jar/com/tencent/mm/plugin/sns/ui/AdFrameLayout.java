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
    AppMethodBeat.i(97666);
    super.addView(paramView);
    AppMethodBeat.o(97666);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(97672);
    super.draw(paramCanvas);
    AppMethodBeat.o(97672);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(97669);
    super.onDetachedFromWindow();
    AppMethodBeat.o(97669);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97670);
    System.currentTimeMillis();
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(97670);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97671);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(97671);
  }
  
  public void removeView(View paramView)
  {
    AppMethodBeat.i(97667);
    super.removeView(paramView);
    AppMethodBeat.o(97667);
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(97668);
    super.requestLayout();
    AppMethodBeat.o(97668);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.AdFrameLayout
 * JD-Core Version:    0.7.0.1
 */