package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ScrollAlwaysTextView
  extends TextView
{
  public ScrollAlwaysTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842884);
  }
  
  public ScrollAlwaysTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public int getBaseline()
  {
    AppMethodBeat.i(106129);
    try
    {
      int i = super.getBaseline();
      AppMethodBeat.o(106129);
      return i;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(106129);
    }
    return -1;
  }
  
  public boolean isFocused()
  {
    return true;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(106128);
    try
    {
      super.onDraw(paramCanvas);
      AppMethodBeat.o(106128);
      return;
    }
    catch (Throwable paramCanvas)
    {
      AppMethodBeat.o(106128);
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(106125);
    if (paramBoolean) {
      super.onFocusChanged(paramBoolean, paramInt, paramRect);
    }
    AppMethodBeat.o(106125);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106127);
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(106127);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(106127);
    }
  }
  
  public boolean onPreDraw()
  {
    AppMethodBeat.i(106130);
    try
    {
      boolean bool = super.onPreDraw();
      AppMethodBeat.o(106130);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(106130);
    }
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(106126);
    if (paramBoolean) {
      super.onWindowFocusChanged(paramBoolean);
    }
    AppMethodBeat.o(106126);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.ScrollAlwaysTextView
 * JD-Core Version:    0.7.0.1
 */