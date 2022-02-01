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
    AppMethodBeat.i(141488);
    try
    {
      int i = super.getBaseline();
      AppMethodBeat.o(141488);
      return i;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(141488);
    }
    return -1;
  }
  
  public boolean isFocused()
  {
    return true;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(141487);
    try
    {
      super.onDraw(paramCanvas);
      AppMethodBeat.o(141487);
      return;
    }
    catch (Throwable paramCanvas)
    {
      AppMethodBeat.o(141487);
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(141484);
    if (paramBoolean) {
      super.onFocusChanged(paramBoolean, paramInt, paramRect);
    }
    AppMethodBeat.o(141484);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141486);
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(141486);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(141486);
    }
  }
  
  public boolean onPreDraw()
  {
    AppMethodBeat.i(141489);
    try
    {
      boolean bool = super.onPreDraw();
      AppMethodBeat.o(141489);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(141489);
    }
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(141485);
    if (paramBoolean) {
      super.onWindowFocusChanged(paramBoolean);
    }
    AppMethodBeat.o(141485);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.ScrollAlwaysTextView
 * JD-Core Version:    0.7.0.1
 */