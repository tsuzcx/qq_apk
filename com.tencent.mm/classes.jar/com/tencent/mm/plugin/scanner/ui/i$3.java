package com.tencent.mm.plugin.scanner.ui;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.y;

final class i$3
  implements View.OnTouchListener
{
  private float nLG;
  private float nLH = 400.0F;
  
  i$3(i parami) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    int j = paramMotionEvent.getActionIndex();
    y.d("MicroMsg.scanner.ScanMode", "pointIndex:%d", new Object[] { Integer.valueOf(j) });
    switch (i)
    {
    }
    float f;
    do
    {
      do
      {
        for (;;)
        {
          this.nLF.jEK.onTouchEvent(paramMotionEvent);
          return true;
          y.d("MicroMsg.scanner.ScanMode", "first down,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(j), Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY()) });
          continue;
          y.d("MicroMsg.scanner.ScanMode", "down,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(j), Float.valueOf(paramMotionEvent.getX(j)), Float.valueOf(paramMotionEvent.getY(j)) });
          if (paramMotionEvent.getPointerCount() == 2)
          {
            this.nLG = ((float)(Math.pow(paramMotionEvent.getX(0) - paramMotionEvent.getX(1), 2.0D) + Math.pow(paramMotionEvent.getY(0) - paramMotionEvent.getY(1), 2.0D)));
            continue;
            y.d("MicroMsg.scanner.ScanMode", "last up,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(j), Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY()) });
            if (paramMotionEvent.getPointerCount() == 2)
            {
              this.nLG = ((float)(Math.pow(paramMotionEvent.getX(0) - paramMotionEvent.getX(1), 2.0D) + Math.pow(paramMotionEvent.getY(0) - paramMotionEvent.getY(1), 2.0D)));
              continue;
              y.d("MicroMsg.scanner.ScanMode", "up,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(j), Float.valueOf(paramMotionEvent.getX(j)), Float.valueOf(paramMotionEvent.getY(j)) });
              if (paramMotionEvent.getPointerCount() == 2) {
                this.nLG = ((float)(Math.pow(paramMotionEvent.getX(0) - paramMotionEvent.getX(1), 2.0D) + Math.pow(paramMotionEvent.getY(0) - paramMotionEvent.getY(1), 2.0D)));
              }
            }
          }
        }
      } while (paramMotionEvent.getPointerCount() != 2);
      y.d("MicroMsg.scanner.ScanMode", "move,pointer:0,x:%f,y:%f", new Object[] { Float.valueOf(paramMotionEvent.getX(0)), Float.valueOf(paramMotionEvent.getY(0)) });
      y.d("MicroMsg.scanner.ScanMode", "move,pointer:1,x:%f,y:%f", new Object[] { Float.valueOf(paramMotionEvent.getX(1)), Float.valueOf(paramMotionEvent.getY(1)) });
      f = (float)(Math.pow(paramMotionEvent.getX(0) - paramMotionEvent.getX(1), 2.0D) + Math.pow(paramMotionEvent.getY(0) - paramMotionEvent.getY(1), 2.0D));
      y.d("MicroMsg.scanner.ScanMode", "distance:%f,lastDistance:%f,min move:%f", new Object[] { Float.valueOf(f), Float.valueOf(this.nLG), Float.valueOf(this.nLH) });
    } while (Math.abs(f - this.nLG) <= this.nLH);
    if (this.nLF.nLD) {
      this.nLF.nLD = false;
    }
    if (f - this.nLG > 0.0F) {
      this.nLF.nLB.V(2, 2, 100);
    }
    for (;;)
    {
      this.nLG = f;
      break;
      this.nLF.nLB.V(3, 2, 100);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.i.3
 * JD-Core Version:    0.7.0.1
 */