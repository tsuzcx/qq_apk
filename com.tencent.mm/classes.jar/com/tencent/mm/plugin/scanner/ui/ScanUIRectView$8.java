package com.tencent.mm.plugin.scanner.ui;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.model.am;
import com.tencent.mm.plugin.scanner.ui.widget.b;
import com.tencent.mm.sdk.platformtools.Log;

final class ScanUIRectView$8
  implements View.OnTouchListener
{
  private float Pcp;
  private float Pcq = 400.0F;
  private boolean Pcr = false;
  
  ScanUIRectView$8(ScanUIRectView paramScanUIRectView) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(314548);
    int i = paramMotionEvent.getActionMasked();
    int j = paramMotionEvent.getActionIndex();
    Log.d("MicroMsg.ScanUIRectView", "pointIndex:%d, action: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
    switch (i)
    {
    }
    for (;;)
    {
      paramView = ScanUIRectView.R(this.Pcg);
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b(paramView, locala.aYi(), "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$17", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)locala.sb(0)), "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$17", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      if (paramMotionEvent.getAction() == 1) {
        ScanUIRectView.c(this.Pcg, false);
      }
      AppMethodBeat.o(314548);
      return true;
      Log.d("MicroMsg.ScanUIRectView", "first down,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(j), Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY()) });
      ScanUIRectView.a(this.Pcg, paramMotionEvent.getRawX());
      ScanUIRectView.b(this.Pcg, true);
      this.Pcr = false;
      continue;
      Log.d("MicroMsg.ScanUIRectView", "down,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(j), Float.valueOf(paramMotionEvent.getX(j)), Float.valueOf(paramMotionEvent.getY(j)) });
      if (paramMotionEvent.getPointerCount() == 2)
      {
        this.Pcp = ((float)(Math.pow(paramMotionEvent.getX(0) - paramMotionEvent.getX(1), 2.0D) + Math.pow(paramMotionEvent.getY(0) - paramMotionEvent.getY(1), 2.0D)));
        ScanUIRectView.c(this.Pcg, true);
      }
      this.Pcr = false;
      continue;
      Log.d("MicroMsg.ScanUIRectView", "last up,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(j), Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY()) });
      if (paramMotionEvent.getPointerCount() == 2)
      {
        this.Pcp = ((float)(Math.pow(paramMotionEvent.getX(0) - paramMotionEvent.getX(1), 2.0D) + Math.pow(paramMotionEvent.getY(0) - paramMotionEvent.getY(1), 2.0D)));
        continue;
        Log.d("MicroMsg.ScanUIRectView", "up,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(j), Float.valueOf(paramMotionEvent.getX(j)), Float.valueOf(paramMotionEvent.getY(j)) });
        if (paramMotionEvent.getPointerCount() == 2)
        {
          this.Pcp = ((float)(Math.pow(paramMotionEvent.getX(0) - paramMotionEvent.getX(1), 2.0D) + Math.pow(paramMotionEvent.getY(0) - paramMotionEvent.getY(1), 2.0D)));
          if (this.Pcr)
          {
            this.Pcr = false;
            am.J(ScanUIRectView.H(this.Pcg), 4, ScanUIRectView.r(this.Pcg));
            continue;
            float f;
            if (paramMotionEvent.getPointerCount() == 2)
            {
              Log.d("MicroMsg.ScanUIRectView", "move,pointer:0,x:%f,y:%f", new Object[] { Float.valueOf(paramMotionEvent.getX(0)), Float.valueOf(paramMotionEvent.getY(0)) });
              Log.d("MicroMsg.ScanUIRectView", "move,pointer:1,x:%f,y:%f", new Object[] { Float.valueOf(paramMotionEvent.getX(1)), Float.valueOf(paramMotionEvent.getY(1)) });
              f = (float)(Math.pow(paramMotionEvent.getX(0) - paramMotionEvent.getX(1), 2.0D) + Math.pow(paramMotionEvent.getY(0) - paramMotionEvent.getY(1), 2.0D));
              Log.d("MicroMsg.ScanUIRectView", "distance:%f,lastDistance:%f,min move:%f", new Object[] { Float.valueOf(f), Float.valueOf(this.Pcp), Float.valueOf(this.Pcq) });
              if (Math.abs(f - this.Pcp) > this.Pcq)
              {
                if (ScanUIRectView.n(this.Pcg)) {
                  ScanUIRectView.M(this.Pcg);
                }
                if (f - this.Pcp > 0.0F) {
                  ((com.tencent.scanlib.a.a)ScanUIRectView.N(this.Pcg)).aHd(2);
                }
                for (this.Pcr = true;; this.Pcr = true)
                {
                  this.Pcp = f;
                  break;
                  ((com.tencent.scanlib.a.a)ScanUIRectView.O(this.Pcg)).aHd(3);
                }
              }
            }
            else if ((paramMotionEvent.getPointerCount() == 1) && (ScanUIRectView.J(this.Pcg)) && (!ScanUIRectView.K(this.Pcg)))
            {
              f = paramMotionEvent.getRawX() - ScanUIRectView.P(this.Pcg);
              Log.v("MicroMsg.ScanUIRectView", "alvinluo onTouchEvent offsetX: %f, canScrollSwitchTab: %b", new Object[] { Float.valueOf(f), Boolean.valueOf(ScanUIRectView.I(this.Pcg)) });
              if ((f >= ScanUIRectView.Q(this.Pcg)) && (ScanUIRectView.I(this.Pcg)))
              {
                if (ScanUIRectView.L(this.Pcg) != null) {
                  ScanUIRectView.L(this.Pcg).gTy();
                }
                ScanUIRectView.b(this.Pcg, false);
              }
              else if ((f <= -ScanUIRectView.Q(this.Pcg)) && (ScanUIRectView.I(this.Pcg)))
              {
                if (ScanUIRectView.L(this.Pcg) != null) {
                  ScanUIRectView.L(this.Pcg).gTx();
                }
                ScanUIRectView.b(this.Pcg, false);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanUIRectView.8
 * JD-Core Version:    0.7.0.1
 */