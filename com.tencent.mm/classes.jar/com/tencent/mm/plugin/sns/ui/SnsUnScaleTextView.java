package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SnsUnScaleTextView
  extends TextView
{
  public SnsUnScaleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SnsUnScaleTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public int getBaseline()
  {
    AppMethodBeat.i(39674);
    try
    {
      int i = super.getBaseline();
      AppMethodBeat.o(39674);
      return i;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(39674);
    }
    return -1;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(39673);
    try
    {
      super.onDraw(paramCanvas);
      AppMethodBeat.o(39673);
      return;
    }
    catch (Throwable paramCanvas)
    {
      AppMethodBeat.o(39673);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39672);
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(39672);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(39672);
    }
  }
  
  public boolean onPreDraw()
  {
    AppMethodBeat.i(39675);
    try
    {
      boolean bool = super.onPreDraw();
      AppMethodBeat.o(39675);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(39675);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUnScaleTextView
 * JD-Core Version:    0.7.0.1
 */