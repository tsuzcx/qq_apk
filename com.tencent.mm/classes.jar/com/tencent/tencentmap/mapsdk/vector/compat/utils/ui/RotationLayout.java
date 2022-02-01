package com.tencent.tencentmap.mapsdk.vector.compat.utils.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class RotationLayout
  extends FrameLayout
{
  private int a;
  
  public RotationLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public RotationLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RotationLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(217704);
    if (this.a == 0)
    {
      super.dispatchDraw(paramCanvas);
      AppMethodBeat.o(217704);
      return;
    }
    if (this.a == 1)
    {
      paramCanvas.translate(getWidth(), 0.0F);
      paramCanvas.rotate(90.0F, getWidth() / 2, 0.0F);
      paramCanvas.translate(getHeight() / 2, getWidth() / 2);
    }
    for (;;)
    {
      super.dispatchDraw(paramCanvas);
      AppMethodBeat.o(217704);
      return;
      if (this.a == 2)
      {
        paramCanvas.rotate(180.0F, getWidth() / 2, getHeight() / 2);
      }
      else
      {
        paramCanvas.translate(0.0F, getHeight());
        paramCanvas.rotate(270.0F, getWidth() / 2, 0.0F);
        paramCanvas.translate(getHeight() / 2, -getWidth() / 2);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(217693);
    if ((this.a == 1) || (this.a == 3))
    {
      super.onMeasure(paramInt1, paramInt2);
      setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
      AppMethodBeat.o(217693);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(217693);
  }
  
  public void setViewRotation(int paramInt)
  {
    this.a = ((paramInt + 360) % 360 / 90);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.vector.compat.utils.ui.RotationLayout
 * JD-Core Version:    0.7.0.1
 */