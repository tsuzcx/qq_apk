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
    AppMethodBeat.i(99503);
    try
    {
      int i = super.getBaseline();
      AppMethodBeat.o(99503);
      return i;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(99503);
    }
    return -1;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(99502);
    try
    {
      super.onDraw(paramCanvas);
      AppMethodBeat.o(99502);
      return;
    }
    catch (Throwable paramCanvas)
    {
      AppMethodBeat.o(99502);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(99501);
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(99501);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(99501);
    }
  }
  
  public boolean onPreDraw()
  {
    AppMethodBeat.i(99504);
    try
    {
      boolean bool = super.onPreDraw();
      AppMethodBeat.o(99504);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(99504);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUnScaleTextView
 * JD-Core Version:    0.7.0.1
 */