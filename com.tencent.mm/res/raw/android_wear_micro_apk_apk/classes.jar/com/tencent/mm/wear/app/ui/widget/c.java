package com.tencent.mm.wear.app.ui.widget;

import android.graphics.Canvas;
import android.view.SurfaceHolder;
import com.tencent.mm.wear.a.c.d;

final class c
  extends Thread
{
  private boolean adQ;
  private SurfaceHolder ahY;
  private boolean ahZ;
  private long aia;
  private int aib;
  private int aic;
  
  public c(MMCustomSurfaceView paramMMCustomSurfaceView, SurfaceHolder paramSurfaceHolder)
  {
    this.ahY = paramSurfaceHolder;
  }
  
  public final void nC()
  {
    this.ahZ = false;
    this.adQ = true;
    interrupt();
  }
  
  public final void run()
  {
    for (;;)
    {
      if (!this.adQ)
      {
        long l1 = System.currentTimeMillis();
        if (this.ahZ) {}
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
                Canvas localCanvas = this.ahY.lockCanvas(null);
                try
                {
                  for (;;)
                  {
                    localObject3 = this.ahY;
                    if (localCanvas != null) {}
                    try
                    {
                      for (;;)
                      {
                        this.aid.a(localCanvas);
                        if (localCanvas != null) {
                          this.ahY.unlockCanvasAndPost(localCanvas);
                        }
                        if (this.aia == 0L) {
                          this.aia = System.currentTimeMillis();
                        }
                        long l2 = System.currentTimeMillis();
                        if (l2 - this.aia > 1000L) {
                          break label198;
                        }
                        this.aib += 1;
                        l1 = l2 - l1;
                        this.aic = ((int)(this.aic + l1));
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
            this.ahY.unlockCanvasAndPost((Canvas)localObject3);
            throw localObject1;
            d.e("MicroMsg.MMCustomSurfaceView", "fps: %d, avarageDrawTime: %d", new Object[] { Integer.valueOf(this.aib), Integer.valueOf(this.aic / this.aib) });
            this.aib = 0;
            this.aia = 0L;
            this.aic = 0;
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