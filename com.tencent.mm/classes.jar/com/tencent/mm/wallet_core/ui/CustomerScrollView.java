package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CustomerScrollView
  extends ScrollView
{
  private float IeN;
  private float IeO;
  private float IeP;
  private float IeQ;
  
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
        this.IeO = 0.0F;
        this.IeN = 0.0F;
        this.IeP = paramMotionEvent.getX();
        this.IeQ = paramMotionEvent.getY();
      }
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.IeN += Math.abs(f1 - this.IeP);
      this.IeO += Math.abs(f2 - this.IeQ);
      this.IeP = f1;
      this.IeQ = f2;
    } while (this.IeN <= this.IeO);
    AppMethodBeat.o(72898);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.CustomerScrollView
 * JD-Core Version:    0.7.0.1
 */