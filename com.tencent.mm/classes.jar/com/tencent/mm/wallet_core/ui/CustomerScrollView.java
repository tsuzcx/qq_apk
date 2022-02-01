package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CustomerScrollView
  extends ScrollView
{
  private float LWi;
  private float LWj;
  private float LWk;
  private float LWl;
  
  public CustomerScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CustomerScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(72898);
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      for (;;)
      {
        boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
        AppMethodBeat.o(72898);
        return bool;
        this.LWj = 0.0F;
        this.LWi = 0.0F;
        this.LWk = paramMotionEvent.getX();
        this.LWl = paramMotionEvent.getY();
      }
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.LWi += Math.abs(f1 - this.LWk);
      this.LWj += Math.abs(f2 - this.LWl);
      this.LWk = f1;
      this.LWl = f2;
    } while (this.LWi <= this.LWj);
    AppMethodBeat.o(72898);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.CustomerScrollView
 * JD-Core Version:    0.7.0.1
 */