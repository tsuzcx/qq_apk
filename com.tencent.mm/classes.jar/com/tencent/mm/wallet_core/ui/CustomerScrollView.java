package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CustomerScrollView
  extends ScrollView
{
  private float JGp;
  private float JGq;
  private float JGr;
  private float JGs;
  
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
        this.JGq = 0.0F;
        this.JGp = 0.0F;
        this.JGr = paramMotionEvent.getX();
        this.JGs = paramMotionEvent.getY();
      }
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.JGp += Math.abs(f1 - this.JGr);
      this.JGq += Math.abs(f2 - this.JGs);
      this.JGr = f1;
      this.JGs = f2;
    } while (this.JGp <= this.JGq);
    AppMethodBeat.o(72898);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.CustomerScrollView
 * JD-Core Version:    0.7.0.1
 */