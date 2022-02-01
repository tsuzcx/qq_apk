package com.tencent.mm.wear.app.ui.widget;

import android.graphics.Canvas;
import android.view.SurfaceHolder;
import com.tencent.mm.wear.a.c.d;

final class c
  extends Thread
{
  private boolean ahs;
  private SurfaceHolder alA;
  private boolean alB;
  private long alC;
  private int alD;
  private int alE;
  
  public c(MMCustomSurfaceView paramMMCustomSurfaceView, SurfaceHolder paramSurfaceHolder)
  {
    this.alA = paramSurfaceHolder;
  }
  
  public final void oq()
  {
    this.alB = false;
    this.ahs = true;
    interrupt();
  }
  
  public final void run()
  {
    for (;;)
    {
      if (!this.ahs)
      {
        long l1 = System.currentTimeMillis();
        if (this.alB) {}
        try
        {
          Thread.sleep(2147483647L);
          for (;;)
          {
            try
            {
              for (;;)
              {
                label24:
                Canvas localCanvas = this.alA.lockCanvas(null);
                try
                {
                  for (;;)
                  {
                    localObject3 = this.alA;
                    if (localCanvas != null) {}
                    try
                    {
                      for (;;)
                      {
                        this.alF.a(localCanvas);
                        if (localCanvas != null) {
                          this.alA.unlockCanvasAndPost(localCanvas);
                        }
                        if (this.alC == 0L) {
                          this.alC = System.currentTimeMillis();
                        }
                        long l2 = System.currentTimeMillis();
                        if (l2 - this.alC > 1000L) {
                          break label198;
                        }
                        this.alD += 1;
                        l1 = l2 - l1;
                        this.alE = ((int)(this.alE + l1));
                        l1 = 31L - l1;
                        if (l1 <= 0L) {
                          break;
                        }
                        try
                        {
                          Thread.sleep(l1);
                        }
                        catch (InterruptedException localInterruptedException1) {}
                      }
                      break;
                    }
                    finally {}
                  }
                  if (localObject3 == null) {
                    break label195;
                  }
                }
                finally
                {
                  localObject3 = localInterruptedException1;
                  localObject1 = localObject5;
                }
              }
            }
            finally
            {
              Object localObject1;
              label195:
              label198:
              Object localObject3 = null;
              continue;
            }
            this.alA.unlockCanvasAndPost((Canvas)localObject3);
            throw localObject1;
            d.d("MicroMsg.MMCustomSurfaceView", "fps: %d, avarageDrawTime: %d", new Object[] { Integer.valueOf(this.alD), Integer.valueOf(this.alE / this.alD) });
            this.alD = 0;
            this.alC = 0L;
            this.alE = 0;
          }
        }
        catch (InterruptedException localInterruptedException2)
        {
          break label24;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */