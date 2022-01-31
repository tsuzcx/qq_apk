package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CustomerScrollView
  extends ScrollView
{
  private float AYa;
  private float AYb;
  private float AYc;
  private float AYd;
  
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
    AppMethodBeat.i(49180);
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      for (;;)
      {
        boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
        AppMethodBeat.o(49180);
        return bool;
        this.AYb = 0.0F;
        this.AYa = 0.0F;
        this.AYc = paramMotionEvent.getX();
        this.AYd = paramMotionEvent.getY();
      }
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.AYa += Math.abs(f1 - this.AYc);
      this.AYb += Math.abs(f2 - this.AYd);
      this.AYc = f1;
      this.AYd = f2;
    } while (this.AYa <= this.AYb);
    AppMethodBeat.o(49180);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.CustomerScrollView
 * JD-Core Version:    0.7.0.1
 */