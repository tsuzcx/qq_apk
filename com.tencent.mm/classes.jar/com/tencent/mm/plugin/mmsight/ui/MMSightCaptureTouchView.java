package com.tencent.mm.plugin.mmsight.ui;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.wcdb.support.Log;

public class MMSightCaptureTouchView
  extends RelativeLayout
{
  private long fxo = -1L;
  private float fxp = -1.0F;
  private int fxq = 0;
  private MMSightCaptureTouchView.a mom;
  
  public MMSightCaptureTouchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MMSightCaptureTouchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private float s(MotionEvent paramMotionEvent)
  {
    try
    {
      if (this.fxq >= 2)
      {
        float f3 = paramMotionEvent.getX(0);
        float f1 = paramMotionEvent.getY(0);
        float f4 = paramMotionEvent.getX(1);
        float f2 = paramMotionEvent.getY(1);
        f3 = Math.abs(f3 - f4);
        f1 = Math.abs(f1 - f2);
        return f3 + f1;
      }
    }
    catch (Exception paramMotionEvent)
    {
      Log.e("MicroMsg.MMSightCaptureTouchView", "pointerDistance error: %s", new Object[] { paramMotionEvent.getMessage() });
    }
    return 0.0F;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    float f;
    do
    {
      do
      {
        do
        {
          return true;
          Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_DOWN");
          if ((this.fxo > 0L) && (SystemClock.elapsedRealtime() - this.fxo < 400L)) {
            if (this.mom != null) {
              this.mom.aKT();
            }
          }
          for (;;)
          {
            this.fxo = SystemClock.elapsedRealtime();
            this.fxp = -1.0F;
            this.fxq += 1;
            return true;
            if (this.mom != null) {
              this.mom.O(paramMotionEvent.getX(), paramMotionEvent.getY());
            }
          }
          Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_POINTER_DOWN");
          this.fxq += 1;
          return true;
          Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_POINTER_UP");
          this.fxq -= 1;
          return true;
          Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_UP");
          this.fxp = -1.0F;
          this.fxq = 0;
          return true;
        } while (this.fxq < 2);
        f = s(paramMotionEvent);
        Log.v("MicroMsg.MMSightCaptureTouchView", "distance: %s", new Object[] { Float.valueOf(f) });
      } while (f <= 0.0F);
      if (this.fxp <= 0.0F) {
        break;
      }
    } while (Math.abs(f - this.fxp) <= 15.0F);
    if (f > this.fxp)
    {
      Log.d("MicroMsg.MMSightCaptureTouchView", "zoom out");
      if (this.mom != null) {
        this.mom.Zh();
      }
    }
    for (;;)
    {
      this.fxp = f;
      return true;
      Log.d("MicroMsg.MMSightCaptureTouchView", "zoom in");
      if (this.mom != null) {
        this.mom.Zi();
      }
    }
  }
  
  public void setTouchCallback(MMSightCaptureTouchView.a parama)
  {
    this.mom = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView
 * JD-Core Version:    0.7.0.1
 */