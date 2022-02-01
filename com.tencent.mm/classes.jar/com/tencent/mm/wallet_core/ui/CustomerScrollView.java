package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CustomerScrollView
  extends ScrollView
{
  private float RuY;
  private float RuZ;
  private float Rva;
  private float Rvb;
  
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
        this.RuZ = 0.0F;
        this.RuY = 0.0F;
        this.Rva = paramMotionEvent.getX();
        this.Rvb = paramMotionEvent.getY();
      }
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.RuY += Math.abs(f1 - this.Rva);
      this.RuZ += Math.abs(f2 - this.Rvb);
      this.Rva = f1;
      this.Rvb = f2;
    } while (this.RuY <= this.RuZ);
    AppMethodBeat.o(72898);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.CustomerScrollView
 * JD-Core Version:    0.7.0.1
 */